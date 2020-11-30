package com.action;

import com.ManageYaml;
import com.bean.LoginData;
import com.bean.SubmitCount;
import com.bean.SubmitData;
import com.bean.UserData;
import com.biz.UserBiz;
import com.biz.UserBizImp;
import com.opensymphony.xwork2.ActionSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class LoginAction extends ActionSupport {

    public LoginData getLd() {
        return ld;
    }

    public void setLd(LoginData ld) {
        this.ld = ld;
    }

    public List<SubmitCount> getCountS() {
        return countS;
    }

    public void setCountS(List<SubmitCount> countS) {
        this.countS = countS;
    }

    LoginData ld;
    boolean flag = false;
    SubmitCount sc;
    List<SubmitCount> countS;
    List<SubmitCount> countO;
    ManageYaml my;

    public List<SubmitCount> SCount(int count){
        List<SubmitCount> list=new ArrayList<SubmitCount>();
        for(int i = 1 ; i <= count ; i++){
            sc = new SubmitCount();
            sc.setCount(Integer.toString(i));
            list.add(sc);
        }
        return list;
    }

    public String UserLogin() {
        my = new ManageYaml();
        String[] value = my.getManageYaml();
        countS = SCount(Integer.parseInt(value[2]));
        countO = SCount(Integer.parseInt(value[3]));
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
