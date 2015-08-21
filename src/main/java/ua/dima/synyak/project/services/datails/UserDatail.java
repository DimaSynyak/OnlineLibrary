package ua.dima.synyak.project.services.datails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.dima.synyak.project.beans.person.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by root on 8/13/15.
 */
@Service
public class UserDatail implements UserDetailsService {
    @Autowired
    private UserService userService;


    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Person person = userService.getPerson(login);
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(person.getRole().name()));
        UserDetails userDetails = new User(person.getLogin(), person.getPassword(), roles);
        return userDetails;
    }


}
