package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.notFoundAndSedrch.Searchable;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchableObjects = new ArrayList<>();



    public void add(Searchable searchable) {
        searchableObjects.add(searchable);
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable obj : searchableObjects) {
            if (obj != null && obj.getSearchTerm().contains(searchTerm)) {
                results.add(obj);
            }
        }
        return results;
    }

    public List<Searchable> findMostSuitable(String search) {
        List<Searchable> suitableResults = new ArrayList<>();
        int maxCount = 0;

        for (Searchable obj : searchableObjects) {
            if (obj != null) {
                String searchTerm = obj.getSearchTerm();
                int count = 0;
                int fromIndex = 0;

                while ((fromIndex = searchTerm.indexOf(search, fromIndex)) != -1) {
                    count++;
                    fromIndex += search.length();
                }

                if (count > maxCount) {
                    maxCount = count;
                    suitableResults.clear();
                    suitableResults.add(obj);
                } else if (count == maxCount) {
                    suitableResults.add(obj);
                }
            }
        }

        return suitableResults;
    }
}
