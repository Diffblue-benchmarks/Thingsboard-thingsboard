package org.thingsboard.rule.engine.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.NotificationTemplateId;

class TbNotificationNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbNotificationNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbNotificationNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbNotificationNodeConfiguration TbNotificationNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange
    TbNotificationNodeConfiguration tbNotificationNodeConfiguration =
        new TbNotificationNodeConfiguration();

    // Act
    TbNotificationNodeConfiguration actualDefaultConfigurationResult =
        tbNotificationNodeConfiguration.defaultConfiguration();

    // Assert
    assertEquals(tbNotificationNodeConfiguration, actualDefaultConfigurationResult);
  }

  /**
   * Test {@link TbNotificationNodeConfiguration#equals(Object)}, and {@link
   * TbNotificationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNotificationNodeConfiguration#equals(Object)}
   *   <li>{@link TbNotificationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNotificationNodeConfiguration.equals(Object)",
    "int TbNotificationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbNotificationNodeConfiguration tbNotificationNodeConfiguration =
        new TbNotificationNodeConfiguration();
    TbNotificationNodeConfiguration tbNotificationNodeConfiguration2 =
        new TbNotificationNodeConfiguration();

    // Act and Assert
    assertEquals(tbNotificationNodeConfiguration, tbNotificationNodeConfiguration2);
    assertEquals(
        tbNotificationNodeConfiguration.hashCode(), tbNotificationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbNotificationNodeConfiguration#equals(Object)}, and {@link
   * TbNotificationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNotificationNodeConfiguration#equals(Object)}
   *   <li>{@link TbNotificationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNotificationNodeConfiguration.equals(Object)",
    "int TbNotificationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbNotificationNodeConfiguration tbNotificationNodeConfiguration =
        new TbNotificationNodeConfiguration();
    tbNotificationNodeConfiguration.setTargets(new ArrayList<>());

    TbNotificationNodeConfiguration tbNotificationNodeConfiguration2 =
        new TbNotificationNodeConfiguration();
    tbNotificationNodeConfiguration2.setTargets(new ArrayList<>());

    // Act and Assert
    assertEquals(tbNotificationNodeConfiguration, tbNotificationNodeConfiguration2);
    assertEquals(
        tbNotificationNodeConfiguration.hashCode(), tbNotificationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbNotificationNodeConfiguration#equals(Object)}, and {@link
   * TbNotificationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNotificationNodeConfiguration#equals(Object)}
   *   <li>{@link TbNotificationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNotificationNodeConfiguration.equals(Object)",
    "int TbNotificationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbNotificationNodeConfiguration tbNotificationNodeConfiguration =
        new TbNotificationNodeConfiguration();
    tbNotificationNodeConfiguration.setTemplateId(
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbNotificationNodeConfiguration tbNotificationNodeConfiguration2 =
        new TbNotificationNodeConfiguration();
    tbNotificationNodeConfiguration2.setTemplateId(
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals(tbNotificationNodeConfiguration, tbNotificationNodeConfiguration2);
    assertEquals(
        tbNotificationNodeConfiguration.hashCode(), tbNotificationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbNotificationNodeConfiguration#equals(Object)}, and {@link
   * TbNotificationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNotificationNodeConfiguration#equals(Object)}
   *   <li>{@link TbNotificationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNotificationNodeConfiguration.equals(Object)",
    "int TbNotificationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbNotificationNodeConfiguration tbNotificationNodeConfiguration =
        new TbNotificationNodeConfiguration();

    // Act and Assert
    assertEquals(tbNotificationNodeConfiguration, tbNotificationNodeConfiguration);
    int expectedHashCodeResult = tbNotificationNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbNotificationNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbNotificationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNotificationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNotificationNodeConfiguration.equals(Object)",
    "int TbNotificationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbNotificationNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbNotificationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNotificationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNotificationNodeConfiguration.equals(Object)",
    "int TbNotificationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbNotificationNodeConfiguration tbNotificationNodeConfiguration =
        new TbNotificationNodeConfiguration();
    tbNotificationNodeConfiguration.setTargets(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbNotificationNodeConfiguration, new TbNotificationNodeConfiguration());
  }

  /**
   * Test {@link TbNotificationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNotificationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNotificationNodeConfiguration.equals(Object)",
    "int TbNotificationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbNotificationNodeConfiguration tbNotificationNodeConfiguration =
        new TbNotificationNodeConfiguration();
    tbNotificationNodeConfiguration.setTemplateId(
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(tbNotificationNodeConfiguration, new TbNotificationNodeConfiguration());
  }

  /**
   * Test {@link TbNotificationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNotificationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNotificationNodeConfiguration.equals(Object)",
    "int TbNotificationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbNotificationNodeConfiguration tbNotificationNodeConfiguration =
        new TbNotificationNodeConfiguration();

    TbNotificationNodeConfiguration tbNotificationNodeConfiguration2 =
        new TbNotificationNodeConfiguration();
    tbNotificationNodeConfiguration2.setTargets(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbNotificationNodeConfiguration, tbNotificationNodeConfiguration2);
  }

  /**
   * Test {@link TbNotificationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNotificationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNotificationNodeConfiguration.equals(Object)",
    "int TbNotificationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbNotificationNodeConfiguration tbNotificationNodeConfiguration =
        new TbNotificationNodeConfiguration();

    TbNotificationNodeConfiguration tbNotificationNodeConfiguration2 =
        new TbNotificationNodeConfiguration();
    tbNotificationNodeConfiguration2.setTemplateId(
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(tbNotificationNodeConfiguration, tbNotificationNodeConfiguration2);
  }

  /**
   * Test {@link TbNotificationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNotificationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNotificationNodeConfiguration.equals(Object)",
    "int TbNotificationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbNotificationNodeConfiguration(), null);
  }

  /**
   * Test {@link TbNotificationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNotificationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNotificationNodeConfiguration.equals(Object)",
    "int TbNotificationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbNotificationNodeConfiguration(), "Different type to TbNotificationNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbNotificationNodeConfiguration}
   *   <li>{@link TbNotificationNodeConfiguration#setTargets(List)}
   *   <li>{@link TbNotificationNodeConfiguration#setTemplateId(NotificationTemplateId)}
   *   <li>{@link TbNotificationNodeConfiguration#toString()}
   *   <li>{@link TbNotificationNodeConfiguration#getTargets()}
   *   <li>{@link TbNotificationNodeConfiguration#getTemplateId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbNotificationNodeConfiguration.<init>()",
    "List TbNotificationNodeConfiguration.getTargets()",
    "NotificationTemplateId TbNotificationNodeConfiguration.getTemplateId()",
    "void TbNotificationNodeConfiguration.setTargets(List)",
    "void TbNotificationNodeConfiguration.setTemplateId(NotificationTemplateId)",
    "String TbNotificationNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbNotificationNodeConfiguration actualTbNotificationNodeConfiguration =
        new TbNotificationNodeConfiguration();
    ArrayList<UUID> targets = new ArrayList<>();
    actualTbNotificationNodeConfiguration.setTargets(targets);
    NotificationTemplateId templateId =
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualTbNotificationNodeConfiguration.setTemplateId(templateId);
    String actualToStringResult = actualTbNotificationNodeConfiguration.toString();
    List<UUID> actualTargets = actualTbNotificationNodeConfiguration.getTargets();
    NotificationTemplateId actualTemplateId = actualTbNotificationNodeConfiguration.getTemplateId();

    // Assert
    assertEquals(
        "TbNotificationNodeConfiguration(targets=[], templateId=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertTrue(actualTargets.isEmpty());
    assertSame(targets, actualTargets);
    assertSame(templateId, actualTemplateId);
  }
}
