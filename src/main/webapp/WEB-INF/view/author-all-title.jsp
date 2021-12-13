<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h2>${author.surname} ${author.name} ${author.secondname}</h2>
    <br/>
    <h4>${author.shortBiography}</h4>
    <br/>
    <table>
        <tr>
            <th>Title</th>

            <th>Genre</th>
            <th></th>
        </tr>

        <c:forEach var="tit" items="${author.titleOfBookList}">

            <c:url  var="bookInfo"  value="${contextPath}/bookInfo" >
                <c:param  name="book" value="${tit.titleOfBookId}"/>
            </c:url>

            <tr>
                <td>
                    <input type="text" value="${tit.title}"
                           onclick="window.location.href='${bookInfo}'"/>
                    &emsp;&emsp;
                    &emsp;&emsp;</td>

                <td>${tit.genre.typeGenre}&emsp;</td>
            </tr>

        </c:forEach>

    </table>
</div>






<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>