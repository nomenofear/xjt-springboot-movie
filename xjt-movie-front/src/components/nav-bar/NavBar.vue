<template>
    <div class="navbar-component">
        <div class="left-container">
            <slot name="left"></slot>
        </div>
        <div class="middle-container">
            <slot name="middle"></slot>
        </div>
        <div class="right-container">
            <slot name="right"></slot>
        </div>
    </div>
</template>

<script>
    export default {
        name: "NavBar"
    }
</script>

<style lang="less" scoped>
    .navbar-component{
        display: flex;
        height: 50px;
        width: 100%;
        .left-container{
            width: 120px;
            text-align: left;
            line-height: 50px;
        }
        .middle-container{
            flex: 1;
            text-align: center;
            line-height: 50px;
        }
        .right-container{
            width: 120px;
            text-align: right;
            line-height: 50px;
        }
    }
</style>
