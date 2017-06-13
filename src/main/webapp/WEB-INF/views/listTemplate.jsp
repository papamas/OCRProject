<%-- 
    Document   : listTemplate
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
              <li><a href="#">proyek ocr</a></li>
              <li class="active">list template</li>
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
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">List of templates</h3>
                  <div class="box-tools">
                    <div class="input-group" style="width: 150px;">
                      <input type="text" name="table_search" class="form-control input-sm pull-right" placeholder="Search">
                      <div class="input-group-btn">
                        <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
                      </div>
                    </div>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive no-padding">
                  <table class="table table-hover">
                    <tr>
                      <th>Instansi</th>  
                      <th>Template</th>
                      <th>File Name</th>
                      <th>File Type</th>
                      <th>Active</th>
                      <c:url var="newTemplateUrl" value="/newTemplate" />           
                      <th><a href="${newTemplateUrl}" title="create template"><i class="fa fa-plus-circle fa-2x text-green"></i></a></th>                      
                    </tr> 
                    <c:forEach items="${templates}" var="template">                    
                    <tr>
                      <td>${template.instansi.namaInstansi}</td>  
                      <td>${template.templateName}</td>
                      <td>${template.fileName}</td>
                      <td>${template.type}</td>
                        <c:choose>
                            <c:when test="${template.active}">
                                <td><input type="checkbox" checked="" /></td>
                            </c:when>    
                            <c:otherwise>
                                <td><input type="checkbox"/></td>
                            </c:otherwise>
                        </c:choose>                      
                      <td><a href="<c:url value='/edit-template-${template.id}' />" title="edit">
                              <i class="fa fa-pencil text-blue"></i></a>&nbsp; 
                          <a href="<c:url value='/delete-template-${template.id}' />" title="remove">
                              <i class="fa fa-remove text-red"></i></a>&nbsp;<a href="<c:url value='/edit-file-${template.id}' />" title="update image"><i class="fa fa-image text-info"></i></a>&nbsp;<a href="<c:url value='/listCordinate-${template.id}' />" title="create ordinate"><i class="fa fa-globe text-aqua"></i></a>&nbsp;</td>
                    </tr>
                    </c:forEach>

                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div>
          </div>
              
          </section><!-- /.content -->
        </div><!-- /.container -->
      </div><!-- /.content-wrapper -->
     <%@include file="footerAll.jsp" %> 
         
      
  </body>
</html>
