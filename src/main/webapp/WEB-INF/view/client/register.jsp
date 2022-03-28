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
    <title>Créer un compte - Client</title>

    <!-- Custom fonts for this template-->
    <link href="inc/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="inc/css/style.css" rel="stylesheet">
    <link href="inc/css/myStyle.css" rel="stylesheet">

</head>


<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-4">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="px-5 pt-4 pb-4">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Créer un compte!</h1>
                            </div>
                            <form method="post" action="register-client" class="user">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="prenom" name="prenom" 
                                            value="${client.prenom}" aria-describedby="prenomErreur" placeholder="Prénom">
                                        <div id="prenomErreur" class="text-danger form-text px-3">${form.erreurs.prenom}</div>
                                    </div>
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="nom" name="nom" 
                                            value="${client.nom}" aria-describedby="nomErreur" placeholder="Nom">
                                        <div id="nomErreur" class="text-danger form-text px-3">${form.erreurs.nom}</div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="cin" name="cin" 
                                            value="${client.cin}" aria-describedby="cinErreur" placeholder="CIN">
                                        <div id="cinErreur" class="text-danger form-text px-3">${form.erreurs.cin}</div>
                                    </div>
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="tele" name="tele" 
                                            value="${client.tele}" aria-describedby="teleErreur" placeholder="Numéro de téléphone">
                                        <div id="teleErreur" class="text-danger form-text px-3">${form.erreurs.tele}</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                     <input type="email" class="form-control form-control-user" id="email" name="email" 
                                     	value="${client.email}" aria-describedby="emailErreur" placeholder="Adresse email">
                                     <div id="emailErreur" class="text-danger form-text px-3">${form.erreurs.email}</div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user" id="motDePasse" name="motDePasse" 
                                            aria-describedby="motDePasseErreur" placeholder="Mot de passe">
                                        <div id="motDePasseErreur" class="text-danger form-text px-3">${form.erreurs.motDePasse}</div>
                                    </div>
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user" id="motDePasseConf" name="motDePasseConf" 
                                            aria-describedby="motDePasseConfErreur" placeholder="Confirmer le mot de passe">
                                        <div id="motDePasseConfErreur" class="text-danger form-text px-3">${form.erreurs.motDePasseConf}</div>
                                    </div>
                                </div>
                                
                                <button type="submit" class="btn btn-user btn-block text-light" id="connexionBtn">Créer un compte</button>
                                <c:if test="${!empty form.resultat}">
									<div class="alert alert-danger mx-5 mt-3 text-center" role="alert">${form.resultat}</div>
								</c:if>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="login-client">Vous avez déjà un compte? Se connecter!</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="forgot-password-client">Mot de passe oublié?</a>
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
    <!-- Bootstrap core JavaScript-->
    <script src="inc/vendor/jquery/jquery.min.js"></script>
    <script src="inc/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="inc/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="inc/js/script2.js"></script>

</body>

</html>