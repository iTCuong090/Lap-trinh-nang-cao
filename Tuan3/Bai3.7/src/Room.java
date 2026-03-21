public class Room {
    protected String roomId;
    protected long pricePerNight;
    protected int rentedNights;

    public Room(String roomId,long pricePerNight,int rentedNights) {
        this.roomId = roomId;
        this.pricePerNight = pricePerNight;
        this.rentedNights = rentedNights;
    }

    public double calculateFinalPrice() {
        return pricePerNight*rentedNights;
    }
}

class VipRoom extends Room {
    private static final long VIP_RENT_PRICE = 2000000;

    public VipRoom(String roomId,int rentedNights) {
        super(roomId, VIP_RENT_PRICE, rentedNights);
    }

}

class StandardRoom extends Room {
    private static final long STANDARD_RENT_PRICE = 500000;
    private static final double DISCOUNT = 0.05;

    public StandardRoom(String roomId,int rentedNights) {
        super(roomId, STANDARD_RENT_PRICE, rentedNights);
    }

    @Override
    public double calculateFinalPrice() {
        if (rentedNights > 3) {
            return pricePerNight*rentedNights*(1-DISCOUNT);
        }
        else {
            return pricePerNight*rentedNights;
        }
    }
}