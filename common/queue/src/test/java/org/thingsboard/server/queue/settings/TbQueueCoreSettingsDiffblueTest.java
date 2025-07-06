package org.thingsboard.server.queue.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbQueueCoreSettingsDiffblueTest {
  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}, and {@link TbQueueCoreSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueCoreSettings#equals(Object)}
   *   <li>{@link TbQueueCoreSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();

    // Act and Assert
    assertEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
    int expectedHashCodeResult = tbQueueCoreSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueCoreSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}, and {@link TbQueueCoreSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueCoreSettings#equals(Object)}
   *   <li>{@link TbQueueCoreSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setTopic("Topic");

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setTopic("Topic");

    // Act and Assert
    assertEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
    int expectedHashCodeResult = tbQueueCoreSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueCoreSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}, and {@link TbQueueCoreSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueCoreSettings#equals(Object)}
   *   <li>{@link TbQueueCoreSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setOtaPackageTopic("java.text");

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setOtaPackageTopic("java.text");

    // Act and Assert
    assertEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
    int expectedHashCodeResult = tbQueueCoreSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueCoreSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}, and {@link TbQueueCoreSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueCoreSettings#equals(Object)}
   *   <li>{@link TbQueueCoreSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setUsageStatsTopic("Usage Stats Topic");

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setUsageStatsTopic("Usage Stats Topic");

    // Act and Assert
    assertEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
    int expectedHashCodeResult = tbQueueCoreSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueCoreSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}, and {@link TbQueueCoreSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueCoreSettings#equals(Object)}
   *   <li>{@link TbQueueCoreSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setHousekeeperTopic("Housekeeper Topic");

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setHousekeeperTopic("Housekeeper Topic");

    // Act and Assert
    assertEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
    int expectedHashCodeResult = tbQueueCoreSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueCoreSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}, and {@link TbQueueCoreSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueCoreSettings#equals(Object)}
   *   <li>{@link TbQueueCoreSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setHousekeeperReprocessingTopic("Housekeeper Reprocessing Topic");

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setHousekeeperReprocessingTopic("Housekeeper Reprocessing Topic");

    // Act and Assert
    assertEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
    int expectedHashCodeResult = tbQueueCoreSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueCoreSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}, and {@link TbQueueCoreSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueCoreSettings#equals(Object)}
   *   <li>{@link TbQueueCoreSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();

    // Act and Assert
    assertEquals(tbQueueCoreSettings, tbQueueCoreSettings);
    int expectedHashCodeResult = tbQueueCoreSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueCoreSettings.hashCode());
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueCoreSettings(), 1);
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, new TbQueueCoreSettings());
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setOtaPackageTopic("java.text");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, new TbQueueCoreSettings());
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setUsageStatsTopic("Usage Stats Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, new TbQueueCoreSettings());
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setHousekeeperTopic("Housekeeper Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, new TbQueueCoreSettings());
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setHousekeeperReprocessingTopic("Housekeeper Reprocessing Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, new TbQueueCoreSettings());
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setPartitions(1);

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, new TbQueueCoreSettings());
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setOtaPackageTopic("java.text");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setUsageStatsTopic("Usage Stats Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setHousekeeperTopic("Housekeeper Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setHousekeeperReprocessingTopic("Housekeeper Reprocessing Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueCoreSettings(), null);
  }

  /**
   * Test {@link TbQueueCoreSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueCoreSettings.equals(Object)",
    "int TbQueueCoreSettings.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueCoreSettings(), "Different type to TbQueueCoreSettings");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueCoreSettings#setHousekeeperReprocessingTopic(String)}
   *   <li>{@link TbQueueCoreSettings#setHousekeeperTopic(String)}
   *   <li>{@link TbQueueCoreSettings#setOtaPackageTopic(String)}
   *   <li>{@link TbQueueCoreSettings#setPartitions(int)}
   *   <li>{@link TbQueueCoreSettings#setTopic(String)}
   *   <li>{@link TbQueueCoreSettings#setUsageStatsTopic(String)}
   *   <li>{@link TbQueueCoreSettings#toString()}
   *   <li>{@link TbQueueCoreSettings#getHousekeeperReprocessingTopic()}
   *   <li>{@link TbQueueCoreSettings#getHousekeeperTopic()}
   *   <li>{@link TbQueueCoreSettings#getOtaPackageTopic()}
   *   <li>{@link TbQueueCoreSettings#getPartitions()}
   *   <li>{@link TbQueueCoreSettings#getTopic()}
   *   <li>{@link TbQueueCoreSettings#getUsageStatsTopic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "String TbQueueCoreSettings.getHousekeeperReprocessingTopic()",
    "String TbQueueCoreSettings.getHousekeeperTopic()",
    "String TbQueueCoreSettings.getOtaPackageTopic()",
    "int TbQueueCoreSettings.getPartitions()",
    "String TbQueueCoreSettings.getTopic()",
    "String TbQueueCoreSettings.getUsageStatsTopic()",
    "void TbQueueCoreSettings.setHousekeeperReprocessingTopic(String)",
    "void TbQueueCoreSettings.setHousekeeperTopic(String)",
    "void TbQueueCoreSettings.setOtaPackageTopic(String)",
    "void TbQueueCoreSettings.setPartitions(int)",
    "void TbQueueCoreSettings.setTopic(String)",
    "void TbQueueCoreSettings.setUsageStatsTopic(String)",
    "String TbQueueCoreSettings.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();

    // Act
    tbQueueCoreSettings.setHousekeeperReprocessingTopic("Housekeeper Reprocessing Topic");
    tbQueueCoreSettings.setHousekeeperTopic("Housekeeper Topic");
    tbQueueCoreSettings.setOtaPackageTopic("java.text");
    tbQueueCoreSettings.setPartitions(1);
    tbQueueCoreSettings.setTopic("Topic");
    tbQueueCoreSettings.setUsageStatsTopic("Usage Stats Topic");
    String actualToStringResult = tbQueueCoreSettings.toString();
    String actualHousekeeperReprocessingTopic =
        tbQueueCoreSettings.getHousekeeperReprocessingTopic();
    String actualHousekeeperTopic = tbQueueCoreSettings.getHousekeeperTopic();
    String actualOtaPackageTopic = tbQueueCoreSettings.getOtaPackageTopic();
    int actualPartitions = tbQueueCoreSettings.getPartitions();
    String actualTopic = tbQueueCoreSettings.getTopic();

    // Assert
    assertEquals("Housekeeper Reprocessing Topic", actualHousekeeperReprocessingTopic);
    assertEquals("Housekeeper Topic", actualHousekeeperTopic);
    assertEquals(
        "TbQueueCoreSettings(topic=Topic, otaPackageTopic=java.text, usageStatsTopic=Usage Stats Topic,"
            + " housekeeperTopic=Housekeeper Topic, housekeeperReprocessingTopic=Housekeeper Reprocessing Topic,"
            + " partitions=1)",
        actualToStringResult);
    assertEquals("Topic", actualTopic);
    assertEquals("Usage Stats Topic", tbQueueCoreSettings.getUsageStatsTopic());
    assertEquals("java.text", actualOtaPackageTopic);
    assertEquals(1, actualPartitions);
  }
}
