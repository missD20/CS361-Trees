package edu.odu.cs.cs361;


// Tree Nodes for graphics compression.
public class TreeNode {

    public char c;  // < ' ' for internal nodes, printable for leaves
    public int width;  // dimensions of area described by this node
    public int height; 
    TreeNode ul; // upper-left region
    TreeNode ur; // upper-right region
    TreeNode ll; // lower-left region
    TreeNode lr; // lower-right region

    public TreeNode (char c, int width, int height) {
        this.c = c;
        this.width = width;
        this.height = height;
        ul = ur = ll = lr = null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TreeNode) {
            TreeNode t = (TreeNode)obj;
            return c == t.c && width == t.width  && height == t.height;
        } else 
            return false;
    }

    public boolean isLeaf() {
        return c >= ' ';
    }
}
