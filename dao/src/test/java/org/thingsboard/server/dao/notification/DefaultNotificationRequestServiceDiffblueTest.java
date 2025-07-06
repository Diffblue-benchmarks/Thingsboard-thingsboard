package org.thingsboard.server.dao.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationRequest;
import org.thingsboard.server.common.data.notification.NotificationRequest.NotificationRequestBuilder;
import org.thingsboard.server.common.data.notification.NotificationRequestInfo;
import org.thingsboard.server.common.data.notification.NotificationRequestStats;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.notification.JpaNotificationDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.NotificationRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {DefaultNotificationRequestService.class})
@DisabledInAotMode
@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultNotificationRequestServiceDiffblueTest {
  @Autowired private DefaultNotificationRequestService defaultNotificationRequestService;

  @InjectMocks private DefaultNotificationRequestService defaultNotificationRequestService2;

  @MockBean private NotificationDao notificationDao;

  @MockBean private NotificationRequestDao notificationRequestDao;

  @Mock private NotificationRequestDao notificationRequestDao2;

  /**
   * Test {@link DefaultNotificationRequestService#saveNotificationRequest(TenantId,
   * NotificationRequest)}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationRequestService#saveNotificationRequest(TenantId, NotificationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "NotificationRequest DefaultNotificationRequestService.saveNotificationRequest(TenantId, NotificationRequest)"
  })
  public void testSaveNotificationRequest_thenOriginatorEntityIdReturnCustomerId() {
    // Arrange
    NotificationRequestBuilder originatorEntityIdResult =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRuleId ruleId =
        new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRequestBuilder ruleIdResult = originatorEntityIdResult.ruleId(ruleId);
    NotificationRequestStats stats = new NotificationRequestStats();
    NotificationRequestBuilder statusResult =
        ruleIdResult.stats(stats).status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationTemplate template = new NotificationTemplate();
    NotificationRequestBuilder templateResult = targetsResult.template(template);
    NotificationTemplateId templateId =
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRequest buildResult =
        templateResult.templateId(templateId).tenantId(ModelConstants.SYSTEM_TENANT).build();
    when(notificationRequestDao2.save(Mockito.<TenantId>any(), Mockito.<NotificationRequest>any()))
        .thenReturn(buildResult);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    ArrayList<UUID> targets = new ArrayList<>();
    targets.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setTargets(targets);

    // Act
    NotificationRequest actualSaveNotificationRequestResult =
        defaultNotificationRequestService2.saveNotificationRequest(tenantId, notificationRequest);

    // Assert
    verify(notificationRequestDao2).save(isA(TenantId.class), isA(NotificationRequest.class));
    assertTrue(actualSaveNotificationRequestResult.getOriginatorEntityId() instanceof CustomerId);
    assertEquals("To targets []", actualSaveNotificationRequestResult.getName());
    assertNull(actualSaveNotificationRequestResult.getUuidId());
    assertNull(actualSaveNotificationRequestResult.getId());
    assertNull(actualSaveNotificationRequestResult.getSenderId());
    assertNull(actualSaveNotificationRequestResult.getAdditionalConfig());
    assertEquals(0L, actualSaveNotificationRequestResult.getCreatedTime());
    assertEquals(
        NotificationRequestStatus.PROCESSING, actualSaveNotificationRequestResult.getStatus());
    assertFalse(actualSaveNotificationRequestResult.isScheduled());
    assertFalse(actualSaveNotificationRequestResult.isSent());
    assertTrue(actualSaveNotificationRequestResult.getTargets().isEmpty());
    assertSame(ruleId, actualSaveNotificationRequestResult.getRuleId());
    assertSame(templateId, actualSaveNotificationRequestResult.getTemplateId());
    assertSame(stats, actualSaveNotificationRequestResult.getStats());
    assertSame(template, actualSaveNotificationRequestResult.getTemplate());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualSaveNotificationRequestResult.getTenantId());
  }

  /**
   * Test {@link DefaultNotificationRequestService#findNotificationRequestById(TenantId,
   * NotificationRequestId)}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationRequestService#findNotificationRequestById(TenantId, NotificationRequestId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "NotificationRequest DefaultNotificationRequestService.findNotificationRequestById(TenantId, NotificationRequestId)"
  })
  public void testFindNotificationRequestById_thenOriginatorEntityIdReturnCustomerId() {
    // Arrange
    NotificationRequestBuilder originatorEntityIdResult =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRuleId ruleId =
        new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRequestBuilder ruleIdResult = originatorEntityIdResult.ruleId(ruleId);
    NotificationRequestStats stats = new NotificationRequestStats();
    NotificationRequestBuilder statusResult =
        ruleIdResult.stats(stats).status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationTemplate template = new NotificationTemplate();
    NotificationRequestBuilder templateResult = targetsResult.template(template);
    NotificationTemplateId templateId =
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRequest buildResult =
        templateResult.templateId(templateId).tenantId(ModelConstants.SYSTEM_TENANT).build();
    when(notificationRequestDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(buildResult);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    NotificationRequest actualFindNotificationRequestByIdResult =
        defaultNotificationRequestService.findNotificationRequestById(
            tenantId,
            new NotificationRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationRequestDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(
        actualFindNotificationRequestByIdResult.getOriginatorEntityId() instanceof CustomerId);
    assertEquals("To targets []", actualFindNotificationRequestByIdResult.getName());
    assertNull(actualFindNotificationRequestByIdResult.getUuidId());
    assertNull(actualFindNotificationRequestByIdResult.getId());
    assertNull(actualFindNotificationRequestByIdResult.getSenderId());
    assertNull(actualFindNotificationRequestByIdResult.getAdditionalConfig());
    assertEquals(0L, actualFindNotificationRequestByIdResult.getCreatedTime());
    assertEquals(
        NotificationRequestStatus.PROCESSING, actualFindNotificationRequestByIdResult.getStatus());
    assertFalse(actualFindNotificationRequestByIdResult.isScheduled());
    assertFalse(actualFindNotificationRequestByIdResult.isSent());
    assertTrue(actualFindNotificationRequestByIdResult.getTargets().isEmpty());
    assertSame(ruleId, actualFindNotificationRequestByIdResult.getRuleId());
    assertSame(templateId, actualFindNotificationRequestByIdResult.getTemplateId());
    assertSame(stats, actualFindNotificationRequestByIdResult.getStats());
    assertSame(template, actualFindNotificationRequestByIdResult.getTemplate());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualFindNotificationRequestByIdResult.getTenantId());
  }

  /**
   * Test {@link DefaultNotificationRequestService#findNotificationRequestInfoById(TenantId,
   * NotificationRequestId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationRequestService#findNotificationRequestInfoById(TenantId,
   * NotificationRequestId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "NotificationRequestInfo DefaultNotificationRequestService.findNotificationRequestInfoById(TenantId, NotificationRequestId)"
  })
  public void testFindNotificationRequestInfoById() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();
    when(notificationRequestDao.findInfoById(
            Mockito.<TenantId>any(), Mockito.<NotificationRequestId>any()))
        .thenReturn(notificationRequestInfo);

    // Act
    NotificationRequestInfo actualFindNotificationRequestInfoByIdResult =
        defaultNotificationRequestService.findNotificationRequestInfoById(
            ModelConstants.SYSTEM_TENANT,
            new NotificationRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationRequestDao)
        .findInfoById(isA(TenantId.class), isA(NotificationRequestId.class));
    assertSame(notificationRequestInfo, actualFindNotificationRequestInfoByIdResult);
  }

  /**
   * Test {@link
   * DefaultNotificationRequestService#findNotificationRequestsByTenantIdAndOriginatorType(TenantId,
   * EntityType, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationRequestService#findNotificationRequestsByTenantIdAndOriginatorType(TenantId,
   * EntityType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DefaultNotificationRequestService.findNotificationRequestsByTenantIdAndOriginatorType(TenantId, EntityType, PageLink)"
  })
  public void testFindNotificationRequestsByTenantIdAndOriginatorType() {
    // Arrange
    PageData<NotificationRequest> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRequestDao.findByTenantIdAndOriginatorTypeAndPageLink(
            Mockito.<TenantId>any(), Mockito.<EntityType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationRequest> actualFindNotificationRequestsByTenantIdAndOriginatorTypeResult =
        defaultNotificationRequestService.findNotificationRequestsByTenantIdAndOriginatorType(
            ModelConstants.SYSTEM_TENANT, EntityType.TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRequestDao)
        .findByTenantIdAndOriginatorTypeAndPageLink(
            isA(TenantId.class), eq(EntityType.TENANT), isA(PageLink.class));
    assertSame(
        actualFindNotificationRequestsByTenantIdAndOriginatorTypeResult.EMPTY_PAGE_DATA,
        actualFindNotificationRequestsByTenantIdAndOriginatorTypeResult);
  }

  /**
   * Test {@link
   * DefaultNotificationRequestService#findNotificationRequestsInfosByTenantIdAndOriginatorType(TenantId,
   * EntityType, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationRequestService#findNotificationRequestsInfosByTenantIdAndOriginatorType(TenantId,
   * EntityType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DefaultNotificationRequestService.findNotificationRequestsInfosByTenantIdAndOriginatorType(TenantId, EntityType, PageLink)"
  })
  public void testFindNotificationRequestsInfosByTenantIdAndOriginatorType() {
    // Arrange
    PageData<NotificationRequestInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRequestDao.findInfosByTenantIdAndOriginatorTypeAndPageLink(
            Mockito.<TenantId>any(), Mockito.<EntityType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationRequestInfo>
        actualFindNotificationRequestsInfosByTenantIdAndOriginatorTypeResult =
            defaultNotificationRequestService
                .findNotificationRequestsInfosByTenantIdAndOriginatorType(
                    ModelConstants.SYSTEM_TENANT,
                    EntityType.TENANT,
                    BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRequestDao)
        .findInfosByTenantIdAndOriginatorTypeAndPageLink(
            isA(TenantId.class), eq(EntityType.TENANT), isA(PageLink.class));
    assertSame(
        actualFindNotificationRequestsInfosByTenantIdAndOriginatorTypeResult.EMPTY_PAGE_DATA,
        actualFindNotificationRequestsInfosByTenantIdAndOriginatorTypeResult);
  }

  /**
   * Test {@link
   * DefaultNotificationRequestService#findNotificationRequestsIdsByStatusAndRuleId(TenantId,
   * NotificationRequestStatus, NotificationRuleId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationRequestService#findNotificationRequestsIdsByStatusAndRuleId(TenantId,
   * NotificationRequestStatus, NotificationRuleId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "List DefaultNotificationRequestService.findNotificationRequestsIdsByStatusAndRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)"
  })
  public void testFindNotificationRequestsIdsByStatusAndRuleId() {
    // Arrange
    when(notificationRequestDao.findIdsByRuleId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationRuleId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<NotificationRequestId> actualFindNotificationRequestsIdsByStatusAndRuleIdResult =
        defaultNotificationRequestService.findNotificationRequestsIdsByStatusAndRuleId(
            ModelConstants.SYSTEM_TENANT,
            NotificationRequestStatus.PROCESSING,
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationRequestDao)
        .findIdsByRuleId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.PROCESSING),
            isA(NotificationRuleId.class));
    assertTrue(actualFindNotificationRequestsIdsByStatusAndRuleIdResult.isEmpty());
  }

  /**
   * Test {@link
   * DefaultNotificationRequestService#findNotificationRequestsByRuleIdAndOriginatorEntityId(TenantId,
   * NotificationRuleId, EntityId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationRequestService#findNotificationRequestsByRuleIdAndOriginatorEntityId(TenantId,
   * NotificationRuleId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "List DefaultNotificationRequestService.findNotificationRequestsByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)"
  })
  public void testFindNotificationRequestsByRuleIdAndOriginatorEntityId() {
    // Arrange
    when(notificationRequestDao.findByRuleIdAndOriginatorEntityId(
            Mockito.<TenantId>any(), Mockito.<NotificationRuleId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<NotificationRequest> actualFindNotificationRequestsByRuleIdAndOriginatorEntityIdResult =
        defaultNotificationRequestService.findNotificationRequestsByRuleIdAndOriginatorEntityId(
            ModelConstants.SYSTEM_TENANT,
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationRequestDao)
        .findByRuleIdAndOriginatorEntityId(
            isA(TenantId.class), isA(NotificationRuleId.class), isA(EntityId.class));
    assertTrue(actualFindNotificationRequestsByRuleIdAndOriginatorEntityIdResult.isEmpty());
  }

  /**
   * Test {@link DefaultNotificationRequestService#deleteNotificationRequest(TenantId,
   * NotificationRequest)}.
   *
   * <ul>
   *   <li>When {@link NotificationRequest#NotificationRequest()}.
   *   <li>Then calls {@link NotificationRequestDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationRequestService#deleteNotificationRequest(TenantId, NotificationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DefaultNotificationRequestService.deleteNotificationRequest(TenantId, NotificationRequest)"
  })
  public void testDeleteNotificationRequest_whenNotificationRequest_thenCallsRemoveById() {
    // Arrange
    doNothing()
        .when(notificationRequestDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing()
        .when(notificationDao)
        .deleteByRequestId(Mockito.<TenantId>any(), Mockito.<NotificationRequestId>any());

    // Act
    defaultNotificationRequestService.deleteNotificationRequest(
        ModelConstants.SYSTEM_TENANT, new NotificationRequest());

    // Assert
    verify(notificationRequestDao).removeById(isA(TenantId.class), isNull());
    verify(notificationDao).deleteByRequestId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DefaultNotificationRequestService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link NotificationDao}.
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then calls {@link NotificationRequestDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationRequestService#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DefaultNotificationRequestService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity_givenNotificationDao_whenNull_customer_id_thenCallsRemoveById() {
    // Arrange
    doNothing()
        .when(notificationRequestDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    defaultNotificationRequestService.deleteEntity(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert
    verify(notificationRequestDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationRequestService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationRequestDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationRequestService#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DefaultNotificationRequestService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity_thenCallsFindById() {
    // Arrange
    NotificationRequestBuilder originatorEntityIdResult =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    when(notificationRequestDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(buildResult);
    doNothing()
        .when(notificationRequestDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing()
        .when(notificationDao)
        .deleteByRequestId(Mockito.<TenantId>any(), Mockito.<NotificationRequestId>any());

    // Act
    defaultNotificationRequestService.deleteEntity(
        ModelConstants.SYSTEM_TENANT,
        new NotificationRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
        false);

    // Assert
    verify(notificationRequestDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(notificationRequestDao).removeById(isA(TenantId.class), isNull());
    verify(notificationDao).deleteByRequestId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DefaultNotificationRequestService#findScheduledNotificationRequests(PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationRequestService#findScheduledNotificationRequests(PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DefaultNotificationRequestService.findScheduledNotificationRequests(PageLink)"
  })
  public void testFindScheduledNotificationRequests() {
    // Arrange
    PageData<NotificationRequest> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRequestDao.findAllByStatus(
            Mockito.<NotificationRequestStatus>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationRequest> actualFindScheduledNotificationRequestsResult =
        defaultNotificationRequestService.findScheduledNotificationRequests(
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRequestDao)
        .findAllByStatus(eq(NotificationRequestStatus.SCHEDULED), isA(PageLink.class));
    assertSame(
        actualFindScheduledNotificationRequestsResult.EMPTY_PAGE_DATA,
        actualFindScheduledNotificationRequestsResult);
  }

  /**
   * Test {@link DefaultNotificationRequestService#updateNotificationRequest(TenantId,
   * NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationRequestService#updateNotificationRequest(TenantId, NotificationRequestId,
   * NotificationRequestStatus, NotificationRequestStats)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DefaultNotificationRequestService.updateNotificationRequest(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)"
  })
  public void testUpdateNotificationRequest() {
    // Arrange
    doNothing()
        .when(notificationRequestDao)
        .updateById(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationRequestStats>any());
    NotificationRequestId requestId =
        new NotificationRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    defaultNotificationRequestService.updateNotificationRequest(
        ModelConstants.SYSTEM_TENANT,
        requestId,
        NotificationRequestStatus.PROCESSING,
        new NotificationRequestStats());

    // Assert
    verify(notificationRequestDao)
        .updateById(
            isA(TenantId.class),
            isA(NotificationRequestId.class),
            eq(NotificationRequestStatus.PROCESSING),
            isA(NotificationRequestStats.class));
  }

  /**
   * Test {@link DefaultNotificationRequestService#deleteNotificationRequestsByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationRequestService#deleteNotificationRequestsByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DefaultNotificationRequestService.deleteNotificationRequestsByTenantId(TenantId)"
  })
  public void testDeleteNotificationRequestsByTenantId() {
    // Arrange
    doNothing().when(notificationRequestDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationRequestService.deleteNotificationRequestsByTenantId(
        ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationRequestDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationRequestService#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link DefaultNotificationRequestService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationRequestService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId() {
    // Arrange
    doNothing().when(notificationRequestDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationRequestService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationRequestDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationRequestService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then {@link Optional#get()} OriginatorEntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationRequestService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional DefaultNotificationRequestService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_whenNull_customer_id_thenGetOriginatorEntityIdReturnCustomerId() {
    // Arrange
    NotificationRequestBuilder originatorEntityIdResult =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRuleId ruleId =
        new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRequestBuilder ruleIdResult = originatorEntityIdResult.ruleId(ruleId);
    NotificationRequestStats stats = new NotificationRequestStats();
    NotificationRequestBuilder statusResult =
        ruleIdResult.stats(stats).status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationTemplate template = new NotificationTemplate();
    NotificationRequestBuilder templateResult = targetsResult.template(template);
    NotificationTemplateId templateId =
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRequest buildResult =
        templateResult.templateId(templateId).tenantId(ModelConstants.SYSTEM_TENANT).build();
    when(notificationRequestDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(buildResult);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        defaultNotificationRequestService.findEntity(tenantId, entityId);

    // Assert
    verify(notificationRequestDao).findById(isA(TenantId.class), isA(UUID.class));
    HasId<?> getResult = actualFindEntityResult.get();
    EntityId originatorEntityId = ((NotificationRequest) getResult).getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof CustomerId);
    assertTrue(getResult instanceof NotificationRequest);
    assertEquals("To targets []", ((NotificationRequest) getResult).getName());
    assertNull(((NotificationRequest) getResult).getUuidId());
    assertNull(getResult.getId());
    assertNull(((NotificationRequest) getResult).getSenderId());
    assertNull(((NotificationRequest) getResult).getAdditionalConfig());
    assertEquals(0L, ((NotificationRequest) getResult).getCreatedTime());
    assertEquals(
        NotificationRequestStatus.PROCESSING, ((NotificationRequest) getResult).getStatus());
    assertFalse(((NotificationRequest) getResult).isScheduled());
    assertFalse(((NotificationRequest) getResult).isSent());
    assertTrue(((NotificationRequest) getResult).getTargets().isEmpty());
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(ruleId, ((NotificationRequest) getResult).getRuleId());
    assertSame(templateId, ((NotificationRequest) getResult).getTemplateId());
    assertSame(stats, ((NotificationRequest) getResult).getStats());
    assertSame(template, ((NotificationRequest) getResult).getTemplate());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, ((NotificationRequest) getResult).getTenantId());
    assertSame(entityId, originatorEntityId);
  }

  /**
   * Test {@link DefaultNotificationRequestService#getEntityType()}.
   *
   * <p>Method under test: {@link DefaultNotificationRequestService#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType DefaultNotificationRequestService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    // Act and Assert
    assertEquals(
        EntityType.NOTIFICATION_REQUEST,
        new DefaultNotificationRequestService(
                notificationRequestDao,
                new JpaNotificationDao(
                    mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
                mock(ApplicationEventPublisher.class))
            .getEntityType());
  }
}
