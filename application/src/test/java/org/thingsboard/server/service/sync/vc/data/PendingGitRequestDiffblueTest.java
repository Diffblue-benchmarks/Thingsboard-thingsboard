package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import java.util.concurrent.ScheduledFuture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class PendingGitRequestDiffblueTest {
  /**
   * Test {@link PendingGitRequest#requiresSettings()}.
   * <p>
   * Method under test: {@link PendingGitRequest#requiresSettings()}
   */
  @Test
  @DisplayName("Test requiresSettings()")
  void testRequiresSettings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PendingGitRequest<Object> pendingGitRequest = new PendingGitRequest<>(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertTrue(pendingGitRequest.requiresSettings());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PendingGitRequest#setTimeoutTask(ScheduledFuture)}
   *   <li>{@link PendingGitRequest#getCreatedTime()}
   *   <li>{@link PendingGitRequest#getFuture()}
   *   <li>{@link PendingGitRequest#getRequestId()}
   *   <li>{@link PendingGitRequest#getTenantId()}
   *   <li>{@link PendingGitRequest#getTimeoutTask()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    PendingGitRequest<Object> pendingGitRequest = new PendingGitRequest<>(tenantId);

    // Act
    pendingGitRequest.setTimeoutTask(null);
    pendingGitRequest.getCreatedTime();
    pendingGitRequest.getFuture();
    pendingGitRequest.getRequestId();
    TenantId actualTenantId = pendingGitRequest.getTenantId();
    pendingGitRequest.getTimeoutTask();

    // Assert that nothing has changed
    assertSame(tenantId, actualTenantId);
  }
}
