package ge.tsu.DemoCarsShopApplication.controller;

import ge.tsu.DemoCarsShopApplication.controller.comment.CommentForm;
import ge.tsu.DemoCarsShopApplication.entiti.Car;
import ge.tsu.DemoCarsShopApplication.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

@Controller
public class CarsController {

    @Autowired
    private CarRepository repository;

    // მთავარი გვერდი - index.html აჩვენებს ყველა მანქანას
    @GetMapping("/")
    public String index(Model model) {
        List<Car> carsList = repository.findAll(Sort.by("createdDate").descending());
        model.addAttribute("carsList", carsList);
        return "index";
    }

    // კონკრეტული მანქანის გვერდი მისი ID-ით
    @GetMapping("/car/{id}")
    public String car(@PathVariable Long id, Model model) {
        Optional<Car> car = repository.findById(id);
        if (car.isPresent()) {
            model.addAttribute("car", car.get());
            model.addAttribute("commentForm", new CommentForm(car.get().getId()));
            return "car/single";
        } else {
            return "error/404"; // თუ მანქანა არ არსებობს
        }
    }

    // დახმარებისათვის - ტესტური მეთოდი (სურვილისამებრ)
    @GetMapping("/stuff")
    @ResponseBody
    public Car stuff() {
        return repository.findByBrand("Audi").orElse(null);
    }

}
