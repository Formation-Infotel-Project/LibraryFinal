<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>--%>
<html>
<head>
    <title>Membres</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/bootstrap/css/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/css/custom.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/css/library.css'/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="<c:url value='/style/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>
    <div class="page">
    <jsp:include page="template/navbar.jsp"/>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3>Liste des membres</h3>
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th style='text-align:center'>Nom</th>
                                    <th style='text-align:center'>Prénom</th>
                                    <th style='text-align:center'>EMail</th>
                                    <th style='text-align:center'>Adresse</th>
                                    <th style='text-align:center'>Tel</th>
                                    <th style='text-align:center'>Actions</th>
                                </tr>
                            </thead>
                            <tbody id="contenant">
                            <c:forEach items="${members}" var="member">
                                <tr>
                                    <td>${member.memberLastName}</td>
                                    <td>${member.firstName}</td>
                                    <td>${member.email}</td>
                                    <td>${member.address} ${member.postalCode} ${member.city}</td>
                                    <td>${member.phone}</td>
                                    <td>
                                        <form method="get" action="MemberDetail">
                                            <input type="hidden" name="id" value="${member.memberId}">
                                            <input type="submit" class="btn btn-info" value="Détail">
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="template/footer.jsp"/>
</body>
</html>
