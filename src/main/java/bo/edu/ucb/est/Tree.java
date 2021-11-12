package bo.edu.ucb.est;

public class Tree<D extends Comparable<D>> {
    private Node<D> root;

    public Tree() {
    }

    public Node<D> getRoot() {
        return root;
    }

    public void setRoot(Node<D> root) {
        this.root = root;
    }

    public void add(D data) {
        Node<D> newNode = new Node<>(data);
        if ( root == null) { // arbol vacio
            root = newNode;
        } else {
            Node<D> current = root;
            while(current != null ) {
                if (current.getData().compareTo(data) > 0) {
                    if (current.getLeft() == null) { // Tengo el espacio vacio para agregar el nodo
                        current.setLeft(newNode);
                        break; // Terminamos el recorrido
                    } else { // continuo bajando por la rama izquierda
                        current = current.getLeft();
                    }
                } else if (current.getData().compareTo(data) < 0) {
                    if (current.getRight() == null) { // Tengo el espacio vacio para agregar el nodo
                        current.setRight(newNode);
                        break; // Terminamos el recorrido
                    } else { // continuo bajando por la rama derecha
                        current = current.getRight();
                    }
                } else { // igual a cero
                    // Entonces el elemento ya existe.
                    throw new RuntimeException("No se puede agregar elementos duplicados a un ABB");
                }

            }
        }
    }

    //        Hasta que todos los nodos hayan sido atravesados −
//        Paso 1 − Recorre recursivamente el subarbol izquierdo.
//                Paso 2 − Visitamos el nodo raíz.
//        Paso 3 − Recorre recursivamente el subarbol derecho.

    public static void printInOrder(Node<?> root) {
        if( root.getLeft() != null){ //        Paso 1 − Recorre recursivamente el subarbol izquierdo.
            printInOrder(root.getLeft());
            System.out.println(root.getData());
        }else{
            System.out.println(root.getData());//                Paso 2 − Visitamos el nodo raíz.
        }
        if( root.getRight() != null){
            printInOrder(root.getRight());//        Paso 3 − Recorre recursivamente el subarbol derecho.
        }
    }

    //Practicando

    public void add2(D data){
        Node<D> newNode = new Node<>(data);
        if ( root == null) { // arbol vacio
            root = newNode;
        }else{
            for( Node<D> current=root; current!=null;){
                if(current.getData().compareTo(data)>0){
                    if(current.getLeft()==null){
                        current.setLeft(newNode);
                        break;
                    }else{
                        current = current.getLeft();
                    }
                }else if(current.getData().compareTo(data) < 0){
                    if(current.getRight()==null){
                        current.setRight(newNode);
                        break;
                    }else{
                        current = current.getRight();
                    }
                }else{
                    break;
                }
            }
        }
    }
}
