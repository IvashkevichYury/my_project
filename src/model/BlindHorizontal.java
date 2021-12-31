package model;

public class BlindHorizontal implements Blind{

    private int width;
    private int height;
    private int color;
    private double areaBlinds;
    private long blindsCost;

    @Override
    public int getWidth() {
        return width;
    }

    @Override public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public double getAreaBlinds() {
        return areaBlinds;
    }

    @Override
    public void setAreaBlinds(double areaBlinds) {
        this.areaBlinds = areaBlinds;
    }

    @Override
    public long getBlindsCost() {
        return blindsCost;
    }

    @Override
    public void setBlindsCost(long blindsCost) {
        this.blindsCost = blindsCost;
    }
}
