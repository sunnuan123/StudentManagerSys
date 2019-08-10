<%@page import="com.rgzn.entity.Student"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jstlel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<%
    	//1.准备数据  
     	int n=70;//基本类型
     	double avgScore = 57.45678;//基本类型
     	//Student stu = null;
    	Student stu = new Student();//引用类型
    	stu.setSno("122121");
    	stu.setName("张晓红");
    	stu.setBirthday(Date.valueOf("1999-12-12"));
    	
    	String [] strs = {"Java","Oracle","JSP","HTML"};//数组
    	String courses="Java,Oracle,JSP,HTML,Servlet";//特殊的字符串
    	String courses2="Java#Oracle#JSP#HTML#Servlet";//特殊的字符串
    	String str = null;
    	String str3 = "";
     	List list = new ArrayList();//分配空间，没有元素
     	list.add(90);
     	list.add(80);
     	List list2 =null;//没有分配空间
     	List list3 =new ArrayList();//分配空间,没有元素  size()==0
     	Map<String,String> map = new HashMap<String,String>();//Map
     	map.put("cn", "China");
     	map.put("fr", "France");
		//setAttribute
		request.setAttribute("n",n);
		request.setAttribute("avgScore",avgScore);
    	request.setAttribute("stu",stu);
    	request.setAttribute("strs",strs);
    	request.setAttribute("courses",courses); 
    	request.setAttribute("courses2",courses2);  
    	request.setAttribute("now",new java.util.Date());     	
    	request.setAttribute("list", list);
    	request.setAttribute("list2", list2);  
    	request.setAttribute("list3", list3);    
        request.setAttribute("map", map);    	
    	 	
    	request.setAttribute("str", str);
    	request.setAttribute("str3", str3);
    	//2.使用JSTL和EL输出    	
    	 %>
    	
    	n:${n}<br/>
    	n:${requestScope.n}<br/>
    	n:<c:out value="${n}"></c:out><br/>
    	
    	分数：${avgScore}<br/>
    	<fmt:formatNumber value="${avgScore}" maxFractionDigits="2"></fmt:formatNumber><br/>
    	
    	姓名：${stu['name']}<br/>
    	<c:forEach items="${strs}" var="s" varStatus="sta">
    		${s}-->${sta.index}-->${sta.count}<br/>
    	</c:forEach>
  
    	<c:forTokens items="${courses2}" delims="#" var="s" varStatus="vs">
    		${s}<br/>
    	</c:forTokens>
    	
    	<fmt:formatDate value="${now}" pattern="yyyy年MM月dd日"/><br/>
		每页显示
		<select>
			<c:forEach  step="10" var="size" begin="10" end="60" >
				<option>${size}</option>
			</c:forEach>
		</select>
		 条
    	<br/>
    	<c:forEach items="${list}" var="li">
    		${li}<br/>
    	</c:forEach>
    	
    	<c:forEach items="${map}" var="map">
    		${map.key}-->${map.value}<br/>
    	</c:forEach>
    	<c:if test="${str != ' '}">
    		非空
    	</c:if>
    	<br/>
    	${not empty str }<br/>
    	${empty str3}<br/>
  		
  		
  		<c:choose>
  			<c:when test="${n>90}">
  				A
  			</c:when>
  			
  			<c:when test="${n>70}">
  				B
  			</c:when>
  			<c:when test="${n>60}">
  				C
  			</c:when>
  			<c:otherwise>
  				E
  			</c:otherwise>
  			
  		</c:choose>
  		
  		
  	
  </body>
</html>
