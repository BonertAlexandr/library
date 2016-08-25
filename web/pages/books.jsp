<%@page import="ua.training.web.enums.SearchType"%>
<%@page import="ua.training.web.beans.LetterList"%>
<%@page import="ua.training.web.beans.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%@include file="../WEB-INF/jspf/left_menu.jspf" %>
    <%@include file="../WEB-INF/jspf/letters.jspf" %>
    
    <% request.setCharacterEncoding("UTF-8");
      
    %>
    
    <jsp:useBean id="bookList" class="ua.training.web.beans.BookList" scope="page"/>
    
    <div class = "book_list">
    
    <h3>${param.name}</h3>

        <%  
            ArrayList<Book> list = null;
            if ( request.getParameter("letter") != null) {
                 list = bookList.getBooksByLetter(request.getParameter("letter"));
            } else if ( request.getParameter("search_String") != null ) {
                SearchType type = SearchType.TITLE;
                if (request.getParameter("search_option").equals("Автор"))
                    type = SearchType.AUTHOR;
                list = bookList.getBooksBySearch(type, request.getParameter("search_String"));
            } else if (request.getParameter("genre_id") != null) {
                long genreId = 0L;
                try {
                    genreId = Long.valueOf(request.getParameter("genre_id"));
                } catch (Exception ex) {
                    ex.printStackTrace();            
                }
                list = bookList.getBooksByGenre(genreId);
            }
            session.setAttribute("currentBookList", list);
        %>
        <h5>Найдено книг: <%=list.size()%></h5>
        <%
            for (Book book : list) {                
        %>
        <div class="book_info">
            <div class="book_title">
                <p><%=book.getName()%></p>
            </div>
            <div class="book_image">
                <img src="<%=request.getContextPath()%>/ShowImage?index=<%=list.indexOf(book)%>" height="250" width="190" alt="Обложка">
            </div>
            <div class="book_details">
                <br><strong>ISBN:</strong> <%=book.getIsbn()%>
                <br><strong>Издательство:</strong> <%=book.getPublisher() %>               
                <br><strong>Количество страниц:</strong> <%=book.getPageCount() %>
                <br><strong>Год издания:</strong> <%=book.getPublishDate() %>
                <br><strong>Автор:</strong> <%=book.getAuthor()%>                
                <p style="margin:10px;"> <a style="padding: 10px;" href="<%=request.getContextPath()%>/PDFContent?index=<%=list.indexOf(book)%>">Читать</a>
                <a href="<%=request.getContextPath()%>/DownloadBook?index=<%=list.indexOf(book)%>">Скачать</a></p>
            </div>    
        </div>        
        <% } %>
    </div>