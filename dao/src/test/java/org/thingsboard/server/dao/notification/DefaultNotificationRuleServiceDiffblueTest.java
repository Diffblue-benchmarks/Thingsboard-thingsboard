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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.NotificationRuleInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;

@ContextConfiguration(classes = {DefaultNotificationRuleService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultNotificationRuleServiceDiffblueTest {
  @MockBean private CleanUpService cleanUpService;

  @Autowired private DefaultNotificationRuleService defaultNotificationRuleService;

  @MockBean private NotificationRuleDao notificationRuleDao;

  /**
   * Test {@link DefaultNotificationRuleService#saveNotificationRule(TenantId, NotificationRule)}.
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#saveNotificationRule(TenantId,
   * NotificationRule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "NotificationRule DefaultNotificationRuleService.saveNotificationRule(TenantId, NotificationRule)"
  })
  public void testSaveNotificationRule() {
    // Arrange
    when(notificationRuleDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenThrow(new IllegalArgumentException("uq_notification_rule_name"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationRuleService.saveNotificationRule(
                ModelConstants.SYSTEM_TENANT, new NotificationRule()));
    verify(notificationRuleDao).saveAndFlush(isA(TenantId.class), isA(NotificationRule.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#saveNotificationRule(TenantId, NotificationRule)}.
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#saveNotificationRule(TenantId,
   * NotificationRule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "NotificationRule DefaultNotificationRuleService.saveNotificationRule(TenantId, NotificationRule)"
  })
  public void testSaveNotificationRule2() {
    // Arrange
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setId(new NotificationRuleId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationRuleService.saveNotificationRule(
                ModelConstants.SYSTEM_TENANT, notificationRule));
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#saveNotificationRule(TenantId, NotificationRule)}.
   *
   * <ul>
   *   <li>Given {@link NotificationRuleDao} {@link NotificationRuleDao#findById(TenantId, UUID)}
   *       return {@link NotificationRule#NotificationRule()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#saveNotificationRule(TenantId,
   * NotificationRule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "NotificationRule DefaultNotificationRuleService.saveNotificationRule(TenantId, NotificationRule)"
  })
  public void testSaveNotificationRule_givenNotificationRuleDaoFindByIdReturnNotificationRule() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationRule);
    when(notificationRuleDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setId(new NotificationRuleId(ModelConstants.NULL_UUID));

    // Act
    NotificationRule actualSaveNotificationRuleResult =
        defaultNotificationRuleService.saveNotificationRule(
            ModelConstants.SYSTEM_TENANT, notificationRule2);

    // Assert
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(notificationRuleDao).saveAndFlush(isA(TenantId.class), isA(NotificationRule.class));
    assertEquals(notificationRule, actualSaveNotificationRuleResult);
  }

  /**
   * Test {@link DefaultNotificationRuleService#saveNotificationRule(TenantId, NotificationRule)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationRule#getTriggerType()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#saveNotificationRule(TenantId,
   * NotificationRule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "NotificationRule DefaultNotificationRuleService.saveNotificationRule(TenantId, NotificationRule)"
  })
  public void testSaveNotificationRule_thenCallsGetTriggerType() {
    // Arrange
    NotificationRule notificationRule = mock(NotificationRule.class);
    when(notificationRule.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationRule);

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setId(new NotificationRuleId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationRuleService.saveNotificationRule(
                ModelConstants.SYSTEM_TENANT, notificationRule2));
    verify(notificationRule).getTriggerType();
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#saveNotificationRule(TenantId, NotificationRule)}.
   *
   * <ul>
   *   <li>When {@link NotificationRule#NotificationRule()}.
   *   <li>Then return {@link NotificationRule#NotificationRule()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#saveNotificationRule(TenantId,
   * NotificationRule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "NotificationRule DefaultNotificationRuleService.saveNotificationRule(TenantId, NotificationRule)"
  })
  public void testSaveNotificationRule_whenNotificationRule_thenReturnNotificationRule() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    when(notificationRuleDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(notificationRule);

    // Act
    NotificationRule actualSaveNotificationRuleResult =
        defaultNotificationRuleService.saveNotificationRule(
            ModelConstants.SYSTEM_TENANT, new NotificationRule());

    // Assert
    verify(notificationRuleDao).saveAndFlush(isA(TenantId.class), isA(NotificationRule.class));
    assertSame(notificationRule, actualSaveNotificationRuleResult);
  }

  /**
   * Test {@link DefaultNotificationRuleService#findNotificationRuleById(TenantId,
   * NotificationRuleId)}.
   *
   * <ul>
   *   <li>Then return {@link NotificationRule#NotificationRule()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#findNotificationRuleById(TenantId,
   * NotificationRuleId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "NotificationRule DefaultNotificationRuleService.findNotificationRuleById(TenantId, NotificationRuleId)"
  })
  public void testFindNotificationRuleById_thenReturnNotificationRule() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationRule);

    // Act
    NotificationRule actualFindNotificationRuleByIdResult =
        defaultNotificationRuleService.findNotificationRuleById(
            ModelConstants.SYSTEM_TENANT,
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(notificationRule, actualFindNotificationRuleByIdResult);
  }

  /**
   * Test {@link DefaultNotificationRuleService#findNotificationRuleById(TenantId,
   * NotificationRuleId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#findNotificationRuleById(TenantId,
   * NotificationRuleId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "NotificationRule DefaultNotificationRuleService.findNotificationRuleById(TenantId, NotificationRuleId)"
  })
  public void testFindNotificationRuleById_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationRuleService.findNotificationRuleById(
                ModelConstants.SYSTEM_TENANT,
                new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#findNotificationRuleInfoById(TenantId,
   * NotificationRuleId)}.
   *
   * <ul>
   *   <li>Then return {@link NotificationRuleInfo#NotificationRuleInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationRuleService#findNotificationRuleInfoById(TenantId, NotificationRuleId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "NotificationRuleInfo DefaultNotificationRuleService.findNotificationRuleInfoById(TenantId, NotificationRuleId)"
  })
  public void testFindNotificationRuleInfoById_thenReturnNotificationRuleInfo() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    when(notificationRuleDao.findInfoById(
            Mockito.<TenantId>any(), Mockito.<NotificationRuleId>any()))
        .thenReturn(notificationRuleInfo);

    // Act
    NotificationRuleInfo actualFindNotificationRuleInfoByIdResult =
        defaultNotificationRuleService.findNotificationRuleInfoById(
            ModelConstants.SYSTEM_TENANT,
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationRuleDao).findInfoById(isA(TenantId.class), isA(NotificationRuleId.class));
    assertSame(notificationRuleInfo, actualFindNotificationRuleInfoByIdResult);
  }

  /**
   * Test {@link DefaultNotificationRuleService#findNotificationRuleInfoById(TenantId,
   * NotificationRuleId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationRuleService#findNotificationRuleInfoById(TenantId, NotificationRuleId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "NotificationRuleInfo DefaultNotificationRuleService.findNotificationRuleInfoById(TenantId, NotificationRuleId)"
  })
  public void testFindNotificationRuleInfoById_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationRuleDao.findInfoById(
            Mockito.<TenantId>any(), Mockito.<NotificationRuleId>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationRuleService.findNotificationRuleInfoById(
                ModelConstants.SYSTEM_TENANT,
                new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(notificationRuleDao).findInfoById(isA(TenantId.class), isA(NotificationRuleId.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#findNotificationRulesInfosByTenantId(TenantId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationRuleService#findNotificationRulesInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DefaultNotificationRuleService.findNotificationRulesInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindNotificationRulesInfosByTenantId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<NotificationRuleInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRuleDao.findInfosByTenantIdAndPageLink(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationRuleInfo> actualFindNotificationRulesInfosByTenantIdResult =
        defaultNotificationRuleService.findNotificationRulesInfosByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRuleDao)
        .findInfosByTenantIdAndPageLink(isA(TenantId.class), isA(PageLink.class));
    assertSame(
        actualFindNotificationRulesInfosByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindNotificationRulesInfosByTenantIdResult);
  }

  /**
   * Test {@link DefaultNotificationRuleService#findNotificationRulesInfosByTenantId(TenantId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationRuleService#findNotificationRulesInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DefaultNotificationRuleService.findNotificationRulesInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindNotificationRulesInfosByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationRuleDao.findInfosByTenantIdAndPageLink(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationRuleService.findNotificationRulesInfosByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationRuleDao)
        .findInfosByTenantIdAndPageLink(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#findNotificationRulesByTenantId(TenantId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationRuleService#findNotificationRulesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DefaultNotificationRuleService.findNotificationRulesByTenantId(TenantId, PageLink)"
  })
  public void testFindNotificationRulesByTenantId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<NotificationRule> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRuleDao.findByTenantIdAndPageLink(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationRule> actualFindNotificationRulesByTenantIdResult =
        defaultNotificationRuleService.findNotificationRulesByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRuleDao).findByTenantIdAndPageLink(isA(TenantId.class), isA(PageLink.class));
    assertSame(
        actualFindNotificationRulesByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindNotificationRulesByTenantIdResult);
  }

  /**
   * Test {@link DefaultNotificationRuleService#findNotificationRulesByTenantId(TenantId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationRuleService#findNotificationRulesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DefaultNotificationRuleService.findNotificationRulesByTenantId(TenantId, PageLink)"
  })
  public void testFindNotificationRulesByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationRuleDao.findByTenantIdAndPageLink(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationRuleService.findNotificationRulesByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationRuleDao).findByTenantIdAndPageLink(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link
   * DefaultNotificationRuleService#findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId,
   * NotificationRuleTriggerType)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationRuleService#findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId,
   * NotificationRuleTriggerType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "List DefaultNotificationRuleService.findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId, NotificationRuleTriggerType)"
  })
  public void testFindEnabledNotificationRulesByTenantIdAndTriggerType() {
    // Arrange
    when(notificationRuleDao.findByTenantIdAndTriggerTypeAndEnabled(
            Mockito.<TenantId>any(), Mockito.<NotificationRuleTriggerType>any(), anyBoolean()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationRuleService.findEnabledNotificationRulesByTenantIdAndTriggerType(
                ModelConstants.SYSTEM_TENANT, NotificationRuleTriggerType.ENTITY_ACTION));
    verify(notificationRuleDao)
        .findByTenantIdAndTriggerTypeAndEnabled(
            isA(TenantId.class), eq(NotificationRuleTriggerType.ENTITY_ACTION), eq(true));
  }

  /**
   * Test {@link
   * DefaultNotificationRuleService#findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId,
   * NotificationRuleTriggerType)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationRuleService#findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId,
   * NotificationRuleTriggerType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "List DefaultNotificationRuleService.findEnabledNotificationRulesByTenantIdAndTriggerType(TenantId, NotificationRuleTriggerType)"
  })
  public void testFindEnabledNotificationRulesByTenantIdAndTriggerType_thenReturnEmpty() {
    // Arrange
    when(notificationRuleDao.findByTenantIdAndTriggerTypeAndEnabled(
            Mockito.<TenantId>any(), Mockito.<NotificationRuleTriggerType>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());

    // Act
    List<NotificationRule> actualFindEnabledNotificationRulesByTenantIdAndTriggerTypeResult =
        defaultNotificationRuleService.findEnabledNotificationRulesByTenantIdAndTriggerType(
            ModelConstants.SYSTEM_TENANT, NotificationRuleTriggerType.ENTITY_ACTION);

    // Assert
    verify(notificationRuleDao)
        .findByTenantIdAndTriggerTypeAndEnabled(
            isA(TenantId.class), eq(NotificationRuleTriggerType.ENTITY_ACTION), eq(true));
    assertTrue(actualFindEnabledNotificationRulesByTenantIdAndTriggerTypeResult.isEmpty());
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteNotificationRuleById(TenantId,
   * NotificationRuleId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationRuleService#deleteNotificationRuleById(TenantId, NotificationRuleId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DefaultNotificationRuleService.deleteNotificationRuleById(TenantId, NotificationRuleId)"
  })
  public void testDeleteNotificationRuleById() {
    // Arrange
    doThrow(new IllegalArgumentException("foo"))
        .when(notificationRuleDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationRuleService.deleteNotificationRuleById(
                ModelConstants.SYSTEM_TENANT,
                new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(notificationRuleDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteNotificationRuleById(TenantId,
   * NotificationRuleId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationRuleService#deleteNotificationRuleById(TenantId, NotificationRuleId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DefaultNotificationRuleService.deleteNotificationRuleById(TenantId, NotificationRuleId)"
  })
  public void testDeleteNotificationRuleById2() {
    // Arrange
    doThrow(new IllegalArgumentException("foo"))
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(notificationRuleDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationRuleService.deleteNotificationRuleById(
                ModelConstants.SYSTEM_TENANT,
                new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(notificationRuleDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteNotificationRuleById(TenantId,
   * NotificationRuleId)}.
   *
   * <ul>
   *   <li>Then calls {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationRuleService#deleteNotificationRuleById(TenantId, NotificationRuleId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DefaultNotificationRuleService.deleteNotificationRuleById(TenantId, NotificationRuleId)"
  })
  public void testDeleteNotificationRuleById_thenCallsHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(notificationRuleDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    defaultNotificationRuleService.deleteNotificationRuleById(
        ModelConstants.SYSTEM_TENANT,
        new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationRuleDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DefaultNotificationRuleService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity() {
    // Arrange
    doThrow(new IllegalArgumentException("foo"))
        .when(notificationRuleDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationRuleService.deleteEntity(
                ModelConstants.SYSTEM_TENANT,
                new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                true));
    verify(notificationRuleDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DefaultNotificationRuleService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity2() {
    // Arrange
    doThrow(new IllegalArgumentException("foo"))
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(notificationRuleDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationRuleService.deleteEntity(
                ModelConstants.SYSTEM_TENANT,
                new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                true));
    verify(notificationRuleDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link CleanUpService} {@link
   *       CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DefaultNotificationRuleService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity_givenCleanUpServiceHandleEntityDeletionEventDoesNothing() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(notificationRuleDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    defaultNotificationRuleService.deleteEntity(
        ModelConstants.SYSTEM_TENANT,
        new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
        true);

    // Assert
    verify(notificationRuleDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteNotificationRulesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationRuleService#deleteNotificationRulesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DefaultNotificationRuleService.deleteNotificationRulesByTenantId(TenantId)"
  })
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationRuleService#deleteNotificationRulesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DefaultNotificationRuleService.deleteNotificationRulesByTenantId(TenantId)"
  })
  public void testDeleteNotificationRulesByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo"))
        .when(notificationRuleDao)
        .removeByTenantId(Mockito.<TenantId>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationRuleService.deleteNotificationRulesByTenantId(
                ModelConstants.SYSTEM_TENANT));
    verify(notificationRuleDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link NotificationRuleDao} {@link NotificationRuleDao#removeByTenantId(TenantId)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#deleteByTenantId(TenantId)}
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationRuleService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo"))
        .when(notificationRuleDao)
        .removeByTenantId(Mockito.<TenantId>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultNotificationRuleService.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(notificationRuleDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional DefaultNotificationRuleService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenReturnPresent() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationRule);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        defaultNotificationRuleService.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(notificationRule, actualFindEntityResult.get());
  }

  /**
   * Test {@link DefaultNotificationRuleService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional DefaultNotificationRuleService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationRuleService.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationRuleService#getEntityType()}.
   *
   * <p>Method under test: {@link DefaultNotificationRuleService#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType DefaultNotificationRuleService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(
        EntityType.NOTIFICATION_RULE,
        new DefaultNotificationRuleService(
                new JpaNotificationRuleDao(mock(NotificationRuleRepository.class)))
            .getEntityType());
  }
}
