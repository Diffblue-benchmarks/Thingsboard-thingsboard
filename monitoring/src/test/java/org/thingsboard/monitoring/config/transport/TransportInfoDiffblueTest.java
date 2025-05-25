package org.thingsboard.monitoring.config.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TransportInfoDiffblueTest {
  /**
   * Test {@link TransportInfo#toString()}.
   * <ul>
   *   <li>Then return {@code *MQTT* (https://example.org/example)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportInfo#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '*MQTT* (https://example.org/example)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TransportInfo.toString()"})
  void testToString_thenReturnMqttHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("*MQTT* (https://example.org/example)",
        (new TransportInfo(TransportType.MQTT, "https://example.org/example", "Main")).toString());
  }

  /**
   * Test {@link TransportInfo#toString()}.
   * <ul>
   *   <li>Then return {@code *MQTT* (https://example.org/example) _Queue_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportInfo#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '*MQTT* (https://example.org/example) _Queue_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TransportInfo.toString()"})
  void testToString_thenReturnMqttHttpsExampleOrgExampleQueue() {
    // Arrange, Act and Assert
    assertEquals("*MQTT* (https://example.org/example) _Queue_",
        (new TransportInfo(TransportType.MQTT, "https://example.org/example", "Queue")).toString());
  }

  /**
   * Test {@link TransportInfo#equals(Object)}, and {@link TransportInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportInfo#equals(Object)}
   *   <li>{@link TransportInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportInfo.equals(Object)", "int TransportInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportInfo transportInfo = new TransportInfo(TransportType.MQTT, "https://example.org/example", "Queue");
    TransportInfo transportInfo2 = new TransportInfo(TransportType.MQTT, "https://example.org/example", "Queue");

    // Act and Assert
    assertEquals(transportInfo, transportInfo2);
    int expectedHashCodeResult = transportInfo.hashCode();
    assertEquals(expectedHashCodeResult, transportInfo2.hashCode());
  }

  /**
   * Test {@link TransportInfo#equals(Object)}, and {@link TransportInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportInfo#equals(Object)}
   *   <li>{@link TransportInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportInfo.equals(Object)", "int TransportInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TransportInfo transportInfo = new TransportInfo(null, "https://example.org/example", "Queue");
    TransportInfo transportInfo2 = new TransportInfo(null, "https://example.org/example", "Queue");

    // Act and Assert
    assertEquals(transportInfo, transportInfo2);
    int expectedHashCodeResult = transportInfo.hashCode();
    assertEquals(expectedHashCodeResult, transportInfo2.hashCode());
  }

  /**
   * Test {@link TransportInfo#equals(Object)}, and {@link TransportInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportInfo#equals(Object)}
   *   <li>{@link TransportInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportInfo.equals(Object)", "int TransportInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TransportInfo transportInfo = new TransportInfo(TransportType.MQTT, null, "Queue");
    TransportInfo transportInfo2 = new TransportInfo(TransportType.MQTT, null, "Queue");

    // Act and Assert
    assertEquals(transportInfo, transportInfo2);
    int expectedHashCodeResult = transportInfo.hashCode();
    assertEquals(expectedHashCodeResult, transportInfo2.hashCode());
  }

  /**
   * Test {@link TransportInfo#equals(Object)}, and {@link TransportInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportInfo#equals(Object)}
   *   <li>{@link TransportInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportInfo.equals(Object)", "int TransportInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TransportInfo transportInfo = new TransportInfo(TransportType.MQTT, "https://example.org/example", null);
    TransportInfo transportInfo2 = new TransportInfo(TransportType.MQTT, "https://example.org/example", null);

    // Act and Assert
    assertEquals(transportInfo, transportInfo2);
    int expectedHashCodeResult = transportInfo.hashCode();
    assertEquals(expectedHashCodeResult, transportInfo2.hashCode());
  }

  /**
   * Test {@link TransportInfo#equals(Object)}, and {@link TransportInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportInfo#equals(Object)}
   *   <li>{@link TransportInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportInfo.equals(Object)", "int TransportInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportInfo transportInfo = new TransportInfo(TransportType.MQTT, "https://example.org/example", "Queue");

    // Act and Assert
    assertEquals(transportInfo, transportInfo);
    int expectedHashCodeResult = transportInfo.hashCode();
    assertEquals(expectedHashCodeResult, transportInfo.hashCode());
  }

  /**
   * Test {@link TransportInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportInfo.equals(Object)", "int TransportInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TransportInfo transportInfo = new TransportInfo(null, "https://example.org/example", "Queue");

    // Act and Assert
    assertNotEquals(transportInfo, new TransportInfo(TransportType.MQTT, "https://example.org/example", "Queue"));
  }

  /**
   * Test {@link TransportInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportInfo.equals(Object)", "int TransportInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TransportInfo transportInfo = new TransportInfo(TransportType.COAP, "https://example.org/example", "Queue");

    // Act and Assert
    assertNotEquals(transportInfo, new TransportInfo(TransportType.MQTT, "https://example.org/example", "Queue"));
  }

  /**
   * Test {@link TransportInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportInfo.equals(Object)", "int TransportInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TransportInfo transportInfo = new TransportInfo(TransportType.MQTT, "Queue", "Queue");

    // Act and Assert
    assertNotEquals(transportInfo, new TransportInfo(TransportType.MQTT, "https://example.org/example", "Queue"));
  }

  /**
   * Test {@link TransportInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportInfo.equals(Object)", "int TransportInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TransportInfo transportInfo = new TransportInfo(TransportType.MQTT, null, "Queue");

    // Act and Assert
    assertNotEquals(transportInfo, new TransportInfo(TransportType.MQTT, "https://example.org/example", "Queue"));
  }

  /**
   * Test {@link TransportInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportInfo.equals(Object)", "int TransportInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TransportInfo transportInfo = new TransportInfo(TransportType.MQTT, "https://example.org/example",
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(transportInfo, new TransportInfo(TransportType.MQTT, "https://example.org/example", "Queue"));
  }

  /**
   * Test {@link TransportInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportInfo.equals(Object)", "int TransportInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TransportInfo transportInfo = new TransportInfo(TransportType.MQTT, "https://example.org/example", null);

    // Act and Assert
    assertNotEquals(transportInfo, new TransportInfo(TransportType.MQTT, "https://example.org/example", "Queue"));
  }

  /**
   * Test {@link TransportInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportInfo.equals(Object)", "int TransportInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TransportInfo(TransportType.MQTT, "https://example.org/example", "Queue"), null);
  }

  /**
   * Test {@link TransportInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportInfo.equals(Object)", "int TransportInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TransportInfo(TransportType.MQTT, "https://example.org/example", "Queue"),
        "Different type to TransportInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportInfo#TransportInfo(TransportType, String, String)}
   *   <li>{@link TransportInfo#getBaseUrl()}
   *   <li>{@link TransportInfo#getQueue()}
   *   <li>{@link TransportInfo#getTransportType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TransportInfo.<init>(TransportType, String, String)", "String TransportInfo.getBaseUrl()",
      "String TransportInfo.getQueue()", "TransportType TransportInfo.getTransportType()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TransportInfo actualTransportInfo = new TransportInfo(TransportType.MQTT, "https://example.org/example", "Queue");
    String actualBaseUrl = actualTransportInfo.getBaseUrl();
    String actualQueue = actualTransportInfo.getQueue();

    // Assert
    assertEquals("Queue", actualQueue);
    assertEquals("https://example.org/example", actualBaseUrl);
    assertEquals(TransportType.MQTT, actualTransportInfo.getTransportType());
  }
}
