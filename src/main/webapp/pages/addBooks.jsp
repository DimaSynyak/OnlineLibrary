<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@include file="../pages/jspf/header.jspf" %>
<%@include file="../pages/jspf/letters.jspf" %>

<sec:authorize access="hasRole('USER')" var="isUser"/>
<sec:authorize access="hasRole('ADMIN')" var="isAdmin"/>



<div class="body">
  <div class="state">
    ${state}
  </div>
  <div class="fields">
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
              <img name="image" src="${pageContext.request.getContextPath()}/${imgBook}" width="400" height="600"/>
            </label>
            <input name="image" onchange="window.upload.click();" type="file" id="FileInput" style="cursor: pointer;  display: none"/>
          </c:otherwise>
        </c:choose>
      </form>
    </div>

    <div class="main_field">
      <form action="${pageContext.request.getContextPath()}/validate" method="post" enctype="multipart/form-data">
        <div class="labels">
          <div class="label_block"><label>Author name:</label>
            <input value="Синяк Дмитрий Вадимович" id="authorName" name="authorName" type="text"/></div> <div class="label_err"><label>${authorName}</label></div>
          <div class="label_block"><label>Author birthday:</label>
            <input value="1988-11-01" id="authorBirthday" name="authorBirthday" type="date"/></div><div class="label_err"><label>${authorBirthday}</label></div>
          <div class="label_block"><label>Book name:</label>
            <input value="My Life" id="bookName" name="bookName" type="text"/></div><div class="label_err"><label>${bookName}</label></div>

          <div class="label_block"><label>Book content:</label>
            <label class="labelforfile" for="file"><div class="text">Content</div>
              <input id="file" type="file" name="file"/>
            </label>
          </div>

          <div class="label_block"><label>Page count:</label>
            <input value="145" id="pageCount" name="pageCount" type="number"/></div><div class="label_err"><label>${pageCount}</label></div>
          <div class="label_block"><label>Publisher name:</label>
            <input value="My Publisher" id="publisherName" name="publisherName" type="text"/></div><div class="label_err"><label>${publisherName}</label></div>
          <div class="label_block"><label>Publish year:</label>
            <input value="2015-11-01" id="publisherYear" name="publisherYear" type="dat"/></div><div class="label_err"><label>${publisherYear}</label></div>
          <div class="label_block"><label>Isbn:</label>
            <input value="KKHY-89543II" id="isbn" name="isbn" type="text"/></div><div class="label_err"><label>${isbn}</label></div>
          <div class="label_block"><label>Genre name:</label>
            <select id="genreName" name="genreName" >
              <c:forEach items="${genres}" var="genre">
                <option>${genre.getName()}</option>
              </c:forEach>
            </select></div>
        </div>
        <input id="save" class="button" type="submit" name="save" value="Save"/>
      </form>
      <form action="${pageContext.request.getContextPath()}/main" method="get">
        <input id="cancel" class="button" type="submit" name="cancel" value="Cancel"/>
      </form>
    </div>
  </div>

</div>
<%@include file="../pages/jspf/login.jspf" %>
<%@include file="../pages/jspf/left_menu.jspf" %>
<%@include file="../pages/jspf/footer.jspf" %>