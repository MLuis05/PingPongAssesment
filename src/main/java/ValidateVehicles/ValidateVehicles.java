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
}
