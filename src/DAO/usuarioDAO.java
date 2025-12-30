/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class usuarioDAO {

    private Connection conn;
    private PreparedStatement mysql;
    private Statement stt;
    ResultSet rs;

    public void cadatrarUser(UsuarioDTO gs) {
        conexaoDAO cd = new conexaoDAO();
        conn = (cd.conectaDB());

        String sql = "insert into usuario(nome_usuario, email_usuario, senha_usuario) values(?,?,?)";

        try {
            mysql = conn.prepareStatement(sql);
            mysql.setString(1, gs.getNome_usuario());
            mysql.setString(2, gs.getEmail_usuario());
            mysql.setString(3, gs.getSenha_usuario());

            mysql.executeUpdate();
            mysql.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro no cadastro em UsuarioDAO" + e);
        }
    }

    public ArrayList<UsuarioDTO> ListarUsuario() {
        conexaoDAO cd = new conexaoDAO();
        conn = (cd.conectaDB());
        ArrayList<UsuarioDTO> listaa = new ArrayList<>();
        String sql = "select * from usuario";

        try {

            mysql = conn.prepareStatement(sql);
            rs = mysql.executeQuery();

            while (rs.next()) {
                UsuarioDTO userDto = new UsuarioDTO();
                userDto.setId_usuario(rs.getInt("id_usuario"));
                userDto.setNome_usuario(rs.getString("nome_usuario"));
                userDto.setEmail_usuario(rs.getString("email_usuario"));
                userDto.setSenha_usuario(rs.getString("senha_usuario"));
                listaa.add(userDto);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro na listagem em FuncionarioDAO" + e);
        }
        return listaa;
    }
    
    public void alterarUser(UsuarioDTO gs){
         conexaoDAO cd = new conexaoDAO();
        conn = (cd.conectaDB());

        String sql = "update usuario set nome_usuario = ?,"
                + " email_usuario = ?, senha_usuario = ? where id_usuario = ?";

        try {
            mysql = conn.prepareStatement(sql);
            mysql.setString(1, gs.getNome_usuario());
            mysql.setString(2, gs.getEmail_usuario());
            mysql.setString(3, gs.getSenha_usuario());
            mysql.setInt(4, gs.getId_usuario());

            mysql.executeUpdate();
            mysql.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro no alterar em FuncionarioDAO" + e);
        }
    }
    
    public void excluirUser(UsuarioDTO gs){
        conexaoDAO cd = new conexaoDAO();
        conn = (cd.conectaDB());
         String sql = "delete from usuario where id_usuario = ?";
          try {
            mysql = conn.prepareStatement(sql);
            mysql.setInt(1, gs.getId_usuario());

            mysql.execute();
            mysql.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro no excluir em FuncionarioDAO" + e);
        }
         
        
        
    }
}
