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
              <li><a href="#">Laporan</a></li>
              <li class="active">Generate Laporan</li>
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
                    <h3 class="box-title">Generate Report</h3>                    
                </div><!-- /.box-header -->
                <!-- form start -->
                <form:form method="POST"  cssClass="form-horizontal" modelAttribute="laporan" enctype="multipart/form-data">
		<div class="box-body">
                    <div class="form-group">
                      <label for="instansi" class="col-sm-2 control-label">Nama Instansi</label>
                      <div class="col-sm-6">
                        <form:select path="instansi" id="instansi" class="form-control input-sm">
		            <form:option value="ALL">--Please Select--</form:option>
                             <form:options itemValue="kodeInstansi" itemLabel="namaInstansi" items="${instansiList}" />                                                
			</form:select> 
                        <div class="text-danger text-bold">
                            <form:errors path="instansi" class="help-inline"/>
                        </div>  
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="status" class="col-sm-2 control-label">Status File</label>
                      <div class="col-sm-6">
                        <form:select path="status" id="status" class="form-control input-sm" >
		            <form:option value="">--Please Select--</form:option>
                            <form:option value="0">NEW</form:option>
                            <form:option value="1">IMS</form:option>
                            <form:option value="2">DMS</form:option>
                            <form:option value="3">SAPK</form:option>                                                
			</form:select> 
                        <div class="text-danger text-bold">
                            <form:errors path="status" class="help-inline"/>
                        </div>  
                      </div>
                    </div>              
                    <div class="form-group">
                      <label for="namaKeyword" class="col-sm-2 control-label">Tanggal</label>
                      <div class="col-sm-3">
                        <form:input type="text" path="createdDate" id="createdDate" class="form-control input-sm" />
                        <div class="text-danger text-bold">
                            <form:errors path="createdDate" class="help-inline"/>
                        </div>
                      </div>
                        <div class="col-sm-1">
                            <label class="control-label">Sampai</label>
                         
                        </div>  
                      <div class="col-sm-3">
                        <form:input type="text" path="updateDate" id="updateDate" class="form-control input-sm" />
                        <div class="text-danger text-bold">
                            <form:errors path="updateDate" class="help-inline"/>
                        </div>
                      </div>  
                    </div>                    
                  </div><!-- /.box-body -->
                  <div class="box-footer">
                    <button type="submit" class="btn btn-flat btn-info">Generate Report</button>                                        
                  </div>
                </form:form>
              </div><!-- /.box -->
  
              
          </section><!-- /.content -->
        </div><!-- /.container -->
      </div><!-- /.content-wrapper -->
      <%@include file="footerAll.jsp" %>   
      
  </body>
</html>
