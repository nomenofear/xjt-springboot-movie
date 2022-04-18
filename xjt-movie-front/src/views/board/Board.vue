<template>
    <div class="xjt-board-view">
        <div class="grid-content">
            <div class="cinamas-list" style="font-size: 22px;font-weight: bold;
            border-left: 4px solid red;padding-left: 5px;margin: 20px 0;">影院列表</div>

            <div class="grid-item" v-for="(item,index) in gridData" :key="index">
                <board-item :movie="item"></board-item>
            </div>
        </div>

        <div class="my-pagination" style="margin-top: 30px;padding: 10px 0;border: 1px solid #ddd;">
            <el-pagination
                background
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="currentPage"
                :page-sizes="pageSizes"
                :page-size="pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    import BoardItem from "./comps/BoardItem.vue"

    export default {
        name: "Board",
        components:{
            BoardItem,
        },
        data(){
            return{
                activeShowType:"/films/hot",
                activeCategory:"0",
                activeCountry:"0",
                activeReleaseDate:"0",

                gridData:[
                    {
                        movie_id:"12",
                        movie_cn_name:"误杀",
                        movie_picture:"https://p0.meituan.net/movie/e93b8b54ffd529b26605c8c078b9cbca2295531.jpg",
                        movie_actor:"肖央:李维杰",
                        movie_category:"剧情 犯罪",
                        movie_score:7.8,
                        movie_releaseDate:"2021-12-17",
                    },
                    {
                        movie_id:"1234",
                        movie_cn_name:"误杀",
                        movie_picture:"https://p0.meituan.net/movie/e93b8b54ffd529b26605c8c078b9cbca2295531.jpg",
                        movie_actor:"肖央:李维杰",
                        movie_category:"剧情 犯罪",
                        movie_score:7.8,
                        movie_releaseDate:"2021-12-17",
                    },
                    {
                        movie_id:"1234",
                        movie_cn_name:"误杀",
                        movie_picture:"https://p0.meituan.net/movie/e93b8b54ffd529b26605c8c078b9cbca2295531.jpg",
                        movie_actor:"肖央:李维杰",
                        movie_category:"剧情 犯罪",
                        movie_score:7.8,
                        movie_releaseDate:"2021-12-17",
                    },
                    {
                        movie_id:"1234",
                        movie_cn_name:"误杀",
                        movie_picture:"https://p0.meituan.net/movie/e93b8b54ffd529b26605c8c078b9cbca2295531.jpg",
                        movie_actor:"肖央:李维杰",
                        movie_category:"剧情 犯罪",
                        movie_score:7.8,
                        movie_releaseDate:"2021-12-17",
                    },
                ],

                /*分页*/
                currentPage:1,
                pageSizes:[6,12,18,24],
                pageSize:12,
                total:100
            }
        },
        methods:{
            handleShowTypeSelect(val){
                this.activeShowType = val;
                this.$router.push(val)
            },
            handleCategoryNavSelect(val){
                this.activeCategory = val;
            },
            handleCountryNavSelect(val){
                this.activeCountry = val;
            },
            handleReleaseDateNavSelect(val){
                this.activeReleaseDate = val;
            },

            /*分页*/
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
            }

        }
    }
</script>

<style scoped>

</style>
