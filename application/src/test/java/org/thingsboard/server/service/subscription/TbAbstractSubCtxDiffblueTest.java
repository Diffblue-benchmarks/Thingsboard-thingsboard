package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetSocketAddress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.query.DynamicValueSourceType;
import org.thingsboard.server.common.data.query.EntityCountQuery;
import org.thingsboard.server.common.data.query.EntityFilter;
import org.thingsboard.server.common.data.query.FilterPredicateType;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.controller.plugin.TbWebSocketHandler;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.notification.DefaultNotificationRequestService;
import org.thingsboard.server.dao.notification.DefaultNotificationService;
import org.thingsboard.server.dao.notification.DefaultNotificationSettingsService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
import org.thingsboard.server.dao.notification.DefaultNotificationTemplateService;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationDao;
import org.thingsboard.server.dao.sql.notification.NotificationRepository;
import org.thingsboard.server.dao.sql.query.DefaultEntityQueryRepository;
import org.thingsboard.server.dao.sql.query.DefaultQueryLogComponent;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;
import org.thingsboard.server.dao.tenant.DefaultTbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;
import org.thingsboard.server.dao.util.DbTypeInfoComponent;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;
import org.thingsboard.server.service.executors.NotificationExecutorService;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.notification.DefaultNotificationCenter;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;
import org.thingsboard.server.service.security.AccessValidator;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.state.DefaultDeviceStateService;
import org.thingsboard.server.service.subscription.TbAbstractSubCtx.DynamicValueKey;
import org.thingsboard.server.service.ws.DefaultWebSocketService;
import org.thingsboard.server.service.ws.WebSocketService;
import org.thingsboard.server.service.ws.WebSocketSessionRef;
import org.thingsboard.server.service.ws.WebSocketSessionType;
import org.thingsboard.server.service.ws.notification.DefaultNotificationCommandsHandler;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.AlarmCountUpdate;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.CmdUpdate;

