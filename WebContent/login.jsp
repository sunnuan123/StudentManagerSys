<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>学生选课系统</title>
		<style type="text/css">
			<!--
			body {
				margin-left: 0px;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
			}
			-->
		</style>
		<link href="css/css.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="147" background="images/top02.gif"><img src="images/top3.jpg" width="776" height="147" /></td>
			</tr>
		</table>
		<form action="servlet/AdminLogin" method="post">
			<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
				<tr>
					<td width="221">
						<table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
		
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
										<tr>
											<td align="center"><img src="images/ico13.gif" width="107" height="97" /></td>
										</tr>
										<tr>
											<td height="40" align="center">&nbsp;</td>
										</tr>
		
									</table>
								</td>
								<td><img src="images/line01.gif" width="5" height="292" /></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="31%" height="35" class="login-text02">用户名称：${msg}
									<br />
								</td>
								<td width="69%">
									<input name="name" type="text" size="30" />
								</td>
							</tr>
							<tr>
								<td height="35" class="login-text02">密　码：
									<br />
								</td>
								<td>
									<input name="pwd" type="password" size="30" />
								</td>
							</tr>
		
							<tr>
								<td height="35" class="login-text02">验证图片：
									<br />
								</td>
								<td><img src="images/pic05.gif" width="109" height="40" /> <a href="#" class="login-text03">看不清楚，换张图片</a></td>
							</tr>
							<tr>
								<td height="35" class="login-text02">请输入验证码：</td>
								<td>
									<input name="textfield3" type="text" size="30" />
								</td>
							</tr>
							<tr>
								<td colspan="2" height="35" class="login-text02">管理员登录 
									<input type="radio" name="role" value="admin" />&emsp;
									学生登录 
									<input type="radio" name="role" value="student" />&emsp;
									教师登录 
									<input type="radio" name="role" value="teacher" />&emsp;
								</td>
							</tr>
		
							<tr>
								<td height="35">&nbsp;</td>
								<td>
									<input name="Submit2" type="submit" class="right-button01" value="确认登陆" />
									<input name="Submit232" type="submit" class="right-button02" value="重 置" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>

</html>