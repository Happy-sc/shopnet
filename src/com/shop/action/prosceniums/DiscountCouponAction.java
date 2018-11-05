package com.shop.action.prosceniums;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.domain.DiscountCoupon;
import com.shop.domain.Users;
import com.shop.service.DiscountCouponService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("discountCouponAction")
public class DiscountCouponAction extends BaseAction {

    @Resource(name = "discountCouponService")
    private DiscountCouponService discountCouponService;

    public String seeDiscountCoupon(){
        HttpSession session = request.getSession();
        String state = request.getParameter("type");
        Users users = (Users) session.getAttribute("user");
        if(users != null){
            List<DiscountCoupon> list = discountCouponService.getDiscountCoupon(users.getUserId(),Integer.valueOf(state),getPage());
            ActionContext.getContext().put("discountCoupons",list);
        }
        ActionContext.getContext().put("type",state );
        return "seeDiscountCoupon";
    }

}
