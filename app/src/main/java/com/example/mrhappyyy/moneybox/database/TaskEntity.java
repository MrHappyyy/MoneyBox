package com.example.mrhappyyy.moneybox.database;

public class TaskEntity {
    private int id;
    private String name;
    private double price;
    private String dataAdd;

    public TaskEntity(int id, String name, double price, String dataAdd, String dataEnd) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dataAdd = dataAdd;
        this.dataEnd = dataEnd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDataAdd(String dataAdd) {
        this.dataAdd = dataAdd;
    }

    public void setDataEnd(String dataEnd) {
        this.dataEnd = dataEnd;
    }

    public String getDataEnd() {
        return dataEnd;
    }

    public String getDataAdd() {
        return dataAdd;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    private String dataEnd;
}
