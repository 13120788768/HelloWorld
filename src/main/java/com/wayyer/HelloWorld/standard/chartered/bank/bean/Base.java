package com.wayyer.HelloWorld.standard.chartered.bank.bean;

/**
 * @Author: wayyer
 * @Description: base
 * can use the lombok to automatically inject set/get
 * @Program: HelloWorld
 * @Date: 2019.05.13
 */
public class Base {

    private String last_trading_date;
    private String delivery_date;
    private String market;
    private String label;

    public String getLast_trading_date() {
        return last_trading_date;
    }

    public void setLast_trading_date(String last_trading_date) {
        this.last_trading_date = last_trading_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
