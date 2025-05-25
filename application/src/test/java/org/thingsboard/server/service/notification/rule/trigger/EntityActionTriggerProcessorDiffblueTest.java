package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.notification.info.EntityActionNotificationInfo;
import org.thingsboard.server.common.data.notification.info.RuleOriginatedNotificationInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.EntityActionTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EntityActionNotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {EntityActionTriggerProcessor.class})
@ExtendWith(SpringExtension.class)
class EntityActionTriggerProcessorDiffblueTest {
  @Autowired
  private EntityActionTriggerProcessor entityActionTriggerProcessor;

  /**
   * Test {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)} with {@code EntityActionTrigger}, {@code EntityActionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig) with 'EntityActionTrigger', 'EntityActionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EntityActionTriggerProcessor.matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEntityActionTriggerEntityActionNotificationRuleTriggerConfig() {
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
   * Test {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)} with {@code EntityActionTrigger}, {@code EntityActionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig) with 'EntityActionTrigger', 'EntityActionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EntityActionTriggerProcessor.matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEntityActionTriggerEntityActionNotificationRuleTriggerConfig2() {
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
   * Test {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)} with {@code EntityActionTrigger}, {@code EntityActionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig) with 'EntityActionTrigger', 'EntityActionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EntityActionTriggerProcessor.matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEntityActionTriggerEntityActionNotificationRuleTriggerConfig3() {
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
   * Test {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)} with {@code EntityActionTrigger}, {@code EntityActionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig) with 'EntityActionTrigger', 'EntityActionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EntityActionTriggerProcessor.matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEntityActionTriggerEntityActionNotificationRuleTriggerConfig4() {
    // Arrange
    EntityActionTrigger trigger = mock(EntityActionTrigger.class);
    when(trigger.getEntityId()).thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(trigger.getActionType()).thenReturn(ActionType.ADDED);
    EntityActionNotificationRuleTriggerConfigBuilder deletedResult = EntityActionNotificationRuleTriggerConfig.builder()
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
   * Test {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)} with {@code EntityActionTrigger}, {@code EntityActionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig) with 'EntityActionTrigger', 'EntityActionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EntityActionTriggerProcessor.matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEntityActionTriggerEntityActionNotificationRuleTriggerConfig5() {
    // Arrange
    EntityActionTrigger trigger = mock(EntityActionTrigger.class);
    when(trigger.getEntityId()).thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(trigger.getActionType()).thenReturn(ActionType.DELETED);
    EntityActionNotificationRuleTriggerConfigBuilder deletedResult = EntityActionNotificationRuleTriggerConfig.builder()
        .created(true)
        .deleted(true);
    EntityActionNotificationRuleTriggerConfig triggerConfig = deletedResult.entityTypes(new HashSet<>())
        .updated(true)
        .build();

    // Act
    boolean actualMatchesFilterResult = entityActionTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger, atLeast(1)).getActionType();
    verify(trigger).getEntityId();
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)} with {@code EntityActionTrigger}, {@code EntityActionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig) with 'EntityActionTrigger', 'EntityActionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EntityActionTriggerProcessor.matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEntityActionTriggerEntityActionNotificationRuleTriggerConfig6() {
    // Arrange
    EntityActionTrigger trigger = mock(EntityActionTrigger.class);
    when(trigger.getEntityId()).thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(trigger.getActionType()).thenReturn(ActionType.UPDATED);
    EntityActionNotificationRuleTriggerConfigBuilder deletedResult = EntityActionNotificationRuleTriggerConfig.builder()
        .created(true)
        .deleted(true);
    EntityActionNotificationRuleTriggerConfig triggerConfig = deletedResult.entityTypes(new HashSet<>())
        .updated(true)
        .build();

    // Act
    boolean actualMatchesFilterResult = entityActionTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger, atLeast(1)).getActionType();
    verify(trigger).getEntityId();
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)} with {@code EntityActionTrigger}, {@code EntityActionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig) with 'EntityActionTrigger', 'EntityActionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EntityActionTriggerProcessor.matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEntityActionTriggerEntityActionNotificationRuleTriggerConfig7() {
    // Arrange
    EntityActionTrigger trigger = mock(EntityActionTrigger.class);
    when(trigger.getEntityId()).thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(trigger.getActionType()).thenReturn(ActionType.ADDED);

    HashSet<EntityType> entityTypes = new HashSet<>();
    entityTypes.add(EntityType.CUSTOMER);
    EntityActionNotificationRuleTriggerConfig triggerConfig = EntityActionNotificationRuleTriggerConfig.builder()
        .created(true)
        .deleted(true)
        .entityTypes(entityTypes)
        .updated(true)
        .build();

    // Act
    boolean actualMatchesFilterResult = entityActionTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).getActionType();
    verify(trigger).getEntityId();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)} with {@code EntityActionTrigger}, {@code EntityActionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EntityActionTriggerProcessor#matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig) with 'EntityActionTrigger', 'EntityActionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EntityActionTriggerProcessor.matchesFilter(EntityActionTrigger, EntityActionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEntityActionTriggerEntityActionNotificationRuleTriggerConfig8() {
    // Arrange
    EntityActionTriggerProcessor entityActionTriggerProcessor = new EntityActionTriggerProcessor();
    EntityActionTrigger trigger = mock(EntityActionTrigger.class);
    when(trigger.getEntityId()).thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(trigger.getActionType()).thenReturn(ActionType.ADDED);

    HashSet<EntityType> entityTypes = new HashSet<>();
    entityTypes.add(EntityType.CUSTOMER);
    EntityActionNotificationRuleTriggerConfig triggerConfig = EntityActionNotificationRuleTriggerConfig.builder()
        .created(true)
        .deleted(true)
        .entityTypes(entityTypes)
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
   * Test {@link EntityActionTriggerProcessor#constructNotificationInfo(EntityActionTrigger)} with {@code EntityActionTrigger}.
   * <ul>
   *   <li>Then EntityId return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionTriggerProcessor#constructNotificationInfo(EntityActionTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(EntityActionTrigger) with 'EntityActionTrigger'; then EntityId return AlarmId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleOriginatedNotificationInfo EntityActionTriggerProcessor.constructNotificationInfo(EntityActionTrigger)"})
  void testConstructNotificationInfoWithEntityActionTrigger_thenEntityIdReturnAlarmId() {
    // Arrange
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");
    User user = mock(User.class);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    when(user.getFirstName()).thenReturn("Jane");
    when(user.getLastName()).thenReturn("Doe");
    when(user.getTitle()).thenReturn("Dr");
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(user.getUuidId()).thenReturn(fromStringResult);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(user.getCustomerId()).thenReturn(customerId);
    EntityActionTrigger trigger = mock(EntityActionTrigger.class);
    when(trigger.getUser()).thenReturn(user);
    when(trigger.getActionType()).thenReturn(ActionType.ADDED);
    when(trigger.getEntity()).thenReturn(hasName);
    AlarmId alarmId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(trigger.getEntityId()).thenReturn(alarmId);

    // Act
    RuleOriginatedNotificationInfo actualConstructNotificationInfoResult = entityActionTriggerProcessor
        .constructNotificationInfo(trigger);
    Map<String, String> actualTemplateData = actualConstructNotificationInfoResult.getTemplateData();

    // Assert
    verify(hasName).getName();
    verify(user).getCustomerId();
    verify(user).getEmail();
    verify(user).getFirstName();
    verify(user).getLastName();
    verify(user).getTitle();
    verify(user).getUuidId();
    verify(trigger).getActionType();
    verify(trigger, atLeast(1)).getEntity();
    verify(trigger).getEntityId();
    verify(trigger, atLeast(1)).getUser();
    EntityId entityId = ((EntityActionNotificationInfo) actualConstructNotificationInfoResult).getEntityId();
    assertTrue(entityId instanceof AlarmId);
    assertTrue(actualConstructNotificationInfoResult instanceof EntityActionNotificationInfo);
    assertEquals("Doe", ((EntityActionNotificationInfo) actualConstructNotificationInfoResult).getUserLastName());
    assertEquals("Dr", ((EntityActionNotificationInfo) actualConstructNotificationInfoResult).getUserTitle());
    assertEquals("Jane", ((EntityActionNotificationInfo) actualConstructNotificationInfoResult).getUserFirstName());
    assertEquals("Name", ((EntityActionNotificationInfo) actualConstructNotificationInfoResult).getEntityName());
    assertEquals("jane.doe@example.org",
        ((EntityActionNotificationInfo) actualConstructNotificationInfoResult).getUserEmail());
    assertNull(actualConstructNotificationInfoResult.getDashboardId());
    assertNull(actualConstructNotificationInfoResult.getAffectedTenantId());
    assertNull(actualConstructNotificationInfoResult.getAffectedUserId());
    Map<String, String> templateData = actualConstructNotificationInfoResult.getTemplateData();
    assertEquals(9, templateData.size());
    assertEquals(ActionType.ADDED,
        ((EntityActionNotificationInfo) actualConstructNotificationInfoResult).getActionType());
    assertTrue(templateData.containsKey("actionType"));
    assertTrue(templateData.containsKey("entityId"));
    assertTrue(templateData.containsKey("entityName"));
    assertTrue(templateData.containsKey("entityType"));
    assertTrue(templateData.containsKey("userLastName"));
    assertTrue(templateData.containsKey("userTitle"));
    assertEquals(templateData, actualTemplateData);
    assertSame(alarmId, entityId);
    assertSame(alarmId, actualConstructNotificationInfoResult.getStateEntityId());
    assertSame(customerId,
        ((EntityActionNotificationInfo) actualConstructNotificationInfoResult).getEntityCustomerId());
    assertSame(customerId, actualConstructNotificationInfoResult.getAffectedCustomerId());
    assertSame(fromStringResult, ((EntityActionNotificationInfo) actualConstructNotificationInfoResult).getUserId());
  }

  /**
   * Test {@link EntityActionTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link EntityActionTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationRuleTriggerType EntityActionTriggerProcessor.getTriggerType()"})
  void testGetTriggerType() {
    // Arrange, Act and Assert
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, (new EntityActionTriggerProcessor()).getTriggerType());
  }
}
