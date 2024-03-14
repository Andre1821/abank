package com.enigma.abank.entity;

import com.enigma.abank.constant.Gender;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "m_nasabah")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Nasabah {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, unique = true, length = 40)
    private String email;

    @Column(name = "no_phone", nullable = false, unique = true, length = 30)
    private String noPhone;

    @Column(nullable = false, length = 100)
    private String address;
}
