package com.mashibing.bean;

/**
 * @Auther: huangguanxiong
 * @Date: 2024/3/12
 * @Description: com.mashibing.bean
 * @version: 1.0
 */
public class Car {

    private Integer id;

    private Double price;

    private Boolean isFlag;


    public Car() {
    }

    public Car(Integer id, Double price, Boolean isFlag) {
        this.id = id;
        this.price = price;
        this.isFlag = isFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", price=" + price +
                ", isFlag=" + isFlag +
                '}';
    }
}
