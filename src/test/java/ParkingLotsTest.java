import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotsTest {
    @Test
    //Story1 AC1
    void should_parking_boy_park_a_car_and_get_back_the_same_car() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        //When
        ParkingTicket ticket = parkingBoy.park(car);
        Car fetched = parkingBoy.fetch(ticket);
        //Then
        assertSame(fetched, car);
    }

    @Test
    //Story1 AC2
    void should_parking_boy_park_multiple_cars(){
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        //When
        ParkingTicket car1Ticket = parkingBoy.park(car1);
        ParkingTicket car2Ticket = parkingBoy.park(car2);
        Car fetchedCar1Ticket = parkingBoy.fetch(car1Ticket);
        Car fetchedCar2Ticket = parkingBoy.fetch(car2Ticket);
        //Then
        assertSame(car1, fetchedCar1Ticket);
        assertSame(car2, fetchedCar2Ticket);
    }

}