<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<c:import url="/inc/includes/header.jsp"></c:import>
    <title>Employees</title> 
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
				<div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Employees</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>
                    <!-- DataTales Example -->
                            <c:if test="${!empty message }">
                            	<div  class="text-light bg-success text-center p-2 mb-2 mt-4">${ message }</div>
                            </c:if>
                                                
                    <div class="card shadow mb-4">
                        
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Liste des Employees </h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>                                           
                                            <th>Nom</th>
                                            <th>Prénom</th>
                                            <th>CIN</th>
                                            <th>Date début</th>
                                            <th>Salaire</th>
                                            <th width="30px"></th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>                                           
                                            <th>Nom</th>
                                            <th>Prénom</th>
                                            <th>CIN</th>
                                            <th>Date début</th>
                                            <th>Salaire</th>
                                            <th width="30px"></th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                      <c:forEach items="${employes}" var="employe">
                                        <tr>
                                            <td>
                                              <c:out value="${ employe.nom }"></c:out>
                                            </td>
                                            <td>
                                              <c:out value="${ employe.prenom }"></c:out>
                                            </td>  
                                            <td>
                                              <c:out value="${ employe.cin }"></c:out>
                                            </td>                                                                                      
                                            <td>
                                              <c:out value="${ employe.dateDebutTravail }"></c:out>
                                            </td>
                                            <td>
                                              <c:out value="${ employe.salaireActuel }"></c:out>
                                            </td>
                                            <td>
                                                <a href="admin-delete-employe?id=${employe.id}">
                                                    <img src="inc/assets/img/delete.png" style="width:20px">
                                                </a>
                                                <a href="admin-update-employe?id=${ employe.id }">
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


