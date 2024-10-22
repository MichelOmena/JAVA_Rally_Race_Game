import exception.PesoException;

import java.util.ArrayList;



/**
 * Subclasse Carro herdará a minha classe abstrata Veiculo
 */
public class Carro extends Veiculo {
    // Atributos adicionais da classe Carro
    private TipoCarro tipoCarro;                           // Tipo do carro
    private ArrayList<Modificacao> kitCorrida;             // Lista de modificações para corrida

    /**
     * Método Construtor da minha Classe Carro
     */
    public Carro(String nome, String marca, int potenciaCV, double pesoKg, int desgaste, TipoCarro tipoCarro, int preco) throws PesoException {
        // Super serve para chamar os atributos do construtor da classe Veiculo
        super(nome, marca, potenciaCV, pesoKg, desgaste, preco);

        // Excessão de Tratamento de Erro para Verifica se o peso mínimo de 1000Kg é respeitado ao instanciar um carro
        if (pesoKg < 1000) {
            throw new PesoException("Peso mínimo de um carro é 1000Kg.");
        }

        // Inicialização dos atributos específicos da classe Carro
        this.tipoCarro = tipoCarro;
        this.kitCorrida = new ArrayList<>();
    }

    /**
     * Método para adicionar os modificadores ao ArrayList<Modificacao>
     * @param modificacao {@link Modificacao}
     */
    public void addModificacoes(Modificacao modificacao) {
        this.kitCorrida.add(modificacao);
    }


    /**
     * Metodo ArrayList<modificacao>
     * @return
     */
    public ArrayList<Modificacao> getKitCorrida() {
        return this.kitCorrida;
    }
    /**
     * Método para mostrar os detalhes do carro
     */
    @Override
    public void mostrarDetalhes() {
        // Exibição dos detalhes do veículo e informações específicas do carro
        System.out.println("Detalhes do Carro:");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Potência: " + this.getPotenciaCV() + " CV");
        System.out.println("Peso: " + this.getPesoKg() + " Kg");
        System.out.println("Desgaste: " + this.getDesgaste());
        System.out.println("Tipo de Carro: " + tipoCarro);
        System.out.println("Kit de Corrida: " + this.kitCorrida);
    }
}