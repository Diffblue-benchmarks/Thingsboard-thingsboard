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
package org.thingsboard.rule.engine.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.credentials.AnonymousCredentials;
import org.thingsboard.rule.engine.credentials.ClientCredentials;
import org.thingsboard.rule.engine.credentials.CredentialsType;
import org.thingsboard.rule.engine.mqtt.azure.TbAzureIotHubNodeConfiguration;

class TbMqttNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbMqttNodeConfiguration#defaultConfiguration()}.
   *
   * <ul>
   *   <li>Then Credentials return {@link AnonymousCredentials}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); then Credentials return AnonymousCredentials")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMqttNodeConfiguration TbMqttNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration_thenCredentialsReturnAnonymousCredentials() {
    // Arrange and Act
    TbMqttNodeConfiguration actualDefaultConfigurationResult =
        new TbMqttNodeConfiguration().defaultConfiguration();

    // Assert
    ClientCredentials credentials = actualDefaultConfigurationResult.getCredentials();
    assertTrue(credentials instanceof AnonymousCredentials);
    assertEquals("my-topic", actualDefaultConfigurationResult.getTopicPattern());
    assertNull(actualDefaultConfigurationResult.getHost());
    assertEquals(1883, actualDefaultConfigurationResult.getPort());
    assertEquals(CredentialsType.ANONYMOUS, credentials.getType());
    assertFalse(actualDefaultConfigurationResult.isSsl());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#defaultConfiguration()}.
   *
   * <ul>
   *   <li>Then return {@link TbAzureIotHubNodeConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); then return TbAzureIotHubNodeConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMqttNodeConfiguration TbMqttNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration_thenReturnTbAzureIotHubNodeConfiguration() {
    // Arrange
    TbAzureIotHubNodeConfiguration tbAzureIotHubNodeConfiguration =
        new TbAzureIotHubNodeConfiguration();

    // Act
    TbAzureIotHubNodeConfiguration actualDefaultConfigurationResult =
        tbAzureIotHubNodeConfiguration.defaultConfiguration();

    // Assert
    assertTrue(actualDefaultConfigurationResult instanceof TbAzureIotHubNodeConfiguration);
    assertEquals(tbAzureIotHubNodeConfiguration, actualDefaultConfigurationResult);
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}, and {@link
   * TbMqttNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMqttNodeConfiguration#equals(Object)}
   *   <li>{@link TbMqttNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    TbMqttNodeConfiguration tbMqttNodeConfiguration2 = new TbMqttNodeConfiguration();

    // Act and Assert
    assertEquals(tbMqttNodeConfiguration, tbMqttNodeConfiguration2);
    assertEquals(tbMqttNodeConfiguration.hashCode(), tbMqttNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}, and {@link
   * TbMqttNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMqttNodeConfiguration#equals(Object)}
   *   <li>{@link TbMqttNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setTopicPattern("Topic Pattern");

    TbMqttNodeConfiguration tbMqttNodeConfiguration2 = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration2.setTopicPattern("Topic Pattern");

    // Act and Assert
    assertEquals(tbMqttNodeConfiguration, tbMqttNodeConfiguration2);
    assertEquals(tbMqttNodeConfiguration.hashCode(), tbMqttNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}, and {@link
   * TbMqttNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMqttNodeConfiguration#equals(Object)}
   *   <li>{@link TbMqttNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setHost("localhost");

    TbMqttNodeConfiguration tbMqttNodeConfiguration2 = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration2.setHost("localhost");

    // Act and Assert
    assertEquals(tbMqttNodeConfiguration, tbMqttNodeConfiguration2);
    assertEquals(tbMqttNodeConfiguration.hashCode(), tbMqttNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}, and {@link
   * TbMqttNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMqttNodeConfiguration#equals(Object)}
   *   <li>{@link TbMqttNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setClientId("42");

    TbMqttNodeConfiguration tbMqttNodeConfiguration2 = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration2.setClientId("42");

    // Act and Assert
    assertEquals(tbMqttNodeConfiguration, tbMqttNodeConfiguration2);
    assertEquals(tbMqttNodeConfiguration.hashCode(), tbMqttNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}, and {@link
   * TbMqttNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMqttNodeConfiguration#equals(Object)}
   *   <li>{@link TbMqttNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();

    // Act and Assert
    assertEquals(tbMqttNodeConfiguration, tbMqttNodeConfiguration);
    int expectedHashCodeResult = tbMqttNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMqttNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbAzureIotHubNodeConfiguration tbAzureIotHubNodeConfiguration =
        new TbAzureIotHubNodeConfiguration();

    // Act and Assert
    assertNotEquals(tbAzureIotHubNodeConfiguration, new TbMqttNodeConfiguration());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, new TbAzureIotHubNodeConfiguration());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setTopicPattern("Topic Pattern");

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, new TbMqttNodeConfiguration());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setHost("localhost");

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, new TbMqttNodeConfiguration());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setPort(8080);

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, new TbMqttNodeConfiguration());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setConnectTimeoutSec(10);

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, new TbMqttNodeConfiguration());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setClientId("42");

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, new TbMqttNodeConfiguration());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setAppendClientIdSuffix(true);

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, new TbMqttNodeConfiguration());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setRetainedMessage(true);

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, new TbMqttNodeConfiguration());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setCleanSession(true);

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, new TbMqttNodeConfiguration());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setSsl(true);

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, new TbMqttNodeConfiguration());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setParseToPlainText(true);

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, new TbMqttNodeConfiguration());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setCredentials(mock(ClientCredentials.class));

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, new TbMqttNodeConfiguration());
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();

    TbMqttNodeConfiguration tbMqttNodeConfiguration2 = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration2.setTopicPattern("Topic Pattern");

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, tbMqttNodeConfiguration2);
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();

    TbMqttNodeConfiguration tbMqttNodeConfiguration2 = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration2.setHost("localhost");

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, tbMqttNodeConfiguration2);
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();

    TbMqttNodeConfiguration tbMqttNodeConfiguration2 = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration2.setClientId("42");

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, tbMqttNodeConfiguration2);
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();

    TbMqttNodeConfiguration tbMqttNodeConfiguration2 = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration2.setCredentials(mock(ClientCredentials.class));

    // Act and Assert
    assertNotEquals(tbMqttNodeConfiguration, tbMqttNodeConfiguration2);
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMqttNodeConfiguration(), null);
  }

  /**
   * Test {@link TbMqttNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMqttNodeConfiguration.equals(Object)",
    "int TbMqttNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMqttNodeConfiguration(), "Different type to TbMqttNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMqttNodeConfiguration}
   *   <li>{@link TbMqttNodeConfiguration#setAppendClientIdSuffix(boolean)}
   *   <li>{@link TbMqttNodeConfiguration#setCleanSession(boolean)}
   *   <li>{@link TbMqttNodeConfiguration#setClientId(String)}
   *   <li>{@link TbMqttNodeConfiguration#setConnectTimeoutSec(int)}
   *   <li>{@link TbMqttNodeConfiguration#setCredentials(ClientCredentials)}
   *   <li>{@link TbMqttNodeConfiguration#setHost(String)}
   *   <li>{@link TbMqttNodeConfiguration#setParseToPlainText(boolean)}
   *   <li>{@link TbMqttNodeConfiguration#setPort(int)}
   *   <li>{@link TbMqttNodeConfiguration#setRetainedMessage(boolean)}
   *   <li>{@link TbMqttNodeConfiguration#setSsl(boolean)}
   *   <li>{@link TbMqttNodeConfiguration#setTopicPattern(String)}
   *   <li>{@link TbMqttNodeConfiguration#toString()}
   *   <li>{@link TbMqttNodeConfiguration#getClientId()}
   *   <li>{@link TbMqttNodeConfiguration#getConnectTimeoutSec()}
   *   <li>{@link TbMqttNodeConfiguration#getCredentials()}
   *   <li>{@link TbMqttNodeConfiguration#getHost()}
   *   <li>{@link TbMqttNodeConfiguration#getPort()}
   *   <li>{@link TbMqttNodeConfiguration#getTopicPattern()}
   *   <li>{@link TbMqttNodeConfiguration#isAppendClientIdSuffix()}
   *   <li>{@link TbMqttNodeConfiguration#isCleanSession()}
   *   <li>{@link TbMqttNodeConfiguration#isParseToPlainText()}
   *   <li>{@link TbMqttNodeConfiguration#isRetainedMessage()}
   *   <li>{@link TbMqttNodeConfiguration#isSsl()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbMqttNodeConfiguration.<init>()",
    "String TbMqttNodeConfiguration.getClientId()",
    "int TbMqttNodeConfiguration.getConnectTimeoutSec()",
    "ClientCredentials TbMqttNodeConfiguration.getCredentials()",
    "String TbMqttNodeConfiguration.getHost()",
    "int TbMqttNodeConfiguration.getPort()",
    "String TbMqttNodeConfiguration.getTopicPattern()",
    "boolean TbMqttNodeConfiguration.isAppendClientIdSuffix()",
    "boolean TbMqttNodeConfiguration.isCleanSession()",
    "boolean TbMqttNodeConfiguration.isParseToPlainText()",
    "boolean TbMqttNodeConfiguration.isRetainedMessage()",
    "boolean TbMqttNodeConfiguration.isSsl()",
    "void TbMqttNodeConfiguration.setAppendClientIdSuffix(boolean)",
    "void TbMqttNodeConfiguration.setCleanSession(boolean)",
    "void TbMqttNodeConfiguration.setClientId(String)",
    "void TbMqttNodeConfiguration.setConnectTimeoutSec(int)",
    "void TbMqttNodeConfiguration.setCredentials(ClientCredentials)",
    "void TbMqttNodeConfiguration.setHost(String)",
    "void TbMqttNodeConfiguration.setParseToPlainText(boolean)",
    "void TbMqttNodeConfiguration.setPort(int)",
    "void TbMqttNodeConfiguration.setRetainedMessage(boolean)",
    "void TbMqttNodeConfiguration.setSsl(boolean)",
    "void TbMqttNodeConfiguration.setTopicPattern(String)",
    "String TbMqttNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbMqttNodeConfiguration actualTbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    actualTbMqttNodeConfiguration.setAppendClientIdSuffix(true);
    actualTbMqttNodeConfiguration.setCleanSession(true);
    actualTbMqttNodeConfiguration.setClientId("42");
    actualTbMqttNodeConfiguration.setConnectTimeoutSec(10);
    ClientCredentials credentials = mock(ClientCredentials.class);
    actualTbMqttNodeConfiguration.setCredentials(credentials);
    actualTbMqttNodeConfiguration.setHost("localhost");
    actualTbMqttNodeConfiguration.setParseToPlainText(true);
    actualTbMqttNodeConfiguration.setPort(8080);
    actualTbMqttNodeConfiguration.setRetainedMessage(true);
    actualTbMqttNodeConfiguration.setSsl(true);
    actualTbMqttNodeConfiguration.setTopicPattern("Topic Pattern");
    actualTbMqttNodeConfiguration.toString();
    String actualClientId = actualTbMqttNodeConfiguration.getClientId();
    int actualConnectTimeoutSec = actualTbMqttNodeConfiguration.getConnectTimeoutSec();
    ClientCredentials actualCredentials = actualTbMqttNodeConfiguration.getCredentials();
    String actualHost = actualTbMqttNodeConfiguration.getHost();
    int actualPort = actualTbMqttNodeConfiguration.getPort();
    String actualTopicPattern = actualTbMqttNodeConfiguration.getTopicPattern();
    boolean actualIsAppendClientIdSuffixResult =
        actualTbMqttNodeConfiguration.isAppendClientIdSuffix();
    boolean actualIsCleanSessionResult = actualTbMqttNodeConfiguration.isCleanSession();
    boolean actualIsParseToPlainTextResult = actualTbMqttNodeConfiguration.isParseToPlainText();
    boolean actualIsRetainedMessageResult = actualTbMqttNodeConfiguration.isRetainedMessage();

    // Assert
    assertEquals("42", actualClientId);
    assertEquals("Topic Pattern", actualTopicPattern);
    assertEquals("localhost", actualHost);
    assertEquals(10, actualConnectTimeoutSec);
    assertEquals(8080, actualPort);
    assertTrue(actualIsAppendClientIdSuffixResult);
    assertTrue(actualIsCleanSessionResult);
    assertTrue(actualIsParseToPlainTextResult);
    assertTrue(actualIsRetainedMessageResult);
    assertTrue(actualTbMqttNodeConfiguration.isSsl());
    assertSame(credentials, actualCredentials);
  }
}
