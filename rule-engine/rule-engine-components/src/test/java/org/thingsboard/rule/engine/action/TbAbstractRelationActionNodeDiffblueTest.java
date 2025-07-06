package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.util.TbPair;

class TbAbstractRelationActionNodeDiffblueTest {
  /**
   * Test {@link TbAbstractRelationActionNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then throw TbNodeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbAbstractRelationActionNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbCreateRelationNode tbCreateRelationNode = new TbCreateRelationNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        TbNodeException.class, () -> tbCreateRelationNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbAbstractRelationActionNode#checkIfConfigEntityTypeIsSupported(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ALARM}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractRelationActionNode#checkIfConfigEntityTypeIsSupported(EntityType)}
   */
  @Test
  @DisplayName(
      "Test checkIfConfigEntityTypeIsSupported(EntityType); when 'ALARM'; then throw TbNodeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbAbstractRelationActionNode.checkIfConfigEntityTypeIsSupported(EntityType)"
  })
  void testCheckIfConfigEntityTypeIsSupported_whenAlarm_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> new TbCreateRelationNode().checkIfConfigEntityTypeIsSupported(EntityType.ALARM));
  }

  /**
   * Test {@link TbAbstractRelationActionNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Second is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbAbstractRelationActionNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenReturnSecondIsNull() throws TbNodeException {
    // Arrange and Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = new TbCreateRelationNode().upgrade(1, null);

    // Assert
    assertNull(actualUpgradeResult.getSecond());
    assertFalse(actualUpgradeResult.getFirst());
  }
}
