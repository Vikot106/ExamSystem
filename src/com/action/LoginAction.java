package com.action;

import com.bean.LoginData;
import com.bean.UserData;
import com.biz.UserBiz;
import com.biz.UserBizImp;
import com.opensymphony.xwork2.ActionSupport;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

public class LoginAction extends ActionSupport {

    public LoginData getLd() {
        return ld;
    }

    public void setLd(LoginData ld) {
        this.ld = ld;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSId() {
        return SId;
    }

    public void setSId(String SId) {
        this.SId = SId;
    }

    LoginData ld;
    boolean flag = false;
    String Name;
    String SId;

    public String UserLogin() {
        this.Name = ld.getUName();
        this.SId = ld.getSId();
        String name = ld.getUName();
        String sid = ld.getSId();
        String uid = ld.getUId();
        UserBiz ub = new UserBizImp();
        List<UserData> listud = ub.getalluser();
        ListIterator<UserData> iterator = listud.listIterator();
        //UserData ud = null;
        if (ld.getUName().trim().equals("") || ld.getSId().trim().equals("") || ld.getUId().trim().equals("")) {
            this.addFieldError("ld.UName", "输入框不能为空，请检查输入");
            flag = true;
        }
        while (iterator.hasNext()) {
            UserData ud = iterator.next();
            String inputName = ud.getName();
            String inputSId = ud.getSId();
            String inputUId = ud.getUId();
            System.out.println("Value is : " + iterator.nextIndex() + "aaa" + ud.getName() + "\n" + name + ld.getUName());
            if (name.equals(inputName)) {
                if (sid.equals(inputSId) && uid.equals(inputUId)) {
                    System.out.println("PASS");
                    this.flag = true;
                    return SUCCESS;
                } else {
                    System.out.println("nPASS1");
                }
            } else {
                System.out.println("nPASS2");
            }
        }
        if (!flag) {
            this.addFieldError("ld.UName", "帐号或密码有误，请重新输入");
        }
        System.out.println("nPASS3");
        return INPUT;
    }

//    @Override
//    public void validate() {
//        super.validate();
//        if (ld.getUName().trim().equals("")) {
//            this.addFieldError("ld.UName", "账号不能为空");
//        }
//
//        if (ld.getSId().trim().equals("")) {
//            this.addFieldError("ld.SId", "学号不能为空");
//        }
//        if (ld.getUId().trim().equals("")) {
//            this.addFieldError("ld.UId", "身份证号不能为空");
//        }
//        if (!flag) {
//            this.addFieldError("ld.UName", "帐号或密码有误，请重新输入");
//        }
//    }

}
