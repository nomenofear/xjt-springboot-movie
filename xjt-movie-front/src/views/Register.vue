<template>
  <div class="register-view">
    <el-card class="register-card" shadow="always">
      <div slot="header" class="logo-title" style="display: flex;">
        <div class="logo-image"><img src="@/assets/logo-image.png" alt="" width="100px" height="90px"></div>
        <div style="font-size: 32px;font-weight: bold;height: 90px;line-height: 90px;margin-left: 20px">用户注册</div>
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
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="ruleForm.email"></el-input>
        </el-form-item>

        <el-form-item label="邮箱验证码">
          <el-row>
            <el-col :span="15">
              <el-input v-model="ruleForm.email_code"></el-input>
            </el-col>
            <el-col :span="8" :offset="1">
              <el-button type="success" :loading="isSendEmailing" @click="sendEmailCode">发送验证码</el-button>
            </el-col>
          </el-row>
        </el-form-item>

        <el-form-item>
          <el-button type="danger" @click="submitForm">立即注册</el-button>
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
    name: "Register",
    data() {
      return {
        isSendEmailing:false,   //是否正在发送邮件
        ruleForm: {
          username: 'admin',
          password: '123',
          email:"",
          email_code:""
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
          email: [
            {required: true, message: '请输入密码', trigger: 'blur',validator:this.emailValidate},
          ],
        }
      };
    },
    methods: {
      submitForm() {
        this.$refs.ruleForm.validate((valid) => {
          if (valid) {
            this.$postRequest("/user/toResigter", this.ruleForm).then(res => {
              if (res.status == 200) {
                //登录成功
                this.$message.success(res.msg);

                this.$router.push("/login");
              }
            })

          } else {
            this.$message.error(res.msg);
            return false;
          }
        });
      },

      sendEmailCode(){
        this.isSendEmailing = true;
        this.$getRequest("/user/sendMailCode?email=" + this.ruleForm.email).then(res => {
          if(res.status === 200){
            this.isSendEmailing = false;
            this.$notify.success(res.msg);
          }

        })
      },

      //邮箱验证规则
      emailValidate(rule, value, callback){
        //rule 对应使用emailValida自定义验证的 对象
        //value 对应使用emailValida自定义验证的 数值
        //callback 回调函数
        const regEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (regEmail.test(value)) {
          return callback();
        }
        callback(new Error("邮箱格式有误"));
      },
    }
  }
</script>

<style scoped>
  .register-view {
    background: no-repeat center url("~@/assets/images/common/login-bg.jpg");
    position: relative;
    width: 100vw;
    height: 100vh;
  }

  .register-card {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 550px;
    height: 480px;
    padding: 0 20px;
  }
</style>
