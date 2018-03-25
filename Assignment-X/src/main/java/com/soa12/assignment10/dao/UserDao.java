package com.soa12.assignment10.dao;

import com.soa12.assignment10.model.UsersEntity;

public interface UserDao {

    public UsersEntity getUser(String email);

    public void save(UsersEntity user);

    public void update(UsersEntity user);

}
