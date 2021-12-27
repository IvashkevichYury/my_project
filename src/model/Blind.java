package model;

public class Blind {

    private double blindsWidth;
    private double blindsHeight;
    private int color;
    private double areaBlinds;
    private long blindsCost;

    public double getBlindsWidth() {
        return blindsWidth;
    }

    public void setBlindsWidth(double blindsWidth) {
        this.blindsWidth = blindsWidth;
    }

    public double getBlindsHeight() {
        return blindsHeight;
    }

    public void setBlindsHeight(double blindsHeight) {
        this.blindsHeight = blindsHeight;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public double getAreaBlinds() {
        return areaBlinds;
    }

    public void setAreaBlinds(double areaBlinds) {
        this.areaBlinds = areaBlinds;
    }

    public long getBlindsCost() {
        return blindsCost;
    }

    public void setBlindsCost(long blindsCost) {
        this.blindsCost = blindsCost;
    }
}
