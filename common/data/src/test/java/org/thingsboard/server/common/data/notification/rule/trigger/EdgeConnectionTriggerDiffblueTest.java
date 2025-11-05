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

class EdgeConnectionTriggerDiffblueTest {
  /**
   * Test {@link EdgeConnectionTrigger#deduplicate()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeConnectionTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeConnectionTrigger.deduplicate()"})
  void testDeduplicate_thenReturnTrue() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeConnectionTrigger edgeConnectionTrigger =
        new EdgeConnectionTrigger(TenantId.SYS_TENANT_ID, customerId, null, true, "Edge Name");

    // Act and Assert
    assertTrue(edgeConnectionTrigger.deduplicate());
  }

  /**
   * Test {@link EdgeConnectionTrigger#getDeduplicationKey()}.
   *
   * <p>Method under test: {@link EdgeConnectionTrigger#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EdgeConnectionTrigger.getDeduplicationKey()"})
  void testGetDeduplicationKey() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeId edgeId = new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeConnectionTrigger edgeConnectionTrigger =
        new EdgeConnectionTrigger(TenantId.SYS_TENANT_ID, customerId, edgeId, true, "Edge Name");

    // Act and Assert
    assertEquals(
        "EDGE_CONNECTION:EDGE:784f394c-42b6-435a-983c-b7beff2784f9:true",
        edgeConnectionTrigger.getDeduplicationKey());
  }

  /**
   * Test {@link EdgeConnectionTrigger#getDefaultDeduplicationDuration()}.
   *
   * <ul>
   *   <li>Then return {@code 60000}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeConnectionTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  @DisplayName("Test getDefaultDeduplicationDuration(); then return '60000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long EdgeConnectionTrigger.getDefaultDeduplicationDuration()"})
  void testGetDefaultDeduplicationDuration_thenReturn60000() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeConnectionTrigger edgeConnectionTrigger =
        new EdgeConnectionTrigger(TenantId.SYS_TENANT_ID, customerId, null, true, "Edge Name");

    // Act and Assert
    assertEquals(60000L, edgeConnectionTrigger.getDefaultDeduplicationDuration());
  }
}
