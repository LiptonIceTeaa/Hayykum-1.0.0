$(document).ready(function() {
	
	
	
	$('#dropDoenMenu').change(function() {
		autoFillPreviousField();
		var color = $('#dropDoenMenu').val();
		if (color !== "doseNumber") {

			$("#oldValField").prop('disabled', true);
		} else {
			$("#oldValField").prop('disabled', false);
		}

	});
	$('#passportInput').change(function() {
			var passportNO = $('#passportInput').val();

			

			var changeType = $('#dropDoenMenu').val();

			$.ajax({
				method: "GET",
				url: "../MOHUpdateRecord",
				data: { passportNO: passportNO, changeType: changeType },
			})
				.success(function(data) {
					
					$('#oldValField').val(data);
				})
				.error(function() {
					//do error handling stuff
				});
		});

	function autoFillPreviousField() {
		
		
			var passportNO = $('#passportInput').val();

			

			var changeType = $('#dropDoenMenu').val();

			$.ajax({
				method: "GET",
				url: "../MOHUpdateRecord",
				data: { passportNO: passportNO, changeType: changeType },
			})
				.success(function(data) {
					
					$('#oldValField').val(data);
				})
				.error(function() {
					//do error handling stuff
				});
		
	}

});