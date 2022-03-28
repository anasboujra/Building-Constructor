<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html lang="en">

<head>
	<c:import url="/inc/includes/header.jsp"></c:import>
    <title>répondre au message</title> 
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
                        <h1 class="h3 mb-0 text-gray-800">Répondre au message</h1>
                        <a onclick="window.print();" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                           <i class="fas fa-download fa-sm text-white-50"></i> 
                           Exporter PDF
                        </a>
                    </div>  
                    <div class="row justify-content-center px-3 mb-3">
                        <div class="col-lg-9 card p-4">
                        <form method="post" action="rh-messages">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="id">id</label>
                                    <input name="id" type="text"  class="form-control" id="id" value="${message.id}" required readonly>
                                </div>                       
                                <div class="form-group col-md-12">
                                    <label for="email">Email</label>
                                    <input name="email" type="email" class="form-control" id="email" value="${message.email}" required readonly>
                                </div>
                            </div>
                            <!-- Message input-->
                            <div class="form-group mb-3">
                            	<label for="reponse">La réponse</label>
                                <textarea class="form-control" id="reponse" placeholder="Entrer votre réponse ici..." 
                                	style="height: 10rem" aria-describedby="contenuErreur" name="reponse"></textarea>
                            </div>
                            
                            
                            <button type="submit" class="btn btn-primary form-control mb-2 mt-4">Envoyer</button>                       
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


