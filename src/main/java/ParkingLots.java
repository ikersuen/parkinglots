import java.util.ArrayList;
import java.util.List;

public class ParkingLots {
    private List<ParkingLot> parkingLotsOwned;

    public ParkingLots(){
        this.parkingLotsOwned = new ArrayList<>();
    }

    public void add(ParkingLot parkingLot) {
        parkingLotsOwned.add(parkingLot);
    }

    public int getSize(){
        return parkingLotsOwned.size();
    }

    public ParkingLot getFirstParkingLot(){
        return parkingLotsOwned.get(0);
    }

    public List<ParkingLot> getParkingLotsOwned(){
        return this.parkingLotsOwned;
    }
}
