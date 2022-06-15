/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Curso;
import classes.Turma;
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
public class CursosDao {
        public static List<Curso> getCursos() {
        List<Curso> list = new ArrayList<Curso>();   

        try{
            Connection con = getConnection(); 
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM cursos");
            ResultSet rs = ps.executeQuery(); 

            while(rs.next()){
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                list.add(curso);
            }
            
        }catch(Exception erro){
            System.out.println(erro);
        }
        return list;
    }
}
