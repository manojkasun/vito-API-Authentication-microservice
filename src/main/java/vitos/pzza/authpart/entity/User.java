package vitos.pzza.authpart.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @NotEmpty
    @Size(min = 2, message = "Your Name should have at least 2 characters")
    private String name;
    @NotEmpty
    @Size(min = 2, message = "Your Email should have at least 2 characters")
    @Email
    private String email;
    @NotEmpty
    @Size(min = 10, message = "Your phone should be valid one")
    private String phone;
    @NotEmpty
    @Size(min = 6, message = "Your password should have at least 6 characters")
    private String password;
    private String address;

}
