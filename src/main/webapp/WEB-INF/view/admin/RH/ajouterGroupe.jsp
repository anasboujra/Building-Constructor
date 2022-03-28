<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
	<c:import url="/inc/includes/header.jsp"></c:import>
    <title>Nouveau Equipe</title> 
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
                        <h1 class="h3 mb-0 text-gray-800">Nouveau Equipe</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>
                    <!-- DataTales Example -->
                    <div class="d-flex justify-content-center pt-5" >
                        <form  action="rh-creer-equipe" method="post" class="col-lg-9 ">
                            <c:if test="${!empty message }">
                            	<div  class="text-light bg-success text-center p-2 mb-2 mt-4">${ message }</div>
                            </c:if> 
                            <div class="row d-flex justify-content-center">
                                <div class="col-lg-12 card mb-4 shadow p-3">
                                      <h5  class="m-0 font-weight-bold text-primary p-2 mb-3">Employees libres</h5>
                                      <div class="overflow-y card pr-3 p-4">
                                          <table class="table">
                                              <thead>
                                                  <tr>
                                                      <th>Employees</th>
                                                      <th>CIN</th>
                                                      <th></th>
                                                  </tr>
                                              </thead>
                                              <tbody>
                                                 <c:forEach items="${ employes }" var="employe">
                                                  <tr>
                                                      <td>
                                                        <c:out value="${ employe.nom } ${ employe.prenom }"></c:out>
                                                      </td>
                                                      <td>
                                                        <c:out value="${ employe.cin }"></c:out>
                                                      </td>
                                                      <td><input value="${ employe.id }" type="checkbox" name="emp[]"></td>
                                                  </tr>                                                 
                                                 </c:forEach>
                                              </tbody>
                                          </table>
                                      </div>          
                                </div>
                                <div class="col-lg-12 card shadow p-3">
                                    <h5  class="m-0 font-weight-bold text-primary p-3 mb-3"> Chefs d'équipes libres</h5>
                                      <div class="overflow-y  card pr-3 p-4">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>Chef</th>
                                                    <th>CIN</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                             <c:forEach items="${ chefs }" var="chef">
                                             
                                                <tr>
                                                    <td>
                                                      <c:out value="${ chef.nom } ${ chef.prenom }"></c:out>
                                                    </td>
                                                    <td>
                                                      <c:out value="${ chef.cin }"></c:out>
                                                     </td>
                                                    <td><input value="${ chef.id }" type="radio" name="chef"></td>
                                                </tr>
                                              </c:forEach>                                                
                                            </tbody>
                                        </table>
                                      </div>              
                                </div>
                                <div class="form-group col-md-12 card shadow p-4 mt-3">
                                    <label for="inputNom">Nom d'équipe</label>
                                    <input name="titre" type="text" class="form-control" id="inputNom" required>
                                </div>
                                <div class="form-group col-md-12">
									<button type="submit" class="btn btn-primary form-control mb-2 mt-4">Enregister</button>
                                </div>          
                            </div>
                        </form>
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


