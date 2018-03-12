<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<nav class="navbar navbar-default" style="margin-bottom: 3%;">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/Library-Web">Library</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/Library-Web">Home</a></li>
                <li><a href="books">Livres</a></li>
                <li><a href="#">Page 3</a></li>
                <li><a href="memberList">Members</a></li>
            </ul>
            <form class="navbar-form navbar-left" action="Search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="isAnonymous()">
                    <li><a href="/Library-Web/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    <li><a href="/Library-Web/register"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li><a href="/Library-Web/administration"><span class="glyphicon glyphicon-wrench"></span> Administration</a></li>
                    <li><a href="/Library-Web/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>