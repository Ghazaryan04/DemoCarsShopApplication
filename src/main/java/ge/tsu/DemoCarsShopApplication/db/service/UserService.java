package ge.tsu.DemoCarsShopApplication.db.service;

import ge.tsu.DemoCarsShopApplication.db.entity.Authority;
import ge.tsu.DemoCarsShopApplication.db.entity.User;
import ge.tsu.DemoCarsShopApplication.db.repository.AuthorityRepository;
import ge.tsu.DemoCarsShopApplication.db.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean existsUsername(String username) {
        return userRepository.existsById(username);
    }

    @Transactional
    public void register(String username, String rawPassword) {
        // Encrypt password
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // (1) First, save the user
        User newUser = new User(username, encodedPassword, true, null, null);
        userRepository.save(newUser);

        // (2) Then, save authority for that user
        Authority authority = new Authority(null, newUser, "ROLE_USER");
        authorityRepository.save(authority);

        newUser.setAuthorities(Set.of(authority));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
