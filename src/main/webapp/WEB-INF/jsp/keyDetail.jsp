<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/7/14
  Time: 12:00
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
<hr/>
<table>
  <tr>
  <c:forEach items="${list}" var="item" varStatus="status">
        <c:choose>
          <c:when  test="${status.index%7==0}">
            </tr><tr>
          </c:when>

          <c:otherwise>
            <td><a href="javascript:void(0)" onclick="getSpider('${item}')">${item}</a></td>
          </c:otherwise>
        </c:choose>

      </c:forEach>
</table>
</body>
<script language="JavaScript">
  function getSpider(keyword){
    var unicode = encodeURI(keyword);
    var url = "https://www.baidu.com/s?wd="+unicode;
    window.open(url);
  }
</script>
</html>
