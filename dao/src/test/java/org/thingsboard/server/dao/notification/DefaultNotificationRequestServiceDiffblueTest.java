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
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationRequest;
import org.thingsboard.server.common.data.notification.NotificationRequestInfo;
import org.thingsboard.server.common.data.notification.NotificationRequestStats;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.notification.JpaNotificationDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.NotificationRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {DefaultNotificationRequestService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DefaultNotificationRequestServiceDiffblueTest {
  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private DefaultNotificationRequestService defaultNotificationRequestService;

  @MockBean
  private NotificationDao notificationDao;

  @MockBean
  private NotificationRequestDao notificationRequestDao;

  /**
   * Test
   * {@link DefaultNotificationRequestService#findNotificationRequestById(TenantId, NotificationRequestId)}.
   * <ul>
   *   <li>Then OriginatorEntityId return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRequestService#findNotificationRequestById(TenantId, NotificationRequestId)}
   */
  @Test
  public void testFindNotificationRequestById_thenOriginatorEntityIdReturnCustomerId() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRuleId ruleId = new NotificationRuleId(ModelConstants.NULL_UUID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult.ruleId(ruleId);
    NotificationRequestStats stats = new NotificationRequestStats();
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(stats)
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationTemplate template = new NotificationTemplate();
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(template);
    NotificationTemplateId templateId = new NotificationTemplateId(ModelConstants.NULL_UUID);
    NotificationRequest buildResult = templateResult.templateId(templateId)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    when(notificationRequestDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(buildResult);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    NotificationRequest actualFindNotificationRequestByIdResult = defaultNotificationRequestService
        .findNotificationRequestById(tenantId, new NotificationRequestId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestDao).findById(isA(TenantId.class), isA(UUID.class));
    EntityId originatorEntityId = actualFindNotificationRequestByIdResult.getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof CustomerId);
    assertEquals("To targets []", actualFindNotificationRequestByIdResult.getName());
    assertNull(actualFindNotificationRequestByIdResult.getUuidId());
    assertNull(actualFindNotificationRequestByIdResult.getId());
    assertNull(actualFindNotificationRequestByIdResult.getSenderId());
    assertNull(actualFindNotificationRequestByIdResult.getAdditionalConfig());
    assertEquals(0L, actualFindNotificationRequestByIdResult.getCreatedTime());
    assertEquals(EntityType.CUSTOMER, originatorEntityId.getEntityType());
    assertEquals(NotificationRequestStatus.PROCESSING, actualFindNotificationRequestByIdResult.getStatus());
    assertFalse(actualFindNotificationRequestByIdResult.isScheduled());
    assertFalse(actualFindNotificationRequestByIdResult.isSent());
    assertTrue(actualFindNotificationRequestByIdResult.getTargets().isEmpty());
    assertTrue(originatorEntityId.isNullUid());
    assertSame(ruleId, actualFindNotificationRequestByIdResult.getRuleId());
    assertSame(templateId, actualFindNotificationRequestByIdResult.getTemplateId());
    assertSame(stats, actualFindNotificationRequestByIdResult.getStats());
    assertSame(template, actualFindNotificationRequestByIdResult.getTemplate());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualFindNotificationRequestByIdResult.getTenantId());
  }

  /**
   * Test
   * {@link DefaultNotificationRequestService#findNotificationRequestInfoById(TenantId, NotificationRequestId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationRequestService#findNotificationRequestInfoById(TenantId, NotificationRequestId)}
   */
  @Test
  public void testFindNotificationRequestInfoById() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();
    when(notificationRequestDao.findInfoById(Mockito.<TenantId>any(), Mockito.<NotificationRequestId>any()))
        .thenReturn(notificationRequestInfo);

    // Act
    NotificationRequestInfo actualFindNotificationRequestInfoByIdResult = defaultNotificationRequestService
        .findNotificationRequestInfoById(ModelConstants.SYSTEM_TENANT,
            new NotificationRequestId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestDao).findInfoById(isA(TenantId.class), isA(NotificationRequestId.class));
    assertSame(notificationRequestInfo, actualFindNotificationRequestInfoByIdResult);
  }

  /**
   * Test
   * {@link DefaultNotificationRequestService#findNotificationRequestsByTenantIdAndOriginatorType(TenantId, EntityType, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationRequestService#findNotificationRequestsByTenantIdAndOriginatorType(TenantId, EntityType, PageLink)}
   */
  @Test
  public void testFindNotificationRequestsByTenantIdAndOriginatorType() {
    // Arrange
    PageData<NotificationRequest> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRequestDao.findByTenantIdAndOriginatorTypeAndPageLink(Mockito.<TenantId>any(),
        Mockito.<EntityType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationRequest> actualFindNotificationRequestsByTenantIdAndOriginatorTypeResult = defaultNotificationRequestService
        .findNotificationRequestsByTenantIdAndOriginatorType(ModelConstants.SYSTEM_TENANT, EntityType.TENANT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRequestDao).findByTenantIdAndOriginatorTypeAndPageLink(isA(TenantId.class),
        eq(EntityType.TENANT), isA(PageLink.class));
    assertSame(actualFindNotificationRequestsByTenantIdAndOriginatorTypeResult.EMPTY_PAGE_DATA,
        actualFindNotificationRequestsByTenantIdAndOriginatorTypeResult);
  }

  /**
   * Test
   * {@link DefaultNotificationRequestService#findNotificationRequestsInfosByTenantIdAndOriginatorType(TenantId, EntityType, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationRequestService#findNotificationRequestsInfosByTenantIdAndOriginatorType(TenantId, EntityType, PageLink)}
   */
  @Test
  public void testFindNotificationRequestsInfosByTenantIdAndOriginatorType() {
    // Arrange
    PageData<NotificationRequestInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRequestDao.findInfosByTenantIdAndOriginatorTypeAndPageLink(Mockito.<TenantId>any(),
        Mockito.<EntityType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationRequestInfo> actualFindNotificationRequestsInfosByTenantIdAndOriginatorTypeResult = defaultNotificationRequestService
        .findNotificationRequestsInfosByTenantIdAndOriginatorType(ModelConstants.SYSTEM_TENANT, EntityType.TENANT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRequestDao).findInfosByTenantIdAndOriginatorTypeAndPageLink(isA(TenantId.class),
        eq(EntityType.TENANT), isA(PageLink.class));
    assertSame(actualFindNotificationRequestsInfosByTenantIdAndOriginatorTypeResult.EMPTY_PAGE_DATA,
        actualFindNotificationRequestsInfosByTenantIdAndOriginatorTypeResult);
  }

  /**
   * Test
   * {@link DefaultNotificationRequestService#findNotificationRequestsIdsByStatusAndRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationRequestService#findNotificationRequestsIdsByStatusAndRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)}
   */
  @Test
  public void testFindNotificationRequestsIdsByStatusAndRuleId() {
    // Arrange
    when(notificationRequestDao.findIdsByRuleId(Mockito.<TenantId>any(), Mockito.<NotificationRequestStatus>any(),
        Mockito.<NotificationRuleId>any())).thenReturn(new ArrayList<>());

    // Act
    List<NotificationRequestId> actualFindNotificationRequestsIdsByStatusAndRuleIdResult = defaultNotificationRequestService
        .findNotificationRequestsIdsByStatusAndRuleId(ModelConstants.SYSTEM_TENANT,
            NotificationRequestStatus.PROCESSING, new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestDao).findIdsByRuleId(isA(TenantId.class), eq(NotificationRequestStatus.PROCESSING),
        isA(NotificationRuleId.class));
    assertTrue(actualFindNotificationRequestsIdsByStatusAndRuleIdResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultNotificationRequestService#findNotificationRequestsByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationRequestService#findNotificationRequestsByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)}
   */
  @Test
  public void testFindNotificationRequestsByRuleIdAndOriginatorEntityId() {
    // Arrange
    when(notificationRequestDao.findByRuleIdAndOriginatorEntityId(Mockito.<TenantId>any(),
        Mockito.<NotificationRuleId>any(), Mockito.<EntityId>any())).thenReturn(new ArrayList<>());

    // Act
    List<NotificationRequest> actualFindNotificationRequestsByRuleIdAndOriginatorEntityIdResult = defaultNotificationRequestService
        .findNotificationRequestsByRuleIdAndOriginatorEntityId(ModelConstants.SYSTEM_TENANT,
            new NotificationRuleId(ModelConstants.NULL_UUID), BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationRequestDao).findByRuleIdAndOriginatorEntityId(isA(TenantId.class), isA(NotificationRuleId.class),
        isA(EntityId.class));
    assertTrue(actualFindNotificationRequestsByRuleIdAndOriginatorEntityIdResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultNotificationRequestService#deleteNotificationRequest(TenantId, NotificationRequest)}.
   * <ul>
   *   <li>When {@link NotificationRequest#NotificationRequest()}.</li>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRequestService#deleteNotificationRequest(TenantId, NotificationRequest)}
   */
  @Test
  public void testDeleteNotificationRequest_whenNotificationRequest_thenCallsRemoveById() {
    // Arrange
    doNothing().when(notificationRequestDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(notificationDao).deleteByRequestId(Mockito.<TenantId>any(), Mockito.<NotificationRequestId>any());

    // Act
    defaultNotificationRequestService.deleteNotificationRequest(ModelConstants.SYSTEM_TENANT,
        new NotificationRequest());

    // Assert
    verify(notificationRequestDao).removeById(isA(TenantId.class), isNull());
    verify(notificationDao).deleteByRequestId(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DefaultNotificationRequestService#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRequestService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_whenNull_customer_id_thenCallsRemoveById() {
    // Arrange
    doNothing().when(notificationRequestDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    defaultNotificationRequestService.deleteEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        true);

    // Assert that nothing has changed
    verify(notificationRequestDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DefaultNotificationRequestService#findScheduledNotificationRequests(PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationRequestService#findScheduledNotificationRequests(PageLink)}
   */
  @Test
  public void testFindScheduledNotificationRequests() {
    // Arrange
    PageData<NotificationRequest> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRequestDao.findAllByStatus(Mockito.<NotificationRequestStatus>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationRequest> actualFindScheduledNotificationRequestsResult = defaultNotificationRequestService
        .findScheduledNotificationRequests(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRequestDao).findAllByStatus(eq(NotificationRequestStatus.SCHEDULED), isA(PageLink.class));
    assertSame(actualFindScheduledNotificationRequestsResult.EMPTY_PAGE_DATA,
        actualFindScheduledNotificationRequestsResult);
  }

  /**
   * Test
   * {@link DefaultNotificationRequestService#updateNotificationRequest(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationRequestService#updateNotificationRequest(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}
   */
  @Test
  public void testUpdateNotificationRequest() {
    // Arrange
    doNothing().when(notificationRequestDao)
        .updateById(Mockito.<TenantId>any(), Mockito.<NotificationRequestId>any(),
            Mockito.<NotificationRequestStatus>any(), Mockito.<NotificationRequestStats>any());
    NotificationRequestId requestId = new NotificationRequestId(ModelConstants.NULL_UUID);

    // Act
    defaultNotificationRequestService.updateNotificationRequest(ModelConstants.SYSTEM_TENANT, requestId,
        NotificationRequestStatus.PROCESSING, new NotificationRequestStats());

    // Assert that nothing has changed
    verify(notificationRequestDao).updateById(isA(TenantId.class), isA(NotificationRequestId.class),
        eq(NotificationRequestStatus.PROCESSING), isA(NotificationRequestStats.class));
  }

  /**
   * Test
   * {@link DefaultNotificationRequestService#deleteNotificationRequestsByTenantId(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationRequestService#deleteNotificationRequestsByTenantId(TenantId)}
   */
  @Test
  public void testDeleteNotificationRequestsByTenantId() {
    // Arrange
    doNothing().when(notificationRequestDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationRequestService.deleteNotificationRequestsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(notificationRequestDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationRequestService#deleteByTenantId(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationRequestService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId() {
    // Arrange
    doNothing().when(notificationRequestDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationRequestService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(notificationRequestDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultNotificationRequestService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then {@link Optional#get()} return {@link NotificationRequest}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRequestService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenGetReturnNotificationRequest() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRuleId ruleId = new NotificationRuleId(ModelConstants.NULL_UUID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult.ruleId(ruleId);
    NotificationRequestStats stats = new NotificationRequestStats();
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(stats)
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationTemplate template = new NotificationTemplate();
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(template);
    NotificationTemplateId templateId = new NotificationTemplateId(ModelConstants.NULL_UUID);
    NotificationRequest buildResult = templateResult.templateId(templateId)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    when(notificationRequestDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(buildResult);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Optional<HasId<?>> actualFindEntityResult = defaultNotificationRequestService.findEntity(tenantId, entityId);

    // Assert
    verify(notificationRequestDao).findById(isA(TenantId.class), isA(UUID.class));
    HasId<?> getResult = actualFindEntityResult.get();
    assertTrue(getResult instanceof NotificationRequest);
    assertEquals("To targets []", ((NotificationRequest) getResult).getName());
    assertNull(((NotificationRequest) getResult).getUuidId());
    assertNull(getResult.getId());
    assertNull(((NotificationRequest) getResult).getSenderId());
    assertNull(((NotificationRequest) getResult).getAdditionalConfig());
    assertEquals(0L, ((NotificationRequest) getResult).getCreatedTime());
    assertEquals(NotificationRequestStatus.PROCESSING, ((NotificationRequest) getResult).getStatus());
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
    assertSame(entityId, ((NotificationRequest) getResult).getOriginatorEntityId());
  }

  /**
   * Test {@link DefaultNotificationRequestService#getEntityType()}.
   * <p>
   * Method under test: {@link DefaultNotificationRequestService#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));

    // Act and Assert
    assertEquals(EntityType.NOTIFICATION_REQUEST,
        (new DefaultNotificationRequestService(notificationRequestDao,
            new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
            mock(ApplicationEventPublisher.class))).getEntityType());
  }
}
