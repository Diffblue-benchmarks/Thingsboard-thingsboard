package org.thingsboard.server.queue.sqs;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbAwsSqsQueueAttributesDiffblueTest {
  /**
   * Test {@link TbAwsSqsQueueAttributes#toConfigs(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsSqsQueueAttributes#toConfigs(String)}
   */
  @Test
  @DisplayName("Test toConfigs(String); when empty string; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TbAwsSqsQueueAttributes.toConfigs(String)"})
  void testToConfigs_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualToConfigsResult = TbAwsSqsQueueAttributes.toConfigs("");

    // Assert
    assertTrue(actualToConfigsResult.isEmpty());
  }

  /**
   * Test {@link TbAwsSqsQueueAttributes#toConfigs(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsSqsQueueAttributes#toConfigs(String)}
   */
  @Test
  @DisplayName("Test toConfigs(String); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TbAwsSqsQueueAttributes.toConfigs(String)"})
  void testToConfigs_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualToConfigsResult = TbAwsSqsQueueAttributes.toConfigs(null);

    // Assert
    assertTrue(actualToConfigsResult.isEmpty());
  }

  /**
   * Test {@link TbAwsSqsQueueAttributes#toConfigs(String)}.
   *
   * <ul>
   *   <li>When {@code ;}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsSqsQueueAttributes#toConfigs(String)}
   */
  @Test
  @DisplayName("Test toConfigs(String); when ';'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TbAwsSqsQueueAttributes.toConfigs(String)"})
  void testToConfigs_whenSemicolon_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualToConfigsResult = TbAwsSqsQueueAttributes.toConfigs(";");

    // Assert
    assertTrue(actualToConfigsResult.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbAwsSqsQueueAttributes#getCoreAttributes()}
   *   <li>{@link TbAwsSqsQueueAttributes#getEdgeAttributes()}
   *   <li>{@link TbAwsSqsQueueAttributes#getJsExecutorAttributes()}
   *   <li>{@link TbAwsSqsQueueAttributes#getNotificationsAttributes()}
   *   <li>{@link TbAwsSqsQueueAttributes#getOtaAttributes()}
   *   <li>{@link TbAwsSqsQueueAttributes#getRuleEngineAttributes()}
   *   <li>{@link TbAwsSqsQueueAttributes#getTransportApiAttributes()}
   *   <li>{@link TbAwsSqsQueueAttributes#getVcAttributes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Map TbAwsSqsQueueAttributes.getCoreAttributes()",
    "Map TbAwsSqsQueueAttributes.getEdgeAttributes()",
    "Map TbAwsSqsQueueAttributes.getJsExecutorAttributes()",
    "Map TbAwsSqsQueueAttributes.getNotificationsAttributes()",
    "Map TbAwsSqsQueueAttributes.getOtaAttributes()",
    "Map TbAwsSqsQueueAttributes.getRuleEngineAttributes()",
    "Map TbAwsSqsQueueAttributes.getTransportApiAttributes()",
    "Map TbAwsSqsQueueAttributes.getVcAttributes()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbAwsSqsQueueAttributes tbAwsSqsQueueAttributes = new TbAwsSqsQueueAttributes();

    // Act
    Map<String, String> actualCoreAttributes = tbAwsSqsQueueAttributes.getCoreAttributes();
    Map<String, String> actualEdgeAttributes = tbAwsSqsQueueAttributes.getEdgeAttributes();
    Map<String, String> actualJsExecutorAttributes =
        tbAwsSqsQueueAttributes.getJsExecutorAttributes();
    Map<String, String> actualNotificationsAttributes =
        tbAwsSqsQueueAttributes.getNotificationsAttributes();
    Map<String, String> actualOtaAttributes = tbAwsSqsQueueAttributes.getOtaAttributes();
    Map<String, String> actualRuleEngineAttributes =
        tbAwsSqsQueueAttributes.getRuleEngineAttributes();
    Map<String, String> actualTransportApiAttributes =
        tbAwsSqsQueueAttributes.getTransportApiAttributes();

    // Assert
    assertNull(actualCoreAttributes);
    assertNull(actualEdgeAttributes);
    assertNull(actualJsExecutorAttributes);
    assertNull(actualNotificationsAttributes);
    assertNull(actualOtaAttributes);
    assertNull(actualRuleEngineAttributes);
    assertNull(actualTransportApiAttributes);
    assertNull(tbAwsSqsQueueAttributes.getVcAttributes());
  }
}
