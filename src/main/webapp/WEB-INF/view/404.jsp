<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>



<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>404</title>

    <!-- Custom fonts for this template-->
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="inc/css/style.css" rel="stylesheet">

</head>

<body id="page-top" class="mt-5">
    <div id="wrapper">
        <div id="content-wrapper" class="jumbotron d-flex align-items-center">
            <div id="content">
                <div class="container-fluid">
                    <!-- 404 Error Text -->
                    <div class="text-center mt-5">
                        <div class="error mx-auto" data-text="404">404</div>
                        <p class="lead text-gray-800 mb-5">Page non trouvée</p>
                        <a href="accueil">&larr; Retour à la page d'accueil</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer -->
	<c:import url="/inc/includes/footer.jsp"></c:import>


</body>

</html>