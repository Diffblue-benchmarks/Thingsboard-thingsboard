package org.thingsboard.server.transport.lwm2m.server.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;

class ResultsAddKeyValueProtoDiffblueTest {
  /**
   * Test {@link ResultsAddKeyValueProto#equals(Object)}, and
   * {@link ResultsAddKeyValueProto#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResultsAddKeyValueProto#equals(Object)}
   *   <li>{@link ResultsAddKeyValueProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link ResultsAddKeyValueProto#equals(Object)}, and
   * {@link ResultsAddKeyValueProto#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResultsAddKeyValueProto#equals(Object)}
   *   <li>{@link ResultsAddKeyValueProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResultsAddKeyValueProto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<TransportProtos.KeyValueProto> resultAttributes = new ArrayList<>();
    resultAttributes.add(TransportProtos.KeyValueProto.getDefaultInstance());

    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(resultAttributes);
    resultsAddKeyValueProto.setResultTelemetries(new ArrayList<>());

    ResultsAddKeyValueProto resultsAddKeyValueProto2 = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto2.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto2.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertNotEquals(resultsAddKeyValueProto, resultsAddKeyValueProto2);
  }

  /**
   * Test {@link ResultsAddKeyValueProto#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResultsAddKeyValueProto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<TransportProtos.KeyValueProto> resultTelemetries = new ArrayList<>();
    resultTelemetries.add(TransportProtos.KeyValueProto.getDefaultInstance());

    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto.setResultTelemetries(resultTelemetries);

    ResultsAddKeyValueProto resultsAddKeyValueProto2 = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto2.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto2.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertNotEquals(resultsAddKeyValueProto, resultsAddKeyValueProto2);
  }

  /**
   * Test {@link ResultsAddKeyValueProto#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResultsAddKeyValueProto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResultsAddKeyValueProto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertNotEquals(resultsAddKeyValueProto, "Different type to ResultsAddKeyValueProto");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ResultsAddKeyValueProto}
   *   <li>{@link ResultsAddKeyValueProto#setResultAttributes(List)}
   *   <li>{@link ResultsAddKeyValueProto#setResultTelemetries(List)}
   *   <li>{@link ResultsAddKeyValueProto#toString()}
   *   <li>{@link ResultsAddKeyValueProto#getResultAttributes()}
   *   <li>{@link ResultsAddKeyValueProto#getResultTelemetries()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    ResultsAddKeyValueProto actualResultsAddKeyValueProto = new ResultsAddKeyValueProto();
    ArrayList<TransportProtos.KeyValueProto> resultAttributes = new ArrayList<>();
    actualResultsAddKeyValueProto.setResultAttributes(resultAttributes);
    ArrayList<TransportProtos.KeyValueProto> resultTelemetries = new ArrayList<>();
    actualResultsAddKeyValueProto.setResultTelemetries(resultTelemetries);
    String actualToStringResult = actualResultsAddKeyValueProto.toString();
    List<TransportProtos.KeyValueProto> actualResultAttributes = actualResultsAddKeyValueProto.getResultAttributes();
    List<TransportProtos.KeyValueProto> actualResultTelemetries = actualResultsAddKeyValueProto.getResultTelemetries();

    // Assert that nothing has changed
    assertEquals("ResultsAddKeyValueProto(resultAttributes=[], resultTelemetries=[])", actualToStringResult);
    assertTrue(actualResultAttributes.isEmpty());
    assertTrue(actualResultTelemetries.isEmpty());
    assertSame(resultAttributes, actualResultAttributes);
    assertSame(resultTelemetries, actualResultTelemetries);
  }
}
