package com.avas.springboot.controllers;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private class TrieNode {
        Map<Character, TrieNode> edges;
        boolean isWordEnd;
        TrieNode(){
            this.edges = new HashMap<>();
            this.isWordEnd = false;

        }
    }

    TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    void insert(String word){
        TrieNode currNode = root;
        for(char ch : word.toCharArray()){
            if(!currNode.edges.containsKey(ch)){
                currNode.edges.put(ch, new TrieNode());
            }
            currNode = currNode.edges.get(ch);
        }
        currNode.isWordEnd = true;
    }

    public boolean search(String word){
        TrieNode currNode = root;
        for(char ch : word.toCharArray()){
            if(!currNode.edges.containsKey(ch)){
                return false;
            }
            currNode = currNode.edges.get(ch);
        }
        return currNode.isWordEnd;
    }


}
