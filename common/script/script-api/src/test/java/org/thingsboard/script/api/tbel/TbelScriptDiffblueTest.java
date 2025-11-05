package org.thingsboard.script.api.tbel;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbelScriptDiffblueTest {
  /**
   * Test {@link TbelScript#createVars(Object[])}.
   *
   * <p>Method under test: {@link TbelScript#createVars(Object[])}
   */
  @Test
  @DisplayName("Test createVars(Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TbelScript.createVars(Object[])"})
  void testCreateVars() {
    // Arrange
    TbelScript tbelScript = new TbelScript("Not all who wander are lost", new String[] {});

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> tbelScript.createVars(new Object[] {"Args"}));
  }

  /**
   * Test {@link TbelScript#createVars(Object[])}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link TbelScript#createVars(Object[])}
   */
  @Test
  @DisplayName("Test createVars(Object[]); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TbelScript.createVars(Object[])"})
  void testCreateVars_thenReturnSizeIsOne() {
    // Arrange
    String[] argNames = new String[] {"Arg Names"};
    TbelScript tbelScript = new TbelScript("Not all who wander are lost", argNames);

    // Act
    Map actualCreateVarsResult = tbelScript.createVars(new Object[] {"Args"});

    // Assert
    assertEquals(1, actualCreateVarsResult.size());
    assertEquals("Args", actualCreateVarsResult.get("Arg Names"));
  }

  /**
   * Test {@link TbelScript#createVars(Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbelScript#createVars(Object[])}
   */
  @Test
  @DisplayName("Test createVars(Object[]); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TbelScript.createVars(Object[])"})
  void testCreateVars_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    String[] argNames = new String[] {"Arg Names"};
    TbelScript tbelScript = new TbelScript("Not all who wander are lost", argNames);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbelScript.createVars(null));
  }

  /**
   * Test {@link TbelScript#equals(Object)}, and {@link TbelScript#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbelScript#equals(Object)}
   *   <li>{@link TbelScript#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbelScript.equals(Object)", "int TbelScript.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    String[] argNames = new String[] {"Arg Names"};
    TbelScript tbelScript = new TbelScript("Not all who wander are lost", argNames);
    String[] argNames2 = new String[] {"Arg Names"};
    TbelScript tbelScript2 = new TbelScript("Not all who wander are lost", argNames2);

    // Act and Assert
    assertEquals(tbelScript, tbelScript2);
    assertEquals(tbelScript.hashCode(), tbelScript2.hashCode());
  }

  /**
   * Test {@link TbelScript#equals(Object)}, and {@link TbelScript#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbelScript#equals(Object)}
   *   <li>{@link TbelScript#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbelScript.equals(Object)", "int TbelScript.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    String[] argNames = new String[] {"Arg Names"};
    TbelScript tbelScript = new TbelScript(null, argNames);
    String[] argNames2 = new String[] {"Arg Names"};
    TbelScript tbelScript2 = new TbelScript(null, argNames2);

    // Act and Assert
    assertEquals(tbelScript, tbelScript2);
    assertEquals(tbelScript.hashCode(), tbelScript2.hashCode());
  }

  /**
   * Test {@link TbelScript#equals(Object)}, and {@link TbelScript#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbelScript#equals(Object)}
   *   <li>{@link TbelScript#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbelScript.equals(Object)", "int TbelScript.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    String[] argNames = new String[] {"Arg Names"};
    TbelScript tbelScript = new TbelScript("Not all who wander are lost", argNames);

    // Act and Assert
    assertEquals(tbelScript, tbelScript);
    int expectedHashCodeResult = tbelScript.hashCode();
    assertEquals(expectedHashCodeResult, tbelScript.hashCode());
  }

  /**
   * Test {@link TbelScript#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbelScript#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbelScript.equals(Object)", "int TbelScript.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    String[] argNames = new String[] {"Arg Names"};
    TbelScript tbelScript = new TbelScript("Script Body", argNames);
    String[] argNames2 = new String[] {"Arg Names"};

    // Act and Assert
    assertNotEquals(tbelScript, new TbelScript("Not all who wander are lost", argNames2));
  }

  /**
   * Test {@link TbelScript#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbelScript#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbelScript.equals(Object)", "int TbelScript.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    String[] argNames = new String[] {"Arg Names"};
    TbelScript tbelScript = new TbelScript(null, argNames);
    String[] argNames2 = new String[] {"Arg Names"};

    // Act and Assert
    assertNotEquals(tbelScript, new TbelScript("Not all who wander are lost", argNames2));
  }

  /**
   * Test {@link TbelScript#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbelScript#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbelScript.equals(Object)", "int TbelScript.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbelScript tbelScript = new TbelScript("Not all who wander are lost", null);
    String[] argNames = new String[] {"Arg Names"};

    // Act and Assert
    assertNotEquals(tbelScript, new TbelScript("Not all who wander are lost", argNames));
  }

  /**
   * Test {@link TbelScript#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbelScript#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbelScript.equals(Object)", "int TbelScript.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    String[] argNames = new String[] {"Arg Names"};

    // Act and Assert
    assertNotEquals(new TbelScript("Not all who wander are lost", argNames), null);
  }

  /**
   * Test {@link TbelScript#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbelScript#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbelScript.equals(Object)", "int TbelScript.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    String[] argNames = new String[] {"Arg Names"};

    // Act and Assert
    assertNotEquals(
        new TbelScript("Not all who wander are lost", argNames), "Different type to TbelScript");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbelScript#TbelScript(String, String[])}
   *   <li>{@link TbelScript#toString()}
   *   <li>{@link TbelScript#getArgNames()}
   *   <li>{@link TbelScript#getScriptBody()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbelScript.<init>(String, String[])",
    "String[] TbelScript.getArgNames()",
    "String TbelScript.getScriptBody()",
    "String TbelScript.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    String[] argNames = new String[] {"Arg Names"};

    // Act
    TbelScript actualTbelScript = new TbelScript("Not all who wander are lost", argNames);
    String actualToStringResult = actualTbelScript.toString();
    String[] actualArgNames = actualTbelScript.getArgNames();

    // Assert
    assertEquals("Not all who wander are lost", actualTbelScript.getScriptBody());
    assertEquals(
        "TbelScript(scriptBody=Not all who wander are lost, argNames=[Arg Names])",
        actualToStringResult);
    assertSame(argNames, actualArgNames);
    assertArrayEquals(new String[] {"Arg Names"}, actualArgNames);
  }
}
