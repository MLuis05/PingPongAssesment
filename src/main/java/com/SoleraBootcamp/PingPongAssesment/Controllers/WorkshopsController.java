package com.SoleraBootcamp.PingPongAssesment.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SoleraBootcamp.PingPongAssesment.Model.Workshops;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String createWorkshop(@Valid @RequestBody Workshops workShop) {
        return workshopService.createWorkshop(workShop);
    }
    
    // Endpoint to get a workshop by ID
    @GetMapping("/workshops/{id}")
    public String getWorkshop(@PathVariable(value="id") Long Id){
        return workshopService.getWorkshop(Id);
    }

    //Endpoint to get all workshops
    @GetMapping("/allworkshops")
    public List<Workshops> getAllWorkshops() {
        return workshopService.getAllWorkshops();
    }
    
    //Endpoint deleting a workshop
    @DeleteMapping("/workshops/{id}")
    public String deleteWorkshopById(@PathVariable(value="id") Long Id){
        return workshopService.deleteWorkshopById(Id);
    }

    //Endpoint to Edit a workshop
    @PutMapping("workshops/{id}")
    public String editWorkshopById(@RequestBody Workshops workshop, @PathVariable(value="id") Long Id) {
        return workshopService.editWorkshopById(workshop, Id);
    }
    
}
