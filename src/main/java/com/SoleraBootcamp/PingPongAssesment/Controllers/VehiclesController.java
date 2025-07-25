package com.SoleraBootcamp.PingPongAssesment.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SoleraBootcamp.PingPongAssesment.Model.Vehicles;
import com.SoleraBootcamp.PingPongAssesment.Services.VehiclesService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
    ResponseEntity<String> createVehicle(@Valid @RequestBody Vehicles vehicle) {
        String result = vehiclesService.createVehicle(vehicle); 
        return ResponseEntity.status(201).body(result);
    }
    
    //Endpoint to get a vehicle by ID
    @GetMapping("/vehicles/{id}")
    ResponseEntity<Vehicles> getVehicle(@PathVariable(value="id") Long Id) {
        Vehicles result = vehiclesService.getVehicle(Id); 
        return ResponseEntity.status(200).body(result);
    }

    //Endpoint to get all vehicles
    @GetMapping("/allvehicles")
    public ResponseEntity<List<Vehicles>> getAllVehicles() {
        List<Vehicles> result = vehiclesService.getAllVehicles();
        return ResponseEntity.ok(result);
    }

    //Endpoint to delete a vehicle by ID
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<String> deleteVehicleById(@PathVariable(value="id") Long Id) {
        String result = vehiclesService.deleteVehicleById(Id); 
        return ResponseEntity.status(201).body(result);

    }

    //Endpoint to edit a vehicle by ID
    @PutMapping("/vehicles/{id}")
    public ResponseEntity<String> updateVehicleById(@RequestBody Vehicles vehicleDetails, @PathVariable(value="id") Long Id) {
        String result = vehiclesService.updateVehicleById(vehicleDetails, Id); 
        return ResponseEntity.status(200).body(result);
    }

}
