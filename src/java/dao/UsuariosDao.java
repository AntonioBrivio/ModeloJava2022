/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Usuario;
import static dao.Dao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class UsuariosDao {
        public static Usuario getUsuarioById(int id){
        Usuario usuario = null;      
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from usuarios where Id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));         
            usuario.setSenha(rs.getString("senha"));   
            usuario.setAcesso(rs.getString("acesso")); 
        }
    }catch(Exception erro){
        System.out.println(erro);
    }      
        return usuario;
    }
    
    
   public static int editarUsuario(Usuario usuario){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE usuarios SET Nome=?, Email=?, Acesso=? WHERE id=?");
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getAcesso()); 
        ps.setInt(4, usuario.getId());         
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }
    
    public static List<Usuario> getUsuarios(int inicio, int total) {
    List<Usuario> list = new ArrayList<Usuario>();
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuarios ORDER BY id LIMIT " + (inicio - 1) + " ," + total);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));         
            usuario.setSenha(rs.getString("senha"));   
            usuario.setAcesso(rs.getString("acesso")); 
            usuario.setStatus(rs.getString("status"));
            list.add(usuario);
        }       
    }catch(Exception erro){
        System.out.println(erro);
    }
    return list;
    }

    public static List<Usuario> getRelatorio() {
    List<Usuario> list = new ArrayList<Usuario>();
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuarios");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));          
            usuario.setAcesso(rs.getString("acesso")); 
            list.add(usuario);
        }       
    }catch(Exception erro){
        System.out.println(erro);
    }
    return list;
    }
    
    public static int getContagem() {
        int contagem = 0;
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS contagem FROM usuarios");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                contagem = rs.getInt("contagem");
            }   
        }catch(Exception erro){
            System.out.println(erro);
        }
        return contagem;
    }
    
    
        public static int[] getRelatorioUsuarios() {

        int[] valores = {0, 0};
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS ADM FROM usuarios where Acesso = 'Admin'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                valores[0] = rs.getInt("ADM");
            }   
 
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Comum FROM usuarios where Acesso = 'Comum'");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[1] = rs.getInt("Comum");
            }            
            
        }catch(Exception erro){
            System.out.println(erro);
        }
        return valores;
    }
        

        
    
    public static int excluirUsuario(Usuario usuario){
       int status = 0;  
        try{
             Connection con = getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM usuarios WHERE id=?");
             ps.setInt(1, usuario.getId());         
             status = ps.executeUpdate();
         }catch(Exception erro){
             System.out.println(erro);
         }      
            return status;
   }
    

    public static int bloquearUsuario(Usuario usuario){
       int status = 0;  
       String statusdousuario;
       
       if(usuario.getStatus().equals("ativo")){
        statusdousuario = "inativo";   
       }else{
        statusdousuario = "ativo";   
       }
        try{
             Connection con = getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE usuarios SET Status=? WHERE id=?");
             ps.setString(1, statusdousuario);
             ps.setInt(2, usuario.getId());         
             status = ps.executeUpdate();
         }catch(Exception erro){
             System.out.println(erro);
         }      
            return status;
   }

    
   public static int cadastrarUsuario(Usuario usuario){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO USUARIOS(NOME,EMAIL,SENHA,ACESSO,STATUS) VALUES(?,?,?,?,'ativo')");
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getSenha());        
        ps.setString(4, usuario.getAcesso());          
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }
    
public static Usuario logar(String email, String senha){ 
Usuario usuario = new Usuario();    
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from usuarios where Email=?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        //Verifica se a consulta retornou resultado
        if (rs.next()) {       
                if(rs.getString("status").equals("ativo")){
                    if(rs.getString("senha").equals(senha)){
                        usuario.setId(rs.getInt("id"));
                        usuario.setNome(rs.getString("nome"));
                        usuario.setEmail(rs.getString("email"));         
                        usuario.setSenha(rs.getString("senha"));   
                        usuario.setAcesso(rs.getString("acesso"));     
                    }else{
                        //Senha errada
                        usuario = null;
                    }
                }else{
                   //Usuário Inativo
                   usuario = null;     
                }
        }else{
            // E-mail não existe
            usuario = null; 
        }
    }catch(Exception erro){
        System.out.println(erro);
    }      
        return usuario;
    }
   
}
