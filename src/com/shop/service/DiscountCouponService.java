package com.shop.service;


import com.shop.domain.DiscountCoupon;

import java.util.List;

public interface DiscountCouponService {

    /**
     * 根据用户编号和优惠状态获取实例
     * @param userId
     * @param pageNo
     * @param state
     * @return
     */
    List<DiscountCoupon> getDiscountCoupon(String userId, int state ,int pageNo);

}
