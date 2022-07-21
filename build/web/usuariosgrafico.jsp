<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Dao, dao.UsuariosDao, classes.Usuario, java.util.*, org.json.JSONObject"%>
            <%               
                int[] valores = UsuariosDao.getRelatorioUsuarios();
                request.setAttribute("valores", valores);  


JSONObject jo = new JSONObject();
jo.put("status", true);
jo.put("dados", valores);

            %>
<%=jo%>

            