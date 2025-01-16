package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbCreateRelationNodeDiffblueTest {
  /**
   * Test
   * {@link TbCreateRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_ARRAY}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCreateRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadEntityNodeActionConfig(TbNodeConfiguration); given 'START_ARRAY'; then throw RuntimeException")
  void testLoadEntityNodeActionConfig_givenStartArray_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbCreateRelationNode tbCreateRelationNode = new TbCreateRelationNode();
    ArrayNode data = mock(ArrayNode.class);
    when(data.elements()).thenThrow(new RuntimeException("foo"));
    when(data.asToken()).thenReturn(JsonToken.START_ARRAY);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> tbCreateRelationNode.loadEntityNodeActionConfig(new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).elements();
  }

  /**
   * Test new {@link TbCreateRelationNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbCreateRelationNode}
   */
  @Test
  @DisplayName("Test new TbCreateRelationNode (default constructor)")
  void testNewTbCreateRelationNode() {
    // Arrange, Act and Assert
    assertNull((new TbCreateRelationNode()).config);
  }
}
