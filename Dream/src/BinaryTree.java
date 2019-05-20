


import java.io.FileOutputStream;
import java.io.PrintWriter;

public class BinaryTree<E> {
    public User root;
    public int KEY;

    public BinaryTree(int KEY) {
        this.KEY = KEY;
    }

    public int getKEY() {
        return KEY;
    }
    
    public byte[] encrypt(byte[] NAME, int KEY) {
        byte[] enc = new byte[NAME.length];        
        for(int i = 0; i<NAME.length; i++){
            enc[i] = (byte)((i%2 == 0) ? NAME[i]+1: NAME[i]-1);            
        }
        return enc;
    }

    public byte[] decrypt(byte[] ENCRYPTED_NAME, int KEY) {
        byte[] enc = new byte[ENCRYPTED_NAME.length];
        for(int i = 0; i<ENCRYPTED_NAME.length; i++){
            enc[i] = (byte)((i%2 == 0) ? ENCRYPTED_NAME[i]-1: ENCRYPTED_NAME[i]+1);            
        }
        return enc;
    }

    public BinaryTree() {
        root = null;
    }
        
    public boolean isEmpty() {
        return root == null;
    }
    
    public int regFee (int e) {
        return e;
    }       
    
    //ADD NODE TO THE BINARY TREE
    public void insert(String name) {
                    try{
                        PrintWriter p = new PrintWriter(new FileOutputStream("user.txt", true));
                        p.println("\n\n" + name);
                        String enc = new String(encrypt(name.getBytes(), 127));
                        p.println("Encrypted name : " + enc + "\n");
                        p.println();
                        p.close();
                    }
                    catch (Exception e) {
                        System.out.println("File not found");
                    }
//        if (isEmpty()) {
//            root = new User(name);
//        }
//        else {
//            root.add(name);
//        }
//        System.out.println("Added!");
    }
    
    public User getRoot() {
        return root;
    }
    
//    public E search (String name, Node node) {
//        if (root != null) {
//            if (root.name.equalsIgnoreCase(name)) {
//                System.out.println("here");
//            }
//            else {
//                Node foundNode = (Node) search(name, node.left);
//                if (foundNode == null) {
//                    foundNode = (Node) search(name, node.right);
//                }
//                return (E) foundNode;
//            }
//        }
//        else {
//            return null;
//        }
//        return null;
//    }
    
    public String search (String name) {
//        while (root.name.equalsIgnoreCase(name)) {
//        while (root.equals(name)) {
            if (root.left != null && root.left.equals(name)) {
                root = root.left;
                System.out.println(root);
            }
            else if (root.right != null && root.right.equals(name)) {
                root = root.left;
                System.out.println(root);
            }
            else if (root.equals(name)) {
                System.out.println(root);
            }
            else {
                return null;
            }
        return null;
    }
    
    public boolean isFound (String name) {
        boolean found = true;
        while (root.name.equalsIgnoreCase(name)) {
            if (root.left != null) {
                root = root.left;
            }
            if (root.right != null) {
                root = root.right;
            }
            else {
                root = null;
            }
        }
        return found;
    }
    
    public void preOrder() {
        preOrder(root);
    }
    
    public void preOrder(User root) {
        if (root != null) {
            System.out.println(root.getString());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
    
    
}
