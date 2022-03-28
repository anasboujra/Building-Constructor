<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/x-icon" href="inc/assets/newlogo.png" />
    <title>Changer le mot de passe</title>

    <!-- Custom fonts for this template-->
    <link href="inc/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="inc/css/style.css" rel="stylesheet">
    <link href="inc/css/profileStyle.css" rel="stylesheet">
    <link href="inc/css/myStyle.css" rel="stylesheet">

</head>
<body id="page-top">
    <div id="wrapper">
    
       <!-- Sidebar -->
        <c:import url="inc/sidebar.jsp"></c:import>


        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
            
                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>
                    <div class="mx-3 my-auto">
                        <h1 class="h3 mb-0 text-gray-800">Changer le mot de passe</h1>
                    </div>
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item no-arrow">
                            <a class="nav-link" href="logout" id="userDropdown" role="button"
                                aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Se déconnecter</span>
                                <i class="fas fa-sign-out-alt"></i>
                            </a>
                        </li>
                    </ul>
                </nav>
                
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Content Row -->
                    <div class="row">
                    	<div class="card-body">
                    		<form method="post" action="client-change-password" class="user col-md-6 mx-auto">
                                <div class="form-group">
                                       <input type="password" class="form-control form-control-user" id="oldMotDePasse" name="oldMotDePasse" 
                                           aria-describedby="oldMotDePasseErreur" placeholder="ancien mot de passe">
                                       <div id="oldMotDePasseErreur" class="text-danger form-text px-3">${form.erreurs.oldMotDePasse}</div>
                                   </div>
                                   <div class="form-group">
                                       <input type="password" class="form-control form-control-user" id="motDePasse" name="motDePasse" 
                                           aria-describedby="motDePasseErreur" placeholder="Nouveau mot de passe">
                                       <div id="motDePasseErreur" class="text-danger form-text px-3">${form.erreurs.motDePasse}</div>
                                   </div>
                                   <div class="form-group">
                                       <input type="password" class="form-control form-control-user" id="motDePasseConf" name="motDePasseConf" 
                                           aria-describedby="motDePasseConfErreur" placeholder="Confirmer le mot de passe">
                                       <div id="motDePasseConfErreur" class="text-danger form-text px-3">${form.erreurs.motDePasseConf}</div>
                                   </div>
                                <button type="submit" class="btn btn-user btn-block text-light" id="connexionBtn">Valider</button>
               				</form>
            			</div>
           			</div>
            	</div>
			</div>
            <!-- Footer -->
            <c:import url="/inc/includes/footer.jsp"></c:import>
        </div>
    </div>

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
    
	<!-- Bootstrap core JavaScript-->
    <script src="inc/vendor/jquery/jquery.min.js"></script>
    <script src="inc/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="inc/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="inc/js/sb-admin-2.min.js"></script>

</body>
</html>