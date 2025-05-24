package ge.tsu.DemoCarsShopApplication.controller;

import ge.tsu.DemoCarsShopApplication.entiti.Car;
import ge.tsu.DemoCarsShopApplication.model.AddCar;
import ge.tsu.DemoCarsShopApplication.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AddCarController {

    @Autowired
    private CarService carService;

    @GetMapping("/add")
    public String addCar(Model model) {
        model.addAttribute("addCar", new AddCar());
        return "/add";  // looks for templates/car/add.html
    }


    @PostMapping("/add")
    public String saveCar(@Valid @ModelAttribute("addCar") AddCar addCar,
                          BindingResult bindingResult,
                          @RequestParam("image") MultipartFile image) throws IOException {

        if (image.isEmpty()) {
            // Changed "imagePath" to "image" to match the request param field name
            bindingResult.addError(new FieldError("addCar", "image", "No image file selected"));
        }

        if (bindingResult.hasErrors()) {
            return "/add";  // return form view if errors
        }

        Car newCar = carService.save(addCar, image);

        return "redirect:/car/" + newCar.getId();
    }
}
