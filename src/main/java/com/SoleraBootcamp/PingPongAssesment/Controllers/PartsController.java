package com.SoleraBootcamp.PingPongAssesment.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SoleraBootcamp.PingPongAssesment.Model.Parts;
import com.SoleraBootcamp.PingPongAssesment.Model.Vehicles;
import com.SoleraBootcamp.PingPongAssesment.Repository.PartsRepository;
import com.SoleraBootcamp.PingPongAssesment.Repository.VehiclesRepository;

@RestController
@RequestMapping("/api")
public class PartsController {

    private final PartsRepository partsRepository;
    private final VehiclesRepository vehiclesRepository;

    public PartsController(PartsRepository repository, VehiclesRepository vehiclesRepo){
        partsRepository = repository;
        vehiclesRepository = vehiclesRepo;
    }

    // Endpoint to create a new part
    @PostMapping("/parts")
    public String createPart(@RequestBody Parts part, @RequestParam Long vehicleId) {
        // Buscar el vehículo
        Optional<Vehicles> optionalVehicle = vehiclesRepository.findById(vehicleId);
        if(optionalVehicle.isEmpty()) {
            return "Vehicle with ID " + vehicleId + " not found";
        }

        Vehicles vehicle = optionalVehicle.get();
        
        // Inicializar listas si son null
        if(part.getVehicles() == null) {
            part.setVehicles(new ArrayList<>());
        }
        if(vehicle.getParts() == null) {
            vehicle.setParts(new ArrayList<>());
        }

        // Guardar la parte primero
        Parts savedPart = partsRepository.save(part);
        
        // Agregar la relación bidireccional
        vehicle.getParts().add(savedPart);
        savedPart.getVehicles().add(vehicle);
        
        // Guardar ambos
        vehiclesRepository.save(vehicle);
        partsRepository.save(savedPart);

        return "Part " + part.getName() + " created and assigned to vehicle ID " + vehicleId;
    }
    
    // Endpoint to get a part by ID
    @GetMapping("/parts/{id}")
    public String getPart(@PathVariable(value="id") Long Id){
        Optional<Parts> optionalPart = partsRepository.findById(Id);
        if(optionalPart.isEmpty()){
            return Id + " is not found";
        } else {
            Parts part = optionalPart.get();
            return "Part = " + part.getName();
        }
    }

    //Endpoint to get all parts
    @GetMapping("/allparts")
    public List<Parts> getAllParts() {
        return (List<Parts>) partsRepository.findAll();
    }
    
    //Endpoint deleting a part
    @DeleteMapping("/parts/{id}")
    public String deletePartById(@PathVariable(value="id") Long Id){
        partsRepository.deleteById(Id);
        return "The part with id " + Id + " has been deleted";
    }

    //Endpoint to Edit a part
    @PutMapping("parts/{id}")
    public String editPartsById(@RequestBody Parts part, @PathVariable(value="id") Long Id) {
        Optional<Parts> partExistent = partsRepository.findById(Id);
        if(partExistent.isEmpty()){
            return "ID: "+ Id + " not found";
        }else{
            Parts partFinal =  partExistent.get();
            partFinal.setName(part.getName());
            partFinal.setDescription(part.getDescription());
            partsRepository.save(partFinal);
            return "ID: " + Id + " has been updated";
        }
    }
}
