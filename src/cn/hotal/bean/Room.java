package cn.hotal.bean;

public class Room {
    private String id;
    private double price;
    private String roomType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}
