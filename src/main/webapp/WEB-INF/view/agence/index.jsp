<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion-Stock</title>
    </head>
    <body>
        <h3>Liste des Agences</h3>

        <table>
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Intitule</th>
                    <th>Region</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <spring:url value="/agence/new" var="agenceNew" />
                <spring:url value="/" var="accueil" />

                <c:if test="${agences.size() eq 0}">
                    Liste vide.
                </c:if>

                <c:if test="${agences.size() ne 0}">
                    <c:forEach items="${agences}" var="agence">

                        <spring:url value="/agence/${agence.id}/show" var="show" />
                        <spring:url value="/agence/${agence.id}/edit" var="edit" />

                        <tr>
                            <td>${agence.code}</td>
                            <td>${agence.intitule}</td>
                            <td>${agence.region}</td>
                            <td>
                                <a href="${show}">Show</a>
                                <a href="${edit}">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>

        <hr/>
        <a href="${agenceNew}">New</a> &nbsp; &nbsp;
        <a href="${accueil}">Accueil</a>
    </body>
</html>
