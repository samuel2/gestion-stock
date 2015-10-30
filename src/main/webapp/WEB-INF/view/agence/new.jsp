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

        <h3>New Agence</h3>

        <hr/>

        <spring:url value="/agence/create" var="save" />
        <spring:url value="/agence/" var="agences" />
        <spring:url value="/" var="accueil" />

        <form:form method="post" commandName="agence" action="${save}" htmlEscape="true" >
            <div>
                <label for="code">Code</label>
                <form:input id="code" path="code" />
                <form:errors path="code" />
            </div><br/>

            <div>
                <label for="intitule">Intitule</label>
                <form:input id="intitule" path="intitule" />
                <form:errors path="intitule" />
            </div><br/>

            <div>
                <label for="region">Region</label>
                <form:input id="region" path="region" />
                <form:errors path="region" />
            </div><br/>

            <div>
                <input type="submit" value="Save" />
            </div>
        </form:form>

        <hr />

        <a href="${accueil}">Accueil</a> &nbsp; &nbsp;
        <a href="${agences}">Liste des agences</a>

    </body>
</html>
