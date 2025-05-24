package ge.tsu.DemoCarsShopApplication.repository;

import ge.tsu.DemoCarsShopApplication.entiti.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository
public interface CarRepository extends JpaRepository <Car,Long>{


Optional<Car> findByBrand(String brand);

//    static {
//        cars.add(new Car(1L, "Toyota", 2015, 9500, "Automatic", "White", "/image/car1.jpg"));
//        cars.add(new Car(2L, "BMW", 2018, 18000, "Manual", "Black", "/image/car2.jpg"));
//        cars.add(new Car(3L, "Mercedes", 2020, 25000, "Automatic", "Silver", "/image/car3.jpg"));
//        cars.add(new Car(4L, "Honda", 2016, 9800, "Manual", "Blue", "/image/car4.jpg"));
//        cars.add(new Car(5L, "Ford", 2014, 8700, "Automatic", "Red", "/image/car5.jpg"));
//        cars.add(new Car(6L, "Hyundai", 2019, 11000, "Automatic", "Gray", "/image/car6.jpg"));
//        cars.add(new Car(7L, "Kia", 2021, 12000, "Manual", "Green", "/image/car7.jpg"));
//        cars.add(new Car(8L, "Audi", 2017, 22000, "Automatic", "White", "/image/car8.jpg"));
//        cars.add(new Car(9L, "Chevrolet", 2013, 7200, "Manual", "Black", "/image/car9.jpg"));
//        cars.add(new Car(10L, "Nissan", 2015, 8900, "Automatic", "Brown", "/image/car10.jpg"));
//        cars.add(new Car(11L, "Volkswagen", 2018, 13000, "Manual", "Blue", "/image/car11.jpg"));
//        cars.add(new Car(12L, "Mazda", 2020, 15000, "Automatic", "Red", "/image/car12.jpg"));
//        cars.add(new Car(13L, "Subaru", 2016, 9900, "Manual", "White", "/image/car13.jpg"));
//        cars.add(new Car(14L, "Renault", 2019, 8700, "Automatic", "Yellow", "/image/car14.jpg"));
//        cars.add(new Car(15L, "Peugeot", 2017, 8100, "Manual", "Gray", "/image/car15.jpg"));
//    }

//    public Car save(AddCar addCar, String imagePath) {
//        Car car = new Car();
//        car.setId((long) (cars.size() + 1));
//        car.setBrand(addCar.getBrand());
//        car.setYear(addCar.getYear());
//        car.setPrice(addCar.getPrice());
//        car.setTransmission(addCar.getTransmission());
//        car.setColor(addCar.getColor());
//        car.setImagePath(imagePath);
//        cars.add(car);
//        return car;
//    }
//
//    public Car getById(Long id) {
//        return cars.stream()
//                .filter(c -> c.getId().equals(id))
//                .findFirst()
//                .orElseThrow();
//    }
//
//    public List<Car> getAll() {
//        return new ArrayList<>(cars);
//    }
}
