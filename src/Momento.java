// Definição da classe Momento
public class Momento {
    // Atributos da classe Momento
    private String nome;          // Nome do momento
    private double atrasoPeso;    // Atraso de peso
    private double atrasoPotencia;// Atraso de potência

    // Construtor da classe Momento
    public Momento(String nome, double atrasoPeso, double atrasoPotencia) {
        this.nome = nome;
        this.atrasoPeso = atrasoPeso;
        this.atrasoPotencia = atrasoPotencia;
    }

    //  Os meus Métodos de acesso (getters e setters) para os atributos da classe Momento


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAtrasoPeso() {
        return atrasoPeso;
    }

    public void setAtrasoPeso(double atrasoPeso) {
        this.atrasoPeso = atrasoPeso;
    }

    public double getAtrasoPotencia() {
        return atrasoPotencia;
    }

    public void setAtrasoPotencia(double atrasoPotencia) {
        this.atrasoPotencia = atrasoPotencia;
    }
}