package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
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
   *   <li>Then return read is {@link StringUtils#INDEX_NOT_FOUND}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getInputStream(Object, String)}
   */
  @Test
  @DisplayName(
      "Test getInputStream(Object, String) with 'classLoaderSource', 'filePath'; then return read is INDEX_NOT_FOUND")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream ResourceUtils.getInputStream(Object, String)"})
  void testGetInputStreamWithClassLoaderSourceFilePath_thenReturnReadIsIndex_not_found()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        StringUtils.INDEX_NOT_FOUND,
        ResourceUtils.getInputStream(
                new KotlinNullPointerException("An error occurred"),
                ResourceUtils.CLASSPATH_URL_PREFIX)
            .read(new byte[] {}));
  }

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream ResourceUtils.getInputStream(Object, String)"})
  void testGetInputStreamWithClassLoaderSourceFilePath_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ResourceUtils.getInputStream(
                new KotlinNullPointerException("An error occurred"), "/directory/foo.txt"));
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceUtils.getUri(Object, String)"})
  void testGetUriWithClassLoaderSourceFilePath_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ResourceUtils.getUri(
                new KotlinNullPointerException("An error occurred"), "/directory/foo.txt"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceUtils.getUri(Object, String)"})
  void testGetUriWithClassLoaderSourceFilePath_whenClassLoaderSource() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ResourceUtils.getUri("Class Loader Source", "/directory/foo.txt"));
  }

  /**
   * Test {@link ResourceUtils#getUri(Object, String)} with {@code classLoaderSource}, {@code
   * filePath}.
   *
   * <ul>
   *   <li>When {@link DataConstants#DEFAULT_SECRET_KEY}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getUri(Object, String)}
   */
  @Test
  @DisplayName(
      "Test getUri(Object, String) with 'classLoaderSource', 'filePath'; when DEFAULT_SECRET_KEY; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceUtils.getUri(Object, String)"})
  void testGetUriWithClassLoaderSourceFilePath_whenDefault_secret_key_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "jar:file:/C:/Users/sdodd/.m2/repository/net/bytebuddy/byte-buddy-agent/1.15.3/byte-buddy-agent-1.15.3"
            + ".jar!/META-INF/versions/9/",
        ResourceUtils.getUri(
            new KotlinNullPointerException("An error occurred"), DataConstants.DEFAULT_SECRET_KEY));
  }
}
