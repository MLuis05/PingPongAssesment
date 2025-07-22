package com.SoleraBootcamp.ValidateVehiclesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.SoleraBootcamp.PingPongAssesment.Model.Parts;
import com.SoleraBootcamp.PingPongAssesment.Model.Vehicles;
import com.SoleraBootcamp.PingPongAssesment.Model.Workshops;

import ValidateVehicles.ValidateVehicles;

public class ValidateVehiclesTest {

    @Test
    @DisplayName("Test vehicle creation")
    public void testModelVehicle() {
        Vehicles vehicle = new Vehicles(1L, "Rav4", "Toyota", "2018", "Azul", "1HGBH41JXMN109186", new Workshops(1L, "Test", "Test", new ArrayList<Vehicles>()), new ArrayList<Parts>());
        ValidateVehicles validateVehicles = new ValidateVehicles();
        assertEquals("Rav4", validateVehicles.validateVehicleModel(vehicle));
    }

    @Test
    @DisplayName("Test vehicle creation")
    public void testBrandVehicle() {
        Vehicles vehicle = new Vehicles(1L, "Rav4", "Toyota", "2018", "Azul", "1HGBH41JXMN109186", new Workshops(1L, "Test", "Test", new ArrayList<Vehicles>()), new ArrayList<Parts>());
        ValidateVehicles validateVehicles = new ValidateVehicles();
        assertEquals("Toyota", validateVehicles.validateVehicleBrand(vehicle));
    }

    @Test
    @DisplayName("Test vehicle creation")
    public void testYearVehicle() {
        Vehicles vehicle = new Vehicles(1L, "Rav4", "Toyota", "2018", "Azul", "1HGBH41JXMN109186", new Workshops(1L, "Test", "Test", new ArrayList<Vehicles>()), new ArrayList<Parts>());
        ValidateVehicles validateVehicles = new ValidateVehicles();
        assertEquals("2018", validateVehicles.validateVehicleYear(vehicle));
    }

    @Test
    @DisplayName("Test vehicle creation")
    public void testColorVehicle() {
        Vehicles vehicle = new Vehicles(1L, "Rav4", "Toyota", "2018", "Azul", "1HGBH41JXMN109186", new Workshops(1L, "Test", "Test", new ArrayList<Vehicles>()), new ArrayList<Parts>());
        ValidateVehicles validateVehicles = new ValidateVehicles();
        assertEquals("Azul", validateVehicles.validateVehicleColor(vehicle));
    }

    @Test
    @DisplayName("Test vehicle creation")
    public void testVinVehicle() {
        Vehicles vehicle = new Vehicles(1L, "Rav4", "Toyota", "2018", "Azul", "1HGBH41JXMN109186", new Workshops(1L, "Test", "Test", new ArrayList<Vehicles>()), new ArrayList<Parts>());
        ValidateVehicles validateVehicles = new ValidateVehicles();
        assertEquals("1HGBH41JXMN109186", validateVehicles.validateVehicleVin(vehicle));
    }
}
