package com.shop.service.impl;

import com.shop.dao.DiscountCouponDao;
import com.shop.domain.DiscountCoupon;
import com.shop.service.DiscountCouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("discountCouponService")
public class DiscountCouponServiceImpl implements DiscountCouponService {

    @Resource(name = "discountCouponDao")
    private DiscountCouponDao discountCouponDao;


    @Override
    public List<DiscountCoupon> getDiscountCoupon(String userId,int state, int pageNo) {
        return discountCouponDao.getDiscountCoupon(userId,state,pageNo);
    }
}
