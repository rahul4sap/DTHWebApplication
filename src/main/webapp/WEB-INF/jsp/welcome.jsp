<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <title>Welcome ${name}</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  </style>
</head>
<body>

<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#">DTH USER DETAILS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About</a>
      </li>
    </ul>
  </div>
</nav>

<div class="container">

<h5><span class="badge badge-secondary">Host Name     </span>: <span id="hostName"></span></h5>
<h5><span class="badge badge-secondary">Host Address  </span>: <span id="hostAddress"></span></h5>

<br>
<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    SELECT USER
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
  	<c:forEach items="${users}" var="user">
  		<a class="dropdown-item" id="${user.id}" href="#">${user.name}</a>
	</c:forEach>
  </div>
</div>
<br><br>

  <div class="row">
    <div class="col-sm-4">
      <h5><span class="badge badge-secondary">User ID</span>: <span id="userID"></span></h5>
      <h5><span class="badge badge-secondary">Name   </span>: <span id="userName"></span></h5>
   	  <button type="button" class="btn btn-primary" id="getAddress">RETRIEVE ADDRESS</button>
      <h4 id="addressHeader"><span class="badge badge-secondary">Address</span></h4>
      <h5><span id="addressPlaceHolder"></span></h5>
      <ul id="addressItems" class="list-group"></ul>
    </div>
    <div class="col-sm-8">
      <h2>SUBSCRIBED CHANNELS</h2>
      <h5><span id="datePlaceHolder"></span></h5>
      	<ul id="channelsList" class="list-group">
  		</ul>
     </div>
  </div>
  
   
</div>
</body>

<script>
$(document).ready(function(){
	    var hostUrl = "/host";
		$.ajax({
  				url: hostUrl, 
  				dataType: 'json',
  				success: function(result){
  					$("#hostName").empty();
  					$("#hostAddress").empty();
  					$("#hostName").text(result.hostName);
  					$("#hostAddress").text(result.hostAddress);
  				}
  		});


	$("#addressHeader").hide();

	$("a[id]").on("click",function(){
		$("#addressHeader").hide();
		$("#addressItems").empty();
		var id = $(this).attr("id");
		$("#userID").text(id);
		$("#userName").text($(this).text());
		var d = new Date();
		$("#datePlaceHolder").text(d)
		var url = "/users/"+id+"/channels";
  		$.ajax({
  				url: url, 
  				dataType: 'json',
  				success: function(result){
  					$("#channelsList").empty();
  					$(result).each(function(index,item){
  						$("#channelsList").append("<li class=\"list-group-item\"><img src=\""+item.src+"\"class=\"img-rounded\" alt=\""+item.name+"\" width=\"100\" height=\"50\"></li>");
  					})
    		  		
  				}
  		});
	});
	
	
	$("#getAddress").on("click",function(){
		var id = $("#userID").text();
		var url = "/users/"+id+"/address";
  		$.ajax({
  				url: url, 
  				dataType: 'json',
  				success: function(result){
  					$("#addressItems").empty();
  					$("#addressHeader").show();
  					$("#addressItems").append("<li class=\"list-group-item\">"+result.street+"</li>");
  					$("#addressItems").append("<li class=\"list-group-item\">"+result.city+"</li>");
  					$("#addressItems").append("<li class=\"list-group-item\">"+result.state+"</li>");
  					$("#addressItems").append("<li class=\"list-group-item\">"+result.country+"</li>");
  					$("#addressItems").append("<li class=\"list-group-item\">"+result.zip+"</li>");
  				},
  				error: function(result){
  					$("#addressItems").empty();
  					$("#addressItems").append("<li class=\"list-group-item\">Error Retrieving Address</li>");
  				}
  				
  		});
	});
	
});
</script>
</html>

