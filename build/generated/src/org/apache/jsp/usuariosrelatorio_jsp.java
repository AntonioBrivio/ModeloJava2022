package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.Dao;
import dao.usuariosDao;
import classes.Usuario;
import java.util.*;

public final class usuariosrelatorio_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/menu.jsp");
    _jspx_dependants.add("/rodape.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/tabela.css\">\n");
      out.write("        <link href=\"css/grafico.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("        <title>Lista de Usuários</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("            <div class=\"topnav\">\n");
      out.write("                ");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<style>\n");
      out.write("* {\n");
      out.write("  box-sizing: border-box;\n");
      out.write("  font-family: Arial, Helvetica, sans-serif;\n");
      out.write("}\n");
      out.write("\n");
      out.write("body {\n");
      out.write("  margin: 0;\n");
      out.write("  font-family: Arial, Helvetica, sans-serif;\n");
      out.write("}\n");
      out.write("\n");
      out.write("ul {\n");
      out.write("  list-style-type: none;\n");
      out.write("  margin: 0;\n");
      out.write("  padding: 0;\n");
      out.write("  overflow: hidden;\n");
      out.write("  background-color: #333;\n");
      out.write("}\n");
      out.write("\n");
      out.write("li {\n");
      out.write("  float: left;\n");
      out.write("}\n");
      out.write("\n");
      out.write("li a, .dropbtn {\n");
      out.write("  display: inline-block;\n");
      out.write("  color: white;\n");
      out.write("  text-align: center;\n");
      out.write("  padding: 14px 16px;\n");
      out.write("  text-decoration: none;\n");
      out.write("}\n");
      out.write("\n");
      out.write("li a:hover, .dropdown:hover .dropbtn {\n");
      out.write("  background-color: red;\n");
      out.write("}\n");
      out.write("\n");
      out.write("li.dropdown {\n");
      out.write("  display: inline-block;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".dropdown-content {\n");
      out.write("  display: none;\n");
      out.write("  position: absolute;\n");
      out.write("  background-color: #f9f9f9;\n");
      out.write("  min-width: 160px;\n");
      out.write("  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n");
      out.write("  z-index: 1;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".dropdown-content a {\n");
      out.write("  color: black;\n");
      out.write("  padding: 12px 16px;\n");
      out.write("  text-decoration: none;\n");
      out.write("  display: block;\n");
      out.write("  text-align: left;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".dropdown-content a:hover {background-color: #f1f1f1;}\n");
      out.write("\n");
      out.write(".dropdown:hover .dropdown-content {\n");
      out.write("  display: block;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Style the content */\n");
      out.write(".content {\n");
      out.write("  background-color: #ddd;\n");
      out.write("  padding: 10px;\n");
      out.write("\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Style the footer */\n");
      out.write(".footer {\n");
      out.write("  background-color: #f1f1f1;\n");
      out.write("  padding: 10px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<ul>\n");
      out.write("  <li><a href=\"index.jsp\">Principal</a></li>\n");
      out.write("  <li><a href=\"#news\">Pedido</a></li>\n");
      out.write("  <li><a href=\"#news\">Relatório</a></li>\n");
      out.write("\n");
      out.write("<li class='dropdown'><a href='javascript:void(0)' class='dropbtn'>Usuários</a>\n");
      out.write("<div class='dropdown-content'><a href='usuarioscontrolar1.jsp?pag=1'>Controlar Usuários sem paginação</a><a href='usuarioscontrolar.jsp?pag=1'>Controlar Usuários com paginação</a><a href='usuariocadastrarform.html'>Cadastrar Usuário</a></div></li>\n");
      out.write("\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("</body>");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"content\">        \n");
      out.write("            ");

                
                List<Usuario> list = usuariosDao.getRelatorio();
                request.setAttribute("list", list);
               
                int ADM = usuariosDao.getADM();
                request.setAttribute("ADM", ADM);
                
                int Comum = usuariosDao.getComum();
                request.setAttribute("Comum", Comum);

            
      out.write("\n");
      out.write("        \n");
      out.write("            <h1>Lista de Usuários</h1>\n");
      out.write("            <table>\n");
      out.write("            <tr><th>Id</th><th>Nome</th><th>Email</th><th>Senha</th><th>Acesso</th></tr>\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </table>\n");
      out.write(" \n");
      out.write("            <div class=\"grafico\">\n");
      out.write("                <canvas id=\"myChart\"></canvas>\n");
      out.write("                <p>Distribuição de Usuários:</p>\n");
      out.write("                <p>Administrador: ");
      out.print(ADM);
      out.write("</p>\n");
      out.write("                <p>Comum: ");
      out.print(Comum);
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js\n");
      out.write("            \"></script>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        var ctx = document.getElementById(\"myChart\");\n");
      out.write("        var valores = [");
      out.print(Comum);
      out.write(',');
      out.write(' ');
      out.print(ADM);
      out.write("];\n");
      out.write("        var tipos = [\"Comum\", \"ADM\"];\n");
      out.write("\n");
      out.write("        var myChart = new Chart(ctx, {\n");
      out.write("          type: \"pie\",\n");
      out.write("          data: {\n");
      out.write("            labels: tipos,\n");
      out.write("            datasets: [\n");
      out.write("              {\n");
      out.write("                label: \"Usuarios\",\n");
      out.write("                data: valores,\n");
      out.write("                backgroundColor: [\n");
      out.write("                  \"rgba(255, 99, 132, 0.2)\",\n");
      out.write("                  \"rgba(54, 162, 235, 0.2)\",\n");
      out.write("                  \"rgba(255, 206, 86, 0.2)\",\n");
      out.write("                  \"rgba(75, 192, 192, 0.2)\",\n");
      out.write("                  \"rgba(153, 102, 255, 0.2)\",\n");
      out.write("                ]\n");
      out.write("              }\n");
      out.write("            ]\n");
      out.write("          }\n");
      out.write("        }); \n");
      out.write("    </script>           \n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"footer\">\n");
      out.write("        ");
      out.write("<p>Projeto Final</p>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("usuario");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                <tr>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.getNome()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.getEmail()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>            \n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.getSenha()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>    \n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.getAcesso()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td> \n");
          out.write("          \n");
          out.write("                </tr>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
