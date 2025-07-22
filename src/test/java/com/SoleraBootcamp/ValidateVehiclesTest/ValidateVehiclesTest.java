package com.SoleraBootcamp.ValidateVehiclesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.SoleraBootcamp.PingPongAssesment.Model.Parts;
import com.SoleraBootcamp.PingPongAssesment.Model.Vehicles;
import com.SoleraBootcamp.PingPongAssesment.Model.Workshops;



public class ValidateVehiclesTest {


    /*@ParameterizedTest
    @CsvFileSource(resources = "/vehiclesData.csv")
    @Test
    @DisplayName("Test vehicle creation")
    public void testCreateVehicle() {
        Vehicles vehicle = new Vehicles(1L, "Rav4", "Toyota", "2018", "Azul", "1HGBH41JXMN109186", new Workshops(1L, "Test", "Test", new ArrayList<Vehicles>()), new ArrayList<Parts>());
        ValidateVehicles validateVehicles = new ValidateVehicles();
        assertEquals("Rav4", validateVehicles.validateVehicleModel(vehicle));
    }*/

    @Test
    public void unoEsIgualAUno() {
        assertEquals(1, 1);
    }
}
