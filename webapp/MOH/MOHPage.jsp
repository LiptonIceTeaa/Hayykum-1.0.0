<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<meta name="description" content="">
<meta name="page_type" content="np-template-header-footer-from-plugin">
<title>MOH</title>
<link rel="icon" href="../images/icon.Png.png" type="image/icon type">
<link rel="stylesheet" href="../css/nicePage.css" media="screen">
<link rel="stylesheet" href="../css/MOHPage.css" media="screen">
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="sweetalert2.all.min.js"></script>
<script class="u-script" type="text/javascript" src="../js/jquery.js"
	defer=""></script>
<script class="u-script" type="text/javascript" src="../js/nicePage.js"
	defer=""></script>
<meta name="generator" content="Nicepage 4.8.2, nicepage.com">
<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<link id="u-page-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
<script src="sweetalert2.all.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
	</script>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<meta name="generator" content="Nicepage 4.8.2, nicepage.com">
<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<meta name="generator" content="Nicepage 4.8.2, nicepage.com">
<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<link id="u-page-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto+Slab:100,200,300,400,500,600,700,800,900|Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Playfair+Display:400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
<script type="text/javascript" src="../js/MOHPageJS.js"></script>

<script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": ""
}</script>
<meta name="theme-color" content="#478ac9">
<meta property="og:title" content="MOH Homepage">
<meta property="og:type" content="website">
</head>


<body class="u-body u-xl-mode">
	<header class="u-clearfix u-header u-palette-1-dark-1 u-header" 
		id="sec-0eff" style="">
		<img class="u-image u-image-default u-preserve-proportions u-image-1"
			src="../images/icon.Png.png" alt="" data-image-width="1200"
			data-image-height="1200">
		<nav
			class="u-dropdown-icon u-menu u-menu-dropdown u-offcanvas u-menu-1 ">
			<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

			if (session.getAttribute("MOHEmployeeEmail") == null) {

				response.sendRedirect("MOHLogin.jsp");
			}
			%>

			<script type="text/javascript">

var employeeEmail = '<%=session.getAttribute("MOHEmployeeEmail")%>';
				

				function alertName() {
					
					document.getElementById('emailHolder').text=employeeEmail	;
				}
			</script>

			<script type="text/javascript">
				window.onload = alertName;
			</script>

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
					
					<li class="u-nav-item">
						<div class="dropdown show">
							<a
								class="u-button-style u-nav-link u-text-active-white u-text-custom-color-3 u-text-hover-black active"
								aria-pressed="true" href="#" role="button" id="emailHolder"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> Email holder </a>

							<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
								<a class="dropdown-item" href="#" style="color: black"
									id="dropDownViewProfile">View profile</a>

								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="../clientLogout"
									style="color: black">Logout</a>
							</div>
						</div>
					</li>
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
								href="clientLogout" id="employeeNameHolder">Name holder</a></li>
							<li class="u-nav-item"><a class="u-button-style u-nav-link"
								href="clientLogout">Logout</a></li>
						</ul>
					</div>
				</div>
				<div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
			</div>
		</nav>
	</header>
	<section
		class="u-align-center u-clearfix u-typography-Normal--Introduction u-white u-section-1"
		src="" id="carousel_8b49">
		<div class="u-clearfix u-sheet u-sheet-1">
			<img class="u-image u-image-default u-preserve-proportions u-image-1"
				src="../images/MOHlogo1.jpg" alt="" data-image-width="232"
				data-image-height="217">
			<div
				class="u-border-6 u-border-custom-color-2 u-line u-line-horizontal u-line-1"></div>
			<div class="u-list u-list-1">
				<div class="u-repeater u-repeater-1">
					<div
						class="u-align-center u-container-style u-grey-5 u-hover-feature u-list-item u-repeater-item u-shape-rectangle u-list-item-1"
						data-href="MOHCreate.jsp" data-page-id="130864484"
						data-target="_blank">
						<div
							class="u-container-layout u-similar-container u-container-layout-1">
							<span
								class="u-file-icon u-icon u-spacing-20 u-text-custom-color-2 u-icon-1"><img
								src="../images/4.png" alt=""></span>
							<h3 class="u-align-center u-text u-text-default u-text-1">
								Create Record</h3>
						</div>
					</div>
					<div
						class="u-container-style u-grey-5 u-hover-feature u-list-item u-repeater-item u-shape-rectangle u-list-item-2"
						data-href="MOHQuery.jsp" data-page-id="155304608"
						data-target="_blank">
						<div
							class="u-container-layout u-similar-container u-container-layout-2">
							<span
								class="u-file-icon u-icon u-spacing-20 u-text-custom-color-2 u-icon-2"><img
								src="../images/5.png" alt=""></span>
							<h3 class="u-align-center u-text u-text-default u-text-2">Query
								Record</h3>
						</div>
					</div>
					<div
						class="u-align-center u-container-style u-grey-5 u-hover-feature u-list-item u-repeater-item u-shape-rectangle u-list-item-3"
						data-href="MOHUpdate.jsp" data-page-id="983109684"
						data-target="_blank">
						<div
							class="u-container-layout u-similar-container u-container-layout-3">
							<span
								class="u-file-icon u-icon u-spacing-20 u-text-custom-color-2 u-icon-3"><img
								src="../images/6.png" alt=""></span>
							<h3 class="u-align-center u-text u-text-default u-text-3">Update
								Record</h3>
						</div>
					</div>
				</div>
			</div>
			<div class="u-list u-list-2">
				<div class="u-repeater u-repeater-2">
					<div
						class="u-container-style u-grey-5 u-hover-feature u-list-item u-repeater-item u-shape-rectangle u-list-item-4"
						data-href="MOHAddDose.jsp" data-page-id="33650522">
						<div
							class="u-container-layout u-similar-container u-container-layout-4">
							<span
								class="u-file-icon u-icon u-spacing-20 u-text-custom-color-1 u-icon-4"><img
								src="../images/7.png" alt=""></span>
							<h5 class="u-align-center u-text u-text-default u-text-4">
								<span style="font-weight: 700;">Add </span> <span
									style="font-weight: 700;">Dose</span>
							</h5>
						</div>
					</div>
					<div>
					</div>
					
				</div>
			</div>
			

		</div>




	</section>


	<footer
		class="u-align-center u-clearfix u-footer u-palette-1-light-1 u-footer"
		id="sec-bd66">
		<div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
			<p class="u-small-text u-text u-text-variant u-text-1">
				Developed by the Hayyakum Co. Team Members.<br>For Contact:
				+966567471314 Email:hsalamah@alfaisal.edu
			</p>
		</div>
	</footer>
	


</body>
</html>