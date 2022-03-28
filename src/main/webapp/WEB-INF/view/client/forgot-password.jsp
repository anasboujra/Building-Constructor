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
    <title>Mot de passe oublie - Client</title>

    <!-- Custom fonts for this template-->
    <link href="inc/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="inc/css/style.css" rel="stylesheet">
    <link href="inc/css/myStyle.css" rel="stylesheet">

</head>


<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Mot de passe oublié?</h1>
                                        <p class="mb-4">Entrez simplement votre adresse e-mail ci-dessous et nous vous 
                                        enverrons un code de sécurité pour réinitialiser votre mot de passe !</p>
                                    </div>
                                    <form method="post" action="forgot-password-client" class="user">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user" id="email" name="email" 
                                            value="${client.email}" aria-describedby="emailErreur" placeholder="Adresse email">
                                            <div id="emailErreur" class="text-danger form-text px-5">${form.erreurs.email}</div>
                                        </div>
                                        
                                        <button type="submit" class="btn btn-user btn-block text-light" id="connexionBtn">
                                        Réinitialiser le mot de passe</button>
                                        <c:if test="${!empty form.resultat}">
											<div class="alert alert-danger mx-1 mt-3 text-center" role="alert">${form.resultat}</div>
										</c:if>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="login-client">Vous avez déjà un compte? Se connecter!</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="register-client">Créer un compte!</a>
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