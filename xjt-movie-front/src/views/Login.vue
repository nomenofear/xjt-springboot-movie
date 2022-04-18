<template>
  <div class="login-view">
    <el-card class="login-card" shadow="always">
      <div slot="header" class="logo-title" style="display: flex;">
        <div class="logo-image"><img src="@/assets/logo-image.png" alt="" width="100px" height="90px"></div>
        <div style="font-size: 32px;font-weight: bold;height: 90px;line-height: 90px;margin-left: 20px">用户登录</div>
      </div>
      <el-form :model="ruleForm" :rules="rules"
               ref="ruleForm"
               label-width="100px"
               class="demo-ruleForm"
               label-position="left">

        <el-form-item label="用户名" prop="username">
          <el-input v-model="ruleForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="ruleForm.password"></el-input>
        </el-form-item>

        <el-form-item label="验证码" prop="verify_code">
          <el-col :span="14">
            <el-input v-model="ruleForm.verify_code" id="input-captcha"></el-input>
          </el-col>

          <el-col :span="8" :offset="2">
            <img src="/api/user/getCaptcha" alt="" ref="captchaImg" @click="changeCaptcha"
                 style="width: 100%;height: 40px;border: 1px solid #ddd;">
          </el-col>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitLoginForm">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>

    <!--引入粒子特效-->
    <vue-particles
      color="#fff"
      :particleOpacity="0.5"
      :particlesNumber="100"
      shapeType="circle"
      :particleSize="4"
      linesColor="#fff"
      :linesWidth="1"
      :lineLinked="true"
      :lineOpacity="0.4"
      :linesDistance="150"
      :moveSpeed="2"
      :hoverEffect="true"
      hoverMode="grab"
      :clickEffect="true"
      clickMode="push"
      class="lizi">
    </vue-particles>
  </div>
</template>

<script>
  export default {
    name: "Login",
    data() {
      return {
        ruleForm: {
          username: 'admin',
          password: '123',
          verify_code: '',
        },
        rules: {
          username: [
            {required: true, message: '请输入用户名', trigger: 'blur'},
            {min: 1, max: 26, message: '长度在 1 到 26 个字符', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'},
            {min: 1, max: 18, message: '长度在 1 到 18 个字符', trigger: 'blur'}
          ],
          verify_code: [
            {required: true, message: '请输入验证码', trigger: 'blur'},
          ],
        }
      };
    },
    methods: {
      submitLoginForm() {
        this.$refs.ruleForm.validate((valid) => {
          if (valid) {
            this.$postRequest("/user/toLogin", this.ruleForm).then(res => {
              console.log(res);
              if (res.status === 200) {
                //将对象存入store
                this.$store.commit("updateLoginUser", res.obj);

                //登录成功
                this.$message.success("登录成功");

                //debug:window.location.href跳转会导致你的页面刷新，从而丢失Vuex的数据
                // window.location.href = "/home"
                this.$router.replace("/index")
              }
            })
          } else {
            this.$message.error("请检查输入的格式是否正确！");
            return false;
          }
        });
      },
      changeCaptcha() {
        this.$refs.captchaImg.setAttribute("src", "/api/user/getCaptcha?time=" + new Date().getTime());
      },
    }
  }
</script>

<style scoped>
  .login-view {
    background: no-repeat center url("~@/assets/images/common/login-bg.jpg");
    position: relative;
    width: 100vw;
    height: 100vh;
  }

  .login-card {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 550px;
    height: 450px;
    padding: 0 20px;
  }

</style>
