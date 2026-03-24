package wk9;

public class Driver {
    public static void main(String[] args) {
        {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>();
            bst.add(33);
            bst.add(12);
            bst.add(72);
            bst.add(8);
            bst.add(14);
            bst.traverse(e -> System.out.println(e));
        }
//        {
//            BinarySearchTree<String> bst = new BinarySearchTree<>();
//            bst.add("we");
//            bst.add("are");
//            bst.add("here");
//            bst.add("not");
//            bst.add("over");
//            bst.add("there");
//            System.out.println(bst);
//        }
//        {
//            BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//            bst.add(8);
//            bst.add(4);
//            bst.add(12);
//            bst.add(2);
//            bst.add(6);
//            bst.add(10);
//            bst.add(14);
//            System.out.println(bst.toString());
//        }
    }
}
