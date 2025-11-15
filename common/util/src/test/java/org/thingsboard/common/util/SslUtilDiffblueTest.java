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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.security.cert.X509Certificate;
import java.util.List;
import org.junit.jupiter.api.Test;

class SslUtilDiffblueTest {
  /**
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  void testReadCertFile() {
    // Arrange and Act
    List<X509Certificate> actualReadCertFileResult = SslUtil.readCertFile("Not all who wander are lost");

    // Assert
    assertTrue(actualReadCertFileResult.isEmpty());
  }

  /**
   * Method under test: {@link SslUtil#readPrivateKey(String, String)}
   */
  @Test
  void testReadPrivateKey() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKey("Not all who wander are lost", "Pass Str"));
    assertNull(SslUtil.readPrivateKey(null, null));
    assertNull(SslUtil.readPrivateKey("", null));
    assertNull(SslUtil.readPrivateKey("Not all who wander are lost", null));
    assertNull(SslUtil.readPrivateKey("Not all who wander are lost", ""));
  }

  /**
   * Method under test: {@link SslUtil#readPrivateKeyByFilePath(String, String)}
   */
  @Test
  void testReadPrivateKeyByFilePath() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readPrivateKeyByFilePath(null, null));
    assertNull(SslUtil.readPrivateKeyByFilePath("", null));
  }

  /**
   * Method under test: {@link SslUtil#getPassword(String)}
   */
  @Test
  void testGetPassword() {
    // Arrange and Act
    char[] actualPassword = SslUtil.getPassword("Pass Str");

    // Assert
    assertArrayEquals("Pass Str".toCharArray(), actualPassword);
  }

  /**
   * Method under test: {@link SslUtil#getPassword(String)}
   */
  @Test
  void testGetPassword2() {
    // Arrange, Act and Assert
    assertEquals(0, SslUtil.getPassword(null).length);
  }

  /**
   * Method under test: {@link SslUtil#getPassword(String)}
   */
  @Test
  void testGetPassword3() {
    // Arrange, Act and Assert
    assertEquals(0, SslUtil.getPassword("").length);
  }
}
