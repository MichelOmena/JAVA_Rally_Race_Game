// Definição da subclasse Habilidade que herda da classe ItemCorrida
public class Habilidade extends ItemCorrida {
    // Atributo adicional da classe Habilidade
    private int aumentoPotencia;  // Aumento de potência

    // Construtor da classe Habilidade
    public Habilidade(String nome, int precoEmFichas, int aumentoPotencia) {
        super(nome, precoEmFichas);
        this.aumentoPotencia = aumentoPotencia;
    }


    /**
     * Método mostrarDetalhesItem
     */
    @Override
    public void mostrarDetalhesItem() {
        System.out.println("Detalhes da Habilidade:");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Preço em Fichas: " + this.getPrecoEmFichas());
        System.out.println("Aumento de Potência: " + this.aumentoPotencia);
    }

    // Método de acesso para o atributo específico da classe Habilidade
}