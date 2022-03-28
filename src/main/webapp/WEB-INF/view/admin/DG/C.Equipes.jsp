<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

	<c:import url="/inc/includes/header.jsp"></c:import>
    <title>C.Equipes</title>

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
                        <h1 class="h3 mb-0 text-gray-800">Chefs d'Equipes</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>

                    <!-- DataTales Example -->
                            <c:if test="${ message=='success' }">
                            	<div  class="text-light bg-success text-center p-2 mb-2 mt-4">
                            	  Suppression avec succès
                            	</div>
                            </c:if>
                            <c:if test="${ message=='failed' }">
                               <div  class="text-light bg-danger text-center p-2 mb-2 mt-4">
                                 Opération échoué : Ce Chef d'équipe est en train de réaliser un projet
                               </div>                               
                            </c:if>	                   
                    <div class="card shadow mb-4">
                        
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Liste des Chefs d'équipes </h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" >
                                    <thead>
                                        <tr>
                                            <th>Numéro</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>CIN</th>
                                            <th>Date début</th>
                                            <th width="30px"></th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Numéro</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>CIN</th>
                                            <th>Date début</th>
                                            <th width="30px"></th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                     <c:forEach items="${CEs }" var="CE">
                                     
                                        <tr>
                                            <td>
                                              <c:out value="${CE.id }"></c:out>
                                            </td>
                                            <td>
                                              <c:out value="${CE.nom }"></c:out>
                                            </td>
                                             <td>
                                              <c:out value="${CE.prenom }"></c:out>
                                            </td>                                           
                                            <td>
                                              <c:out value="${CE.cin }"></c:out>
                                            </td>
                                            <td>
                                              <c:out value="${CE.dateCreation }"></c:out>
                                            </td>                                            
                                            <td>
                                                <a href="dg-delete-ce?id=${ CE.id }">
                                                    <img src="inc/assets/img/delete.png" style="width:20px">
                                                </a>
                                                <a href="dg-update-chef?id=${ CE.id }">
                                                    <img src="inc/assets/img/update.png" style="width:23px">
                                                </a>                                                
                                            </td>
                                        </tr>
                                        </c:forEach>                                   
                                        
                                    </tbody>
                                </table>
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