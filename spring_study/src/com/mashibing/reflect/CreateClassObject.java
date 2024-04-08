package com.mashibing.reflect;

import com.mashibing.bean.Person;
import com.mashibing.bean.Student;

/**
 * @Auther: huangguanxiong
 * @Date: 2024/2/22
 * @Description: com.mashibing.reflect 反射
 * @version: 1.0
 */
public class CreateClassObject{
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 创建class 几种方式 1.Class.forName()
         * 2.Person.class
         * 3.new Person().getClass()
         * 4.包装类Intger.TYPE
         */
        Class clazz = Class.forName("com.mashibing.bean.Person");
        //获取包名
        System.out.println(clazz.getPackage());
        //获取路劲名
        System.out.println(clazz.getName());
        //获取类名
        System.out.println(clazz.getSimpleName());
        //获取java规范名
        System.out.println(clazz.getCanonicalName());
        Class clazz1 = Person.class;
        Class clazz2 = new Person().getClass();
        Class<Integer> type = Integer.TYPE;
        Class type1 = Integer[].class;
        System.out.println(type1.getName());
        System.out.println(type1.getCanonicalName());

        Student s = new Student();
        Person p = new Student();
        System.out.println(s.getClass().isAssignableFrom(Student.class));
        System.out.println(Student.class.isAssignableFrom(Person.class));
        System.out.println(p.getClass().isAssignableFrom(Person.class));

    }

}
