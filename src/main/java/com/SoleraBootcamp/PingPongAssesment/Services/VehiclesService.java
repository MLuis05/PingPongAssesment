package com.SoleraBootcamp.PingPongAssesment.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SoleraBootcamp.PingPongAssesment.Model.Vehicles;
import com.SoleraBootcamp.PingPongAssesment.Repository.VehiclesRepository;
import com.SoleraBootcamp.PingPongAssesment.Repository.WorkshopsRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@Service
public class VehiclesService {

    private final VehiclesRepository vehiclesRepository;
    private final WorkshopsRepository workshopsRepository;

    public VehiclesService(VehiclesRepository vehiclesRepository, WorkshopsRepository workshopsRepository){
    this.vehiclesRepository = vehiclesRepository;
    this.workshopsRepository = workshopsRepository;
}

    // Endpoint to create a new vehicle
    public String createVehicle(@Valid @RequestBody Vehicles vehicle) {
        if (vehicle.getWorkshop() == null || vehicle.getWorkshop().getWorkshopId() == null){
            return "Workshop is requires and must have a valid ID";
        }

        // Buscar el workshop en la base de datos
        Optional<com.SoleraBootcamp.PingPongAssesment.Model.Workshops> optionalWorkshop = workshopsRepository.findById(vehicle.getWorkshop().getWorkshopId());
        if(optionalWorkshop.isEmpty()){
            return "Workshop with ID " + vehicle.getWorkshop().getWorkshopId() + " does not exist"; 
        }

        vehicle.setWorkshop(optionalWorkshop.get());
        vehiclesRepository.save(vehicle);

        return "The vehicle with the model " + vehicle.getModel()+ ", brand: " + vehicle.getBrand() + " has been created";
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
