package br.com.samucadev.contacts_registration.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Nome")
    private String name;

    @Column(name = "Telefone")
    private String phoneNumber;

    @Column(name = "Endereço")
    private String address;
}
