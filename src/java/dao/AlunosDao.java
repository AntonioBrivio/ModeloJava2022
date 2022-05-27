/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Aluno;
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
public class AlunosDao {
    public static List<Aluno> getAlunos(int turma_id) {
    List<Aluno> list = new ArrayList<Aluno>();
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM alunos where turma_id=" + turma_id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Aluno aluno = new Aluno();
            aluno.setId(rs.getInt("id"));
            aluno.setNome(rs.getString("nome"));
            list.add(aluno);
        }       
    }catch(Exception erro){
        System.out.println(erro);
    }
    return list;
    }
}
