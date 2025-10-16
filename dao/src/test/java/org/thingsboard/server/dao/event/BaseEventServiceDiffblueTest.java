/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.EventInfo;
import org.thingsboard.server.common.data.event.ErrorEvent;
import org.thingsboard.server.common.data.event.ErrorEvent.ErrorEventBuilder;
import org.thingsboard.server.common.data.event.ErrorEventFilter;
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.common.data.event.EventFilter;
import org.thingsboard.server.common.data.event.EventType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.NotificationId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.QueueStatsId;
import org.thingsboard.server.common.data.id.RpcId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseEventService.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseEventServiceDiffblueTest {
  @Autowired private BaseEventService baseEventService;

  @MockBean private DataValidator<Event> dataValidator;

  @MockBean private EventDao eventDao;

  /**
   * Test {@link BaseEventService#saveAsync(Event)}.
   *
   * <p>Method under test: {@link BaseEventService#saveAsync(Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEventService.saveAsync(Event)"})
  public void testSaveAsync() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(eventDao.saveAsync(Mockito.<Event>any())).thenReturn(createResult);
    when(dataValidator.validate(Mockito.<Event>any(), Mockito.<Function<Event, TenantId>>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    // Act
    ListenableFuture<Void> actualSaveAsyncResult =
        baseEventService.saveAsync(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    // Assert
    verify(eventDao).saveAsync(isA(Event.class));
    verify(dataValidator).validate(isA(Event.class), isA(Function.class));
    assertTrue(actualSaveAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualSaveAsyncResult);
  }

  /**
   * Test {@link BaseEventService#saveAsync(Event)}.
   *
   * <p>Method under test: {@link BaseEventService#saveAsync(Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEventService.saveAsync(Event)"})
  public void testSaveAsync2() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(eventDao.saveAsync(Mockito.<Event>any())).thenReturn(createResult);
    when(dataValidator.validate(Mockito.<Event>any(), Mockito.<Function<Event, TenantId>>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    // Act
    ListenableFuture<Void> actualSaveAsyncResult =
        baseEventService.saveAsync(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error(null)
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    // Assert
    verify(eventDao).saveAsync(isA(Event.class));
    verify(dataValidator).validate(isA(Event.class), isA(Function.class));
    assertTrue(actualSaveAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualSaveAsyncResult);
  }

  /**
   * Test {@link BaseEventService#saveAsync(Event)}.
   *
   * <ul>
   *   <li>Given {@code STATS}.
   *   <li>When {@link Event} {@link Event#getType()} return {@code STATS}.
   *   <li>Then calls {@link Event#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#saveAsync(Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEventService.saveAsync(Event)"})
  public void testSaveAsync_givenStats_whenEventGetTypeReturnStats_thenCallsGetType() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(eventDao.saveAsync(Mockito.<Event>any())).thenReturn(createResult);
    when(dataValidator.validate(Mockito.<Event>any(), Mockito.<Function<Event, TenantId>>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    Event event = mock(Event.class);
    when(event.getType()).thenReturn(EventType.STATS);

    // Act
    ListenableFuture<Void> actualSaveAsyncResult = baseEventService.saveAsync(event);

    // Assert
    verify(event).getType();
    verify(eventDao).saveAsync(isA(Event.class));
    verify(dataValidator).validate(isA(Event.class), isA(Function.class));
    assertTrue(actualSaveAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualSaveAsyncResult);
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents() {
    // Arrange
    PageData<? extends Event> pageData = new PageData<>(new ArrayList<>(), 4, 4L, true);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            EventType.ERROR,
            new TimePageLink(3));

    // Assert
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    assertEquals(pageData, actualFindEventsResult);
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents2() {
    // Arrange
    PageData<? extends Event> pageData = new PageData<>(null, 4, 4L, true);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            EventType.ERROR,
            new TimePageLink(3));

    // Assert
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    assertEquals(pageData, actualFindEventsResult);
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ALARM}.
   *   <li>Then Data first EntityId return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenAlarm_thenDataFirstEntityIdReturnAlarmId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ALARM);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code API_USAGE_STATE}.
   *   <li>Then Data first EntityId return {@link ApiUsageStateId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenApiUsageState_thenDataFirstEntityIdReturnApiUsageStateId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.API_USAGE_STATE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof ApiUsageStateId);
    assertEquals(EntityType.API_USAGE_STATE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ASSET_PROFILE}.
   *   <li>Then Data first EntityId return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenAssetProfile_thenDataFirstEntityIdReturnAssetProfileId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ASSET_PROFILE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AssetProfileId);
    assertEquals(EntityType.ASSET_PROFILE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ASSET}.
   *   <li>Then Data first EntityId return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenAsset_thenDataFirstEntityIdReturnAssetId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ASSET);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AssetId);
    assertEquals(EntityType.ASSET, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DASHBOARD}.
   *   <li>Then Data first EntityId return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenDashboard_thenDataFirstEntityIdReturnDashboardId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DEVICE_PROFILE}.
   *   <li>Then Data first EntityId return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenDeviceProfile_thenDataFirstEntityIdReturnDeviceProfileId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DEVICE_PROFILE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DeviceProfileId);
    assertEquals(EntityType.DEVICE_PROFILE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DEVICE}.
   *   <li>Then Data first EntityId return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenDevice_thenDataFirstEntityIdReturnDeviceId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DEVICE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DeviceId);
    assertEquals(EntityType.DEVICE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DOMAIN}.
   *   <li>Then Data first EntityId return {@link DomainId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenDomain_thenDataFirstEntityIdReturnDomainId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DOMAIN);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DomainId);
    assertEquals(EntityType.DOMAIN, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code EDGE}.
   *   <li>Then Data first EntityId return {@link EdgeId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenEdge_thenDataFirstEntityIdReturnEdgeId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.EDGE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof EdgeId);
    assertEquals(EntityType.EDGE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ENTITY_VIEW}.
   *   <li>Then Data first EntityId return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenEntityView_thenDataFirstEntityIdReturnEntityViewId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ENTITY_VIEW);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof EntityViewId);
    assertEquals(EntityType.ENTITY_VIEW, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code MOBILE_APP}.
   *   <li>Then Data first EntityId return {@link MobileAppId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenMobileApp_thenDataFirstEntityIdReturnMobileAppId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.MOBILE_APP);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof MobileAppId);
    assertEquals(EntityType.MOBILE_APP, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code NOTIFICATION}.
   *   <li>Then Data first EntityId return {@link NotificationId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenNotification_thenDataFirstEntityIdReturnNotificationId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationId);
    assertEquals(EntityType.NOTIFICATION, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return TotalPages is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenNull_uuid_whenNull_customer_id_thenReturnTotalPagesIsOne() {
    // Arrange
    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(new ArrayList<>());
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    assertEquals(1, actualFindEventsResult.getTotalPages());
    assertEquals(1L, actualFindEventsResult.getTotalElements());
    assertTrue(actualFindEventsResult.getData().isEmpty());
    assertTrue(actualFindEventsResult.hasNext());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code OAUTH2_CLIENT}.
   *   <li>Then Data first EntityId return {@link OAuth2ClientId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenOauth2Client_thenDataFirstEntityIdReturnOAuth2ClientId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.OAUTH2_CLIENT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof OAuth2ClientId);
    assertEquals(EntityType.OAUTH2_CLIENT, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code OTA_PACKAGE}.
   *   <li>Then Data first EntityId return {@link OtaPackageId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenOtaPackage_thenDataFirstEntityIdReturnOtaPackageId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.OTA_PACKAGE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof OtaPackageId);
    assertEquals(EntityType.OTA_PACKAGE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code QUEUE_STATS}.
   *   <li>Then Data first EntityId return {@link QueueStatsId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenQueueStats_thenDataFirstEntityIdReturnQueueStatsId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.QUEUE_STATS);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof QueueStatsId);
    assertEquals(EntityType.QUEUE_STATS, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code QUEUE}.
   *   <li>Then Data first EntityId return {@link QueueId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenQueue_thenDataFirstEntityIdReturnQueueId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.QUEUE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof QueueId);
    assertEquals(EntityType.QUEUE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code RPC}.
   *   <li>Then Data first EntityId return {@link RpcId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenRpc_thenDataFirstEntityIdReturnRpcId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RPC);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RpcId);
    assertEquals(EntityType.RPC, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code RULE_CHAIN}.
   *   <li>Then Data first EntityId return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenRuleChain_thenDataFirstEntityIdReturnRuleChainId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_CHAIN);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RuleChainId);
    assertEquals(EntityType.RULE_CHAIN, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code RULE_NODE}.
   *   <li>Then Data first EntityId return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenRuleNode_thenDataFirstEntityIdReturnRuleNodeId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RuleNodeId);
    assertEquals(EntityType.RULE_NODE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code TB_RESOURCE}.
   *   <li>Then Data first EntityId return {@link TbResourceId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenTbResource_thenDataFirstEntityIdReturnTbResourceId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TB_RESOURCE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TbResourceId);
    assertEquals(EntityType.TB_RESOURCE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code TENANT_PROFILE}.
   *   <li>Then Data first EntityId return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenTenantProfile_thenDataFirstEntityIdReturnTenantProfileId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT_PROFILE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantProfileId);
    assertEquals(EntityType.TENANT_PROFILE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>Then return Data first TenantId is Data first EntityId.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenTenant_thenReturnDataFirstTenantIdIsDataFirstEntityId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertSame(entityId2, getResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, entityId2);
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>When {@link EntityId} {@link EntityId#getEntityType()} return {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenTenant_whenEntityIdGetEntityTypeReturnTenant() {
    // Arrange
    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(new ArrayList<>());
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    assertEquals(1, actualFindEventsResult.getTotalPages());
    assertEquals(1L, actualFindEventsResult.getTotalElements());
    assertTrue(actualFindEventsResult.getData().isEmpty());
    assertTrue(actualFindEventsResult.hasNext());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code USER}.
   *   <li>Then Data first EntityId return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenUser_thenDataFirstEntityIdReturnUserId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.USER);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof UserId);
    assertEquals(EntityType.USER, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code WIDGET_TYPE}.
   *   <li>Then Data first EntityId return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenWidgetType_thenDataFirstEntityIdReturnWidgetTypeId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.WIDGET_TYPE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof WidgetTypeId);
    assertEquals(EntityType.WIDGET_TYPE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code WIDGETS_BUNDLE}.
   *   <li>Then Data first EntityId return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_givenWidgetsBundle_thenDataFirstEntityIdReturnWidgetsBundleId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.WIDGETS_BUNDLE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof WidgetsBundleId);
    assertEquals(EntityType.WIDGETS_BUNDLE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link NotificationRequestId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_thenDataFirstEntityIdReturnNotificationRequestId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION_REQUEST);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationRequestId);
    assertEquals(EntityType.NOTIFICATION_REQUEST, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link NotificationRuleId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_thenDataFirstEntityIdReturnNotificationRuleId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION_RULE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationRuleId);
    assertEquals(EntityType.NOTIFICATION_RULE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link NotificationTargetId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_thenDataFirstEntityIdReturnNotificationTargetId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION_TARGET);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationTargetId);
    assertEquals(EntityType.NOTIFICATION_TARGET, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link NotificationTemplateId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_thenDataFirstEntityIdReturnNotificationTemplateId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION_TEMPLATE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationTemplateId);
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_thenReturnEmpty_page_data() {
    // Arrange
    PageData<? extends Event> emptyPageDataResult = PageData.emptyPageData();
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            EventType.ERROR,
            new TimePageLink(3));

    // Assert
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    assertEquals(PageData.EMPTY_PAGE_DATA, actualFindEventsResult);
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then Data first EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_whenSystem_tenant_thenDataFirstEntityIdReturnCustomerId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof CustomerId);
    assertEquals(entityId, entityId2);
    assertSame(tenantId, getResult.getTenantId());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_whenSystem_tenant_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            EventType.ERROR,
            new TimePageLink(3));

    // Assert
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(2, data.size());
    EventInfo expectedGetResult = data.get(0);
    assertEquals(expectedGetResult, data.get(1));
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TotalPages is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  public void testFindEvents_whenSystem_tenant_thenReturnTotalPagesIsOne() {
    // Arrange
    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(new ArrayList<>());
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEvents(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventType>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            EventType.ERROR,
            new TimePageLink(3));

    // Assert
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    assertEquals(1, actualFindEventsResult.getTotalPages());
    assertEquals(1L, actualFindEventsResult.getTotalElements());
    assertTrue(actualFindEventsResult.getData().isEmpty());
    assertTrue(actualFindEventsResult.hasNext());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code ALARM}.
   *   <li>Then first EntityId return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenAlarm_thenFirstEntityIdReturnAlarmId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ALARM);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code API_USAGE_STATE}.
   *   <li>Then first EntityId return {@link ApiUsageStateId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenApiUsageState_thenFirstEntityIdReturnApiUsageStateId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.API_USAGE_STATE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof ApiUsageStateId);
    assertEquals(EntityType.API_USAGE_STATE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code ASSET_PROFILE}.
   *   <li>Then first EntityId return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenAssetProfile_thenFirstEntityIdReturnAssetProfileId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ASSET_PROFILE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AssetProfileId);
    assertEquals(EntityType.ASSET_PROFILE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code ASSET}.
   *   <li>Then first EntityId return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenAsset_thenFirstEntityIdReturnAssetId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ASSET);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AssetId);
    assertEquals(EntityType.ASSET, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code DASHBOARD}.
   *   <li>Then first EntityId return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenDashboard_thenFirstEntityIdReturnDashboardId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code DEVICE_PROFILE}.
   *   <li>Then first EntityId return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenDeviceProfile_thenFirstEntityIdReturnDeviceProfileId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DEVICE_PROFILE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DeviceProfileId);
    assertEquals(EntityType.DEVICE_PROFILE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code DEVICE}.
   *   <li>Then first EntityId return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenDevice_thenFirstEntityIdReturnDeviceId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DEVICE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DeviceId);
    assertEquals(EntityType.DEVICE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code DOMAIN}.
   *   <li>Then first EntityId return {@link DomainId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenDomain_thenFirstEntityIdReturnDomainId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DOMAIN);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DomainId);
    assertEquals(EntityType.DOMAIN, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code EDGE}.
   *   <li>Then first EntityId return {@link EdgeId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenEdge_thenFirstEntityIdReturnEdgeId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.EDGE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof EdgeId);
    assertEquals(EntityType.EDGE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code ENTITY_VIEW}.
   *   <li>Then first EntityId return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenEntityView_thenFirstEntityIdReturnEntityViewId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ENTITY_VIEW);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof EntityViewId);
    assertEquals(EntityType.ENTITY_VIEW, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code MOBILE_APP}.
   *   <li>Then first EntityId return {@link MobileAppId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenMobileApp_thenFirstEntityIdReturnMobileAppId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.MOBILE_APP);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof MobileAppId);
    assertEquals(EntityType.MOBILE_APP, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code NOTIFICATION}.
   *   <li>Then first EntityId return {@link NotificationId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenNotification_thenFirstEntityIdReturnNotificationId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationId);
    assertEquals(EntityType.NOTIFICATION, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenNull_uuid_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, EventType.ERROR, 1);

    // Assert
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertTrue(actualFindLatestEventsResult.isEmpty());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code OAUTH2_CLIENT}.
   *   <li>Then first EntityId return {@link OAuth2ClientId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenOauth2Client_thenFirstEntityIdReturnOAuth2ClientId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.OAUTH2_CLIENT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof OAuth2ClientId);
    assertEquals(EntityType.OAUTH2_CLIENT, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code OTA_PACKAGE}.
   *   <li>Then first EntityId return {@link OtaPackageId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenOtaPackage_thenFirstEntityIdReturnOtaPackageId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.OTA_PACKAGE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof OtaPackageId);
    assertEquals(EntityType.OTA_PACKAGE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code QUEUE_STATS}.
   *   <li>Then first EntityId return {@link QueueStatsId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenQueueStats_thenFirstEntityIdReturnQueueStatsId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.QUEUE_STATS);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof QueueStatsId);
    assertEquals(EntityType.QUEUE_STATS, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code QUEUE}.
   *   <li>Then first EntityId return {@link QueueId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenQueue_thenFirstEntityIdReturnQueueId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.QUEUE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof QueueId);
    assertEquals(EntityType.QUEUE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code RPC}.
   *   <li>Then first EntityId return {@link RpcId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenRpc_thenFirstEntityIdReturnRpcId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RPC);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RpcId);
    assertEquals(EntityType.RPC, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code RULE_CHAIN}.
   *   <li>Then first EntityId return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenRuleChain_thenFirstEntityIdReturnRuleChainId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_CHAIN);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RuleChainId);
    assertEquals(EntityType.RULE_CHAIN, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code RULE_NODE}.
   *   <li>Then first EntityId return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenRuleNode_thenFirstEntityIdReturnRuleNodeId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RuleNodeId);
    assertEquals(EntityType.RULE_NODE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code TB_RESOURCE}.
   *   <li>Then first EntityId return {@link TbResourceId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenTbResource_thenFirstEntityIdReturnTbResourceId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TB_RESOURCE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TbResourceId);
    assertEquals(EntityType.TB_RESOURCE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code TENANT_PROFILE}.
   *   <li>Then first EntityId return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenTenantProfile_thenFirstEntityIdReturnTenantProfileId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT_PROFILE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantProfileId);
    assertEquals(EntityType.TENANT_PROFILE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>Then return first TenantId is first EntityId.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenTenant_thenReturnFirstTenantIdIsFirstEntityId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertSame(entityId2, getResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, entityId2);
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>When {@link EntityId} {@link EntityId#getEntityType()} return {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenTenant_whenEntityIdGetEntityTypeReturnTenant() {
    // Arrange
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertTrue(actualFindLatestEventsResult.isEmpty());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code USER}.
   *   <li>Then first EntityId return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenUser_thenFirstEntityIdReturnUserId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.USER);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof UserId);
    assertEquals(EntityType.USER, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code WIDGET_TYPE}.
   *   <li>Then first EntityId return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenWidgetType_thenFirstEntityIdReturnWidgetTypeId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.WIDGET_TYPE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof WidgetTypeId);
    assertEquals(EntityType.WIDGET_TYPE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code WIDGETS_BUNDLE}.
   *   <li>Then first EntityId return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_givenWidgetsBundle_thenFirstEntityIdReturnWidgetsBundleId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.WIDGETS_BUNDLE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof WidgetsBundleId);
    assertEquals(EntityType.WIDGETS_BUNDLE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Then first EntityId return {@link NotificationRequestId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_thenFirstEntityIdReturnNotificationRequestId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION_REQUEST);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationRequestId);
    assertEquals(EntityType.NOTIFICATION_REQUEST, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Then first EntityId return {@link NotificationRuleId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_thenFirstEntityIdReturnNotificationRuleId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION_RULE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationRuleId);
    assertEquals(EntityType.NOTIFICATION_RULE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Then first EntityId return {@link NotificationTargetId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_thenFirstEntityIdReturnNotificationTargetId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION_TARGET);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationTargetId);
    assertEquals(EntityType.NOTIFICATION_TARGET, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Then first EntityId return {@link NotificationTemplateId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_thenFirstEntityIdReturnNotificationTemplateId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION_TEMPLATE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationTemplateId);
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then first EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_whenSystem_tenant_thenFirstEntityIdReturnCustomerId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(tenantId, entityId, EventType.ERROR, 1);

    // Assert
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof CustomerId);
    assertEquals(entityId, entityId2);
    assertSame(tenantId, getResult.getTenantId());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EventType.ERROR, 1);

    // Assert
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertTrue(actualFindLatestEventsResult.isEmpty());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  public void testFindLatestEvents_whenSystem_tenant_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EventType.ERROR, 1);

    // Assert
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(2, actualFindLatestEventsResult.size());
    EventInfo expectedGetResult = actualFindLatestEventsResult.get(0);
    assertEquals(expectedGetResult, actualFindLatestEventsResult.get(1));
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@code ASSET}.
   *   <li>Then EntityId return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  public void testFindLatestDebugRuleNodeInEvent_givenAsset_thenEntityIdReturnAssetId() {
    // Arrange
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.ASSET);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId2 instanceof AssetId);
    assertEquals(EntityType.ASSET, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@code DASHBOARD}.
   *   <li>Then EntityId return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  public void testFindLatestDebugRuleNodeInEvent_givenDashboard_thenEntityIdReturnDashboardId() {
    // Arrange
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.DASHBOARD);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId2 instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@code DEVICE}.
   *   <li>Then EntityId return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  public void testFindLatestDebugRuleNodeInEvent_givenDevice_thenEntityIdReturnDeviceId() {
    // Arrange
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.DEVICE);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId2 instanceof DeviceId);
    assertEquals(EntityType.DEVICE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@code RULE_CHAIN}.
   *   <li>Then EntityId return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  public void testFindLatestDebugRuleNodeInEvent_givenRuleChain_thenEntityIdReturnRuleChainId() {
    // Arrange
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_CHAIN);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId2 instanceof RuleChainId);
    assertEquals(EntityType.RULE_CHAIN, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@code RULE_NODE}.
   *   <li>Then EntityId return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  public void testFindLatestDebugRuleNodeInEvent_givenRuleNode_thenEntityIdReturnRuleNodeId() {
    // Arrange
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_NODE);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId2 instanceof RuleNodeId);
    assertEquals(EntityType.RULE_NODE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>Then return EntityId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  public void testFindLatestDebugRuleNodeInEvent_givenTenant_thenReturnEntityIdIsSys_tenant_id() {
    // Arrange
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    EntityId entityId2 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertSame(entityId2, actualFindLatestDebugRuleNodeInEventResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, entityId2);
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@code USER}.
   *   <li>Then EntityId return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  public void testFindLatestDebugRuleNodeInEvent_givenUser_thenEntityIdReturnUserId() {
    // Arrange
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.USER);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId2 instanceof UserId);
    assertEquals(EntityType.USER, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then EntityId return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  public void testFindLatestDebugRuleNodeInEvent_thenEntityIdReturnAlarmId() {
    // Arrange
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());
    AlarmId entityId = new AlarmId(ModelConstants.NULL_UUID);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    assertEquals(entityId, entityId2);
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  public void testFindLatestDebugRuleNodeInEvent_thenEntityIdReturnCustomerId() {
    // Arrange
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    assertTrue(actualFindLatestDebugRuleNodeInEventResult.getEntityId() instanceof CustomerId);
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  public void testFindLatestDebugRuleNodeInEvent_thenEntityIdReturnCustomerId2() {
    // Arrange
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    assertTrue(actualFindLatestDebugRuleNodeInEventResult.getEntityId() instanceof CustomerId);
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then EntityId return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  public void testFindLatestDebugRuleNodeInEvent_thenEntityIdReturnEntityViewId() {
    // Arrange
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.ENTITY_VIEW);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId2 instanceof EntityViewId);
    assertEquals(EntityType.ENTITY_VIEW, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then EntityId return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  public void testFindLatestDebugRuleNodeInEvent_thenEntityIdReturnTenantId() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    UUID entityId = UUID.randomUUID();
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            builderResult
                .entityId(entityId)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId2.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId2);

    // Assert
    verify(entityId2).getEntityType();
    verify(entityId2).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    EntityId entityId3 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId3 instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId3.getEntityType());
    assertFalse(entityId3.isNullUid());
    assertFalse(((TenantId) entityId3).isSysTenantId());
    assertSame(entityId, entityId3.getId());
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return EntityId is {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  public void testFindLatestDebugRuleNodeInEvent_thenReturnEntityIdIsSystem_tenant() {
    // Arrange
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            ErrorEvent.builder()
                .entityId(ModelConstants.NULL_UUID)
                .error("An error occurred")
                .id(ModelConstants.NULL_UUID)
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());
    TenantId entityId = ModelConstants.SYSTEM_TENANT;

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertSame(entityId2, actualFindLatestDebugRuleNodeInEventResult.getTenantId());
    assertSame(entityId, entityId2);
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter() {
    // Arrange
    PageData<? extends Event> pageData = new PageData<>(new ArrayList<>(), 4, 4L, true);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            eventFilter,
            new TimePageLink(3));

    // Assert
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    assertEquals(pageData, actualFindEventsByFilterResult);
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter2() {
    // Arrange
    PageData<? extends Event> pageData = new PageData<>(null, 4, 4L, true);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            eventFilter,
            new TimePageLink(3));

    // Assert
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    assertEquals(pageData, actualFindEventsByFilterResult);
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ALARM}.
   *   <li>Then Data first EntityId return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenAlarm_thenDataFirstEntityIdReturnAlarmId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ALARM);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ASSET}.
   *   <li>Then Data first EntityId return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenAsset_thenDataFirstEntityIdReturnAssetId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ASSET);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AssetId);
    assertEquals(EntityType.ASSET, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DASHBOARD}.
   *   <li>Then Data first EntityId return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenDashboard_thenDataFirstEntityIdReturnDashboardId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DEVICE}.
   *   <li>Then Data first EntityId return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenDevice_thenDataFirstEntityIdReturnDeviceId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DEVICE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DeviceId);
    assertEquals(EntityType.DEVICE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DOMAIN}.
   *   <li>Then Data first EntityId return {@link DomainId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenDomain_thenDataFirstEntityIdReturnDomainId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DOMAIN);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DomainId);
    assertEquals(EntityType.DOMAIN, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code EDGE}.
   *   <li>Then Data first EntityId return {@link EdgeId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenEdge_thenDataFirstEntityIdReturnEdgeId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.EDGE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof EdgeId);
    assertEquals(EntityType.EDGE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ENTITY_VIEW}.
   *   <li>Then Data first EntityId return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenEntityView_thenDataFirstEntityIdReturnEntityViewId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ENTITY_VIEW);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof EntityViewId);
    assertEquals(EntityType.ENTITY_VIEW, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code MOBILE_APP}.
   *   <li>Then Data first EntityId return {@link MobileAppId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenMobileApp_thenDataFirstEntityIdReturnMobileAppId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.MOBILE_APP);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof MobileAppId);
    assertEquals(EntityType.MOBILE_APP, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code OTA_PACKAGE}.
   *   <li>Then Data first EntityId return {@link OtaPackageId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenOtaPackage_thenDataFirstEntityIdReturnOtaPackageId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.OTA_PACKAGE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof OtaPackageId);
    assertEquals(EntityType.OTA_PACKAGE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code QUEUE_STATS}.
   *   <li>Then Data first EntityId return {@link QueueStatsId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenQueueStats_thenDataFirstEntityIdReturnQueueStatsId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.QUEUE_STATS);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof QueueStatsId);
    assertEquals(EntityType.QUEUE_STATS, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code QUEUE}.
   *   <li>Then Data first EntityId return {@link QueueId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenQueue_thenDataFirstEntityIdReturnQueueId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.QUEUE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof QueueId);
    assertEquals(EntityType.QUEUE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code RPC}.
   *   <li>Then Data first EntityId return {@link RpcId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenRpc_thenDataFirstEntityIdReturnRpcId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RPC);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RpcId);
    assertEquals(EntityType.RPC, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code RULE_CHAIN}.
   *   <li>Then Data first EntityId return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenRuleChain_thenDataFirstEntityIdReturnRuleChainId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_CHAIN);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RuleChainId);
    assertEquals(EntityType.RULE_CHAIN, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code RULE_NODE}.
   *   <li>Then Data first EntityId return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenRuleNode_thenDataFirstEntityIdReturnRuleNodeId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RuleNodeId);
    assertEquals(EntityType.RULE_NODE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code TB_RESOURCE}.
   *   <li>Then Data first EntityId return {@link TbResourceId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenTbResource_thenDataFirstEntityIdReturnTbResourceId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TB_RESOURCE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TbResourceId);
    assertEquals(EntityType.TB_RESOURCE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>When {@link EntityId} {@link EntityId#getEntityType()} return {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenTenant_whenEntityIdGetEntityTypeReturnTenant() {
    // Arrange
    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(new ArrayList<>());
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    assertEquals(1, actualFindEventsByFilterResult.getTotalPages());
    assertEquals(1L, actualFindEventsByFilterResult.getTotalElements());
    assertTrue(actualFindEventsByFilterResult.getData().isEmpty());
    assertTrue(actualFindEventsByFilterResult.hasNext());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code USER}.
   *   <li>Then Data first EntityId return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenUser_thenDataFirstEntityIdReturnUserId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.USER);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof UserId);
    assertEquals(EntityType.USER, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code WIDGET_TYPE}.
   *   <li>Then Data first EntityId return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_givenWidgetType_thenDataFirstEntityIdReturnWidgetTypeId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.WIDGET_TYPE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof WidgetTypeId);
    assertEquals(EntityType.WIDGET_TYPE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link ApiUsageStateId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_thenDataFirstEntityIdReturnApiUsageStateId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.API_USAGE_STATE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof ApiUsageStateId);
    assertEquals(EntityType.API_USAGE_STATE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_thenDataFirstEntityIdReturnAssetProfileId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ASSET_PROFILE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AssetProfileId);
    assertEquals(EntityType.ASSET_PROFILE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_thenDataFirstEntityIdReturnDeviceProfileId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DEVICE_PROFILE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DeviceProfileId);
    assertEquals(EntityType.DEVICE_PROFILE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link NotificationId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_thenDataFirstEntityIdReturnNotificationId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationId);
    assertEquals(EntityType.NOTIFICATION, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link NotificationRequestId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_thenDataFirstEntityIdReturnNotificationRequestId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION_REQUEST);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationRequestId);
    assertEquals(EntityType.NOTIFICATION_REQUEST, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link NotificationRuleId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_thenDataFirstEntityIdReturnNotificationRuleId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION_RULE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationRuleId);
    assertEquals(EntityType.NOTIFICATION_RULE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link NotificationTargetId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_thenDataFirstEntityIdReturnNotificationTargetId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION_TARGET);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationTargetId);
    assertEquals(EntityType.NOTIFICATION_TARGET, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link NotificationTemplateId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_thenDataFirstEntityIdReturnNotificationTemplateId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.NOTIFICATION_TEMPLATE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof NotificationTemplateId);
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link OAuth2ClientId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_thenDataFirstEntityIdReturnOAuth2ClientId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.OAUTH2_CLIENT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof OAuth2ClientId);
    assertEquals(EntityType.OAUTH2_CLIENT, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_thenDataFirstEntityIdReturnTenantProfileId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT_PROFILE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantProfileId);
    assertEquals(EntityType.TENANT_PROFILE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then Data first EntityId return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_thenDataFirstEntityIdReturnWidgetsBundleId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.WIDGETS_BUNDLE);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof WidgetsBundleId);
    assertEquals(EntityType.WIDGETS_BUNDLE, entityId2.getEntityType());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId is Data first EntityId.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_thenReturnDataFirstTenantIdIsDataFirstEntityId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertSame(entityId2, getResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, entityId2);
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_thenReturnEmpty_page_data() {
    // Arrange
    PageData<? extends Event> emptyPageDataResult = PageData.emptyPageData();
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            eventFilter,
            new TimePageLink(3));

    // Assert
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    assertEquals(PageData.EMPTY_PAGE_DATA, actualFindEventsByFilterResult);
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return TotalPages is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_whenNull_customer_id_thenReturnTotalPagesIsOne() {
    // Arrange
    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(new ArrayList<>());
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, eventFilter, new TimePageLink(3));

    // Assert
    verify(tenantId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    assertEquals(1, actualFindEventsByFilterResult.getTotalPages());
    assertEquals(1L, actualFindEventsByFilterResult.getTotalElements());
    assertTrue(actualFindEventsByFilterResult.getData().isEmpty());
    assertTrue(actualFindEventsByFilterResult.hasNext());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then Data first EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_whenSystem_tenant_thenDataFirstEntityIdReturnCustomerId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(tenantId, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    EventInfo getResult = data.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof CustomerId);
    assertEquals(entityId, entityId2);
    assertSame(tenantId, getResult.getTenantId());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_whenSystem_tenant_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    eventList.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(eventList);
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            eventFilter,
            new TimePageLink(3));

    // Assert
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(2, data.size());
    EventInfo expectedGetResult = data.get(0);
    assertEquals(expectedGetResult, data.get(1));
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TotalPages is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  public void testFindEventsByFilter_whenSystem_tenant_thenReturnTotalPagesIsOne() {
    // Arrange
    PageData<? extends Event> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    Mockito.<List<? extends Event>>when(pageData.getData()).thenReturn(new ArrayList<>());
    when(pageData.getTotalElements()).thenReturn(1L);
    Mockito.<PageData<? extends Event>>when(
            eventDao.findEventByFilter(
                Mockito.<UUID>any(),
                Mockito.<UUID>any(),
                Mockito.<EventFilter>any(),
                Mockito.<TimePageLink>any()))
        .thenReturn(pageData);
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            eventFilter,
            new TimePageLink(3));

    // Assert
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    assertEquals(1, actualFindEventsByFilterResult.getTotalPages());
    assertEquals(1L, actualFindEventsByFilterResult.getTotalElements());
    assertTrue(actualFindEventsByFilterResult.getData().isEmpty());
    assertTrue(actualFindEventsByFilterResult.hasNext());
  }

  /**
   * Test {@link BaseEventService#removeEvents(TenantId, EntityId, EventFilter, Long, Long)} with
   * {@code tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link BaseEventService#removeEvents(TenantId, EntityId, EventFilter,
   * Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseEventService.removeEvents(TenantId, EntityId, EventFilter, Long, Long)"
  })
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime() {
    // Arrange
    doNothing()
        .when(eventDao)
        .removeEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EventFilter>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any());

    // Act
    baseEventService.removeEvents(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        new ErrorEventFilter(),
        1L,
        1L);

    // Assert
    verify(eventDao)
        .removeEvents(isA(UUID.class), isA(UUID.class), isA(EventFilter.class), eq(1L), eq(1L));
  }

  /**
   * Test {@link BaseEventService#removeEvents(TenantId, EntityId, EventFilter, Long, Long)} with
   * {@code tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link BaseEventService#removeEvents(TenantId, EntityId, EventFilter,
   * Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseEventService.removeEvents(TenantId, EntityId, EventFilter, Long, Long)"
  })
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime2() {
    // Arrange
    doNothing()
        .when(eventDao)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    // Act
    baseEventService.removeEvents(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null, 1L, 1L);

    // Assert
    verify(eventDao).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
  }

  /**
   * Test {@link BaseEventService#removeEvents(TenantId, EntityId, EventFilter, Long, Long)} with
   * {@code tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#removeEvents(TenantId, EntityId, EventFilter,
   * Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseEventService.removeEvents(TenantId, EntityId, EventFilter, Long, Long)"
  })
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime_thenCallsGetId() {
    // Arrange
    doNothing()
        .when(eventDao)
        .removeEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EventFilter>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any());

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    baseEventService.removeEvents(
        ModelConstants.SYSTEM_TENANT, entityId, new ErrorEventFilter(), 1L, 1L);

    // Assert
    verify(entityId).getId();
    verify(eventDao)
        .removeEvents(isA(UUID.class), isA(UUID.class), isA(EventFilter.class), eq(1L), eq(1L));
  }

  /**
   * Test {@link BaseEventService#removeEvents(TenantId, EntityId, EventFilter, Long, Long)} with
   * {@code tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#removeEvents(TenantId, EntityId, EventFilter,
   * Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseEventService.removeEvents(TenantId, EntityId, EventFilter, Long, Long)"
  })
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime_thenCallsGetId2() {
    // Arrange
    doNothing()
        .when(eventDao)
        .removeEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EventFilter>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    baseEventService.removeEvents(tenantId, entityId, new ErrorEventFilter(), 1L, 1L);

    // Assert
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao)
        .removeEvents(isA(UUID.class), isA(UUID.class), isA(EventFilter.class), eq(1L), eq(1L));
  }

  /**
   * Test {@link BaseEventService#removeEvents(TenantId, EntityId, EventFilter, Long, Long)} with
   * {@code tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#removeEvents(TenantId, EntityId, EventFilter,
   * Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseEventService.removeEvents(TenantId, EntityId, EventFilter, Long, Long)"
  })
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime_thenCallsGetId3() {
    // Arrange
    doNothing()
        .when(eventDao)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    baseEventService.removeEvents(tenantId, entityId, null, 1L, 1L);

    // Assert
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
  }

  /**
   * Test {@link BaseEventService#removeEvents(TenantId, EntityId)} with {@code tenantId}, {@code
   * entityId}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#removeEvents(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseEventService.removeEvents(TenantId, EntityId)"})
  public void testRemoveEventsWithTenantIdEntityId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing()
        .when(eventDao)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    baseEventService.removeEvents(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getId();
    verify(eventDao).removeEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull());
  }

  /**
   * Test {@link BaseEventService#removeEvents(TenantId, EntityId)} with {@code tenantId}, {@code
   * entityId}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#removeEvents(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseEventService.removeEvents(TenantId, EntityId)"})
  public void testRemoveEventsWithTenantIdEntityId_thenCallsGetId() {
    // Arrange
    doNothing()
        .when(eventDao)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    baseEventService.removeEvents(tenantId, entityId);

    // Assert
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(eventDao).removeEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull());
  }

  /**
   * Test {@link BaseEventService#removeEvents(TenantId, EntityId)} with {@code tenantId}, {@code
   * entityId}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then calls {@link EventDao#removeEvents(UUID, UUID, Long, Long)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#removeEvents(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseEventService.removeEvents(TenantId, EntityId)"})
  public void testRemoveEventsWithTenantIdEntityId_whenNull_customer_id_thenCallsRemoveEvents() {
    // Arrange
    doNothing()
        .when(eventDao)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    // Act
    baseEventService.removeEvents(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(eventDao).removeEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull());
  }

  /**
   * Test {@link BaseEventService#cleanupEvents(long, long, boolean)}.
   *
   * <p>Method under test: {@link BaseEventService#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseEventService.cleanupEvents(long, long, boolean)"})
  public void testCleanupEvents() {
    // Arrange
    doNothing().when(eventDao).cleanupEvents(anyLong(), anyLong(), anyBoolean());

    // Act
    baseEventService.cleanupEvents(1L, 1L, true);

    // Assert
    verify(eventDao).cleanupEvents(1L, 1L, true);
  }
}
