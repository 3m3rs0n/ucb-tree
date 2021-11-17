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
        tree.add2(15);
        tree.add2(9);
        tree.add2(16);
        tree.add2(2);
        tree.add2(1);
        tree.add2(5);
        tree.add2(12);
        tree.add2(11);
        tree.add2(14);
        tree.add2(16);
        tree.add2(20);
        tree.add2(19);
        tree.add2(22);

        System.out.println("========InOrder=========");
        Tree.printInOrderNonRecursive(tree.getRoot());
        System.out.println("FIN");

        tree.remove(9);

        System.out.println("========InOrder=========");
        Tree.printInOrderNonRecursive(tree.getRoot());
        System.out.println("FIN");

        System.out.println("======PreOrder=========");
        Tree.printPreOrder(tree.getRoot());
        System.out.println("FIN");
        System.out.println("======PostOrder=========");
        Tree.printPostOrder(tree.getRoot());
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
