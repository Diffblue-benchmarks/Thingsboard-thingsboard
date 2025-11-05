package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import kotlin.KotlinNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResourceUtilsDiffblueTest {
  /**
   * Test {@link ResourceUtils#getInputStream(Object, String)} with {@code classLoaderSource},
   * {@code filePath}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getInputStream(Object, String)}
   */
  @Test
  @DisplayName(
      "Test getInputStream(Object, String) with 'classLoaderSource', 'filePath'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream ResourceUtils.getInputStream(Object, String)"})
  void testGetInputStreamWithClassLoaderSourceFilePath_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ResourceUtils.getInputStream(new KotlinNullPointerException(), "/directory/foo.txt"));
  }

  /**
   * Test {@link ResourceUtils#getInputStream(Object, String)} with {@code classLoaderSource},
   * {@code filePath}.
   *
   * <ul>
   *   <li>When {@code Class Loader Source}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getInputStream(Object, String)}
   */
  @Test
  @DisplayName(
      "Test getInputStream(Object, String) with 'classLoaderSource', 'filePath'; when 'Class Loader Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream ResourceUtils.getInputStream(Object, String)"})
  void testGetInputStreamWithClassLoaderSourceFilePath_whenClassLoaderSource() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ResourceUtils.getInputStream("Class Loader Source", "/directory/foo.txt"));
  }

  /**
   * Test {@link ResourceUtils#getInputStream(Object, String)} with {@code classLoaderSource},
   * {@code filePath}.
   *
   * <ul>
   *   <li>When {@code Class Loader Source}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getInputStream(Object, String)}
   */
  @Test
  @DisplayName(
      "Test getInputStream(Object, String) with 'classLoaderSource', 'filePath'; when 'Class Loader Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream ResourceUtils.getInputStream(Object, String)"})
  void testGetInputStreamWithClassLoaderSourceFilePath_whenClassLoaderSource2() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ResourceUtils.getInputStream(
                "Class Loader Source", ResourceUtils.CLASSPATH_URL_PREFIX));
  }

  /**
   * Test {@link ResourceUtils#getUri(Object, String)} with {@code classLoaderSource}, {@code
   * filePath}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getUri(Object, String)}
   */
  @Test
  @DisplayName(
      "Test getUri(Object, String) with 'classLoaderSource', 'filePath'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceUtils.getUri(Object, String)"})
  void testGetUriWithClassLoaderSourceFilePath_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ResourceUtils.getUri(new KotlinNullPointerException(), "/directory/foo.txt"));
  }

  /**
   * Test {@link ResourceUtils#getUri(Object, String)} with {@code classLoaderSource}, {@code
   * filePath}.
   *
   * <ul>
   *   <li>When {@code Class Loader Source}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getUri(Object, String)}
   */
  @Test
  @DisplayName(
      "Test getUri(Object, String) with 'classLoaderSource', 'filePath'; when 'Class Loader Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceUtils.getUri(Object, String)"})
  void testGetUriWithClassLoaderSourceFilePath_whenClassLoaderSource() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ResourceUtils.getUri("Class Loader Source", "/directory/foo.txt"));
  }
}
