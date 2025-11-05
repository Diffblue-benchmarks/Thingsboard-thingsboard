package org.thingsboard.server.common.data.notification.targets.slack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversation.SlackConversationBuilder;

@ContextConfiguration(classes = {SlackConversationBuilder.class})
@ExtendWith(SpringExtension.class)
class SlackConversationDiffblueTest {
  @Autowired private SlackConversationBuilder slackConversationBuilder;

  /**
   * Test {@link SlackConversation#getTitle()}.
   *
   * <p>Method under test: {@link SlackConversation#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SlackConversation.getTitle()"})
  void testGetTitle() {
    // Arrange
    SlackConversation slackConversation =
        new SlackConversation(
            SlackConversationType.DIRECT, "42", "Name", "", "jane.doe@example.org");

    // Act and Assert
    assertEquals("Name", slackConversation.getTitle());
  }

  /**
   * Test {@link SlackConversation#getTitle()}.
   *
   * <p>Method under test: {@link SlackConversation#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SlackConversation.getTitle()"})
  void testGetTitle2() {
    // Arrange
    SlackConversation slackConversation =
        new SlackConversation(
            SlackConversationType.DIRECT, "42", "Name", null, "jane.doe@example.org");

    // Act and Assert
    assertEquals("Name", slackConversation.getTitle());
  }

  /**
   * Test {@link SlackConversation#getTitle()}.
   *
   * <p>Method under test: {@link SlackConversation#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SlackConversation.getTitle()"})
  void testGetTitle3() {
    // Arrange
    SlackConversation slackConversation =
        new SlackConversation(
            SlackConversationType.PUBLIC_CHANNEL,
            "42",
            "Name",
            "Whole Name",
            "jane.doe@example.org");

    // Act and Assert
    assertEquals("Name", slackConversation.getTitle());
  }

  /**
   * Test {@link SlackConversation#getTitle()}.
   *
   * <ul>
   *   <li>Then return {@code Whole Name}.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return 'Whole Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SlackConversation.getTitle()"})
  void testGetTitle_thenReturnWholeName() {
    // Arrange
    SlackConversation slackConversation =
        new SlackConversation(
            SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org");

    // Act and Assert
    assertEquals("Whole Name", slackConversation.getTitle());
  }

  /**
   * Test {@link SlackConversation#getFirstName()}.
   *
   * <p>Method under test: {@link SlackConversation#getFirstName()}
   */
  @Test
  @DisplayName("Test getFirstName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SlackConversation.getFirstName()"})
  void testGetFirstName() {
    // Arrange
    SlackConversation slackConversation =
        new SlackConversation(
            SlackConversationType.DIRECT, "42", "Name", "", "jane.doe@example.org");

    // Act and Assert
    assertEquals("Name", slackConversation.getFirstName());
  }

  /**
   * Test {@link SlackConversation#getFirstName()}.
   *
   * <p>Method under test: {@link SlackConversation#getFirstName()}
   */
  @Test
  @DisplayName("Test getFirstName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SlackConversation.getFirstName()"})
  void testGetFirstName2() {
    // Arrange
    SlackConversation slackConversation =
        new SlackConversation(
            SlackConversationType.DIRECT, "42", "Name", null, "jane.doe@example.org");

    // Act and Assert
    assertEquals("Name", slackConversation.getFirstName());
  }

  /**
   * Test {@link SlackConversation#getFirstName()}.
   *
   * <ul>
   *   <li>Then return {@code Whole}.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#getFirstName()}
   */
  @Test
  @DisplayName("Test getFirstName(); then return 'Whole'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SlackConversation.getFirstName()"})
  void testGetFirstName_thenReturnWhole() {
    // Arrange
    SlackConversation slackConversation =
        new SlackConversation(
            SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org");

    // Act and Assert
    assertEquals("Whole", slackConversation.getFirstName());
  }

  /**
   * Test {@link SlackConversation#getLastName()}.
   *
   * <p>Method under test: {@link SlackConversation#getLastName()}
   */
  @Test
  @DisplayName("Test getLastName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SlackConversation.getLastName()"})
  void testGetLastName() {
    // Arrange
    SlackConversation slackConversation =
        new SlackConversation(
            SlackConversationType.DIRECT, "42", "Name", "", "jane.doe@example.org");

    // Act and Assert
    assertNull(slackConversation.getLastName());
  }

  /**
   * Test {@link SlackConversation#getLastName()}.
   *
   * <p>Method under test: {@link SlackConversation#getLastName()}
   */
  @Test
  @DisplayName("Test getLastName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SlackConversation.getLastName()"})
  void testGetLastName2() {
    // Arrange
    SlackConversation slackConversation =
        new SlackConversation(
            SlackConversationType.DIRECT, "42", "Name", null, "jane.doe@example.org");

    // Act and Assert
    assertNull(slackConversation.getLastName());
  }

  /**
   * Test {@link SlackConversation#getLastName()}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#getLastName()}
   */
  @Test
  @DisplayName("Test getLastName(); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SlackConversation.getLastName()"})
  void testGetLastName_thenReturnName() {
    // Arrange
    SlackConversation slackConversation =
        new SlackConversation(
            SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org");

    // Act and Assert
    assertEquals("Name", slackConversation.getLastName());
  }

  /**
   * Test {@link SlackConversation#getPointer()}.
   *
   * <ul>
   *   <li>Then return {@code @}.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#getPointer()}
   */
  @Test
  @DisplayName("Test getPointer(); then return '@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SlackConversation.getPointer()"})
  void testGetPointer_thenReturnCommercialAt() {
    // Arrange
    SlackConversation slackConversation =
        new SlackConversation(
            SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org");

    // Act and Assert
    assertEquals("@", slackConversation.getPointer());
  }

  /**
   * Test {@link SlackConversation#getPointer()}.
   *
   * <ul>
   *   <li>Then return {@code #}.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#getPointer()}
   */
  @Test
  @DisplayName("Test getPointer(); then return '#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SlackConversation.getPointer()"})
  void testGetPointer_thenReturnNumberSign() {
    // Arrange
    SlackConversation slackConversation =
        new SlackConversation(
            SlackConversationType.PUBLIC_CHANNEL,
            "42",
            "Name",
            "Whole Name",
            "jane.doe@example.org");

    // Act and Assert
    assertEquals("#", slackConversation.getPointer());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}, and {@link SlackConversation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlackConversation#equals(Object)}
   *   <li>{@link SlackConversation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    SlackConversation slackConversation2 =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    // Act and Assert
    assertEquals(slackConversation, slackConversation2);
    assertEquals(slackConversation.hashCode(), slackConversation2.hashCode());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}, and {@link SlackConversation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlackConversation#equals(Object)}
   *   <li>{@link SlackConversation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email(null)
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    SlackConversation slackConversation2 =
        SlackConversation.builder()
            .email(null)
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    // Act and Assert
    assertEquals(slackConversation, slackConversation2);
    assertEquals(slackConversation.hashCode(), slackConversation2.hashCode());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}, and {@link SlackConversation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlackConversation#equals(Object)}
   *   <li>{@link SlackConversation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id(null)
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    SlackConversation slackConversation2 =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id(null)
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    // Act and Assert
    assertEquals(slackConversation, slackConversation2);
    assertEquals(slackConversation.hashCode(), slackConversation2.hashCode());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}, and {@link SlackConversation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlackConversation#equals(Object)}
   *   <li>{@link SlackConversation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name(null)
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    SlackConversation slackConversation2 =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name(null)
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    // Act and Assert
    assertEquals(slackConversation, slackConversation2);
    assertEquals(slackConversation.hashCode(), slackConversation2.hashCode());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}, and {@link SlackConversation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlackConversation#equals(Object)}
   *   <li>{@link SlackConversation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(null)
            .wholeName("Whole Name")
            .build();
    SlackConversation slackConversation2 =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(null)
            .wholeName("Whole Name")
            .build();

    // Act and Assert
    assertEquals(slackConversation, slackConversation2);
    assertEquals(slackConversation.hashCode(), slackConversation2.hashCode());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}, and {@link SlackConversation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlackConversation#equals(Object)}
   *   <li>{@link SlackConversation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName(null)
            .build();
    SlackConversation slackConversation2 =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName(null)
            .build();

    // Act and Assert
    assertEquals(slackConversation, slackConversation2);
    assertEquals(slackConversation.hashCode(), slackConversation2.hashCode());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}, and {@link SlackConversation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlackConversation#equals(Object)}
   *   <li>{@link SlackConversation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    // Act and Assert
    assertEquals(slackConversation, slackConversation);
    int expectedHashCodeResult = slackConversation.hashCode();
    assertEquals(expectedHashCodeResult, slackConversation.hashCode());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("john.smith@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    // Act and Assert
    assertNotEquals(
        slackConversation,
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email(null)
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    // Act and Assert
    assertNotEquals(
        slackConversation,
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("Name")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    // Act and Assert
    assertNotEquals(
        slackConversation,
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id(null)
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    // Act and Assert
    assertNotEquals(
        slackConversation,
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("42")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    // Act and Assert
    assertNotEquals(
        slackConversation,
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name(null)
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    // Act and Assert
    assertNotEquals(
        slackConversation,
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(null)
            .wholeName("Whole Name")
            .build();

    // Act and Assert
    assertNotEquals(
        slackConversation,
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.PUBLIC_CHANNEL)
            .wholeName("Whole Name")
            .build();

    // Act and Assert
    assertNotEquals(
        slackConversation,
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("42")
            .build();

    // Act and Assert
    assertNotEquals(
        slackConversation,
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    SlackConversation slackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName(null)
            .build();

    // Act and Assert
    assertNotEquals(
        slackConversation,
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build());
  }

  /**
   * Test {@link SlackConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build(),
        null);
  }

  /**
   * Test {@link SlackConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackConversation.equals(Object)",
    "int SlackConversation.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build(),
        "Different type to SlackConversation");
  }

  /**
   * Test {@link SlackConversation#getId()}.
   *
   * <p>Method under test: {@link SlackConversation#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SlackConversation.getId()"})
  void testGetId() {
    // Arrange
    SlackConversation slackConversation =
        new SlackConversation(
            SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org");

    // Act and Assert
    assertEquals("42", slackConversation.getId());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SlackConversation.<init>()",
    "void SlackConversation.<init>(SlackConversationType, String, String, String, String)",
    "String SlackConversation.getEmail()",
    "String SlackConversation.getName()",
    "SlackConversationType SlackConversation.getType()",
    "String SlackConversation.getWholeName()",
    "void SlackConversation.setEmail(String)",
    "void SlackConversation.setId(String)",
    "void SlackConversation.setName(String)",
    "void SlackConversation.setType(SlackConversationType)",
    "void SlackConversation.setWholeName(String)",
    "String SlackConversation.toString()"
  })
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

    // Assert
    assertEquals("42", actualSlackConversation.getId());
    assertEquals("Name", actualName);
    assertEquals(
        "SlackConversation(type=DIRECT, id=42, name=Name, wholeName=Whole Name, email=jane.doe@example.org)",
        actualToStringResult);
    assertEquals("Whole Name", actualWholeName);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals(SlackConversationType.DIRECT, actualType);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code DIRECT}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlackConversation#SlackConversation(SlackConversationType, String, String, String,
   *       String)}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SlackConversation.<init>()",
    "void SlackConversation.<init>(SlackConversationType, String, String, String, String)",
    "String SlackConversation.getEmail()",
    "String SlackConversation.getName()",
    "SlackConversationType SlackConversation.getType()",
    "String SlackConversation.getWholeName()",
    "void SlackConversation.setEmail(String)",
    "void SlackConversation.setId(String)",
    "void SlackConversation.setName(String)",
    "void SlackConversation.setType(SlackConversationType)",
    "void SlackConversation.setWholeName(String)",
    "String SlackConversation.toString()"
  })
  void testGettersAndSetters_whenDirect() {
    // Arrange and Act
    SlackConversation actualSlackConversation =
        new SlackConversation(
            SlackConversationType.DIRECT, "42", "Name", "Whole Name", "jane.doe@example.org");
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

    // Assert
    assertEquals("42", actualSlackConversation.getId());
    assertEquals("Name", actualName);
    assertEquals(
        "SlackConversation(type=DIRECT, id=42, name=Name, wholeName=Whole Name, email=jane.doe@example.org)",
        actualToStringResult);
    assertEquals("Whole Name", actualWholeName);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals(SlackConversationType.DIRECT, actualType);
  }

  /**
   * Test SlackConversationBuilder {@link SlackConversationBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlackConversationBuilder#build()}
   *   <li>{@link SlackConversationBuilder#email(String)}
   *   <li>{@link SlackConversationBuilder#id(String)}
   *   <li>{@link SlackConversationBuilder#name(String)}
   *   <li>{@link SlackConversationBuilder#type(SlackConversationType)}
   *   <li>{@link SlackConversationBuilder#wholeName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test SlackConversationBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SlackConversationBuilder.<init>()",
    "SlackConversation SlackConversationBuilder.build()",
    "SlackConversationBuilder SlackConversationBuilder.email(String)",
    "SlackConversationBuilder SlackConversationBuilder.id(String)",
    "SlackConversationBuilder SlackConversationBuilder.name(String)",
    "String SlackConversationBuilder.toString()",
    "SlackConversationBuilder SlackConversationBuilder.type(SlackConversationType)",
    "SlackConversationBuilder SlackConversationBuilder.wholeName(String)"
  })
  void testSlackConversationBuilderBuild() {
    // Arrange and Act
    SlackConversation actualSlackConversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();

    // Assert
    assertEquals("42", actualSlackConversation.getId());
    assertEquals("@", actualSlackConversation.getPointer());
    assertEquals("Name", actualSlackConversation.getLastName());
    assertEquals("Name", actualSlackConversation.getName());
    assertEquals("Whole Name", actualSlackConversation.getTitle());
    assertEquals("Whole Name", actualSlackConversation.getWholeName());
    assertEquals("Whole", actualSlackConversation.getFirstName());
    assertEquals("jane.doe@example.org", actualSlackConversation.getEmail());
    assertEquals(SlackConversationType.DIRECT, actualSlackConversation.getType());
  }
}
