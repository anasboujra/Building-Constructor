<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="/inc/includes/header.jsp"></c:import>
    <title>Modifier admin</title>

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
                        <h1 class="h3 mb-0 text-gray-800">Modifier Administrateur</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>
                    <div class="row justify-content-center  p-5 mb-5 ">
                        <div class="col-lg-9  card p-4 shadow">
                        <h4 class="m-0 font-weight-bold text-primary pb-4">Modification</h4>
                        <hr class="mb-5">
                        
                        <form method="post" action="dg-update-rf">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="nom">Nom</label>
                                    <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" value="${ rf.nom }">
                                    <c:if test="${ ! empty erreurs.nom }">
                                    <div  class="text-danger form-text px-3">${erreurs.nom}</div>
                                    </c:if>           
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="prenom">Prenom</label>
                                    <input type="text" name="prenom" class="form-control" id="prenom" placeholder="Prenom" value="${ rf.prenom }" >
                                    <c:if test="${ ! empty erreurs.prenom }">
                                    <div  class="text-danger form-text px-3">${erreurs.ptrnom}</div>
                                    </c:if> 
                                </div>                        
                                <div class="form-group col-md-4">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${ rf.email }">
                                	<c:if test="${ ! empty erreurs.email }">
                                    <div  class="text-danger form-text px-3">${erreurs.email}</div>
                                    </c:if> 
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="tele">Telephone</label>
                                    <input type="text" class="form-control" name="tele" id="inputCity" placeholder="06-XXXXXXX" value="${ rf.tele }">
                                	<c:if test="${ ! empty erreurs.tele }">
                                    <div  class="text-danger form-text px-3">${erreurs.tele}</div>
                                    </c:if> 
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="cin">CIN</label>
                                    <input type="text" name="cin" class="form-control" id="cin"value="${ rf.cin }">
                                    <c:if test="${ ! empty erreurs.cin }">
                                    <div  class="text-danger form-text px-3">${erreurs.cin}</div>
                                    </c:if> 
                                </div>
                            </div>
                            
                            <input type="hidden" name="id" value="${ rf.id }">
                            <input type="hidden" name="type" value="rf">
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