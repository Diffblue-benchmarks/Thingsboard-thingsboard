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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.targets.platform.PlatformUsersNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilter;

class NotificationTargetConfigDiffblueTest {
  /**
   * Test {@link NotificationTargetConfig#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link MicrosoftTeamsNotificationTargetConfig} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetConfig#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when MicrosoftTeamsNotificationTargetConfig (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationTargetConfig.canEqual(Object)"})
  void testCanEqual_whenMicrosoftTeamsNotificationTargetConfig_thenReturnTrue() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();

    // Act and Assert
    assertTrue(
        microsoftTeamsNotificationTargetConfig.canEqual(
            new MicrosoftTeamsNotificationTargetConfig()));
  }

  /**
   * Test {@link NotificationTargetConfig#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationTargetConfig.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new MicrosoftTeamsNotificationTargetConfig().canEqual("Other"));
  }

  /**
   * Test {@link NotificationTargetConfig#equals(Object)}, and {@link
   * NotificationTargetConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetConfig.equals(Object)",
    "int NotificationTargetConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 =
        new MicrosoftTeamsNotificationTargetConfig();

    // Act and Assert
    assertEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
    assertEquals(
        microsoftTeamsNotificationTargetConfig.hashCode(),
        microsoftTeamsNotificationTargetConfig2.hashCode());
  }

  /**
   * Test {@link NotificationTargetConfig#equals(Object)}, and {@link
   * NotificationTargetConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetConfig.equals(Object)",
    "int NotificationTargetConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();

    // Act and Assert
    assertEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig);
    int expectedHashCodeResult = microsoftTeamsNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, microsoftTeamsNotificationTargetConfig.hashCode());
  }

  /**
   * Test {@link NotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetConfig.equals(Object)",
    "int NotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, platformUsersNotificationTargetConfig);
  }

  /**
   * Test {@link NotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetConfig.equals(Object)",
    "int NotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 =
        mock(MicrosoftTeamsNotificationTargetConfig.class);
    when(microsoftTeamsNotificationTargetConfig2.getUseOldApi()).thenReturn(true);
    when(microsoftTeamsNotificationTargetConfig2.getDescription())
        .thenReturn("The characteristics of someone or something");
    when(microsoftTeamsNotificationTargetConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(
        microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Test {@link NotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetConfig.equals(Object)",
    "int NotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 =
        mock(MicrosoftTeamsNotificationTargetConfig.class);
    when(microsoftTeamsNotificationTargetConfig2.getChannelName()).thenReturn("Channel Name");
    when(microsoftTeamsNotificationTargetConfig2.getWebhookUrl())
        .thenReturn("https://example.org/example");
    when(microsoftTeamsNotificationTargetConfig2.getDescription()).thenReturn(null);
    when(microsoftTeamsNotificationTargetConfig2.getUseOldApi()).thenReturn(true);
    when(microsoftTeamsNotificationTargetConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(
        microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Test {@link NotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetConfig.equals(Object)",
    "int NotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setDescription(
        "org.thingsboard.server.common.data.notification.targets.NotificationTargetConfig");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 =
        mock(MicrosoftTeamsNotificationTargetConfig.class);
    when(microsoftTeamsNotificationTargetConfig2.getChannelName()).thenReturn("Channel Name");
    when(microsoftTeamsNotificationTargetConfig2.getWebhookUrl())
        .thenReturn("https://example.org/example");
    when(microsoftTeamsNotificationTargetConfig2.getDescription())
        .thenReturn(
            "org.thingsboard.server.common.data.notification.targets.NotificationTargetConfig");
    when(microsoftTeamsNotificationTargetConfig2.getUseOldApi()).thenReturn(true);
    when(microsoftTeamsNotificationTargetConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(
        microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Test {@link NotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetConfig.equals(Object)",
    "int NotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MicrosoftTeamsNotificationTargetConfig(), null);
  }

  /**
   * Test {@link NotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetConfig.equals(Object)",
    "int NotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new MicrosoftTeamsNotificationTargetConfig(), "Different type to NotificationTargetConfig");
  }

  /**
   * Test {@link NotificationTargetConfig#getDescription()}.
   *
   * <p>Method under test: {@link NotificationTargetConfig#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NotificationTargetConfig.getDescription()"})
  void testGetDescription() {
    // Arrange, Act and Assert
    assertNull(new MicrosoftTeamsNotificationTargetConfig().getDescription());
  }

  /**
   * Test {@link NotificationTargetConfig#setDescription(String)}.
   *
   * <p>Method under test: {@link NotificationTargetConfig#setDescription(String)}
   */
  @Test
  @DisplayName("Test setDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTargetConfig.setDescription(String)"})
  void testSetDescription() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();

    // Act
    microsoftTeamsNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");

    // Assert
    assertEquals(
        "The characteristics of someone or something",
        microsoftTeamsNotificationTargetConfig.getDescription());
  }

  /**
   * Test {@link NotificationTargetConfig#toString()}.
   *
   * <p>Method under test: {@link NotificationTargetConfig#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NotificationTargetConfig.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "MicrosoftTeamsNotificationTargetConfig(webhookUrl=null, channelName=null, useOldApi=true)",
        new MicrosoftTeamsNotificationTargetConfig().toString());
  }
}
