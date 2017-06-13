<%-- 
    Document   : home
    Created on : Apr 1, 2017, 9:15:21 AM
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
    <link rel="stylesheet" href="<c:url value='/static/jcrop/css/jquery.Jcrop.min.css'/>" type="text/css" />
        
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
              <li class="active">new / update cordinate</li>
            </ol>
          </section>

          <!-- Main content -->
          <section class="content">
            <div class="callout callout-info">
              <h4>Tip!</h4>
              <p>Add the layout-top-nav class to the body tag to get this layout. This feature can also be used with a sidebar! So use this class if you want to remove the custom dropdown menus from the navbar and use regular links instead.</p>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <img  class="" src="<c:url value='/static/template/${fileName}' />" id="target"/>                     
                </div>
                <div class="col-xs-4 pull-right">
                <form:form method="POST"  modelAttribute="templateCordinate" cssClass="form-horizontal">
                <form:input type="hidden" path="id" id="id"/>
                    <div class="row">
                        <div class="box box-warning">
                            <div class="box-header with-border">
                            <h3 class="box-title">Coordinate of ${templateName}</h3>
                        </div>              
                        <div class="box-body">
                            <div class="row" id="coords">
                            <div class="col-sm-4 border-right">
                                <div class="description-block">
                                    <h5 class="description-header">X1</h5>
                                    <span class="description-text"><form:input type="text" path="X1" id="x1" class="form-control input-sm" required="required" /></span>
                                </div><!-- /.description-block -->
                            </div><!-- /.col -->
                            <div class="col-sm-4 border-right">
                                <div class="description-block">
                                    <h5 class="description-header">Y1</h5>
                                    <span class="description-text"> <form:input type="text" path="Y1" id="y1" class="form-control input-sm" required="required" /></span>
                                </div><!-- /.description-block -->
                            </div><!-- /.col -->
                            <div class="col-sm-4">
                                <div class="description-block">
                                    <h5 class="description-header">X2</h5>
                                    <span class="description-text"> <form:input type="text" path="X2" id="x2" class="form-control input-sm" required="required" /></span>
                            </div><!-- /.description-block -->
                            </div><!-- /.col -->
                        </div><!-- /.row -->
                        <div class="row">
                            <div class="col-sm-4 border-right">
                                <div class="description-block">
                                    <h5 class="description-header">Y2</h5>
                                    <span class="description-text"><form:input type="text" path="Y2" id="y2" class="form-control input-sm" required="required" /></span>
                                </div><!-- /.description-block -->
                            </div><!-- /.col -->
                            <div class="col-sm-4 border-right">
                                <div class="description-block">
                                    <h5 class="description-header">WIDTH</h5>
                                    <span class="description-text"> <form:input type="text" path="width" id="width" class="form-control input-sm" required="required" /></span>
                                </div><!-- /.description-block -->
                            </div><!-- /.col -->
                            <div class="col-sm-4">
                                <div class="description-block">
                                    <h5 class="description-header">HEIGHT</h5>
                                    <span class="description-text"> <form:input type="text" path="height" id="height" class="form-control input-sm" required="required" /></span>
                                    <form:errors path="height" class="help-inline"/>
                                </div><!-- /.description-block -->
                            </div><!-- /.col -->
                        </div><!-- /.row -->
                        <div class="row">
                            <div class="col-xs-12">                            
                            <div class="form-group">
                                <label for="fieldName"  class="col-xs-3 control-label">Name</label>
                                <div class="col-xs-7 col-xs-offset-1">                      
                                    <form:input type="text" path="name" id="name" class="form-control input-sm" required="required" />
                                    <div class="text-danger text-bold">
                                        <form:errors path="name" class="help-inline"/>
                                    </div>
                                </div> 
                             </div>
                            </div>    
                        </div>                        
                        </div><!-- /.body -->
                        <div class="box-footer">
                              <button type="submit" class="btn btn-info pull-right">Save Cordinate</button>
                        </div><!-- /.box-footer -->                     
                        </div><!-- /.box cordinate-->                
                    </div><!-- /.row  coordinate-->   
                    </form:form>
                    <div class="row">
                        <div class="box box-info">
                            <div class="box-header with-border">
                              <h3 class="box-title">OCR Result</h3>
                            </div><!-- /.box-header -->
                            <!-- form start -->
                            <form class="form-horizontal">
                              <div class="box-body">
                                <textarea  class="form-control" name="result" id="ocrResult" rows="5" style="min-width: 100%" class="">${ocrResult} </textarea>
                              </div><!-- /.box-body -->
                            <div class="box-footer">
                              <button id="ocrButton" type="button" class="btn btn-info pull-right">OCR Proses</button>
                            </div><!-- /.box-footer -->
                          </form>
                        </div><!-- /.box --> 
                    </div><!-- /.row  result-->
               </div><!-- /.col -->
            </div><!-- /.row -->
          </section><!-- /.content -->
        </div><!-- /.container -->
      </div><!-- /.content-wrapper -->
     <%@include file="footerAll.jsp" %>
    <script src="<c:url value='/static/jcrop/js/jquery.Jcrop.min.js'/>"></script> 
    <c:url var="partialOcr" value="/OCRJson" />
    <script type="text/javascript">
 
            jQuery(function ($) {
 
                $("#ocrButton").click(function (event) {
                    event.preventDefault();
                    $.ajax(
                            {
                                type: 'GET',
                                url: "${partialOcr}",
                                data: {
                                    'x1': $('#x1').val(),
                                    'y1': $('#y1').val(),
                                    'x2': $('#x2').val(),
                                    'y2': $('#y2').val(),                            
                                    'width': $('#width').val(),
                                    'height': $('#height').val(),
                                    'imageId': '${fileName}'
                                },
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                // crossDomain: true,
                                timeout: 9500,
                                success: function (data) {
                                    console.log("data: " + data);
                                    $("#ocrResult").val(data.ocrResult );
                                },
                                error: function (jqXHR, textStatus, errorThrown) {
                                    console.log(jqXHR.status + ' ' + textStatus + '\n ' + jqXHR.responseText);
                                    window.alert(jqXHR.responseText);
                                }
                            }
                    );
                });
 
                var jcrop_api;
 
                $('#target').Jcrop({
                    boxWidth: 727,
                    boxHeight: 1000,
                    onChange: showCoords,
                    onSelect: showCoords,
                    onRelease: function () {
                        $('#coords input').val('');
                    }
                }, function () {
                    jcrop_api = this;
                    <c:if test="${edit}">
                        var x1 = $('#x1').val(),
                            x2 = $('#x2').val(),
                            y1 = $('#y1').val(), 
                            y2 = $('#y2').val();
                        jcrop_api.animateTo([x1,y1,x2,y2]);
                    </c:if>     
                });
 
                $('#coords').on('change', 'input', function (e) {
                    var x1 = $('#x1').val(),
                        x2 = $('#x2').val(),
                        y1 = $('#y1').val(), 
                        y2 = $('#y2').val();
                    jcrop_api.setSelect([x1, y1, x2, y2]);
                });
 
            });
 
            // Simple event handler, called from onChange and onSelect event handlers, as per the Jcrop invocation above
            function showCoords(c) {
                $('#x1').val(c.x);
                $('#y1').val(c.y);
                $('#x2').val(c.x2);
                $('#y2').val(c.y2);
                $('#width').val(c.w);
                $('#height').val(c.h);
            };
 
        </script>
      
  </body>
</html>
