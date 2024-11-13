package org.thingsboard.server.service.action;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.audit.AuditLogService;

@ContextConfiguration(classes = {EntityActionService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class EntityActionServiceDiffblueTest {
  @MockBean
  private AuditLogService auditLogService;

  @Autowired
  private EntityActionService entityActionService;

  @MockBean
  private NotificationRuleProcessor notificationRuleProcessor;

  @MockBean
  private TbClusterService tbClusterService;

  /**
   * Test
   * {@link EntityActionService#pushEntityActionToRuleEngine(EntityId, HasName, TenantId, CustomerId, ActionType, User, Object[])}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link Customer#getAddress()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityActionService#pushEntityActionToRuleEngine(EntityId, HasName, TenantId, CustomerId, ActionType, User, Object[])}
   */
  @Test
  @DisplayName("Test pushEntityActionToRuleEngine(EntityId, HasName, TenantId, CustomerId, ActionType, User, Object[]); given one; then calls getAddress()")
  void testPushEntityActionToRuleEngine_givenOne_thenCallsGetAddress() {
    // Arrange
    Customer entity = mock(Customer.class);
    when(entity.getVersion()).thenReturn(1L);
    when(entity.getAddress()).thenReturn("42 Main St");
    when(entity.getAddress2()).thenReturn("42 Main St");
    when(entity.getCity()).thenReturn("Oxford");
    when(entity.getCountry()).thenReturn("GB");
    when(entity.getEmail()).thenReturn("jane.doe@example.org");
    when(entity.getPhone()).thenReturn("6625550144");
    when(entity.getState()).thenReturn("MD");
    when(entity.getTitle()).thenReturn("Dr");
    when(entity.getZip()).thenReturn("21654");
    when(entity.getCreatedTime()).thenReturn(1L);
    when(entity.getExternalId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(entity.getId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(entity.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    entityActionService.pushEntityActionToRuleEngine(null, entity, tenantId, new CustomerId(UUID.randomUUID()),
        ActionType.ADDED, null, "Additional Info");

    // Assert
    verify(entity).getAddress();
    verify(entity).getAddress2();
    verify(entity).getCity();
    verify(entity).getCountry();
    verify(entity).getCreatedTime();
    verify(entity).getEmail();
    verify(entity).getExternalId();
    verify(entity).getId();
    verify(entity).getPhone();
    verify(entity).getState();
    verify(entity).getTenantId();
    verify(entity).getTitle();
    verify(entity).getVersion();
    verify(entity).getZip();
  }

  /**
   * Test
   * {@link EntityActionService#logEntityAction(User, EntityId, HasName, CustomerId, ActionType, Exception, Object[])}.
   * <ul>
   *   <li>Then calls
   * {@link AuditLogService#logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityActionService#logEntityAction(User, EntityId, HasName, CustomerId, ActionType, Exception, Object[])}
   */
  @Test
  @DisplayName("Test logEntityAction(User, EntityId, HasName, CustomerId, ActionType, Exception, Object[]); then calls logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])")
  void testLogEntityAction_thenCallsLogEntityAction() {
    // Arrange
    SettableFuture<Void> delegate = SettableFuture.create();
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    User user = new User();
    HasName hasName = mock(HasName.class);
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    entityActionService.logEntityAction(user, null, hasName, customerId, ActionType.ADDED, new Exception("foo"),
        "Additional Info");

    // Assert that nothing has changed
    verify(auditLogService).logEntityAction(isNull(), isA(CustomerId.class), isNull(), isNull(), isNull(),
        isA(HasName.class), eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link EntityActionService#logEntityAction(User, EntityId, HasName, CustomerId, ActionType, Exception, Object[])}.
   * <ul>
   *   <li>Then calls
   * {@link AuditLogService#logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityActionService#logEntityAction(User, EntityId, HasName, CustomerId, ActionType, Exception, Object[])}
   */
  @Test
  @DisplayName("Test logEntityAction(User, EntityId, HasName, CustomerId, ActionType, Exception, Object[]); then calls logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])")
  void testLogEntityAction_thenCallsLogEntityAction2() {
    // Arrange
    SettableFuture<Void> delegate = SettableFuture.create();
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    User user = new User();
    HasName hasName = mock(HasName.class);

    // Act
    entityActionService.logEntityAction(user, null, hasName, null, ActionType.ADDED, new Exception("foo"),
        "Additional Info");

    // Assert that nothing has changed
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isA(HasName.class),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
  }
}
