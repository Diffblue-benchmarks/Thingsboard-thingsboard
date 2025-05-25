package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

@ExtendWith(MockitoExtension.class)
class EntityContentGitRequestDiffblueTest {
  @Mock
  private EntityId entityId;

  @InjectMocks
  private TenantId tenantId;

  /**
   * Test {@link EntityContentGitRequest#EntityContentGitRequest(TenantId, String, EntityId)}.
   * <p>
   * Method under test: {@link EntityContentGitRequest#EntityContentGitRequest(TenantId, String, EntityId)}
   */
  @Test
  @DisplayName("Test new EntityContentGitRequest(TenantId, String, EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityContentGitRequest.<init>(TenantId, String, EntityId)"})
  void testNewEntityContentGitRequest() {
    // Arrange and Act
    EntityContentGitRequest actualEntityContentGitRequest = new EntityContentGitRequest(tenantId, "42", entityId);

    // Assert
    assertEquals("42", actualEntityContentGitRequest.getVersionId());
    assertNull(actualEntityContentGitRequest.getTimeoutTask());
    assertSame(entityId, actualEntityContentGitRequest.getEntityId());
    assertSame(tenantId, actualEntityContentGitRequest.getTenantId());
  }
}
