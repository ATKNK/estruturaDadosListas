public class Fila {
    private Nodo head;
    private Nodo tail;

    public Nodo getHead(){
        return head;
    }

    public void criaFila(){
        head = null;
        tail = null;
    }

    public void enqueue(int valor){
        Nodo novo = new Nodo();
        novo.setValor(valor);
        if (head == null){
            head = novo;
            tail = novo;
        }
        else{
            tail.setProx(novo);
            tail = novo;
        }
        System.out.println("Elemento "+tail.getValor()+" enqueue com sucesso!");
    }

    public void dequeue(){
    //Atividade Digite a linha de código que falta aqui abaixo:
        head = head.getProx();
    /*Observação
    Não existe o método free() no java para liberar memória porque a JVM 
    tem o Garbage Collector! Limpa memória sozinho =)
    */

    }

    public void print(Nodo atual){
        if(atual == null)
            System.out.println("Null");
        else{
            if (atual==head) System.out.print("Head->"); 
            System.out.print(atual.getValor()+"->");
            print(atual.getProx());
        }
    }
}
