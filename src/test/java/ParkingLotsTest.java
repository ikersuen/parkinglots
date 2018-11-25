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

    //Story1 AC3
    @Test
    void should_not_fetch_any_car_once_ticket_is_wrong() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket wrongTicket = new ParkingTicket();
        //When
        ParkingTicket ticket = parkingBoy.park(car);
        //Then
        assertNull(parkingBoy.fetch(wrongTicket));
        assertSame(car, parkingBoy.fetch(ticket));
    }

    //Story1 AC3
    @Test
    void should_query_message_once_the_ticket_is_wrong() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket wrongTicket = new ParkingTicket();
        //When
        parkingBoy.fetch(wrongTicket);
        String message = parkingBoy.getLastErrorMessage();
        //Then
        assertEquals("Unrecognized parking ticket.", message);
    }

    //Story1 AC3
    @Test
    void should_clear_the_message_once_the_operation_is_succeeded() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket wrongTicket = new ParkingTicket();
        //When
        parkingBoy.fetch(wrongTicket);
        assertNotNull(parkingBoy.getLastErrorMessage());
        //Then
        ParkingTicket ticket = parkingBoy.park(new Car());
        assertNotNull(ticket);
        assertNull(parkingBoy.getLastErrorMessage());
    }

    //Story1 AC3
    @Test
    void should_not_fetch_any_car_once_ticket_is_not_provided() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        //When
        ParkingTicket ticket = parkingBoy.park(car);
        //Then
        assertNull(parkingBoy.fetch(null));
        assertSame(car, parkingBoy.fetch(ticket));
    }

    //Story1 AC3
    @Test
    void should_query_message_once_ticket_is_not_provided() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //When
        parkingBoy.fetch(null);
        //Then
        assertEquals(
                "Please provide your parking ticket.",
                parkingBoy.getLastErrorMessage());
    }
}