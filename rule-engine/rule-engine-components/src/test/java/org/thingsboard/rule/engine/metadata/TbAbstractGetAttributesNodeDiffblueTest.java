package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbAbstractGetAttributesNodeDiffblueTest {
  /**
   * Test {@link TbAbstractGetAttributesNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_ARRAY}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractGetAttributesNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_ARRAY'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbAbstractGetAttributesNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartArray_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.elements()).thenThrow(new RuntimeException("foo"));
    when(data.asToken()).thenReturn(JsonToken.START_ARRAY);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbGetAttributesNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).elements();
  }
}
