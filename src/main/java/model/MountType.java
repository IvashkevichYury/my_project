package model;

public enum MountType {
    CEILING(1), WALL(2);

    private int numberMountType;

    MountType(int numberMountType) {
    }

    public static MountType getMountType(int number) {
        MountType[] mountTypes = MountType.values();
        return mountTypes[number - 1];
    }
}
