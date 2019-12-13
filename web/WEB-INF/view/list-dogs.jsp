<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


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

<%@include file="/WEB-INF/view/includes/header.jsp"%>

<div id="container">
    <div id="content">
<security:authorize access="hasRole('USER')">
        <button class="add-button"
                onclick="window.location.href='${contextPath}/dogs/user/showAddDogForm';return false;">Add Dog
        </button>
</security:authorize>



        <form:form action="search" method="GET">
            Search dogs <input type="search" name="searchTerm"/>
            <input type="submit" value="Search" class="add-button"/>
        </form:form>



        <table>
    <tr>
        <th>Dog ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Breed</th>
        <th>Gender</th>
        <th>Price</th>
        <th>Declawed?</th>
        <th>Photo</th>
        <th>Action</th>
    </tr>
    <c:forEach var="tempDogs" items="${dogs}">
        <%--Update dog--%>

        <c:url var="updateLink" value="/dogs/admin/showUpdateDogForm">
            <c:param name="dogId" value="${tempDogs.dog_id}"/>
        </c:url>

        <!-- Delete dog  -->
        <c:url var="deleteLink" value="/dogs/admin/delete">
            <c:param name="dogId" value="${tempDogs.dog_id}"/>
        </c:url>

        <!-- Detail dog  -->
        <c:url var="detailLink" value="/dogs/showDogDetail">
            <c:param name="dogId" value="${tempDogs.dog_id}"/>
        </c:url>

        <tr>
            <td>${tempDogs.dog_id}</td>
            <td>${tempDogs.name}</td>
            <td>${tempDogs.age}</td>
            <td>${tempDogs.breed.breed}</td>
            <td>${tempDogs.gender.gender}</td>
            <td><fmt:setLocale value = "en_US"/>
                <fmt:formatNumber value = "${tempDogs.price}" type = "currency"/></td>
            <td>${tempDogs.declawed.declawed}</td>
            <td>
                <img height="100" width="auto" src="${pageContext.request.contextPath}/resources/img/${tempDogs.imgFile}"alt="${tempDogs.imgFile}">
            </td>
            <td>
                <!-- display the update link -->
                <a href="${detailLink}">Detail</a>
                <security:authorize access="hasRole('ADMIN')">
                <a href="${updateLink}">Update</a>
                </security:authorize>
                
                <security:authorize access="hasRole('ADMIN')">
                <a href="${deleteLink}"
                   onclick="if (!confirm('Are you sure?')) return false">Delete</a>
                </security:authorize>
            </td>

        </tr>
    </c:forEach>

</table>
    </div>
</div>

</body>
</html>
