package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbGpsGeofencingActionNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGpsGeofencingActionNodeConfiguration TbGpsGeofencingActionNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbGpsGeofencingActionNodeConfiguration actualDefaultConfigurationResult =
        new TbGpsGeofencingActionNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals("MINUTES", actualDefaultConfigurationResult.getMinInsideDurationTimeUnit());
    assertEquals("MINUTES", actualDefaultConfigurationResult.getMinOutsideDurationTimeUnit());
    assertEquals("latitude", actualDefaultConfigurationResult.getLatitudeKeyName());
    assertEquals("longitude", actualDefaultConfigurationResult.getLongitudeKeyName());
    assertEquals("ss_perimeter", actualDefaultConfigurationResult.getPerimeterKeyName());
    assertNull(actualDefaultConfigurationResult.getCenterLatitude());
    assertNull(actualDefaultConfigurationResult.getCenterLongitude());
    assertNull(actualDefaultConfigurationResult.getRange());
    assertNull(actualDefaultConfigurationResult.getPolygonsDefinition());
    assertNull(actualDefaultConfigurationResult.getRangeUnit());
    assertEquals(1, actualDefaultConfigurationResult.getMinInsideDuration());
    assertEquals(1, actualDefaultConfigurationResult.getMinOutsideDuration());
    assertEquals(PerimeterType.POLYGON, actualDefaultConfigurationResult.getPerimeterType());
    assertTrue(actualDefaultConfigurationResult.isReportPresenceStatusOnEachMessage());
    assertTrue(actualDefaultConfigurationResult.isFetchPerimeterInfoFromMessageMetadata());
  }

  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}, and {@link
   * TbGpsGeofencingActionNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGpsGeofencingActionNodeConfiguration.equals(Object)",
    "int TbGpsGeofencingActionNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration =
        new TbGpsGeofencingActionNodeConfiguration();
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration2 =
        new TbGpsGeofencingActionNodeConfiguration();

    // Act and Assert
    assertEquals(tbGpsGeofencingActionNodeConfiguration, tbGpsGeofencingActionNodeConfiguration2);
    assertEquals(
        tbGpsGeofencingActionNodeConfiguration.hashCode(),
        tbGpsGeofencingActionNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}, and {@link
   * TbGpsGeofencingActionNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGpsGeofencingActionNodeConfiguration.equals(Object)",
    "int TbGpsGeofencingActionNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration =
        new TbGpsGeofencingActionNodeConfiguration();
    tbGpsGeofencingActionNodeConfiguration.setMinInsideDurationTimeUnit(
        "Min Inside Duration Time Unit");

    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration2 =
        new TbGpsGeofencingActionNodeConfiguration();
    tbGpsGeofencingActionNodeConfiguration2.setMinInsideDurationTimeUnit(
        "Min Inside Duration Time Unit");

    // Act and Assert
    assertEquals(tbGpsGeofencingActionNodeConfiguration, tbGpsGeofencingActionNodeConfiguration2);
    assertEquals(
        tbGpsGeofencingActionNodeConfiguration.hashCode(),
        tbGpsGeofencingActionNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}, and {@link
   * TbGpsGeofencingActionNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGpsGeofencingActionNodeConfiguration.equals(Object)",
    "int TbGpsGeofencingActionNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration =
        new TbGpsGeofencingActionNodeConfiguration();
    tbGpsGeofencingActionNodeConfiguration.setMinOutsideDurationTimeUnit(
        "Min Outside Duration Time Unit");

    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration2 =
        new TbGpsGeofencingActionNodeConfiguration();
    tbGpsGeofencingActionNodeConfiguration2.setMinOutsideDurationTimeUnit(
        "Min Outside Duration Time Unit");

    // Act and Assert
    assertEquals(tbGpsGeofencingActionNodeConfiguration, tbGpsGeofencingActionNodeConfiguration2);
    assertEquals(
        tbGpsGeofencingActionNodeConfiguration.hashCode(),
        tbGpsGeofencingActionNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}, and {@link
   * TbGpsGeofencingActionNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGpsGeofencingActionNodeConfiguration.equals(Object)",
    "int TbGpsGeofencingActionNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration =
        new TbGpsGeofencingActionNodeConfiguration();

    // Act and Assert
    assertEquals(tbGpsGeofencingActionNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
    int expectedHashCodeResult = tbGpsGeofencingActionNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGpsGeofencingActionNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGpsGeofencingActionNodeConfiguration.equals(Object)",
    "int TbGpsGeofencingActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGpsGeofencingActionNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGpsGeofencingActionNodeConfiguration.equals(Object)",
    "int TbGpsGeofencingActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration =
        new TbGpsGeofencingActionNodeConfiguration();
    tbGpsGeofencingActionNodeConfiguration.setMinInsideDuration(1);

    // Act and Assert
    assertNotEquals(
        tbGpsGeofencingActionNodeConfiguration, new TbGpsGeofencingActionNodeConfiguration());
  }

  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGpsGeofencingActionNodeConfiguration.equals(Object)",
    "int TbGpsGeofencingActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration =
        new TbGpsGeofencingActionNodeConfiguration();
    tbGpsGeofencingActionNodeConfiguration.setMinOutsideDuration(1);

    // Act and Assert
    assertNotEquals(
        tbGpsGeofencingActionNodeConfiguration, new TbGpsGeofencingActionNodeConfiguration());
  }

  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGpsGeofencingActionNodeConfiguration.equals(Object)",
    "int TbGpsGeofencingActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration =
        new TbGpsGeofencingActionNodeConfiguration();
    tbGpsGeofencingActionNodeConfiguration.setMinInsideDurationTimeUnit(
        "Min Inside Duration Time Unit");

    // Act and Assert
    assertNotEquals(
        tbGpsGeofencingActionNodeConfiguration, new TbGpsGeofencingActionNodeConfiguration());
  }

  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGpsGeofencingActionNodeConfiguration.equals(Object)",
    "int TbGpsGeofencingActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration =
        new TbGpsGeofencingActionNodeConfiguration();
    tbGpsGeofencingActionNodeConfiguration.setMinOutsideDurationTimeUnit(
        "Min Outside Duration Time Unit");

    // Act and Assert
    assertNotEquals(
        tbGpsGeofencingActionNodeConfiguration, new TbGpsGeofencingActionNodeConfiguration());
  }

  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGpsGeofencingActionNodeConfiguration.equals(Object)",
    "int TbGpsGeofencingActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration =
        new TbGpsGeofencingActionNodeConfiguration();
    tbGpsGeofencingActionNodeConfiguration.setReportPresenceStatusOnEachMessage(true);

    // Act and Assert
    assertNotEquals(
        tbGpsGeofencingActionNodeConfiguration, new TbGpsGeofencingActionNodeConfiguration());
  }

  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGpsGeofencingActionNodeConfiguration.equals(Object)",
    "int TbGpsGeofencingActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration =
        new TbGpsGeofencingActionNodeConfiguration();

    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration2 =
        new TbGpsGeofencingActionNodeConfiguration();
    tbGpsGeofencingActionNodeConfiguration2.setMinInsideDurationTimeUnit(
        "Min Inside Duration Time Unit");

    // Act and Assert
    assertNotEquals(
        tbGpsGeofencingActionNodeConfiguration, tbGpsGeofencingActionNodeConfiguration2);
  }

  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGpsGeofencingActionNodeConfiguration.equals(Object)",
    "int TbGpsGeofencingActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration =
        new TbGpsGeofencingActionNodeConfiguration();

    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration2 =
        new TbGpsGeofencingActionNodeConfiguration();
    tbGpsGeofencingActionNodeConfiguration2.setMinOutsideDurationTimeUnit(
        "Min Outside Duration Time Unit");

    // Act and Assert
    assertNotEquals(
        tbGpsGeofencingActionNodeConfiguration, tbGpsGeofencingActionNodeConfiguration2);
  }

  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGpsGeofencingActionNodeConfiguration.equals(Object)",
    "int TbGpsGeofencingActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGpsGeofencingActionNodeConfiguration(), null);
  }

  /**
   * Test {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGpsGeofencingActionNodeConfiguration.equals(Object)",
    "int TbGpsGeofencingActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbGpsGeofencingActionNodeConfiguration(),
        "Different type to TbGpsGeofencingActionNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGpsGeofencingActionNodeConfiguration}
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#setMinInsideDuration(int)}
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#setMinInsideDurationTimeUnit(String)}
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#setMinOutsideDuration(int)}
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#setMinOutsideDurationTimeUnit(String)}
   *   <li>{@link
   *       TbGpsGeofencingActionNodeConfiguration#setReportPresenceStatusOnEachMessage(boolean)}
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#toString()}
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#getMinInsideDuration()}
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#getMinInsideDurationTimeUnit()}
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#getMinOutsideDuration()}
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#getMinOutsideDurationTimeUnit()}
   *   <li>{@link TbGpsGeofencingActionNodeConfiguration#isReportPresenceStatusOnEachMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbGpsGeofencingActionNodeConfiguration.<init>()",
    "int TbGpsGeofencingActionNodeConfiguration.getMinInsideDuration()",
    "String TbGpsGeofencingActionNodeConfiguration.getMinInsideDurationTimeUnit()",
    "int TbGpsGeofencingActionNodeConfiguration.getMinOutsideDuration()",
    "String TbGpsGeofencingActionNodeConfiguration.getMinOutsideDurationTimeUnit()",
    "boolean TbGpsGeofencingActionNodeConfiguration.isReportPresenceStatusOnEachMessage()",
    "void TbGpsGeofencingActionNodeConfiguration.setMinInsideDuration(int)",
    "void TbGpsGeofencingActionNodeConfiguration.setMinInsideDurationTimeUnit(String)",
    "void TbGpsGeofencingActionNodeConfiguration.setMinOutsideDuration(int)",
    "void TbGpsGeofencingActionNodeConfiguration.setMinOutsideDurationTimeUnit(String)",
    "void TbGpsGeofencingActionNodeConfiguration.setReportPresenceStatusOnEachMessage(boolean)",
    "String TbGpsGeofencingActionNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbGpsGeofencingActionNodeConfiguration actualTbGpsGeofencingActionNodeConfiguration =
        new TbGpsGeofencingActionNodeConfiguration();
    actualTbGpsGeofencingActionNodeConfiguration.setMinInsideDuration(1);
    actualTbGpsGeofencingActionNodeConfiguration.setMinInsideDurationTimeUnit(
        "Min Inside Duration Time Unit");
    actualTbGpsGeofencingActionNodeConfiguration.setMinOutsideDuration(1);
    actualTbGpsGeofencingActionNodeConfiguration.setMinOutsideDurationTimeUnit(
        "Min Outside Duration Time Unit");
    actualTbGpsGeofencingActionNodeConfiguration.setReportPresenceStatusOnEachMessage(true);
    String actualToStringResult = actualTbGpsGeofencingActionNodeConfiguration.toString();
    int actualMinInsideDuration =
        actualTbGpsGeofencingActionNodeConfiguration.getMinInsideDuration();
    String actualMinInsideDurationTimeUnit =
        actualTbGpsGeofencingActionNodeConfiguration.getMinInsideDurationTimeUnit();
    int actualMinOutsideDuration =
        actualTbGpsGeofencingActionNodeConfiguration.getMinOutsideDuration();
    String actualMinOutsideDurationTimeUnit =
        actualTbGpsGeofencingActionNodeConfiguration.getMinOutsideDurationTimeUnit();
    boolean actualIsReportPresenceStatusOnEachMessageResult =
        actualTbGpsGeofencingActionNodeConfiguration.isReportPresenceStatusOnEachMessage();

    // Assert
    assertEquals("Min Inside Duration Time Unit", actualMinInsideDurationTimeUnit);
    assertEquals("Min Outside Duration Time Unit", actualMinOutsideDurationTimeUnit);
    assertEquals(
        "TbGpsGeofencingActionNodeConfiguration(minInsideDuration=1, minOutsideDuration=1, minInsideDurationTimeUnit"
            + "=Min Inside Duration Time Unit, minOutsideDurationTimeUnit=Min Outside Duration Time Unit, reportPre"
            + "senceStatusOnEachMessage=true)",
        actualToStringResult);
    assertNull(actualTbGpsGeofencingActionNodeConfiguration.getCenterLatitude());
    assertNull(actualTbGpsGeofencingActionNodeConfiguration.getCenterLongitude());
    assertNull(actualTbGpsGeofencingActionNodeConfiguration.getRange());
    assertNull(actualTbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName());
    assertNull(actualTbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName());
    assertNull(actualTbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName());
    assertNull(actualTbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition());
    assertNull(actualTbGpsGeofencingActionNodeConfiguration.getPerimeterType());
    assertNull(actualTbGpsGeofencingActionNodeConfiguration.getRangeUnit());
    assertEquals(1, actualMinInsideDuration);
    assertEquals(1, actualMinOutsideDuration);
    assertFalse(
        actualTbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata());
    assertTrue(actualIsReportPresenceStatusOnEachMessageResult);
  }
}
