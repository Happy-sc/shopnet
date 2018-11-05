$(document).ready(function(){
    //选定tab
    $(".discount_content>.title>ul>li").click(function(){
       $(this).addClass("now").siblings().removeClass("now") ;
       var id = $(this).attr("id");
        if(id=="tab1"){
            window.location.href = "../userCenter/discountCoupon_seeDiscountCoupon.action?type=1";
        }
        if(id=="tab2"){
            window.location.href = "../userCenter/discountCoupon_seeDiscountCoupon.action?type=2";
        }
        if(id=="tab3"){
            window.location.href = "../userCenter/discountCoupon_seeDiscountCoupon.action?type=0";
        }
    });
});