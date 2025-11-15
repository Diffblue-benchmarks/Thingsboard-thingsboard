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
package org.thingsboard.server.common.data.notification.targets.slack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.targets.NotificationTargetType;

class SlackNotificationTargetConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SlackNotificationTargetConfig#equals(Object)}
   *   <li>{@link SlackNotificationTargetConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SlackNotificationTargetConfig slackNotificationTargetConfig = new SlackNotificationTargetConfig();
    SlackConversation conversation = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(SlackConversationType.DIRECT);
    slackNotificationTargetConfig.setDescription("The characteristics of someone or something");

    SlackNotificationTargetConfig slackNotificationTargetConfig2 = new SlackNotificationTargetConfig();
    SlackConversation conversation2 = SlackConversation.builder()
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
   * Methods under test:
   * <ul>
   *   <li>{@link SlackNotificationTargetConfig#equals(Object)}
   *   <li>{@link SlackNotificationTargetConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SlackNotificationTargetConfig slackNotificationTargetConfig = new SlackNotificationTargetConfig();
    SlackConversation conversation = SlackConversation.builder()
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
   * Method under test: {@link SlackNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.email(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation conversation = slackConversationBuilder.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    SlackNotificationTargetConfig slackNotificationTargetConfig = new SlackNotificationTargetConfig();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(SlackConversationType.DIRECT);
    slackNotificationTargetConfig.setDescription("The characteristics of someone or something");

    SlackNotificationTargetConfig slackNotificationTargetConfig2 = new SlackNotificationTargetConfig();
    SlackConversation conversation2 = SlackConversation.builder()
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
   * Method under test: {@link SlackNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.email(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation conversation = slackConversationBuilder.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    SlackNotificationTargetConfig slackNotificationTargetConfig = new SlackNotificationTargetConfig();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(null);
    slackNotificationTargetConfig.setDescription("The characteristics of someone or something");

    SlackNotificationTargetConfig slackNotificationTargetConfig2 = new SlackNotificationTargetConfig();
    SlackConversation conversation2 = SlackConversation.builder()
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
   * Method under test: {@link SlackNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.email(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation conversation = slackConversationBuilder.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    SlackNotificationTargetConfig slackNotificationTargetConfig = new SlackNotificationTargetConfig();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(SlackConversationType.PUBLIC_CHANNEL);
    slackNotificationTargetConfig.setDescription("The characteristics of someone or something");

    SlackNotificationTargetConfig slackNotificationTargetConfig2 = new SlackNotificationTargetConfig();
    SlackConversation conversation2 = SlackConversation.builder()
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
   * Method under test: {@link SlackNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.email(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation conversation = slackConversationBuilder.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    SlackNotificationTargetConfig slackNotificationTargetConfig = new SlackNotificationTargetConfig();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(SlackConversationType.DIRECT);
    slackNotificationTargetConfig.setDescription("42");

    SlackNotificationTargetConfig slackNotificationTargetConfig2 = new SlackNotificationTargetConfig();
    SlackConversation conversation2 = SlackConversation.builder()
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
   * Method under test: {@link SlackNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.email(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation conversation = slackConversationBuilder.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    SlackNotificationTargetConfig slackNotificationTargetConfig = new SlackNotificationTargetConfig();
    slackNotificationTargetConfig.setConversation(conversation);
    slackNotificationTargetConfig.setConversationType(null);
    slackNotificationTargetConfig.setDescription("The characteristics of someone or something");

    SlackNotificationTargetConfig slackNotificationTargetConfig2 = new SlackNotificationTargetConfig();
    SlackConversation conversation2 = SlackConversation.builder()
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
   * Method under test: {@link SlackNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SlackNotificationTargetConfig slackNotificationTargetConfig = new SlackNotificationTargetConfig();
    SlackConversation conversation = SlackConversation.builder()
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
   * Method under test: {@link SlackNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SlackNotificationTargetConfig slackNotificationTargetConfig = new SlackNotificationTargetConfig();
    SlackConversation conversation = SlackConversation.builder()
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
    assertNotEquals(slackNotificationTargetConfig, "Different type to SlackNotificationTargetConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SlackNotificationTargetConfig}
   *   <li>{@link SlackNotificationTargetConfig#setConversation(SlackConversation)}
   *   <li>
   * {@link SlackNotificationTargetConfig#setConversationType(SlackConversationType)}
   *   <li>{@link SlackNotificationTargetConfig#toString()}
   *   <li>{@link SlackNotificationTargetConfig#getConversation()}
   *   <li>{@link SlackNotificationTargetConfig#getConversationType()}
   *   <li>{@link SlackNotificationTargetConfig#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SlackNotificationTargetConfig actualSlackNotificationTargetConfig = new SlackNotificationTargetConfig();
    SlackConversation conversation = SlackConversation.builder()
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
    SlackConversationType actualConversationType = actualSlackNotificationTargetConfig.getConversationType();

    // Assert that nothing has changed
    assertEquals("SlackNotificationTargetConfig(conversationType=DIRECT, conversation=SlackConversation(type=DIRECT,"
        + " id=42, name=Name, wholeName=Whole Name, email=jane.doe@example.org))", actualToStringResult);
    assertEquals(NotificationTargetType.SLACK, actualSlackNotificationTargetConfig.getType());
    assertEquals(SlackConversationType.DIRECT, actualConversationType);
    assertSame(conversation, actualConversation);
  }
}
