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
        <h3>update Service</h3>

        <spring:url value="/departement/" var="departements" />
        <spring:url value="departement/update" var="edit" />
        <spring:url value="/" var="accueil" />

        <form:form commandName="departement" action="${edit}">
            <div>
                <label for="code">Code : </label>
                <form:input path="code" />
                <form:hidden path="id" />
            </div> <br/>

            <div>
                <label for="intitule">Intitule : </label>
                <form:input path="intitule" />
            </div> <br/>

            <div>
                <label for="agence">Agence</label>
                <form:select id="agence" path="agence.id">
                    <form:option value="">${departement.agence.intitule}</form:option>
                    <form:options items="${listAgence}" />
                </form:select>
            </div><br/>

            <input type="submit" value="Update" />
        </form:form>
        <hr/>
        <a href="${accueil}">Accueil</a> &nbsp; &nbsp; &nbsp;
        <a href="${departements}">Liste des services</a>
    </body>
</html>
