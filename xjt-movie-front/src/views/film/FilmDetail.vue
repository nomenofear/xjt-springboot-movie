<template>
  <div class="xjt-film-detail-view">
    <div class="banner">
      <div class="wrapper">
        <div class="left movie-poster">
          <el-image
            class=""
            style="width: 250px; height: 100%"
            :src="filmInfo.moviePicture"
            fit="fill"></el-image>
        </div>

        <div class="middle movie-brief-container">
          <div class="name">{{filmInfo.movieCnName}}</div>
          <p class="fg_name">又名：{{filmInfo.movieFgName}}</p>
          <p class="director">导演：{{filmInfo.movieDirector}}</p>
          <p class="actor">主演：{{filmInfo.movieActor}}</p>
          <p class="category">类型：{{filmInfo.movieCategory}}</p>
          <p class="country">制片国家/地区：{{filmInfo.movieCategory}}</p>
          <p class="duration">片长：{{filmInfo.movieDuration}}</p>
          <p class="publish-time">上映时间：{{filmInfo.movieReleasedate}}</p>
        </div>

        <div class="right">
          <div class="right-inner">
            <div class="action-buyBtn">
              <el-button type="default">
                <svg t="1641131081327" class="icon" viewBox="0 0 1024 1024" version="1.1"
                     xmlns="http://www.w3.org/2000/svg" p-id="2080" width="18" height="18">
                  <path
                    d="M171.712 571.648l0.352 0.32 287.904 252.8a64 64 0 0 0 82.912 1.344l296.832-244.544a215.584 215.584 0 1 0-301.824-300.576L512 316.672l-25.888-35.616a215.584 215.584 0 1 0-314.4 290.624zM32 407.584a279.584 279.584 0 0 1 480-194.944 279.584 279.584 0 0 1 480 194.944 278.144 278.144 0 0 1-113.024 224.512l-295.36 243.392a128 128 0 0 1-165.888-2.592L129.984 620.16A278.976 278.976 0 0 1 32 407.584z"
                    p-id="2081"></path>
                </svg>
                收藏
              </el-button>

              <el-button type="danger">
                <svg t="1641131204109" class="icon" viewBox="0 0 1024 1024" version="1.1"
                     xmlns="http://www.w3.org/2000/svg" p-id="2899" width="18" height="18">
                  <path
                    d="M821.333333 138.666667c64.8 0 117.333333 52.533333 117.333334 117.333333v149.333333a32 32 0 0 1-32 32 74.666667 74.666667 0 0 0 0 149.333334 32 32 0 0 1 32 32v149.333333c0 64.8-52.533333 117.333333-117.333334 117.333333H202.666667c-64.8 0-117.333333-52.533333-117.333334-117.333333V618.666667a32 32 0 0 1 32-32 74.666667 74.666667 0 0 0 0-149.333334 32 32 0 0 1-32-32V256c0-64.8 52.533333-117.333333 117.333334-117.333333h618.666666z m0 64H202.666667a53.333333 53.333333 0 0 0-53.333334 53.333333v121.045333C210.485333 391.488 256 446.432 256 512c0 65.568-45.514667 120.512-106.666667 134.954667V768a53.333333 53.333333 0 0 0 53.333334 53.333333h618.666666a53.333333 53.333333 0 0 0 53.333334-53.333333V646.954667C813.514667 632.512 768 577.568 768 512c0-65.568 45.514667-120.512 106.666667-134.954667V256a53.333333 53.333333 0 0 0-53.333334-53.333333zM384.853333 327.413333a32 32 0 0 1 45.066667 4.096L512 430.016l82.08-98.506667a32 32 0 1 1 49.173333 40.981334L571.413333 458.666667H618.666667a32 32 0 0 1 31.946666 30.122666L650.666667 490.666667a32 32 0 0 1-32 32h-69.333334v42.666666H618.666667a32 32 0 0 1 31.946666 30.122667L650.666667 597.333333a32 32 0 0 1-32 32h-69.333334v42.666667a32 32 0 0 1-30.122666 31.946667L517.333333 704a32 32 0 0 1-32-32v-42.666667H405.333333a32 32 0 0 1-31.946666-30.122666L373.333333 597.333333a32 32 0 0 1 32-32h80v-42.666666H405.333333a32 32 0 0 1-31.946666-30.122667L373.333333 490.666667a32 32 0 0 1 32-32h47.232l-71.818666-86.186667a32 32 0 0 1 2.581333-43.722667z"
                    p-id="2900" fill="#ffffff"></path>
                </svg>
                特惠购票
              </el-button>
            </div>

            <div class="movie-stats-container">
              <my-rate :score="parseFloat(filmInfo.movieScore)"
                       :star-num="10"
                       :disabled="true" showText/>
              <br>
              <br>

              <el-tag type="warning" class="status">{{filmInfo.movieShowType == 1?"上映中":"已下架"}}</el-tag>
            </div>
          </div>


        </div>


      </div>
    </div>

    <div class="main-container">
      <nav-bar class="navBar">
        <div slot="left">剧情简介</div>
      </nav-bar>
      <p class="movie-introduce">
        {{filmInfo.movieDetail}}
      </p>

      <nav-bar class="navBar">
        <div slot="left">观众评价</div>
      </nav-bar>
      <div class="comments-section">
        <div class="all-comments-container" style="border-left: 2px solid skyblue;padding-left: 10px;">
          <div v-for="(item1,index1) in allComments" :key="index1">
            <!--父评论-->
            <div class="my-marginTop20">
              <el-row :gutter="15" type="flex">
                <el-col style="width: 120px;">
                  <div>
                    <el-image
                      class="my-border"
                      style="width: 90px; height: 90px;border-radius: 50%;"
                      :src="item1.avatar | filterImgUrl(that)">
                    </el-image>
                  </div>
                </el-col>
                <el-col :span="20">
                  <div style=" width: 100%;">
                    <p style="font-size: 16px;line-height: 30px;font-weight:bold;">{{item1.username}}</p>
                    <p style="font-size: 13px;line-height: 30px;color: lightskyblue;">{{item1.content}}</p>
                    <div style="font-size: 10px;font-weight: lighter;">
                      <span style="line-height: 30px;"> {{item1.create_time|filterFormatDateTime(that)}}</span>
                      <span style="margin-left: 10px;line-height: 30px;" @click="handelReplyBtn(item1)">
														<el-link style="font-size: 5px;" :underline="false">回复</el-link>
													</span>
                    </div>
                  </div>
                </el-col>
              </el-row>
            </div>

            <!--子评论-->
            <div class="second-comments">
              <div v-for="(item2,index2) in item1.replyComments" :key=index2
                   style="margin-top: 16px;margin-left: 120px;">
                <el-row :gutter="15" type="flex">
                  <el-col style="width: 100px">
                    <div style="padding-left: 10px;">
                      <el-image
                        style="width: 80px; height: 80px;border-radius: 50%;border: 1px solid #ddd;"
                        :src="item2.avatar | filterImgUrl(that)">
                      </el-image>
                    </div>
                  </el-col>
                  <el-col :span="20" style="background-color: #eee;margin-left: 10px;padding: 5px;">
                    <div style=" width: 100%;">
                      <span style="font-size: 16px;line-height: 26px;font-weight:bold;">{{item2.username}}</span>
                      <span
                        style="font-size: 14px;line-height: 26px;font-weight: normal;color: #007eff;margin-left: 10px;">@{{item2.parent_comment_nickname}}</span>
                      <p style="font-size: 12px;line-height: 26px;">{{item2.content}}</p>
                    </div>
                    <div>
                      <span style="font-size: 10px;font-weight: normal;line-height: 26px;">  {{item2.create_time|filterFormatDateTime(that)}}</span>
                      <span style="font-size: 13px;line-height: 26px;margin-left: 10px;"
                            @click="handelReplyBtn(item2)">
														<el-link style="font-size: 5px;line-height: 26px;">回复</el-link>
													</span>
                    </div>
                  </el-col>
                </el-row>
              </div>
            </div>
          </div>
        </div>
      </div>

      <nav-bar class="navBar">
        <div slot="left">留下评价</div>
      </nav-bar>
      <div class="comment-container">

        <div class="editor-html" id="wangeditor" v-html="editorContent">

        </div>

        <div class="postComment">
          <el-button type="success" @click="postCommentHandle">提交评价</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import MyRate from "@/components/my-rate/MyRate"
  import NavBar from "@/components/nav-bar/NavBar"

  import WEditor from 'wangeditor'

  export default {
    name: "FilmDetail",
    components: {
      MyRate,
      NavBar,
    },
    data() {
      return {
        filmInfo: {},
        filmCommentList: [],

        commentsNum: 10,

        weditor:null,
        editorContent:"",

        allComments: [],
        currentReplyParentId: "",		//对当前评论id 进行回复
      }
    },
    methods: {
      //初始化wangEditor编辑器
      initWangEditor() {
        const editor = new WEditor("#wangeditor");
        // 设置编辑区域高度为 300px
        editor.config.height = 300
        //编辑器 z-index 默认为 10000，可以自行调整
        editor.config.zIndex = 100
        //占位文字
        editor.config.placeholder = '请输入你的留言'
        // 配置菜单栏，设置不需要的菜单
        editor.config.excludeMenus = [
          'image',
          'video'
        ]
        //配置颜色（文字颜色、背景色）
        editor.config.colors = [
          '#000000',
          '#eeece0',
          '#1c487f',
          '#4d80bf',
          '#ff0000',
          '#00ff00',
          '#0000ff',
          '#ffffff',
        ]

        editor.create();
        this.weditor = editor;
      },

      //电影的所有评论
      initFilmAllComments(){
        this.$getRequest("/comment/getAllByMoiveId?movie_id=" + this.filmInfo.movieId).then(res => {
          console.log(res);
          if (res.status === 200) {
            this.allComments.push(...res.obj);
          }
        })
      },

      initFilmData() {
        this.$getRequest("/movie/getById?id=" + this.filmInfo.movieId).then(res => {
          console.log(res);
          if (res.status === 200) {
            this.filmInfo = res.obj;
          }
        })
      },

      postCommentHandle(){
        let content = this.weditor.txt.html()
        console.log(content);
      },

      handelReplyBtn(item) {
        // let login_user = this.$store.state.login_user;
        // if (Object.keys(login_user).length > 0) {
        //   this.inputCommentDialogVisible = true;
        //   //当前评论id
        //   if (item === '-1') {
        //     //对博客评论
        //     this.currentReplyParentId = "-1";
        //   } else {
        //     //回复
        //     this.currentReplyParentId = item.id;
        //   }
        // } else {
        //   this.$message.warning("尚未登录，请先去登录！");
        //   this.$router.push("/toLogin");
        // }
      },
    },
    created() {
      console.log(this.$route.params.id);
      this.filmInfo.movieId = this.$route.params.id;

      this.$nextTick(() =>{
        this.initWangEditor();
      })

      this.initFilmData();

      this.initFilmAllComments();
    }
  }
