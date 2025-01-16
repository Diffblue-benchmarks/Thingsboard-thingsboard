package org.thingsboard.server.common.data.notification.targets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.targets.platform.PlatformUsersNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilter;

class NotificationTargetConfigDiffblueTest {
  /**
   * Test {@link NotificationTargetConfig#canEqual(Object)}.
   * <ul>
   *   <li>When {@link MicrosoftTeamsNotificationTargetConfig} (default
   * constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when MicrosoftTeamsNotificationTargetConfig (default constructor); then return 'true'")
  void testCanEqual_whenMicrosoftTeamsNotificationTargetConfig_thenReturnTrue() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();

    // Act and Assert
    assertTrue(microsoftTeamsNotificationTargetConfig.canEqual(new MicrosoftTeamsNotificationTargetConfig()));
  }

  /**
   * Test {@link NotificationTargetConfig#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new MicrosoftTeamsNotificationTargetConfig()).canEqual("Other"));
  }

  /**
   * Test {@link NotificationTargetConfig#equals(Object)}, and
   * {@link NotificationTargetConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link NotificationTargetConfig#equals(Object)}, and
   * {@link NotificationTargetConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = new MicrosoftTeamsNotificationTargetConfig();

    // Act and Assert
    assertEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig);
    int expectedHashCodeResult = microsoftTeamsNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, microsoftTeamsNotificationTargetConfig.hashCode());
  }

  /**
   * Test {@link NotificationTargetConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link NotificationTargetConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link NotificationTargetConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link NotificationTargetConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link NotificationTargetConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MicrosoftTeamsNotificationTargetConfig(), null);
  }

  /**
   * Test {@link NotificationTargetConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MicrosoftTeamsNotificationTargetConfig(), "Different type to NotificationTargetConfig");
  }

  /**
   * Test {@link NotificationTargetConfig#getDescription()}.
   * <p>
   * Method under test: {@link NotificationTargetConfig#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  void testGetDescription() {
    // Arrange, Act and Assert
    assertNull((new MicrosoftTeamsNotificationTargetConfig()).getDescription());
  }

  /**
   * Test {@link NotificationTargetConfig#setDescription(String)}.
   * <p>
   * Method under test: {@link NotificationTargetConfig#setDescription(String)}
   */
  @Test
  @DisplayName("Test setDescription(String)")
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
   * Test {@link NotificationTargetConfig#toString()}.
   * <p>
   * Method under test: {@link NotificationTargetConfig#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("MicrosoftTeamsNotificationTargetConfig(webhookUrl=null, channelName=null, useOldApi=true)",
        (new MicrosoftTeamsNotificationTargetConfig()).toString());
  }
}
