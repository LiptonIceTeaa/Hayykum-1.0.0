<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="page_type" content="np-template-header-footer-from-plugin">
<title>user profilke</title>
<link rel="stylesheet" href="../css/nicePage.css" media="screen">
<link rel="stylesheet" href="clientPage.css" media="screen">
<link rel="stylesheet" href="../css/userProflie.css" media="screen">
<meta name="generator" content="Nicepage 4.8.2, nicepage.com">
<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<link id="u-page-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i">
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="sweetalert2.all.min.js"></script>
<!-- <script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
</script>  -->

<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"> </script> -->
<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="../js/MOHPageJS.js"></script> 
<script type="text/javascript" src="../js/userProfileJS.js"></script> 
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script type="text/javascript" src="../js/nicePage.js"></script> 
	




<script
	type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "",
		"logo": "images/icon.Png.png"
}</script>
<meta name="theme-color" content="#478ac9">
<meta property="og:title" content="Home Page">
<meta property="og:type" content="website">
</head>

<body class="u-body u-xl-mode">

	<%
	
	String url = request.getHeader("referer");
	//System.out.println(url);
	if(!url.equals("http://localhost:8080/Hayykum_1.0.0/CLIENT/clientPage.jsp")){
	
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	}
    
	if (session.getAttribute("clientPassport") == null) {

		response.sendRedirect("clientLogin.jsp");
	}
	
	
	
    
	%>

	<script type="text/javascript">

var Msg3 ='<%=session.getAttribute("clientPassport")%>';




				

				function alertName() {
						
					
					/* filling inside of query results div */
					if(Msg3 != "null"){
						
						$("p#passportNO").html(Msg3);
						//document.getElementById('passportNO').value="DSFDS";
						
						
					}
				}	
					
					
					
				
			</script>

	<script type="text/javascript">
				window.onload = alertName;
			</script>
	<header class="u-clearfix u-header u-sticky-7962 u-header" style="margin-bottom:-2rem"
		id="sec-1ab4">
		<div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
			<a href="https://nicepage.com" class="u-image u-logo u-image-1"
				data-image-width="1200" data-image-height="1200"> <img
				src="../images/icon.Png.png" class="u-logo-image u-logo-image-1"
				style="margin-top: 1.2rem; margin-left: -8rem" id="imgToHide">
			</a>
			<nav id="headerToChange" class="u-menu-dropdown u-offcanvas u-menu-1">
				<div class="menu-collapse"
					style="font-size: 1rem; letter-spacing: 0px; font-weight: 700;">
					<a
						class="u-button-style u-custom-color u-custom-hover-color u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-text-active-color u-custom-text-color u-custom-text-hover-color u-custom-text-shadow u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base"
						href="#"> <svg class="u-svg-link" viewBox="0 0 24 24">
							<use xmlns:xlink="http://www.w3.org/1999/xlink"
								xlink:href="#menu-hamburger"></use></svg> <svg class="u-svg-content"
							version="1.1" id="menu-hamburger" viewBox="0 0 16 16" x="0px"
							y="0px" xmlns:xlink="http://www.w3.org/1999/xlink"
							xmlns="http://www.w3.org/2000/svg">
							<g>
							<rect y="1" width="16" height="2"></rect>
							<rect y="7" width="16" height="2"></rect>
							<rect y="13" width="16" height="2"></rect>
