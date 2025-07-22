package com.SoleraBootcamp.PingPongAssesment.Model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    @NotBlank(message = "Add a model, Example: 'model':'value'")
    @Size(min = 4, max = 200, message = "Vehicle model must be between 4 and 200 characters")
    private String model;

    @NotBlank(message = "Add a brand, Example: 'brand':'value'")
    @Size(min = 4, max = 200, message = "Vehicle brand must be between 4 and 200 characters")
    private String brand;

    @Size(min = 4, max = 4, message = "Vehicle year must be 4 characters")
    @NotBlank(message = "Add a vehicleYear, Example: 'vehicleYear':'YYYY'")
    private String vehicleYear;

    @NotBlank(message = "Add a color, Example: 'color':'colorName'")
    @Size(min = 3, max = 200, message = "Vehicle color must be between 3 and 200 characters")
    private String color;

    @NotBlank(message = "Add a vin, Example: 'vin':'colorName'")
    @Size(min = 17, max = 17, message = "VIN must be 17 characters")
    private String vin;
    
    // Union desde vehiculos a un workshop
    @ManyToOne
    @JoinColumn(name = "WORKSHOP_ID", nullable = false)
    @JsonBackReference
    @NotNull(message = "Add a workshop id (need to be created first), Example: 'workshop':{'whorkshop': '1'")
    private Workshops workshop;

    //Union desde vehiculos a varias partes
    @ManyToMany
    @JoinTable(name = "vehicles_parts",
               joinColumns = @JoinColumn(name = "vehicle_id"),
               inverseJoinColumns = @JoinColumn(name = "part_id"))
    private List<Parts> parts;

}
