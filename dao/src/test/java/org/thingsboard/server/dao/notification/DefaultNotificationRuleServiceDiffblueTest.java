package org.thingsboard.server.dao.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;

@ContextConfiguration(classes = {DefaultNotificationRuleService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultNotificationRuleServiceDiffblueTest {
  @MockBean
  private CleanUpService cleanUpService;

  @Autowired
  private DefaultNotificationRuleService defaultNotificationRuleService;

  @MockBean
  private NotificationRuleDao notificationRuleDao;

  /**
   * Test {@link DefaultNotificationRuleService#findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId, NotificationRuleTriggerType)}.
   * <p>
   * Method under test: {@link DefaultNotificationRuleService#findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId, NotificationRuleTriggerType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List DefaultNotificationRuleService.findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId, NotificationRuleTriggerType)"})
  public void testFindEnabledNotificationRulesByTenantIdAndTriggerType() {
    // Arrange
    when(notificationRuleDao.findByTenantIdAndTriggerTypeAndEnabled(Mockito.<TenantId>any(),
        Mockito.<NotificationRuleTriggerType>any(), anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationRuleService.findEnabledNotificationRulesByTenantIdAndTriggerType(
            ModelConstants.SYSTEM_TENANT, NotificationRuleTriggerType.ENTITY_ACTION));
    verify(notificationRuleDao).findByTenantIdAndTriggerTypeAndEnabled(isA(TenantId.class),
        eq(NotificationRuleTriggerType.ENTITY_ACTION), eq(true));
  }

  /**
   * Test {@link DefaultNotificationRuleService#findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId, NotificationRuleTriggerType)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationRuleService#findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId, NotificationRuleTriggerType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List DefaultNotificationRuleService.findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId, NotificationRuleTriggerType)"})
  public void testFindEnabledNotificationRulesByTenantIdAndTriggerType_thenReturnEmpty() {
    // Arrange
    when(notificationRuleDao.findByTenantIdAndTriggerTypeAndEnabled(Mockito.<TenantId>any(),
        Mockito.<NotificationRuleTriggerType>any(), anyBoolean())).thenReturn(new ArrayList<>());

    // Act
    List<NotificationRule> actualFindEnabledNotificationRulesByTenantIdAndTriggerTypeResult = defaultNotificationRuleService
        .findEnabledNotificationRulesByTenantIdAndTriggerType(ModelConstants.SYSTEM_TENANT,
            NotificationRuleTriggerType.ENTITY_ACTION);

    // Assert
    verify(notificationRuleDao).findByTenantIdAndTriggerTypeAndEnabled(isA(TenantId.class),
        eq(NotificationRuleTriggerType.ENTITY_ACTION), eq(true));
    assertTrue(actualFindEnabledNotificationRulesByTenantIdAndTriggerTypeResult.isEmpty());
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteNotificationRuleById(TenantId, NotificationRuleId)}.
   * <ul>
   *   <li>Then calls {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationRuleService#deleteNotificationRuleById(TenantId, NotificationRuleId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationRuleService.deleteNotificationRuleById(TenantId, NotificationRuleId)"})
  public void testDeleteNotificationRuleById_thenCallsHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(notificationRuleDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    defaultNotificationRuleService.deleteNotificationRuleById(ModelConstants.SYSTEM_TENANT,
        new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationRuleDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteNotificationRuleById(TenantId, NotificationRuleId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationRuleService#deleteNotificationRuleById(TenantId, NotificationRuleId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationRuleService.deleteNotificationRuleById(TenantId, NotificationRuleId)"})
  public void testDeleteNotificationRuleById_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(notificationRuleDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationRuleService.deleteNotificationRuleById(ModelConstants.SYSTEM_TENANT,
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(notificationRuleDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteEntity(TenantId, EntityId, boolean)}.
   * <p>
   * Method under test: {@link DefaultNotificationRuleService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationRuleService.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(notificationRuleDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationRuleService.deleteEntity(ModelConstants.SYSTEM_TENANT,
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), true));
    verify(notificationRuleDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteEntity(TenantId, EntityId, boolean)}.
   * <p>
   * Method under test: {@link DefaultNotificationRuleService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationRuleService.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity2() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(notificationRuleDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationRuleService.deleteEntity(tenantId,
        new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), true));
    verify(notificationRuleDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link CleanUpService} {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationRuleService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationRuleService.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_givenCleanUpServiceHandleEntityDeletionEventDoesNothing() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(notificationRuleDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    defaultNotificationRuleService.deleteEntity(ModelConstants.SYSTEM_TENANT,
        new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), true);

    // Assert
    verify(notificationRuleDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteNotificationRulesByTenantId(TenantId)}.
   * <p>
   * Method under test: {@link DefaultNotificationRuleService#deleteNotificationRulesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationRuleService.deleteNotificationRulesByTenantId(TenantId)"})
  public void testDeleteNotificationRulesByTenantId() {
    // Arrange
    doNothing().when(notificationRuleDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationRuleService.deleteNotificationRulesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationRuleDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteNotificationRulesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationRuleService#deleteNotificationRulesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationRuleService.deleteNotificationRulesByTenantId(TenantId)"})
  public void testDeleteNotificationRulesByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(notificationRuleDao).removeByTenantId(Mockito.<TenantId>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationRuleService.deleteNotificationRulesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(notificationRuleDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link NotificationRuleDao} {@link NotificationRuleDao#removeByTenantId(TenantId)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationRuleService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationRuleService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenNotificationRuleDaoRemoveByTenantIdDoesNothing() {
    // Arrange
    doNothing().when(notificationRuleDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationRuleService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationRuleDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationRuleService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationRuleService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(notificationRuleDao).removeByTenantId(Mockito.<TenantId>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationRuleService.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(notificationRuleDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#getEntityType()}.
   * <p>
   * Method under test: {@link DefaultNotificationRuleService#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType DefaultNotificationRuleService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.NOTIFICATION_RULE,
        (new DefaultNotificationRuleService(new JpaNotificationRuleDao(mock(NotificationRuleRepository.class))))
            .getEntityType());
  }
}
