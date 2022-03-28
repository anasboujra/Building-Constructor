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
    <title>Code de sécurité - Client</title>

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

            <div class="col-lg-8">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
	                    <div class="p-5">
	                        <div class="text-center">
	                            <h1 class="h4 text-gray-900 mb-4">Entrez le code de sécurité</h1>
	                            <p class="mb-4">Nous avons envoyé votre code à : ${sessionScope.email}</p>
	                            <p class="mb-4">Merci de vérifier dans vos e-mails que vous avez reçu un message avec votre 
	                            code. Celui-ci est composé de 8 chiffres.</p>
	                        </div>
	                        <form method="post" action="verifier-code-client" class="user col-md-8 mx-auto">
	                            <div class="form-group">
	                                <input type="text" class="form-control form-control-user" id="code" name="code" 
	                                 aria-describedby="codeErreur" placeholder="Entrez le code">
	                                <div id="emailErreur" class="text-danger form-text px-5">${form.erreurs.code}</div>
	                            </div>
	                            
	                            <button type="submit" class="btn btn-user btn-block text-light" id="connexionBtn">
	                            Valider</button>
	                            <c:if test="${!empty form.resultat}">
									<div class="alert alert-danger mx-1 mt-3 text-center" role="alert">${form.resultat}</div>
								</c:if>
	                        </form>
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