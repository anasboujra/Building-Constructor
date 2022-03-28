<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="/inc/includes/header.jsp"></c:import>
    <title>Nouveau admin</title>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <c:import url="inc/sidebar.jsp"></c:import>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            
            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                   <c:import url="/inc/includes/topbar.jsp"></c:import>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid ">
                
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Nouveau Administrateur</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>
                
                    
                    <div class="row justify-content-center  p-5 mb-5 ">
                        <div class="col-lg-9  card p-4 shadow">
	                        <form method="post" action="dg-ajouter-admin">
	                            <div class="form-row">
	                                <div class="form-group col-md-6">
	                                    <label for="nom">Nom</label>
	                                    <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" 
	                                    	value="${utilisateur.nom}">
	                                    <div  class="text-danger form-text px-3">${form.erreurs.nom}</div>
	                                </div>
	                                <div class="form-group col-md-6">
	                                    <label for="prenom">Prenom</label>
	                                    <input type="text" name="prenom" class="form-control" id="prenom" placeholder="Prenom" 
	                                    	value="${ utilisateur.prenom }" >
	                                	<div  class="text-danger form-text px-3">${form.erreurs.prenom}</div>
	                                </div>                       
	                                <div class="form-group col-md-6">
	                                    <label for="email">Email</label>
	                                    <input type="email" class="form-control" id="email" name="email" placeholder="Email" 
	                                    	value="${ utilisateur.email }">
	                                	<div  class="text-danger form-text px-3">${form.erreurs.email}</div>
	                                </div>
	                                <div class="form-group col-md-6">
	                                    <label for="tele">Telephone</label>
	                                    <input type="text" class="form-control" name="tele" id="tele" placeholder="06-XXXXXXX" 
	                                    	value="${ utilisateur.tele }">
	                                	<div class="text-danger form-text px-3">${form.erreurs.tele}</div>
	                                </div>
	                                <div class="form-group col-md-6">
	                                    <label for="motDePasse">Mot de passe</label>
	                                    <input type="password" class="form-control" id="motDePasse" name="motDePasse" placeholder="Password">
	                                	<div  class="text-danger form-text px-3">${form.erreurs.motDePasse}</div>
	                                </div>
	                                <div class="form-group col-md-6">
	                                    <label for="motDePasse">Confirmer le mot de passe</label>
	                                    <input type="password" class="form-control" id="motDePasseConf" name="motDePasseConf" placeholder="Password">
	                                	<div  class="text-danger form-text px-3">${form.erreurs.motDePasseConf}</div>
	                                </div>
	                            </div>
	                            <div class="form-row">
	                            	<div class="form-group col-md-6">
	                                    <label for="cin">CIN</label>
	                                    <input type="text" name="cin" class="form-control" id="cin" placeholder="CIN" 
	                                    	value="${ utilisateur.cin }">
	                                    <div  class="text-danger form-text px-3">${form.erreurs.cin}</div>
	                                </div> 
	                            <div class="form-group col-md-6">
	                                <label for="type">Type</label>
	                                <select id="type" name="type" class="form-control">
		                                <option ></option>
		                                <option value="rf">R.Finanière</option>
		                                <option value="rh">R.Humain</option>
		                                <option value="ce">Chef d'équipe</option>
	                                </select>
	                                <div  class="text-danger form-text px-3">${form.erreurs.type}</div>
	                            </div>
	                            </div>
	                            
	                            <button type="submit" class="btn btn-primary form-control mb-2 mt-4">Enregister</button>
                            <c:if test="${!empty errorMessage }">
                            	<div  class="text-light bg-danger text-center p-2 mb-2 mt-4">${ errorMessage }</div>
                            </c:if>	                            
	                        </form>
                        </div>
                    </div>

                    <!-- Page Heading -->

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
              <c:import url="/inc/includes/footer.jsp"></c:import>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->



 <c:import url="/inc/includes/scripts.jsp"></c:import>
 
</body>

</html>