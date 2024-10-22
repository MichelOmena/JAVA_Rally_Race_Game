import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Definição da classe Oficina
public class Oficina {
    // Atributos da classe Oficina

    private ArrayList<Veiculo> garagem;     // Veículos disponíveis na oficina (carros ou motas)
    private ArrayList<ItemCorrida> stock;   // Itens disponíveis na oficina (modificações ou habilidades)

    // No meu array list esta onde esta o local onde vou guardar devo percorrer
    // Todo o array list usando um foreach para cada metodo que temos no caso 4.
    // Itens disponíveis na oficina (modificações ou habilidades)


    /**
     * Método Construtor da classe Oficina
     */
    public Oficina() {
        this.garagem = new ArrayList<>();
        this.stock = new ArrayList<>();
    }

    /**
     * Métodos para Adicionar os Veiculos na Oficina ao ArrayList<Veiculo>
     */
    public void adicionarVeiculo(Veiculo veiculo) {
        this.garagem.add(veiculo);
    }

    // Método para Adicionar itens na Oficina ao ArrayList<Veiculo>
    public void adicionarItem(ItemCorrida itemCorrida) {
        this.stock.add(itemCorrida);
    }

    /**
     * Métodos de acesso
     */
    public ArrayList<Veiculo> getGaragem() {
        return garagem;
    }

    public void setGaragem(ArrayList<Veiculo> garagem) {
        this.garagem = garagem;
    }

    public ArrayList<ItemCorrida> getStock() {
        return stock;
    }

    public void setStock(ArrayList<ItemCorrida> stock) {
        this.stock = stock;
    }

    /**
     * Método imprimir o Stock
     */
    public void imprimirStock() {
        System.out.println("==================FAST AND FURIOUS=================== ");
        System.out.println("=======================STOCK========================= ");
        System.out.println("\t\t\t\t\t\t\t\t\tItens do seu stock\t\t\t\t\t\t\t\t\t");
        System.out.println("======================================================");

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(stock.size());
            ItemCorrida item = stock.get(index);

            if (item instanceof Modificacao) {
                item.mostrarDetalhesItem();
            } else if (item instanceof Habilidade) {
                item.mostrarDetalhesItem();
            }
        }
    }

    /**
     *
     */
    public void imprimirGaragem() {  //imprimirGaragem é nome da variavel que acessa o array.
        System.out.println("==================FAST AND FURIOUS=================== ");
        System.out.println("==================GARAGEM=================== ");
        System.out.println("\t\t\t\t\t Veiculos na garagem disponiveis\t\t\t\t");
        System.out.println("===================================================== ");

        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            int index = random.nextInt(garagem.size());
            Veiculo veiculo = garagem.get(index);
            veiculo.mostrarDetalhes();
        }
    }

    /**
     //Ciclo foreach
     for (Veiculo veiculo : garagem){
     veiculo.mostrarDetalhes();
     }**/

    /**
     *
     * @param piloto
     */
    public void venderItem(Piloto piloto) {
        // Verifica se o piloto tem "fichas" para comprar o item
        if (piloto.getVeiculoAtual() != null) {
            int index = 0;
            for (ItemCorrida item : stock) {
                    System.out.println(index);
                    item.mostrarDetalhesItem();
                    index++;
            }

            Scanner in = new Scanner(System.in);
            System.out.println("Escolhe o item da lista");
            int itemEscolhido = in.nextInt();

            if (piloto.getFichasCorrida() >= stock.get(itemEscolhido).getPrecoEmFichas()) {
                piloto.setFichasCorrida(piloto.getFichasCorrida() - stock.get(itemEscolhido).getPrecoEmFichas()); //Atualiza o saldo
                if (piloto.getVeiculoAtual() instanceof Carro) {
                    ((Carro) piloto.getVeiculoAtual()).addModificacoes((Modificacao) stock.get(itemEscolhido));

                } else {
                    ((Mota) piloto.getVeiculoAtual()).addHabilidade((Habilidade) stock.get(itemEscolhido));

                }

                System.out.println("=========================FAST AND FURIOUS=====================");
                System.out.println("\t\t\t\t\t\t\t\t\t Compra realizada com sucesso\t\t\t\t\t\t\t");
                System.out.println("==============================================================");
            } else {
                System.out.println("Infelizmente você não tem fichas o suficiente");
            }
        }
    }


    /**
     * Dá opções de veiculos disponiveis e permite comprar veiculo novo
     * @param piloto {@link Piloto} que pretende comprar veiculo novo
     */
    public void venderVeiculo(Piloto piloto){
        // Verifica se o piloto tem "fichas" para comprar o item
        int index = 0;
        int carrosDisponiveis = 0;
        for(Veiculo veiculo: garagem) {
            if (piloto.getFichasCorrida() >= veiculo.getPrecoEmFichas()) {
                System.out.println("Numero do veiculo a escolher: " + index);
                veiculo.mostrarDetalhes();
                carrosDisponiveis++;
                index++;
            }
        }

        if(carrosDisponiveis == 0) {
            System.out.println("Não tem fichas suficientes para comprar veiculo novo: " + piloto.getFichasCorrida());

        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("Escolhe o veiculo da lista");
            int veiculoEscolhido = in.nextInt();

            piloto.setFichasCorrida(piloto.getFichasCorrida() - garagem.get(veiculoEscolhido).getPrecoEmFichas()); //Atualiza o saldo
            piloto.setVeiculoAtual(garagem.get(veiculoEscolhido));

            System.out.println("=========================FAST AND FURIOUS=====================");
            System.out.println("\t\t\t\t\t\t\t\t\t Compra realizada com sucesso\t\t\t\t\t\t\t");
            System.out.println("==============================================================");
        }
    }
}

