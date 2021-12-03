package com.lib.mvc.service;

import com.lib.mvc.entity.Profile;


public interface UserService {

    void save(Profile user);

    Profile findByEmail(String username);
}