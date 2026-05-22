
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int menu = -1;
        Scanner scan = new Scanner(System.in);

        while (menu != 0) {
            System.out.println("""
                    1) Criar Fila
                    2) Criar Pilha
                    3) Lista Encadeada
                    0) Sair
                    """);
            menu = scan.nextInt();

            switch (menu) {
                case 1 -> fila();
                case 2 -> pilha();
                case 3 -> listaMenu();
                case 0 -> System.out.println("Saindo");
            }
        }
    }

    public static void fila() {
        System.out.println("*Fila*  enqueue(x) e dequeue()");
        Fila minhafila = new Fila();
        minhafila.criaFila(); // head e tail são zerados
        minhafila.enqueue(3); // insere o valor 3 na fila
        minhafila.enqueue(4); // insere o valor 4 na fila
        minhafila.enqueue(5); // insere o valor 5 na fila
        minhafila.enqueue(8); // insere o valor 8 na fila;
        minhafila.print(minhafila.getHead());
        minhafila.dequeue();
        minhafila.print(minhafila.getHead());
    }

    public static void pilha() {
        System.out.println("*Pilha*");
        Pilha minhaPilha = new Pilha();
        minhaPilha.criaPilha();
        minhaPilha.push(23);
        minhaPilha.push(20);
        minhaPilha.push(12);
        minhaPilha.pop(); // tira 12
        minhaPilha.pop(); // tira 20
        minhaPilha.pop(); // tira 23
        minhaPilha.pop(); // teste
        minhaPilha.print();
    }

    public static void listaSimples() {
        System.out.println("*Lista Encadeada*");
        listaMenu();
    }

    public static void listaMenu() {
        Scanner scan = new Scanner(System.in);
        Lista objLista = new Lista();
        objLista.criaLista();

        int opc = -1;
        while (opc != 0) {
            System.out.println("""
                    --- Menu Lista ---
                    1) Criar lista
                    2) Adicionar Valor no início
                    3) Buscar nodo por valor
                    4) Buscar anterior de um valor
                    5) Remover valor
                    6) Imprimir lista
                    0) Voltar
                    """);
            opc = scan.nextInt();

            switch (opc) {
                case 1 -> {
                    objLista.criaLista();
                    System.out.println("Lista criada.");
                }

                case 2 -> {
                    System.out.print("Valor para inserir no início: ");
                    int v = scan.nextInt();
                    objLista.addInicio(v);
                    System.out.println("Inserido: " + v);
                }

                case 3 -> {
                    System.out.print("Valor a buscar: ");
                    int v = scan.nextInt();
                    Nodo encontrado = objLista.getNodoPorValor(v);
                    if (encontrado == null) {
                        System.out.println("Nodo não encontrado.");
                    } else {
                        System.out.println("Nodo encontrado com valor: " + encontrado.getValor() + " - hash: "
                                + encontrado.hashCode() + "\n");
                    }
                }

                case 4 -> {
                    System.out.print("Valor cujo anterior deseja ver: ");
                    int v = scan.nextInt();
                    Nodo anterior = objLista.getAnterior(v);
                    if (anterior == null) {
                        System.out.println("Anterior não encontrado (ou é o primeiro).");
                    } else {
                        System.out.println("Anterior possui valor: " + anterior.getValor());
                    }
                }

                case 5 -> {
                    System.out.print("Valor a remover: ");
                    int v = scan.nextInt();
                    boolean ok = objLista.remover(v);
                    System.out.println(ok ? "Remoção bem-sucedida." : "Remoção falhou ou valor não existe.");
                }

                case 6 -> objLista.print();

                case 0 -> System.out.println("Voltando ao menu principal...");

                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
