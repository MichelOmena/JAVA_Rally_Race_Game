import java.util.ArrayList;
import java.util.List;

// Definição da classe Pista
public class Pista {
    // Atributos da classe Pista
    private String nome;                // Nome da pista
    private double tempo;               // Tempo da corrida
    private double tempoRecordeSeg;     // Tempo recorde em segundos
    private double distanciaVoltaM;     // Distância por volta em metros
    private int quantidadeVoltas;       // Quantidade de voltas
    private List<Momento> momentosPista = new ArrayList<>();  // Momentos da pista

    /**
     * Metodo Construtor da Classe Pista
     * @param nome
     * @param tempo
     * @param tempoRecordeSeg
     * @param distanciaVoltaM
     * @param quantidadeVoltas
     * @param momento
     */
    public Pista(String nome, double tempo, double tempoRecordeSeg, double distanciaVoltaM, int quantidadeVoltas, List<Momento> momento) {
        this.nome = nome;
        this.tempo = tempo;
        this.tempoRecordeSeg = tempoRecordeSeg;
        this.distanciaVoltaM = distanciaVoltaM;
        this.quantidadeVoltas = quantidadeVoltas;
        this.momentosPista = momento;
    }


    /**
     * Metodo addMomentosPista
     * @param momento
     */
    // Método para Adicionar os Momentos da  Classe Pista ao ArrayList<Veiculo>
    public void addMomentosPista(Momento momento) {
        this.momentosPista.add(momento);
    }

    //  Criar os Métodos de acesso (getters e setters) para os atributos da classe Pista

    public String getNome() {
        return this.nome;
    }

    public double getTempoRecordeSeg() {
        return this.tempoRecordeSeg;
    }

    public double getDistanciaVoltaM() {
        return this.distanciaVoltaM;
    }

    public List<Momento> getMomentosPista() {
        return this.momentosPista;
    }

    public int getQuantidadeVoltas() {
        return this.quantidadeVoltas;
    }
}