package bo.edu.ucb.est;

import java.util.Stack;

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



        /**
     * 1. Crear un Stack vacio S.
     * 2. Inicializar el nodo current como root.
     * 3. Insertar el nodo current a S y asignar current = current.getLeft(), hasta que el actual sea NULL.
     * 4. Si current es NULL y S no esta vacio, entonces:
     *      4.1) Hacemos pop de S.
     *      4.2) Imprimos el elemento que hicimos pop y asignamos current = pop_node.getRight();
     *      4.3) Ir al paso 3.
     * 5. Si current es NULL, y S esta vacio entocnes hemos terminado.
     * @param root nodo a partir del cual ser comienza a realizar in order recursiva
     */
    public static void printInOrderNonRecursive(Node<?> root) {
        Stack<Node<?>> S = new Stack<>();
        Node<?> current = root;
        
        while(current!=null){
            S.push(current);
            current = current.getLeft();
        } 
        while (!S.isEmpty()){
            current=S.pop();
            System.out.print(current.getData()+"->");
            if(current.getRight()!=null){
                current = current.getRight();
                while(current!=null){
                    S.push(current);
                    current = current.getLeft();
                }
            }
        }
        

    }

    /**
     * 1. El nodo que se va a eliminar no tiene hijo, es una hoja.
     * Este es el caso más simple; dado que un nodo hoja no tiene hijos, no necesitamos preocuparnos por nada. Podemos reemplazar el nodo hoja con NULL y liberar el espacio asignado a este nodo.
     *
     * 2. El nodo que se va a eliminar tiene un solo hijo (hijo izquierdo o derecho).
     * En este caso, almacenamos el hijo del nodo y eliminamos el nodo de su posición original. Luego, el nodo hijo se inserta en la posición original del nodo eliminado.
     *
     * 3. El nodo que se va a eliminar tiene hijos, hijo izquierdo y derecho.
     * Este es el caso más complicado porque aquí, no podemos simplemente eliminar o reemplazar el nodo con su hijo. En este caso, encontramos el nodo más pequeño en el subárbol derecho del nodo minnode. Reemplace el valor del nodo que se eliminará con el valor de minnode y llame de forma recursiva a delete en este nodo.
     * @param data
     */
    public void remove(D data) {
        Node<D> nodoAEliminar = obtenerNodo(data);
        Node<D> nodoAnterior = obtenerPadre(data);
     
        if(nodoAEliminar.getRight()== null && nodoAEliminar.getLeft()== null){ //caso 1. El nodo a eliminar es una hoja
            if(nodoAnterior.getLeft()==nodoAEliminar){
                nodoAnterior.setLeft(null);
            }else{
                nodoAnterior.setRight(null);
            }
        }else{//caso 3. El nodo a eliminar tiene dos hijos
            if(nodoAEliminar.getRight()!=null && nodoAEliminar.getLeft()!=null){
                Node<D> minNode = obtenerMinNode(nodoAEliminar);
                remove(minNode.getData());
                nodoAEliminar.setData(minNode.getData());
            }else{//caso 2. Cuando tiene solo un hijo
                Node<D> hijo = obtenerUnicoHijo(nodoAEliminar);
                if(nodoAnterior.getLeft()==nodoAEliminar){ // Inge por alguna razon que no entiendo cuando uso el metodo .equals en esta parte me sale nullPointerException
                    nodoAnterior.setLeft(hijo);
                }else{
                    nodoAnterior.setRight(hijo);
                }
            }
        }
    }

    public Node<D> obtenerUnicoHijo(Node<D> nodo){
        Node<D> hijo = null;
        if(nodo.getLeft()!=null){
            hijo = nodo.getLeft();
        }else{
            hijo = nodo.getRight();
        }
        return hijo;
    }

    public Node<D> obtenerMinNode(Node<D> nodoAEliminar){
        Node<D> minNode= null;
        for( Node<D> current=nodoAEliminar.getRight(); current!=null ;){
            minNode = current;
            current = current.getLeft();
        }
        return minNode;
    }

    public Node<D> obtenerNodo(D data){
        Node<D> NodoAObtener = null;
        for( Node<D> current=root; current!=null ;){ //recorrido
            if(current.getData().compareTo(data)>0){
                current = current.getLeft();
            } else if(current.getData().compareTo(data)<0){
                current = current.getRight();
            } else{
                NodoAObtener = current;
                break;
            }
        }
        return NodoAObtener;
    }


    public Node<D> obtenerPadre(D data){
        Node<D> padre = null;
        for( Node<D> current=root; current!=null ;){ //recorrido
            if(current.getData().compareTo(data)>0){
                padre = current;
                current = current.getLeft();
            } else if(current.getData().compareTo(data)<0){
                padre = current;
                current = current.getRight();
            } else{
                break;
            }
        }
        return  padre;
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

    public static void printPreOrder(Node<?> root){
        System.out.println(root.getData());
        if( root.getLeft()!=null){
            printPreOrder(root.getLeft());
        }
        if( root.getRight()!=null){
            printPreOrder(root.getRight());
        }
    }

    public static void printPostOrder(Node<?> root){
        if( root.getLeft() != null){
            printPostOrder(root.getLeft());
        }
        if( root.getRight() != null){
            printPostOrder(root.getRight());
        }
        System.out.println(root.getData());
        
    }

    //Practicando

    public void add2(D data){
        Node<D> newNode = new Node<>(data);
        if ( root == null) { // arbol vacio
            root = newNode;
        }else{
            addDataToNode(root,newNode);
        }
    }

    public void addDataToNode(Node<D> current, Node<D> newNode){
        if (current.getData().compareTo(newNode.getData()) > 0){
            if (current.getLeft()==null){
                current.setLeft(newNode);
            }else{
                addDataToNode(current.getLeft(), newNode);
            }
        }else if (current.getData().compareTo(newNode.getData()) < 0){
            if (current.getRight()==null){
                current.setRight(newNode);
            }else{
                addDataToNode(current.getRight(), newNode);
            }
        }
        

    }
}
