class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        TreeSet<List<Integer>> allCombinations = new TreeSet<>(Comparator.comparing(List::hashCode));
        LinkedList<Integer> currentCombinations = new LinkedList<>();
        Arrays.sort(candidates);

        findCombinations(target, 0, candidates, currentCombinations, allCombinations);

        return new LinkedList<>(allCombinations);
    }

    private static void findCombinations(int target, int shift, int[] candidates, LinkedList<Integer> currentCombinations, TreeSet<List<Integer>> allCombinations) {

        if (target == 0) {
            Collections.sort(currentCombinations);
            allCombinations.add(new LinkedList<>(currentCombinations));
            return;
        }

        for (int i = shift; i < candidates.length; i++) {

            if (target - candidates[i] < 0) break;

            currentCombinations.addLast(candidates[i]);
            findCombinations(target - candidates[i], i + 1, candidates, currentCombinations, allCombinations);
            currentCombinations.pollLast();
        }

    }
}