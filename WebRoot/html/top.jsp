<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>


<head>
<title>�ͻ���ϵ����ϵͳ</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body style="border-bottom:solid 1px #666;">

<TABLE style="width:100%;">
<TR >
	<td ><img src="images/logo.gif"></td>
	<td style="font-family:����;font-size:33px;font-weight:bold;"> �ͻ���ϵ����ϵͳ</td>	
	<td width="25%" align="right" style="font-size:12px;" valign="bottom">��ǰ�û���${users.suname }��${users.restricttable.rpoint}��&nbsp;&nbsp; <a href="javascript:history.go(-1)">�˳�ϵͳ</a> </td>
</tr>
</table>
</body>
</html>
