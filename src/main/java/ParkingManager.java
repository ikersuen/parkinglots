import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy {
    private List<ParkingBoy> managementList;
    private String lastErrorMessage;

    public ParkingManager(){
        this.managementList = new ArrayList<>();
    }

    public ParkingManager(ParkingLots parkingLots){
        super(parkingLots);
        this.managementList = new ArrayList<>();
    }

    public String getLastErrorMessage(){
        return this.lastErrorMessage;
    }

    public void setManagementList(ParkingBoy parkingBoy){
        managementList.add(parkingBoy);
    }

    public ParkingTicket useParkingBoyToPark (ParkingBoy parkingBoy, Car car){
        ParkingTicket ticket =  parkingBoy.park(car);
        this.lastErrorMessage = parkingBoy.getLastErrorMessage();
        return ticket;
    }

    public Car useParkingBoyToFetch (ParkingBoy parkingBoy, ParkingTicket ticket){
        Car car =  parkingBoy.fetch(ticket);
        this.lastErrorMessage = parkingBoy.getLastErrorMessage();
        return car;
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
