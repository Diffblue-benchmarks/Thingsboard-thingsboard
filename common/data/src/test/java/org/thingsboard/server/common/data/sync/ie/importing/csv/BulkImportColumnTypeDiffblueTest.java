package org.thingsboard.server.common.data.sync.ie.importing.csv;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkImportColumnTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BulkImportColumnType#getDefaultValue()}
   *   <li>{@link BulkImportColumnType#getKey()}
   *   <li>{@link BulkImportColumnType#isKv()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BulkImportColumnType.getDefaultValue()",
    "String BulkImportColumnType.getKey()",
    "boolean BulkImportColumnType.isKv()"
  })
  void testGettersAndSetters() {
    // Arrange
    BulkImportColumnType valueOfResult = BulkImportColumnType.valueOf("NAME");

    // Act
    String actualDefaultValue = valueOfResult.getDefaultValue();
    String actualKey = valueOfResult.getKey();

    // Assert
    assertNull(actualDefaultValue);
    assertNull(actualKey);
    assertFalse(valueOfResult.isKv());
  }
}
