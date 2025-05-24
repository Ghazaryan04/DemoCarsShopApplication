package ge.tsu.DemoCarsShopApplication.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class ContactUs {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 15, message = "must be at least 2 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @NotBlank(message = "Message is required")
    @Size(min = 2, max = 100, message = "must be at least 2 characters")
    private String message;
}
