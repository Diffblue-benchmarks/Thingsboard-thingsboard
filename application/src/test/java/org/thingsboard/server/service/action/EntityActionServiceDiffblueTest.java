package org.thingsboard.server.service.action;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cluster.TbClusterService;
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
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class EntityActionServiceDiffblueTest {
  @MockBean private AuditLogService auditLogService;

  @Autowired private EntityActionService entityActionService;

  @MockBean private NotificationRuleProcessor notificationRuleProcessor;

  @MockBean private TbClusterService tbClusterService;

  /**
   * Test {@link EntityActionService#logEntityAction(User, EntityId, HasName, CustomerId,
   * ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>Then calls {@link AuditLogService#logEntityAction(TenantId, CustomerId, UserId, String,
   *       EntityId, HasName, ActionType, Exception, Object[])}.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionService#logEntityAction(User, EntityId, HasName,
   * CustomerId, ActionType, Exception, Object[])}
   */
  @Test
  @DisplayName(
      "Test logEntityAction(User, EntityId, HasName, CustomerId, ActionType, Exception, Object[]); then calls logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityActionService.logEntityAction(User, EntityId, HasName, CustomerId, ActionType, Exception, Object[])"
  })
  void testLogEntityAction_thenCallsLogEntityAction() {
    // Arrange
    SettableFuture<Void> delegate = SettableFuture.create();
    ForwardingApiFuture<Void> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    when(auditLogService.logEntityAction(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<UserId>any(),
            Mockito.<String>any(),
            Mockito.<EntityId>any(),
            Mockito.<HasName>any(),
            Mockito.<ActionType>any(),
            Mockito.<Exception>any(),
            isA(Object[].class)))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));
    User user = new User();
    HasName hasName = mock(HasName.class);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityActionService.logEntityAction(
        user, null, hasName, customerId, ActionType.ADDED, new Exception(), "Additional Info");

    // Assert
    verify(auditLogService)
        .logEntityAction(
            isNull(),
            isA(CustomerId.class),
            isNull(),
            isNull(),
            isNull(),
            isA(HasName.class),
            eq(ActionType.ADDED),
            isA(Exception.class),
            isA(Object[].class));
  }
}
