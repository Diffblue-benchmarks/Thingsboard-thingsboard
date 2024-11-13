package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbDeleteRelationNodeDiffblueTest {
  /**
   * Test
   * {@link TbDeleteRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_ARRAY}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDeleteRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadEntityNodeActionConfig(TbNodeConfiguration); given 'START_ARRAY'; then throw RuntimeException")
  void testLoadEntityNodeActionConfig_givenStartArray_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbDeleteRelationNode tbDeleteRelationNode = new TbDeleteRelationNode();
    ArrayNode data = mock(ArrayNode.class);
    when(data.elements()).thenThrow(new RuntimeException("foo"));
    when(data.asToken()).thenReturn(JsonToken.START_ARRAY);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> tbDeleteRelationNode.loadEntityNodeActionConfig(new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).elements();
  }

  /**
   * Test
   * {@link TbDeleteRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}.
   * <ul>
   *   <li>Then return EntityNamePattern is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDeleteRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadEntityNodeActionConfig(TbNodeConfiguration); then return EntityNamePattern is 'null'")
  void testLoadEntityNodeActionConfig_thenReturnEntityNamePatternIsNull() throws TbNodeException {
    // Arrange
    TbDeleteRelationNode tbDeleteRelationNode = new TbDeleteRelationNode();
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    TbDeleteRelationNodeConfiguration actualLoadEntityNodeActionConfigResult = tbDeleteRelationNode
        .loadEntityNodeActionConfig(new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    assertNull(actualLoadEntityNodeActionConfigResult.getEntityNamePattern());
    assertNull(actualLoadEntityNodeActionConfigResult.getEntityTypePattern());
    assertNull(actualLoadEntityNodeActionConfigResult.getRelationType());
    assertNull(actualLoadEntityNodeActionConfigResult.getEntityType());
    assertNull(actualLoadEntityNodeActionConfigResult.getDirection());
    assertFalse(actualLoadEntityNodeActionConfigResult.isDeleteForSingleEntity());
  }

  /**
   * Test {@link TbDeleteRelationNode#createEntityIfNotExists()}.
   * <p>
   * Method under test: {@link TbDeleteRelationNode#createEntityIfNotExists()}
   */
  @Test
  @DisplayName("Test createEntityIfNotExists()")
  void testCreateEntityIfNotExists() {
    // Arrange, Act and Assert
    assertFalse((new TbDeleteRelationNode()).createEntityIfNotExists());
  }

  /**
   * Test new {@link TbDeleteRelationNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbDeleteRelationNode}
   */
  @Test
  @DisplayName("Test new TbDeleteRelationNode (default constructor)")
  void testNewTbDeleteRelationNode() {
    // Arrange, Act and Assert
    assertNull((new TbDeleteRelationNode()).config);
  }
}
