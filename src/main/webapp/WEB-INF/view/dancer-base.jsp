<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%--Подключение CSS--%>
    <style>
        <%@include file="/WEB-INF/css/dance-base-style.css" %>
    </style>
</head>
<body>
<H2>Dancers Base</H2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Year of birth</th>
        <th>Dance club</th>
    </tr>
    <c:forEach var="dancer" items="${dancers}">

        <c:url var="linkToUpdate" value="/updateDancer">
            <c:param name="dancer_id" value="${dancer.id}"/>
        </c:url>
        <c:url var="linkToDelete" value="/deleteDancer">
            <c:param name="dancer_id" value="${dancer.id}"/>
        </c:url>

        <tr>
            <td>${dancer.name}</td>
            <td>${dancer.surName}</td>
            <td>${dancer.year}</td>
            <td>${dancer.danceClub}</td>

            <td>
                <input type="button" value="Update" onclick="window.location.href='${linkToUpdate}'"/>
                <input type="button" value="Delete" onclick="window.location.href='${linkToDelete}'"/>
            </td>

        </tr>
    </c:forEach>
    <%--    <img src="/src/main/resources/fon.jpg" alt="Test Image">--%>
</table>
<br>
<input id="button" type="button" value="Add dancer" onclick="window.location.href='addDancer'"/>
</body>

</html>
