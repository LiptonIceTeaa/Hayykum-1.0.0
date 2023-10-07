<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<meta name="description" content="">
<meta name="page_type" content="np-template-header-footer-from-plugin">
<title>MOI Query</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" href="../css/nicePage.css" media="screen">
<link rel="stylesheet" href="../css/MOIPage.css" media="screen">
<meta name="generator" content="Nicepage 4.8.2, nicepage.com">
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="sweetalert2.all.min.js"></script>
<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<link id="u-page-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<link id="u-page-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">

<script type="text/javascript" src="../js/MOHQueryJS.js"></script>	

<script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": ""
}</script>
<meta name="theme-color" content="#478ac9">
<meta property="og:title" content="MOI Query">
<meta property="og:type" content="website">
</head>
<body class="u-body u-xl-mode">
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if (session.getAttribute("MOIEmployeeEmail") == null) {

		response.sendRedirect("MOILogin.jsp");
	}
	%>

	<script type="text/javascript">

var Msg ='<%=session.getAttribute("getAlertMOIQueryUserDoesntExist")%>';
var Msg3 ='<%=session.getAttribute("mainStrMOI")%>';



	
	
				

				function alertName() {
					
					if(Msg3 !="null"){
						$("p#queryResultsTemplate").html(Msg3);
						//document.getElementById('queryResultsTemplate').value='testo deezo';
						<%session.removeAttribute("mainStrMOI");%>
					}
					
					if (Msg != "null") {
						//alert("User doesnt exist.\nYou will be directed to create a user.");
						Swal.fire({
						  title: 'Passport does not exist!',
						  icon: 'error',
						  confirmButtonText: 'Ok',
						}).then((result) => {
						  /* Read more about isConfirmed, isDenied below */
						  if (result.isConfirmed) {
							  window.location.href = "MOIPage.jsp";
							  <%session.removeAttribute("getAlertMOIQueryUserDoesntExist");%>
						  }
						});
					

						
						  <%session.removeAttribute("getAlertMOIQueryUserDoesntExist");%>
				}

					<%session.removeAttribute("getAlertMOIQueryUserDoesntExist");%>
				}
				
			</script>

	<script type="text/javascript">
				window.onload = alertName;
			</script>
	<header class="u-clearfix u-header u-palette-1-dark-1 u-header"
		id="sec-0eff">
		<a href="../clientLogout"> <img
			class="u-image u-image-default u-preserve-proportions u-image-1"
			src="../images/icon.Png.png" href="../clientLogout" alt=""
			data-image-width="1200" data-image-height="1200">
		</a>
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
	<section
		class="u-align-center u-clearfix u-typography-Normal--Introduction u-section-1"
		src="" id="carousel_8b49">
		<div class="u-clearfix u-sheet u-sheet-1">
			<img class="u-image u-image-default u-preserve-proportions u-image-1"
				src="../images/MOIlogo1.png" alt="" data-image-width="225"
				data-image-height="225">
			<div
				class="u-border-2 u-border-white u-form u-grey-5 u-radius-16 u-form-1">
				<form action="../MOIQueryRecord" method="POST"
					class="u-clearfix u-form-spacing-10 u-form-vertical u-inner-form"
					name="form" style="padding: 10px;">
					<div class="u-form-group u-form-name">
						<label for="name-628c" class="u-label">Search By Passport
							Number:</label> <input type="text" placeholder="Passport Number"
							id="name-628c" name="passportNO"
							class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"
							required>
					</div>
					<div class="u-form-checkbox u-form-group u-form-group-2">
						<input type="checkbox" id="checkbox-7a1e" name="checkbox"
							value="On"> <label for="checkbox-7a1e" class="u-label">Display
							All Previous Records</label>
					</div>
					<div class="u-align-left u-form-group u-form-submit">
						<input type="submit" value="View"
							class="u-border-none u-btn u-btn-submit u-button-style u-custom-color-2 u-btn-2">
					</div>
				</form>
			</div>

			<div
				class="u-container-style u-grey-5 u-group u-shape-rectangle u-group-1">
				<div class="u-container-layout u-container-layout-1"
					style="max-height: 100%">
					<p class="u-align-center u-text u-text-1" style="font-weight: bold">Record</p>
					<div style="max-height: 100%">
						<p id="queryResultsTemplate" style="max-height: 25rem; overflow-y: scroll; Overflow-X: scroll;">
								
						</p>
						<div>
							<button id="showPopup">Show as a popup</button>
						</div>
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