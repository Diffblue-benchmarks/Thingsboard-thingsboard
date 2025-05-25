package org.thingsboard.server.common.data.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DefaultRuleChainCreateRequestDiffblueTest {
  /**
   * Test {@link DefaultRuleChainCreateRequest#equals(Object)}, and {@link DefaultRuleChainCreateRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultRuleChainCreateRequest#equals(Object)}
   *   <li>{@link DefaultRuleChainCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultRuleChainCreateRequest.equals(Object)",
      "int DefaultRuleChainCreateRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName("Name");

    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest2 = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest2.setName("Name");

    // Act and Assert
    assertEquals(defaultRuleChainCreateRequest, defaultRuleChainCreateRequest2);
    int expectedHashCodeResult = defaultRuleChainCreateRequest.hashCode();
    assertEquals(expectedHashCodeResult, defaultRuleChainCreateRequest2.hashCode());
  }

  /**
   * Test {@link DefaultRuleChainCreateRequest#equals(Object)}, and {@link DefaultRuleChainCreateRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultRuleChainCreateRequest#equals(Object)}
   *   <li>{@link DefaultRuleChainCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultRuleChainCreateRequest.equals(Object)",
      "int DefaultRuleChainCreateRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName(null);

    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest2 = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest2.setName(null);

    // Act and Assert
    assertEquals(defaultRuleChainCreateRequest, defaultRuleChainCreateRequest2);
    int expectedHashCodeResult = defaultRuleChainCreateRequest.hashCode();
    assertEquals(expectedHashCodeResult, defaultRuleChainCreateRequest2.hashCode());
  }

  /**
   * Test {@link DefaultRuleChainCreateRequest#equals(Object)}, and {@link DefaultRuleChainCreateRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultRuleChainCreateRequest#equals(Object)}
   *   <li>{@link DefaultRuleChainCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultRuleChainCreateRequest.equals(Object)",
      "int DefaultRuleChainCreateRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName("Name");

    // Act and Assert
    assertEquals(defaultRuleChainCreateRequest, defaultRuleChainCreateRequest);
    int expectedHashCodeResult = defaultRuleChainCreateRequest.hashCode();
    assertEquals(expectedHashCodeResult, defaultRuleChainCreateRequest.hashCode());
  }

  /**
   * Test {@link DefaultRuleChainCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultRuleChainCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultRuleChainCreateRequest.equals(Object)",
      "int DefaultRuleChainCreateRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName(null);

    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest2 = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest2.setName("Name");

    // Act and Assert
    assertNotEquals(defaultRuleChainCreateRequest, defaultRuleChainCreateRequest2);
  }

  /**
   * Test {@link DefaultRuleChainCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultRuleChainCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultRuleChainCreateRequest.equals(Object)",
      "int DefaultRuleChainCreateRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName("org.thingsboard.server.common.data.rule.DefaultRuleChainCreateRequest");

    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest2 = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest2.setName("Name");

    // Act and Assert
    assertNotEquals(defaultRuleChainCreateRequest, defaultRuleChainCreateRequest2);
  }

  /**
   * Test {@link DefaultRuleChainCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultRuleChainCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultRuleChainCreateRequest.equals(Object)",
      "int DefaultRuleChainCreateRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName("Name");

    // Act and Assert
    assertNotEquals(defaultRuleChainCreateRequest, null);
  }

  /**
   * Test {@link DefaultRuleChainCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultRuleChainCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultRuleChainCreateRequest.equals(Object)",
      "int DefaultRuleChainCreateRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName("Name");

    // Act and Assert
    assertNotEquals(defaultRuleChainCreateRequest, "Different type to DefaultRuleChainCreateRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DefaultRuleChainCreateRequest}
   *   <li>{@link DefaultRuleChainCreateRequest#setName(String)}
   *   <li>{@link DefaultRuleChainCreateRequest#toString()}
   *   <li>{@link DefaultRuleChainCreateRequest#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultRuleChainCreateRequest.<init>()", "String DefaultRuleChainCreateRequest.getName()",
      "void DefaultRuleChainCreateRequest.setName(String)", "String DefaultRuleChainCreateRequest.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultRuleChainCreateRequest actualDefaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    actualDefaultRuleChainCreateRequest.setName("Name");
    String actualToStringResult = actualDefaultRuleChainCreateRequest.toString();

    // Assert
    assertEquals("DefaultRuleChainCreateRequest(name=Name)", actualToStringResult);
    assertEquals("Name", actualDefaultRuleChainCreateRequest.getName());
  }
}
