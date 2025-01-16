package org.thingsboard.server.transport.lwm2m.server.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParametersAnalyzeResultDiffblueTest {
  /**
   * Test new {@link ParametersAnalyzeResult} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ParametersAnalyzeResult}
   */
  @Test
  @DisplayName("Test new ParametersAnalyzeResult (default constructor)")
  void testNewParametersAnalyzeResult() {
    // Arrange and Act
    ParametersAnalyzeResult actualParametersAnalyzeResult = new ParametersAnalyzeResult();

    // Assert
    assertTrue(actualParametersAnalyzeResult.getPathPostParametersAdd().isEmpty());
    assertTrue(actualParametersAnalyzeResult.getPathPostParametersDel().isEmpty());
  }

  /**
   * Test {@link ParametersAnalyzeResult#equals(Object)}, and
   * {@link ParametersAnalyzeResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ParametersAnalyzeResult#equals(Object)}
   *   <li>{@link ParametersAnalyzeResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParametersAnalyzeResult parametersAnalyzeResult = new ParametersAnalyzeResult();
    parametersAnalyzeResult.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult.setPathPostParametersDel(new HashSet<>());

    ParametersAnalyzeResult parametersAnalyzeResult2 = new ParametersAnalyzeResult();
    parametersAnalyzeResult2.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult2.setPathPostParametersDel(new HashSet<>());

    // Act and Assert
    assertEquals(parametersAnalyzeResult, parametersAnalyzeResult2);
    int expectedHashCodeResult = parametersAnalyzeResult.hashCode();
    assertEquals(expectedHashCodeResult, parametersAnalyzeResult2.hashCode());
  }

  /**
   * Test {@link ParametersAnalyzeResult#equals(Object)}, and
   * {@link ParametersAnalyzeResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ParametersAnalyzeResult#equals(Object)}
   *   <li>{@link ParametersAnalyzeResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParametersAnalyzeResult parametersAnalyzeResult = new ParametersAnalyzeResult();
    parametersAnalyzeResult.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult.setPathPostParametersDel(new HashSet<>());

    // Act and Assert
    assertEquals(parametersAnalyzeResult, parametersAnalyzeResult);
    int expectedHashCodeResult = parametersAnalyzeResult.hashCode();
    assertEquals(expectedHashCodeResult, parametersAnalyzeResult.hashCode());
  }

  /**
   * Test {@link ParametersAnalyzeResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParametersAnalyzeResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<String> pathPostParametersAdd = new HashSet<>();
    pathPostParametersAdd.add("foo");

    ParametersAnalyzeResult parametersAnalyzeResult = new ParametersAnalyzeResult();
    parametersAnalyzeResult.setPathPostParametersAdd(pathPostParametersAdd);
    parametersAnalyzeResult.setPathPostParametersDel(new HashSet<>());

    ParametersAnalyzeResult parametersAnalyzeResult2 = new ParametersAnalyzeResult();
    parametersAnalyzeResult2.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult2.setPathPostParametersDel(new HashSet<>());

    // Act and Assert
    assertNotEquals(parametersAnalyzeResult, parametersAnalyzeResult2);
  }

  /**
   * Test {@link ParametersAnalyzeResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParametersAnalyzeResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<String> pathPostParametersDel = new HashSet<>();
    pathPostParametersDel.add("foo");

    ParametersAnalyzeResult parametersAnalyzeResult = new ParametersAnalyzeResult();
    parametersAnalyzeResult.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult.setPathPostParametersDel(pathPostParametersDel);

    ParametersAnalyzeResult parametersAnalyzeResult2 = new ParametersAnalyzeResult();
    parametersAnalyzeResult2.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult2.setPathPostParametersDel(new HashSet<>());

    // Act and Assert
    assertNotEquals(parametersAnalyzeResult, parametersAnalyzeResult2);
  }

  /**
   * Test {@link ParametersAnalyzeResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParametersAnalyzeResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ParametersAnalyzeResult parametersAnalyzeResult = new ParametersAnalyzeResult();
    parametersAnalyzeResult.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult.setPathPostParametersDel(new HashSet<>());

    // Act and Assert
    assertNotEquals(parametersAnalyzeResult, null);
  }

  /**
   * Test {@link ParametersAnalyzeResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParametersAnalyzeResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ParametersAnalyzeResult parametersAnalyzeResult = new ParametersAnalyzeResult();
    parametersAnalyzeResult.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult.setPathPostParametersDel(new HashSet<>());

    // Act and Assert
    assertNotEquals(parametersAnalyzeResult, "Different type to ParametersAnalyzeResult");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ParametersAnalyzeResult#setPathPostParametersAdd(Set)}
   *   <li>{@link ParametersAnalyzeResult#setPathPostParametersDel(Set)}
   *   <li>{@link ParametersAnalyzeResult#toString()}
   *   <li>{@link ParametersAnalyzeResult#getPathPostParametersAdd()}
   *   <li>{@link ParametersAnalyzeResult#getPathPostParametersDel()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    ParametersAnalyzeResult parametersAnalyzeResult = new ParametersAnalyzeResult();
    HashSet<String> pathPostParametersAdd = new HashSet<>();

    // Act
    parametersAnalyzeResult.setPathPostParametersAdd(pathPostParametersAdd);
    HashSet<String> pathPostParametersDel = new HashSet<>();
    parametersAnalyzeResult.setPathPostParametersDel(pathPostParametersDel);
    String actualToStringResult = parametersAnalyzeResult.toString();
    Set<String> actualPathPostParametersAdd = parametersAnalyzeResult.getPathPostParametersAdd();
    Set<String> actualPathPostParametersDel = parametersAnalyzeResult.getPathPostParametersDel();

    // Assert that nothing has changed
    assertEquals("ParametersAnalyzeResult(pathPostParametersAdd=[], pathPostParametersDel=[])", actualToStringResult);
    assertTrue(actualPathPostParametersAdd.isEmpty());
    assertTrue(actualPathPostParametersDel.isEmpty());
    assertSame(pathPostParametersAdd, actualPathPostParametersAdd);
    assertSame(pathPostParametersDel, actualPathPostParametersDel);
  }
}
