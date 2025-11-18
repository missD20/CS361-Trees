package edu.odu.cs.cs361;

import java.util.ArrayList;
import java.util.List;

public class AsciiArtDecoder {

    private TreeNode root;
    
    public AsciiArtDecoder(TreeNode root) {
        this.root = root;
    }

    public List<String> decodeTree() {
        List<String> results = new ArrayList<>();
        /*** Your code here  */
        // Create the grid (2D char array) for the entire image
        int totalWidth = root.width;
        int totalHeight = root.height;
        char[][] grid = new char[totalHeight][totalWidth];

        // Launch the recursive decoding function starting from (0, 0)
        decodeHelp(root, grid, 0, 0);

        // 3. Convert the 2D grid into a List<String> for the result
        for (int y = 0; y < totalHeight; y++) {
            results.add(new String(grid[y]));
        }
        return results;
    }

    private void decodeHelp(TreeNode t, char[][] grid, int x0, int y0) {
        if (t == null) {
            return;
        }

        // Base case: Leaf (uniform region)
        if (t.isLeaf()) {
            // Fill the entire area with the node character
            for (int y = y0; y < y0 + t.height; y++) {
                for (int x = x0; x < x0 + t.width; x++) {
                    grid[y][x] = t.c;
                }
            }
            return;
        }

        // Recursive Case: Internal Node (we calculate the coordinates of the children)

        int w = t.width;
        int h = t.height;

        // Calculation of quadrant dimensions (must comply with the encoding rule)
        int w_left = w / 2;
        int w_right = w - w_left;
        int h_up = h / 2;
        int h_down = h - h_up;

        // 1. Upper Left
        decodeHelp(t.ul, grid, x0, y0);

        // 2. Upper Right
        decodeHelp(t.ur, grid, x0 + w_left, y0);

        // 3. Lower Left
        decodeHelp(t.ll, grid, x0, y0 + h_up);

        // 4. Lower Right
        decodeHelp(t.lr, grid, x0 + w_left, y0 + h_up);
    }

}
