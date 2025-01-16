package org.thingsboard.script.api.tbel;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbelScriptDiffblueTest {
  /**
   * Test {@link TbelScript#createVars(Object[])}.
   * <p>
   * Method under test: {@link TbelScript#createVars(Object[])}
   */
  @Test
  @DisplayName("Test createVars(Object[])")
  void testCreateVars() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TbelScript("Not all who wander are lost", new String[]{})).createVars(new Object[]{"Args"}));
  }

  /**
   * Test {@link TbelScript#createVars(Object[])}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbelScript#createVars(Object[])}
   */
  @Test
  @DisplayName("Test createVars(Object[]); then return size is one")
  void testCreateVars_thenReturnSizeIsOne() {
    // Arrange and Act
    Map actualCreateVarsResult = (new TbelScript("Not all who wander are lost", new String[]{"Arg Names"}))
        .createVars(new Object[]{"Args"});

    // Assert
    assertEquals(1, actualCreateVarsResult.size());
    assertEquals("Args", actualCreateVarsResult.get("Arg Names"));
  }

  /**
   * Test {@link TbelScript#createVars(Object[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbelScript#createVars(Object[])}
   */
  @Test
  @DisplayName("Test createVars(Object[]); when 'null'; then throw IllegalArgumentException")
  void testCreateVars_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TbelScript("Not all who wander are lost", new String[]{"Arg Names"})).createVars(null));
  }

  /**
   * Test {@link TbelScript#equals(Object)}, and {@link TbelScript#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbelScript#equals(Object)}
   *   <li>{@link TbelScript#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbelScript tbelScript = new TbelScript("Not all who wander are lost", new String[]{"Arg Names"});
    TbelScript tbelScript2 = new TbelScript("Not all who wander are lost", new String[]{"Arg Names"});

    // Act and Assert
    assertEquals(tbelScript, tbelScript2);
    int expectedHashCodeResult = tbelScript.hashCode();
    assertEquals(expectedHashCodeResult, tbelScript2.hashCode());
  }

  /**
   * Test {@link TbelScript#equals(Object)}, and {@link TbelScript#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbelScript#equals(Object)}
   *   <li>{@link TbelScript#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbelScript tbelScript = new TbelScript(null, new String[]{"Arg Names"});
    TbelScript tbelScript2 = new TbelScript(null, new String[]{"Arg Names"});

    // Act and Assert
    assertEquals(tbelScript, tbelScript2);
    int expectedHashCodeResult = tbelScript.hashCode();
    assertEquals(expectedHashCodeResult, tbelScript2.hashCode());
  }

  /**
   * Test {@link TbelScript#equals(Object)}, and {@link TbelScript#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbelScript#equals(Object)}
   *   <li>{@link TbelScript#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbelScript tbelScript = new TbelScript("Not all who wander are lost", new String[]{"Arg Names"});

    // Act and Assert
    assertEquals(tbelScript, tbelScript);
    int expectedHashCodeResult = tbelScript.hashCode();
    assertEquals(expectedHashCodeResult, tbelScript.hashCode());
  }

  /**
   * Test {@link TbelScript#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbelScript#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbelScript tbelScript = new TbelScript("Script Body", new String[]{"Arg Names"});

    // Act and Assert
    assertNotEquals(tbelScript, new TbelScript("Not all who wander are lost", new String[]{"Arg Names"}));
  }

  /**
   * Test {@link TbelScript#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbelScript#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbelScript tbelScript = new TbelScript(null, new String[]{"Arg Names"});

    // Act and Assert
    assertNotEquals(tbelScript, new TbelScript("Not all who wander are lost", new String[]{"Arg Names"}));
  }

  /**
   * Test {@link TbelScript#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbelScript#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbelScript tbelScript = new TbelScript("Not all who wander are lost", new String[]{"Not all who wander are lost"});

    // Act and Assert
    assertNotEquals(tbelScript, new TbelScript("Not all who wander are lost", new String[]{"Arg Names"}));
  }

  /**
   * Test {@link TbelScript#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbelScript#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbelScript("Not all who wander are lost", new String[]{"Arg Names"}), null);
  }

  /**
   * Test {@link TbelScript#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbelScript#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbelScript("Not all who wander are lost", new String[]{"Arg Names"}),
        "Different type to TbelScript");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbelScript#TbelScript(String, String[])}
   *   <li>{@link TbelScript#toString()}
   *   <li>{@link TbelScript#getArgNames()}
   *   <li>{@link TbelScript#getScriptBody()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    String[] argNames = new String[]{"Arg Names"};

    // Act
    TbelScript actualTbelScript = new TbelScript("Not all who wander are lost", argNames);
    String actualToStringResult = actualTbelScript.toString();
    String[] actualArgNames = actualTbelScript.getArgNames();

    // Assert
    assertEquals("Not all who wander are lost", actualTbelScript.getScriptBody());
    assertEquals("TbelScript(scriptBody=Not all who wander are lost, argNames=[Arg Names])", actualToStringResult);
    assertSame(argNames, actualArgNames);
    assertArrayEquals(new String[]{"Arg Names"}, actualArgNames);
  }
}
