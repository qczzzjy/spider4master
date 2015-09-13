<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<%--
  Created by IntelliJ IDEA.
  User: qcz
  Date: 2015/6/24
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@include file="include.jsp"%>

<head>
    <title></title>
</head>
<body>
<div class="container">
  <div class="jumbotron">
    <h1>Hello, 宅大师!</h1>
    <p></p>
    <div class="row">
      <div class="col-lg-6">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="输入关键词(敬请期待)">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Go!</button>
      </span>
        </div><!-- /input-group -->
      </div><!-- /.col-lg-6 -->
    <br/>
    <p><a class="btn btn-primary btn-lg" href="javascript:void(0)" role="button" onclick="autoSearch()">一键搜索</a></p>
  </div><!-- /.row -->
  </div>
</div>
</body>
<script language="JavaScript">
  function autoSearch(){
    $.ajax({
      url:"/home/autoSearch",
      dataType:"html",
      success:function(result){
        $(".container").html(result);
      },
      error:   function(){
        alert(arguments[1]);
      }
    });
  }
</script>
</html>
