package org.gnuhpc.interview.leetcode.solutions;

import org.junit.Test;

/**
 * Copyright gnuhpc 2019/10/5
 */
/*
Trie解法
 */
public class WordDictionary2112 {

    class Node {
        private Node[] next;
        private boolean isWord;

        public Node() {
            next = new Node[26];
            isWord = false;
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary2112() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        int len = word.length();
        Node curNode = root;
        for (int i = 0; i < len; i++) {
            char curChar = word.charAt(i);
            Node next = curNode.next[curChar - 'a'];
            if (next == null) {
                curNode.next[curChar - 'a'] = new Node();
            }
            curNode = curNode.next[curChar - 'a'];
        }
        if (!curNode.isWord) {
            curNode.isWord = true;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(word, root, 0);
    }

    private boolean match(String word, Node node, int start) {
        if (start == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(start);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.next[i] != null && match(word, node.next[i], start + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.next[c - 'a'] == null) {
                return false;

            }
            return match(word, node.next[c - 'a'], start + 1);
        }
    }

    @Test
    public void test() {
        WordDictionary2112 dictionary = new WordDictionary2112();
        dictionary.addWord("bad");
        dictionary.addWord("mad");
        dictionary.addWord("dad");

        System.out.println(dictionary.search(".ad"));
    }
}
