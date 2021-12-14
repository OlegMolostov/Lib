<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html;charset=cp1251" %>

<%--<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>--%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${user.name}  </h2>

        <h4>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>


    </c:if>

</div>

<form id="BooksThatAreReadInfo"  action="/BooksThatAreReadInfo">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

   <h3>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a onclick="document.forms['BooksThatAreReadInfo'].submit()">BooksThatAreRead</a></h3>
</form>

<form id="FavoriteBooksInfo"  action="/FavoriteBooksInfo">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <h3>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a onclick="document.forms['FavoriteBooksInfo'].submit()">FavoriteBooks</a></h3>
</form>

<form id="ReadBookInfo"  action="/ReadBookInfo">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <h3>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a onclick="document.forms['ReadBookInfo'].submit()">ReadBook</a></h3>
</form>


<form id="WantToReadInfo"  action="/WantToReadInfo">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <h3>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a onclick="document.forms['WantToReadInfo'].submit()">WantToRead</a></h3>
</form>

<br/>
<br/>
<br/>
<div class="container">
<form action="/search" method="get" accept-charset="UTF-8">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    &emsp;  Title:<input type="search" name="title">
    Author:<input type="search" name="author"/>
    Genre:<input type="search" name="genre">
    <input type="submit" value="Search">
</form>

    <h2>Books</h2>
    <br>
    <table>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Genre</th>
        </tr>

        <c:forEach var="tit" items="${allTitle}" >

            <c:url  var="autInfo"  value="${contextPath}/autInfo" >
                <c:param  name="aut" value="${tit.author.authorId}"/>
            </c:url>

            <c:url  var="bookInfo"  value="${contextPath}/bookInfo" >
                <c:param  name="book" value="${tit.titleOfBookId}"/>
            </c:url>


            <tr>
                <td>

                        <%--                    <form id="bookInfo" method="POST" action="${contextPath}/bookInfo">--%>
                        <%--                        <input type="hidden" name="book" value="${tit.titleOfBookId}" />--%>

                        <%--                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
                        <%--                        <a onclick="document.forms['bookInfo'].submit()">${tit.title}&emsp;</a>&emsp;&emsp;--%>
                        <%--                    </form>--%>
                            <input type="text" value="${tit.title}"
                                   onclick="window.location.href='${bookInfo}'"/>
                            &emsp;&emsp;
                            &emsp;&emsp;

                </td>

                <td>

                        <%--                    <form id="autInfo" method="POST" action="${contextPath}/autInfo">--%>
                        <%--                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" class="form-control"/>--%>
                        <%--                        <input type="hidden" name="aut" value="${tit.author}"/>--%>

                        <%--                        <a onclick="document.forms['autInfo'].submit()"> ${tit.author.surname} ${tit.author.name.charAt(0)}.${tit.author.secondname.charAt(0)}.</a>&emsp;&emsp;--%>
                        <%--                    </form>--%>


<%--                          <a onclick="href=[${autInfo}].submit()"> ${tit.author.surname} ${tit.author.name.charAt(0)}.${tit.author.secondname.charAt(0)}.</a>&emsp;&emsp;--%>

                            <input type="text" value="${tit.author.surname} ${tit.author.name.charAt(0)}.${tit.author.secondname.charAt(0)}"
                                   onclick="window.location.href='${autInfo}'"/>
                            &emsp;&emsp;

                </td>
                <td>${tit.genre.typeGenre}</td>
            </tr>

        </c:forEach>
    </table>
<br/>
<br/>
<br/>
<br/>






</div>





<%--.............................................................--%>
<%--<head>--%>
<%--    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>--%>
<%--    <script type="text/javascript">--%>
<%--        google.charts.load("current", {packages:["corechart"]});--%>
<%--        google.charts.setOnLoadCallback(drawChart);--%>



<%--        function drawChart() {--%>

<%--            &lt;%&ndash;var data = google.visualization.arrayToDataTable([&ndash;%&gt;--%>
<%--            &lt;%&ndash;    ['Task', 'Hours per Day'],&ndash;%&gt;--%>
<%--            &lt;%&ndash;    ['FavoriteBooks',     ${cFavoriteBooks}],&ndash;%&gt;--%>
<%--            &lt;%&ndash;    ['ReadBook',      ${cReadBook}],&ndash;%&gt;--%>
<%--            &lt;%&ndash;    ['BooksThatAreRead',  ${cBooksThatAreRead}],&ndash;%&gt;--%>
<%--            &lt;%&ndash;    ['WantToRead', ${cWantToRead}],&ndash;%&gt;--%>
<%--            &lt;%&ndash;]); &ndash;%&gt;--%>

<%--           var data=new google.visualization.DataTable();--%>
<%--            data.addColumn('string', 'Sections');--%>
<%--            data.addColumn('number', 'Count');--%>

<%--            <c:forEach items="${genres}" var="sect" >--%>

<%--            data.addRow(['${sect.name}',${sect.count}]);--%>
<%--            </c:forEach>--%>




<%--            var options = {--%>
<%--                title: 'Genres',--%>
<%--                is3D: true,--%>
<%--            };--%>

<%--            var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));--%>
<%--            chart.draw(data, options);--%>
<%--        }--%>
<%--    </script>--%>
<%--</head>--%>
<%--<div id="piechart_3d" style="width: 900px; height: 500px;"></div>--%>


<%--////////////////////////////////////////////--%>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>