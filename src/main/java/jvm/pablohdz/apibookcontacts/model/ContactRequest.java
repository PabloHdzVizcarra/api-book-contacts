package jvm.pablohdz.apibookcontacts.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest
{
    @NotNull
    @Size(min = 3, max = 55, message = "the name must be greater than 3 characters and not null")
    private String username;

    @Pattern(
            regexp = "[0-9]{10}",
            message = "the phone number length must be equal to ten characters"
    )
    private String phoneNumber;

    @NotBlank(message = "the phone type cannot be null")
    private String phoneType;
}
