package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.service.ws.telemetry.sub.TelemetrySubscriptionUpdate;

class TbTimeSeriesSubscriptionDiffblueTest {
  /**
   * Test {@link TbTimeSeriesSubscription#TbTimeSeriesSubscription(String, String, int, TenantId, EntityId, BiConsumer, long, boolean, Map, long, long, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ServiceId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTimeSeriesSubscription#TbTimeSeriesSubscription(String, String, int, TenantId, EntityId, BiConsumer, long, boolean, Map, long, long, boolean)}
   */
  @Test
  @DisplayName("Test new TbTimeSeriesSubscription(String, String, int, TenantId, EntityId, BiConsumer, long, boolean, Map, long, long, boolean); when 'null'; then return ServiceId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void TbTimeSeriesSubscription.<init>(String, String, int, TenantId, EntityId, BiConsumer, long, boolean, Map, long, long, boolean)"})
  void testNewTbTimeSeriesSubscription_whenNull_thenReturnServiceIdIs42() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    BiConsumer<TbSubscription<TelemetrySubscriptionUpdate>, TelemetrySubscriptionUpdate> updateProcessor = mock(
        BiConsumer.class);

    // Act
    TbTimeSeriesSubscription actualTbTimeSeriesSubscription = new TbTimeSeriesSubscription("42", "42", 1, tenantId,
        null, updateProcessor, 1L, true, new HashMap<>(), 1L, 1L, true);

    // Assert
    assertEquals("42", actualTbTimeSeriesSubscription.getServiceId());
    assertEquals("42", actualTbTimeSeriesSubscription.getSessionId());
    assertNull(actualTbTimeSeriesSubscription.getEntityId());
    assertEquals(1, actualTbTimeSeriesSubscription.getSubscriptionId());
    assertEquals(1L, actualTbTimeSeriesSubscription.getEndTime());
    assertEquals(1L, actualTbTimeSeriesSubscription.getQueryTs());
    assertEquals(1L, actualTbTimeSeriesSubscription.getStartTime());
    assertEquals(TbSubscriptionType.TIMESERIES, actualTbTimeSeriesSubscription.getType());
    assertTrue(actualTbTimeSeriesSubscription.getKeyStates().isEmpty());
    assertTrue(actualTbTimeSeriesSubscription.isAllKeys());
    assertTrue(actualTbTimeSeriesSubscription.isLatestValues());
    assertSame(tenantId, actualTbTimeSeriesSubscription.getTenantId());
    assertSame(updateProcessor, actualTbTimeSeriesSubscription.getUpdateProcessor());
  }
}
