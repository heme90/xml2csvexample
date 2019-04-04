<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "java.io.IOException,org.jsoup.Jsoup,org.jsoup.nodes.Document,org.jsoup.select.Elements" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Document doc 
= Jsoup.connect("https://news.naver.com/main/read.nhn?mode=LSD&mid=tvh&oid=056&aid=0010687189&sid1=293").get();

// 뉴스의 본문이 들어가는 id

Elements e = doc.select("#articleBodyContents");

/* e.filter();*/

String html = e.toString();
%>
<%=html %>
</body>
</html>