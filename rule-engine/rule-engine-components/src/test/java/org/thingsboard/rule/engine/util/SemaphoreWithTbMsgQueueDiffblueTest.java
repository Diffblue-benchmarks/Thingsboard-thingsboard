package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Semaphore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class SemaphoreWithTbMsgQueueDiffblueTest {
  /**
   * Test {@link SemaphoreWithTbMsgQueue#SemaphoreWithTbMsgQueue(EntityId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SemaphoreWithTbMsgQueue#SemaphoreWithTbMsgQueue(EntityId)}
   */
  @Test
  @DisplayName("Test new SemaphoreWithTbMsgQueue(EntityId); when 'null'; then return EntityId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SemaphoreWithTbMsgQueue.<init>(EntityId)"})
  void testNewSemaphoreWithTbMsgQueue_whenNull_thenReturnEntityIdIsNull() {
    // Arrange and Act
    SemaphoreWithTbMsgQueue actualSemaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);

    // Assert
    assertNull(actualSemaphoreWithTbMsgQueue.getEntityId());
    Semaphore semaphore = actualSemaphoreWithTbMsgQueue.getSemaphore();
    assertEquals(0, semaphore.getQueueLength());
    assertFalse(semaphore.hasQueuedThreads());
    assertFalse(semaphore.isFair());
    assertTrue(actualSemaphoreWithTbMsgQueue.getQueue().isEmpty());
  }
}
