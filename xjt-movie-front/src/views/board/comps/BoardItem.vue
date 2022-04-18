<template>
    <div class="board-item-comp">
        <div class="board-item" style="display: flex;margin-top: 30px;">
            <div class="item-index" style="width: 100px;height: 260px;">
                <span style="width: 100px;height: 100px;line-height: 260px;background-color:#ef4238;font-size: 32px;color: white;padding: 5px;">{{movie.movie_id}}</span>
            </div>
            <div class="item-image">
                <el-image
                    class="hvr-grow"
                    style="width: 180px; height: 260px;"
                    :src="movie.movie_picture"
                    fit="fill"></el-image>
            </div>
            <div class="item-info" style="flex: 1;margin-left: 20px;">
                <div class="name" style="font-size: 28px;line-height: 100px;">{{movie.movie_cn_name}}</div>
                <div class="actors" style="font-size: 18px;line-height: 32px;">主演：{{movie.movie_actor}}</div>
                <div class="releaseTime" style="font-size: 18px;line-height: 32px;">上映时间：{{movie.movie_releaseDate}}</div>
            </div>
            <div class="score" style="width: 100px;line-height: 260px;font-size: 32px;font-weight: bold;font-style: italic;color: #ffb400;">{{movie.movie_score}}</div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "BoardItem",
        props:{
            movie:{
                type:Object,
                default(){
                    return {

                    }
                }
            }
        },
    }
</script>

<style scoped>

</style>
