package com.mashibing.bean;

/**
 * @Auther: huangguanxiong
 * @Date: 2024/2/24
 * @Description: com.mashibing.bean
 * @version: 1.0
 */
public class Student extends Person {
    public String className;

    private String address;

    public Student(){}

    private Student(String className, String address) {
        this.className = className;
        this.address = address;
    }

    public Student(String className, String address,String name) {
        super(name);
        this.className = className;
        this.address = address;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void add(int a,int b){
        System.out.println(a+b);
    }
    public int add(int a,int b,int c){
       return a+b+c;
    }

    @Override
    public String toString() {
        return "Student{" +
                "className='" + className + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
