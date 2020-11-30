package com.biz;

import com.ManageYaml;
import com.bean.UserData;
import com.dao.UserDao;
import com.dao.UserDaoImp;

import javax.print.attribute.standard.MediaName;
import java.util.List;

public class UserBizImp implements UserBiz {

    UserDao ud = new UserDaoImp();
    ManageYaml my = new ManageYaml();
    
    @Override
    public List<UserData> getalluser() {
        // TODO Auto-generated method stub
        return ud.getAllUser();
    }

    public String[] getManageYaml(){
        return my.getManageYaml();
    }

    public int getRows(){
        return ud.getRows();
    }

}
