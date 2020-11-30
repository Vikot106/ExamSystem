package com.biz;

import com.bean.UserData;

import java.util.List;

public interface UserBiz {

    public List<UserData> getalluser();
    public int getRows();
    public String[] getManageYaml();
}