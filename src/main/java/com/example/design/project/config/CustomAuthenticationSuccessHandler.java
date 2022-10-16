package com.example.design.project.config;

import com.example.design.project.service.serviceImplements.UserServiceImp;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private UserServiceImp userServiceImp;

    public CustomAuthenticationSuccessHandler(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

//        System.out.println("\n\nIn customAuthenticationSuccessHandler\n\n");
//
//        String userName = authentication.getName();
//
//        UserDto userDto = userServiceImp.findByUserName(userName);
//
//        HttpSession session = request.getSession();
//        session.setAttribute("user", userDto);
//
//        response.sendRedirect(request.getContextPath() + "/");


        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();

        for (GrantedAuthority g : authorities){
            roles.add(g.getAuthority());
        }
        if (roles.contains("ROLE_ADMIN")){
            response.sendRedirect("/admin");
        } else if (roles.contains("ROLE_USER")) {
                response.sendRedirect("/");
        }
    }
}
