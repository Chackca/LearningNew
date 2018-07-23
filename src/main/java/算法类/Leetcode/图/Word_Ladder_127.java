package 算法类.Leetcode.图;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 给出两个单词（begin和endWord），以及一个单词列表，寻找一条从beginWord到endWord的最短变换路径
 * 每次变换只能修改单词的一个字母，最后返回最短路径的大小
 */
public class Word_Ladder_127 {

    private static int ladderLength(String beginWord, String endWord, ArrayList<String> wordList) {
        HashSet<String> wordSet = new HashSet<>();
        for(String word: wordList)
            wordSet.add(word);

        HashSet<String> visited = new HashSet<>();
        wordSet.remove(beginWord);

        LinkedList<Pair<String,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord,1));

        while (!queue.isEmpty()){
            Pair<String, Integer> stringIntegerPair = queue.removeFirst();
            String curWord  = stringIntegerPair.getKey();
            int curStep = stringIntegerPair.getValue();
            visited.clear();
            for (String word : wordSet){
                if (similar(curWord,word)){
                    if(word.equals(endWord))
                        return curStep + 1;
                    queue.add(new Pair<>(word,curStep+1));
                    visited.add(word);
                }
            }
            for(String word: visited)
                wordSet.remove(word);
        }
        return -1;
    }


    private static boolean similar(String word1, String word2) {
        if(word1.length() != word2.length() || word1.equals(word2))
            throw new IllegalArgumentException();

        int diff = 0;
        for(int i = 0 ; i < word1.length() ; i ++)
            if(word1.charAt(i) != word2.charAt(i)){
                diff ++;
                if(diff > 1)
                    return false;
            }
        return true;
    }


    public static void main(String[] args) {

        ArrayList<String> wordList1 = new ArrayList<String>(
                Arrays.asList("hot","dot","dog","lot","log","cog"));
        String beginWord1 = "hit";
        String endWord1 = "cog";
        System.out.println(ladderLength(beginWord1, endWord1, wordList1));

        // 5

        // ---

        ArrayList<String> wordList2 = new ArrayList<String>(
                Arrays.asList("a","b","c"));
        String beginWord2 = "a";
        String endWord2 = "c";
        System.out.println(ladderLength(beginWord2, endWord2, wordList2));
        // 2
    }


}
