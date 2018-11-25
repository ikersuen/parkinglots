public class ParkingBoy {

    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot){

    }

    public ParkingTicket park(Car car){
        ParkingTicket parkingTicket = new ParkingTicket(car);
        return  parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket){
        if ( (parkingTicket.getCar() == null)){
            this.lastErrorMessage = "Unrecognized parking ticket.";
            return null;
        }
        return parkingTicket.getCar();
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
