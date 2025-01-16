package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.service.ws.telemetry.sub.AlarmSubscriptionUpdate;

class TbEntityLocalSubsInfoDiffblueTest {
  /**
   * Test {@link TbEntityLocalSubsInfo#removeAll(List)}.
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#removeAll(List)}
   */
  @Test
  @DisplayName("Test removeAll(List)")
  void testRemoveAll() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityLocalSubsInfo tbEntityLocalSubsInfo = new TbEntityLocalSubsInfo(new TenantId(UUID.randomUUID()), null);
    tbEntityLocalSubsInfo.add(
        new TbAlarmsSubscription("42", "42", 1, new TenantId(UUID.randomUUID()), null, mock(BiConsumer.class), 1L));

    // Act and Assert
    assertNull(tbEntityLocalSubsInfo.removeAll(new ArrayList<>()));
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#removeAll(List)}.
   * <ul>
   *   <li>Given
   * {@link TbEntityLocalSubsInfo#TbEntityLocalSubsInfo(TenantId, EntityId)} with
   * tenantId is {@link TenantId#TenantId(UUID)} and entityId is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#removeAll(List)}
   */
  @Test
  @DisplayName("Test removeAll(List); given TbEntityLocalSubsInfo(TenantId, EntityId) with tenantId is TenantId(UUID) and entityId is 'null'")
  void testRemoveAll_givenTbEntityLocalSubsInfoWithTenantIdIsTenantIdAndEntityIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityLocalSubsInfo tbEntityLocalSubsInfo = new TbEntityLocalSubsInfo(new TenantId(UUID.randomUUID()), null);

    // Act and Assert
    assertNull(tbEntityLocalSubsInfo.removeAll(new ArrayList<>()));
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#removeAll(List)}.
   * <ul>
   *   <li>Then calls {@link TbSubscription#getSubscriptionId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#removeAll(List)}
   */
  @Test
  @DisplayName("Test removeAll(List); then calls getSubscriptionId()")
  void testRemoveAll_thenCallsGetSubscriptionId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbTimeSeriesSubscription subscription = mock(TbTimeSeriesSubscription.class);
    when(subscription.isAllKeys()).thenReturn(false);
    when(subscription.getKeyStates()).thenReturn(new HashMap<>());
    when(subscription.getSubscriptionId()).thenReturn(1);
    when(subscription.getType()).thenReturn(TbSubscriptionType.TIMESERIES);

    TbEntityLocalSubsInfo tbEntityLocalSubsInfo = new TbEntityLocalSubsInfo(new TenantId(UUID.randomUUID()), null);
    tbEntityLocalSubsInfo.add(subscription);

    // Act
    TbEntitySubEvent actualRemoveAllResult = tbEntityLocalSubsInfo.removeAll(new ArrayList<>());

    // Assert
    verify(subscription).getSubscriptionId();
    verify(subscription, atLeast(1)).getType();
    verify(subscription).getKeyStates();
    verify(subscription).isAllKeys();
    assertNull(actualRemoveAllResult);
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#toEvent(ComponentLifecycleEvent)}.
   * <ul>
   *   <li>Given
   * {@link TbEntityLocalSubsInfo#TbEntityLocalSubsInfo(TenantId, EntityId)} with
   * tenantId is {@link TenantId#TenantId(UUID)} and entityId is
   * {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbEntityLocalSubsInfo#toEvent(ComponentLifecycleEvent)}
   */
  @Test
  @DisplayName("Test toEvent(ComponentLifecycleEvent); given TbEntityLocalSubsInfo(TenantId, EntityId) with tenantId is TenantId(UUID) and entityId is AlarmId")
  void testToEvent_givenTbEntityLocalSubsInfoWithTenantIdIsTenantIdAndEntityIdIsAlarmId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TbEntitySubEvent actualToEventResult = (new TbEntityLocalSubsInfo(new TenantId(UUID.randomUUID()),
        mock(AlarmId.class))).toEvent(ComponentLifecycleEvent.CREATED);

    // Assert
    TbSubscriptionsInfo info = actualToEventResult.getInfo();
    assertNull(info.attrKeys);
    assertNull(info.tsKeys);
    assertEquals(1, info.seqNumber);
    assertEquals(ComponentLifecycleEvent.CREATED, actualToEventResult.getType());
    assertFalse(info.alarms);
    assertFalse(info.attrAllKeys);
    assertFalse(info.notifications);
    assertFalse(info.tsAllKeys);
    assertTrue(info.isEmpty());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#toEvent(ComponentLifecycleEvent)}.
   * <ul>
   *   <li>Then return Info {@link TbSubscriptionsInfo#attrKeys} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbEntityLocalSubsInfo#toEvent(ComponentLifecycleEvent)}
   */
  @Test
  @DisplayName("Test toEvent(ComponentLifecycleEvent); then return Info attrKeys is 'null'")
  void testToEvent_thenReturnInfoAttrKeysIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TbEntitySubEvent actualToEventResult = (new TbEntityLocalSubsInfo(new TenantId(UUID.randomUUID()), null))
        .toEvent(ComponentLifecycleEvent.CREATED);

    // Assert
    TbSubscriptionsInfo info = actualToEventResult.getInfo();
    assertNull(info.attrKeys);
    assertNull(info.tsKeys);
    assertNull(actualToEventResult.getEntityId());
    assertEquals(1, info.seqNumber);
    assertEquals(ComponentLifecycleEvent.CREATED, actualToEventResult.getType());
    assertFalse(info.alarms);
    assertFalse(info.attrAllKeys);
    assertFalse(info.notifications);
    assertFalse(info.tsAllKeys);
    assertTrue(info.isEmpty());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#toEvent(ComponentLifecycleEvent)}.
   * <ul>
   *   <li>When {@code DELETED}.</li>
   *   <li>Then return Info is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbEntityLocalSubsInfo#toEvent(ComponentLifecycleEvent)}
   */
  @Test
  @DisplayName("Test toEvent(ComponentLifecycleEvent); when 'DELETED'; then return Info is 'null'")
  void testToEvent_whenDeleted_thenReturnInfoIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TbEntitySubEvent actualToEventResult = (new TbEntityLocalSubsInfo(new TenantId(UUID.randomUUID()), null))
        .toEvent(ComponentLifecycleEvent.DELETED);

    // Assert
    assertNull(actualToEventResult.getEntityId());
    assertNull(actualToEventResult.getInfo());
    assertEquals(ComponentLifecycleEvent.DELETED, actualToEventResult.getType());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#isNf()}.
   * <ul>
   *   <li>Given
   * {@link TbEntityLocalSubsInfo#TbEntityLocalSubsInfo(TenantId, EntityId)} with
   * tenantId is {@link TenantId#TenantId(UUID)} and entityId is
   * {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#isNf()}
   */
  @Test
  @DisplayName("Test isNf(); given TbEntityLocalSubsInfo(TenantId, EntityId) with tenantId is TenantId(UUID) and entityId is AlarmId")
  void testIsNf_givenTbEntityLocalSubsInfoWithTenantIdIsTenantIdAndEntityIdIsAlarmId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TbEntityLocalSubsInfo(new TenantId(UUID.randomUUID()), mock(AlarmId.class))).isNf());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#isNf()}.
   * <ul>
   *   <li>Given
   * {@link TbEntityLocalSubsInfo#TbEntityLocalSubsInfo(TenantId, EntityId)} with
   * tenantId is {@link TenantId#TenantId(UUID)} and entityId is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#isNf()}
   */
  @Test
  @DisplayName("Test isNf(); given TbEntityLocalSubsInfo(TenantId, EntityId) with tenantId is TenantId(UUID) and entityId is 'null'")
  void testIsNf_givenTbEntityLocalSubsInfoWithTenantIdIsTenantIdAndEntityIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TbEntityLocalSubsInfo(new TenantId(UUID.randomUUID()), null)).isNf());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#isEmpty()}.
   * <ul>
   *   <li>Given
   * {@link TbEntityLocalSubsInfo#TbEntityLocalSubsInfo(TenantId, EntityId)} with
   * tenantId is {@link TenantId#TenantId(UUID)} and entityId is
   * {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given TbEntityLocalSubsInfo(TenantId, EntityId) with tenantId is TenantId(UUID) and entityId is AlarmId")
  void testIsEmpty_givenTbEntityLocalSubsInfoWithTenantIdIsTenantIdAndEntityIdIsAlarmId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TbEntityLocalSubsInfo(new TenantId(UUID.randomUUID()), mock(AlarmId.class))).isEmpty());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#isEmpty()}.
   * <ul>
   *   <li>Given
   * {@link TbEntityLocalSubsInfo#TbEntityLocalSubsInfo(TenantId, EntityId)} with
   * tenantId is {@link TenantId#TenantId(UUID)} and entityId is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given TbEntityLocalSubsInfo(TenantId, EntityId) with tenantId is TenantId(UUID) and entityId is 'null'")
  void testIsEmpty_givenTbEntityLocalSubsInfoWithTenantIdIsTenantIdAndEntityIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TbEntityLocalSubsInfo(new TenantId(UUID.randomUUID()), null)).isEmpty());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#clearPendingSubscriptions(int)}.
   * <p>
   * Method under test:
   * {@link TbEntityLocalSubsInfo#clearPendingSubscriptions(int)}
   */
  @Test
  @DisplayName("Test clearPendingSubscriptions(int)")
  void testClearPendingSubscriptions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TbEntityLocalSubsInfo(new TenantId(UUID.randomUUID()), null)).clearPendingSubscriptions(10));
    assertNull((new TbEntityLocalSubsInfo(new TenantId(UUID.randomUUID()), mock(AlarmId.class)))
        .clearPendingSubscriptions(10));
    assertNull((new TbEntityLocalSubsInfo(new TenantId(UUID.randomUUID()), null)).clearPendingSubscriptions(0));
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#clearPendingSubscriptions(int)}.
   * <p>
   * Method under test:
   * {@link TbEntityLocalSubsInfo#clearPendingSubscriptions(int)}
   */
  @Test
  @DisplayName("Test clearPendingSubscriptions(int)")
  void testClearPendingSubscriptions2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityLocalSubsInfo tbEntityLocalSubsInfo = new TbEntityLocalSubsInfo(new TenantId(UUID.randomUUID()), null);
    tbEntityLocalSubsInfo.setPendingTimeSeriesEvent(3);

    // Act and Assert
    assertNull(tbEntityLocalSubsInfo.clearPendingSubscriptions(0));
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#TbEntityLocalSubsInfo(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link AlarmId}.</li>
   *   <li>Then return EntityId is {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbEntityLocalSubsInfo#TbEntityLocalSubsInfo(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test new TbEntityLocalSubsInfo(TenantId, EntityId); when AlarmId; then return EntityId is AlarmId")
  void testNewTbEntityLocalSubsInfo_whenAlarmId_thenReturnEntityIdIsAlarmId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);

    // Act
    TbEntityLocalSubsInfo actualTbEntityLocalSubsInfo = new TbEntityLocalSubsInfo(tenantId, entityId);

    // Assert
    assertEquals(0, actualTbEntityLocalSubsInfo.getPendingAttributesEvent());
    assertEquals(0, actualTbEntityLocalSubsInfo.getPendingTimeSeriesEvent());
    assertEquals(0L, actualTbEntityLocalSubsInfo.getPendingAttributesEventTs());
    assertEquals(0L, actualTbEntityLocalSubsInfo.getPendingTimeSeriesEventTs());
    assertFalse(actualTbEntityLocalSubsInfo.isNf());
    assertTrue(actualTbEntityLocalSubsInfo.getSubs().isEmpty());
    assertTrue(actualTbEntityLocalSubsInfo.isEmpty());
    assertSame(tenantId, actualTbEntityLocalSubsInfo.getTenantId());
    assertSame(entityId, actualTbEntityLocalSubsInfo.getEntityId());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#TbEntityLocalSubsInfo(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbEntityLocalSubsInfo#TbEntityLocalSubsInfo(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test new TbEntityLocalSubsInfo(TenantId, EntityId); when 'null'; then return EntityId is 'null'")
  void testNewTbEntityLocalSubsInfo_whenNull_thenReturnEntityIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TbEntityLocalSubsInfo actualTbEntityLocalSubsInfo = new TbEntityLocalSubsInfo(tenantId, null);

    // Assert
    assertNull(actualTbEntityLocalSubsInfo.getEntityId());
    assertEquals(0, actualTbEntityLocalSubsInfo.getPendingAttributesEvent());
    assertEquals(0, actualTbEntityLocalSubsInfo.getPendingTimeSeriesEvent());
    assertEquals(0L, actualTbEntityLocalSubsInfo.getPendingAttributesEventTs());
    assertEquals(0L, actualTbEntityLocalSubsInfo.getPendingTimeSeriesEventTs());
    assertFalse(actualTbEntityLocalSubsInfo.isNf());
    assertTrue(actualTbEntityLocalSubsInfo.getSubs().isEmpty());
    assertTrue(actualTbEntityLocalSubsInfo.isEmpty());
    assertSame(tenantId, actualTbEntityLocalSubsInfo.getTenantId());
  }
}
