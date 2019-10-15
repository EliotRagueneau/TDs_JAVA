package fr.ubordeaux.ao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;


class CatalogImplTest {
    private static final int LAMBDA_PRICE_IN_EURO_CENTS = 110;
    private static Catalog catalog;
    private static Reference aRef;
    private static Reference bRef;

    @BeforeAll
    static void initTest() {
        catalog = new CatalogImpl("collection");
        Catalog subCatalog = new CatalogImpl("bar");
        catalog.addSubCatalog(subCatalog);
        catalog.addSubCatalog(new CatalogImpl("foo"));
        aRef = new Reference("a", "A", "a?", new Price(LAMBDA_PRICE_IN_EURO_CENTS));
        bRef = new Reference("b", "B", "b?", new Price(Integer.MAX_VALUE));

        catalog.addReference(aRef);
        subCatalog.addReference(bRef);
    }

    @Test
    void setName() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                catalog.setName("Aze"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                catalog.setName("az"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                catalog.setName(""));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                catalog.setName("abcdefghijklmnopq"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                catalog.setName("abcdefghijklmnopq"));
        Assertions.assertDoesNotThrow(() -> catalog.setName("testname"));
    }

    @Test
    void addSubCatalog() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> catalog.addSubCatalog(new CatalogImpl("bar")));
        Assertions.assertDoesNotThrow(() -> catalog.addSubCatalog(new CatalogImpl("plop")));
    }

    @Test
    void removeSubCatalogByName() {
        Assertions.assertTrue(catalog.removeSubCatalogByName("bar"));
        for (Catalog subCatalog : catalog.getSubCatalogs()) {
            if (subCatalog.getName().equals("bar")) {
                Assertions.fail("The catalog is not removed");
            }
        }
        Assertions.assertFalse(catalog.removeSubCatalogByName("nothere"));
    }

    @Test
    void getOwnReferences() {
        Set<Reference> ownReferences = new HashSet<>();
        ownReferences.add(aRef);
        Assertions.assertIterableEquals(ownReferences, catalog.getOwnReferences());
    }

    @Test
    void getAllReferences() {
        Set<Reference> ownReferences = new HashSet<>();
        ownReferences.add(aRef);
        ownReferences.add(bRef);
        Assertions.assertIterableEquals(ownReferences, catalog.getAllReferences());
    }
}