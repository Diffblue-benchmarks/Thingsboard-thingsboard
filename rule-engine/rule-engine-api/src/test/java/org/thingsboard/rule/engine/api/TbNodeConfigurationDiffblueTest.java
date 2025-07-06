package org.thingsboard.rule.engine.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbNodeConfiguration#equals(Object)}, and {@link TbNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNodeConfiguration#equals(Object)}
   *   <li>{@link TbNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbNodeConfiguration.equals(Object)",
    "int TbNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbNodeConfiguration tbNodeConfiguration = new TbNodeConfiguration(DoubleNode.valueOf(10.0d));
    TbNodeConfiguration tbNodeConfiguration2 = new TbNodeConfiguration(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertEquals(tbNodeConfiguration, tbNodeConfiguration2);
    int expectedHashCodeResult = tbNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbNodeConfiguration#equals(Object)}, and {@link TbNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNodeConfiguration#equals(Object)}
   *   <li>{@link TbNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbNodeConfiguration.equals(Object)",
    "int TbNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbNodeConfiguration tbNodeConfiguration = new TbNodeConfiguration(null);
    TbNodeConfiguration tbNodeConfiguration2 = new TbNodeConfiguration(null);

    // Act and Assert
    assertEquals(tbNodeConfiguration, tbNodeConfiguration2);
    int expectedHashCodeResult = tbNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbNodeConfiguration#equals(Object)}, and {@link TbNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNodeConfiguration#equals(Object)}
   *   <li>{@link TbNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbNodeConfiguration.equals(Object)",
    "int TbNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbNodeConfiguration tbNodeConfiguration = new TbNodeConfiguration(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertEquals(tbNodeConfiguration, tbNodeConfiguration);
    int expectedHashCodeResult = tbNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbNodeConfiguration.equals(Object)",
    "int TbNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbNodeConfiguration tbNodeConfiguration = new TbNodeConfiguration(DoubleNode.valueOf(0.5d));

    // Act and Assert
    assertNotEquals(tbNodeConfiguration, new TbNodeConfiguration(DoubleNode.valueOf(10.0d)));
  }

  /**
   * Test {@link TbNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbNodeConfiguration.equals(Object)",
    "int TbNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbNodeConfiguration tbNodeConfiguration = new TbNodeConfiguration(null);

    // Act and Assert
    assertNotEquals(tbNodeConfiguration, new TbNodeConfiguration(DoubleNode.valueOf(10.0d)));
  }

  /**
   * Test {@link TbNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbNodeConfiguration.equals(Object)",
    "int TbNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbNodeConfiguration(DoubleNode.valueOf(10.0d)), null);
  }

  /**
   * Test {@link TbNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbNodeConfiguration.equals(Object)",
    "int TbNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbNodeConfiguration(DoubleNode.valueOf(10.0d)),
        "Different type to TbNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)}
   *   <li>{@link TbNodeConfiguration#toString()}
   *   <li>{@link TbNodeConfiguration#getData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbNodeConfiguration.<init>(JsonNode)",
    "JsonNode TbNodeConfiguration.getData()",
    "String TbNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act
    TbNodeConfiguration actualTbNodeConfiguration = new TbNodeConfiguration(data);
    String actualToStringResult = actualTbNodeConfiguration.toString();

    // Assert
    assertEquals("TbNodeConfiguration(data=10.0)", actualToStringResult);
    assertSame(data, actualTbNodeConfiguration.getData());
  }
}
