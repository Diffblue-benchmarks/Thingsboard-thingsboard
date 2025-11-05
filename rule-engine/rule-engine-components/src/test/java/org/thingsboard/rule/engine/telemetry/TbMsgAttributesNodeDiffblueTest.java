package org.thingsboard.rule.engine.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.msg.TbMsg;

class TbMsgAttributesNodeDiffblueTest {
  /**
   * Test {@link TbMsgAttributesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgAttributesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsTellFailure() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgAttributesNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbMsgAttributesNode#saveAttr(List, TbContext, TbMsg, AttributeScope, boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#saveAttr(List, TbContext, TbMsg,
   * AttributeScope, boolean)}
   */
  @Test
  @DisplayName(
      "Test saveAttr(List, TbContext, TbMsg, AttributeScope, boolean); when ArrayList(); then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbMsgAttributesNode.saveAttr(List, TbContext, TbMsg, AttributeScope, boolean)"
  })
  void testSaveAttr_whenArrayList_thenCallsTellSuccess() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgAttributesNode.saveAttr(attributes, ctx, msg, AttributeScope.CLIENT_SCOPE, true);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName(
      "Test filterChangedAttr(List, List); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_givenJsonDataEntryWithKeyAndValueIs42_thenReturnEmpty() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    currentAttributes.add(baseAttributeKvEntry);

    ArrayList<AttributeKvEntry> newAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    newAttributes.add(baseAttributeKvEntry2);

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(currentAttributes, newAttributes).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName(
      "Test filterChangedAttr(List, List); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_givenJsonDataEntryWithKeyAndValueIs42_thenReturnEmpty2() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    currentAttributes.add(baseAttributeKvEntry);

    ArrayList<AttributeKvEntry> newAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    newAttributes.add(baseAttributeKvEntry2);
    BaseAttributeKvEntry baseAttributeKvEntry3 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    newAttributes.add(baseAttributeKvEntry3);

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(currentAttributes, newAttributes).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and {@code
   *       Value}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName(
      "Test filterChangedAttr(List, List); given JsonDataEntry(String, String) with 'Key' and 'Value'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_givenJsonDataEntryWithKeyAndValue_thenReturnSizeIsOne() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    currentAttributes.add(baseAttributeKvEntry);

    ArrayList<AttributeKvEntry> newAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "Value"));
    newAttributes.add(baseAttributeKvEntry2);

    // Act
    List<AttributeKvEntry> actualFilterChangedAttrResult =
        tbMsgAttributesNode.filterChangedAttr(currentAttributes, newAttributes);

    // Assert
    assertEquals(1, actualFilterChangedAttrResult.size());
    assertSame(baseAttributeKvEntry2, actualFilterChangedAttrResult.get(0));
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with key is {@code null} and
   *       value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName(
      "Test filterChangedAttr(List, List); given JsonDataEntry(String, String) with key is 'null' and value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_givenJsonDataEntryWithKeyIsNullAndValueIs42() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    currentAttributes.add(baseAttributeKvEntry);

    ArrayList<AttributeKvEntry> newAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry(null, "42"));
    newAttributes.add(baseAttributeKvEntry2);

    // Act
    List<AttributeKvEntry> actualFilterChangedAttrResult =
        tbMsgAttributesNode.filterChangedAttr(currentAttributes, newAttributes);

    // Assert
    assertEquals(1, actualFilterChangedAttrResult.size());
    assertSame(baseAttributeKvEntry2, actualFilterChangedAttrResult.get(0));
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   *
   * <ul>
   *   <li>Given {@link StringDataEntry#StringDataEntry(String, String)} with {@code Key} and value
   *       is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName(
      "Test filterChangedAttr(List, List); given StringDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_givenStringDataEntryWithKeyAndValueIs42() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new StringDataEntry("Key", "42"));
    currentAttributes.add(baseAttributeKvEntry);

    ArrayList<AttributeKvEntry> newAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    newAttributes.add(baseAttributeKvEntry2);

    // Act
    List<AttributeKvEntry> actualFilterChangedAttrResult =
        tbMsgAttributesNode.filterChangedAttr(currentAttributes, newAttributes);

    // Assert
    assertEquals(1, actualFilterChangedAttrResult.size());
    assertSame(baseAttributeKvEntry2, actualFilterChangedAttrResult.get(0));
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_whenArrayList_thenReturnEmpty() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();

    // Act and Assert
    assertTrue(
        tbMsgAttributesNode.filterChangedAttr(currentAttributes, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_whenArrayList_thenReturnEmpty2() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    currentAttributes.add(baseAttributeKvEntry);

    // Act and Assert
    assertTrue(
        tbMsgAttributesNode.filterChangedAttr(currentAttributes, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_whenArrayList_thenReturnEmpty3() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    currentAttributes.add(baseAttributeKvEntry);
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    currentAttributes.add(baseAttributeKvEntry2);

    // Act and Assert
    assertTrue(
        tbMsgAttributesNode.filterChangedAttr(currentAttributes, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_whenArrayList_thenReturnEmpty4() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    currentAttributes.add(baseAttributeKvEntry);
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    currentAttributes.add(baseAttributeKvEntry2);
    BaseAttributeKvEntry baseAttributeKvEntry3 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    currentAttributes.add(baseAttributeKvEntry3);

    // Act and Assert
    assertTrue(
        tbMsgAttributesNode.filterChangedAttr(currentAttributes, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbMsgAttributesNode.filterChangedAttr(List, List)"})
  void testFilterChangedAttr_whenNull_thenReturnEmpty() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(null, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbMsgAttributesNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_givenNull() throws TbNodeException {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("updateAttributesOnlyOnValueChange", (JsonNode) null);
    oldConfiguration.put("notifyDevice", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("sendAttributesUpdatedNotification", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbMsgAttributesNode.upgrade(0, oldConfiguration).getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode expectedDoubleNode = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof BooleanNode);
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertTrue(nextResult.isBoolean());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isNumber());
    assertTrue(nextResult2 instanceof DoubleNode);
    assertEquals(expectedDoubleNode, nextResult2);
  }

  /**
   * Test {@link TbMsgAttributesNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then return Second iterator next.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); then return Second iterator next")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbMsgAttributesNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_thenReturnSecondIteratorNext() throws TbNodeException {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("updateAttributesOnlyOnValueChange", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("notifyDevice", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("sendAttributesUpdatedNotification", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbMsgAttributesNode.upgrade(0, oldConfiguration).getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    JsonNode nextResult3 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult2 instanceof DoubleNode);
    assertEquals(nextResult, nextResult2);
    assertTrue(nextResult3 instanceof DoubleNode);
    assertEquals(nextResult, nextResult3);
  }

  /**
   * Test {@link TbMsgAttributesNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbMsgAttributesNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenMinusOne() throws TbNodeException {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("updateAttributesOnlyOnValueChange", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("notifyDevice", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("sendAttributesUpdatedNotification", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbMsgAttributesNode.upgrade(-1, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof DoubleNode);
    JsonNode nextResult3 = iteratorResult.next();
    assertTrue(nextResult3 instanceof DoubleNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    assertEquals(nextResult, nextResult2);
    assertEquals(nextResult, nextResult3);
  }

  /**
   * Test {@link TbMsgAttributesNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second iterator next traverse return {@link TreeTraversingParser}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgAttributesNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); when one; then Second iterator next traverse return TreeTraversingParser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbMsgAttributesNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenOne_thenSecondIteratorNextTraverseReturnTreeTraversingParser()
      throws TbNodeException {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("updateAttributesOnlyOnValueChange", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("notifyDevice", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("sendAttributesUpdatedNotification", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbMsgAttributesNode.upgrade(1, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof DoubleNode);
    JsonNode nextResult3 = iteratorResult.next();
    assertTrue(nextResult3 instanceof DoubleNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    assertEquals(nextResult, nextResult2);
    assertEquals(nextResult, nextResult3);
  }
}
