package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EntityContentGitRequestDiffblueTest {
  /**
   * Test
   * {@link EntityContentGitRequest#EntityContentGitRequest(TenantId, String, EntityId)}.
   * <ul>
   *   <li>When {@link AlarmId}.</li>
   *   <li>Then return EntityId is {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityContentGitRequest#EntityContentGitRequest(TenantId, String, EntityId)}
   */
  @Test
  @DisplayName("Test new EntityContentGitRequest(TenantId, String, EntityId); when AlarmId; then return EntityId is AlarmId")
  void testNewEntityContentGitRequest_whenAlarmId_thenReturnEntityIdIsAlarmId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);

    // Act
    EntityContentGitRequest actualEntityContentGitRequest = new EntityContentGitRequest(tenantId, "42", entityId);

    // Assert
    assertEquals("42", actualEntityContentGitRequest.getVersionId());
    assertNull(actualEntityContentGitRequest.getTimeoutTask());
    assertSame(tenantId, actualEntityContentGitRequest.getTenantId());
    assertSame(entityId, actualEntityContentGitRequest.getEntityId());
  }

  /**
   * Test
   * {@link EntityContentGitRequest#EntityContentGitRequest(TenantId, String, EntityId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityContentGitRequest#EntityContentGitRequest(TenantId, String, EntityId)}
   */
  @Test
  @DisplayName("Test new EntityContentGitRequest(TenantId, String, EntityId); when 'null'; then return EntityId is 'null'")
  void testNewEntityContentGitRequest_whenNull_thenReturnEntityIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    EntityContentGitRequest actualEntityContentGitRequest = new EntityContentGitRequest(tenantId, "42", null);

    // Assert
    assertEquals("42", actualEntityContentGitRequest.getVersionId());
    assertNull(actualEntityContentGitRequest.getTimeoutTask());
    assertNull(actualEntityContentGitRequest.getEntityId());
    assertSame(tenantId, actualEntityContentGitRequest.getTenantId());
  }
}
