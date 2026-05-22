public class Pilha {
    private Nodo top;

    public void criaPilha(){
        top = null;
    }

    public void push(int valor){
        Nodo novo = new Nodo();
        novo.setValor(valor);
        novo.setProx(top);
        top = novo;
    }

    public void pop(){
        if (top != null)
            top = top.getProx();
        else System.out.println("Pilha vazia!");
    }

    public void print(){
        for (Nodo n = top; n != null; n = n.getProx()){
            System.out.println(n.getValor());
        }
    }

    /*Observação
    Não existe o método free() no java para liberar memória porque a JVM 
    tem o Garbage Collector! Limpa memória sozinho =)
    */
}
