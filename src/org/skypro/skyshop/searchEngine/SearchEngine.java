package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.notFoundAndSedrch.Searchable;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchableObjects = new HashSet<>();

    public void add(Searchable searchable) {
        searchableObjects.add(searchable);
    }

    public Set<Searchable> search(String searchTerm) {
        Set<Searchable> results = new TreeSet<>(new Comparator<Searchable>() {
            @Override
            public int compare(Searchable s1, Searchable s2) {
                int lenDiff = s2.getObjectName().length() - s1.getObjectName().length();
                if (lenDiff != 0) {
                    return lenDiff;
                } else {
                    return s1.getObjectName().compareTo(s2.getObjectName());
                }
            }
        });

        for (Searchable obj : searchableObjects) {
            if (obj != null && obj.getSearchTerm().contains(searchTerm)) {
                results.add(obj);
            }
        }
        return results;
    }

    public Set<Searchable> findMostSuitable(String search) {
        Set<Searchable> suitableResults = new TreeSet<>(new Comparator<Searchable>() {
            @Override
            public int compare(Searchable s1, Searchable s2) {
                int lenDiff = s2.getObjectName().length() - s1.getObjectName().length();
                if (lenDiff != 0) {
                    return lenDiff;
                } else {
                    return s1.getObjectName().compareTo(s2.getObjectName());
                }
            }
        });

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
