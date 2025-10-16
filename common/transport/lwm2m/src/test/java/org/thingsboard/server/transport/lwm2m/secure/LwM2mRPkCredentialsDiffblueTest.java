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
package org.thingsboard.server.transport.lwm2m.secure;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2mRPkCredentialsDiffblueTest {
  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code EC}.
   *   <li>Then return not ServerPrivateKey Destroyed.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'EC'; then return not ServerPrivateKey Destroyed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenEc_thenReturnNotServerPrivateKeyDestroyed() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials("EC", "EC", "EC");

    // Assert
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
    assertFalse(actualLwM2mRPkCredentials.getServerPrivateKey().isDestroyed());
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code EC}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'EC'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenEc_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new LwM2mRPkCredentials("EC", "Publ Y", "Priv S"));
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code EC}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'EC'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenEc_thenThrowRuntimeException2() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new LwM2mRPkCredentials("EC", "EC", "Priv S"));
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return ServerPrivateKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when empty string; then return ServerPrivateKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenEmptyString_thenReturnServerPrivateKeyIsNull() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials(null, null, "");

    // Assert
    assertNull(actualLwM2mRPkCredentials.getServerPrivateKey());
    assertNull(actualLwM2mRPkCredentials.getServerPublicKey());
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return ServerPrivateKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when empty string; then return ServerPrivateKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenEmptyString_thenReturnServerPrivateKeyIsNull2() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials("", null, null);

    // Assert
    assertNull(actualLwM2mRPkCredentials.getServerPrivateKey());
    assertNull(actualLwM2mRPkCredentials.getServerPublicKey());
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ServerPrivateKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'null'; then return ServerPrivateKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenNull_thenReturnServerPrivateKeyIsNull() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials(null, null, null);

    // Assert
    assertNull(actualLwM2mRPkCredentials.getServerPrivateKey());
    assertNull(actualLwM2mRPkCredentials.getServerPublicKey());
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Priv S}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'Priv S'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenPrivS_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new LwM2mRPkCredentials(null, null, "Priv S"));
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Publ X}.
   *   <li>Then return ServerPrivateKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'Publ X'; then return ServerPrivateKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenPublX_thenReturnServerPrivateKeyIsNull() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials("Publ X", null, null);

    // Assert
    assertNull(actualLwM2mRPkCredentials.getServerPrivateKey());
    assertNull(actualLwM2mRPkCredentials.getServerPublicKey());
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Publ X}.
   *   <li>Then return ServerPrivateKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'Publ X'; then return ServerPrivateKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenPublX_thenReturnServerPrivateKeyIsNull2() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials("Publ X", "", null);

    // Assert
    assertNull(actualLwM2mRPkCredentials.getServerPrivateKey());
    assertNull(actualLwM2mRPkCredentials.getServerPublicKey());
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Publ X}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'Publ X'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenPublX_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> new LwM2mRPkCredentials("Publ X", "Publ Y", "Priv S"));
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code secp256r1}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'secp256r1'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenSecp256r1_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> new LwM2mRPkCredentials("secp256r1", "Publ Y", "Priv S"));
  }
}
