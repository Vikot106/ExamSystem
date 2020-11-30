package com.dao;

import com.bean.UserData;

import java.util.List;

public interface UserDao {
    public List<UserData> getAllUser();
    public int getRows();

}