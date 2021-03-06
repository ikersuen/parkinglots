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

    public Car findCarInParkingLot(Car car){
        int index = this.cars.indexOf(car);
        if (index >= 0) {
            return this.cars.get(index);
        }else{
            return null;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTotalVacancy() {
        return capacity - count;
    }

    public boolean park(Car car) {
        if (this.count == this.capacity){
            return false;
        }
        this.cars.add(car);
        this.count++;
        return true;
    }

    public Car fetch(Car car) {
        int index = this.cars.indexOf(car);
        if (index >= 0 ){
            Car carFetch = this.cars.remove(index);
            this.count--;
            return carFetch;
        }else{
            return null;
        }

    }
}
