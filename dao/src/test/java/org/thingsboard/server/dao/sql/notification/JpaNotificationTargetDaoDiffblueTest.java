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
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilterType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationTargetEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaNotificationTargetDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaNotificationTargetDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaNotificationTargetDao jpaNotificationTargetDao;

  @MockBean
  private NotificationTargetRepository notificationTargetRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndPageLink() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    when(notificationTargetEntity.toData()).thenReturn(new NotificationTarget());
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(-1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("42");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(null);
    notificationTargetEntity2.setCreatedTime(0L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("org.thingsboard.server.dao.model.sql.NotificationTargetEntity");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity2);
    content.add(notificationTargetEntity);
    PageImpl<NotificationTargetEntity> pageImpl = new PageImpl<>(content);
    when(notificationTargetRepository.findByTenantIdAndSearchText(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndPageLinkResult = jpaNotificationTargetDao
        .findByTenantIdAndPageLink(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTargetEntity).setCreatedTime(eq(-1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("42"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdAndPageLinkResult.getData();
    assertEquals(2, data.size());
    NotificationTarget getResult = data.get(0);
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndPageLink2() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    NotificationTarget notificationTarget = new NotificationTarget();
    when(notificationTargetEntity.toData()).thenReturn(notificationTarget);
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(-1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("42");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(null);
    notificationTargetEntity2.setCreatedTime(0L);
    notificationTargetEntity2.setExternalId(null);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("org.thingsboard.server.dao.model.sql.NotificationTargetEntity");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity2);
    content.add(notificationTargetEntity);
    PageImpl<NotificationTargetEntity> pageImpl = new PageImpl<>(content);
    when(notificationTargetRepository.findByTenantIdAndSearchText(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndPageLinkResult = jpaNotificationTargetDao
        .findByTenantIdAndPageLink(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTargetEntity).setCreatedTime(eq(-1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("42"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdAndPageLinkResult.getData();
    assertEquals(2, data.size());
    NotificationTarget getResult = data.get(0);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("org.thingsboard.server.dao.model.sql.NotificationTargetEntity", getResult.getName());
    assertNull(getResult.getExternalId());
    assertEquals(2L, actualFindByTenantIdAndPageLinkResult.getTotalElements());
    NotificationTargetId id = getResult.getId();
    assertEquals(EntityType.NOTIFICATION_TARGET, id.getEntityType());
    assertTrue(id.isNullUid());
    assertSame(notificationTarget, data.get(1));
    assertSame(uuidId, id.getId());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndPageLink_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchText(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndPageLinkResult = jpaNotificationTargetDao
        .findByTenantIdAndPageLink(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTargetRepository).findByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndPageLink_thenReturnDataSizeIsOne() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    NotificationTarget notificationTarget = new NotificationTarget();
    when(notificationTargetEntity.toData()).thenReturn(notificationTarget);
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(-1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("42");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    PageImpl<NotificationTargetEntity> pageImpl = new PageImpl<>(content);
    when(notificationTargetRepository.findByTenantIdAndSearchText(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndPageLinkResult = jpaNotificationTargetDao
        .findByTenantIdAndPageLink(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTargetEntity).setCreatedTime(eq(-1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("42"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdAndPageLinkResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindByTenantIdAndPageLinkResult.getTotalElements());
    assertSame(notificationTarget, data.get(0));
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndPageLink_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchText(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndPageLinkResult = jpaNotificationTargetDao
        .findByTenantIdAndPageLink(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndSearchText(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndSupportedNotificationTypeAndPageLink() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<List<String>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult = jpaNotificationTargetDao
        .findByTenantIdAndSupportedNotificationTypeAndPageLink(ModelConstants.SYSTEM_TENANT, NotificationType.GENERAL,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(isA(UUID.class),
        isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndSupportedNotificationTypeAndPageLink2() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    NotificationTarget notificationTarget = new NotificationTarget();
    when(notificationTargetEntity.toData()).thenReturn(notificationTarget);
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(0L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("42");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    PageImpl<NotificationTargetEntity> pageImpl = new PageImpl<>(content);
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<List<String>>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult = jpaNotificationTargetDao
        .findByTenantIdAndSupportedNotificationTypeAndPageLink(ModelConstants.SYSTEM_TENANT, NotificationType.GENERAL,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTargetEntity).setCreatedTime(eq(0L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("42"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(isA(UUID.class),
        eq("Text Search"), isA(List.class), isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalElements());
    assertSame(notificationTarget, data.get(0));
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)}.
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndSupportedNotificationTypeAndPageLink_thenCallsGetPage() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<List<String>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult = jpaNotificationTargetDao
        .findByTenantIdAndSupportedNotificationTypeAndPageLink(ModelConstants.SYSTEM_TENANT, NotificationType.GENERAL,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTargetRepository).findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(isA(UUID.class),
        eq("Text Search"), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)}.
   * <ul>
   *   <li>When {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndSupportedNotificationTypeAndPageLink_whenAlarm() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<List<String>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult = jpaNotificationTargetDao
        .findByTenantIdAndSupportedNotificationTypeAndPageLink(ModelConstants.SYSTEM_TENANT, NotificationType.ALARM,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(isA(UUID.class),
        isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  public void testFindByTenantIdAndIds() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    when(notificationTargetEntity.toData()).thenReturn(new NotificationTarget());
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(null);
    notificationTargetEntity2.setCreatedTime(-1L);
    notificationTargetEntity2.setExternalId(null);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("42");
    notificationTargetEntity2.setTenantId(new UUID(1L, 1L));
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> notificationTargetEntityList = new ArrayList<>();
    notificationTargetEntityList.add(notificationTargetEntity2);
    notificationTargetEntityList.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(notificationTargetEntityList);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult = jpaNotificationTargetDao
        .findByTenantIdAndIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(notificationTargetEntity).setCreatedTime(eq(1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(2, actualFindByTenantIdAndIdsResult.size());
    NotificationTarget getResult = actualFindByTenantIdAndIdsResult.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("00000000-0000-0001-0000-000000000001", tenantId.getId().toString());
    NotificationTargetId id = getResult.getId();
    assertEquals(EntityType.NOTIFICATION_TARGET, id.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertTrue(id.isNullUid());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@link NotificationTargetId#NotificationTargetId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  public void testFindByTenantIdAndIds_givenNotificationTargetIdWithIdIsNull_uuid() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<NotificationTargetId> ids = new ArrayList<>();
    ids.add(new NotificationTargetId(ModelConstants.NULL_UUID));

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult = jpaNotificationTargetDao
        .findByTenantIdAndIds(ModelConstants.SYSTEM_TENANT, ids);

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@link NotificationTargetId#NotificationTargetId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  public void testFindByTenantIdAndIds_givenNotificationTargetIdWithIdIsNull_uuid2() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<NotificationTargetId> ids = new ArrayList<>();
    ids.add(new NotificationTargetId(ModelConstants.NULL_UUID));
    ids.add(new NotificationTargetId(ModelConstants.NULL_UUID));

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult = jpaNotificationTargetDao
        .findByTenantIdAndIds(ModelConstants.SYSTEM_TENANT, ids);

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   * <ul>
   *   <li>Then return first ExternalId EntityType is
   * {@code NOTIFICATION_TARGET}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  public void testFindByTenantIdAndIds_thenReturnFirstExternalIdEntityTypeIsNotificationTarget() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    when(notificationTargetEntity.toData()).thenReturn(new NotificationTarget());
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(null);
    notificationTargetEntity2.setCreatedTime(-1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("42");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> notificationTargetEntityList = new ArrayList<>();
    notificationTargetEntityList.add(notificationTargetEntity2);
    notificationTargetEntityList.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(notificationTargetEntityList);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult = jpaNotificationTargetDao.findByTenantIdAndIds(tenantId,
        new ArrayList<>());

    // Assert
    verify(notificationTargetEntity).setCreatedTime(eq(1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(2, actualFindByTenantIdAndIdsResult.size());
    NotificationTarget getResult = actualFindByTenantIdAndIdsResult.get(0);
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   * <ul>
   *   <li>Then return first Id EntityType is {@code NOTIFICATION_TARGET}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  public void testFindByTenantIdAndIds_thenReturnFirstIdEntityTypeIsNotificationTarget() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    when(notificationTargetEntity.toData()).thenReturn(new NotificationTarget());
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(null);
    notificationTargetEntity2.setCreatedTime(-1L);
    notificationTargetEntity2.setExternalId(null);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("42");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> notificationTargetEntityList = new ArrayList<>();
    notificationTargetEntityList.add(notificationTargetEntity2);
    notificationTargetEntityList.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(notificationTargetEntityList);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult = jpaNotificationTargetDao.findByTenantIdAndIds(tenantId,
        new ArrayList<>());

    // Assert
    verify(notificationTargetEntity).setCreatedTime(eq(1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(2, actualFindByTenantIdAndIdsResult.size());
    NotificationTarget getResult = actualFindByTenantIdAndIdsResult.get(0);
    NotificationTargetId id = getResult.getId();
    assertEquals(EntityType.NOTIFICATION_TARGET, id.getEntityType());
    assertTrue(id.isNullUid());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   * <ul>
   *   <li>Then return first TenantId Id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  public void testFindByTenantIdAndIds_thenReturnFirstTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    when(notificationTargetEntity.toData()).thenReturn(new NotificationTarget());
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(null);
    notificationTargetEntity2.setCreatedTime(-1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("42");
    UUID tenantId = UUID.randomUUID();
    notificationTargetEntity2.setTenantId(tenantId);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> notificationTargetEntityList = new ArrayList<>();
    notificationTargetEntityList.add(notificationTargetEntity2);
    notificationTargetEntityList.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(notificationTargetEntityList);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult = jpaNotificationTargetDao
        .findByTenantIdAndIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(notificationTargetEntity).setCreatedTime(eq(1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(2, actualFindByTenantIdAndIdsResult.size());
    NotificationTarget getResult = actualFindByTenantIdAndIdsResult.get(0);
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  public void testFindByTenantIdAndIds_thenReturnSizeIsOne() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    NotificationTarget notificationTarget = new NotificationTarget();
    when(notificationTargetEntity.toData()).thenReturn(notificationTarget);
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> notificationTargetEntityList = new ArrayList<>();
    notificationTargetEntityList.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(notificationTargetEntityList);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult = jpaNotificationTargetDao
        .findByTenantIdAndIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(notificationTargetEntity).setCreatedTime(eq(1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByTenantIdAndIdsResult.size());
    assertSame(notificationTarget, actualFindByTenantIdAndIdsResult.get(0));
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  public void testFindByTenantIdAndIds_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult = jpaNotificationTargetDao
        .findByTenantIdAndIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}
   */
  @Test
  public void testFindByTenantIdAndUsersFilterType() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    when(notificationTargetEntity.toData()).thenReturn(new NotificationTarget());
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(2147483647L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(null);
    notificationTargetEntity2.setCreatedTime(0L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("42");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity2);
    content.add(notificationTargetEntity);
    PageImpl<NotificationTargetEntity> pageImpl = new PageImpl<>(content);
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<List<String>>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    List<NotificationTarget> actualFindByTenantIdAndUsersFilterTypeResult = jpaNotificationTargetDao
        .findByTenantIdAndUsersFilterType(tenantId, UsersFilterType.USER_LIST);

    // Assert
    verify(notificationTargetEntity).setCreatedTime(eq(2147483647L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(isA(UUID.class),
        isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(2, actualFindByTenantIdAndUsersFilterTypeResult.size());
    NotificationTarget getResult = actualFindByTenantIdAndUsersFilterTypeResult.get(0);
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}
   */
  @Test
  public void testFindByTenantIdAndUsersFilterType_thenReturnEmpty() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<List<String>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    List<NotificationTarget> actualFindByTenantIdAndUsersFilterTypeResult = jpaNotificationTargetDao
        .findByTenantIdAndUsersFilterType(ModelConstants.SYSTEM_TENANT, UsersFilterType.USER_LIST);

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(isA(UUID.class),
        isNull(), isA(List.class), isA(Pageable.class));
    assertTrue(actualFindByTenantIdAndUsersFilterTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}.
   * <ul>
   *   <li>Then return first ExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}
   */
  @Test
  public void testFindByTenantIdAndUsersFilterType_thenReturnFirstExternalIdIsNull() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    when(notificationTargetEntity.toData()).thenReturn(new NotificationTarget());
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(2147483647L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(null);
    notificationTargetEntity2.setCreatedTime(0L);
    notificationTargetEntity2.setExternalId(null);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("42");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity2);
    content.add(notificationTargetEntity);
    PageImpl<NotificationTargetEntity> pageImpl = new PageImpl<>(content);
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<List<String>>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    List<NotificationTarget> actualFindByTenantIdAndUsersFilterTypeResult = jpaNotificationTargetDao
        .findByTenantIdAndUsersFilterType(tenantId, UsersFilterType.USER_LIST);

    // Assert
    verify(notificationTargetEntity).setCreatedTime(eq(2147483647L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(isA(UUID.class),
        isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(2, actualFindByTenantIdAndUsersFilterTypeResult.size());
    NotificationTarget getResult = actualFindByTenantIdAndUsersFilterTypeResult.get(0);
    assertNull(getResult.getExternalId());
    NotificationTargetId id = getResult.getId();
    assertEquals(EntityType.NOTIFICATION_TARGET, id.getEntityType());
    assertTrue(id.isNullUid());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}.
   * <ul>
   *   <li>Then return not first TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}
   */
  @Test
  public void testFindByTenantIdAndUsersFilterType_thenReturnNotFirstTenantIdNullUid() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    when(notificationTargetEntity.toData()).thenReturn(new NotificationTarget());
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(2147483647L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(null);
    notificationTargetEntity2.setCreatedTime(0L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("42");
    UUID tenantId = UUID.randomUUID();
    notificationTargetEntity2.setTenantId(tenantId);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity2);
    content.add(notificationTargetEntity);
    PageImpl<NotificationTargetEntity> pageImpl = new PageImpl<>(content);
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<List<String>>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndUsersFilterTypeResult = jpaNotificationTargetDao
        .findByTenantIdAndUsersFilterType(ModelConstants.SYSTEM_TENANT, UsersFilterType.USER_LIST);

    // Assert
    verify(notificationTargetEntity).setCreatedTime(eq(2147483647L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(isA(UUID.class),
        isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(2, actualFindByTenantIdAndUsersFilterTypeResult.size());
    TenantId tenantId2 = actualFindByTenantIdAndUsersFilterTypeResult.get(0).getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}
   */
  @Test
  public void testFindByTenantIdAndUsersFilterType_thenReturnSizeIsOne() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    NotificationTarget notificationTarget = new NotificationTarget();
    when(notificationTargetEntity.toData()).thenReturn(notificationTarget);
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(2147483647L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    PageImpl<NotificationTargetEntity> pageImpl = new PageImpl<>(content);
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<List<String>>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndUsersFilterTypeResult = jpaNotificationTargetDao
        .findByTenantIdAndUsersFilterType(ModelConstants.SYSTEM_TENANT, UsersFilterType.USER_LIST);

    // Assert
    verify(notificationTargetEntity).setCreatedTime(eq(2147483647L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(isA(UUID.class),
        isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(1, actualFindByTenantIdAndUsersFilterTypeResult.size());
    assertSame(notificationTarget, actualFindByTenantIdAndUsersFilterTypeResult.get(0));
  }

  /**
   * Test {@link JpaNotificationTargetDao#removeByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls
   * {@link NotificationTargetRepository#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#removeByTenantId(TenantId)}
   */
  @Test
  public void testRemoveByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(notificationTargetRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaNotificationTargetDao.removeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(notificationTargetRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationTargetDao#countByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationTargetDao#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(notificationTargetRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaNotificationTargetDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTargetRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then return {@link NotificationTarget#NotificationTarget()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenReturnNotificationTarget() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    NotificationTarget notificationTarget = new NotificationTarget();
    when(notificationTargetEntity.toData()).thenReturn(notificationTarget);
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTargetRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTargetEntity);

    // Act
    NotificationTarget actualFindByTenantIdAndExternalIdResult = jpaNotificationTargetDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    verify(notificationTargetEntity).setCreatedTime(eq(1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    assertSame(notificationTarget, actualFindByTenantIdAndExternalIdResult);
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then return {@link NotificationTarget#NotificationTarget()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndName_thenReturnNotificationTarget() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    NotificationTarget notificationTarget = new NotificationTarget();
    when(notificationTargetEntity.toData()).thenReturn(notificationTarget);
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTargetRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationTargetEntity);

    // Act
    NotificationTarget actualFindByTenantIdAndNameResult = jpaNotificationTargetDao
        .findByTenantIdAndName(ModelConstants.NULL_UUID, "Name");

    // Assert
    verify(notificationTargetEntity).setCreatedTime(eq(1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertSame(notificationTarget, actualFindByTenantIdAndNameResult);
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTargetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdResult = jpaNotificationTargetDao
        .findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTargetRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first ExternalId EntityType is
   * {@code NOTIFICATION_TARGET}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataFirstExternalIdEntityTypeIsNotificationTarget() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    when(notificationTargetEntity.toData()).thenReturn(new NotificationTarget());
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(-1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("42");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(null);
    notificationTargetEntity2.setCreatedTime(0L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("org.thingsboard.server.dao.model.sql.NotificationTargetEntity");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity2);
    content.add(notificationTargetEntity);
    PageImpl<NotificationTargetEntity> pageImpl = new PageImpl<>(content);
    when(notificationTargetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdResult = jpaNotificationTargetDao.findByTenantId(tenantId,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTargetEntity).setCreatedTime(eq(-1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("42"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdResult.getData();
    assertEquals(2, data.size());
    NotificationTarget getResult = data.get(0);
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first Id EntityType is {@code NOTIFICATION_TARGET}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataFirstIdEntityTypeIsNotificationTarget() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    when(notificationTargetEntity.toData()).thenReturn(new NotificationTarget());
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(-1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("42");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(null);
    notificationTargetEntity2.setCreatedTime(0L);
    notificationTargetEntity2.setExternalId(null);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("org.thingsboard.server.dao.model.sql.NotificationTargetEntity");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity2);
    content.add(notificationTargetEntity);
    PageImpl<NotificationTargetEntity> pageImpl = new PageImpl<>(content);
    when(notificationTargetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdResult = jpaNotificationTargetDao.findByTenantId(tenantId,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTargetEntity).setCreatedTime(eq(-1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("42"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdResult.getData();
    assertEquals(2, data.size());
    NotificationTargetId id = data.get(0).getId();
    assertEquals(EntityType.NOTIFICATION_TARGET, id.getEntityType());
    assertTrue(id.isNullUid());
    assertSame(tenantId, id.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    NotificationTarget notificationTarget = new NotificationTarget();
    when(notificationTargetEntity.toData()).thenReturn(notificationTarget);
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(-1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("42");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    PageImpl<NotificationTargetEntity> pageImpl = new PageImpl<>(content);
    when(notificationTargetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdResult = jpaNotificationTargetDao
        .findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTargetEntity).setCreatedTime(eq(-1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("42"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTargetRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertSame(notificationTarget, data.get(0));
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTargetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdResult = jpaNotificationTargetDao
        .findByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTargetRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#getExternalIdByInternal(NotificationTargetId)}
   * with {@code NotificationTargetId}.
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#getExternalIdByInternal(NotificationTargetId)}
   */
  @Test
  public void testGetExternalIdByInternalWithNotificationTargetId() {
    // Arrange
    when(notificationTargetRepository.getExternalIdByInternal(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    NotificationTargetId internalId = new NotificationTargetId(ModelConstants.NULL_UUID);

    // Act
    NotificationTargetId actualExternalIdByInternal = jpaNotificationTargetDao.getExternalIdByInternal(internalId);

    // Assert
    verify(notificationTargetRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#getExternalIdByInternal(NotificationTargetId)}
   * with {@code NotificationTargetId}.
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#getExternalIdByInternal(NotificationTargetId)}
   */
  @Test
  public void testGetExternalIdByInternalWithNotificationTargetId2() {
    // Arrange
    when(notificationTargetRepository.getExternalIdByInternal(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    NotificationTargetId internalId = mock(NotificationTargetId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    NotificationTargetId actualExternalIdByInternal = jpaNotificationTargetDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(notificationTargetRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test
   * {@link JpaNotificationTargetDao#getExternalIdByInternal(NotificationTargetId)}
   * with {@code NotificationTargetId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTargetDao#getExternalIdByInternal(NotificationTargetId)}
   */
  @Test
  public void testGetExternalIdByInternalWithNotificationTargetId_thenReturnNull() {
    // Arrange
    when(notificationTargetRepository.getExternalIdByInternal(Mockito.<UUID>any())).thenReturn(null);

    // Act
    NotificationTargetId actualExternalIdByInternal = jpaNotificationTargetDao
        .getExternalIdByInternal(new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationTargetRepository).getExternalIdByInternal(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaNotificationTargetDao#getEntityClass()}
   *   <li>{@link JpaNotificationTargetDao#getEntityType()}
   *   <li>{@link JpaNotificationTargetDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationTargetDao jpaNotificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));

    // Act
    Class<NotificationTargetEntity> actualEntityClass = jpaNotificationTargetDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationTargetDao.getEntityType();
    jpaNotificationTargetDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION_TARGET, actualEntityType);
    Class<NotificationTargetEntity> expectedEntityClass = NotificationTargetEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
