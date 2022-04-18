<template>
    <div class="xjt-index-view">
        <div class="layout-left">
            <div class="panel">
                <div class="panel-header">
                    <svg t="1639899022125" style="margin-top: 10px;margin-right: 10px;" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2137" width="40" height="40"><path d="M336 972.8c-60.8-128-28.8-201.6 19.2-268.8 51.2-76.8 64-150.4 64-150.4s41.6 51.2 25.6 134.4c70.4-80 83.2-208 73.6-256 160 112 230.4 358.4 137.6 537.6 492.8-281.6 121.6-700.8 57.6-745.6 22.4 48 25.6 128-19.2 166.4-73.6-281.6-256-336-256-336 22.4 144-76.8 300.8-172.8 419.2-3.2-57.6-6.4-96-38.4-153.6-6.4 105.6-86.4 188.8-108.8 294.4C89.6 758.4 140.8 860.8 336 972.8L336 972.8z" p-id="2138" fill="#d81e06"></path></svg>

                    <div class="panel-title">
                        正在热映（{{hotMovieTotal}}部）
                    </div>
                    <div class="panel-more">
                        全部 >
                    </div>
                </div>
                <div class="panel-content">
                    <div class="movie-item" v-for="(item,index) in hotMovieList" :key="index">
                        <hot-movie-card :movie-item="item"></hot-movie-card>
                    </div>
                </div>
            </div>
            <div class="panel">
                <div class="panel-header">
                    <svg t="1639899255699" style="margin-top: 10px;margin-right: 10px;" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3139" width="40" height="40"><path d="M496 280c-12.8 0-24 11.2-24 24v224c0 12.8 11.2 24 24 24h160c12.8 0 24-11.2 24-24s-11.2-24-24-24h-136V304c0-12.8-11.2-24-24-24z" p-id="3140" fill="#1296db"></path><path d="M512 152C313.6 152 152 313.6 152 512c0 8 4.8 16 12.8 20.8 8 4.8 16 4.8 24 0l80-48c11.2-6.4 14.4-20.8 8-33.6-6.4-11.2-20.8-14.4-33.6-8l-40 24C224 316.8 355.2 200 512 200c172.8 0 312 139.2 312 312S684.8 824 512 824c-99.2 0-193.6-48-252.8-129.6-8-11.2-22.4-12.8-33.6-4.8-11.2 8-12.8 22.4-4.8 33.6 67.2 92.8 176 148.8 291.2 148.8 198.4 0 360-161.6 360-360S710.4 152 512 152z" p-id="3141" fill="#1296db"></path></svg>

                    <div class="panel-title">
                        即将上映（{{commingMovieTotal}}部）
                    </div>
                    <div class="panel-more">
                        全部 >
                    </div>
                </div>
                <div class="panel-content">
                    <div class="movie-item" v-for="(item,index) in commingMovieList" :key="index">
                        <hot-movie-card :movie="item"></hot-movie-card>
                    </div>
                </div>
            </div>
            <div class="panel">
                <div class="panel-header">
                    <svg t="1639899362259" style="margin-top: 10px;margin-right: 10px;" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3757" width="40" height="40"><path d="M511.04256 115.30752l121.4976 274.32448 298.32192 31.95904-223.36 200.32512 61.78816 293.58592-259.52768-150.528-260.13184 149.504 62.95552-293.36064-222.55616-201.19552 298.42944-30.77632 122.58304-273.83808z" fill="#FF962F" p-id="3758"></path></svg>

                    <div class="panel-title">
                        经典影片
                    </div>
                    <div class="panel-more">
                        全部 >
                    </div>
                </div>
                <div class="panel-content">
                    <div class="movie-item" v-for="(item,index) in classicMovieList" :key="index">
                        <hot-movie-card :movie="item"></hot-movie-card>
                    </div>
                </div>
            </div>
        </div>

        <div class="layout-right">
            <!--今日票房-->
            <div class="ranking-box-wrapper">
                <div class="panel-title" style="line-height: 50px;font-size: 30px;color: #ef4238;border-left: 4px solid deepskyblue;padding-left: 8px;">今日票房</div>

                <div class="ranking-item"
                     :class="{'ranking-top':index==0}"
                     v-for="(item,index) in rankingBoxData" :key="index">

                    <div class="ranking-left" v-if="index == 0">
                        <el-image
                            style="width: 100%; height: 100%"
                            :src="item.coverPic"
                            fit="fill"></el-image>
                    </div>
                    <div class="ranking-left" v-else>{{index + 1}}</div>
                    <div class="ranking-right">
                        <div class="name">{{item.name}}</div>
                        <div class="wish-ticket">{{item.ticket}}万</div>
                    </div>
                </div>
            </div>

            <!--最受期待-->
            <div class="most-expect-wrapper" style="margin-top: 30px;">
                <div class="panel-title">
                    <span class="left"
                          style="line-height: 50px;font-size: 30px;color: #ef4238;border-left: 4px solid deepskyblue;padding-left: 8px;">最受期待</span>
                    <span class="right" style="line-height: 50px;font-size: 22px;color: #ffb400;float: right;">查看完整榜单></span>
                </div>
                <div class="ranking-mostExpect">
                    <div class="ranking-item"
                         style="display: flex;padding: 10px 0;"
                         v-for="(item,index) in mostExpectData"
                         :key="index">
                        <div class="most-expect-left" style="width: 140px;height: 194px;">
                            <el-image
                                style="width: 100%; height: 100%"
                                :src="item.coverPic"
                                fit="fill"></el-image>
                        </div>
                        <div class="most-expect-right" style="flex: 1;margin-left: 20px;height: 194px;align-items: center;line-height: 194px;">
                            <div class="name" style="font-size: 22px;line-height: 64px;">{{item.name}}</div>
                            <div class="release-time" style="font-size: 16px;line-height: 64px;color: #515a6e;">上映时间：{{item.releaseTime}}</div>
                            <div class="wish-ticket" style="font-size: 18px;line-height: 64px;color: #ffb400;">{{item.wishTicket}}人想看</div>
                        </div>
                    </div>
                </div>
            </div>

            <!--top100-->
            <div class="top100-wrapper" style="margin-top: 30px;">
                <div class="panel-title">
                    <span class="left"
                          style="line-height: 50px;font-size: 30px;color: #ef4238;border-left: 4px solid deepskyblue;padding-left: 8px;">Top100</span>
                    <span class="right" style="line-height: 50px;font-size: 22px;color: #ffb400;float: right;">查看完整榜单></span>
                </div>
                <div class="ranking-top100">
                    <div class="ranking-item"
                         style="display: flex;padding: 10px 0;"
                         v-for="(item,index) in top100Data"
                         :key="index">
                        <div class="most-expect-left" style="width: 140px;height: 194px;">
                            <el-image
                                style="width: 100%; height: 100%"
                                :src="item.coverPic"
                                fit="fill"></el-image>
                        </div>
                        <div class="most-expect-right" style="flex: 1;margin-left: 20px;height: 194px;align-items: center;line-height: 194px;">
                            <div class="name" style="font-size: 22px;line-height: 64px;">{{item.name}}</div>
                            <div class="release-time" style="font-size: 16px;line-height: 64px;color: #515a6e;">上映时间：{{item.releaseTime}}</div>
                            <div class="wish-ticket" style="font-size: 18px;line-height: 64px;color: #ffb400;">评分：{{item.score}}</div>
                        </div>
                    </div>
                </div>
            </div>

            <!--热门影人-->
            <div class="popular-container" style="margin-top: 30px;">
                <div class="panel-title">
                    <span class="left"
                          style="line-height: 50px;font-size: 30px;color: #ef4238;border-left: 4px solid deepskyblue;padding-left: 8px;">热门影人</span>
                </div>
                <div class="ranking-popular-actor">
                    <div class="ranking-item"
                         style="display: flex;padding: 10px 0;"
                         v-for="(item,index) in popularActorData"
                         :key="index">

                        <div style="width: 26px;text-align: center;font-size: 22px;font-weight: bold;height: 120px;line-height: 120px;color: #ef4238;">{{index + 1}}</div>

                        <div style="width: 120px;height: 120px;margin-left: 20px;">
                            <el-image
                                    style="width: 100%; height: 100%"
                                    :src="item.actorAvatar"
                                    fit="fill"></el-image>
                        </div>

                        <div class="name" style="font-size: 22px;height: 120px;line-height: 120px;margin-left: 20px;">{{item.name}}</div>
                    </div>
                </div>
            </div>

            <!--娱乐热点-->
            <div class="news-container" style="margin-top: 30px;">
                <div class="panel-title" style="width: 100%;">
                    <span style="line-height: 50px;font-size: 30px;color: #ef4238;border-left: 4px solid deepskyblue;padding-left: 8px;">娱乐热点</span>
                </div>
                <div class="ranking-news">
                    <div class="ranking-item"
                         style="display: flex;padding: 10px 0;"
                         v-for="(item,index) in newsData"
                         :key="index">

                        <div style="width: 40px;
                        height: 100%;
                        font-size: 28px;
                        color: #ef4238;
                        text-align: center;
                        font-style: italic;
                        font-weight: bold;
                        line-height: 100%;
                        background-color:#eee;">{{index + 1}}</div>

                        <div style="font-size: 16px;height: 32px;line-height: 32px;margin-left: 10px;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;">{{item.content}}</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import HotMovieCard from "./comps/HotMovieCard"

    export default {
        name: "Index",
        components:{
            HotMovieCard
        },
        data(){
            return{
                hotMovieTotal:0,
                hotMovieList:[
                    {
                        "coverPic":"https://p0.meituan.net/movie/e93b8b54ffd529b26605c8c078b9cbca2295531.jpg",
                        "name":"误杀2",
                        "score":9.7,
                        "id":1235
                    },

                ],      //正在热映

                commingMovieTotal:0,
                commingMovieList:[
                    {
                        "coverPic":"https://p0.meituan.net/movie/e93b8b54ffd529b26605c8c078b9cbca2295531.jpg",
                        "name":"误杀2",
                        "score":9.7,
                        "id":1235
                    },

                ],      //即将上映

                classicMovieList:[],

                rankingBoxData:[
                    {
                        "coverPic":"https://p0.meituan.net/movie/e93b8b54ffd529b26605c8c078b9cbca2295531.jpg",
                        "name":"误杀2",
                        "score":9.7,
                        "id":1235,
                        "ticket":2207.32
                    },

                ],

                mostExpectData:[
                    {
                        "coverPic":"https://p1.meituan.net/movie/d8b7d8d9c3b3a043865aec532cbddf85375350.jpg",
                        "name":"紧急营救",
                        "releaseTime":"2021-12-31",
                        "id":1235,
                        "wishTicket":481701
                    },
                ],

                top100Data:[
                    {
                        "coverPic":"https://p0.meituan.net/moviemachine/152f043cabbc6feb9153f89203872657977832.jpg",
                        "name":"战狼",
                        "releaseTime":"2015-04-02",
                        "id":1235,
                        "score":9.7,
                    },
                    {
                        "coverPic":"https://p0.meituan.net/moviemachine/152f043cabbc6feb9153f89203872657977832.jpg",
                        "name":"战狼",
                        "releaseTime":"2015-04-02",
                        "id":1235,
                        "score":9.7,
                    },
                    {
                        "coverPic":"https://p0.meituan.net/moviemachine/152f043cabbc6feb9153f89203872657977832.jpg",
                        "name":"战狼",
                        "releaseTime":"2015-04-02",
                        "id":1235,
                        "score":9.7,
                    },
                    {
                        "coverPic":"https://p0.meituan.net/moviemachine/152f043cabbc6feb9153f89203872657977832.jpg",
                        "name":"战狼",
                        "releaseTime":"2015-04-02",
                        "id":1235,
                        "score":9.7,
                    },{
                        "coverPic":"https://p0.meituan.net/moviemachine/152f043cabbc6feb9153f89203872657977832.jpg",
                        "name":"战狼",
                        "releaseTime":"2015-04-02",
                        "id":1235,
                        "score":9.7,
                    },
                ],

                popularActorData:[
                    {
                        "actorAvatar":"https://p1.meituan.net/moviemachine/4c848df6e2d8fef6b27f94d746a89354140365.jpg",
                        "name":"肖央",
                        "id":1235,
                    },
                    {
                        "actorAvatar":"https://p1.meituan.net/moviemachine/534ecb98ceb5b093ff632917df05371b32352.jpg",
                        "name":"范伟",
                        "id":1235,
                    },
                    {
                        "actorAvatar":"https://p1.meituan.net/moviemachine/534ecb98ceb5b093ff632917df05371b32352.jpg",
                        "name":"范伟",
                        "id":1235,
                    },
                    {
                        "actorAvatar":"https://p1.meituan.net/moviemachine/534ecb98ceb5b093ff632917df05371b32352.jpg",
                        "name":"范伟",
                        "id":1235,
                    },
                    {
                        "actorAvatar":"https://p1.meituan.net/moviemachine/534ecb98ceb5b093ff632917df05371b32352.jpg",
                        "name":"范伟",
                        "id":1235,
                    },

                ],

                newsData:[
                    {
                        "coverPic":"",
                        "id":1234,
                        "content":"一部国产动画电影竟然被万众期待，大电影《我们的冬奥》做到了",
                    },
                    {
                        "coverPic":"",
                        "id":1234,
                        "content":"一部国产动画电影竟然被万众期待，大电影《我们的冬奥》做到了",
                    },
                    {
                        "coverPic":"",
                        "id":1234,
                        "content":"一部国产动画电影竟然被万众期待，大电影《我们的冬奥》做到了",
                    },
                    {
                        "coverPic":"",
                        "id":1234,
                        "content":"一部国产动画电影竟然被万众期待，大电影《我们的冬奥》做到了",
                    },
                ]
            }
        },
        methods:{
            initIndex(){
                //正在热映
                this.$getRequest("/movie/getMoviesByPage?showType=1").then(res =>{
                    console.log(res);
                    if(res.status === 200){
                        this.hotMovieList.splice(0);
                        this.hotMovieList.push(...res.obj.records);
                        this.hotMovieTotal = res.obj.total;
                    }
                });

                //即将上映
                this.$getRequest("/movie/getMoviesByPage?showType=2").then(res =>{
                    console.log(res);
                    if(res.status === 200){
                        this.commingMovieList.splice(0);
                        this.commingMovieList.push(...res.obj.records);
                        this.commingMovieTotal = res.obj.total;
                    }
                });

                //经典影片
                this.$getRequest("/movie/getMoviesByPage?showType=3").then(res =>{
                    console.log(res);
                    if(res.status === 200){
                        this.classicMovieList.splice(0);
                        this.classicMovieList.push(...res.obj.records);
                    }
                });
            },
        },
        created() {
            this.initIndex();
        }
    }
