<%@page language="java" contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion-Stock</title>
    </head>
    <body>
        <spring:url value="/agence/update" var="edit" />
        <spring:url value="/agence/" var="agences" />
        <spring:url value="/" var="accueil" />


        <form:form commandName="agence" action="${edit}">
            <label>Code : </label>
            <form:input path="code" />
            <form:hidden path="id" />

            <label>Intitule : </label>
            <form:input path="intitule" />
            <form:hidden path="id" />

            <label>Region : </label>
            <form:input path="region" />
            <form:hidden path="id" />

            <input type="submit" value="Update" />
        </form:form>
        <hr />
        <a href="${accueil}">Accueil</a> &nbsp; &nbsp;
        <a href="${agences}">Liste des agences</a>
    </body>
</html>
