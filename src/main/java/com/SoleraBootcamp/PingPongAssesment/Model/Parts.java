package com.SoleraBootcamp.PingPongAssesment.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partId;

    @NotBlank(message = "Add a part name, Example: 'name':'partName'")
    @Size(min = 4, max = 200, message = "Vehicle model must be between 4 and 200 characters")
    private String name;

    @NotBlank(message = "Add a part description, Example: 'description':'text'")
    private String description;

    @ManyToMany(targetEntity = Vehicles.class, mappedBy = "parts")
    @JsonIgnore
    private List<Vehicles> vehicles;
}
