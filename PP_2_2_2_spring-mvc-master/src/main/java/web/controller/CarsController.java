package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarServiceImpl;
import java.util.List;


@Controller
public class CarsController {

    CarServiceImpl carService;

    public CarsController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(defaultValue = "5", value = "count") Integer count, Model model) {
       List<Car> fin = carService.carList(count);
        model.addAttribute("cars", fin);
        return "cars";
    }

}