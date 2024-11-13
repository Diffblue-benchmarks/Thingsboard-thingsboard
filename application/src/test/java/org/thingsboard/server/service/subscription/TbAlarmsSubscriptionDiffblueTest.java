package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.service.ws.telemetry.sub.AlarmSubscriptionUpdate;

class TbAlarmsSubscriptionDiffblueTest {
  /**
   * Test
   * {@link TbAlarmsSubscription#TbAlarmsSubscription(String, String, int, TenantId, EntityId, BiConsumer, long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ServiceId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAlarmsSubscription#TbAlarmsSubscription(String, String, int, TenantId, EntityId, BiConsumer, long)}
   */
  @Test
  @DisplayName("Test new TbAlarmsSubscription(String, String, int, TenantId, EntityId, BiConsumer, long); when 'null'; then return ServiceId is '42'")
  void testNewTbAlarmsSubscription_whenNull_thenReturnServiceIdIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    BiConsumer<TbSubscription<AlarmSubscriptionUpdate>, AlarmSubscriptionUpdate> updateProcessor = mock(
        BiConsumer.class);

    // Act
    TbAlarmsSubscription actualTbAlarmsSubscription = new TbAlarmsSubscription("42", "42", 1, tenantId, null,
        updateProcessor, 1L);

    // Assert
    assertEquals("42", actualTbAlarmsSubscription.getServiceId());
    assertEquals("42", actualTbAlarmsSubscription.getSessionId());
    assertNull(actualTbAlarmsSubscription.getEntityId());
    assertEquals(1, actualTbAlarmsSubscription.getSubscriptionId());
    assertEquals(1L, actualTbAlarmsSubscription.getTs());
    assertEquals(TbSubscriptionType.ALARMS, actualTbAlarmsSubscription.getType());
    assertSame(tenantId, actualTbAlarmsSubscription.getTenantId());
    assertSame(updateProcessor, actualTbAlarmsSubscription.getUpdateProcessor());
  }
}
