<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/bootstrap/css/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/css/custom.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/css/library.css'/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="<c:url value='/style/bootstrap/js/bootstrap.min.js'/>"></script>
    <title>Administration</title>
</head>
<body>
    <div class="page">
        <jsp:include page="../template/navbar.jsp"/>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3>Administration</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3">
                            <h3><a href="addUser">Ajouter un utilisateur</a></h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../template/footer.jsp"/>
</body>
</html>
