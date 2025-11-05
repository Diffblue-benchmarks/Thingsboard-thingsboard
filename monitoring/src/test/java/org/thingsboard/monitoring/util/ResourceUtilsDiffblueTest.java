package org.thingsboard.monitoring.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResourceUtilsDiffblueTest {
  /**
   * Test {@link ResourceUtils#getResource(String, Class)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getResource(String, Class)}
   */
  @Test
  @DisplayName("Test getResource(String, Class); when 'Path'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ResourceUtils.getResource(String, Class)"})
  void testGetResource_whenPath_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ResourceUtils.getResource("Path", type));
  }

  /**
   * Test {@link ResourceUtils#getResourceAsStream(String)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getResourceAsStream(String)}
   */
  @Test
  @DisplayName("Test getResourceAsStream(String); when 'Path'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream ResourceUtils.getResourceAsStream(String)"})
  void testGetResourceAsStream_whenPath_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ResourceUtils.getResourceAsStream("Path"));
  }
}
