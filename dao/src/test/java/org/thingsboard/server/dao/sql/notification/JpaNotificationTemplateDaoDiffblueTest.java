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
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationTemplateEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaNotificationTemplateDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaNotificationTemplateDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaNotificationTemplateDao jpaNotificationTemplateDao;

  @MockBean
  private NotificationTemplateRepository notificationTemplateRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaNotificationTemplateDao#getEntityClass()}
   *   <li>{@link JpaNotificationTemplateDao#getEntityType()}
   *   <li>{@link JpaNotificationTemplateDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationTemplateDao jpaNotificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));

    // Act
    Class<NotificationTemplateEntity> actualEntityClass = jpaNotificationTemplateDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationTemplateDao.getEntityType();
    jpaNotificationTemplateDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualEntityType);
    Class<NotificationTemplateEntity> expectedEntityClass = NotificationTemplateEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test
   * {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)}.
   * <ul>
   *   <li>Given {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndNotificationTypesAndPageLink_givenAlarm() {
    // Arrange
    when(notificationTemplateRepository.findByTenantIdAndNotificationTypesAndSearchText(Mockito.<UUID>any(),
        Mockito.<List<NotificationType>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.ALARM);
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdAndNotificationTypesAndPageLinkResult = jpaNotificationTemplateDao
        .findByTenantIdAndNotificationTypesAndPageLink(ModelConstants.SYSTEM_TENANT, notificationTypes,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTemplateRepository).findByTenantIdAndNotificationTypesAndSearchText(isA(UUID.class),
        isA(List.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)}.
   * <ul>
   *   <li>Given {@code GENERAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndNotificationTypesAndPageLink_givenGeneral() {
    // Arrange
    when(notificationTemplateRepository.findByTenantIdAndNotificationTypesAndSearchText(Mockito.<UUID>any(),
        Mockito.<List<NotificationType>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdAndNotificationTypesAndPageLinkResult = jpaNotificationTemplateDao
        .findByTenantIdAndNotificationTypesAndPageLink(ModelConstants.SYSTEM_TENANT, notificationTypes,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTemplateRepository).findByTenantIdAndNotificationTypesAndSearchText(isA(UUID.class),
        isA(List.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndNotificationTypesAndPageLink_givenOne_thenCallsGetPage() {
    // Arrange
    when(notificationTemplateRepository.findByTenantIdAndNotificationTypesAndSearchText(Mockito.<UUID>any(),
        Mockito.<List<NotificationType>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdAndNotificationTypesAndPageLinkResult = jpaNotificationTemplateDao
        .findByTenantIdAndNotificationTypesAndPageLink(ModelConstants.SYSTEM_TENANT, notificationTypes, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTemplateRepository).findByTenantIdAndNotificationTypesAndSearchText(isA(UUID.class),
        isA(List.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndNotificationTypesAndPageLink_thenReturnDataSizeIsOne() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = mock(NotificationTemplateEntity.class);
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    when(notificationTemplateEntity.toData()).thenReturn(notificationTemplate);
    doNothing().when(notificationTemplateEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTemplateEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTemplateEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTemplateEntity).setNotificationType(Mockito.<NotificationType>any());
    doNothing().when(notificationTemplateEntity).setTenantId(Mockito.<UUID>any());
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(-1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("42");
    notificationTemplateEntity.setNotificationType(NotificationType.DEVICE_ACTIVITY);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTemplateEntity> content = new ArrayList<>();
    content.add(notificationTemplateEntity);
    PageImpl<NotificationTemplateEntity> pageImpl = new PageImpl<>(content);
    when(notificationTemplateRepository.findByTenantIdAndNotificationTypesAndSearchText(Mockito.<UUID>any(),
        Mockito.<List<NotificationType>>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdAndNotificationTypesAndPageLinkResult = jpaNotificationTemplateDao
        .findByTenantIdAndNotificationTypesAndPageLink(ModelConstants.SYSTEM_TENANT, notificationTypes, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTemplateEntity).setCreatedTime(eq(-1L));
    verify(notificationTemplateEntity).setId(isA(UUID.class));
    verify(notificationTemplateEntity).setUuid(isA(UUID.class));
    verify(notificationTemplateEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTemplateEntity).setExternalId(isA(UUID.class));
    verify(notificationTemplateEntity).setName(eq("42"));
    verify(notificationTemplateEntity).setNotificationType(eq(NotificationType.DEVICE_ACTIVITY));
    verify(notificationTemplateEntity).setTenantId(isA(UUID.class));
    verify(notificationTemplateEntity).toData();
    verify(notificationTemplateRepository).findByTenantIdAndNotificationTypesAndSearchText(isA(UUID.class),
        isA(List.class), eq("Text Search"), isA(Pageable.class));
    List<NotificationTemplate> data = actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalElements());
    assertSame(notificationTemplate, data.get(0));
  }

  /**
   * Test
   * {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)}
   */
  @Test
  public void testFindByTenantIdAndNotificationTypesAndPageLink_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTemplateRepository.findByTenantIdAndNotificationTypesAndSearchText(Mockito.<UUID>any(),
        Mockito.<List<NotificationType>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdAndNotificationTypesAndPageLinkResult = jpaNotificationTemplateDao
        .findByTenantIdAndNotificationTypesAndPageLink(ModelConstants.SYSTEM_TENANT, new ArrayList<>(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTemplateRepository).findByTenantIdAndNotificationTypesAndSearchText(isA(UUID.class),
        isA(List.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}.
   * <ul>
   *   <li>Given {@code ALARM}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}
   */
  @Test
  public void testCountByTenantIdAndNotificationTypes_givenAlarm_whenArrayListAddAlarm() {
    // Arrange
    when(notificationTemplateRepository.countByTenantIdAndNotificationTypes(Mockito.<UUID>any(),
        Mockito.<List<NotificationType>>any())).thenReturn(1);

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.ALARM);
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    int actualCountByTenantIdAndNotificationTypesResult = jpaNotificationTemplateDao
        .countByTenantIdAndNotificationTypes(ModelConstants.SYSTEM_TENANT, notificationTypes);

    // Assert
    verify(notificationTemplateRepository).countByTenantIdAndNotificationTypes(isA(UUID.class), isA(List.class));
    assertEquals(1, actualCountByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test
   * {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}.
   * <ul>
   *   <li>Given {@code GENERAL}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code GENERAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}
   */
  @Test
  public void testCountByTenantIdAndNotificationTypes_givenGeneral_whenArrayListAddGeneral() {
    // Arrange
    when(notificationTemplateRepository.countByTenantIdAndNotificationTypes(Mockito.<UUID>any(),
        Mockito.<List<NotificationType>>any())).thenReturn(1);

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    int actualCountByTenantIdAndNotificationTypesResult = jpaNotificationTemplateDao
        .countByTenantIdAndNotificationTypes(ModelConstants.SYSTEM_TENANT, notificationTypes);

    // Assert
    verify(notificationTemplateRepository).countByTenantIdAndNotificationTypes(isA(UUID.class), isA(List.class));
    assertEquals(1, actualCountByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test
   * {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}
   */
  @Test
  public void testCountByTenantIdAndNotificationTypes_whenArrayList_thenReturnOne() {
    // Arrange
    when(notificationTemplateRepository.countByTenantIdAndNotificationTypes(Mockito.<UUID>any(),
        Mockito.<List<NotificationType>>any())).thenReturn(1);

    // Act
    int actualCountByTenantIdAndNotificationTypesResult = jpaNotificationTemplateDao
        .countByTenantIdAndNotificationTypes(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(notificationTemplateRepository).countByTenantIdAndNotificationTypes(isA(UUID.class), isA(List.class));
    assertEquals(1, actualCountByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link JpaNotificationTemplateDao#removeByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls
   * {@link NotificationTemplateRepository#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#removeByTenantId(TenantId)}
   */
  @Test
  public void testRemoveByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(notificationTemplateRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaNotificationTemplateDao.removeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(notificationTemplateRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test
   * {@link JpaNotificationTemplateDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then return {@link NotificationTemplate#NotificationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenReturnNotificationTemplate() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = mock(NotificationTemplateEntity.class);
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    when(notificationTemplateEntity.toData()).thenReturn(notificationTemplate);
    doNothing().when(notificationTemplateEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTemplateEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTemplateEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTemplateEntity).setNotificationType(Mockito.<NotificationType>any());
    doNothing().when(notificationTemplateEntity).setTenantId(Mockito.<UUID>any());
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTemplateRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTemplateEntity);

    // Act
    NotificationTemplate actualFindByTenantIdAndExternalIdResult = jpaNotificationTemplateDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(notificationTemplateRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    verify(notificationTemplateEntity).setCreatedTime(eq(1L));
    verify(notificationTemplateEntity).setId(isA(UUID.class));
    verify(notificationTemplateEntity).setUuid(isA(UUID.class));
    verify(notificationTemplateEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTemplateEntity).setExternalId(isA(UUID.class));
    verify(notificationTemplateEntity).setName(eq("Name"));
    verify(notificationTemplateEntity).setNotificationType(eq(NotificationType.GENERAL));
    verify(notificationTemplateEntity).setTenantId(isA(UUID.class));
    verify(notificationTemplateEntity).toData();
    assertSame(notificationTemplate, actualFindByTenantIdAndExternalIdResult);
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then return {@link NotificationTemplate#NotificationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndName_thenReturnNotificationTemplate() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = mock(NotificationTemplateEntity.class);
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    when(notificationTemplateEntity.toData()).thenReturn(notificationTemplate);
    doNothing().when(notificationTemplateEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTemplateEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTemplateEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTemplateEntity).setNotificationType(Mockito.<NotificationType>any());
    doNothing().when(notificationTemplateEntity).setTenantId(Mockito.<UUID>any());
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTemplateRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationTemplateEntity);

    // Act
    NotificationTemplate actualFindByTenantIdAndNameResult = jpaNotificationTemplateDao
        .findByTenantIdAndName(ModelConstants.NULL_UUID, "Name");

    // Assert
    verify(notificationTemplateEntity).setCreatedTime(eq(1L));
    verify(notificationTemplateEntity).setId(isA(UUID.class));
    verify(notificationTemplateEntity).setUuid(isA(UUID.class));
    verify(notificationTemplateEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTemplateEntity).setExternalId(isA(UUID.class));
    verify(notificationTemplateEntity).setName(eq("Name"));
    verify(notificationTemplateEntity).setNotificationType(eq(NotificationType.GENERAL));
    verify(notificationTemplateEntity).setTenantId(isA(UUID.class));
    verify(notificationTemplateEntity).toData();
    verify(notificationTemplateRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertSame(notificationTemplate, actualFindByTenantIdAndNameResult);
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTemplateRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdResult = jpaNotificationTemplateDao
        .findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTemplateRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = mock(NotificationTemplateEntity.class);
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    when(notificationTemplateEntity.toData()).thenReturn(notificationTemplate);
    doNothing().when(notificationTemplateEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTemplateEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTemplateEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTemplateEntity).setNotificationType(Mockito.<NotificationType>any());
    doNothing().when(notificationTemplateEntity).setTenantId(Mockito.<UUID>any());
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(-1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("42");
    notificationTemplateEntity.setNotificationType(NotificationType.DEVICE_ACTIVITY);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTemplateEntity> content = new ArrayList<>();
    content.add(notificationTemplateEntity);
    PageImpl<NotificationTemplateEntity> pageImpl = new PageImpl<>(content);
    when(notificationTemplateRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdResult = jpaNotificationTemplateDao
        .findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTemplateEntity).setCreatedTime(eq(-1L));
    verify(notificationTemplateEntity).setId(isA(UUID.class));
    verify(notificationTemplateEntity).setUuid(isA(UUID.class));
    verify(notificationTemplateEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTemplateEntity).setExternalId(isA(UUID.class));
    verify(notificationTemplateEntity).setName(eq("42"));
    verify(notificationTemplateEntity).setNotificationType(eq(NotificationType.DEVICE_ACTIVITY));
    verify(notificationTemplateEntity).setTenantId(isA(UUID.class));
    verify(notificationTemplateEntity).toData();
    verify(notificationTemplateRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationTemplate> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertSame(notificationTemplate, data.get(0));
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataSizeIsTwo() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = mock(NotificationTemplateEntity.class);
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    when(notificationTemplateEntity.toData()).thenReturn(notificationTemplate);
    doNothing().when(notificationTemplateEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTemplateEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTemplateEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTemplateEntity).setNotificationType(Mockito.<NotificationType>any());
    doNothing().when(notificationTemplateEntity).setTenantId(Mockito.<UUID>any());
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(-1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("42");
    notificationTemplateEntity.setNotificationType(NotificationType.DEVICE_ACTIVITY);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(null);
    notificationTemplateEntity2.setCreatedTime(0L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("org.thingsboard.server.dao.model.sql.NotificationTemplateEntity");
    notificationTemplateEntity2.setNotificationType(NotificationType.ALARM);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTemplateEntity> content = new ArrayList<>();
    content.add(notificationTemplateEntity2);
    content.add(notificationTemplateEntity);
    PageImpl<NotificationTemplateEntity> pageImpl = new PageImpl<>(content);
    when(notificationTemplateRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdResult = jpaNotificationTemplateDao.findByTenantId(tenantId,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationTemplateEntity).setCreatedTime(eq(-1L));
    verify(notificationTemplateEntity).setId(isA(UUID.class));
    verify(notificationTemplateEntity).setUuid(isA(UUID.class));
    verify(notificationTemplateEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTemplateEntity).setExternalId(isA(UUID.class));
    verify(notificationTemplateEntity).setName(eq("42"));
    verify(notificationTemplateEntity).setNotificationType(eq(NotificationType.DEVICE_ACTIVITY));
    verify(notificationTemplateEntity).setTenantId(isA(UUID.class));
    verify(notificationTemplateEntity).toData();
    verify(notificationTemplateRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationTemplate> data = actualFindByTenantIdResult.getData();
    assertEquals(2, data.size());
    NotificationTemplate getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("org.thingsboard.server.dao.model.sql.NotificationTemplateEntity", getResult.getName());
    assertEquals(2L, actualFindByTenantIdResult.getTotalElements());
    NotificationTemplateId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertEquals(NotificationType.ALARM, getResult.getNotificationType());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertEquals(externalId, getResult.getId());
    assertSame(notificationTemplate, data.get(1));
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTemplateRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdResult = jpaNotificationTemplateDao
        .findByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTemplateRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationTemplateDao#getExternalIdByInternal(NotificationTemplateId)}
   * with {@code NotificationTemplateId}.
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#getExternalIdByInternal(NotificationTemplateId)}
   */
  @Test
  public void testGetExternalIdByInternalWithNotificationTemplateId() {
    // Arrange
    when(notificationTemplateRepository.getExternalIdByInternal(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    NotificationTemplateId internalId = new NotificationTemplateId(ModelConstants.NULL_UUID);

    // Act
    NotificationTemplateId actualExternalIdByInternal = jpaNotificationTemplateDao.getExternalIdByInternal(internalId);

    // Assert
    verify(notificationTemplateRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test
   * {@link JpaNotificationTemplateDao#getExternalIdByInternal(NotificationTemplateId)}
   * with {@code NotificationTemplateId}.
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#getExternalIdByInternal(NotificationTemplateId)}
   */
  @Test
  public void testGetExternalIdByInternalWithNotificationTemplateId2() {
    // Arrange
    when(notificationTemplateRepository.getExternalIdByInternal(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    NotificationTemplateId internalId = mock(NotificationTemplateId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    NotificationTemplateId actualExternalIdByInternal = jpaNotificationTemplateDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(notificationTemplateRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test
   * {@link JpaNotificationTemplateDao#getExternalIdByInternal(NotificationTemplateId)}
   * with {@code NotificationTemplateId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationTemplateDao#getExternalIdByInternal(NotificationTemplateId)}
   */
  @Test
  public void testGetExternalIdByInternalWithNotificationTemplateId_thenReturnNull() {
    // Arrange
    when(notificationTemplateRepository.getExternalIdByInternal(Mockito.<UUID>any())).thenReturn(null);

    // Act
    NotificationTemplateId actualExternalIdByInternal = jpaNotificationTemplateDao
        .getExternalIdByInternal(new NotificationTemplateId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationTemplateRepository).getExternalIdByInternal(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }
}
