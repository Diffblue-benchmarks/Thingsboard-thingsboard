package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;

class EntitiesContentGitRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesContentGitRequest#getEntityType()}
   *   <li>{@link EntitiesContentGitRequest#getVersionId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    EntitiesContentGitRequest entitiesContentGitRequest = new EntitiesContentGitRequest(new TenantId(UUID.randomUUID()),
        "42", EntityType.TENANT);

    // Act
    EntityType actualEntityType = entitiesContentGitRequest.getEntityType();

    // Assert
    assertEquals("42", entitiesContentGitRequest.getVersionId());
    assertEquals(EntityType.TENANT, actualEntityType);
  }
}
