package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class TenantIdDiffblueTest {
  /**
   * Test {@link TenantId#fromUUID(UUID)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link TenantId#fromUUID(UUID)}
   */
  @Test
  @DisplayName(
      "Test fromUUID(UUID); then return Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId TenantId.fromUUID(UUID)"})
  void testFromUUID_thenReturnIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange and Act
    TenantId actualFromUUIDResult =
        TenantId.fromUUID(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualFromUUIDResult.getId().toString());
    assertEquals(EntityType.TENANT, actualFromUUIDResult.getEntityType());
    assertFalse(actualFromUUIDResult.isNullUid());
    assertFalse(actualFromUUIDResult.isSysTenantId());
  }

  /**
   * Test {@link TenantId#fromUUID(UUID)}.
   *
   * <ul>
   *   <li>When {@link EntityId#NULL_UUID}.
   *   <li>Then return NullUid.
   * </ul>
   *
   * <p>Method under test: {@link TenantId#fromUUID(UUID)}
   */
  @Test
  @DisplayName("Test fromUUID(UUID); when NULL_UUID; then return NullUid")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId TenantId.fromUUID(UUID)"})
  void testFromUUID_whenNull_uuid_thenReturnNullUid() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act
    TenantId actualFromUUIDResult = TenantId.fromUUID(id);

    // Assert
    assertEquals(EntityType.TENANT, actualFromUUIDResult.getEntityType());
    assertTrue(actualFromUUIDResult.isNullUid());
    assertTrue(actualFromUUIDResult.isSysTenantId());
    assertSame(id, actualFromUUIDResult.getId());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantId#TenantId(UUID)}
   *   <li>{@link TenantId#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantId.<init>(UUID)", "EntityType TenantId.getEntityType()"})
  void testGettersAndSetters() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    TenantId actualTenantId = new TenantId(id);
    EntityType actualEntityType = actualTenantId.getEntityType();

    // Assert
    UUID id2 = actualTenantId.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(id, id2);
  }

  /**
   * Test {@link TenantId#isSysTenantId()}.
   *
   * <ul>
   *   <li>Given {@link TenantId#SYS_TENANT_ID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TenantId#isSysTenantId()}
   */
  @Test
  @DisplayName("Test isSysTenantId(); given SYS_TENANT_ID; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantId.isSysTenantId()"})
  void testIsSysTenantId_givenSys_tenant_id_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(TenantId.SYS_TENANT_ID.isSysTenantId());
  }

  /**
   * Test {@link TenantId#isSysTenantId()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TenantId#isSysTenantId()}
   */
  @Test
  @DisplayName("Test isSysTenantId(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantId.isSysTenantId()"})
  void testIsSysTenantId_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")).isSysTenantId());
  }
}
