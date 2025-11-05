package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class TenantProfileIdDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileId#TenantProfileId(UUID)}
   *   <li>{@link TenantProfileId#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantProfileId.<init>(UUID)",
    "EntityType TenantProfileId.getEntityType()"
  })
  void testGettersAndSetters() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    TenantProfileId actualTenantProfileId = new TenantProfileId(id);
    EntityType actualEntityType = actualTenantProfileId.getEntityType();

    // Assert
    UUID id2 = actualTenantProfileId.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals(EntityType.TENANT_PROFILE, actualEntityType);
    assertSame(id, id2);
  }
}
