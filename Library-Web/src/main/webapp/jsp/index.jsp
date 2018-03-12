<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="<c:url value='../../style/bootstrap/css/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='../../style/css/custom.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='../../style/css/library.css'/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="<c:url value='../../style/bootstrap/js/bootstrap.min.js'/>"></script>
    <title>Library</title>
</head>
<body><!-- sec:authorize="hasAuthority('ADMIN')" -->
    <div class="page">
        <jsp:include page="template/navbar.jsp"/>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-8">
                    <h1 style="margin-bottom:20px; font-size:25px;">Livres recommandés</h1>
                    <div id="box-book-recom" class="container-fluid"  style="background-color:white;overflow-y:scroll;height: 200px;">
                        <div class='row'>
                            <!-- foreach -->
                            <a href="">
                                <div class='col-md-3' style='margin-top:20px;'>
                                    <div class='book'>
                                        <div class='divBookTitle'><span class='bookTitle'></span></div>
                                    </div>
                                </div>
                            </a>
                            <!-- end foreach -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="template/footer.jsp"/>
</body>
</html>