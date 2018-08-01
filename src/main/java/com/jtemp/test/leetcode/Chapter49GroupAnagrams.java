package com.jtemp.test.leetcode;

import java.util.*;

/**
 * Group Anagrams 群组错位词
 * <p>
 * <p>
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * <p>
 * Note: All inputs will be in lower-case.
 */
public class Chapter49GroupAnagrams {


    public static void main(String[] args) {
        String[] array = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Collection<List<String>> ret = groupAnagrams(array);
        System.out.println(ret);
    }

    private static Collection<List<String>> groupAnagrams(String[] array) {
        Map<BitSet, List<String>> groupMap = new HashMap<>();
        for (String s : array) {
            BitSet bitSet = toBitSet(s);
            List<String> list = groupMap.computeIfAbsent(bitSet, k -> new ArrayList<>());
            list.add(s);
        }
        return groupMap.values();
    }

    private static BitSet toBitSet(String s) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < s.length(); i++) {
            bitSet.set(s.charAt(i) - 'a');
        }
        return bitSet;
    }

}
