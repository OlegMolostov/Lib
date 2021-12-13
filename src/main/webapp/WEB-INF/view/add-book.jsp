<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ page language="java" contentType="text/html;charset=cp1251"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Author</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>



        <form id="home"  action="${contextPath}/">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>


        <h2><a onclick="document.forms['home'].submit()">${user.name} </a></h2>

        <h4>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>

    </c:if>


</div>

<div class="container">
    <h2>${book.title}</h2>

    <c:url  var="autInfo"  value="${contextPath}/autInfo" >
        <c:param  name="aut" value="${book.author.authorId}"/>
    </c:url>

    <h4>
        <input type="submit" value="${book.author.surname} ${book.author.name} ${book.author.secondname}"
               onclick="window.location.href='${autInfo}'"/>
    </h4>
    <br>

    <form id="AddBook" method="POST" action="${contextPath}/addBook">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="hidden" name="book" value="${book.titleOfBookId}">



    Добавить в:
    <select name="section"  style="height: 25px; width: 160px; color: black">
        <option value="FavoriteBook">FavoriteBook</option>
        <option value="WantToReadBook" >WantToReadBook</option>
        <option value="ReadBook" >ReadBook</option>
        <option value="BooksThatAreRead" >BooksThatAreRead</option>
    </select>

   <input type="submit" value="Add">

    </form>
</div>






<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>