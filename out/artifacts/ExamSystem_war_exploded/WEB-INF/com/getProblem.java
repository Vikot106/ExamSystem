package com;

import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class getProblem {

    public String getProblem(int ans) {
        int t = ans + 1;
        String name = Integer.toString(t);
        String file = "\\problem\\" + name + ".docx";
        return file;
    }

    public int getPCount() {
        String path = ServletActionContext.getServletContext().getRealPath("/problem/");
        int count = 0;
        for (File file : new File(path).listFiles())
            if (file.isFile()) ++count;
        System.out.println("Number of file(s): " + count);
        return count;
    }
}

//        int fileNum = 0;
//        File file = new File(path);
//        LinkedList<File> list = new LinkedList<>();
//
//        if (file.exists()) {
//            if (null == file.listFiles()) {
//                return 0;
//            }
//            list.addAll(Arrays.asList(file.listFiles()));
//            while (!list.isEmpty()) {
//                File[] files = list.removeFirst().listFiles();
//                if (null == files) {
//                    continue;
//                }
//                for (File f : files) {
//                    if (f.isDirectory()) {
//                        System.out.println("文件夹:" + f.getAbsolutePath());
//                        list.add(f);
//                    } else {
//                        System.out.println("文件:" + f.getAbsolutePath());
//                        fileNum++;
//                    }
//                }
//            }
//        } else {
//            System.out.println("文件不存在!");
//        }
//        System.out.println("文件数量:" + fileNum);
//        return fileNum;
//    }


//    public void saveIP(String ip){
//        String requestData = ip;
//        String Path = ServletActionContext.getServletContext().getRealPath("/source/ip.txt");
//        File file = new File(Path);
//        try {
//            if (file.exists()) {
//                file.delete();
//            }
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//
//            FileWriter fw = new FileWriter(Path);
//            fw.write(requestData + ",");
//            fw.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }

//    public String[] readIP(){
//        String filePath = ServletActionContext.getServletContext().getRealPath("/source/ip.txt");
//        List<String> list = new ArrayList<>();
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    new FileInputStream(filePath)));
//
//            for (String line = br.readLine(); line != null; line = br.readLine()) {
//                list.add(line);
//                System.out.println(line);
//            }
//            br.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

//    public String setIP(){
//        return ;
//    }
//}
