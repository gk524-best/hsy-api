package com.hsy.manager;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @Description:
 * @Author: gk
 * @Date: Created in 2021/2/4 14:32
 */
public class JwtUtilTest {
    @Test
    public void generateRandom16() {
        StringBuilder uid = new StringBuilder();
        Random rd = new SecureRandom();
        for (int i = 0; i < 16; i++) {
            int type = rd.nextInt(3);
            switch (type) {
                case 0:
                    // 0-9的随机数
                    uid.append(rd.nextInt(10));
                    break;
                case 1:
                    // ASCII 65-90之间为大写
                    uid.append((char)(rd.nextInt(25)+65));
                    break;
                case 2:
                    // ASCII 97-122之间为小写
                    uid.append((char)(rd.nextInt(25)+97));
                    break;
                default:
                    break;
            }
        }
        System.out.println(uid.toString());
    }
}
