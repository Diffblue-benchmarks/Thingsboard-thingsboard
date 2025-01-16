package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.service.ws.telemetry.sub.TelemetrySubscriptionUpdate;

class TbAttributeSubscriptionDiffblueTest {
  /**
   * Test
   * {@link TbAttributeSubscription#TbAttributeSubscription(String, String, int, TenantId, EntityId, BiConsumer, long, boolean, Map, TbAttributeSubscriptionScope)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ServiceId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAttributeSubscription#TbAttributeSubscription(String, String, int, TenantId, EntityId, BiConsumer, long, boolean, Map, TbAttributeSubscriptionScope)}
   */
  @Test
  @DisplayName("Test new TbAttributeSubscription(String, String, int, TenantId, EntityId, BiConsumer, long, boolean, Map, TbAttributeSubscriptionScope); when 'null'; then return ServiceId is '42'")
  void testNewTbAttributeSubscription_whenNull_thenReturnServiceIdIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    BiConsumer<TbSubscription<TelemetrySubscriptionUpdate>, TelemetrySubscriptionUpdate> updateProcessor = mock(
        BiConsumer.class);

    // Act
    TbAttributeSubscription actualTbAttributeSubscription = new TbAttributeSubscription("42", "42", 1, tenantId, null,
        updateProcessor, 1L, true, new HashMap<>(), TbAttributeSubscriptionScope.ANY_SCOPE);

    // Assert
    assertEquals("42", actualTbAttributeSubscription.getServiceId());
    assertEquals("42", actualTbAttributeSubscription.getSessionId());
    assertNull(actualTbAttributeSubscription.getEntityId());
    assertEquals(1, actualTbAttributeSubscription.getSubscriptionId());
    assertEquals(1L, actualTbAttributeSubscription.getQueryTs());
    assertEquals(TbAttributeSubscriptionScope.ANY_SCOPE, actualTbAttributeSubscription.getScope());
    assertEquals(TbSubscriptionType.ATTRIBUTES, actualTbAttributeSubscription.getType());
    assertTrue(actualTbAttributeSubscription.getKeyStates().isEmpty());
    assertTrue(actualTbAttributeSubscription.isAllKeys());
    assertSame(tenantId, actualTbAttributeSubscription.getTenantId());
    assertSame(updateProcessor, actualTbAttributeSubscription.getUpdateProcessor());
  }
}
