package com.action;

import com.ManageYaml;
import com.bean.SubmitData;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubmitAction extends ActionSupport {

    public String getQuest() {
        return Quest;
    }

    public void setQuest(String quest) {
        content.add(quest);
    }

    List content;

    ManageYaml my = new ManageYaml();
    String Quest;

    private List buildList(){
        List list = new ArrayList();
        for(int i=0; i<5; i ){
            SubmitData sd = new SubmitData();
            sd.setQNum(i);
            p.setAge(20 i);
            p.setName("pengbing" i);
            list.add(p);
        }
        return list;
    }
//https://blog.csdn.net/tiandiqing/article/details/83682683
    public String UserSubmit() throws Exception {
        String value[] = my.getManageYaml();
        int QSubject = Integer.parseInt(value[2]);
        int QObject = Integer.parseInt(value[3]);
        Iterator it = content.iterator();
        while(it.hasNext()){
            SubmitData sd = (SubmitData)it.next();
            System.out.println("===============" + it.next());
        }
        for (int i = 1 ; i <= QSubject ; i++){

        }
        return SUCCESS;
    }


    // 生成表单
    public String execute() {
        content = buildList();
        return this.SUCCESS;
    }

    // 处理提交的表单
    public String update(){
        Iterator it = personList.iterator();
        while(it.hasNext()){
            Person p = (Person)it.next();
            System.out.println("===============" p.getName());
        }
        return this.SUCCESS;
    }



}
