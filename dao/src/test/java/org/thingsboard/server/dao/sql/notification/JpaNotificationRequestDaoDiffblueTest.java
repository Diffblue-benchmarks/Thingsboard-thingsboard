package org.thingsboard.server.dao.sql.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationRequest;
import org.thingsboard.server.common.data.notification.NotificationRequestInfo;
import org.thingsboard.server.common.data.notification.NotificationRequestStats;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationRequestEntity;
import org.thingsboard.server.dao.model.sql.NotificationRequestInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaNotificationRequestDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaNotificationRequestDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaNotificationRequestDao jpaNotificationRequestDao;

  @MockBean
  private NotificationRequestRepository notificationRequestRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test
   * {@link JpaNotificationRequestDao#findByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndOriginatorTypeAndPageLink_thenReturnDataSizeIsOne() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = mock(NotificationRequestEntity.class);
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
    when(notificationRequestEntity.toData()).thenReturn(buildResult);
    doNothing().when(notificationRequestEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRequestEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setInfo(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityType(Mockito.<EntityType>any());
    doNothing().when(notificationRequestEntity).setRuleId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setStats(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setStatus(Mockito.<NotificationRequestStatus>any());
    doNothing().when(notificationRequestEntity).setTargets(Mockito.<String>any());
    doNothing().when(notificationRequestEntity).setTemplate(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setTenantId(Mockito.<UUID>any());
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(-1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.USER);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.SCHEDULED);
    notificationRequestEntity.setTargets("42");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationRequestEntity> content = new ArrayList<>();
    content.add(notificationRequestEntity);
    PageImpl<NotificationRequestEntity> pageImpl = new PageImpl<>(content);
    when(notificationRequestRepository.findByTenantIdAndOriginatorEntityType(Mockito.<UUID>any(),
        Mockito.<EntityType>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationRequest> actualFindByTenantIdAndOriginatorTypeAndPageLinkResult = jpaNotificationRequestDao
        .findByTenantIdAndOriginatorTypeAndPageLink(tenantId, EntityType.TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRequestEntity).setCreatedTime(eq(-1L));
    verify(notificationRequestEntity).setId(isA(UUID.class));
    verify(notificationRequestEntity).setUuid(isA(UUID.class));
    verify(notificationRequestEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRequestEntity).setInfo(isA(JsonNode.class));
    verify(notificationRequestEntity).setOriginatorEntityId(isA(UUID.class));
    verify(notificationRequestEntity).setOriginatorEntityType(eq(EntityType.USER));
    verify(notificationRequestEntity).setRuleId(isA(UUID.class));
    verify(notificationRequestEntity).setStats(isA(JsonNode.class));
    verify(notificationRequestEntity).setStatus(eq(NotificationRequestStatus.SCHEDULED));
    verify(notificationRequestEntity).setTargets(eq("42"));
    verify(notificationRequestEntity).setTemplate(isA(JsonNode.class));
    verify(notificationRequestEntity).setTemplateId(isA(UUID.class));
    verify(notificationRequestEntity).setTenantId(isA(UUID.class));
    verify(notificationRequestEntity).toData();
    verify(notificationRequestRepository).findByTenantIdAndOriginatorEntityType(isA(UUID.class), eq(EntityType.TENANT),
        isA(Pageable.class));
    List<NotificationRequest> data = actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getData();
    assertEquals(1, data.size());
    NotificationRequest getResult = data.get(0);
    EntityId originatorEntityId = getResult.getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof CustomerId);
    assertEquals("To targets []", getResult.getName());
    assertNull(getResult.getUuidId());
    assertNull(getResult.getId());
    assertNull(getResult.getSenderId());
    assertNull(getResult.getAdditionalConfig());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalElements());
    assertEquals(EntityType.CUSTOMER, originatorEntityId.getEntityType());
    assertEquals(NotificationRequestStatus.PROCESSING, getResult.getStatus());
    assertFalse(getResult.isScheduled());
    assertFalse(getResult.isSent());
    assertTrue(getResult.getTargets().isEmpty());
    assertTrue(originatorEntityId.isNullUid());
    assertSame(ruleId, getResult.getRuleId());
    assertSame(templateId, getResult.getTemplateId());
    assertSame(stats, getResult.getStats());
    assertSame(template, getResult.getTemplate());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndOriginatorTypeAndPageLink_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRequestRepository.findByTenantIdAndOriginatorEntityType(Mockito.<UUID>any(),
        Mockito.<EntityType>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationRequest> actualFindByTenantIdAndOriginatorTypeAndPageLinkResult = jpaNotificationRequestDao
        .findByTenantIdAndOriginatorTypeAndPageLink(ModelConstants.SYSTEM_TENANT, EntityType.TENANT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRequestRepository).findByTenantIdAndOriginatorEntityType(isA(UUID.class), eq(EntityType.TENANT),
        isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndOriginatorTypeAndPageLink_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(notificationRequestRepository.findByTenantIdAndOriginatorEntityType(Mockito.<UUID>any(),
        Mockito.<EntityType>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationRequest> actualFindByTenantIdAndOriginatorTypeAndPageLinkResult = jpaNotificationRequestDao
        .findByTenantIdAndOriginatorTypeAndPageLink(ModelConstants.SYSTEM_TENANT, EntityType.TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRequestRepository).findByTenantIdAndOriginatorEntityType(isA(UUID.class), eq(EntityType.TENANT),
        isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findInfosByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findInfosByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)}
   */
  @Test
  public void testFindInfosByTenantIdAndOriginatorTypeAndPageLink() {
    // Arrange
    when(notificationRequestRepository.findInfosByTenantIdAndOriginatorEntityTypeAndSearchText(Mockito.<UUID>any(),
        Mockito.<EntityType>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationRequestInfo> actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult = jpaNotificationRequestDao
        .findInfosByTenantIdAndOriginatorTypeAndPageLink(ModelConstants.SYSTEM_TENANT, EntityType.TENANT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRequestRepository).findInfosByTenantIdAndOriginatorEntityTypeAndSearchText(isA(UUID.class),
        eq(EntityType.TENANT), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findInfosByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findInfosByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)}
   */
  @Test
  public void testFindInfosByTenantIdAndOriginatorTypeAndPageLink_givenOne_thenCallsGetPage() {
    // Arrange
    when(notificationRequestRepository.findInfosByTenantIdAndOriginatorEntityTypeAndSearchText(Mockito.<UUID>any(),
        Mockito.<EntityType>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationRequestInfo> actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult = jpaNotificationRequestDao
        .findInfosByTenantIdAndOriginatorTypeAndPageLink(ModelConstants.SYSTEM_TENANT, EntityType.TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRequestRepository).findInfosByTenantIdAndOriginatorEntityTypeAndSearchText(isA(UUID.class),
        eq(EntityType.TENANT), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)}
   */
  @Test
  public void testFindIdsByRuleId_givenArrayListAddNull_uuid_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(ModelConstants.NULL_UUID);
    when(notificationRequestRepository.findAllIdsByStatusAndRuleId(Mockito.<NotificationRequestStatus>any(),
        Mockito.<UUID>any())).thenReturn(uuidList);

    // Act
    List<NotificationRequestId> actualFindIdsByRuleIdResult = jpaNotificationRequestDao.findIdsByRuleId(
        ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
        new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestRepository).findAllIdsByStatusAndRuleId(eq(NotificationRequestStatus.PROCESSING),
        isA(UUID.class));
    assertEquals(1, actualFindIdsByRuleIdResult.size());
    NotificationRequestId getResult = actualFindIdsByRuleIdResult.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(EntityType.NOTIFICATION_REQUEST, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)}
   */
  @Test
  public void testFindIdsByRuleId_givenArrayListAddNull_uuid_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(ModelConstants.NULL_UUID);
    uuidList.add(ModelConstants.NULL_UUID);
    when(notificationRequestRepository.findAllIdsByStatusAndRuleId(Mockito.<NotificationRequestStatus>any(),
        Mockito.<UUID>any())).thenReturn(uuidList);

    // Act
    List<NotificationRequestId> actualFindIdsByRuleIdResult = jpaNotificationRequestDao.findIdsByRuleId(
        ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
        new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestRepository).findAllIdsByStatusAndRuleId(eq(NotificationRequestStatus.PROCESSING),
        isA(UUID.class));
    assertEquals(2, actualFindIdsByRuleIdResult.size());
    assertEquals(actualFindIdsByRuleIdResult.get(0), actualFindIdsByRuleIdResult.get(1));
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)}
   */
  @Test
  public void testFindIdsByRuleId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(notificationRequestRepository.findAllIdsByStatusAndRuleId(Mockito.<NotificationRequestStatus>any(),
        Mockito.<UUID>any())).thenReturn(new ArrayList<>());
    NotificationRuleId ruleId = mock(NotificationRuleId.class);
    when(ruleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationRequestId> actualFindIdsByRuleIdResult = jpaNotificationRequestDao
        .findIdsByRuleId(ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING, ruleId);

    // Assert
    verify(ruleId).getId();
    verify(notificationRequestRepository).findAllIdsByStatusAndRuleId(eq(NotificationRequestStatus.PROCESSING),
        isA(UUID.class));
    assertTrue(actualFindIdsByRuleIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)}.
   * <ul>
   *   <li>When {@link NotificationRuleId#NotificationRuleId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)}
   */
  @Test
  public void testFindIdsByRuleId_whenNotificationRuleIdWithIdIsNull_uuid_thenReturnEmpty() {
    // Arrange
    when(notificationRequestRepository.findAllIdsByStatusAndRuleId(Mockito.<NotificationRequestStatus>any(),
        Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<NotificationRequestId> actualFindIdsByRuleIdResult = jpaNotificationRequestDao.findIdsByRuleId(
        ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
        new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestRepository).findAllIdsByStatusAndRuleId(eq(NotificationRequestStatus.PROCESSING),
        isA(UUID.class));
    assertTrue(actualFindIdsByRuleIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)}
   */
  @Test
  public void testFindByRuleIdAndOriginatorEntityId_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(notificationRequestRepository.findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<EntityType>any())).thenReturn(new ArrayList<>());
    NotificationRuleId ruleId = mock(NotificationRuleId.class);
    when(ruleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationRequest> actualFindByRuleIdAndOriginatorEntityIdResult = jpaNotificationRequestDao
        .findByRuleIdAndOriginatorEntityId(ModelConstants.SYSTEM_TENANT, ruleId, ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(ruleId).getId();
    verify(notificationRequestRepository).findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(isA(UUID.class),
        isA(UUID.class), eq(EntityType.TENANT));
    assertTrue(actualFindByRuleIdAndOriginatorEntityIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)}.
   * <ul>
   *   <li>Given {@code TENANT}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)}
   */
  @Test
  public void testFindByRuleIdAndOriginatorEntityId_givenTenant_thenCallsGetEntityType() {
    // Arrange
    when(notificationRequestRepository.findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<EntityType>any())).thenReturn(new ArrayList<>());
    NotificationRuleId ruleId = mock(NotificationRuleId.class);
    when(ruleId.getId()).thenReturn(ModelConstants.NULL_UUID);
    AlarmId originatorEntityId = mock(AlarmId.class);
    when(originatorEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(originatorEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<NotificationRequest> actualFindByRuleIdAndOriginatorEntityIdResult = jpaNotificationRequestDao
        .findByRuleIdAndOriginatorEntityId(ModelConstants.SYSTEM_TENANT, ruleId, originatorEntityId);

    // Assert
    verify(originatorEntityId).getEntityType();
    verify(originatorEntityId).getId();
    verify(ruleId).getId();
    verify(notificationRequestRepository).findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(isA(UUID.class),
        isA(UUID.class), eq(EntityType.TENANT));
    assertTrue(actualFindByRuleIdAndOriginatorEntityIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)}
   */
  @Test
  public void testFindByRuleIdAndOriginatorEntityId_thenReturnSizeIsOne() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = mock(NotificationRequestEntity.class);
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
    when(notificationRequestEntity.toData()).thenReturn(buildResult);
    doNothing().when(notificationRequestEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRequestEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setInfo(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityType(Mockito.<EntityType>any());
    doNothing().when(notificationRequestEntity).setRuleId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setStats(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setStatus(Mockito.<NotificationRequestStatus>any());
    doNothing().when(notificationRequestEntity).setTargets(Mockito.<String>any());
    doNothing().when(notificationRequestEntity).setTemplate(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setTenantId(Mockito.<UUID>any());
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationRequestEntity> notificationRequestEntityList = new ArrayList<>();
    notificationRequestEntityList.add(notificationRequestEntity);
    when(notificationRequestRepository.findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<EntityType>any())).thenReturn(notificationRequestEntityList);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;
    NotificationRuleId ruleId2 = mock(NotificationRuleId.class);
    when(ruleId2.getId()).thenReturn(ModelConstants.NULL_UUID);
    AlarmId originatorEntityId = mock(AlarmId.class);
    when(originatorEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(originatorEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<NotificationRequest> actualFindByRuleIdAndOriginatorEntityIdResult = jpaNotificationRequestDao
        .findByRuleIdAndOriginatorEntityId(tenantId, ruleId2, originatorEntityId);

    // Assert
    verify(originatorEntityId).getEntityType();
    verify(originatorEntityId).getId();
    verify(ruleId2).getId();
    verify(notificationRequestEntity).setCreatedTime(eq(1L));
    verify(notificationRequestEntity).setId(isA(UUID.class));
    verify(notificationRequestEntity).setUuid(isA(UUID.class));
    verify(notificationRequestEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRequestEntity).setInfo(isA(JsonNode.class));
    verify(notificationRequestEntity).setOriginatorEntityId(isA(UUID.class));
    verify(notificationRequestEntity).setOriginatorEntityType(eq(EntityType.TENANT));
    verify(notificationRequestEntity).setRuleId(isA(UUID.class));
    verify(notificationRequestEntity).setStats(isA(JsonNode.class));
    verify(notificationRequestEntity).setStatus(eq(NotificationRequestStatus.PROCESSING));
    verify(notificationRequestEntity).setTargets(eq("Targets"));
    verify(notificationRequestEntity).setTemplate(isA(JsonNode.class));
    verify(notificationRequestEntity).setTemplateId(isA(UUID.class));
    verify(notificationRequestEntity).setTenantId(isA(UUID.class));
    verify(notificationRequestEntity).toData();
    verify(notificationRequestRepository).findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(isA(UUID.class),
        isA(UUID.class), eq(EntityType.TENANT));
    assertEquals(1, actualFindByRuleIdAndOriginatorEntityIdResult.size());
    NotificationRequest getResult = actualFindByRuleIdAndOriginatorEntityIdResult.get(0);
    EntityId originatorEntityId2 = getResult.getOriginatorEntityId();
    assertTrue(originatorEntityId2 instanceof CustomerId);
    assertEquals("To targets []", getResult.getName());
    assertNull(getResult.getUuidId());
    assertNull(getResult.getId());
    assertNull(getResult.getSenderId());
    assertNull(getResult.getAdditionalConfig());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(EntityType.CUSTOMER, originatorEntityId2.getEntityType());
    assertEquals(NotificationRequestStatus.PROCESSING, getResult.getStatus());
    assertFalse(getResult.isScheduled());
    assertFalse(getResult.isSent());
    assertTrue(getResult.getTargets().isEmpty());
    assertTrue(originatorEntityId2.isNullUid());
    assertSame(ruleId, getResult.getRuleId());
    assertSame(templateId, getResult.getTemplateId());
    assertSame(stats, getResult.getStats());
    assertSame(template, getResult.getTemplate());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)}.
   * <ul>
   *   <li>When {@link NotificationRuleId#NotificationRuleId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)}
   */
  @Test
  public void testFindByRuleIdAndOriginatorEntityId_whenNotificationRuleIdWithIdIsNull_uuid() {
    // Arrange
    when(notificationRequestRepository.findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<EntityType>any())).thenReturn(new ArrayList<>());

    // Act
    List<NotificationRequest> actualFindByRuleIdAndOriginatorEntityIdResult = jpaNotificationRequestDao
        .findByRuleIdAndOriginatorEntityId(ModelConstants.SYSTEM_TENANT,
            new NotificationRuleId(ModelConstants.NULL_UUID), BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationRequestRepository).findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(isA(UUID.class),
        isA(UUID.class), eq(EntityType.CUSTOMER));
    assertTrue(actualFindByRuleIdAndOriginatorEntityIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)}
   */
  @Test
  public void testFindByRuleIdAndOriginatorEntityId_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(notificationRequestRepository.findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<EntityType>any())).thenReturn(new ArrayList<>());
    NotificationRuleId ruleId = mock(NotificationRuleId.class);
    when(ruleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationRequest> actualFindByRuleIdAndOriginatorEntityIdResult = jpaNotificationRequestDao
        .findByRuleIdAndOriginatorEntityId(ModelConstants.SYSTEM_TENANT, ruleId, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(ruleId).getId();
    verify(notificationRequestRepository).findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(isA(UUID.class),
        isA(UUID.class), eq(EntityType.CUSTOMER));
    assertTrue(actualFindByRuleIdAndOriginatorEntityIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findAllByStatus(NotificationRequestStatus, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findAllByStatus(NotificationRequestStatus, PageLink)}
   */
  @Test
  public void testFindAllByStatus_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRequestRepository.findAllByStatus(Mockito.<NotificationRequestStatus>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationRequest> actualFindAllByStatusResult = jpaNotificationRequestDao
        .findAllByStatus(NotificationRequestStatus.PROCESSING, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRequestRepository).findAllByStatus(eq(NotificationRequestStatus.PROCESSING),
        isA(Pageable.class));
    assertEquals(0L, actualFindAllByStatusResult.getTotalElements());
    assertEquals(1, actualFindAllByStatusResult.getTotalPages());
    assertFalse(actualFindAllByStatusResult.hasNext());
    assertTrue(actualFindAllByStatusResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findAllByStatus(NotificationRequestStatus, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findAllByStatus(NotificationRequestStatus, PageLink)}
   */
  @Test
  public void testFindAllByStatus_thenReturnDataSizeIsOne() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = mock(NotificationRequestEntity.class);
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
    when(notificationRequestEntity.toData()).thenReturn(buildResult);
    doNothing().when(notificationRequestEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRequestEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setInfo(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityType(Mockito.<EntityType>any());
    doNothing().when(notificationRequestEntity).setRuleId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setStats(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setStatus(Mockito.<NotificationRequestStatus>any());
    doNothing().when(notificationRequestEntity).setTargets(Mockito.<String>any());
    doNothing().when(notificationRequestEntity).setTemplate(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setTenantId(Mockito.<UUID>any());
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(-1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.USER);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.SCHEDULED);
    notificationRequestEntity.setTargets("42");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationRequestEntity> content = new ArrayList<>();
    content.add(notificationRequestEntity);
    PageImpl<NotificationRequestEntity> pageImpl = new PageImpl<>(content);
    when(notificationRequestRepository.findAllByStatus(Mockito.<NotificationRequestStatus>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationRequest> actualFindAllByStatusResult = jpaNotificationRequestDao
        .findAllByStatus(NotificationRequestStatus.PROCESSING, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRequestEntity).setCreatedTime(eq(-1L));
    verify(notificationRequestEntity).setId(isA(UUID.class));
    verify(notificationRequestEntity).setUuid(isA(UUID.class));
    verify(notificationRequestEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRequestEntity).setInfo(isA(JsonNode.class));
    verify(notificationRequestEntity).setOriginatorEntityId(isA(UUID.class));
    verify(notificationRequestEntity).setOriginatorEntityType(eq(EntityType.USER));
    verify(notificationRequestEntity).setRuleId(isA(UUID.class));
    verify(notificationRequestEntity).setStats(isA(JsonNode.class));
    verify(notificationRequestEntity).setStatus(eq(NotificationRequestStatus.SCHEDULED));
    verify(notificationRequestEntity).setTargets(eq("42"));
    verify(notificationRequestEntity).setTemplate(isA(JsonNode.class));
    verify(notificationRequestEntity).setTemplateId(isA(UUID.class));
    verify(notificationRequestEntity).setTenantId(isA(UUID.class));
    verify(notificationRequestEntity).toData();
    verify(notificationRequestRepository).findAllByStatus(eq(NotificationRequestStatus.PROCESSING),
        isA(Pageable.class));
    List<NotificationRequest> data = actualFindAllByStatusResult.getData();
    assertEquals(1, data.size());
    NotificationRequest getResult = data.get(0);
    EntityId originatorEntityId = getResult.getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof CustomerId);
    TenantId tenantId = getResult.getTenantId();
    UUID id = tenantId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("To targets []", getResult.getName());
    assertNull(getResult.getUuidId());
    assertNull(getResult.getId());
    assertNull(getResult.getSenderId());
    assertNull(getResult.getAdditionalConfig());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAllByStatusResult.getTotalElements());
    assertEquals(EntityType.CUSTOMER, originatorEntityId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(NotificationRequestStatus.PROCESSING, getResult.getStatus());
    assertFalse(getResult.isScheduled());
    assertFalse(getResult.isSent());
    assertTrue(getResult.getTargets().isEmpty());
    assertTrue(originatorEntityId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(ruleId, getResult.getRuleId());
    assertSame(templateId, getResult.getTemplateId());
    assertSame(stats, getResult.getStats());
    assertSame(template, getResult.getTemplate());
    assertSame(id, originatorEntityId.getId());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findAllByStatus(NotificationRequestStatus, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findAllByStatus(NotificationRequestStatus, PageLink)}
   */
  @Test
  public void testFindAllByStatus_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRequestRepository.findAllByStatus(Mockito.<NotificationRequestStatus>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationRequest> actualFindAllByStatusResult = jpaNotificationRequestDao
        .findAllByStatus(NotificationRequestStatus.PROCESSING, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRequestRepository).findAllByStatus(eq(NotificationRequestStatus.PROCESSING),
        isA(Pageable.class));
    assertEquals(0L, actualFindAllByStatusResult.getTotalElements());
    assertEquals(1, actualFindAllByStatusResult.getTotalPages());
    assertFalse(actualFindAllByStatusResult.hasNext());
    assertTrue(actualFindAllByStatusResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#updateById(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#updateById(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}
   */
  @Test
  public void testUpdateById() {
    // Arrange
    doNothing().when(notificationRequestRepository)
        .updateStatusAndStatsById(Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(),
            Mockito.<JsonNode>any());
    NotificationRequestId requestId = mock(NotificationRequestId.class);
    when(requestId.getId()).thenReturn(ModelConstants.NULL_UUID);
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();

    // Act
    jpaNotificationRequestDao.updateById(ModelConstants.SYSTEM_TENANT, requestId, NotificationRequestStatus.PROCESSING,
        new NotificationRequestStats(sent, new HashMap<>(), -1, "An error occurred"));

    // Assert
    verify(requestId).getId();
    verify(notificationRequestRepository).updateStatusAndStatsById(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), isA(JsonNode.class));
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#updateById(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link NotificationRequestStats#NotificationRequestStats()}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#updateById(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}
   */
  @Test
  public void testUpdateById_givenNull_uuid_whenNotificationRequestStats_thenCallsGetId() {
    // Arrange
    doNothing().when(notificationRequestRepository)
        .updateStatusAndStatsById(Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(),
            Mockito.<JsonNode>any());
    NotificationRequestId requestId = mock(NotificationRequestId.class);
    when(requestId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationRequestDao.updateById(ModelConstants.SYSTEM_TENANT, requestId, NotificationRequestStatus.PROCESSING,
        new NotificationRequestStats());

    // Assert
    verify(requestId).getId();
    verify(notificationRequestRepository).updateStatusAndStatsById(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), isA(JsonNode.class));
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#updateById(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#updateById(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}
   */
  @Test
  public void testUpdateById_givenNull_uuid_whenNull_thenCallsGetId() {
    // Arrange
    doNothing().when(notificationRequestRepository)
        .updateStatusAndStatsById(Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(),
            Mockito.<JsonNode>any());
    NotificationRequestId requestId = mock(NotificationRequestId.class);
    when(requestId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationRequestDao.updateById(ModelConstants.SYSTEM_TENANT, requestId, NotificationRequestStatus.PROCESSING,
        null);

    // Assert that nothing has changed
    verify(requestId).getId();
    verify(notificationRequestRepository).updateStatusAndStatsById(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), isA(JsonNode.class));
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#updateById(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}.
   * <ul>
   *   <li>When {@link NotificationRequestId#NotificationRequestId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#updateById(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}
   */
  @Test
  public void testUpdateById_whenNotificationRequestIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(notificationRequestRepository)
        .updateStatusAndStatsById(Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(),
            Mockito.<JsonNode>any());
    NotificationRequestId requestId = new NotificationRequestId(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationRequestDao.updateById(ModelConstants.SYSTEM_TENANT, requestId, NotificationRequestStatus.PROCESSING,
        new NotificationRequestStats());

    // Assert
    verify(notificationRequestRepository).updateStatusAndStatsById(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), isA(JsonNode.class));
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)}
   */
  @Test
  public void testExistsByTenantIdAndStatusAndTargetId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTargetsContaining(Mockito.<UUID>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<String>any())).thenReturn(true);
    NotificationTargetId targetId = mock(NotificationTargetId.class);
    when(targetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTargetIdResult = jpaNotificationRequestDao
        .existsByTenantIdAndStatusAndTargetId(ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
            targetId);

    // Assert
    verify(targetId).getId();
    verify(notificationRequestRepository).existsByTenantIdAndStatusAndTargetsContaining(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), eq("13814000-1dd2-11b2-8080-808080808080"));
    assertTrue(actualExistsByTenantIdAndStatusAndTargetIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)}
   */
  @Test
  public void testExistsByTenantIdAndStatusAndTargetId_thenReturnFalse() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTargetsContaining(Mockito.<UUID>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTargetIdResult = jpaNotificationRequestDao
        .existsByTenantIdAndStatusAndTargetId(ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
            new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestRepository).existsByTenantIdAndStatusAndTargetsContaining(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), eq("13814000-1dd2-11b2-8080-808080808080"));
    assertFalse(actualExistsByTenantIdAndStatusAndTargetIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)}
   */
  @Test
  public void testExistsByTenantIdAndStatusAndTargetId_thenReturnTrue() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTargetsContaining(Mockito.<UUID>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTargetIdResult = jpaNotificationRequestDao
        .existsByTenantIdAndStatusAndTargetId(ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
            new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestRepository).existsByTenantIdAndStatusAndTargetsContaining(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), eq("13814000-1dd2-11b2-8080-808080808080"));
    assertTrue(actualExistsByTenantIdAndStatusAndTargetIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)}
   */
  @Test
  public void testExistsByTenantIdAndStatusAndTemplateId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTemplateId(Mockito.<UUID>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<UUID>any())).thenReturn(true);
    NotificationTemplateId templateId = mock(NotificationTemplateId.class);
    when(templateId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTemplateIdResult = jpaNotificationRequestDao
        .existsByTenantIdAndStatusAndTemplateId(ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
            templateId);

    // Assert
    verify(templateId).getId();
    verify(notificationRequestRepository).existsByTenantIdAndStatusAndTemplateId(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndStatusAndTemplateIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)}
   */
  @Test
  public void testExistsByTenantIdAndStatusAndTemplateId_thenReturnFalse() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTemplateId(Mockito.<UUID>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<UUID>any())).thenReturn(false);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTemplateIdResult = jpaNotificationRequestDao
        .existsByTenantIdAndStatusAndTemplateId(ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
            new NotificationTemplateId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestRepository).existsByTenantIdAndStatusAndTemplateId(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), isA(UUID.class));
    assertFalse(actualExistsByTenantIdAndStatusAndTemplateIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)}
   */
  @Test
  public void testExistsByTenantIdAndStatusAndTemplateId_thenReturnTrue() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTemplateId(Mockito.<UUID>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<UUID>any())).thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTemplateIdResult = jpaNotificationRequestDao
        .existsByTenantIdAndStatusAndTemplateId(ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
            new NotificationTemplateId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestRepository).existsByTenantIdAndStatusAndTemplateId(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndStatusAndTemplateIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#removeAllByCreatedTimeBefore(long)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#removeAllByCreatedTimeBefore(long)}
   */
  @Test
  public void testRemoveAllByCreatedTimeBefore() {
    // Arrange
    when(notificationRequestRepository.deleteAllByCreatedTimeBefore(anyLong())).thenReturn(1);

    // Act
    int actualRemoveAllByCreatedTimeBeforeResult = jpaNotificationRequestDao.removeAllByCreatedTimeBefore(1L);

    // Assert
    verify(notificationRequestRepository).deleteAllByCreatedTimeBefore(eq(1L));
    assertEquals(1, actualRemoveAllByCreatedTimeBeforeResult);
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findInfoById(TenantId, NotificationRequestId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findInfoById(TenantId, NotificationRequestId)}
   */
  @Test
  public void testFindInfoById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    NotificationRequestInfoEntity notificationRequestInfoEntity = mock(NotificationRequestInfoEntity.class);
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();
    when(notificationRequestInfoEntity.toData()).thenReturn(notificationRequestInfo);
    when(notificationRequestRepository.findInfoById(Mockito.<UUID>any())).thenReturn(notificationRequestInfoEntity);
    NotificationRequestId id = mock(NotificationRequestId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    NotificationRequestInfo actualFindInfoByIdResult = jpaNotificationRequestDao
        .findInfoById(ModelConstants.SYSTEM_TENANT, id);

    // Assert
    verify(id).getId();
    verify(notificationRequestInfoEntity).toData();
    verify(notificationRequestRepository).findInfoById(isA(UUID.class));
    assertSame(notificationRequestInfo, actualFindInfoByIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findInfoById(TenantId, NotificationRequestId)}.
   * <ul>
   *   <li>Then return
   * {@link NotificationRequestInfo#NotificationRequestInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findInfoById(TenantId, NotificationRequestId)}
   */
  @Test
  public void testFindInfoById_thenReturnNotificationRequestInfo() {
    // Arrange
    NotificationRequestInfoEntity notificationRequestInfoEntity = mock(NotificationRequestInfoEntity.class);
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();
    when(notificationRequestInfoEntity.toData()).thenReturn(notificationRequestInfo);
    when(notificationRequestRepository.findInfoById(Mockito.<UUID>any())).thenReturn(notificationRequestInfoEntity);

    // Act
    NotificationRequestInfo actualFindInfoByIdResult = jpaNotificationRequestDao
        .findInfoById(ModelConstants.SYSTEM_TENANT, new NotificationRequestId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestInfoEntity).toData();
    verify(notificationRequestRepository).findInfoById(isA(UUID.class));
    assertSame(notificationRequestInfo, actualFindInfoByIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationRequestDao#findInfoById(TenantId, NotificationRequestId)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#findInfoById(TenantId, NotificationRequestId)}
   */
  @Test
  public void testFindInfoById_thenReturnNull() {
    // Arrange
    when(notificationRequestRepository.findInfoById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    NotificationRequestInfo actualFindInfoByIdResult = jpaNotificationRequestDao
        .findInfoById(ModelConstants.SYSTEM_TENANT, new NotificationRequestId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestRepository).findInfoById(isA(UUID.class));
    assertNull(actualFindInfoByIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#removeByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls
   * {@link NotificationRequestRepository#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRequestDao#removeByTenantId(TenantId)}
   */
  @Test
  public void testRemoveByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(notificationRequestRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaNotificationRequestDao.removeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(notificationRequestRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaNotificationRequestDao#getEntityClass()}
   *   <li>{@link JpaNotificationRequestDao#getEntityType()}
   *   <li>{@link JpaNotificationRequestDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationRequestDao jpaNotificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));

    // Act
    Class<NotificationRequestEntity> actualEntityClass = jpaNotificationRequestDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationRequestDao.getEntityType();
    jpaNotificationRequestDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION_REQUEST, actualEntityType);
    Class<NotificationRequestEntity> expectedEntityClass = NotificationRequestEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
