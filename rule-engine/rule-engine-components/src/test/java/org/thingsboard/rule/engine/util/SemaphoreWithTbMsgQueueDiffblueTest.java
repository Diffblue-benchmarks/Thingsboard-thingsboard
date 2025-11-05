package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;

class SemaphoreWithTbMsgQueueDiffblueTest {
  /**
   * Test {@link SemaphoreWithTbMsgQueue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SemaphoreWithTbMsgQueue.equals(Object)",
    "int SemaphoreWithTbMsgQueue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);

    // Act and Assert
    assertNotEquals(semaphoreWithTbMsgQueue, new SemaphoreWithTbMsgQueue(null));
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SemaphoreWithTbMsgQueue.equals(Object)",
    "int SemaphoreWithTbMsgQueue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(entityId);

    // Act and Assert
    assertNotEquals(semaphoreWithTbMsgQueue, new SemaphoreWithTbMsgQueue(null));
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SemaphoreWithTbMsgQueue.equals(Object)",
    "int SemaphoreWithTbMsgQueue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new SemaphoreWithTbMsgQueue(null), 1);
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SemaphoreWithTbMsgQueue.equals(Object)",
    "int SemaphoreWithTbMsgQueue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(entityId);
    AlarmId entityId2 = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(semaphoreWithTbMsgQueue, new SemaphoreWithTbMsgQueue(entityId2));
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SemaphoreWithTbMsgQueue.equals(Object)",
    "int SemaphoreWithTbMsgQueue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(semaphoreWithTbMsgQueue, new SemaphoreWithTbMsgQueue(entityId));
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#SemaphoreWithTbMsgQueue(EntityId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#SemaphoreWithTbMsgQueue(EntityId)}
   */
  @Test
  @DisplayName(
      "Test new SemaphoreWithTbMsgQueue(EntityId); when 'null'; then return EntityId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
