import java.util.ArrayList;
import java.util.List;

// Definição da subclasse Modificacao que herda da classe ItemCorrida
public class Modificacao extends ItemCorrida {
    // Atributos adicionais da classe Modificacao
    private int diminuicaoDesgaste;                    // Diminuição do desgaste
    private double diminuicaoPeso;                     // Diminuição do peso
    private ArrayList<TipoCarro> carrosPermitidos;     // ArrayList<TipoCarro> dos tipos de carro permitidos para adicioar ao codigo futuramente

    /**
     *
     * @param nome
     * @param precoEmFichas
     * @param diminuicaoDesgaste
     * @param diminuicaoPeso
     */
    public Modificacao(String nome, int precoEmFichas, int diminuicaoDesgaste, double diminuicaoPeso) {
        super(nome, precoEmFichas);
        this.diminuicaoDesgaste = diminuicaoDesgaste;
        this.diminuicaoPeso = diminuicaoPeso;
        this.carrosPermitidos = new ArrayList<>();
    }


    /**
     * Método para Adicionar os Tipo de Carro ao ArrayList<TipoCarro>
     * @param tipoCarro
     */

    public void addTipoCarro(TipoCarro tipoCarro) {
        this.carrosPermitidos.add(tipoCarro);
    }


    /**
     * Método para mostrar os detalhes da modificação
     */
    @Override
    public void mostrarDetalhesItem() {
        System.out.println("Detalhes da Modificação:");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Preço em Fichas: " + this.getPrecoEmFichas());
        System.out.println("Diminuição do Desgaste: " + this.diminuicaoDesgaste);
        System.out.println("Diminuição do Peso: " + this.diminuicaoPeso);
        System.out.println("Carros Permitidos: " + this.carrosPermitidos);
    }

    // Métodos de acesso para os atributos específicos da classe Modificacao
}