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
        <h3>Liste des Services</h3>

        <table>
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Intitule</th>
                    <th>Agence</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <spring:url value="/departement/new" var="departementNew" />
                <spring:url value="/" var="accueil" />

                <c:if test="${departements.size() eq 0}">
                    Liste vide.
                </c:if>

                <c:if test="${departements.size() ne 0}">
                    <c:forEach items="${departements}" var="departement">

                        <spring:url value="/departement/${departement.id}/show" var="show" />
                        <spring:url value="/departement/${departement.id}/edit" var="departementEdit" />

                        <tr>
                            <td>${departement.code}</td>
                            <td>${departement.intitule}</td>
                            <td>${departement.agence.intitule}</td>
                            <td>
                                <a href="${show}">Show</a>
                                <a href="${departementEdit}">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>

        <hr />

        <a href="${departementNew}">New</a> &nbsp; &nbsp;
        <a href="${accueil}">Accueil</a>

    </body>
</html>
