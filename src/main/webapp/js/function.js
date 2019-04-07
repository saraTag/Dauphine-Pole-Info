	function templateJS() {

	$(document).ready(function() {
		// Activate tooltip
		$('[data-toggle="tooltip"]').tooltip();

		// Select/Deselect checkboxes
		var checkbox = $('table tbody input[type="checkbox"]');
		$("#selectAll").click(function() {
			if (this.checked) {
				checkbox.each(function() {
					this.checked = true;
				});
			} else {
				checkbox.each(function() {
					this.checked = false;
				});
			}
		});
		checkbox.click(function() {
			if (!this.checked) {
				$("#selectAll").prop("checked", false);
			}
		});
	});

	function formatParams(params) {
		return "?" + Object.keys(params).map(function(key) {
			return key + "=" + encodeURIComponent(params[key])
		}).join("&")
	}

	function addFunction() {
		var request = new XMLHttpRequest();
		var f1 = document.getElementById('Name').value;
		var f2 = document.getElementById('Description').value;
		var params = {
			name : f1,
			description : f2
		};
		var url = formatParams(params);
		var url1 = "http://localhost:8080/Dauphine-Pole-Info/myapp/addMaster";
		var url2 = url1 + url;
		request.open("POST", url2, true);
		request.send(null);
		document.location.href = "ManageMaster.html";

	}

	function updateFunction() {
		var request = new XMLHttpRequest();
		var f1 = document.getElementById('id').value;
		var f2 = document.getElementById('Name').value;
		var f3 = document.getElementById('Description').value;
		var params = {
			id : f1,
			name : f2,
			description : f3
		};
		var url = formatParams(params);
		var url1 = "http://localhost:8080/Dauphine-Pole-Info/myapp/UpdateMaster";
		var url2 = url1 + url;
		request.open("PUT", url2, true);
		request.send(null);
		document.location.href = "ManageMaster.html";

	}

	function deleteFunction() {
		var request = new XMLHttpRequest();
		var f1 = document.getElementById('id').value;
		var params = {
			id : f1
		};
		var url = formatParams(params);
		var url1 = "http://localhost:8080/Dauphine-Pole-Info/myapp/DeleteMaster";
		var url2 = url1 + url;
		request.open("DELETE", url2, true);
		request.send(null);
		document.location.href = "ManageMaster.html";

	}

}