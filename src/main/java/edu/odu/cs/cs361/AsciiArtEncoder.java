package edu.odu.cs.cs361;

import java.util.List;

public class AsciiArtEncoder {

    private List<String> inputs;
    private int width;
    private int height;

    public AsciiArtEncoder(List<String> in) {
        inputs = in;
        height = in.size();
        width = in.get(0).length();
    }

    public TreeNode generateTree() {
        /*** Your code here  */
        // Begin by encoding the entire region (0, 0) to the maximum width/height.
        return encodeHelp(0, 0, width, height);
    }

    private TreeNode encodeHelp(int x0, int y0, int w, int h) {
        // Basic case: If the region is uniform
        if (uniformContents(x0, y0, w, h)) {
            char c = inputs.get(y0).charAt(x0);
            return new TreeNode(c, w, h);
        }

        // Recursive case: the region is not uniform

        // Calculation of quadrant dimensions (asymmetric division)
        int w_left = w / 2;
        int w_right = w - w_left;
        int h_top = h / 2;
        int h_bottom = h - h_top;

        // Creation of the internal node (character (char)0 or '--')
        TreeNode parent = new TreeNode((char)0, w, h);

        //Recursive calls for the four quadrants

        // Upper Left
        parent.ul = encodeHelp(x0, y0, w_left, h_top);

        // Upper Right
        parent.ur = encodeHelp(x0 + w_left, y0, w_right, h_top);

        // Lower Left
        parent.ll = encodeHelp(x0, y0 + h_top, w_left, h_bottom);

        // Lower Right
        parent.lr = encodeHelp(x0 + w_left, y0 + h_top, w_right, h_bottom);

        return parent;
    }


    private boolean uniformContents(int x0, int y0, int w, int h) {
        char c = inputs.get(y0).charAt(x0);
        for (int x = x0; x < x0 + w; ++x)
            for (int y = y0; y < y0 + h; ++y) {
                char c0 = inputs.get(y).charAt(x);
                if (c != c0)
                    return false;
            }
        return true;
    }

}
