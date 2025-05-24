
package ge.tsu.DemoCarsShopApplication.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCar {

    @NotBlank(message = "Brand is required")
    @Size(min = 2, max = 30, message = "Brand must be between 2 and 30 characters")
    private String brand;

    @NotNull(message = "Year is required")
    @Min(value = 1886, message = "Year must be no earlier than 1886")
    private Integer year;

    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must be at least 1")
    private Integer price;

    @NotBlank(message = "Transmission is required")
    @Size(min = 3, max = 20, message = "Transmission must be between 3 and 20 characters")
    private String transmission;

    @NotBlank(message = "Color is required")
    @Size(min = 3, max = 20, message = "Color must be between 3 and 20 characters")
    private String color;

    // Optional field for image path or name
    private String imagePath;
}
