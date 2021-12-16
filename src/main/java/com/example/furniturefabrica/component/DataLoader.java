package com.example.furniturefabrica.component;

import com.example.furniturefabrica.entity.Role;
import com.example.furniturefabrica.entity.User;
import com.example.furniturefabrica.entity.enums.Permission;
import com.example.furniturefabrica.repositories.RoleRepository;
import com.example.furniturefabrica.repositories.UserRepository;
import com.example.furniturefabrica.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Value("${spring.sql.init.mode}")
    String initMode;

    @Override
    public void run(String... args) throws Exception {


        if (initMode.equals("always")) {
            Permission[] values = Permission.values();
            Role admin = roleRepository.save(new Role(
                    Constants.ADMIN,
                    "Hamma narsa qoshish huquqiga ega",
                    Arrays.asList(values)
            ));
            Role director = roleRepository.save(new Role(
                    Constants.DIRECTOR,
                    "Mijoz",
                    Arrays.asList(ADD_COMMENT, DELETE_MYCOMMENT, EDIT_COMMENT)
            ));
            Role cordinator = roleRepository.save(new Role(
                    Constants.COORDINATOR,
                    "Mijoz",
                    Arrays.asList(ADD_COMMENT, DELETE_MYCOMMENT, EDIT_COMMENT)
            ));
            userRepository.save(new User(
                    "muhammadqodir",
                    "Xolmurodiv",
                    "+998990674236",
                    "muhammadqodir",
                    passwordEncoder.encode("1007"),
                    admin,
                    true
            ));
        }
    }
}
