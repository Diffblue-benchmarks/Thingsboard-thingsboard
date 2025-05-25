package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;

@ContextConfiguration(classes = {EntitiesContentGitRequest.class, TenantId.class, String.class, EntityType.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class EntitiesContentGitRequestDiffblueTest {
  @Autowired
  private EntitiesContentGitRequest entitiesContentGitRequest;

  @MockBean
  private EntityType entityType;

  @MockBean
  private UUID uUID;

  /**
   * Test {@link EntitiesContentGitRequest#EntitiesContentGitRequest(TenantId, String, EntityType)}.
   * <ul>
   *   <li>Then return VersionId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesContentGitRequest#EntitiesContentGitRequest(TenantId, String, EntityType)}
   */
  @Test
  @DisplayName("Test new EntitiesContentGitRequest(TenantId, String, EntityType); then return VersionId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesContentGitRequest.<init>(TenantId, String, EntityType)"})
  void testNewEntitiesContentGitRequest_thenReturnVersionIdIs42() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    EntitiesContentGitRequest actualEntitiesContentGitRequest = new EntitiesContentGitRequest(tenantId, "42",
        EntityType.TENANT);

    // Assert
    assertEquals("42", actualEntitiesContentGitRequest.getVersionId());
    assertNull(actualEntitiesContentGitRequest.getTimeoutTask());
    assertEquals(EntityType.TENANT, actualEntitiesContentGitRequest.getEntityType());
    assertSame(tenantId, actualEntitiesContentGitRequest.getTenantId());
  }

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType EntitiesContentGitRequest.getEntityType()",
      "String EntitiesContentGitRequest.getVersionId()"})
  void testGettersAndSetters() {
    // Arrange
    EntitiesContentGitRequest entitiesContentGitRequest = new EntitiesContentGitRequest(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "42", EntityType.TENANT);

    // Act
    EntityType actualEntityType = entitiesContentGitRequest.getEntityType();

    // Assert
    assertEquals("42", entitiesContentGitRequest.getVersionId());
    assertEquals(EntityType.TENANT, actualEntityType);
  }
}
