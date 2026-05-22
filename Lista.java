public class Lista {
    private Nodo prim;

    public void criaLista() {
        prim = null;
    }

    public void addInicio(int valor) {
        Nodo novo = new Nodo();
        novo.setValor(valor);
        novo.setProx(prim);
        prim = novo;
    }

    public Nodo getNodoPorValor(int valor) {
        for (Nodo n = prim; n != null; n = n.getProx()) {
            if (n.getValor() == valor) {
                return n;
            }
        }
        return null;
    }

    public Nodo getAnterior(int valor) {
        if (prim == null) {
            return null;
        }

        for (Nodo n = prim; n.getProx() != null; n = n.getProx()) {
            if (n.getProx().getValor() == valor) {
                return n;
            }
        }
        return null;
    }

    public boolean remover(int valor) {

        if (prim == null) {
            return false;
        }

        if (prim.getValor() == valor) {
            prim = prim.getProx();
            return true;
        }

        Nodo anterior = getAnterior(valor);

        if (anterior == null) {
            return false;
        }

        anterior.setProx(
                anterior.getProx().getProx());

        return true;
    }

    public void print() {
        for (Nodo n = prim; n != null; n = n.getProx()) {
            System.out.print(" [" + n.getValor() + "]");
        }
        System.out.println();
    }
}
