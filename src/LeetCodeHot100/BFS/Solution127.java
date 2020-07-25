package LeetCodeHot100.BFS;

import java.util.*;

public class Solution127 {
    /**
     * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
     *
     *     每次转换只能改变一个字母。
     *     转换过程中的中间单词必须是字典中的单词。
     *
     * 说明:
     *
     *     如果不存在这样的转换序列，返回 0。
     *     所有单词具有相同的长度。
     *     所有单词只由小写字母组成。
     *     字典中不存在重复的单词。
     *     你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     *
     * 示例 1:
     *
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * 输出: 5
     *
     * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     *      返回它的长度 5。
     *
     * 示例 2:
     *
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * 输出: 0
     *
     * 解释: endWord "cog" 不在字典中，所以无法进行转换。
     */
    class Node{
        public String word;
        public int level;

        public Node(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();

        Map<String,List<String>> genericWordListMap = new HashMap<>();
        for(String word:wordList){
            for(int i = 0;i<len;i++){
                String genericWord = word.substring(0,i)+"*"+word.substring(i+1,len);
                List<String> transformList =  genericWordListMap.getOrDefault(genericWord,new ArrayList<>());
                transformList.add(word);
                genericWordListMap.put(genericWord,transformList);
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(beginWord,1));

        Map<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord,true);

        while (!queue.isEmpty()){
            Node node = queue.remove();
            String curWord = node.word;
            int curLevel = node.level;

            for(int i=0; i<len;i++){
                String genericWord = curWord.substring(0,i)+"*"+curWord.substring(i+1,len);
                List<String> matchWordList = genericWordListMap.getOrDefault(genericWord,new ArrayList<>());
                for(String word:matchWordList){

                    if(word.equals(endWord)) {
                        return curLevel + 1;
                    }

                    if(!visited.getOrDefault(word,false)){
                        visited.put(word,true);
                        queue.add(new Node(word,curLevel+1));

                    }
                }
            }
        }
        return 0;
    }
}
