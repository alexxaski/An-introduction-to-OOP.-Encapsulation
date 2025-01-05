package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.notFoundAndSedrch.Searchable;

import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class SearchEngine {
    private Set<Searchable> searchableObjects = new TreeSet<>(new SearchableComparator());

    public void add(Searchable searchable) {
        searchableObjects.add(searchable);
    }

    public Set<Searchable> search(String searchTerm) {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());

        for (Searchable obj : searchableObjects) {
            if (obj != null && obj.getSearchTerm().contains(searchTerm)) {
                results.add(obj);
            }
        }

        return results;
    }

    public Set<Searchable> findMostSuitable(String search) {
        Set<Searchable> suitableResults = new TreeSet<>(new SearchableComparator());

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
