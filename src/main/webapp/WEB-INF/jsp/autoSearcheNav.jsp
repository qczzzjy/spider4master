<%--
  Created by IntelliJ IDEA.
  User: qcz
  Date: 2015/7/8
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title></title>
</head>
<body>
<div class="row">
    <div class="alert alert-success" role="alert">大师，请吃烧饼（点击对应的分类，列出对应关键词的超链）</div>
    <ul class="nav nav-pills">
      <c:forEach items="${sheetList}" var="item">
          <li role="presentation">
              <a href="javascript:void(0)" onclick="loadSheetKeyWords(this)">${item}</a>
          </li>
      </c:forEach>
    </ul>
    <div id="hrefDiv">

    </div>
</div>
<script language="javascript">
    function loadSheetKeyWords(o){
        $("li").removeClass("active");
        $(o).parent().addClass("active");
        $("#hrefDiv").load("/home/getKeySet", {"key": $(o).text()}, function(){

        });
    }
</script>
</body>
</html>
