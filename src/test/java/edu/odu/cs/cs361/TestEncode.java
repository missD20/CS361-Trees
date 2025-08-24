package edu.odu.cs.cs361;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;


public class TestEncode {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testUniform1x1() {
        AsciiArtEncoder enc = new AsciiArtEncoder(List.of("a"));
        TreeNode t = enc.generateTree();
        assertThat(t, not(is((TreeNode)null)));
        assertThat(t.isLeaf(), is(true));
        assertThat(t.c, is('a'));
        assertThat(t.width, is(1));
        assertThat(t.height, is(1));
        assertThat(t.ul, is((TreeNode)null));
        assertThat(t.ur, is((TreeNode)null));
        assertThat(t.ll, is((TreeNode)null));
        assertThat(t.lr, is((TreeNode)null));
    }

    @Test
    public void testUniform3x2() {
        AsciiArtEncoder enc = new AsciiArtEncoder(List.of("aaa", "aaa"));
        TreeNode t = enc.generateTree();
        assertThat(t, not(is((TreeNode)null)));
        assertThat(t.isLeaf(), is(true));
        assertThat(t.c, is('a'));
        assertThat(t.width, is(3));
        assertThat(t.height, is(2));
        assertThat(t.ul, is((TreeNode)null));
        assertThat(t.ur, is((TreeNode)null));
        assertThat(t.ll, is((TreeNode)null));
        assertThat(t.lr, is((TreeNode)null));
    }

    @Test
    public void testVaried2x2() {
        AsciiArtEncoder enc = new AsciiArtEncoder(List.of("aa", "a."));
        TreeNode t = enc.generateTree();
        assertThat(t, not(is((TreeNode)null)));
        assertThat(t.isLeaf(), is(false));
        assertThat(t.c, lessThan(' '));
        assertThat(t.width, is(2));
        assertThat(t.height, is(2));

        TreeNode ul = t.ul;
        assertThat(ul.isLeaf(), is(true));
        assertThat(ul.c, is('a'));
        assertThat(ul.width, is(1));
        assertThat(ul.height, is(1));

        TreeNode ur = t.ur;
        assertThat(ur.isLeaf(), is(true));
        assertThat(ur.c, is('a'));
        assertThat(ur.width, is(1));
        assertThat(ur.height, is(1));

        TreeNode ll = t.ll;
        assertThat(ll.isLeaf(), is(true));
        assertThat(ll.c, is('a'));
        assertThat(ll.width, is(1));
        assertThat(ll.height, is(1));

        TreeNode lr = t.lr;
        assertThat(lr.isLeaf(), is(true));
        assertThat(lr.c, is('.'));
        assertThat(lr.width, is(1));
        assertThat(lr.height, is(1));
    }

    @Test
    public void testVaried3x3() {
        AsciiArtEncoder enc = new AsciiArtEncoder(List.of("aaa", "abb", "abb"));
        TreeNode t = enc.generateTree();
        assertThat(t, not(is((TreeNode)null)));
        assertThat(t.isLeaf(), is(false));
        assertThat(t.c, lessThan(' '));
        assertThat(t.width, is(3));
        assertThat(t.height, is(3));

        TreeNode ul = t.ul;
        assertThat(ul.isLeaf(), is(true));
        assertThat(ul.c, is('a'));
        assertThat(ul.width, is(1));
        assertThat(ul.height, is(1));

        TreeNode ur = t.ur;
        assertThat(ur.isLeaf(), is(true));
        assertThat(ur.c, is('a'));
        assertThat(ur.width, is(2));
        assertThat(ur.height, is(1));

        TreeNode ll = t.ll;
        assertThat(ll.isLeaf(), is(true));
        assertThat(ll.c, is('a'));
        assertThat(ll.width, is(1));
        assertThat(ll.height, is(2));

        TreeNode lr = t.lr;
        assertThat(lr.isLeaf(), is(true));
        assertThat(lr.c, is('b'));
        assertThat(lr.width, is(2));
        assertThat(lr.height, is(2));
    }

}
