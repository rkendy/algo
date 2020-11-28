package misc;

/**
 * BST Successor Search
 * 
 * In a Binary Search Tree (BST), an Inorder Successor of a node is defined as
 * the node with the smallest key grater than the key of the input node. Given a
 * node inputNode in a BST, you'are asked to write a function
 * findInOrderSuccessor that returns the Inorder Successor of inputNode. If
 * inputNot has no Inorder Successor, return null.
 * 
 * Explain your solution and analyze its time and space complexities.
 */
public class InorderSuccessor {

    static class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        Node findInOrderSuccessor(Node inputNode) {
            return null;
        }

        void insert(int key) {
            if (this.root == null) {
                this.root = new Node(key);
                return;
            }

            Node currentNode = this.root;
            Node newNode = new Node(key);

            while (currentNode != null) {
                if (key < currentNode.key) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }

        Node getNodeByKey(int key) {
            Node currentNode = this.root;

            while (currentNode != null) {
                if (key == currentNode.key) {
                    return currentNode;
                }
                if (key < currentNode.key) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }

            return null;
        }
    }

    public static void main(String[] args) {
        Node test = null, succ = null;

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(9);
        tree.insert(25);
        tree.insert(5);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);

        test = tree.getNodeByKey(9);

        succ = tree.findInOrderSuccessor(test);

        if (succ != null) {
            System.out.println("Inorder successor of " + test.key + " is " + succ.key);
        } else {
            System.out.println("Inorder successor does not exist");
        }

    }

}
