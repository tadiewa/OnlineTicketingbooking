/**
 * @author : tadiewa
 * date: 5/11/2023
 */


package com.tadiewa.userManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Uzar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String adminId;
    String firstName;
    String lastName;
    String gender;
    String contactAddress;
    String email;
    String password;
    String accessLevel;
    Boolean activeStatus;
}
