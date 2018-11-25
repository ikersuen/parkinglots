import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLots parkingLots){
        super(parkingLots);
    }

    @Override
    public ParkingLot chooseParkingLot() {
        ParkingLots parkingLotsOwned = super.getParkingLots();
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