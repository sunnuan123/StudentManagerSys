<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<style type="text/css">
			<!-- body {
				margin-left: 0px;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
			}
			.tabfont01 {
				font-family: "宋体";
				font-size: 9px;
				color: #555555;
				text-decoration: none;
				text-align: center;
			}
			.font051 {
				font-family: "宋体";
				font-size: 12px;
				color: #333333;
				text-decoration: none;
				line-height: 20px;
			}
			.font201 {
				font-family: "宋体";
				font-size: 12px;
				color: #FF0000;
				text-decoration: none;
			}
			.button {
				font-family: "宋体";
				font-size: 14px;
				height: 37px;
			}
			html {
				overflow-x: auto;
				overflow-y: auto;
				border: 0;
			}
			-->
		</style>

		<link href="css/css.css" rel="stylesheet" type="text/css" />
		<script type="text/JavaScript">

		</script>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<SCRIPT language=JavaScript>
		function sousuo() {
			window.open("gaojisousuo.htm", "", "depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
		}

		function selectAll() {
			var obj = document.fom.elements;
			for (var i = 0; i < obj.length; i++) {
				if (obj[i].name == "delid") {
					obj[i].checked = true;
				}
			}
		}

		function unselectAll() {
			var obj = document.fom.elements;
			for (var i = 0; i < obj.length; i++) {
				if (obj[i].name == "delid") {
					if (obj[i].checked == true) obj[i].checked = false;
					else obj[i].checked = true;
				}
			}
		}

		function link() {
			document.getElementById("fom").action = "yuangong.htm";
			document.getElementById("fom").submit();
		}
	</SCRIPT>

	<body>
		<form name="fom" id="fom" method="post" action="servlet/StudentServlet?method=addTsc">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="62" background="images/nav04.gif">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td height="40" class="font42">
												<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

													<tr>
														<td height="20" colspan="15" align="center" bgcolor="#EEEEEE" class="tablestyle_title" style="text-align: center;"> 以下课程可选 </td>
													</tr>
													<tr>
														<td width="6%" align="center" bgcolor="#EEEEEE">选择</td>
														<td width="9%" height="20" align="center" bgcolor="#EEEEEE">课程编号</td>${msg}
														<td width="9%" align="center" bgcolor="#EEEEEE">课程名称</td>
														<td width="9%" align="center" bgcolor="#EEEEEE">学分</td>
														<td width="9%" align="center" bgcolor="#EEEEEE">开课时间</td>
														<td width="10%" align="center" bgcolor="#EEEEEE">结课时间</td>
														<td width="4%" align="center" bgcolor="#EEEEEE">任课老师</td>
														<td width="10%" align="center" bgcolor="#EEEEEE">联系电话</td>
													</tr>
													<c:forEach items="${allCou}" var="cou">
													<tr>
														<td bgcolor="#FFFFFF"><input type="checkbox" name="delid" value="${cou.cno}#${cou.teacher.tno}"/></td>
														<td height="20" bgcolor="#FFFFFF"><a href="listyuangongmingxi.html">${cou.cno}</a></td>
														<td bgcolor="#FFFFFF"><a href="listyuangongmingxi.html">${cou.cname}</a></td>
														<td bgcolor="#FFFFFF">${cou.credit}</td>
														<td bgcolor="#FFFFFF">${cou.periodStart}</td>
														<td bgcolor="#FFFFFF">${cou.periodEnd}</td>
														<td height="20" bgcolor="#FFFFFF">${cou.teacher.tname }</td>
														<td height="20" bgcolor="#FFFFFF">${cou.teacher.tphone}</td>
													</tr>
													</c:forEach>
													
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					<tr>
						<td align="center" height="40px">
							<input type="submit" name="Submit" value="提交选中课程" class="button"/>　
						</td>
					</tr>
					</td>
				</tr>
			</table>
		</form>
	</body>

</html>