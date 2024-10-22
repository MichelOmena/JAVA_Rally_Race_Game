import exception.PesoException;

import java.util.ArrayList;

// Definição da subclasse Mota que herda da classe abstrata Veiculo
public class Mota extends Veiculo {
    // Atributo adicional da classe Mota
    private ArrayList<Habilidade> habilidadesMota;  // Lista de habilidades da mota

    // Construtor da classe Mota (com os atributos da classe veiculo e da propria classe Mota
    public Mota(String nome, String marca, int potenciaCV, double pesoKg, int desgaste, int preco) throws PesoException {
        super(nome, marca, potenciaCV, pesoKg, desgaste, preco);    // Sempre tem que o super pra chamar os atributos da classe Veiculo

        // Excessão de Tratamento de Erro para Verifica se o peso máximo de 400Kg é respeitado ao instanciar uma mota
        if (pesoKg > 400) {
            throw new PesoException("Peso máximo de uma mota é 400Kg.");
        }

        // Inicialização do atributo específico da classe Mota
        this.habilidadesMota = habilidadesMota;
        this.habilidadesMota = new ArrayList<Habilidade>();
    }

    /**
     * Método para Adicionar os Modificadores ao ArrayList<Modificacao>
     * @param habilidade {@link Habilidade}
     */
    public void addHabilidade(Habilidade habilidade) {
        this.habilidadesMota.add(habilidade);
    }

    /**
     * Método para mostrar os detalhes da mota
     */
    @Override
    public void mostrarDetalhes() {
        // Exibição dos detalhes do veículo e informações específicas da mota
        System.out.println("Detalhes da Mota:");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Potência: " + this.getPotenciaCV() + " CV");
        System.out.println("Peso: " + this.getPesoKg() + " Kg");
        System.out.println("Desgaste: " + this.getDesgaste());
        System.out.println("Habilidades: " + habilidadesMota);
    }

    // Criar os Métodos de acesso Get e Set para o atributo específico da classe Mota
}