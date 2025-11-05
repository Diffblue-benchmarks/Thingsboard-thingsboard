package org.thingsboard.server.common.data.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2mResourceObserveDiffblueTest {
  /**
   * Test {@link LwM2mResourceObserve#equals(Object)}, and {@link LwM2mResourceObserve#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mResourceObserve#equals(Object)}
   *   <li>{@link LwM2mResourceObserve#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mResourceObserve.equals(Object)",
    "int LwM2mResourceObserve.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", true, true, true);
    LwM2mResourceObserve lwM2mResourceObserve2 =
        new LwM2mResourceObserve(1, "Name", true, true, true);

    // Act and Assert
    assertEquals(lwM2mResourceObserve, lwM2mResourceObserve2);
    assertEquals(lwM2mResourceObserve.hashCode(), lwM2mResourceObserve2.hashCode());
  }

  /**
   * Test {@link LwM2mResourceObserve#equals(Object)}, and {@link LwM2mResourceObserve#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mResourceObserve#equals(Object)}
   *   <li>{@link LwM2mResourceObserve#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mResourceObserve.equals(Object)",
    "int LwM2mResourceObserve.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", true, true, true);

    // Act and Assert
    assertEquals(lwM2mResourceObserve, lwM2mResourceObserve);
    int expectedHashCodeResult = lwM2mResourceObserve.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mResourceObserve.hashCode());
  }

  /**
   * Test {@link LwM2mResourceObserve#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mResourceObserve.equals(Object)",
    "int LwM2mResourceObserve.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(2, "Name", true, true, true);

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Test {@link LwM2mResourceObserve#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mResourceObserve.equals(Object)",
    "int LwM2mResourceObserve.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, "name", true, true, true);

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Test {@link LwM2mResourceObserve#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mResourceObserve.equals(Object)",
    "int LwM2mResourceObserve.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", false, true, true);

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Test {@link LwM2mResourceObserve#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mResourceObserve.equals(Object)",
    "int LwM2mResourceObserve.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", true, false, true);

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Test {@link LwM2mResourceObserve#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mResourceObserve.equals(Object)",
    "int LwM2mResourceObserve.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", true, true, false);

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Test {@link LwM2mResourceObserve#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mResourceObserve.equals(Object)",
    "int LwM2mResourceObserve.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", true, true, true, "Name");

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Test {@link LwM2mResourceObserve#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mResourceObserve.equals(Object)",
    "int LwM2mResourceObserve.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, null, true, true, true, "Name");

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Test {@link LwM2mResourceObserve#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mResourceObserve.equals(Object)",
    "int LwM2mResourceObserve.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", true, true, true, null);

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Test {@link LwM2mResourceObserve#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mResourceObserve.equals(Object)",
    "int LwM2mResourceObserve.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2mResourceObserve(1, "Name", true, true, true), null);
  }

  /**
   * Test {@link LwM2mResourceObserve#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2mResourceObserve.equals(Object)",
    "int LwM2mResourceObserve.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new LwM2mResourceObserve(1, "Name", true, true, true),
        "Different type to LwM2mResourceObserve");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mResourceObserve#LwM2mResourceObserve(int, String, boolean, boolean, boolean,
   *       String)}
   *   <li>{@link LwM2mResourceObserve#setAttribute(boolean)}
   *   <li>{@link LwM2mResourceObserve#setId(int)}
   *   <li>{@link LwM2mResourceObserve#setKeyName(String)}
   *   <li>{@link LwM2mResourceObserve#setName(String)}
   *   <li>{@link LwM2mResourceObserve#setObserve(boolean)}
   *   <li>{@link LwM2mResourceObserve#setTelemetry(boolean)}
   *   <li>{@link LwM2mResourceObserve#toString()}
   *   <li>{@link LwM2mResourceObserve#getId()}
   *   <li>{@link LwM2mResourceObserve#getKeyName()}
   *   <li>{@link LwM2mResourceObserve#getName()}
   *   <li>{@link LwM2mResourceObserve#isAttribute()}
   *   <li>{@link LwM2mResourceObserve#isObserve()}
   *   <li>{@link LwM2mResourceObserve#isTelemetry()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mResourceObserve.<init>(int, String, boolean, boolean, boolean, String)",
    "int LwM2mResourceObserve.getId()",
    "String LwM2mResourceObserve.getKeyName()",
    "String LwM2mResourceObserve.getName()",
    "boolean LwM2mResourceObserve.isAttribute()",
    "boolean LwM2mResourceObserve.isObserve()",
    "boolean LwM2mResourceObserve.isTelemetry()",
    "void LwM2mResourceObserve.setAttribute(boolean)",
    "void LwM2mResourceObserve.setId(int)",
    "void LwM2mResourceObserve.setKeyName(String)",
    "void LwM2mResourceObserve.setName(String)",
    "void LwM2mResourceObserve.setObserve(boolean)",
    "void LwM2mResourceObserve.setTelemetry(boolean)",
    "String LwM2mResourceObserve.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2mResourceObserve actualLwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", true, true, true, "Key Name");
    actualLwM2mResourceObserve.setAttribute(true);
    actualLwM2mResourceObserve.setId(1);
    actualLwM2mResourceObserve.setKeyName("Key Name");
    actualLwM2mResourceObserve.setName("Name");
    actualLwM2mResourceObserve.setObserve(true);
    actualLwM2mResourceObserve.setTelemetry(true);
    String actualToStringResult = actualLwM2mResourceObserve.toString();
    int actualId = actualLwM2mResourceObserve.getId();
    String actualKeyName = actualLwM2mResourceObserve.getKeyName();
    String actualName = actualLwM2mResourceObserve.getName();
    boolean actualIsAttributeResult = actualLwM2mResourceObserve.isAttribute();
    boolean actualIsObserveResult = actualLwM2mResourceObserve.isObserve();

    // Assert
    assertEquals("Key Name", actualKeyName);
    assertEquals(
        "LwM2mResourceObserve(id=1, name=Name, observe=true, attribute=true, telemetry=true, keyName=Key"
            + " Name)",
        actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals(1, actualId);
    assertTrue(actualIsAttributeResult);
    assertTrue(actualIsObserveResult);
    assertTrue(actualLwM2mResourceObserve.isTelemetry());
  }

  /**
   * Test {@link LwM2mResourceObserve#LwM2mResourceObserve(int, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return Name is {@link LwM2mConstants#LWM2M_SEPARATOR_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mResourceObserve#LwM2mResourceObserve(int, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mResourceObserve(int, String, boolean, boolean, boolean); then return Name is LWM2M_SEPARATOR_KEY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mResourceObserve.<init>(int, String, boolean, boolean, boolean)"})
  void testNewLwM2mResourceObserve_thenReturnNameIsLwm2m_separator_key() {
    // Arrange and Act
    LwM2mResourceObserve actualLwM2mResourceObserve =
        new LwM2mResourceObserve(1, LwM2mConstants.LWM2M_SEPARATOR_KEY, true, true, true);

    // Assert
    assertEquals("", actualLwM2mResourceObserve.getKeyName());
    assertEquals(1, actualLwM2mResourceObserve.getId());
    assertTrue(actualLwM2mResourceObserve.isAttribute());
    assertTrue(actualLwM2mResourceObserve.isObserve());
    assertTrue(actualLwM2mResourceObserve.isTelemetry());
    assertEquals(LwM2mConstants.LWM2M_SEPARATOR_KEY, actualLwM2mResourceObserve.getName());
  }

  /**
   * Test {@link LwM2mResourceObserve#LwM2mResourceObserve(int, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return Name is {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mResourceObserve#LwM2mResourceObserve(int, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mResourceObserve(int, String, boolean, boolean, boolean); when '-'; then return Name is '-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mResourceObserve.<init>(int, String, boolean, boolean, boolean)"})
  void testNewLwM2mResourceObserve_whenDash_thenReturnNameIsDash() {
    // Arrange and Act
    LwM2mResourceObserve actualLwM2mResourceObserve =
        new LwM2mResourceObserve(1, "-", true, true, true);

    // Assert
    assertEquals("", actualLwM2mResourceObserve.getKeyName());
    assertEquals("-", actualLwM2mResourceObserve.getName());
    assertEquals(1, actualLwM2mResourceObserve.getId());
    assertTrue(actualLwM2mResourceObserve.isAttribute());
    assertTrue(actualLwM2mResourceObserve.isObserve());
    assertTrue(actualLwM2mResourceObserve.isTelemetry());
  }

  /**
   * Test {@link LwM2mResourceObserve#LwM2mResourceObserve(int, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mResourceObserve#LwM2mResourceObserve(int, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mResourceObserve(int, String, boolean, boolean, boolean); when empty string; then return Name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mResourceObserve.<init>(int, String, boolean, boolean, boolean)"})
  void testNewLwM2mResourceObserve_whenEmptyString_thenReturnNameIsEmptyString() {
    // Arrange and Act
    LwM2mResourceObserve actualLwM2mResourceObserve =
        new LwM2mResourceObserve(1, "", true, true, true);

    // Assert
    assertEquals("", actualLwM2mResourceObserve.getKeyName());
    assertEquals("", actualLwM2mResourceObserve.getName());
    assertEquals(1, actualLwM2mResourceObserve.getId());
    assertTrue(actualLwM2mResourceObserve.isAttribute());
    assertTrue(actualLwM2mResourceObserve.isObserve());
    assertTrue(actualLwM2mResourceObserve.isTelemetry());
  }

  /**
   * Test {@link LwM2mResourceObserve#LwM2mResourceObserve(int, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mResourceObserve#LwM2mResourceObserve(int, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mResourceObserve(int, String, boolean, boolean, boolean); when 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mResourceObserve.<init>(int, String, boolean, boolean, boolean)"})
  void testNewLwM2mResourceObserve_whenName_thenReturnName() {
    // Arrange and Act
    LwM2mResourceObserve actualLwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", true, true, true);

    // Assert
    assertEquals("Name", actualLwM2mResourceObserve.getName());
    assertEquals("name", actualLwM2mResourceObserve.getKeyName());
    assertEquals(1, actualLwM2mResourceObserve.getId());
    assertTrue(actualLwM2mResourceObserve.isAttribute());
    assertTrue(actualLwM2mResourceObserve.isObserve());
    assertTrue(actualLwM2mResourceObserve.isTelemetry());
  }
}
