<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html lang="en">

<head>
	<c:import url="/inc/includes/header.jsp"></c:import>
    <title>Modifier Employe</title> 
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
                <div class="container-fluid ">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Modifier Employe</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>                
                    <div class="row justify-content-center  px-5 mb-5 ">
                        <div class="col-lg-9  card p-4">
                        <h4 class="m-0 font-weight-bold text-primary pb-4">Editer un Employées </h4>
                        <hr class="mb-5">
                        <form method="post" action="admin-update-employe">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inputNom">Nom</label>
                                    <input name="nom" type="text"  class="form-control" id="inputNom" placeholder="Nom" value="${ employe.nom }" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputPrenom">Prenom</label>
                                    <input name="prenom" type="text" class="form-control" id="inputPrenom" placeholder="Prenom" value="${ employe.prenom }" required>
                                </div>                        
                                <div class="form-group col-md-6">
                                    <label for="inputEmail">Email</label>
                                    <input name="email" type="email" class="form-control" id="inputEmail" placeholder="Email" value="${ employe.email }">
                                </div>
                            </div>
                            <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputTele">Telephone</label>
                                <input name="tele" type="text" class="form-control" id="inputTele" placeholder="06-XXXXXXX" value="${ employe.tele }" >
                            </div>
                            <div class="form-group col-md-4">
                                <label for="inputSalaire">Salaire</label>
                                <input  name="salaire" inputmode="numeric" id="inputSalaire" class="form-control" value="${ employe.salaireActuel }" required>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="inputCIN">CIN</label>
                                <input name="cin" type="text" class="form-control" id="inputCIN" value="${ employe.cin }" required>
                            </div>
                            </div>
                            <input type="hidden" name="id" value="${ employe.id }">
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


