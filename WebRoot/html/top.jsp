<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>


<head>
<title>客户关系管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body style="border-bottom:solid 1px #666;">

<TABLE style="width:100%;">
<TR >
	<td ><img src="images/logo.gif"></td>
	<td style="font-family:黑体;font-size:33px;font-weight:bold;"> 客户关系管理系统</td>	
	<td width="25%" align="right" style="font-size:12px;" valign="bottom">当前用户：${users.suname }（${users.restricttable.rpoint}）&nbsp;&nbsp; <a href="javascript:history.go(-1)">退出系统</a> </td>
</tr>
</table>
</body>
</html>
