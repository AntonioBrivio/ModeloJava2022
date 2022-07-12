package dao;


import classes.Curso;
import classes.Evento;
import static dao.Dao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;




public class EventosDao {
    public static int cadastrarEvento(String data, String hora){
       int status = 0;  
   try{
        Connection con = getConnection();
       PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO eventos(title, description, start, end, color, usuario_id) VALUES('Evento', 'Evento marcado', ?, ?, 'blue', 4)");
        Timestamp start = java.sql.Timestamp.valueOf(data + ' ' + hora);
        Timestamp end = new Timestamp(start.getTime()+2400000);  
        ps.setTimestamp(1, start);
        ps.setTimestamp(2, end);        
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }        
    public static List<Evento> getEventos(){
     List<Evento> list = new ArrayList<Evento>();
   try{
        Connection con = getConnection();
       PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from eventos");        
                    ResultSet rs = ps.executeQuery(); 

            while(rs.next()){
                Evento evento = new Evento();
                evento.setId(rs.getInt("id"));
                evento.setTitle(rs.getString("title"));
                evento.setDescription(rs.getString("description"));
                evento.setStart(rs.getTimestamp("start"));
                evento.setEnd(rs.getTimestamp("end"));                
                evento.setColor(rs.getString("color"));                
                list.add(evento);
            }
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return list;
   }
}

