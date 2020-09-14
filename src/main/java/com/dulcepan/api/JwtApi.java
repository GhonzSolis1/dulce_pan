package com.dulcepan.api;

import com.dulcepan.util.Jwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(JwtApi.JWT)
public class JwtApi {

    @Autowired
    private Jwt jwt;
    private static Logger LOG = LoggerFactory.getLogger(JwtApi.class);
    public static final String JWT = "/jwts";
    public static final String TOKEN = "/token";

    @PreAuthorize("authenticated")
    @PostMapping(value = TOKEN)
    public String login(@AuthenticationPrincipal User activeUser) {

        List<String> roleList = activeUser.getAuthorities().stream().map
                (GrantedAuthority::getAuthority).collect(Collectors.toList());
        System.out.println(roleList);
         return jwt.createToken(activeUser.getUsername(), roleList);
    }

    @GetMapping
    public void loginOk(){
        LOG.info("Login Ok");
    }

}
