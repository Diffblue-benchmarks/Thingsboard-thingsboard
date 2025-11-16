/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"char[] SslUtil.getPassword(String)"})
  void testGetPassword_whenPassStr_thenReturnPassStrToCharArray() {
    // Arrange and Act
    char[] actualPassword = SslUtil.getPassword("Pass Str");

    // Assert
    assertArrayEquals("Pass Str".toCharArray(), actualPassword);
  }
}
