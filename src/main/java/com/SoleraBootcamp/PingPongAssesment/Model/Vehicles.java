package com.SoleraBootcamp.PingPongAssesment.Model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ManyToOne;

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
    private String model;
    private String brand;
    private String vehicleYear;
    private String color;
    private String vin;
    
    // Union desde vehiculos a un workshop
    @ManyToOne
    @JoinColumn(name = "WORKSHOP_ID", nullable = false)
    @JsonBackReference
    private Workshops workshop;

    //Union desde vehiculos a varias partes
    @ManyToMany
    @JoinTable(name = "vehicles_parts",
               joinColumns = @JoinColumn(name = "vehicle_id"),
               inverseJoinColumns = @JoinColumn(name = "part_id"))
    private List<Parts> parts;

}
