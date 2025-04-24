// Pessoa.java

public class Pessoa {

    private int id;
    private String nome;
    private int idade;
    private double salario;
// Construtor

    public Pessoa(int id, String nome, int idade, double salario) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }
// Getters e Setters (gerados automaticamente no NetBeans: Alt+Insert)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
