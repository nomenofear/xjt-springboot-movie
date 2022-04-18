<template>
    <div class="latest-news-item">
        <div class="pic" style="width: 100%;overflow: hidden;border: 1px solid #ddd;">
            <el-image
                class="hvr-grow"
                style="width: 100%; height: 160px;"
                :src="news.news_pic"
                fit="fill"></el-image>
        </div>
        <div class="info">
            <div class="title">
                <span style="font-size: 24px;line-height: 42px;">{{news.news_title}}</span>
            </div>
            <div class="type" style="line-height: 32px;font-size: 16px;height: 32px;color: darkgrey;">
                <span style="float: right"><i class="el-icon-view"></i> {{news.news_viewCount}}</span>
                <span>猫眼电影</span>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "LatestNewsItem",
        props:{
            news:{
                type:Object,
                default(){
                    return {

                    }
                }
            }
        }
    }
</script>

<style scoped>

</style>
