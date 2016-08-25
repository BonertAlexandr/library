package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ua.training.web.beans.Genre;
import ua.training.web.beans.Author;
import ua.training.web.beans.AuthorList;
import ua.training.web.enums.SearchType;
import ua.training.web.beans.LetterList;
import ua.training.web.beans.Book;
import java.util.ArrayList;
import ua.training.web.beans.Genre;

public final class books_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/WEB-INF/jspf/header.jspf");
    _jspx_dependants.add("/pages/../WEB-INF/jspf/left_menu.jspf");
    _jspx_dependants.add("/pages/../WEB-INF/jspf/letters.jspf");
    _jspx_dependants.add("/WEB-INF/jspf/footer.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Онлайн библиотека</title>\n");
      out.write("        <link href=\"../css/style_main.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
  
            request.setCharacterEncoding("utf-8");
            String searchString = "";
            
            if (request.getParameter("username") != null){
                session.setAttribute("username", request.getParameter("username"));
            }
            if (request.getParameter("search_String") != null) {                
                searchString = request.getParameter("search_String");
                session.setAttribute("search_String", searchString);
            } else if (session.getAttribute("search_String") != null) {
                searchString = (String) session.getAttribute("search_String");
            }
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"header\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                <img src=\"../images/library.png\" alt=\"Логотип\" name=\"logo\" />\n");
      out.write("                \n");
      out.write("                </div>\n");
      out.write("                <div class=\"descr\">\n");
      out.write("                    <h3>Онлайн библиотека</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"welcome\">\n");
      out.write("                    <h5>Добро пожаловать, ");
      out.print( session.getAttribute("username") );
      out.write("!</h5>\n");
      out.write("                    <h6><a href=\"../index.jsp?session=0\">Выход</a></h6>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"search_form\">\n");
      out.write("                    <form name=\"search_form\" method=\"GET\" action=\"books.jsp\">\n");
      out.write("                        <input type=\"text\" name=\"search_String\" value=\"");
      out.print( searchString );
      out.write("\" size=\"110\" />\n");
      out.write("                        <input class=\"search_button\" type=\"submit\" value=\"Поиск\" name=\"search_button\" />\n");
      out.write("                        <select name=\"search_option\">\n");
      out.write("                            ");
 if ((request.getParameter("search_option") == null) || (request.getParameter("search_option").equals("Название"))) { 
      out.write("\n");
      out.write("                                <option>Название</option>\n");
      out.write("                                <option>Автор</option>\n");
      out.write("                            ");
 } else { 
      out.write("\n");
      out.write("                                <option>Автор</option>\n");
      out.write("                                <option>Название</option>\n");
      out.write("                            ");
 } 
      out.write("                            \n");
      out.write("                        </select>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
  
    long selectedGenreId = 0L;
    if (request.getParameter("genre_id") != null) {
        selectedGenreId = Long.parseLong(request.getParameter("genre_id"));
        session.setAttribute("selectedGenreId", selectedGenreId);    
    } else if (session.getAttribute("selectedGenreId") != null) {
        selectedGenreId = Long.parseLong(session.getAttribute("selectedGenreId").toString());
    }    

      out.write("\n");
      out.write("<div class=\"sidebar1\">\n");
      out.write("                <h4>Список жанров:</h4>\n");
      out.write("                <ul class=\"nav\">\n");
      out.write("                ");
      ua.training.web.beans.GenreList genreList = null;
      synchronized (application) {
        genreList = (ua.training.web.beans.GenreList) _jspx_page_context.getAttribute("genreList", PageContext.APPLICATION_SCOPE);
        if (genreList == null){
          genreList = new ua.training.web.beans.GenreList();
          _jspx_page_context.setAttribute("genreList", genreList, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write("\n");
      out.write("                <li><a href=\"books.jsp?genre_id=0\">Все книги</a></li>\n");
      out.write("                    ");

                    for (Genre genre : genreList.getGenreList()) {
                        if ((selectedGenreId != 0) && (selectedGenreId == genre.getId())) {
                    
      out.write("                        \n");
      out.write("                            <li><a style=\"font-weight: bold;\" href=\"books.jsp?genre_id=");
      out.print(genre.getId());
      out.write("&name=");
      out.print(genre.getName());
      out.write('"');
      out.write('>');
      out.print(genre.getName());
      out.write("</a></li>                        \n");
      out.write("                    ");
  } else {
                    
      out.write("        \n");
      out.write("                            <li><a href=\"books.jsp?genre_id=");
      out.print(genre.getId());
      out.write("&name=");
      out.print(genre.getName());
      out.write('"');
      out.write('>');
      out.print(genre.getName());
      out.write("</a></li>\n");
      out.write("                    ");
  }                                                                   
                    }
                    
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <p>&nbsp;</p>\n");
      out.write("</div>");
      out.write("\n");
      out.write("    ");
      out.write('\n');
      out.write('\n');
      ua.training.web.beans.LetterList letterList = null;
      synchronized (application) {
        letterList = (ua.training.web.beans.LetterList) _jspx_page_context.getAttribute("letterList", PageContext.APPLICATION_SCOPE);
        if (letterList == null){
          letterList = new ua.training.web.beans.LetterList();
          _jspx_page_context.setAttribute("letterList", letterList, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write("\n");
      out.write("<div class=\"letters\">\n");
      out.write("    ");
  
        String selectedLetter = null;
        if (request.getParameter("letter") != null) {
            selectedLetter = request.getParameter("letter");
            session.setAttribute("letter", selectedLetter);
        } else if (session.getAttribute("letter") != null) {
            selectedLetter = (String) session.getAttribute("letter");
        }
        
        char[] letters = letterList.getRussianLetters();
        for (int i = 0; i < letters.length; i++) {    
            if (selectedLetter != null && selectedLetter.toUpperCase().charAt(0) == letters[i]) {
    
      out.write("     \n");
      out.write("            <a style = \"font-weight: bold\" href=\"books.jsp?letter=");
      out.print( letters[i]);
      out.write('"');
      out.write('>');
      out.print( letters[i]);
      out.write("</a> \n");
      out.write("    ");
      } else {
    
      out.write("        \n");
      out.write("                <a href=\"books.jsp?letter=");
      out.print( letters[i]);
      out.write('"');
      out.write('>');
      out.print( letters[i]);
      out.write("</a> \n");
      out.write("    ");
      }
        }
    
      out.write("\n");
      out.write("</div>");
      out.write("\n");
      out.write("    \n");
      out.write("    ");
 request.setCharacterEncoding("UTF-8");
      
    
      out.write("\n");
      out.write("    \n");
      out.write("    ");
      ua.training.web.beans.BookList bookList = null;
      synchronized (_jspx_page_context) {
        bookList = (ua.training.web.beans.BookList) _jspx_page_context.getAttribute("bookList", PageContext.PAGE_SCOPE);
        if (bookList == null){
          bookList = new ua.training.web.beans.BookList();
          _jspx_page_context.setAttribute("bookList", bookList, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("    \n");
      out.write("    <div class = \"book_list\">\n");
      out.write("    \n");
      out.write("    <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("\n");
      out.write("        ");
  
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
        
      out.write("\n");
      out.write("        <h5>Найдено книг: ");
      out.print(list.size());
      out.write("</h5>\n");
      out.write("        ");

            for (Book book : list) {                
        
      out.write("\n");
      out.write("        <div class=\"book_info\">\n");
      out.write("            <div class=\"book_title\">\n");
      out.write("                <p>");
      out.print(book.getName());
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"book_image\">\n");
      out.write("                <img src=\"");
      out.print(request.getContextPath());
      out.write("/ShowImage?index=");
      out.print(list.indexOf(book));
      out.write("\" height=\"250\" width=\"190\" alt=\"Обложка\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"book_details\">\n");
      out.write("                <br><strong>ISBN:</strong> ");
      out.print(book.getIsbn());
      out.write("\n");
      out.write("                <br><strong>Издательство:</strong> ");
      out.print(book.getPublisher() );
      out.write("               \n");
      out.write("                <br><strong>Количество страниц:</strong> ");
      out.print(book.getPageCount() );
      out.write("\n");
      out.write("                <br><strong>Год издания:</strong> ");
      out.print(book.getPublishDate() );
      out.write("\n");
      out.write("                <br><strong>Автор:</strong> ");
      out.print(book.getAuthor());
      out.write("                \n");
      out.write("                <p style=\"margin:10px;\"> <a style=\"padding: 10px;\" href=\"");
      out.print(request.getContextPath());
      out.write("/PDFContent?index=");
      out.print(list.indexOf(book));
      out.write("\">Читать</a>\n");
      out.write("                <a href=\"");
      out.print(request.getContextPath());
      out.write("/DownloadBook?index=");
      out.print(list.indexOf(book));
      out.write("\">Скачать</a></p>\n");
      out.write("            </div>    \n");
      out.write("        </div>        \n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </div>");
      out.write("\n");
      out.write("        </div><!-- end .container -->\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
