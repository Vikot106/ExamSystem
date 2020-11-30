package com.dao;

import com.bean.UserData;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    public Sheet getSheet() {
        try {
            String path = ServletActionContext.getServletContext().getRealPath("/source/studata.xls");
            File file = new File(path); // �����ļ�����
            Workbook wb = Workbook.getWorkbook(file); // ���ļ����л�ȡExcel����������WorkBook��
            Sheet sheet = wb.getSheet(0); // �ӹ�������ȡ��ҳ��Sheet��
            return sheet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getRows() {
        Sheet sheet = getSheet();
        return sheet.getRows();
    }

    public List<UserData> getAllUser() {
        // TODO Auto-generated method stub
        Sheet sheet = getSheet();
        UserData ud;
        List<UserData> listuser = new ArrayList<UserData>();
        for (int i = 1; i < sheet.getRows(); i++) { // ѭ����ӡExcel���е�����
            ud = new UserData();
            ud.setId(sheet.getCell(0, i).getContents());
            ud.setName(sheet.getCell(1, i).getContents());
            ud.setSId(sheet.getCell(2, i).getContents());
            ud.setUId(sheet.getCell(3, i).getContents());
            listuser.add(ud);
            //Cell cell = sheet.getCell(j, i);
            //System.out.printf(sheet.getCell(3, i).getContents());
        }
        return listuser;
    }
}
