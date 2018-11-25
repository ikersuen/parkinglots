import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    private ParkingLots parkingLotsOwned;

    public SmartParkingBoy(ParkingLots parkingLots){
        this.parkingLotsOwned = parkingLots;
    }

    @Override
    public ParkingLot chooseParkingLot() {
        if (parkingLotsOwned.getSize() == 0) {
            return null;
        }
        ParkingLot chosenParkingLot = parkingLotsOwned.getFirstParkingLot();
        for(ParkingLot parkingLot: parkingLotsOwned.getParkingLotsOwned()) {
            if (parkingLot.getTotalVacancy() > chosenParkingLot.getTotalVacancy()) {
                chosenParkingLot = parkingLot;
            }
        }
        return chosenParkingLot;
    }
}