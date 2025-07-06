package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbAssignToCustomerNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbAssignToCustomerNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbAssignToCustomerNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbAssignToCustomerNodeConfiguration TbAssignToCustomerNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbAssignToCustomerNodeConfiguration actualDefaultConfigurationResult =
        new TbAssignToCustomerNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals("", actualDefaultConfigurationResult.getCustomerNamePattern());
    assertFalse(actualDefaultConfigurationResult.isCreateCustomerIfNotExists());
  }

  /**
   * Test {@link TbAssignToCustomerNodeConfiguration#equals(Object)}, and {@link
   * TbAssignToCustomerNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbAssignToCustomerNodeConfiguration#equals(Object)}
   *   <li>{@link TbAssignToCustomerNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbAssignToCustomerNodeConfiguration.equals(Object)",
    "int TbAssignToCustomerNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration =
        new TbAssignToCustomerNodeConfiguration();
    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration2 =
        new TbAssignToCustomerNodeConfiguration();

    // Act and Assert
    assertEquals(tbAssignToCustomerNodeConfiguration, tbAssignToCustomerNodeConfiguration2);
    int expectedHashCodeResult = tbAssignToCustomerNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbAssignToCustomerNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAssignToCustomerNodeConfiguration#equals(Object)}, and {@link
   * TbAssignToCustomerNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbAssignToCustomerNodeConfiguration#equals(Object)}
   *   <li>{@link TbAssignToCustomerNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbAssignToCustomerNodeConfiguration.equals(Object)",
    "int TbAssignToCustomerNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration =
        new TbAssignToCustomerNodeConfiguration();

    // Act and Assert
    assertEquals(tbAssignToCustomerNodeConfiguration, tbAssignToCustomerNodeConfiguration);
    int expectedHashCodeResult = tbAssignToCustomerNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbAssignToCustomerNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbAssignToCustomerNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAssignToCustomerNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbAssignToCustomerNodeConfiguration.equals(Object)",
    "int TbAssignToCustomerNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbAssignToCustomerNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbAssignToCustomerNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAssignToCustomerNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbAssignToCustomerNodeConfiguration.equals(Object)",
    "int TbAssignToCustomerNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration =
        new TbAssignToCustomerNodeConfiguration();
    tbAssignToCustomerNodeConfiguration.setCreateCustomerIfNotExists(true);

    // Act and Assert
    assertNotEquals(tbAssignToCustomerNodeConfiguration, new TbAssignToCustomerNodeConfiguration());
  }

  /**
   * Test {@link TbAssignToCustomerNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAssignToCustomerNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbAssignToCustomerNodeConfiguration.equals(Object)",
    "int TbAssignToCustomerNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration =
        new TbAssignToCustomerNodeConfiguration();
    tbAssignToCustomerNodeConfiguration.setCustomerNamePattern("Customer Name Pattern");

    // Act and Assert
    assertNotEquals(tbAssignToCustomerNodeConfiguration, new TbAssignToCustomerNodeConfiguration());
  }

  /**
   * Test {@link TbAssignToCustomerNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAssignToCustomerNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbAssignToCustomerNodeConfiguration.equals(Object)",
    "int TbAssignToCustomerNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbAssignToCustomerNodeConfiguration(), null);
  }

  /**
   * Test {@link TbAssignToCustomerNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAssignToCustomerNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbAssignToCustomerNodeConfiguration.equals(Object)",
    "int TbAssignToCustomerNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbAssignToCustomerNodeConfiguration(),
        "Different type to TbAssignToCustomerNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbAssignToCustomerNodeConfiguration}
   *   <li>{@link TbAssignToCustomerNodeConfiguration#setCreateCustomerIfNotExists(boolean)}
   *   <li>{@link TbAssignToCustomerNodeConfiguration#toString()}
   *   <li>{@link TbAssignToCustomerNodeConfiguration#isCreateCustomerIfNotExists()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbAssignToCustomerNodeConfiguration.<init>()",
    "boolean TbAssignToCustomerNodeConfiguration.isCreateCustomerIfNotExists()",
    "void TbAssignToCustomerNodeConfiguration.setCreateCustomerIfNotExists(boolean)",
    "String TbAssignToCustomerNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbAssignToCustomerNodeConfiguration actualTbAssignToCustomerNodeConfiguration =
        new TbAssignToCustomerNodeConfiguration();
    actualTbAssignToCustomerNodeConfiguration.setCreateCustomerIfNotExists(true);
    String actualToStringResult = actualTbAssignToCustomerNodeConfiguration.toString();
    boolean actualIsCreateCustomerIfNotExistsResult =
        actualTbAssignToCustomerNodeConfiguration.isCreateCustomerIfNotExists();

    // Assert
    assertEquals(
        "TbAssignToCustomerNodeConfiguration(createCustomerIfNotExists=true)",
        actualToStringResult);
    assertNull(actualTbAssignToCustomerNodeConfiguration.getCustomerNamePattern());
    assertTrue(actualIsCreateCustomerIfNotExistsResult);
  }
}
