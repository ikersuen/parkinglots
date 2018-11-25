public class ParkingTicket {
    private Car car;

    public ParkingTicket(){

    }

    public ParkingTicket(Car car){
        this.car = car;
    }

    protected Car getCar() {
        return this.car;
    }
}
