<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@include file="top.jsp" %>

   	<div class="container-fluid">
	     <div class="row-fluid">
        <div class="span2">
          <div class="well sidebar-nav">
          	<ul class="nav nav-list">
			  <li class="nav-header">Welcome</li>
			  <li><a href="<c:url value="/forecast" />">Forecasts</a></li>	
			  <li><a href="<c:url value="/activity" />">Activities</a></li>			 			
			  <li><a href="<c:url value="/reports" />">Reports</a></li>	
			  </ul>  
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span10">         
            <div class="hero-unit">
              <h1>Welcome</h1>     
            </div>
            <div class="row-fluid">
              <div class="span12">
                  <div class="container" align="center">
                  	<section id="welcome">
                    	<div class="page-header"><h3>Do your part by forecasting!</h3>                    	
                    	</div>
                    	<div class="row">
	                    	<div class="span4">
	                    		Create <a href="<c:url value="/forecast" />">forecasts</a>
	                    		<img src="<c:url value="/resources/img/crystal-ball.png" />">
	                    	</div> 
	                    	<div class="span4">
	                    		Create <a href="<c:url value="/activity" />">activity</a>
	                    		<img src="<c:url value="/resources/img/activity.png" />">
	                    	</div>
	                    	<div class="span4">
	                    		Show <a href="<c:url value="/report" />">report</a>
	                    		<img src="<c:url value="/resources/img/report.png" />">
	                    	</div>
                    	</div>                        
					</section>
                  </div>
<%@include file="bottom.jsp" %>