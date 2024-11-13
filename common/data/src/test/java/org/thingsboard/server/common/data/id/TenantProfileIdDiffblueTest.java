package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class TenantProfileIdDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileId#TenantProfileId(UUID)}
   *   <li>{@link TenantProfileId#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act
    TenantProfileId actualTenantProfileId = new TenantProfileId(id);
    EntityType actualEntityType = actualTenantProfileId.getEntityType();

    // Assert
    UUID id2 = actualTenantProfileId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertEquals(EntityType.TENANT_PROFILE, actualEntityType);
    assertSame(id, id2);
  }
}
