package com.SoleraBootcamp.PingPongAssesment.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Workshops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workshopId;
    @NotBlank(message = "Name SHOULD be specified")
    private String name;
    @NotBlank(message = "A Description should be add.")
    private String description;

    @OneToMany(mappedBy = "workshop")
    @JsonManagedReference
    List<Vehicles> vehicles;
}
