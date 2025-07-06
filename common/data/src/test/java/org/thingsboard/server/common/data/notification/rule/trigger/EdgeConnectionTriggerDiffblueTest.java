package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeConnectionTrigger.deduplicate()"})
  void testDeduplicate_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new EdgeConnectionTrigger(
                TenantId.SYS_TENANT_ID,
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                null,
                true,
                "Edge Name")
            .deduplicate());
  }

  /**
   * Test {@link EdgeConnectionTrigger#getDeduplicationKey()}.
   *
   * <p>Method under test: {@link EdgeConnectionTrigger#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String EdgeConnectionTrigger.getDeduplicationKey()"})
  void testGetDeduplicationKey() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(
        "EDGE_CONNECTION:EDGE:784f394c-42b6-435a-983c-b7beff2784f9:true",
        new EdgeConnectionTrigger(
                TenantId.SYS_TENANT_ID,
                customerId,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                true,
                "Edge Name")
            .getDeduplicationKey());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long EdgeConnectionTrigger.getDefaultDeduplicationDuration()"})
  void testGetDefaultDeduplicationDuration_thenReturn60000() {
    // Arrange, Act and Assert
    assertEquals(
        60000L,
        new EdgeConnectionTrigger(
                TenantId.SYS_TENANT_ID,
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                null,
                true,
                "Edge Name")
            .getDefaultDeduplicationDuration());
  }
}
