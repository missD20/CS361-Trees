package edu.odu.cs.cs361;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

// Binary Search Tree implementation
public class GraphicsTree {

    private TreeNode root;

    // constructor
    GraphicsTree() {
        root = null;
    }

    public void read (BufferedReader in) throws IOException {
        root = readHelp(in);
    }

    private TreeNode readHelp(BufferedReader in) throws IOException {
        String line = in.readLine();
        String[] parts = line.split(" +");
        if (parts[0].equals("--")) {
            // Nonleaf node
            TreeNode t = new TreeNode((char)0, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            t.ul = readHelp(in);
            t.ur = readHelp(in);
            t.ll = readHelp(in);
            t.lr = readHelp(in);
            return t;
        } else {
            // leaf node
            char c = ' ';
            if (parts[0].length() > 0) {
                c = parts[0].charAt(0);
            }
            int w = Integer.parseInt(parts[1]);
            int h = Integer.parseInt(parts[2]);

            TreeNode t = new TreeNode(c, w, h);
            return t;
        }
    }

    public void encode (List<String> in) {
        padStrings(in);
        root = new AsciiArtEncoder(in).generateTree();
    }

    /**
     * Make sure that all strings in the list are of equal width by padding
     * with extra blanks as necessary.
     * @param in a list of strings
     */
    private void padStrings(List<String> in) {
        int maxWidth = -1;
        for (String line: in) {
            maxWidth = Math.max(maxWidth, line.length());
        }
        for (ListIterator<String> it = in.listIterator(); it.hasNext(); ) {
            String line = it.next();
            if (line.length() < maxWidth) {
                line = line + " ".repeat(maxWidth - line.length());
                it.set(line);
            }
        }
    }

    public List<String> decode() {
        return new AsciiArtDecoder(root).decodeTree();
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        printHelp(root, buffer);
        return buffer.toString();
    }

    private void printHelp(TreeNode t, StringBuffer buffer) {
        if (t != null) {
            if (t.isLeaf()) {
                buffer.append(t.c);
                buffer.append(' ');
                buffer.append(t.width);
                buffer.append(' ');
                buffer.append(t.height);
                buffer.append("\n");
            } else {
                buffer.append("-- ");
                buffer.append(t.width);
                buffer.append(' ');
                buffer.append(t.height);
                buffer.append("\n");
                printHelp(t.ul, buffer);
                printHelp(t.ur, buffer);
                printHelp(t.ll, buffer);
                printHelp(t.lr, buffer);
            }
        }
    }


}