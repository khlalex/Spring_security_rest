package security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import security.model.User;
import security.service.RoleService;
import security.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/admin/admin";
    }

    @GetMapping(value = "/addUser")
    public String add(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("users",userService.getAllUsers());
        return "admin/add";
    }


    @PostMapping("/addUser")
    public String add(Model model, User user){
        userService.saveUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return  "redirect:/admin";
    }

    @GetMapping("/editUser/{id}")
    public String edit( Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("users",userService.getAllUsers());
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute User user, @PathVariable Long id){
        userService.updateUser(id,user);
        return "redirect:/admin";
    }


    @DeleteMapping("/delete/{id}")
    private String delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
