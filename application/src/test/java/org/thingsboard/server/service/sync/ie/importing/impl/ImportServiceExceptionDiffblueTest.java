package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImportServiceExceptionDiffblueTest {
  /**
   * Test new {@link ImportServiceException} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ImportServiceException}
   */
  @Test
  @DisplayName("Test new ImportServiceException (default constructor)")
  void testNewImportServiceException() {
    // Arrange and Act
    ImportServiceException actualImportServiceException = new ImportServiceException();

    // Assert
    assertNull(actualImportServiceException.getMessage());
    assertNull(actualImportServiceException.getCause());
    assertEquals(0, actualImportServiceException.getSuppressed().length);
  }
}
