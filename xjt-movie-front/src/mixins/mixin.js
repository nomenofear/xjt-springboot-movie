export const myMixin = {
    data () {
        return{
            that:this,
        }
    },
    methods: {

    },
    filters:{
        filterSex(val){
            if(val === 1 || val === "1"){
                return "男"
            }else if(val === 0 || val === "0"){
                return "女"
            }
            else if(val === 2 || val === "2"){
                return "组合"
            }
            else if(val === 4 || val === "4"){
                return "未知"
            }
        },
        filterBirth(val,that){
            /*注意：filters中this失效，需要我们在data中定义that==this*/
            // console.log(val);
            // console.log(that);
            return that.$moment(val).format('YYYY-MM-DD');
        },
        filterImageUrl(val,that){
            let img_url = val + "";
            if(img_url.startsWith("http") || img_url.startsWith("https")){
                return img_url;
            }else{
                return that.$store.state.HOST + img_url;
            }
        }
    }
};

