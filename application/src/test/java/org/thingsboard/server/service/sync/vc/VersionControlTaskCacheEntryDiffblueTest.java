package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.thingsboard.server.common.data.sync.vc.EntityLoadError;
import org.thingsboard.server.common.data.sync.vc.VersionCreationResult;
import org.thingsboard.server.common.data.sync.vc.VersionLoadResult;

@DisabledInAotMode
class VersionControlTaskCacheEntryDiffblueTest {
  @MockBean
  private VersionCreationResult versionCreationResult;

  @MockBean
  private VersionLoadResult versionLoadResult;

  /**
   * Test
   * {@link VersionControlTaskCacheEntry#newForExport(VersionCreationResult)}.
   * <p>
   * Method under test:
   * {@link VersionControlTaskCacheEntry#newForExport(VersionCreationResult)}
   */
  @Test
  @DisplayName("Test newForExport(VersionCreationResult)")
  void testNewForExport() {
    // Arrange and Act
    VersionControlTaskCacheEntry actualNewForExportResult = VersionControlTaskCacheEntry
        .newForExport(versionCreationResult);

    // Assert
    assertNull(actualNewForExportResult.getImportResult());
    assertSame(versionCreationResult, actualNewForExportResult.getExportResult());
  }

  /**
   * Test {@link VersionControlTaskCacheEntry#newForImport(VersionLoadResult)}.
   * <p>
   * Method under test:
   * {@link VersionControlTaskCacheEntry#newForImport(VersionLoadResult)}
   */
  @Test
  @DisplayName("Test newForImport(VersionLoadResult)")
  void testNewForImport() {
    // Arrange and Act
    VersionControlTaskCacheEntry actualNewForImportResult = VersionControlTaskCacheEntry
        .newForImport(versionLoadResult);

    // Assert
    assertNull(actualNewForImportResult.getExportResult());
    assertSame(versionLoadResult, actualNewForImportResult.getImportResult());
  }

