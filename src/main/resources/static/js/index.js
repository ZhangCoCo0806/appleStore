var vm=new Vue({
    el:'#app',
    data:{
        goodsType:'',
        userInfo:{
            userAccount:'',
            userPass:'',
            phone:'',
            email:''
        }
    },
    methods:{
        sendUserInfo:function () {
            var _this=this;
            var userInfo=_this.userInfo
            var user=JSON.stringify(userInfo);
            $.ajax({
                type: "POST",
                url: "getUserInfo",
                data:user,
                contentType: "application/json;charset=utf-8",
                success:function (data) {
                    console.log(data)
                }
            })
        }
    },
    mounted:function () {
        var _this=this;
        $.ajax({
            url:'getAllGoodsType',
            dataType:'json',
            type:'get',
            success:function (data) {
                _this.goodsType=data
            }
        })
    }

})
$(document).ready(function(){
    $(".signBtn").click(function () {
        $(".userSign").modal('show')
    })
    $('[data-toggle="tooltip"]').tooltip()
});
var swiper = new Swiper('.swiper-container', {
    pagination: '.swiper-pagination',
    effect: 'coverflow',
    grabCursor: true,
    centeredSlides: true,
    slidesPerView: 'auto',
    autoplay: 500,
    coverflow: {
        rotate: 50,
        stretch: 0,
        depth: 100,
        modifier: 1,
        slideShadows : true
    }
});