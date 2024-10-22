import java.util.ArrayList;
import java.util.Scanner;

// Definição da classe Piloto
public class Piloto {
    // Atributos da classe Piloto
    private String nome;          // Nome do piloto
    private int fichasCorrida;    // Fichas de corrida do piloto
    private Veiculo veiculoAtual; // Veículo atual do piloto
    private int vitorias;         // Número de vitórias do piloto
    private ArrayList<ItemCorrida> itensComprados;

    /**
     * Construtor da classe Piloto
     * @param nome
     * @param fichasCorrida
     * @param veiculoAtual
     * @param vitorias
     */
    public Piloto(String nome, int fichasCorrida, Veiculo veiculoAtual, int vitorias) {
        this.nome = nome;
        this.fichasCorrida = fichasCorrida;
        this.veiculoAtual = veiculoAtual;
        this.vitorias = vitorias;
    }

    // Meus Métodos de acesso (getters e setters) para os atributos da classe Piloto

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFichasCorrida() {
        return fichasCorrida;
    }

    public void setFichasCorrida(int fichasCorrida) {
        this.fichasCorrida = fichasCorrida;
    }

    public Veiculo getVeiculoAtual() {
        return veiculoAtual;
    }

    public void setVeiculoAtual(Veiculo veiculoAtual) {
        this.veiculoAtual = veiculoAtual;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }



    /**
     * Método usarItem
     */
    public void usarItem(){
        if(veiculoAtual != null) {

            for(int i=0; i<itensComprados.size(); i++) {
                System.out.println("Escolhe o item de ser aplicado: " + i);
                itensComprados.get(i).mostrarDetalhesItem();
                Scanner in = new Scanner(System.in);
                int itemEscolhido = in.nextInt();

                if (veiculoAtual instanceof Carro) {
                    ((Carro) veiculoAtual).addModificacoes((Modificacao) itensComprados.get(itemEscolhido));
                } else {
                    ((Mota) veiculoAtual).addHabilidade((Habilidade) itensComprados.get(itemEscolhido));
                }
            }
        } else {
            System.out.println("Você não tem um veiculo atualmente. ");
        }
    }

    /**
     *  Método Corrida
     * @param pista
     * @return
     */

    public double corrida(Pista pista){
        double tempoTotal = 0;

        //Calcula o tempo da volta
        double tempoVolta = calcularTempoVolta(pista);
        //Aplica o atraso dos momentos
        double atrasoMomentos = calcularAtrasoMomentos(pista);
        //Soma o tempo da volta ao tempo total
        tempoTotal += (tempoVolta + atrasoMomentos);
        // Aumenta o desgaste do veiculo em 20 a cada volta
        veiculoAtual.setDesgaste(veiculoAtual.getDesgaste() + 20);

        return tempoTotal;
    }

    /**
     * Metrodo TempoVolta
     * @param pista
     * @return
     */
    public double calcularTempoVolta(Pista pista){
        double distanciaVolta = pista.getDistanciaVoltaM();
        double potencia = veiculoAtual.getPotenciaCV();
        double peso = veiculoAtual.getPesoKg();
        double desgaste = veiculoAtual.getDesgaste();

        return distanciaVolta / ((1.6 * potencia) - (0.2 * peso) - (0.5 * desgaste));
    }


    /**
     * Metodo AtrasoMomentos
     * @param pista
     * @return
     */
    public double calcularAtrasoMomentos(Pista pista){
        for(Momento momento: pista.getMomentosPista()) {
            return ((veiculoAtual.getPesoKg() * momento.getAtrasoPeso())
                    + (veiculoAtual.getPotenciaCV() * momento.getAtrasoPotencia()))/100;
        }

        return 0;
    }
}