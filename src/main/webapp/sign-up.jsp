<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="icon" type="image/png" href="images/icons/favicon.ico" />

<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css"
	href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">

<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">

<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">

<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">

<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('images/img-01.jpg');">
			<div class="wrap-login100 p-t-190 p-b-30">
				<form class="login100-form validate-form" action="docreate.html"
					autocomplete="on" method="post" modelAttribute="userDTO">
					<div class="wrap-input100 validate-input m-b-10"
						data-validate="Username is required">
						<input class="input100" type="text" name="username"
							placeholder="Username"> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-user"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input m-b-10"
						data-validate="Password is required">
						<input class="input100" type="text" name="password"
							placeholder="Password"> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-lock"></i>
						</span>
					</div>

					<div class="wrap-input100 m-b-10">
						<input class="input100" type="text" name="name" placeholder="Name">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 m-b-10">
						<input class="input100" type="text" name="phone_no"
							placeholder="Phone Number"> <span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-10"
						data-validate="Date of Birth is required">
						<input class="input100" type="text" name="dob"
							placeholder="Date of Birth, must be mm/dd/yyyy"> <span
							class="focus-input100"></span>
					</div>

					<div class="container-login100-form-btn p-t-10">
						<button class="login100-form-btn">Sign up</button>
					</div>

					<div class="text-center w-full">
						<a class="txt1" href="login.html"> Go back and log in <i
							class="fa fa-long-arrow-left"></i>
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>




	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>

	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<script src="vendor/select2/select2.min.js"></script>

	<script src="js/main.js"></script>

</body>

</html>