$(document).ready(function() {

	/*$(window).resize(function() {
		if ($(window).width() < 575) {
			alert("window");
			$("#headerToChange").removeClass("u-menu-dropdown u-offcanvas u-menu-1").addClass("u-menu-dropdown u-offcanvas u-menu-1 u-enable-responsive");
			$("#headerToChange").toggleClass('u-menu-dropdown u-offcanvas u-menu-1');
		}
	});*/



	// ajax to get full name
	$.ajax({
		method: "GET",
		url: "../clientPage",
		data: {},
	}).success(function(data) {



		var array = data.split(',');
		var fname = array[0];
		var lname = array[1];
		var dosesNO = array[5];

		$('#fullName').html(fname + " " + lname);
		$('#dosesNO').html(dosesNO);
	})
		.error(function() {
			//do error handling stuff
		});

	/************************************************************************* */
	/* ajax to get vaccine doses */
	$.ajax({
		method: "GET",
		url: "../clientPageVaccine",
		data: {},
	}).success(function(data) {


		//alert("data: " + data);

		var arr = data.split(',,'); // produces [{"vaccine type 1, vaccine expiry 1"},{"vaccine type 2, vaccine expiry 2"}]
		var htmlToBeAdded = "";
		for (let i = 0; i < arr.length - 1; i++) {
			var dose = arr[i].split(','); // produces array of [vaccine type , vaccine expiry]
			var doseType = dose[0];
			var doseExpiry = dose[1];
			$('#latestDoseType').html(doseType);
			$('#latestDoseExpiry').html(doseExpiry);
			htmlToBeAdded += "<tr style='height: 111px;'>";
			htmlToBeAdded += "<td class='u-table-cell'>";
			htmlToBeAdded += "<div";
			htmlToBeAdded += " class='u-align-center u-border-2 u-border-black u-container-style u-group u-radius-26 u-shape-round u-white u-group-7'>";
			htmlToBeAdded += "<div class='u-container-layout u-container-layout-20'>";
			htmlToBeAdded += "<p";
			htmlToBeAdded += " class='u-align-center u-text u-text-default-lg u-text-default-md u-text-default-sm u-text-default-xl u-text-25'>Vaccine";
			htmlToBeAdded += " Dose:&nbsp;</p>";
			htmlToBeAdded += "<p class='u-text u-text-26'>" + doseType + "</p>";
			htmlToBeAdded += "<p";
			htmlToBeAdded += " class='u-align-center u-text u-text-default u-text-27'>Expiration";
			htmlToBeAdded += "Date:&nbsp;</p>";
			htmlToBeAdded += "<p";
			htmlToBeAdded += " class='u-align-center u-text u-text-default u-text-28'>" + doseExpiry + "</p>";
			htmlToBeAdded += "</div>";
			htmlToBeAdded += "</div>";
			htmlToBeAdded += "</td>";
			htmlToBeAdded += "</tr>";


		}


		$('#tableBody').html(htmlToBeAdded);
	})
		.error(function() {
			//do error handling stuff
		});

	$("#viewGuideLines").click(function(e) {

		Swal.fire({
			title: 'Vaccine advice',
			icon: 'info',
			html:
				'Safe and effective vaccines are available that provide strong protection against serious illness hospitalization and death from COVID-19.<br><br>'
				+ 'Billions of people have been vaccinated against COVID-19.Getting vaccinated is one of the most important things you can do to protect yourself against COVID- 19.<br><br>'
				+ 'Help end the pandemic and stop new variants emerging.',

			confirmButtonText: 'Read more',
		}).then((result) => {
			/* Read more about isConfirmed, isDenied below */
			if (result.isConfirmed) {
				var win = window.open('https://www.who.int/emergencies/diseases/novel-coronavirus-2019/covid-19-vaccines/advice', '_blank');
				if (win) {
					//Browser has allowed it to be opened
					win.focus();
				} else {
					//Browser has blocked it
					alert('Please allow popups for this website');
				}
			}
		});


	});
	

	$("#viewMOHDashboard").click(function(e) {
		var win = window.open('https://covid19.moh.gov.sa/', '_blank');
		if (win) {
			//Browser has allowed it to be opened
			win.focus();
		} else {
			//Browser has blocked it
			alert('Please allow popups for this website');
		}



	});








});