<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<%@include file="../top.jsp"%>


<div class="container-fluid">
	<div class="row-fluid">
		<div class="span2">
			<div class="well sidebar-nav">
				<ul class="nav nav-list">
					<li class="nav-header"><a href="<c:url value="/" />">Welcome</a>
					</li>
					<li><a href="<c:url value="/forecast/forecast" />">Forecasts</a>
					</li>
					<li class="nav-header">Activities</li>
					<li><a href="<c:url value="/forecast/reports" />">Reports</a>
					</li>
				</ul>
			</div>
			<!--/.well -->
		</div>
		<!--/span-->
		<div class="span10">
			<div class="hero-unit">
				<h1>Please enter activity details</h1>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<div class="container" align="center">
						<form:form id="form" method="post" modelAttribute="activity"
							class="form-horizontal well">
							<div>
								<c:if test="${not empty message}">
									<div id="message" class="success">${message}</div>
								</c:if>
								<s:bind path="*">
									<c:if test="${status.error}">
										<div id="message" class="error"><div class="alert alert-error"><h2>Form has errors</h2></div></div>
									</c:if>
								</s:bind>
							</div>
							<fieldset>
						  		<legend>Date information</legend>						  		
						  		<div class="control-group <c:if test="${status.error}">error</c:if>">
									<form:label class="control-label" path="startDate">
						  				Start Date <form:errors path="startDate"/>
									</form:label>
									<div class="controls">												 
					                    <form:input path="startDate" size="16" placeholder="15-01-2013" class="datepicker" data-date-format="dd-mm-yyyy"/>	                    
									</div>
								</div>
								<div class="control-group <c:if test="${status.error}">error</c:if>">
									<form:label class="control-label" path="endDate">
						  				End Date <form:errors path="endDate"/>
									</form:label>
									<div class="controls">												 
					                    <form:input path="endDate" size="16" placeholder="15-01-2013" class="datepicker" data-date-format="dd-mm-yyyy"/>	                    
									</div>
								</div>
								<div class="control-group ${requestScope['org.springframework.validation.BindingResult.activity'].hasFieldErrors('defaultPercentage') ? 'error' : ''}">
									<form:label class="control-label" path="defaultPercentage">
						  				Default percentage <form:errors path="defaultPercentage" />
									</form:label>
									<div class="controls">
										<form:input path="defaultPercentage" />
									</div>
								</div>
								<legend>Billing information</legend>
							<div class="control-group">
								<form:label class="control-label"  path="type">
									Type (select one)
								</form:label>
								<div class="controls">
									<form:select path="type">
										<form:option value="TM">TM</form:option>
										<form:option value="FIXED">Fixed</form:option>
										<form:option value="OTHER">Other</form:option>
									</form:select>
								</div>
							</div>						  			
						  	</fieldset>
						  	<p><button type="submit" class="btn btn-primary">Submit</button></p>
						</form:form>
					</div>
					<%@include file="../bottom.jsp"%>