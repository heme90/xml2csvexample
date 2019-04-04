<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menubar.jsp" flush="false" />

<h1>pagebody</h1>

<jsp:include page="calendar.jsp" flush="false" />
<jsp:include page="sidebar.jsp" flush="false" />
<jsp:include page="footer.jsp" flush="false" />


</body>
</html>