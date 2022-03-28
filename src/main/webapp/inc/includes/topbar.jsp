 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
    <!-- Sidebar Toggle (Topbar) -->
    <form class="form-inline">
        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
        </button>
    </form>

    <!-- Topbar Navbar -->
    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->

                        <!-- Nav Item - Alerts -->
                        
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-bell fa-fw"></i>
                                <!-- Counter - Alerts -->
                                
                                <!-- Number of Alerts to  RF -->
                                <c:if test="${!empty sessionScope.RFNotifications }">
                                <span class="badge badge-danger badge-counter">                                
                                +1                               
                                </span>
                                </c:if>
                                 <!-- / Number of Alerts to  RF -->
                                 
                                <!-- Number of Alerts to  DG -->
                                <c:set var="nbrcredits" value="${0}" scope="page"></c:set>
                                <c:forEach items="${ sessionScope.credits }">
                                  <c:set var="nbrcredits" value="${nbrcredits + 1}" ></c:set>
                                </c:forEach>
                                <c:if test="${ nbrcredits > 0 }">
                                <span class="badge badge-danger badge-counter">
                                
                                +${ nbrcredits }
                                
                                </span>                                
                                </c:if>
                                 <!-- /Number of Alerts to  DG -->
                            </a>
                            <!-- Dropdown - Alerts -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="alertsDropdown">
                                <h6 class="dropdown-header">
                                   Notifications
                                </h6>
                                
                                <!-- Alerts to RF -->
                                <c:if test="${sessionScope.RFNotifications == 'salaires' }">
                                <a class="dropdown-item d-flex align-items-center" href="rf-envoyer-salaires">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-primary">
                                            <i class="fas fa-dollar-sign text-white"></i>
                                        </div>
                                    </div>
                                    
                                    <div>
                                        <div class="small text-gray-500">Aujourd'hui</div>
                                        <span class="font-weight-bold">Aujourd'hui, vous devez confirmer l'envoi des salaires</span>
                                    </div>
                                </a>
                                </c:if>
                                <!-- /Alerts to RF -->
                                
                                <!-- Alerts to DG -->
                                <c:forEach items="${ sessionScope.credits }" var="credit">
                                <a class="dropdown-item d-flex align-items-center" href="dg-payer-prets?id=${ credit.id }">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-primary">
                                            <i class="fas fa-dollar-sign text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">Aujourd'hui</div>
                                        <span class="font-weight-bold">Aujourd'hui, vous devez payer le prêt de : ${ credit.banque }</span>
                                    </div>
                                </a>                                
                                </c:forEach>
                                <!-- /Alerts to DG -->
                                
                                <a class="dropdown-item text-center small text-gray-500" href="#">----------</a>
                            </div>
                        </li>
                        


                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                ${ sessionScope.sessionUser.nom } ${ sessionScope.sessionUser.prenom }
                                </span>
                                <img class="img-profile rounded-circle"
                                    src="inc/assets/img/unknown.png">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="admin-profile">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

</nav>