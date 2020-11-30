<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/28
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.net.*" %>
<%!
    int ips[] = new int[100];int ans;
    int ipi=0;
    String ipstring;
    int ipint;
    public String ipno4(String ip){
        String[] str=ip.split("\\.");

        String rt = str[3];
        return rt;
    }
%>
<%!
    public boolean exist(int no4){
        for(int i=0;i<ipi;i++){
            if(ips[i]==no4)
                return true;
        }
        return false;
    }
%>
<%!public String getIpAddr(HttpServletRequest request) {
    String ip = request.getHeader("x-forwarded-for");
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("Proxy-Client-IP");
    }
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getRemoteAddr();
    }
    return ip;
}%>
<%
    //得到按座位顺序排列的写着所有考生ip的一维数组
    String tpstr=getIpAddr(request);
    ipint=Integer.parseInt(ipno4(tpstr));
    if(exist(ipint))ipi++;
    ans=ipint%3;
%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

ip:<%=ipstring%>
ipno4:<%=ipint%>
套题号:<%=ans%>
登入考试系统人数:<%=ipi%>
</body>
</html>
