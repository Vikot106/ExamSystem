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
            File file = new File(path); // 创建文件对象
            Workbook wb = Workbook.getWorkbook(file); // 从文件流中获取Excel工作区对象（WorkBook）
            Sheet sheet = wb.getSheet(0); // 从工作区中取得页（Sheet）
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
        for (int i = 1; i < sheet.getRows(); i++) { // 循环打印Excel表中的内容
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
