import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int capacity;
    private List<Car> cars;
    private int count;

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.cars = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableParkingPosition() {
        return count - capacity;
    }

    public boolean park(Car car) {
        if (this.count == this.capacity){
            return false;
        }
        this.cars.add(car);
        this.count++;
        return true;
    }
}
