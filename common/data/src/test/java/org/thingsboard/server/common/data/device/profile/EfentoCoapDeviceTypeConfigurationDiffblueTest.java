package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.CoapDeviceType;

class EfentoCoapDeviceTypeConfigurationDiffblueTest {
  /**
   * Test {@link EfentoCoapDeviceTypeConfiguration#equals(Object)}, and {@link
   * EfentoCoapDeviceTypeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EfentoCoapDeviceTypeConfiguration#equals(Object)}
   *   <li>{@link EfentoCoapDeviceTypeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EfentoCoapDeviceTypeConfiguration.equals(Object)",
    "int EfentoCoapDeviceTypeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EfentoCoapDeviceTypeConfiguration efentoCoapDeviceTypeConfiguration =
        new EfentoCoapDeviceTypeConfiguration();
    EfentoCoapDeviceTypeConfiguration efentoCoapDeviceTypeConfiguration2 =
        new EfentoCoapDeviceTypeConfiguration();

    // Act and Assert
    assertEquals(efentoCoapDeviceTypeConfiguration, efentoCoapDeviceTypeConfiguration2);
    assertEquals(
        efentoCoapDeviceTypeConfiguration.hashCode(),
        efentoCoapDeviceTypeConfiguration2.hashCode());
  }

  /**
   * Test {@link EfentoCoapDeviceTypeConfiguration#equals(Object)}, and {@link
   * EfentoCoapDeviceTypeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EfentoCoapDeviceTypeConfiguration#equals(Object)}
   *   <li>{@link EfentoCoapDeviceTypeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EfentoCoapDeviceTypeConfiguration.equals(Object)",
    "int EfentoCoapDeviceTypeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EfentoCoapDeviceTypeConfiguration efentoCoapDeviceTypeConfiguration =
        new EfentoCoapDeviceTypeConfiguration();

    // Act and Assert
    assertEquals(efentoCoapDeviceTypeConfiguration, efentoCoapDeviceTypeConfiguration);
    int expectedHashCodeResult = efentoCoapDeviceTypeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, efentoCoapDeviceTypeConfiguration.hashCode());
  }

  /**
   * Test {@link EfentoCoapDeviceTypeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapDeviceTypeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EfentoCoapDeviceTypeConfiguration.equals(Object)",
    "int EfentoCoapDeviceTypeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EfentoCoapDeviceTypeConfiguration(), 1);
  }

  /**
   * Test {@link EfentoCoapDeviceTypeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapDeviceTypeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EfentoCoapDeviceTypeConfiguration.equals(Object)",
    "int EfentoCoapDeviceTypeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EfentoCoapDeviceTypeConfiguration(), null);
  }

  /**
   * Test {@link EfentoCoapDeviceTypeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapDeviceTypeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EfentoCoapDeviceTypeConfiguration.equals(Object)",
    "int EfentoCoapDeviceTypeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EfentoCoapDeviceTypeConfiguration(),
        "Different type to EfentoCoapDeviceTypeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EfentoCoapDeviceTypeConfiguration}
   *   <li>{@link EfentoCoapDeviceTypeConfiguration#toString()}
   *   <li>{@link EfentoCoapDeviceTypeConfiguration#getCoapDeviceType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EfentoCoapDeviceTypeConfiguration.<init>()",
    "CoapDeviceType EfentoCoapDeviceTypeConfiguration.getCoapDeviceType()",
    "String EfentoCoapDeviceTypeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EfentoCoapDeviceTypeConfiguration actualEfentoCoapDeviceTypeConfiguration =
        new EfentoCoapDeviceTypeConfiguration();
    String actualToStringResult = actualEfentoCoapDeviceTypeConfiguration.toString();

    // Assert
    assertEquals("EfentoCoapDeviceTypeConfiguration()", actualToStringResult);
    assertEquals(
        CoapDeviceType.EFENTO, actualEfentoCoapDeviceTypeConfiguration.getCoapDeviceType());
  }
}
