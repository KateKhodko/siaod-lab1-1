package com.company;

public class Number {
    private int degree;
    private double num;

    public Number(int degree, double num) {
        this.degree = degree;
        this.num = num;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
