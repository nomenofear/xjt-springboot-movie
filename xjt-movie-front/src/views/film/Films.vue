<template>
    <div class="xjt-films-view">
        <div class="nav-container">
            <div class="category-nav" style="display: flex">
                <div class="nav-title" style="line-height: 60px;font-size: 20px;color: #ef4238;font-weight: bold;">
                    类型：
                </div>
                <el-menu
                    :default-active="activeCategory"
                    class="el-menu-demo"
                    mode="horizontal"
                    @select="handleCategoryNavSelect">
                    <el-menu-item :index="item" v-for="(item,index) in $const.categoryArr" :key="index">{{item}}</el-menu-item>
                </el-menu>
            </div>

            <div class="country-nav" style="display: flex">
                <div class="nav-title" style="line-height: 60px;font-size: 20px;color: #ef4238;font-weight: bold;">
                    区域：
                </div>
                <el-menu
                    :default-active="activeCountry"
                    class="el-menu-demo"
                    mode="horizontal"
                    @select="handleCountryNavSelect">
                    <el-menu-item :index="item" v-for="(item,index) in $const.countryArr" :key="index">{{item}}</el-menu-item>
                </el-menu>
            </div>

            <div class="release-date-nav" style="display: flex">
                <div class="nav-title" style="line-height: 60px;font-size: 20px;color: #ef4238;font-weight: bold;">
                    年代：
                </div>
                <el-menu
                    :default-active="activeReleaseDate"
                    class="el-menu-demo"
                    mode="horizontal"
                    @select="handleReleaseDateNavSelect">
                    <el-menu-item :index="item" v-for="(item,index) in $const.releaseDataArr" :key="index">{{item}}</el-menu-item>
                </el-menu>
            </div>
        </div>

        <div class="grid-content">
            <div class="grid-item" v-for="(item,index) in gridData" :key="index">
                <movie-item :movie="item"></movie-item>
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
    import MovieItem from "./comps/MovieItem.vue"

    export default {
        name: "Films",
        components:{
            MovieItem,
        },
        data(){
            return{
                activeCategory:"全部",
                activeCountry:"全部",
                activeReleaseDate:"全部",

                gridData:[
                    {
                        movie_id:"1234",
                        movie_cn_name:"误杀",
                        movie_picture:"https://p0.meituan.net/movie/e93b8b54ffd529b26605c8c078b9cbca2295531.jpg",
                        movie_actor:"肖央:李维杰",
                        movie_category:"剧情 犯罪",
                        movie_score:7.8,
                        movie_releaseDate:"2.21-12-17",
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
            initFilmsData(){
                //获取数据
                let params = {
                    "currentPage":this.currentPage,
                    "pageSize":this.pageSize,
                    "name":this.inputSearchWord,
                    "category":this.activeCategory == "全部"?"":this.activeCategory,
                    "country":this.activeCountry == "全部"?"":this.activeCountry,
                    "release":this.activeReleaseDate == "全部"?"":this.activeReleaseDate,
                };
                this.$getRequest("/movie/getMoviesByPage?"+this.$qs.stringify(params,{encode:false})).then(res =>{
                    console.log(res);
                    this.gridData.splice(0);
                    this.gridData.push(...res.obj.records);
                })
            },
            handleCategoryNavSelect(val){
                console.log(val);
                this.activeCategory = val;
                this.initFilmsData();
            },
            handleCountryNavSelect(val){
                console.log(val);
                this.activeCountry = val;
                this.initFilmsData();
            },
            handleReleaseDateNavSelect(val){
                console.log(val);
                this.activeReleaseDate = val;
                this.initFilmsData();
            },

            /*分页*/
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
                this.pageSize = val;
                this.initFilmsData();
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
                this.currentPage = val;
                this.initFilmsData();
            },

        },
        created() {
            this.initFilmsData();
        }
    }
</script>

<style lang="less" scoped>
    .nav-container{
        margin-top: 20px;
        border: 1px solid #ddd;
        padding: 10px 20px;
    }
    .grid-content{
        width: 100%;
        display: grid;
        grid-template-columns: repeat(6,16.67%);
        .grid-item{
            margin: 20px 20px 0 20px;
        }
    }
</style>
