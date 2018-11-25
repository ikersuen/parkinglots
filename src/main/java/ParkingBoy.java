import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private String lastErrorMessage;
    private ParkingLots parkingLots;

    public ParkingBoy(){

    }

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLots = new ParkingLots();
        this.parkingLots.add(parkingLot);
    }

    public ParkingBoy(ParkingLots parkingLots){
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car){
        ParkingLot chosenParkingLot = this.chooseParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket(car, chosenParkingLot);
        if(chosenParkingLot != null) {
            boolean parkingLotCanParkCar = chosenParkingLot.park(car);
            if (parkingLotCanParkCar) {
                this.lastErrorMessage = null;
                return parkingTicket;
            } else {
                this.lastErrorMessage = "Not enough position.";
                return null;
            }
        }else{
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

        ParkingLot parkingLot = parkingTicket.getParkingLot();
        parkingTicket.setUsed(true);
        return parkingLot.fetch(parkingTicket.getCar());
    }

    public ParkingLot chooseParkingLot() {
        if (this.parkingLots.getSize() == 0) {
            return null;
        }
        for (ParkingLot parkingLot : this.parkingLots.getParkingLotsOwned()) {
            if (parkingLot.getTotalVacancy() > 0){
                return parkingLot;
            }
        }
        return null;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
