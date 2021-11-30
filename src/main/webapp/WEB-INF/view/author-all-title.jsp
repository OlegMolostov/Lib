<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=cp1251" %>
<!DOCTYPE html>
<html>
<body>

<h1>${author.surname} ${author.name} ${author.secondname}</h1>
<br>
<h4>${author.shortBiography}</h4>


<h2>All titles</h2>
<table>
    <tr>
        <th>Title</th>
        <th>Genre</th>
    </tr>

    <c:forEach var="allTitles" items="${authorAllTitles}">



    <tr>
        <td>${allTitles.title}</td>


        <td>${allTitles.genre.typeGenre}</td>
    </tr>

    </c:forEach>

</body>


</html>