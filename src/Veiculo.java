
public abstract class Veiculo {
    // Atributos da minha classe Veiculo
    private String nome;
    private String marca;
    private int potenciaCV;
    private double pesoKg;
    private int desgaste;
    private int precoEmFichasDaCorrida;      // Preço do item em fichas de corrida

    /**
     * Metodo Construtor da classe veiculo
     * @param nome
     * @param marca
     * @param potenciaCV
     * @param pesoKg
     * @param desgaste
     * @param preco
     */
    public Veiculo(String nome, String marca, int potenciaCV, double pesoKg, int desgaste, int preco) {
        // Inicialização dos atributos com os valores passados como argumentos
        this.nome = nome;
        this.marca = marca;
        this.potenciaCV = potenciaCV;
        this.pesoKg = pesoKg;
        this.desgaste = desgaste;
        this.precoEmFichasDaCorrida = preco;
    }

    /**
     * Metodo abstrato mostrarDetalhes
     */
    // Método abstrato para mostrar os detalhes do veículo (será implementado nas subclasses)
    public abstract void mostrarDetalhes();


    //Métodos Getter's dos atributos da minha classe
    // PorquêUsar?Podemos trazer mais seguranca a nossa aplicacao controlando os parametros



    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public int getPotenciaCV() {
        return potenciaCV;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public int getDesgaste() {
        return desgaste;
    }

    public int getPrecoEmFichas() {
        return precoEmFichasDaCorrida;
    }

    public void setDesgaste(int desgaste) {
        this.desgaste = desgaste;
    }
}