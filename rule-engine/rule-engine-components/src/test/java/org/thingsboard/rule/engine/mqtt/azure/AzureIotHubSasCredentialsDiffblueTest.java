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
package org.thingsboard.rule.engine.mqtt.azure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.credentials.CredentialsType;

class AzureIotHubSasCredentialsDiffblueTest {
  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}, and {@link
   * AzureIotHubSasCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AzureIotHubSasCredentials#equals(Object)}
   *   <li>{@link AzureIotHubSasCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AzureIotHubSasCredentials.equals(Object)",
    "int AzureIotHubSasCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AzureIotHubSasCredentials azureIotHubSasCredentials = new AzureIotHubSasCredentials();
    AzureIotHubSasCredentials azureIotHubSasCredentials2 = new AzureIotHubSasCredentials();

    // Act and Assert
    assertEquals(azureIotHubSasCredentials, azureIotHubSasCredentials2);
    assertEquals(azureIotHubSasCredentials.hashCode(), azureIotHubSasCredentials2.hashCode());
  }

  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}, and {@link
   * AzureIotHubSasCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AzureIotHubSasCredentials#equals(Object)}
   *   <li>{@link AzureIotHubSasCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AzureIotHubSasCredentials.equals(Object)",
    "int AzureIotHubSasCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AzureIotHubSasCredentials azureIotHubSasCredentials = new AzureIotHubSasCredentials();
    azureIotHubSasCredentials.setSasKey("Sas Key");

    AzureIotHubSasCredentials azureIotHubSasCredentials2 = new AzureIotHubSasCredentials();
    azureIotHubSasCredentials2.setSasKey("Sas Key");

    // Act and Assert
    assertEquals(azureIotHubSasCredentials, azureIotHubSasCredentials2);
    assertEquals(azureIotHubSasCredentials.hashCode(), azureIotHubSasCredentials2.hashCode());
  }

  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}, and {@link
   * AzureIotHubSasCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AzureIotHubSasCredentials#equals(Object)}
   *   <li>{@link AzureIotHubSasCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AzureIotHubSasCredentials.equals(Object)",
    "int AzureIotHubSasCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AzureIotHubSasCredentials azureIotHubSasCredentials = new AzureIotHubSasCredentials();

    // Act and Assert
    assertEquals(azureIotHubSasCredentials, azureIotHubSasCredentials);
    int expectedHashCodeResult = azureIotHubSasCredentials.hashCode();
    assertEquals(expectedHashCodeResult, azureIotHubSasCredentials.hashCode());
  }

  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AzureIotHubSasCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AzureIotHubSasCredentials.equals(Object)",
    "int AzureIotHubSasCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AzureIotHubSasCredentials(), 1);
  }

  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AzureIotHubSasCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AzureIotHubSasCredentials.equals(Object)",
    "int AzureIotHubSasCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AzureIotHubSasCredentials azureIotHubSasCredentials = new AzureIotHubSasCredentials();
    azureIotHubSasCredentials.setSasKey("Sas Key");

    // Act and Assert
    assertNotEquals(azureIotHubSasCredentials, new AzureIotHubSasCredentials());
  }

  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AzureIotHubSasCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AzureIotHubSasCredentials.equals(Object)",
    "int AzureIotHubSasCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AzureIotHubSasCredentials azureIotHubSasCredentials = new AzureIotHubSasCredentials();

    AzureIotHubSasCredentials azureIotHubSasCredentials2 = new AzureIotHubSasCredentials();
    azureIotHubSasCredentials2.setSasKey("Sas Key");

    // Act and Assert
    assertNotEquals(azureIotHubSasCredentials, azureIotHubSasCredentials2);
  }

  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AzureIotHubSasCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AzureIotHubSasCredentials.equals(Object)",
    "int AzureIotHubSasCredentials.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AzureIotHubSasCredentials(), null);
  }

  /**
   * Test {@link AzureIotHubSasCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AzureIotHubSasCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AzureIotHubSasCredentials.equals(Object)",
    "int AzureIotHubSasCredentials.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AzureIotHubSasCredentials(), "Different type to AzureIotHubSasCredentials");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AzureIotHubSasCredentials}
   *   <li>{@link AzureIotHubSasCredentials#setSasKey(String)}
   *   <li>{@link AzureIotHubSasCredentials#toString()}
   *   <li>{@link AzureIotHubSasCredentials#getSasKey()}
   *   <li>{@link AzureIotHubSasCredentials#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AzureIotHubSasCredentials.<init>()",
    "String AzureIotHubSasCredentials.getSasKey()",
    "CredentialsType AzureIotHubSasCredentials.getType()",
    "void AzureIotHubSasCredentials.setSasKey(String)",
    "String AzureIotHubSasCredentials.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AzureIotHubSasCredentials actualAzureIotHubSasCredentials = new AzureIotHubSasCredentials();
    actualAzureIotHubSasCredentials.setSasKey("Sas Key");
    String actualToStringResult = actualAzureIotHubSasCredentials.toString();
    String actualSasKey = actualAzureIotHubSasCredentials.getSasKey();
    CredentialsType actualType = actualAzureIotHubSasCredentials.getType();

    // Assert
    assertEquals("AzureIotHubSasCredentials(sasKey=Sas Key)", actualToStringResult);
    assertEquals("Sas Key", actualSasKey);
    assertNull(actualAzureIotHubSasCredentials.getCaCert());
    assertNull(actualAzureIotHubSasCredentials.getCert());
    assertNull(actualAzureIotHubSasCredentials.getPassword());
    assertNull(actualAzureIotHubSasCredentials.getPrivateKey());
    assertEquals(CredentialsType.SAS, actualType);
  }
}
