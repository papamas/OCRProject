<%-- 
    Document   : newTemplate
    Created on : Apr 1, 2017, 7:18:21 PM
    Author     : Nur Muhamad
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
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

        <%@include  file="topHeader.jsp" %>
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
              <li><a href="#">Layout</a></li>
              <li class="active">Top Navigation</li>
            </ol>
          </section>

          <!-- Main content -->
          <section class="content">
            <div class="callout callout-info">
              <h4>Tip!</h4>
              <p>Add the layout-top-nav class to the body tag to get this layout. This feature can also be used with a sidebar! So use this class if you want to remove the custom dropdown menus from the navbar and use regular links instead.</p>
            </div>
            
            <!-- general form elements -->
              <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">OCR FILE TEST BY TEMPLATE
                    </h3>                    
                </div><!-- /.box-header -->
                <!-- form start -->
                <form:form method="POST"  cssClass="form-horizontal" modelAttribute="fileOCR" enctype="multipart/form-data">
		<div class="box-body">
                    <div class="form-group">
                     <label for="file"  class="col-sm-2 control-label">File Image</label>
                     <div class="col-sm-10">                      
                         <form:input type="file" path="file" id="file"/>
                         <div class="text-danger text-bold">
                             <form:errors path="file" class="help-inline"/>
                         </div>
                     </div>
                     </div> 
                    <div class="form-group">
                      <label for="active" class="col-sm-2 control-label">Fix Skew Image</label>
                      <div class="col-sm-2">
                        <form:checkbox path="fixSkew" id="fixSkew" />
                        <div class="text-danger text-bold">
                            <form:errors path="fixSkew" class="help-inline"/>
                        </div>
                      </div>
                    </div>         
                    
                  </div><!-- /.box-body -->
                  <div class="box-footer">
                    <button type="submit" class="btn btn-flat btn-info">Upload</button>                                        
                  </div>
                </form:form>
              </div><!-- /.box -->
  
              
          </section><!-- /.content -->
        </div><!-- /.container -->
      </div><!-- /.content-wrapper -->
      
      <footer class="main-footer">
        <div class="container">
          <div class="pull-right hidden-xs">
            <b>Version</b> 2.3.0
          </div>
          <strong>Copyright &copy; 2014-2015 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights reserved.
        </div><!-- /.container -->
      </footer>
    </div><!-- ./wrapper -->
    <script src="<c:url value='/static/js/jQuery-2.1.4.min.js'/>"> </script>    
    <script src="<c:url value='/static/js/bootstrap.min.js'/>"> </script>     
    <script src="<c:url value='/static/js/jquery.slimscroll.min.js'/> "></script>
    <script src="<c:url value='/static/js/fastclick.min.js' />"></script>
    <script src="<c:url value='/static/js/app.min.js'/>"> </script>     
      
  </body>
</html>
