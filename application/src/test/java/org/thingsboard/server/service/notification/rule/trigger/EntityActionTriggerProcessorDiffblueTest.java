package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.EntityActionTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EntityActionNotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {EntityActionTriggerProcessor.class})
@ExtendWith(SpringExtension.class)
class EntityActionTriggerProcessorDiffblueTest {
  @Autowired
  private EntityActionTriggerProcessor entityActionTriggerProcessor;

  /**
   * Test
   * {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   * with {@code EntityActionTrigger},
   * {@code EntityActionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig) with 'EntityActionTrigger', 'EntityActionNotificationRuleTriggerConfig'")
  void testMatchesFilterWithEntityActionTriggerEntityActionNotificationRuleTriggerConfig() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder entityActionTriggerBuilder = mock(
        EntityActionTrigger.EntityActionTriggerBuilder.class);
    when(entityActionTriggerBuilder.entity(Mockito.<HasName>any())).thenReturn(EntityActionTrigger.builder());
    EntityActionTrigger.EntityActionTriggerBuilder entityActionTriggerBuilder2 = mock(
        EntityActionTrigger.EntityActionTriggerBuilder.class);
    when(entityActionTriggerBuilder2.actionType(Mockito.<ActionType>any())).thenReturn(entityActionTriggerBuilder);
    EntityActionTrigger.EntityActionTriggerBuilder entityIdResult = entityActionTriggerBuilder2
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(null);
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = entityIdResult
        .tenantId(new TenantId(UUID.randomUUID()));
    EntityActionTrigger trigger = tenantIdResult.user(new User()).build();
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult = EntityActionNotificationRuleTriggerConfig
        .builder()
        .created(true)
        .deleted(true);
    EntityActionNotificationRuleTriggerConfig triggerConfig = deletedResult.entityTypes(new HashSet<>())
        .updated(true)
        .build();

    // Act
    boolean actualMatchesFilterResult = entityActionTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(entityActionTriggerBuilder2).actionType(eq(ActionType.ADDED));
    verify(entityActionTriggerBuilder).entity(isA(HasName.class));
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   * with {@code EntityActionTrigger},
   * {@code EntityActionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig) with 'EntityActionTrigger', 'EntityActionNotificationRuleTriggerConfig'")
  void testMatchesFilterWithEntityActionTriggerEntityActionNotificationRuleTriggerConfig2() {
    // Arrange
    EntityActionTrigger trigger = mock(EntityActionTrigger.class);
    when(trigger.getActionType()).thenReturn(ActionType.ADDED);

    // Act
    boolean actualMatchesFilterResult = entityActionTriggerProcessor.matchesFilter(trigger,
        new EntityActionNotificationRuleTriggerConfig());

    // Assert
    verify(trigger, atLeast(1)).getActionType();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   * with {@code EntityActionTrigger},
   * {@code EntityActionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig) with 'EntityActionTrigger', 'EntityActionNotificationRuleTriggerConfig'")
  void testMatchesFilterWithEntityActionTriggerEntityActionNotificationRuleTriggerConfig3() {
    // Arrange
    EntityActionTrigger trigger = mock(EntityActionTrigger.class);
    when(trigger.getActionType()).thenReturn(ActionType.DELETED);

    // Act
    boolean actualMatchesFilterResult = entityActionTriggerProcessor.matchesFilter(trigger,
        new EntityActionNotificationRuleTriggerConfig());

    // Assert
    verify(trigger, atLeast(1)).getActionType();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   * with {@code EntityActionTrigger},
   * {@code EntityActionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig) with 'EntityActionTrigger', 'EntityActionNotificationRuleTriggerConfig'")
  void testMatchesFilterWithEntityActionTriggerEntityActionNotificationRuleTriggerConfig4() {
    // Arrange
    EntityActionTrigger trigger = mock(EntityActionTrigger.class);
    when(trigger.getActionType()).thenReturn(ActionType.UPDATED);

    // Act
    boolean actualMatchesFilterResult = entityActionTriggerProcessor.matchesFilter(trigger,
        new EntityActionNotificationRuleTriggerConfig());

    // Assert
    verify(trigger, atLeast(1)).getActionType();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   * with {@code EntityActionTrigger},
   * {@code EntityActionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig) with 'EntityActionTrigger', 'EntityActionNotificationRuleTriggerConfig'")
  void testMatchesFilterWithEntityActionTriggerEntityActionNotificationRuleTriggerConfig5() {
    // Arrange
    EntityActionTrigger trigger = mock(EntityActionTrigger.class);
    when(trigger.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(trigger.getActionType()).thenReturn(ActionType.ADDED);
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult = EntityActionNotificationRuleTriggerConfig
        .builder()
        .created(true)
        .deleted(true);
    EntityActionNotificationRuleTriggerConfig triggerConfig = deletedResult.entityTypes(new HashSet<>())
        .updated(true)
        .build();

    // Act
    boolean actualMatchesFilterResult = entityActionTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).getActionType();
    verify(trigger).getEntityId();
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test {@link EntityActionTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link EntityActionTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  void testGetTriggerType() {
    // Arrange, Act and Assert
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, (new EntityActionTriggerProcessor()).getTriggerType());
  }
}
