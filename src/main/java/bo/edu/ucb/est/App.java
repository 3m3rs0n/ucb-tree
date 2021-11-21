package bo.edu.ucb.est;

import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  {
        Tree<Integer> tree = new Tree<Integer>();
        tree.add2(50);
        tree.add2(20);
        tree.add2(40);
        tree.add2(35);
        tree.add2(70);
        tree.add2(80);
        tree.add2(60);
        tree.add2(90);


        System.out.println("========InOrder=========");
        Tree.printInOrderNonRecursive(tree.getRoot());
        System.out.println("FIN");

        tree.remove(40);

        System.out.println("========InOrder=========");
        Tree.printInOrderNonRecursive(tree.getRoot());
        System.out.println("FIN");

        Stack<String> stringStack = new Stack<>();
        stringStack.push("Alfa");
        stringStack.push("Beta");
        stringStack.push("Bravo");
        stringStack.push("Gama");

        System.out.println("Contenido de la pila:" + stringStack);
        System.out.println("Primer pop:" + stringStack.pop());
        System.out.println("Segundo pop:" + stringStack.pop());
        System.out.println("Primer peek:" + stringStack.peek());
        System.out.println("Primer peek:" + stringStack.peek());


    }
}
