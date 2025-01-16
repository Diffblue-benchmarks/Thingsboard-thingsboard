package org.thingsboard.server.service.install.update;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DefaultDataUpdateServiceDiffblueTest {
  /**
   * Test {@link DefaultDataUpdateService#updateData(String)}.
   * <ul>
   *   <li>When {@code jane.doe@example.org}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDataUpdateService#updateData(String)}
   */
  @Test
  @DisplayName("Test updateData(String); when 'jane.doe@example.org'; then throw RuntimeException")
  void testUpdateData_whenJaneDoeExampleOrg_thenThrowRuntimeException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new DefaultDataUpdateService()).updateData("jane.doe@example.org"));
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode)")
  void testConvertDeviceProfileForVersion330() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();

    // Act and Assert
    assertFalse(defaultDataUpdateService
        .convertDeviceProfileForVersion330(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode); given ArrayList() add Instance")
  void testConvertDeviceProfileForVersion330_givenArrayListAddInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();

    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    jsonNodeList.add(MissingNode.getInstance());
    Iterator<JsonNode> iteratorResult = jsonNodeList.iterator();
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.isNull()).thenReturn(false);
    when(arrayNode.iterator()).thenReturn(iteratorResult);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(profileData).has(eq("alarms"));
    verify(arrayNode).isNull();
    verify(arrayNode).iterator();
    verify(profileData, atLeast(1)).get(eq("alarms"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode); given ArrayNode get(String) return Instance")
  void testConvertDeviceProfileForVersion330_givenArrayNodeGetReturnInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    ArrayNode arrayNode2 = mock(ArrayNode.class);
    when(arrayNode2.has(Mockito.<String>any())).thenReturn(true);
    when(arrayNode2.get(Mockito.<String>any())).thenReturn(arrayNode);
    when(arrayNode2.isNull()).thenReturn(true);
    ArrayNode arrayNode3 = mock(ArrayNode.class);
    when(arrayNode3.get(Mockito.<String>any())).thenReturn(arrayNode2);
    when(arrayNode3.has(Mockito.<String>any())).thenReturn(true);

    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    jsonNodeList.add(arrayNode3);
    Iterator<JsonNode> iteratorResult = jsonNodeList.iterator();
    ArrayNode arrayNode4 = mock(ArrayNode.class);
    when(arrayNode4.isNull()).thenReturn(false);
    when(arrayNode4.iterator()).thenReturn(iteratorResult);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode4);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(arrayNode3, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode2, atLeast(1)).has(Mockito.<String>any());
    verify(profileData).has(eq("alarms"));
    verify(arrayNode4).isNull();
    verify(arrayNode2).isNull();
    verify(arrayNode4).iterator();
    verify(arrayNode3, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode2, atLeast(1)).get(Mockito.<String>any());
    verify(profileData, atLeast(1)).get(eq("alarms"));
    verify(arrayNode, atLeast(1)).get(eq("condition"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode); given ArrayNode get(String) return Instance")
  void testConvertDeviceProfileForVersion330_givenArrayNodeGetReturnInstance2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    ArrayNode arrayNode2 = mock(ArrayNode.class);
    when(arrayNode2.get(Mockito.<String>any())).thenReturn(arrayNode);
    ArrayNode arrayNode3 = mock(ArrayNode.class);
    when(arrayNode3.has(Mockito.<String>any())).thenReturn(true);
    when(arrayNode3.get(Mockito.<String>any())).thenReturn(arrayNode2);
    when(arrayNode3.isNull()).thenReturn(true);
    ArrayNode arrayNode4 = mock(ArrayNode.class);
    when(arrayNode4.get(Mockito.<String>any())).thenReturn(arrayNode3);
    when(arrayNode4.has(Mockito.<String>any())).thenReturn(true);

    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    jsonNodeList.add(arrayNode4);
    Iterator<JsonNode> iteratorResult = jsonNodeList.iterator();
    ArrayNode arrayNode5 = mock(ArrayNode.class);
    when(arrayNode5.isNull()).thenReturn(false);
    when(arrayNode5.iterator()).thenReturn(iteratorResult);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode5);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(arrayNode4, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode3, atLeast(1)).has(Mockito.<String>any());
    verify(profileData).has(eq("alarms"));
    verify(arrayNode5).isNull();
    verify(arrayNode3).isNull();
    verify(arrayNode5).iterator();
    verify(arrayNode4, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode3, atLeast(1)).get(Mockito.<String>any());
    verify(profileData, atLeast(1)).get(eq("alarms"));
    verify(arrayNode2, atLeast(1)).get(eq("condition"));
    verify(arrayNode, atLeast(1)).get(eq("spec"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode); given ArrayNode get(String) return Instance")
  void testConvertDeviceProfileForVersion330_givenArrayNodeGetReturnInstance3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    when(arrayNode.has(Mockito.<String>any())).thenReturn(true);
    ArrayNode arrayNode2 = mock(ArrayNode.class);
    when(arrayNode2.get(Mockito.<String>any())).thenReturn(arrayNode);
    ArrayNode arrayNode3 = mock(ArrayNode.class);
    when(arrayNode3.get(Mockito.<String>any())).thenReturn(arrayNode2);
    ArrayNode arrayNode4 = mock(ArrayNode.class);
    when(arrayNode4.has(Mockito.<String>any())).thenReturn(true);
    when(arrayNode4.get(Mockito.<String>any())).thenReturn(arrayNode3);
    when(arrayNode4.isNull()).thenReturn(true);
    ArrayNode arrayNode5 = mock(ArrayNode.class);
    when(arrayNode5.get(Mockito.<String>any())).thenReturn(arrayNode4);
    when(arrayNode5.has(Mockito.<String>any())).thenReturn(true);

    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    jsonNodeList.add(arrayNode5);
    Iterator<JsonNode> iteratorResult = jsonNodeList.iterator();
    ArrayNode arrayNode6 = mock(ArrayNode.class);
    when(arrayNode6.isNull()).thenReturn(false);
    when(arrayNode6.iterator()).thenReturn(iteratorResult);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode6);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(arrayNode5, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode4, atLeast(1)).has(Mockito.<String>any());
    verify(profileData).has(eq("alarms"));
    verify(arrayNode, atLeast(1)).has(eq("type"));
    verify(arrayNode6).isNull();
    verify(arrayNode4).isNull();
    verify(arrayNode6).iterator();
    verify(arrayNode5, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode4, atLeast(1)).get(Mockito.<String>any());
    verify(profileData, atLeast(1)).get(eq("alarms"));
    verify(arrayNode3, atLeast(1)).get(eq("condition"));
    verify(arrayNode2, atLeast(1)).get(eq("spec"));
    verify(arrayNode, atLeast(1)).get(eq("type"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link JsonNode#isNull()} return
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode); given ArrayNode isNull() return 'true'")
  void testConvertDeviceProfileForVersion330_givenArrayNodeIsNullReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.isNull()).thenReturn(true);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(profileData).has(eq("alarms"));
    verify(arrayNode).isNull();
    verify(profileData).get(eq("alarms"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <ul>
   *   <li>Given {@link BigIntegerNode#BigIntegerNode(BigInteger)} with v is valueOf
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode); given BigIntegerNode(BigInteger) with v is valueOf one")
  void testConvertDeviceProfileForVersion330_givenBigIntegerNodeWithVIsValueOfOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(new BigIntegerNode(BigInteger.valueOf(1L)));
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(profileData).has(eq("alarms"));
    verify(profileData, atLeast(1)).get(eq("alarms"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <ul>
   *   <li>Given Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode); given Instance")
  void testConvertDeviceProfileForVersion330_givenInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(profileData).has(eq("alarms"));
    verify(profileData, atLeast(1)).get(eq("alarms"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code alarms}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode); given RuntimeException(String) with 'alarms'")
  void testConvertDeviceProfileForVersion330_givenRuntimeExceptionWithAlarms() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenThrow(new RuntimeException("alarms"));
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultDataUpdateService.convertDeviceProfileForVersion330(profileData));
    verify(profileData).has(eq("alarms"));
    verify(profileData).get(eq("alarms"));
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <ul>
   *   <li>Then calls {@link ContainerNode#asText()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode); then calls asText()")
  void testConvertDeviceProfileForVersion330_thenCallsAsText() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asText()).thenReturn("As Text");
    ArrayNode arrayNode2 = mock(ArrayNode.class);
    when(arrayNode2.asText()).thenReturn("As Text");
    when(arrayNode2.get(Mockito.<String>any())).thenReturn(arrayNode);
    when(arrayNode2.has(Mockito.<String>any())).thenReturn(true);
    ArrayNode arrayNode3 = mock(ArrayNode.class);
    when(arrayNode3.has(Mockito.<String>any())).thenReturn(true);
    when(arrayNode3.get(Mockito.<String>any())).thenReturn(arrayNode2);
    ArrayNode arrayNode4 = mock(ArrayNode.class);
    when(arrayNode4.get(Mockito.<String>any())).thenReturn(arrayNode3);
    ArrayNode arrayNode5 = mock(ArrayNode.class);
    when(arrayNode5.has(Mockito.<String>any())).thenReturn(true);
    when(arrayNode5.get(Mockito.<String>any())).thenReturn(arrayNode4);
    when(arrayNode5.isNull()).thenReturn(false);
    ArrayNode arrayNode6 = mock(ArrayNode.class);
    when(arrayNode6.get(Mockito.<String>any())).thenReturn(arrayNode5);
    when(arrayNode6.has(Mockito.<String>any())).thenReturn(true);

    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    jsonNodeList.add(arrayNode6);
    Iterator<JsonNode> iteratorResult = jsonNodeList.iterator();
    ArrayNode arrayNode7 = mock(ArrayNode.class);
    when(arrayNode7.isNull()).thenReturn(false);
    when(arrayNode7.iterator()).thenReturn(iteratorResult);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode7);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(arrayNode6, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode5, atLeast(1)).has(Mockito.<String>any());
    verify(profileData).has(eq("alarms"));
    verify(arrayNode3, atLeast(1)).has(eq("type"));
    verify(arrayNode2, atLeast(1)).has(eq("type"));
    verify(arrayNode7).isNull();
    verify(arrayNode5).isNull();
    verify(arrayNode7).iterator();
    verify(arrayNode6, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode5, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode4, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode3, atLeast(1)).get(Mockito.<String>any());
    verify(profileData, atLeast(1)).get(eq("alarms"));
    verify(arrayNode2, atLeast(1)).get(eq("type"));
    verify(arrayNode2, atLeast(1)).asText();
    verify(arrayNode, atLeast(1)).asText();
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <ul>
   *   <li>Then calls {@link JsonNode#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode); then calls iterator()")
  void testConvertDeviceProfileForVersion330_thenCallsIterator() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.isNull()).thenReturn(false);

    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    when(arrayNode.iterator()).thenReturn(jsonNodeList.iterator());
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(profileData).has(eq("alarms"));
    verify(arrayNode).isNull();
    verify(arrayNode).iterator();
    verify(profileData, atLeast(1)).get(eq("alarms"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode); when Instance; then return 'false'")
  void testConvertDeviceProfileForVersion330_whenInstance_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();

    // Act and Assert
    assertFalse(defaultDataUpdateService.convertDeviceProfileForVersion330(MissingNode.getInstance()));
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode)")
  void testConvertDeviceProfileForVersion3302() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(profileData).has(eq("alarms"));
    verify(profileData, atLeast(1)).get(eq("alarms"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode)")
  void testConvertDeviceProfileForVersion3303() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();

    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    jsonNodeList.add(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    Iterator<JsonNode> iteratorResult = jsonNodeList.iterator();
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.isNull()).thenReturn(false);
    when(arrayNode.iterator()).thenReturn(iteratorResult);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(profileData).has(eq("alarms"));
    verify(arrayNode).isNull();
    verify(arrayNode).iterator();
    verify(profileData, atLeast(1)).get(eq("alarms"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode)")
  void testConvertDeviceProfileForVersion3304() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenThrow(new RuntimeException("alarms"));
    when(arrayNode.has(Mockito.<String>any())).thenReturn(true);

    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    jsonNodeList.add(arrayNode);
    Iterator<JsonNode> iteratorResult = jsonNodeList.iterator();
    ArrayNode arrayNode2 = mock(ArrayNode.class);
    when(arrayNode2.isNull()).thenReturn(false);
    when(arrayNode2.iterator()).thenReturn(iteratorResult);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode2);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultDataUpdateService.convertDeviceProfileForVersion330(profileData));
    verify(profileData).has(eq("alarms"));
    verify(arrayNode).has(eq("createRules"));
    verify(arrayNode2).isNull();
    verify(arrayNode2).iterator();
    verify(profileData, atLeast(1)).get(eq("alarms"));
    verify(arrayNode).get(eq("createRules"));
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode)")
  void testConvertDeviceProfileForVersion3305() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    ArrayNode arrayNode2 = mock(ArrayNode.class);
    when(arrayNode2.has(Mockito.<String>any())).thenReturn(true);
    when(arrayNode2.get(Mockito.<String>any())).thenReturn(arrayNode);
    when(arrayNode2.isNull()).thenReturn(true);
    ArrayNode arrayNode3 = mock(ArrayNode.class);
    when(arrayNode3.get(Mockito.<String>any())).thenReturn(arrayNode2);
    when(arrayNode3.has(Mockito.<String>any())).thenReturn(true);

    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    jsonNodeList.add(arrayNode3);
    Iterator<JsonNode> iteratorResult = jsonNodeList.iterator();
    ArrayNode arrayNode4 = mock(ArrayNode.class);
    when(arrayNode4.isNull()).thenReturn(false);
    when(arrayNode4.iterator()).thenReturn(iteratorResult);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode4);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(arrayNode3, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode2, atLeast(1)).has(Mockito.<String>any());
    verify(profileData).has(eq("alarms"));
    verify(arrayNode4).isNull();
    verify(arrayNode2).isNull();
    verify(arrayNode4).iterator();
    verify(arrayNode3, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode2, atLeast(1)).get(Mockito.<String>any());
    verify(profileData, atLeast(1)).get(eq("alarms"));
    verify(arrayNode, atLeast(1)).get(eq("condition"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode)")
  void testConvertDeviceProfileForVersion3306() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    ArrayNode arrayNode2 = mock(ArrayNode.class);
    when(arrayNode2.get(Mockito.<String>any())).thenReturn(arrayNode);
    ArrayNode arrayNode3 = mock(ArrayNode.class);
    when(arrayNode3.has(Mockito.<String>any())).thenReturn(true);
    when(arrayNode3.get(Mockito.<String>any())).thenReturn(arrayNode2);
    when(arrayNode3.isNull()).thenReturn(true);
    ArrayNode arrayNode4 = mock(ArrayNode.class);
    when(arrayNode4.get(Mockito.<String>any())).thenReturn(arrayNode3);
    when(arrayNode4.has(Mockito.<String>any())).thenReturn(true);

    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    jsonNodeList.add(arrayNode4);
    Iterator<JsonNode> iteratorResult = jsonNodeList.iterator();
    ArrayNode arrayNode5 = mock(ArrayNode.class);
    when(arrayNode5.isNull()).thenReturn(false);
    when(arrayNode5.iterator()).thenReturn(iteratorResult);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode5);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(arrayNode4, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode3, atLeast(1)).has(Mockito.<String>any());
    verify(profileData).has(eq("alarms"));
    verify(arrayNode5).isNull();
    verify(arrayNode3).isNull();
    verify(arrayNode5).iterator();
    verify(arrayNode4, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode3, atLeast(1)).get(Mockito.<String>any());
    verify(profileData, atLeast(1)).get(eq("alarms"));
    verify(arrayNode2, atLeast(1)).get(eq("condition"));
    verify(arrayNode, atLeast(1)).get(eq("spec"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode)")
  void testConvertDeviceProfileForVersion3307() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenThrow(new RuntimeException("alarms"));
    when(arrayNode.has(Mockito.<String>any())).thenReturn(true);
    ArrayNode arrayNode2 = mock(ArrayNode.class);
    when(arrayNode2.get(Mockito.<String>any())).thenReturn(arrayNode);
    ArrayNode arrayNode3 = mock(ArrayNode.class);
    when(arrayNode3.get(Mockito.<String>any())).thenReturn(arrayNode2);
    ArrayNode arrayNode4 = mock(ArrayNode.class);
    when(arrayNode4.has(Mockito.<String>any())).thenReturn(true);
    when(arrayNode4.get(Mockito.<String>any())).thenReturn(arrayNode3);
    when(arrayNode4.isNull()).thenReturn(true);
    ArrayNode arrayNode5 = mock(ArrayNode.class);
    when(arrayNode5.get(Mockito.<String>any())).thenReturn(arrayNode4);
    when(arrayNode5.has(Mockito.<String>any())).thenReturn(true);

    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    jsonNodeList.add(arrayNode5);
    Iterator<JsonNode> iteratorResult = jsonNodeList.iterator();
    ArrayNode arrayNode6 = mock(ArrayNode.class);
    when(arrayNode6.isNull()).thenReturn(false);
    when(arrayNode6.iterator()).thenReturn(iteratorResult);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode6);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultDataUpdateService.convertDeviceProfileForVersion330(profileData));
    verify(arrayNode4).has(eq("CRITICAL"));
    verify(profileData).has(eq("alarms"));
    verify(arrayNode5).has(eq("createRules"));
    verify(arrayNode).has(eq("type"));
    verify(arrayNode6).isNull();
    verify(arrayNode6).iterator();
    verify(arrayNode4).get(eq("CRITICAL"));
    verify(profileData, atLeast(1)).get(eq("alarms"));
    verify(arrayNode3).get(eq("condition"));
    verify(arrayNode5).get(eq("createRules"));
    verify(arrayNode2).get(eq("spec"));
    verify(arrayNode).get(eq("type"));
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode)")
  void testConvertDeviceProfileForVersion3308() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(arrayNode.has(Mockito.<String>any())).thenReturn(true);
    ArrayNode arrayNode2 = mock(ArrayNode.class);
    when(arrayNode2.get(Mockito.<String>any())).thenReturn(arrayNode);
    ArrayNode arrayNode3 = mock(ArrayNode.class);
    when(arrayNode3.get(Mockito.<String>any())).thenReturn(arrayNode2);
    ArrayNode arrayNode4 = mock(ArrayNode.class);
    when(arrayNode4.has(Mockito.<String>any())).thenReturn(true);
    when(arrayNode4.get(Mockito.<String>any())).thenReturn(arrayNode3);
    when(arrayNode4.isNull()).thenReturn(true);
    ArrayNode arrayNode5 = mock(ArrayNode.class);
    when(arrayNode5.get(Mockito.<String>any())).thenReturn(arrayNode4);
    when(arrayNode5.has(Mockito.<String>any())).thenReturn(true);

    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    jsonNodeList.add(arrayNode5);
    Iterator<JsonNode> iteratorResult = jsonNodeList.iterator();
    ArrayNode arrayNode6 = mock(ArrayNode.class);
    when(arrayNode6.isNull()).thenReturn(false);
    when(arrayNode6.iterator()).thenReturn(iteratorResult);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode6);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(arrayNode5, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode4, atLeast(1)).has(Mockito.<String>any());
    verify(profileData).has(eq("alarms"));
    verify(arrayNode, atLeast(1)).has(eq("type"));
    verify(arrayNode6).isNull();
    verify(arrayNode4).isNull();
    verify(arrayNode6).iterator();
    verify(arrayNode5, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode4, atLeast(1)).get(Mockito.<String>any());
    verify(profileData, atLeast(1)).get(eq("alarms"));
    verify(arrayNode3, atLeast(1)).get(eq("condition"));
    verify(arrayNode2, atLeast(1)).get(eq("spec"));
    verify(arrayNode, atLeast(1)).get(eq("type"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}.
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileAlarmRulesForVersion330(JsonNode)")
  void testConvertDeviceProfileAlarmRulesForVersion330() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();

    // Act and Assert
    assertFalse(defaultDataUpdateService
        .convertDeviceProfileAlarmRulesForVersion330(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}.
   * <ul>
   *   <li>Given Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileAlarmRulesForVersion330(JsonNode); given Instance")
  void testConvertDeviceProfileAlarmRulesForVersion330_givenInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode spec = mock(ArrayNode.class);
    when(spec.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    when(spec.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileAlarmRulesForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileAlarmRulesForVersion330(spec);

    // Assert
    verify(spec, atLeast(1)).has(eq("type"));
    verify(spec, atLeast(1)).get(eq("type"));
    assertFalse(actualConvertDeviceProfileAlarmRulesForVersion330Result);
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileAlarmRulesForVersion330(JsonNode); then throw RuntimeException")
  void testConvertDeviceProfileAlarmRulesForVersion330_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode spec = mock(ArrayNode.class);
    when(spec.get(Mockito.<String>any())).thenThrow(new RuntimeException("type"));
    when(spec.has(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(spec));
    verify(spec).has(eq("type"));
    verify(spec).get(eq("type"));
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileAlarmRulesForVersion330(JsonNode); when Instance; then return 'false'")
  void testConvertDeviceProfileAlarmRulesForVersion330_whenInstance_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();

    // Act and Assert
    assertFalse(defaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(MissingNode.getInstance()));
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileAlarmRulesForVersion330(JsonNode); when 'null'; then return 'false'")
  void testConvertDeviceProfileAlarmRulesForVersion330_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DefaultDataUpdateService()).convertDeviceProfileAlarmRulesForVersion330(null));
  }

  /**
   * Test
   * {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}.
   * <p>
   * Method under test:
   * {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileAlarmRulesForVersion330(JsonNode)")
  void testConvertDeviceProfileAlarmRulesForVersion3302() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDataUpdateService defaultDataUpdateService = new DefaultDataUpdateService();
    ArrayNode spec = mock(ArrayNode.class);
    when(spec.get(Mockito.<String>any())).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(spec.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileAlarmRulesForVersion330Result = defaultDataUpdateService
        .convertDeviceProfileAlarmRulesForVersion330(spec);

    // Assert
    verify(spec, atLeast(1)).has(eq("type"));
    verify(spec, atLeast(1)).get(eq("type"));
    assertFalse(actualConvertDeviceProfileAlarmRulesForVersion330Result);
  }

  /**
   * Test {@link DefaultDataUpdateService#getEnv(String, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDataUpdateService#getEnv(String, boolean)}
   */
  @Test
  @DisplayName("Test getEnv(String, boolean); when 'false'; then return 'false'")
  void testGetEnv_whenFalse_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(DefaultDataUpdateService.getEnv("Name", false));
  }

  /**
   * Test {@link DefaultDataUpdateService#getEnv(String, boolean)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDataUpdateService#getEnv(String, boolean)}
   */
  @Test
  @DisplayName("Test getEnv(String, boolean); when 'Name'; then return 'true'")
  void testGetEnv_whenName_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue(DefaultDataUpdateService.getEnv("Name", true));
  }
}
