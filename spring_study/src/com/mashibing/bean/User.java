package com.mashibing.bean;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: huangguanxiong
 * @Date: 2024/2/24
 * @Description: com.mashibing.bean
 * @version: 1.0
 */
public class User {
    public String name;

    private String pwd = "11111111111";

    public User() {
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public static void main(String[] args) {
        /*List<User> strs = new ArrayList();
        User user = new User("zhangsan","1");
        User user1 = new User("lisi","1");
        User user2 = new User("wangwu","1");
        User user3 = new User("zhangsan","2");
        User user4 = new User("zhaoliu","1");
        strs.add(user);
        strs.add(user1);
        strs.add(user2);
        strs.add(user3);
        strs.add(user4);
        System.out.println(strs.stream().collect(Collectors.groupingBy(User::getName)));*/


        Map<String,String> map = new HashMap<>();
        map.put("zhangsan","1");
        map.put("lisi","2");
        map.put("lisi","2");
        System.out.println(map);
    }

}
