/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Curso;
import classes.Turma;
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
public class TurmasDao {
        public static List<Turma> getTurmas() {
    List<Turma> list = new ArrayList<Turma>();
    List<Curso> list1 = new ArrayList<Curso>();
    
 
    try{

        Connection con = getConnection(); 
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM cursos");
        ResultSet rs = ps.executeQuery(); 
        
        while(rs.next()){
            Curso curso = new Curso();
            curso.setId(rs.getInt("id"));
            curso.setNome(rs.getString("nome"));
            list1.add(curso);
        }

        ps = (PreparedStatement) con.prepareStatement("SELECT * FROM turmas");
        rs = ps.executeQuery();
        
        while(rs.next()){
            Turma turma = new Turma();
            turma.setId(rs.getInt("id"));
            turma.setNumero(rs.getInt("numero"));     
                for(Curso curso : list1){
                    if(rs.getInt("curso_id")==curso.getId()){
                        turma.setCurso(curso);                        
                    }         
                }            
            list.add(turma);
        } 
       
    }catch(Exception erro){
        System.out.println(erro);
    }
    return list;
    }

}
