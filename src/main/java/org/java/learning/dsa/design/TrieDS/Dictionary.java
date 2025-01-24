package org.java.learning.dsa.design.TrieDS;




class Dictionary {
    private TrieNode root; // injecting root node

    public Dictionary() {
        root = new TrieNode();
    }

    public void addNewWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int ind = c - 'a';
            if (node.children[ind] == null) {
                node.children[ind] = new TrieNode();
            }
            node = node.children[ind];
        }
        node.isEndOfWord = true;
    }

    public boolean searchWord(String word) {
        return searchInNode(word, root);
    }

    public boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') { //wildcard
                for (TrieNode child : node.children) {
                    if (child != null && searchInNode(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                int ind = c - 'a';
                if (node.children[ind] == null) {
                    return false;
                }
                node = node.children[ind];
            }
        }
        return node.isEndOfWord;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];

    boolean isEndOfWord;

//    public TrieNode() {
//        this.children = new TrieNode[26];
//        this.isEndOfWord = false;
//    }
}

class Solution {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.addNewWord("bad");
        dictionary.addNewWord("dad");
        dictionary.addNewWord("mad");
        System.out.println(dictionary.searchWord("pad")); //false
        System.out.println(dictionary.searchWord("bad")); //true
        System.out.println(dictionary.searchWord(".ad")); //true
        System.out.println(dictionary.searchWord("b..")); //true
    }
}

