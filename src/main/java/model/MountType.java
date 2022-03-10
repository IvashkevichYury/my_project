package model;

public enum MountType {
    CEILING(1), WALL(2);

    private int number;

    MountType(int number) {
        this.number = number;
    }

    public static MountType getMountType(int number) {

        if (number == CEILING.number) {
            return CEILING;
        } else if (number == WALL.number) {
            return WALL;
        } else throw new IllegalArgumentException("mount type must be Ceiling (1) or Wall (2)!");

    }
}
