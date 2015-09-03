<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="../pages/jspf/header.jspf" %>
<%@include file="../pages/jspf/letters.jspf" %>

<sec:authorize access="hasRole('USER')" var="isUser"/>
<sec:authorize access="hasRole('ADMIN')" var="isAdmin"/>



<div class="body">




  <h5 style="text-align: left; margin-top:20px; margin-left: 10px">Найдено книг: ${books.size()} </h5>
<div class="select_books">
  <a>    На странице: </a>
  <select>
    <option>5 книг</option>
    <option>10 книг</option>
    <option>15 книг</option>
    <option>20 книг</option>
  </select>
</div>

  <%@include file="../pages/jspf/addbooks.jspf" %>

  <c:forEach items="${books}" var="book">
    <div class="book_info">
      <div class="book_title">
        <p> ${book.getName()}</p>
      </div>

      <div class="book_image">
        <img src="${pageContext.request.getContextPath()}/books/image=${book.getId()}" height="250" width="190" />
      </div>

      <div class="book_details">
        <br><strong>ISBN:</strong> ${book.getIsbn()}
        <br><strong>Издательство:</strong> ${book.getPublish().getName()}

        <br><strong>Кол-во страниц:</strong> ${book.getPage_count()}
        <br><strong>Год издания:</strong> ${book.getPublish_year()}
        <br><strong>Автор:</strong> ${book.getAuthor().getName()}

        <c:if test="${isUser or isAdmin}">
          <form action="" method="post">
            <div>
              <input type="submit" value="Скачать"/>
            </div>
          </form>
        </c:if>

        <c:if test="${isAdmin}">
          <form action="" method="post">
            <div>
              <input type="submit" value="Изменить"/>
            </div>
            <div>
              <input type="submit" value="Удалить"/>
            </div>
          </form>
        </c:if>
      </div><%--end book_datails--%>
    </div>
  </c:forEach>
</div>
<%@include file="../pages/jspf/login.jspf" %>
<%@include file="../pages/jspf/left_menu.jspf" %>
<%@include file="../pages/jspf/footer.jspf" %>