</script>

<style lang="less" scoped>
  .xjt-film-detail-view {
    width: 100%;
    height: 100%;

    .banner {
      width: 100%;
      height: 340px;
      background: #392f59 url("~@/assets/images/common/banner_bg.png") no-repeat no-repeat;

      .wrapper {
        width: 100%;
        margin: 0 auto;
        height: 376px;
        position: relative;
        display: flex;

        .left {
          width: 250px;
          margin-left: 20px;
          margin-top: 20px;
          border: 4px solid #fff;
        }

        .middle {
          flex: 1;
          padding: 0 20px;
          color: white;

          .name {
            line-height: 60px;
            font-size: 32px;
            font-weight: bold;
          }

          .actor {
            line-height: 20px;
          }
        }

        .right {
          width: 400px;
          height: 320px;
          border-left: 1px solid #eeeeee;
          color: white;

          .right-inner {
            margin-top: 60px;
            margin-left: 20px;

            .movie-stats-container {
              margin-top: 20px;
            }
          }
        }
      }
    }

    .main-container {
      margin-top: 60px;

      .navBar {
        border-left: 4px solid #ef4238;
        padding-left: 10px;
        font-size: 24px;
        font-weight: bold;
      }

      .movie-introduce {
        margin: 20px 50px 20px 20px;
        line-height: 30px;
      }

      .comment-item {
        margin: 20px 0;
        padding: 15px 10px;
        background-color: #eee;

        .comment-header {
          display: flex;
          height: 36px;
          line-height: 36px;

          div {
            margin-left: 20px;
          }
        }

        .comment-content {
          line-height: 30px;
        }
      }

      .comment-container{
        margin-top: 10px;
        width: 80%;
      }
    }
  }

</style>
