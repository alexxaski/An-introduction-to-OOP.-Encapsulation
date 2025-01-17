package org.skypro.skyshop.notFoundAndSedrch;

public interface Searchable {

    String getSearchTerm();
    String getContentType();
    String getObjectName();
    default String getStringRepresentation() {
        return getObjectName() + " — " + getContentType();
    }
}
