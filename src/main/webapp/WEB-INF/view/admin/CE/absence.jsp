<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<c:import url="/inc/includes/header.jsp"></c:import>
    <title>L'Absence</title> 
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
                        <h1 class="h3 mb-0 text-gray-800">L'Absence</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>  
                                         
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3"> <h6 align="Center">POINTAGE DU JOUR: ${dateActuelle}</h6>
                        </div>
                        <div class="card-body">
                        <form method="post" action="ce-noter-absence"> 
                          <div class="table-responsive">
                           <table class="table table-borderless" id="dataTable" cellspacing="0">
                                    <thead>
                                        <tr class="text-center">
                                            <th>Code apoge</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>CIN</th>
                                            <th>Pointage</th>
                                        </tr>  
                                    </thead>
                                    <tfoot>
                                        <tr class="text-center">
                                            <th>Code apoge</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>CIN</th>
                                            <th>Pointage</th>
                                        </tr> 
                                    </tfoot>

                                    <c:forEach items="${equipe}" var="employe">
                                    
                                     <c:forEach items="${absences}" var="absence">
                                     <c:if test="${absence.employe.id==employe.id }">
                                       <c:set var="check" value="${absence.present}"></c:set>
                                     </c:if>
                                     </c:forEach>
                                        <tr class="text-center">
                                            <td>${employe.id}</td>
                                            <td>${employe.nom}</td>
                                            <td>${employe.prenom}</td>
                                            <td>${employe.cin}</td>
                                            <td ><input <c:if test="${check}">${"checked"}</c:if> type="checkbox" name="check" value="${employe.id}"></td>
                                        </tr>
                                        
                                       </c:forEach>
                                   
                                </table>
                                </div>
                                    <div class="row h-50 justify-content-center align-items-center">
                                       <div class="col-4">
                                          <button type="submit" class="btn btn-primary form-control mb-2 mt-4">VALIDER POINTAGE</button>
                                       </div>
 
                                    </div>
                                    <c:if test="${!empty message }">
                            	       <div  class="text-light bg-success text-center p-2 mb-2 mt-4">${ message }</div>
                                    </c:if>  
                               </form>
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


