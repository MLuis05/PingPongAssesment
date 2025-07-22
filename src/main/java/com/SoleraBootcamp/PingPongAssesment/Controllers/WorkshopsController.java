package com.SoleraBootcamp.PingPongAssesment.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SoleraBootcamp.PingPongAssesment.Model.Workshops;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import com.SoleraBootcamp.PingPongAssesment.Services.WorkshopService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api")
public class WorkshopsController {
    
    private final WorkshopService workshopService;

    public WorkshopsController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    // Endpoint to create a new workshop
    @PostMapping("/workshops")
    ResponseEntity<String> createWorkshop(@Valid @RequestBody Workshops workShop) {
        String result = workshopService.createWorkshop(workShop); 
        return ResponseEntity.status(201).body(result);
    }
    
    
    // Endpoint to get a workshop by ID
    @GetMapping("/workshops/{id}")
    public ResponseEntity<String> getWorkshop(@PathVariable(value="id") Long Id){
        String result = workshopService.getWorkshop(Id); 
        return ResponseEntity.status(200).body(result);
    }

    //Endpoint to get all workshops
    @GetMapping("/allworkshops")
    public ResponseEntity<List<Workshops>> getAllWorkshops() {
        List<Workshops> result = workshopService.getAllWorkshops(); 
        return ResponseEntity.status(200).body(result);
    }
    
    //Endpoint deleting a workshop
    @DeleteMapping("/workshops/{id}")
    public ResponseEntity<String> deleteWorkshopById(@PathVariable(value="id") Long Id){
        String result = workshopService.deleteWorkshopById(Id); 
        return ResponseEntity.status(200).body(result);
    }

    //Endpoint to Edit a workshop
    @PutMapping("workshops/{id}")
    public ResponseEntity<String> editWorkshopById(@Valid @RequestBody Workshops workshop, @PathVariable(value="id") Long Id) {
        String result = workshopService.editWorkshopById(workshop, Id); 
        return ResponseEntity.status(200).body(result);
    }
    
}
