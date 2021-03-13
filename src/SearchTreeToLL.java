import java.util.ArrayList;
import java.util.List;

public class SearchTreeToLL {

    // initial binary tree class
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }


    // initial method to flatten the tree and convert to doubly linked list and return the first node.
    public static BinaryTree flattenBinaryTree(BinaryTree root) {

        // creates an array or in order nodes.
        List<BinaryTree> nodesInOrder = orderNodes(root, new ArrayList<BinaryTree>());

        // loop through the in order nodes
        for (int i = 0; i < nodesInOrder.size() - 1; i++){
            BinaryTree leftNode = nodesInOrder.get(i);
            BinaryTree rightNode = nodesInOrder.get(i + 1);
            // at each node leftNode.right is the right, rightNode.left is the left
            leftNode.right = rightNode;
            rightNode.left = leftNode;

        }
        // return the first node
        return nodesInOrder.get(0);
    }


    // helper function that preforms an inorder traversal and returns it in an array.
    public static List<BinaryTree> orderNodes (BinaryTree tree, List<BinaryTree> array){

        if (tree != null){
            orderNodes(tree.left, array);
            array.add(tree);
            orderNodes(tree.right, array);
        }

        return array;
    }


}
