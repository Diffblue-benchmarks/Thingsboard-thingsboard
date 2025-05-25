package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class AbstractTbMsgPushNodeDiffblueTest {
  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code END_ARRAY}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code END_ARRAY}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'END_ARRAY'; when ArrayNode asToken() return 'END_ARRAY'; then calls asToken()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenEndArray_whenArrayNodeAsTokenReturnEndArray_thenCallsAsToken() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_ARRAY);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code END_OBJECT}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code END_OBJECT}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'END_OBJECT'; when ArrayNode asToken() return 'END_OBJECT'; then calls asToken()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenEndObject_whenArrayNodeAsTokenReturnEndObject_thenCallsAsToken() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_OBJECT);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_ARRAY}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_ARRAY'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartArray_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.elements()).thenThrow(new RuntimeException("foo"));
    when(data.asToken()).thenReturn(JsonToken.START_ARRAY);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).elements();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_OBJECT}.</li>
   *   <li>Then {@link TbMsgPushToCloudNode} (default constructor) {@link AbstractTbMsgPushNode#config} Scope is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then TbMsgPushToCloudNode (default constructor) config Scope is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_thenTbMsgPushToCloudNodeConfigScopeIsNull() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    assertNull(tbMsgPushToCloudNode.config.getScope());
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code VALUE_NULL}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code VALUE_NULL}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'VALUE_NULL'; when ArrayNode asToken() return 'VALUE_NULL'; then calls asToken()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenValueNull_whenArrayNodeAsTokenReturnValueNull_thenCallsAsToken() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.VALUE_NULL);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getScope(Map)}.
   * <ul>
   *   <li>Given {@code Metadata}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code scope} is {@code Metadata}.</li>
   *   <li>Then return {@code Metadata}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbMsgPushNode#getScope(Map)}
   */
  @Test
  @DisplayName("Test getScope(Map); given 'Metadata'; when HashMap() 'scope' is 'Metadata'; then return 'Metadata'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractTbMsgPushNode.getScope(Map)"})
  void testGetScope_givenMetadata_whenHashMapScopeIsMetadata_thenReturnMetadata() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    HashMap<String, String> metadata = new HashMap<>();
    metadata.put("scope", "Metadata");

    // Act and Assert
    assertEquals("Metadata", tbMsgPushToCloudNode.getScope(metadata));
  }
}
