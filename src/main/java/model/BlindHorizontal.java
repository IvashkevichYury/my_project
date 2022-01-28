package model;

public class BlindHorizontal extends Blind{

    private int width;
    private int height;
    private int colorNumber;
    private double areaBlinds;
    private long blindsCost;

    public BlindHorizontal() {
    }

    public BlindHorizontal(int width, int height, int colorNumber) {
        this.width = width;
        this.height = height;
        this.colorNumber = colorNumber;
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

    public int getColorNumber() {
        return colorNumber;
    }

    public void setColorNumber(int colorNumber) {
        this.colorNumber = colorNumber;
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
        return "BlindHorizontal{" +
                "width=" + width +
                ", height=" + height +
                ", color=" + colorNumber +
                ", areaBlinds=" + areaBlinds +
                ", blindsCost=" + blindsCost +
                '}';
    }
}
