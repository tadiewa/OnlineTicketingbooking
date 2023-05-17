/**
 * @author : tadiewa
 * date: 5/11/2023
 */


package com.tadiewa.userManagement.repository;

import com.tadiewa.userManagement.model.Uzar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Uzar, Integer> {
    Uzar findByEmail(String email);
    Optional<Uzar> findByLastName(String lastname);
    Optional<Uzar> findUzarByAdminId(String adminId);

}
