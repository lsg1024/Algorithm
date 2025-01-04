import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Node {
        int num;
        Node left;
        Node right;

        Node(int num) {
            this.num = num;
        }

        Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }
        public void insert(int n) {
            if (this.num > n) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root=new Node(Integer.parseInt(br.readLine()));
        
        String s;
        while (true) {
            s = br.readLine();

            if (s == null) {
                break;
            }

            root.insert(Integer.parseInt(s));
        }

        orderNode(root);

    }

    static void orderNode(Node node) {
        if (node == null) {
            return;
        }

        orderNode(node.left);
        orderNode(node.right);

        System.out.println(node.num);
    }
}