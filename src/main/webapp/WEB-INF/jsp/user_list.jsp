<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Users</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="pageSize" value="3" />
<c:choose>
    <c:when test="${totalElements == pageSize}">
        <div class="pagination">
                <ul>
                    <c:forEach var="i" begin="1" end="${totalPages}">
                        <c:url var="pageUrl" value="/pages/${i}" />
                        <c:choose>
                            <c:when test="${i == pageNumber}">
                                <li class="active"><a href="#"><c:out value="${i}" /></a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="/user/user_list.html?pageSize=${pageSize}&pageNumber=${i}"><c:out value="${i}" /></a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </ul>
            </div>
    </c:when>
</c:choose>
    <table border=1>
        <thead>
            <tr>
                <th>User Id</th>
                <th>Pasword</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.password}" /></td>
                    <td><a href="UserController?action=edit&userId=<c:out value="${user.id}"/>">Update</a></td>
                    <td><a href="UserController?action=delete&userId=<c:out value="${user.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="UserController?action=insert">Add User</a></p>
</body>
</html>