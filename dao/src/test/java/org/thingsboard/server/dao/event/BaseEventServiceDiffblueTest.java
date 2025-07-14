package org.thingsboard.server.dao.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
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
import org.thingsboard.server.common.data.event.ErrorEventFilter;
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.common.data.event.EventFilter;
import org.thingsboard.server.common.data.event.EventType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
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
   * <ul>
   *   <li>Given {@link EventDao} {@link EventDao#saveAsync(Event)} return create.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#saveAsync(Event)}
   */
  @Test
  @DisplayName(
      "Test saveAsync(Event); given EventDao saveAsync(Event) return create; then return SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture BaseEventService.saveAsync(Event)"})
  void testSaveAsync_givenEventDaoSaveAsyncReturnCreate_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(eventDao.saveAsync(Mockito.<Event>any())).thenReturn(createResult);
    when(dataValidator.validate(Mockito.<Event>any(), Mockito.<Function<Event, TenantId>>any()))
        .thenReturn(null);
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
  @DisplayName("Test findEvents(TenantId, EntityId, EventType, TimePageLink)")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>Given {@code DOMAIN}.
   *   <li>Then calls {@link EntityId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); given 'DOMAIN'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_givenDomain_thenCallsGetEntityType() {
    // Arrange
    Event event = mock(Event.class);
    EventInfo eventInfo = new EventInfo();
    when(event.toInfo(Mockito.<EntityType>any())).thenReturn(eventInfo);
    Event event2 = mock(Event.class);
    when(event2.toInfo(Mockito.<EntityType>any())).thenReturn(new EventInfo());

    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(event2);
    eventList.add(event);
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
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DOMAIN);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    PageData<EventInfo> actualFindEventsResult =
        baseEventService.findEvents(
            ModelConstants.SYSTEM_TENANT, entityId, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(event2).toInfo(eq(EntityType.DOMAIN));
    verify(event).toInfo(eq(EntityType.DOMAIN));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(2, data.size());
    assertSame(eventInfo, data.get(1));
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@link Event} {@link Event#toInfo(EntityType)} return {@link
   *       EventInfo#EventInfo()}.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); given Event toInfo(EntityType) return EventInfo(); then return Data size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_givenEventToInfoReturnEventInfo_thenReturnDataSizeIsOne() {
    // Arrange
    Event event = mock(Event.class);
    EventInfo eventInfo = new EventInfo();
    when(event.toInfo(Mockito.<EntityType>any())).thenReturn(eventInfo);

    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(event);
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
    verify(event).toInfo(eq(EntityType.CUSTOMER));
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    assertSame(eventInfo, data.get(0));
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@link Event} {@link Event#toInfo(EntityType)} return {@link
   *       EventInfo#EventInfo()}.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); given Event toInfo(EntityType) return EventInfo(); then return Data size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_givenEventToInfoReturnEventInfo_thenReturnDataSizeIsTwo() {
    // Arrange
    Event event = mock(Event.class);
    EventInfo eventInfo = new EventInfo();
    when(event.toInfo(Mockito.<EntityType>any())).thenReturn(eventInfo);
    Event event2 = mock(Event.class);
    when(event2.toInfo(Mockito.<EntityType>any())).thenReturn(new EventInfo());

    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(event2);
    eventList.add(event);
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
    verify(event2).toInfo(eq(EntityType.CUSTOMER));
    verify(event).toInfo(eq(EntityType.CUSTOMER));
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsResult.getData();
    assertEquals(2, data.size());
    assertSame(eventInfo, data.get(1));
  }

  /**
   * Test {@link BaseEventService#findEvents(TenantId, EntityId, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code true}.
   *   <li>Then return TotalPages is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEvents(TenantId, EntityId, EventType,
   * TimePageLink)}
   */
  @Test
  @DisplayName(
      "Test findEvents(TenantId, EntityId, EventType, TimePageLink); given PageData hasNext() return 'true'; then return TotalPages is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PageData BaseEventService.findEvents(TenantId, EntityId, EventType, TimePageLink)"
  })
  void testFindEvents_givenPageDataHasNextReturnTrue_thenReturnTotalPagesIsOne() {
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
  @Tag("MaintainedByDiffblue")
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
    assertEquals(actualFindEventsResult.EMPTY_PAGE_DATA, actualFindEventsResult);
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@code DOMAIN}.
   *   <li>Then calls {@link EntityId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); given 'DOMAIN'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_givenDomain_thenCallsGetEntityType() {
    // Arrange
    Event event = mock(Event.class);
    EventInfo eventInfo = new EventInfo();
    when(event.toInfo(Mockito.<EntityType>any())).thenReturn(eventInfo);
    Event event2 = mock(Event.class);
    when(event2.toInfo(Mockito.<EntityType>any())).thenReturn(new EventInfo());

    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(event2);
    eventList.add(event);
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DOMAIN);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(
            ModelConstants.SYSTEM_TENANT, entityId, EventType.ERROR, 1);

    // Assert
    verify(event2).toInfo(eq(EntityType.DOMAIN));
    verify(event).toInfo(eq(EntityType.DOMAIN));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(2, actualFindLatestEventsResult.size());
    assertSame(eventInfo, actualFindLatestEventsResult.get(1));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_whenNull_customer_id_thenReturnEmpty() {
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
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); when NULL_CUSTOMER_ID; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_whenNull_customer_id_thenReturnSizeIsOne() {
    // Arrange
    Event event = mock(Event.class);
    EventInfo eventInfo = new EventInfo();
    when(event.toInfo(Mockito.<EntityType>any())).thenReturn(eventInfo);

    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(event);
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EventType.ERROR, 1);

    // Assert
    verify(event).toInfo(eq(EntityType.CUSTOMER));
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    assertSame(eventInfo, actualFindLatestEventsResult.get(0));
  }

  /**
   * Test {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType, int)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestEvents(TenantId, EntityId, EventType,
   * int)}
   */
  @Test
  @DisplayName(
      "Test findLatestEvents(TenantId, EntityId, EventType, int); when NULL_CUSTOMER_ID; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseEventService.findLatestEvents(TenantId, EntityId, EventType, int)"})
  void testFindLatestEvents_whenNull_customer_id_thenReturnSizeIsTwo() {
    // Arrange
    Event event = mock(Event.class);
    EventInfo eventInfo = new EventInfo();
    when(event.toInfo(Mockito.<EntityType>any())).thenReturn(eventInfo);
    Event event2 = mock(Event.class);
    when(event2.toInfo(Mockito.<EntityType>any())).thenReturn(new EventInfo());

    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(event2);
    eventList.add(event);
    Mockito.<List<? extends Event>>when(
            eventDao.findLatestEvents(
                Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EventType>any(), anyInt()))
        .thenReturn(eventList);

    // Act
    List<EventInfo> actualFindLatestEventsResult =
        baseEventService.findLatestEvents(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EventType.ERROR, 1);

    // Assert
    verify(event2).toInfo(eq(EntityType.CUSTOMER));
    verify(event).toInfo(eq(EntityType.CUSTOMER));
    verify(eventDao).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(EventType.ERROR), eq(1));
    assertEquals(2, actualFindLatestEventsResult.size());
    assertSame(eventInfo, actualFindLatestEventsResult.get(1));
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test findLatestDebugRuleNodeInEvent(TenantId, EntityId); then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  void testFindLatestDebugRuleNodeInEvent_thenCallsGetEntityType() {
    // Arrange
    Event event = mock(Event.class);
    EventInfo eventInfo = new EventInfo();
    when(event.toInfo(Mockito.<EntityType>any())).thenReturn(eventInfo);
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(event);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(event).toInfo(eq(EntityType.TENANT));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    assertSame(eventInfo, actualFindLatestDebugRuleNodeInEventResult);
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName("Test findLatestDebugRuleNodeInEvent(TenantId, EntityId); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  void testFindLatestDebugRuleNodeInEvent_thenReturnNull() {
    // Arrange
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(null);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    assertNull(actualFindLatestDebugRuleNodeInEventResult);
  }

  /**
   * Test {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@link EventInfo#EventInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findLatestDebugRuleNodeInEvent(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test findLatestDebugRuleNodeInEvent(TenantId, EntityId); when NULL_CUSTOMER_ID; then return EventInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EventInfo BaseEventService.findLatestDebugRuleNodeInEvent(TenantId, EntityId)"
  })
  void testFindLatestDebugRuleNodeInEvent_whenNull_customer_id_thenReturnEventInfo() {
    // Arrange
    Event event = mock(Event.class);
    EventInfo eventInfo = new EventInfo();
    when(event.toInfo(Mockito.<EntityType>any())).thenReturn(eventInfo);
    when(eventDao.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(event);

    // Act
    EventInfo actualFindLatestDebugRuleNodeInEventResult =
        baseEventService.findLatestDebugRuleNodeInEvent(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(event).toInfo(eq(EntityType.CUSTOMER));
    verify(eventDao).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    assertSame(eventInfo, actualFindLatestDebugRuleNodeInEventResult);
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>Given {@code DOMAIN}.
   *   <li>Then calls {@link EntityId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); given 'DOMAIN'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_givenDomain_thenCallsGetEntityType() {
    // Arrange
    Event event = mock(Event.class);
    EventInfo eventInfo = new EventInfo();
    when(event.toInfo(Mockito.<EntityType>any())).thenReturn(eventInfo);
    Event event2 = mock(Event.class);
    when(event2.toInfo(Mockito.<EntityType>any())).thenReturn(new EventInfo());

    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(event2);
    eventList.add(event);
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
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DOMAIN);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<EventInfo> actualFindEventsByFilterResult =
        baseEventService.findEventsByFilter(
            ModelConstants.SYSTEM_TENANT, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(event2).toInfo(eq(EntityType.DOMAIN));
    verify(event).toInfo(eq(EntityType.DOMAIN));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(2, data.size());
    assertSame(eventInfo, data.get(1));
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@link Event} {@link Event#toInfo(EntityType)} return {@link
   *       EventInfo#EventInfo()}.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); given Event toInfo(EntityType) return EventInfo(); then return Data size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_givenEventToInfoReturnEventInfo_thenReturnDataSizeIsOne() {
    // Arrange
    Event event = mock(Event.class);
    EventInfo eventInfo = new EventInfo();
    when(event.toInfo(Mockito.<EntityType>any())).thenReturn(eventInfo);

    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(event);
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
    verify(event).toInfo(eq(EntityType.CUSTOMER));
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(1, data.size());
    assertSame(eventInfo, data.get(0));
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@link Event} {@link Event#toInfo(EntityType)} return {@link
   *       EventInfo#EventInfo()}.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); given Event toInfo(EntityType) return EventInfo(); then return Data size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_givenEventToInfoReturnEventInfo_thenReturnDataSizeIsTwo() {
    // Arrange
    Event event = mock(Event.class);
    EventInfo eventInfo = new EventInfo();
    when(event.toInfo(Mockito.<EntityType>any())).thenReturn(eventInfo);
    Event event2 = mock(Event.class);
    when(event2.toInfo(Mockito.<EntityType>any())).thenReturn(new EventInfo());

    ArrayList<Event> eventList = new ArrayList<>();
    eventList.add(event2);
    eventList.add(event);
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
    verify(event2).toInfo(eq(EntityType.CUSTOMER));
    verify(event).toInfo(eq(EntityType.CUSTOMER));
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(eventDao)
        .findEventByFilter(
            isA(UUID.class), isA(UUID.class), isA(EventFilter.class), isA(TimePageLink.class));
    List<EventInfo> data = actualFindEventsByFilterResult.getData();
    assertEquals(2, data.size());
    assertSame(eventInfo, data.get(1));
  }

  /**
   * Test {@link BaseEventService#findEventsByFilter(TenantId, EntityId, EventFilter,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code true}.
   *   <li>Then return TotalPages is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#findEventsByFilter(TenantId, EntityId,
   * EventFilter, TimePageLink)}
   */
  @Test
  @DisplayName(
      "Test findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink); given PageData hasNext() return 'true'; then return TotalPages is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PageData BaseEventService.findEventsByFilter(TenantId, EntityId, EventFilter, TimePageLink)"
  })
  void testFindEventsByFilter_givenPageDataHasNextReturnTrue_thenReturnTotalPagesIsOne() {
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
  @Tag("MaintainedByDiffblue")
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
    assertEquals(actualFindEventsByFilterResult.EMPTY_PAGE_DATA, actualFindEventsByFilterResult);
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void BaseEventService.removeEvents(TenantId, EntityId, EventFilter, Long, Long)"
  })
  void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime2() {
    // Arrange
    doNothing()
        .when(eventDao)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    baseEventService.removeEvents(ModelConstants.SYSTEM_TENANT, entityId, null, 1L, 1L);

    // Assert
    verify(entityId).getId();
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then calls {@link EventDao#removeEvents(UUID, UUID, Long, Long)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEventService#removeEvents(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test removeEvents(TenantId, EntityId) with 'tenantId', 'entityId'; when NULL_CUSTOMER_ID; then calls removeEvents(UUID, UUID, Long, Long)")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseEventService.cleanupEvents(long, long, boolean)"})
  void testCleanupEvents() {
    // Arrange
    doNothing().when(eventDao).cleanupEvents(anyLong(), anyLong(), anyBoolean());

    // Act
    baseEventService.cleanupEvents(1L, 1L, true);

    // Assert
    verify(eventDao).cleanupEvents(eq(1L), eq(1L), eq(true));
  }
}
