package com.SoleraBootcamp.PingPongAssesment.Services;


import com.SoleraBootcamp.PingPongAssesment.Model.Workshops;
import com.SoleraBootcamp.PingPongAssesment.Repository.WorkshopsRepository;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class WorkshopService {
    
    private final WorkshopsRepository workshopsRepository;


    public WorkshopService(WorkshopsRepository repository) {
        workshopsRepository = repository;
    }

    // Endpoint to create a new workshop
    public String createWorkshop(@Valid Workshops workShop) {
        workshopsRepository.save(workShop);
        return "The workshop with name " + workShop.getName() + " has been created successfully.";
    }
    
    // Endpoint to get a workshop by ID
    public String getWorkshop( Long Id){
        Optional<Workshops> optionalWorkshop = workshopsRepository.findById(Id);
        if(optionalWorkshop.isEmpty()){
            return Id + " is not found";
        } else {
            Workshops workshop = optionalWorkshop.get();
            return "Workshop = " + workshop.getName();
        }
    }

    //Endpoint to get all workshops
    public List<Workshops> getAllWorkshops() {
        return (List<Workshops>) workshopsRepository.findAll();
    }
    
    //Endpoint deleting a workshop
    public String deleteWorkshopById(Long Id){
        Workshops workshop = workshopsRepository.findById(Id).orElse(null);
        if(workshop == null) {
            return "Workshop with ID " + Id + " not found";
        } else {
            if(workshop.getVehicles().size() != 0) {
                // Clear the vehicles list to remove the relationship
                return "The workshop with id " + Id + " could not be deleted because it has associated vehicles.";
            } else {
                workshopsRepository.deleteById(Id);
                return "The workshop with id " + Id + " has been deleted";
            }
        }
    }

    //Endpoint to Edit a workshop
    public String editWorkshopById( Workshops workshop,Long Id) {
        Optional<Workshops> workshopExistent = workshopsRepository.findById(Id);
        if(workshopExistent.isEmpty()){
            return "ID: "+ Id + " not found";
        }else{
            Workshops workshopFinal =  workshopExistent.get();
            workshopFinal.setName(workshop.getName());
            workshopFinal.setDescription(workshop.getDescription());
            workshopsRepository.save(workshopFinal);
            return "ID: " + Id + " has been updated";
        }
    }
    
}




