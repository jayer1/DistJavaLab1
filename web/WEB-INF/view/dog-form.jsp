<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Add/Edit a Dog</title>
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/donut-form-style.css">
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/select-style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Add/Edit a Dog</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <form:form action="${contextPath}/dogs/save" enctype="multipart/form-data" modelAttribute="dog"
                   method="post">
            <form:hidden path="dog_id" value="${dog.dog_id}"/>
            <form:hidden path="imgFile" value="${dog.imgFile}"/>

            <table>
                <tr>
                    <td><label>Name</label></td>
                    <td><form:input path="name"/>
                        <form:errors path="name" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Age</label></td>
                    <td><form:input path="age"/>
                        <form:errors path="age" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Price</label></td>
                    <td><form:input path="price"/>
                        <form:errors path="price" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Breed</label></td>
                    <td>
                        <form:select path="breed" items="${breeds}" itemLabel="breed" itemValue="breedId"
                                     cssClass="select-css">
                        </form:select>
                        <form:errors path="breed" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td><label>Gender</label></td>
                    <td>
                        <form:select path="gender" items="${genders}" itemLabel="gender" itemValue="genderId"
                                     cssClass="select-css">
                        </form:select>
                        <form:errors path="gender" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td><label>Declawed?</label></td>
                    <td>
                        <form:select path="declawed" items="${declaweds}" itemLabel="declawed" itemValue="declawedId"
                                     cssClass="select-css">
                        </form:select>
                        <form:errors path="declawed" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td><label>Image</label></td>
                    <td>
                        <input type="file" name="image">
                        <c:if test="${dog.imgFile != null}">
                            <br/><br/>
                            <img src="${contextPath}/resources/img/${dog.imgFile}" alt="${dog.name}">
                            <br/>${dog.imgFile}
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save" class="save"></td>
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