package fr.ubordeaux.ao;

import java.util.Set;

public interface Catalog {
    int size();

    String getName();

    void setName(String name);

    void addSubCatalog(Catalog catalog);

    boolean removeSubCatalogByName(String name);

    Set<Catalog> getSubCatalogs();

    Set<Reference> getOwnReferences();

    Set<Reference> getAllReferences();

    Reference findReferenceById(String id);

    void addReference(Reference reference);

    void removeReference(Reference reference);
}