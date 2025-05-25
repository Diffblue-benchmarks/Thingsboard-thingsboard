package org.thingsboard.rule.engine.mail;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbSendEmailNodeDiffblueTest {
  /**
   * Test {@link TbSendEmailNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>Given {@code START_OBJECT}.</li>
   *   <li>Then calls {@link JsonNode#fields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given 'START_OBJECT'; then calls fields()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbSendEmailNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenStartObject_thenCallsFields() throws TbNodeException {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    JsonNode data = mock(JsonNode.class);
    when(data.fields()).thenThrow(new IllegalStateException("foo"));
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> tbSendEmailNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).fields();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendEmailNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>Given {@code VALUE_EMBEDDED_OBJECT}.</li>
   *   <li>Then calls {@link JsonNode#isPojo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given 'VALUE_EMBEDDED_OBJECT'; then calls isPojo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbSendEmailNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenValueEmbeddedObject_thenCallsIsPojo() throws TbNodeException {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    JsonNode data = mock(JsonNode.class);
    when(data.isPojo()).thenThrow(new IllegalStateException("foo"));
    when(data.asToken()).thenReturn(JsonToken.VALUE_EMBEDDED_OBJECT);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> tbSendEmailNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).isPojo();
    verify(ctx).isExternalNodeForceAck();
  }
}
