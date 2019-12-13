<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Dog Detail</title>
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/donut-form-style.css">
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/select-style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Dog Detail</h2>
    </div>
</div>

<%@include file="/WEB-INF/view/includes/header.jsp"%>

<div id="container">

    <div id="content">

        <form:form action="${contextPath}/dogs/save" enctype="multipart/form-data" modelAttribute="dog"
                   method="post">
            <form:hidden path="dog_id" value="${dog.dog_id}"/>
            <form:hidden path="imgFile" value="${dog.imgFile}"/>

            <table>
                <tr>
                    <td><label>Name</label></td>
                    <td>${dog.name}</td>

                </tr>
                <tr>
                    <td><label>Age</label></td>
                    <td>${dog.age}</td>

                </tr>
                <tr>
                    <td><label>Price</label></td>
                    <td><fmt:setLocale value = "en_US"/>
                        <fmt:formatNumber value = "${dog.price}" type = "currency"/></td>

                </tr>
                <tr>
                    <td><label>Breed</label></td>
                    <td>${dog.breed.breed}</td>
                </tr>
                <tr>
                    <td><label>Gender</label></td>
                    <td>${dog.gender.gender}</td>
                </tr>
                <tr>
                    <td><label>Declawed?</label></td>
                    <td>${dog.declawed.declawed}</td>
                </tr>
                <tr>
                    <td><label>Image</label></td>
                    <td>
                        <c:if test="${dog.imgFile != null}">
                            <br/><br/>
                            <img height="200" width="auto" src="${contextPath}/resources/img/${dog.imgFile}" alt="${dog.name}">
                            <br/>${dog.imgFile}
                        </c:if>
                    </td>
                </tr>

            </table>
        </form:form>

        <div style="clear: both;">
            <p>
                <a href="${contextPath}/dogs/list">Back to List</a>
            </p>
        </div>

    </div>
</div>
</body>
</html>

