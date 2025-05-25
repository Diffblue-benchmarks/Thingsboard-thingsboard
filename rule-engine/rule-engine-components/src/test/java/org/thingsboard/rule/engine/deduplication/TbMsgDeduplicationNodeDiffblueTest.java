package org.thingsboard.rule.engine.deduplication;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbMsgDeduplicationNodeDiffblueTest {
  /**
   * Test {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_ARRAY}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code START_ARRAY}.</li>
   *   <li>Then calls {@link ArrayNode#elements()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_ARRAY'; when ArrayNode asToken() return 'START_ARRAY'; then calls elements()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMsgDeduplicationNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartArray_whenArrayNodeAsTokenReturnStartArray_thenCallsElements() throws TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.elements()).thenThrow(new RuntimeException("foo"));
    when(data.asToken()).thenReturn(JsonToken.START_ARRAY);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgDeduplicationNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).elements();
  }

  /**
   * Test {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_OBJECT}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code START_OBJECT}.</li>
   *   <li>Then calls {@link JsonNode#fields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; when ArrayNode asToken() return 'START_OBJECT'; then calls fields()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMsgDeduplicationNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_whenArrayNodeAsTokenReturnStartObject_thenCallsFields() throws TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenReturn("Queue Name");
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbMsgDeduplicationNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    verify(ctx).getQueueName();
  }

  /**
   * Test {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getQueueName()} throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); when TbContext getQueueName() throw RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMsgDeduplicationNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenTbContextGetQueueNameThrowRuntimeExceptionWithFoo() throws TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenThrow(new RuntimeException("foo"));
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgDeduplicationNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    verify(ctx).getQueueName();
  }

  /**
   * Test {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Then return Second is {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); then return Second is ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.util.TbPair TbMsgDeduplicationNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenReturnSecondIsArrayNodeWithNfIsWithExactBigDecimalsTrue() throws TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();
    ArrayNode oldConfiguration = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act and Assert
    assertSame(oldConfiguration, tbMsgDeduplicationNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return Second is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when Instance; then return Second is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.util.TbPair TbMsgDeduplicationNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenInstance_thenReturnSecondIsInstance() throws TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act and Assert
    assertSame(oldConfiguration, tbMsgDeduplicationNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Second is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.util.TbPair TbMsgDeduplicationNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenReturnSecondIsInstance() throws TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act and Assert
    assertSame(oldConfiguration, tbMsgDeduplicationNode.upgrade(1, oldConfiguration).getSecond());
  }
}
