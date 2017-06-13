<%-- 
    Document   : home
    Created on : Apr 1, 2017, 9:15:21 AM
    Author     : Nur Muhamad
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="<c:url value='/static/css/bootstrap.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/static/font-awesome/css/font-awesome.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/static/css/AdminLTE.css' />" />
    <link rel="stylesheet" href="<c:url value='/static/css/skins/_all-skins.min.css' />" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="hold-transition skin-purple layout-top-nav">
    <div class="wrapper">
        <%@include file="topHeader.jsp" %>
      <!-- Full Width Column -->
      <div class="content-wrapper">
        <div class="container">
          <!-- Content Header (Page header) -->
          <section class="content-header">
            <h1>
              OCR Project
              <small>Version 1.0</small>
            </h1>
            <ol class="breadcrumb">
              <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
              <li><a href="#">proyek ocr</a></li>
              <li class="active">new / update user</li>
            </ol>
          </section>

          <!-- Main content -->
          <section class="content">
            <div class="callout callout-info">
              <h4>Tip!</h4>
              <p>Add the layout-top-nav class to the body tag to get this layout. This feature can also be used with a sidebar! So use this class if you want to remove the custom dropdown menus from the navbar and use regular links instead.</p>
            </div>
            <div class="row">
              <div class="col-xs-12">
                <div class="box box-info">
                <div class="box-header with-border">
                <c:choose>
                    <c:when test="${edit}">
                        <h3 class="box-title">Update User</h3>
                    </c:when>
                    <c:otherwise>
                        <h3 class="box-title">Add User</h3>
                    </c:otherwise>
                </c:choose>                    
                </div><!-- /.box-header -->
                <!-- form start -->
                <form:form method="POST" modelAttribute="user" class="form-horizontal">                    
                <form:input type="hidden" path="id" id="id"/>
			  
                  <div class="box-body">
                    <div class="form-group">
                      <label for="firstName" class="col-sm-2 control-label">First Name</label>
                      <div class="col-sm-10">
                        <form:input type="text" path="firstName" id="firstName" class="form-control input-sm" required="required" />
                        <div class="text-danger text-bold">
                            <form:errors path="firstName" class="help-inline"/>
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="lastName" class="col-sm-2 control-label">Last Name</label>
                      <div class="col-sm-10">
                        <form:input type="text" path="lastName" id="lastName" class="form-control input-sm" required="required" />
			<div class="text-danger text-bold">
			    <form:errors path="lastName" class="help-inline"/>
			</div>
                      </div>
                    </div>
                        
                    <div class="form-group">
                      <label for="lastName" class="col-sm-2 control-label">Username</label>
                      <div class="col-sm-10">
                        <c:choose>
                            <c:when test="${edit}">
                                <form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" disabled="true" required="required"/>
                            </c:when>
                            <c:otherwise>
                                <form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" required="required" />
                                <div class="text-danger text-bold">
                                        <form:errors path="ssoId" class="help-inline"/>
                                </div>
                            </c:otherwise>
                        </c:choose>
                      </div>
                    </div>  
                    
                    <div class="form-group">
                      <label for="password" class="col-sm-2 control-label">Password</label>
                      <div class="col-sm-10">
                        <form:input type="password" path="password" id="password" class="form-control input-sm" required="required" />
                        <div class="text-danger text-bold">
                                <form:errors path="password" class="help-inline"/>
                        </div>
                      </div>
                    </div>
                        
                     <div class="form-group">
                      <label for="email" class="col-sm-2 control-label">Email</label>
                      <div class="col-sm-10">
                        <form:input type="email" path="email" id="email" class="form-control input-sm" required="required" />
			    <div class="text-danger text-bold">
			        <form:errors path="email" class="help-inline"/>
			    </div>
                      </div>
                    </div>  
                            
                     <div class="form-group">
                      <label for="userProfiles" class="col-sm-2 control-label">Roles</label>
                      <div class="col-sm-10">
                        <form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm"  required="required" />
                        <div class="text-danger text-bold">
                            <form:errors path="userProfiles" class="help-inline"/>
                        </div>
                      </div>
                    </div>         
                        
                    
                  </div><!-- /.box-body -->
                  <div class="box-footer">
                    <a href="<c:url value='/home' />" class="btn btn-danger btn-flat">Cancel</a>
                    <c:choose>					
                        <c:when test="${edit}">
                          <button type="submit" class="btn btn-info  btn-flat pull-right">Update</button>                 
                        </c:when>
                        <c:otherwise>
                          <button type="submit" class="btn btn-info  btn-flat pull-right">Register</button>                 
                        </c:otherwise>
                    </c:choose>  
                   </div><!-- /.box-footer -->
                </form:form>
              </div><!-- /.box -->
              </div>
            </div>

            </section><!-- /.content -->
        </div><!-- /.container -->
      </div><!-- /.content-wrapper -->
      
      <%@include file="footerAll.jsp" %>
      
  </body>
</html>
