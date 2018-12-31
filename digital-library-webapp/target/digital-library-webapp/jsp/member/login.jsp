<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
    <title>E-library</title>
    <%@ include file="../_include/header.jsp" %>
</head>


<body class="text-center">

<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">E-Library </h3>
            <nav class="nav nav-masthead justify-content-center">
                <a class="nav-link active" href="/">Home</a>
                <a class="nav-link" href="/searchwork">Oeuvres</a>
                <c:choose>
                    <c:when test = "${sessionScope.loggedin}">
                        <a class="nav-link" href="/borrowing/list">Emprunts</a>
                        <a class="nav-link " href="/member/profile">Profil</a>
                        <a class="nav-link" href="/library/logout">Logout</a>
                    </c:when>
                    <c:otherwise>
                        <a class= "nav-link " href="/">Login</a>
                    </c:otherwise>
                </c:choose>

            </nav>
        </div>
    </header>

    <main role="main" class="inner cover">
        <h1 class="cover-heading">E-library.</h1>

        <p class="lead"> Passer par l'E-library est le moyen parfait pour emprunter des livres. Recherchez des oeuvres, empruntez les, et gérez vos prêts ici même.</p>                <c:choose>


        <c:when test = "${sessionScope.loggedin}">
            </a>
        </c:when>
        <c:otherwise>
            <form:form name="login" method="POST" action="member/login" class="form-signin" >

                <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
                <h1 class="h3 mb-3 font-weight-normal">Veuillez vous connecter</h1>
                <label for="login" class="sr-only">Username</label>
                <input type="text" id="login" class="form-control" placeholder="username" required autofocus name="login">
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" class="form-control" placeholder="Password" required name="password">
                <br>
                <input type="submit" value="Se connecter" class="btn btn-outline-warning" >
            </form:form>
            <p>${msg}</p>
        </c:otherwise>
    </c:choose>



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
