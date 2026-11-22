package com.example.demo.l10;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/l10/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarEntity> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public CarEntity createCar(@RequestBody CarEntity car) {
        return carService.createCar(car);
    }

    @GetMapping("/{id}")
    public CarEntity getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}
