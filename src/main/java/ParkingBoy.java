public class ParkingBoy {

    private String lastErrorMessage;
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car){
        ParkingTicket parkingTicket = new ParkingTicket(car, this.parkingLot);
        if(this.parkingLot != null) {
            boolean parkingLotCanParkCar = this.parkingLot.park(car);
            if (parkingLotCanParkCar) {
                this.lastErrorMessage = null;
                return parkingTicket;
            } else {
                this.lastErrorMessage = "Not enough position.";
                return null;
            }
        }else{
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

        ParkingLot parkingLot = parkingTicket.getParkingLot();
        parkingTicket.setUsed(true);
        return parkingLot.fetch(parkingTicket.getCar());
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
