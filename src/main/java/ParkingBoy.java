public class ParkingBoy {

    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot){

    }

    public ParkingTicket park(Car car){
        ParkingTicket parkingTicket = new ParkingTicket(car);
        this.lastErrorMessage = null;
        return parkingTicket;
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
