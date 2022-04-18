<template>
    <div class="xjt-cinemas-view">
        <div class="nav-container">
            <div class="category-nav" style="display: flex">
                <div class="nav-title" style="line-height: 60px;font-size: 20px;color: #ef4238;font-weight: bold;">
                    影院名：
                </div>
                <el-menu
                    :default-active="activeCategory"
                    class="el-menu-demo"
                    mode="horizontal"
                    router
                    @select="handleCategoryNavSelect">
                    <el-menu-item index="0">全部</el-menu-item>
                    <el-menu-item index="1">万达影城</el-menu-item>
                    <el-menu-item index="2">大地影院</el-menu-item>
                    <el-menu-item index="3">中影国际影城</el-menu-item>
                    <el-menu-item index="4">中影南方国际影城</el-menu-item>
                    <el-menu-item index="5">金逸影城</el-menu-item>
                    <el-menu-item index="6">星星国际影城</el-menu-item>
                    <el-menu-item index="7">完美世界影城</el-menu-item>
                    <el-menu-item index="8">横店影视</el-menu-item>
                    <el-menu-item index="9">环球影城</el-menu-item>
                    <el-menu-item index="10">博纳国际影城</el-menu-item>
                </el-menu>
            </div>

            <div class="country-nav" style="display: flex">
                <div class="nav-title" style="line-height: 60px;font-size: 20px;color: #ef4238;font-weight: bold;">
                    位置：
                </div>
                <el-menu
                    :default-active="activeCountry"
                    class="el-menu-demo"
                    mode="horizontal"
                    router
                    @select="handleCountryNavSelect">
                    <el-menu-item index="0">全部</el-menu-item>
                    <el-menu-item index="1">南山区</el-menu-item>
                    <el-menu-item index="2">福田区</el-menu-item>
                    <el-menu-item index="3">龙岗区</el-menu-item>
                    <el-menu-item index="4">宝安区</el-menu-item>
                    <el-menu-item index="5">罗湖区</el-menu-item>
                    <el-menu-item index="6">龙华区</el-menu-item>
                    <el-menu-item index="7">盐田区</el-menu-item>
                    <el-menu-item index="8">坪山区</el-menu-item>
                    <el-menu-item index="9">光明区</el-menu-item>
                </el-menu>
            </div>
        </div>

        <div class="grid-content">
            <div class="cinamas-list" style="font-size: 22px;font-weight: bold;
            border-left: 4px solid red;padding-left: 5px;margin: 20px 0;">影院列表</div>

            <div class="grid-item" v-for="(item,index) in gridData" :key="index">
                <cinema-item :cinema="item"></cinema-item>
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
    import CinemaItem from "./comps/CinemaItem.vue"

    export default {
        name: "Cinemas",
        components:{
            CinemaItem,
        },
        data(){
            return{
                activeShowType:"/films/hot",
                activeCategory:"0",
                activeCountry:"0",
                activeReleaseDate:"0",

                gridData:[
                    {
                        cinema_id:"1234",
                        cinema_name:"万达影城（虎门万达广场IMAX店）",
                        cinema_address:"地址：虎门镇连升北路388号万达广场F4层",
                        cinema_tags:"改签，折扣卡，儿童厅，MX4D厅",
                        cinema_price:45,
                    },
                    {
                        cinema_id:"1234",
                        cinema_name:"万达影城（虎门万达广场IMAX店）",
                        cinema_address:"地址：虎门镇连升北路388号万达广场F4层",
                        cinema_tags:"改签，折扣卡，儿童厅，MX4D厅",
                        cinema_price:45,
                    },
                    {
                        cinema_id:"1234",
                        cinema_name:"万达影城（虎门万达广场IMAX店）",
                        cinema_address:"地址：虎门镇连升北路388号万达广场F4层",
                        cinema_tags:"改签，折扣卡，儿童厅，MX4D厅",
                        cinema_price:45,
                    },
                    {
                        cinema_id:"1234",
                        cinema_name:"万达影城（虎门万达广场IMAX店）",
                        cinema_address:"地址：虎门镇连升北路388号万达广场F4层",
                        cinema_tags:"改签，折扣卡，儿童厅，MX4D厅",
                        cinema_price:45,
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

<style lang="less" scoped>
    .nav-container{
        margin-top: 20px;
        border: 1px solid #ddd;
        padding: 10px 20px;
    }
</style>


