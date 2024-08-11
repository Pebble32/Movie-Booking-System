package com.adam.movie_ticket.repositories.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String username;

    private Integer age;
    private String address;

    private String mobileNo;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TicketEntity> ticketEntityList;

    private String password;

    private String roles;

}
