<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion-Stock</title>
    </head>
    <body>
        <h3>Details Service</h3>

        <spring:url value="/departement/" var="departements" />
        <spring:url value="/departement/${departement.id}/delete" var="departementDelete" />
        <spring:url value="/" var="accueil" />

        <h4>Code : ${departement.code}</h4>
        <h4>Intitule : ${departement.intitule}</h4>
        <h4>Agence : ${departement.agence.intitule}</h4>

        <form:form method="post" commandName="departement" action="${departementDelete}">
            <form:hidden path="id" />
            <input type="submit" value="Delete" />
        </form:form>

        <hr/>

        <a href="${accueil}">Accueil</a>
        <a href="${departements}">Liste des Services</a>
    </body>
</html>
