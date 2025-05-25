package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import java.util.concurrent.ScheduledFuture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;

@ContextConfiguration(classes = {PendingGitRequest.class, TenantId.class})
@DisabledInAotMode
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class PendingGitRequestDiffblueTest {
  @Autowired
  private PendingGitRequest<Object> pendingGitRequest;

  @InjectMocks
  private TenantId tenantId;

  @MockBean
  private UUID uUID;

  /**
   * Test {@link PendingGitRequest#PendingGitRequest(TenantId)}.
   * <ul>
   *   <li>Then return TimeoutTask is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PendingGitRequest#PendingGitRequest(TenantId)}
   */
  @Test
  @DisplayName("Test new PendingGitRequest(TenantId); then return TimeoutTask is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PendingGitRequest.<init>(TenantId)"})
  void testNewPendingGitRequest_thenReturnTimeoutTaskIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    PendingGitRequest<Object> actualPendingGitRequest = new PendingGitRequest<>(tenantId);

    // Assert
    assertNull(actualPendingGitRequest.getTimeoutTask());
    assertSame(tenantId, actualPendingGitRequest.getTenantId());
  }

  /**
   * Test {@link PendingGitRequest#requiresSettings()}.
   * <p>
   * Method under test: {@link PendingGitRequest#requiresSettings()}
   */
  @Test
  @DisplayName("Test requiresSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PendingGitRequest.requiresSettings()"})
  void testRequiresSettings() {
    // Arrange, Act and Assert
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long PendingGitRequest.getCreatedTime()",
      "com.google.common.util.concurrent.SettableFuture PendingGitRequest.getFuture()",
      "UUID PendingGitRequest.getRequestId()", "TenantId PendingGitRequest.getTenantId()",
      "ScheduledFuture PendingGitRequest.getTimeoutTask()", "void PendingGitRequest.setTimeoutTask(ScheduledFuture)"})
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingGitRequest<Object> pendingGitRequest = new PendingGitRequest<>(tenantId);

    // Act
    pendingGitRequest.setTimeoutTask(null);
    pendingGitRequest.getCreatedTime();
    pendingGitRequest.getFuture();
    pendingGitRequest.getRequestId();
    TenantId actualTenantId = pendingGitRequest.getTenantId();

    // Assert
    assertNull(pendingGitRequest.getTimeoutTask());
    assertSame(tenantId, actualTenantId);
  }
}
