<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <c:import url="/inc/includes/header.jsp"></c:import>
    <title>Nouveau projet</title>


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
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Nouveau Projet</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>

                  
                   <div class="container col-lg-11">
                    <div class="row justify-content-center  p-5 mb-5  ">
                        <div class="col-lg-12  card shadow p-4">
	                        <form method="post"  enctype="multipart/form-data" action="dg-ajouter-projet">
	                            <h6 class="m-0 font-weight-bold text-primary mb-3">A propos</h6>
	                            <div class="form-row mb-4">                                
	                                <div class="form-group col-md-6">
	                                    <label for="inputTitle">Titre</label>
	                                    <input name="titre" type="text" class="form-control" id="inputTitle" placeholder="Tite" required>
	                                </div>
	                                <div class="form-group col-md-6">
	                                    <label for="inputAdresse">Adresse</label>
	                                    <input name="adresse" type="text" class="form-control" id="inputAdresse" placeholder="Adresse" required>
	                                </div>                        
	                                <div class="form-group col-md-6">
	                                    <label for="inputDD">Date debut</label>
	                                    <input name="dateDebut" type="date" class="form-control" id="inputDD" required>
	                                </div>
	                                <div class="form-group col-md-6">
	                                    <label for="inputDF">Date fin</label>
	                                    <input name="dateFin" type="date" class="form-control" id="inputDF" required>
	                                </div>
	                            </div>
	                            <h6 class="m-0 font-weight-bold text-primary mb-3">Construction</h6>
	                            <div class="form-row">
	                            
	                            <div class="form-group col-md-4">
	                                <label for="inputSurface">Surface d'appartment m²</label>
	                                <input name="surface" type="text" class="form-control" id="inputSurface" required>
	                            </div>
	                            <div class="form-group col-md-5">
	                                <label for="inputNA">Nombre d'appartements</label>
	                                <input name="nombreAppartement" type="number" class="form-control" id="inputNA" required>
	                            </div>
	                            <div class="form-group col-md-3">
	                                <label for="inputTeam">Equipe</label>
	                                <select name="equipe" id="inputTeam" class="form-control" required>
	                                <option selected>Choose...</option>
	                                <c:forEach items="${ equipes }" var="equipe">
	                                  <option value="${ equipe.id }">
	                                    ${ equipe.nom }
	                                  </option>
	                                </c:forEach>
	                                
	                                </select>
	                            </div>
	
	                            </div>
	                            <div class="form-row mb-4">
	                                <div class="form-group col-md-3">
	                                    <label for="inputNE">Nombre des étages</label>
	                                    <input name="nombreEtage" type="number" class="form-control" id="inputNE" required>
	                                </div>
	                                <div class="form-group col-md-5">
	                                    <label for="inputNEA">Nombre des chambres/app</label>
	                                    <input name="nombreChambre" type="number" class="form-control" id="inputNEA" required>
	                                </div>
	                                <div class="form-group col-md-4">
	                                    <label for="inputPrice">Prix de vente d'appartement</label>
	                                    <input name="prixVente" type="number" class="form-control" id="inputPrice" required>
	                                </div>
	                                <div class="form-group col-md-12">
	                                      <div class="file-field " style=" display: flex; justify-content: center; margin-top: 10px">
	                                         <div class="btn btn-primary btn-sm float-right">
	                                         <span >Selectionner l'image</span>
	                                         <input type="file" name="image" required>
	                                         </div>
	                                       </div>
	                                </div>
	                            </div>
	                            <h6 class="m-0 font-weight-bold text-primary mb-3">Matieres premiéres nécessaires</h6>
	                            <div class="form-row mb-4">
	                             <c:forEach items="${ mps }" var="mp">
	                                <div class="form-group col-md-4">
	                                    <label for="inputMP${ mp.id }">${ mp.nom }</label>
	                                    <input name="${ mp.id }" type="number" class="form-control" id="inputMP${ mp.id }" max="${ mp.quantiteStockee }">
	                                </div>                              
	                             </c:forEach>
	 
	                            </div>
	                            <button type="submit" class="btn btn-primary form-control mb-2 mt-4">Enregister</button>
	                        </form>                            
                        </div>
                    </div>                       

                   </div>
                  
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