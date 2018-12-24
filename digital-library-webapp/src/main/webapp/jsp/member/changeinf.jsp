<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
    <title>E-library - Modifier le profil</title>
    <%@ include file="../_include/header.jsp" %>
</head>


<body class="text-center">

<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">E-Library </h3>
            <nav class="nav nav-masthead justify-content-center">
                <a class="nav-link " href="/">Home</a>
                <a class="nav-link" href="/searchwork">Oeuvres</a>
                <a class="nav-link" href="/borrowing/list">Emprunts</a>
                <a class="nav-link active" href="/member/profile">Profil</a>
                <c:choose>
                <c:when test = "${sessionScope.loggedin}">
                    <a class="nav-link" href="/library/logout">Logout</a>
                </c:when>
                <c:otherwise>
                    <a class= "nav-link" href="/">Login</a>
                </c:otherwise>
            </c:choose>
            </nav>
        </div>
    </header>

    <main role="main" class="inner cover">
        <h1 class="cover-heading">${loggedmember.username}, Changez ici vos informations</h1>

        <form:form name="login" method="POST" action="member/changements"  >


            <table class="table table-dark" style="with: 50%">

                <tr>
                    <td>Nom d'utilisateur actuel : </td>
                    <td><input type="text" name="username" value="${loggedmember.username}"/></td>
                </tr>
                <tr>
                    <td>Nouveau d'utilisateur : </td>
                    <td><input type="text" name="newusername" /></td>
                </tr>
                <tr>
                    <td>Nouveau mot de passe : </td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td>Nouvelle Addresse : </td>
                    <td><input type="text" name="address" /></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Enregistrer" class="btn btn-lg btn-secondary" >
        </form:form>
        <p>${msg}</p>

    </main>

    <footer class="mastfoot mt-auto">
        <div class="inner">
            <p></p>
        </div>
    </footer>
</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../../../assets/js/vendor/popper.min.js"></script>
<script src="../../../../dist/js/bootstrap.min.js"></script>
</body>
</html>


</html>