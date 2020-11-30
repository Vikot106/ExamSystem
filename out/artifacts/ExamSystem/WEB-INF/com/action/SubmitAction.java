//package com.action;
//
//import com.ManageYaml;
//import com.bean.SubmitData;
//import com.bean.UserData;
//import com.opensymphony.xwork2.ActionSupport;
//import org.apache.struts2.ServletActionContext;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.ListIterator;
//
//public class SubmitAction extends ActionSupport {
//
//    public String getAnswer() {
//        return Answer;
//    }
//
//    public void setAnswer(String quest) {
//        content.add(quest);
//    }
//    public SubmitData getSa() {
//        return sa;
//    }
//
//    public void setSa(SubmitData sa) {
//        this.sa = sa;
//    }
//
//    public List<SubmitData> getContentS() {
//        return contentS;
//    }
//
//    public void setContentS(List<SubmitData> contentS) {
//        this.contentS = contentS;
//    }
//
//    List<SubmitData> contentS;
//    SubmitData sa;
//    ManageYaml my = new ManageYaml();
//    String Answer;
//
////    private List buildList(){
////        List list = new ArrayList();
////        for(int i=0; i<5; i ){
////            SubmitData sd = new SubmitData();
////            sd.setQNum(i);
////            p.setAge(20 i);
////            p.setName("pengbing" i);
////            list.add(p);
////        }
////        return list;
////    }
////https://blog.csdn.net/tiandiqing/article/details/83682683
//    public String UserSubmit() throws Exception {
//        List<String> answers = sa.getAnswers();
//        System.out.println(answers);
//        ListIterator<String> iterator = answers.listIterator();
////        String value[] = my.getManageYaml();
////        int QSubject = Integer.parseInt(value[2]);
////        int QObject = Integer.parseInt(value[3]);
////        String Name = "";
////        String SId = "";
////        String path = ServletActionContext.getServletContext().getRealPath("/upload/"+SId+"/"+Name+".txt");
////        File file = new File(path);
////        if(file.exists()){
////            file.delete();
////        }
////        if(!file.exists()){
////            file.createNewFile();
////        }
////        FileWriter writer = new FileWriter(file, true);
////        BufferedWriter buffer = new BufferedWriter(writer);
////        Iterator it = content.iterator();
////        while(it.hasNext()){
////            SubmitData sd = (SubmitData)it.next();
////            System.out.println("===============" + it.next());
////        }
////        for (int i = 1 ; i <= QSubject ; i++){
////
////        }
////        buffer.close();
//        return SUCCESS;
//    }
//
//
//
//    // 生成表单
////    public String execute() {
////        content = buildList();
////        return this.SUCCESS;
////    }
////
////    // 处理提交的表单
////    public String update(){
////        Iterator it = personList.iterator();
////        while(it.hasNext()){
////            Person p = (Person)it.next();
////            System.out.println("===============" p.getName());
////        }
////        return this.SUCCESS;
////    }
//
//
//
//}
