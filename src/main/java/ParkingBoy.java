public class ParkingBoy {

    private String lastErrorMessage;
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car){
        ParkingTicket parkingTicket = new ParkingTicket(car);
        if(this.parkingLot.park(car)){
            this.lastErrorMessage = null;
            return parkingTicket;
        }else {
            this.lastErrorMessage = "Not enough position.";
            return null;
        }
    }

    public Car fetch(ParkingTicket parkingTicket){
        if (parkingTicket == null){
            this.lastErrorMessage = "Please provide your parking ticket.";
            return null;
        }

        if ( (parkingTicket.getCar() == null)){
            this.lastErrorMessage = "Unrecognized parking ticket.";
            return null;
        }

        if ( parkingTicket.isUsed()){
            this.lastErrorMessage = "Unrecognized parking ticket.";
            return null;
        }
        parkingTicket.setUsed(true);
        return parkingTicket.getCar();
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
