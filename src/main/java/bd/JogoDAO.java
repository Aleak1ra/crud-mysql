package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import model.Jogo;

public class JogoDAO {

    public void inserir(Jogo j) {
        String sql = "INSERT INTO jogo (nome, ano, imagem, desenvolvedor, genero) VALUES (?, ?, ?, ?, ?)";

        Connection c = null;
        PreparedStatement pstm = null;

        try {
            c = ConnectionFactory.criarConexao();
            pstm = c.prepareStatement(sql);

            pstm.setString(1, j.getNome());
            pstm.setInt(2, j.getAno());
            pstm.setBytes(3, j.getImagem());
            pstm.setString(4, j.getDesenvolvedor());
            pstm.setString(5, j.getGenero());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro nao conectado ao BD");
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }

    }
}
