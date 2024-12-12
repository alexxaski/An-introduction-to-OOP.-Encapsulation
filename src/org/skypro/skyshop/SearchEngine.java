package org.skypro.skyshop;

public class SearchEngine {
    private Searchable[] searchableObjects;

    public SearchEngine(int size) {
        this.searchableObjects = new Searchable[size];
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < searchableObjects.length; i++) {
            if (searchableObjects[i] == null) {
                searchableObjects[i] = searchable;
                break;
            }
        }
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] results = new Searchable[5];
        int count = 0;
        for (Searchable obj : searchableObjects) {
            if (obj != null && obj.getSearchTerm().contains(searchTerm)) {
                results[count] = obj;
                count++;
                if (count == 5) {
                    break;
                }
            }
        }
        return results;
    }

    public Searchable findMostSuitable(String search) {
        Searchable mostSuitable = null;
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
                    mostSuitable = obj;
                }
            }
        }
        return mostSuitable;
    }
}

