package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EventDiffblueTest {
  /**
   * Test {@link Event#putNotNull(ObjectNode, String, String)}.
   * <p>
   * Method under test: {@link Event#putNotNull(ObjectNode, String, String)}
   */
  @Test
  @DisplayName("Test putNotNull(ObjectNode, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Event.putNotNull(ObjectNode, String, String)"})
  void testPutNotNull() {
    // Arrange
    ObjectNode json = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    Event.putNotNull(json, "Key", "42");

    // Assert
    Iterator<JsonNode> iteratorResult = json.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals("{\r\n  \"Key\" : \"42\"\r\n}", json.toPrettyString());
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link Event#putNotNull(ObjectNode, String, String)}.
   * <p>
   * Method under test: {@link Event#putNotNull(ObjectNode, String, String)}
   */
  @Test
  @DisplayName("Test putNotNull(ObjectNode, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Event.putNotNull(ObjectNode, String, String)"})
  void testPutNotNull2() {
    // Arrange
    ObjectNode json = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    Event.putNotNull(json, "Key", null);

    // Assert that nothing has changed
    assertEquals("{ }", json.toPrettyString());
    assertEquals(0, json.size());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isEmpty());
  }
}
