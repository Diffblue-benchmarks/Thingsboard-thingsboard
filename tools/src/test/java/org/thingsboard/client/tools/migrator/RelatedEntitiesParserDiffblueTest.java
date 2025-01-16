package org.thingsboard.client.tools.migrator;

import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RelatedEntitiesParserDiffblueTest {
  /**
   * Test {@link RelatedEntitiesParser#RelatedEntitiesParser(File)}.
   * <p>
   * Method under test: {@link RelatedEntitiesParser#RelatedEntitiesParser(File)}
   */
  @Test
  @DisplayName("Test new RelatedEntitiesParser(File)")
  void testNewRelatedEntitiesParser() throws IOException {
    // Arrange, Act and Assert
    assertNull((new RelatedEntitiesParser(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
        .getEntityType("01234567-89AB-CDEF-FEDC-BA9876543210"));
  }

  /**
   * Test {@link RelatedEntitiesParser#getEntityType(String)}.
   * <p>
   * Method under test: {@link RelatedEntitiesParser#getEntityType(String)}
   */
  @Test
  @DisplayName("Test getEntityType(String)")
  void testGetEntityType() throws IOException {
    // Arrange, Act and Assert
    assertNull((new RelatedEntitiesParser(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
        .getEntityType("01234567-89AB-CDEF-FEDC-BA9876543210"));
  }
}
