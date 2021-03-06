<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html;charset=cp1251"%>
<!DOCTYPE html>
<html>
<body>

<form:form action="/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Sign out">

</form:form>



Hello <b><c:out value="${pageContext.request.remoteUser}"/></b>

<h2>All titles</h2>
<br>
<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Genre</th>
    </tr>

    <c:forEach var="tit" items="${allTitle}">

        <c:url var="InfoAuthor" value="/authorAllTitle">
            <c:param  name="autId" value="${tit.author.authorId}"/>
        </c:url>
        <tr>
            <td>${tit.title}</td>
            <td>
                <input type="button" value="${tit.author.surname} ${tit.author.name} ${tit.author.secondname}"
            onclick="window.location.href='${InfoAuthor}'"/>

            </td>
            <td>${tit.genre.typeGenre}</td>
        </tr>

    </c:forEach>

</table>



</body>


</html>