package com.jaydip.fantasysport.models;

import java.io.Serializable;

public class Player implements Serializable {
    String PlayreName;
    String age;
    String Point;
    double Credit;
    boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getPlayreName() {
        return PlayreName;
    }

    public void setPlayreName(String playreName) {
        PlayreName = playreName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPoint() {
        return Point;
    }

    public void setPoint(String point) {
        Point = point;
    }

    public double getCredit() {
        return Credit;
    }

    public void setCredit(double credit) {
        Credit = credit;
    }
}
