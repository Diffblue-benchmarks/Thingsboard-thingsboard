package org.thingsboard.server.service.install.update;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.service.component.ComponentDiscoveryService;

@ExtendWith(MockitoExtension.class)
class DefaultDataUpdateServiceDiffblueTest {
  @Mock private ComponentDiscoveryService componentDiscoveryService;

  @InjectMocks private DefaultDataUpdateService defaultDataUpdateService;

  /**
   * Test {@link DefaultDataUpdateService#updateData(String)}.
   *
   * <ul>
   *   <li>When {@code jane.doe@example.org}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDataUpdateService#updateData(String)}
   */
  @Test
  @DisplayName("Test updateData(String); when 'jane.doe@example.org'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultDataUpdateService.updateData(String)"})
  void testUpdateData_whenJaneDoeExampleOrg_thenThrowRuntimeException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> defaultDataUpdateService.updateData("jane.doe@example.org"));
  }

  /**
   * Test {@link DefaultDataUpdateService#upgradeRuleNodes()}.
   *
   * <ul>
   *   <li>Then calls {@link ComponentDiscoveryService#getVersionedNodes()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDataUpdateService#upgradeRuleNodes()}
   */
  @Test
  @DisplayName("Test upgradeRuleNodes(); then calls getVersionedNodes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultDataUpdateService.upgradeRuleNodes()"})
  void testUpgradeRuleNodes_thenCallsGetVersionedNodes() {
    // Arrange
    when(componentDiscoveryService.getVersionedNodes()).thenReturn(new ArrayList<>());

    // Act
    defaultDataUpdateService.upgradeRuleNodes();

    // Assert
    verify(componentDiscoveryService).getVersionedNodes();
  }

  /**
   * Test {@link DefaultDataUpdateService#upgradeRuleNodes()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDataUpdateService#upgradeRuleNodes()}
   */
  @Test
  @DisplayName("Test upgradeRuleNodes(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultDataUpdateService.upgradeRuleNodes()"})
  void testUpgradeRuleNodes_thenThrowRuntimeException() {
    // Arrange
    when(componentDiscoveryService.getVersionedNodes())
        .thenThrow(new RuntimeException("Starting rule nodes upgrade ..."));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultDataUpdateService.upgradeRuleNodes());
    verify(componentDiscoveryService).getVersionedNodes();
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion330() {
    // Arrange, Act and Assert
    assertFalse(
        defaultDataUpdateService.convertDeviceProfileForVersion330(
            new ArrayNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertDeviceProfileForVersion330(JsonNode); given ArrayList() add valueOf ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion330_givenArrayListAddValueOfTen() {
    // Arrange
    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    jsonNodeList.add(DoubleNode.valueOf(10.0d));
    Iterator<JsonNode> iteratorResult = jsonNodeList.iterator();
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.isNull()).thenReturn(false);
    when(arrayNode.iterator()).thenReturn(iteratorResult);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(profileData).has(eq("alarms"));
    verify(arrayNode).isNull();
    verify(arrayNode).iterator();
    verify(profileData, atLeast(1)).get(eq("alarms"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertDeviceProfileForVersion330(JsonNode); given ArrayNode get(String) return valueOf ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion330_givenArrayNodeGetReturnValueOfTen() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(DoubleNode.valueOf(10.0d));
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
    boolean actualConvertDeviceProfileForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileForVersion330(profileData);

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
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertDeviceProfileForVersion330(JsonNode); given ArrayNode get(String) return valueOf ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion330_givenArrayNodeGetReturnValueOfTen2() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(DoubleNode.valueOf(10.0d));
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
    boolean actualConvertDeviceProfileForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileForVersion330(profileData);

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
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertDeviceProfileForVersion330(JsonNode); given ArrayNode get(String) return valueOf ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion330_givenArrayNodeGetReturnValueOfTen3() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(DoubleNode.valueOf(10.0d));
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
    boolean actualConvertDeviceProfileForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileForVersion330(profileData);

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
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#has(String)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertDeviceProfileForVersion330(JsonNode); given ArrayNode has(String) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion330_givenArrayNodeHasReturnFalse() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.has(Mockito.<String>any())).thenReturn(false);
    when(arrayNode.isNull()).thenReturn(true);
    ArrayNode arrayNode2 = mock(ArrayNode.class);
    when(arrayNode2.get(Mockito.<String>any())).thenReturn(arrayNode);
    when(arrayNode2.has(Mockito.<String>any())).thenReturn(true);

    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    jsonNodeList.add(arrayNode2);
    Iterator<JsonNode> iteratorResult = jsonNodeList.iterator();
    ArrayNode arrayNode3 = mock(ArrayNode.class);
    when(arrayNode3.isNull()).thenReturn(false);
    when(arrayNode3.iterator()).thenReturn(iteratorResult);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode3);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(arrayNode2, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).has(Mockito.<String>any());
    verify(profileData).has(eq("alarms"));
    verify(arrayNode3).isNull();
    verify(arrayNode).isNull();
    verify(arrayNode3).iterator();
    verify(arrayNode2, atLeast(1)).get(Mockito.<String>any());
    verify(profileData, atLeast(1)).get(eq("alarms"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#isNull()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertDeviceProfileForVersion330(JsonNode); given ArrayNode isNull() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion330_givenArrayNodeIsNullReturnTrue() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.isNull()).thenReturn(true);
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(profileData).has(eq("alarms"));
    verify(arrayNode).isNull();
    verify(profileData).get(eq("alarms"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code alarms}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertDeviceProfileForVersion330(JsonNode); given RuntimeException(String) with 'alarms'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion330_givenRuntimeExceptionWithAlarms() {
    // Arrange
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenThrow(new RuntimeException("alarms"));
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> defaultDataUpdateService.convertDeviceProfileForVersion330(profileData));
    verify(profileData).has(eq("alarms"));
    verify(profileData).get(eq("alarms"));
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode); given valueOf ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion330_givenValueOfTen() {
    // Arrange
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(DoubleNode.valueOf(10.0d));
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(profileData).has(eq("alarms"));
    verify(profileData, atLeast(1)).get(eq("alarms"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Then calls {@link ArrayNode#asText()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode); then calls asText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion330_thenCallsAsText() {
    // Arrange
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
    boolean actualConvertDeviceProfileForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileForVersion330(profileData);

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
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Then calls {@link ArrayNode#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode); then calls iterator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion330_thenCallsIterator() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.isNull()).thenReturn(false);

    ArrayList<JsonNode> jsonNodeList = new ArrayList<>();
    when(arrayNode.iterator()).thenReturn(jsonNodeList.iterator());
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any())).thenReturn(arrayNode);
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(profileData).has(eq("alarms"));
    verify(arrayNode).isNull();
    verify(arrayNode).iterator();
    verify(profileData, atLeast(1)).get(eq("alarms"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertDeviceProfileForVersion330(JsonNode); when valueOf ten; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion330_whenValueOfTen_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        defaultDataUpdateService.convertDeviceProfileForVersion330(DoubleNode.valueOf(10.0d)));
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion3302() {
    // Arrange
    ArrayNode profileData = mock(ArrayNode.class);
    when(profileData.get(Mockito.<String>any()))
        .thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(profileData.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(profileData).has(eq("alarms"));
    verify(profileData, atLeast(1)).get(eq("alarms"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion3303() {
    // Arrange
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
    boolean actualConvertDeviceProfileForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileForVersion330(profileData);

    // Assert
    verify(profileData).has(eq("alarms"));
    verify(arrayNode).isNull();
    verify(arrayNode).iterator();
    verify(profileData, atLeast(1)).get(eq("alarms"));
    assertFalse(actualConvertDeviceProfileForVersion330Result);
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion3304() {
    // Arrange
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
    assertThrows(
        RuntimeException.class,
        () -> defaultDataUpdateService.convertDeviceProfileForVersion330(profileData));
    verify(profileData).has(eq("alarms"));
    verify(arrayNode).has(eq("createRules"));
    verify(arrayNode2).isNull();
    verify(arrayNode2).iterator();
    verify(profileData, atLeast(1)).get(eq("alarms"));
    verify(arrayNode).get(eq("createRules"));
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion3305() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any()))
        .thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
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
    boolean actualConvertDeviceProfileForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileForVersion330(profileData);

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
   * Test {@link DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}.
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileForVersion330(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileForVersion3306() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any()))
        .thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
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
    boolean actualConvertDeviceProfileForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileForVersion330(profileData);

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
   * Test {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}.
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileAlarmRulesForVersion330(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileAlarmRulesForVersion330() {
    // Arrange, Act and Assert
    assertFalse(
        defaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(
            new ArrayNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileAlarmRulesForVersion330(JsonNode); given Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileAlarmRulesForVersion330_givenInstance() {
    // Arrange
    ArrayNode spec = mock(ArrayNode.class);
    when(spec.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    when(spec.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileAlarmRulesForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(spec);

    // Assert
    verify(spec, atLeast(1)).has(eq("type"));
    verify(spec, atLeast(1)).get(eq("type"));
    assertFalse(actualConvertDeviceProfileAlarmRulesForVersion330Result);
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code type}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertDeviceProfileAlarmRulesForVersion330(JsonNode); given RuntimeException(String) with 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileAlarmRulesForVersion330_givenRuntimeExceptionWithType() {
    // Arrange
    ArrayNode spec = mock(ArrayNode.class);
    when(spec.get(Mockito.<String>any())).thenThrow(new RuntimeException("type"));
    when(spec.has(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> defaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(spec));
    verify(spec).has(eq("type"));
    verify(spec).get(eq("type"));
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileAlarmRulesForVersion330(JsonNode); given valueOf ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileAlarmRulesForVersion330_givenValueOfTen() {
    // Arrange
    ArrayNode spec = mock(ArrayNode.class);
    when(spec.get(Mockito.<String>any())).thenReturn(DoubleNode.valueOf(10.0d));
    when(spec.has(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualConvertDeviceProfileAlarmRulesForVersion330Result =
        defaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(spec);

    // Assert
    verify(spec, atLeast(1)).has(eq("type"));
    verify(spec, atLeast(1)).get(eq("type"));
    assertFalse(actualConvertDeviceProfileAlarmRulesForVersion330Result);
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Then calls {@link JsonNode#asInt()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileAlarmRulesForVersion330(JsonNode); then calls asInt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileAlarmRulesForVersion330_thenCallsAsInt() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.asInt()).thenThrow(new RuntimeException("type"));
    when(jsonNode.asText()).thenReturn("REPEATING");
    ArrayNode spec = mock(ArrayNode.class);
    when(spec.get(Mockito.<String>any())).thenReturn(jsonNode);
    when(spec.has(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> defaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(spec));
    verify(jsonNode).asInt();
    verify(jsonNode, atLeast(1)).asText();
    verify(spec, atLeast(1)).has(Mockito.<String>any());
    verify(spec, atLeast(1)).get(Mockito.<String>any());
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>Then calls {@link JsonNode#asLong()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileAlarmRulesForVersion330(JsonNode); then calls asLong()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileAlarmRulesForVersion330_thenCallsAsLong() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.asLong()).thenThrow(new RuntimeException("type"));
    when(jsonNode.asText()).thenReturn("DURATION");
    ArrayNode spec = mock(ArrayNode.class);
    when(spec.get(Mockito.<String>any())).thenReturn(jsonNode);
    when(spec.has(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> defaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(spec));
    verify(jsonNode).asLong();
    verify(jsonNode).asText();
    verify(spec, atLeast(1)).has(Mockito.<String>any());
    verify(spec, atLeast(1)).get(Mockito.<String>any());
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertDeviceProfileAlarmRulesForVersion330(JsonNode); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileAlarmRulesForVersion330_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(defaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(null));
  }

  /**
   * Test {@link DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDataUpdateService#convertDeviceProfileAlarmRulesForVersion330(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertDeviceProfileAlarmRulesForVersion330(JsonNode); when valueOf ten; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(JsonNode)"
  })
  void testConvertDeviceProfileAlarmRulesForVersion330_whenValueOfTen_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        defaultDataUpdateService.convertDeviceProfileAlarmRulesForVersion330(
            DoubleNode.valueOf(10.0d)));
  }

  /**
   * Test {@link DefaultDataUpdateService#getEnv(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDataUpdateService#getEnv(String, boolean)}
   */
  @Test
  @DisplayName("Test getEnv(String, boolean); when 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDataUpdateService.getEnv(String, boolean)"})
  void testGetEnv_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DefaultDataUpdateService.getEnv("Name", false));
  }

  /**
   * Test {@link DefaultDataUpdateService#getEnv(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDataUpdateService#getEnv(String, boolean)}
   */
  @Test
  @DisplayName("Test getEnv(String, boolean); when 'Name'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDataUpdateService.getEnv(String, boolean)"})
  void testGetEnv_whenName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DefaultDataUpdateService.getEnv("Name", true));
  }
}
