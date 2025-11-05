package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimpleAlarmConditionSpecDiffblueTest {
  /**
   * Test {@link SimpleAlarmConditionSpec#equals(Object)}, and {@link
   * SimpleAlarmConditionSpec#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleAlarmConditionSpec#equals(Object)}
   *   <li>{@link SimpleAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleAlarmConditionSpec.equals(Object)",
    "int SimpleAlarmConditionSpec.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SimpleAlarmConditionSpec simpleAlarmConditionSpec = new SimpleAlarmConditionSpec();
    SimpleAlarmConditionSpec simpleAlarmConditionSpec2 = new SimpleAlarmConditionSpec();

    // Act and Assert
    assertEquals(simpleAlarmConditionSpec, simpleAlarmConditionSpec2);
    assertEquals(simpleAlarmConditionSpec.hashCode(), simpleAlarmConditionSpec2.hashCode());
  }

  /**
   * Test {@link SimpleAlarmConditionSpec#equals(Object)}, and {@link
   * SimpleAlarmConditionSpec#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleAlarmConditionSpec#equals(Object)}
   *   <li>{@link SimpleAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleAlarmConditionSpec.equals(Object)",
    "int SimpleAlarmConditionSpec.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SimpleAlarmConditionSpec simpleAlarmConditionSpec = new SimpleAlarmConditionSpec();

    // Act and Assert
    assertEquals(simpleAlarmConditionSpec, simpleAlarmConditionSpec);
    int expectedHashCodeResult = simpleAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, simpleAlarmConditionSpec.hashCode());
  }

  /**
   * Test {@link SimpleAlarmConditionSpec#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleAlarmConditionSpec#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleAlarmConditionSpec.equals(Object)",
    "int SimpleAlarmConditionSpec.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SimpleAlarmConditionSpec(), null);
  }

  /**
   * Test {@link SimpleAlarmConditionSpec#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleAlarmConditionSpec#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleAlarmConditionSpec.equals(Object)",
    "int SimpleAlarmConditionSpec.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SimpleAlarmConditionSpec(), "Different type to SimpleAlarmConditionSpec");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SimpleAlarmConditionSpec}
   *   <li>{@link SimpleAlarmConditionSpec#toString()}
   *   <li>{@link SimpleAlarmConditionSpec#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleAlarmConditionSpec.<init>()",
    "AlarmConditionSpecType SimpleAlarmConditionSpec.getType()",
    "String SimpleAlarmConditionSpec.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SimpleAlarmConditionSpec actualSimpleAlarmConditionSpec = new SimpleAlarmConditionSpec();
    String actualToStringResult = actualSimpleAlarmConditionSpec.toString();

    // Assert
    assertEquals("SimpleAlarmConditionSpec()", actualToStringResult);
    assertEquals(AlarmConditionSpecType.SIMPLE, actualSimpleAlarmConditionSpec.getType());
  }
}
