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
<title>Home Page</title>
<link rel="stylesheet" href="../css/nicePage.css" media="screen">
<link rel="stylesheet" href="clientPage.css" media="screen">
<link rel="stylesheet" href="../css/clientPage.css" media="screen">
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
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="../js/MOHPageJS.js"></script>
<script type="text/javascript" src="../js/clientPageJS.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script type="text/javascript" src="../js/nicePage.js"></script>





<script type="application/ld+json">{
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
	if(!url.equals("http://localhost:8080/Hayykum_1.0.0/CLIENT/userProfile.jsp")){

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
			if (Msg3 != "null") {

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
							class="u-button-style u-nav-link u-text-active-black u-text-black"
							href="userProfile.jsp" style="color: black" id="profileHeaderToShowMinimized">Profile</a></li>
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-black u-text-black"
							href="../about-us-page/aboutUs.html" style="color: black">About
								Us</a></li>
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-black u-text-black"
							href="../contact-form-12/contactUs.html" style="color: black">Contact
								US</a></li>
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
								<li class="u-nav-item" style="color: black"><a
									class="u-button-style u-nav-link" href="../homePage.jsp"
									style="color: black">Home Page</a></li>
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="../about-us-page/aboutUs.html" style="color: black">About
										Us</a></li>
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="../contact-form-12/contactUs.html" style="color: black">Contact
										US</a></li>
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
												src="../images/5.png" alt=""></span> <a href="clientPage.jsp">
												<h6
													class="u-custom-font u-font-lato u-text u-text-default u-text-grey-15 u-text-1">Home</h6>
											</a>
										</div>
									</div>
									<div class="u-container-style u-list-item u-repeater-item">
										<div
											class="u-container-layout u-similar-container u-valign-top u-container-layout-3">
											<span
												class="u-file-icon u-icon u-text-palette-1-base u-icon-2"><img
												src="../images/logo.png1.png" alt=""></span> <a
												href="https://ta.sdaia.gov.sa/en/index">

												<h6
													class="u-custom-font u-font-lato u-text u-text-default u-text-grey-15 u-text-2">Tawakklna</h6>
											</a>
										</div>
									</div>
									<div class="u-container-style u-list-item u-repeater-item">
										<div
											class="u-container-layout u-similar-container u-valign-top u-container-layout-4">
											<span class="u-file-icon u-icon u-text-grey-25 u-icon-3"><img
												src="../images/7.png" alt=""></span> <a
												href="userProfile.jsp">
												<h6
													class="u-custom-font u-font-lato u-text u-text-default u-text-grey-15 u-text-3">Profile</h6>
											</a>
										</div>
									</div>
									<div class="u-container-style u-list-item u-repeater-item">
										<div
											class="u-container-layout u-similar-container u-valign-top u-container-layout-5">
											<span class="u-file-icon u-icon u-text-grey-25 u-icon-4"><img
												src="../images/8.png" alt=""></span> <a
												href="../clientLogout">
												<h6
													class="u-custom-font u-font-lato u-text u-text-default u-text-grey-15 u-text-4">Logout</h6>
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
								class="u-container-style u-expanded-width-xl u-group u-radius-10 u-shape-round u-white u-group-2">
								<div class="u-container-layout u-container-layout-8">
									<h5
										class="u-custom-font u-font-lato u-text u-text-default u-text-9">Your
										doses</h5>
									<div
										class="u-expanded-width u-table u-table-responsive u-table-1">
										<table class="u-table-entity">
											<tbody class="u-table-body" id="tableBody">

											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div
						class="u-container-style u-layout-cell u-size-15-xl u-size-16-lg u-size-16-md u-size-16-sm u-size-16-xs u-layout-cell-3">
						<div class="u-container-layout u-container-layout-9">
							<div
								class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xl u-container-style u-gradient u-group u-radius-10 u-shape-round u-group-3">
								<div class="u-container-layout u-container-layout-10">
									<p
										class="u-align-center u-text u-text-default u-text-grey-5 u-text-10">Latest
										Dose:</p>
									<p
										class="u-custom-font u-font-lato u-text u-text-default-xs u-text-grey-5 u-text-11"
										id="latestDoseType">
										P<span style="font-weight: 700;"></span>fizer
									</p>
									<p
										class="u-align-center u-custom-font u-font-lato u-text u-text-default u-text-grey-5 u-text-12">Vaccination
										expiry:</p>
									<p
										class="u-align-center u-custom-font u-font-lato u-text u-text-default u-text-grey-5 u-text-13"
										id="latestDoseExpiry">12/12/12</p>
								</div>
							</div>
							<div class="u-hidden-xs u-list u-list-2">
								<div class="u-repeater u-repeater-2">
									<div class="u-container-style u-list-item u-repeater-item">
										<div
											class="u-container-layout u-similar-container u-container-layout-11">
											<div
												class="u-absolute-hcenter u-align-center u-container-style u-custom-item u-expanded u-group u-radius-10 u-shape-round u-white u-group-4">
												<div class="u-container-layout u-container-layout-12">
													<p
														class="u-custom-font u-custom-item u-font-lato u-text u-text-14">Total
														number of doses:</p>
													<img
														class="u-image u-image-default u-preserve-proportions u-image-1"
														src="../images/30.png" alt="" data-image-width="128"
														data-image-height="128" style="display: none">
													<p
														class="u-custom-font u-custom-item u-font-lato u-text u-text-15"
														id="dosesNO"></p>
													<img
														class="u-image u-image-default u-preserve-proportions u-image-5"
														src="../images/24.png" alt="" data-image-width="150"
														data-image-height="94">
												</div>
											</div>
										</div>
									</div>
									<div class="u-container-style u-list-item u-repeater-item">
										<div
											class="u-container-layout u-similar-container u-container-layout-13">
											<div
												class="u-align-center u-container-style u-custom-item u-expanded u-group u-radius-10 u-shape-round u-white u-group-5">
												<div class="u-container-layout u-container-layout-14">
													<p
														class="u-custom-font u-custom-item u-font-lato u-text u-text-16">View
														Vaccine&nbsp;Advice</p>
													<img
														class="u-image u-image-default u-preserve-proportions u-image-3"
														src="../images/30.png" alt="" data-image-width="128"
														data-image-height="128">
													<p
														class="u-custom-font u-custom-item u-font-lato u-text u-text-17">
														COVID-19 advice for the public<span
															style="font-weight: 400;"> &nbsp;</span>
													</p>
													<a id="viewGuideLines" href="#"> <img
														class="u-image u-image-default u-preserve-proportions u-image-5"
														src="../images/6982988.png" alt="" data-image-width="150"
														data-image-height="94">
													</a>
												</div>
											</div>
										</div>
									</div>
									<div class="u-container-style u-list-item u-repeater-item">
										<div
											class="u-container-layout u-similar-container u-container-layout-15">
											<div
												class="u-absolute-hcenter u-align-center u-container-style u-custom-item u-expanded u-group u-radius-10 u-shape-round u-white u-group-6">
												<div class="u-container-layout u-container-layout-16">
													<p
														class="u-custom-font u-custom-item u-font-lato u-text u-text-18">MOH
														COVID-19 Dashboard</p>
													<img
														class="u-image u-image-default u-preserve-proportions u-image-4"
														src="../images/30.png" alt="" data-image-width="128"
														data-image-height="128">
													<p
														class="u-custom-font u-custom-item u-font-lato u-text u-text-19">
														<br>
													</p>
													<a href="#" id="viewMOHDashboard"> <img
														class="u-image u-image-default u-preserve-proportions u-image-5"
														src="../images/mohlogoosanos.png" alt=""
														data-image-width="150" data-image-height="94">
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div data-interval="5000" data-u-ride="carousel"
								class="u-carousel u-hidden-lg u-hidden-md u-hidden-sm u-hidden-xl u-slider u-slider-1"
								id="carousel-c527">
								<ol
									class="u-absolute-hcenter u-carousel-indicators u-carousel-indicators-1">
									<li data-u-target="#carousel-c527"
										class="u-active u-active-grey-10 u-grey-30"
										data-u-slide-to="0"></li>
									<li data-u-target="#carousel-c527"
										class="u-active-grey-10 u-grey-30" data-u-slide-to="1"></li>
									<li data-u-target="#carousel-c527"
										class="u-active-grey-10 u-grey-30" data-u-slide-to="2"></li>
								</ol>
								<div class="u-carousel-inner" role="listbox">
									<div
										class="u-active u-align-center-xs u-carousel-item u-container-style u-slide">
										<div class="u-container-layout u-container-layout-17">
											<p
												class="u-custom-font u-font-lato u-text u-text-default-xs u-text-20">
												Number O<span style="font-size: 1.125rem;"> <span
													style="font-weight: 700;"></span>
												</span>f Doses
											</p>
											<p
												class="u-custom-font u-font-lato u-text u-text-default-xs u-text-21">2</p>
											<img
												class="u-image u-image-default u-preserve-proportions u-image-6"
												src="../images/24-12.png" alt="" data-image-width="128"
												data-image-height="128">
										</div>
									</div>
									<div class="u-carousel-item u-container-style u-slide">
										<div class="u-container-layout u-container-layout-18">
											<p
												class="u-custom-font u-font-lato u-text u-text-default-xs u-text-22">View
												Our Guidlines</p>
											<p class="u-custom-font u-font-lato u-text u-text-23">
												Description of Hayykum guidlines<span
													style="font-style: italic;"></span>
											</p>
											<img
												class="u-image u-image-default u-preserve-proportions u-image-7"
												src="../images/6982988.png" alt="" data-image-width="128"
												data-image-height="128">
										</div>
									</div>
									<div
										class="u-carousel-item u-container-style u-slide u-carousel-item-3">
										<div class="u-container-layout u-container-layout-19">
											<p
												class="u-custom-font u-font-lato u-text u-text-default-xs u-text-24">MOH
												COVID-19 DASHBOARD</p>
											<img
												class="u-image u-image-default u-preserve-proportions u-image-8"
												src="../images/mohlogoosanos-14.png" alt=""
												data-image-width="121" data-image-height="76">
										</div>
									</div>
								</div>
								<a
									class="u-absolute-vcenter u-carousel-control u-carousel-control-prev u-spacing-5 u-text-grey-30 u-carousel-control-1"
									href="#carousel-c527" role="button" data-u-slide="prev"> <span
									aria-hidden="true"> <svg viewBox="0 0 477.175 477.175">
											<path
												d="M145.188,238.575l215.5-215.5c5.3-5.3,5.3-13.8,0-19.1s-13.8-5.3-19.1,0l-225.1,225.1c-5.3,5.3-5.3,13.8,0,19.1l225.1,225
                    c2.6,2.6,6.1,4,9.5,4s6.9-1.3,9.5-4c5.3-5.3,5.3-13.8,0-19.1L145.188,238.575z"></path></svg>
								</span> <span class="sr-only">Previous</span>
								</a> <a
									class="u-absolute-vcenter u-carousel-control u-carousel-control-next u-spacing-5 u-text-grey-30 u-carousel-control-2"
									href="#carousel-c527" role="button" data-u-slide="next"> <span
									aria-hidden="true"> <svg viewBox="0 0 477.175 477.175">
											<path
												d="M360.731,229.075l-225.1-225.1c-5.3-5.3-13.8-5.3-19.1,0s-5.3,13.8,0,19.1l215.5,215.5l-215.5,215.5
                    c-5.3,5.3-5.3,13.8,0,19.1c2.6,2.6,6.1,4,9.5,4c3.4,0,6.9-1.3,9.5-4l225.1-225.1C365.931,242.875,365.931,234.275,360.731,229.075z"></path></svg>
								</span> <span class="sr-only">Next</span>
								</a>
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
						utilizing block chain technology.</p>
					</div>
					<!-- Grid column -->

					<!-- Grid column -->
					<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
						<!-- Links -->
						<h6 class="text-uppercase fw-bold mb-4" style="color: grey">Useful
							links</h6>
						<p>
							<a href="homePage.jsp" class="text-reset" style="color: grey">Home</a>
						</p>
						<p>
							<a href="CLIENT/clientLogin.jsp" class="text-reset"
								style="color: grey">Client Login</a>
						</p>
						<p>
							<a href="contact-form-12/contactUs.html" class="text-reset"
								style="color: grey">Contact us</a>
						</p>
						<p>
							<a href="about-us-page/aboutUs.html" class="text-reset"
								style="color: grey">About us</a>
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
							<a href="MOFA/MOFALogin.jsp" class="text-reset"
								style="color: grey">MOFA</a>
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
			© 2022 Copyright: <a class="text-reset fw-bold" href="#">Hayykum&trade;</a>
		</div>
		<!-- Copyright -->
	</footer>
	<!-- Footer -->
</body>
</html>