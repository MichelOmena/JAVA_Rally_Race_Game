import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Jogo {

    private static final Integer RECORDE = 500;

    private static final Oficina oficina = new Oficina();
    private static final ArrayList<Pista> pistas = new ArrayList<>();

    private static final Scanner in = new Scanner(System.in);



    public static void main(String[] args) {
        corridasRapidas();
        simuladorCorridas();
        aventuraNaPista();
        derradeiraPista();
        criarVeiculos();
        criarItens();

        Piloto piloto = criarPiloto();

        oficina.venderVeiculo(piloto);

        for (Pista pista : pistas) {
            System.out.println("Começa nova corrida " + pista.getNome());
            double tempoTotal = 0;

            for(int volta = 0; volta <= pista.getQuantidadeVoltas(); volta++) {
                System.out.println("Vai na volta " + volta);
                tempoTotal = tempoTotal + piloto.corrida(pista);
            }

            if (tempoTotal >= pista.getTempoRecordeSeg()) {
                piloto.setFichasCorrida(RECORDE);
                System.out.println("Parabens bateu recorde! " + tempoTotal);

            } else {
                piloto.setFichasCorrida(RECORDE / 2);
                System.out.println("Infelizmente não bateu recorde! " + tempoTotal);
            }

            System.out.println("FIM DA CORRIDA");
            System.out.println("Deseja comprar carro novo? 'SIM', 'NAO'");

            if ("SIM".equalsIgnoreCase(in.nextLine())) {
                oficina.venderVeiculo(piloto);
            }

            System.out.println("Deseja comprar item novo? 'SIM', 'NAO'");

            if ("SIM".equalsIgnoreCase(in.nextLine())) {
                oficina.venderItem(piloto);

                System.out.println("Deseja comprar mais itens novos? 'SIM', 'NAO'");

                if ("SIM".equalsIgnoreCase(in.nextLine())) {
                    oficina.venderItem(piloto);
                }
            }
        }
    }

    /**
     * Cria um piloto
     * @return {@link Piloto} piloto criado
     */
    private static Piloto criarPiloto() {
        int moedas = criarDificuldade();

        Scanner in = new Scanner(System.in);
        System.out.println("Cria jogador");
        System.out.println("Introduza nome do jogador");
        String nome = in.nextLine();
        return new Piloto(nome, moedas, null, 0);
    }

    /**
     * Método @criarVeiculos
     */
    private static void criarVeiculos() {
        Veiculo veiculo1 = new Carro("X3", "BMW", 220, 2500, 0, TipoCarro.RALLY, 1000);
        oficina.adicionarVeiculo(veiculo1); //adiciono a minha oficina

        Veiculo veiculo2 = new Carro("206", "Peugeout", 110, 1500, 0, TipoCarro.GT, 800);
        oficina.adicionarVeiculo(veiculo2);

        Veiculo veiculo3 = new Carro("SS", "Camaro", 220, 1800, 0, TipoCarro.F1, 1500);
        oficina.adicionarVeiculo(veiculo3);

        Veiculo veiculo4 = new Mota("MT-Sport", "Yamaha", 300, 200, 0, 300);
        oficina.adicionarVeiculo(veiculo4);

        Veiculo veiculo5 = new Mota("Casal", "Formula1", 150, 250, 0, 200);
        oficina.adicionarVeiculo(veiculo5);

        Veiculo veiculo6 = new Mota("125cc", "Honda", 125, 300, 0, 400);
        oficina.adicionarVeiculo(veiculo6);

        Veiculo veiculo7 = new Mota("Lambreta", "Italia", 50, 80, 0, 200);
        oficina.adicionarVeiculo(veiculo7);

        Veiculo veiculo8 = new Carro("Carochinha", "Volkswagen", 120, 1300, 100, TipoCarro.RALLY, 500);
        oficina.adicionarVeiculo(veiculo8);

        Veiculo veiculo9 = new Carro("CorsaB", "Opel", 110, 1500, 12, TipoCarro.GT, 280);
        oficina.adicionarVeiculo(veiculo9);

        Veiculo veiculo10 = new Carro("3008", "Peugeout", 150, 2000, 0, TipoCarro.F1, 599);
        oficina.adicionarVeiculo(veiculo10);

        Veiculo veiculo11 = new Carro("BrasiliaAmarela", "Brasilia", 220, 1400, 0, TipoCarro.F1, 400);
        oficina.adicionarVeiculo(veiculo11);

        Veiculo veiculo12 = new Carro("Class A", "MercedesBenz", 250, 1700, 0, TipoCarro.GT, 1000);
        oficina.adicionarVeiculo(veiculo12);

        Veiculo veiculo13 = new Mota("Vespa", "VespadaItalia", 50, 150, 0, 500);
        oficina.adicionarVeiculo(veiculo13);

        Veiculo veiculo14 = new Carro("Bugatti Verona", "Buggati", 350, 2300, 0, TipoCarro.RALLY, 1600);
        oficina.adicionarVeiculo(veiculo14);

        Veiculo veiculo15 = new Carro("SpeedMasseratti", "Masseratti", 400, 1900, 0, TipoCarro.F1, 1800);
        oficina.adicionarVeiculo(veiculo15);

        Veiculo veiculo16 = new Carro("Toyota Corolla", "Toyota", 140, 1500, 10, TipoCarro.RALLY, 500);
        oficina.adicionarVeiculo(veiculo16);

        Veiculo veiculo17 = new Carro("Ford Mustang", "Ford", 290, 2000, 0, TipoCarro.F1, 1740);
        oficina.adicionarVeiculo(veiculo17);

        Veiculo veiculo18 = new Carro("Lamborgini Aventador", "Lamborgini", 400, 2600, 0, TipoCarro.GT, 2000);
        oficina.adicionarVeiculo(veiculo18);

        Veiculo veiculo19 = new Carro("918 Spyder", "Porsche", 450, 1600, 0, TipoCarro.F1, 2200);
        oficina.adicionarVeiculo(veiculo19);

        Veiculo veiculo20 = new Carro("McLaren Speedtail", "McLaren", 540, 1500, 0, TipoCarro.GT, 2400);
        oficina.adicionarVeiculo(veiculo20);
    }


    private static void criarItens() {
        ItemCorrida itemCorrida1 = new Habilidade("Turbo", 200, 400);
        oficina.adicionarItem(itemCorrida1);

        ItemCorrida itemCorrida2 = new Habilidade("Congelar adversarios",1000,1000);
        oficina.adicionarItem(itemCorrida2);

        ItemCorrida itemCorrida3 = new Habilidade("Voar",1400,1300);
        oficina.adicionarItem(itemCorrida3);

        ItemCorrida itemCorrida4 = new Habilidade("Pulo quantico",350,900);
        oficina.adicionarItem(itemCorrida4);

        ItemCorrida itemCorrida5 = new Habilidade("Veiculo Translucido",800,2000);
        oficina.adicionarItem(itemCorrida5);

        ItemCorrida itemCorrida6 = new Habilidade("Velocidade Joaguar",230,400);
        oficina.adicionarItem(itemCorrida6);

        ItemCorrida itemCorrida7 = new Modificacao("KitReparo",200,300,0);
        oficina.adicionarItem(itemCorrida7);

        ItemCorrida itemCorrida8 = new Modificacao("Spoiler",400,0,400);
        oficina.adicionarItem(itemCorrida8);

        ItemCorrida itemCorrida9 = new Modificacao("MotorV8",1000,300,500);
        oficina.adicionarItem(itemCorrida9);

        ItemCorrida itemCorrida10 = new Modificacao("DuploEscape",300,0,200);
        oficina.adicionarItem(itemCorrida10);

        ItemCorrida itemCorrida11 = new Modificacao("CarroceriaLight",400,0,600);
        oficina.adicionarItem(itemCorrida11);

        ItemCorrida itemCorrida12 = new Modificacao("Boost",200,3,50);
        oficina.adicionarItem(itemCorrida12);
    }

    /**
     * Método criarDificuldade
     * @return pontos consoante a dificuldade do jogo
     */
    private static int criarDificuldade(){
        Scanner in = new Scanner(System.in);
        System.out.println("=========================FAST AND FURIOUS ITCenter=====================");
        System.out.println("\t\t\t\t\t ****Definir Dificuldade****\t\t\t\t\t");
        System.out.println("Introduza a dificuldade do jogo: 'Canja','Tranquilo','ConduzirComOlhosVendados'");
        System.out.println("==============================================================");
        String dificuldadeDoJogo = in.nextLine();

        if (dificuldadeDoJogo.equals("Canja")) {
            return 2000;
        } else if (dificuldadeDoJogo.equals("ConduzirComOlhosVendados")){
            return 1500;
        } else {
            return 3000;
        }
    }

    /**
     * Criar tipo de corrida rapida
     */
    private static void corridasRapidas() {
        Momento momentoRapida = new Momento("Rapida", 1000, 30);
        Momento momentoRapida2 = new Momento("Turbo",120.4,300);
        Pista pistaRapida = new Pista("Rapida", 100, 120, 2000, 1, Arrays.asList(momentoRapida, momentoRapida2));
        pistas.add(pistaRapida);
    }


    /**
     * Criar tipo de corrida simuladorCorridas
     */
    private static void simuladorCorridas() {
        Momento momentoSimulador= new Momento("Simulador", 100, 300);
        Momento momentoSimulador2= new Momento("SimuladorChuva",149,240);
        Pista pistaSimulador = new Pista("Simulador", 80, 75, 1000, 3, Arrays.asList(momentoSimulador, momentoSimulador2));
        pistas.add(pistaSimulador);
    }

    /**
     * Criar tipo de corrida aventuraNaPista
     */
    private static void aventuraNaPista() {
        Momento momentoAventura= new Momento("Aventura", 100, 300);
        Momento momentoAventura2= new Momento("Jumanji",185,280);
        Pista pistaAventura = new Pista("Aventura", 80, 75, 3000, 3, Arrays.asList(momentoAventura, momentoAventura2));
        pistas.add(pistaAventura);
    }

    /**
     * Criar tipo de corrida derradeiraPista
     */
    private static void derradeiraPista() {
        Momento momentoDerradeiraPista = new Momento("Floresta",100,300);
        Momento momentoDerradeiraPista2 = new Momento("Savana",100,200);
        Momento momentoDerradeiraPista3 = new Momento("Pantano",89,280);
        Pista pistaNaFloresta = new Pista("Floresta",50,60,5000,5, Arrays.asList(momentoDerradeiraPista, momentoDerradeiraPista2, momentoDerradeiraPista3));
        pistas.add(pistaNaFloresta);
    }
}
