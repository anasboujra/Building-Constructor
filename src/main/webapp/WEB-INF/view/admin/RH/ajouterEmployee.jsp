<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html lang="en">

<head>
	<c:import url="/inc/includes/header.jsp"></c:import>
    <title>Nouveau Employe</title> 
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
                        <h1 class="h3 mb-0 text-gray-800">Nouveau Employe</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>  
                    <div class="row justify-content-center  p-5 mb-5 ">
                        <div class="col-lg-9  card p-4">
                        <form method="post" action="rh-creer-employe">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inputNom">Nom</label>
                                    <input name="nom" type="text"  class="form-control" id="inputNom" placeholder="Nom" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputPrenom">Prenom</label>
                                    <input name="prenom" type="text" class="form-control" id="inputPrenom" placeholder="Prenom" required>
                                </div>                        
                                <div class="form-group col-md-12">
                                    <label for="inputEmail">Email</label>
                                    <input name="email" type="email" class="form-control" id="inputEmail" placeholder="Email">
                                </div>
                            </div>
                            <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputTele">Telephone</label>
                                <input name="tele" type="text" class="form-control" id="inputCity" placeholder="06-XXXXXXX">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="inputSalaire">Salaire (DH)</label>
                                <input  name="salaire" type="number" inputmode="numeric" id="inputSalaire" class="form-control" required>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="inputCIN">CIN</label>
                                <input name="cin" type="text" class="form-control" id="inputCIN" required>
                            </div>
                            </div>
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