</g></svg>
					</a>
				</div>
				<div class="u-custom-menu u-nav-container">
					<ul class="u-nav u-unstyled u-nav-1">
					<li class="u-nav-item">
							
								<img src="../images/icon.Png.png" id="imgToShowMinimized">
							
						</li>
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-black u-text-black" id="homeHeaderToShowMinimized"
							href="clientPage.jsp" style="color:black">Home</a></li>
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-black u-text-black"
							href="../about-us-page/aboutUs.html" style="color:black">About Us</a></li>
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-black u-text-black"
							href="../contact-form-12/contactUs.html" style="color:black">Contact US</a>
						</li>
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-black u-text-black"
							href="../clientLogout" style="color: black" id="logoutHeaderToShowMinimized">Logout</a></li>
						
					</ul>
				</div>
				<div class="u-custom-menu u-nav-container-collapse">
					<div
						class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
						<div class="u-inner-container-layout u-sidenav-overflow">
							<div class="u-menu-close"></div>
							<ul
								class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2">
								<li class="u-nav-item" style="color:black"><a class="u-button-style u-nav-link"
									href="../homePage.jsp" style="color:black">Home Page</a></li>
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="../about-us-page/aboutUs.html" style="color:black">About Us</a></li>
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="../contact-form-12/contactUs.html" style="color:black">Contact US</a></li>
							</ul>
						</div>
					</div>
					<div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
				</div>
			</nav>
		</div>
	</header>
	<section class="u-clearfix u-section-1" id="sec-b2f7">
		<div class="u-clearfix u-layout-wrap u-layout-wrap-1">
			<div class="u-layout">
				<div class="u-layout-row">
					<div
						class="u-container-style u-hidden-xs u-layout-cell u-size-10-xl u-size-13-lg u-size-13-md u-size-13-sm u-size-13-xs u-layout-cell-1">
						<div class="u-container-layout u-container-layout-1">
							<div
								class="u-expanded-height u-gradient u-radius-10 u-shape u-shape-round u-shape-1"></div>
							<div class="u-list u-list-1">
								<div class="u-repeater u-repeater-1">
									<div class="u-container-style u-list-item u-repeater-item">
										<div
											class="u-container-layout u-similar-container u-valign-top u-container-layout-2">
											<span class="u-file-icon u-icon u-text-grey-25 u-icon-1"><img
												src="../images/5.png" alt=""></span>
											<a href="clientPage.jsp"> 
											<h6 class="u-custom-font u-font-lato u-text u-text-default u-text-grey-15 u-text-1">Home</h6>
										</a>
										</div>
									</div>
									<div class="u-container-style u-list-item u-repeater-item">
										<div
											class="u-container-layout u-similar-container u-valign-top u-container-layout-3">
											<span
												class="u-file-icon u-icon u-text-palette-1-base u-icon-2"><img
												src="../images/logo.png1.png" alt=""></span>
											<a href="https://ta.sdaia.gov.sa/en/index"> 
											
											<h6	class="u-custom-font u-font-lato u-text u-text-default u-text-grey-15 u-text-2">Tawakklna</h6>
										</a>
										</div>
									</div>
									<div class="u-container-style u-list-item u-repeater-item">
										<div
											class="u-container-layout u-similar-container u-valign-top u-container-layout-4">
											<span class="u-file-icon u-icon u-text-grey-25 u-icon-3"><img
												src="../images/7.png" alt=""></span>
											<a href="#"> 
												<h6 class="u-custom-font u-font-lato u-text u-text-default u-text-grey-15 u-text-3">Profile</h6>
										</a>
										</div>
									</div>
									<div class="u-container-style u-list-item u-repeater-item">
										<div
											class="u-container-layout u-similar-container u-valign-top u-container-layout-5">
											<span class="u-file-icon u-icon u-text-grey-25 u-icon-4"><img
												src="../images/8.png" alt=""></span>
												<a href="../clientLogout"> 
											<h6
												class="u-custom-font u-font-lato u-text u-text-default u-text-grey-15 u-text-4" >Logout</h6>
										</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div
						class="u-container-style u-layout-cell u-size-31-lg u-size-31-md u-size-31-sm u-size-31-xs u-size-35-xl u-layout-cell-2">
						<div class="u-container-layout u-container-layout-6">
							<div
								class="u-align-left u-container-style u-expanded-width-xl u-group u-radius-10 u-shape-round u-white u-group-1">
								<div class="u-container-layout u-container-layout-7">
									<p class="u-text u-text-default u-text-5">Name</p>
									<p class="u-text u-text-default u-text-6">Passport number</p>
									<p class="u-text u-text-default u-text-7" id="fullName">
											N/A</p>
									<p class="u-text u-text-default u-text-8" id="passportNO">N/A</p>
								</div>
							</div>
							<div
								class="u-align-left u-container-style u-expanded-width-xl u-group u-radius-10 u-shape-round u-white u-group-1">
								<div class="u-container-layout u-container-layout-7">
									
									
									<p class="u-text u-text-default u-text-5">Nationality</p>
									<p class="u-text u-text-default u-text-6">Gender</p>
									<p class="u-text u-text-default u-text-7" id="nationality">
											N/A</p>
									<p class="u-text u-text-default u-text-8" id="gender">N/A</p>
									
									<hr>
									
									
									<p class="u-text u-text-default u-text-5">Birth date</p>
									<p class="u-text u-text-default u-text-6">Number of doses</p>
									<p class="u-text u-text-default u-text-7" id="birthDate">	
											N/A</p>
									<p class="u-text u-text-default u-text-8" id="dosesNO">N/A</p>
									
									<hr>
									
									<p class="u-text u-text-default u-text-5" style="text-align:center;margin:auto;font-weight:bold;font-size:20px">Change password</p> 
									<br>
									<br>
									<p class="u-text u-text-default u-text-5" style="text-align:center;margin:auto;font-weight:bold;">Old Password:</p>
									<input id="oldPassword" type="password" class="u-text u-text-default u-text-7" style="text-align:center;margin:auto;font-weight:bold;min-width:30%;max-height:30px">
									<br>
									<p class="u-text u-text-default u-text-5" style="text-align:center;margin:auto;font-weight:bold;">New Password:</p>
									<input id="newPassword" type="password" class="u-text u-text-default u-text-7" style="text-align:center;margin:auto;font-weight:bold;min-width:30%;max-height:30px">
									<br>
									<br>
									<br>
									<button value="Submit changes" id="changePasswordBttn" class="u-border-none u-btn u-button-style u-custom-color-2 u-btn-1" style="text-align:center;margin:auto;font-weight:bold;min-width:30%;min-height:30px;margin-bottom:3rem">Submit changes</button>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- Footer -->
	<footer class="text-center text-lg-start bg-light text-muted">
		<!-- Section: Social media -->
		<section
			class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
			<!-- Left -->
			
			<!-- Left -->

			<!-- Right -->
			<div>
				<a href="" class="me-4 text-reset"> <i class="fab fa-facebook-f"></i>
				</a> <a href="" class="me-4 text-reset"> <i class="fab fa-twitter"></i>
				</a> <a href="" class="me-4 text-reset"> <i class="fab fa-google"></i>
				</a> <a href="" class="me-4 text-reset"> <i class="fab fa-instagram"></i>
				</a> <a href="" class="me-4 text-reset"> <i class="fab fa-linkedin"></i>
				</a> <a href="" class="me-4 text-reset"> <i class="fab fa-github"></i>
				</a>
			</div>
			<!-- Right -->
		</section>
		<!-- Section: Social media -->

		<!-- Section: Links  -->
		<section class="">
			<div class="container text-center text-md-start mt-5">
				<!-- Grid row -->
				<div class="row mt-3">
					<!-- Grid column -->
					<div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
						<!-- Content -->
						<h6 class="text-uppercase fw-bold mb-4">
							<i class="fas fa-gem me-3"></i>Hayyakum
						</h6>
						<p>We are a small group of senior software students providing a solution for vaccine certificates validation
						utilizing blockchain technology.</p>
					</div>
					<!-- Grid column -->

					<!-- Grid column -->
					<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
						<!-- Links -->
						<h6 class="text-uppercase fw-bold mb-4" style="color: grey">Useful links</h6>
						<p>
							<a href="homePage.jsp" class="text-reset" style="color: grey">Home</a>
						</p>
						<p>
							<a href="CLIENT/clientLogin.jsp" class="text-reset" style="color: grey">Client Login</a>
						</p>
						<p>
							<a href="contact-form-12/contactUs.html" class="text-reset" style="color: grey">Contact us</a>
						</p>
						<p>
							<a href="about-us-page/aboutUs.html" class="text-reset" style="color: grey">About us</a>
						</p>
					</div>
					<!-- Grid column -->

					<!-- Grid column -->
					<div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
						<!-- Links -->
						<h6 class="text-uppercase fw-bold mb-4">Employees</h6>
						<p>
							<a href="MOH/MOHLogin.jsp" class="text-reset" style="color: grey">MOH</a>
						</p>
						<p>
							<a href="MOFA/MOFALogin.jsp" class="text-reset" style="color: grey">MOFA</a>
						</p>
						<p>
							<a href="MOH/MOHLogin.jsp" class="text-reset" style="color: grey">MOH</a>
						</p>
					</div>
					<!-- Grid column -->

					<!-- Grid column -->
					<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
						<!-- Links -->
						<h6 class="text-uppercase fw-bold mb-4">Contact</h6>
						<p>
							<i class="fas fa-home me-3"></i> Riyadh, Riyadh 10012, KSA
						</p>
						<p>
							<i class="fas fa-envelope me-3"></i> hayykum@com.sa
						</p>
						<p>
							<i class="fas fa-phone me-3"></i> +966 50 678 4615
						</p>
					</div>
					<!-- Grid column -->
				</div>
				<!-- Grid row -->
			</div>
		</section>
		<!-- Section: Links  -->

		<!-- Copyright -->
		<div class="text-center p-4"
			style="background-color: rgba(0, 0, 0, 0.05);">
			© 2022 Copyright: <a class="text-reset fw-bold"
				href="#">Hayykum&trade;</a>
		</div>
		<!-- Copyright -->
	</footer>
	<!-- Footer -->
</body>
</html>