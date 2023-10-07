<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<meta name="description" content="">
<meta name="page_type" content="np-template-header-footer-from-plugin">
<title>MOH Query</title>
<link rel="stylesheet" href="../css/nicePage.css" media="screen">
<link rel="stylesheet" href="../css/MOHQuery.css" media="screen">
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="sweetalert2.all.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<meta name="generator" content="Nicepage 4.8.2, nicepage.com">
<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<script type="text/javascript" src="../js/MOHQueryJS.js"></script>

<script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": ""
}</script>
<meta name="theme-color" content="#478ac9">
<meta property="og:title" content="MOH Query">
<meta property="og:type" content="website">
</head>
<body class="u-body u-xl-mode">
	<header class="u-clearfix u-header u-palette-1-dark-1 u-header"
		id="sec-0eff">
		<img class="u-image u-image-default u-preserve-proportions u-image-1"
			src="../images/icon.Png.png" alt="" data-image-width="1200"
			data-image-height="1200">
		<nav
			class="u-dropdown-icon u-menu u-menu-dropdown u-offcanvas u-menu-1">

			<%
			if (session.getAttribute("MOHEmployeeEmail") == null) {

				response.sendRedirect("MOHLogin.jsp");
			}
			%>


			<script type="text/javascript">

var Msg ='<%=session.getAttribute("MOHQueryUserDoesntExist")%>';
var Msg2 ='<%=session.getAttribute("MOHQueryUserExist")%>';
var Msg3 ='<%=session.getAttribute("mainStr")%>';

	


				

				function alertName() {
						
					/* filling inside of query results div */
					if(Msg3 != "null"){
						
						$("p#queryResultsTemplate").html(Msg3);
						//document.getElementById('queryResultsTemplate').value='testo deezo';
						<%session.removeAttribute("mainStr");%>
						
					}
					<%session.removeAttribute("mainStr");%>
					
					if (Msg != "null") {
						//alert("User doesnt exist.\nYou will be directed to create a user.");
						Swal.fire({
						  title: 'Passport does not exist!',
						  icon: 'error',
						  html:
							    'You will be redirected to <b>create user</b>, ' +
							    'with the entered passport number. ',
						  showDenyButton: true,
						  confirmButtonText: 'Go',
						  denyButtonText: 'Stay here',
						}).then((result) => {
						  /* Read more about isConfirmed, isDenied below */
						  if (result.isConfirmed) {
							  window.location.href = "MOHCreate.jsp";
							  <%session.removeAttribute("MOHQueryUserDoesntExist");%>
						  } else if (result.isDenied) {
							  window.location.href = "MOHQuery.jsp";
							  <%session.removeAttribute("MOHQueryUserDoesntExist");%>
						  }
						});
					

						
						  <%session.removeAttribute("MOHQueryUserDoesntExist");%>
				}

					<%session.removeAttribute("getAlertMOHAddDoseSucess");%>
					  <%session.removeAttribute("MOHQueryUserDoesntExist");%>
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
			<div class="u-custom-menu u-nav-container"></div>
			<div class="u-custom-menu u-nav-container-collapse">
				<div
					class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
					<div class="u-inner-container-layout u-sidenav-overflow">
						<div class="u-menu-close"></div>
					</div>
				</div>
				<div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
			</div>
		</nav>
	</header>
	<section
		class="u-align-center u-clearfix u-typography-Normal--Introduction u-section-1"
		id="carousel_8b49">
		<div class="u-clearfix u-sheet u-sheet-1">
			<img class="u-image u-image-default u-preserve-proportions u-image-1"
				src="../images/MOHlogo1-12.jpg" alt="" data-image-width="232"
				data-image-height="217">
			<div class="u-list u-list-1">
				<div class="u-repeater u-repeater-1"></div>
			</div>
			<div
				class="u-container-style u-grey-5 u-group u-shape-rectangle u-group-1">
				<div class="u-container-layout u-container-layout-1"
					style="max-height: 100%">
					<p class="u-align-center u-text u-text-1">Vaccine Record</p>
					<div style="max-height: 100%">
					<p id="queryResultsTemplate" style="max-height: 25rem; overflow-y: scroll;Overflow-X: scroll;">
					
					</p>
					<div>
					<button id="showPopup">Show as a popup</button>
					</div>
					</div>
				</div>
			</div>
			<div
				class="u-border-2 u-border-white u-form u-grey-5 u-radius-16 u-form-1">
				<form action="../MOHQueryRecord" method="POST"
					class="u-clearfix u-form-spacing-10 u-form-vertical u-inner-form" source="custom" name="form" style="padding: 10px;">
					<div class="u-form-group u-form-name">
						<label for="name-628c" class="u-label">Search By Passport
							Number:</label> <input type="text" placeholder="Passport Number"
							id="name-628c" name="passportNO"
							class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"
							required="">
					</div>
					<div class="u-form-checkbox u-form-group u-form-group-2"
						style="border-style: none !important;">
						<fieldset id="group1" name="radioGroup" required>
							<input type="radio" value="allRecords" name="group1" checked>
							All Records <br> <input type="radio" value="latestDose"
								name="group1"> Latest Vaccine Dose <br> <input
								type="radio" value="allDoses" name="group1"> Vaccine
							Doses

						</fieldset>
					</div>

					<div class="u-align-left u-form-group u-form-submit">

						<input type="submit" value="Query Record"
							class="u-border-none u-btn u-btn-submit u-button-style u-custom-color-2 u-btn-1">
					</div>
					<br>
				</form>
			</div>

			<span class="u-file-icon u-icon u-rotate-180 u-text-grey-50 u-icon-1"
				data-page-id="99841084"> <a href="MOHPage.jsp"> <img
					src="../images/11.png" alt="">
			</a>
			</span>

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