package org.thingsboard.server.dao.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.NotificationRuleInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;

@ContextConfiguration(classes = {DefaultNotificationRuleService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DefaultNotificationRuleServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private CleanUpService cleanUpService;

  @Autowired
  private DefaultNotificationRuleService defaultNotificationRuleService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private NotificationRuleDao notificationRuleDao;

  @MockBean
  private RelationService relationService;

  /**
   * Test
   * {@link DefaultNotificationRuleService#saveNotificationRule(TenantId, NotificationRule)}.
   * <ul>
   *   <li>Given {@link NotificationRuleDao} {@link Dao#findById(TenantId, UUID)}
   * return {@link NotificationRule#NotificationRule()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#saveNotificationRule(TenantId, NotificationRule)}
   */
  @Test
  public void testSaveNotificationRule_givenNotificationRuleDaoFindByIdReturnNotificationRule() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(notificationRule);
    when(notificationRuleDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setId(new NotificationRuleId(UUID.randomUUID()));

    // Act
    NotificationRule actualSaveNotificationRuleResult = defaultNotificationRuleService
        .saveNotificationRule(ModelConstants.SYSTEM_TENANT, notificationRule2);

    // Assert
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(notificationRuleDao).saveAndFlush(isA(TenantId.class), isA(NotificationRule.class));
    assertEquals(notificationRule, actualSaveNotificationRuleResult);
  }

  /**
   * Test
   * {@link DefaultNotificationRuleService#saveNotificationRule(TenantId, NotificationRule)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#saveNotificationRule(TenantId, NotificationRule)}
   */
  @Test
  public void testSaveNotificationRule_thenThrowIllegalArgumentException() {
    // Arrange
    NotificationRule notificationRule = mock(NotificationRule.class);
    when(notificationRule.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(notificationRule);

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setId(new NotificationRuleId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationRuleService.saveNotificationRule(ModelConstants.SYSTEM_TENANT, notificationRule2));
    verify(notificationRule).getTriggerType();
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DefaultNotificationRuleService#saveNotificationRule(TenantId, NotificationRule)}.
   * <ul>
   *   <li>When {@link NotificationRule#NotificationRule()}.</li>
   *   <li>Then return {@link NotificationRule#NotificationRule()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#saveNotificationRule(TenantId, NotificationRule)}
   */
  @Test
  public void testSaveNotificationRule_whenNotificationRule_thenReturnNotificationRule() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    when(notificationRuleDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(notificationRule);

    // Act
    NotificationRule actualSaveNotificationRuleResult = defaultNotificationRuleService
        .saveNotificationRule(ModelConstants.SYSTEM_TENANT, new NotificationRule());

    // Assert
    verify(notificationRuleDao).saveAndFlush(isA(TenantId.class), isA(NotificationRule.class));
    assertSame(notificationRule, actualSaveNotificationRuleResult);
  }

  /**
   * Test
   * {@link DefaultNotificationRuleService#findNotificationRuleById(TenantId, NotificationRuleId)}.
   * <ul>
   *   <li>Then return {@link NotificationRule#NotificationRule()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#findNotificationRuleById(TenantId, NotificationRuleId)}
   */
  @Test
  public void testFindNotificationRuleById_thenReturnNotificationRule() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(notificationRule);

    // Act
    NotificationRule actualFindNotificationRuleByIdResult = defaultNotificationRuleService
        .findNotificationRuleById(ModelConstants.SYSTEM_TENANT, new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(notificationRule, actualFindNotificationRuleByIdResult);
  }

  /**
   * Test
   * {@link DefaultNotificationRuleService#findNotificationRuleById(TenantId, NotificationRuleId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#findNotificationRuleById(TenantId, NotificationRuleId)}
   */
  @Test
  public void testFindNotificationRuleById_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationRuleService
        .findNotificationRuleById(ModelConstants.SYSTEM_TENANT, new NotificationRuleId(ModelConstants.NULL_UUID)));
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DefaultNotificationRuleService#findNotificationRuleInfoById(TenantId, NotificationRuleId)}.
   * <ul>
   *   <li>Then return {@link NotificationRuleInfo#NotificationRuleInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#findNotificationRuleInfoById(TenantId, NotificationRuleId)}
   */
  @Test
  public void testFindNotificationRuleInfoById_thenReturnNotificationRuleInfo() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    when(notificationRuleDao.findInfoById(Mockito.<TenantId>any(), Mockito.<NotificationRuleId>any()))
        .thenReturn(notificationRuleInfo);

    // Act
    NotificationRuleInfo actualFindNotificationRuleInfoByIdResult = defaultNotificationRuleService
        .findNotificationRuleInfoById(ModelConstants.SYSTEM_TENANT, new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRuleDao).findInfoById(isA(TenantId.class), isA(NotificationRuleId.class));
    assertSame(notificationRuleInfo, actualFindNotificationRuleInfoByIdResult);
  }

  /**
   * Test
   * {@link DefaultNotificationRuleService#findNotificationRuleInfoById(TenantId, NotificationRuleId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#findNotificationRuleInfoById(TenantId, NotificationRuleId)}
   */
  @Test
  public void testFindNotificationRuleInfoById_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationRuleDao.findInfoById(Mockito.<TenantId>any(), Mockito.<NotificationRuleId>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationRuleService
        .findNotificationRuleInfoById(ModelConstants.SYSTEM_TENANT, new NotificationRuleId(ModelConstants.NULL_UUID)));
    verify(notificationRuleDao).findInfoById(isA(TenantId.class), isA(NotificationRuleId.class));
  }

  /**
   * Test
   * {@link DefaultNotificationRuleService#findNotificationRulesInfosByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#findNotificationRulesInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindNotificationRulesInfosByTenantId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<NotificationRuleInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRuleDao.findInfosByTenantIdAndPageLink(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationRuleInfo> actualFindNotificationRulesInfosByTenantIdResult = defaultNotificationRuleService
        .findNotificationRulesInfosByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRuleDao).findInfosByTenantIdAndPageLink(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindNotificationRulesInfosByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindNotificationRulesInfosByTenantIdResult);
  }

  /**
   * Test
   * {@link DefaultNotificationRuleService#findNotificationRulesInfosByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#findNotificationRulesInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindNotificationRulesInfosByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationRuleDao.findInfosByTenantIdAndPageLink(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationRuleService
        .findNotificationRulesInfosByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationRuleDao).findInfosByTenantIdAndPageLink(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultNotificationRuleService#findNotificationRulesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#findNotificationRulesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindNotificationRulesByTenantId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<NotificationRule> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRuleDao.findByTenantIdAndPageLink(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationRule> actualFindNotificationRulesByTenantIdResult = defaultNotificationRuleService
        .findNotificationRulesByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRuleDao).findByTenantIdAndPageLink(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindNotificationRulesByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindNotificationRulesByTenantIdResult);
  }

  /**
   * Test
   * {@link DefaultNotificationRuleService#findNotificationRulesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#findNotificationRulesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindNotificationRulesByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationRuleDao.findByTenantIdAndPageLink(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationRuleService
        .findNotificationRulesByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationRuleDao).findByTenantIdAndPageLink(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultNotificationRuleService#findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId, NotificationRuleTriggerType)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId, NotificationRuleTriggerType)}
   */
  @Test
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
   * Test
   * {@link DefaultNotificationRuleService#findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId, NotificationRuleTriggerType)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId, NotificationRuleTriggerType)}
   */
  @Test
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
   * Test
   * {@link DefaultNotificationRuleService#deleteNotificationRuleById(TenantId, NotificationRuleId)}.
   * <ul>
   *   <li>Then calls
   * {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#deleteNotificationRuleById(TenantId, NotificationRuleId)}
   */
  @Test
  public void testDeleteNotificationRuleById_thenCallsHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(notificationRuleDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    defaultNotificationRuleService.deleteNotificationRuleById(ModelConstants.SYSTEM_TENANT,
        new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRuleDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test
   * {@link DefaultNotificationRuleService#deleteNotificationRuleById(TenantId, NotificationRuleId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#deleteNotificationRuleById(TenantId, NotificationRuleId)}
   */
  @Test
  public void testDeleteNotificationRuleById_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(notificationRuleDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationRuleService
        .deleteNotificationRuleById(ModelConstants.SYSTEM_TENANT, new NotificationRuleId(ModelConstants.NULL_UUID)));
    verify(notificationRuleDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DefaultNotificationRuleService#deleteNotificationRulesByTenantId(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#deleteNotificationRulesByTenantId(TenantId)}
   */
  @Test
  public void testDeleteNotificationRulesByTenantId() {
    // Arrange
    doNothing().when(notificationRuleDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationRuleService.deleteNotificationRulesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(notificationRuleDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultNotificationRuleService#deleteNotificationRulesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#deleteNotificationRulesByTenantId(TenantId)}
   */
  @Test
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
   *   <li>Given {@link NotificationRuleDao}
   * {@link NotificationRuleDao#removeByTenantId(TenantId)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_givenNotificationRuleDaoRemoveByTenantIdDoesNothing() {
    // Arrange
    doNothing().when(notificationRuleDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationRuleService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(notificationRuleDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(notificationRuleDao).removeByTenantId(Mockito.<TenantId>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationRuleService.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(notificationRuleDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_thenReturnPresent() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(notificationRule);

    // Act
    Optional<HasId<?>> actualFindEntityResult = defaultNotificationRuleService.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(notificationRule, actualFindEntityResult.get());
  }

  /**
   * Test {@link DefaultNotificationRuleService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationRuleService
        .findEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#getEntityType()}.
   * <p>
   * Method under test: {@link DefaultNotificationRuleService#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.NOTIFICATION_RULE,
        (new DefaultNotificationRuleService(new JpaNotificationRuleDao(mock(NotificationRuleRepository.class))))
            .getEntityType());
  }
}
