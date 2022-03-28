<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>BUILDING CONSTRUCTOR</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="inc/assets/newlogo.png" />
        <!-- Bootstrap Icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <!-- SimpleLightbox plugin CSS-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="inc/css/styleAccueil.css" rel="stylesheet" />
    </head>


    <body id="page-top">

        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top py-accueil-nav" id="mainNav">
            <div class="container-fluid px-4 px-lg-5">
                <a class="navbar-brand" href="#page-top">
                	<img src="inc/assets/img/logo.png" class="topbar-logo">
                </a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto my-2 my-lg-0">
                        <li class="nav-item"><a class="nav-link" href="#about">À propos</a></li>
                        <li class="nav-item"><a class="nav-link" href="#services">Nos services</a></li>
                        <li class="nav-item"><a class="nav-link" href="#portfolio">Nos projets</a></li>
                        <li class="nav-item"><a class="nav-link" href="#contact">Contactez-nous</a></li>
                        <c:if test="${empty sessionScope.sessionUser}">
	                        <li class="nav-item"><a class="nav-link" href="register-client">Créer un compte</a></li>
	                        <li class="nav-item"><a class="nav-link" href="login-client">Se Connecter</a></li>
						</c:if>
						<c:if test="${!empty sessionScope.sessionUser && sessionScope.userType=='client'}">
	                        <li class="nav-item"><a class="nav-link" href="client-profile">Profile</a></li>
	                        <li class="nav-item"><a class="nav-link" href="logout">Se déconnecter</a></li>
						</c:if>
						<c:if test="${!empty sessionScope.sessionUser && sessionScope.userType!='client'}">
	                        <li class="nav-item"><a class="nav-link" href="admin-profile">Profile</a></li>
	                        <li class="nav-item"><a class="nav-link" href="logout">Se déconnecter</a></li>
						</c:if>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Masthead-->
        <header class="masthead">
            <div class="container px-4 px-lg-5 h-100">
                <div class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center">
                    <div class="col-lg-8 align-self-end">
                        <h1 class="text-white font-weight-bold">Plus Qu'un Constructeur</h1>
                        <hr class="divider" />
                    </div>
                    <div class="col-lg-8 align-self-baseline">
                        <p class="text-white-75 mb-5">Nous mettons à votre dispositon les compétences et l'expérience de nos équipes</p>
                        <a class="btn btn-primary btn-xl" href="#about">en savoir plus</a>
                    </div>
                </div>
            </div>
        </header>

        <!-- About-->
        <section class="page-section bg-primary" id="about"  style="height: 92vh ; display: flex; justify-content: center;">
            <div class="container px-4 px-lg-5"  style="display: flex; align-items: center; justify-content: center;">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-lg-8 text-center"  style="width: auto;">
                        <h2 class="text-white mt-0">Nous avons ce que vous avez besoin!</h2>
                        <hr class="divider divider-light" />
                        <p class="text-white-75 mb-4">BUILDING CONSTRUCTOR, fondée en 2001, est une entreprise de construction des bâtiments.<br>
                        BC enrichie d'une expérience de 20 ans, continue à se développer en faisant de la qualité et de la sécurité. </p>
                        <a class="btn btn-light btn-xl" href="#services">Commencer!</a>
                    </div>
                </div>
            </div>
        </section>

        <!-- Services-->
        <section class="page-section" id="services">
            <div class="container px-4 px-lg-5">
            	<table width="75%" align="center" >
					<tr><td>
                       <img alt="" src="inc/assets/img/logo.png" style="width:100%; margin-bottom: 30px">
					</td></tr>
                </table>
                <h2 class="text-center mt-0">À votre service</h2>
                <hr class="divider" />
                <div class="row gx-4 gx-lg-5">
                    <div class="col-lg-3 col-md-6 text-center">
                        <div class="mt-5">
                            <div class="mb-2"><i class="bi-gem fs-1 text-primary"></i></div>
                            <h3 class="h4 mb-2">Dans votre besoin</h3>
                            <p class="text-muted mb-0">BC Vous offre l'achat d'une appartement selon votre besoin.</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 text-center">
                        <div class="mt-5">
                            <div class="mb-2"><i class="bi-laptop fs-1 text-primary"></i></div>
                            <h3 class="h4 mb-2">en-ligne</h3>
                            <p class="text-muted mb-0">Mettre à votre disposition la possibilité d'acheter en ligne!</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 text-center">
                        <div class="mt-5">
                            <div class="mb-2"><i class="bi-globe fs-1 text-primary"></i></div>
                            <h3 class="h4 mb-2">Partout</h3>
                            <p class="text-muted mb-0">Vous pouvez choisir où vous allez achetez l'appartement dans tout le maroc.</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 text-center">
                        <div class="mt-5">
                            <div class="mb-2"><i class="bi-award fs-1 text-primary"></i></div>
                            <h3 class="h4 mb-2">Qualité</h3>
                            <p class="text-muted mb-0">La qualité et la sécurité sont notre premières priorités.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Portfolio-->
        <div id="portfolio">
            <div class="container-fluid p-0">
          		<div class="row g-0">
          			<c:if test="${!empty images}">
          				<c:forEach var="i" begin="0" end="${images.size()-1}" step="1">
		                    <div class="col-lg-4 col-sm-6">
		                        <a class="portfolio-box" href="${images[i]}" title="${projets[i].titre}">
		                            <img class="img-fluid" src="${images[i]}" alt="..." style="width:100%;height:240px;"/>
		                            <div class="portfolio-box-caption">
		                                <div class="project-name">${projets[i].titre}</div>
		                                <div class="project-category text-white-50">
		                                	<br>Adresse: ${projets[i].adresse}
		                                	<br>Prix d'appartements: ${projets[i].prixVente} DH
		                                </div>
		                            </div>
		                        </a>
		                    </div>
						</c:forEach>
          			</c:if>
            	</div>
            	<div class="text-center mt-4">
            		<c:if test="${sessionScope.userType == 'client'}">
            			<a class="btn btn-primary btn-xl" href="client-demande">Demander Maintenant</a>
            		</c:if>
            		<c:if test="${sessionScope.userType != 'client'}">
            			<a class="btn btn-primary btn-xl" href="login-client">Demander Maintenant</a>
            		</c:if>
            	</div>
            </div>
        </div>

        <!-- Contact-->
        <section class="page-section" id="contact">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-lg-8 col-xl-6 text-center">
                        <h2 class="mt-0">Contactez-nous</h2>
                        <hr class="divider" />
                        <p class="text-muted mb-5">Envoyez-nous un message et nous vous répondrons dans le plus bref délai.</p>
                    </div>
                </div>
                <div class="row gx-4 gx-lg-5 justify-content-center mb-5">
                    <div class="col-lg-6">
                    	
                        <form id="contactForm" method="post" action="messages-client">
                            <!-- First name input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="prenom" type="text" placeholder="Entrer votre prénom..."
				                	<c:if test="${!empty message.prenom}">value="${message.prenom}"</c:if> 
                                	<c:if test="${empty message.prenom}">value="${sessionScope.sessionUser.prenom}"</c:if> 
                                	name="prenom" aria-describedby="prenomErreur"/>
                                <label for="prenom">Prénom</label>
                                <div id="prenomErreur" class="text-danger form-text px-3">${form.erreurs.prenom}</div>
                            </div>
                            <!-- Last name input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="nom" type="text" placeholder="Entrer votre nom..."
				                  	<c:if test="${!empty message.nom}">value="${message.nom}"</c:if> 
                                	<c:if test="${empty message.nom}">value="${sessionScope.sessionUser.nom}"</c:if> 
									name="nom" aria-describedby="nomErreur"/>
                                <label for="nom">Nom</label>
                                <div id="nomErreur" class="text-danger form-text px-3">${form.erreurs.nom}</div>
                            </div>
                            <!-- Email address input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="email" type="email" placeholder="name@example.com" name="email"
                                	<c:if test="${!empty message.email}">value="${message.email}"</c:if> 
                                	<c:if test="${empty message.email}">value="${sessionScope.sessionUser.email}"</c:if> 
 									aria-describedby="emailErreur" />
                                <label for="email">Adresse email</label>
                                <div id="emailErreur" class="text-danger form-text px-3">${form.erreurs.email}</div>
                            </div>
                            <!-- Phone number input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="tele" type="text" placeholder="(06) 45 67 89 00" 
                                	<c:if test="${!empty message.tele}">value="${message.tele}"</c:if> 
                                	<c:if test="${empty message.tele}">value="${sessionScope.sessionUser.tele}"</c:if> 
                                	aria-describedby="teleErreur" name="tele"/>
                                <label for="tele">Numéro de téléphone</label>
                                <div id="teleErreur" class="text-danger form-text px-3">${form.erreurs.tele}</div>
                            </div>
                            <!-- Message input-->
                            <div class="form-floating mb-3">
                                <textarea class="form-control" id="contenu" placeholder="Entrer votre message ici..." style="height: 10rem"
                                	aria-describedby="contenuErreur" name="contenu"></textarea>
                                <label for="contenu">Message</label>
                                <div id="contenuErreur" class="text-danger form-text px-3">${form.erreurs.contenu}</div>
                            </div>
                            <!-- Submit Button-->
                            <div class="d-grid">
                            	<button class="btn btn-primary btn-xl" id="submitButton" type="submit">Envoyer</button>
                           	</div>
                            <c:if test="${!empty form.resultat}">
								<div class="alert alert-danger mx-5 mt-3 text-center" role="alert">${form.resultat}</div>
							</c:if>
                        </form>
                    </div>
                </div>
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-lg-4 text-center mb-5 mb-lg-0">
                        <i class="bi-phone fs-2 mb-3 text-muted"></i>
                        <div>+212 522-220-220</div>
                    </div>
                    <div class="col-lg-4 text-center mb-5 mb-lg-0">
                        <i class="bi-building fs-2 mb-3 text-muted"></i>
                        <div>Rue Ayour Tikiouine,<br> 80000 Agadir, Maroc</div>
                    </div>
                    <div class="col-lg-4 text-center mb-5 mb-lg-0">
                        <i class="bi-envelope fs-2 mb-3 text-muted"></i>
                        <div>constructor.contact@gmail.com</div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Footer-->
        <footer class="bg-light py-5">
            <div class="container px-4 px-lg-5">
            	<div class="small text-center text-muted">Copyright &copy; 2022 - BUILDING CONSTRUCTOR</div>
            </div>
        </footer>

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- SimpleLightbox plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
        <!-- Core theme JS-->
        <script src="inc/js/scripts.js"></script>
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
