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
package org.thingsboard.server.common.data.notification.targets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class MicrosoftTeamsNotificationTargetConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
    int expectedHashCodeResult = microsoftTeamsNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, microsoftTeamsNotificationTargetConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig);
    int expectedHashCodeResult = microsoftTeamsNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, microsoftTeamsNotificationTargetConfig.hashCode());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName(null);
    microsoftTeamsNotificationTargetConfig.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription("https://example.org/example");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(false);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(null);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("The characteristics of someone or something");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl(null);

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, null);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription("The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, "Different type to MicrosoftTeamsNotificationTargetConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#setChannelName(String)}
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#setUseOldApi(Boolean)}
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#setWebhookUrl(String)}
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#toString()}
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#getChannelName()}
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#getId()}
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#getTitle()}
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#getType()}
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#getUseOldApi()}
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#getWebhookUrl()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();

    // Act
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");
    String actualToStringResult = microsoftTeamsNotificationTargetConfig.toString();
    String actualChannelName = microsoftTeamsNotificationTargetConfig.getChannelName();
    Object actualId = microsoftTeamsNotificationTargetConfig.getId();
    String actualTitle = microsoftTeamsNotificationTargetConfig.getTitle();
    NotificationTargetType actualType = microsoftTeamsNotificationTargetConfig.getType();
    Boolean actualUseOldApi = microsoftTeamsNotificationTargetConfig.getUseOldApi();

    // Assert that nothing has changed
    assertEquals("Channel Name", actualChannelName);
    assertEquals("Channel Name", actualTitle);
    assertEquals("MicrosoftTeamsNotificationTargetConfig(webhookUrl=https://example.org/example, channelName=Channel"
        + " Name, useOldApi=true)", actualToStringResult);
    assertEquals("https://example.org/example", microsoftTeamsNotificationTargetConfig.getWebhookUrl());
    assertEquals("https://example.org/example", actualId);
    assertEquals(NotificationTargetType.MICROSOFT_TEAMS, actualType);
    assertTrue(actualUseOldApi);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link MicrosoftTeamsNotificationTargetConfig}
   */
  @Test
  void testNewMicrosoftTeamsNotificationTargetConfig() {
    // Arrange and Act
    MicrosoftTeamsNotificationTargetConfig actualMicrosoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();

    // Assert
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getId());
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getChannelName());
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getTitle());
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getWebhookUrl());
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getEmail());
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getFirstName());
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getLastName());
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getDescription());
    assertEquals(NotificationTargetType.MICROSOFT_TEAMS, actualMicrosoftTeamsNotificationTargetConfig.getType());
    assertTrue(actualMicrosoftTeamsNotificationTargetConfig.getUseOldApi());
  }
}
