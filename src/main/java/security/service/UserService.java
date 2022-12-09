package security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import security.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    void saveUser(User user);

    boolean deleteUser(Long id);
    User getUserById(Long id);

    void updateUser(Long id, User user);
}
