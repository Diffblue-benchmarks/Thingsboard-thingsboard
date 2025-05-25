package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbChangeOriginatorNodeDiffblueTest {
  /**
   * Test {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbContext, TbNodeConfiguration); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbChangeOriginatorNodeConfiguration TbChangeOriginatorNode.loadNodeConfiguration(TbContext, TbNodeConfiguration)"})
  void testLoadNodeConfiguration_thenThrowIllegalStateException() throws TbNodeException {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> tbChangeOriginatorNode.loadNodeConfiguration(ctx, new TbNodeConfiguration(data)));
    verify(data).asToken();
  }

  /**
   * Test new {@link TbChangeOriginatorNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbChangeOriginatorNode}
   */
  @Test
  @DisplayName("Test new TbChangeOriginatorNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbChangeOriginatorNode.<init>()"})
  void testNewTbChangeOriginatorNode() {
    // Arrange, Act and Assert
    assertNull((new TbChangeOriginatorNode()).config);
  }
}
