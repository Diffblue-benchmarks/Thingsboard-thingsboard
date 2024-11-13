package org.thingsboard.server.dao.sql.device;

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
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceProfileInfo;
import org.thingsboard.server.common.data.DeviceProfileProvisionType;
import org.thingsboard.server.common.data.DeviceProfileType;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DeviceProfileEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaDeviceProfileDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaDeviceProfileDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private DeviceProfileRepository deviceProfileRepository;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaDeviceProfileDao jpaDeviceProfileDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaDeviceProfileDao#getEntityClass()}
   *   <li>{@link JpaDeviceProfileDao#getEntityType()}
   *   <li>{@link JpaDeviceProfileDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaDeviceProfileDao jpaDeviceProfileDao = new JpaDeviceProfileDao();

    // Act
    Class<DeviceProfileEntity> actualEntityClass = jpaDeviceProfileDao.getEntityClass();
    EntityType actualEntityType = jpaDeviceProfileDao.getEntityType();

    // Assert
    assertNull(jpaDeviceProfileDao.getRepository());
    assertEquals(EntityType.DEVICE_PROFILE, actualEntityType);
    Class<DeviceProfileEntity> expectedEntityClass = DeviceProfileEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDeviceProfileInfoById(TenantId, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#findDeviceProfileInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindDeviceProfileInfoById() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());
    when(deviceProfileRepository.findDeviceProfileInfoById(Mockito.<UUID>any())).thenReturn(deviceProfileInfo);

    // Act
    DeviceProfileInfo actualFindDeviceProfileInfoByIdResult = jpaDeviceProfileDao
        .findDeviceProfileInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(deviceProfileRepository).findDeviceProfileInfoById(isA(UUID.class));
    assertSame(deviceProfileInfo, actualFindDeviceProfileInfoByIdResult);
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindDeviceProfiles_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(
        deviceProfileRepository.findDeviceProfiles(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult = jpaDeviceProfileDao
        .findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceProfileRepository).findDeviceProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDeviceProfilesResult.getTotalElements());
    assertEquals(1, actualFindDeviceProfilesResult.getTotalPages());
    assertFalse(actualFindDeviceProfilesResult.hasNext());
    assertTrue(actualFindDeviceProfilesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return not Data first TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindDeviceProfiles_thenReturnNotDataFirstTenantIdNullUid() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(-1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultQueueName("42");
    deviceProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDescription("com.fasterxml.jackson.databind.JsonNode");
    deviceProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setImage("42");
    deviceProfileEntity.setName("42");
    deviceProfileEntity.setProfileData(null);
    deviceProfileEntity.setProvisionDeviceKey("42");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.CHECK_PRE_PROVISIONED_DEVICES);
    deviceProfileEntity.setSoftwareId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    deviceProfileEntity.setTenantId(tenantId);
    deviceProfileEntity.setTransportType(DeviceTransportType.COAP);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(-1L);

    ArrayList<DeviceProfileEntity> content = new ArrayList<>();
    content.add(deviceProfileEntity);
    PageImpl<DeviceProfileEntity> pageImpl = new PageImpl<>(content);
    when(
        deviceProfileRepository.findDeviceProfiles(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult = jpaDeviceProfileDao
        .findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceProfileRepository).findDeviceProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DeviceProfile> data = actualFindDeviceProfilesResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId2 = data.get(0).getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindDeviceProfiles_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(
        deviceProfileRepository.findDeviceProfiles(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult = jpaDeviceProfileDao
        .findDeviceProfiles(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceProfileRepository).findDeviceProfiles(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindDeviceProfilesResult.getTotalElements());
    assertEquals(1, actualFindDeviceProfilesResult.getTotalPages());
    assertFalse(actualFindDeviceProfilesResult.hasNext());
    assertTrue(actualFindDeviceProfilesResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceProfileDao#findDeviceProfileInfos(TenantId, PageLink, String)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#findDeviceProfileInfos(TenantId, PageLink, String)}
   */
  @Test
  public void testFindDeviceProfileInfos_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceProfileRepository.findDeviceProfileInfos(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getTextSearch()).thenReturn("Text Search");

    // Act
    PageData<DeviceProfileInfo> actualFindDeviceProfileInfosResult = jpaDeviceProfileDao
        .findDeviceProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink, "");

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceProfileRepository).findDeviceProfileInfos(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDeviceProfileInfosResult.getTotalElements());
    assertEquals(1, actualFindDeviceProfileInfosResult.getTotalPages());
    assertFalse(actualFindDeviceProfileInfosResult.hasNext());
    assertTrue(actualFindDeviceProfileInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDefaultDeviceProfileInfo(TenantId)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#findDefaultDeviceProfileInfo(TenantId)}
   */
  @Test
  public void testFindDefaultDeviceProfileInfo() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());
    when(deviceProfileRepository.findDefaultDeviceProfileInfo(Mockito.<UUID>any())).thenReturn(deviceProfileInfo);

    // Act
    DeviceProfileInfo actualFindDefaultDeviceProfileInfoResult = jpaDeviceProfileDao
        .findDefaultDeviceProfileInfo(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceProfileRepository).findDefaultDeviceProfileInfo(isA(UUID.class));
    assertSame(deviceProfileInfo, actualFindDefaultDeviceProfileInfoResult);
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByProvisionDeviceKey(String)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#findByProvisionDeviceKey(String)}
   */
  @Test
  public void testFindByProvisionDeviceKey() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(MissingNode.getInstance());
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(1L);
    when(deviceProfileRepository.findByProvisionDeviceKey(Mockito.<String>any())).thenReturn(deviceProfileEntity);

    // Act
    DeviceProfile actualFindByProvisionDeviceKeyResult = jpaDeviceProfileDao
        .findByProvisionDeviceKey("Provision Device Key");

    // Assert
    verify(deviceProfileRepository).findByProvisionDeviceKey(eq("Provision Device Key"));
    UUID uuidId = actualFindByProvisionDeviceKeyResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    TenantId tenantId = actualFindByProvisionDeviceKeyResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Default Queue Name", actualFindByProvisionDeviceKeyResult.getDefaultQueueName());
    assertEquals("Image", actualFindByProvisionDeviceKeyResult.getImage());
    assertEquals("Name", actualFindByProvisionDeviceKeyResult.getName());
    assertEquals("Provision Device Key", actualFindByProvisionDeviceKeyResult.getProvisionDeviceKey());
    assertEquals("The characteristics of someone or something", actualFindByProvisionDeviceKeyResult.getDescription());
    assertNull(actualFindByProvisionDeviceKeyResult.getProfileDataBytes());
    assertNull(actualFindByProvisionDeviceKeyResult.getProfileData());
    assertEquals(1L, actualFindByProvisionDeviceKeyResult.getVersion().longValue());
    assertEquals(1L, actualFindByProvisionDeviceKeyResult.getCreatedTime());
    assertEquals(DeviceProfileProvisionType.DISABLED, actualFindByProvisionDeviceKeyResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualFindByProvisionDeviceKeyResult.getType());
    assertEquals(DeviceTransportType.DEFAULT, actualFindByProvisionDeviceKeyResult.getTransportType());
    DashboardId defaultDashboardId = actualFindByProvisionDeviceKeyResult.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId.getEntityType());
    DeviceProfileId externalId = actualFindByProvisionDeviceKeyResult.getExternalId();
    assertEquals(EntityType.DEVICE_PROFILE, externalId.getEntityType());
    OtaPackageId firmwareId = actualFindByProvisionDeviceKeyResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    RuleChainId defaultEdgeRuleChainId = actualFindByProvisionDeviceKeyResult.getDefaultEdgeRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, defaultEdgeRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(actualFindByProvisionDeviceKeyResult.isDefault());
    assertTrue(defaultDashboardId.isNullUid());
    assertTrue(defaultEdgeRuleChainId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertEquals(defaultEdgeRuleChainId, actualFindByProvisionDeviceKeyResult.getDefaultRuleChainId());
    assertEquals(externalId, actualFindByProvisionDeviceKeyResult.getId());
    assertEquals(firmwareId, actualFindByProvisionDeviceKeyResult.getSoftwareId());
    assertSame(uuidId, defaultDashboardId.getId());
    assertSame(uuidId, defaultEdgeRuleChainId.getId());
    assertSame(uuidId, externalId.getId());
    assertSame(uuidId, firmwareId.getId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}.
   * <p>
   * Method under test: {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  public void testFindAllWithImages() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(-1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultQueueName("42");
    deviceProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDescription("com.fasterxml.jackson.databind.JsonNode");
    deviceProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setImage("42");
    deviceProfileEntity.setName("42");
    deviceProfileEntity.setProfileData(null);
    deviceProfileEntity.setProvisionDeviceKey("42");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.CHECK_PRE_PROVISIONED_DEVICES);
    deviceProfileEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTransportType(DeviceTransportType.COAP);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(-1L);

    ArrayList<DeviceProfileEntity> content = new ArrayList<>();
    content.add(deviceProfileEntity);
    PageImpl<DeviceProfileEntity> pageImpl = new PageImpl<>(content);
    when(deviceProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DeviceProfile> actualFindAllWithImagesResult = jpaDeviceProfileDao.findAllWithImages(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    List<DeviceProfile> data = actualFindAllWithImagesResult.getData();
    assertEquals(1, data.size());
    DeviceProfile getResult = data.get(0);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("42", getResult.getDefaultQueueName());
    assertEquals("42", getResult.getImage());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getProvisionDeviceKey());
    assertEquals("com.fasterxml.jackson.databind.JsonNode", getResult.getDescription());
    assertNull(getResult.getProfileDataBytes());
    assertNull(getResult.getProfileData());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAllWithImagesResult.getTotalElements());
    assertEquals(DeviceProfileProvisionType.CHECK_PRE_PROVISIONED_DEVICES, getResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, getResult.getType());
    assertEquals(DeviceTransportType.COAP, getResult.getTransportType());
    DashboardId defaultDashboardId = getResult.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId.getEntityType());
    DeviceProfileId externalId = getResult.getExternalId();
    assertEquals(EntityType.DEVICE_PROFILE, externalId.getEntityType());
    OtaPackageId firmwareId = getResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    RuleChainId defaultEdgeRuleChainId = getResult.getDefaultEdgeRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, defaultEdgeRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(getResult.isDefault());
    assertTrue(defaultDashboardId.isNullUid());
    assertTrue(defaultEdgeRuleChainId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertEquals(defaultEdgeRuleChainId, getResult.getDefaultRuleChainId());
    assertEquals(externalId, getResult.getId());
    assertEquals(firmwareId, getResult.getSoftwareId());
    assertSame(uuidId, defaultDashboardId.getId());
    assertSame(uuidId, defaultEdgeRuleChainId.getId());
    assertSame(uuidId, externalId.getId());
    assertSame(uuidId, firmwareId.getId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  public void testFindAllWithImages_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DeviceProfile> actualFindAllWithImagesResult = jpaDeviceProfileDao.findAllWithImages(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    assertEquals(0L, actualFindAllWithImagesResult.getTotalElements());
    assertEquals(1, actualFindAllWithImagesResult.getTotalPages());
    assertFalse(actualFindAllWithImagesResult.hasNext());
    assertTrue(actualFindAllWithImagesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}.
   * <ul>
   *   <li>Then return not Data first TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  public void testFindAllWithImages_thenReturnNotDataFirstTenantIdNullUid() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(-1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultQueueName("42");
    deviceProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDescription("com.fasterxml.jackson.databind.JsonNode");
    deviceProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setImage("42");
    deviceProfileEntity.setName("42");
    deviceProfileEntity.setProfileData(null);
    deviceProfileEntity.setProvisionDeviceKey("42");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.CHECK_PRE_PROVISIONED_DEVICES);
    deviceProfileEntity.setSoftwareId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    deviceProfileEntity.setTenantId(tenantId);
    deviceProfileEntity.setTransportType(DeviceTransportType.COAP);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(-1L);

    ArrayList<DeviceProfileEntity> content = new ArrayList<>();
    content.add(deviceProfileEntity);
    PageImpl<DeviceProfileEntity> pageImpl = new PageImpl<>(content);
    when(deviceProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DeviceProfile> actualFindAllWithImagesResult = jpaDeviceProfileDao.findAllWithImages(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    List<DeviceProfile> data = actualFindAllWithImagesResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId2 = data.get(0).getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  public void testFindAllWithImages_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DeviceProfile> actualFindAllWithImagesResult = jpaDeviceProfileDao
        .findAllWithImages(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    assertEquals(0L, actualFindAllWithImagesResult.getTotalElements());
    assertEquals(1, actualFindAllWithImagesResult.getTotalPages());
    assertFalse(actualFindAllWithImagesResult.hasNext());
    assertTrue(actualFindAllWithImagesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findTenantDeviceProfileNames(UUID, boolean)}.
   * <ul>
   *   <li>Then calls
   * {@link DeviceProfileRepository#findActiveTenantDeviceProfileNames(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#findTenantDeviceProfileNames(UUID, boolean)}
   */
  @Test
  public void testFindTenantDeviceProfileNames_thenCallsFindActiveTenantDeviceProfileNames() {
    // Arrange
    when(deviceProfileRepository.findActiveTenantDeviceProfileNames(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityInfo> actualFindTenantDeviceProfileNamesResult = jpaDeviceProfileDao
        .findTenantDeviceProfileNames(ModelConstants.NULL_UUID, true);

    // Assert
    verify(deviceProfileRepository).findActiveTenantDeviceProfileNames(isA(UUID.class));
    assertTrue(actualFindTenantDeviceProfileNamesResult.isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findTenantDeviceProfileNames(UUID, boolean)}.
   * <ul>
   *   <li>Then calls
   * {@link DeviceProfileRepository#findAllTenantDeviceProfileNames(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#findTenantDeviceProfileNames(UUID, boolean)}
   */
  @Test
  public void testFindTenantDeviceProfileNames_thenCallsFindAllTenantDeviceProfileNames() {
    // Arrange
    when(deviceProfileRepository.findAllTenantDeviceProfileNames(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityInfo> actualFindTenantDeviceProfileNamesResult = jpaDeviceProfileDao
        .findTenantDeviceProfileNames(ModelConstants.NULL_UUID, false);

    // Assert
    verify(deviceProfileRepository).findAllTenantDeviceProfileNames(isA(UUID.class));
    assertTrue(actualFindTenantDeviceProfileNamesResult.isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(MissingNode.getInstance());
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(1L);
    when(deviceProfileRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfileEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    DeviceProfile actualFindByTenantIdAndExternalIdResult = jpaDeviceProfileDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(deviceProfileRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Default Queue Name", actualFindByTenantIdAndExternalIdResult.getDefaultQueueName());
    assertEquals("Image", actualFindByTenantIdAndExternalIdResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals("Provision Device Key", actualFindByTenantIdAndExternalIdResult.getProvisionDeviceKey());
    assertEquals("The characteristics of someone or something",
        actualFindByTenantIdAndExternalIdResult.getDescription());
    assertNull(actualFindByTenantIdAndExternalIdResult.getProfileDataBytes());
    assertNull(actualFindByTenantIdAndExternalIdResult.getProfileData());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertEquals(DeviceProfileProvisionType.DISABLED, actualFindByTenantIdAndExternalIdResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualFindByTenantIdAndExternalIdResult.getType());
    assertEquals(DeviceTransportType.DEFAULT, actualFindByTenantIdAndExternalIdResult.getTransportType());
    DashboardId defaultDashboardId = actualFindByTenantIdAndExternalIdResult.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId.getEntityType());
    DeviceProfileId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.DEVICE_PROFILE, externalId2.getEntityType());
    OtaPackageId firmwareId = actualFindByTenantIdAndExternalIdResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    RuleChainId defaultEdgeRuleChainId = actualFindByTenantIdAndExternalIdResult.getDefaultEdgeRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, defaultEdgeRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isDefault());
    assertTrue(defaultDashboardId.isNullUid());
    assertTrue(defaultEdgeRuleChainId.isNullUid());
    assertTrue(externalId2.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertEquals(defaultEdgeRuleChainId, actualFindByTenantIdAndExternalIdResult.getDefaultRuleChainId());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertEquals(firmwareId, actualFindByTenantIdAndExternalIdResult.getSoftwareId());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
    assertSame(externalId, defaultDashboardId.getId());
    assertSame(externalId, defaultEdgeRuleChainId.getId());
    assertSame(externalId, externalId2.getId());
    assertSame(externalId, firmwareId.getId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantIdAndName(UUID, String)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndName() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(MissingNode.getInstance());
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(1L);
    when(deviceProfileRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(deviceProfileEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    DeviceProfile actualFindByTenantIdAndNameResult = jpaDeviceProfileDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(deviceProfileRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    TenantId tenantId2 = actualFindByTenantIdAndNameResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Default Queue Name", actualFindByTenantIdAndNameResult.getDefaultQueueName());
    assertEquals("Image", actualFindByTenantIdAndNameResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndNameResult.getName());
    assertEquals("Provision Device Key", actualFindByTenantIdAndNameResult.getProvisionDeviceKey());
    assertEquals("The characteristics of someone or something", actualFindByTenantIdAndNameResult.getDescription());
    assertNull(actualFindByTenantIdAndNameResult.getProfileDataBytes());
    assertNull(actualFindByTenantIdAndNameResult.getProfileData());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertEquals(DeviceProfileProvisionType.DISABLED, actualFindByTenantIdAndNameResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualFindByTenantIdAndNameResult.getType());
    assertEquals(DeviceTransportType.DEFAULT, actualFindByTenantIdAndNameResult.getTransportType());
    DashboardId defaultDashboardId = actualFindByTenantIdAndNameResult.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId.getEntityType());
    DeviceProfileId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.DEVICE_PROFILE, externalId.getEntityType());
    OtaPackageId firmwareId = actualFindByTenantIdAndNameResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    RuleChainId defaultEdgeRuleChainId = actualFindByTenantIdAndNameResult.getDefaultEdgeRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, defaultEdgeRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(actualFindByTenantIdAndNameResult.isDefault());
    assertTrue(defaultDashboardId.isNullUid());
    assertTrue(defaultEdgeRuleChainId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertEquals(defaultEdgeRuleChainId, actualFindByTenantIdAndNameResult.getDefaultRuleChainId());
    assertEquals(externalId, actualFindByTenantIdAndNameResult.getId());
    assertEquals(firmwareId, actualFindByTenantIdAndNameResult.getSoftwareId());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
    assertSame(tenantId, defaultDashboardId.getId());
    assertSame(tenantId, defaultEdgeRuleChainId.getId());
    assertSame(tenantId, externalId.getId());
    assertSame(tenantId, firmwareId.getId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then {@link ModelConstants#NULL_UUID} toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenNull_uuidToStringIs138140001dd211b28080808080808080() {
    // Arrange
    when(
        deviceProfileRepository.findDeviceProfiles(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<DeviceProfile> actualFindByTenantIdResult = jpaDeviceProfileDao.findByTenantId(tenantId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceProfileRepository).findDeviceProfiles(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.toString());
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then {@link ModelConstants#NULL_UUID} toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenNull_uuidToStringIs138140001dd211b280808080808080802() {
    // Arrange
    when(
        deviceProfileRepository.findDeviceProfiles(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DeviceProfile> actualFindByTenantIdResult = jpaDeviceProfileDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceProfileRepository).findDeviceProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.toString());
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(-1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultQueueName("42");
    deviceProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDescription("com.fasterxml.jackson.databind.JsonNode");
    deviceProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setImage("42");
    deviceProfileEntity.setName("42");
    deviceProfileEntity.setProfileData(null);
    deviceProfileEntity.setProvisionDeviceKey("42");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.CHECK_PRE_PROVISIONED_DEVICES);
    deviceProfileEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTransportType(DeviceTransportType.COAP);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(-1L);

    ArrayList<DeviceProfileEntity> content = new ArrayList<>();
    content.add(deviceProfileEntity);
    PageImpl<DeviceProfileEntity> pageImpl = new PageImpl<>(content);
    when(
        deviceProfileRepository.findDeviceProfiles(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DeviceProfile> actualFindByTenantIdResult = jpaDeviceProfileDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceProfileRepository).findDeviceProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DeviceProfile> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    DeviceProfile getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("42", getResult.getDefaultQueueName());
    assertEquals("42", getResult.getImage());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getProvisionDeviceKey());
    assertEquals("com.fasterxml.jackson.databind.JsonNode", getResult.getDescription());
    assertNull(getResult.getProfileDataBytes());
    assertNull(getResult.getProfileData());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(DeviceProfileProvisionType.CHECK_PRE_PROVISIONED_DEVICES, getResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, getResult.getType());
    assertEquals(DeviceTransportType.COAP, getResult.getTransportType());
    DashboardId defaultDashboardId = getResult.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId.getEntityType());
    DeviceProfileId externalId = getResult.getExternalId();
    assertEquals(EntityType.DEVICE_PROFILE, externalId.getEntityType());
    OtaPackageId firmwareId = getResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    RuleChainId defaultEdgeRuleChainId = getResult.getDefaultEdgeRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, defaultEdgeRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(getResult.isDefault());
    assertTrue(defaultDashboardId.isNullUid());
    assertTrue(defaultEdgeRuleChainId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertEquals(defaultEdgeRuleChainId, getResult.getDefaultRuleChainId());
    assertEquals(externalId, getResult.getId());
    assertEquals(firmwareId, getResult.getSoftwareId());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, defaultDashboardId.getId());
    assertSame(tenantId, defaultEdgeRuleChainId.getId());
    assertSame(tenantId, externalId.getId());
    assertSame(tenantId, firmwareId.getId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When randomUUID.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenRandomUUID_thenReturnTotalElementsIsZero() {
    // Arrange
    when(
        deviceProfileRepository.findDeviceProfiles(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DeviceProfile> actualFindByTenantIdResult = jpaDeviceProfileDao.findByTenantId(UUID.randomUUID(),
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceProfileRepository).findDeviceProfiles(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#getExternalIdByInternal(DeviceProfileId)}
   * with {@code DeviceProfileId}.
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#getExternalIdByInternal(DeviceProfileId)}
   */
  @Test
  public void testGetExternalIdByInternalWithDeviceProfileId() {
    // Arrange
    when(deviceProfileRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    DeviceProfileId internalId = new DeviceProfileId(ModelConstants.NULL_UUID);

    // Act
    DeviceProfileId actualExternalIdByInternal = jpaDeviceProfileDao.getExternalIdByInternal(internalId);

    // Assert
    verify(deviceProfileRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaDeviceProfileDao#getExternalIdByInternal(DeviceProfileId)}
   * with {@code DeviceProfileId}.
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#getExternalIdByInternal(DeviceProfileId)}
   */
  @Test
  public void testGetExternalIdByInternalWithDeviceProfileId2() {
    // Arrange
    when(deviceProfileRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    DeviceProfileId internalId = mock(DeviceProfileId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DeviceProfileId actualExternalIdByInternal = jpaDeviceProfileDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(deviceProfileRepository).getExternalIdById(isA(UUID.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaDeviceProfileDao#getExternalIdByInternal(DeviceProfileId)}
   * with {@code DeviceProfileId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#getExternalIdByInternal(DeviceProfileId)}
   */
  @Test
  public void testGetExternalIdByInternalWithDeviceProfileId_thenReturnNull() {
    // Arrange
    when(deviceProfileRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    DeviceProfileId actualExternalIdByInternal = jpaDeviceProfileDao
        .getExternalIdByInternal(new DeviceProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(deviceProfileRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDefaultEntityByTenantId(UUID)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#findDefaultEntityByTenantId(UUID)}
   */
  @Test
  public void testFindDefaultEntityByTenantId() {
    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(MissingNode.getInstance());
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(1L);
    when(deviceProfileRepository.findByDefaultTrueAndTenantId(Mockito.<UUID>any())).thenReturn(deviceProfileEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    DeviceProfile actualFindDefaultEntityByTenantIdResult = jpaDeviceProfileDao.findDefaultEntityByTenantId(tenantId);

    // Assert
    verify(deviceProfileRepository).findByDefaultTrueAndTenantId(isA(UUID.class));
    TenantId tenantId2 = actualFindDefaultEntityByTenantIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Default Queue Name", actualFindDefaultEntityByTenantIdResult.getDefaultQueueName());
    assertEquals("Image", actualFindDefaultEntityByTenantIdResult.getImage());
    assertEquals("Name", actualFindDefaultEntityByTenantIdResult.getName());
    assertEquals("Provision Device Key", actualFindDefaultEntityByTenantIdResult.getProvisionDeviceKey());
    assertEquals("The characteristics of someone or something",
        actualFindDefaultEntityByTenantIdResult.getDescription());
    assertNull(actualFindDefaultEntityByTenantIdResult.getProfileDataBytes());
    assertNull(actualFindDefaultEntityByTenantIdResult.getProfileData());
    assertEquals(1L, actualFindDefaultEntityByTenantIdResult.getVersion().longValue());
    assertEquals(1L, actualFindDefaultEntityByTenantIdResult.getCreatedTime());
    assertEquals(DeviceProfileProvisionType.DISABLED, actualFindDefaultEntityByTenantIdResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualFindDefaultEntityByTenantIdResult.getType());
    assertEquals(DeviceTransportType.DEFAULT, actualFindDefaultEntityByTenantIdResult.getTransportType());
    DashboardId defaultDashboardId = actualFindDefaultEntityByTenantIdResult.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId.getEntityType());
    DeviceProfileId externalId = actualFindDefaultEntityByTenantIdResult.getExternalId();
    assertEquals(EntityType.DEVICE_PROFILE, externalId.getEntityType());
    OtaPackageId firmwareId = actualFindDefaultEntityByTenantIdResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    RuleChainId defaultEdgeRuleChainId = actualFindDefaultEntityByTenantIdResult.getDefaultEdgeRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, defaultEdgeRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(actualFindDefaultEntityByTenantIdResult.isDefault());
    assertTrue(defaultDashboardId.isNullUid());
    assertTrue(defaultEdgeRuleChainId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertEquals(defaultEdgeRuleChainId, actualFindDefaultEntityByTenantIdResult.getDefaultRuleChainId());
    assertEquals(externalId, actualFindDefaultEntityByTenantIdResult.getId());
    assertEquals(firmwareId, actualFindDefaultEntityByTenantIdResult.getSoftwareId());
    assertSame(tenantId, actualFindDefaultEntityByTenantIdResult.getUuidId());
    assertSame(tenantId, defaultDashboardId.getId());
    assertSame(tenantId, defaultEdgeRuleChainId.getId());
    assertSame(tenantId, externalId.getId());
    assertSame(tenantId, firmwareId.getId());
  }

  /**
   * Test
   * {@link JpaDeviceProfileDao#findByTenantAndImageLink(TenantId, String, int)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceProfileDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  public void testFindByTenantAndImageLink_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(deviceProfileRepository.findByTenantAndImageLink(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new ArrayList<>());

    // Act
    List<DeviceProfileInfo> actualFindByTenantAndImageLinkResult = jpaDeviceProfileDao
        .findByTenantAndImageLink(ModelConstants.SYSTEM_TENANT, "Image Link", 1);

    // Assert
    verify(deviceProfileRepository).findByTenantAndImageLink(isA(UUID.class), eq("Image Link"), isA(Pageable.class));
    assertTrue(actualFindByTenantAndImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByImageLink(String, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceProfileDao#findByImageLink(String, int)}
   */
  @Test
  public void testFindByImageLink_whenOne_thenReturnEmpty() {
    // Arrange
    when(deviceProfileRepository.findByImageLink(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<DeviceProfileInfo> actualFindByImageLinkResult = jpaDeviceProfileDao.findByImageLink("Image Link", 1);

    // Assert
    verify(deviceProfileRepository).findByImageLink(eq("Image Link"), isA(Pageable.class));
    assertTrue(actualFindByImageLinkResult.isEmpty());
  }
}
