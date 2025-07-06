package org.thingsboard.server.queue.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbQueueVersionControlSettingsDiffblueTest {
  /**
   * Test {@link TbQueueVersionControlSettings#equals(Object)}, and {@link
   * TbQueueVersionControlSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueVersionControlSettings#equals(Object)}
   *   <li>{@link TbQueueVersionControlSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueVersionControlSettings.equals(Object)",
    "int TbQueueVersionControlSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings =
        new TbQueueVersionControlSettings();
    TbQueueVersionControlSettings tbQueueVersionControlSettings2 =
        new TbQueueVersionControlSettings();

    // Act and Assert
    assertEquals(tbQueueVersionControlSettings, tbQueueVersionControlSettings2);
    int expectedHashCodeResult = tbQueueVersionControlSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueVersionControlSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueVersionControlSettings#equals(Object)}, and {@link
   * TbQueueVersionControlSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueVersionControlSettings#equals(Object)}
   *   <li>{@link TbQueueVersionControlSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueVersionControlSettings.equals(Object)",
    "int TbQueueVersionControlSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings =
        new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings.setTopic("Topic");

    TbQueueVersionControlSettings tbQueueVersionControlSettings2 =
        new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings2.setTopic("Topic");

    // Act and Assert
    assertEquals(tbQueueVersionControlSettings, tbQueueVersionControlSettings2);
    int expectedHashCodeResult = tbQueueVersionControlSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueVersionControlSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueVersionControlSettings#equals(Object)}, and {@link
   * TbQueueVersionControlSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueVersionControlSettings#equals(Object)}
   *   <li>{@link TbQueueVersionControlSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueVersionControlSettings.equals(Object)",
    "int TbQueueVersionControlSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings =
        new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings.setUsageStatsTopic("Usage Stats Topic");

    TbQueueVersionControlSettings tbQueueVersionControlSettings2 =
        new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings2.setUsageStatsTopic("Usage Stats Topic");

    // Act and Assert
    assertEquals(tbQueueVersionControlSettings, tbQueueVersionControlSettings2);
    int expectedHashCodeResult = tbQueueVersionControlSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueVersionControlSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueVersionControlSettings#equals(Object)}, and {@link
   * TbQueueVersionControlSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueVersionControlSettings#equals(Object)}
   *   <li>{@link TbQueueVersionControlSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueVersionControlSettings.equals(Object)",
    "int TbQueueVersionControlSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings =
        new TbQueueVersionControlSettings();

    // Act and Assert
    assertEquals(tbQueueVersionControlSettings, tbQueueVersionControlSettings);
    int expectedHashCodeResult = tbQueueVersionControlSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueVersionControlSettings.hashCode());
  }

  /**
   * Test {@link TbQueueVersionControlSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueVersionControlSettings.equals(Object)",
    "int TbQueueVersionControlSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueVersionControlSettings(), 1);
  }

  /**
   * Test {@link TbQueueVersionControlSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueVersionControlSettings.equals(Object)",
    "int TbQueueVersionControlSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings =
        new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueVersionControlSettings, new TbQueueVersionControlSettings());
  }

  /**
   * Test {@link TbQueueVersionControlSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueVersionControlSettings.equals(Object)",
    "int TbQueueVersionControlSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings =
        new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings.setUsageStatsTopic("Usage Stats Topic");

    // Act and Assert
    assertNotEquals(tbQueueVersionControlSettings, new TbQueueVersionControlSettings());
  }

  /**
   * Test {@link TbQueueVersionControlSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueVersionControlSettings.equals(Object)",
    "int TbQueueVersionControlSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings =
        new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings.setPartitions(1);

    // Act and Assert
    assertNotEquals(tbQueueVersionControlSettings, new TbQueueVersionControlSettings());
  }

  /**
   * Test {@link TbQueueVersionControlSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueVersionControlSettings.equals(Object)",
    "int TbQueueVersionControlSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings =
        new TbQueueVersionControlSettings();

    TbQueueVersionControlSettings tbQueueVersionControlSettings2 =
        new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueVersionControlSettings, tbQueueVersionControlSettings2);
  }

  /**
   * Test {@link TbQueueVersionControlSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueVersionControlSettings.equals(Object)",
    "int TbQueueVersionControlSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings =
        new TbQueueVersionControlSettings();

    TbQueueVersionControlSettings tbQueueVersionControlSettings2 =
        new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings2.setUsageStatsTopic("Usage Stats Topic");

    // Act and Assert
    assertNotEquals(tbQueueVersionControlSettings, tbQueueVersionControlSettings2);
  }

  /**
   * Test {@link TbQueueVersionControlSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueVersionControlSettings.equals(Object)",
    "int TbQueueVersionControlSettings.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueVersionControlSettings(), null);
  }

  /**
   * Test {@link TbQueueVersionControlSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueVersionControlSettings.equals(Object)",
    "int TbQueueVersionControlSettings.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbQueueVersionControlSettings(), "Different type to TbQueueVersionControlSettings");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueVersionControlSettings#setPartitions(int)}
   *   <li>{@link TbQueueVersionControlSettings#setTopic(String)}
   *   <li>{@link TbQueueVersionControlSettings#setUsageStatsTopic(String)}
   *   <li>{@link TbQueueVersionControlSettings#toString()}
   *   <li>{@link TbQueueVersionControlSettings#getPartitions()}
   *   <li>{@link TbQueueVersionControlSettings#getTopic()}
   *   <li>{@link TbQueueVersionControlSettings#getUsageStatsTopic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int TbQueueVersionControlSettings.getPartitions()",
    "String TbQueueVersionControlSettings.getTopic()",
    "String TbQueueVersionControlSettings.getUsageStatsTopic()",
    "void TbQueueVersionControlSettings.setPartitions(int)",
    "void TbQueueVersionControlSettings.setTopic(String)",
    "void TbQueueVersionControlSettings.setUsageStatsTopic(String)",
    "String TbQueueVersionControlSettings.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings =
        new TbQueueVersionControlSettings();

    // Act
    tbQueueVersionControlSettings.setPartitions(1);
    tbQueueVersionControlSettings.setTopic("Topic");
    tbQueueVersionControlSettings.setUsageStatsTopic("Usage Stats Topic");
    String actualToStringResult = tbQueueVersionControlSettings.toString();
    int actualPartitions = tbQueueVersionControlSettings.getPartitions();
    String actualTopic = tbQueueVersionControlSettings.getTopic();

    // Assert
    assertEquals(
        "TbQueueVersionControlSettings(topic=Topic, usageStatsTopic=Usage Stats Topic, partitions=1)",
        actualToStringResult);
    assertEquals("Topic", actualTopic);
    assertEquals("Usage Stats Topic", tbQueueVersionControlSettings.getUsageStatsTopic());
    assertEquals(1, actualPartitions);
  }
}
