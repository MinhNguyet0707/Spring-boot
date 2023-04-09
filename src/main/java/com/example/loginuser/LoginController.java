package com.example.loginuser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(org.springframework.ui.Model model) {
        model.addAttribute("loginForm", new User());
        return "login";
    }   

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("loginForm") User loginForm, org.springframework.ui.Model model) {
        if ("admin".equals(loginForm.getUsername()) && "admin".equals(loginForm.getPassword())) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Tài khoản hoặc mật khẩu không đúng.");
            return "login";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
