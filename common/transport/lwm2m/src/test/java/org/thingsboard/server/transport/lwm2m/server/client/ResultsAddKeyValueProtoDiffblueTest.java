package org.thingsboard.server.transport.lwm2m.server.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResultsAddKeyValueProtoDiffblueTest {
  /**
   * Test {@link ResultsAddKeyValueProto#equals(Object)}, and {@link
   * ResultsAddKeyValueProto#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResultsAddKeyValueProto#equals(Object)}
   *   <li>{@link ResultsAddKeyValueProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ResultsAddKeyValueProto.equals(Object)",
    "int ResultsAddKeyValueProto.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto.setResultTelemetries(new ArrayList<>());

    ResultsAddKeyValueProto resultsAddKeyValueProto2 = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto2.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto2.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertEquals(resultsAddKeyValueProto, resultsAddKeyValueProto2);
    int expectedHashCodeResult = resultsAddKeyValueProto.hashCode();
    assertEquals(expectedHashCodeResult, resultsAddKeyValueProto2.hashCode());
  }

  /**
   * Test {@link ResultsAddKeyValueProto#equals(Object)}, and {@link
   * ResultsAddKeyValueProto#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResultsAddKeyValueProto#equals(Object)}
   *   <li>{@link ResultsAddKeyValueProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ResultsAddKeyValueProto.equals(Object)",
    "int ResultsAddKeyValueProto.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertEquals(resultsAddKeyValueProto, resultsAddKeyValueProto);
    int expectedHashCodeResult = resultsAddKeyValueProto.hashCode();
    assertEquals(expectedHashCodeResult, resultsAddKeyValueProto.hashCode());
  }

  /**
   * Test {@link ResultsAddKeyValueProto#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResultsAddKeyValueProto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ResultsAddKeyValueProto.equals(Object)",
    "int ResultsAddKeyValueProto.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertNotEquals(resultsAddKeyValueProto, null);
  }

  /**
   * Test {@link ResultsAddKeyValueProto#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResultsAddKeyValueProto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ResultsAddKeyValueProto.equals(Object)",
    "int ResultsAddKeyValueProto.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertNotEquals(resultsAddKeyValueProto, "Different type to ResultsAddKeyValueProto");
  }
}
