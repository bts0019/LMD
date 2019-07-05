package com.sh.lmd.server.user.point.util;

import java.util.Random;

public class RandomUtil {
    public static int createNum(int start,int end){
        Random random=new Random();
        return random.nextInt(end-start)+start;
    }

    public static void main(String[] args) {
        int a = createNum(1,7);
        System.out.println(a);
    }
}
