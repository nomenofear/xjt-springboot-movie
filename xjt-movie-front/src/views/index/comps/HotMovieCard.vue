<template>
    <div class="xjt-hot-movie-card">
        <div class="movie-poster">
            <el-image
                class="hvr-grow"
                style="width: 100%; height: 300px"
                :src="movieItem.moviePicture"
                fit="fill"></el-image>
            <div class="movie-overlay">
                <div class="movie-info">
                    <div class="movie-score">{{movieItem.movieScore}}</div>
                    <div class="movie-name">{{movieItem.movieCnName}}</div>
                </div>
            </div>
        </div>
        <div class="movie-sale" @click="goto">购票</div>
    </div>
</template>

<script>
    export default {
        name: "HotMovieCard",
        props:{
            movieItem:{
                type:Object,
                default(){
                    return {
                        movieId:"",
                        moviePicture:"",
                        movieCnName:"",
                        movieScore:9,
                    }
                }
            }
        },
        methods:{
            goto(){
                console.log(this.movieItem);
                this.$router.push('/cinemas?movieId='+ this.movieItem.movieId);
            }
        },
    }
</script>

<style lang="less" scoped>
    .xjt-hot-movie-card{
        position: relative;
        margin-left: 15px;
        margin-right: 15px;
        .movie-poster{
            border: 1px solid #ddd;
            border-radius: 8px 8px 0 0;
            padding: 10px;
            overflow: hidden;
            position: relative;
            .el-image{
                width: 100%;
                height: 160px;
            }
            .movie-overlay{
                position: absolute;
                left: 15px;
                bottom: 15px;
                width: 90%;
                height: 50px;
                .movie-info{
                    color: #fff;
                    position: absolute;
                    bottom: 7px;
                    width: 100%;
                    height: 50px;
                    line-height: 50px;
                    .movie-name{
                        float: left;
                        font-size: 18px;
                    }
                    .movie-score{
                        color: #ffb400;
                        float: right;
                        margin-right: 10px;
                        font-size: 24px;
                    }
                }
            }
        }

        .movie-sale{
            border: 1px solid #ddd;
            text-align: center;
            height: 40px;
            line-height: 39px;
            font-size: 18px;
            color: #ef4238;
            &:hover{
                background-color: #ef4238;
                color: white;
            }
        }
    }
</style>
