package com.ztx.springcloud;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

        @GetMapping("/getCurrentUser")
        public Object getCurrentUser(Authentication authentication) {
            return authentication.getPrincipal();
        }
}
