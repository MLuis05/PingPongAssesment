package com.SoleraBootcamp.PingPongAssesment.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SoleraBootcamp.PingPongAssesment.Model.Vehicles;
import com.SoleraBootcamp.PingPongAssesment.Repository.VehiclesRepository;
import com.SoleraBootcamp.PingPongAssesment.Services.VehiclesService;
import com.SoleraBootcamp.PingPongAssesment.Services.WorkshopService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api")
public class VehiclesController {

     private final VehiclesService vehiclesService;


    public VehiclesController(VehiclesService vehiclesService){
        this.vehiclesService = vehiclesService;
    }

    // Endpoint to create a new workshop
    @PostMapping("/vehicles")
    public String createVehicle(@RequestBody Vehicles vehicle) {
        return vehiclesService.createVehicle(vehicle);
    }
    
    //Endpoint to get a vehicle by ID
    @GetMapping("/vehicles/{id}")
    public Vehicles getVehicle(@PathVariable(value="id") Long Id) {
        return vehiclesService.getVehicle(Id);
    }

    //Endpoint to get all vehicles
    @GetMapping("/allvehicles")
    public List<Vehicles> getAllVehicles() {
        return vehiclesService.getAllVehicles();
    }

    //Endpoint to delete a vehicle by ID
    @DeleteMapping("/vehicles/{id}")
    public String deleteVehicleById(@PathVariable(value="id") Long Id) {
        return vehiclesService.deleteVehicleById(Id);

    }

    //Endpoint to edit a vehicle by ID
    @PutMapping("/vehicles/{id}")
    public String updateVehicleById(@RequestBody Vehicles vehicleDetails, @PathVariable(value="id") Long Id) {
                return vehiclesService.updateVehicleById(vehicleDetails, Id);
    }

}
