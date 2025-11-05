package org.thingsboard.server.common.data.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ToDeviceRpcRequestBodyDiffblueTest {
  /**
   * Test {@link ToDeviceRpcRequestBody#equals(Object)}, and {@link
   * ToDeviceRpcRequestBody#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToDeviceRpcRequestBody#equals(Object)}
   *   <li>{@link ToDeviceRpcRequestBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToDeviceRpcRequestBody.equals(Object)",
    "int ToDeviceRpcRequestBody.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody("Method", "Params");
    ToDeviceRpcRequestBody toDeviceRpcRequestBody2 = new ToDeviceRpcRequestBody("Method", "Params");

    // Act and Assert
    assertEquals(toDeviceRpcRequestBody, toDeviceRpcRequestBody2);
    assertEquals(toDeviceRpcRequestBody.hashCode(), toDeviceRpcRequestBody2.hashCode());
  }

  /**
   * Test {@link ToDeviceRpcRequestBody#equals(Object)}, and {@link
   * ToDeviceRpcRequestBody#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToDeviceRpcRequestBody#equals(Object)}
   *   <li>{@link ToDeviceRpcRequestBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToDeviceRpcRequestBody.equals(Object)",
    "int ToDeviceRpcRequestBody.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody(null, "Params");
    ToDeviceRpcRequestBody toDeviceRpcRequestBody2 = new ToDeviceRpcRequestBody(null, "Params");

    // Act and Assert
    assertEquals(toDeviceRpcRequestBody, toDeviceRpcRequestBody2);
    assertEquals(toDeviceRpcRequestBody.hashCode(), toDeviceRpcRequestBody2.hashCode());
  }

  /**
   * Test {@link ToDeviceRpcRequestBody#equals(Object)}, and {@link
   * ToDeviceRpcRequestBody#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToDeviceRpcRequestBody#equals(Object)}
   *   <li>{@link ToDeviceRpcRequestBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToDeviceRpcRequestBody.equals(Object)",
    "int ToDeviceRpcRequestBody.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody("Method", null);
    ToDeviceRpcRequestBody toDeviceRpcRequestBody2 = new ToDeviceRpcRequestBody("Method", null);

    // Act and Assert
    assertEquals(toDeviceRpcRequestBody, toDeviceRpcRequestBody2);
    assertEquals(toDeviceRpcRequestBody.hashCode(), toDeviceRpcRequestBody2.hashCode());
  }

  /**
   * Test {@link ToDeviceRpcRequestBody#equals(Object)}, and {@link
   * ToDeviceRpcRequestBody#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToDeviceRpcRequestBody#equals(Object)}
   *   <li>{@link ToDeviceRpcRequestBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToDeviceRpcRequestBody.equals(Object)",
    "int ToDeviceRpcRequestBody.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody("Method", "Params");

    // Act and Assert
    assertEquals(toDeviceRpcRequestBody, toDeviceRpcRequestBody);
    int expectedHashCodeResult = toDeviceRpcRequestBody.hashCode();
    assertEquals(expectedHashCodeResult, toDeviceRpcRequestBody.hashCode());
  }

  /**
   * Test {@link ToDeviceRpcRequestBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ToDeviceRpcRequestBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToDeviceRpcRequestBody.equals(Object)",
    "int ToDeviceRpcRequestBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody("Params", "Params");

    // Act and Assert
    assertNotEquals(toDeviceRpcRequestBody, new ToDeviceRpcRequestBody("Method", "Params"));
  }

  /**
   * Test {@link ToDeviceRpcRequestBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ToDeviceRpcRequestBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToDeviceRpcRequestBody.equals(Object)",
    "int ToDeviceRpcRequestBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody(null, "Params");

    // Act and Assert
    assertNotEquals(toDeviceRpcRequestBody, new ToDeviceRpcRequestBody("Method", "Params"));
  }

  /**
   * Test {@link ToDeviceRpcRequestBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ToDeviceRpcRequestBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToDeviceRpcRequestBody.equals(Object)",
    "int ToDeviceRpcRequestBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody("Method", "Method");

    // Act and Assert
    assertNotEquals(toDeviceRpcRequestBody, new ToDeviceRpcRequestBody("Method", "Params"));
  }

  /**
   * Test {@link ToDeviceRpcRequestBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ToDeviceRpcRequestBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToDeviceRpcRequestBody.equals(Object)",
    "int ToDeviceRpcRequestBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody("Method", null);

    // Act and Assert
    assertNotEquals(toDeviceRpcRequestBody, new ToDeviceRpcRequestBody("Method", "Params"));
  }

  /**
   * Test {@link ToDeviceRpcRequestBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ToDeviceRpcRequestBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToDeviceRpcRequestBody.equals(Object)",
    "int ToDeviceRpcRequestBody.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ToDeviceRpcRequestBody("Method", "Params"), null);
  }

  /**
   * Test {@link ToDeviceRpcRequestBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ToDeviceRpcRequestBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToDeviceRpcRequestBody.equals(Object)",
    "int ToDeviceRpcRequestBody.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ToDeviceRpcRequestBody("Method", "Params"), "Different type to ToDeviceRpcRequestBody");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToDeviceRpcRequestBody#ToDeviceRpcRequestBody(String, String)}
   *   <li>{@link ToDeviceRpcRequestBody#toString()}
   *   <li>{@link ToDeviceRpcRequestBody#getMethod()}
   *   <li>{@link ToDeviceRpcRequestBody#getParams()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToDeviceRpcRequestBody.<init>(String, String)",
    "String ToDeviceRpcRequestBody.getMethod()",
    "String ToDeviceRpcRequestBody.getParams()",
    "String ToDeviceRpcRequestBody.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ToDeviceRpcRequestBody actualToDeviceRpcRequestBody =
        new ToDeviceRpcRequestBody("Method", "Params");
    String actualToStringResult = actualToDeviceRpcRequestBody.toString();
    String actualMethod = actualToDeviceRpcRequestBody.getMethod();

    // Assert
    assertEquals("Method", actualMethod);
    assertEquals("Params", actualToDeviceRpcRequestBody.getParams());
    assertEquals("ToDeviceRpcRequestBody(method=Method, params=Params)", actualToStringResult);
  }
}