</script>

<style lang="less" scoped>
    .xjt-index-view{
        display: flex;
        width: 100%;
        margin-top: 20px;
        .layout-left{
            flex: 1;
            .panel{
                margin-bottom: 20px;
                padding-bottom: 30px;
                border-bottom: 1px dashed #ddd;
                .panel-header{
                    display: flex;
                    line-height: 60px;
                    .panel-title{
                        flex: 1;
                        font-size: 30px;
                        color: #ef4238;
                    }
                    .panel-more{
                        width: 100px;
                        font-size: 20px;
                    }
                }
                .panel-content{
                    display: grid;
                    grid-template-columns: repeat(4,25%);
                    grid-row-gap: 20px;
                }
            }
        }

        .layout-right{
            width: 400px;
            height: 100%;
            margin-left: 30px;
            /*background-color: #dddddd;*/

            .ranking-box-wrapper{
                width: 100%;

                .panel-title{
                    height: 50px;
                    line-height: 50px;
                    font-size: 30px;
                    color: #ef4238;
                }
                .ranking-item{
                    display: flex;
                    padding: 15px 0;
                    .ranking-left{
                        width: 40px;
                        height: 100%;
                        font-size: 36px;
                        color: #ef4238;
                        text-align: center;
                        background-color: #dddddd;
                    }
                    .ranking-right{
                        margin-left: 50px;
                        flex: 1;
                        height: 18px;
                        line-height: 18px;
                        .name{
                            font-size: 20px;
                        }
                        .wish-ticket{
                            margin-top: 5px;
                            font-size: 16px;
                            color: #ef4238;
                        }
                    }
                }
                .ranking-top{
                    height: 100px;
                    display: flex;
                    .ranking-left{
                        width: 180px;
                        height: 100%;
                        font-size: 24px;
                        color: #ef4238;
                    }
                    .ranking-right{
                        margin-left: 10px;
                        flex: 1;
                        height: 80px;
                        line-height: 40px;
                        .name{
                            font-size: 24px;
                        }
                        .wish-ticket{
                            font-size: 18px;
                            color: #ef4238;
                        }
                    }
                }
            }
        }
    }

</style>
