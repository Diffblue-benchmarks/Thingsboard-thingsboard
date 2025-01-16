package org.thingsboard.server.actors.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.MsgType;

class StatsPersistMsgDiffblueTest {
  /**
   * Test {@link StatsPersistMsg#isEmpty()}.
   * <p>
   * Method under test: {@link StatsPersistMsg#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  void testIsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StatsPersistMsg(1L, -1L, new TenantId(UUID.randomUUID()), null)).isEmpty());
    assertFalse((new StatsPersistMsg(1L, -1L, new TenantId(UUID.randomUUID()), mock(AlarmId.class))).isEmpty());
    assertFalse((new StatsPersistMsg(0L, -1L, new TenantId(UUID.randomUUID()), null)).isEmpty());
  }

  /**
   * Test {@link StatsPersistMsg#isEmpty()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatsPersistMsg#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'true'")
  void testIsEmpty_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new StatsPersistMsg(0L, 0L, new TenantId(UUID.randomUUID()), null)).isEmpty());
  }

  /**
   * Test {@link StatsPersistMsg#StatsPersistMsg(long, long, TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link AlarmId}.</li>
   *   <li>Then return EntityId is {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StatsPersistMsg#StatsPersistMsg(long, long, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test new StatsPersistMsg(long, long, TenantId, EntityId); when AlarmId; then return EntityId is AlarmId")
  void testNewStatsPersistMsg_whenAlarmId_thenReturnEntityIdIsAlarmId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);

    // Act
    StatsPersistMsg actualStatsPersistMsg = new StatsPersistMsg(1L, -1L, tenantId, entityId);

    // Assert
    assertEquals(-1L, actualStatsPersistMsg.getErrorsOccurred());
    assertEquals(1L, actualStatsPersistMsg.getMessagesProcessed());
    assertEquals(MsgType.STATS_PERSIST_MSG, actualStatsPersistMsg.getMsgType());
    assertFalse(actualStatsPersistMsg.isEmpty());
    assertSame(tenantId, actualStatsPersistMsg.getTenantId());
    assertSame(entityId, actualStatsPersistMsg.getEntityId());
  }

  /**
   * Test {@link StatsPersistMsg#StatsPersistMsg(long, long, TenantId, EntityId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StatsPersistMsg#StatsPersistMsg(long, long, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test new StatsPersistMsg(long, long, TenantId, EntityId); when 'null'; then return EntityId is 'null'")
  void testNewStatsPersistMsg_whenNull_thenReturnEntityIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

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