  /**
   * Test {@link VersionControlTaskCacheEntry#equals(Object)}, and
   * {@link VersionControlTaskCacheEntry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionControlTaskCacheEntry#equals(Object)}
   *   <li>{@link VersionControlTaskCacheEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VersionControlTaskCacheEntry newForExportResult = VersionControlTaskCacheEntry
        .newForExport(new VersionCreationResult("An error occurred"));
    VersionControlTaskCacheEntry newForExportResult2 = VersionControlTaskCacheEntry
        .newForExport(new VersionCreationResult("An error occurred"));

    // Act and Assert
    assertEquals(newForExportResult, newForExportResult2);
    int expectedHashCodeResult = newForExportResult.hashCode();
    assertEquals(expectedHashCodeResult, newForExportResult2.hashCode());
  }

  /**
   * Test {@link VersionControlTaskCacheEntry#equals(Object)}, and
   * {@link VersionControlTaskCacheEntry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionControlTaskCacheEntry#equals(Object)}
   *   <li>{@link VersionControlTaskCacheEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    VersionControlTaskCacheEntry newForExportResult = VersionControlTaskCacheEntry.newForExport(null);
    VersionControlTaskCacheEntry newForExportResult2 = VersionControlTaskCacheEntry.newForExport(null);

    // Act and Assert
    assertEquals(newForExportResult, newForExportResult2);
    int expectedHashCodeResult = newForExportResult.hashCode();
    assertEquals(expectedHashCodeResult, newForExportResult2.hashCode());
  }

  /**
   * Test {@link VersionControlTaskCacheEntry#equals(Object)}, and
   * {@link VersionControlTaskCacheEntry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionControlTaskCacheEntry#equals(Object)}
   *   <li>{@link VersionControlTaskCacheEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    VersionCreationResult exportResult = new VersionCreationResult("An error occurred");
    VersionLoadResult.VersionLoadResultBuilder doneResult = VersionLoadResult.builder().done(true);
    EntityLoadError error = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(null)
        .target(null)
        .type("Type")
        .build();
    VersionLoadResult.VersionLoadResultBuilder errorResult = doneResult.error(error);
    VersionLoadResult importResult = errorResult.result(new ArrayList<>()).build();
    VersionControlTaskCacheEntry versionControlTaskCacheEntry = new VersionControlTaskCacheEntry(exportResult,
        importResult);
    VersionCreationResult exportResult2 = new VersionCreationResult("An error occurred");
    VersionLoadResult.VersionLoadResultBuilder doneResult2 = VersionLoadResult.builder().done(true);
    EntityLoadError error2 = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(null)
        .target(null)
        .type("Type")
        .build();
    VersionLoadResult.VersionLoadResultBuilder errorResult2 = doneResult2.error(error2);
    VersionLoadResult importResult2 = errorResult2.result(new ArrayList<>()).build();
    VersionControlTaskCacheEntry versionControlTaskCacheEntry2 = new VersionControlTaskCacheEntry(exportResult2,
        importResult2);

    // Act and Assert
    assertEquals(versionControlTaskCacheEntry, versionControlTaskCacheEntry2);
    int expectedHashCodeResult = versionControlTaskCacheEntry.hashCode();
    assertEquals(expectedHashCodeResult, versionControlTaskCacheEntry2.hashCode());
  }

  /**
   * Test {@link VersionControlTaskCacheEntry#equals(Object)}, and
   * {@link VersionControlTaskCacheEntry#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionControlTaskCacheEntry#equals(Object)}
   *   <li>{@link VersionControlTaskCacheEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VersionControlTaskCacheEntry newForExportResult = VersionControlTaskCacheEntry
        .newForExport(new VersionCreationResult("An error occurred"));

    // Act and Assert
    assertEquals(newForExportResult, newForExportResult);
    int expectedHashCodeResult = newForExportResult.hashCode();
    assertEquals(expectedHashCodeResult, newForExportResult.hashCode());
  }

  /**
   * Test {@link VersionControlTaskCacheEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionControlTaskCacheEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    VersionControlTaskCacheEntry newForExportResult = VersionControlTaskCacheEntry
        .newForExport(new VersionCreationResult("Error"));

    // Act and Assert
    assertNotEquals(newForExportResult,
        VersionControlTaskCacheEntry.newForExport(new VersionCreationResult("An error occurred")));
  }

  /**
   * Test {@link VersionControlTaskCacheEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionControlTaskCacheEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VersionControlTaskCacheEntry newForExportResult = VersionControlTaskCacheEntry.newForExport(null);

    // Act and Assert
    assertNotEquals(newForExportResult,
        VersionControlTaskCacheEntry.newForExport(new VersionCreationResult("An error occurred")));
  }

  /**
   * Test {@link VersionControlTaskCacheEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionControlTaskCacheEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    VersionControlTaskCacheEntry newForExportResult = VersionControlTaskCacheEntry
        .newForExport(mock(VersionCreationResult.class));

    // Act and Assert
    assertNotEquals(newForExportResult,
        VersionControlTaskCacheEntry.newForExport(new VersionCreationResult("An error occurred")));
  }

  /**
   * Test {@link VersionControlTaskCacheEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionControlTaskCacheEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    VersionCreationResult exportResult = new VersionCreationResult("An error occurred");
    VersionLoadResult.VersionLoadResultBuilder doneResult = VersionLoadResult.builder().done(true);
    EntityLoadError error = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(null)
        .target(null)
        .type("Type")
        .build();
    VersionLoadResult.VersionLoadResultBuilder errorResult = doneResult.error(error);
    VersionLoadResult importResult = errorResult.result(new ArrayList<>()).build();
    VersionControlTaskCacheEntry versionControlTaskCacheEntry = new VersionControlTaskCacheEntry(exportResult,
        importResult);

    // Act and Assert
    assertNotEquals(versionControlTaskCacheEntry,
        VersionControlTaskCacheEntry.newForExport(new VersionCreationResult("An error occurred")));
  }

  /**
   * Test {@link VersionControlTaskCacheEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionControlTaskCacheEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    VersionControlTaskCacheEntry newForExportResult = VersionControlTaskCacheEntry
        .newForExport(new VersionCreationResult("An error occurred"));
    VersionCreationResult exportResult = new VersionCreationResult("An error occurred");
    VersionLoadResult.VersionLoadResultBuilder doneResult = VersionLoadResult.builder().done(true);
    EntityLoadError error = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(null)
        .target(null)
        .type("Type")
        .build();
    VersionLoadResult.VersionLoadResultBuilder errorResult = doneResult.error(error);
    VersionLoadResult importResult = errorResult.result(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(newForExportResult, new VersionControlTaskCacheEntry(exportResult, importResult));
  }

  /**
   * Test {@link VersionControlTaskCacheEntry#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionControlTaskCacheEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VersionControlTaskCacheEntry.newForExport(new VersionCreationResult("An error occurred")), null);
  }

  /**
   * Test {@link VersionControlTaskCacheEntry#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionControlTaskCacheEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VersionControlTaskCacheEntry.newForExport(new VersionCreationResult("An error occurred")),
        "Different type to VersionControlTaskCacheEntry");
  }
}
