<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <style><%@include file="/WEB-INF/css/add-dancer.css"%></style>
</head>
<body>

<%--@elvariable id="dancer" type=""--%>
<form:form id="forma" action="saveDancer" method="get" modelAttribute="dancer">
    Name <form:input class="fields" path="name"/>
    <br>
    Surname <form:input class="fields" path="surName"/>
    <br>
    Year of birth <form:input class="fields" path="year"/>
    <br>
    Dance club <form:input class="fields" path="danceClub"/>
    <br>
    <input type="submit" class="fields" value="Ok">
</form:form>
</body>
</html>