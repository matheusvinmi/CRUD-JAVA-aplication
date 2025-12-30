/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class conexaoDAO {

    public Connection conectaDB() {
        Connection conexVar = null;

        try {
            String driver = "com.mysql.jdbc.Driver";

            try {
                Class.forName(driver);
            } catch (ClassNotFoundException erro) {
                JOptionPane.showMessageDialog(null, "Drive de conexao não encontrado!" + erro);
            }

            String usuario = "root";
            String baseD = "localhost";
            String BDport = "3306";
            String senha = "";
            String NameBD = "crudapl";
            String url = "jdbc:mysql://" + baseD + ":" + BDport + "/" + NameBD + "?" + "user="
                    + usuario + "&" + "password=" + senha;
            conexVar = DriverManager.getConnection(url);

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro em conexaoDAO" + erro.getMessage());
        }
        return conexVar;
    }
}
