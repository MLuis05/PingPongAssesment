package com.SoleraBootcamp.PingPongAssesment.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
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

import jakarta.validation.Valid;

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
    public ResponseEntity<String> createPart( @Valid @RequestBody Parts part, @RequestParam Long vehicleId) {
        String result = partsService.createPart(part, vehicleId); 
        return ResponseEntity.status(201).body(result);
    }
    
    // Endpoint to get a part by ID
    @GetMapping("/parts/{id}")
    public ResponseEntity<String> getPart(@PathVariable(value="id") Long Id){
        String result = partsService.getPart(Id); 
        return ResponseEntity.status(200).body(result);

    }

    //Endpoint to get all parts
    @GetMapping("/allparts")
    public ResponseEntity<List<Parts>> getAllParts() {
        List<Parts> result = partsService.getAllParts(); 
        return ResponseEntity.ok(result);

    }
    
    //Endpoint deleting a part
    @DeleteMapping("/parts/{id}")
    public ResponseEntity<String> deletePartById(@PathVariable(value="id") Long Id){
        String result = partsService.deletePartById(Id); 
        return ResponseEntity.status(200).body(result);
    }

    //Endpoint to Edit a part
    @PutMapping("parts/{id}")
    public ResponseEntity<String> editPartsById(@Valid @RequestBody Parts part, @PathVariable(value="id") Long Id) {
        String result = partsService.editPartsById(part, Id); 
        return ResponseEntity.status(200).body(result);
    }
}
