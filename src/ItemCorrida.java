// Definição da classe abstrata ItemCorrida
public abstract class ItemCorrida {
    // Atributos da classe ItemCorrida
    private String nome;                      // Nome do item
    private int precoEmFichasDaCorrida;       // Preço do item em fichas de corrida

    // Construtor da classe ItemCorrida
    public ItemCorrida(String nome, int precoEmFichas) {
        this.nome = nome;
        this.precoEmFichasDaCorrida = precoEmFichas;
    }

    /**
     * Método abstrato mostrarDetalhesItem
     */
    public abstract void mostrarDetalhesItem();


    //Métodos de acesso (getters e setters)

    public String getNome() {
        return nome;
    }

    public int getPrecoEmFichas() {
        return precoEmFichasDaCorrida;
    }
}