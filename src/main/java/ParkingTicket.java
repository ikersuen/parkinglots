public class ParkingTicket {
    private Car car;
    private boolean used;
    private ParkingLot parkingLot;

    public ParkingTicket(){

    }

    public ParkingTicket(Car car, ParkingLot parkingLot){
        this.car = car;
        this.used = false;
        this.parkingLot = parkingLot;
    }

    protected Car getCar() {
        return this.car;
    }

    public boolean isUsed(){
        return this.used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public ParkingLot getParkingLot() {
        return this.parkingLot;
    }

}
