package com.action;

import com.DeleteFolder;
import com.ManageYaml;
import com.UZipFile;
import com.bean.ManageData;
import com.bean.UserData;
import com.biz.UserBiz;
import com.biz.UserBizImp;
import com.dao.UserDao;
import com.dao.UserDaoImp;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageAction extends ActionSupport {


    ManageData md;
    String uri = System.getProperty("user.dir");
    List<UserData> listuser;
    File uploadData; //�õ��ϴ����ļ�
    String uploadDataContentType; //�õ��ļ�������
    String uploadDataFileName; //�õ��ļ�������
    File uploadComp; //�õ��ϴ����ļ�
    String uploadCompContentType; //�õ��ļ�������
    String uploadCompFileName; //�õ��ļ�������

    public String getUploadDataContentType() {
        return uploadDataContentType;
    }

    public void setUploadDataContentType(String uploadDataContentType) {
        this.uploadDataContentType = uploadDataContentType;
    }

    public String getUploadDataFileName() {
        return uploadDataFileName;
    }

    public void setUploadDataFileName(String uploadDataFileName) {
        this.uploadDataFileName = uploadDataFileName;
    }

    public File getUploadComp() {
        return uploadComp;
    }

    public void setUploadComp(File uploadComp) {
        this.uploadComp = uploadComp;
    }

    public String getUploadCompContentType() {
        return uploadCompContentType;
    }

    public void setUploadCompContentType(String uploadCompContentType) {
        this.uploadCompContentType = uploadCompContentType;
    }

    public String getUploadCompFileName() {
        return uploadCompFileName;
    }

    public void setUploadCompFileName(String uploadCompFileName) {
        this.uploadCompFileName = uploadCompFileName;
    }

    public File getUploadData() {
        return uploadData;
    }


    public ManageData getMd() {
        return md;
    }

    public void setMd(ManageData md) {
        this.md = md;
    }


    public String exec() throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("subject", md.getSubject());
        map.put("time", md.getTime());
        map.put("QuestSubject", md.getQuestSubject());
        map.put("QuestObject", md.getQuestObject());
        Calendar cal=Calendar.getInstance();
        int h=cal.get(Calendar.HOUR_OF_DAY);
        int mi=cal.get(Calendar.MINUTE);
        mi = mi + Integer.parseInt(md.getTime());
        while(mi >= 60){
            mi = mi - 60;
            h = h + 1;
        }
        String endTime = h + ":" + mi ;
        map.put("endTime", endTime);
        Yaml yml = new Yaml();

        String dirPath = ServletActionContext.getServletContext().getRealPath("/conf");
//        File file = new File("..\\..\\conf\\MSetting.yml");
        File dir = new File(dirPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        String path = ServletActionContext.getServletContext().getRealPath("/conf/MSetting.yml");
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.newLine();
        yml.dump(map, buffer);
        buffer.close();
        writer.close();

        System.out.println("fileName:"+this.getUploadDataFileName());
        System.out.println("contentType:"+this.getUploadDataContentType());
        System.out.println("File:"+this.getUploadData());
        String xlsPath=ServletActionContext.getServletContext().getRealPath("/source/studata.xls");
        String zipPath=ServletActionContext.getServletContext().getRealPath("/source/problem.zip");
        String unzipPath=ServletActionContext.getServletContext().getRealPath("/problem/*");
        String unzipPath2=ServletActionContext.getServletContext().getRealPath("/problem");
        File uploadFile = new File(xlsPath);
        File uploadZip = new File(zipPath);
        File unZip = new File(unzipPath2);
        DeleteFolder df = new DeleteFolder();

        //���Դ˳���·������ʾ���ļ���Ŀ¼�Ƿ���ڡ��������ڣ������˳���·����ָ����Ŀ¼���������б��赫�����ڵĸ�Ŀ¼��
        if (this.getUploadData() == null || this.getUploadComp() == null){
            this.addFieldError("md.subject", "���ϴ��ļ�");
            return INPUT;
        }
        if(uploadFile.exists())
            uploadFile.delete();

        if(uploadZip.exists())
            uploadZip.delete();


        if(unZip.exists())
            df.deleteDirectory(unzipPath2);

        try {
            //�����ļ�
            FileUtils.copyFile(uploadData, uploadFile);
            FileUtils.copyFile(uploadComp, uploadZip);
        } catch (IOException e) {
            e.printStackTrace();
            this.addFieldError("md.subject", "�ļ��ϴ�ʧ��");
            return INPUT;
        }
        this.addFieldError("md.subject", "�ļ��ϴ��ɹ�");

        UZipFile uzip = new UZipFile();
        uzip.unZipFiles(zipPath,unzipPath);

        return SUCCESS;


//        File uploadFile = new File("..\\..\\source\\studata.xls");
//        if (uploadFile.exists()) {
//            uploadFile.delete();
//        }
//        if (!uploadFile.exists()){
//            try {
//                //�����ļ�
//                FileUtils.copyFile(uploadData, uploadFile);
//                this.addFieldError("md.subject", "�ļ��ϴ��ɹ�");
//                return SUCCESS;
//            } catch (IOException e) {
//                e.printStackTrace();
//                this.addFieldError("md.subject", "�ļ��ϴ�ʧ��");
//                return INPUT;
//            }
//        }
//        return INPUT;
    }

    public String setManageData() throws IOException {
        return this.exec();
    }

    public List<UserData> getListuser() {
        return listuser;
    }

    public void setListuser(List<UserData> listuser) {
        this.listuser = listuser;
    }


    public void setUploadData(File uploadData) {
        this.uploadData = uploadData;
    }
}
