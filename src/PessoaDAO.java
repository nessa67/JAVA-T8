// PessoaDAO.java

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    public static void inserir(Pessoa p) {
        String sql = "INSERT INTO pessoa (nome, idade, salario) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoSQLite.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getNome());
            pstmt.setInt(2, p.getIdade());
            pstmt.setDouble(3, p.getSalario());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public static List<Pessoa> listar() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoa ORDER BY id";
        try (Connection conn = ConexaoSQLite.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pessoa p = new Pessoa(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getDouble("salario")
                );
                pessoas.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return pessoas;
    }

    public static void atualizar(Pessoa p) {
        String sql = "UPDATE pessoa SET nome = ?, idade = ?, salario = ? WHERE id = ?";
        try (Connection conn = ConexaoSQLite.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getIdade());
            stmt.setDouble(3, p.getSalario());
            stmt.setInt(4, p.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public static void excluir(int id) {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        try (Connection conn = ConexaoSQLite.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }
}
