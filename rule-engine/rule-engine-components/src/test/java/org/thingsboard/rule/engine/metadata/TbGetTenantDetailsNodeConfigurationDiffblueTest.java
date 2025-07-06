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

class TbGetTenantDetailsNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbGetTenantDetailsNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbGetTenantDetailsNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbGetTenantDetailsNodeConfiguration TbGetTenantDetailsNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbGetTenantDetailsNodeConfiguration actualDefaultConfigurationResult =
        new TbGetTenantDetailsNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals(TbMsgSource.DATA, actualDefaultConfigurationResult.getFetchTo());
    assertTrue(actualDefaultConfigurationResult.getDetailsList().isEmpty());
  }

  /**
   * Test {@link TbGetTenantDetailsNodeConfiguration#equals(Object)}, and {@link
   * TbGetTenantDetailsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetTenantDetailsNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetTenantDetailsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTenantDetailsNodeConfiguration.equals(Object)",
    "int TbGetTenantDetailsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbGetTenantDetailsNodeConfiguration tbGetTenantDetailsNodeConfiguration =
        new TbGetTenantDetailsNodeConfiguration();
    TbGetTenantDetailsNodeConfiguration tbGetTenantDetailsNodeConfiguration2 =
        new TbGetTenantDetailsNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetTenantDetailsNodeConfiguration, tbGetTenantDetailsNodeConfiguration2);
    int expectedHashCodeResult = tbGetTenantDetailsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetTenantDetailsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetTenantDetailsNodeConfiguration#equals(Object)}, and {@link
   * TbGetTenantDetailsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetTenantDetailsNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetTenantDetailsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTenantDetailsNodeConfiguration.equals(Object)",
    "int TbGetTenantDetailsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbGetTenantDetailsNodeConfiguration tbGetTenantDetailsNodeConfiguration =
        new TbGetTenantDetailsNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetTenantDetailsNodeConfiguration, tbGetTenantDetailsNodeConfiguration);
    int expectedHashCodeResult = tbGetTenantDetailsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetTenantDetailsNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbGetTenantDetailsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTenantDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTenantDetailsNodeConfiguration.equals(Object)",
    "int TbGetTenantDetailsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetTenantDetailsNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbGetTenantDetailsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTenantDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTenantDetailsNodeConfiguration.equals(Object)",
    "int TbGetTenantDetailsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbGetTenantDetailsNodeConfiguration tbGetTenantDetailsNodeConfiguration =
        new TbGetTenantDetailsNodeConfiguration();
    tbGetTenantDetailsNodeConfiguration.setDetailsList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbGetTenantDetailsNodeConfiguration, new TbGetTenantDetailsNodeConfiguration());
  }

  /**
   * Test {@link TbGetTenantDetailsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTenantDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTenantDetailsNodeConfiguration.equals(Object)",
    "int TbGetTenantDetailsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetTenantDetailsNodeConfiguration(), null);
  }

  /**
   * Test {@link TbGetTenantDetailsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTenantDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTenantDetailsNodeConfiguration.equals(Object)",
    "int TbGetTenantDetailsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbGetTenantDetailsNodeConfiguration(),
        "Different type to TbGetTenantDetailsNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGetTenantDetailsNodeConfiguration}
   *   <li>{@link TbGetTenantDetailsNodeConfiguration#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbGetTenantDetailsNodeConfiguration.<init>()",
    "java.lang.String TbGetTenantDetailsNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbGetTenantDetailsNodeConfiguration actualTbGetTenantDetailsNodeConfiguration =
        new TbGetTenantDetailsNodeConfiguration();

    // Assert
    assertEquals(
        "TbGetTenantDetailsNodeConfiguration()",
        actualTbGetTenantDetailsNodeConfiguration.toString());
    assertNull(actualTbGetTenantDetailsNodeConfiguration.getDetailsList());
    assertNull(actualTbGetTenantDetailsNodeConfiguration.getFetchTo());
  }
}
