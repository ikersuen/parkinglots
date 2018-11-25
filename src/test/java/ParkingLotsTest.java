import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

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

    //Story2 AC1
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

    //Story2 AC2
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

    //Story1 AC4
    @Test
    void should_not_fetch_any_car_once_ticket_has_been_used() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        //When
        ParkingTicket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        //Then
        assertNull(parkingBoy.fetch(ticket));
    }

    //Story2 AC1
    @Test
    void should_query_error_message_for_used_ticket() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        //When
        ParkingTicket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        parkingBoy.fetch(ticket);
        //Then
        assertEquals(
                "Unrecognized parking ticket.",
                parkingBoy.getLastErrorMessage()
        );
    }

    //Story1 AC5
    @Test
    void should_not_park_cars_to_parking_lot_if_there_is_not_enough_position() {
        final int capacity = 1;
        ParkingLot parkingLot = new ParkingLot(capacity);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        parkingBoy.park(new Car());

        assertNull(parkingBoy.park(new Car()));
    }

    //Story2 AC3
    @Test
    void should_get_message_if_there_is_not_enough_position() {
        final int capacity = 1;
        ParkingLot parkingLot = new ParkingLot(capacity);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        parkingBoy.park(new Car());
        parkingBoy.park(new Car());

        assertEquals("Not enough position.", parkingBoy.getLastErrorMessage());
    }

    //Story3
    @Test
    void should_parking_boy_park_sequentially(){
        //Given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(20);
        Car myCar = new Car();
        ParkingLots parkingBoyParkingLots = new ParkingLots();
        parkingBoyParkingLots.add(parkingLot1);
        parkingBoyParkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingBoyParkingLots);

        //When
        parkingBoy.park(myCar);

        //Then
        assertSame(myCar, parkingLot2.findCarInParkingLot(myCar));
        assertNull(parkingLot1.findCarInParkingLot(myCar));

    }

    //Story4
    @Test
    void should_smart_parking_boy_park_cars_to_more_empty_position_parking_lot() {
        //Given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(20);
        Car myCar = new Car();
        ParkingLots smartParkingBoyParkingLots = new ParkingLots();
        smartParkingBoyParkingLots.add(parkingLot1);
        smartParkingBoyParkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(smartParkingBoyParkingLots);

        //When
        smartParkingBoy.park(myCar);

        //Then
        assertSame(myCar, parkingLot2.findCarInParkingLot(myCar));
        assertNull(parkingLot1.findCarInParkingLot(myCar));
    }

    //Story4
    @Test
    void should_super_parking_boy_park_cars_to_more_empty_position_parking_lot() {
        //Given
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(20);
        Car myCar1 = new Car();
        Car myCar2 = new Car();
        ParkingLots superParkingBoyParkingLots = new ParkingLots();
        superParkingBoyParkingLots.add(parkingLot1);
        superParkingBoyParkingLots.add(parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(superParkingBoyParkingLots);
        //When
        superParkingBoy.park(myCar1);
        superParkingBoy.park(myCar2);

        //Then
        assertSame(myCar1, parkingLot1.findCarInParkingLot(myCar1));
        assertSame(myCar2, parkingLot2.findCarInParkingLot(myCar2));
        assertNull(parkingLot1.findCarInParkingLot(myCar2));
        assertNull(parkingLot2.findCarInParkingLot(myCar1));
    }

    //Story6 AC1
    @Test
    void should_manager_act_as_a_standard_parking_boy(){
        //Given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(20);
        Car myCar = new Car();
        ParkingLots managerParkingLots = new ParkingLots();
        managerParkingLots.add(parkingLot1);
        managerParkingLots.add(parkingLot2);
        ParkingManager manager = new ParkingManager(managerParkingLots);

        //When
        manager.park(myCar);

        //Then
        assertSame(myCar, parkingLot2.findCarInParkingLot(myCar));
        assertNull(parkingLot1.findCarInParkingLot(myCar));
    }

    //Story6 AC1
    @Test
    void should_manager_add_parking_boys_to_management_list(){
        //Given
        ParkingBoy parkingBoy1 = new ParkingBoy();
        SmartParkingBoy parkingBoy2 = new SmartParkingBoy();
        SuperParkingBoy parkingBoy3 = new SuperParkingBoy();
        ParkingManager manager = new ParkingManager();
        ParkingBoy parkingBoy4 = new ParkingBoy();

        //When
        manager.setManagementList(parkingBoy1);
        manager.setManagementList(parkingBoy2);
        manager.setManagementList(parkingBoy3);
        manager.setManagementList(manager);

        //Then
        assertSame(parkingBoy1, manager.findParkingBoyInManagementList(parkingBoy1));
        assertSame(parkingBoy2, manager.findParkingBoyInManagementList(parkingBoy2));
        assertSame(parkingBoy3, manager.findParkingBoyInManagementList(parkingBoy3));
        assertSame(manager, manager.findParkingBoyInManagementList(manager));
        assertNull(manager.findParkingBoyInManagementList(parkingBoy4));
    }
}