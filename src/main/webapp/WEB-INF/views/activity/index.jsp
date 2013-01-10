<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@include file="../top.jsp" %>


   	<div class="container-fluid">
	     <div class="row-fluid">
        <div class="span2">
          <div class="well sidebar-nav">
          	<ul class="nav nav-list">
			  <li class="nav-header"><a href="<c:url value="/" />">Welcome</a></li>	
			  <li><a href="<c:url value="../forecast/forecast" />">Forecasts</a></li>	
			  <li class="nav-header">Activities</li>			 			
			  <li><a href="<c:url value="../forecast/reports" />">Reports</a></li>	
			  </ul>  
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span10">         
            <div class="hero-unit">
              <h1>Your activities</h1>     
            </div>
            <div class="row-fluid">
              <div class="span12">
                  <div class="container" align="center">
  					 <table class="table table-bordered table-striped table-hover">
				    <thead>
				      <tr>
				        <th>#</th>
				        <th>Type</th>
				        <th>Start Date</th>
				        <th>End Date</th>
				        <th>Default percentage</th>
				      </tr>
				    </thead>
				    <tbody>				 
					 	<c:forEach var="activity" items="${activities}">
					       <tr>
					        <td>${activity.id}</td>
					        <td>${activity.type}</td>
					        <td>${activity.startDate}</td>
					        <td>${activity.endDate}</td>
					        <td>${activity.defaultPercentage}</td>
				     	 </tr>
					   </c:forEach>								     
				    </tbody>
				  </table>
  					<p><a href="<c:url value="/activity/create" />">Create a new activity</a></p>
                  </div>
<%@include file="../bottom.jsp" %>