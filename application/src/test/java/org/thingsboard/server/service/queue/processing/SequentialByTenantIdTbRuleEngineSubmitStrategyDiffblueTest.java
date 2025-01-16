package org.thingsboard.server.service.queue.processing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.transport.TransportProtos;

@ContextConfiguration(classes = {SequentialByTenantIdTbRuleEngineSubmitStrategy.class, String.class})
@ExtendWith(SpringExtension.class)
class SequentialByTenantIdTbRuleEngineSubmitStrategyDiffblueTest {
  @Autowired
  private SequentialByTenantIdTbRuleEngineSubmitStrategy sequentialByTenantIdTbRuleEngineSubmitStrategy;

  /**
   * Test
   * {@link SequentialByTenantIdTbRuleEngineSubmitStrategy#SequentialByTenantIdTbRuleEngineSubmitStrategy(String)}.
   * <p>
   * Method under test:
   * {@link SequentialByTenantIdTbRuleEngineSubmitStrategy#SequentialByTenantIdTbRuleEngineSubmitStrategy(String)}
   */
  @Test
  @DisplayName("Test new SequentialByTenantIdTbRuleEngineSubmitStrategy(String)")
  void testNewSequentialByTenantIdTbRuleEngineSubmitStrategy() {
    // Arrange and Act
    SequentialByTenantIdTbRuleEngineSubmitStrategy actualSequentialByTenantIdTbRuleEngineSubmitStrategy = new SequentialByTenantIdTbRuleEngineSubmitStrategy(
        "Queue Name");

    // Assert
    assertEquals("Queue Name", actualSequentialByTenantIdTbRuleEngineSubmitStrategy.queueName);
    assertNull(actualSequentialByTenantIdTbRuleEngineSubmitStrategy.orderedMsgList);
  }

  /**
   * Test
   * {@link SequentialByTenantIdTbRuleEngineSubmitStrategy#getEntityId(ToRuleEngineMsg)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SequentialByTenantIdTbRuleEngineSubmitStrategy#getEntityId(TransportProtos.ToRuleEngineMsg)}
   */
  @Test
  @DisplayName("Test getEntityId(ToRuleEngineMsg); when DefaultInstance; then return TenantId")
  void testGetEntityId_whenDefaultInstance_thenReturnTenantId() {
    // Arrange and Act
    EntityId actualEntityId = sequentialByTenantIdTbRuleEngineSubmitStrategy
        .getEntityId(TransportProtos.ToRuleEngineMsg.getDefaultInstance());

    // Assert
    assertTrue(actualEntityId instanceof TenantId);
    assertEquals("00000000-0000-0000-0000-000000000000", actualEntityId.getId().toString());
    assertEquals(EntityType.TENANT, actualEntityId.getEntityType());
    assertFalse(actualEntityId.isNullUid());
    assertFalse(((TenantId) actualEntityId).isSysTenantId());
  }
}
