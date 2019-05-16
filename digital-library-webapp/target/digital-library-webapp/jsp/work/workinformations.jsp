<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
    <title>E-library - ${work.title}</title>
    <%@ include file="../_include/header.jsp" %>
</head>


<body class="text-center">

<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">E-Library</h3>
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
                        <a class= "nav-link " href="${pageContext.request.contextPath}/home">Login</a>
                    </c:otherwise>
                </c:choose>
            </nav>
        </div>
    </header>


    <main role="main" class="inner cover">
        <h1>${work.title}</h1>
        <p><img src="${work.imgUrl}"/></p>
        <p>
            Auteur : ${work.author} </br>
            Publié en : ${work.publicationYear} </br>
            Description de l'oeuvre : ${work.bookDescription} </br>


            <c:choose>
                <c:when test = "${sessionScope.loggedin}">
                    <td><a href="${pageContext.request.contextPath}/e-library/borrow/${work.worksId}"> <button  class="btn btn-outline-warning" data-toggle="popover" data-trigger="focus" title="Cliquez ici pour emprunter ce livre" >Emprunter</button></a>
                </c:when>
                <c:otherwise>
                    <td><a href="#"> <button  class="btn btn-outline-warning" data-toggle="popover" data-trigger="focus" title="Connectez vous pour emprunter ce livre" disabled>Emprunter</button></a>
                </c:otherwise>
            </c:choose>


        </p>
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
