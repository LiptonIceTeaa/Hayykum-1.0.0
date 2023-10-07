$(document).ready(function() {
	


	$("#showPopup").click(function(e) {
		var info = $('#queryResultsTemplate').html();
		Swal.fire({
						  title: 'Query result',
						  icon: 'info',
						  html:
							    info,
						  
						  confirmButtonText: 'Ok',
						}).then((result) => {
						  /* Read more about isConfirmed, isDenied below */
						  if (result.isConfirmed) {	  
						  }
						});
		
	});

});