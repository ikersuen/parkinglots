import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy {
    private List<ParkingBoy> managementList;

    public ParkingManager(){
        this.managementList = new ArrayList<>();
    }

    public ParkingManager(ParkingLots parkingLots){
        super(parkingLots);
        this.managementList = new ArrayList<>();
    }

    public void setManagementList(ParkingBoy parkingBoy){
        managementList.add(parkingBoy);
    }

    public ParkingBoy findParkingBoyInManagementList(ParkingBoy parkingBoy){
        int index = this.managementList.indexOf(parkingBoy);
        if (index >= 0) {
            return this.managementList.get(index);
        }else{
            return null;
        }
    }
}
