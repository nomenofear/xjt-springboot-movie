<template>
    <div class="xjt-movieItem">
        <div class="pic" style="width: 100%;overflow: hidden;border: 1px solid #ddd;">
            <el-image
                class="hvr-grow"
                style="width: 100%; height: 320px"
                :src="movie.moviePicture"
                fit="cover"></el-image>
        </div>
        <div class="info">
            <div class="title-score" style="display: flex;">
                <div @click="$router.push('/film/'+movie.movieId)" style="font-size: 20px;line-height: 50px;flex: 1;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">{{movie.movieCnName}}</div>
                <div style="font-size: 18px;line-height: 50px;color: #ffb400;width: 24px;">{{movie.movieScore}}</div>
            </div>
            <div class="type" style="line-height: 32px;font-size: 16px;height: 32px;color: darkgrey;">类型：{{movie.movieCategory}}</div>
            <div class="actors" style="line-height: 32px;font-size: 16px;height: 32px;color: darkgrey;
            width: 100%;overflow: hidden;">主演：{{movie.movieActor}}</div>
            <div class="release-time" style="line-height: 32px;font-size: 16px;height: 32px;color: darkgrey;">上映时间：{{movie.movieReleasedate}}</div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "MovieItem",
        props:{
            movie:{
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
