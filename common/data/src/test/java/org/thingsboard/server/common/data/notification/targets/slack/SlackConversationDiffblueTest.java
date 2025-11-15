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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SlackConversationDiffblueTest {
  /**
   * Method under test: {@link SlackConversation#getTitle()}
   */
  @Test
  void testGetTitle() {
    // Arrange, Act and Assert
    assertEquals("Whole Name",
        (new SlackConversation(SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org"))
            .getTitle());
    assertEquals("Name", (new SlackConversation(SlackConversationType.PUBLIC_CHANNEL, "42", "Name", "Whole Name",
        "jane.doe@example.org")).getTitle());
    assertEquals("Name",
        (new SlackConversation(SlackConversationType.DIRECT, "42", "Name", "", "jane.doe@example.org")).getTitle());
  }

  /**
   * Method under test: {@link SlackConversation#getTitle()}
   */
  @Test
  void testGetTitle2() {
    // Arrange
    SlackConversation slackConversation = new SlackConversation(SlackConversationType.DIRECT, "42", "Name",
        "Whole Name", "jane.doe@example.org");
    slackConversation.setType(SlackConversationType.DIRECT);
    slackConversation.setWholeName(null);
    slackConversation.setName("foo");

    // Act and Assert
    assertEquals("foo", slackConversation.getTitle());
  }

  /**
   * Method under test: {@link SlackConversation#getFirstName()}
   */
  @Test
  void testGetFirstName() {
    // Arrange, Act and Assert
    assertEquals("Whole",
        (new SlackConversation(SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org"))
            .getFirstName());
    assertEquals("Name",
        (new SlackConversation(SlackConversationType.DIRECT, "42", "Name", "", "jane.doe@example.org")).getFirstName());
  }

  /**
   * Method under test: {@link SlackConversation#getFirstName()}
   */
  @Test
  void testGetFirstName2() {
    // Arrange
    SlackConversation slackConversation = new SlackConversation(SlackConversationType.DIRECT, "42", "Name",
        "Whole Name", "jane.doe@example.org");
    slackConversation.setWholeName(null);

    // Act and Assert
    assertEquals("Name", slackConversation.getFirstName());
  }

  /**
   * Method under test: {@link SlackConversation#getFirstName()}
   */
  @Test
  void testGetFirstName3() {
    // Arrange
    SlackConversation slackConversation = new SlackConversation(SlackConversationType.DIRECT, "42", "Name",
        "Whole Name", "jane.doe@example.org");
    slackConversation.setWholeName("foo");

    // Act and Assert
    assertEquals("foo", slackConversation.getFirstName());
  }

  /**
   * Method under test: {@link SlackConversation#getLastName()}
   */
  @Test
  void testGetLastName() {
    // Arrange, Act and Assert
    assertEquals("Name",
        (new SlackConversation(SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org"))
            .getLastName());
  }

  /**
   * Method under test: {@link SlackConversation#getLastName()}
   */
  @Test
  void testGetLastName2() {
    // Arrange
    SlackConversation slackConversation = new SlackConversation(SlackConversationType.DIRECT, "42", "Name",
        "Whole Name", "jane.doe@example.org");
    slackConversation.setWholeName(null);

    // Act and Assert
    assertNull(slackConversation.getLastName());
  }

  /**
   * Method under test: {@link SlackConversation#getLastName()}
   */
  @Test
  void testGetLastName3() {
    // Arrange
    SlackConversation slackConversation = new SlackConversation(SlackConversationType.DIRECT, "42", "Name",
        "Whole Name", "jane.doe@example.org");
    slackConversation.setWholeName("foo");

    // Act and Assert
    assertNull(slackConversation.getLastName());
  }

  /**
   * Method under test: {@link SlackConversation#getPointer()}
   */
  @Test
  void testGetPointer() {
    // Arrange, Act and Assert
    assertEquals("@",
        (new SlackConversation(SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org"))
            .getPointer());
    assertEquals("#", (new SlackConversation(SlackConversationType.PUBLIC_CHANNEL, "42", "Name", "Whole Name",
        "jane.doe@example.org")).getPointer());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SlackConversation#equals(Object)}
   *   <li>{@link SlackConversation#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SlackConversation buildResult = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();
    SlackConversation buildResult2 = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SlackConversation#equals(Object)}
   *   <li>{@link SlackConversation#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.name(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation.SlackConversationBuilder slackConversationBuilder2 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder2.id(Mockito.<String>any())).thenReturn(slackConversationBuilder);
    SlackConversation.SlackConversationBuilder slackConversationBuilder3 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder3.email(Mockito.<String>any())).thenReturn(slackConversationBuilder2);
    SlackConversation buildResult = slackConversationBuilder3.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();
    SlackConversation.SlackConversationBuilder slackConversationBuilder4 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder4.email(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation buildResult2 = slackConversationBuilder4.email("jane.doe@example.org")
        .id(null)
        .name(null)
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SlackConversation#equals(Object)}
   *   <li>{@link SlackConversation#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SlackConversation buildResult = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.email(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation buildResult = slackConversationBuilder.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();
    SlackConversation buildResult2 = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.id(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation.SlackConversationBuilder slackConversationBuilder2 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder2.email(Mockito.<String>any())).thenReturn(slackConversationBuilder);
    SlackConversation buildResult = slackConversationBuilder2.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();
    SlackConversation buildResult2 = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.id(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation.SlackConversationBuilder slackConversationBuilder2 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder2.email(Mockito.<String>any())).thenReturn(slackConversationBuilder);
    SlackConversation buildResult = slackConversationBuilder2.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(null)
        .wholeName("Whole Name")
        .build();
    SlackConversation buildResult2 = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.id(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation.SlackConversationBuilder slackConversationBuilder2 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder2.email(Mockito.<String>any())).thenReturn(slackConversationBuilder);
    SlackConversation buildResult = slackConversationBuilder2.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.PUBLIC_CHANNEL)
        .wholeName("Whole Name")
        .build();
    SlackConversation buildResult2 = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.id(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation.SlackConversationBuilder slackConversationBuilder2 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder2.email(Mockito.<String>any())).thenReturn(slackConversationBuilder);
    SlackConversation buildResult = slackConversationBuilder2.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();
    SlackConversation buildResult2 = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id(null)
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.id(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation.SlackConversationBuilder slackConversationBuilder2 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder2.email(Mockito.<String>any())).thenReturn(slackConversationBuilder);
    SlackConversation buildResult = slackConversationBuilder2.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(null)
        .wholeName("Whole Name")
        .build();
    SlackConversation buildResult2 = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(null)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.name(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation.SlackConversationBuilder slackConversationBuilder2 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder2.id(Mockito.<String>any())).thenReturn(slackConversationBuilder);
    SlackConversation.SlackConversationBuilder slackConversationBuilder3 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder3.email(Mockito.<String>any())).thenReturn(slackConversationBuilder2);
    SlackConversation buildResult = slackConversationBuilder3.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();
    SlackConversation buildResult2 = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id(null)
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.name(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation.SlackConversationBuilder slackConversationBuilder2 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder2.id(Mockito.<String>any())).thenReturn(slackConversationBuilder);
    SlackConversation.SlackConversationBuilder slackConversationBuilder3 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder3.email(Mockito.<String>any())).thenReturn(slackConversationBuilder2);
    SlackConversation buildResult = slackConversationBuilder3.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();
    SlackConversation buildResult2 = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id(null)
        .name(null)
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    SlackConversation.SlackConversationBuilder builderResult = SlackConversation.builder();
    builderResult.id("42");
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.name(Mockito.<String>any())).thenReturn(builderResult);
    SlackConversation.SlackConversationBuilder slackConversationBuilder2 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder2.id(Mockito.<String>any())).thenReturn(slackConversationBuilder);
    SlackConversation.SlackConversationBuilder slackConversationBuilder3 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder3.email(Mockito.<String>any())).thenReturn(slackConversationBuilder2);
    SlackConversation buildResult = slackConversationBuilder3.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();
    SlackConversation buildResult2 = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id(null)
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.name(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation.SlackConversationBuilder slackConversationBuilder2 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder2.id(Mockito.<String>any())).thenReturn(slackConversationBuilder);
    SlackConversation.SlackConversationBuilder slackConversationBuilder3 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder3.email(Mockito.<String>any())).thenReturn(slackConversationBuilder2);
    SlackConversation buildResult = slackConversationBuilder3.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName(null)
        .build();
    SlackConversation buildResult2 = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id(null)
        .name(null)
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.name(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation.SlackConversationBuilder slackConversationBuilder2 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder2.id(Mockito.<String>any())).thenReturn(slackConversationBuilder);
    SlackConversation.SlackConversationBuilder slackConversationBuilder3 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder3.email(Mockito.<String>any())).thenReturn(slackConversationBuilder2);
    SlackConversation buildResult = slackConversationBuilder3.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("42")
        .build();
    SlackConversation buildResult2 = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id(null)
        .name(null)
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    SlackConversation.SlackConversationBuilder builderResult = SlackConversation.builder();
    builderResult.name("Whole Name");
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.name(Mockito.<String>any())).thenReturn(builderResult);
    SlackConversation.SlackConversationBuilder slackConversationBuilder2 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder2.id(Mockito.<String>any())).thenReturn(slackConversationBuilder);
    SlackConversation.SlackConversationBuilder slackConversationBuilder3 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder3.email(Mockito.<String>any())).thenReturn(slackConversationBuilder2);
    SlackConversation buildResult = slackConversationBuilder3.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();
    SlackConversation.SlackConversationBuilder slackConversationBuilder4 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder4.email(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation buildResult2 = slackConversationBuilder4.email("jane.doe@example.org")
        .id(null)
        .name(null)
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    SlackConversation.SlackConversationBuilder builderResult = SlackConversation.builder();
    builderResult.email("jane.doe@example.org");
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.name(Mockito.<String>any())).thenReturn(builderResult);
    SlackConversation.SlackConversationBuilder slackConversationBuilder2 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder2.id(Mockito.<String>any())).thenReturn(slackConversationBuilder);
    SlackConversation.SlackConversationBuilder slackConversationBuilder3 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder3.email(Mockito.<String>any())).thenReturn(slackConversationBuilder2);
    SlackConversation buildResult = slackConversationBuilder3.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();
    SlackConversation.SlackConversationBuilder slackConversationBuilder4 = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder4.email(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation buildResult2 = slackConversationBuilder4.email("jane.doe@example.org")
        .id(null)
        .name(null)
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SlackConversation buildResult = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SlackConversation buildResult = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to SlackConversation");
  }

  /**
   * Method under test: {@link SlackConversation#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertEquals("42",
        (new SlackConversation(SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org"))
            .getId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SlackConversation#SlackConversation()}
   *   <li>{@link SlackConversation#setEmail(String)}
   *   <li>{@link SlackConversation#setId(String)}
   *   <li>{@link SlackConversation#setName(String)}
   *   <li>{@link SlackConversation#setType(SlackConversationType)}
   *   <li>{@link SlackConversation#setWholeName(String)}
   *   <li>{@link SlackConversation#toString()}
   *   <li>{@link SlackConversation#getEmail()}
   *   <li>{@link SlackConversation#getName()}
   *   <li>{@link SlackConversation#getType()}
   *   <li>{@link SlackConversation#getWholeName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SlackConversation actualSlackConversation = new SlackConversation();
    actualSlackConversation.setEmail("jane.doe@example.org");
    actualSlackConversation.setId("42");
    actualSlackConversation.setName("Name");
    actualSlackConversation.setType(SlackConversationType.DIRECT);
    actualSlackConversation.setWholeName("Whole Name");
    String actualToStringResult = actualSlackConversation.toString();
    String actualEmail = actualSlackConversation.getEmail();
    String actualName = actualSlackConversation.getName();
    SlackConversationType actualType = actualSlackConversation.getType();
    String actualWholeName = actualSlackConversation.getWholeName();

    // Assert that nothing has changed
    assertEquals("42", actualSlackConversation.getId());
    assertEquals("Name", actualName);
    assertEquals("SlackConversation(type=DIRECT, id=42, name=Name, wholeName=Whole Name, email=jane.doe@example.org)",
        actualToStringResult);
    assertEquals("Whole Name", actualWholeName);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals(SlackConversationType.DIRECT, actualType);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SlackConversation#SlackConversation(SlackConversationType, String, String, String, String)}
   *   <li>{@link SlackConversation#setEmail(String)}
   *   <li>{@link SlackConversation#setId(String)}
   *   <li>{@link SlackConversation#setName(String)}
   *   <li>{@link SlackConversation#setType(SlackConversationType)}
   *   <li>{@link SlackConversation#setWholeName(String)}
   *   <li>{@link SlackConversation#toString()}
   *   <li>{@link SlackConversation#getEmail()}
   *   <li>{@link SlackConversation#getName()}
   *   <li>{@link SlackConversation#getType()}
   *   <li>{@link SlackConversation#getWholeName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    SlackConversation actualSlackConversation = new SlackConversation(SlackConversationType.DIRECT, "42", "Name",
        "Whole Name", "jane.doe@example.org");
    actualSlackConversation.setEmail("jane.doe@example.org");
    actualSlackConversation.setId("42");
    actualSlackConversation.setName("Name");
    actualSlackConversation.setType(SlackConversationType.DIRECT);
    actualSlackConversation.setWholeName("Whole Name");
    String actualToStringResult = actualSlackConversation.toString();
    String actualEmail = actualSlackConversation.getEmail();
    String actualName = actualSlackConversation.getName();
    SlackConversationType actualType = actualSlackConversation.getType();
    String actualWholeName = actualSlackConversation.getWholeName();

    // Assert that nothing has changed
    assertEquals("42", actualSlackConversation.getId());
    assertEquals("Name", actualName);
    assertEquals("SlackConversation(type=DIRECT, id=42, name=Name, wholeName=Whole Name, email=jane.doe@example.org)",
        actualToStringResult);
    assertEquals("Whole Name", actualWholeName);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals(SlackConversationType.DIRECT, actualType);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SlackConversation.SlackConversationBuilder#build()}
   *   <li>{@link SlackConversation.SlackConversationBuilder#email(String)}
   *   <li>{@link SlackConversation.SlackConversationBuilder#id(String)}
   *   <li>{@link SlackConversation.SlackConversationBuilder#name(String)}
   *   <li>
   * {@link SlackConversation.SlackConversationBuilder#type(SlackConversationType)}
   *   <li>{@link SlackConversation.SlackConversationBuilder#wholeName(String)}
   * </ul>
   */
  @Test
  void testSlackConversationBuilderBuild() {
    // Arrange and Act
    SlackConversation actualBuildResult = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getId());
    assertEquals("@", actualBuildResult.getPointer());
    assertEquals("Name", actualBuildResult.getLastName());
    assertEquals("Name", actualBuildResult.getName());
    assertEquals("Whole Name", actualBuildResult.getTitle());
    assertEquals("Whole Name", actualBuildResult.getWholeName());
    assertEquals("Whole", actualBuildResult.getFirstName());
    assertEquals("jane.doe@example.org", actualBuildResult.getEmail());
    assertEquals(SlackConversationType.DIRECT, actualBuildResult.getType());
  }
}
