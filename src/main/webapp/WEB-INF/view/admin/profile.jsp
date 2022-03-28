<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <c:import url="/inc/includes/header.jsp"></c:import>
    <title>Profile</title>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
           <!--  Test Session -->
           <c:if test="${sessionScope.userType == 'dg' }">
             <c:import url="DG/inc/sidebar.jsp"></c:import>
           </c:if>
           
           <c:if test="${sessionScope.userType == 'rh' }">
             <c:import url="RH/inc/sidebar.jsp"></c:import>
           </c:if>

           <c:if test="${sessionScope.userType == 'rf' }">
             <c:import url="RF/inc/sidebar.jsp"></c:import>
           </c:if>

           <c:if test="${sessionScope.userType == 'ce' }">
             <c:import url="CE/inc/sidebar.jsp"></c:import>
           </c:if>
           
           <!--  End Of Test Session -->
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
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Profile</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>                        
                    </div>                      
                    <div class="row justify-content-center  p-3 mb-5 ">
                        <div class="col-lg-9  card p-4 shadow">
                        
	                        <form action="admin-profile" method="post">
	                            <div class="form-row">
	                                <div class="form-group col-md-5">
	                                    <label for="nom">Nom</label>
	                                    <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom"
	                                    	<c:if test="${!empty utilisateur.nom}">value="${utilisateur.nom}"</c:if> 
                                			<c:if test="${empty utilisateur.nom}">value="${sessionScope.sessionUser.nom}"</c:if>>
	                                    <div  class="text-danger form-text px-3">${form.erreurs.nom}</div>
	                                </div>
	                                
	                                <div class="form-group col-md-5">
	                                    <label for="prenom">Prenom</label>
                                    <input type="text" name="prenom" class="form-control" id="prenom" placeholder="Prenom" 
                                    	<c:if test="${!empty utilisateur.prenom}">value="${utilisateur.prenom}"</c:if> 
                               			<c:if test="${empty utilisateur.prenom}">value="${sessionScope.sessionUser.prenom}"</c:if>>
                                	<div  class="text-danger form-text px-3">${form.erreurs.prenom}</div>
	                                    
	                                </div>      
	                                <div class="form-group col-md-2">
		                                <label for="cin">CIN</label>
	                                    <input type="text" name="cin" class="form-control" id="cin" placeholder="CIN" 
	                                    	<c:if test="${!empty utilisateur.cin}">value="${utilisateur.cin}"</c:if> 
                               				<c:if test="${empty utilisateur.cin}">value="${sessionScope.sessionUser.cin}"</c:if>>
	                                    <div  class="text-danger form-text px-3">${form.erreurs.cin}</div>
	                                </div> 
	                                
	                                <div class="form-group col-md-6">
	                                    <label for="email">Email</label>
	                                    <input type="email" class="form-control" id="email" name="email" placeholder="Email" 
	                                    	<c:if test="${!empty utilisateur.email}">value="${utilisateur.email}"</c:if> 
                               				<c:if test="${empty utilisateur.email}">value="${sessionScope.sessionUser.email}"</c:if>>
	                                	<div  class="text-danger form-text px-3">${form.erreurs.email}</div>
	                                </div>
	                                
	                                <div class="form-group col-md-6">
	                                    <label for="tele">Telephone</label>
	                                    <input type="text" class="form-control" name="tele" id="inputCity" placeholder="06-XXXXXXX" 
	                                    	<c:if test="${!empty utilisateur.tele}">value="${utilisateur.tele}"</c:if> 
                               				<c:if test="${empty utilisateur.tele}">value="${sessionScope.sessionUser.tele}"</c:if>>
	                                	<div  class="text-danger form-text px-3">${form.erreurs.tele}</div>
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
	
	                            <button type="submit" class="btn btn-primary form-control mb-2 mt-4">Enregister</button>

                                    <c:if test="${!empty message }">
                            	       <div  class="text-light bg-success text-center p-2 mb-2 mt-4">${ message }</div>
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