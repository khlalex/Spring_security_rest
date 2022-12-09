package security.service;

import security.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRoles();

    Role getRoleById(long id);

    void addRole( Role role);

    String getRoleName();
}
