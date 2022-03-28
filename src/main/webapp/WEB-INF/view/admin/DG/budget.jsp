<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

	<c:import url="/inc/includes/header.jsp"></c:import>
    <title>BC-Budjet</title>

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
                        <h1 class="h3 mb-0 text-gray-800">Budget</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>
                   <div class="container">
                    <div class="row justify-content-center  p-5 mb-5 ">
                        <div class="col-lg-10  card p-4 shadow">
                        <h4 class="m-0 font-weight-bold text-primary pb-3">Ajouter un nouveau credit </h4>
                        <hr class="mb-5">
                        <form method="post" action="dg-budget">
                            <div class="form-row mb-3">
                                <div class="form-group col-md-6">
                                    <label for="banque">Banque</label>
                                    <input name="banque" type="text" class="form-control" id="banque" placeholder="Banque" value="${ credit.banque }" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="valeur">Valeur</label>
                                    <input name="valeur" type="number" inputmode="numeric" class="form-control" id="valeur" placeholder="Valeur" value="${ credit.valeur }" required>
                                </div>                        
                            </div>
                            <div class="form-row mb-3">
                            <div class="form-group col-md-5">
                                <label for="dateEmprunt">Date Emprunt</label>
                                <input name="dateEmprunt" type="date" class="form-control" id="dateEmprunt" value="${ credit.dateEmprunt }" required>
                            </div>
                            <div class="form-group col-md-5">
                                <label for="dateEpargne">Date Epargne</label>
                                <input name="dateEpargne" type="date" class="form-control" id="dateEpargne" value="${ credit.dateEpargne }" required>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="taux">Taux(%)</label>
                                <input name="taux" type="number" inputmode="numeric" class="form-control" id="taux" value="${ credit.taux }" required>
                            </div>
                            </div>
                            <button type="submit" class="btn btn-primary form-control mb-2 mt-4">Enregister</button>
                            <c:if test="${!empty message }">
                            	<div  class="text-light bg-success text-center p-2 mb-2 mt-4">${ message }</div>
                            </c:if>
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