<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="fr">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/x-icon" href="inc/assets/newlogo.png" />
    <title>Connexion - Admin</title>

    <!-- Custom fonts for this template-->
    <link href="inc/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="inc/css/style.css" rel="stylesheet">
    <link href="inc/css/myStyle.css" rel="stylesheet">

</head>


<body class="bg-employe-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-employe-image"></div>
                            <div class="col-lg-6 pt-3 mt-3">
                                <div class="px-5 pt-5 pb-4">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Se connecter</h1>
                                    </div>
                                    <form method="post" action="login-admin" class="user">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user" id="email" name="email" 
                                            value="${user.email}" aria-describedby="emailErreur" placeholder="Adresse email">
                                            <div id="emailErreur" class="text-danger form-text px-5">${form.erreurs.email}</div>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user" id="motDePasse" name="motDePasse" 
                                            aria-describedby="motDePasseErreur" placeholder="Mot de passe">
                                            <div id="motDePasseErreur" class="text-danger form-text px-5">${form.erreurs.motDePasse}</div>
                                        </div>
                                        <button type="submit" class="btn btn-user btn-block text-light" id="connexionBtnEmp">Connexion</button>
                                        <c:if test="${!empty form.resultat}">
											<div class="alert alert-danger mx-5 mt-3 text-center" role="alert">${form.resultat}</div>
										</c:if>
                                        <hr>
                                        <a href="login-client" class="btn btn-comme btn-user btn-block">Connecter comme un client</a>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="forgot-password-admin">Mot de passe oublié?</a>
                                    </div>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="accueil">Retour à la page d'accueil?</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="inc/vendor/jquery/jquery.min.js"></script>
    <script src="inc/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="inc/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="inc/js/script2.js"></script>

</body>

</html>