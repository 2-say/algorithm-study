import java.io.*;
import java.util.*;

class Main {

    static class Node {
        int root;    
        Node r;
        Node l;

        Node(int root, Node r, Node l) {
            this.root = root;
            this.r = r;
            this.l = l;
        }

        Node(int n) {
            this.root = n;
        }

        void insert(int n) {
            if(n < this.root) {
                if(this.l == null) this.l = new Node(n);
                else this.l.insert(n);
            } else {
                if(this.r == null) this.r = new Node(n);
                else this.r.insert(n);
            }
        }
    }

	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;

        while((input = br.readLine()) != null && !input.equals("")) {
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    static void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.l);
        postOrder(node.r);
        System.out.println(node.root);
    }
}


