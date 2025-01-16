package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;
import java.nio.file.Paths;
import javax.management.loading.MLet;
import kotlin.KotlinNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ResourceUtilsDiffblueTest {
  /**
   * Test {@link ResourceUtils#resourceExists(ClassLoader, String)} with
   * {@code classLoader}, {@code filePath}.
   * <ul>
   *   <li>Then calls
   * {@link URLStreamHandlerFactory#createURLStreamHandler(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceUtils#resourceExists(ClassLoader, String)}
   */
  @Test
  @DisplayName("Test resourceExists(ClassLoader, String) with 'classLoader', 'filePath'; then calls createURLStreamHandler(String)")
  void testResourceExistsWithClassLoaderFilePath_thenCallsCreateURLStreamHandler() throws MalformedURLException {
    // Arrange
    URLStreamHandlerFactory urlStreamHandlerFactory = mock(URLStreamHandlerFactory.class);
    when(urlStreamHandlerFactory.createURLStreamHandler(Mockito.<String>any())).thenReturn(null);

    // Act
    boolean actualResourceExistsResult = ResourceUtils.resourceExists(
        new URLClassLoader(new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()},
            new MLet(), urlStreamHandlerFactory),
        "/directory/foo.txt");

    // Assert
    verify(urlStreamHandlerFactory).createURLStreamHandler(eq("jar"));
    assertFalse(actualResourceExistsResult);
  }

  /**
   * Test {@link ResourceUtils#resourceExists(ClassLoader, String)} with
   * {@code classLoader}, {@code filePath}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceUtils#resourceExists(ClassLoader, String)}
   */
  @Test
  @DisplayName("Test resourceExists(ClassLoader, String) with 'classLoader', 'filePath'; then return 'true'")
  void testResourceExistsWithClassLoaderFilePath_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ResourceUtils.resourceExists(new MLet(), ResourceUtils.CLASSPATH_URL_PREFIX));
  }

  /**
   * Test {@link ResourceUtils#resourceExists(ClassLoader, String)} with
   * {@code classLoader}, {@code filePath}.
   * <ul>
   *   <li>When {@link MLet#MLet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceUtils#resourceExists(ClassLoader, String)}
   */
  @Test
  @DisplayName("Test resourceExists(ClassLoader, String) with 'classLoader', 'filePath'; when MLet(); then return 'false'")
  void testResourceExistsWithClassLoaderFilePath_whenMLet_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ResourceUtils.resourceExists(new MLet(), "/directory/foo.txt"));
  }

  /**
   * Test {@link ResourceUtils#getInputStream(ClassLoader, String)} with
   * {@code classLoader}, {@code filePath}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceUtils#getInputStream(ClassLoader, String)}
   */
  @Test
  @DisplayName("Test getInputStream(ClassLoader, String) with 'classLoader', 'filePath'; then throw RuntimeException")
  void testGetInputStreamWithClassLoaderFilePath_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ResourceUtils.getInputStream(new MLet(), "/directory/foo.txt"));
    assertThrows(RuntimeException.class, () -> ResourceUtils.getInputStream((ClassLoader) null, "/directory/foo.txt"));
  }

  /**
   * Test {@link ResourceUtils#getInputStream(Object, String)} with
   * {@code classLoaderSource}, {@code filePath}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceUtils#getInputStream(Object, String)}
   */
  @Test
  @DisplayName("Test getInputStream(Object, String) with 'classLoaderSource', 'filePath'; then throw RuntimeException")
  void testGetInputStreamWithClassLoaderSourceFilePath_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ResourceUtils.getInputStream(new KotlinNullPointerException("An error occurred"), "/directory/foo.txt"));
  }

  /**
   * Test {@link ResourceUtils#getInputStream(Object, String)} with
   * {@code classLoaderSource}, {@code filePath}.
   * <ul>
   *   <li>When {@code Class Loader Source}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceUtils#getInputStream(Object, String)}
   */
  @Test
  @DisplayName("Test getInputStream(Object, String) with 'classLoaderSource', 'filePath'; when 'Class Loader Source'")
  void testGetInputStreamWithClassLoaderSourceFilePath_whenClassLoaderSource() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ResourceUtils.getInputStream("Class Loader Source", "/directory/foo.txt"));
    assertThrows(RuntimeException.class,
        () -> ResourceUtils.getInputStream("Class Loader Source", ResourceUtils.CLASSPATH_URL_PREFIX));
  }

  /**
   * Test {@link ResourceUtils#getUri(ClassLoader, String)} with
   * {@code classLoader}, {@code filePath}.
   * <ul>
   *   <li>When {@link MLet#MLet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceUtils#getUri(ClassLoader, String)}
   */
  @Test
  @DisplayName("Test getUri(ClassLoader, String) with 'classLoader', 'filePath'; when MLet()")
  void testGetUriWithClassLoaderFilePath_whenMLet() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ResourceUtils.getUri(new MLet(), "/directory/foo.txt"));
  }

  /**
   * Test {@link ResourceUtils#getUri(ClassLoader, String)} with
   * {@code classLoader}, {@code filePath}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceUtils#getUri(ClassLoader, String)}
   */
  @Test
  @DisplayName("Test getUri(ClassLoader, String) with 'classLoader', 'filePath'; when 'null'")
  void testGetUriWithClassLoaderFilePath_whenNull() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ResourceUtils.getUri((ClassLoader) null, "/directory/foo.txt"));
  }

  /**
   * Test {@link ResourceUtils#getUri(Object, String)} with
   * {@code classLoaderSource}, {@code filePath}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceUtils#getUri(Object, String)}
   */
  @Test
  @DisplayName("Test getUri(Object, String) with 'classLoaderSource', 'filePath'; then throw RuntimeException")
  void testGetUriWithClassLoaderSourceFilePath_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ResourceUtils.getUri(new KotlinNullPointerException("An error occurred"), "/directory/foo.txt"));
  }

  /**
   * Test {@link ResourceUtils#getUri(Object, String)} with
   * {@code classLoaderSource}, {@code filePath}.
   * <ul>
   *   <li>When {@code Class Loader Source}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceUtils#getUri(Object, String)}
   */
  @Test
  @DisplayName("Test getUri(Object, String) with 'classLoaderSource', 'filePath'; when 'Class Loader Source'")
  void testGetUriWithClassLoaderSourceFilePath_whenClassLoaderSource() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ResourceUtils.getUri("Class Loader Source", "/directory/foo.txt"));
  }
}
