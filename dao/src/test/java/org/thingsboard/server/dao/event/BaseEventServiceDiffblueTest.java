package org.thingsboard.server.dao.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.EventInfo;
import org.thingsboard.server.common.data.event.ErrorEvent;
import org.thingsboard.server.common.data.event.ErrorEvent.ErrorEventBuilder;
import org.thingsboard.server.common.data.event.ErrorEventFilter;
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.common.data.event.EventFilter;
import org.thingsboard.server.common.data.event.EventType;
import org.thingsboard.server.common.data.event.LifecycleEvent;
import org.thingsboard.server.common.data.event.LifecycleEvent.LifecycleEventBuilder;
import org.thingsboard.server.common.data.event.RuleNodeDebugEvent;
import org.thingsboard.server.common.data.event.RuleNodeDebugEvent.RuleNodeDebugEventBuilder;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseEventService.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class BaseEventServiceDiffblueTest {
  @Autowired private BaseEventService baseEventService;

  @MockBean private DataValidator<Event> dataValidator;

  @MockBean private EventDao eventDao;

  /**
   * Test {@link BaseEventService#saveAsync(Event)}.
   *
   * <p>Method under test: {@link BaseEventService#saveAsync(Event)}
   */
  @Test
  @DisplayName("Test saveAsync(Event)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEventService.saveAsync(Event)"})
  void testSaveAsync() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(eventDao.saveAsync(Mockito.<Event>any())).thenReturn(createResult);

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    when(dataValidator.validate(Mockito.<Event>any(), Mockito.<Function<Event, TenantId>>any()))
        .thenReturn(
            errorResult
                .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    ErrorEventBuilder builderResult2 = ErrorEvent.builder();

    ErrorEventBuilder errorResult2 =
        builderResult2
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");

    // Act
    ListenableFuture<Void> actualSaveAsyncResult =
        baseEventService.saveAsync(
            errorResult2
                .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
  @DisplayName("Test saveAsync(Event)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEventService.saveAsync(Event)"})
  void testSaveAsync2() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(eventDao.saveAsync(Mockito.<Event>any())).thenReturn(createResult);

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    when(dataValidator.validate(Mockito.<Event>any(), Mockito.<Function<Event, TenantId>>any()))
        .thenReturn(
            errorResult
                .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    LifecycleEventBuilder builderResult2 = LifecycleEvent.builder();

    LifecycleEventBuilder errorResult2 =
        builderResult2
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");

    // Act
    ListenableFuture<Void> actualSaveAsyncResult =
        baseEventService.saveAsync(
            errorResult2
                .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
                .lcEventType("Lc Event Type")
                .serviceId("42")
                .success(true)
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
  @DisplayName("Test saveAsync(Event)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEventService.saveAsync(Event)"})
  void testSaveAsync3() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(eventDao.saveAsync(Mockito.<Event>any())).thenReturn(createResult);

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    when(dataValidator.validate(Mockito.<Event>any(), Mockito.<Function<Event, TenantId>>any()))
        .thenReturn(
            errorResult
                .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    RuleNodeDebugEventBuilder dataTypeResult =
        RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");

    RuleNodeDebugEventBuilder eventTypeResult =
        dataTypeResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred")
            .eventEntity(BaseEntityService.NULL_CUSTOMER_ID)
            .eventType("Event Type");

    RuleNodeDebugEventBuilder metadataResult =
        eventTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .metadata("Metadata");

    // Act
    ListenableFuture<Void> actualSaveAsyncResult =
        baseEventService.saveAsync(
            metadataResult
                .msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
                .msgType("Msg Type")
                .relationType("Relation Type")
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
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @DisplayName("Test findEvents(TenantId, EntityId, EventType, TimePageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents() {
    // Arrange
    PageData<? extends Event> pageData = new PageData<>(new ArrayList<>(), 3, 3L, true);
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
  @DisplayName("Test findEvents(TenantId, EntityId, EventType, TimePageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents2() {
    // Arrange
    PageData<? extends Event> pageData = new PageData<>(null, 3, 3L, true);
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
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); given 'ALARM'; then Data first EntityId return AlarmId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_givenAlarm_thenDataFirstEntityIdReturnAlarmId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ALARM);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); given 'ASSET'; then Data first EntityId return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_givenAsset_thenDataFirstEntityIdReturnAssetId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ASSET);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AssetId);
    assertEquals(EntityType.ASSET, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); given 'DASHBOARD'; then Data first EntityId return DashboardId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_givenDashboard_thenDataFirstEntityIdReturnDashboardId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); given 'DEVICE'; then Data first EntityId return DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_givenDevice_thenDataFirstEntityIdReturnDeviceId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DEVICE);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DeviceId);
    assertEquals(EntityType.DEVICE, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); given 'ENTITY_VIEW'; then Data first EntityId return EntityViewId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_givenEntityView_thenDataFirstEntityIdReturnEntityViewId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ENTITY_VIEW);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof EntityViewId);
    assertEquals(EntityType.ENTITY_VIEW, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); given 'RULE_CHAIN'; then Data first EntityId return RuleChainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_givenRuleChain_thenDataFirstEntityIdReturnRuleChainId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_CHAIN);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RuleChainId);
    assertEquals(EntityType.RULE_CHAIN, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); given 'RULE_NODE'; then Data first EntityId return RuleNodeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_givenRuleNode_thenDataFirstEntityIdReturnRuleNodeId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RuleNodeId);
    assertEquals(EntityType.RULE_NODE, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>Then Data first EntityId return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); given 'TENANT'; then Data first EntityId return TenantId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_givenTenant_thenDataFirstEntityIdReturnTenantId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    assertTrue(entityId2 instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId2.getEntityType());
    assertFalse(((TenantId) entityId2).isSysTenantId());
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
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); given 'TENANT'; when EntityId getEntityType() return 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_givenTenant_whenEntityIdGetEntityTypeReturnTenant() {
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); given 'USER'; then Data first EntityId return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_givenUser_thenDataFirstEntityIdReturnUserId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.USER);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof UserId);
    assertEquals(EntityType.USER, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_thenReturnEmpty_page_data() {
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
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return TotalPages is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); when NULL_CUSTOMER_ID; then return TotalPages is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_whenNull_customer_id_thenReturnTotalPagesIsOne() {
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then Data first EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); when SYSTEM_TENANT; then Data first EntityId return CustomerId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_whenSystem_tenant_thenDataFirstEntityIdReturnCustomerId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, EventType.ERROR, new TimePageLink(3));

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
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof CustomerId);
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
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
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); when SYSTEM_TENANT; then return Data size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_whenSystem_tenant_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    ErrorEventBuilder builderResult2 = ErrorEvent.builder();

    ErrorEventBuilder errorResult2 =
        builderResult2
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult2
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); when SYSTEM_TENANT; then return TotalPages is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_whenSystem_tenant_thenReturnTotalPagesIsOne() {
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
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); given 'ALARM'; then first EntityId return AlarmId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_givenAlarm_thenFirstEntityIdReturnAlarmId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ALARM);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); given 'ASSET'; then first EntityId return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_givenAsset_thenFirstEntityIdReturnAssetId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ASSET);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AssetId);
    assertEquals(EntityType.ASSET, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); given 'DASHBOARD'; then first EntityId return DashboardId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_givenDashboard_thenFirstEntityIdReturnDashboardId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); given 'DEVICE'; then first EntityId return DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_givenDevice_thenFirstEntityIdReturnDeviceId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DEVICE);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DeviceId);
    assertEquals(EntityType.DEVICE, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); given 'ENTITY_VIEW'; then first EntityId return EntityViewId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_givenEntityView_thenFirstEntityIdReturnEntityViewId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ENTITY_VIEW);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof EntityViewId);
    assertEquals(EntityType.ENTITY_VIEW, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); given 'RULE_CHAIN'; then first EntityId return RuleChainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_givenRuleChain_thenFirstEntityIdReturnRuleChainId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_CHAIN);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RuleChainId);
    assertEquals(EntityType.RULE_CHAIN, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); given 'RULE_NODE'; then first EntityId return RuleNodeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_givenRuleNode_thenFirstEntityIdReturnRuleNodeId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RuleNodeId);
    assertEquals(EntityType.RULE_NODE, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>Then first EntityId return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); given 'TENANT'; then first EntityId return TenantId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_givenTenant_thenFirstEntityIdReturnTenantId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    assertTrue(entityId2 instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId2.getEntityType());
    assertFalse(((TenantId) entityId2).isSysTenantId());
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
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); given 'TENANT'; when EntityId getEntityType() return 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_givenTenant_whenEntityIdGetEntityTypeReturnTenant() {
    // Arrange
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); given 'USER'; then first EntityId return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_givenUser_thenFirstEntityIdReturnUserId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.USER);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof UserId);
    assertEquals(EntityType.USER, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); when NULL_CUSTOMER_ID; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then first EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); when SYSTEM_TENANT; then first EntityId return CustomerId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_whenSystem_tenant_thenFirstEntityIdReturnCustomerId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, EventType.ERROR, 1);

    // Assert
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    EventInfo getResult = actualFindLatestEventsResult.get(0);
    JsonNode body = getResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof CustomerId);
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
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
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); when SYSTEM_TENANT; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_whenSystem_tenant_thenReturnEmpty() {
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
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); when SYSTEM_TENANT; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_whenSystem_tenant_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    ErrorEventBuilder builderResult2 = ErrorEvent.builder();

    ErrorEventBuilder errorResult2 =
        builderResult2
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult2
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName("Test findLatestDebugRuleNodeInEvent(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  void testFindLatestDebugRuleNodeInEvent() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            errorResult
                .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
                .method("Method")
                .serviceId("")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

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
    assertTrue(entityId2 instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId2.getEntityType());
    assertFalse(((TenantId) entityId2).isSysTenantId());
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
  @DisplayName(
      "Test findLatestDebugRuleNodeInEvent(TenantId, EntityId); given 'ASSET'; then EntityId return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  void testFindLatestDebugRuleNodeInEvent_givenAsset_thenEntityIdReturnAssetId() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    ErrorEventBuilder errorResult = builderResult.entityId(entityId).error("An error occurred");
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            errorResult
                .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId2.getEntityType()).thenReturn(EntityType.ASSET);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId2);

    // Assert
    verify(entityId2).getEntityType();
    verify(entityId2).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId3 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId3 instanceof AssetId);
    assertEquals(EntityType.ASSET, entityId3.getEntityType());
    assertSame(entityId, entityId3.getId());
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
  @DisplayName(
      "Test findLatestDebugRuleNodeInEvent(TenantId, EntityId); given 'DASHBOARD'; then EntityId return DashboardId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  void testFindLatestDebugRuleNodeInEvent_givenDashboard_thenEntityIdReturnDashboardId() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    ErrorEventBuilder errorResult = builderResult.entityId(entityId).error("An error occurred");
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            errorResult
                .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId2.getEntityType()).thenReturn(EntityType.DASHBOARD);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId2);

    // Assert
    verify(entityId2).getEntityType();
    verify(entityId2).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId3 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId3 instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, entityId3.getEntityType());
    assertSame(entityId, entityId3.getId());
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
  @DisplayName(
      "Test findLatestDebugRuleNodeInEvent(TenantId, EntityId); given 'DEVICE'; then EntityId return DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  void testFindLatestDebugRuleNodeInEvent_givenDevice_thenEntityIdReturnDeviceId() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    ErrorEventBuilder errorResult = builderResult.entityId(entityId).error("An error occurred");
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            errorResult
                .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId2.getEntityType()).thenReturn(EntityType.DEVICE);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId2);

    // Assert
    verify(entityId2).getEntityType();
    verify(entityId2).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId3 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId3 instanceof DeviceId);
    assertEquals(EntityType.DEVICE, entityId3.getEntityType());
    assertSame(entityId, entityId3.getId());
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
  @DisplayName(
      "Test findLatestDebugRuleNodeInEvent(TenantId, EntityId); given 'RULE_CHAIN'; then EntityId return RuleChainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  void testFindLatestDebugRuleNodeInEvent_givenRuleChain_thenEntityIdReturnRuleChainId() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    ErrorEventBuilder errorResult = builderResult.entityId(entityId).error("An error occurred");
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            errorResult
                .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId2.getEntityType()).thenReturn(EntityType.RULE_CHAIN);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId2);

    // Assert
    verify(entityId2).getEntityType();
    verify(entityId2).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId3 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId3 instanceof RuleChainId);
    assertEquals(EntityType.RULE_CHAIN, entityId3.getEntityType());
    assertSame(entityId, entityId3.getId());
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
  @DisplayName(
      "Test findLatestDebugRuleNodeInEvent(TenantId, EntityId); given 'RULE_NODE'; then EntityId return RuleNodeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  void testFindLatestDebugRuleNodeInEvent_givenRuleNode_thenEntityIdReturnRuleNodeId() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    ErrorEventBuilder errorResult = builderResult.entityId(entityId).error("An error occurred");
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            errorResult
                .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId2.getEntityType()).thenReturn(EntityType.RULE_NODE);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId2);

    // Assert
    verify(entityId2).getEntityType();
    verify(entityId2).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId3 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId3 instanceof RuleNodeId);
    assertEquals(EntityType.RULE_NODE, entityId3.getEntityType());
    assertSame(entityId, entityId3.getId());
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>Then EntityId return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test findLatestDebugRuleNodeInEvent(TenantId, EntityId); given 'TENANT'; then EntityId return TenantId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  void testFindLatestDebugRuleNodeInEvent_givenTenant_thenEntityIdReturnTenantId() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            errorResult
                .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

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
    assertTrue(entityId2 instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId2.getEntityType());
    assertFalse(((TenantId) entityId2).isSysTenantId());
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
  @DisplayName(
      "Test findLatestDebugRuleNodeInEvent(TenantId, EntityId); given 'USER'; then EntityId return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  void testFindLatestDebugRuleNodeInEvent_givenUser_thenEntityIdReturnUserId() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    ErrorEventBuilder errorResult = builderResult.entityId(entityId).error("An error occurred");
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            errorResult
                .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId2.getEntityType()).thenReturn(EntityType.USER);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(tenantId, entityId2);

    // Assert
    verify(entityId2).getEntityType();
    verify(entityId2).getId();
    verify(tenantId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    JsonNode body = actualFindLatestDebugRuleNodeInEventResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId3 = actualFindLatestDebugRuleNodeInEventResult.getEntityId();
    assertTrue(entityId3 instanceof UserId);
    assertEquals(EntityType.USER, entityId3.getEntityType());
    assertSame(entityId, entityId3.getId());
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return EntityId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test findLatestDebugRuleNodeInEvent(TenantId, EntityId); then return EntityId Id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  void testFindLatestDebugRuleNodeInEvent_thenReturnEntityIdIdIsRandomUUID() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    UUID entityId = UUID.randomUUID();

    ErrorEventBuilder errorResult = builderResult.entityId(entityId).error("An error occurred");
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(
            errorResult
                .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
                .method("Method")
                .serviceId("42")
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .ts(1L)
                .build());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    assertFalse(((TenantId) entityId3).isSysTenantId());
    assertSame(entityId, entityId3.getId());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @DisplayName("Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter() {
    // Arrange
    PageData<? extends Event> pageData = new PageData<>(new ArrayList<>(), 3, 3L, true);
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
  @DisplayName("Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter2() {
    // Arrange
    PageData<? extends Event> pageData = new PageData<>(null, 3, 3L, true);
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
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); given 'ALARM'; then Data first EntityId return AlarmId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_givenAlarm_thenDataFirstEntityIdReturnAlarmId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ALARM);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); given 'ASSET'; then Data first EntityId return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_givenAsset_thenDataFirstEntityIdReturnAssetId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ASSET);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof AssetId);
    assertEquals(EntityType.ASSET, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); given 'DASHBOARD'; then Data first EntityId return DashboardId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_givenDashboard_thenDataFirstEntityIdReturnDashboardId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); given 'DEVICE'; then Data first EntityId return DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_givenDevice_thenDataFirstEntityIdReturnDeviceId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DEVICE);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof DeviceId);
    assertEquals(EntityType.DEVICE, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); given 'ENTITY_VIEW'; then Data first EntityId return EntityViewId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_givenEntityView_thenDataFirstEntityIdReturnEntityViewId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ENTITY_VIEW);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof EntityViewId);
    assertEquals(EntityType.ENTITY_VIEW, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); given 'RULE_CHAIN'; then Data first EntityId return RuleChainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_givenRuleChain_thenDataFirstEntityIdReturnRuleChainId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_CHAIN);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RuleChainId);
    assertEquals(EntityType.RULE_CHAIN, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); given 'RULE_NODE'; then Data first EntityId return RuleNodeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_givenRuleNode_thenDataFirstEntityIdReturnRuleNodeId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof RuleNodeId);
    assertEquals(EntityType.RULE_NODE, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>Then Data first EntityId return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); given 'TENANT'; then Data first EntityId return TenantId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_givenTenant_thenDataFirstEntityIdReturnTenantId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    assertTrue(entityId2 instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId2.getEntityType());
    assertFalse(((TenantId) entityId2).isSysTenantId());
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
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); given 'TENANT'; when EntityId getEntityType() return 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_givenTenant_whenEntityIdGetEntityTypeReturnTenant() {
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); given 'USER'; then Data first EntityId return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_givenUser_thenDataFirstEntityIdReturnUserId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.USER);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof UserId);
    assertEquals(EntityType.USER, entityId2.getEntityType());
    assertTrue(iteratorResult.hasNext());
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
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_thenReturnEmpty_page_data() {
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
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); when NULL_CUSTOMER_ID; then return TotalPages is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_whenNull_customer_id_thenReturnTotalPagesIsOne() {
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); when SYSTEM_TENANT; then Data first EntityId return CustomerId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_whenSystem_tenant_thenDataFirstEntityIdReturnCustomerId() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, eventFilter, new TimePageLink(3));

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
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof CustomerId);
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
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
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); when SYSTEM_TENANT; then return Data size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_whenSystem_tenant_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<Event> eventList = new ArrayList<>();

    ErrorEventBuilder builderResult = ErrorEvent.builder();

    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    ErrorEventBuilder builderResult2 = ErrorEvent.builder();

    ErrorEventBuilder errorResult2 =
        builderResult2
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    eventList.add(
        errorResult2
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); when SYSTEM_TENANT; then return TotalPages is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_whenSystem_tenant_thenReturnTotalPagesIsOne() {
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
  @DisplayName(
      "Test removeEvents(TenantId, EntityId, EventFilter, Long, Long) with 'tenantId', 'entityId', 'eventFilter', 'startTime', 'endTime'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseEventService.removeEvents(TenantId, EntityId, EventFilter, Long, Long)"
  })
  void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime() {
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
  @DisplayName(
      "Test removeEvents(TenantId, EntityId, EventFilter, Long, Long) with 'tenantId', 'entityId', 'eventFilter', 'startTime', 'endTime'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseEventService.removeEvents(TenantId, EntityId, EventFilter, Long, Long)"
  })
  void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime2() {
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
  @DisplayName(
      "Test removeEvents(TenantId, EntityId, EventFilter, Long, Long) with 'tenantId', 'entityId', 'eventFilter', 'startTime', 'endTime'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseEventService.removeEvents(TenantId, EntityId, EventFilter, Long, Long)"
  })
  void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime_thenCallsGetId() {
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
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test removeEvents(TenantId, EntityId, EventFilter, Long, Long) with 'tenantId', 'entityId', 'eventFilter', 'startTime', 'endTime'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseEventService.removeEvents(TenantId, EntityId, EventFilter, Long, Long)"
  })
  void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime_thenCallsGetId2() {
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test removeEvents(TenantId, EntityId, EventFilter, Long, Long) with 'tenantId', 'entityId', 'eventFilter', 'startTime', 'endTime'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseEventService.removeEvents(TenantId, EntityId, EventFilter, Long, Long)"
  })
  void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime_thenCallsGetId3() {
    // Arrange
    doNothing()
        .when(eventDao)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#removeEvents(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test removeEvents(TenantId, EntityId) with 'tenantId', 'entityId'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseEventService.removeEvents(TenantId, EntityId)"})
  void testRemoveEventsWithTenantIdEntityId_thenCallsGetId() {
    // Arrange
    doNothing()
        .when(eventDao)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test removeEvents(TenantId, EntityId) with 'tenantId', 'entityId'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseEventService.removeEvents(TenantId, EntityId)"})
  void testRemoveEventsWithTenantIdEntityId_thenCallsGetId2() {
    // Arrange
    doNothing()
        .when(eventDao)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test removeEvents(TenantId, EntityId) with 'tenantId', 'entityId'; when NULL_CUSTOMER_ID; then calls removeEvents(UUID, UUID, Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseEventService.removeEvents(TenantId, EntityId)"})
  void testRemoveEventsWithTenantIdEntityId_whenNull_customer_id_thenCallsRemoveEvents() {
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
  @DisplayName("Test cleanupEvents(long, long, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseEventService.cleanupEvents(long, long, boolean)"})
  void testCleanupEvents() {
    // Arrange
    doNothing().when(eventDao).cleanupEvents(anyLong(), anyLong(), anyBoolean());

    // Act
    baseEventService.cleanupEvents(1L, 1L, true);

    // Assert
    verify(eventDao).cleanupEvents(1L, 1L, true);
  }
}
