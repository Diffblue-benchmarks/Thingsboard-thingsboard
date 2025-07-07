package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.vc.RepositorySettings;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ToVersionControlServiceMsg;

class VersionControlRequestCtxDiffblueTest {
  /**
   * Test {@link VersionControlRequestCtx#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionControlRequestCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionControlRequestCtx.equals(Object)",
    "int VersionControlRequestCtx.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        new VersionControlRequestCtx("42", requestId, tenantId, new RepositorySettings()), "42");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionControlRequestCtx#VersionControlRequestCtx(String, UUID, TenantId,
   *       RepositorySettings)}
   *   <li>{@link VersionControlRequestCtx#toString()}
   *   <li>{@link VersionControlRequestCtx#getNodeId()}
   *   <li>{@link VersionControlRequestCtx#getRequestId()}
   *   <li>{@link VersionControlRequestCtx#getSettings()}
   *   <li>{@link VersionControlRequestCtx#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void VersionControlRequestCtx.<init>(String, UUID, TenantId, RepositorySettings)",
    "String VersionControlRequestCtx.getNodeId()",
    "UUID VersionControlRequestCtx.getRequestId()",
    "RepositorySettings VersionControlRequestCtx.getSettings()",
    "TenantId VersionControlRequestCtx.getTenantId()",
    "String VersionControlRequestCtx.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RepositorySettings settings = new RepositorySettings();

    // Act
    VersionControlRequestCtx actualVersionControlRequestCtx =
        new VersionControlRequestCtx("42", requestId, tenantId, settings);
    String actualToStringResult = actualVersionControlRequestCtx.toString();
    String actualNodeId = actualVersionControlRequestCtx.getNodeId();
    UUID actualRequestId = actualVersionControlRequestCtx.getRequestId();
    RepositorySettings actualSettings = actualVersionControlRequestCtx.getSettings();
    TenantId actualTenantId = actualVersionControlRequestCtx.getTenantId();

    // Assert
    assertEquals("42", actualNodeId);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualRequestId.toString());
    assertEquals(
        "VersionControlRequestCtx{nodeId='42', requestId=784f394c-42b6-435a-983c-b7beff2784f9, tenantId=784f394c"
            + "-42b6-435a-983c-b7beff2784f9}",
        actualToStringResult);
    assertSame(tenantId, actualTenantId);
    assertSame(settings, actualSettings);
    assertSame(requestId, actualRequestId);
  }

  /**
   * Test {@link VersionControlRequestCtx#VersionControlRequestCtx(ToVersionControlServiceMsg,
   * RepositorySettings)}.
   *
   * <ul>
   *   <li>Then return NodeId is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * VersionControlRequestCtx#VersionControlRequestCtx(ToVersionControlServiceMsg,
   * RepositorySettings)}
   */
  @Test
  @DisplayName(
      "Test new VersionControlRequestCtx(ToVersionControlServiceMsg, RepositorySettings); then return NodeId is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void VersionControlRequestCtx.<init>(ToVersionControlServiceMsg, RepositorySettings)"
  })
  void testNewVersionControlRequestCtx_thenReturnNodeIdIsEmptyString() {
    // Arrange
    ToVersionControlServiceMsg msg = ToVersionControlServiceMsg.getDefaultInstance();
    RepositorySettings settings = new RepositorySettings();

    // Act
    VersionControlRequestCtx actualVersionControlRequestCtx =
        new VersionControlRequestCtx(msg, settings);

    // Assert
    assertEquals("", actualVersionControlRequestCtx.getNodeId());
    assertEquals(
        "00000000-0000-0000-0000-000000000000",
        actualVersionControlRequestCtx.getRequestId().toString());
    TenantId tenantId = actualVersionControlRequestCtx.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(settings, actualVersionControlRequestCtx.getSettings());
  }
}
