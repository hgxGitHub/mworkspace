package com.mashibing.reflect;

import com.mashibing.bean.Person;

/**
 * @Auther: huangguanxiong
 * @Date: 2024/2/29
 * @Description: com.mashibing.reflect
 * @version: 1.0
 */
public class CustomCreateClass {
    public static void main(String[] args) throws Exception {
        Class aClass = Class.forName("com.mashibing.bean.Person");

        Object obj = aClass.newInstance();

        if(obj instanceof Person){
            System.out.println(aClass.getPackage());
            System.out.println(aClass.getName());
        }else{
            System.out.println("没进========");
        }

    }
}
