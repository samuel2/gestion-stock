<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="url" value="${pageContext.request.requestURI}" />

<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

    <!--    Partenaires-->
    <div class="panel panel-info">
        <div class="panel-heading" role="tab" id="administration">
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseAdministration" aria-expanded="true" aria-controls="collapseAdministration">
                    <spring:message code="menu.administration" />
                </a>
            </h4>
        </div>
        <div id="collapseAdministration"  role="tabpanel" aria-labelledby="administration"
             <c:choose>
                 <c:when test="${fn:containsIgnoreCase(url, 'service') || fn:containsIgnoreCase(url, 'agence') || fn:containsIgnoreCase(url, 'categorie') }">
                     class="panel-collapse collapse in"
                 </c:when>
                 <c:otherwise>
                     class="panel-collapse collapse"
                 </c:otherwise>
             </c:choose>
             >
            <div class="panel-body">
                <ul class="list-unstyled">
                    <li>
                        <a
                            <c:if test="${fn:containsIgnoreCase(url, 'agence')}">
                                class="list-group-item active"
                            </c:if>
                            href="<spring:url  value="/agence/" />">
                            <spring:message code="menu.agence" />
                        </a>
                    </li>
                    <li>
                        <a
                            <c:if test="${fn:containsIgnoreCase(url, 'service')}">
                                class="list-group-item active"
                            </c:if>
                            href="<spring:url value="/service/"/>">
                            <spring:message code="menu.service" />
                        </a>
                    </li>
                    <li>
                        <a
                            <c:if test="${fn:containsIgnoreCase(url, 'categorie')}">
                                class="list-group-item active"
                            </c:if>
                            href="<spring:url value="/categorie/" />">
                            <spring:message code="menu.categorie" />
                        </a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
    <!-- Approvisionnements -->
    <div class="panel panel-info">
        <div class="panel-heading" role="tab" id="appeloffre">
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseOperation" aria-expanded="false" aria-controls="collapseAppelOffre">
                    Operations
                </a>
            </h4>
        </div>
        <div id="collapseOperation" role="tabpanel" aria-labelledby="entree"

             <c:choose>
                 <c:when test="${fn:containsIgnoreCase(url, 'entree') || fn:containsIgnoreCase(url, 'sortie') || fn:containsIgnoreCase(url, 'audit') }">
                     class="panel-collapse collapse in"
                 </c:when>
                 <c:otherwise>
                     class="panel-collapse collapse"
                 </c:otherwise>
             </c:choose>

             >
            <div class="panel-body">
                <ul class="list-unstyled">
                    <li><a
                            <c:if test="${fn:containsIgnoreCase(url, 'entree')}">
                                class="list-group-item active"
                            </c:if>
                            href="<spring:url value="#"/>" >
                            Entree
                            <%--<spring:message code="caution.liste" />--%>
                        </a>
                    </li>
                    <li>
                        <a
                            <c:if test="${(fn:containsIgnoreCase(url, 'sortie')) }">
                                class="list-group-item active"
                            </c:if>
                            href="<spring:url value="#"/>" >
                            Sortie
                            <%--<spring:message code="menu.appelOffre.liste" />--%>
                        </a>
                    </li>
                    <li>
                        <a
                            <c:if test="${(fn:containsIgnoreCase(url, 'audit')) }">
                                class="list-group-item active"
                            </c:if>
                            href="<spring:url value="#"/>" >
                            Audit
                            <%--<spring:message code="menu.appelOffre.liste" />--%>
                        </a>
                    </li>

                </ul>

            </div>
        </div>
    </div>


</div>
