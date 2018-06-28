package com.jtemp.test.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

//        {
//            int[] candidate = {2, 3, 6, 7};
//            int target = 7;
//            System.out.println(combinationSum1(candidate, target));
//            System.out.println("-----------");
//        }
//        {
//            int[] candidate = {10, 1, 2, 7, 6, 1, 5};
//            int target = 8;
//            System.out.println(combinationSum2(candidate, target));
//        }

//        System.out.println(combinationSum3(3, 7));
//        System.out.println(combinationSum3(3, 9));

        {
            int[] candidate = {1, 2, 3};
            int target = 4;
            System.out.println(combinationSum4(candidate, target));
        }
        {
            int[] candidate = {1, 2, 3};
            int target = 4;
            System.out.println(combinationSum4DP(candidate, target));
        }

    }

    /**
     * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
     * find all unique combinations in C where the candidate numbers sums to T.
     * <p>
     * The same repeated number may be chosen from C unlimited number of times.
     * <p>
     * Note:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * For example, given candidate set [2, 3, 6, 7] and target 7,
     * A solution set is:
     * [
     * [7],
     * [2, 2, 3]
     * ]
     * 可重复使用数组中的数，构建一个和为target的序列, 数组所有数大于0， target大于0
     *
     * @param candidate
     * @param target
     * @return
     */
    private static List<List<Integer>> combinationSum1(int[] candidate, int target) {
        if (candidate == null || candidate.length == 0 || target <= 0) {
            return null;
        }
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidate);
        combinationSum1(candidate, target, ret, new ArrayList<>(), 0);
        return ret;
    }

    private static void combinationSum1(int[] candidate, int target, List<List<Integer>> ret, List<Integer> path, int start) {
        if (target > 0) {
            for (int i = start; i < candidate.length; i++) {
                if (candidate[i] > target) {
                    break;
                }
                path.add(candidate[i]);
                combinationSum1(candidate, target - candidate[i], ret, path, i);
                path.remove(path.size() - 1);
            }
        } else if (target == 0) {
            ret.add(new ArrayList<>(path));
        }
    }

    /**
     * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
     * <p>
     * Each number in C may only be used once in the combination.
     * <p>
     * Note:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
     * A solution set is:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     * 集合中元素可能重复，每个元素只可以使用一次
     *
     * @param candidate
     * @param target
     * @return
     */
    private static List<List<Integer>> combinationSum2(int[] candidate, int target) {
        if (candidate == null || candidate.length == 0 || target <= 0) {
            return null;
        }
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidate);
        System.out.println(Arrays.toString(candidate));
        combinationSum2(candidate, target, ret, new ArrayList<>(), 0);
        return ret;
    }

    private static void combinationSum2(int[] candidate, int target, List<List<Integer>> ret, ArrayList<Integer> path, int start) {
        if (target > 0) {
            for (int i = start; i < candidate.length; i++) {
                if (candidate[i] > target) {
                    break;
                }
                if (i > start && candidate[i - 1] == candidate[i]) {
                    continue;
                }
                path.add(candidate[i]);
                combinationSum2(candidate, target - candidate[i], ret, path, i + 1);
                StringBuilder sb = new StringBuilder();
                sb.append(path.toString());
                path.remove(path.size() - 1);
                sb.append("->").append(path.toString());
                System.out.println(sb.toString());
            }
        } else if (target == 0) {
            ret.add(new ArrayList<>(path));
        }
    }


    /**
     * Find all possible combinations of k numbers that add up to a number n,
     * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: k = 3, n = 7
     * <p>
     * Output:
     * <p>
     * [[1,2,4]]
     * <p>
     * Example 2:
     * <p>
     * Input: k = 3, n = 9
     * <p>
     * Output:
     * <p>
     * [[1,2,6], [1,3,5], [2,3,4]]
     *
     * @param k
     * @param n
     * @return
     */
    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        combinationSum3(k, n, ret, new ArrayList<>(), 1);
        return ret;
    }

    private static void combinationSum3(int k, int n, List<List<Integer>> ret, ArrayList<Integer> path, int start) {
        if (k == 0 && n == 0) {
            ret.add(new ArrayList<>(path));
        } else if (k > 0 && n > 0) {
            for (int i = start; i <= 9; i++) {
                if (i > n) {
                    break;
                }
                path.add(i);
                combinationSum3(k - 1, n - i, ret, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }


    /**
     * Given an integer array with all positive numbers and no duplicates,
     * find the number of possible combinations that add up to a positive integer target.
     * <p>
     * Example:
     * <p>
     * nums = [1, 2, 3]
     * target = 4
     * <p>
     * The possible combination ways are:
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     * <p>
     * Note that different sequences are counted as different combinations.
     * <p>
     * Therefore the output is 7.
     * Follow up:
     * What if negative numbers are allowed in the given array?
     * How does it change the problem?
     * What limitation we need to add to the question to allow negative numbers?
     *
     * @param candidate
     * @param target
     * @return
     */
    private static List<List<Integer>> combinationSum4(int[] candidate, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        combinationSum4(candidate, target, ret, new ArrayList<Integer>());
        return ret;
    }

    private static void combinationSum4(int[] candidate, int target, List<List<Integer>> ret, ArrayList<Integer> path) {
        if (target == 0) {
            ret.add(new ArrayList<>(path));
        } else if (target > 0) {
            for (int i = 0; i < candidate.length; i++) {
                path.add(candidate[i]);
                combinationSum4(candidate, target - candidate[i], ret, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private static int combinationSum4DP(int[] candidate, int target) {
        Arrays.sort(candidate);
        int[] ret = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            for (int num : candidate) {
                if (num == i) {
                    ret[i] += 1;
                } else if (num < i) {
                    ret[i] += ret[i - num];
                } else {
                    break;
                }
            }
        }
        return ret[target];
    }

}
