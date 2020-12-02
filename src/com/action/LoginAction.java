package com.action;

import com.ManageYaml;
import com.bean.LoginData;
import com.bean.SubmitCount;
import com.bean.SubmitData;
import com.bean.UserData;
import com.biz.UserBiz;
import com.biz.UserBizImp;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
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
    SubmitData sd;
    List<SubmitCount> countS;
    List<SubmitCount> countO;
    List<SubmitData> Answer;
    ManageYaml my;

    public List<SubmitCount> getCountO() {
        return countO;
    }

    public void setCountO(List<SubmitCount> countO) {
        this.countO = countO;
    }

    public String UserSubmitS() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        //HttpSession session = request.getSession();
        String strCount;
        int count = 1;
        int nCount;
        String SId = "null";
        SId = request.getSession().getAttribute("SId").toString();
        System.out.println("qqqqqqqqqqqq  "+SId);
        String path = ServletActionContext.getServletContext().getRealPath("/upload/"+SId+".txt");
        String dirPath = ServletActionContext.getServletContext().getRealPath("/upload");
        String closeFlag = ServletActionContext.getServletContext().getRealPath("/source/closeFlag");
        File file = new File(path);
        File dir = new File(dirPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        if(file.exists()){
            file.delete();
        }
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(path);
        my = new ManageYaml();
        String[] value = my.getManageYaml();
        countS = SCount(Integer.parseInt(value[2]));
        countO = OCount(Integer.parseInt(value[3]));
//        Answer = initAnswer(Integer.parseInt(value[2]) + Integer.parseInt(value[3]));
        Iterator it = Answer.iterator();
//        ListIterator<SubmitData> iterator = Answer.listIterator();
        while (it.hasNext()) {
            SubmitData rssd = (SubmitData)it.next();
            if(count <= Integer.parseInt(value[2])){
                strCount = "------主观题 " + Integer.toString(count) + " 题------";
            }else{
                nCount = count - Integer.parseInt(value[2]);
                strCount = "------客观题 " + Integer.toString(nCount) + " 题------";
            }
            fw.write( strCount + '\n' + rssd.getAnswer() + '\n' + '\n');
            System.out.println("!!!!!!!!!!!!" + rssd.getAnswer());
            count++;
        }
        fw.flush();
        fw.close();

//        while(it.hasNext()){
//            SubmitCount p = (SubmitCount) it.next();
//            System.out.println("===============" + p.getCount());
//        }
        File flag = new File(closeFlag);
        if(flag.exists()){
            return INPUT;
        }
        return SUCCESS;
    }

    public List<SubmitCount> SCount(int count){
        List<SubmitCount> listS= new ArrayList<>();
        for(int i = 1 ; i <= count ; i++){
            sc = new SubmitCount();
            sc.setCount("主观题" + Integer.toString(i));
            listS.add(sc);
        }
        return listS;
    }

    public List<SubmitCount> OCount(int count){
        List<SubmitCount> listO= new ArrayList<>();
        for(int i = 1 ; i <= count ; i++){
            sc = new SubmitCount();
            sc.setCount("客观题" + Integer.toString(i));
            listO.add(sc);
        }
        return listO;
    }

    public List<SubmitData> getAnswer() {
        return Answer;
    }

    public void setAnswer(List<SubmitData> answer) {
        //System.out.println("----------setAnswer");
        Answer = answer;
    }

    public List<SubmitData> initAnswer(int count){
        System.out.println("-----------initAnswer");
        List<SubmitData> list= new ArrayList<>();
        for(int i = 1 ; i <= count ; i++){
            sd = new SubmitData();
            sd.setAnswer("未作答");
            list.add(sd);
        }
        return list;
    }

    public String UserLogin() {
        System.out.println("-------use UserLogin");
        my = new ManageYaml();
        String[] value = my.getManageYaml();
        countS = SCount(Integer.parseInt(value[2]));
        countO = OCount(Integer.parseInt(value[3]));
        Answer = initAnswer(Integer.parseInt(value[2]) + Integer.parseInt(value[3]));
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
            this.addFieldError("ld.UName", "登录信息有误，请重新输入");
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
