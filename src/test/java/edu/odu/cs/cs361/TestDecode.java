package edu.odu.cs.cs361;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;


public class TestDecode {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testUniform1x1() {
        TreeNode t = new TreeNode('a', 1, 1);
        AsciiArtDecoder dec = new AsciiArtDecoder(t);
        List<String> observed = dec.decodeTree();
        List<String> expected = List.of("a");

        assertThat(observed, is(expected));
    }

    @Test
    public void testUniform3x2() {
        TreeNode t = new TreeNode('a', 3, 2);
        AsciiArtDecoder dec = new AsciiArtDecoder(t);
        List<String> observed = dec.decodeTree();
        List<String> expected = List.of("aaa", "aaa");

        assertThat(observed, is(expected));
    }

    @Test
    public void testVaried2x2() {
        TreeNode ul = new TreeNode('a', 1, 1); 
        TreeNode ur = new TreeNode('a', 1, 1); 
        TreeNode ll = new TreeNode('a', 1, 1); 
        TreeNode lr = new TreeNode('.', 1, 1); 
        TreeNode t = new TreeNode((char)0, 2, 2);
        t.ul = ul;
        t.ur = ur;
        t.ll = ll;
        t.lr = lr;

        AsciiArtDecoder dec = new AsciiArtDecoder(t);
        List<String> observed = dec.decodeTree();
        List<String> expected = List.of("aa", "a.");

        assertThat(observed, is(expected));
    }

    @Test
    public void testVaried3x3() {
        TreeNode ul = new TreeNode('a', 1, 1); 
        TreeNode ur = new TreeNode('a', 2, 1); 
        TreeNode ll = new TreeNode('a', 1, 2); 
        TreeNode lr = new TreeNode('b', 2, 2); 
        TreeNode t = new TreeNode((char)0, 3, 3);
        t.ul = ul;
        t.ur = ur;
        t.ll = ll;
        t.lr = lr;

        AsciiArtDecoder dec = new AsciiArtDecoder(t);
        List<String> observed = dec.decodeTree();
        List<String> expected = List.of("aaa", "abb", "abb");

        assertThat(observed, is(expected));
    }


}
