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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.service.subscription.TbAttributeSubscription.TbAttributeSubscriptionBuilder;
import org.thingsboard.server.service.subscription.TbTimeSeriesSubscription.TbTimeSeriesSubscriptionBuilder;
import org.thingsboard.server.service.ws.telemetry.sub.TelemetrySubscriptionUpdate;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class TbEntityLocalSubsInfoDiffblueTest {
  @Mock
  private EntityId entityId;

  @InjectMocks
  private TbEntityLocalSubsInfo tbEntityLocalSubsInfo;

  @InjectMocks
  private TenantId tenantId;

  /**
   * Test {@link TbEntityLocalSubsInfo#add(TbSubscription)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return Info {@link TbSubscriptionsInfo#attrKeys} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#add(TbSubscription)}
   */
  @Test
  @DisplayName("Test add(TbSubscription); given 'false'; then return Info attrKeys Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbEntitySubEvent TbEntityLocalSubsInfo.add(TbSubscription)"})
  void testAdd_givenFalse_thenReturnInfoAttrKeysEmpty() {
    // Arrange
    TbAttributeSubscription subscription = mock(TbAttributeSubscription.class);
    when(subscription.isAllKeys()).thenReturn(false);
    when(subscription.getKeyStates()).thenReturn(new HashMap<>());
    when(subscription.getSubscriptionId()).thenReturn(1);
    when(subscription.getType()).thenReturn(TbSubscriptionType.ATTRIBUTES);

    // Act
    TbEntitySubEvent actualAddResult = tbEntityLocalSubsInfo.add(subscription);

    // Assert
    verify(subscription).getKeyStates();
    verify(subscription).isAllKeys();
    verify(subscription).getSubscriptionId();
    verify(subscription).getType();
    assertFalse(tbEntityLocalSubsInfo.isNf());
    TbSubscriptionsInfo info = actualAddResult.getInfo();
    assertFalse(info.alarms);
    assertFalse(info.attrAllKeys);
    assertFalse(info.notifications);
    assertFalse(info.tsAllKeys);
    assertTrue(info.attrKeys.isEmpty());
    assertTrue(actualAddResult.hasTsOrAttrSub());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#add(TbSubscription)}.
   * <ul>
   *   <li>Given {@code NOTIFICATIONS}.</li>
   *   <li>Then {@link TbEntityLocalSubsInfo} Nf.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#add(TbSubscription)}
   */
  @Test
  @DisplayName("Test add(TbSubscription); given 'NOTIFICATIONS'; then TbEntityLocalSubsInfo Nf")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbEntitySubEvent TbEntityLocalSubsInfo.add(TbSubscription)"})
  void testAdd_givenNotifications_thenTbEntityLocalSubsInfoNf() {
    // Arrange
    TbAlarmsSubscription subscription = mock(TbAlarmsSubscription.class);
    when(subscription.getSubscriptionId()).thenReturn(1);
    when(subscription.getType()).thenReturn(TbSubscriptionType.NOTIFICATIONS);

    // Act
    TbEntitySubEvent actualAddResult = tbEntityLocalSubsInfo.add(subscription);

    // Assert
    verify(subscription).getSubscriptionId();
    verify(subscription).getType();
    TbSubscriptionsInfo info = actualAddResult.getInfo();
    assertNull(info.attrKeys);
    assertFalse(actualAddResult.hasTsOrAttrSub());
    assertFalse(info.alarms);
    assertFalse(info.attrAllKeys);
    assertFalse(info.tsAllKeys);
    assertTrue(tbEntityLocalSubsInfo.isNf());
    assertTrue(info.notifications);
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#add(TbSubscription)}.
   * <ul>
   *   <li>Then return Info {@link TbSubscriptionsInfo#alarms}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#add(TbSubscription)}
   */
  @Test
  @DisplayName("Test add(TbSubscription); then return Info alarms")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbEntitySubEvent TbEntityLocalSubsInfo.add(TbSubscription)"})
  void testAdd_thenReturnInfoAlarms() {
    // Arrange and Act
    TbEntitySubEvent actualAddResult = tbEntityLocalSubsInfo
        .add(new TbAlarmsSubscription("42", "42", 1, tenantId, entityId, mock(BiConsumer.class), 1L));

    // Assert
    TbSubscriptionsInfo info = actualAddResult.getInfo();
    assertNull(info.attrKeys);
    assertFalse(tbEntityLocalSubsInfo.isNf());
    assertFalse(actualAddResult.hasTsOrAttrSub());
    assertFalse(info.attrAllKeys);
    assertFalse(info.notifications);
    assertFalse(info.tsAllKeys);
    assertTrue(info.alarms);
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#add(TbSubscription)}.
   * <ul>
   *   <li>Then return Info {@link TbSubscriptionsInfo#attrAllKeys}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#add(TbSubscription)}
   */
  @Test
  @DisplayName("Test add(TbSubscription); then return Info attrAllKeys")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbEntitySubEvent TbEntityLocalSubsInfo.add(TbSubscription)"})
  void testAdd_thenReturnInfoAttrAllKeys() {
    // Arrange
    TbAttributeSubscriptionBuilder entityIdResult = TbAttributeSubscription.builder().allKeys(true).entityId(entityId);
    TbAttributeSubscription subscription = entityIdResult.keyStates(new HashMap<>())
        .queryTs(1L)
        .scope(TbAttributeSubscriptionScope.ANY_SCOPE)
        .serviceId("42")
        .sessionId("42")
        .subscriptionId(1)
        .tenantId(tenantId)
        .updateProcessor(mock(BiConsumer.class))
        .build();

    // Act
    TbEntitySubEvent actualAddResult = tbEntityLocalSubsInfo.add(subscription);

    // Assert
    TbSubscriptionsInfo info = actualAddResult.getInfo();
    assertNull(info.attrKeys);
    assertFalse(tbEntityLocalSubsInfo.isNf());
    assertFalse(info.alarms);
    assertFalse(info.notifications);
    assertFalse(info.tsAllKeys);
    assertTrue(actualAddResult.hasTsOrAttrSub());
    assertTrue(info.attrAllKeys);
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#add(TbSubscription)}.
   * <ul>
   *   <li>Then return Info {@link TbSubscriptionsInfo#tsAllKeys}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#add(TbSubscription)}
   */
  @Test
  @DisplayName("Test add(TbSubscription); then return Info tsAllKeys")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbEntitySubEvent TbEntityLocalSubsInfo.add(TbSubscription)"})
  void testAdd_thenReturnInfoTsAllKeys() {
    // Arrange
    TbTimeSeriesSubscriptionBuilder entityIdResult = TbTimeSeriesSubscription.builder()
        .allKeys(true)
        .endTime(1L)
        .entityId(entityId);
    TbTimeSeriesSubscription subscription = entityIdResult.keyStates(new HashMap<>())
        .latestValues(true)
        .queryTs(1L)
        .serviceId("42")
        .sessionId("42")
        .startTime(1L)
        .subscriptionId(1)
        .tenantId(tenantId)
        .updateProcessor(mock(BiConsumer.class))
        .build();

    // Act
    TbEntitySubEvent actualAddResult = tbEntityLocalSubsInfo.add(subscription);

    // Assert
    TbSubscriptionsInfo info = actualAddResult.getInfo();
    assertNull(info.attrKeys);
    assertFalse(tbEntityLocalSubsInfo.isNf());
    assertFalse(info.alarms);
    assertFalse(info.attrAllKeys);
    assertFalse(info.notifications);
    assertTrue(actualAddResult.hasTsOrAttrSub());
    assertTrue(info.tsAllKeys);
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#remove(TbSubscription)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#remove(TbSubscription)}
   */
  @Test
  @DisplayName("Test remove(TbSubscription); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbEntitySubEvent TbEntityLocalSubsInfo.remove(TbSubscription)"})
  void testRemove_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(tbEntityLocalSubsInfo
        .remove(new TbAlarmsSubscription("42", "42", 1, tenantId, entityId, mock(BiConsumer.class), 1L)));
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#removeAll(List)}.
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#removeAll(List)}
   */
  @Test
  @DisplayName("Test removeAll(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbEntitySubEvent TbEntityLocalSubsInfo.removeAll(List)"})
  void testRemoveAll() {
    // Arrange
    ArrayList<TbSubscription<?>> subsToRemove = new ArrayList<>();
    subsToRemove.add(new TbAlarmsSubscription("42", "42", 1, tenantId, entityId, mock(BiConsumer.class), 1L));

    // Act and Assert
    assertNull(tbEntityLocalSubsInfo.removeAll(subsToRemove));
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#removeAll(List)}.
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#removeAll(List)}
   */
  @Test
  @DisplayName("Test removeAll(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbEntitySubEvent TbEntityLocalSubsInfo.removeAll(List)"})
  void testRemoveAll2() {
    // Arrange
    ArrayList<TbSubscription<?>> subsToRemove = new ArrayList<>();
    subsToRemove.add(new TbAlarmsSubscription("42", "42", 1, tenantId, entityId, mock(BiConsumer.class), 1L));
    subsToRemove.add(new TbAlarmsSubscription("42", "42", 1, tenantId, entityId, mock(BiConsumer.class), 1L));

    // Act and Assert
    assertNull(tbEntityLocalSubsInfo.removeAll(subsToRemove));
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#removeAll(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#removeAll(List)}
   */
  @Test
  @DisplayName("Test removeAll(List); when ArrayList(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbEntitySubEvent TbEntityLocalSubsInfo.removeAll(List)"})
  void testRemoveAll_whenArrayList_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(tbEntityLocalSubsInfo.removeAll(new ArrayList<>()));
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#toEvent(ComponentLifecycleEvent)}.
   * <ul>
   *   <li>When {@code CREATED}.</li>
   *   <li>Then return Info {@link TbSubscriptionsInfo#attrKeys} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#toEvent(ComponentLifecycleEvent)}
   */
  @Test
  @DisplayName("Test toEvent(ComponentLifecycleEvent); when 'CREATED'; then return Info attrKeys is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbEntitySubEvent TbEntityLocalSubsInfo.toEvent(ComponentLifecycleEvent)"})
  void testToEvent_whenCreated_thenReturnInfoAttrKeysIsNull() {
    // Arrange and Act
    TbEntitySubEvent actualToEventResult = tbEntityLocalSubsInfo.toEvent(ComponentLifecycleEvent.CREATED);

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
   *   <li>When {@code DELETED}.</li>
   *   <li>Then return TenantId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#toEvent(ComponentLifecycleEvent)}
   */
  @Test
  @DisplayName("Test toEvent(ComponentLifecycleEvent); when 'DELETED'; then return TenantId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbEntitySubEvent TbEntityLocalSubsInfo.toEvent(ComponentLifecycleEvent)"})
  void testToEvent_whenDeleted_thenReturnTenantIdIsNull() {
    // Arrange and Act
    TbEntitySubEvent actualToEventResult = tbEntityLocalSubsInfo.toEvent(ComponentLifecycleEvent.DELETED);

    // Assert
    assertNull(actualToEventResult.getTenantId());
    assertNull(actualToEventResult.getInfo());
    assertEquals(1, actualToEventResult.getSeqNumber());
    assertEquals(ComponentLifecycleEvent.DELETED, actualToEventResult.getType());
    assertFalse(actualToEventResult.hasTsOrAttrSub());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#isNf()}.
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#isNf()}
   */
  @Test
  @DisplayName("Test isNf()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityLocalSubsInfo.isNf()"})
  void testIsNf() {
    // Arrange, Act and Assert
    assertFalse(tbEntityLocalSubsInfo.isNf());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#isEmpty()}.
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityLocalSubsInfo.isEmpty()"})
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue(tbEntityLocalSubsInfo.isEmpty());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#registerPendingSubscription(TbSubscription, TbEntitySubEvent)}.
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#registerPendingSubscription(TbSubscription, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test registerPendingSubscription(TbSubscription, TbEntitySubEvent)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbSubscription TbEntityLocalSubsInfo.registerPendingSubscription(TbSubscription, TbEntitySubEvent)"})
  void testRegisterPendingSubscription() {
    // Arrange
    TbAlarmsSubscription subscription = new TbAlarmsSubscription("42", "42", 1, tenantId, entityId,
        mock(BiConsumer.class), 1L);

    // Act and Assert
    assertNull(tbEntityLocalSubsInfo.registerPendingSubscription(subscription,
        new TbEntitySubEvent(tenantId, entityId, ComponentLifecycleEvent.CREATED, new TbSubscriptionsInfo(), 10)));
    assertEquals(0, tbEntityLocalSubsInfo.getPendingAttributesEvent());
    assertEquals(0, tbEntityLocalSubsInfo.getPendingTimeSeriesEvent());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#registerPendingSubscription(TbSubscription, TbEntitySubEvent)}.
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#registerPendingSubscription(TbSubscription, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test registerPendingSubscription(TbSubscription, TbEntitySubEvent)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbSubscription TbEntityLocalSubsInfo.registerPendingSubscription(TbSubscription, TbEntitySubEvent)"})
  void testRegisterPendingSubscription2() {
    // Arrange
    TbTimeSeriesSubscriptionBuilder entityIdResult = TbTimeSeriesSubscription.builder()
        .allKeys(true)
        .endTime(1L)
        .entityId(entityId);
    TbTimeSeriesSubscription subscription = entityIdResult.keyStates(new HashMap<>())
        .latestValues(true)
        .queryTs(1L)
        .serviceId("42")
        .sessionId("42")
        .startTime(1L)
        .subscriptionId(1)
        .tenantId(tenantId)
        .updateProcessor(mock(BiConsumer.class))
        .build();

    // Act and Assert
    assertNull(tbEntityLocalSubsInfo.registerPendingSubscription(subscription,
        new TbEntitySubEvent(tenantId, entityId, ComponentLifecycleEvent.CREATED, new TbSubscriptionsInfo(), 10)));
    assertEquals(0, tbEntityLocalSubsInfo.getPendingAttributesEvent());
    assertEquals(10, tbEntityLocalSubsInfo.getPendingTimeSeriesEvent());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#registerPendingSubscription(TbSubscription, TbEntitySubEvent)}.
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#registerPendingSubscription(TbSubscription, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test registerPendingSubscription(TbSubscription, TbEntitySubEvent)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbSubscription TbEntityLocalSubsInfo.registerPendingSubscription(TbSubscription, TbEntitySubEvent)"})
  void testRegisterPendingSubscription3() {
    // Arrange
    BiConsumer<TbSubscription<TelemetrySubscriptionUpdate>, TelemetrySubscriptionUpdate> updateProcessor = mock(
        BiConsumer.class);
    TbAttributeSubscription subscription = new TbAttributeSubscription("42", "42", 1, tenantId, entityId,
        updateProcessor, 1L, true, new HashMap<>(), TbAttributeSubscriptionScope.ANY_SCOPE);

    // Act and Assert
    assertNull(tbEntityLocalSubsInfo.registerPendingSubscription(subscription,
        new TbEntitySubEvent(tenantId, entityId, ComponentLifecycleEvent.CREATED, new TbSubscriptionsInfo(), 10)));
    assertEquals(0, tbEntityLocalSubsInfo.getPendingTimeSeriesEvent());
    assertEquals(10, tbEntityLocalSubsInfo.getPendingAttributesEvent());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#registerPendingSubscription(TbSubscription, TbEntitySubEvent)}.
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#registerPendingSubscription(TbSubscription, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test registerPendingSubscription(TbSubscription, TbEntitySubEvent)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbSubscription TbEntityLocalSubsInfo.registerPendingSubscription(TbSubscription, TbEntitySubEvent)"})
  void testRegisterPendingSubscription4() {
    // Arrange
    TbTimeSeriesSubscriptionBuilder entityIdResult = TbTimeSeriesSubscription.builder()
        .allKeys(true)
        .endTime(1L)
        .entityId(entityId);
    TbTimeSeriesSubscription subscription = entityIdResult.keyStates(new HashMap<>())
        .latestValues(true)
        .queryTs(1L)
        .serviceId("42")
        .sessionId("42")
        .startTime(1L)
        .subscriptionId(1)
        .tenantId(tenantId)
        .updateProcessor(mock(BiConsumer.class))
        .build();

    // Act and Assert
    assertSame(subscription, tbEntityLocalSubsInfo.registerPendingSubscription(subscription, null));
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#registerPendingSubscription(TbSubscription, TbEntitySubEvent)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then calls {@link TbEntitySubEvent#getSeqNumber()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#registerPendingSubscription(TbSubscription, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test registerPendingSubscription(TbSubscription, TbEntitySubEvent); given ten; then calls getSeqNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbSubscription TbEntityLocalSubsInfo.registerPendingSubscription(TbSubscription, TbEntitySubEvent)"})
  void testRegisterPendingSubscription_givenTen_thenCallsGetSeqNumber() {
    // Arrange
    TbTimeSeriesSubscriptionBuilder entityIdResult = TbTimeSeriesSubscription.builder()
        .allKeys(true)
        .endTime(1L)
        .entityId(entityId);
    TbTimeSeriesSubscription subscription = entityIdResult.keyStates(new HashMap<>())
        .latestValues(true)
        .queryTs(1L)
        .serviceId("42")
        .sessionId("42")
        .startTime(1L)
        .subscriptionId(1)
        .tenantId(tenantId)
        .updateProcessor(mock(BiConsumer.class))
        .build();
    TbEntitySubEvent event = mock(TbEntitySubEvent.class);
    when(event.getSeqNumber()).thenReturn(10);

    // Act
    TbSubscription<?> actualRegisterPendingSubscriptionResult = tbEntityLocalSubsInfo
        .registerPendingSubscription(subscription, event);

    // Assert
    verify(event, atLeast(1)).getSeqNumber();
    assertNull(actualRegisterPendingSubscriptionResult);
    assertEquals(0, tbEntityLocalSubsInfo.getPendingAttributesEvent());
    assertEquals(10, tbEntityLocalSubsInfo.getPendingTimeSeriesEvent());
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#clearPendingSubscriptions(int)}.
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#clearPendingSubscriptions(int)}
   */
  @Test
  @DisplayName("Test clearPendingSubscriptions(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set TbEntityLocalSubsInfo.clearPendingSubscriptions(int)"})
  void testClearPendingSubscriptions() {
    // Arrange
    TbEntityLocalSubsInfo tbEntityLocalSubsInfo = new TbEntityLocalSubsInfo(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null);
    tbEntityLocalSubsInfo.setPendingTimeSeriesEvent(3);

    // Act and Assert
    assertNull(tbEntityLocalSubsInfo.clearPendingSubscriptions(0));
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#clearPendingSubscriptions(int)}.
   * <ul>
   *   <li>Given {@link TbEntityLocalSubsInfo}.</li>
   *   <li>When ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#clearPendingSubscriptions(int)}
   */
  @Test
  @DisplayName("Test clearPendingSubscriptions(int); given TbEntityLocalSubsInfo; when ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set TbEntityLocalSubsInfo.clearPendingSubscriptions(int)"})
  void testClearPendingSubscriptions_givenTbEntityLocalSubsInfo_whenTen() {
    // Arrange, Act and Assert
    assertNull(tbEntityLocalSubsInfo.clearPendingSubscriptions(10));
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#clearPendingSubscriptions(int)}.
   * <ul>
   *   <li>Given {@link TbEntityLocalSubsInfo}.</li>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#clearPendingSubscriptions(int)}
   */
  @Test
  @DisplayName("Test clearPendingSubscriptions(int); given TbEntityLocalSubsInfo; when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set TbEntityLocalSubsInfo.clearPendingSubscriptions(int)"})
  void testClearPendingSubscriptions_givenTbEntityLocalSubsInfo_whenZero() {
    // Arrange, Act and Assert
    assertNull(tbEntityLocalSubsInfo.clearPendingSubscriptions(0));
  }

  /**
   * Test {@link TbEntityLocalSubsInfo#TbEntityLocalSubsInfo(TenantId, EntityId)}.
   * <p>
   * Method under test: {@link TbEntityLocalSubsInfo#TbEntityLocalSubsInfo(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test new TbEntityLocalSubsInfo(TenantId, EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbEntityLocalSubsInfo.<init>(TenantId, EntityId)"})
  void testNewTbEntityLocalSubsInfo() {
    // Arrange and Act
    TbEntityLocalSubsInfo actualTbEntityLocalSubsInfo = new TbEntityLocalSubsInfo(tenantId, entityId);

    // Assert
    assertEquals(0, actualTbEntityLocalSubsInfo.getPendingAttributesEvent());
    assertEquals(0, actualTbEntityLocalSubsInfo.getPendingTimeSeriesEvent());
    assertEquals(0L, actualTbEntityLocalSubsInfo.getPendingAttributesEventTs());
    assertEquals(0L, actualTbEntityLocalSubsInfo.getPendingTimeSeriesEventTs());
    assertFalse(actualTbEntityLocalSubsInfo.isNf());
    assertTrue(actualTbEntityLocalSubsInfo.getSubs().isEmpty());
    assertTrue(actualTbEntityLocalSubsInfo.isEmpty());
    assertSame(entityId, actualTbEntityLocalSubsInfo.getEntityId());
    assertSame(tenantId, actualTbEntityLocalSubsInfo.getTenantId());
  }
}
