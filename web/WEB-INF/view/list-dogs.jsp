<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <title>Dog Listings</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Dog Listings</h2>
    </div>
</div>
<div id="container">
    <div id="content">
    </div>
</div>
<table>
    <tr>
        <th>Dog ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Breed</th>
    </tr>
    <c:forEach var="tempDogs" items="${dogs}">
        <tr>
            <td>${tempDogs.dog_id}</td>
            <td>${tempDogs.name}</td>
            <td>${tempDogs.age}</td>
            <td>${tempDogs.breed}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
