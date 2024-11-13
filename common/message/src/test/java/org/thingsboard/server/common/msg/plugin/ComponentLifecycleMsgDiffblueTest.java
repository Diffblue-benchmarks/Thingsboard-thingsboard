package org.thingsboard.server.common.msg.plugin;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;

class ComponentLifecycleMsgDiffblueTest {
  /**
   * Test {@link ComponentLifecycleMsg#getRuleChainId()}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComponentLifecycleMsg#getRuleChainId()}
   */
  @Test
  @DisplayName("Test getRuleChainId(); given AlarmId(UUID) with id is randomUUID; then return not Present")
  void testGetRuleChainId_givenAlarmIdWithIdIsRandomUUID_thenReturnNotPresent() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertFalse((new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED))
        .getRuleChainId()
        .isPresent());
  }

  /**
   * Test {@link ComponentLifecycleMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComponentLifecycleMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ComponentLifecycleMsg componentLifecycleMsg = new ComponentLifecycleMsg(new TenantId(UUID.randomUUID()),
        mock(AlarmId.class), ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(componentLifecycleMsg,
        new ComponentLifecycleMsg(new TenantId(UUID.randomUUID()), null, ComponentLifecycleEvent.CREATED));
  }

  /**
   * Test {@link ComponentLifecycleMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComponentLifecycleMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ComponentLifecycleMsg(new TenantId(UUID.randomUUID()), mock(AlarmId.class),
        ComponentLifecycleEvent.CREATED), "42");
  }

  /**
   * Test {@link ComponentLifecycleMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComponentLifecycleMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ComponentLifecycleMsg componentLifecycleMsg = new ComponentLifecycleMsg(null, mock(AlarmId.class),
        ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(componentLifecycleMsg,
        new ComponentLifecycleMsg(new TenantId(UUID.randomUUID()), null, ComponentLifecycleEvent.CREATED));
  }
}
