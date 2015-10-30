<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h2>Menu</h2>

        <spring:url value="/agence/" var="agences" />
        <spring:url value="/departement/" var="departements" />


        <ul>
            <li>
                <a href="${agences}">Liste des agences</a>
            </li>

            <li>
                <a href="${departements}">Liste des services</a>
            </li>
        </ul>
    </body>
</html>
