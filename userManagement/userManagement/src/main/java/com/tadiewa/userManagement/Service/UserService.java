/**
 * @author : tadiewa
 * date: 5/11/2023
 */

package com.tadiewa.userManagement.Service;

import com.tadiewa.userManagement.model.Uzar;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void saveUser(Uzar uzar);
}
