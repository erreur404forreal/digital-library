<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>E-library - Rechercher une oeuvre</title>
    <%@ include file="../_include/header.jsp" %>
</head>


<body class="text-center">

<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">E-Library </h3>
            <nav class="nav nav-masthead justify-content-center">
                <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
                <a class="nav-link active" href="${pageContext.request.contextPath}/searchwork">Oeuvres</a>
                <c:choose>
                    <c:when test = "${sessionScope.loggedin}">
                        <a class="nav-link" href="${pageContext.request.contextPath}/borrowing/list">Emprunts</a>
                        <a class="nav-link " href="${pageContext.request.contextPath}/member/profile">Profil</a>
                        <a class="nav-link" href="${pageContext.request.contextPath}/library/logout">Logout</a>
                    </c:when>
                    <c:otherwise>
                        <a class= "nav-link" href="${pageContext.request.contextPath}/home">Login</a>
                    </c:otherwise>
                </c:choose>
            </nav>
        </div>
    </header>
    <main role="main" class="inner cover">
        <h1 class="cover-heading">${loggedmember.username} Trouvez votre oeuvre  </h1>
        <form:form method="GET" name="searchwork" action="/work/search" class="form-signin">

            <label for="author" class="sr-only">Auteur</label>
            <input type="text" id="author" class="form-control" placeholder="Auteur" name="author" />
            <label for="title" class="sr-only">Titre</label>
            <input type="text" id="title" class="form-control" placeholder="Titre" name="title" />
            <BR>
            <input type="submit" value="Rechercher" class="btn btn-outline-warning" />

        </form:form>
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
