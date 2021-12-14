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

    <title>FavoriteBooks</title>

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

        <h3>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a onclick="document.forms['logoutForm'].submit()">Logout</a></h3>

    </c:if>

</div>

<div class="container">
    <h2>FavoriteBooks</h2>
    <br>
    <c:if test="${favoriteBooksList.size()==0}">
        <h5>Тут ещё ничего нет</h5>
    </c:if>
    <c:if test="${favoriteBooksList.size()>0}">
    <table>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Genre</th>
            <th></th>
        </tr>

        <c:forEach var="tit" items="${favoriteBooksList}">

            <c:url  var="bookInfo"  value="${contextPath}/bookInfo" >
                <c:param  name="book" value="${tit.titleOfBook.titleOfBookId}"/>
            </c:url>

            <c:url var="deleteButton" value="/deleteFavoriteBook">
            <c:param name="bookId" value="${tit.titleOfBook.titleOfBookId}"/>
            </c:url>

            <tr>
                <td>
                    <input type="text" value="${tit.titleOfBook.title}" onclick="window.location.href='${bookInfo}'"/>
                    &emsp;&emsp;
                    &emsp;&emsp;
                </td>
                <td>

                        ${tit.titleOfBook.author.surname} ${tit.titleOfBook.author.name.charAt(0)}.${tit.titleOfBook.author.secondname.charAt(0)}.&emsp;

                </td>
                <td>${tit.titleOfBook.genre.typeGenre}&emsp;&emsp;</td>
                <td>

                    <input type="button" value="Delete"
                           onclick="window.location.href='${deleteButton}'"/>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>



<%--.............................................................--%>
<head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load("current", {packages:["corechart"]});
        google.charts.setOnLoadCallback(drawChart);



        function drawChart() {

            <%--var data = google.visualization.arrayToDataTable([--%>
            <%--    ['Task', 'Hours per Day'],--%>
            <%--    ['FavoriteBooks',     ${cFavoriteBooks}],--%>
            <%--    ['ReadBook',      ${cReadBook}],--%>
            <%--    ['BooksThatAreRead',  ${cBooksThatAreRead}],--%>
            <%--    ['WantToRead', ${cWantToRead}],--%>
            <%--]); --%>

            var data=new google.visualization.DataTable();
            data.addColumn('string', 'Sections');
            data.addColumn('number', 'Count');

            <c:forEach items="${sections}" var="sect" >

            data.addRow(['${sect.name}',${sect.count}]);
            </c:forEach>




            var options = {
                title: '',
                is3D: true,
            };

            var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
            chart.draw(data, options);
        }
    </script>
</head>
<div id="piechart_3d" style="width: 900px; height: 500px;"></div>
</c:if>

<%--////////////////////////////////////////////--%>





<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>