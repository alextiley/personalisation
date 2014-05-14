<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Home</title>
		<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
	</head>
	<body>
		<h1>Personalisation Service</h1>
		<p class="status">Requesting personalised products from web service...</p>
		
		<script>

			function output($output) {
				if ($output === undefined) {
					$('.status').append('an error occurred...logging to browser console...');
				} else {
					$('.status').append('done!');
					$('body').append('<p>' + $output + '</p>');	
				}
				
			}

			window.setTimeout(function () {
				$.ajax({
					url: 'customer/1',
					dataType: 'json',
					cache: false,
					success: function (data, xhr) {
						output(JSON.stringify(data));
					},
					error: function (xhr) {
						output();
						console.log(xhr);
					}
				});
			}, 1000);

		</script>
	</body>
</html>
