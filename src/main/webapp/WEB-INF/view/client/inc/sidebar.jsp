
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="client-profile">
                <div class="sidebar-brand-icon">
                    <i class="fas fa-user"></i>
                </div>
                <div class="sidebar-brand-text mx-3">${sessionScope.sessionUser.prenom} ${sessionScope.sessionUser.nom}</div>
            </a>
            <li class="nav-item mt-2">
                <a class="nav-link" href="client-profile">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Achats</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="client-demande">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Faire une demande</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="messages-client">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Messages</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Compte</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="client-change-infos">Modifier les informations</a>
                        <a class="collapse-item" href="client-change-password">Changer le mot de passe</a>
                    </div>
                </div>
            </li>
            <div class="text-center d-none d-md-inline mt-3">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
        </ul>