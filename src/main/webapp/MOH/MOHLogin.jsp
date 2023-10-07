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
<title>MOH</title>
<link rel="icon" href="../images/icon.Png.png" type="image/icon type">
<link rel="stylesheet" href="../css/nicePage.css" media="screen">
<link rel="stylesheet" href="../css/MOHLogin.css" media="screen">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script class="u-script" type="text/javascript"
	src="../js/MOHUpdateJS.js"></script>
<script class="u-script" type="text/javascript" src="../js/jquery.js"
	defer=""></script>
<script class="u-script" type="text/javascript" src="../js/nicePage.js"
	defer=""></script>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/4.7.95/css/materialdesignicons.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	
<meta name="generator" content="Nicepage 4.8.2, nicepage.com">
<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">


<script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": ""
}</script>
<meta name="theme-color" content="#478ac9">
<meta property="og:title" content="MOH">
<meta property="og:type" content="website">
</head>
<body class="u-body u-xl-mode">

			<script type="text/javascript">

var Msg ='<%=session.getAttribute("getAlert")%>';
				
				if (Msg != "null") {
					function alertName() {
						alert("Invalid credentials.\nPlease try again.");
					}
				}
			</script>
			<script type="text/javascript">
				window.onload = alertName;
			</script>

	<header class="u-clearfix u-header u-palette-1-dark-1 u-header"
		id="sec-0eff">
		<img class="u-image u-image-default u-preserve-proportions u-image-1"
			src="../images/icon.Png.png" alt="" data-image-width="1200"
			data-image-height="1200">
		<nav
			class="u-dropdown-icon u-menu u-menu-dropdown u-offcanvas u-menu-1">


			<div class="menu-collapse"
				style="font-size: 1rem; letter-spacing: 0px; font-weight: 700;">
				<a
					class="u-button-style u-custom-border u-custom-border-color u-custom-borders u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-text-active-color u-custom-text-color u-custom-text-hover-color u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base"
					href="#" style="padding: 4px 6px; font-size: calc(1em + 8px);">
					<svg class="u-svg-link" viewBox="0 0 24 24">
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
				<ul class="u-nav u-spacing-20 u-unstyled u-nav-1">
					<li class="u-nav-item"><a
						class="u-button-style u-nav-link u-text-active-white u-text-hover-white u-text-white"
						href="../homePage.jsp" style="padding: 10px;">Home</a></li>
					<li class="u-nav-item"><a
						class="u-button-style u-nav-link u-text-active-white u-text-hover-white u-text-white"
						href="../MOI/MOILogin.jsp" style="padding: 10px;">MOI</a></li>
					<li class="u-nav-item"><a
						class="u-button-style u-nav-link u-text-active-white u-text-hover-white u-text-white"
						href="../MOFA/MOFALogin.jsp" style="padding: 10px;">MOFA</a></li>
				</ul>
			</div>
			<div class="u-custom-menu u-nav-container-collapse">
				<div
					class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
					<div class="u-inner-container-layout u-sidenav-overflow">
						<div class="u-menu-close"></div>
						<ul
							class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2">
							<li class="u-nav-item"><a class="u-button-style u-nav-link"
								href="../homePage.jsp">Home</a></li>
							<li class="u-nav-item"><a class="u-button-style u-nav-link"
								href="../MOI/MOILogin.jsp">MOI</a></li>
							<li class="u-nav-item"><a class="u-button-style u-nav-link"
								href="../MOFA/MOFALogin.jsp">MOFA</a></li>
						</ul>
					</div>
				</div>
				<div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
			</div>
		</nav>
	</header>
	<section class="u-clearfix u-section-1" id="sec-b3ce">
		<div class="u-clearfix u-sheet u-sheet-1">
			<img class="u-image u-image-default u-preserve-proportions u-image-1"
				src="../images/MOHlogo1-14.jpg" alt="" data-image-width="232"
				data-image-height="217">
			<div class="u-align-center u-form u-grey-5 u-radius-15 u-form-1">
				<form action="../MOHLogin" method="POST"
					class="u-clearfix u-form-custom-backend u-form-spacing-10 u-form-vertical u-inner-form"
					source="custom" name="form" style="padding: 10px;" redirect="true" id="loginForm">
					<div class="u-form-email u-form-group">
						<label for="email-b96c" class="u-label">Email</label> <input
							type="email" placeholder="Enter a valid email address"
							id="email-b96c" name="emailMOH"
							class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"
							required>
					</div>
					<div class="u-form-group u-form-name">
						<label for="name-b96c" class="u-label">Password</label>
						 <input
							type="password" placeholder="Enter Password" id="name-b96c"
							name="PasswordMOH"
							class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"
							required>
						
					</div>
					<div class="u-align-center u-form-group u-form-submit">
						<br>
						<div class="u-align-center">

							<input type="submit" value="Login"
								class="u-align-center u-border-none u-btn u-btn-round u-button-style u-custom-color-1 u-hover-custom-color-1 u-radius-6 u-text-grey-5 u-btn-2">
						</div>

					</div>

				</form>
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
						<h6 class="text-uppercase fw-bold mb-4">Useful links</h6>
						<p>
							<a href="../homePage.jsp" class="text-reset">Home</a>
						</p>
						<p>
							<a href="../CLIENT/clientLogin.jsp" class="text-reset">Client Login</a>
						</p>
						<p>
							<a href="../contact-form-12/contactUs.html" class="text-reset">Contact us</a>
						</p>
						<p>
							<a href="../about-us-page/aboutUs.html" class="text-reset">About us</a>
						</p>
					</div>
					<!-- Grid column -->

					<!-- Grid column -->
					<div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
						<!-- Links -->
						<h6 class="text-uppercase fw-bold mb-4">Employees</h6>
						<p>
							<a href="MOHLogin.jsp" class="text-reset">MOH</a>
						</p>
						<p>
							<a href="../MOFA/MOFALogin.jsp" class="text-reset">MOFA</a>
						</p>
						<p>
							<a href="../MOI/MOILogin.jsp" class="text-reset">MOI</a>
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
				href="https://mdbootstrap.com/">Hayykum&trade;</a>
		</div>
		<!-- Copyright -->
	</footer>
	<!-- Footer -->
</body>
</html>