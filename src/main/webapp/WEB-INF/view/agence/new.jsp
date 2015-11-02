<%@page language="java" contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<tiles:insertDefinition name="layout">
    <tiles:putAttribute name="body">
        <div class="row">
            <div class="col-md-12">
                <h3>
                    <spring:message code="agence.nouveau" />
               	</h3>
                <hr/>
            </div>
        </div>

        <spring:url value="/agence/create" var="save" htmlEscape="true" />


        <form:form method="post" commandName="agence" action="${save}" >
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <form:label for="code" path="">
                            <spring:message code="agence.code" />
                        </form:label>
                        <form:input id="code" path="code" cssClass="form-control input-sm" />
                        <form:errors path="code" />
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="form-group">
                        <form:label for="intitule" path="">
                            <spring:message code="agence.intitule" />
                        </form:label>
                        <form:input id="intitule" path="intitule" cssClass="form-control input-sm" />
                        <form:errors path="intitule" />
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="form-group">
                        <form:label for="region" path="">
                            <spring:message code="agence.region" />
                        </form:label>
                        <form:input id="region" path="region" cssClass="form-control input-sm   " />
                        <form:errors path="region" />
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <hr/>
                    <button type="submit" class="btn btn-sm btn-danger" >
                        <span class="glyphicon glyphicon-save"></span>
                        <spring:message code="action.enregistrer" />
                    </button>
                    <spring:url value="/agence/" htmlEscape="true"
                                var="agence_home" />
                    <a href="${agence_home}" class="btn btn-sm btn-default">
                        <span class="glyphicon glyphicon-list"></span>
                        <spring:message code="agence.list" />
                    </a>
                </div>
            </div>
        </form:form>

    </tiles:putAttribute>
</tiles:insertDefinition>