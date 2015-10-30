<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <h3>New Service</h3>

        <hr/>

        <spring:url value="/departement/create" var="save" />
        <spring:url value="/departement/" var="departements" />
        <spring:url value="/" var="accueil" />

        <c:if test="${not empty error}">
            ${error}
        </c:if>

        <form:form method="post" commandName="departement" action="${save}">
            <div>
                <label for="code">Code</label>
                <form:input id="code" path="code" />
            </div> <br/>

            <div>
                <label for="intitule">Intitule</label>
                <form:input id="intitule" path="intitule" />
            </div> <br/>

            <div>
                <label for="agence">Agence</label>
                <form:select id="agence" path="agence.id">
                    <form:option value="NONE">--- SELECT ---</form:option>
                    <form:options items="${listAgence}" />
                </form:select>
            </div><br/>

            <input type="submit" value="Save" />
        </form:form>
        <hr/>

        <a href="${accueil}">Accueil</a> &nbsp; &nbsp;
        <a href="${departements}">Liste des Services</a>

    </body>
</html>
