package com.SoleraBootcamp.PingPongAssesment.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SoleraBootcamp.PingPongAssesment.Model.Vehicles;
import com.SoleraBootcamp.PingPongAssesment.Repository.VehiclesRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class VehiclesController {

    private final VehiclesRepository vehiclesRepository;
    public VehiclesController(VehiclesRepository repository){
        vehiclesRepository = repository;
    }

    // Endpoint to create a new workshop
    @PostMapping("/vehicles")
    public String createVehicle(@RequestBody Vehicles vehicle) {
        vehiclesRepository.save(vehicle);
        return "The vehicle with the model " + vehicle.getModel() + " has been created";
    }
    
    //Endpoint to get a vehicle by ID
    @GetMapping("/vehicles/{id}")
    public Vehicles getVehicle(@PathVariable(value="id") Long Id) {
        Optional<Vehicles> optionalVehicle = vehiclesRepository.findById(Id);
        if(optionalVehicle.isEmpty()) {
            return null; // or throw an exception
        } else {
            Vehicles vehicle = optionalVehicle.get();
            return vehicle;
        }
    }

    //Endpoint to get all vehicles
    @GetMapping("/allvehicles")
    public List<Vehicles> getAllVehicles() {
        return (List<Vehicles>) vehiclesRepository.findAll();
    }

    //Endpoint to delete a vehicle by ID
    @DeleteMapping("/vehicles/{id}")
    public String deleteVehicleById(@PathVariable(value="id") Long Id) {
        vehiclesRepository.deleteById(Id);
        return "Vehicle with ID " + Id + " has been deleted";
    }

    //Endpoint to edit a vehicle by ID
    @PutMapping("/vehicles/{id}")
    public String updateVehicleById(@RequestBody Vehicles vehicleDetails, @PathVariable(value="id") Long Id) {
        Optional<Vehicles> optionalVehicle = vehiclesRepository.findById(Id);
        if(optionalVehicle.isEmpty()) {
            return "Vehicle with ID " + Id + " not found";
        } else {
            Vehicles vehicle = optionalVehicle.get();
            vehicle.setModel(vehicleDetails.getModel());
            vehicle.setBrand(vehicleDetails.getBrand());
            vehicle.setVehicleYear(vehicleDetails.getVehicleYear());
            vehicle.setColor(vehicleDetails.getColor());
            vehicle.setVin(vehicleDetails.getVin());
            vehiclesRepository.save(vehicle);
            return "Vehicle with ID " + Id + " has been updated";
        }
    }

}
