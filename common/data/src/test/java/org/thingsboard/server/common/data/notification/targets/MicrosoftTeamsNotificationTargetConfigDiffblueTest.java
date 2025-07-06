package org.thingsboard.server.common.data.notification.targets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MicrosoftTeamsNotificationTargetConfigDiffblueTest {
  /**
   * Test {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}, and {@link
   * MicrosoftTeamsNotificationTargetConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MicrosoftTeamsNotificationTargetConfig.equals(Object)",
    "int MicrosoftTeamsNotificationTargetConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
    int expectedHashCodeResult = microsoftTeamsNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, microsoftTeamsNotificationTargetConfig2.hashCode());
  }

  /**
   * Test {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}, and {@link
   * MicrosoftTeamsNotificationTargetConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MicrosoftTeamsNotificationTargetConfig.equals(Object)",
    "int MicrosoftTeamsNotificationTargetConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(null);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(null);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
    int expectedHashCodeResult = microsoftTeamsNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, microsoftTeamsNotificationTargetConfig2.hashCode());
  }

  /**
   * Test {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}, and {@link
   * MicrosoftTeamsNotificationTargetConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   *   <li>{@link MicrosoftTeamsNotificationTargetConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MicrosoftTeamsNotificationTargetConfig.equals(Object)",
    "int MicrosoftTeamsNotificationTargetConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertEquals(microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig);
    int expectedHashCodeResult = microsoftTeamsNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, microsoftTeamsNotificationTargetConfig.hashCode());
  }

  /**
   * Test {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MicrosoftTeamsNotificationTargetConfig.equals(Object)",
    "int MicrosoftTeamsNotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(
        microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Test {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MicrosoftTeamsNotificationTargetConfig.equals(Object)",
    "int MicrosoftTeamsNotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription("https://example.org/example");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(
        microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Test {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MicrosoftTeamsNotificationTargetConfig.equals(Object)",
    "int MicrosoftTeamsNotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(false);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(
        microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Test {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MicrosoftTeamsNotificationTargetConfig.equals(Object)",
    "int MicrosoftTeamsNotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(null);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(
        microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Test {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MicrosoftTeamsNotificationTargetConfig.equals(Object)",
    "int MicrosoftTeamsNotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl(
        "The characteristics of someone or something");

    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig2 =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig2.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig2.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig2.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig2.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(
        microsoftTeamsNotificationTargetConfig, microsoftTeamsNotificationTargetConfig2);
  }

  /**
   * Test {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MicrosoftTeamsNotificationTargetConfig.equals(Object)",
    "int MicrosoftTeamsNotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(microsoftTeamsNotificationTargetConfig, null);
  }

  /**
   * Test {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MicrosoftTeamsNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MicrosoftTeamsNotificationTargetConfig.equals(Object)",
    "int MicrosoftTeamsNotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();
    microsoftTeamsNotificationTargetConfig.setChannelName("Channel Name");
    microsoftTeamsNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    microsoftTeamsNotificationTargetConfig.setUseOldApi(true);
    microsoftTeamsNotificationTargetConfig.setWebhookUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(
        microsoftTeamsNotificationTargetConfig,
        "Different type to MicrosoftTeamsNotificationTargetConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "String MicrosoftTeamsNotificationTargetConfig.getChannelName()",
    "Object MicrosoftTeamsNotificationTargetConfig.getId()",
    "String MicrosoftTeamsNotificationTargetConfig.getTitle()",
    "NotificationTargetType MicrosoftTeamsNotificationTargetConfig.getType()",
    "Boolean MicrosoftTeamsNotificationTargetConfig.getUseOldApi()",
    "String MicrosoftTeamsNotificationTargetConfig.getWebhookUrl()",
    "void MicrosoftTeamsNotificationTargetConfig.setChannelName(String)",
    "void MicrosoftTeamsNotificationTargetConfig.setUseOldApi(Boolean)",
    "void MicrosoftTeamsNotificationTargetConfig.setWebhookUrl(String)",
    "String MicrosoftTeamsNotificationTargetConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();

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

    // Assert
    assertEquals("Channel Name", actualChannelName);
    assertEquals("Channel Name", actualTitle);
    assertEquals(
        "MicrosoftTeamsNotificationTargetConfig(webhookUrl=https://example.org/example, channelName=Channel"
            + " Name, useOldApi=true)",
        actualToStringResult);
    assertEquals(
        "https://example.org/example", microsoftTeamsNotificationTargetConfig.getWebhookUrl());
    assertEquals("https://example.org/example", actualId);
    assertEquals(NotificationTargetType.MICROSOFT_TEAMS, actualType);
    assertTrue(actualUseOldApi);
  }

  /**
   * Test new {@link MicrosoftTeamsNotificationTargetConfig} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * MicrosoftTeamsNotificationTargetConfig}
   */
  @Test
  @DisplayName("Test new MicrosoftTeamsNotificationTargetConfig (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MicrosoftTeamsNotificationTargetConfig.<init>()"})
  void testNewMicrosoftTeamsNotificationTargetConfig() {
    // Arrange and Act
    MicrosoftTeamsNotificationTargetConfig actualMicrosoftTeamsNotificationTargetConfig =
        new MicrosoftTeamsNotificationTargetConfig();

    // Assert
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getId());
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getChannelName());
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getTitle());
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getWebhookUrl());
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getEmail());
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getFirstName());
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getLastName());
    assertNull(actualMicrosoftTeamsNotificationTargetConfig.getDescription());
    assertEquals(
        NotificationTargetType.MICROSOFT_TEAMS,
        actualMicrosoftTeamsNotificationTargetConfig.getType());
    assertTrue(actualMicrosoftTeamsNotificationTargetConfig.getUseOldApi());
  }
}
