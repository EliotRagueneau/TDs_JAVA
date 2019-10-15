package fr.ubordeaux.ao;

import java.util.*;

public class CatalogImpl implements Catalog {
    private Map<String, Reference> references;
    private SmallCaseString name;
    private Set<Catalog> subCatalogs;


    public CatalogImpl(String name) {
        references = new HashMap<String, Reference>();
        subCatalogs = new HashSet<>();
        this.name = new SmallCaseString(name);
    }

    @Override
    public String getName() {
        return name.getValue();
    }

    @Override
    public void setName(String name) {
        this.name.setValue(name);
    }

    @Override
    public void addSubCatalog(Catalog catalog) {
        for (Catalog subCatalog : subCatalogs) {
            if (subCatalog.getName().equals(catalog.getName())) {
                throw new IllegalArgumentException("A brother catalog has already the name given");
            }
        }
        subCatalogs.add(catalog);
    }

    @Override
    public boolean removeSubCatalogByName(String name) {
        return subCatalogs.removeIf(catalog -> catalog.getName().equals(name));
    }

    @Override
    public Set<Catalog> getSubCatalogs() {
        return new HashSet<>(subCatalogs);
    }

    public int size() {
        return references.size();
    }

    public Set<Reference> getOwnReferences() {
        return new HashSet<>(references.values());
    }

    @Override
    public Set<Reference> getAllReferences() {
        Set<Reference> allReferences = getOwnReferences();
        for (Catalog subCatalog : subCatalogs) {
            allReferences.addAll(subCatalog.getAllReferences());
        }
        return allReferences;
    }

    public Reference findReferenceById(String id) {
        if (!references.containsKey(id)) throw new ReferenceManagementException("cannot find Reference, id unknown !");
        return references.get(id);
    }

    public void addReference(Reference reference) {
        references.put(reference.getId(), reference);
    }

    public void removeReference(Reference reference) {
        references.remove(reference.getId());
    }
}