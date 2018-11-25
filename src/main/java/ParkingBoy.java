public class ParkingBoy {
    public ParkingBoy(ParkingLot parkingLot){

    }

    public ParkingTicket park(Car car){
        ParkingTicket parkingTicket = new ParkingTicket(car);
        return  parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket){
        return parkingTicket.getCar();
    }
}
