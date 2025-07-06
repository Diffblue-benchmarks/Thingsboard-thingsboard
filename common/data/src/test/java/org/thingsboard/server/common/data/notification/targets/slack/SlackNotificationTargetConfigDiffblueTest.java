package org.thingsboard.server.common.data.notification.targets.slack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.targets.NotificationTargetType;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversation.SlackConversationBuilder;

class SlackNotificationTargetConfigDiffblueTest {
  /**
   * Test {@link SlackNotificationTargetConfig#equals(Object)}, and {@link
   * SlackNotificationTargetConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlackNotificationTargetConfig#equals(Object)}
   *   <li>{@link SlackNotificationTargetConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SlackNotificationTargetConfig.equals(Object)",
    "int SlackNotificationTargetConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SlackNotificationTargetConfig slackNotificationTargetConfig =
        new SlackNotificationTargetConfig();
    SlackConversation conversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(SlackConversationType.DIRECT);
    slackNotificationTargetConfig.setDescription("The characteristics of someone or something");

    SlackNotificationTargetConfig slackNotificationTargetConfig2 =
        new SlackNotificationTargetConfig();
    SlackConversation conversation2 =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    slackNotificationTargetConfig2.setConversation(conversation2);
    slackNotificationTargetConfig2.setConversationType(SlackConversationType.DIRECT);
    slackNotificationTargetConfig2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals(slackNotificationTargetConfig, slackNotificationTargetConfig2);
    int expectedHashCodeResult = slackNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, slackNotificationTargetConfig2.hashCode());
  }

  /**
   * Test {@link SlackNotificationTargetConfig#equals(Object)}, and {@link
   * SlackNotificationTargetConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlackNotificationTargetConfig#equals(Object)}
   *   <li>{@link SlackNotificationTargetConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SlackNotificationTargetConfig.equals(Object)",
    "int SlackNotificationTargetConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SlackNotificationTargetConfig slackNotificationTargetConfig =
        new SlackNotificationTargetConfig();
    SlackConversation conversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(SlackConversationType.DIRECT);
    slackNotificationTargetConfig.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals(slackNotificationTargetConfig, slackNotificationTargetConfig);
    int expectedHashCodeResult = slackNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, slackNotificationTargetConfig.hashCode());
  }

  /**
   * Test {@link SlackNotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SlackNotificationTargetConfig.equals(Object)",
    "int SlackNotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SlackConversationBuilder slackConversationBuilder = mock(SlackConversationBuilder.class);
    when(slackConversationBuilder.email(Mockito.<String>any()))
        .thenReturn(SlackConversation.builder());
    SlackConversation conversation =
        slackConversationBuilder
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    SlackNotificationTargetConfig slackNotificationTargetConfig =
        new SlackNotificationTargetConfig();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(SlackConversationType.DIRECT);
    slackNotificationTargetConfig.setDescription("The characteristics of someone or something");

    SlackNotificationTargetConfig slackNotificationTargetConfig2 =
        new SlackNotificationTargetConfig();
    SlackConversation conversation2 =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    slackNotificationTargetConfig2.setConversation(conversation2);
    slackNotificationTargetConfig2.setConversationType(SlackConversationType.DIRECT);
    slackNotificationTargetConfig2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(slackNotificationTargetConfig, slackNotificationTargetConfig2);
  }

  /**
   * Test {@link SlackNotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SlackNotificationTargetConfig.equals(Object)",
    "int SlackNotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SlackConversationBuilder slackConversationBuilder = mock(SlackConversationBuilder.class);
    when(slackConversationBuilder.email(Mockito.<String>any()))
        .thenReturn(SlackConversation.builder());
    SlackConversation conversation =
        slackConversationBuilder
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    SlackNotificationTargetConfig slackNotificationTargetConfig =
        new SlackNotificationTargetConfig();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(null);
    slackNotificationTargetConfig.setDescription("The characteristics of someone or something");

    SlackNotificationTargetConfig slackNotificationTargetConfig2 =
        new SlackNotificationTargetConfig();
    SlackConversation conversation2 =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    slackNotificationTargetConfig2.setConversation(conversation2);
    slackNotificationTargetConfig2.setConversationType(SlackConversationType.DIRECT);
    slackNotificationTargetConfig2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(slackNotificationTargetConfig, slackNotificationTargetConfig2);
  }

  /**
   * Test {@link SlackNotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SlackNotificationTargetConfig.equals(Object)",
    "int SlackNotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SlackConversationBuilder slackConversationBuilder = mock(SlackConversationBuilder.class);
    when(slackConversationBuilder.email(Mockito.<String>any()))
        .thenReturn(SlackConversation.builder());
    SlackConversation conversation =
        slackConversationBuilder
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    SlackNotificationTargetConfig slackNotificationTargetConfig =
        new SlackNotificationTargetConfig();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(SlackConversationType.PUBLIC_CHANNEL);
    slackNotificationTargetConfig.setDescription("The characteristics of someone or something");

    SlackNotificationTargetConfig slackNotificationTargetConfig2 =
        new SlackNotificationTargetConfig();
    SlackConversation conversation2 =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    slackNotificationTargetConfig2.setConversation(conversation2);
    slackNotificationTargetConfig2.setConversationType(SlackConversationType.DIRECT);
    slackNotificationTargetConfig2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(slackNotificationTargetConfig, slackNotificationTargetConfig2);
  }

  /**
   * Test {@link SlackNotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SlackNotificationTargetConfig.equals(Object)",
    "int SlackNotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SlackConversationBuilder slackConversationBuilder = mock(SlackConversationBuilder.class);
    when(slackConversationBuilder.email(Mockito.<String>any()))
        .thenReturn(SlackConversation.builder());
    SlackConversation conversation =
        slackConversationBuilder
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    SlackNotificationTargetConfig slackNotificationTargetConfig =
        new SlackNotificationTargetConfig();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(SlackConversationType.DIRECT);
    slackNotificationTargetConfig.setDescription("42");

    SlackNotificationTargetConfig slackNotificationTargetConfig2 =
        new SlackNotificationTargetConfig();
    SlackConversation conversation2 =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    slackNotificationTargetConfig2.setConversation(conversation2);
    slackNotificationTargetConfig2.setConversationType(SlackConversationType.DIRECT);
    slackNotificationTargetConfig2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(slackNotificationTargetConfig, slackNotificationTargetConfig2);
  }

  /**
   * Test {@link SlackNotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SlackNotificationTargetConfig.equals(Object)",
    "int SlackNotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SlackConversationBuilder slackConversationBuilder = mock(SlackConversationBuilder.class);
    when(slackConversationBuilder.email(Mockito.<String>any()))
        .thenReturn(SlackConversation.builder());
    SlackConversation conversation =
        slackConversationBuilder
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    SlackNotificationTargetConfig slackNotificationTargetConfig =
        new SlackNotificationTargetConfig();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(null);
    slackNotificationTargetConfig.setDescription("The characteristics of someone or something");

    SlackNotificationTargetConfig slackNotificationTargetConfig2 =
        new SlackNotificationTargetConfig();
    SlackConversation conversation2 =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    slackNotificationTargetConfig2.setConversation(conversation2);
    slackNotificationTargetConfig2.setConversationType(null);
    slackNotificationTargetConfig2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(slackNotificationTargetConfig, slackNotificationTargetConfig2);
  }

  /**
   * Test {@link SlackNotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SlackNotificationTargetConfig.equals(Object)",
    "int SlackNotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SlackNotificationTargetConfig slackNotificationTargetConfig =
        new SlackNotificationTargetConfig();
    SlackConversation conversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(SlackConversationType.DIRECT);
    slackNotificationTargetConfig.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(slackNotificationTargetConfig, null);
  }

  /**
   * Test {@link SlackNotificationTargetConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SlackNotificationTargetConfig.equals(Object)",
    "int SlackNotificationTargetConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SlackNotificationTargetConfig slackNotificationTargetConfig =
        new SlackNotificationTargetConfig();
    SlackConversation conversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(SlackConversationType.DIRECT);
    slackNotificationTargetConfig.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        slackNotificationTargetConfig, "Different type to SlackNotificationTargetConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SlackNotificationTargetConfig}
   *   <li>{@link SlackNotificationTargetConfig#setConversation(SlackConversation)}
   *   <li>{@link SlackNotificationTargetConfig#setConversationType(SlackConversationType)}
   *   <li>{@link SlackNotificationTargetConfig#toString()}
   *   <li>{@link SlackNotificationTargetConfig#getConversation()}
   *   <li>{@link SlackNotificationTargetConfig#getConversationType()}
   *   <li>{@link SlackNotificationTargetConfig#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void SlackNotificationTargetConfig.<init>()",
    "SlackConversation SlackNotificationTargetConfig.getConversation()",
    "SlackConversationType SlackNotificationTargetConfig.getConversationType()",
    "NotificationTargetType SlackNotificationTargetConfig.getType()",
    "void SlackNotificationTargetConfig.setConversation(SlackConversation)",
    "void SlackNotificationTargetConfig.setConversationType(SlackConversationType)",
    "String SlackNotificationTargetConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SlackNotificationTargetConfig actualSlackNotificationTargetConfig =
        new SlackNotificationTargetConfig();
    SlackConversation conversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    actualSlackNotificationTargetConfig.setConversation(conversation);
    actualSlackNotificationTargetConfig.setConversationType(SlackConversationType.DIRECT);
    String actualToStringResult = actualSlackNotificationTargetConfig.toString();
    SlackConversation actualConversation = actualSlackNotificationTargetConfig.getConversation();
    SlackConversationType actualConversationType =
        actualSlackNotificationTargetConfig.getConversationType();
    NotificationTargetType actualType = actualSlackNotificationTargetConfig.getType();

    // Assert
    assertEquals(
        "SlackNotificationTargetConfig(conversationType=DIRECT, conversation=SlackConversation(type=DIRECT,"
            + " id=42, name=Name, wholeName=Whole Name, email=jane.doe@example.org))",
        actualToStringResult);
    assertNull(actualSlackNotificationTargetConfig.getDescription());
    assertEquals(NotificationTargetType.SLACK, actualType);
    assertEquals(SlackConversationType.DIRECT, actualConversationType);
    assertSame(conversation, actualConversation);
  }
}
