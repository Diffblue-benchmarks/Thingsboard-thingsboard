package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbDeviceProfileNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbDeviceProfileNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbDeviceProfileNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbDeviceProfileNodeConfiguration TbDeviceProfileNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange
    TbDeviceProfileNodeConfiguration tbDeviceProfileNodeConfiguration =
        new TbDeviceProfileNodeConfiguration();

    // Act
    TbDeviceProfileNodeConfiguration actualDefaultConfigurationResult =
        tbDeviceProfileNodeConfiguration.defaultConfiguration();

    // Assert
    assertEquals(tbDeviceProfileNodeConfiguration, actualDefaultConfigurationResult);
  }

  /**
   * Test {@link TbDeviceProfileNodeConfiguration#equals(Object)}, and {@link
   * TbDeviceProfileNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbDeviceProfileNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeviceProfileNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceProfileNodeConfiguration.equals(Object)",
    "int TbDeviceProfileNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbDeviceProfileNodeConfiguration tbDeviceProfileNodeConfiguration =
        new TbDeviceProfileNodeConfiguration();
    TbDeviceProfileNodeConfiguration tbDeviceProfileNodeConfiguration2 =
        new TbDeviceProfileNodeConfiguration();

    // Act and Assert
    assertEquals(tbDeviceProfileNodeConfiguration, tbDeviceProfileNodeConfiguration2);
    assertEquals(
        tbDeviceProfileNodeConfiguration.hashCode(), tbDeviceProfileNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbDeviceProfileNodeConfiguration#equals(Object)}, and {@link
   * TbDeviceProfileNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbDeviceProfileNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeviceProfileNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceProfileNodeConfiguration.equals(Object)",
    "int TbDeviceProfileNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbDeviceProfileNodeConfiguration tbDeviceProfileNodeConfiguration =
        new TbDeviceProfileNodeConfiguration();

    // Act and Assert
    assertEquals(tbDeviceProfileNodeConfiguration, tbDeviceProfileNodeConfiguration);
    int expectedHashCodeResult = tbDeviceProfileNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbDeviceProfileNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbDeviceProfileNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceProfileNodeConfiguration.equals(Object)",
    "int TbDeviceProfileNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbDeviceProfileNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbDeviceProfileNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceProfileNodeConfiguration.equals(Object)",
    "int TbDeviceProfileNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbDeviceProfileNodeConfiguration tbDeviceProfileNodeConfiguration =
        new TbDeviceProfileNodeConfiguration();
    tbDeviceProfileNodeConfiguration.setPersistAlarmRulesState(true);

    // Act and Assert
    assertNotEquals(tbDeviceProfileNodeConfiguration, new TbDeviceProfileNodeConfiguration());
  }

  /**
   * Test {@link TbDeviceProfileNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceProfileNodeConfiguration.equals(Object)",
    "int TbDeviceProfileNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbDeviceProfileNodeConfiguration tbDeviceProfileNodeConfiguration =
        new TbDeviceProfileNodeConfiguration();
    tbDeviceProfileNodeConfiguration.setFetchAlarmRulesStateOnStart(true);

    // Act and Assert
    assertNotEquals(tbDeviceProfileNodeConfiguration, new TbDeviceProfileNodeConfiguration());
  }

  /**
   * Test {@link TbDeviceProfileNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceProfileNodeConfiguration.equals(Object)",
    "int TbDeviceProfileNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbDeviceProfileNodeConfiguration(), null);
  }

  /**
   * Test {@link TbDeviceProfileNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceProfileNodeConfiguration.equals(Object)",
    "int TbDeviceProfileNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbDeviceProfileNodeConfiguration(),
        "Different type to TbDeviceProfileNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbDeviceProfileNodeConfiguration}
   *   <li>{@link TbDeviceProfileNodeConfiguration#setFetchAlarmRulesStateOnStart(boolean)}
   *   <li>{@link TbDeviceProfileNodeConfiguration#setPersistAlarmRulesState(boolean)}
   *   <li>{@link TbDeviceProfileNodeConfiguration#toString()}
   *   <li>{@link TbDeviceProfileNodeConfiguration#isFetchAlarmRulesStateOnStart()}
   *   <li>{@link TbDeviceProfileNodeConfiguration#isPersistAlarmRulesState()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbDeviceProfileNodeConfiguration.<init>()",
    "boolean TbDeviceProfileNodeConfiguration.isFetchAlarmRulesStateOnStart()",
    "boolean TbDeviceProfileNodeConfiguration.isPersistAlarmRulesState()",
    "void TbDeviceProfileNodeConfiguration.setFetchAlarmRulesStateOnStart(boolean)",
    "void TbDeviceProfileNodeConfiguration.setPersistAlarmRulesState(boolean)",
    "String TbDeviceProfileNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbDeviceProfileNodeConfiguration actualTbDeviceProfileNodeConfiguration =
        new TbDeviceProfileNodeConfiguration();
    actualTbDeviceProfileNodeConfiguration.setFetchAlarmRulesStateOnStart(true);
    actualTbDeviceProfileNodeConfiguration.setPersistAlarmRulesState(true);
    String actualToStringResult = actualTbDeviceProfileNodeConfiguration.toString();
    boolean actualIsFetchAlarmRulesStateOnStartResult =
        actualTbDeviceProfileNodeConfiguration.isFetchAlarmRulesStateOnStart();

    // Assert
    assertEquals(
        "TbDeviceProfileNodeConfiguration(persistAlarmRulesState=true, fetchAlarmRulesStateOnStart=true)",
        actualToStringResult);
    assertTrue(actualIsFetchAlarmRulesStateOnStartResult);
    assertTrue(actualTbDeviceProfileNodeConfiguration.isPersistAlarmRulesState());
  }
}
