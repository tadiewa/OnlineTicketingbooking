/**
 * @author : tadiewa
 * date: 5/11/2023
 */


package com.tadiewa.userManagement.Service;

import com.tadiewa.userManagement.exeception.BadRequestException;
import com.tadiewa.userManagement.model.Uzar;
import com.tadiewa.userManagement.repository.UserRepository;
import com.tadiewa.userManagement.exeception.Error;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl {
    private final UserRepository repository;

    public List<Uzar> getAllUsers() {
        return repository.findAll();
    }

    public void saveUser(Uzar uzar) {
        Uzar user = repository.findByEmail(uzar.getEmail());
        if (Objects.nonNull(user)) {
            throw new BadRequestException(Error.USER_ALREADY_EXISTS.getErrorCode(),
                    Error.USER_ALREADY_EXISTS.getErrorMessage());
        }
        repository.save(uzar);
    }

   public Uzar findUserByID( String userId) {
       return repository.findUzarByAdminId(userId)
               .orElseThrow(() -> new BadRequestException(Error.USER_NOT_FOUND.getErrorCode(),
                        Error.USER_NOT_FOUND.getErrorMessage()));
    }

    public Uzar updateUserInfo(Uzar updateUserInfo) {
    Uzar userToUpdate =  findUserByID(updateUserInfo.getAdminId());
   return Uzar.builder()
            .adminId(updateUserInfo.getAdminId())
            .contactAddress(updateUserInfo.getContactAddress())
            .gender(updateUserInfo.getGender())
            .email(updateUserInfo.getEmail())
            .password(updateUserInfo.getPassword())
            .accessLevel(updateUserInfo.getAccessLevel())
            .firstName(updateUserInfo.getFirstName())
            .lastName(updateUserInfo.getLastName())
            .activeStatus(updateUserInfo.getActiveStatus())
            .build();
           // log.info("updated details {}",userToUpdate
    }
}
