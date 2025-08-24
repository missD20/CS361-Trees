package edu.odu.cs.cs361;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Encode {

    
    public static void main(String[] args) throws IOException {
        BufferedReader in;
        if (args.length > 0) {
            in = new BufferedReader(new FileReader(args[0]));
        } else {
            in = new BufferedReader(new InputStreamReader(System.in));
        }
        GraphicsTree t = readAndEncode(in);
        in.close();
        System.out.print(t.toString());
    }

    private static GraphicsTree readAndEncode(BufferedReader in) throws IOException {
        GraphicsTree t = new GraphicsTree();
        List<String> picture = readArt(in);
        t.encode(picture);
        return t;
    }

    private static List<String> readArt(BufferedReader in) throws IOException {
        String line = in.readLine();
        List<String> results = new ArrayList<>();
        while (line != null) {
            results.add(line);
            line = in.readLine();
        }
        return results;
    }

}
