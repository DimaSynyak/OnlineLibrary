<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@include file="../pages/jspf/header.jspf" %>
<%@include file="../pages/jspf/letters.jspf" %>

<sec:authorize access="hasRole('USER')" var="isUser"/>
<sec:authorize access="hasRole('ADMIN')" var="isAdmin"/>



<div class="body">

  <div class="fields">
    <%--<form method="post" action="/upload" enctype="multipart/form-data">--%>
      <div class="image">

        <form id="formfile" method="post" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
          <input type="submit" id="upload" style="display: none"/>
        <c:choose>
          <c:when test="${upload}">
            <label for="FileInput">
              <img  src="${pageContext.request.getContextPath()}/addbook/editbook" width="400" height="600"/>
            </label>
            <input name="image" onchange="window.upload.click();" type="file" id="FileInput" style="cursor: pointer;  display: none"/>
          </c:when>
          <c:otherwise>
            <label for="FileInput">
              <img name="image" src="${imgBook}" width="400" height="600"/>
            </label>
            <input name="image" onchange="window.upload.click();" type="file" id="FileInput" style="cursor: pointer;  display: none"/>
          </c:otherwise>
        </c:choose>
        </form>
      </div>
      <div class="labels">
        <div class="label_block"><label>Author name:</label><input type="text"/></div>
        <div class="label_block"><label>Author birthday:</label><input type="text"/></div>
        <div class="label_block"><label>Book name:</label><input type="text"/></div>
        <div class="label_block"><label>Book content:</label>
          <label for="ContentInput">
            <img class="button" value="Load Content"/>
          </label>
          <input id="ContentInput" class="button" type="file" name="file"/>
        </div>
        <div class="label_block"><label>Page count:</label><input id="m" type="text"/></div>
        <div class="label_block"><label>Publisher name:</label><input type="text"/></div>
        <div class="label_block"><label>Publish year:</label><input type="text"/></div>
        <div class="label_block"><label>Genre name:</label><input type="text"/></div>
      </div>
      <input class="button" type="submit" value="Save"/>
      <input class="button" type="submit" value="Cancel"/>
    <%--</form>--%>
  </div>

</div>
<%@include file="../pages/jspf/login.jspf" %>
<%@include file="../pages/jspf/left_menu.jspf" %>
<%@include file="../pages/jspf/footer.jspf" %>