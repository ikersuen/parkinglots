public class ParkingTicket {
    private Car car;
    private boolean used;

    public ParkingTicket(){

    }

    public ParkingTicket(Car car){
        this.car = car;
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

}
