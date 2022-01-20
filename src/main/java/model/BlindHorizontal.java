package model;

public class BlindHorizontal {

    private int width;
    private int height;
    private int color;
    private double areaBlinds;
    private long blindsCost;

    public BlindHorizontal() {
    }

    public BlindHorizontal(int width, int height, int color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    @Override
    public String toString() {
        return width + "," + height + "," + color + ",,,";
    }
}
