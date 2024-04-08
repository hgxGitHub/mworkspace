package com.mashibing.reflect;

import com.mashibing.bean.Orders;
import com.mashibing.bean.Student;
import com.mashibing.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: huangguanxiong
 * @Date: 2024/2/24
 * @Description: com.mashibing.reflect
 * @version: 1.0
 */
public class CreateClassObject01 {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.mashibing.bean.Student");
        //获取属性
        Field[] fields = clazz.getFields();
        //获取属性信息，包含父类，但只能访问public修饰的
        for (Field field : fields) {
            //属性对象
            System.out.println(field);
            //属性名称
            System.out.println(field.getName());
            //获取类型
            System.out.println(field.getType());
            //获取访问修饰符
            System.out.println(field.getModifiers());
        }
        System.out.println("========================================");
        Field[] declaredFields = clazz.getDeclaredFields();
        //只能访问当前类的属性，可以访问private修饰的
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        //User user = new User();
        Class clazz1 = Class.forName("com.mashibing.bean.User");
        Field pwd = clazz1.getDeclaredField("pwd");
        //class.new Instance()必须要有无参构造方法
        User o1 = (User)clazz1.newInstance();
        System.out.println("=========修改私有属性值=========");
        System.out.println(o1.getPwd());
        System.out.println(pwd.getName() + " ");
        //设置可以改变私有修饰属性
        pwd.setAccessible(true);
        pwd.set(o1,"1234567");
        System.out.println(o1.getPwd());

        System.out.println("----------------------------------");
        //获取普通方法,包含父类的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("当前类方法");
        //获取当前类的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        //调用私有方法
        Method add = clazz.getDeclaredMethod("add", int.class, int.class);
        Method add1 = clazz.getMethod("add", int.class, int.class);
        add.setAccessible(true);
        Student o = (Student)clazz.newInstance();
        add.invoke(o,123,123);

        System.out.println("获取构造方法==============2==");
        //构造方法只能获取本类，无法获取父类
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }
        //调用构造方法
        Constructor constructor = clazz.getDeclaredConstructor(String.class, String.class);
        constructor.setAccessible(true);
        Student s  = (Student)constructor.newInstance("java一班", "上海市");
        System.out.println(s);

        List<Object> lists = new ArrayList<>();
        lists.add(1);
        lists.add(100.00);
        lists.add(true);
        //lists.add(new User());

        Class<?>[] cla = new Class[lists.size()];
        outer:for (int i = 0; i < lists.size(); i++) {
            cla[i] = lists.get(i).getClass();
            if(1==1){
                continue outer;
            }
        }
        Class clazz2 = Class.forName("com.mashibing.bean.Car");
        Constructor constructor2 = clazz2.getConstructor(cla);
        constructor.setAccessible(true);
        Orders o2 = (Orders)constructor2.newInstance(1,100.00,true);
        System.out.println(o2);


    }
}
