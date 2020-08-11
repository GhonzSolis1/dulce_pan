package com.dulcepan.security;

import com.dulcepan.dao.security.UserDao;
import com.dulcepan.entity.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.dulcepan.entity.security.User user =
                userDao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No Encuentra a usuario"));

        Set<GrantedAuthority> grantList = new HashSet<>();
        for (Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            grantList.add(grantedAuthority);
        }

        UserDetails userDetails = (UserDetails) new User(user.getUsername(), user.getPassword(), grantList);
        return userDetails;
    }
}

/*package com.pasteleria.security;

import com.pasteleria.entity.security.Role;
import com.pasteleria.repository.security.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.pasteleria.entity.security.User user =
                userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No Encuentra a usuario"));



        UserDetails userDetails = (UserDetails) userBuilder(user.getUsername(), user.getPassword(), user.getRoles());
        return userDetails;
    }

    private User userBuilder(String username, String password, Set<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        }
        return new User(username, password, true, true, true,
                true, authorities);
    }
}*/