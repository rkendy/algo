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

        Node getLeftMost(Node node) {
            Node currentNode = node;
            while (currentNode.left != null)
                currentNode = currentNode.left;
            return currentNode;
        }

        /**
         * Simplest solution: using value.
         */
        Node getClosestParent(Node node, Node inputNode) {
            Node currentNode = node;
            while (currentNode != null) {
                if (currentNode.key > inputNode.key)
                    return currentNode;
                currentNode = currentNode.parent;
            }
            return null;
        }

        /**
         * Using parent and the fact that if coming from left, parent is higher.
         */
        Node getClosestParent2(Node node, Node inputNode) {
            while (node != null && node.right == inputNode) {
                inputNode = node;
                node = node.parent;
            }
            return node;
        }

        /**
         * Recursive solution.
         */
        Node findInOrderSuccessorRecursive(Node node, int key) {
            if (node == null)
                return null;
            if (node.key == key) {
                if (node.right != null)
                    return getLeftMost(node.right);
                else
                    return null;
            } else {
                Node currentNode = findInOrderSuccessorRecursive(key > node.key ? node.right : node.left, key);
                if (currentNode == null) {
                    if (node.key > key) {
                        return node;
                    } else
                        return null;
                } else
                    return currentNode;
            }
        }

        Node findInOrderSuccessorRecursive(int key) {
            return findInOrderSuccessorRecursive(root, key);
        }

        Node findInOrderSuccessor(Node inputNode) {
            if (inputNode == null)
                return null;

            return inputNode.right != null ? getLeftMost(inputNode.right)
                    : getClosestParent2(inputNode.parent, inputNode);
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

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(9);
        tree.insert(25);
        tree.insert(5);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);

        test(tree, 9);
        test(tree, 12);
        test(tree, 14);
        test(tree, 11);
        test(tree, 5);
        test(tree, 25);
        test(tree, 20);

        System.out.println("============== recursive ================");
        testeRecursive(tree, 9);
        testeRecursive(tree, 12);
        testeRecursive(tree, 14);
        testeRecursive(tree, 11);
        testeRecursive(tree, 5);
        testeRecursive(tree, 25);
        testeRecursive(tree, 20);

    }

    private static void testeRecursive(BinarySearchTree tree, int key) {
        Node result = tree.findInOrderSuccessorRecursive(key);
        print(result, key);
    }

    private static void print(Node result, int key) {
        if (result != null) {
            System.out.println("Inorder successor of " + key + " is " + result.key);
        } else {
            System.out.println("Inorder successor of " + key + " does not exist");
        }
    }

    private static void test(BinarySearchTree tree, int key) {
        Node test = null, succ = null;
        test = tree.getNodeByKey(key);
        succ = tree.findInOrderSuccessor(test);
        print(succ, test.key);
    }

}