class TbAbstractSubCtxDiffblueTest {
  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}, and
   * {@link DynamicValueKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbAbstractSubCtx.DynamicValueKey#equals(Object)}
   *   <li>{@link TbAbstractSubCtx.DynamicValueKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object), and hashCode(); when other is equal; then return equal")
  void testDynamicValueKeyEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey = new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey2 = new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertEquals(dynamicValueKey, dynamicValueKey2);
    int expectedHashCodeResult = dynamicValueKey.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValueKey2.hashCode());
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}, and
   * {@link DynamicValueKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbAbstractSubCtx.DynamicValueKey#equals(Object)}
   *   <li>{@link TbAbstractSubCtx.DynamicValueKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object), and hashCode(); when other is equal; then return equal")
  void testDynamicValueKeyEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey = new TbAbstractSubCtx.DynamicValueKey(null,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey2 = new TbAbstractSubCtx.DynamicValueKey(null,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertEquals(dynamicValueKey, dynamicValueKey2);
    int expectedHashCodeResult = dynamicValueKey.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValueKey2.hashCode());
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}, and
   * {@link DynamicValueKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbAbstractSubCtx.DynamicValueKey#equals(Object)}
   *   <li>{@link TbAbstractSubCtx.DynamicValueKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object), and hashCode(); when other is equal; then return equal")
  void testDynamicValueKeyEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey = new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        null, "Source Attribute");
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey2 = new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        null, "Source Attribute");

    // Act and Assert
    assertEquals(dynamicValueKey, dynamicValueKey2);
    int expectedHashCodeResult = dynamicValueKey.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValueKey2.hashCode());
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}, and
   * {@link DynamicValueKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbAbstractSubCtx.DynamicValueKey#equals(Object)}
   *   <li>{@link TbAbstractSubCtx.DynamicValueKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object), and hashCode(); when other is equal; then return equal")
  void testDynamicValueKeyEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey = new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, null);
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey2 = new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, null);

    // Act and Assert
    assertEquals(dynamicValueKey, dynamicValueKey2);
    int expectedHashCodeResult = dynamicValueKey.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValueKey2.hashCode());
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}, and
   * {@link DynamicValueKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbAbstractSubCtx.DynamicValueKey#equals(Object)}
   *   <li>{@link TbAbstractSubCtx.DynamicValueKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object), and hashCode(); when other is same; then return equal")
  void testDynamicValueKeyEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey = new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertEquals(dynamicValueKey, dynamicValueKey);
    int expectedHashCodeResult = dynamicValueKey.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValueKey.hashCode());
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx.DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is different; then return not equal")
  void testDynamicValueKeyEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey = new TbAbstractSubCtx.DynamicValueKey(null,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValueKey, new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx.DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is different; then return not equal")
  void testDynamicValueKeyEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey = new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.NUMERIC,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValueKey, new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx.DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is different; then return not equal")
  void testDynamicValueKeyEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey = new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        null, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValueKey, new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx.DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is different; then return not equal")
  void testDynamicValueKeyEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey = new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_CUSTOMER, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValueKey, new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx.DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is different; then return not equal")
  void testDynamicValueKeyEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey = new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, null);

    // Act and Assert
    assertNotEquals(dynamicValueKey, new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx.DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is different; then return not equal")
  void testDynamicValueKeyEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbAbstractSubCtx.DynamicValueKey dynamicValueKey = new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT,
        "org.thingsboard.server.service.subscription.TbAbstractSubCtx$DynamicValueKey");

    // Act and Assert
    assertNotEquals(dynamicValueKey, new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx.DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is 'null'; then return not equal")
  void testDynamicValueKeyEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"), null);
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx.DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is wrong type; then return not equal")
  void testDynamicValueKeyEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbAbstractSubCtx.DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"), "Different type to DynamicValueKey");
  }

  /**
   * Test DynamicValueKey getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbAbstractSubCtx.DynamicValueKey#DynamicValueKey(FilterPredicateType, DynamicValueSourceType, String)}
   *   <li>{@link TbAbstractSubCtx.DynamicValueKey#toString()}
   *   <li>{@link TbAbstractSubCtx.DynamicValueKey#getPredicateType()}
   *   <li>{@link TbAbstractSubCtx.DynamicValueKey#getSourceAttribute()}
   *   <li>{@link TbAbstractSubCtx.DynamicValueKey#getSourceType()}
   * </ul>
   */
  @Test
  @DisplayName("Test DynamicValueKey getters and setters")
  void testDynamicValueKeyGettersAndSetters() {
    // Arrange and Act
    TbAbstractSubCtx.DynamicValueKey actualDynamicValueKey = new TbAbstractSubCtx.DynamicValueKey(
        FilterPredicateType.STRING, DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    String actualToStringResult = actualDynamicValueKey.toString();
    FilterPredicateType actualPredicateType = actualDynamicValueKey.getPredicateType();
    String actualSourceAttribute = actualDynamicValueKey.getSourceAttribute();

    // Assert
    assertEquals("Source Attribute", actualSourceAttribute);
    assertEquals(
        "TbAbstractSubCtx.DynamicValueKey(predicateType=STRING, sourceType=CURRENT_TENANT, sourceAttribute=Source"
            + " Attribute)",
        actualToStringResult);
    assertEquals(DynamicValueSourceType.CURRENT_TENANT, actualDynamicValueKey.getSourceType());
    assertEquals(FilterPredicateType.STRING, actualPredicateType);
  }

  /**
   * Test {@link TbAbstractSubCtx#setAndResolveQuery(EntityCountQuery)}.
   * <p>
   * Method under test:
   * {@link TbAbstractSubCtx#setAndResolveQuery(EntityCountQuery)}
   */
  @Test
  @DisplayName("Test setAndResolveQuery(EntityCountQuery)")
  void testSetAndResolveQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1);
    EntityCountQuery entityCountQuery = new EntityCountQuery();

    // Act
    tbEntityCountSubCtx.setAndResolveQuery(entityCountQuery);

    // Assert
    verify(sessionRef, atLeast(1)).getSecurityCtx();
    assertSame(entityCountQuery, tbEntityCountSubCtx.getQuery());
  }

  /**
   * Test {@link TbAbstractSubCtx#setAndResolveQuery(EntityCountQuery)}.
   * <p>
   * Method under test:
   * {@link TbAbstractSubCtx#setAndResolveQuery(EntityCountQuery)}
   */
  @Test
  @DisplayName("Test setAndResolveQuery(EntityCountQuery)")
  void testSetAndResolveQuery2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1);

    // Act
    tbEntityCountSubCtx.setAndResolveQuery(null);

    // Assert
    verify(sessionRef, atLeast(1)).getSecurityCtx();
    assertNull(tbEntityCountSubCtx.getQuery());
  }

  /**
   * Test {@link TbAbstractSubCtx#setAndResolveQuery(EntityCountQuery)}.
   * <p>
   * Method under test:
   * {@link TbAbstractSubCtx#setAndResolveQuery(EntityCountQuery)}
   */
  @Test
  @DisplayName("Test setAndResolveQuery(EntityCountQuery)")
  void testSetAndResolveQuery3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1);
    EntityCountQuery entityCountQuery = new EntityCountQuery(mock(EntityFilter.class));

    // Act
    tbEntityCountSubCtx.setAndResolveQuery(entityCountQuery);

    // Assert
    verify(sessionRef, atLeast(1)).getSecurityCtx();
    assertSame(entityCountQuery, tbEntityCountSubCtx.getQuery());
  }

  /**
   * Test {@link TbAbstractSubCtx#setAndResolveQuery(EntityCountQuery)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractSubCtx#setAndResolveQuery(EntityCountQuery)}
   */
  @Test
  @DisplayName("Test setAndResolveQuery(EntityCountQuery); then throw NumberFormatException")
  void testSetAndResolveQuery_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1);
    EntityCountQuery entityCountQuery = mock(EntityCountQuery.class);
    when(entityCountQuery.getKeyFilters()).thenThrow(new NumberFormatException("foo"));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> tbEntityCountSubCtx.setAndResolveQuery(entityCountQuery));
    verify(entityCountQuery).getKeyFilters();
  }

  /**
   * Test {@link TbAbstractSubCtx#stop()}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#stop()}
   */
  @Test
  @DisplayName("Test stop()")
  void testStop() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1);

    // Act
    tbEntityCountSubCtx.stop();

    // Assert
    assertTrue(tbEntityCountSubCtx.isStopped());
  }

  /**
   * Test {@link TbAbstractSubCtx#getSessionId()}.
   * <ul>
   *   <li>Given {@link WebSocketSessionRef}
   * {@link WebSocketSessionRef#getSessionId()} return {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getSessionId()}
   */
  @Test
  @DisplayName("Test getSessionId(); given WebSocketSessionRef getSessionId() return '42'; then return '42'")
  void testGetSessionId_givenWebSocketSessionRefGetSessionIdReturn42_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenReturn("42");

    // Act
    String actualSessionId = (new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
        mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1)).getSessionId();

    // Assert
    verify(sessionRef).getSessionId();
    assertEquals("42", actualSessionId);
  }

  /**
   * Test {@link TbAbstractSubCtx#getSessionId()}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getSessionId()}
   */
  @Test
  @DisplayName("Test getSessionId(); then throw NumberFormatException")
  void testGetSessionId_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenThrow(new NumberFormatException("foo"));

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> (new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
            mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
            mock(SubscriptionServiceStatistics.class), sessionRef, 1)).getSessionId());
    verify(sessionRef).getSessionId();
  }

  /**
   * Test {@link TbAbstractSubCtx#getTenantId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId(); then return 'null'")
  void testGetTenantId_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());

    // Act
    TenantId actualTenantId = (new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
        mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1)).getTenantId();

    // Assert
    verify(sessionRef).getSecurityCtx();
    assertNull(actualTenantId);
  }

  /**
   * Test {@link TbAbstractSubCtx#getTenantId()}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId(); then throw NumberFormatException")
  void testGetTenantId_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSecurityCtx()).thenThrow(new NumberFormatException("foo"));

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> (new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
            mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
            mock(SubscriptionServiceStatistics.class), sessionRef, 1)).getTenantId());
    verify(sessionRef).getSecurityCtx();
  }

  /**
   * Test {@link TbAbstractSubCtx#getCustomerId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getCustomerId()}
   */
  @Test
  @DisplayName("Test getCustomerId(); then return 'null'")
  void testGetCustomerId_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());

    // Act
    CustomerId actualCustomerId = (new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1)).getCustomerId();

    // Assert
    verify(sessionRef).getSecurityCtx();
    assertNull(actualCustomerId);
  }

  /**
   * Test {@link TbAbstractSubCtx#getCustomerId()}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getCustomerId()}
   */
  @Test
  @DisplayName("Test getCustomerId(); then throw NumberFormatException")
  void testGetCustomerId_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSecurityCtx()).thenThrow(new NumberFormatException("foo"));

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> (new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
            mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
            mock(SubscriptionServiceStatistics.class), sessionRef, 1)).getCustomerId());
    verify(sessionRef).getSecurityCtx();
  }

  /**
   * Test {@link TbAbstractSubCtx#getUserId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getUserId()}
   */
  @Test
  @DisplayName("Test getUserId(); then return 'null'")
  void testGetUserId_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());

    // Act
    UserId actualUserId = (new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
        mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1)).getUserId();

    // Assert
    verify(sessionRef).getSecurityCtx();
    assertNull(actualUserId);
  }

  /**
   * Test {@link TbAbstractSubCtx#getUserId()}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getUserId()}
   */
  @Test
  @DisplayName("Test getUserId(); then throw NumberFormatException")
  void testGetUserId_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSecurityCtx()).thenThrow(new NumberFormatException("foo"));

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> (new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
            mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
            mock(SubscriptionServiceStatistics.class), sessionRef, 1)).getUserId());
    verify(sessionRef).getSecurityCtx();
  }

  /**
   * Test {@link TbAbstractSubCtx#sendWsMsg(CmdUpdate)}.
   * <ul>
   *   <li>Given {@link WebSocketService}
   * {@link WebSocketService#sendUpdate(String, CmdUpdate)} does nothing.</li>
   *   <li>Then calls {@link WebSocketService#sendUpdate(String, CmdUpdate)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#sendWsMsg(CmdUpdate)}
   */
  @Test
  @DisplayName("Test sendWsMsg(CmdUpdate); given WebSocketService sendUpdate(String, CmdUpdate) does nothing; then calls sendUpdate(String, CmdUpdate)")
  void testSendWsMsg_givenWebSocketServiceSendUpdateDoesNothing_thenCallsSendUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketService wsService = mock(WebSocketService.class);
    doNothing().when(wsService).sendUpdate(Mockito.<String>any(), Mockito.<CmdUpdate>any());
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenReturn("42");
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", wsService, mock(EntityService.class),
        mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1);

    // Act
    tbEntityCountSubCtx.sendWsMsg(new AlarmCountUpdate(1, 3));

    // Assert
    verify(wsService).sendUpdate(eq("42"), isA(CmdUpdate.class));
    verify(sessionRef).getSessionId();
  }

  /**
   * Test {@link TbAbstractSubCtx#sendWsMsg(CmdUpdate)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#sendWsMsg(CmdUpdate)}
   */
  @Test
  @DisplayName("Test sendWsMsg(CmdUpdate); then throw NumberFormatException")
  void testSendWsMsg_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenThrow(new NumberFormatException("foo"));
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> tbEntityCountSubCtx.sendWsMsg(new AlarmCountUpdate(1, 3)));
    verify(sessionRef).getSessionId();
  }

  /**
   * Test {@link TbAbstractSubCtx#canEqual(Object)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); then return 'true'")
  void testCanEqual_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1);

    // Act and Assert
    assertTrue(tbEntityCountSubCtx.canEqual(new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1)));
  }

  /**
   * Test {@link TbAbstractSubCtx#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  void testCanEqual_whenOther_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
        mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1)).canEqual("Other"));
  }

  /**
   * Test {@link TbAbstractSubCtx#equals(Object)}, and
   * {@link TbAbstractSubCtx#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbAbstractSubCtx#equals(Object)}
   *   <li>{@link TbAbstractSubCtx#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider3, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    DefaultDeviceStateService deviceStateService = new DefaultDeviceStateService(null, null,
        new BaseTimeseriesService(), null, null, null, mock(DbTypeInfoComponent.class), null,
        mock(NotificationRuleProcessor.class));

    TopicService topicService3 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService2 = new DefaultTbClusterService(topicService3, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultSubscriptionManagerService subscriptionManagerService = new DefaultSubscriptionManagerService(topicService2,
        partitionService2, serviceInfoProvider4, producerProvider, null, deviceStateService, clusterService2,
        new SubscriptionSchedulerComponent());

    DefaultTbLocalSubscriptionService oldSubService = new DefaultTbLocalSubscriptionService(attrService, tsService,
        serviceInfoProvider, partitionService, clusterService, subscriptionManagerService, null,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultTbEntityDataSubscriptionService entityDataSubService = new DefaultTbEntityDataSubscriptionService();
    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    BaseAttributesService attrService2 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider6, tenantRoutingInfoService3,
        applicationEventPublisher3, queueRoutingInfoService3, new TopicService());

    TopicService topicService4 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService3 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService3 = new DefaultTbClusterService(topicService4, null, null,
        gatewayNotificationsService3, new EdgeServiceImpl(), null);

    TopicService topicService5 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider7 = new DefaultTbServiceInfoProvider();
    DefaultSubscriptionManagerService subscriptionManagerService2 = new DefaultSubscriptionManagerService(topicService5,
        null, serviceInfoProvider7, null, null, null, null, new SubscriptionSchedulerComponent());

    DefaultTbLocalSubscriptionService localSubscriptionService = new DefaultTbLocalSubscriptionService(attrService2,
        tsService2, serviceInfoProvider5, partitionService3, clusterService3, subscriptionManagerService2, null,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(null, null,
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService2 = new DefaultNotificationService(null);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        new AdminSettingsServiceImpl(), null, null, null, null);

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService6 = new TopicService();
    TbCoreQueueProducerProvider producerProvider2 = new TbCoreQueueProducerProvider(null);
    DefaultNotificationCenter notificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService2, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService6, producerProvider2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationCommandsHandler notificationCmdsHandler = new DefaultNotificationCommandsHandler(
        notificationService, localSubscriptionService, notificationCenter, new DefaultTbServiceInfoProvider());

    TbWebSocketHandler msgEndpoint = new TbWebSocketHandler();
    AccessValidator accessValidator = new AccessValidator();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService3 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultWebSocketService wsService = new DefaultWebSocketService(oldSubService, entityDataSubService,
        notificationCmdsHandler, msgEndpoint, accessValidator, attributesService, tsService3, serviceInfoProvider8,
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl()));

    BaseEntityService entityService = new BaseEntityService();
    BaseAttributesService attrService3 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService4 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService4 = new HashPartitionService(serviceInfoProvider10, tenantRoutingInfoService4,
        applicationEventPublisher4, queueRoutingInfoService4, new TopicService());

    TopicService topicService7 = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache2 = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService2 = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache2 = new DefaultTbAssetProfileCache(assetProfileService2,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService4 = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService2 = new EdgeServiceImpl();
    DefaultTbClusterService clusterService4 = new DefaultTbClusterService(topicService7, deviceProfileCache2,
        assetProfileCache2, gatewayNotificationsService4, edgeService2,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    TopicService topicService8 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService5 = new HashPartitionService(serviceInfoProvider11, tenantRoutingInfoService5,
        applicationEventPublisher5, queueRoutingInfoService5, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider12 = new DefaultTbServiceInfoProvider();
    TopicService topicService9 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider13 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider3 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService9, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider13, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    JpaDeviceDao deviceDao2 = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao2, null, deviceProfileService3, eventService2,
        tenantService2, deviceValidator2, countService2, new JpaExecutorService());

    BaseAttributesService attributesService2 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService5 = new BaseTimeseriesService();
    TopicService topicService10 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService5 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService5 = new DefaultTbClusterService(topicService10, null, null,
        gatewayNotificationsService5, new EdgeServiceImpl(), null);

    DefaultTbServiceInfoProvider serviceInfoProvider14 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService6 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher6 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService6 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService6 = new HashPartitionService(serviceInfoProvider14, tenantRoutingInfoService6,
        applicationEventPublisher6, queueRoutingInfoService6, new TopicService());

    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    DefaultEntityQueryRepository entityQueryRepository = new DefaultEntityQueryRepository(jdbcTemplate,
        transactionTemplate, new DefaultQueryLogComponent());

    DbTypeInfoComponent dbTypeInfoComponent = mock(DbTypeInfoComponent.class);
    DefaultTbServiceInfoProvider serviceInfoProvider15 = new DefaultTbServiceInfoProvider();
    DefaultDeviceStateService deviceStateService2 = new DefaultDeviceStateService(deviceService, attributesService2,
        tsService5, clusterService5, partitionService6, entityQueryRepository, dbTypeInfoComponent,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider15, new DefaultSchedulerComponent(), null),
        mock(NotificationRuleProcessor.class));

    TopicService topicService11 = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache3 = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService3 = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache3 = new DefaultTbAssetProfileCache(assetProfileService3,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService6 = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService3 = new EdgeServiceImpl();
    DefaultTbClusterService clusterService6 = new DefaultTbClusterService(topicService11, deviceProfileCache3,
        assetProfileCache3, gatewayNotificationsService6, edgeService3,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSubscriptionManagerService subscriptionManagerService3 = new DefaultSubscriptionManagerService(topicService8,
        partitionService5, serviceInfoProvider12, producerProvider3, null, deviceStateService2, clusterService6,
        new SubscriptionSchedulerComponent());

    DefaultTbEntityDataSubscriptionService entityDataSubService2 = new DefaultTbEntityDataSubscriptionService();
    DefaultNotificationService notificationService3 = new DefaultNotificationService(null);
    NotificationExecutorService notificationExecutor2 = new NotificationExecutorService();
    DefaultNotificationCenter notificationCenter2 = new DefaultNotificationCenter(null, null, null, null, null,
        notificationExecutor2, new TopicService(), null, null);

    DefaultNotificationCommandsHandler notificationCmdsHandler2 = new DefaultNotificationCommandsHandler(
        notificationService3, null, notificationCenter2, new DefaultTbServiceInfoProvider());

    TbWebSocketHandler msgEndpoint2 = new TbWebSocketHandler();
    AccessValidator accessValidator2 = new AccessValidator();
    BaseAttributesService attributesService3 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService6 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider16 = new DefaultTbServiceInfoProvider();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultWebSocketService webSocketService = new DefaultWebSocketService(null, entityDataSubService2,
        notificationCmdsHandler2, msgEndpoint2, accessValidator2, attributesService3, tsService6, serviceInfoProvider16,
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl()));

    DefaultTbLocalSubscriptionService localSubscriptionService2 = new DefaultTbLocalSubscriptionService(attrService3,
        tsService4, serviceInfoProvider9, partitionService4, clusterService4, subscriptionManagerService3,
        webSocketService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    BaseAttributesService attributesService4 = new BaseAttributesService(new JpaAttributeDao());
    SubscriptionServiceStatistics stats = new SubscriptionServiceStatistics();
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", wsService, entityService,
        localSubscriptionService2, attributesService4, stats, sessionRef, 1);

    // Act and Assert
    assertEquals(tbEntityCountSubCtx, tbEntityCountSubCtx);
    int expectedHashCodeResult = tbEntityCountSubCtx.hashCode();
    assertEquals(expectedHashCodeResult, tbEntityCountSubCtx.hashCode());
  }

  /**
   * Test {@link TbAbstractSubCtx#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider3, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    DefaultDeviceStateService deviceStateService = new DefaultDeviceStateService(null, null,
        new BaseTimeseriesService(), null, null, null, mock(DbTypeInfoComponent.class), null,
        mock(NotificationRuleProcessor.class));

    TopicService topicService3 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService2 = new DefaultTbClusterService(topicService3, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultSubscriptionManagerService subscriptionManagerService = new DefaultSubscriptionManagerService(topicService2,
        partitionService2, serviceInfoProvider4, producerProvider, null, deviceStateService, clusterService2,
        new SubscriptionSchedulerComponent());

    DefaultTbLocalSubscriptionService oldSubService = new DefaultTbLocalSubscriptionService(attrService, tsService,
        serviceInfoProvider, partitionService, clusterService, subscriptionManagerService, null,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultTbEntityDataSubscriptionService entityDataSubService = new DefaultTbEntityDataSubscriptionService();
    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    BaseAttributesService attrService2 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider6, tenantRoutingInfoService3,
        applicationEventPublisher3, queueRoutingInfoService3, new TopicService());

    TopicService topicService4 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService3 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService3 = new DefaultTbClusterService(topicService4, null, null,
        gatewayNotificationsService3, new EdgeServiceImpl(), null);

    TopicService topicService5 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider7 = new DefaultTbServiceInfoProvider();
    DefaultSubscriptionManagerService subscriptionManagerService2 = new DefaultSubscriptionManagerService(topicService5,
        null, serviceInfoProvider7, null, null, null, null, new SubscriptionSchedulerComponent());

    DefaultTbLocalSubscriptionService localSubscriptionService = new DefaultTbLocalSubscriptionService(attrService2,
        tsService2, serviceInfoProvider5, partitionService3, clusterService3, subscriptionManagerService2, null,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(null, null,
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService2 = new DefaultNotificationService(null);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        new AdminSettingsServiceImpl(), null, null, null, null);

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService6 = new TopicService();
    TbCoreQueueProducerProvider producerProvider2 = new TbCoreQueueProducerProvider(null);
    DefaultNotificationCenter notificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService2, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService6, producerProvider2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationCommandsHandler notificationCmdsHandler = new DefaultNotificationCommandsHandler(
        notificationService, localSubscriptionService, notificationCenter, new DefaultTbServiceInfoProvider());

    TbWebSocketHandler msgEndpoint = new TbWebSocketHandler();
    AccessValidator accessValidator = new AccessValidator();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService3 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultWebSocketService wsService = new DefaultWebSocketService(oldSubService, entityDataSubService,
        notificationCmdsHandler, msgEndpoint, accessValidator, attributesService, tsService3, serviceInfoProvider8,
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl()));

    BaseEntityService entityService = new BaseEntityService();
    BaseAttributesService attrService3 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService4 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService4 = new HashPartitionService(serviceInfoProvider10, tenantRoutingInfoService4,
        applicationEventPublisher4, queueRoutingInfoService4, new TopicService());

    TopicService topicService7 = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache2 = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService2 = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache2 = new DefaultTbAssetProfileCache(assetProfileService2,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService4 = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService2 = new EdgeServiceImpl();
    DefaultTbClusterService clusterService4 = new DefaultTbClusterService(topicService7, deviceProfileCache2,
        assetProfileCache2, gatewayNotificationsService4, edgeService2,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    TopicService topicService8 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService5 = new HashPartitionService(serviceInfoProvider11, tenantRoutingInfoService5,
        applicationEventPublisher5, queueRoutingInfoService5, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider12 = new DefaultTbServiceInfoProvider();
    TopicService topicService9 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider13 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider3 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService9, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider13, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    JpaDeviceDao deviceDao2 = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao2, null, deviceProfileService3, eventService2,
        tenantService2, deviceValidator2, countService2, new JpaExecutorService());

    BaseAttributesService attributesService2 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService5 = new BaseTimeseriesService();
    TopicService topicService10 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService5 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService5 = new DefaultTbClusterService(topicService10, null, null,
        gatewayNotificationsService5, new EdgeServiceImpl(), null);

    DefaultTbServiceInfoProvider serviceInfoProvider14 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService6 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher6 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService6 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService6 = new HashPartitionService(serviceInfoProvider14, tenantRoutingInfoService6,
        applicationEventPublisher6, queueRoutingInfoService6, new TopicService());

    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    DefaultEntityQueryRepository entityQueryRepository = new DefaultEntityQueryRepository(jdbcTemplate,
        transactionTemplate, new DefaultQueryLogComponent());

    DbTypeInfoComponent dbTypeInfoComponent = mock(DbTypeInfoComponent.class);
    DefaultTbServiceInfoProvider serviceInfoProvider15 = new DefaultTbServiceInfoProvider();
    DefaultDeviceStateService deviceStateService2 = new DefaultDeviceStateService(deviceService, attributesService2,
        tsService5, clusterService5, partitionService6, entityQueryRepository, dbTypeInfoComponent,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider15, new DefaultSchedulerComponent(), null),
        mock(NotificationRuleProcessor.class));

    TopicService topicService11 = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache3 = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService3 = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache3 = new DefaultTbAssetProfileCache(assetProfileService3,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService6 = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService3 = new EdgeServiceImpl();
    DefaultTbClusterService clusterService6 = new DefaultTbClusterService(topicService11, deviceProfileCache3,
        assetProfileCache3, gatewayNotificationsService6, edgeService3,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSubscriptionManagerService subscriptionManagerService3 = new DefaultSubscriptionManagerService(topicService8,
        partitionService5, serviceInfoProvider12, producerProvider3, null, deviceStateService2, clusterService6,
        new SubscriptionSchedulerComponent());

    DefaultTbEntityDataSubscriptionService entityDataSubService2 = new DefaultTbEntityDataSubscriptionService();
    DefaultNotificationService notificationService3 = new DefaultNotificationService(null);
    NotificationExecutorService notificationExecutor2 = new NotificationExecutorService();
    DefaultNotificationCenter notificationCenter2 = new DefaultNotificationCenter(null, null, null, null, null,
        notificationExecutor2, new TopicService(), null, null);

    DefaultNotificationCommandsHandler notificationCmdsHandler2 = new DefaultNotificationCommandsHandler(
        notificationService3, null, notificationCenter2, new DefaultTbServiceInfoProvider());

    TbWebSocketHandler msgEndpoint2 = new TbWebSocketHandler();
    AccessValidator accessValidator2 = new AccessValidator();
    BaseAttributesService attributesService3 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService6 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider16 = new DefaultTbServiceInfoProvider();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultWebSocketService webSocketService = new DefaultWebSocketService(null, entityDataSubService2,
        notificationCmdsHandler2, msgEndpoint2, accessValidator2, attributesService3, tsService6, serviceInfoProvider16,
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl()));

    DefaultTbLocalSubscriptionService localSubscriptionService2 = new DefaultTbLocalSubscriptionService(attrService3,
        tsService4, serviceInfoProvider9, partitionService4, clusterService4, subscriptionManagerService3,
        webSocketService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    BaseAttributesService attributesService4 = new BaseAttributesService(new JpaAttributeDao());
    SubscriptionServiceStatistics stats = new SubscriptionServiceStatistics();
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", wsService, entityService,
        localSubscriptionService2, attributesService4, stats, sessionRef, 1);
    BaseAttributesService attrService4 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService7 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider17 = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider18 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService7 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher7 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService7 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService7 = new HashPartitionService(serviceInfoProvider18, tenantRoutingInfoService7,
        applicationEventPublisher7, queueRoutingInfoService7, new TopicService());

    TopicService topicService12 = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache4 = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService4 = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache4 = new DefaultTbAssetProfileCache(assetProfileService4,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService7 = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService4 = new EdgeServiceImpl();
    DefaultTbClusterService clusterService7 = new DefaultTbClusterService(topicService12, deviceProfileCache4,
        assetProfileCache4, gatewayNotificationsService7, edgeService4,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    TopicService topicService13 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider19 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService8 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher8 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService8 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService8 = new HashPartitionService(serviceInfoProvider19, tenantRoutingInfoService8,
        applicationEventPublisher8, queueRoutingInfoService8, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider20 = new DefaultTbServiceInfoProvider();
    TbCoreQueueProducerProvider producerProvider4 = new TbCoreQueueProducerProvider(null);
    DefaultDeviceStateService deviceStateService3 = new DefaultDeviceStateService(null, null,
        new BaseTimeseriesService(), null, null, null, mock(DbTypeInfoComponent.class), null,
        mock(NotificationRuleProcessor.class));

    TopicService topicService14 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService8 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService8 = new DefaultTbClusterService(topicService14, null, null,
        gatewayNotificationsService8, new EdgeServiceImpl(), null);

    DefaultSubscriptionManagerService subscriptionManagerService4 = new DefaultSubscriptionManagerService(
        topicService13, partitionService8, serviceInfoProvider20, producerProvider4, null, deviceStateService3,
        clusterService8, new SubscriptionSchedulerComponent());

    DefaultTbLocalSubscriptionService oldSubService2 = new DefaultTbLocalSubscriptionService(attrService4, tsService7,
        serviceInfoProvider17, partitionService7, clusterService7, subscriptionManagerService4, null,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultTbEntityDataSubscriptionService entityDataSubService3 = new DefaultTbEntityDataSubscriptionService();
    DefaultNotificationService notificationService4 = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    BaseAttributesService attrService5 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService8 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider21 = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider22 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService9 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher9 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService9 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService9 = new HashPartitionService(serviceInfoProvider22, tenantRoutingInfoService9,
        applicationEventPublisher9, queueRoutingInfoService9, new TopicService());

    TopicService topicService15 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService9 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService9 = new DefaultTbClusterService(topicService15, null, null,
        gatewayNotificationsService9, new EdgeServiceImpl(), null);

    TopicService topicService16 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider23 = new DefaultTbServiceInfoProvider();
    DefaultSubscriptionManagerService subscriptionManagerService5 = new DefaultSubscriptionManagerService(
        topicService16, null, serviceInfoProvider23, null, null, null, null, new SubscriptionSchedulerComponent());

    DefaultTbLocalSubscriptionService localSubscriptionService3 = new DefaultTbLocalSubscriptionService(attrService5,
        tsService8, serviceInfoProvider21, partitionService9, clusterService9, subscriptionManagerService5, null,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationRequestService notificationRequestService2 = new DefaultNotificationRequestService(null, null,
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService5 = new DefaultNotificationService(null);
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(null,
        null);

    DefaultNotificationSettingsService notificationSettingsService2 = new DefaultNotificationSettingsService(
        new AdminSettingsServiceImpl(), null, null, null, null);

    NotificationExecutorService notificationExecutor3 = new NotificationExecutorService();
    TopicService topicService17 = new TopicService();
    TbCoreQueueProducerProvider producerProvider5 = new TbCoreQueueProducerProvider(null);
    DefaultNotificationCenter notificationCenter3 = new DefaultNotificationCenter(notificationTargetService2,
        notificationRequestService2, notificationService5, notificationTemplateService2, notificationSettingsService2,
        notificationExecutor3, topicService17, producerProvider5,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationCommandsHandler notificationCmdsHandler3 = new DefaultNotificationCommandsHandler(
        notificationService4, localSubscriptionService3, notificationCenter3, new DefaultTbServiceInfoProvider());

    TbWebSocketHandler msgEndpoint3 = new TbWebSocketHandler();
    AccessValidator accessValidator3 = new AccessValidator();
    BaseAttributesService attributesService5 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService9 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider24 = new DefaultTbServiceInfoProvider();
    TenantProfileServiceImpl tenantProfileService3 = new TenantProfileServiceImpl();
    DefaultWebSocketService wsService2 = new DefaultWebSocketService(oldSubService2, entityDataSubService3,
        notificationCmdsHandler3, msgEndpoint3, accessValidator3, attributesService5, tsService9, serviceInfoProvider24,
        new DefaultTbTenantProfileCache(tenantProfileService3, new TenantServiceImpl()));

    BaseEntityService entityService2 = new BaseEntityService();
    BaseAttributesService attrService6 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService10 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider25 = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider26 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService10 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher10 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService10 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService10 = new HashPartitionService(serviceInfoProvider26,
        tenantRoutingInfoService10, applicationEventPublisher10, queueRoutingInfoService10, new TopicService());

    TopicService topicService18 = new TopicService();
    DeviceProfileServiceImpl deviceProfileService4 = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao3 = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService5 = new DeviceProfileServiceImpl();
    BaseEventService eventService3 = new BaseEventService();
    TenantServiceImpl tenantService3 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator3 = new DeviceDataValidator();
    BaseEntityCountService countService3 = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache5 = new DefaultTbDeviceProfileCache(deviceProfileService4,
        new DeviceServiceImpl(deviceDao3, null, deviceProfileService5, eventService3, tenantService3, deviceValidator3,
            countService3, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService5 = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache5 = new DefaultTbAssetProfileCache(assetProfileService5,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService10 = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService5 = new EdgeServiceImpl();
    DefaultTbClusterService clusterService10 = new DefaultTbClusterService(topicService18, deviceProfileCache5,
        assetProfileCache5, gatewayNotificationsService10, edgeService5,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    TopicService topicService19 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider27 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService11 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher11 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService11 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService11 = new HashPartitionService(serviceInfoProvider27,
        tenantRoutingInfoService11, applicationEventPublisher11, queueRoutingInfoService11, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider28 = new DefaultTbServiceInfoProvider();
    TopicService topicService20 = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings2 = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings2 = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider29 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings2 = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider6 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService20, coreSettings2, ruleEngineSettings2, vcSettings2, serviceInfoProvider29, transportApiSettings2,
        transportNotificationSettings2, edgeSettings2, new DefaultInMemoryStorage()));
    JpaDeviceDao deviceDao4 = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService6 = new DeviceProfileServiceImpl();
    BaseEventService eventService4 = new BaseEventService();
    TenantServiceImpl tenantService4 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator4 = new DeviceDataValidator();
    BaseEntityCountService countService4 = new BaseEntityCountService();
    DeviceServiceImpl deviceService2 = new DeviceServiceImpl(deviceDao4, null, deviceProfileService6, eventService4,
        tenantService4, deviceValidator4, countService4, new JpaExecutorService());

    BaseAttributesService attributesService6 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService11 = new BaseTimeseriesService();
    TopicService topicService21 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService11 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService11 = new DefaultTbClusterService(topicService21, null, null,
        gatewayNotificationsService11, new EdgeServiceImpl(), null);

    DefaultTbServiceInfoProvider serviceInfoProvider30 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService12 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher12 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService12 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService12 = new HashPartitionService(serviceInfoProvider30,
        tenantRoutingInfoService12, applicationEventPublisher12, queueRoutingInfoService12, new TopicService());

    NamedParameterJdbcTemplate jdbcTemplate2 = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate2 = new TransactionTemplate();
    DefaultEntityQueryRepository entityQueryRepository2 = new DefaultEntityQueryRepository(jdbcTemplate2,
        transactionTemplate2, new DefaultQueryLogComponent());

    DbTypeInfoComponent dbTypeInfoComponent2 = mock(DbTypeInfoComponent.class);
    DefaultTbServiceInfoProvider serviceInfoProvider31 = new DefaultTbServiceInfoProvider();
    DefaultDeviceStateService deviceStateService4 = new DefaultDeviceStateService(deviceService2, attributesService6,
        tsService11, clusterService11, partitionService12, entityQueryRepository2, dbTypeInfoComponent2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider31, new DefaultSchedulerComponent(), null),
        mock(NotificationRuleProcessor.class));

    TopicService topicService22 = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache6 = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService6 = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache6 = new DefaultTbAssetProfileCache(assetProfileService6,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService12 = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService6 = new EdgeServiceImpl();
    DefaultTbClusterService clusterService12 = new DefaultTbClusterService(topicService22, deviceProfileCache6,
        assetProfileCache6, gatewayNotificationsService12, edgeService6,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSubscriptionManagerService subscriptionManagerService6 = new DefaultSubscriptionManagerService(
        topicService19, partitionService11, serviceInfoProvider28, producerProvider6, null, deviceStateService4,
        clusterService12, new SubscriptionSchedulerComponent());

    DefaultTbEntityDataSubscriptionService entityDataSubService4 = new DefaultTbEntityDataSubscriptionService();
    DefaultNotificationService notificationService6 = new DefaultNotificationService(null);
    NotificationExecutorService notificationExecutor4 = new NotificationExecutorService();
    DefaultNotificationCenter notificationCenter4 = new DefaultNotificationCenter(null, null, null, null, null,
        notificationExecutor4, new TopicService(), null, null);

    DefaultNotificationCommandsHandler notificationCmdsHandler4 = new DefaultNotificationCommandsHandler(
        notificationService6, null, notificationCenter4, new DefaultTbServiceInfoProvider());

    TbWebSocketHandler msgEndpoint4 = new TbWebSocketHandler();
    AccessValidator accessValidator4 = new AccessValidator();
    BaseAttributesService attributesService7 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService12 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider32 = new DefaultTbServiceInfoProvider();
    TenantProfileServiceImpl tenantProfileService4 = new TenantProfileServiceImpl();
    DefaultWebSocketService webSocketService2 = new DefaultWebSocketService(null, entityDataSubService4,
        notificationCmdsHandler4, msgEndpoint4, accessValidator4, attributesService7, tsService12,
        serviceInfoProvider32, new DefaultTbTenantProfileCache(tenantProfileService4, new TenantServiceImpl()));

    DefaultTbLocalSubscriptionService localSubscriptionService4 = new DefaultTbLocalSubscriptionService(attrService6,
        tsService10, serviceInfoProvider25, partitionService10, clusterService10, subscriptionManagerService6,
        webSocketService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    BaseAttributesService attributesService8 = new BaseAttributesService(new JpaAttributeDao());
    SubscriptionServiceStatistics stats2 = new SubscriptionServiceStatistics();
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult2 = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult2 = builderResult2
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult2 = localAddressResult2
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef2 = remoteAddressResult2.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(tbEntityCountSubCtx, new TbEntityCountSubCtx("42", wsService2, entityService2,
        localSubscriptionService4, attributesService8, stats2, sessionRef2, 1));
  }

  /**
   * Test {@link TbAbstractSubCtx#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider3, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    DefaultDeviceStateService deviceStateService = new DefaultDeviceStateService(null, null,
        new BaseTimeseriesService(), null, null, null, mock(DbTypeInfoComponent.class), null,
        mock(NotificationRuleProcessor.class));

    TopicService topicService3 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService2 = new DefaultTbClusterService(topicService3, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultSubscriptionManagerService subscriptionManagerService = new DefaultSubscriptionManagerService(topicService2,
        partitionService2, serviceInfoProvider4, producerProvider, null, deviceStateService, clusterService2,
        new SubscriptionSchedulerComponent());

    DefaultTbLocalSubscriptionService oldSubService = new DefaultTbLocalSubscriptionService(attrService, tsService,
        serviceInfoProvider, partitionService, clusterService, subscriptionManagerService, null,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultTbEntityDataSubscriptionService entityDataSubService = new DefaultTbEntityDataSubscriptionService();
    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    BaseAttributesService attrService2 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider6, tenantRoutingInfoService3,
        applicationEventPublisher3, queueRoutingInfoService3, new TopicService());

    TopicService topicService4 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService3 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService3 = new DefaultTbClusterService(topicService4, null, null,
        gatewayNotificationsService3, new EdgeServiceImpl(), null);

    TopicService topicService5 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider7 = new DefaultTbServiceInfoProvider();
    DefaultSubscriptionManagerService subscriptionManagerService2 = new DefaultSubscriptionManagerService(topicService5,
        null, serviceInfoProvider7, null, null, null, null, new SubscriptionSchedulerComponent());

    DefaultTbLocalSubscriptionService localSubscriptionService = new DefaultTbLocalSubscriptionService(attrService2,
        tsService2, serviceInfoProvider5, partitionService3, clusterService3, subscriptionManagerService2, null,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(null, null,
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService2 = new DefaultNotificationService(null);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        new AdminSettingsServiceImpl(), null, null, null, null);

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService6 = new TopicService();
    TbCoreQueueProducerProvider producerProvider2 = new TbCoreQueueProducerProvider(null);
    DefaultNotificationCenter notificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService2, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService6, producerProvider2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationCommandsHandler notificationCmdsHandler = new DefaultNotificationCommandsHandler(
        notificationService, localSubscriptionService, notificationCenter, new DefaultTbServiceInfoProvider());

    TbWebSocketHandler msgEndpoint = new TbWebSocketHandler();
    AccessValidator accessValidator = new AccessValidator();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService3 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultWebSocketService wsService = new DefaultWebSocketService(oldSubService, entityDataSubService,
        notificationCmdsHandler, msgEndpoint, accessValidator, attributesService, tsService3, serviceInfoProvider8,
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl()));

    BaseEntityService entityService = new BaseEntityService();
    BaseAttributesService attrService3 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService4 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService4 = new HashPartitionService(serviceInfoProvider10, tenantRoutingInfoService4,
        applicationEventPublisher4, queueRoutingInfoService4, new TopicService());

    TopicService topicService7 = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache2 = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService2 = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache2 = new DefaultTbAssetProfileCache(assetProfileService2,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService4 = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService2 = new EdgeServiceImpl();
    DefaultTbClusterService clusterService4 = new DefaultTbClusterService(topicService7, deviceProfileCache2,
        assetProfileCache2, gatewayNotificationsService4, edgeService2,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    TopicService topicService8 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService5 = new HashPartitionService(serviceInfoProvider11, tenantRoutingInfoService5,
        applicationEventPublisher5, queueRoutingInfoService5, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider12 = new DefaultTbServiceInfoProvider();
    TopicService topicService9 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider13 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider3 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService9, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider13, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    JpaDeviceDao deviceDao2 = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao2, null, deviceProfileService3, eventService2,
        tenantService2, deviceValidator2, countService2, new JpaExecutorService());

    BaseAttributesService attributesService2 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService5 = new BaseTimeseriesService();
    TopicService topicService10 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService5 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService5 = new DefaultTbClusterService(topicService10, null, null,
        gatewayNotificationsService5, new EdgeServiceImpl(), null);

    DefaultTbServiceInfoProvider serviceInfoProvider14 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService6 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher6 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService6 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService6 = new HashPartitionService(serviceInfoProvider14, tenantRoutingInfoService6,
        applicationEventPublisher6, queueRoutingInfoService6, new TopicService());

    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    DefaultEntityQueryRepository entityQueryRepository = new DefaultEntityQueryRepository(jdbcTemplate,
        transactionTemplate, new DefaultQueryLogComponent());

    DbTypeInfoComponent dbTypeInfoComponent = mock(DbTypeInfoComponent.class);
    DefaultTbServiceInfoProvider serviceInfoProvider15 = new DefaultTbServiceInfoProvider();
    DefaultDeviceStateService deviceStateService2 = new DefaultDeviceStateService(deviceService, attributesService2,
        tsService5, clusterService5, partitionService6, entityQueryRepository, dbTypeInfoComponent,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider15, new DefaultSchedulerComponent(), null),
        mock(NotificationRuleProcessor.class));

    TopicService topicService11 = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache3 = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService3 = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache3 = new DefaultTbAssetProfileCache(assetProfileService3,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService6 = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService3 = new EdgeServiceImpl();
    DefaultTbClusterService clusterService6 = new DefaultTbClusterService(topicService11, deviceProfileCache3,
        assetProfileCache3, gatewayNotificationsService6, edgeService3,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSubscriptionManagerService subscriptionManagerService3 = new DefaultSubscriptionManagerService(topicService8,
        partitionService5, serviceInfoProvider12, producerProvider3, null, deviceStateService2, clusterService6,
        new SubscriptionSchedulerComponent());

    DefaultTbEntityDataSubscriptionService entityDataSubService2 = new DefaultTbEntityDataSubscriptionService();
    DefaultNotificationService notificationService3 = new DefaultNotificationService(null);
    NotificationExecutorService notificationExecutor2 = new NotificationExecutorService();
    DefaultNotificationCenter notificationCenter2 = new DefaultNotificationCenter(null, null, null, null, null,
        notificationExecutor2, new TopicService(), null, null);

    DefaultNotificationCommandsHandler notificationCmdsHandler2 = new DefaultNotificationCommandsHandler(
        notificationService3, null, notificationCenter2, new DefaultTbServiceInfoProvider());

    TbWebSocketHandler msgEndpoint2 = new TbWebSocketHandler();
    AccessValidator accessValidator2 = new AccessValidator();
    BaseAttributesService attributesService3 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService6 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider16 = new DefaultTbServiceInfoProvider();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultWebSocketService webSocketService = new DefaultWebSocketService(null, entityDataSubService2,
        notificationCmdsHandler2, msgEndpoint2, accessValidator2, attributesService3, tsService6, serviceInfoProvider16,
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl()));

    DefaultTbLocalSubscriptionService localSubscriptionService2 = new DefaultTbLocalSubscriptionService(attrService3,
        tsService4, serviceInfoProvider9, partitionService4, clusterService4, subscriptionManagerService3,
        webSocketService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    BaseAttributesService attributesService4 = new BaseAttributesService(new JpaAttributeDao());
    SubscriptionServiceStatistics stats = new SubscriptionServiceStatistics();
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(new TbEntityCountSubCtx("42", wsService, entityService, localSubscriptionService2,
        attributesService4, stats, sessionRef, 1), null);
  }

  /**
   * Test {@link TbAbstractSubCtx#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider3, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    DefaultDeviceStateService deviceStateService = new DefaultDeviceStateService(null, null,
        new BaseTimeseriesService(), null, null, null, mock(DbTypeInfoComponent.class), null,
        mock(NotificationRuleProcessor.class));

    TopicService topicService3 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService2 = new DefaultTbClusterService(topicService3, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultSubscriptionManagerService subscriptionManagerService = new DefaultSubscriptionManagerService(topicService2,
        partitionService2, serviceInfoProvider4, producerProvider, null, deviceStateService, clusterService2,
        new SubscriptionSchedulerComponent());

    DefaultTbLocalSubscriptionService oldSubService = new DefaultTbLocalSubscriptionService(attrService, tsService,
        serviceInfoProvider, partitionService, clusterService, subscriptionManagerService, null,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultTbEntityDataSubscriptionService entityDataSubService = new DefaultTbEntityDataSubscriptionService();
    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    BaseAttributesService attrService2 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider6, tenantRoutingInfoService3,
        applicationEventPublisher3, queueRoutingInfoService3, new TopicService());

    TopicService topicService4 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService3 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService3 = new DefaultTbClusterService(topicService4, null, null,
        gatewayNotificationsService3, new EdgeServiceImpl(), null);

    TopicService topicService5 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider7 = new DefaultTbServiceInfoProvider();
    DefaultSubscriptionManagerService subscriptionManagerService2 = new DefaultSubscriptionManagerService(topicService5,
        null, serviceInfoProvider7, null, null, null, null, new SubscriptionSchedulerComponent());

    DefaultTbLocalSubscriptionService localSubscriptionService = new DefaultTbLocalSubscriptionService(attrService2,
        tsService2, serviceInfoProvider5, partitionService3, clusterService3, subscriptionManagerService2, null,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(null, null,
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService2 = new DefaultNotificationService(null);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        new AdminSettingsServiceImpl(), null, null, null, null);

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService6 = new TopicService();
    TbCoreQueueProducerProvider producerProvider2 = new TbCoreQueueProducerProvider(null);
    DefaultNotificationCenter notificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService2, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService6, producerProvider2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationCommandsHandler notificationCmdsHandler = new DefaultNotificationCommandsHandler(
        notificationService, localSubscriptionService, notificationCenter, new DefaultTbServiceInfoProvider());

    TbWebSocketHandler msgEndpoint = new TbWebSocketHandler();
    AccessValidator accessValidator = new AccessValidator();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService3 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultWebSocketService wsService = new DefaultWebSocketService(oldSubService, entityDataSubService,
        notificationCmdsHandler, msgEndpoint, accessValidator, attributesService, tsService3, serviceInfoProvider8,
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl()));

    BaseEntityService entityService = new BaseEntityService();
    BaseAttributesService attrService3 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService4 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService4 = new HashPartitionService(serviceInfoProvider10, tenantRoutingInfoService4,
        applicationEventPublisher4, queueRoutingInfoService4, new TopicService());

    TopicService topicService7 = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache2 = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService2 = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache2 = new DefaultTbAssetProfileCache(assetProfileService2,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService4 = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService2 = new EdgeServiceImpl();
    DefaultTbClusterService clusterService4 = new DefaultTbClusterService(topicService7, deviceProfileCache2,
        assetProfileCache2, gatewayNotificationsService4, edgeService2,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    TopicService topicService8 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService5 = new HashPartitionService(serviceInfoProvider11, tenantRoutingInfoService5,
        applicationEventPublisher5, queueRoutingInfoService5, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider12 = new DefaultTbServiceInfoProvider();
    TopicService topicService9 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider13 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider3 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService9, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider13, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    JpaDeviceDao deviceDao2 = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao2, null, deviceProfileService3, eventService2,
        tenantService2, deviceValidator2, countService2, new JpaExecutorService());

    BaseAttributesService attributesService2 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService5 = new BaseTimeseriesService();
    TopicService topicService10 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService5 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService5 = new DefaultTbClusterService(topicService10, null, null,
        gatewayNotificationsService5, new EdgeServiceImpl(), null);

    DefaultTbServiceInfoProvider serviceInfoProvider14 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService6 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher6 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService6 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService6 = new HashPartitionService(serviceInfoProvider14, tenantRoutingInfoService6,
        applicationEventPublisher6, queueRoutingInfoService6, new TopicService());

    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    DefaultEntityQueryRepository entityQueryRepository = new DefaultEntityQueryRepository(jdbcTemplate,
        transactionTemplate, new DefaultQueryLogComponent());

    DbTypeInfoComponent dbTypeInfoComponent = mock(DbTypeInfoComponent.class);
    DefaultTbServiceInfoProvider serviceInfoProvider15 = new DefaultTbServiceInfoProvider();
    DefaultDeviceStateService deviceStateService2 = new DefaultDeviceStateService(deviceService, attributesService2,
        tsService5, clusterService5, partitionService6, entityQueryRepository, dbTypeInfoComponent,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider15, new DefaultSchedulerComponent(), null),
        mock(NotificationRuleProcessor.class));

    TopicService topicService11 = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache3 = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService3 = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache3 = new DefaultTbAssetProfileCache(assetProfileService3,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService6 = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService3 = new EdgeServiceImpl();
    DefaultTbClusterService clusterService6 = new DefaultTbClusterService(topicService11, deviceProfileCache3,
        assetProfileCache3, gatewayNotificationsService6, edgeService3,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSubscriptionManagerService subscriptionManagerService3 = new DefaultSubscriptionManagerService(topicService8,
        partitionService5, serviceInfoProvider12, producerProvider3, null, deviceStateService2, clusterService6,
        new SubscriptionSchedulerComponent());

    DefaultTbEntityDataSubscriptionService entityDataSubService2 = new DefaultTbEntityDataSubscriptionService();
    DefaultNotificationService notificationService3 = new DefaultNotificationService(null);
    NotificationExecutorService notificationExecutor2 = new NotificationExecutorService();
    DefaultNotificationCenter notificationCenter2 = new DefaultNotificationCenter(null, null, null, null, null,
        notificationExecutor2, new TopicService(), null, null);

    DefaultNotificationCommandsHandler notificationCmdsHandler2 = new DefaultNotificationCommandsHandler(
        notificationService3, null, notificationCenter2, new DefaultTbServiceInfoProvider());

    TbWebSocketHandler msgEndpoint2 = new TbWebSocketHandler();
    AccessValidator accessValidator2 = new AccessValidator();
    BaseAttributesService attributesService3 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService6 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider16 = new DefaultTbServiceInfoProvider();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultWebSocketService webSocketService = new DefaultWebSocketService(null, entityDataSubService2,
        notificationCmdsHandler2, msgEndpoint2, accessValidator2, attributesService3, tsService6, serviceInfoProvider16,
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl()));

    DefaultTbLocalSubscriptionService localSubscriptionService2 = new DefaultTbLocalSubscriptionService(attrService3,
        tsService4, serviceInfoProvider9, partitionService4, clusterService4, subscriptionManagerService3,
        webSocketService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    BaseAttributesService attributesService4 = new BaseAttributesService(new JpaAttributeDao());
    SubscriptionServiceStatistics stats = new SubscriptionServiceStatistics();
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(new TbEntityCountSubCtx("42", wsService, entityService, localSubscriptionService2,
        attributesService4, stats, sessionRef, 1), "Different type to TbAbstractSubCtx");
  }

  /**
   * Test {@link TbAbstractSubCtx#getAttributesService()}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getAttributesService()}
   */
  @Test
  @DisplayName("Test getAttributesService()")
  void testGetAttributesService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1);

    // Act and Assert
    assertSame(tbEntityCountSubCtx.attributesService, tbEntityCountSubCtx.getAttributesService());
  }

  /**
   * Test {@link TbAbstractSubCtx#getCmdId()}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getCmdId()}
   */
  @Test
  @DisplayName("Test getCmdId()")
  void testGetCmdId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1,
        (new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
            mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
            mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1)).getCmdId());
  }

  /**
   * Test {@link TbAbstractSubCtx#getDynamicValues()}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getDynamicValues()}
   */
  @Test
  @DisplayName("Test getDynamicValues()")
  void testGetDynamicValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
        mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1)).getDynamicValues().isEmpty());
  }

  /**
   * Test {@link TbAbstractSubCtx#getEntityService()}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getEntityService()}
   */
  @Test
  @DisplayName("Test getEntityService()")
  void testGetEntityService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1);

    // Act and Assert
    assertSame(tbEntityCountSubCtx.entityService, tbEntityCountSubCtx.getEntityService());
  }

  /**
   * Test {@link TbAbstractSubCtx#getLocalSubscriptionService()}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getLocalSubscriptionService()}
   */
  @Test
  @DisplayName("Test getLocalSubscriptionService()")
  void testGetLocalSubscriptionService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1);

    // Act and Assert
    assertSame(tbEntityCountSubCtx.localSubscriptionService, tbEntityCountSubCtx.getLocalSubscriptionService());
  }

  /**
   * Test {@link TbAbstractSubCtx#getQuery()}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getQuery()}
   */
  @Test
  @DisplayName("Test getQuery()")
  void testGetQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
        mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1)).getQuery());
  }

  /**
   * Test {@link TbAbstractSubCtx#getRefreshTask()}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getRefreshTask()}
   */
  @Test
  @DisplayName("Test getRefreshTask()")
  void testGetRefreshTask() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
        mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1)).getRefreshTask());
  }

  /**
   * Test {@link TbAbstractSubCtx#getServiceId()}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getServiceId()}
   */
  @Test
  @DisplayName("Test getServiceId()")
  void testGetServiceId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42",
        (new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
            mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
            mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1)).getServiceId());
  }

  /**
   * Test {@link TbAbstractSubCtx#getSessionRef()}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getSessionRef()}
   */
  @Test
  @DisplayName("Test getSessionRef()")
  void testGetSessionRef() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1);

    // Act and Assert
    assertSame(tbEntityCountSubCtx.sessionRef, tbEntityCountSubCtx.getSessionRef());
  }

  /**
   * Test {@link TbAbstractSubCtx#getStats()}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getStats()}
   */
  @Test
  @DisplayName("Test getStats()")
  void testGetStats() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1);

    // Act and Assert
    assertSame(tbEntityCountSubCtx.stats, tbEntityCountSubCtx.getStats());
  }

  /**
   * Test {@link TbAbstractSubCtx#getSubToDynamicValueKeySet()}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getSubToDynamicValueKeySet()}
   */
  @Test
  @DisplayName("Test getSubToDynamicValueKeySet()")
  void testGetSubToDynamicValueKeySet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
        mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1)).getSubToDynamicValueKeySet()
        .isEmpty());
  }

  /**
   * Test {@link TbAbstractSubCtx#getWsLock()}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#getWsLock()}
   */
  @Test
  @DisplayName("Test getWsLock()")
  void testGetWsLock() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1);

    // Act and Assert
    assertSame(tbEntityCountSubCtx.wsLock, tbEntityCountSubCtx.getWsLock());
  }

  /**
   * Test {@link TbAbstractSubCtx#isStopped()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#isStopped()}
   */
  @Test
  @DisplayName("Test isStopped(); then return 'false'")
  void testIsStopped_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TbEntityCountSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
        mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1)).isStopped());
  }

  /**
   * Test {@link TbAbstractSubCtx#isStopped()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractSubCtx#isStopped()}
   */
  @Test
  @DisplayName("Test isStopped(); then return 'true'")
  void testIsStopped_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1);
    tbEntityCountSubCtx.setStopped(true);

    // Act and Assert
    assertTrue(tbEntityCountSubCtx.isStopped());
  }

  /**
   * Test {@link TbAbstractSubCtx#setCreatedTime(long)}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#setCreatedTime(long)}
   */
  @Test
  @DisplayName("Test setCreatedTime(long)")
  void testSetCreatedTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1);

    // Act
    tbEntityCountSubCtx.setCreatedTime(1L);

    // Assert
    assertEquals(1L, tbEntityCountSubCtx.getCreatedTime());
  }

  /**
   * Test {@link TbAbstractSubCtx#setQuery(EntityCountQuery)}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#setQuery(EntityCountQuery)}
   */
  @Test
  @DisplayName("Test setQuery(EntityCountQuery)")
  void testSetQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1);
    EntityCountQuery entityCountQuery = new EntityCountQuery();

    // Act
    tbEntityCountSubCtx.setQuery(entityCountQuery);

    // Assert
    assertSame(entityCountQuery, tbEntityCountSubCtx.getQuery());
  }

  /**
   * Test {@link TbAbstractSubCtx#setStopped(boolean)}.
   * <p>
   * Method under test: {@link TbAbstractSubCtx#setStopped(boolean)}
   */
  @Test
  @DisplayName("Test setStopped(boolean)")
  void testSetStopped() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityCountSubCtx tbEntityCountSubCtx = new TbEntityCountSubCtx("42", mock(WebSocketService.class),
        mock(EntityService.class), mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1);

    // Act
    tbEntityCountSubCtx.setStopped(true);

    // Assert
    assertTrue(tbEntityCountSubCtx.isStopped());
  }
}
