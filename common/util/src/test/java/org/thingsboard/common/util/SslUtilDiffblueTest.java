package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.cert.X509Certificate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SslUtilDiffblueTest {
  /**
   * Test {@link SslUtil#readCertFile(String)} with {@code fileContent}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName(
      "Test readCertFile(String) with 'fileContent'; when 'Not all who wander are lost'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SslUtil.readCertFile(String)"})
  void testReadCertFileWithFileContent_whenNotAllWhoWanderAreLost_thenReturnEmpty() {
    // Arrange and Act
    List<X509Certificate> actualReadCertFileResult =
        SslUtil.readCertFile("Not all who wander are lost");

    // Assert
    assertTrue(actualReadCertFileResult.isEmpty());
  }

  /**
   * Test {@link SslUtil#readPrivateKey(String, String)} with {@code fileContent}, {@code passStr}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link SslUtil#readPrivateKey(String, String)}
   */
  @Test
  @DisplayName(
      "Test readPrivateKey(String, String) with 'fileContent', 'passStr'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey SslUtil.readPrivateKey(String, String)"})
  void testReadPrivateKeyWithFileContentPassStr_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKey("", ""));
  }

  /**
   * Test {@link SslUtil#readPrivateKey(String, String)} with {@code fileContent}, {@code passStr}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link SslUtil#readPrivateKey(String, String)}
   */
  @Test
  @DisplayName(
      "Test readPrivateKey(String, String) with 'fileContent', 'passStr'; when 'Not all who wander are lost'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey SslUtil.readPrivateKey(String, String)"})
  void testReadPrivateKeyWithFileContentPassStr_whenNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKey("Not all who wander are lost", "Pass Str"));
  }

  /**
   * Test {@link SslUtil#readPrivateKey(String, String)} with {@code fileContent}, {@code passStr}.
   *
   * <ul>
   *   <li>When {@code not empty}.
   * </ul>
   *
   * <p>Method under test: {@link SslUtil#readPrivateKey(String, String)}
   */
  @Test
  @DisplayName(
      "Test readPrivateKey(String, String) with 'fileContent', 'passStr'; when 'not empty'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey SslUtil.readPrivateKey(String, String)"})
  void testReadPrivateKeyWithFileContentPassStr_whenNotEmpty() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKey("not empty", ""));
  }

  /**
   * Test {@link SslUtil#readPrivateKey(String, String)} with {@code fileContent}, {@code passStr}.
   *
   * <ul>
   *   <li>When {@code not empty}.
   * </ul>
   *
   * <p>Method under test: {@link SslUtil#readPrivateKey(String, String)}
   */
  @Test
  @DisplayName(
      "Test readPrivateKey(String, String) with 'fileContent', 'passStr'; when 'not empty'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey SslUtil.readPrivateKey(String, String)"})
  void testReadPrivateKeyWithFileContentPassStr_whenNotEmpty2() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKey("not empty", null));
  }

  /**
   * Test {@link SslUtil#readPrivateKey(String, String)} with {@code fileContent}, {@code passStr}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SslUtil#readPrivateKey(String, String)}
   */
  @Test
  @DisplayName("Test readPrivateKey(String, String) with 'fileContent', 'passStr'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey SslUtil.readPrivateKey(String, String)"})
  void testReadPrivateKeyWithFileContentPassStr_whenNull() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKey(null, ""));
  }

  /**
   * Test {@link SslUtil#readPrivateKeyByFilePath(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SslUtil#readPrivateKeyByFilePath(String, String)}
   */
  @Test
  @DisplayName(
      "Test readPrivateKeyByFilePath(String, String); when empty string; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey SslUtil.readPrivateKeyByFilePath(String, String)"})
  void testReadPrivateKeyByFilePath_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKeyByFilePath("", ""));
  }

  /**
   * Test {@link SslUtil#readPrivateKeyByFilePath(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SslUtil#readPrivateKeyByFilePath(String, String)}
   */
  @Test
  @DisplayName("Test readPrivateKeyByFilePath(String, String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey SslUtil.readPrivateKeyByFilePath(String, String)"})
  void testReadPrivateKeyByFilePath_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKeyByFilePath(null, ""));
  }

  /**
   * Test {@link SslUtil#getPassword(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty array of {@code char}.
   * </ul>
   *
   * <p>Method under test: {@link SslUtil#getPassword(String)}
   */
  @Test
  @DisplayName("Test getPassword(String); when empty string; then return empty array of char")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char[] SslUtil.getPassword(String)"})
  void testGetPassword_whenEmptyString_thenReturnEmptyArrayOfChar() {
    // Arrange, Act and Assert
    assertArrayEquals(new char[] {}, SslUtil.getPassword(""));
  }

  /**
   * Test {@link SslUtil#getPassword(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty array of {@code char}.
   * </ul>
   *
   * <p>Method under test: {@link SslUtil#getPassword(String)}
   */
  @Test
  @DisplayName("Test getPassword(String); when 'null'; then return empty array of char")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char[] SslUtil.getPassword(String)"})
  void testGetPassword_whenNull_thenReturnEmptyArrayOfChar() {
    // Arrange, Act and Assert
    assertArrayEquals(new char[] {}, SslUtil.getPassword(null));
  }

  /**
   * Test {@link SslUtil#getPassword(String)}.
   *
   * <ul>
   *   <li>When {@code Pass Str}.
   *   <li>Then return {@code Pass Str} toCharArray.
   * </ul>
   *
   * <p>Method under test: {@link SslUtil#getPassword(String)}
   */
  @Test
  @DisplayName("Test getPassword(String); when 'Pass Str'; then return 'Pass Str' toCharArray")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char[] SslUtil.getPassword(String)"})
  void testGetPassword_whenPassStr_thenReturnPassStrToCharArray() {
    // Arrange and Act
    char[] actualPassword = SslUtil.getPassword("Pass Str");

    // Assert
    assertArrayEquals("Pass Str".toCharArray(), actualPassword);
  }
}
