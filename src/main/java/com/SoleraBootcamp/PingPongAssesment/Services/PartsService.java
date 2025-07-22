package com.SoleraBootcamp.PingPongAssesment.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SoleraBootcamp.PingPongAssesment.Model.Parts;
import com.SoleraBootcamp.PingPongAssesment.Model.Vehicles;
import com.SoleraBootcamp.PingPongAssesment.Repository.PartsRepository;
import com.SoleraBootcamp.PingPongAssesment.Repository.VehiclesRepository;

@Service
public class PartsService {

    private final PartsRepository partsRepository;
    private final VehiclesRepository vehiclesRepository;


    public PartsService(PartsRepository repository, VehiclesRepository vehiclesRepo){
        partsRepository = repository;
        vehiclesRepository = vehiclesRepo;
    }

    // Endpoint to create a new part
    public String createPart( Parts part, Long vehicleId) {
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
    public String getPart(Long Id){
        Optional<Parts> optionalPart = partsRepository.findById(Id);
        if(optionalPart.isEmpty()){
            return Id + " is not found";
        } else {
            Parts part = optionalPart.get();
            return "Part = " + part.getName();
        }
    }

    //Endpoint to get all parts
    public List<Parts> getAllParts() {
        return (List<Parts>) partsRepository.findAll();
    }
    
    //Endpoint deleting a part
    public String deletePartById(Long Id){
        Parts part = partsRepository.findById(Id).orElse(null);
        if(part == null) {
            return "Part with ID " + Id + " not found";
        } else {
            if(part.getVehicles().size() != 0) {
                // Clear the vehicles list to remove the relationship
                return "The part with id " + Id + " could not be deleted because it has associated vehicles.";
            } else {
                partsRepository.deleteById(Id);
                return "The part with id " + Id + " has been deleted";
            }
        }
    }

    //Endpoint to Edit a part
    public String editPartsById( Parts part,  Long Id) {
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
