package com.SoleraBootcamp.PingPongAssesment.Controllers;

import java.util.List;
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
import com.SoleraBootcamp.PingPongAssesment.Services.PartsService;
import com.SoleraBootcamp.PingPongAssesment.Services.VehiclesService;

@RestController
@RequestMapping("/api")
public class PartsController {

    private final VehiclesService vehiclesService;
    private final PartsService partsService;


    public PartsController(PartsService partsService, VehiclesService vehiclesService){
        this.partsService = partsService;
        this.vehiclesService = vehiclesService;
    }

    // Endpoint to create a new part
    @PostMapping("/parts")
    public String createPart(@RequestBody Parts part, @RequestParam Long vehicleId) {
        return partsService.createPart(part, vehicleId);
    }
    
    // Endpoint to get a part by ID
    @GetMapping("/parts/{id}")
    public String getPart(@PathVariable(value="id") Long Id){
        return partsService.getPart(Id);

    }

    //Endpoint to get all parts
    @GetMapping("/allparts")
    public List<Parts> getAllParts() {
        return partsService.getAllParts();

    }
    
    //Endpoint deleting a part
    @DeleteMapping("/parts/{id}")
    public String deletePartById(@PathVariable(value="id") Long Id){
        return partsService.deletePartById(Id);
    }

    //Endpoint to Edit a part
    @PutMapping("parts/{id}")
    public String editPartsById(@RequestBody Parts part, @PathVariable(value="id") Long Id) {
        return partsService.editPartsById(part, Id);
    }
}
