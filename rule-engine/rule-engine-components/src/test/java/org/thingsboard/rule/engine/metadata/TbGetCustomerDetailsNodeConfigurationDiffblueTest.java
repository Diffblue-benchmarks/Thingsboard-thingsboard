package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.util.TbMsgSource;

class TbGetCustomerDetailsNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbGetCustomerDetailsNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbGetCustomerDetailsNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbGetCustomerDetailsNodeConfiguration TbGetCustomerDetailsNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbGetCustomerDetailsNodeConfiguration actualDefaultConfigurationResult =
        new TbGetCustomerDetailsNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals(TbMsgSource.DATA, actualDefaultConfigurationResult.getFetchTo());
    assertTrue(actualDefaultConfigurationResult.getDetailsList().isEmpty());
  }

  /**
   * Test {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}, and {@link
   * TbGetCustomerDetailsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetCustomerDetailsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetCustomerDetailsNodeConfiguration.equals(Object)",
    "int TbGetCustomerDetailsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration =
        new TbGetCustomerDetailsNodeConfiguration();
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration2 =
        new TbGetCustomerDetailsNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetCustomerDetailsNodeConfiguration, tbGetCustomerDetailsNodeConfiguration2);
    int expectedHashCodeResult = tbGetCustomerDetailsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetCustomerDetailsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}, and {@link
   * TbGetCustomerDetailsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetCustomerDetailsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetCustomerDetailsNodeConfiguration.equals(Object)",
    "int TbGetCustomerDetailsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration =
        new TbGetCustomerDetailsNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetCustomerDetailsNodeConfiguration, tbGetCustomerDetailsNodeConfiguration);
    int expectedHashCodeResult = tbGetCustomerDetailsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetCustomerDetailsNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetCustomerDetailsNodeConfiguration.equals(Object)",
    "int TbGetCustomerDetailsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetCustomerDetailsNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetCustomerDetailsNodeConfiguration.equals(Object)",
    "int TbGetCustomerDetailsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration =
        new TbGetCustomerDetailsNodeConfiguration();
    tbGetCustomerDetailsNodeConfiguration.setDetailsList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        tbGetCustomerDetailsNodeConfiguration, new TbGetCustomerDetailsNodeConfiguration());
  }

  /**
   * Test {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetCustomerDetailsNodeConfiguration.equals(Object)",
    "int TbGetCustomerDetailsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetCustomerDetailsNodeConfiguration(), null);
  }

  /**
   * Test {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetCustomerDetailsNodeConfiguration.equals(Object)",
    "int TbGetCustomerDetailsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbGetCustomerDetailsNodeConfiguration(),
        "Different type to TbGetCustomerDetailsNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGetCustomerDetailsNodeConfiguration}
   *   <li>{@link TbGetCustomerDetailsNodeConfiguration#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbGetCustomerDetailsNodeConfiguration.<init>()",
    "java.lang.String TbGetCustomerDetailsNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbGetCustomerDetailsNodeConfiguration actualTbGetCustomerDetailsNodeConfiguration =
        new TbGetCustomerDetailsNodeConfiguration();

    // Assert
    assertEquals(
        "TbGetCustomerDetailsNodeConfiguration()",
        actualTbGetCustomerDetailsNodeConfiguration.toString());
    assertNull(actualTbGetCustomerDetailsNodeConfiguration.getDetailsList());
    assertNull(actualTbGetCustomerDetailsNodeConfiguration.getFetchTo());
  }
}
