package com.bootcamp.final_project.lib;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@WebServlet("/test")
public class Test extends HttpServlet {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get all cookies from the request
        Cookie[] cookies = request.getCookies();

        // If cookies exist, clear them
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setValue("");       // Set value to empty
                cookie.setPath("/");       // Match the common path (adjust if needed)
                cookie.setMaxAge(0);       // Expire immediately to delete
                response.addCookie(cookie); // Send to browser to clear it
            }
        }

        String key = getKey();
        System.out.println("Key=" + key);
    }


    public String getKey() {

        String url = "https://query1.finance.yahoo.com/v1/test/getcrumb";
        String key = this.restTemplate.getForObject(url, String.class);
        System.out.println("getKey=" + key);
        return key;
    }

    // Register the servlet in Spring Boot
    @Configuration
    public static class ServletConfig {
        @Bean
        public ServletRegistrationBean<Test> testServlet() {
            ServletRegistrationBean<Test> registrationBean = new ServletRegistrationBean<>(new Test(), "/test");
            return registrationBean;
        }
    }

}
