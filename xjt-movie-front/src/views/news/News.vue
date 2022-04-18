<template>
    <div class="xjt-news-view">
        <!--最新资讯-->
        <div class="latest-news-container">
            <div class="latest-header">
                    <span class="left"
                          style="line-height: 50px;font-size: 30px;color: #ef4238;border-left: 4px solid deepskyblue;padding-left: 8px;">最新资讯</span>
                <span class="right" style="line-height: 50px;font-size: 22px;color: #ffb400;float: right;">全部></span>
            </div>
            <div class="latest-content">
                <div class="news-item" v-for="(item,index) in gridData" :key="index">
                    <latest-news-item :news="item"></latest-news-item>
                </div>
            </div>
        </div>

        <el-divider/>

        <!--热门预告片-->
        <div class="popular-coming-films-container">
            <div class="coming-films-header">
                    <span class="left"
                          style="line-height: 50px;font-size: 30px;color: #ef4238;border-left: 4px solid deepskyblue;padding-left: 8px;">热门预告片</span>
                <span class="right" style="line-height: 50px;font-size: 22px;color: #ffb400;float: right;">全部></span>
            </div>

            <el-table
                :data="popularComingFilms"
                style="width: 100%">
                <el-table-column
                    label="ID"
                    width="100">
                    <template slot-scope="scope">
                        <span style="font-size: 22px;font-weight: bold;font-style: italic">{{scope.row.movie_id}}</span>
                    </template>
                </el-table-column>

                <el-table-column
                    label="封面图"
                    width="200">
                    <template slot-scope="scope">
                        <el-image
                            class="hvr-grow"
                            style="width: 100%; height: 100%;"
                            :src="scope.row.movie_picture"
                            fit="fill"></el-image>
                    </template>
                </el-table-column>
                <el-table-column
                    label="标题">
                    <template slot-scope="scope">
                        <span class="top10-news-content" style="font-size: 22px;line-height: 260px;">{{scope.row.movie_preview_title}}</span>
                    </template>
                </el-table-column>
            </el-table>
        </div>

    </div>
</template>

<script>
    import LatestNewsItem from "./comps/LatestNewsItem.vue"

    export default {
        name: "news",
        components:{
            LatestNewsItem,
        },
        data(){
            return{
                activeShowType:"/films/hot",
                activeCategory:"0",
                activeCountry:"0",
                activeReleaseDate:"0",

                gridData:[
                    {
                        news_id:"1234",
                        news_pic:"https://p0.meituan.net/moviemachine/6fcd1abf4c7040f93656c01d35bb89bb233645.png",
                        news_title:"爷爷“不记得”的那些历史 我们不会忘！",
                        news_viewCount:"85",
                    },
                    {
                        news_id:"1234",
                        news_pic:"https://p0.meituan.net/moviemachine/6fcd1abf4c7040f93656c01d35bb89bb233645.png",
                        news_title:"爷爷“不记得”的那些历史 我们不会忘！",
                        news_viewCount:"85",
                    },
                    {
                        news_id:"1234",
                        news_pic:"https://p0.meituan.net/moviemachine/6fcd1abf4c7040f93656c01d35bb89bb233645.png",
                        news_title:"爷爷“不记得”的那些历史 我们不会忘！",
                        news_viewCount:"85",
                    },
                    {
                        news_id:"1234",
                        news_pic:"https://p0.meituan.net/moviemachine/6fcd1abf4c7040f93656c01d35bb89bb233645.png",
                        news_title:"爷爷“不记得”的那些历史 我们不会忘！",
                        news_viewCount:"85",
                    },
                    {
                        news_id:"1234",
                        news_pic:"https://p0.meituan.net/moviemachine/6fcd1abf4c7040f93656c01d35bb89bb233645.png",
                        news_title:"爷爷“不记得”的那些历史 我们不会忘！",
                        news_viewCount:"85",
                    },
                    {
                        news_id:"1234",
                        news_pic:"https://p0.meituan.net/moviemachine/6fcd1abf4c7040f93656c01d35bb89bb233645.png",
                        news_title:"爷爷“不记得”的那些历史 我们不会忘！",
                        news_viewCount:"85",
                    },
                ],

                popularComingFilms:[
                    {
                        movie_id:"1234",
                        movie_picture:"http://p1.meituan.net/moviemachine/208724bda9bd05385601c522be037081121227.jpg",
                        movie_preview_title:"年末必看电影《误杀2》领跑贺岁档！公映5小时票房突破1亿大关",
                    },
                    {
                        movie_id:"1234",
                        movie_picture:"http://p1.meituan.net/moviemachine/208724bda9bd05385601c522be037081121227.jpg",
                        movie_preview_title:"年末必看电影《误杀2》领跑贺岁档！公映5小时票房突破1亿大关",
                    },
                    {
                        movie_id:"1234",
                        movie_picture:"http://p1.meituan.net/moviemachine/208724bda9bd05385601c522be037081121227.jpg",
                        movie_preview_title:"年末必看电影《误杀2》领跑贺岁档！公映5小时票房突破1亿大关",
                    },
                    {
                        movie_id:"1234",
                        movie_picture:"http://p1.meituan.net/moviemachine/208724bda9bd05385601c522be037081121227.jpg",
                        movie_preview_title:"年末必看电影《误杀2》领跑贺岁档！公映5小时票房突破1亿大关",
                    },
                ],

                /*分页*/
                currentPage:1,
                pageSizes:[6,12,18,24],
                pageSize:12,
                total:100
            }
        },
    }
</script>

<style lang="less" scoped>
    .latest-news-container{
        .latest-content{
            display: grid;
            grid-template-columns: 1fr 1fr 1fr 1fr;
            grid-row-gap: 30px;
            margin-top: 10px;
            .news-item{
                margin-left: 15px;
                margin-right: 15px;
            }
        }
    }
    .popular-coming-films-container{
        .coming-films-header{
            margin-top: 10px;
            margin-bottom: 10px;
        }
    }
</style>
