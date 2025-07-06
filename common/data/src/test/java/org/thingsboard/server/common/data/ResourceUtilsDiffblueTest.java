package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Predicate;
import javax.management.loading.MLet;
import kotlin.KotlinNullPointerException;
import net.bytebuddy.dynamic.loading.MultipleParentClassLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.FilteredClassLoader;

class ResourceUtilsDiffblueTest {
  /**
   * Test {@link ResourceUtils#resourceExists(ClassLoader, String)} with {@code classLoader}, {@code
   * filePath}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#resourceExists(ClassLoader, String)}
   */
  @Test
  @DisplayName(
      "Test resourceExists(ClassLoader, String) with 'classLoader', 'filePath'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceUtils.resourceExists(ClassLoader, String)"})
  void testResourceExistsWithClassLoaderFilePath_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ResourceUtils.resourceExists(new MLet(), ResourceUtils.CLASSPATH_URL_PREFIX));
  }

  /**
   * Test {@link ResourceUtils#resourceExists(ClassLoader, String)} with {@code classLoader}, {@code
   * filePath}.
   *
   * <ul>
   *   <li>When {@code /directory/foo.txt}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#resourceExists(ClassLoader, String)}
   */
  @Test
  @DisplayName(
      "Test resourceExists(ClassLoader, String) with 'classLoader', 'filePath'; when '/directory/foo.txt'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceUtils.resourceExists(ClassLoader, String)"})
  void testResourceExistsWithClassLoaderFilePath_whenDirectoryFooTxt_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ResourceUtils.resourceExists(new MLet(), "/directory/foo.txt"));
  }

  /**
   * Test {@link ResourceUtils#getInputStream(ClassLoader, String)} with {@code classLoader}, {@code
   * filePath}.
   *
   * <p>Method under test: {@link ResourceUtils#getInputStream(ClassLoader, String)}
   */
  @Test
  @DisplayName("Test getInputStream(ClassLoader, String) with 'classLoader', 'filePath'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream ResourceUtils.getInputStream(ClassLoader, String)"})
  void testGetInputStreamWithClassLoaderFilePath() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ResourceUtils.getInputStream(
                new MultipleParentClassLoader(new ArrayList<>()),
                DataConstants.DEFAULT_SECRET_KEY));
  }

  /**
   * Test {@link ResourceUtils#getInputStream(ClassLoader, String)} with {@code classLoader}, {@code
   * filePath}.
   *
   * <ul>
   *   <li>Then return read is {@link StringUtils#INDEX_NOT_FOUND}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getInputStream(ClassLoader, String)}
   */
  @Test
  @DisplayName(
      "Test getInputStream(ClassLoader, String) with 'classLoader', 'filePath'; then return read is INDEX_NOT_FOUND")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream ResourceUtils.getInputStream(ClassLoader, String)"})
  void testGetInputStreamWithClassLoaderFilePath_thenReturnReadIsIndex_not_found()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        StringUtils.INDEX_NOT_FOUND,
        ResourceUtils.getInputStream(new MLet(), ResourceUtils.CLASSPATH_URL_PREFIX)
            .read(new byte[] {}));
  }

  /**
   * Test {@link ResourceUtils#getInputStream(ClassLoader, String)} with {@code classLoader}, {@code
   * filePath}.
   *
   * <ul>
   *   <li>When {@code /directory/foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getInputStream(ClassLoader, String)}
   */
  @Test
  @DisplayName(
      "Test getInputStream(ClassLoader, String) with 'classLoader', 'filePath'; when '/directory/foo.txt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream ResourceUtils.getInputStream(ClassLoader, String)"})
  void testGetInputStreamWithClassLoaderFilePath_whenDirectoryFooTxt() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ResourceUtils.getInputStream(new MLet(), "/directory/foo.txt"));
  }

  /**
   * Test {@link ResourceUtils#getInputStream(ClassLoader, String)} with {@code classLoader}, {@code
   * filePath}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getInputStream(ClassLoader, String)}
   */
  @Test
  @DisplayName(
      "Test getInputStream(ClassLoader, String) with 'classLoader', 'filePath'; when 'null'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream ResourceUtils.getInputStream(ClassLoader, String)"})
  void testGetInputStreamWithClassLoaderFilePath_whenNull_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ResourceUtils.getInputStream((ClassLoader) null, "/directory/foo.txt"));
  }

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
   * Test {@link ResourceUtils#getUri(ClassLoader, String)} with {@code classLoader}, {@code
   * filePath}.
   *
   * <ul>
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getUri(ClassLoader, String)}
   */
  @Test
  @DisplayName(
      "Test getUri(ClassLoader, String) with 'classLoader', 'filePath'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceUtils.getUri(ClassLoader, String)"})
  void testGetUriWithClassLoaderFilePath_thenCallsTest() {
    // Arrange
    Predicate<String> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ResourceUtils.getUri(
                new FilteredClassLoader(predicate), DataConstants.DEFAULT_SECRET_KEY));
    verify(predicate).test(eq(""));
  }

  /**
   * Test {@link ResourceUtils#getUri(ClassLoader, String)} with {@code classLoader}, {@code
   * filePath}.
   *
   * <ul>
   *   <li>When {@link MLet#MLet()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getUri(ClassLoader, String)}
   */
  @Test
  @DisplayName(
      "Test getUri(ClassLoader, String) with 'classLoader', 'filePath'; when MLet(); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceUtils.getUri(ClassLoader, String)"})
  void testGetUriWithClassLoaderFilePath_whenMLet_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "jar:file:/C:/Users/sdodd/.m2/repository/net/bytebuddy/byte-buddy-agent/1.15.3/byte-buddy-agent-1.15.3"
            + ".jar!/META-INF/versions/9/",
        ResourceUtils.getUri(new MLet(), DataConstants.DEFAULT_SECRET_KEY));
  }

  /**
   * Test {@link ResourceUtils#getUri(ClassLoader, String)} with {@code classLoader}, {@code
   * filePath}.
   *
   * <ul>
   *   <li>When {@link MLet#MLet()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getUri(ClassLoader, String)}
   */
  @Test
  @DisplayName(
      "Test getUri(ClassLoader, String) with 'classLoader', 'filePath'; when MLet(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceUtils.getUri(ClassLoader, String)"})
  void testGetUriWithClassLoaderFilePath_whenMLet_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> ResourceUtils.getUri(new MLet(), "/directory/foo.txt"));
  }

  /**
   * Test {@link ResourceUtils#getUri(ClassLoader, String)} with {@code classLoader}, {@code
   * filePath}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getUri(ClassLoader, String)}
   */
  @Test
  @DisplayName(
      "Test getUri(ClassLoader, String) with 'classLoader', 'filePath'; when 'null'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ResourceUtils.getUri(ClassLoader, String)"})
  void testGetUriWithClassLoaderFilePath_whenNull_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ResourceUtils.getUri((ClassLoader) null, "/directory/foo.txt"));
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
