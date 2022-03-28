<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE>
<html>

<head>
	<c:import url="/inc/includes/header.jsp"></c:import>
    <title>Les Equipes</title> 
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
                        <h1 class="h3 mb-0 text-gray-800">Les Equipes</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>
                    <!-- DataTales Example -->

                              <c:if test="${ message == 'failed'}">
                                      <div  class="text-light bg-danger text-center p-2 mb-2 mt-4">
                                        Opération échoué : Cette équipe est en train de réaliser un projet
                                      </div>
                              </c:if>
                              <c:if test="${ message == 'NotFound'}">
                                      <div  class="text-light bg-danger text-center p-2 mb-2 mt-4">
                                        Opération échoué : Cette équipe n'existe pas
                                      </div>
                              </c:if>                              
                              <c:if test="${ message == 'success'}">
		                              <div  class="text-light bg-success text-center p-2 mb-2 mt-4">
		                                Suppression avec succès
		                              </div>
                              </c:if>                            	
                   
                    <div class="card shadow mb-4">                        
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Liste des Groupes </h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Nom d'equipe</th>
                                            <th>Chef d'équipe</th>
                                            <th>Nombre des employes</th>
                                            <th width="2px"></th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Nom d'equipe</th>
                                            <th>Chef d'équipe</th>
                                            <th>Nombre des employes</th>
                                            <th width="2px"></th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                     <c:forEach items="${ equipes }" var="equipe" varStatus="status">
                                        <tr>
                                            <td>
                                              ${ equipe.nom }
                                            </td>
                                            <td>
                                              ${ equipe.ce.nom } ${ equipe.ce.prenom } 
                                            </td>
                                            <td>
                                              <c:set var="nbrEmp" value="${ 0 }" scope="page"></c:set>
                                              <c:forEach items="${ equipe.employe }">
                                                <c:set var="nbrEmp" value="${ nbrEmp + 1 }"></c:set>
                                              </c:forEach>
                                              <c:out value="${ nbrEmp }"></c:out>
                                            </td>
                                            <td>
                                                <a href="rh-supprimer-equipe?id=${ equipe.id }">
                                                    <img src="inc/assets/img/delete.png" style="width:20px">
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


