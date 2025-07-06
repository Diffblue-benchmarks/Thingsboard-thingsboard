package org.thingsboard.rule.engine.filter;

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

class TbCheckAlarmStatusNodeDiffblueTest {
  /**
   * Test {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then calls {@link ArrayNode#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given ArrayList() iterator; then calls fields()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenArrayListIterator_thenCallsFields() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext tbContext = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbCheckAlarmStatusNode.init(tbContext, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code END_ARRAY}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code END_ARRAY}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'END_ARRAY'; when ArrayNode asToken() return 'END_ARRAY'; then calls asToken()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenEndArray_whenArrayNodeAsTokenReturnEndArray_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext tbContext = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_ARRAY);

    // Act
    tbCheckAlarmStatusNode.init(tbContext, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code END_OBJECT}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code END_OBJECT}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'END_OBJECT'; when ArrayNode asToken() return 'END_OBJECT'; then calls asToken()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenEndObject_whenArrayNodeAsTokenReturnEndObject_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext tbContext = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_OBJECT);

    // Act
    tbCheckAlarmStatusNode.init(tbContext, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code VALUE_NULL}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code VALUE_NULL}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'VALUE_NULL'; when ArrayNode asToken() return 'VALUE_NULL'; then calls asToken()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenValueNull_whenArrayNodeAsTokenReturnValueNull_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext tbContext = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.VALUE_NULL);

    // Act
    tbCheckAlarmStatusNode.init(tbContext, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }
}
