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
package org.thingsboard.server.common.transport.config.ssl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SslCredentialsConfigDiffblueTest {
  /**
   * Test {@link SslCredentialsConfig#equals(Object)}, and {@link SslCredentialsConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SslCredentialsConfig#equals(Object)}
   *   <li>{@link SslCredentialsConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);

    // Act and Assert
    assertEquals(sslCredentialsConfig, sslCredentialsConfig2);
    assertEquals(sslCredentialsConfig.hashCode(), sslCredentialsConfig2.hashCode());
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}, and {@link SslCredentialsConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SslCredentialsConfig#equals(Object)}
   *   <li>{@link SslCredentialsConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig(null, true);
    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig(null, true);

    // Act and Assert
    assertEquals(sslCredentialsConfig, sslCredentialsConfig2);
    assertEquals(sslCredentialsConfig.hashCode(), sslCredentialsConfig2.hashCode());
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}, and {@link SslCredentialsConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SslCredentialsConfig#equals(Object)}
   *   <li>{@link SslCredentialsConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setType(SslCredentialsType.PEM);

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setType(SslCredentialsType.PEM);

    // Act and Assert
    assertEquals(sslCredentialsConfig, sslCredentialsConfig2);
    assertEquals(sslCredentialsConfig.hashCode(), sslCredentialsConfig2.hashCode());
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}, and {@link SslCredentialsConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SslCredentialsConfig#equals(Object)}
   *   <li>{@link SslCredentialsConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setPem(new PemSslCredentials());

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setPem(new PemSslCredentials());

    // Act and Assert
    assertEquals(sslCredentialsConfig, sslCredentialsConfig2);
    assertEquals(sslCredentialsConfig.hashCode(), sslCredentialsConfig2.hashCode());
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}, and {@link SslCredentialsConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SslCredentialsConfig#equals(Object)}
   *   <li>{@link SslCredentialsConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(new KeystoreSslCredentials());

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setKeystore(new KeystoreSslCredentials());

    // Act and Assert
    assertEquals(sslCredentialsConfig, sslCredentialsConfig2);
    assertEquals(sslCredentialsConfig.hashCode(), sslCredentialsConfig2.hashCode());
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}, and {@link SslCredentialsConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SslCredentialsConfig#equals(Object)}
   *   <li>{@link SslCredentialsConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setCredentials(new KeystoreSslCredentials());

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setCredentials(new KeystoreSslCredentials());

    // Act and Assert
    assertEquals(sslCredentialsConfig, sslCredentialsConfig2);
    assertEquals(sslCredentialsConfig.hashCode(), sslCredentialsConfig2.hashCode());
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}, and {@link SslCredentialsConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SslCredentialsConfig#equals(Object)}
   *   <li>{@link SslCredentialsConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);

    // Act and Assert
    assertEquals(sslCredentialsConfig, sslCredentialsConfig);
    int expectedHashCodeResult = sslCredentialsConfig.hashCode();
    assertEquals(expectedHashCodeResult, sslCredentialsConfig.hashCode());
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig(null, true);

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig =
        new SslCredentialsConfig(
            "org.thingsboard.server.common.transport.config.ssl.SslCredentialsConfig", true);

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", false);

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setType(SslCredentialsType.PEM);

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setPem(new PemSslCredentials());

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(new KeystoreSslCredentials());

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setCredentials(new KeystoreSslCredentials());

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, new SslCredentialsConfig("Name", true));
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setType(SslCredentialsType.PEM);

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, sslCredentialsConfig2);
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setPem(new PemSslCredentials());

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, sslCredentialsConfig2);
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setKeystore(new KeystoreSslCredentials());

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, sslCredentialsConfig2);
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setCredentials(new KeystoreSslCredentials());

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, sslCredentialsConfig2);
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setEnabled(false);
    sslCredentialsConfig.setPem(new PemSslCredentials());

    PemSslCredentials pem = mock(PemSslCredentials.class);
    when(pem.canEqual(Mockito.<Object>any())).thenThrow(new RuntimeException());

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setPem(pem);

    // Act and Assert
    assertNotEquals(sslCredentialsConfig, sslCredentialsConfig2);
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then throw exception.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then throw exception")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenThrowException() {
    // Arrange
    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setPem(new PemSslCredentials());

    PemSslCredentials pem = mock(PemSslCredentials.class);
    when(pem.canEqual(Mockito.<Object>any())).thenThrow(new RuntimeException());

    SslCredentialsConfig sslCredentialsConfig2 = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig2.setPem(pem);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sslCredentialsConfig.equals(sslCredentialsConfig2));
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SslCredentialsConfig("Name", true), null);
  }

  /**
   * Test {@link SslCredentialsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SslCredentialsConfig.equals(Object)",
    "int SslCredentialsConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new SslCredentialsConfig("Name", true), "Different type to SslCredentialsConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SslCredentialsConfig#SslCredentialsConfig(String, boolean)}
   *   <li>{@link SslCredentialsConfig#setCredentials(SslCredentials)}
   *   <li>{@link SslCredentialsConfig#setEnabled(boolean)}
   *   <li>{@link SslCredentialsConfig#setKeystore(KeystoreSslCredentials)}
   *   <li>{@link SslCredentialsConfig#setPem(PemSslCredentials)}
   *   <li>{@link SslCredentialsConfig#setType(SslCredentialsType)}
   *   <li>{@link SslCredentialsConfig#toString()}
   *   <li>{@link SslCredentialsConfig#getCredentials()}
   *   <li>{@link SslCredentialsConfig#getKeystore()}
   *   <li>{@link SslCredentialsConfig#getName()}
   *   <li>{@link SslCredentialsConfig#getPem()}
   *   <li>{@link SslCredentialsConfig#getType()}
   *   <li>{@link SslCredentialsConfig#isEnabled()}
   *   <li>{@link SslCredentialsConfig#isTrustsOnly()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SslCredentialsConfig.<init>(String, boolean)",
    "SslCredentials SslCredentialsConfig.getCredentials()",
    "KeystoreSslCredentials SslCredentialsConfig.getKeystore()",
    "String SslCredentialsConfig.getName()",
    "PemSslCredentials SslCredentialsConfig.getPem()",
    "SslCredentialsType SslCredentialsConfig.getType()",
    "boolean SslCredentialsConfig.isEnabled()",
    "boolean SslCredentialsConfig.isTrustsOnly()",
    "void SslCredentialsConfig.setCredentials(SslCredentials)",
    "void SslCredentialsConfig.setEnabled(boolean)",
    "void SslCredentialsConfig.setKeystore(KeystoreSslCredentials)",
    "void SslCredentialsConfig.setPem(PemSslCredentials)",
    "void SslCredentialsConfig.setType(SslCredentialsType)",
    "String SslCredentialsConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SslCredentialsConfig actualSslCredentialsConfig = new SslCredentialsConfig("Name", true);
    KeystoreSslCredentials credentials = new KeystoreSslCredentials();
    actualSslCredentialsConfig.setCredentials(credentials);
    actualSslCredentialsConfig.setEnabled(true);
    KeystoreSslCredentials keystore = new KeystoreSslCredentials();
    actualSslCredentialsConfig.setKeystore(keystore);
    PemSslCredentials pem = new PemSslCredentials();
    actualSslCredentialsConfig.setPem(pem);
    actualSslCredentialsConfig.setType(SslCredentialsType.PEM);
    String actualToStringResult = actualSslCredentialsConfig.toString();
    SslCredentials actualCredentials = actualSslCredentialsConfig.getCredentials();
    KeystoreSslCredentials actualKeystore = actualSslCredentialsConfig.getKeystore();
    String actualName = actualSslCredentialsConfig.getName();
    PemSslCredentials actualPem = actualSslCredentialsConfig.getPem();
    SslCredentialsType actualType = actualSslCredentialsConfig.getType();
    boolean actualIsEnabledResult = actualSslCredentialsConfig.isEnabled();

    // Assert
    assertEquals("Name", actualName);
    assertEquals(
        "SslCredentialsConfig(enabled=true, type=PEM, pem=PemSslCredentials(certFile=null, keyFile=null,"
            + " keyPassword=null), keystore=KeystoreSslCredentials(type=null, storeFile=null, storePassword=null,"
            + " keyPassword=null, keyAlias=null), credentials=KeystoreSslCredentials(type=null, storeFile=null,"
            + " storePassword=null, keyPassword=null, keyAlias=null), name=Name, trustsOnly=true)",
        actualToStringResult);
    assertEquals(SslCredentialsType.PEM, actualType);
    assertTrue(actualIsEnabledResult);
    assertTrue(actualSslCredentialsConfig.isTrustsOnly());
    assertSame(credentials, actualCredentials);
    assertSame(keystore, actualKeystore);
    assertSame(pem, actualPem);
  }

  /**
   * Test {@link SslCredentialsConfig#init()}.
   *
   * <ul>
   *   <li>Given {@link KeystoreSslCredentials} (default constructor) StoreFile is {@code
   *       classpath:}.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#init()}
   */
  @Test
  @DisplayName(
      "Test init(); given KeystoreSslCredentials (default constructor) StoreFile is 'classpath:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SslCredentialsConfig.init()"})
  void testInit_givenKeystoreSslCredentialsStoreFileIsClasspath() {
    // Arrange
    KeystoreSslCredentials keystore = new KeystoreSslCredentials();
    keystore.setStoreFile("classpath:");

    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(keystore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sslCredentialsConfig.init());
  }

  /**
   * Test {@link SslCredentialsConfig#init()}.
   *
   * <ul>
   *   <li>Given {@link KeystoreSslCredentials} (default constructor) StoreFile is empty string.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#init()}
   */
  @Test
  @DisplayName(
      "Test init(); given KeystoreSslCredentials (default constructor) StoreFile is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SslCredentialsConfig.init()"})
  void testInit_givenKeystoreSslCredentialsStoreFileIsEmptyString() {
    // Arrange
    KeystoreSslCredentials keystore = new KeystoreSslCredentials();
    keystore.setStoreFile("");

    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(keystore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sslCredentialsConfig.init());
  }

  /**
   * Test {@link SslCredentialsConfig#init()}.
   *
   * <ul>
   *   <li>Given {@link KeystoreSslCredentials} (default constructor) StoreFile is {@code {}:
   *       Initializing SSL credentials.}.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#init()}
   */
  @Test
  @DisplayName(
      "Test init(); given KeystoreSslCredentials (default constructor) StoreFile is '{}: Initializing SSL credentials.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SslCredentialsConfig.init()"})
  void testInit_givenKeystoreSslCredentialsStoreFileIsInitializingSslCredentials() {
    // Arrange
    KeystoreSslCredentials keystore = new KeystoreSslCredentials();
    keystore.setStoreFile("{}: Initializing SSL credentials.");

    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(keystore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sslCredentialsConfig.init());
  }

  /**
   * Test {@link SslCredentialsConfig#init()}.
   *
   * <ul>
   *   <li>Given {@link KeystoreSslCredentials} (default constructor) StorePassword is {@code
   *       iloveyou}.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#init()}
   */
  @Test
  @DisplayName(
      "Test init(); given KeystoreSslCredentials (default constructor) StorePassword is 'iloveyou'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SslCredentialsConfig.init()"})
  void testInit_givenKeystoreSslCredentialsStorePasswordIsIloveyou() {
    // Arrange
    KeystoreSslCredentials keystore = new KeystoreSslCredentials();
    keystore.setStorePassword("iloveyou");
    keystore.setStoreFile("classpath:");

    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(keystore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sslCredentialsConfig.init());
  }

  /**
   * Test {@link SslCredentialsConfig#init()}.
   *
   * <ul>
   *   <li>Given {@link KeystoreSslCredentials} (default constructor) Type is empty string.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#init()}
   */
  @Test
  @DisplayName(
      "Test init(); given KeystoreSslCredentials (default constructor) Type is empty string; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SslCredentialsConfig.init()"})
  void testInit_givenKeystoreSslCredentialsTypeIsEmptyString_thenThrowRuntimeException() {
    // Arrange
    KeystoreSslCredentials keystore = new KeystoreSslCredentials();
    keystore.setType("");
    keystore.setStoreFile("classpath:");

    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(keystore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sslCredentialsConfig.init());
  }

  /**
   * Test {@link SslCredentialsConfig#init()}.
   *
   * <ul>
   *   <li>Given {@link KeystoreSslCredentials} (default constructor) Type is {@code {}:
   *       Initializing SSL credentials.}.
   * </ul>
   *
   * <p>Method under test: {@link SslCredentialsConfig#init()}
   */
  @Test
  @DisplayName(
      "Test init(); given KeystoreSslCredentials (default constructor) Type is '{}: Initializing SSL credentials.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SslCredentialsConfig.init()"})
  void testInit_givenKeystoreSslCredentialsTypeIsInitializingSslCredentials() {
    // Arrange
    KeystoreSslCredentials keystore = new KeystoreSslCredentials();
    keystore.setType("{}: Initializing SSL credentials.");
    keystore.setStoreFile("classpath:");

    SslCredentialsConfig sslCredentialsConfig = new SslCredentialsConfig("Name", true);
    sslCredentialsConfig.setKeystore(keystore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sslCredentialsConfig.init());
  }
}
