package com.liqiang;

public class Apply {
    private String applyName;
    private String applyTime;
    private String inTime;
    private String type;
    private String unit;
    private int num;

    public Apply() {
    }

    public Apply(String applyName) {
        this.applyName = applyName;
    }

    public Apply(String applyName, String applyTime, String inTime, String type, String unit, int num) {
        this.applyName = applyName;
        this.applyTime = applyTime;
        this.inTime = inTime;
        this.type = type;
        this.unit = unit;
        this.num = num;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    @Override
    public String toString() {
        return "Apply{" +
                "applyName='" + applyName + '\'' +
                ", applyTime='" + applyTime + '\'' +
                ", inTime='" + inTime + '\'' +
                ", type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                ", num=" + num +
                '}';
    }
}
