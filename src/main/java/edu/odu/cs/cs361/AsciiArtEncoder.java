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
