package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TopicTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TopicType#getAttributesResponseTopicBase()}
   *   <li>{@link TopicType#getAttributesSubTopic()}
   *   <li>{@link TopicType#getRpcRequestTopicBase()}
   *   <li>{@link TopicType#getRpcResponseTopicBase()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "String TopicType.getAttributesResponseTopicBase()",
    "String TopicType.getAttributesSubTopic()",
    "String TopicType.getRpcRequestTopicBase()",
    "String TopicType.getRpcResponseTopicBase()"
  })
  void testGettersAndSetters() {
    // Arrange
    TopicType valueOfResult = TopicType.valueOf("V1");

    // Act
    String actualAttributesResponseTopicBase = valueOfResult.getAttributesResponseTopicBase();
    String actualAttributesSubTopic = valueOfResult.getAttributesSubTopic();
    String actualRpcRequestTopicBase = valueOfResult.getRpcRequestTopicBase();

    // Assert
    assertEquals("v1/devices/me/attributes", actualAttributesSubTopic);
    assertEquals("v1/devices/me/attributes/response/", actualAttributesResponseTopicBase);
    assertEquals("v1/devices/me/rpc/request/", actualRpcRequestTopicBase);
    assertEquals("v1/devices/me/rpc/response/", valueOfResult.getRpcResponseTopicBase());
  }
}
