package javatest.com.example.JavaTest.service.impl;

import javatest.com.example.JavaTest.model.User;
import javatest.com.example.JavaTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    private final String userApiUrl = "https://jsonplaceholder.typicode.com/users/{id}";

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public User getUser(int userId) {
        return restTemplate.getForObject(userApiUrl, User.class, userId);
    }
}



