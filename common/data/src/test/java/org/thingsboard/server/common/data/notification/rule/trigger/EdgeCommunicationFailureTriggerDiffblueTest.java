package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeCommunicationFailureTriggerDiffblueTest {
  /**
   * Test {@link EdgeCommunicationFailureTrigger#deduplicate()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCommunicationFailureTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeCommunicationFailureTrigger.deduplicate()"})
  void testDeduplicate_thenReturnTrue() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeCommunicationFailureTrigger edgeCommunicationFailureTrigger =
        new EdgeCommunicationFailureTrigger(
            TenantId.SYS_TENANT_ID,
            customerId,
            null,
            "Edge Name",
            "Failure Msg",
            "An error occurred");

    // Act and Assert
    assertTrue(edgeCommunicationFailureTrigger.deduplicate());
  }

  /**
   * Test {@link EdgeCommunicationFailureTrigger#getDeduplicationKey()}.
   *
   * <p>Method under test: {@link EdgeCommunicationFailureTrigger#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EdgeCommunicationFailureTrigger.getDeduplicationKey()"})
  void testGetDeduplicationKey() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeId edgeId = new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeCommunicationFailureTrigger edgeCommunicationFailureTrigger =
        new EdgeCommunicationFailureTrigger(
            TenantId.SYS_TENANT_ID,
            customerId,
            edgeId,
            "Edge Name",
            "Failure Msg",
            "An error occurred");

    // Act and Assert
    assertEquals(
        "EDGE_COMMUNICATION_FAILURE:EDGE:784f394c-42b6-435a-983c-b7beff2784f9:An error occurred",
        edgeCommunicationFailureTrigger.getDeduplicationKey());
  }

  /**
   * Test {@link EdgeCommunicationFailureTrigger#getDefaultDeduplicationDuration()}.
   *
   * <ul>
   *   <li>Then return {@code 1800000}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCommunicationFailureTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  @DisplayName("Test getDefaultDeduplicationDuration(); then return '1800000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long EdgeCommunicationFailureTrigger.getDefaultDeduplicationDuration()"})
  void testGetDefaultDeduplicationDuration_thenReturn1800000() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeCommunicationFailureTrigger edgeCommunicationFailureTrigger =
        new EdgeCommunicationFailureTrigger(
            TenantId.SYS_TENANT_ID,
            customerId,
            null,
            "Edge Name",
            "Failure Msg",
            "An error occurred");

    // Act and Assert
    assertEquals(1800000L, edgeCommunicationFailureTrigger.getDefaultDeduplicationDuration());
  }
}
