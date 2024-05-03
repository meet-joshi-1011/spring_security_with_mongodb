package io.javabrains.springsecurityjwt.service;

import io.javabrains.springsecurityjwt.dto.UserDTO;
import io.javabrains.springsecurityjwt.models.MyUserDetails;
import io.javabrains.springsecurityjwt.models.User;
import io.javabrains.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();
    }

    public Object createUserInDb(UserDTO userDto) {
        try {
            String userName = userDto.getUserName();
            if(!userRepository.findByUserName(userName).isPresent()) {
                User user = new User(userDto);
                return userRepository.save(user);
            }
            return "Already Exists";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
