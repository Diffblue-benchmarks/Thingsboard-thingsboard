package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.EntityData;
import org.thingsboard.server.common.data.query.EntityDataPageLink;
import org.thingsboard.server.common.data.query.EntityDataQuery;
import org.thingsboard.server.common.data.query.EntityDataSortOrder;
import org.thingsboard.server.common.data.query.EntityFilter;
import org.thingsboard.server.common.data.query.EntityKey;
import org.thingsboard.server.common.data.query.EntityKeyType;
import org.thingsboard.server.common.data.query.TsValue;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.entity.EntityService;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.ws.WebSocketService;
import org.thingsboard.server.service.ws.WebSocketSessionRef;

class TbAbstractDataSubCtxDiffblueTest {
  /**
   * Test {@link TbAbstractDataSubCtx#findEntityData()}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractDataSubCtx#findEntityData()}
   */
  @Test
  @DisplayName("Test findEntityData(); then return EMPTY_PAGE_DATA")
  void testFindEntityData_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityService entityService = mock(EntityService.class);
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(entityService.findEntityDataByQuery(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<EntityDataQuery>any())).thenReturn(emptyPageDataResult);
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());

    // Act
    PageData<EntityData> actualFindEntityDataResult = (new TbEntityDataSubCtx("42", mock(WebSocketService.class),
        entityService, mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1, 3)).findEntityData();

    // Assert
    verify(entityService).findEntityDataByQuery(isNull(), isNull(), isNull());
    verify(sessionRef, atLeast(1)).getSecurityCtx();
    assertSame(actualFindEntityDataResult.EMPTY_PAGE_DATA, actualFindEntityDataResult);
  }

  /**
   * Test {@link TbAbstractDataSubCtx#isDynamic()}.
   * <p>
   * Method under test: {@link TbAbstractDataSubCtx#isDynamic()}
   */
  @Test
  @DisplayName("Test isDynamic()")
  void testIsDynamic() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TbEntityDataSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
        mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1, 3)).isDynamic());
  }

  /**
   * Test {@link TbAbstractDataSubCtx#isDynamic()}.
   * <p>
   * Method under test: {@link TbAbstractDataSubCtx#isDynamic()}
   */
  @Test
  @DisplayName("Test isDynamic()")
  void testIsDynamic2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());

    TbEntityDataSubCtx tbEntityDataSubCtx = new TbEntityDataSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1, 3);
    EntityFilter entityFilter = mock(EntityFilter.class);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    tbEntityDataSubCtx
        .setAndResolveQuery(new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Act
    boolean actualIsDynamicResult = tbEntityDataSubCtx.isDynamic();

    // Assert
    verify(sessionRef, atLeast(1)).getSecurityCtx();
    assertFalse(actualIsDynamicResult);
  }

  /**
   * Test {@link TbAbstractDataSubCtx#isDynamic()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractDataSubCtx#isDynamic()}
   */
  @Test
  @DisplayName("Test isDynamic(); then return 'true'")
  void testIsDynamic_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());

    TbEntityDataSubCtx tbEntityDataSubCtx = new TbEntityDataSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1, 3);
    EntityFilter entityFilter = mock(EntityFilter.class);
    EntityDataPageLink pageLink = new EntityDataPageLink(3, 3, "Text Search", new EntityDataSortOrder(), true);

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    tbEntityDataSubCtx
        .setAndResolveQuery(new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Act
    boolean actualIsDynamicResult = tbEntityDataSubCtx.isDynamic();

    // Assert
    verify(sessionRef, atLeast(1)).getSecurityCtx();
    assertTrue(actualIsDynamicResult);
  }

  /**
   * Test {@link TbAbstractDataSubCtx#update()}.
   * <ul>
   *   <li>Then calls
   * {@link EntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractDataSubCtx#update()}
   */
  @Test
  @DisplayName("Test update(); then calls findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)")
  void testUpdate_thenCallsFindEntityDataByQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityService entityService = mock(EntityService.class);
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(entityService.findEntityDataByQuery(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<EntityDataQuery>any())).thenReturn(emptyPageDataResult);
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenReturn("42");
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());

    // Act
    (new TbEntityDataSubCtx("42", mock(WebSocketService.class), entityService, mock(TbLocalSubscriptionService.class),
        mock(AttributesService.class), mock(SubscriptionServiceStatistics.class), sessionRef, 1, 3)).update();

    // Assert
    verify(entityService).findEntityDataByQuery(isNull(), isNull(), isNull());
    verify(sessionRef, atLeast(1)).getSecurityCtx();
    verify(sessionRef).getSessionId();
  }

  /**
   * Test {@link TbAbstractDataSubCtx#getEntityKeyByTypeMap(List)}.
   * <ul>
   *   <li>Then return {@code ATTRIBUTE} is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractDataSubCtx#getEntityKeyByTypeMap(List)}
   */
  @Test
  @DisplayName("Test getEntityKeyByTypeMap(List); then return 'ATTRIBUTE' is ArrayList()")
  void testGetEntityKeyByTypeMap_thenReturnAttributeIsArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityDataSubCtx tbEntityDataSubCtx = new TbEntityDataSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1, 3);

    ArrayList<EntityKey> keys = new ArrayList<>();
    keys.add(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Act
    Map<EntityKeyType, List<EntityKey>> actualEntityKeyByTypeMap = tbEntityDataSubCtx.getEntityKeyByTypeMap(keys);

    // Assert
    assertEquals(1, actualEntityKeyByTypeMap.size());
    assertEquals(keys, actualEntityKeyByTypeMap.get(EntityKeyType.ATTRIBUTE));
  }

  /**
   * Test {@link TbAbstractDataSubCtx#getEntityKeyByTypeMap(List)}.
   * <ul>
   *   <li>Then return {@code ATTRIBUTE} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractDataSubCtx#getEntityKeyByTypeMap(List)}
   */
  @Test
  @DisplayName("Test getEntityKeyByTypeMap(List); then return 'ATTRIBUTE' size is two")
  void testGetEntityKeyByTypeMap_thenReturnAttributeSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityDataSubCtx tbEntityDataSubCtx = new TbEntityDataSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1, 3);

    ArrayList<EntityKey> keys = new ArrayList<>();
    keys.add(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    keys.add(entityKey);

    // Act
    Map<EntityKeyType, List<EntityKey>> actualEntityKeyByTypeMap = tbEntityDataSubCtx.getEntityKeyByTypeMap(keys);

    // Assert
    assertEquals(1, actualEntityKeyByTypeMap.size());
    List<EntityKey> getResult = actualEntityKeyByTypeMap.get(EntityKeyType.ATTRIBUTE);
    assertEquals(2, getResult.size());
    assertSame(entityKey, getResult.get(1));
  }

  /**
   * Test {@link TbAbstractDataSubCtx#getEntityKeyByTypeMap(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractDataSubCtx#getEntityKeyByTypeMap(List)}
   */
  @Test
  @DisplayName("Test getEntityKeyByTypeMap(List); when ArrayList(); then return Empty")
  void testGetEntityKeyByTypeMap_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityDataSubCtx tbEntityDataSubCtx = new TbEntityDataSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1, 3);

    // Act and Assert
    assertTrue(tbEntityDataSubCtx.getEntityKeyByTypeMap(new ArrayList<>()).isEmpty());
  }

  /**
   * Test
   * {@link TbAbstractDataSubCtx#addSubscriptions(EntityData, Map, boolean, long, long)}.
   * <ul>
   *   <li>Given {@code ATTRIBUTE}.</li>
   *   <li>Then return first Scope is {@code ANY_SCOPE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractDataSubCtx#addSubscriptions(EntityData, Map, boolean, long, long)}
   */
  @Test
  @DisplayName("Test addSubscriptions(EntityData, Map, boolean, long, long); given 'ATTRIBUTE'; then return first Scope is 'ANY_SCOPE'")
  void testAddSubscriptions_givenAttribute_thenReturnFirstScopeIsAnyScope() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenReturn("42");
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());
    when(sessionRef.getSessionSubIdSeq()).thenReturn(new AtomicInteger(1));
    TbEntityDataSubCtx tbEntityDataSubCtx = new TbEntityDataSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1, 3);
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(entityId, latest, new HashMap<>());

    HashMap<EntityKeyType, List<EntityKey>> keysByType = new HashMap<>();
    keysByType.put(EntityKeyType.ATTRIBUTE, new ArrayList<>());

    // Act
    List<TbSubscription> actualAddSubscriptionsResult = tbEntityDataSubCtx.addSubscriptions(entityData, keysByType,
        true, 1L, 1L);

    // Assert
    verify(sessionRef).getSecurityCtx();
    verify(sessionRef).getSessionId();
    verify(sessionRef).getSessionSubIdSeq();
    assertEquals(1, actualAddSubscriptionsResult.size());
    TbSubscription getResult = actualAddSubscriptionsResult.get(0);
    assertTrue(getResult instanceof TbAttributeSubscription);
    Map<Integer, EntityId> integerEntityIdMap = tbEntityDataSubCtx.subToEntityIdMap;
    assertEquals(1, integerEntityIdMap.size());
    assertEquals(TbAttributeSubscriptionScope.ANY_SCOPE, ((TbAttributeSubscription) getResult).getScope());
    assertTrue(integerEntityIdMap.containsKey(2));
    assertTrue(((TbAttributeSubscription) getResult).getKeyStates().isEmpty());
  }

  /**
   * Test
   * {@link TbAbstractDataSubCtx#addSubscriptions(EntityData, Map, boolean, long, long)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code CLIENT_ATTRIBUTE} is
   * {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractDataSubCtx#addSubscriptions(EntityData, Map, boolean, long, long)}
   */
  @Test
  @DisplayName("Test addSubscriptions(EntityData, Map, boolean, long, long); given HashMap(); when HashMap() 'CLIENT_ATTRIBUTE' is HashMap()")
  void testAddSubscriptions_givenHashMap_whenHashMapClientAttributeIsHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenReturn("42");
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());
    when(sessionRef.getSessionSubIdSeq()).thenReturn(new AtomicInteger(1));
    TbEntityDataSubCtx tbEntityDataSubCtx = new TbEntityDataSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1, 3);

    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    latest.put(EntityKeyType.CLIENT_ATTRIBUTE, new HashMap<>());
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    EntityData entityData = new EntityData(entityId, latest, new HashMap<>());

    HashMap<EntityKeyType, List<EntityKey>> keysByType = new HashMap<>();
    keysByType.put(EntityKeyType.CLIENT_ATTRIBUTE, new ArrayList<>());

    // Act
    List<TbSubscription> actualAddSubscriptionsResult = tbEntityDataSubCtx.addSubscriptions(entityData, keysByType,
        true, 1L, 1L);

    // Assert
    verify(sessionRef).getSecurityCtx();
    verify(sessionRef).getSessionId();
    verify(sessionRef).getSessionSubIdSeq();
    assertEquals(1, actualAddSubscriptionsResult.size());
    TbSubscription getResult = actualAddSubscriptionsResult.get(0);
    assertTrue(getResult instanceof TbAttributeSubscription);
    Map<Integer, EntityId> integerEntityIdMap = tbEntityDataSubCtx.subToEntityIdMap;
    assertEquals(1, integerEntityIdMap.size());
    assertEquals(TbAttributeSubscriptionScope.CLIENT_SCOPE, ((TbAttributeSubscription) getResult).getScope());
    assertTrue(integerEntityIdMap.containsKey(2));
    assertTrue(((TbAttributeSubscription) getResult).getKeyStates().isEmpty());
  }

  /**
   * Test
   * {@link TbAbstractDataSubCtx#addSubscriptions(EntityData, Map, boolean, long, long)}.
   * <ul>
   *   <li>Given {@code SERVER_ATTRIBUTE}.</li>
   *   <li>Then return first Scope is {@code SERVER_SCOPE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractDataSubCtx#addSubscriptions(EntityData, Map, boolean, long, long)}
   */
  @Test
  @DisplayName("Test addSubscriptions(EntityData, Map, boolean, long, long); given 'SERVER_ATTRIBUTE'; then return first Scope is 'SERVER_SCOPE'")
  void testAddSubscriptions_givenServerAttribute_thenReturnFirstScopeIsServerScope() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenReturn("42");
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());
    when(sessionRef.getSessionSubIdSeq()).thenReturn(new AtomicInteger(1));
    TbEntityDataSubCtx tbEntityDataSubCtx = new TbEntityDataSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1, 3);
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(entityId, latest, new HashMap<>());

    HashMap<EntityKeyType, List<EntityKey>> keysByType = new HashMap<>();
    keysByType.put(EntityKeyType.SERVER_ATTRIBUTE, new ArrayList<>());

    // Act
    List<TbSubscription> actualAddSubscriptionsResult = tbEntityDataSubCtx.addSubscriptions(entityData, keysByType,
        true, 1L, 1L);

    // Assert
    verify(sessionRef).getSecurityCtx();
    verify(sessionRef).getSessionId();
    verify(sessionRef).getSessionSubIdSeq();
    assertEquals(1, actualAddSubscriptionsResult.size());
    TbSubscription getResult = actualAddSubscriptionsResult.get(0);
    assertTrue(getResult instanceof TbAttributeSubscription);
    Map<Integer, EntityId> integerEntityIdMap = tbEntityDataSubCtx.subToEntityIdMap;
    assertEquals(1, integerEntityIdMap.size());
    assertEquals(TbAttributeSubscriptionScope.SERVER_SCOPE, ((TbAttributeSubscription) getResult).getScope());
    assertTrue(integerEntityIdMap.containsKey(2));
    assertTrue(((TbAttributeSubscription) getResult).getKeyStates().isEmpty());
  }

  /**
   * Test
   * {@link TbAbstractDataSubCtx#addSubscriptions(EntityData, Map, boolean, long, long)}.
   * <ul>
   *   <li>Then return first KeyStates size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractDataSubCtx#addSubscriptions(EntityData, Map, boolean, long, long)}
   */
  @Test
  @DisplayName("Test addSubscriptions(EntityData, Map, boolean, long, long); then return first KeyStates size is one")
  void testAddSubscriptions_thenReturnFirstKeyStatesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenReturn("42");
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());
    when(sessionRef.getSessionSubIdSeq()).thenReturn(new AtomicInteger(1));
    TbEntityDataSubCtx tbEntityDataSubCtx = new TbEntityDataSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1, 3);
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(entityId, latest, new HashMap<>());

    ArrayList<EntityKey> entityKeyList = new ArrayList<>();
    entityKeyList.add(
        new EntityKey(EntityKeyType.ATTRIBUTE, "[{}][{}][{}] Creating attributes subscription for [{}] with keys: {}"));

    HashMap<EntityKeyType, List<EntityKey>> keysByType = new HashMap<>();
    keysByType.put(EntityKeyType.CLIENT_ATTRIBUTE, entityKeyList);

    // Act
    List<TbSubscription> actualAddSubscriptionsResult = tbEntityDataSubCtx.addSubscriptions(entityData, keysByType,
        true, 1L, 1L);

    // Assert
    verify(sessionRef).getSecurityCtx();
    verify(sessionRef).getSessionId();
    verify(sessionRef).getSessionSubIdSeq();
    assertEquals(1, actualAddSubscriptionsResult.size());
    TbSubscription getResult = actualAddSubscriptionsResult.get(0);
    assertTrue(getResult instanceof TbAttributeSubscription);
    Map<String, Long> keyStates = ((TbAttributeSubscription) getResult).getKeyStates();
    assertEquals(1, keyStates.size());
    assertEquals(0L, keyStates.get("[{}][{}][{}] Creating attributes subscription for [{}] with keys: {}").longValue());
    assertEquals(TbAttributeSubscriptionScope.CLIENT_SCOPE, ((TbAttributeSubscription) getResult).getScope());
  }

  /**
   * Test
   * {@link TbAbstractDataSubCtx#addSubscriptions(EntityData, Map, boolean, long, long)}.
   * <ul>
   *   <li>Then return first Scope is {@code CLIENT_SCOPE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractDataSubCtx#addSubscriptions(EntityData, Map, boolean, long, long)}
   */
  @Test
  @DisplayName("Test addSubscriptions(EntityData, Map, boolean, long, long); then return first Scope is 'CLIENT_SCOPE'")
  void testAddSubscriptions_thenReturnFirstScopeIsClientScope() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenReturn("42");
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());
    when(sessionRef.getSessionSubIdSeq()).thenReturn(new AtomicInteger(1));
    TbEntityDataSubCtx tbEntityDataSubCtx = new TbEntityDataSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1, 3);
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(entityId, latest, new HashMap<>());

    HashMap<EntityKeyType, List<EntityKey>> keysByType = new HashMap<>();
    keysByType.put(EntityKeyType.CLIENT_ATTRIBUTE, new ArrayList<>());

    // Act
    List<TbSubscription> actualAddSubscriptionsResult = tbEntityDataSubCtx.addSubscriptions(entityData, keysByType,
        true, 1L, 1L);

    // Assert
    verify(sessionRef).getSecurityCtx();
    verify(sessionRef).getSessionId();
    verify(sessionRef).getSessionSubIdSeq();
    assertEquals(1, actualAddSubscriptionsResult.size());
    TbSubscription getResult = actualAddSubscriptionsResult.get(0);
    assertTrue(getResult instanceof TbAttributeSubscription);
    Map<Integer, EntityId> integerEntityIdMap = tbEntityDataSubCtx.subToEntityIdMap;
    assertEquals(1, integerEntityIdMap.size());
    assertEquals(TbAttributeSubscriptionScope.CLIENT_SCOPE, ((TbAttributeSubscription) getResult).getScope());
    assertTrue(integerEntityIdMap.containsKey(2));
    assertTrue(((TbAttributeSubscription) getResult).getKeyStates().isEmpty());
  }

  /**
   * Test
   * {@link TbAbstractDataSubCtx#addSubscriptions(EntityData, Map, boolean, long, long)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractDataSubCtx#addSubscriptions(EntityData, Map, boolean, long, long)}
   */
  @Test
  @DisplayName("Test addSubscriptions(EntityData, Map, boolean, long, long); when HashMap(); then return Empty")
  void testAddSubscriptions_whenHashMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityDataSubCtx tbEntityDataSubCtx = new TbEntityDataSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1, 3);
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(null, latest, new HashMap<>());

    // Act and Assert
    assertTrue(tbEntityDataSubCtx.addSubscriptions(entityData, new HashMap<>(), true, 1L, 1L).isEmpty());
    assertTrue(tbEntityDataSubCtx.subToEntityIdMap.isEmpty());
  }

  /**
   * Test {@link TbAbstractDataSubCtx#getData()}.
   * <p>
   * Method under test: {@link TbAbstractDataSubCtx#getData()}
   */
  @Test
  @DisplayName("Test getData()")
  void testGetData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TbEntityDataSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
        mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1, 3)).getData());
  }
}
