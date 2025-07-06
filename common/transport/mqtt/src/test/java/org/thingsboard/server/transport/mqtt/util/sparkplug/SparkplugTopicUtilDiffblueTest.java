package org.thingsboard.server.transport.mqtt.util.sparkplug;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;

class SparkplugTopicUtilDiffblueTest {
  /**
   * Test {@link SparkplugTopicUtil#getSplitTopic(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#getSplitTopic(String)}
   */
  @Test
  @DisplayName("Test getSplitTopic(String); when '/'; then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] SparkplugTopicUtil.getSplitTopic(String)"})
  void testGetSplitTopic_whenSlash_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugTopicUtil.getSplitTopic("/").length);
  }

  /**
   * Test {@link SparkplugTopicUtil#getSplitTopic(String)}.
   *
   * <ul>
   *   <li>When {@code Topic}.
   *   <li>Then return array of {@link String} with {@code Topic}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#getSplitTopic(String)}
   */
  @Test
  @DisplayName("Test getSplitTopic(String); when 'Topic'; then return array of String with 'Topic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] SparkplugTopicUtil.getSplitTopic(String)"})
  void testGetSplitTopic_whenTopic_thenReturnArrayOfStringWithTopic() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[] {"Topic"}, SparkplugTopicUtil.getSplitTopic("Topic"));
  }

  /**
   * Test {@link SparkplugTopicUtil#sparkplugTopicToString(SparkplugTopic)}.
   *
   * <ul>
   *   <li>Then return {@code {"namespace":"spBv1.0","node":true}}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#sparkplugTopicToString(SparkplugTopic)}
   */
  @Test
  @DisplayName(
      "Test sparkplugTopicToString(SparkplugTopic); then return '{\"namespace\":\"spBv1.0\",\"node\":true}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SparkplugTopicUtil.sparkplugTopicToString(SparkplugTopic)"})
  void testSparkplugTopicToString_thenReturnNamespaceSpBv10NodeTrue()
      throws JsonProcessingException, ThingsboardException {
    // Arrange, Act and Assert
    assertEquals(
        "{\"namespace\":\"spBv1.0\",\"node\":true}",
        SparkplugTopicUtil.sparkplugTopicToString(
            SparkplugTopicUtil.parseTopic(new String[] {SparkplugTopicUtil.NAMESPACE})));
  }

  /**
   * Test {@link SparkplugTopicUtil#sparkplugTopicToString(SparkplugTopic)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#sparkplugTopicToString(SparkplugTopic)}
   */
  @Test
  @DisplayName("Test sparkplugTopicToString(SparkplugTopic); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SparkplugTopicUtil.sparkplugTopicToString(SparkplugTopic)"})
  void testSparkplugTopicToString_whenNull_thenReturnNull() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertEquals("null", SparkplugTopicUtil.sparkplugTopicToString(null));
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopicSubscribe(String)}.
   *
   * <ul>
   *   <li>When {@link SparkplugTopicUtil#NAMESPACE}.
   *   <li>Then return DeviceId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopicSubscribe(String)}
   */
  @Test
  @DisplayName("Test parseTopicSubscribe(String); when NAMESPACE; then return DeviceId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopicSubscribe(String)"})
  void testParseTopicSubscribe_whenNamespace_thenReturnDeviceIdIsNull()
      throws ThingsboardException {
    // Arrange and Act
    SparkplugTopic actualParseTopicSubscribeResult =
        SparkplugTopicUtil.parseTopicSubscribe(SparkplugTopicUtil.NAMESPACE);

    // Assert
    assertNull(actualParseTopicSubscribeResult.getDeviceId());
    assertNull(actualParseTopicSubscribeResult.getEdgeNodeId());
    assertNull(actualParseTopicSubscribeResult.getGroupId());
    assertNull(actualParseTopicSubscribeResult.getNodeDeviceName());
    assertNull(actualParseTopicSubscribeResult.getType());
    assertTrue(actualParseTopicSubscribeResult.isNode());
    assertEquals(SparkplugTopicUtil.NAMESPACE, actualParseTopicSubscribeResult.getNamespace());
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopicSubscribe(String)}.
   *
   * <ul>
   *   <li>When {@code spBv1.0#}.
   *   <li>Then return DeviceId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopicSubscribe(String)}
   */
  @Test
  @DisplayName("Test parseTopicSubscribe(String); when 'spBv1.0#'; then return DeviceId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopicSubscribe(String)"})
  void testParseTopicSubscribe_whenSpBv10_thenReturnDeviceIdIsNull() throws ThingsboardException {
    // Arrange and Act
    SparkplugTopic actualParseTopicSubscribeResult =
        SparkplugTopicUtil.parseTopicSubscribe("spBv1.0#");

    // Assert
    assertNull(actualParseTopicSubscribeResult.getDeviceId());
    assertNull(actualParseTopicSubscribeResult.getEdgeNodeId());
    assertNull(actualParseTopicSubscribeResult.getGroupId());
    assertNull(actualParseTopicSubscribeResult.getNodeDeviceName());
    assertNull(actualParseTopicSubscribeResult.getType());
    assertTrue(actualParseTopicSubscribeResult.isNode());
    assertEquals(SparkplugTopicUtil.NAMESPACE, actualParseTopicSubscribeResult.getNamespace());
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopicSubscribe(String)}.
   *
   * <ul>
   *   <li>When {@code spBv1.0spBv1.0spBv1.0}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopicSubscribe(String)}
   */
  @Test
  @DisplayName(
      "Test parseTopicSubscribe(String); when 'spBv1.0spBv1.0spBv1.0'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopicSubscribe(String)"})
  void testParseTopicSubscribe_whenSpBv10spBv10spBv10_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> SparkplugTopicUtil.parseTopicSubscribe("spBv1.0spBv1.0spBv1.0"));
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopicSubscribe(String)}.
   *
   * <ul>
   *   <li>When {@code Topic}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopicSubscribe(String)}
   */
  @Test
  @DisplayName("Test parseTopicSubscribe(String); when 'Topic'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopicSubscribe(String)"})
  void testParseTopicSubscribe_whenTopic_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> SparkplugTopicUtil.parseTopicSubscribe("Topic"));
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopicPublish(String)}.
   *
   * <ul>
   *   <li>When {@code $}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopicPublish(String)}
   */
  @Test
  @DisplayName("Test parseTopicPublish(String); when '$'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopicPublish(String)"})
  void testParseTopicPublish_whenDollarSign_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> SparkplugTopicUtil.parseTopicPublish("$"));
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopicPublish(String)}.
   *
   * <ul>
   *   <li>When {@code Invalid of topic elements for Publish}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopicPublish(String)}
   */
  @Test
  @DisplayName("Test parseTopicPublish(String); when 'Invalid of topic elements for Publish'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopicPublish(String)"})
  void testParseTopicPublish_whenInvalidOfTopicElementsForPublish() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> SparkplugTopicUtil.parseTopicPublish("Invalid of topic elements for Publish"));
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopicPublish(String)}.
   *
   * <ul>
   *   <li>When {@code #}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopicPublish(String)}
   */
  @Test
  @DisplayName("Test parseTopicPublish(String); when '#'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopicPublish(String)"})
  void testParseTopicPublish_whenNumberSign_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> SparkplugTopicUtil.parseTopicPublish("#"));
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopicPublish(String)}.
   *
   * <ul>
   *   <li>When {@code +}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopicPublish(String)}
   */
  @Test
  @DisplayName("Test parseTopicPublish(String); when '+'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopicPublish(String)"})
  void testParseTopicPublish_whenPlusSign_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> SparkplugTopicUtil.parseTopicPublish("+"));
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopicPublish(String)}.
   *
   * <ul>
   *   <li>When {@code Topic}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopicPublish(String)}
   */
  @Test
  @DisplayName("Test parseTopicPublish(String); when 'Topic'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopicPublish(String)"})
  void testParseTopicPublish_whenTopic_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> SparkplugTopicUtil.parseTopicPublish("Topic"));
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopic(String[])}.
   *
   * <ul>
   *   <li>Then return Type is {@code NBIRTH}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopic(String[])}
   */
  @Test
  @DisplayName("Test parseTopic(String[]); then return Type is 'NBIRTH'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopic(String[])"})
  void testParseTopic_thenReturnTypeIsNbirth() throws ThingsboardException {
    // Arrange and Act
    SparkplugTopic actualParseTopicResult =
        SparkplugTopicUtil.parseTopic(
            new String[] {SparkplugTopicUtil.NAMESPACE, "Split Topic", "NBIRTH"});

    // Assert
    assertEquals("Split Topic", actualParseTopicResult.getGroupId());
    assertNull(actualParseTopicResult.getDeviceId());
    assertNull(actualParseTopicResult.getEdgeNodeId());
    assertNull(actualParseTopicResult.getNodeDeviceName());
    assertEquals(SparkplugMessageType.NBIRTH, actualParseTopicResult.getType());
    assertTrue(actualParseTopicResult.isNode());
    assertEquals(SparkplugTopicUtil.NAMESPACE, actualParseTopicResult.getNamespace());
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopic(String[])}.
   *
   * <ul>
   *   <li>Then return Type is {@code NDEATH}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopic(String[])}
   */
  @Test
  @DisplayName("Test parseTopic(String[]); then return Type is 'NDEATH'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopic(String[])"})
  void testParseTopic_thenReturnTypeIsNdeath() throws ThingsboardException {
    // Arrange and Act
    SparkplugTopic actualParseTopicResult =
        SparkplugTopicUtil.parseTopic(
            new String[] {SparkplugTopicUtil.NAMESPACE, "Split Topic", "NDEATH"});

    // Assert
    assertEquals("Split Topic", actualParseTopicResult.getGroupId());
    assertNull(actualParseTopicResult.getDeviceId());
    assertNull(actualParseTopicResult.getEdgeNodeId());
    assertNull(actualParseTopicResult.getNodeDeviceName());
    assertEquals(SparkplugMessageType.NDEATH, actualParseTopicResult.getType());
    assertTrue(actualParseTopicResult.isNode());
    assertEquals(SparkplugTopicUtil.NAMESPACE, actualParseTopicResult.getNamespace());
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopic(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@link SparkplugTopicUtil#NAMESPACE} and {@code Split
   *       Topic}.
   *   <li>Then return Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopic(String[])}
   */
  @Test
  @DisplayName(
      "Test parseTopic(String[]); when array of String with NAMESPACE and 'Split Topic'; then return Type is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopic(String[])"})
  void testParseTopic_whenArrayOfStringWithNamespaceAndSplitTopic_thenReturnTypeIsNull()
      throws ThingsboardException {
    // Arrange and Act
    SparkplugTopic actualParseTopicResult =
        SparkplugTopicUtil.parseTopic(new String[] {SparkplugTopicUtil.NAMESPACE, "Split Topic"});

    // Assert
    assertEquals("Split Topic", actualParseTopicResult.getGroupId());
    assertNull(actualParseTopicResult.getDeviceId());
    assertNull(actualParseTopicResult.getEdgeNodeId());
    assertNull(actualParseTopicResult.getNodeDeviceName());
    assertNull(actualParseTopicResult.getType());
    assertTrue(actualParseTopicResult.isNode());
    assertEquals(SparkplugTopicUtil.NAMESPACE, actualParseTopicResult.getNamespace());
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopic(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@link SparkplugTopicUtil#NAMESPACE}.
   *   <li>Then return GroupId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopic(String[])}
   */
  @Test
  @DisplayName(
      "Test parseTopic(String[]); when array of String with NAMESPACE; then return GroupId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopic(String[])"})
  void testParseTopic_whenArrayOfStringWithNamespace_thenReturnGroupIdIsNull()
      throws ThingsboardException {
    // Arrange and Act
    SparkplugTopic actualParseTopicResult =
        SparkplugTopicUtil.parseTopic(new String[] {SparkplugTopicUtil.NAMESPACE});

    // Assert
    assertNull(actualParseTopicResult.getDeviceId());
    assertNull(actualParseTopicResult.getEdgeNodeId());
    assertNull(actualParseTopicResult.getGroupId());
    assertNull(actualParseTopicResult.getNodeDeviceName());
    assertNull(actualParseTopicResult.getType());
    assertTrue(actualParseTopicResult.isNode());
    assertEquals(SparkplugTopicUtil.NAMESPACE, actualParseTopicResult.getNamespace());
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopic(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Split Topic}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopic(String[])}
   */
  @Test
  @DisplayName(
      "Test parseTopic(String[]); when array of String with 'Split Topic'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopic(String[])"})
  void testParseTopic_whenArrayOfStringWithSplitTopic_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> SparkplugTopicUtil.parseTopic(new String[] {"Split Topic"}));
  }

  /**
   * Test {@link SparkplugTopicUtil#parseTopic(String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopicUtil#parseTopic(String[])}
   */
  @Test
  @DisplayName(
      "Test parseTopic(String[]); when empty array of String; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkplugTopic SparkplugTopicUtil.parseTopic(String[])"})
  void testParseTopic_whenEmptyArrayOfString_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> SparkplugTopicUtil.parseTopic(new String[] {}));
  }
}
