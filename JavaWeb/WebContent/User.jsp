<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User page</title>
</head>
<body>
Welcome User!
<br>
<table border="1">
   <tr>
    <th>#</th>
    <th>login</th>
    <th>password</th>
   </tr>
  <c:forEach items="${list}" var="i">
    <h3>
     <tr> 
     <td> <c:out value="${list.indexOf(i)}"/></td>
    <td> <c:out value="${i.getLogin()}" /></td>
     <td><c:out value="${i.getPassword()}" /> </td>
     </tr>
    </h3>
  </c:forEach>
  </table>
</body>
</html>