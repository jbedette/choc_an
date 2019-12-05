package com.company;

public class Triple {
    String name;
    int num;
    double fee;

    Triple(String name, int num, double fee) {
        this.name = name;
        this.num = num;
        this.fee = fee;
    }

    Triple(String name, int num) {
        this.name = name;
        this.num = num;
    }

    Triple(String name) {
        this.name = name;
        this.num = 0;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public double getFee() {
        return fee;
    }

    public double setFee() {
        return fee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
