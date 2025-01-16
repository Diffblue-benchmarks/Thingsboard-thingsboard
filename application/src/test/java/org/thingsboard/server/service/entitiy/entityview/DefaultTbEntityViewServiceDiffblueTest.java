package org.thingsboard.server.service.entitiy.entityview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.msg.plugin.ComponentLifecycleMsg;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.timeseries.TimeseriesService;
import org.thingsboard.server.service.entitiy.TbLogEntityActionService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.sync.vc.EntitiesVersionControlService;
import org.thingsboard.server.service.telemetry.AlarmSubscriptionService;
import org.thingsboard.server.service.telemetry.TelemetrySubscriptionService;

@ContextConfiguration(classes = {DefaultTbEntityViewService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class DefaultTbEntityViewServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private AlarmSubscriptionService alarmSubscriptionService;

  @MockBean
  private AttributesService attributesService;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private DbCallbackExecutorService dbCallbackExecutorService;

  @Autowired
  private DefaultTbEntityViewService defaultTbEntityViewService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntitiesVersionControlService entitiesVersionControlService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private Environment environment;

  @MockBean
  private TbClusterService tbClusterService;

  @MockBean
  private TbLogEntityActionService tbLogEntityActionService;

  @MockBean
  private TelemetrySubscriptionService telemetrySubscriptionService;

  @MockBean
  private TimeseriesService timeseriesService;

  /**
   * Test {@link DefaultTbEntityViewService#delete(EntityView, User)}.
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then calls
   * {@link EntityViewService#deleteEntityView(TenantId, EntityViewId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbEntityViewService#delete(EntityView, User)}
   */
  @Test
  @DisplayName("Test delete(EntityView, User); given TenantId(UUID) with id is randomUUID; then calls deleteEntityView(TenantId, EntityViewId)")
  void testDelete_givenTenantIdWithIdIsRandomUUID_thenCallsDeleteEntityView() throws ThingsboardException {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityViewId>any(), Mockito.<EntityView>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    doNothing().when(entityViewService).deleteEntityView(Mockito.<TenantId>any(), Mockito.<EntityViewId>any());

    EntityView entityView = new EntityView();
    entityView.setTenantId(new TenantId(UUID.randomUUID()));
    entityView.setId(new EntityViewId(UUID.randomUUID()));

    // Act
    defaultTbEntityViewService.delete(entityView, new User());

    // Assert
    verify(entityViewService).deleteEntityView(isA(TenantId.class), isA(EntityViewId.class));
    verify(tbLogEntityActionService).logEntityAction(isA(TenantId.class), isA(EntityViewId.class),
        isA(EntityView.class), (CustomerId) isNull(), eq(ActionType.DELETED), isA(User.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbEntityViewService#assignEntityViewToCustomer(TenantId, EntityViewId, Customer, User)}.
   * <p>
   * Method under test:
   * {@link DefaultTbEntityViewService#assignEntityViewToCustomer(TenantId, EntityViewId, Customer, User)}
   */
  @Test
  @DisplayName("Test assignEntityViewToCustomer(TenantId, EntityViewId, Customer, User)")
  void testAssignEntityViewToCustomer() throws ThingsboardException {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityViewId>any(), Mockito.<ActionType>any(),
            Mockito.<User>any(), Mockito.<Exception>any(), isA(Object[].class));
    EntityView entityView = mock(EntityView.class);
    when(entityView.getCustomerId()).thenThrow(new RuntimeException("foo"));
    when(entityViewService.assignEntityViewToCustomer(Mockito.<TenantId>any(), Mockito.<EntityViewId>any(),
        Mockito.<CustomerId>any())).thenReturn(entityView);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityViewId entityViewId = new EntityViewId(UUID.randomUUID());

    Customer customer = new Customer();
    customer.setId(new CustomerId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbEntityViewService.assignEntityViewToCustomer(tenantId, entityViewId, customer, new User()));
    verify(entityView).getCustomerId();
    verify(entityViewService).assignEntityViewToCustomer(isA(TenantId.class), isA(EntityViewId.class),
        isA(CustomerId.class));
    verify(tbLogEntityActionService).logEntityAction(isA(TenantId.class), isA(EntityViewId.class),
        eq(ActionType.ASSIGNED_TO_CUSTOMER), isA(User.class), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbEntityViewService#assignEntityViewToCustomer(TenantId, EntityViewId, Customer, User)}.
   * <p>
   * Method under test:
   * {@link DefaultTbEntityViewService#assignEntityViewToCustomer(TenantId, EntityViewId, Customer, User)}
   */
  @Test
  @DisplayName("Test assignEntityViewToCustomer(TenantId, EntityViewId, Customer, User)")
  void testAssignEntityViewToCustomer2() throws ThingsboardException {
    // Arrange
    doThrow(new RuntimeException("Requested item wasn't found!")).when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityViewId>any(), Mockito.<ActionType>any(),
            Mockito.<User>any(), Mockito.<Exception>any(), isA(Object[].class));
    EntityView entityView = mock(EntityView.class);
    when(entityView.getCustomerId()).thenThrow(new RuntimeException("foo"));
    when(entityViewService.assignEntityViewToCustomer(Mockito.<TenantId>any(), Mockito.<EntityViewId>any(),
        Mockito.<CustomerId>any())).thenReturn(entityView);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityViewId entityViewId = new EntityViewId(UUID.randomUUID());

    Customer customer = new Customer();
    customer.setId(new CustomerId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbEntityViewService.assignEntityViewToCustomer(tenantId, entityViewId, customer, new User()));
    verify(entityView).getCustomerId();
    verify(entityViewService).assignEntityViewToCustomer(isA(TenantId.class), isA(EntityViewId.class),
        isA(CustomerId.class));
    verify(tbLogEntityActionService).logEntityAction(isA(TenantId.class), isA(EntityViewId.class),
        eq(ActionType.ASSIGNED_TO_CUSTOMER), isA(User.class), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbEntityViewService#unassignEntityViewFromCustomer(TenantId, EntityViewId, Customer, User)}.
   * <p>
   * Method under test:
   * {@link DefaultTbEntityViewService#unassignEntityViewFromCustomer(TenantId, EntityViewId, Customer, User)}
   */
  @Test
  @DisplayName("Test unassignEntityViewFromCustomer(TenantId, EntityViewId, Customer, User)")
  void testUnassignEntityViewFromCustomer() throws ThingsboardException {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityViewId>any(), Mockito.<ActionType>any(),
            Mockito.<User>any(), Mockito.<Exception>any(), isA(Object[].class));
    EntityView entityView = mock(EntityView.class);
    when(entityView.getId()).thenThrow(new RuntimeException("foo"));
    when(entityViewService.unassignEntityViewFromCustomer(Mockito.<TenantId>any(), Mockito.<EntityViewId>any()))
        .thenReturn(entityView);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityViewId entityViewId = new EntityViewId(UUID.randomUUID());
    Customer customer = new Customer();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbEntityViewService.unassignEntityViewFromCustomer(tenantId, entityViewId, customer, new User()));
    verify(entityView).getId();
    verify(entityViewService).unassignEntityViewFromCustomer(isA(TenantId.class), isA(EntityViewId.class));
    verify(tbLogEntityActionService).logEntityAction(isA(TenantId.class), isA(EntityViewId.class),
        eq(ActionType.UNASSIGNED_FROM_CUSTOMER), isA(User.class), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbEntityViewService#unassignEntityViewFromCustomer(TenantId, EntityViewId, Customer, User)}.
   * <p>
   * Method under test:
   * {@link DefaultTbEntityViewService#unassignEntityViewFromCustomer(TenantId, EntityViewId, Customer, User)}
   */
  @Test
  @DisplayName("Test unassignEntityViewFromCustomer(TenantId, EntityViewId, Customer, User)")
  void testUnassignEntityViewFromCustomer2() throws ThingsboardException {
    // Arrange
    doThrow(new RuntimeException("Requested item wasn't found!")).when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityViewId>any(), Mockito.<ActionType>any(),
            Mockito.<User>any(), Mockito.<Exception>any(), isA(Object[].class));
    EntityView entityView = mock(EntityView.class);
    when(entityView.getId()).thenThrow(new RuntimeException("foo"));
    when(entityViewService.unassignEntityViewFromCustomer(Mockito.<TenantId>any(), Mockito.<EntityViewId>any()))
        .thenReturn(entityView);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityViewId entityViewId = new EntityViewId(UUID.randomUUID());
    Customer customer = new Customer();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbEntityViewService.unassignEntityViewFromCustomer(tenantId, entityViewId, customer, new User()));
    verify(entityView).getId();
    verify(entityViewService).unassignEntityViewFromCustomer(isA(TenantId.class), isA(EntityViewId.class));
    verify(tbLogEntityActionService).logEntityAction(isA(TenantId.class), isA(EntityViewId.class),
        eq(ActionType.UNASSIGNED_FROM_CUSTOMER), isA(User.class), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbEntityViewService#assignEntityViewToPublicCustomer(TenantId, EntityViewId, User)}.
   * <p>
   * Method under test:
   * {@link DefaultTbEntityViewService#assignEntityViewToPublicCustomer(TenantId, EntityViewId, User)}
   */
  @Test
  @DisplayName("Test assignEntityViewToPublicCustomer(TenantId, EntityViewId, User)")
  void testAssignEntityViewToPublicCustomer() throws ThingsboardException {
    // Arrange
    when(customerService.findOrCreatePublicCustomer(Mockito.<TenantId>any())).thenReturn(new Customer());
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityViewId>any(), Mockito.<ActionType>any(),
            Mockito.<User>any(), Mockito.<Exception>any(), isA(Object[].class));
    EntityView entityView = mock(EntityView.class);
    when(entityView.getCustomerId()).thenThrow(new RuntimeException("foo"));
    when(entityViewService.assignEntityViewToCustomer(Mockito.<TenantId>any(), Mockito.<EntityViewId>any(),
        Mockito.<CustomerId>any())).thenReturn(entityView);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityViewId entityViewId = new EntityViewId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbEntityViewService.assignEntityViewToPublicCustomer(tenantId, entityViewId, new User()));
    verify(entityView).getCustomerId();
    verify(customerService).findOrCreatePublicCustomer(isA(TenantId.class));
    verify(entityViewService).assignEntityViewToCustomer(isA(TenantId.class), isA(EntityViewId.class), isNull());
    verify(tbLogEntityActionService).logEntityAction(isA(TenantId.class), isA(EntityViewId.class),
        eq(ActionType.ASSIGNED_TO_CUSTOMER), isA(User.class), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbEntityViewService#assignEntityViewToPublicCustomer(TenantId, EntityViewId, User)}.
   * <p>
   * Method under test:
   * {@link DefaultTbEntityViewService#assignEntityViewToPublicCustomer(TenantId, EntityViewId, User)}
   */
  @Test
  @DisplayName("Test assignEntityViewToPublicCustomer(TenantId, EntityViewId, User)")
  void testAssignEntityViewToPublicCustomer2() throws ThingsboardException {
    // Arrange
    when(customerService.findOrCreatePublicCustomer(Mockito.<TenantId>any())).thenReturn(new Customer());
    doThrow(new RuntimeException("Requested item wasn't found!")).when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityViewId>any(), Mockito.<ActionType>any(),
            Mockito.<User>any(), Mockito.<Exception>any(), isA(Object[].class));
    EntityView entityView = mock(EntityView.class);
    when(entityView.getCustomerId()).thenThrow(new RuntimeException("foo"));
    when(entityViewService.assignEntityViewToCustomer(Mockito.<TenantId>any(), Mockito.<EntityViewId>any(),
        Mockito.<CustomerId>any())).thenReturn(entityView);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityViewId entityViewId = new EntityViewId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbEntityViewService.assignEntityViewToPublicCustomer(tenantId, entityViewId, new User()));
    verify(entityView).getCustomerId();
    verify(customerService).findOrCreatePublicCustomer(isA(TenantId.class));
    verify(entityViewService).assignEntityViewToCustomer(isA(TenantId.class), isA(EntityViewId.class), isNull());
    verify(tbLogEntityActionService).logEntityAction(isA(TenantId.class), isA(EntityViewId.class),
        eq(ActionType.ASSIGNED_TO_CUSTOMER), isA(User.class), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbEntityViewService#findEntityViewsByTenantIdAndEntityIdAsync(TenantId, EntityId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbEntityViewService#findEntityViewsByTenantIdAndEntityIdAsync(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityViewsByTenantIdAndEntityIdAsync(TenantId, EntityId); then throw RuntimeException")
  void testFindEntityViewsByTenantIdAndEntityIdAsync_thenThrowRuntimeException() {
    // Arrange
    ListenableFutureTask<List<EntityView>> delegate = mock(ListenableFutureTask.class);
    doThrow(new RuntimeException("foo")).when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ApiFutureToListenableFuture<List<EntityView>> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(entityViewService.findEntityViewsByTenantIdAndEntityIdAsync(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(apiFutureToListenableFuture);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbEntityViewService
        .findEntityViewsByTenantIdAndEntityIdAsync(new TenantId(UUID.randomUUID()), null));
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(entityViewService).findEntityViewsByTenantIdAndEntityIdAsync(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DefaultTbEntityViewService#onComponentLifecycleMsg(ComponentLifecycleMsg)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbEntityViewService#onComponentLifecycleMsg(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test onComponentLifecycleMsg(ComponentLifecycleMsg); then throw RuntimeException")
  void testOnComponentLifecycleMsg_thenThrowRuntimeException() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getEntityId()).thenThrow(new RuntimeException("foo"));
    when(entityViewService.findEntityViewById(Mockito.<TenantId>any(), Mockito.<EntityViewId>any()))
        .thenReturn(entityView);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbEntityViewService.onComponentLifecycleMsg(
        new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED)));
    verify(entityView).getEntityId();
    verify(entityViewService).findEntityViewById(isA(TenantId.class), isA(EntityViewId.class));
  }

  /**
   * Test {@link DefaultTbEntityViewService#toException(Throwable)}.
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then return LocalizedMessage is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbEntityViewService#toException(Throwable)}
   */
  @Test
  @DisplayName("Test toException(Throwable); when IOException(String) with 'foo'; then return LocalizedMessage is 'foo'")
  void testToException_whenIOExceptionWithFoo_thenReturnLocalizedMessageIsFoo() {
    // Arrange and Act
    Exception actualToExceptionResult = DefaultTbEntityViewService.toException(new IOException("foo"));

    // Assert
    assertEquals("foo", actualToExceptionResult.getLocalizedMessage());
    assertEquals("foo", actualToExceptionResult.getMessage());
    assertNull(actualToExceptionResult.getCause());
    assertEquals(0, actualToExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link DefaultTbEntityViewService#toException(Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbEntityViewService#toException(Throwable)}
   */
  @Test
  @DisplayName("Test toException(Throwable); when 'null'; then return 'null'")
  void testToException_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DefaultTbEntityViewService.toException(null));
  }

  /**
   * Test {@link DefaultTbEntityViewService#toException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return LocalizedMessage is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbEntityViewService#toException(Throwable)}
   */
  @Test
  @DisplayName("Test toException(Throwable); when Throwable(); then return LocalizedMessage is 'java.lang.Throwable'")
  void testToException_whenThrowable_thenReturnLocalizedMessageIsJavaLangThrowable() {
    // Arrange
    Throwable error = new Throwable();

    // Act
    Exception actualToExceptionResult = DefaultTbEntityViewService.toException(error);

    // Assert
    assertEquals("java.lang.Throwable", actualToExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualToExceptionResult.getMessage());
    assertSame(error, actualToExceptionResult.getCause());
  }
}
