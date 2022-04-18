package com.xjt.movie.controller;

import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import com.wf.captcha.utils.CaptchaUtil;
import com.xjt.movie.entity.TUser;
import com.xjt.movie.service.TUserService;
import com.xjt.movie.utils.MyMailUtil;
import com.xjt.movie.utils.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/user")
public class TUserController {
    @Autowired
    private TUserService tUserService;

    /*登录*/
    @PostMapping("/toLogin")
    private RespBean userLogin(@RequestBody HashMap<String, String> params, HttpSession session){
        String username = params.get("username");
        String password = params.get("password");
        String verify_code = params.get("verify_code");
        log.warn("username===>"+username);
        log.warn("password===>"+password);
        log.warn("verify_code===>"+verify_code);

        String easyCaptcha = session.getAttribute("verify_code").toString();
        if(StringUtils.hasText(verify_code) && easyCaptcha.equalsIgnoreCase(verify_code.trim())){
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                subject.login(token);
                //登录成功后 把用户信息返回给前端
                TUser login_user = (TUser) session.getAttribute("login_user");
                return RespBean.success("ok",login_user);
            } catch (UnknownAccountException e) {
                e.printStackTrace();
                return RespBean.error("用户名错误!");
            } catch (IncorrectCredentialsException e) {
                e.printStackTrace();
                return RespBean.error("密码错误!");
            }catch (Exception e){
                e.printStackTrace();
                return RespBean.error(e.getMessage());
            }
        }else{
            return RespBean.error("验证码错误！");
        }
    }

    /*退出*/
    @GetMapping("toLogout")
    public RespBean logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//退出用户
        return RespBean.success("ok");
    }


    /*注册*/
    @PostMapping("/toResigter")
    public RespBean toResigter(@RequestBody HashMap<String, String> params,HttpSession session){
        System.out.println(params);

        String username = params.get("username");
        String password = params.get("password");
        String email = params.get("email");
        String email_code = params.get("email_code");

        String codes = (String) session.getAttribute("email_code");
        log.warn("session中保存的验证码："+codes);
        if (email_code.equalsIgnoreCase(codes)){
            log.warn("===>注册用户params：username={},password={},email={}",username,password,email);

            return tUserService.registerNewTUser(username,password,email);
        }else{
            return RespBean.error("验证码输入有误！");
        }
    }

    @GetMapping("/sendMailCode")
    @ResponseBody
    public RespBean sendMailCode(@RequestParam("email") String email,HttpSession session){
        String mailCode = MyMailUtil.sendMail(email);
        session.setAttribute("email_code",mailCode);
        session.setMaxInactiveInterval(60*3);     //设置3分钟有效
        log.warn("邮件发送成功 code={}",mailCode);
        return RespBean.success("邮件发送成功，请速去邮箱查看！");
    }

    /*根据id修改用户基本信息*/


    /*根据id上传用户头像*/

    /*查找所有用户*/
    @GetMapping("/getAll")
    public RespBean findAllUser(){
        return tUserService.findAllUser();
    }

    /*根据id查找用户*/
    @GetMapping("/getById")
    public RespBean findUserById(@RequestParam("uid") String uid){
        return tUserService.findUserById(uid);
    }

    /*根据username模糊查找用户*/
    @GetMapping("/getByUsername")
    public RespBean findUserByName(@RequestParam("username") String username){
        return tUserService.findUserByLikeName(username);
    }

    /*根据id删除用户*/
    @GetMapping("/delete")
    public RespBean deleteUserById(@RequestParam("uid") String uid){
        return tUserService.deleteUserById(uid);
    }


    /*验证码*/
    @RequestMapping("/getCaptcha")
    public void getCaptchaImg(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        SpecCaptcha specCaptcha = new SpecCaptcha();
        specCaptcha.setLen(4);
        specCaptcha.setHeight(48);
        specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);
        String text = specCaptcha.text();
        System.out.println("验证码===>"+text);
        session.setAttribute("verify_code",text);
        CaptchaUtil.out(specCaptcha,request,response);
    }
}
