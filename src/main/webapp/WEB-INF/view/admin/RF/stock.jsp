<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html lang="en">
<head>
	<c:import url="/inc/includes/header.jsp"></c:import>
    <title>Stock</title> 
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
                        <h1 class="h3 mb-0 text-gray-800">Stock</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>

                    <div class="row">

                        <!-- Earnings (Monthly) Card Example -->
                        <c:forEach items="${ mps}" var="mp">
                        
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                              ${ mp.nom } ( ${ mp.quantiteStockee } T)
                                            </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">
                                              ${ mp.prix } DH
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                       </c:forEach>                      
                    </div>

                    <div class="row justify-content-center  p-3 mb-2 ">
                        <div class="col-lg-12  card p-4">
                            <h5 class="m-0 font-weight-bold text-primary pb-2">Matières Première <small>( déjà existant )</small> </h5>
                            <hr class="mb-3">
                            <form action="rf-update-stock" method="post">
                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label for="inputEmail4">Nom</label>
                                        <select name="nom" class="form-control" id="inputEmail4">
                                           <c:forEach items="${mps}" var="mp">
                                              <option value="${ mp.id }"> 
                                                <c:out value="${ mp.nom }"></c:out>
                                              </option>
                                           </c:forEach>
                                            
                                        </select>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="quantite">Quantite</label>
                                        <input name="quantite" type="number"  inputmode="numeric" class="form-control" id="quantite" required>
                                    </div>                        
                                    <div class="form-group col-md-4">
                                        <label for="prix">Prix</label>
                                        <input name="prix" type="number" inputmode="numeric" class="form-control" id="prix" required>
                                    </div> 
                                </div>
                                
                                <button type="submit" class="btn btn-primary form-control mb-2 mt-4">Enregister</button>
                            <c:if test="${!empty messageUpdate }">
                            	<div  class="text-light bg-success text-center p-2 mb-2 mt-4">${ messageUpdate }</div>
                            </c:if> 
                            </form>                            
                        </div>
                    </div>


                    
                    <div class="row justify-content-center  p-3 mb-2 ">
                        <div class="col-lg-12  card p-4">
                            <h5 class="m-0 font-weight-bold text-primary pb-2">Matières Première <small>( nouvelle )</small> </h5>
                            <hr class="mb-3">
                            <form method="post" action="rf-stock">
                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label for="titre">Nom</label>
                                        <input name="nom" type="text" id="titre" class="form-control" placeholder="nom" >
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="quantite">Quantite (T)</label>
                                        <input name="quantite" type="number" inputmode="numeric" class="form-control" id="quantite" placeholder="quantite" required>
                                    </div>                        
                                    <div class="form-group col-md-4">
                                        <label for="prix">Prix (DH)</label>
                                        <input name="prix" type="number" inputmode="numeric" class="form-control" id="prix" placeholder="prix" required>
                                    </div> 
                                </div>
                                
                                <button type="submit" class="btn btn-primary form-control mb-2 mt-4">Enregister</button>
                            <c:if test="${!empty messageInsert }">
                            	<div  class="text-light bg-success text-center p-2 mb-2 mt-4">${ messageInsert }</div>
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


