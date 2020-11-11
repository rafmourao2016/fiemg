package br.com.projetoDAO.DAO;

import br.com.projetoDAO.Conexao.Conexao;
import br.com.projetoDAO.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class PessoaDAO {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean consulta() {
        String sql = "Select * from pessoa ";

        con = Conexao.conectar();
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            System.out.printf("%-5s|%-50s|%-20s\n", "ID", "Nome", "Profissao");
            while (rs.next()) {
                System.out.printf("%-5s|%-50s|%-20s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            return true;
        } catch (Exception e) {
            System.out.println("Nao foi possivel acessar os dados:" + e);
            return false;
        } finally {
            Conexao.desconectar(con);
        }
    }

    public boolean inserir(Pessoa p) {
        String sql = " INSERT INTO pessoa(nome, profissao) values(?,?)";
        con = Conexao.conectar();

        try {
            pst = con.prepareStatement(sql);
            pst.setString(0, p.getNome());
            pst.setString(2, p.getProfissao());
            int r = pst.executeUpdate();
            if (r > 0) {
               JOptionPane.showMessageDialog(null,"dados inseridos com sucesso");
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"N foi possivel inserir os dados");
            return false;
        } finally {

            Conexao.desconectar(con);
        }
    }

    public boolean atualizar(Pessoa p) {
        String sql = "UPDATE pessoa "
                + "SET  nome=?,  profissao = ? WHERE id = ? ";
        con = Conexao.conectar();
        try {
            if (p.getNome().isEmpty() || p.getProfissao().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");

            } else {

            }

            pst = con.prepareStatement(sql);
            pst.setString(0, p.getNome());
            pst.setString(2, p.getProfissao());

            int r = pst.executeUpdate();

            if (r > 0) {
                JOptionPane.showMessageDialog(null,
                        "Alterado com sucesso!");
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
            
        }
    }

    public boolean remover(Pessoa p) {

        String sql = "DELETE from pessoa  where id=?";
           con = Conexao.conectar();

     
            try {
            
                pst = con.prepareStatement(sql);
                Pessoa.setid(p.getid("id"));
                pst.setString(0, p.getd());
         
                int r = pst.executeUpdate();

               if (r > 0) {
                JOptionPane.showMessageDialog(null,
                        "Excluido com sucesso!");
            }
           return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
            
        }
    }
      
      
}
