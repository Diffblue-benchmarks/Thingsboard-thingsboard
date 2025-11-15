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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.targets.platform.PlatformUsersNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilter;

class NotificationTargetConfigDiffblueTest {
  /**
   * Method under test: {@link NotificationTargetConfig#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new MicrosoftTeamsNotificationTargetConfig()).canEqual("Other"));
  }

  /**
   * Method under test: {@link NotificationTargetConfig#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();

    // Act and Assert
    assertTrue(microsoftTeamsNotificationTargetConfig.canEqual(new MicrosoftTeamsNotificationTargetConfig()));
  }

  /**
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 = new MicrosoftTeamsNotificationTargetConfig();

    // Act and Assert
    assertEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
    int expectedHashCodeResult = microsoftTeamsNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, microsoftTeamsNotificationTargetConfig2.hashCode());
  }

  /**
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();

    // Act and Assert
    assertEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig);
    int expectedHashCodeResult = microsoftTeamsNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, microsoftTeamsNotificationTargetConfig.hashCode());
  }

  /**
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, platformUsersNotificationTargetConfig);
  }

  /**
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 = mock(
        MicrosoftTeamsNotificationTargetConfig.class);
    when(microsoftTeamsNotificationTargetConfig2.getUseOldApi()).thenReturn(true);
    when(microsoftTeamsNotificationTargetConfig2.getDescription())
        .thenReturn("The characteristics of someone or something");
    when(microsoftTeamsNotificationTargetConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setDescription("The characteristics of someone or something");
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 = mock(
        MicrosoftTeamsNotificationTargetConfig.class);
    when(microsoftTeamsNotificationTargetConfig2.getChannelName()).thenReturn("Channel Name");
    when(microsoftTeamsNotificationTargetConfig2.getWebhookUrl()).thenReturn("https://example.org/example");
    when(microsoftTeamsNotificationTargetConfig2.getUseOldApi()).thenReturn(true);
    when(microsoftTeamsNotificationTargetConfig2.getDescription())
        .thenReturn("The characteristics of someone or something");
    when(microsoftTeamsNotificationTargetConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setDescription("Description");
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 = mock(
        MicrosoftTeamsNotificationTargetConfig.class);
    when(microsoftTeamsNotificationTargetConfig2.getChannelName()).thenReturn("Channel Name");
    when(microsoftTeamsNotificationTargetConfig2.getWebhookUrl()).thenReturn("https://example.org/example");
    when(microsoftTeamsNotificationTargetConfig2.getUseOldApi()).thenReturn(true);
    when(microsoftTeamsNotificationTargetConfig2.getDescription())
        .thenReturn("The characteristics of someone or something");
    when(microsoftTeamsNotificationTargetConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MicrosoftTeamsNotificationTargetConfig(), null);
  }

  /**
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MicrosoftTeamsNotificationTargetConfig(), "Different type to NotificationTargetConfig");
  }

  /**
   * Method under test: {@link NotificationTargetConfig#getDescription()}
   */
  @Test
  void testGetDescription() {
    // Arrange, Act and Assert
    assertNull((new MicrosoftTeamsNotificationTargetConfig()).getDescription());
  }

  /**
   * Method under test: {@link NotificationTargetConfig#setDescription(String)}
   */
  @Test
  void testSetDescription() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();

    // Act
    microsoftTeamsNotificationTargetConfig.setDescription("The characteristics of someone or something");

    // Assert
    assertEquals("The characteristics of someone or something",
        microsoftTeamsNotificationTargetConfig.getDescription());
  }

  /**
   * Method under test: {@link NotificationTargetConfig#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("MicrosoftTeamsNotificationTargetConfig(webhookUrl=null, channelName=null, useOldApi=true)",
        (new MicrosoftTeamsNotificationTargetConfig()).toString());
  }
}
