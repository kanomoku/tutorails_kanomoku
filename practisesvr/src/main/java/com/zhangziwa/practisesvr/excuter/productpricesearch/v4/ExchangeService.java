package com.zhangziwa.practisesvr.excuter.productpricesearch.v4;


import com.zhangziwa.practisesvr.utils.thread.DelayUtils;

// 汇率换算服务
public class ExchangeService {

    public enum Money {
        USD(1.0), EUR(1.35387), GBP(1.69715), CAD(.92106), MXN(.07683);

        private final double rate;

        Money(double rate) {
            this.rate = rate;
        }
    }

    public static double getRate(Money source, Money destination) {
        return getRateWithDelay(source, destination);
    }

    private static double getRateWithDelay(Money source, Money destination) {
        DelayUtils.delay();
        return destination.rate / source.rate;
    }
}
