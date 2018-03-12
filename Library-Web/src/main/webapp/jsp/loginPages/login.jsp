<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/bootstrap/css/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/css/custom.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/css/library.css'/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="<c:url value='/style/bootstrap/js/bootstrap.min.js'/>"></script>
    <title>Connexion</title>
</head>
<body>
    <div class="page">
    <jsp:include page="../template/navbar.jsp"/>
        <div style="width:400px; margin-top: 5%;" class="container margin-top">
            <div class="panel panel-primary">
                <div class="panel-heading"><h1>Connexion</h1></div>
                <div class="panel-body">
                    <div class="container-fluid">
                        <form name="loginForm" method="post" action="<spring:url value='/loginCheck'/> ">
                            <div class="row">
                                <div class="col-md-5">Login </div>
                                <div class="col-md-5"><input type='text' name='userid' required></div>
                            </div>
                            <div style="margin-top:5px;" class="row">
                                <div class="col-md-5">Mot de passe </div>
                                <div class="col-md-5"><input type='password' name='passwd' required></div>
                            </div>
                            <div style="margin-top:20px;" class="row">
                                <div style="text-align:center;" class="col-md-12"><input type='submit' class='btn-success' value='Inscription'></div>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="">
                        </form>
                    </div>
                    <c:if test="${not empty sessionScope.message}">
                        <span style="color:green"><c:out value="${sessionScope.message}"/></span>
                        <c:remove var="message" scope="session"/>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../template/footer.jsp"/>
</body>
</html>
