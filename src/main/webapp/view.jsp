<%@page import="userDto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <%
           User u = (User)request.getAttribute("user");
      %>
      
      <h1>User Details</h1>
      
      <table border = "2px">
      
      	<tr>
      		<th>ID</th>
      		<th>NAME</th>
      		<th>EMAIL</th>
      		<th>PHONE NUMBER</th>
      	</tr>
      	<tr>
         	<td><%= u.getId() %> </td>
      		<td><%= u.getName() %> </td>
      		<td><%= u.getEmail() %> </td>
            <td><%= u.getPhone() %> </td>
      	</tr>
     </table>
     
 </body>
 </html>