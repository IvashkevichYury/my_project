package model;

public class BlindVertical {

    private int width;
    private int height;
    private int type;
    private String color;
    private String mountType;
    private double areaBlinds;
    private long blindsCost;

    public BlindVertical() {
    }

    public BlindVertical(int width, int height, int type, String mountType) {
        this.width = width;
        this.height = height;
        this.type = type;
        this.mountType = mountType;
    }

    public BlindVertical(int width, int height, int type, String color, String mountType) {
        this.width = width;
        this.height = height;
        this.type = type;
        this.color = color;
        this.mountType = mountType;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMountType() {
        return mountType;
    }

    public void setMountType(String mountType) {
        this.mountType = mountType;
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
        return "Vertical blind:" +
                "width=" + width +
                ", height=" + height +
                ", type=" + type +
                ", color=" + color +
                ", mountType=" + mountType;
    }
}
