package org.thingsboard.server.dao.sql.tenant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.TenantProfileType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.TenantProfileEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaTenantProfileDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaTenantProfileDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaTenantProfileDao jpaTenantProfileDao;

  @MockBean
  private TenantProfileRepository tenantProfileRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaTenantProfileDao#getEntityClass()}
   *   <li>{@link JpaTenantProfileDao#getEntityType()}
   *   <li>{@link JpaTenantProfileDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaTenantProfileDao jpaTenantProfileDao = new JpaTenantProfileDao();

    // Act
    Class<TenantProfileEntity> actualEntityClass = jpaTenantProfileDao.getEntityClass();
    EntityType actualEntityType = jpaTenantProfileDao.getEntityType();

    // Assert
    assertNull(jpaTenantProfileDao.getRepository());
    assertEquals(EntityType.TENANT_PROFILE, actualEntityType);
    Class<TenantProfileEntity> expectedEntityClass = TenantProfileEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfileInfoById(TenantId, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaTenantProfileDao#findTenantProfileInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindTenantProfileInfoById() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name");

    when(tenantProfileRepository.findTenantProfileInfoById(Mockito.<UUID>any())).thenReturn(entityInfo);

    // Act
    EntityInfo actualFindTenantProfileInfoByIdResult = jpaTenantProfileDao
        .findTenantProfileInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(tenantProfileRepository).findTenantProfileInfoById(isA(UUID.class));
    assertSame(entityInfo, actualFindTenantProfileInfoByIdResult);
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTenantProfileDao#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfiles_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantProfileRepository.findTenantProfiles(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TenantProfile> actualFindTenantProfilesResult = jpaTenantProfileDao
        .findTenantProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tenantProfileRepository).findTenantProfiles(eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindTenantProfilesResult.getTotalElements());
    assertEquals(1, actualFindTenantProfilesResult.getTotalPages());
    assertFalse(actualFindTenantProfilesResult.hasNext());
    assertTrue(actualFindTenantProfilesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTenantProfileDao#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfiles_thenReturnDataSizeIsOne() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(-1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("com.fasterxml.jackson.databind.JsonNode");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("42");
    tenantProfileEntity.setProfileData(null);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<TenantProfileEntity> content = new ArrayList<>();
    content.add(tenantProfileEntity);
    PageImpl<TenantProfileEntity> pageImpl = new PageImpl<>(content);
    when(tenantProfileRepository.findTenantProfiles(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TenantProfile> actualFindTenantProfilesResult = jpaTenantProfileDao
        .findTenantProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tenantProfileRepository).findTenantProfiles(eq("Text Search"), isA(Pageable.class));
    List<TenantProfile> data = actualFindTenantProfilesResult.getData();
    assertEquals(1, data.size());
    TenantProfile getResult = data.get(0);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("42", getResult.getName());
    assertEquals("com.fasterxml.jackson.databind.JsonNode", getResult.getDescription());
    assertNull(getResult.getProfileDataBytes());
    DefaultTenantProfileConfiguration defaultProfileConfiguration = getResult.getDefaultProfileConfiguration();
    assertNull(defaultProfileConfiguration.getSmsEnabled());
    assertNull(defaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(defaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    TenantProfileData profileData = getResult.getProfileData();
    assertNull(profileData.getQueueConfiguration());
    assertEquals(0, defaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, defaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, defaultProfileConfiguration.getWarnThreshold(), 0.0);
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(0L, defaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, defaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, defaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, defaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, defaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, defaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, defaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, defaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, defaultProfileConfiguration.getMaxSms());
    assertEquals(0L, defaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, defaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(1L, actualFindTenantProfilesResult.getTotalElements());
    TenantProfileId id = getResult.getId();
    assertEquals(EntityType.TENANT_PROFILE, id.getEntityType());
    assertEquals(TenantProfileType.DEFAULT, defaultProfileConfiguration.getType());
    Optional<DefaultTenantProfileConfiguration> profileConfiguration = getResult.getProfileConfiguration();
    assertTrue(profileConfiguration.isPresent());
    assertTrue(getResult.isDefault());
    assertTrue(getResult.isIsolatedTbRuleEngine());
    assertTrue(id.isNullUid());
    assertSame(defaultProfileConfiguration, profileConfiguration.get());
    assertSame(defaultProfileConfiguration, profileData.getConfiguration());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTenantProfileDao#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfiles_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantProfileRepository.findTenantProfiles(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TenantProfile> actualFindTenantProfilesResult = jpaTenantProfileDao
        .findTenantProfiles(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantProfileRepository).findTenantProfiles(isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindTenantProfilesResult.getTotalElements());
    assertEquals(1, actualFindTenantProfilesResult.getTotalPages());
    assertFalse(actualFindTenantProfilesResult.hasNext());
    assertTrue(actualFindTenantProfilesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfileInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTenantProfileDao#findTenantProfileInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfileInfos_givenOne_thenCallsGetPage() {
    // Arrange
    when(tenantProfileRepository.findTenantProfileInfos(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityInfo> actualFindTenantProfileInfosResult = jpaTenantProfileDao
        .findTenantProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tenantProfileRepository).findTenantProfileInfos(eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindTenantProfileInfosResult.getTotalElements());
    assertEquals(1, actualFindTenantProfileInfosResult.getTotalPages());
    assertFalse(actualFindTenantProfileInfosResult.hasNext());
    assertTrue(actualFindTenantProfileInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfileInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTenantProfileDao#findTenantProfileInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfileInfos_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantProfileRepository.findTenantProfileInfos(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityInfo> actualFindTenantProfileInfosResult = jpaTenantProfileDao
        .findTenantProfileInfos(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantProfileRepository).findTenantProfileInfos(isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindTenantProfileInfosResult.getTotalElements());
    assertEquals(1, actualFindTenantProfileInfosResult.getTotalPages());
    assertFalse(actualFindTenantProfileInfosResult.hasNext());
    assertTrue(actualFindTenantProfileInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantProfileDao#findDefaultTenantProfile(TenantId)}.
   * <p>
   * Method under test:
   * {@link JpaTenantProfileDao#findDefaultTenantProfile(TenantId)}
   */
  @Test
  public void testFindDefaultTenantProfile() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(MissingNode.getInstance());
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);
    when(tenantProfileRepository.findByDefaultTrue()).thenReturn(tenantProfileEntity);

    // Act
    TenantProfile actualFindDefaultTenantProfileResult = jpaTenantProfileDao
        .findDefaultTenantProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileRepository).findByDefaultTrue();
    UUID uuidId = actualFindDefaultTenantProfileResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Name", actualFindDefaultTenantProfileResult.getName());
    assertEquals("The characteristics of someone or something", actualFindDefaultTenantProfileResult.getDescription());
    assertNull(actualFindDefaultTenantProfileResult.getProfileDataBytes());
    DefaultTenantProfileConfiguration defaultProfileConfiguration = actualFindDefaultTenantProfileResult
        .getDefaultProfileConfiguration();
    assertNull(defaultProfileConfiguration.getSmsEnabled());
    assertNull(defaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(defaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    TenantProfileData profileData = actualFindDefaultTenantProfileResult.getProfileData();
    assertNull(profileData.getQueueConfiguration());
    assertEquals(0, defaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, defaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, defaultProfileConfiguration.getWarnThreshold(), 0.0);
    assertEquals(0L, defaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, defaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, defaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, defaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, defaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, defaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, defaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, defaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, defaultProfileConfiguration.getMaxSms());
    assertEquals(0L, defaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, defaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(1L, actualFindDefaultTenantProfileResult.getCreatedTime());
    TenantProfileId id = actualFindDefaultTenantProfileResult.getId();
    assertEquals(EntityType.TENANT_PROFILE, id.getEntityType());
    assertEquals(TenantProfileType.DEFAULT, defaultProfileConfiguration.getType());
    Optional<DefaultTenantProfileConfiguration> profileConfiguration = actualFindDefaultTenantProfileResult
        .getProfileConfiguration();
    assertTrue(profileConfiguration.isPresent());
    assertTrue(actualFindDefaultTenantProfileResult.isDefault());
    assertTrue(actualFindDefaultTenantProfileResult.isIsolatedTbRuleEngine());
    assertTrue(id.isNullUid());
    assertSame(defaultProfileConfiguration, profileConfiguration.get());
    assertSame(defaultProfileConfiguration, profileData.getConfiguration());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link JpaTenantProfileDao#findDefaultTenantProfileInfo(TenantId)}.
   * <p>
   * Method under test:
   * {@link JpaTenantProfileDao#findDefaultTenantProfileInfo(TenantId)}
   */
  @Test
  public void testFindDefaultTenantProfileInfo() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name");

    when(tenantProfileRepository.findDefaultTenantProfileInfo()).thenReturn(entityInfo);

    // Act
    EntityInfo actualFindDefaultTenantProfileInfoResult = jpaTenantProfileDao
        .findDefaultTenantProfileInfo(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileRepository).findDefaultTenantProfileInfo();
    assertSame(entityInfo, actualFindDefaultTenantProfileInfoResult);
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfilesByIds(TenantId, UUID[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTenantProfileDao#findTenantProfilesByIds(TenantId, UUID[])}
   */
  @Test
  public void testFindTenantProfilesByIds_thenReturnEmpty() {
    // Arrange
    when(tenantProfileRepository.findByIdIn(Mockito.<List<UUID>>any())).thenReturn(new ArrayList<>());

    // Act
    List<TenantProfile> actualFindTenantProfilesByIdsResult = jpaTenantProfileDao
        .findTenantProfilesByIds(ModelConstants.SYSTEM_TENANT, new UUID[]{ModelConstants.NULL_UUID});

    // Assert
    verify(tenantProfileRepository).findByIdIn(isA(List.class));
    assertTrue(actualFindTenantProfilesByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfilesByIds(TenantId, UUID[])}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTenantProfileDao#findTenantProfilesByIds(TenantId, UUID[])}
   */
  @Test
  public void testFindTenantProfilesByIds_thenReturnSizeIsOne() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(MissingNode.getInstance());
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<TenantProfileEntity> tenantProfileEntityList = new ArrayList<>();
    tenantProfileEntityList.add(tenantProfileEntity);
    when(tenantProfileRepository.findByIdIn(Mockito.<List<UUID>>any())).thenReturn(tenantProfileEntityList);

    // Act
    List<TenantProfile> actualFindTenantProfilesByIdsResult = jpaTenantProfileDao
        .findTenantProfilesByIds(ModelConstants.SYSTEM_TENANT, new UUID[]{ModelConstants.NULL_UUID});

    // Assert
    verify(tenantProfileRepository).findByIdIn(isA(List.class));
    assertEquals(1, actualFindTenantProfilesByIdsResult.size());
    TenantProfile getResult = actualFindTenantProfilesByIdsResult.get(0);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertNull(getResult.getProfileDataBytes());
    DefaultTenantProfileConfiguration defaultProfileConfiguration = getResult.getDefaultProfileConfiguration();
    assertNull(defaultProfileConfiguration.getSmsEnabled());
    assertNull(defaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(defaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    TenantProfileData profileData = getResult.getProfileData();
    assertNull(profileData.getQueueConfiguration());
    assertEquals(0, defaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, defaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, defaultProfileConfiguration.getWarnThreshold(), 0.0);
    assertEquals(0L, defaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, defaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, defaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, defaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, defaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, defaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, defaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, defaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, defaultProfileConfiguration.getMaxSms());
    assertEquals(0L, defaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, defaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(1L, getResult.getCreatedTime());
    TenantProfileId id = getResult.getId();
    assertEquals(EntityType.TENANT_PROFILE, id.getEntityType());
    assertEquals(TenantProfileType.DEFAULT, defaultProfileConfiguration.getType());
    Optional<DefaultTenantProfileConfiguration> profileConfiguration = getResult.getProfileConfiguration();
    assertTrue(profileConfiguration.isPresent());
    assertTrue(getResult.isDefault());
    assertTrue(getResult.isIsolatedTbRuleEngine());
    assertTrue(id.isNullUid());
    assertSame(defaultProfileConfiguration, profileConfiguration.get());
    assertSame(defaultProfileConfiguration, profileData.getConfiguration());
    assertSame(uuidId, id.getId());
  }
}
