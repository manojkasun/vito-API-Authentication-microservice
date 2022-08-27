package vitos.pzza.authpart.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})

})
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String email;

    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    private AddressEntity address;

}
