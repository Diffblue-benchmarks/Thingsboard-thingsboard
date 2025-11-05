package org.thingsboard.server.actors.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.MsgType;

class StatsPersistMsgDiffblueTest {
  /**
   * Test {@link StatsPersistMsg#isEmpty()}.
   *
   * <p>Method under test: {@link StatsPersistMsg#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StatsPersistMsg.isEmpty()"})
  void testIsEmpty() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    StatsPersistMsg statsPersistMsg = new StatsPersistMsg(1L, -1L, tenantId, null);

    // Act and Assert
    assertFalse(statsPersistMsg.isEmpty());
  }

  /**
   * Test {@link StatsPersistMsg#isEmpty()}.
   *
   * <p>Method under test: {@link StatsPersistMsg#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StatsPersistMsg.isEmpty()"})
  void testIsEmpty2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    StatsPersistMsg statsPersistMsg = new StatsPersistMsg(0L, -1L, tenantId, null);

    // Act and Assert
    assertFalse(statsPersistMsg.isEmpty());
  }

  /**
   * Test {@link StatsPersistMsg#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StatsPersistMsg#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StatsPersistMsg.isEmpty()"})
  void testIsEmpty_thenReturnTrue() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    StatsPersistMsg statsPersistMsg = new StatsPersistMsg(0L, 0L, tenantId, null);

    // Act and Assert
    assertTrue(statsPersistMsg.isEmpty());
  }

  /**
   * Test {@link StatsPersistMsg#StatsPersistMsg(long, long, TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StatsPersistMsg#StatsPersistMsg(long, long, TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test new StatsPersistMsg(long, long, TenantId, EntityId); when 'null'; then return EntityId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatsPersistMsg.<init>(long, long, TenantId, EntityId)"})
  void testNewStatsPersistMsg_whenNull_thenReturnEntityIdIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    StatsPersistMsg actualStatsPersistMsg = new StatsPersistMsg(1L, -1L, tenantId, null);

    // Assert
    assertNull(actualStatsPersistMsg.getEntityId());
    assertEquals(-1L, actualStatsPersistMsg.getErrorsOccurred());
    assertEquals(1L, actualStatsPersistMsg.getMessagesProcessed());
    assertEquals(MsgType.STATS_PERSIST_MSG, actualStatsPersistMsg.getMsgType());
    assertFalse(actualStatsPersistMsg.isEmpty());
    assertSame(tenantId, actualStatsPersistMsg.getTenantId());
  }
}
