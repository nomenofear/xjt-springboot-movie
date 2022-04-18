<template>
  <div class="xjt-home-view">
    <!--固定头-->
    <div class="home-header">
      <div class="header-inner">
        <div class="logo">
          <a href="//www.maoyan.com" class="logo" data-act="icon-click"></a>
        </div>

        <div class="nav">
          <el-menu :default-active="activeIndex" class="el-menu-demo"
                   mode="horizontal"
                   @select="handleNavSelect">
            <el-menu-item index="/">首页</el-menu-item>
            <el-menu-item index="/films">电影</el-menu-item>
            <el-menu-item index="/cinemas">影院</el-menu-item>
            <el-menu-item index="/board">榜单</el-menu-item>
            <el-menu-item index="/news">热点</el-menu-item>
          </el-menu>
        </div>

        <div class="search-form">
          <el-input placeholder="请输入内容" v-model="inputSearchWord" class="input-with-select">
            <el-button slot="append" icon="el-icon-search" @click="handleInputSearch"></el-button>
          </el-input>
        </div>

        <div class="user-info">
          <div class="login-register-btns" v-if="!$store.state.login_user">
            <el-button type="success" size="mini" @click="$router.push('/login')">登录</el-button>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <el-button type="danger" size="mini" @click="$router.push('/register')">注册</el-button>
          </div>

          <el-dropdown @command="handleCommand" v-else>
            <div class="el-dropdown-link">
              <el-image slot="reference"
                        style="width: 75px; height: 75px;border-radius: 50%;border: 1px solid #ddd;line-height: 60px;"
                        src=""
                        fit="fill">
              </el-image>
            </div>

            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="orders"><i class="el-icon-setting"></i>我的订单</el-dropdown-item>
              <el-dropdown-item command="info"><i class="el-icon-setting"></i>基本信息</el-dropdown-item>
              <el-dropdown-item command="logout"><i class="el-icon-setting"></i>退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </div>
    </div>

    <!--中间内容区-->
    <div class="home-main">
      <router-view/>
    </div>

    <!--底部-->
    <div class="home-footer">
      <div class="footer-inner">
        关于猫眼 : 关于我们 | 管理团队 | 投资者关系 友情链接 : 美团网 | 格瓦拉 | 美团下载 | 欢喜首映
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Home",
    data() {
      return {
        activeIndex: "/",
        inputSearchWord: "",
      }
    },
    methods: {
      handleCommand(command) {
        if (command === 'orders') {
          this.$message.success("进入我的订单界面...");
          //this.$router.push("/setting")

        } else if (command === 'info') {
          this.$message.success("进入基本信息界面...");

        } else if (command === 'logout') {
          this.$getRequest("/user/toLogout").then(res => {
            if (res.status === 200) {
              this.$message.info("注销!");
              this.$router.push("/login")
            }
          })

        }
      },
      handleNavSelect(key, keyPath) {
        console.log(key);
        this.activeIndex = key;
        this.$router.push(key);
      },
      handleInputSearch() {

      },
    }
  }
</script>

<style lang="less" scoped>
  .xjt-home-view {
    width: 100%;
    height: 100%;
    position: relative;

    .home-header {
      width: 100%;
      height: 80px;
      border-bottom: 1px solid #dddddd;

      .header-inner {
        width: 80%;
        margin: 0 auto;
        display: flex;

        .logo {
          width: 133px;
          height: 80px;
          background: url(data:image/png;base64,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) no-repeat 0;
          background-size: contain;
        }

        .nav {
          flex: 2;
          margin-left: 30px;

          .el-menu-item {
            height: 80px;
            line-height: 80px;
            font-size: 18px;
          }

          .el-menu-item.is-active {
            color: #fff;
            background-color: #ef4238;
            border-bottom: 0;
          }
        }

        .search-form {
          height: 80px;
          line-height: 80px;
          flex: 1;
          margin-left: 30px;
          position: relative;

        }

        .user-info {
          width: 180px;
          position: relative;
          margin-left: 30px;
          z-index: 9999;
          height: 80px;
          line-height: 80px;
          align-items: center;
        }
      }
    }

    .home-main {
      position: relative;
      width: 80%;
      min-height: 700px;
      border: 1px solid #ddd;
      margin: 0 auto;
    }

    .home-footer {
      background-color: #262426;
      padding: 20px 0;
      margin-top: 30px;

      .footer-inner {
        margin: 0 auto;
        text-align: center;
        width: 80%;
        color: white;
      }
    }
  }
</style>
