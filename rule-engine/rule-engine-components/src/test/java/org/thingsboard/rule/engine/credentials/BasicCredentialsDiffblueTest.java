package org.thingsboard.rule.engine.credentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BasicCredentialsDiffblueTest {
  /**
   * Test {@link BasicCredentials#equals(Object)}, and {@link BasicCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BasicCredentials#equals(Object)}
   *   <li>{@link BasicCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicCredentials.equals(Object)", "int BasicCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BasicCredentials basicCredentials = new BasicCredentials();
    BasicCredentials basicCredentials2 = new BasicCredentials();

    // Act and Assert
    assertEquals(basicCredentials, basicCredentials2);
    int expectedHashCodeResult = basicCredentials.hashCode();
    assertEquals(expectedHashCodeResult, basicCredentials2.hashCode());
  }

  /**
   * Test {@link BasicCredentials#equals(Object)}, and {@link BasicCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BasicCredentials#equals(Object)}
   *   <li>{@link BasicCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicCredentials.equals(Object)", "int BasicCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BasicCredentials basicCredentials = new BasicCredentials();
    basicCredentials.setUsername("janedoe");

    BasicCredentials basicCredentials2 = new BasicCredentials();
    basicCredentials2.setUsername("janedoe");

    // Act and Assert
    assertEquals(basicCredentials, basicCredentials2);
    int expectedHashCodeResult = basicCredentials.hashCode();
    assertEquals(expectedHashCodeResult, basicCredentials2.hashCode());
  }

  /**
   * Test {@link BasicCredentials#equals(Object)}, and {@link BasicCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BasicCredentials#equals(Object)}
   *   <li>{@link BasicCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicCredentials.equals(Object)", "int BasicCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BasicCredentials basicCredentials = new BasicCredentials();
    basicCredentials.setPassword("iloveyou");

    BasicCredentials basicCredentials2 = new BasicCredentials();
    basicCredentials2.setPassword("iloveyou");

    // Act and Assert
    assertEquals(basicCredentials, basicCredentials2);
    int expectedHashCodeResult = basicCredentials.hashCode();
    assertEquals(expectedHashCodeResult, basicCredentials2.hashCode());
  }

  /**
   * Test {@link BasicCredentials#equals(Object)}, and {@link BasicCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BasicCredentials#equals(Object)}
   *   <li>{@link BasicCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicCredentials.equals(Object)", "int BasicCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BasicCredentials basicCredentials = new BasicCredentials();

    // Act and Assert
    assertEquals(basicCredentials, basicCredentials);
    int expectedHashCodeResult = basicCredentials.hashCode();
    assertEquals(expectedHashCodeResult, basicCredentials.hashCode());
  }

  /**
   * Test {@link BasicCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicCredentials.equals(Object)", "int BasicCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicCredentials(), 1);
  }

  /**
   * Test {@link BasicCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicCredentials.equals(Object)", "int BasicCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BasicCredentials basicCredentials = new BasicCredentials();
    basicCredentials.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(basicCredentials, new BasicCredentials());
  }

  /**
   * Test {@link BasicCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicCredentials.equals(Object)", "int BasicCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BasicCredentials basicCredentials = new BasicCredentials();
    basicCredentials.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(basicCredentials, new BasicCredentials());
  }

  /**
   * Test {@link BasicCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicCredentials.equals(Object)", "int BasicCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BasicCredentials basicCredentials = new BasicCredentials();

    BasicCredentials basicCredentials2 = new BasicCredentials();
    basicCredentials2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(basicCredentials, basicCredentials2);
  }

  /**
   * Test {@link BasicCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicCredentials.equals(Object)", "int BasicCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BasicCredentials basicCredentials = new BasicCredentials();

    BasicCredentials basicCredentials2 = new BasicCredentials();
    basicCredentials2.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(basicCredentials, basicCredentials2);
  }

  /**
   * Test {@link BasicCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicCredentials.equals(Object)", "int BasicCredentials.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicCredentials(), null);
  }

  /**
   * Test {@link BasicCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicCredentials.equals(Object)", "int BasicCredentials.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicCredentials(), "Different type to BasicCredentials");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BasicCredentials}
   *   <li>{@link BasicCredentials#setPassword(String)}
   *   <li>{@link BasicCredentials#setUsername(String)}
   *   <li>{@link BasicCredentials#toString()}
   *   <li>{@link BasicCredentials#getPassword()}
   *   <li>{@link BasicCredentials#getType()}
   *   <li>{@link BasicCredentials#getUsername()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void BasicCredentials.<init>()",
    "String BasicCredentials.getPassword()",
    "CredentialsType BasicCredentials.getType()",
    "String BasicCredentials.getUsername()",
    "void BasicCredentials.setPassword(String)",
    "void BasicCredentials.setUsername(String)",
    "String BasicCredentials.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BasicCredentials actualBasicCredentials = new BasicCredentials();
    actualBasicCredentials.setPassword("iloveyou");
    actualBasicCredentials.setUsername("janedoe");
    String actualToStringResult = actualBasicCredentials.toString();
    String actualPassword = actualBasicCredentials.getPassword();
    CredentialsType actualType = actualBasicCredentials.getType();

    // Assert
    assertEquals("BasicCredentials(username=janedoe, password=iloveyou)", actualToStringResult);
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualBasicCredentials.getUsername());
    assertEquals(CredentialsType.BASIC, actualType);
  }
}
