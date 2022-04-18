<template>
    <div class="cinema-item" style="display: flex;padding: 10px;border-bottom: 1px dashed #ddd;margin-top: 10px;">
        <div class="left" style="flex: 1;">
            <div class="name" style="line-height: 32px;font-size: 20px;">{{cinema.cinema_name}}</div>
            <div class="addr" style="line-height: 32px;font-size: 16px;">{{cinema.cinema_address}}</div>
            <div class="tags" style="line-height: 32px;font-size: 16px;">
                <el-tag type="success">{{cinema.cinema_tags}}</el-tag>
            </div>
        </div>
        <div class="right" style="width: 100px;">
            <span class="price">
                <p>￥{{cinema.cinema_price}}起</p>
            </span>
            <span class="buyTicket">
                <el-button type="danger" size="medium" @click="handleBuyTicket">选座购票</el-button>
            </span>
        </div>
    </div>
</template>

<script>
    export default {
        name: "CinemaItem",
        props:{
            cinema:{
                type:Object,
                default(){
                    return {

                    }
                }
            }
        },
        methods:{
            handleBuyTicket(){
                console.log("buyTicket");
            }
        }
    }
</script>

<style scoped>

</style>
