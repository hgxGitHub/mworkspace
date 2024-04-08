package com.mashibing.bean;

/**
 * @Auther: huangguanxiong
 * @Date: 2024/2/29
 * @Description: com.mashibing.bean
 * @version: 1.0
 */
public class Orders {

    private String id;
    private String orderType;
    private String customerId;
    private String amount;

    //public String User;

    public Orders() {
    }

    public Orders(String orderType, String customerId, String amount) {
        this.orderType = orderType;
        this.customerId = customerId;
        this.amount = amount;
    }

    public Orders(String id, String orderType, String customerId, String amount) {
        this.id = id;
        this.orderType = orderType;
        this.customerId = customerId;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    /*public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }*/

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderType='" + orderType + '\'' +
                ", customerId='" + customerId + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
