package com.example.demo.l10;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    public CarEntity createCar(CarEntity car) {
        return carRepository.save(car);
    }

    public CarEntity getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car with id " + id + " not found"));
    }

    public CarEntity updateCar(Long id, CarEntity newCarData) {
        CarEntity existingCar = getCarById(id);

        existingCar.setBrand(newCarData.getBrand());
        existingCar.setModel(newCarData.getModel());
        existingCar.setPrice(newCarData.getPrice());

        return carRepository.save(existingCar);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}

