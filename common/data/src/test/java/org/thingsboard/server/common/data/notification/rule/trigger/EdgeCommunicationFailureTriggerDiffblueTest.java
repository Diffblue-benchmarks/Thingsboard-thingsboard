package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeCommunicationFailureTriggerDiffblueTest {
  /**
   * Test {@link EdgeCommunicationFailureTrigger#deduplicate()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCommunicationFailureTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate(); then return 'true'")
  void testDeduplicate_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new EdgeCommunicationFailureTrigger(TenantId.SYS_TENANT_ID,
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, "Edge Name", "Failure Msg",
        "An error occurred")).deduplicate());
  }

  /**
   * Test {@link EdgeCommunicationFailureTrigger#getDeduplicationKey()}.
   * <p>
   * Method under test:
   * {@link EdgeCommunicationFailureTrigger#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  void testGetDeduplicationKey() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals("EDGE_COMMUNICATION_FAILURE:EDGE:784f394c-42b6-435a-983c-b7beff2784f9:An error occurred",
        (new EdgeCommunicationFailureTrigger(TenantId.SYS_TENANT_ID, customerId,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Edge Name", "Failure Msg",
            "An error occurred")).getDeduplicationKey());
  }

  /**
   * Test
   * {@link EdgeCommunicationFailureTrigger#getDefaultDeduplicationDuration()}.
   * <ul>
   *   <li>Then return {@code 1800000}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeCommunicationFailureTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  @DisplayName("Test getDefaultDeduplicationDuration(); then return '1800000'")
  void testGetDefaultDeduplicationDuration_thenReturn1800000() {
    // Arrange, Act and Assert
    assertEquals(1800000L,
        (new EdgeCommunicationFailureTrigger(TenantId.SYS_TENANT_ID,
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, "Edge Name", "Failure Msg",
            "An error occurred")).getDefaultDeduplicationDuration());
  }
}
