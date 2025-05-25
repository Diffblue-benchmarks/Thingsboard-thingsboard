package org.thingsboard.rule.engine.metadata;

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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbGetTelemetryNodeDiffblueTest {
  /**
   * Test {@link TbGetTelemetryNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetTelemetryNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbGetTelemetryNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbGetTelemetryNode tbGetTelemetryNode = new TbGetTelemetryNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.elements()).thenThrow(new RuntimeException("foo"));
    when(data.asToken()).thenReturn(JsonToken.START_ARRAY);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbGetTelemetryNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).elements();
  }

  /**
   * Test {@link TbGetTelemetryNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Then return Second is {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetTelemetryNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); then return Second is ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.util.TbPair TbGetTelemetryNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenReturnSecondIsArrayNodeWithNfIsWithExactBigDecimalsTrue() throws TbNodeException {
    // Arrange
    TbGetTelemetryNode tbGetTelemetryNode = new TbGetTelemetryNode();
    ArrayNode oldConfiguration = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act and Assert
    assertSame(oldConfiguration, tbGetTelemetryNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbGetTelemetryNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return Second is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetTelemetryNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when Instance; then return Second is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.util.TbPair TbGetTelemetryNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenInstance_thenReturnSecondIsInstance() throws TbNodeException {
    // Arrange
    TbGetTelemetryNode tbGetTelemetryNode = new TbGetTelemetryNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act and Assert
    assertSame(oldConfiguration, tbGetTelemetryNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbGetTelemetryNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Second is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetTelemetryNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.util.TbPair TbGetTelemetryNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenReturnSecondIsInstance() throws TbNodeException {
    // Arrange
    TbGetTelemetryNode tbGetTelemetryNode = new TbGetTelemetryNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act and Assert
    assertSame(oldConfiguration, tbGetTelemetryNode.upgrade(1, oldConfiguration).getSecond());
  }
}
