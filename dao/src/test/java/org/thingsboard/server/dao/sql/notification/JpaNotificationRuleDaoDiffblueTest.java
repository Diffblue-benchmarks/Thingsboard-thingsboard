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
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.NotificationRuleInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationRuleEntity;
import org.thingsboard.server.dao.model.sql.NotificationRuleInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaNotificationRuleDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaNotificationRuleDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaNotificationRuleDao jpaNotificationRuleDao;

  @MockBean
  private NotificationRuleRepository notificationRuleRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test
   * {@link JpaNotificationRuleDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findByTenantIdAndPageLink(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndPageLink_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRuleRepository.findByTenantIdAndSearchText(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationRule> actualFindByTenantIdAndPageLinkResult = jpaNotificationRuleDao
        .findByTenantIdAndPageLink(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRuleRepository).findByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findByTenantIdAndPageLink(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndPageLink_thenReturnDataSizeIsOne() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = mock(NotificationRuleEntity.class);
    NotificationRule notificationRule = new NotificationRule();
    when(notificationRuleEntity.toData()).thenReturn(notificationRule);
    doNothing().when(notificationRuleEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRuleEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setEnabled(anyBoolean());
    doNothing().when(notificationRuleEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setName(Mockito.<String>any());
    doNothing().when(notificationRuleEntity).setRecipientsConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setTriggerConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(-1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("42");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ALARM_COMMENT);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationRuleEntity> content = new ArrayList<>();
    content.add(notificationRuleEntity);
    PageImpl<NotificationRuleEntity> pageImpl = new PageImpl<>(content);
    when(notificationRuleRepository.findByTenantIdAndSearchText(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationRule> actualFindByTenantIdAndPageLinkResult = jpaNotificationRuleDao
        .findByTenantIdAndPageLink(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRuleEntity).setCreatedTime(eq(-1L));
    verify(notificationRuleEntity).setId(isA(UUID.class));
    verify(notificationRuleEntity).setUuid(isA(UUID.class));
    verify(notificationRuleEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setEnabled(eq(true));
    verify(notificationRuleEntity).setExternalId(isA(UUID.class));
    verify(notificationRuleEntity).setName(eq("42"));
    verify(notificationRuleEntity).setRecipientsConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setTemplateId(isA(UUID.class));
    verify(notificationRuleEntity).setTenantId(isA(UUID.class));
    verify(notificationRuleEntity).setTriggerConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setTriggerType(eq(NotificationRuleTriggerType.ALARM_COMMENT));
    verify(notificationRuleEntity).toData();
    verify(notificationRuleRepository).findByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<NotificationRule> data = actualFindByTenantIdAndPageLinkResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindByTenantIdAndPageLinkResult.getTotalElements());
    assertSame(notificationRule, data.get(0));
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findByTenantIdAndPageLink(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndPageLink_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRuleRepository.findByTenantIdAndSearchText(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationRule> actualFindByTenantIdAndPageLinkResult = jpaNotificationRuleDao
        .findByTenantIdAndPageLink(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRuleRepository).findByTenantIdAndSearchText(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#findInfosByTenantIdAndPageLink(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findInfosByTenantIdAndPageLink(TenantId, PageLink)}
   */
  @Test
  public void testFindInfosByTenantIdAndPageLink_givenOne_thenCallsGetPage() {
    // Arrange
    when(notificationRuleRepository.findInfosByTenantIdAndSearchText(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationRuleInfo> actualFindInfosByTenantIdAndPageLinkResult = jpaNotificationRuleDao
        .findInfosByTenantIdAndPageLink(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRuleRepository).findInfosByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindInfosByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindInfosByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindInfosByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindInfosByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#findInfosByTenantIdAndPageLink(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findInfosByTenantIdAndPageLink(TenantId, PageLink)}
   */
  @Test
  public void testFindInfosByTenantIdAndPageLink_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRuleRepository.findInfosByTenantIdAndSearchText(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationRuleInfo> actualFindInfosByTenantIdAndPageLinkResult = jpaNotificationRuleDao
        .findInfosByTenantIdAndPageLink(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRuleRepository).findInfosByTenantIdAndSearchText(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindInfosByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindInfosByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindInfosByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindInfosByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId, NotificationTargetId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId, NotificationTargetId)}
   */
  @Test
  public void testExistsByTenantIdAndTargetId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(notificationRuleRepository.existsByTenantIdAndRecipientsConfigContaining(Mockito.<UUID>any(),
        Mockito.<String>any())).thenReturn(true);
    NotificationTargetId targetId = mock(NotificationTargetId.class);
    when(targetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndTargetIdResult = jpaNotificationRuleDao
        .existsByTenantIdAndTargetId(ModelConstants.SYSTEM_TENANT, targetId);

    // Assert
    verify(targetId).getId();
    verify(notificationRuleRepository).existsByTenantIdAndRecipientsConfigContaining(isA(UUID.class),
        eq("13814000-1dd2-11b2-8080-808080808080"));
    assertTrue(actualExistsByTenantIdAndTargetIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId, NotificationTargetId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId, NotificationTargetId)}
   */
  @Test
  public void testExistsByTenantIdAndTargetId_thenReturnFalse() {
    // Arrange
    when(notificationRuleRepository.existsByTenantIdAndRecipientsConfigContaining(Mockito.<UUID>any(),
        Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualExistsByTenantIdAndTargetIdResult = jpaNotificationRuleDao
        .existsByTenantIdAndTargetId(ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRuleRepository).existsByTenantIdAndRecipientsConfigContaining(isA(UUID.class),
        eq("13814000-1dd2-11b2-8080-808080808080"));
    assertFalse(actualExistsByTenantIdAndTargetIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId, NotificationTargetId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId, NotificationTargetId)}
   */
  @Test
  public void testExistsByTenantIdAndTargetId_thenReturnTrue() {
    // Arrange
    when(notificationRuleRepository.existsByTenantIdAndRecipientsConfigContaining(Mockito.<UUID>any(),
        Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndTargetIdResult = jpaNotificationRuleDao
        .existsByTenantIdAndTargetId(ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRuleRepository).existsByTenantIdAndRecipientsConfigContaining(isA(UUID.class),
        eq("13814000-1dd2-11b2-8080-808080808080"));
    assertTrue(actualExistsByTenantIdAndTargetIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId, NotificationRuleTriggerType, boolean)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId, NotificationRuleTriggerType, boolean)}
   */
  @Test
  public void testFindByTenantIdAndTriggerTypeAndEnabled_thenReturnSizeIsOne() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = mock(NotificationRuleEntity.class);
    NotificationRule notificationRule = new NotificationRule();
    when(notificationRuleEntity.toData()).thenReturn(notificationRule);
    doNothing().when(notificationRuleEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRuleEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setEnabled(anyBoolean());
    doNothing().when(notificationRuleEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setName(Mockito.<String>any());
    doNothing().when(notificationRuleEntity).setRecipientsConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setTriggerConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationRuleEntity> notificationRuleEntityList = new ArrayList<>();
    notificationRuleEntityList.add(notificationRuleEntity);
    when(notificationRuleRepository.findAllByTenantIdAndTriggerTypeAndEnabled(Mockito.<UUID>any(),
        Mockito.<NotificationRuleTriggerType>any(), anyBoolean())).thenReturn(notificationRuleEntityList);

    // Act
    List<NotificationRule> actualFindByTenantIdAndTriggerTypeAndEnabledResult = jpaNotificationRuleDao
        .findByTenantIdAndTriggerTypeAndEnabled(ModelConstants.SYSTEM_TENANT, NotificationRuleTriggerType.ENTITY_ACTION,
            true);

    // Assert
    verify(notificationRuleEntity).setCreatedTime(eq(1L));
    verify(notificationRuleEntity).setId(isA(UUID.class));
    verify(notificationRuleEntity).setUuid(isA(UUID.class));
    verify(notificationRuleEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setEnabled(eq(true));
    verify(notificationRuleEntity).setExternalId(isA(UUID.class));
    verify(notificationRuleEntity).setName(eq("Name"));
    verify(notificationRuleEntity).setRecipientsConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setTemplateId(isA(UUID.class));
    verify(notificationRuleEntity).setTenantId(isA(UUID.class));
    verify(notificationRuleEntity).setTriggerConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setTriggerType(eq(NotificationRuleTriggerType.ENTITY_ACTION));
    verify(notificationRuleEntity).toData();
    verify(notificationRuleRepository).findAllByTenantIdAndTriggerTypeAndEnabled(isA(UUID.class),
        eq(NotificationRuleTriggerType.ENTITY_ACTION), eq(true));
    assertEquals(1, actualFindByTenantIdAndTriggerTypeAndEnabledResult.size());
    assertSame(notificationRule, actualFindByTenantIdAndTriggerTypeAndEnabledResult.get(0));
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId, NotificationRuleTriggerType, boolean)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId, NotificationRuleTriggerType, boolean)}
   */
  @Test
  public void testFindByTenantIdAndTriggerTypeAndEnabled_thenReturnSizeIsTwo() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = mock(NotificationRuleEntity.class);
    NotificationRule notificationRule = new NotificationRule();
    when(notificationRuleEntity.toData()).thenReturn(notificationRule);
    doNothing().when(notificationRuleEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRuleEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setEnabled(anyBoolean());
    doNothing().when(notificationRuleEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setName(Mockito.<String>any());
    doNothing().when(notificationRuleEntity).setRecipientsConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setTriggerConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    when(notificationRuleInfoEntity.toData()).thenReturn(notificationRuleInfo);
    doNothing().when(notificationRuleInfoEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRuleInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleInfoEntity).setEnabled(anyBoolean());
    doNothing().when(notificationRuleInfoEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setName(Mockito.<String>any());
    doNothing().when(notificationRuleInfoEntity).setRecipientsConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleInfoEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setTriggerConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleInfoEntity).setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleInfoEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setCreatedTime(-1L);
    notificationRuleInfoEntity.setEnabled(true);
    notificationRuleInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleInfoEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleInfoEntity.setName("42");
    notificationRuleInfoEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleInfoEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTriggerType(NotificationRuleTriggerType.ALARM_COMMENT);
    notificationRuleInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationRuleEntity> notificationRuleEntityList = new ArrayList<>();
    notificationRuleEntityList.add(notificationRuleInfoEntity);
    notificationRuleEntityList.add(notificationRuleEntity);
    when(notificationRuleRepository.findAllByTenantIdAndTriggerTypeAndEnabled(Mockito.<UUID>any(),
        Mockito.<NotificationRuleTriggerType>any(), anyBoolean())).thenReturn(notificationRuleEntityList);

    // Act
    List<NotificationRule> actualFindByTenantIdAndTriggerTypeAndEnabledResult = jpaNotificationRuleDao
        .findByTenantIdAndTriggerTypeAndEnabled(ModelConstants.SYSTEM_TENANT, NotificationRuleTriggerType.ENTITY_ACTION,
            true);

    // Assert
    verify(notificationRuleInfoEntity).setCreatedTime(eq(-1L));
    verify(notificationRuleEntity).setCreatedTime(eq(1L));
    verify(notificationRuleEntity).setId(isA(UUID.class));
    verify(notificationRuleInfoEntity).setId(isA(UUID.class));
    verify(notificationRuleEntity).setUuid(isA(UUID.class));
    verify(notificationRuleInfoEntity).setUuid(isA(UUID.class));
    verify(notificationRuleEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRuleInfoEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setEnabled(eq(true));
    verify(notificationRuleInfoEntity).setEnabled(eq(true));
    verify(notificationRuleEntity).setExternalId(isA(UUID.class));
    verify(notificationRuleInfoEntity).setExternalId(isA(UUID.class));
    verify(notificationRuleInfoEntity).setName(eq("42"));
    verify(notificationRuleEntity).setName(eq("Name"));
    verify(notificationRuleEntity).setRecipientsConfig(isA(JsonNode.class));
    verify(notificationRuleInfoEntity).setRecipientsConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setTemplateId(isA(UUID.class));
    verify(notificationRuleInfoEntity).setTemplateId(isA(UUID.class));
    verify(notificationRuleEntity).setTenantId(isA(UUID.class));
    verify(notificationRuleInfoEntity).setTenantId(isA(UUID.class));
    verify(notificationRuleEntity).setTriggerConfig(isA(JsonNode.class));
    verify(notificationRuleInfoEntity).setTriggerConfig(isA(JsonNode.class));
    verify(notificationRuleInfoEntity).setTriggerType(eq(NotificationRuleTriggerType.ALARM_COMMENT));
    verify(notificationRuleEntity).setTriggerType(eq(NotificationRuleTriggerType.ENTITY_ACTION));
    verify(notificationRuleEntity).toData();
    verify(notificationRuleInfoEntity).toData();
    verify(notificationRuleRepository).findAllByTenantIdAndTriggerTypeAndEnabled(isA(UUID.class),
        eq(NotificationRuleTriggerType.ENTITY_ACTION), eq(true));
    assertEquals(2, actualFindByTenantIdAndTriggerTypeAndEnabledResult.size());
    assertSame(notificationRule, actualFindByTenantIdAndTriggerTypeAndEnabledResult.get(1));
    assertSame(notificationRuleInfo, actualFindByTenantIdAndTriggerTypeAndEnabledResult.get(0));
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId, NotificationRuleTriggerType, boolean)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId, NotificationRuleTriggerType, boolean)}
   */
  @Test
  public void testFindByTenantIdAndTriggerTypeAndEnabled_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(notificationRuleRepository.findAllByTenantIdAndTriggerTypeAndEnabled(Mockito.<UUID>any(),
        Mockito.<NotificationRuleTriggerType>any(), anyBoolean())).thenReturn(new ArrayList<>());

    // Act
    List<NotificationRule> actualFindByTenantIdAndTriggerTypeAndEnabledResult = jpaNotificationRuleDao
        .findByTenantIdAndTriggerTypeAndEnabled(ModelConstants.SYSTEM_TENANT, NotificationRuleTriggerType.ENTITY_ACTION,
            true);

    // Assert
    verify(notificationRuleRepository).findAllByTenantIdAndTriggerTypeAndEnabled(isA(UUID.class),
        eq(NotificationRuleTriggerType.ENTITY_ACTION), eq(true));
    assertTrue(actualFindByTenantIdAndTriggerTypeAndEnabledResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#findInfoById(TenantId, NotificationRuleId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findInfoById(TenantId, NotificationRuleId)}
   */
  @Test
  public void testFindInfoById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    when(notificationRuleInfoEntity.toData()).thenReturn(notificationRuleInfo);
    when(notificationRuleRepository.findInfoById(Mockito.<UUID>any())).thenReturn(notificationRuleInfoEntity);
    NotificationRuleId id = mock(NotificationRuleId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    NotificationRuleInfo actualFindInfoByIdResult = jpaNotificationRuleDao.findInfoById(ModelConstants.SYSTEM_TENANT,
        id);

    // Assert
    verify(id).getId();
    verify(notificationRuleInfoEntity).toData();
    verify(notificationRuleRepository).findInfoById(isA(UUID.class));
    assertSame(notificationRuleInfo, actualFindInfoByIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#findInfoById(TenantId, NotificationRuleId)}.
   * <ul>
   *   <li>Then return {@link NotificationRuleInfo#NotificationRuleInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findInfoById(TenantId, NotificationRuleId)}
   */
  @Test
  public void testFindInfoById_thenReturnNotificationRuleInfo() {
    // Arrange
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    when(notificationRuleInfoEntity.toData()).thenReturn(notificationRuleInfo);
    when(notificationRuleRepository.findInfoById(Mockito.<UUID>any())).thenReturn(notificationRuleInfoEntity);

    // Act
    NotificationRuleInfo actualFindInfoByIdResult = jpaNotificationRuleDao.findInfoById(ModelConstants.SYSTEM_TENANT,
        new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRuleInfoEntity).toData();
    verify(notificationRuleRepository).findInfoById(isA(UUID.class));
    assertSame(notificationRuleInfo, actualFindInfoByIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#findInfoById(TenantId, NotificationRuleId)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findInfoById(TenantId, NotificationRuleId)}
   */
  @Test
  public void testFindInfoById_thenReturnNull() {
    // Arrange
    when(notificationRuleRepository.findInfoById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    NotificationRuleInfo actualFindInfoByIdResult = jpaNotificationRuleDao.findInfoById(ModelConstants.SYSTEM_TENANT,
        new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRuleRepository).findInfoById(isA(UUID.class));
    assertNull(actualFindInfoByIdResult);
  }

  /**
   * Test {@link JpaNotificationRuleDao#removeByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls
   * {@link NotificationRuleRepository#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationRuleDao#removeByTenantId(TenantId)}
   */
  @Test
  public void testRemoveByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(notificationRuleRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaNotificationRuleDao.removeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(notificationRuleRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then return {@link NotificationRule#NotificationRule()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenReturnNotificationRule() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = mock(NotificationRuleEntity.class);
    NotificationRule notificationRule = new NotificationRule();
    when(notificationRuleEntity.toData()).thenReturn(notificationRule);
    doNothing().when(notificationRuleEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRuleEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setEnabled(anyBoolean());
    doNothing().when(notificationRuleEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setName(Mockito.<String>any());
    doNothing().when(notificationRuleEntity).setRecipientsConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setTriggerConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationRuleRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationRuleEntity);

    // Act
    NotificationRule actualFindByTenantIdAndExternalIdResult = jpaNotificationRuleDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(notificationRuleRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    verify(notificationRuleEntity).setCreatedTime(eq(1L));
    verify(notificationRuleEntity).setId(isA(UUID.class));
    verify(notificationRuleEntity).setUuid(isA(UUID.class));
    verify(notificationRuleEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setEnabled(eq(true));
    verify(notificationRuleEntity).setExternalId(isA(UUID.class));
    verify(notificationRuleEntity).setName(eq("Name"));
    verify(notificationRuleEntity).setRecipientsConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setTemplateId(isA(UUID.class));
    verify(notificationRuleEntity).setTenantId(isA(UUID.class));
    verify(notificationRuleEntity).setTriggerConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setTriggerType(eq(NotificationRuleTriggerType.ENTITY_ACTION));
    verify(notificationRuleEntity).toData();
    assertSame(notificationRule, actualFindByTenantIdAndExternalIdResult);
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then return {@link NotificationRule#NotificationRule()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndName_thenReturnNotificationRule() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = mock(NotificationRuleEntity.class);
    NotificationRule notificationRule = new NotificationRule();
    when(notificationRuleEntity.toData()).thenReturn(notificationRule);
    doNothing().when(notificationRuleEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRuleEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setEnabled(anyBoolean());
    doNothing().when(notificationRuleEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setName(Mockito.<String>any());
    doNothing().when(notificationRuleEntity).setRecipientsConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setTriggerConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationRuleRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationRuleEntity);

    // Act
    NotificationRule actualFindByTenantIdAndNameResult = jpaNotificationRuleDao
        .findByTenantIdAndName(ModelConstants.NULL_UUID, "Name");

    // Assert
    verify(notificationRuleEntity).setCreatedTime(eq(1L));
    verify(notificationRuleEntity).setId(isA(UUID.class));
    verify(notificationRuleEntity).setUuid(isA(UUID.class));
    verify(notificationRuleEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setEnabled(eq(true));
    verify(notificationRuleEntity).setExternalId(isA(UUID.class));
    verify(notificationRuleEntity).setName(eq("Name"));
    verify(notificationRuleEntity).setRecipientsConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setTemplateId(isA(UUID.class));
    verify(notificationRuleEntity).setTenantId(isA(UUID.class));
    verify(notificationRuleEntity).setTriggerConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setTriggerType(eq(NotificationRuleTriggerType.ENTITY_ACTION));
    verify(notificationRuleEntity).toData();
    verify(notificationRuleRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertSame(notificationRule, actualFindByTenantIdAndNameResult);
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRuleRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationRule> actualFindByTenantIdResult = jpaNotificationRuleDao
        .findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRuleRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = mock(NotificationRuleEntity.class);
    NotificationRule notificationRule = new NotificationRule();
    when(notificationRuleEntity.toData()).thenReturn(notificationRule);
    doNothing().when(notificationRuleEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRuleEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setEnabled(anyBoolean());
    doNothing().when(notificationRuleEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setName(Mockito.<String>any());
    doNothing().when(notificationRuleEntity).setRecipientsConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(notificationRuleEntity).setTriggerConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleEntity).setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(-1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("42");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ALARM_COMMENT);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationRuleEntity> content = new ArrayList<>();
    content.add(notificationRuleEntity);
    PageImpl<NotificationRuleEntity> pageImpl = new PageImpl<>(content);
    when(notificationRuleRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationRule> actualFindByTenantIdResult = jpaNotificationRuleDao
        .findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRuleEntity).setCreatedTime(eq(-1L));
    verify(notificationRuleEntity).setId(isA(UUID.class));
    verify(notificationRuleEntity).setUuid(isA(UUID.class));
    verify(notificationRuleEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setEnabled(eq(true));
    verify(notificationRuleEntity).setExternalId(isA(UUID.class));
    verify(notificationRuleEntity).setName(eq("42"));
    verify(notificationRuleEntity).setRecipientsConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setTemplateId(isA(UUID.class));
    verify(notificationRuleEntity).setTenantId(isA(UUID.class));
    verify(notificationRuleEntity).setTriggerConfig(isA(JsonNode.class));
    verify(notificationRuleEntity).setTriggerType(eq(NotificationRuleTriggerType.ALARM_COMMENT));
    verify(notificationRuleEntity).toData();
    verify(notificationRuleRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationRule> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertSame(notificationRule, data.get(0));
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRuleRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationRule> actualFindByTenantIdResult = jpaNotificationRuleDao
        .findByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRuleRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#getExternalIdByInternal(NotificationRuleId)}
   * with {@code NotificationRuleId}.
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#getExternalIdByInternal(NotificationRuleId)}
   */
  @Test
  public void testGetExternalIdByInternalWithNotificationRuleId() {
    // Arrange
    when(notificationRuleRepository.getExternalIdByInternal(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    NotificationRuleId internalId = new NotificationRuleId(ModelConstants.NULL_UUID);

    // Act
    NotificationRuleId actualExternalIdByInternal = jpaNotificationRuleDao.getExternalIdByInternal(internalId);

    // Assert
    verify(notificationRuleRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#getExternalIdByInternal(NotificationRuleId)}
   * with {@code NotificationRuleId}.
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#getExternalIdByInternal(NotificationRuleId)}
   */
  @Test
  public void testGetExternalIdByInternalWithNotificationRuleId2() {
    // Arrange
    when(notificationRuleRepository.getExternalIdByInternal(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    NotificationRuleId internalId = mock(NotificationRuleId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    NotificationRuleId actualExternalIdByInternal = jpaNotificationRuleDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(notificationRuleRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.NOTIFICATION_RULE, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test
   * {@link JpaNotificationRuleDao#getExternalIdByInternal(NotificationRuleId)}
   * with {@code NotificationRuleId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationRuleDao#getExternalIdByInternal(NotificationRuleId)}
   */
  @Test
  public void testGetExternalIdByInternalWithNotificationRuleId_thenReturnNull() {
    // Arrange
    when(notificationRuleRepository.getExternalIdByInternal(Mockito.<UUID>any())).thenReturn(null);

    // Act
    NotificationRuleId actualExternalIdByInternal = jpaNotificationRuleDao
        .getExternalIdByInternal(new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRuleRepository).getExternalIdByInternal(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaNotificationRuleDao#getEntityClass()}
   *   <li>{@link JpaNotificationRuleDao#getEntityType()}
   *   <li>{@link JpaNotificationRuleDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationRuleDao jpaNotificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));

    // Act
    Class<NotificationRuleEntity> actualEntityClass = jpaNotificationRuleDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationRuleDao.getEntityType();
    jpaNotificationRuleDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION_RULE, actualEntityType);
    Class<NotificationRuleEntity> expectedEntityClass = NotificationRuleEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
