package com.SoleraBootcamp.PingPongAssesment.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SoleraBootcamp.PingPongAssesment.Model.Workshops;
import com.SoleraBootcamp.PingPongAssesment.Repository.WorkshopsRepository;

import java.util.List;
import java.util.Optional;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService.Work;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api")
public class WorkshopsController {

    private final WorkshopsRepository workshopsRepository;

    public WorkshopsController(WorkshopsRepository repository) {
        workshopsRepository = repository;
    }

    // Endpoint to create a new workshop
    @PostMapping("/workshops")
    public String createWorkshop(@RequestBody Workshops workShop) {
        workshopsRepository.save(workShop);
        return "The workshop with name " + workShop.getName() + " has been created successfully.";
    }
    
    // Endpoint to get a workshop by ID
    @GetMapping("/workshops/{id}")
    public String getWorkshop(@PathVariable(value="id") Long Id){
        Optional<Workshops> optionalWorkshop = workshopsRepository.findById(Id);
        if(optionalWorkshop.isEmpty()){
            return Id + " is not found";
        } else {
            Workshops workshop = optionalWorkshop.get();
            return "Workshop = " + workshop.getName();
        }
    }

    //Endpoint to get all workshops
    @GetMapping("/allworkshops")
    public List<Workshops> getAllWorkshops() {
        return (List<Workshops>) workshopsRepository.findAll();
    }
    
    //Endpoint deleting a workshop
    @DeleteMapping("/workshops/{id}")
    public String deleteWorkshopById(@PathVariable(value="id") Long Id){
        workshopsRepository.deleteById(Id);
        return "The workshop with id " + Id + " has been deleted";
    }

    //Endpoint to Edit a workshop
    @PutMapping("workshops/{id}")
    public String editWorkshopById(@RequestBody Workshops workshop, @PathVariable(value="id") Long Id) {
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
