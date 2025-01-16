package org.thingsboard.server.common.data.notification.targets.slack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversation.SlackConversationBuilder;

class SlackConversationDiffblueTest {
  /**
   * Test {@link SlackConversation#getTitle()}.
   * <p>
   * Method under test: {@link SlackConversation#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle()")
  void testGetTitle() {
    // Arrange, Act and Assert
    assertEquals("Name", (new SlackConversation(SlackConversationType.PUBLIC_CHANNEL, "42", "Name", "Whole Name",
        "jane.doe@example.org")).getTitle());
    assertEquals("Name",
        (new SlackConversation(SlackConversationType.DIRECT, "42", "Name", "", "jane.doe@example.org")).getTitle());
  }

  /**
   * Test {@link SlackConversation#getTitle()}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return 'foo'")
  void testGetTitle_thenReturnFoo() {
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
   * Test {@link SlackConversation#getTitle()}.
   * <ul>
   *   <li>Then return {@code Whole Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return 'Whole Name'")
  void testGetTitle_thenReturnWholeName() {
    // Arrange, Act and Assert
    assertEquals("Whole Name",
        (new SlackConversation(SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org"))
            .getTitle());
  }

  /**
   * Test {@link SlackConversation#getFirstName()}.
   * <p>
   * Method under test: {@link SlackConversation#getFirstName()}
   */
  @Test
  @DisplayName("Test getFirstName()")
  void testGetFirstName() {
    // Arrange
    SlackConversation slackConversation = new SlackConversation(SlackConversationType.DIRECT, "42", "Name",
        "Whole Name", "jane.doe@example.org");
    slackConversation.setWholeName(null);

    // Act and Assert
    assertEquals("Name", slackConversation.getFirstName());
  }

  /**
   * Test {@link SlackConversation#getFirstName()}.
   * <p>
   * Method under test: {@link SlackConversation#getFirstName()}
   */
  @Test
  @DisplayName("Test getFirstName()")
  void testGetFirstName2() {
    // Arrange, Act and Assert
    assertEquals("Name",
        (new SlackConversation(SlackConversationType.DIRECT, "42", "Name", "", "jane.doe@example.org")).getFirstName());
  }

  /**
   * Test {@link SlackConversation#getFirstName()}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#getFirstName()}
   */
  @Test
  @DisplayName("Test getFirstName(); then return 'foo'")
  void testGetFirstName_thenReturnFoo() {
    // Arrange
    SlackConversation slackConversation = new SlackConversation(SlackConversationType.DIRECT, "42", "Name",
        "Whole Name", "jane.doe@example.org");
    slackConversation.setWholeName("foo");

    // Act and Assert
    assertEquals("foo", slackConversation.getFirstName());
  }

  /**
   * Test {@link SlackConversation#getFirstName()}.
   * <ul>
   *   <li>Then return {@code Whole}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#getFirstName()}
   */
  @Test
  @DisplayName("Test getFirstName(); then return 'Whole'")
  void testGetFirstName_thenReturnWhole() {
    // Arrange, Act and Assert
    assertEquals("Whole",
        (new SlackConversation(SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org"))
            .getFirstName());
  }

  /**
   * Test {@link SlackConversation#getLastName()}.
   * <p>
   * Method under test: {@link SlackConversation#getLastName()}
   */
  @Test
  @DisplayName("Test getLastName()")
  void testGetLastName() {
    // Arrange
    SlackConversation slackConversation = new SlackConversation(SlackConversationType.DIRECT, "42", "Name",
        "Whole Name", "jane.doe@example.org");
    slackConversation.setWholeName(null);

    // Act and Assert
    assertNull(slackConversation.getLastName());
  }

  /**
   * Test {@link SlackConversation#getLastName()}.
   * <p>
   * Method under test: {@link SlackConversation#getLastName()}
   */
  @Test
  @DisplayName("Test getLastName()")
  void testGetLastName2() {
    // Arrange
    SlackConversation slackConversation = new SlackConversation(SlackConversationType.DIRECT, "42", "Name",
        "Whole Name", "jane.doe@example.org");
    slackConversation.setWholeName("foo");

    // Act and Assert
    assertNull(slackConversation.getLastName());
  }

  /**
   * Test {@link SlackConversation#getLastName()}.
   * <ul>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#getLastName()}
   */
  @Test
  @DisplayName("Test getLastName(); then return 'Name'")
  void testGetLastName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name",
        (new SlackConversation(SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org"))
            .getLastName());
  }

  /**
   * Test {@link SlackConversation#getPointer()}.
   * <ul>
   *   <li>Then return {@code @}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#getPointer()}
   */
  @Test
  @DisplayName("Test getPointer(); then return '@'")
  void testGetPointer_thenReturnCommercialAt() {
    // Arrange, Act and Assert
    assertEquals("@",
        (new SlackConversation(SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org"))
            .getPointer());
  }

  /**
   * Test {@link SlackConversation#getPointer()}.
   * <ul>
   *   <li>Then return {@code #}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#getPointer()}
   */
  @Test
  @DisplayName("Test getPointer(); then return '#'")
  void testGetPointer_thenReturnNumberSign() {
    // Arrange, Act and Assert
    assertEquals("#", (new SlackConversation(SlackConversationType.PUBLIC_CHANNEL, "42", "Name", "Whole Name",
        "jane.doe@example.org")).getPointer());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}, and
   * {@link SlackConversation#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SlackConversation#equals(Object)}
   *   <li>{@link SlackConversation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link SlackConversation#equals(Object)}, and
   * {@link SlackConversation#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SlackConversation#equals(Object)}
   *   <li>{@link SlackConversation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link SlackConversation#equals(Object)}, and
   * {@link SlackConversation#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SlackConversation#equals(Object)}
   *   <li>{@link SlackConversation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
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
   * Test {@link SlackConversation#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
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
   * Test {@link SlackConversation#getId()}.
   * <p>
   * Method under test: {@link SlackConversation#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  void testGetId() {
    // Arrange, Act and Assert
    assertEquals("42",
        (new SlackConversation(SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org"))
            .getId());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@code DIRECT}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; when 'DIRECT'")
  void testGettersAndSetters_whenDirect() {
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
   * Test SlackConversationBuilder {@link SlackConversationBuilder#build()}.
   * <p>
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
  @DisplayName("Test SlackConversationBuilder build()")
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
