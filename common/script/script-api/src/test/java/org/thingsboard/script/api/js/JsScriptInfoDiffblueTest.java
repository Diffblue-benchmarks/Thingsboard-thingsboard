package org.thingsboard.script.api.js;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JsScriptInfoDiffblueTest {
  /**
   * Test {@link JsScriptInfo#equals(Object)}, and
   * {@link JsScriptInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsScriptInfo#equals(Object)}
   *   <li>{@link JsScriptInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsScriptInfo jsScriptInfo = new JsScriptInfo("Hash", "Function Name");
    JsScriptInfo jsScriptInfo2 = new JsScriptInfo("Hash", "Function Name");

    // Act and Assert
    assertEquals(jsScriptInfo, jsScriptInfo2);
    int expectedHashCodeResult = jsScriptInfo.hashCode();
    assertEquals(expectedHashCodeResult, jsScriptInfo2.hashCode());
  }

  /**
   * Test {@link JsScriptInfo#equals(Object)}, and
   * {@link JsScriptInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsScriptInfo#equals(Object)}
   *   <li>{@link JsScriptInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    JsScriptInfo jsScriptInfo = new JsScriptInfo(null, "Function Name");
    JsScriptInfo jsScriptInfo2 = new JsScriptInfo(null, "Function Name");

    // Act and Assert
    assertEquals(jsScriptInfo, jsScriptInfo2);
    int expectedHashCodeResult = jsScriptInfo.hashCode();
    assertEquals(expectedHashCodeResult, jsScriptInfo2.hashCode());
  }

  /**
   * Test {@link JsScriptInfo#equals(Object)}, and
   * {@link JsScriptInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsScriptInfo#equals(Object)}
   *   <li>{@link JsScriptInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    JsScriptInfo jsScriptInfo = new JsScriptInfo("Hash", null);
    JsScriptInfo jsScriptInfo2 = new JsScriptInfo("Hash", null);

    // Act and Assert
    assertEquals(jsScriptInfo, jsScriptInfo2);
    int expectedHashCodeResult = jsScriptInfo.hashCode();
    assertEquals(expectedHashCodeResult, jsScriptInfo2.hashCode());
  }

  /**
   * Test {@link JsScriptInfo#equals(Object)}, and
   * {@link JsScriptInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsScriptInfo#equals(Object)}
   *   <li>{@link JsScriptInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsScriptInfo jsScriptInfo = new JsScriptInfo("Hash", "Function Name");

    // Act and Assert
    assertEquals(jsScriptInfo, jsScriptInfo);
    int expectedHashCodeResult = jsScriptInfo.hashCode();
    assertEquals(expectedHashCodeResult, jsScriptInfo.hashCode());
  }

  /**
   * Test {@link JsScriptInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsScriptInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JsScriptInfo jsScriptInfo = new JsScriptInfo("Function Name", "Function Name");

    // Act and Assert
    assertNotEquals(jsScriptInfo, new JsScriptInfo("Hash", "Function Name"));
  }

  /**
   * Test {@link JsScriptInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsScriptInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JsScriptInfo jsScriptInfo = new JsScriptInfo(null, "Function Name");

    // Act and Assert
    assertNotEquals(jsScriptInfo, new JsScriptInfo("Hash", "Function Name"));
  }

  /**
   * Test {@link JsScriptInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsScriptInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    JsScriptInfo jsScriptInfo = new JsScriptInfo("Hash", "Hash");

    // Act and Assert
    assertNotEquals(jsScriptInfo, new JsScriptInfo("Hash", "Function Name"));
  }

  /**
   * Test {@link JsScriptInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsScriptInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    JsScriptInfo jsScriptInfo = new JsScriptInfo("Hash", null);

    // Act and Assert
    assertNotEquals(jsScriptInfo, new JsScriptInfo("Hash", "Function Name"));
  }

  /**
   * Test {@link JsScriptInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsScriptInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsScriptInfo("Hash", "Function Name"), null);
  }

  /**
   * Test {@link JsScriptInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsScriptInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsScriptInfo("Hash", "Function Name"), "Different type to JsScriptInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsScriptInfo#JsScriptInfo(String, String)}
   *   <li>{@link JsScriptInfo#toString()}
   *   <li>{@link JsScriptInfo#getFunctionName()}
   *   <li>{@link JsScriptInfo#getHash()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    JsScriptInfo actualJsScriptInfo = new JsScriptInfo("Hash", "Function Name");
    String actualToStringResult = actualJsScriptInfo.toString();
    String actualFunctionName = actualJsScriptInfo.getFunctionName();

    // Assert
    assertEquals("Function Name", actualFunctionName);
    assertEquals("Hash", actualJsScriptInfo.getHash());
    assertEquals("JsScriptInfo(hash=Hash, functionName=Function Name)", actualToStringResult);
  }
}
