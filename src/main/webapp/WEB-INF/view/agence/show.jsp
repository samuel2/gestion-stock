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
        <spring:url value="/agence/" var="agences" />
        <spring:url value="/agence/${agence.id}/delete" var="agenceDelete" />
        <spring:url value="/" var="accueil" />

        <h4>Code : ${agence.code}</h4>
        <h4>Intitule : ${agence.intitule}</h4>
        <h4>Region : ${agence.region}</h4>

        <form:form method="post" commandName="agence" action="${agenceDelete}">
            <form:hidden path="id" />
            <input type="submit" value="Delete" />
        </form:form>
        <hr />
        <a href="${accueil}">Accueil</a> &nbsp; &nbsp;
        <a href="${agences}">Liste des agences</a>
    </body>
</html>
