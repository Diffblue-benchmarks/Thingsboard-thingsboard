package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityIdDiffblueTest {
  /**
   * Test {@link EntityId#isNullUid()}.
   *
   * <ul>
   *   <li>Given {@link TenantId#SYS_TENANT_ID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityId#isNullUid()}
   */
  @Test
  @DisplayName("Test isNullUid(); given SYS_TENANT_ID; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityId.isNullUid()"})
  void testIsNullUid_givenSys_tenant_id_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(TenantId.SYS_TENANT_ID.isNullUid());
  }

  /**
   * Test {@link EntityId#isNullUid()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityId#isNullUid()}
   */
  @Test
  @DisplayName("Test isNullUid(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityId.isNullUid()"})
  void testIsNullUid_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")).isNullUid());
  }
}
