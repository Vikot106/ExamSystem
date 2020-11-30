package com;

import com.action.LoginAction;
import com.dao.UserDao;
import com.dao.UserDaoImp;
import org.apache.struts2.ServletActionContext;
import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ManageYaml {

    UserDao ud = new UserDaoImp();
    LoginAction la = new LoginAction();
    getProblem gp = new getProblem();

    public String[] getManageYaml() {
        String[] value = new String[4];
        try {
            Yaml yml = new Yaml();
            String path = ServletActionContext.getServletContext().getRealPath("/conf/MSetting.yml");
//            FileReader reader = new FileReader("..\\..\\conf\\MSetting.yml");
            FileReader reader = new FileReader(path);
            BufferedReader buffer = new BufferedReader(reader);
            Map<String, Object> map = yml.load(buffer);
            value[0] = (String) map.get("subject");
            value[1] = (String) map.get("time");
            value[2] = (String) map.get("questSubject");
            value[3] = (String) map.get("questObject");
            buffer.close();
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return value;
    }

    public int getRows(){
        return ud.getRows();
    }

    public int getCount(){
        return gp.getPCount();
    }

    public String getFile(int ans){
        return gp.getProblem(ans);
    }

    public String ipno4(String ip){
        String[] str=ip.split("\\.");

        String rt = str[3];
        return rt;
    }

    public String getName(){
        return la.getName();
    }

    public String getSId(){
        return la.getSId();
    }

}
