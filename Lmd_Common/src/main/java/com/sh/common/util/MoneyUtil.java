package com.sh.common.util;

import java.text.DecimalFormat;


public class MoneyUtil {

    /**
     * 是用于对钱的装换
     * 数据库中各种钱字段统一存储的是int类型的
     * 对此需要转换为double类型
     */
    public static Double TransformMoney(Integer money){
        DecimalFormat format = new DecimalFormat("0.00");
        if (money == null){
            return null;
        }else {
            double m = Double.parseDouble(format.format(money));
            return m/100;
        }
    }

}
