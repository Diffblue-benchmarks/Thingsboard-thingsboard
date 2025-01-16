package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.security.cert.X509Certificate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SslUtilDiffblueTest {
  /**
   * Test {@link SslUtil#readCertFile(String)} with {@code fileContent}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String) with 'fileContent'; when 'Not all who wander are lost'; then return Empty")
  void testReadCertFileWithFileContent_whenNotAllWhoWanderAreLost_thenReturnEmpty() {
    // Arrange and Act
    List<X509Certificate> actualReadCertFileResult = SslUtil.readCertFile("Not all who wander are lost");

    // Assert
    assertTrue(actualReadCertFileResult.isEmpty());
  }

  /**
   * Test {@link SslUtil#readPrivateKey(String, String)} with {@code fileContent},
   * {@code passStr}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readPrivateKey(String, String)}
   */
  @Test
  @DisplayName("Test readPrivateKey(String, String) with 'fileContent', 'passStr'; when empty string")
  void testReadPrivateKeyWithFileContentPassStr_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKey("", null));
    assertNull(SslUtil.readPrivateKey("Not all who wander are lost", ""));
  }

  /**
   * Test {@link SslUtil#readPrivateKey(String, String)} with {@code fileContent},
   * {@code passStr}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readPrivateKey(String, String)}
   */
  @Test
  @DisplayName("Test readPrivateKey(String, String) with 'fileContent', 'passStr'; when 'Not all who wander are lost'")
  void testReadPrivateKeyWithFileContentPassStr_whenNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKey("Not all who wander are lost", null));
  }

  /**
   * Test {@link SslUtil#readPrivateKey(String, String)} with {@code fileContent},
   * {@code passStr}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readPrivateKey(String, String)}
   */
  @Test
  @DisplayName("Test readPrivateKey(String, String) with 'fileContent', 'passStr'; when 'null'")
  void testReadPrivateKeyWithFileContentPassStr_whenNull() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKey(null, null));
  }

  /**
   * Test {@link SslUtil#readPrivateKey(String, String)} with {@code fileContent},
   * {@code passStr}.
   * <ul>
   *   <li>When {@code Pass Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readPrivateKey(String, String)}
   */
  @Test
  @DisplayName("Test readPrivateKey(String, String) with 'fileContent', 'passStr'; when 'Pass Str'")
  void testReadPrivateKeyWithFileContentPassStr_whenPassStr() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKey("Not all who wander are lost", "Pass Str"));
  }

  /**
   * Test {@link SslUtil#readPrivateKeyByFilePath(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readPrivateKeyByFilePath(String, String)}
   */
  @Test
  @DisplayName("Test readPrivateKeyByFilePath(String, String); when empty string; then return 'null'")
  void testReadPrivateKeyByFilePath_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKeyByFilePath("", null));
  }

  /**
   * Test {@link SslUtil#readPrivateKeyByFilePath(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readPrivateKeyByFilePath(String, String)}
   */
  @Test
  @DisplayName("Test readPrivateKeyByFilePath(String, String); when 'null'; then return 'null'")
  void testReadPrivateKeyByFilePath_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKeyByFilePath(null, null));
  }

  /**
   * Test {@link SslUtil#getPassword(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#getPassword(String)}
   */
  @Test
  @DisplayName("Test getPassword(String); when empty string; then return array length is zero")
  void testGetPassword_whenEmptyString_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, SslUtil.getPassword("").length);
  }

  /**
   * Test {@link SslUtil#getPassword(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#getPassword(String)}
   */
  @Test
  @DisplayName("Test getPassword(String); when 'null'; then return array length is zero")
  void testGetPassword_whenNull_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, SslUtil.getPassword(null).length);
  }

  /**
   * Test {@link SslUtil#getPassword(String)}.
   * <ul>
   *   <li>When {@code Pass Str}.</li>
   *   <li>Then return {@code Pass Str} toCharArray.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#getPassword(String)}
   */
  @Test
  @DisplayName("Test getPassword(String); when 'Pass Str'; then return 'Pass Str' toCharArray")
  void testGetPassword_whenPassStr_thenReturnPassStrToCharArray() {
    // Arrange and Act
    char[] actualPassword = SslUtil.getPassword("Pass Str");

    // Assert
    assertArrayEquals("Pass Str".toCharArray(), actualPassword);
  }
}
