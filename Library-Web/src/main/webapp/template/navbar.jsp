<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<nav class="navbar navbar-default">
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
                <li><a href="/Library-Web/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                <li><a href="/Library-Web/register"><span class="glyphicon glyphicon-user"></span> Register</a></li>
            </ul>
        </div>
    </div>
</nav>