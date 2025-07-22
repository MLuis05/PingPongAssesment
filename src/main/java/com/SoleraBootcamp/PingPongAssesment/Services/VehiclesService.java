package com.SoleraBootcamp.PingPongAssesment.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SoleraBootcamp.PingPongAssesment.Model.Vehicles;
import com.SoleraBootcamp.PingPongAssesment.Repository.VehiclesRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@Service
public class VehiclesService {

    private final VehiclesRepository vehiclesRepository;



    public VehiclesService(VehiclesRepository repository){
        vehiclesRepository = repository;
    }

    // Endpoint to create a new vehicle
    public String createVehicle(@Valid @RequestBody Vehicles vehicle) {
        vehiclesRepository.save(vehicle);
        return "The vehicle with the model " + vehicle.getModel() + " has been created";
    }
    
    //Endpoint to get a vehicle by ID
    public Vehicles getVehicle(Long Id) {
        Optional<Vehicles> optionalVehicle = vehiclesRepository.findById(Id);
        if(optionalVehicle.isEmpty()) {
            return null; // or throw an exception
        } else {
            Vehicles vehicle = optionalVehicle.get();
            return vehicle;
        }
    }

    //Endpoint to get all vehicles
    public List<Vehicles> getAllVehicles() {
        return (List<Vehicles>) vehiclesRepository.findAll();
    }

    //Endpoint to delete a vehicle by ID
    public String deleteVehicleById(Long Id) {
        vehiclesRepository.deleteById(Id);
        return "Vehicle with ID " + Id + " has been deleted";
    }

    //Endpoint to edit a vehicle by ID
    public String updateVehicleById( Vehicles vehicleDetails,  Long Id) {
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
