package Rooms;

public enum BedroomType {
    SINGLE(1),
    DOUBLE(2);

    private int capacity;

    BedroomType( int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }


}
