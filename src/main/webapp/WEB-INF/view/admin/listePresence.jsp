<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<c:import url="/inc/includes/header.jsp"></c:import>
    <title>Absences</title> 
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
                        <h1 class="h3 mb-0 text-gray-800">Archive d'absence</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Liste des Presence </h6>             
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-borderedclass" id="dataTable" >
                                 <thead>
                                        <tr>
                                            <th>Equipe</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>CIN</th>             
                                            <th width="150px">Total d'absence</th>
                                        </tr> 
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Equipe</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>CIN</th>             
                                            <th width="150px">Total d'absence</th>
                                        </tr>                                   
                                    </tfoot>
                                         <tbody>
                                  <c:forEach items="${equipes}" var="equipe">
                                         <c:forEach items="${equipe.employe}" var="employe">
                                         <c:set var = "nbrabsence" value = "${0}"/>
                                            <tr>
                                            <td>${equipe.nom}</td>
                                            <td>${employe.nom}</td>
                                            <td>${employe.prenom}</td>                                           
                                            <td>${employe.cin}</td>
                              
                                            <c:forEach items="${absences}" var="absence">
                                             <c:if test="${absence.employe.id == employe.id }">
                                             <c:choose>
                                              <c:when test="${absence.present}"><c:set var = "present" value = "${0}"/></c:when>
                                              <c:otherwise ><c:set var = "present" value = "${1}"/></c:otherwise>
                                             </c:choose>
                                           <c:set var = "nbrabsence" value = "${nbrabsence+present}"/>
                                            </c:if>
                                             </c:forEach>
                                              <td><c:out  value = "${nbrabsence}"/></td>
                                        </tr>  
                                         </c:forEach>
                                                                      
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


