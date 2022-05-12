class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        TreeSet<List<Integer>> allCombinations = new TreeSet<>(Comparator.comparing(List::hashCode));

        OUTER:
        for (long i = 1; i < 1L << candidates.length; i++) {

            LinkedList<Integer> tempList = new LinkedList<>();
            int tempSum = 0;

            for (int j = 0; j < candidates.length; j++) {

                if (tempSum > target) continue OUTER;
                if ((i >> j & 1) == 1) {
                    tempList.add(candidates[j]);
                    tempSum += candidates[j];
                }

            }

            if (tempSum == target){
                Collections.sort(tempList);
                allCombinations.add(tempList);
            }

        }

        return new LinkedList<>(allCombinations);
    }

}