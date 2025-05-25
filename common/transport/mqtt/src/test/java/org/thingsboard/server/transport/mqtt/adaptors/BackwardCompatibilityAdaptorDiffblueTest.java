package org.thingsboard.server.transport.mqtt.adaptors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BackwardCompatibilityAdaptorDiffblueTest {
  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}, and {@link BackwardCompatibilityAdaptor#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BackwardCompatibilityAdaptor#equals(Object)}
   *   <li>{@link BackwardCompatibilityAdaptor#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackwardCompatibilityAdaptor.equals(Object)",
      "int BackwardCompatibilityAdaptor.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(null, null);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor2 = new BackwardCompatibilityAdaptor(null, null);

    // Act and Assert
    assertEquals(backwardCompatibilityAdaptor, backwardCompatibilityAdaptor2);
    int expectedHashCodeResult = backwardCompatibilityAdaptor.hashCode();
    assertEquals(expectedHashCodeResult, backwardCompatibilityAdaptor2.hashCode());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}, and {@link BackwardCompatibilityAdaptor#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BackwardCompatibilityAdaptor#equals(Object)}
   *   <li>{@link BackwardCompatibilityAdaptor#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackwardCompatibilityAdaptor.equals(Object)",
      "int BackwardCompatibilityAdaptor.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());

    // Act and Assert
    assertEquals(backwardCompatibilityAdaptor, backwardCompatibilityAdaptor);
    int expectedHashCodeResult = backwardCompatibilityAdaptor.hashCode();
    assertEquals(expectedHashCodeResult, backwardCompatibilityAdaptor.hashCode());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackwardCompatibilityAdaptor.equals(Object)",
      "int BackwardCompatibilityAdaptor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor,
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor()));
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackwardCompatibilityAdaptor.equals(Object)",
      "int BackwardCompatibilityAdaptor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor protoAdaptor2 = new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor2,
        new JsonMqttAdaptor());
    JsonMqttAdaptor protoAdaptor3 = new JsonMqttAdaptor();

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor,
        new BackwardCompatibilityAdaptor(protoAdaptor3, new JsonMqttAdaptor()));
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackwardCompatibilityAdaptor.equals(Object)",
      "int BackwardCompatibilityAdaptor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(null,
        new JsonMqttAdaptor());
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor,
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor()));
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackwardCompatibilityAdaptor.equals(Object)",
      "int BackwardCompatibilityAdaptor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(null,
        new JsonMqttAdaptor());

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor, new BackwardCompatibilityAdaptor(null, new JsonMqttAdaptor()));
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackwardCompatibilityAdaptor.equals(Object)",
      "int BackwardCompatibilityAdaptor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(null,
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor()));

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor, new BackwardCompatibilityAdaptor(null, new JsonMqttAdaptor()));
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackwardCompatibilityAdaptor.equals(Object)",
      "int BackwardCompatibilityAdaptor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(null, null);

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor, new BackwardCompatibilityAdaptor(null, new JsonMqttAdaptor()));
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackwardCompatibilityAdaptor.equals(Object)",
      "int BackwardCompatibilityAdaptor.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();

    // Act and Assert
    assertNotEquals(new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor()), null);
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackwardCompatibilityAdaptor.equals(Object)",
      "int BackwardCompatibilityAdaptor.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();

    // Act and Assert
    assertNotEquals(new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor()),
        "Different type to BackwardCompatibilityAdaptor");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BackwardCompatibilityAdaptor#BackwardCompatibilityAdaptor(MqttTransportAdaptor, MqttTransportAdaptor)}
   *   <li>{@link BackwardCompatibilityAdaptor#setJsonAdaptor(MqttTransportAdaptor)}
   *   <li>{@link BackwardCompatibilityAdaptor#setProtoAdaptor(MqttTransportAdaptor)}
   *   <li>{@link BackwardCompatibilityAdaptor#toString()}
   *   <li>{@link BackwardCompatibilityAdaptor#getJsonAdaptor()}
   *   <li>{@link BackwardCompatibilityAdaptor#getProtoAdaptor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackwardCompatibilityAdaptor.<init>(MqttTransportAdaptor, MqttTransportAdaptor)",
      "MqttTransportAdaptor BackwardCompatibilityAdaptor.getJsonAdaptor()",
      "MqttTransportAdaptor BackwardCompatibilityAdaptor.getProtoAdaptor()",
      "void BackwardCompatibilityAdaptor.setJsonAdaptor(MqttTransportAdaptor)",
      "void BackwardCompatibilityAdaptor.setProtoAdaptor(MqttTransportAdaptor)",
      "java.lang.String BackwardCompatibilityAdaptor.toString()"})
  void testGettersAndSetters() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();

    // Act
    BackwardCompatibilityAdaptor actualBackwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    JsonMqttAdaptor jsonAdaptor = new JsonMqttAdaptor();
    actualBackwardCompatibilityAdaptor.setJsonAdaptor(jsonAdaptor);
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();
    actualBackwardCompatibilityAdaptor.setProtoAdaptor(protoAdaptor2);
    actualBackwardCompatibilityAdaptor.toString();
    MqttTransportAdaptor actualJsonAdaptor = actualBackwardCompatibilityAdaptor.getJsonAdaptor();
    MqttTransportAdaptor actualProtoAdaptor = actualBackwardCompatibilityAdaptor.getProtoAdaptor();

    // Assert
    assertTrue(actualJsonAdaptor instanceof JsonMqttAdaptor);
    assertTrue(actualProtoAdaptor instanceof JsonMqttAdaptor);
    assertSame(jsonAdaptor, actualJsonAdaptor);
    assertSame(protoAdaptor2, actualProtoAdaptor);
  }
}
