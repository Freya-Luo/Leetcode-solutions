package lc_2101.LC_2115_FindAllPossibleRecipesfromGivenSupplies;

import java.util.*;

class Solution {
    // O (E + V), where V: nodes of supplies and ingredients; E: ingredients -> recipes
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // build the graph, ingredients => recipes
        Map<String, Set<String>> adjList = new HashMap<>();
        Map<String, Integer> indegs = new HashMap<>();
        for(int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            for(String in : ingredients.get(i)) {
                if (!adjList.containsKey(in)) {
                    adjList.put(in, new HashSet<>());
                }
                adjList.get(in).add(recipe);
            }
            indegs.put(recipe, ingredients.get(i).size());
        }

        // start from 0-indeg node
        // do the topological sort
        Deque<String> queue = new LinkedList<>(Arrays.asList(supplies));
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (adjList.containsKey(cur)) {
                for (String next: adjList.remove(cur)) {
                    indegs.put(next, indegs.get(next) - 1);
                    if (indegs.get(next) == 0) {
                        queue.add(next);
                        res.add(next);
                    }
                }
            }
        }
        return res;
    }
}