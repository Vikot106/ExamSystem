<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/21
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.net.*" pageEncoding="UTF-8" %>
<jsp:useBean id="Data" class="com.ManageYaml" scope="session"></jsp:useBean>
<%@taglib prefix="s" uri="/struts-tags" %>
<%!
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
%>
<html>
<head>
    <title>考试页面</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <style type="text/css">
        <!--
        .Top1 {
            background-color: #FFFFFF;
            height: 60px;
            width: 100%;
            background-image: url(images/cutbg1.jpg);
            background-repeat: repeat-x;
            margin: 0px;
            padding: 0px;
        }

        .Top2 ul {
            height: 50px;
            width: 1000px;
            background-color: #00FF99;
            background-position: center;
            margin: 0px;
            padding: 0px;
        }

        .Top2 {
            height: 1000px;
            width: 1000px;
            background-color: #FFFFFF;
            background-position: center;
            text-align: center;
            margin-right: auto;
            margin-left: auto;
            padding: 0px;
            margin-top: 40px;
            margin-bottom: 0px;
            border: 1px solid #CCCCCC;
        }

        .Top1 #Zi1 {
            font-size: 30px;
            font-family: "黑体";
            color: #FFCC33;
            font-weight: bold;
            background-position: center;
            text-align: center;
            border-top-style: none;
            border-right-style: none;
            border-bottom-style: none;
            border-left-style: none;
            vertical-align: middle;
            height: auto;
            width: auto;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
            margin-left: 0px;
            padding-top: 10px;
            padding-right: 0px;
            padding-bottom: 0px;
            padding-left: 0px;
        }

        .Top2 #ul2 {
            margin: 0px;
            height: 50px;
            width: 460px;
            text-align: right;
            line-height: 50px;
            float: right;
            padding-top: 20px;
            padding-right: 40px;
            padding-bottom: 0px;
            padding-left: 0px;
            border-top-width: 0px;
            border-right-width: 0px;
            border-bottom-width: 0px;
            border-left-width: 0px;
            border-top-style: none;
            border-right-style: none;
            border-bottom-style: none;
            border-left-style: none;
        }

        .Top2 #ul1 {
            margin: 0px;
            height: 50px;
            width: 460px;
            line-height: 50px;
            text-align: left;
            float: left;
            padding-top: 20px;
            padding-right: 0px;
            padding-bottom: 0px;
            padding-left: 40px;
            border-top-width: 0px;
            border-right-width: 0px;
            border-bottom-width: 0px;
            border-left-width: 0px;
            border-top-style: none;
            border-right-style: none;
            border-bottom-style: none;
            border-left-style: none;
        }

        -->
    </style>
</head>
<body bgcolor="#f0eef5">
<%!
    int ips[] = new int[100];
    int ans;
    int ipi = 0;
    String ipstring;
    int ipint;

%>
<%!
    public boolean exist(int no4) {
        for (int i = 0; i < ipi; i++) {
            if (ips[i] == no4)
                return true;
        }
        return false;
    }
%>
<%
    request.setCharacterEncoding("utf-8");
    //String name = Data.getName();
    String name = request.getParameter("ld.UName");
    String SId = null;
    Cookie cookie = null;
    if(SId==null){
        SId = request.getParameter("ld.SId");
        cookie = new Cookie("SId",SId);
        cookie.setMaxAge(1 * 24 * 60 * 60);
    }
    if(cookie!=null){
        SId = cookie.getValue();
    }
    session.setAttribute("SId",SId);
    String totalTime = null;
    int QSubject = 1;
    int QObject = 1;
    int Quest = 1;
    String[] value = Data.getManageYaml();
//    Data.setIP(getIpAddr(request));
    try {
        totalTime = value[1];
        QSubject = Integer.parseInt(value[2]);
        QObject = Integer.parseInt(value[3]);
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<%
    //得到按座位顺序排列的写着所有考生ip的一维数组
    String tpstr = getIpAddr(request);
    ipint = Integer.parseInt(Data.ipno4(tpstr));
    if (exist(ipint)) ipi++;
    System.out.println("getcount:" + Data.getCount());
    ans = ipint % Data.getCount();
    String downloadURL = request.getContextPath() + Data.getFile(ans);
    System.out.println(downloadURL);
%>
<div class="Top1">
    <ul id="Zi1">
        <div align="center">在线考试系统</div>
    </ul>
</div>
<div class="Top2">

    <div class="Top2" id="ul1">剩余时间：<%=totalTime%>分钟</div>
    <div class="Top2" id="ul2">姓名：<%=name%>
    </div>
    <%--        <s:textfield name="productName" value="%{#parameters.productName}"/></div>--%>
    <br><br><br><br><br><br><br>
    <%--    <input type = "button" value = " 下载1试题 " onclick = "window.location.href = '<%=downloadURL%>'">--%>
    <%--    <INPUT TYPE="button" value=" 下载试题 " onclick="location.href='<%=downloadURL%>'" />--%>
    <a href="<%=downloadURL%>"><img src="images/downloadICON.jpg"
                                    width="375" height="185" alt="download"/></a><br><br>
    <br>
    <div align="center">
        注意：考试结束后将自动提交已保存的答案。<br><br>
        答题卡：<br><br>
        <table border="2" width="100" align="center">
            <tr>
                <td>题号</td>
                <%--                <td>答案</td>--%>
            </tr>
            <%--            <tr>--%>
            <s:iterator value="countS" status="stat">
                <tr>
                    <td><s:property value="count"/></td>
                </tr>
            </s:iterator>
            <s:iterator value="countO" status="stat">
                <tr>
                    <td><s:property value="count"/></td>
                </tr>
            </s:iterator>
        </table>

        <table border="2" width="250" align="center">
            <tr>
                <td>输入答案</td>
            </tr>
            <tr>
                <s:form action="UserSubmitS" method="POST" name="UserSubmitS">
                    <s:iterator value="Answer" status="stat">
                        <s:textfield name="answer[%{#stat.index}].answer" value=" "/>
                    </s:iterator>
                    <s:submit value="保存答案"></s:submit>
                </s:form>
            </tr>
        </table>

        <table border="2" width="200" align="center">
            <tr>
                <td>已提交内容</td>
            </tr>
                <s:iterator value="Answer" status="stat">
                    <tr>
                        <td><s:property value="answer"/></td>
                    </tr>
                </s:iterator>
        </table>

        aaaa<%=QSubject%>
    </div>
    </li1></ul>
</div>


</body>
</html>
