package org.thingsboard.server.common.data.device.credentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BasicMqttCredentialsDiffblueTest {
  /**
   * Test {@link BasicMqttCredentials#equals(Object)}, and {@link BasicMqttCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicMqttCredentials#equals(Object)}
   *   <li>{@link BasicMqttCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicMqttCredentials.equals(Object)", "int BasicMqttCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertEquals(basicMqttCredentials, basicMqttCredentials2);
    int expectedHashCodeResult = basicMqttCredentials.hashCode();
    assertEquals(expectedHashCodeResult, basicMqttCredentials2.hashCode());
  }

  /**
   * Test {@link BasicMqttCredentials#equals(Object)}, and {@link BasicMqttCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicMqttCredentials#equals(Object)}
   *   <li>{@link BasicMqttCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicMqttCredentials.equals(Object)", "int BasicMqttCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId(null);
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId(null);
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertEquals(basicMqttCredentials, basicMqttCredentials2);
    int expectedHashCodeResult = basicMqttCredentials.hashCode();
    assertEquals(expectedHashCodeResult, basicMqttCredentials2.hashCode());
  }

  /**
   * Test {@link BasicMqttCredentials#equals(Object)}, and {@link BasicMqttCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicMqttCredentials#equals(Object)}
   *   <li>{@link BasicMqttCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicMqttCredentials.equals(Object)", "int BasicMqttCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword(null);
    basicMqttCredentials.setUserName("janedoe");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword(null);
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertEquals(basicMqttCredentials, basicMqttCredentials2);
    int expectedHashCodeResult = basicMqttCredentials.hashCode();
    assertEquals(expectedHashCodeResult, basicMqttCredentials2.hashCode());
  }

  /**
   * Test {@link BasicMqttCredentials#equals(Object)}, and {@link BasicMqttCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicMqttCredentials#equals(Object)}
   *   <li>{@link BasicMqttCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicMqttCredentials.equals(Object)", "int BasicMqttCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName(null);

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName(null);

    // Act and Assert
    assertEquals(basicMqttCredentials, basicMqttCredentials2);
    int expectedHashCodeResult = basicMqttCredentials.hashCode();
    assertEquals(expectedHashCodeResult, basicMqttCredentials2.hashCode());
  }

  /**
   * Test {@link BasicMqttCredentials#equals(Object)}, and {@link BasicMqttCredentials#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicMqttCredentials#equals(Object)}
   *   <li>{@link BasicMqttCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicMqttCredentials.equals(Object)", "int BasicMqttCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");

    // Act and Assert
    assertEquals(basicMqttCredentials, basicMqttCredentials);
    int expectedHashCodeResult = basicMqttCredentials.hashCode();
    assertEquals(expectedHashCodeResult, basicMqttCredentials.hashCode());
  }

  /**
   * Test {@link BasicMqttCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicMqttCredentials.equals(Object)", "int BasicMqttCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("janedoe");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, basicMqttCredentials2);
  }

  /**
   * Test {@link BasicMqttCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicMqttCredentials.equals(Object)", "int BasicMqttCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId(null);
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, basicMqttCredentials2);
  }

  /**
   * Test {@link BasicMqttCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicMqttCredentials.equals(Object)", "int BasicMqttCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("42");
    basicMqttCredentials.setUserName("janedoe");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, basicMqttCredentials2);
  }

  /**
   * Test {@link BasicMqttCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicMqttCredentials.equals(Object)", "int BasicMqttCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword(null);
    basicMqttCredentials.setUserName("janedoe");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, basicMqttCredentials2);
  }

  /**
   * Test {@link BasicMqttCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicMqttCredentials.equals(Object)", "int BasicMqttCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("42");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, basicMqttCredentials2);
  }

  /**
   * Test {@link BasicMqttCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicMqttCredentials.equals(Object)", "int BasicMqttCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName(null);

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, basicMqttCredentials2);
  }

  /**
   * Test {@link BasicMqttCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicMqttCredentials.equals(Object)", "int BasicMqttCredentials.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, null);
  }

  /**
   * Test {@link BasicMqttCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicMqttCredentials.equals(Object)", "int BasicMqttCredentials.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, "Different type to BasicMqttCredentials");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BasicMqttCredentials}
   *   <li>{@link BasicMqttCredentials#setClientId(String)}
   *   <li>{@link BasicMqttCredentials#setPassword(String)}
   *   <li>{@link BasicMqttCredentials#setUserName(String)}
   *   <li>{@link BasicMqttCredentials#toString()}
   *   <li>{@link BasicMqttCredentials#getClientId()}
   *   <li>{@link BasicMqttCredentials#getPassword()}
   *   <li>{@link BasicMqttCredentials#getUserName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BasicMqttCredentials.<init>()", "String BasicMqttCredentials.getClientId()",
      "String BasicMqttCredentials.getPassword()", "String BasicMqttCredentials.getUserName()",
      "void BasicMqttCredentials.setClientId(String)", "void BasicMqttCredentials.setPassword(String)",
      "void BasicMqttCredentials.setUserName(String)", "String BasicMqttCredentials.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    BasicMqttCredentials actualBasicMqttCredentials = new BasicMqttCredentials();
    actualBasicMqttCredentials.setClientId("42");
    actualBasicMqttCredentials.setPassword("iloveyou");
    actualBasicMqttCredentials.setUserName("janedoe");
    String actualToStringResult = actualBasicMqttCredentials.toString();
    String actualClientId = actualBasicMqttCredentials.getClientId();
    String actualPassword = actualBasicMqttCredentials.getPassword();

    // Assert
    assertEquals("42", actualClientId);
    assertEquals("BasicMqttCredentials(clientId=42, userName=janedoe, password=iloveyou)", actualToStringResult);
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualBasicMqttCredentials.getUserName());
  }
}
