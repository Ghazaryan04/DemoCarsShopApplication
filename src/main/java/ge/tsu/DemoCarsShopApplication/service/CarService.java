package ge.tsu.DemoCarsShopApplication.service;

import ge.tsu.DemoCarsShopApplication.entiti.Car;
import ge.tsu.DemoCarsShopApplication.model.AddCar;
import ge.tsu.DemoCarsShopApplication.repository.CarRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Transactional(rollbackFor = Exception.class)
    public Car save(@Valid AddCar addCar, MultipartFile image) throws IOException {
        // Save image to filesystem
        Car car = new Car();
        car.setBrand(addCar.getBrand());
        car.setPrice(addCar.getPrice());
        car.setTransmission(addCar.getTransmission());
        car.setColor(addCar.getColor());
        car.setYear(addCar.getYear());
        carRepository.save(car);

        String imageFileName = UUID.randomUUID().toString() + ".jpg";
        Path imagePath = Path.of("C:/Users/lilit/Downloads/root-image/image");
        Files.write(imagePath.resolve(imageFileName), image.getBytes());

        car.setImgUrl("/image/"+imageFileName);
        return carRepository.save(car);
    }
}
