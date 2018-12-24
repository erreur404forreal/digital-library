<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>E-library - Recherche d'oeuvres</title>
    <%@ include file="../_include/header.jsp" %>
</head>


<body class="text-center">

<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">E-Library </h3>
            <nav class="nav nav-masthead justify-content-center">
                <a class="nav-link" href="/">Home</a>
                <a class="nav-link active" href="/searchwork">Oeuvres</a>
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
        <h1 class="cover-heading">${loggedmember.username} Voilà les livres correspondants à votre recherche</h1>

        <c:choose>
            <c:when test="${workList==null || workList.size() == 0}">
                <p> Aucun Resultat trouvé, réessayez</p>
            </c:when>
            <c:otherwise>
                <c:forEach items="${workList}" var="work">
                    <ul>
                        <li>
                            <a href="/work/workinformations/${work.worksId}"> ${work.title} écrit par ${work.author}</a><br>
                                ${work.copies} exemplaire(s) disponible à l'emprunt.
                        </li>

                        <a href="/e-library/borrow/${work.worksId}"/>


                    </ul>

                </c:forEach>
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
