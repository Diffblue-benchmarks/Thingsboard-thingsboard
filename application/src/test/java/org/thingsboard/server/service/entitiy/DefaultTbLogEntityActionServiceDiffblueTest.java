package org.thingsboard.server.service.entitiy;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.service.action.EntityActionService;

@ContextConfiguration(classes = {DefaultTbLogEntityActionService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DefaultTbLogEntityActionServiceDiffblueTest {
  @Autowired
  private DefaultTbLogEntityActionService defaultTbLogEntityActionService;

  @MockBean
  private EntityActionService entityActionService;

  /**
   * Test
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, ActionType, User, Exception, Object[])}
   * with {@code tenantId}, {@code entityId}, {@code actionType}, {@code user},
   * {@code e}, {@code additionalInfo}.
   * <p>
   * Method under test:
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, ActionType, User, Exception, Object[])}
   */
  @Test
  @DisplayName("Test logEntityAction(TenantId, EntityId, ActionType, User, Exception, Object[]) with 'tenantId', 'entityId', 'actionType', 'user', 'e', 'additionalInfo'")
  void testLogEntityActionWithTenantIdEntityIdActionTypeUserEAdditionalInfo() {
    // Arrange
    doNothing().when(entityActionService)
        .logEntityAction(Mockito.<User>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<Exception>any(), isA(Object[].class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    User user = new User();

    // Act
    defaultTbLogEntityActionService.logEntityAction(tenantId, null, ActionType.ADDED, user, new Exception("foo"),
        "Additional Info");

    // Assert that nothing has changed
    verify(entityActionService).logEntityAction(isA(User.class), isNull(), isNull(), isNull(), eq(ActionType.ADDED),
        isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, ActionType, User, Exception, Object[])}
   * with {@code tenantId}, {@code entityId}, {@code actionType}, {@code user},
   * {@code e}, {@code additionalInfo}.
   * <p>
   * Method under test:
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, ActionType, User, Exception, Object[])}
   */
  @Test
  @DisplayName("Test logEntityAction(TenantId, EntityId, ActionType, User, Exception, Object[]) with 'tenantId', 'entityId', 'actionType', 'user', 'e', 'additionalInfo'")
  void testLogEntityActionWithTenantIdEntityIdActionTypeUserEAdditionalInfo2() {
    // Arrange
    doNothing().when(entityActionService)
        .pushEntityActionToRuleEngine(Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));

    // Act
    defaultTbLogEntityActionService.logEntityAction(new TenantId(UUID.randomUUID()), null, ActionType.ADDED, null, null,
        "Additional Info");

    // Assert that nothing has changed
    verify(entityActionService).pushEntityActionToRuleEngine(isNull(), isNull(), isA(TenantId.class), isNull(),
        eq(ActionType.ADDED), isNull(), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, ActionType, User, Object[])}
   * with {@code tenantId}, {@code entityId}, {@code entity}, {@code actionType},
   * {@code user}, {@code additionalInfo}.
   * <p>
   * Method under test:
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, ActionType, User, Object[])}
   */
  @Test
  @DisplayName("Test logEntityAction(TenantId, EntityId, HasName, ActionType, User, Object[]) with 'tenantId', 'entityId', 'entity', 'actionType', 'user', 'additionalInfo'")
  void testLogEntityActionWithTenantIdEntityIdEntityActionTypeUserAdditionalInfo() {
    // Arrange
    doNothing().when(entityActionService)
        .logEntityAction(Mockito.<User>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<Exception>any(), isA(Object[].class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    HasName hasName = mock(HasName.class);

    // Act
    defaultTbLogEntityActionService.logEntityAction(tenantId, null, hasName, ActionType.ADDED, new User(),
        "Additional Info");

    // Assert that nothing has changed
    verify(entityActionService).logEntityAction(isA(User.class), isNull(), isA(HasName.class), isNull(),
        eq(ActionType.ADDED), isNull(), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, ActionType, User, Object[])}
   * with {@code tenantId}, {@code entityId}, {@code entity}, {@code actionType},
   * {@code user}, {@code additionalInfo}.
   * <p>
   * Method under test:
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, ActionType, User, Object[])}
   */
  @Test
  @DisplayName("Test logEntityAction(TenantId, EntityId, HasName, ActionType, User, Object[]) with 'tenantId', 'entityId', 'entity', 'actionType', 'user', 'additionalInfo'")
  void testLogEntityActionWithTenantIdEntityIdEntityActionTypeUserAdditionalInfo2() {
    // Arrange
    doNothing().when(entityActionService)
        .pushEntityActionToRuleEngine(Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));

    // Act
    defaultTbLogEntityActionService.logEntityAction(new TenantId(UUID.randomUUID()), null, mock(HasName.class),
        ActionType.ADDED, null, "Additional Info");

    // Assert that nothing has changed
    verify(entityActionService).pushEntityActionToRuleEngine(isNull(), isA(HasName.class), isA(TenantId.class),
        isNull(), eq(ActionType.ADDED), isNull(), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, ActionType, User, Exception, Object[])}
   * with {@code tenantId}, {@code entityId}, {@code entity}, {@code actionType},
   * {@code user}, {@code e}, {@code additionalInfo}.
   * <p>
   * Method under test:
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, ActionType, User, Exception, Object[])}
   */
  @Test
  @DisplayName("Test logEntityAction(TenantId, EntityId, HasName, ActionType, User, Exception, Object[]) with 'tenantId', 'entityId', 'entity', 'actionType', 'user', 'e', 'additionalInfo'")
  void testLogEntityActionWithTenantIdEntityIdEntityActionTypeUserEAdditionalInfo() {
    // Arrange
    doNothing().when(entityActionService)
        .logEntityAction(Mockito.<User>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<Exception>any(), isA(Object[].class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    HasName hasName = mock(HasName.class);
    User user = new User();

    // Act
    defaultTbLogEntityActionService.logEntityAction(tenantId, null, hasName, ActionType.ADDED, user,
        new Exception("foo"), "Additional Info");

    // Assert that nothing has changed
    verify(entityActionService).logEntityAction(isA(User.class), isNull(), isA(HasName.class), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, ActionType, User, Exception, Object[])}
   * with {@code tenantId}, {@code entityId}, {@code entity}, {@code actionType},
   * {@code user}, {@code e}, {@code additionalInfo}.
   * <p>
   * Method under test:
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, ActionType, User, Exception, Object[])}
   */
  @Test
  @DisplayName("Test logEntityAction(TenantId, EntityId, HasName, ActionType, User, Exception, Object[]) with 'tenantId', 'entityId', 'entity', 'actionType', 'user', 'e', 'additionalInfo'")
  void testLogEntityActionWithTenantIdEntityIdEntityActionTypeUserEAdditionalInfo2() {
    // Arrange
    doNothing().when(entityActionService)
        .pushEntityActionToRuleEngine(Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));

    // Act
    defaultTbLogEntityActionService.logEntityAction(new TenantId(UUID.randomUUID()), null, mock(HasName.class),
        ActionType.ADDED, null, null, "Additional Info");

    // Assert that nothing has changed
    verify(entityActionService).pushEntityActionToRuleEngine(isNull(), isA(HasName.class), isA(TenantId.class),
        isNull(), eq(ActionType.ADDED), isNull(), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, CustomerId, ActionType, User, Object[])}
   * with {@code tenantId}, {@code entityId}, {@code entity}, {@code customerId},
   * {@code actionType}, {@code user}, {@code additionalInfo}.
   * <p>
   * Method under test:
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, CustomerId, ActionType, User, Object[])}
   */
  @Test
  @DisplayName("Test logEntityAction(TenantId, EntityId, HasName, CustomerId, ActionType, User, Object[]) with 'tenantId', 'entityId', 'entity', 'customerId', 'actionType', 'user', 'additionalInfo'")
  void testLogEntityActionWithTenantIdEntityIdEntityCustomerIdActionTypeUserAdditionalInfo() {
    // Arrange
    doNothing().when(entityActionService)
        .logEntityAction(Mockito.<User>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<Exception>any(), isA(Object[].class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    HasName hasName = mock(HasName.class);
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    defaultTbLogEntityActionService.logEntityAction(tenantId, null, hasName, customerId, ActionType.ADDED, new User(),
        "Additional Info");

    // Assert that nothing has changed
    verify(entityActionService).logEntityAction(isA(User.class), isNull(), isA(HasName.class), isA(CustomerId.class),
        eq(ActionType.ADDED), isNull(), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, CustomerId, ActionType, User, Object[])}
   * with {@code tenantId}, {@code entityId}, {@code entity}, {@code customerId},
   * {@code actionType}, {@code user}, {@code additionalInfo}.
   * <p>
   * Method under test:
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, CustomerId, ActionType, User, Object[])}
   */
  @Test
  @DisplayName("Test logEntityAction(TenantId, EntityId, HasName, CustomerId, ActionType, User, Object[]) with 'tenantId', 'entityId', 'entity', 'customerId', 'actionType', 'user', 'additionalInfo'")
  void testLogEntityActionWithTenantIdEntityIdEntityCustomerIdActionTypeUserAdditionalInfo2() {
    // Arrange
    doNothing().when(entityActionService)
        .pushEntityActionToRuleEngine(Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    HasName hasName = mock(HasName.class);

    // Act
    defaultTbLogEntityActionService.logEntityAction(tenantId, null, hasName, new CustomerId(UUID.randomUUID()),
        ActionType.ADDED, null, "Additional Info");

    // Assert that nothing has changed
    verify(entityActionService).pushEntityActionToRuleEngine(isNull(), isA(HasName.class), isA(TenantId.class),
        isA(CustomerId.class), eq(ActionType.ADDED), isNull(), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, CustomerId, ActionType, User, Exception, Object[])}
   * with {@code tenantId}, {@code entityId}, {@code entity}, {@code customerId},
   * {@code actionType}, {@code user}, {@code e}, {@code additionalInfo}.
   * <p>
   * Method under test:
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, CustomerId, ActionType, User, Exception, Object[])}
   */
  @Test
  @DisplayName("Test logEntityAction(TenantId, EntityId, HasName, CustomerId, ActionType, User, Exception, Object[]) with 'tenantId', 'entityId', 'entity', 'customerId', 'actionType', 'user', 'e', 'additionalInfo'")
  void testLogEntityActionWithTenantIdEntityIdEntityCustomerIdActionTypeUserEAdditionalInfo() {
    // Arrange
    doNothing().when(entityActionService)
        .logEntityAction(Mockito.<User>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<Exception>any(), isA(Object[].class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    HasName hasName = mock(HasName.class);
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    User user = new User();

    // Act
    defaultTbLogEntityActionService.logEntityAction(tenantId, null, hasName, customerId, ActionType.ADDED, user,
        new Exception("foo"), "Additional Info");

    // Assert that nothing has changed
    verify(entityActionService).logEntityAction(isA(User.class), isNull(), isA(HasName.class), isA(CustomerId.class),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, CustomerId, ActionType, User, Exception, Object[])}
   * with {@code tenantId}, {@code entityId}, {@code entity}, {@code customerId},
   * {@code actionType}, {@code user}, {@code e}, {@code additionalInfo}.
   * <p>
   * Method under test:
   * {@link DefaultTbLogEntityActionService#logEntityAction(TenantId, EntityId, HasName, CustomerId, ActionType, User, Exception, Object[])}
   */
  @Test
  @DisplayName("Test logEntityAction(TenantId, EntityId, HasName, CustomerId, ActionType, User, Exception, Object[]) with 'tenantId', 'entityId', 'entity', 'customerId', 'actionType', 'user', 'e', 'additionalInfo'")
  void testLogEntityActionWithTenantIdEntityIdEntityCustomerIdActionTypeUserEAdditionalInfo2() {
    // Arrange
    doNothing().when(entityActionService)
        .pushEntityActionToRuleEngine(Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    HasName hasName = mock(HasName.class);

    // Act
    defaultTbLogEntityActionService.logEntityAction(tenantId, null, hasName, new CustomerId(UUID.randomUUID()),
        ActionType.ADDED, null, null, "Additional Info");

    // Assert that nothing has changed
    verify(entityActionService).pushEntityActionToRuleEngine(isNull(), isA(HasName.class), isA(TenantId.class),
        isA(CustomerId.class), eq(ActionType.ADDED), isNull(), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbLogEntityActionService#logEntityRelationAction(TenantId, CustomerId, EntityRelation, User, ActionType, Exception, Object[])}.
   * <ul>
   *   <li>Then calls
   * {@link EntityActionService#pushEntityActionToRuleEngine(EntityId, HasName, TenantId, CustomerId, ActionType, User, Object[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbLogEntityActionService#logEntityRelationAction(TenantId, CustomerId, EntityRelation, User, ActionType, Exception, Object[])}
   */
  @Test
  @DisplayName("Test logEntityRelationAction(TenantId, CustomerId, EntityRelation, User, ActionType, Exception, Object[]); then calls pushEntityActionToRuleEngine(EntityId, HasName, TenantId, CustomerId, ActionType, User, Object[])")
  void testLogEntityRelationAction_thenCallsPushEntityActionToRuleEngine() {
    // Arrange
    doNothing().when(entityActionService)
        .pushEntityActionToRuleEngine(Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    defaultTbLogEntityActionService.logEntityRelationAction(tenantId, customerId, new EntityRelation(), null,
        ActionType.ADDED, null, "Additional Info");

    // Assert that nothing has changed
    verify(entityActionService, atLeast(1)).pushEntityActionToRuleEngine(isNull(), isNull(), isA(TenantId.class),
        isA(CustomerId.class), eq(ActionType.ADDED), isNull(), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbLogEntityActionService#logEntityRelationAction(TenantId, CustomerId, EntityRelation, User, ActionType, Exception, Object[])}.
   * <ul>
   *   <li>When {@link User#User()}.</li>
   *   <li>Then calls
   * {@link EntityActionService#logEntityAction(User, EntityId, HasName, CustomerId, ActionType, Exception, Object[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbLogEntityActionService#logEntityRelationAction(TenantId, CustomerId, EntityRelation, User, ActionType, Exception, Object[])}
   */
  @Test
  @DisplayName("Test logEntityRelationAction(TenantId, CustomerId, EntityRelation, User, ActionType, Exception, Object[]); when User(); then calls logEntityAction(User, EntityId, HasName, CustomerId, ActionType, Exception, Object[])")
  void testLogEntityRelationAction_whenUser_thenCallsLogEntityAction() {
    // Arrange
    doNothing().when(entityActionService)
        .logEntityAction(Mockito.<User>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<Exception>any(), isA(Object[].class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    EntityRelation relation = new EntityRelation();
    User user = new User();

    // Act
    defaultTbLogEntityActionService.logEntityRelationAction(tenantId, customerId, relation, user, ActionType.ADDED,
        new Exception("foo"), "Additional Info");

    // Assert that nothing has changed
    verify(entityActionService, atLeast(1)).logEntityAction(isA(User.class), isNull(), isNull(), isA(CustomerId.class),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
  }
}
