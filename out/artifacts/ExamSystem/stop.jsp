<%@ page import="com.bean.ManageData" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/21
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<jsp:useBean id="Data" class="com.ManageYaml" scope="session"></jsp:useBean>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>考试结果</title>
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

<%
    request.setCharacterEncoding("utf-8");
    //String totalTime = request.getParameter("40");
    //String subject = request.getParameter("Java");
    int stuCount = Data.getRows() - 1;
    String []value = Data.getManageYaml();
    String subject = value[0];
%>

<div class="Top1"  >
    <ul id="Zi1">
        <div align="center">在线考试系统</div>
    </ul></div>
<div class="Top2">

    <div class="Top2" id="ul1">考试结束</div>
    <div class="Top2" id="ul2">考试科目：<%=subject%></div>
    <br><br><br><br><br><br>
    考试已结束，请有序离开考场！<br>
    </li1></ul>
</div>

</body>
</html>
