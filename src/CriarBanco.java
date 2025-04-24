// CriarBanco.java

import java.sql.Connection;
import java.sql.Statement;

public class CriarBanco {

    public static void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS pessoa ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome TEXT NOT NULL, "
                + "idade INTEGER NOT NULL, "
                + "salario REAL NOT NULL);";
        try (Connection conn = ConexaoSQLite.conectar(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        criarTabela(); // Rode uma vez para criar o banco
    }
}
