<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<c:import url="/inc/includes/header.jsp"></c:import>
    <title>Demandes Clientèle</title> 
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
                        <h1 class="h3 mb-0 text-gray-800">Demandes d'Achat</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>
                    <!-- Page Heading -->

                    <!-- DataTales Example -->
                            <c:if test="${!empty message }">
                            	<div  class="text-light bg-success text-center p-2 mb-2 mt-4">${ message }</div>
                            </c:if>                     
                    <div class="card shadow mb-4">
                        
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Liste des demandes</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Rendez-vous</th>
                                            <th>Client</th>
                                            <th>email</th>
                                            <th>Projet</th>
                                            <th width="70px" >Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Rendez-vous</th>
                                            <th>Client</th>
                                            <th>email</th>
                                            <th>Projet</th>
                                            <th width="70px" >Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                    <c:forEach items="${ demandes }" var="demande">
                                        <tr>
                                            <td>${ demande.dateRDV }</td>
                                            <td>${ demande.client.nom } ${ demande.client.prenom }</td>
                                            <td>${ demande.client.email }</td>
                                            <td>${ demande.projet.titre}</td>
                                            <td class="d-flex">
                                                <a href="rf-confirmer-demande?confirmer=${ demande.id }" class="btn btn-primary mr-1">
                                                    C
                                                </a>
                                                <a href="rf-annuler-demande?annuler=${ demande.id }" class="btn btn-danger ml-1">
                                                    A
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


