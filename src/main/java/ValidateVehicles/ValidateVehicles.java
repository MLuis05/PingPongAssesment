package ValidateVehicles;

import com.SoleraBootcamp.PingPongAssesment.Model.Vehicles;

public class ValidateVehicles {
    public String validateVehicleModel(Vehicles vehicle) {
        if (vehicle.getModel() == null || vehicle.getModel().trim().isEmpty()) {
            return "Vehicle model must not be empty";
        } else {
            return vehicle.getModel();
        }
    }

    public String validateVehicleBrand(Vehicles vehicle) {
        if (vehicle.getBrand() == null || vehicle.getBrand().trim().isEmpty()) {
            return "Vehicle brand must not be empty";
        } else {
            return vehicle.getBrand();
        }
    }

    public String validateVehicleYear(Vehicles vehicle) {
        if (vehicle.getVehicleYear() == null || vehicle.getVehicleYear().trim().isEmpty()) {
            return "Vehicle year must not be empty";
        } else {
            return vehicle.getVehicleYear();
        }
    }

    public String validateVehicleColor(Vehicles vehicle) {
        if (vehicle.getColor() == null || vehicle.getColor().trim().isEmpty()) {
            return "Vehicle color must not be empty";
        } else {
            return vehicle.getColor();
        }
    }

    public String validateVehicleVin(Vehicles vehicle) {
        if (vehicle.getVin() == null || vehicle.getVin().trim().isEmpty()) {
            return "Vehicle VIN must not be empty";
        } else {
            return vehicle.getVin();
        }
    }
}
