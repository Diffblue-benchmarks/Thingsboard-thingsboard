package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.vc.RepositorySettings;
import org.thingsboard.server.gen.transport.TransportProtos;

class VersionControlRequestCtxDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link VersionControlRequestCtx#VersionControlRequestCtx(String, UUID, TenantId, RepositorySettings)}
   *   <li>{@link VersionControlRequestCtx#toString()}
   *   <li>{@link VersionControlRequestCtx#getNodeId()}
   *   <li>{@link VersionControlRequestCtx#getRequestId()}
   *   <li>{@link VersionControlRequestCtx#getSettings()}
   *   <li>{@link VersionControlRequestCtx#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UUID requestId = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = new RepositorySettings();

    // Act
    VersionControlRequestCtx actualVersionControlRequestCtx = new VersionControlRequestCtx("42", requestId, tenantId,
        settings);
    actualVersionControlRequestCtx.toString();
    String actualNodeId = actualVersionControlRequestCtx.getNodeId();
    UUID actualRequestId = actualVersionControlRequestCtx.getRequestId();
    RepositorySettings actualSettings = actualVersionControlRequestCtx.getSettings();

    // Assert
    assertEquals("42", actualNodeId);
    assertSame(tenantId, actualVersionControlRequestCtx.getTenantId());
    assertSame(settings, actualSettings);
    assertSame(requestId, actualRequestId);
  }

  /**
   * Test
   * {@link VersionControlRequestCtx#VersionControlRequestCtx(ToVersionControlServiceMsg, RepositorySettings)}.
   * <ul>
   *   <li>Then return NodeId is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link VersionControlRequestCtx#VersionControlRequestCtx(TransportProtos.ToVersionControlServiceMsg, RepositorySettings)}
   */
  @Test
  @DisplayName("Test new VersionControlRequestCtx(ToVersionControlServiceMsg, RepositorySettings); then return NodeId is empty string")
  void testNewVersionControlRequestCtx_thenReturnNodeIdIsEmptyString() {
    // Arrange
    TransportProtos.ToVersionControlServiceMsg msg = TransportProtos.ToVersionControlServiceMsg.getDefaultInstance();
    RepositorySettings settings = new RepositorySettings();

    // Act
    VersionControlRequestCtx actualVersionControlRequestCtx = new VersionControlRequestCtx(msg, settings);

    // Assert
    assertEquals("", actualVersionControlRequestCtx.getNodeId());
    TenantId tenantId = actualVersionControlRequestCtx.getTenantId();
    assertEquals("00000000-0000-0000-0000-000000000000", tenantId.getId().toString());
    assertEquals("00000000-0000-0000-0000-000000000000", actualVersionControlRequestCtx.getRequestId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(settings, actualVersionControlRequestCtx.getSettings());
  }
}
