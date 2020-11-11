/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoDAO.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    Connection con = null;
    static final String URL = "jdbc:mysql://localhost:3308/projetoDAO?useTimezone=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "!@#Abc123";

    public static Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            return conn;
        } catch (Exception e) {
            System.out.println("Não foi possível conectar: " + e);
            return null;
        }
    }

    public static void desconectar(Connection conexao) {
        try {
            conexao.close();
        } catch (Exception e) {
            System.out.println("Não foi possível desconectar: " + e);
        }
    }

}
