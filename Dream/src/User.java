


public class User  {
//    private java.util.LinkedList list = new java.util.LinkedList<>();
    
    public String name;
    User left;
    User right;
    public int freq = 1;

    public User(String name) {
        name = name;
        left = null;
        right = null;
    }
    
    public void add(String name) {
        if (left == null) {
            left = new User(name);
        }
        else if (right == null) {
            right = new User(name);
        }
        else {
            if (countNodes(left) <= countNodes(right)) {
                left.add(name);
            }
            else {
                right.add(name);
            }
        }
    }
    
    public static int countNodes(User root) {
        if (root == null) {
            return 0;
        }
        else {
            int count = 1;
            count = count + countNodes(root.left);
            count = count + countNodes(root.right);
            return count;
        }
    }
    
    public User getLeft() {
        return left;
    }
    
    public User getRight() {
        return right;
    }
    
   
    public Object getString() {
        return name;
    } 
    
    public void upFreq() {
        freq++;
    }
    
    public int getFreq(){
        return freq++;
    }
    
    
}
