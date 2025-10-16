/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.MissingNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaDeviceProfileDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private DeviceProfileRepository deviceProfileRepository;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaDeviceProfileDao jpaDeviceProfileDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaDeviceProfileDao#getEntityClass()}
   *   <li>{@link JpaDeviceProfileDao#getEntityType()}
   *   <li>{@link JpaDeviceProfileDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaDeviceProfileDao.getEntityClass()",
    "EntityType JpaDeviceProfileDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaDeviceProfileDao.getRepository()"
  })
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
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findDeviceProfileInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfileInfo JpaDeviceProfileDao.findDeviceProfileInfoById(TenantId, UUID)"
  })
  public void testFindDeviceProfileInfoById() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());
    when(deviceProfileRepository.findDeviceProfileInfoById(Mockito.<UUID>any()))
        .thenReturn(deviceProfileInfo);

    // Act
    DeviceProfileInfo actualFindDeviceProfileInfoByIdResult =
        jpaDeviceProfileDao.findDeviceProfileInfoById(
            ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(deviceProfileRepository).findDeviceProfileInfoById(isA(UUID.class));
    assertSame(deviceProfileInfo, actualFindDeviceProfileInfoByIdResult);
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceProfileDao.findDeviceProfiles(TenantId, PageLink)"})
  public void testFindDeviceProfiles_givenNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceProfileRepository.findDeviceProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult =
        jpaDeviceProfileDao.findDeviceProfiles(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceProfileRepository)
        .findDeviceProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDeviceProfilesResult.getTotalElements());
    assertEquals(1, actualFindDeviceProfilesResult.getTotalPages());
    assertFalse(actualFindDeviceProfilesResult.hasNext());
    assertTrue(actualFindDeviceProfilesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceProfileDao.findDeviceProfiles(TenantId, PageLink)"})
  public void testFindDeviceProfiles_givenOne_whenSystem_tenant_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceProfileRepository.findDeviceProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult =
        jpaDeviceProfileDao.findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceProfileRepository)
        .findDeviceProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDeviceProfilesResult.getTotalElements());
    assertEquals(1, actualFindDeviceProfilesResult.getTotalPages());
    assertFalse(actualFindDeviceProfilesResult.hasNext());
    assertTrue(actualFindDeviceProfilesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first DefaultQueueName is {@code Default Queue Name}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceProfileDao.findDeviceProfiles(TenantId, PageLink)"})
  public void testFindDeviceProfiles_thenReturnDataFirstDefaultQueueNameIsDefaultQueueName() {
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
    deviceProfileEntity.setTenantId(UUID.randomUUID());
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(1L);

    ArrayList<DeviceProfileEntity> content = new ArrayList<>();
    content.add(deviceProfileEntity);
    when(deviceProfileRepository.findDeviceProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult =
        jpaDeviceProfileDao.findDeviceProfiles(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceProfileRepository)
        .findDeviceProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DeviceProfile> data = actualFindDeviceProfilesResult.getData();
    assertEquals(1, data.size());
    DeviceProfile getResult = data.get(0);
    assertEquals("Default Queue Name", getResult.getDefaultQueueName());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("Provision Device Key", getResult.getProvisionDeviceKey());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertNull(getResult.getProfileDataBytes());
    assertNull(getResult.getProfileData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDeviceProfilesResult.getTotalElements());
    assertEquals(DeviceProfileProvisionType.DISABLED, getResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, getResult.getType());
    assertEquals(DeviceTransportType.DEFAULT, getResult.getTransportType());
    assertTrue(getResult.isDefault());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceProfileDao.findDeviceProfiles(TenantId, PageLink)"})
  public void testFindDeviceProfiles_thenReturnDataFirstTenantIdIsSys_tenant_id() {
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

    ArrayList<DeviceProfileEntity> content = new ArrayList<>();
    content.add(deviceProfileEntity);
    when(deviceProfileRepository.findDeviceProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult =
        jpaDeviceProfileDao.findDeviceProfiles(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceProfileRepository)
        .findDeviceProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DeviceProfile> data = actualFindDeviceProfilesResult.getData();
    assertEquals(1, data.size());
    assertSame(TenantId.SYS_TENANT_ID, data.get(0).getTenantId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceProfileDao.findDeviceProfiles(TenantId, PageLink)"})
  public void testFindDeviceProfiles_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceProfileRepository.findDeviceProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult =
        jpaDeviceProfileDao.findDeviceProfiles(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceProfileRepository)
        .findDeviceProfiles(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindDeviceProfilesResult.getTotalElements());
    assertEquals(1, actualFindDeviceProfilesResult.getTotalPages());
    assertFalse(actualFindDeviceProfilesResult.hasNext());
    assertTrue(actualFindDeviceProfilesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findDeviceProfileInfos(TenantId, PageLink,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceProfileDao.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  public void testFindDeviceProfileInfos_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceProfileRepository.findDeviceProfileInfos(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getTextSearch()).thenReturn("Text Search");

    // Act
    PageData<DeviceProfileInfo> actualFindDeviceProfileInfosResult =
        jpaDeviceProfileDao.findDeviceProfileInfos(tenantId, pageLink, "");

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceProfileRepository)
        .findDeviceProfileInfos(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDeviceProfileInfosResult.getTotalElements());
    assertEquals(1, actualFindDeviceProfileInfosResult.getTotalPages());
    assertFalse(actualFindDeviceProfileInfosResult.hasNext());
    assertTrue(actualFindDeviceProfileInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDefaultDeviceProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findDefaultDeviceProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile JpaDeviceProfileDao.findDefaultDeviceProfile(TenantId)"})
  public void testFindDefaultDeviceProfile_thenReturnNotTenantIdNullUid() {
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
    UUID tenantId = UUID.randomUUID();
    deviceProfileEntity.setTenantId(tenantId);
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(1L);
    when(deviceProfileRepository.findByDefaultTrueAndTenantId(Mockito.<UUID>any()))
        .thenReturn(deviceProfileEntity);

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DeviceProfile actualFindDefaultDeviceProfileResult =
        jpaDeviceProfileDao.findDefaultDeviceProfile(tenantId2);

    // Assert
    verify(tenantId2).getId();
    verify(deviceProfileRepository).findByDefaultTrueAndTenantId(isA(UUID.class));
    TenantId tenantId3 = actualFindDefaultDeviceProfileResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    RuleChainId expectedDefaultRuleChainId =
        actualFindDefaultDeviceProfileResult.getDefaultEdgeRuleChainId();
    assertEquals(
        expectedDefaultRuleChainId, actualFindDefaultDeviceProfileResult.getDefaultRuleChainId());
    DeviceProfileId expectedId = actualFindDefaultDeviceProfileResult.getExternalId();
    assertEquals(expectedId, actualFindDefaultDeviceProfileResult.getId());
    OtaPackageId expectedSoftwareId = actualFindDefaultDeviceProfileResult.getFirmwareId();
    assertEquals(expectedSoftwareId, actualFindDefaultDeviceProfileResult.getSoftwareId());
    assertSame(tenantId, tenantId3.getId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDefaultDeviceProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then return TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findDefaultDeviceProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile JpaDeviceProfileDao.findDefaultDeviceProfile(TenantId)"})
  public void testFindDefaultDeviceProfile_thenReturnTenantIdIsSys_tenant_id() {
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
    when(deviceProfileRepository.findByDefaultTrueAndTenantId(Mockito.<UUID>any()))
        .thenReturn(deviceProfileEntity);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DeviceProfile actualFindDefaultDeviceProfileResult =
        jpaDeviceProfileDao.findDefaultDeviceProfile(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(deviceProfileRepository).findByDefaultTrueAndTenantId(isA(UUID.class));
    assertSame(TenantId.SYS_TENANT_ID, actualFindDefaultDeviceProfileResult.getTenantId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDefaultDeviceProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then return TenantId is {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findDefaultDeviceProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile JpaDeviceProfileDao.findDefaultDeviceProfile(TenantId)"})
  public void testFindDefaultDeviceProfile_thenReturnTenantIdIsSystem_tenant() {
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
    when(deviceProfileRepository.findByDefaultTrueAndTenantId(Mockito.<UUID>any()))
        .thenReturn(deviceProfileEntity);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    DeviceProfile actualFindDefaultDeviceProfileResult =
        jpaDeviceProfileDao.findDefaultDeviceProfile(tenantId);

    // Assert
    verify(deviceProfileRepository).findByDefaultTrueAndTenantId(isA(UUID.class));
    RuleChainId expectedDefaultRuleChainId =
        actualFindDefaultDeviceProfileResult.getDefaultEdgeRuleChainId();
    assertEquals(
        expectedDefaultRuleChainId, actualFindDefaultDeviceProfileResult.getDefaultRuleChainId());
    DeviceProfileId expectedId = actualFindDefaultDeviceProfileResult.getExternalId();
    assertEquals(expectedId, actualFindDefaultDeviceProfileResult.getId());
    OtaPackageId expectedSoftwareId = actualFindDefaultDeviceProfileResult.getFirmwareId();
    assertEquals(expectedSoftwareId, actualFindDefaultDeviceProfileResult.getSoftwareId());
    assertSame(tenantId, actualFindDefaultDeviceProfileResult.getTenantId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDefaultDeviceProfileInfo(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findDefaultDeviceProfileInfo(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfileInfo JpaDeviceProfileDao.findDefaultDeviceProfileInfo(TenantId)"
  })
  public void testFindDefaultDeviceProfileInfo_givenNull_uuid_thenCallsGetId() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());
    when(deviceProfileRepository.findDefaultDeviceProfileInfo(Mockito.<UUID>any()))
        .thenReturn(deviceProfileInfo);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DeviceProfileInfo actualFindDefaultDeviceProfileInfoResult =
        jpaDeviceProfileDao.findDefaultDeviceProfileInfo(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(deviceProfileRepository).findDefaultDeviceProfileInfo(isA(UUID.class));
    assertSame(deviceProfileInfo, actualFindDefaultDeviceProfileInfoResult);
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDefaultDeviceProfileInfo(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findDefaultDeviceProfileInfo(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfileInfo JpaDeviceProfileDao.findDefaultDeviceProfileInfo(TenantId)"
  })
  public void testFindDefaultDeviceProfileInfo_whenSystem_tenant() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());
    when(deviceProfileRepository.findDefaultDeviceProfileInfo(Mockito.<UUID>any()))
        .thenReturn(deviceProfileInfo);

    // Act
    DeviceProfileInfo actualFindDefaultDeviceProfileInfoResult =
        jpaDeviceProfileDao.findDefaultDeviceProfileInfo(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceProfileRepository).findDefaultDeviceProfileInfo(isA(UUID.class));
    assertSame(deviceProfileInfo, actualFindDefaultDeviceProfileInfoResult);
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByProvisionDeviceKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code Default Queue Name}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByProvisionDeviceKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile JpaDeviceProfileDao.findByProvisionDeviceKey(String)"})
  public void testFindByProvisionDeviceKey_thenReturnDefaultQueueName() {
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
    when(deviceProfileRepository.findByProvisionDeviceKey(Mockito.<String>any()))
        .thenReturn(deviceProfileEntity);

    // Act
    DeviceProfile actualFindByProvisionDeviceKeyResult =
        jpaDeviceProfileDao.findByProvisionDeviceKey("Provision Device Key");

    // Assert
    verify(deviceProfileRepository).findByProvisionDeviceKey("Provision Device Key");
    assertEquals("Default Queue Name", actualFindByProvisionDeviceKeyResult.getDefaultQueueName());
    assertEquals("Image", actualFindByProvisionDeviceKeyResult.getImage());
    assertEquals("Name", actualFindByProvisionDeviceKeyResult.getName());
    assertEquals(
        "Provision Device Key", actualFindByProvisionDeviceKeyResult.getProvisionDeviceKey());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByProvisionDeviceKeyResult.getDescription());
    assertNull(actualFindByProvisionDeviceKeyResult.getProfileDataBytes());
    assertNull(actualFindByProvisionDeviceKeyResult.getProfileData());
    assertEquals(1L, actualFindByProvisionDeviceKeyResult.getVersion().longValue());
    assertEquals(1L, actualFindByProvisionDeviceKeyResult.getCreatedTime());
    assertEquals(
        DeviceProfileProvisionType.DISABLED,
        actualFindByProvisionDeviceKeyResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualFindByProvisionDeviceKeyResult.getType());
    assertEquals(
        DeviceTransportType.DEFAULT, actualFindByProvisionDeviceKeyResult.getTransportType());
    assertTrue(actualFindByProvisionDeviceKeyResult.isDefault());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByProvisionDeviceKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code Default Queue Name}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByProvisionDeviceKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile JpaDeviceProfileDao.findByProvisionDeviceKey(String)"})
  public void testFindByProvisionDeviceKey_thenReturnDefaultQueueName2() {
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
    deviceProfileEntity.setTenantId(UUID.randomUUID());
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(1L);
    when(deviceProfileRepository.findByProvisionDeviceKey(Mockito.<String>any()))
        .thenReturn(deviceProfileEntity);

    // Act
    DeviceProfile actualFindByProvisionDeviceKeyResult =
        jpaDeviceProfileDao.findByProvisionDeviceKey("Provision Device Key");

    // Assert
    verify(deviceProfileRepository).findByProvisionDeviceKey("Provision Device Key");
    assertEquals("Default Queue Name", actualFindByProvisionDeviceKeyResult.getDefaultQueueName());
    assertEquals("Image", actualFindByProvisionDeviceKeyResult.getImage());
    assertEquals("Name", actualFindByProvisionDeviceKeyResult.getName());
    assertEquals(
        "Provision Device Key", actualFindByProvisionDeviceKeyResult.getProvisionDeviceKey());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByProvisionDeviceKeyResult.getDescription());
    assertNull(actualFindByProvisionDeviceKeyResult.getProfileDataBytes());
    assertNull(actualFindByProvisionDeviceKeyResult.getProfileData());
    assertEquals(1L, actualFindByProvisionDeviceKeyResult.getVersion().longValue());
    assertEquals(1L, actualFindByProvisionDeviceKeyResult.getCreatedTime());
    assertEquals(
        DeviceProfileProvisionType.DISABLED,
        actualFindByProvisionDeviceKeyResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualFindByProvisionDeviceKeyResult.getType());
    assertEquals(
        DeviceTransportType.DEFAULT, actualFindByProvisionDeviceKeyResult.getTransportType());
    assertTrue(actualFindByProvisionDeviceKeyResult.isDefault());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByName(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileEntity#DeviceProfileEntity()} ProfileData is Instance.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile JpaDeviceProfileDao.findByName(TenantId, String)"})
  public void testFindByName_givenDeviceProfileEntityProfileDataIsInstance_thenCallsGetId() {
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DeviceProfile actualFindByNameResult = jpaDeviceProfileDao.findByName(tenantId, "foo.txt");

    // Assert
    verify(tenantId).getId();
    verify(deviceProfileRepository).findByTenantIdAndName(isA(UUID.class), eq("foo.txt"));
    RuleChainId expectedDefaultRuleChainId = actualFindByNameResult.getDefaultEdgeRuleChainId();
    assertEquals(expectedDefaultRuleChainId, actualFindByNameResult.getDefaultRuleChainId());
    DeviceProfileId expectedId = actualFindByNameResult.getExternalId();
    assertEquals(expectedId, actualFindByNameResult.getId());
    OtaPackageId expectedSoftwareId = actualFindByNameResult.getFirmwareId();
    assertEquals(expectedSoftwareId, actualFindByNameResult.getSoftwareId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByName(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return TenantId is {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile JpaDeviceProfileDao.findByName(TenantId, String)"})
  public void testFindByName_thenReturnTenantIdIsSystem_tenant() {
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
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    DeviceProfile actualFindByNameResult = jpaDeviceProfileDao.findByName(tenantId, "foo.txt");

    // Assert
    verify(deviceProfileRepository).findByTenantIdAndName(isA(UUID.class), eq("foo.txt"));
    RuleChainId expectedDefaultRuleChainId = actualFindByNameResult.getDefaultEdgeRuleChainId();
    assertEquals(expectedDefaultRuleChainId, actualFindByNameResult.getDefaultRuleChainId());
    DeviceProfileId expectedId = actualFindByNameResult.getExternalId();
    assertEquals(expectedId, actualFindByNameResult.getId());
    OtaPackageId expectedSoftwareId = actualFindByNameResult.getFirmwareId();
    assertEquals(expectedSoftwareId, actualFindByNameResult.getSoftwareId());
    assertSame(tenantId, actualFindByNameResult.getTenantId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceProfileDao.findAllWithImages(PageLink)"})
  public void testFindAllWithImages_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceProfile> actualFindAllWithImagesResult =
        jpaDeviceProfileDao.findAllWithImages(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    assertEquals(0L, actualFindAllWithImagesResult.getTotalElements());
    assertEquals(1, actualFindAllWithImagesResult.getTotalPages());
    assertFalse(actualFindAllWithImagesResult.hasNext());
    assertTrue(actualFindAllWithImagesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceProfileDao.findAllWithImages(PageLink)"})
  public void testFindAllWithImages_thenReturnDataSizeIsOne() {
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

    ArrayList<DeviceProfileEntity> content = new ArrayList<>();
    content.add(deviceProfileEntity);
    when(deviceProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceProfile> actualFindAllWithImagesResult =
        jpaDeviceProfileDao.findAllWithImages(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    List<DeviceProfile> data = actualFindAllWithImagesResult.getData();
    assertEquals(1, data.size());
    DeviceProfile getResult = data.get(0);
    assertEquals("Default Queue Name", getResult.getDefaultQueueName());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("Provision Device Key", getResult.getProvisionDeviceKey());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertNull(getResult.getProfileDataBytes());
    assertNull(getResult.getProfileData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAllWithImagesResult.getTotalElements());
    assertEquals(DeviceProfileProvisionType.DISABLED, getResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, getResult.getType());
    assertEquals(DeviceTransportType.DEFAULT, getResult.getTransportType());
    assertTrue(getResult.isDefault());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceProfileDao.findAllWithImages(PageLink)"})
  public void testFindAllWithImages_thenReturnDataSizeIsOne2() {
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
    deviceProfileEntity.setTenantId(UUID.randomUUID());
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(1L);

    ArrayList<DeviceProfileEntity> content = new ArrayList<>();
    content.add(deviceProfileEntity);
    when(deviceProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceProfile> actualFindAllWithImagesResult =
        jpaDeviceProfileDao.findAllWithImages(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    List<DeviceProfile> data = actualFindAllWithImagesResult.getData();
    assertEquals(1, data.size());
    DeviceProfile getResult = data.get(0);
    assertEquals("Default Queue Name", getResult.getDefaultQueueName());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("Provision Device Key", getResult.getProvisionDeviceKey());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertNull(getResult.getProfileDataBytes());
    assertNull(getResult.getProfileData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAllWithImagesResult.getTotalElements());
    assertEquals(DeviceProfileProvisionType.DISABLED, getResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, getResult.getType());
    assertEquals(DeviceTransportType.DEFAULT, getResult.getTransportType());
    assertTrue(getResult.isDefault());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceProfileDao.findAllWithImages(PageLink)"})
  public void testFindAllWithImages_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DeviceProfile> actualFindAllWithImagesResult =
        jpaDeviceProfileDao.findAllWithImages(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    assertEquals(0L, actualFindAllWithImagesResult.getTotalElements());
    assertEquals(1, actualFindAllWithImagesResult.getTotalPages());
    assertFalse(actualFindAllWithImagesResult.hasNext());
    assertTrue(actualFindAllWithImagesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findTenantDeviceProfileNames(UUID, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfileRepository#findActiveTenantDeviceProfileNames(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findTenantDeviceProfileNames(UUID, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDeviceProfileDao.findTenantDeviceProfileNames(UUID, boolean)"})
  public void testFindTenantDeviceProfileNames_thenCallsFindActiveTenantDeviceProfileNames() {
    // Arrange
    when(deviceProfileRepository.findActiveTenantDeviceProfileNames(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityInfo> actualFindTenantDeviceProfileNamesResult =
        jpaDeviceProfileDao.findTenantDeviceProfileNames(ModelConstants.NULL_UUID, true);

    // Assert
    verify(deviceProfileRepository).findActiveTenantDeviceProfileNames(isA(UUID.class));
    assertTrue(actualFindTenantDeviceProfileNamesResult.isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findTenantDeviceProfileNames(UUID, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfileRepository#findAllTenantDeviceProfileNames(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findTenantDeviceProfileNames(UUID, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDeviceProfileDao.findTenantDeviceProfileNames(UUID, boolean)"})
  public void testFindTenantDeviceProfileNames_thenCallsFindAllTenantDeviceProfileNames() {
    // Arrange
    when(deviceProfileRepository.findAllTenantDeviceProfileNames(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityInfo> actualFindTenantDeviceProfileNamesResult =
        jpaDeviceProfileDao.findTenantDeviceProfileNames(ModelConstants.NULL_UUID, false);

    // Assert
    verify(deviceProfileRepository).findAllTenantDeviceProfileNames(isA(UUID.class));
    assertTrue(actualFindTenantDeviceProfileNamesResult.isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return {@code Default Queue Name}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile JpaDeviceProfileDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_thenReturnDefaultQueueName() {
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
    when(deviceProfileRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfileEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    DeviceProfile actualFindByTenantIdAndExternalIdResult =
        jpaDeviceProfileDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(deviceProfileRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertEquals(
        "Default Queue Name", actualFindByTenantIdAndExternalIdResult.getDefaultQueueName());
    assertEquals("Image", actualFindByTenantIdAndExternalIdResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals(
        "Provision Device Key", actualFindByTenantIdAndExternalIdResult.getProvisionDeviceKey());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByTenantIdAndExternalIdResult.getDescription());
    assertNull(actualFindByTenantIdAndExternalIdResult.getProfileDataBytes());
    assertNull(actualFindByTenantIdAndExternalIdResult.getProfileData());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertEquals(
        DeviceProfileProvisionType.DISABLED,
        actualFindByTenantIdAndExternalIdResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualFindByTenantIdAndExternalIdResult.getType());
    assertEquals(
        DeviceTransportType.DEFAULT, actualFindByTenantIdAndExternalIdResult.getTransportType());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isDefault());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return {@code Default Queue Name}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile JpaDeviceProfileDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_thenReturnDefaultQueueName2() {
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
    deviceProfileEntity.setTenantId(UUID.randomUUID());
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(1L);
    when(deviceProfileRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfileEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    DeviceProfile actualFindByTenantIdAndExternalIdResult =
        jpaDeviceProfileDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(deviceProfileRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertEquals(
        "Default Queue Name", actualFindByTenantIdAndExternalIdResult.getDefaultQueueName());
    assertEquals("Image", actualFindByTenantIdAndExternalIdResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals(
        "Provision Device Key", actualFindByTenantIdAndExternalIdResult.getProvisionDeviceKey());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByTenantIdAndExternalIdResult.getDescription());
    assertNull(actualFindByTenantIdAndExternalIdResult.getProfileDataBytes());
    assertNull(actualFindByTenantIdAndExternalIdResult.getProfileData());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertEquals(
        DeviceProfileProvisionType.DISABLED,
        actualFindByTenantIdAndExternalIdResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualFindByTenantIdAndExternalIdResult.getType());
    assertEquals(
        DeviceTransportType.DEFAULT, actualFindByTenantIdAndExternalIdResult.getTransportType());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isDefault());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Then return {@code Default Queue Name}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile JpaDeviceProfileDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName_thenReturnDefaultQueueName() {
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
    DeviceProfile actualFindByTenantIdAndNameResult =
        jpaDeviceProfileDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(deviceProfileRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertEquals("Default Queue Name", actualFindByTenantIdAndNameResult.getDefaultQueueName());
    assertEquals("Image", actualFindByTenantIdAndNameResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndNameResult.getName());
    assertEquals("Provision Device Key", actualFindByTenantIdAndNameResult.getProvisionDeviceKey());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByTenantIdAndNameResult.getDescription());
    assertNull(actualFindByTenantIdAndNameResult.getProfileDataBytes());
    assertNull(actualFindByTenantIdAndNameResult.getProfileData());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertEquals(
        DeviceProfileProvisionType.DISABLED, actualFindByTenantIdAndNameResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualFindByTenantIdAndNameResult.getType());
    assertEquals(DeviceTransportType.DEFAULT, actualFindByTenantIdAndNameResult.getTransportType());
    assertTrue(actualFindByTenantIdAndNameResult.isDefault());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Then return {@code Default Queue Name}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile JpaDeviceProfileDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName_thenReturnDefaultQueueName2() {
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
    deviceProfileEntity.setTenantId(UUID.randomUUID());
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(1L);
    when(deviceProfileRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(deviceProfileEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    DeviceProfile actualFindByTenantIdAndNameResult =
        jpaDeviceProfileDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(deviceProfileRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertEquals("Default Queue Name", actualFindByTenantIdAndNameResult.getDefaultQueueName());
    assertEquals("Image", actualFindByTenantIdAndNameResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndNameResult.getName());
    assertEquals("Provision Device Key", actualFindByTenantIdAndNameResult.getProvisionDeviceKey());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByTenantIdAndNameResult.getDescription());
    assertNull(actualFindByTenantIdAndNameResult.getProfileDataBytes());
    assertNull(actualFindByTenantIdAndNameResult.getProfileData());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertEquals(
        DeviceProfileProvisionType.DISABLED, actualFindByTenantIdAndNameResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualFindByTenantIdAndNameResult.getType());
    assertEquals(DeviceTransportType.DEFAULT, actualFindByTenantIdAndNameResult.getTransportType());
    assertTrue(actualFindByTenantIdAndNameResult.isDefault());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceProfileDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceProfileRepository.findDeviceProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceProfile> actualFindByTenantIdResult =
        jpaDeviceProfileDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceProfileRepository)
        .findDeviceProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When randomUUID.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceProfileDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_whenRandomUUID_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceProfileRepository.findDeviceProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = UUID.randomUUID();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceProfile> actualFindByTenantIdResult =
        jpaDeviceProfileDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceProfileRepository)
        .findDeviceProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceProfileDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_thenReturnDataSizeIsOne() {
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

    ArrayList<DeviceProfileEntity> content = new ArrayList<>();
    content.add(deviceProfileEntity);
    when(deviceProfileRepository.findDeviceProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceProfile> actualFindByTenantIdResult =
        jpaDeviceProfileDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceProfileRepository)
        .findDeviceProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DeviceProfile> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    DeviceProfile getResult = data.get(0);
    assertEquals("Default Queue Name", getResult.getDefaultQueueName());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("Provision Device Key", getResult.getProvisionDeviceKey());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertNull(getResult.getProfileDataBytes());
    assertNull(getResult.getProfileData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(DeviceProfileProvisionType.DISABLED, getResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, getResult.getType());
    assertEquals(DeviceTransportType.DEFAULT, getResult.getTransportType());
    assertTrue(getResult.isDefault());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceProfileDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceProfileRepository.findDeviceProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DeviceProfile> actualFindByTenantIdResult =
        jpaDeviceProfileDao.findByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceProfileRepository)
        .findDeviceProfiles(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#getExternalIdByInternal(DeviceProfileId)} with {@code
   * DeviceProfileId}.
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#getExternalIdByInternal(DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfileId JpaDeviceProfileDao.getExternalIdByInternal(DeviceProfileId)"
  })
  public void testGetExternalIdByInternalWithDeviceProfileId() {
    // Arrange
    when(deviceProfileRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    DeviceProfileId internalId = new DeviceProfileId(ModelConstants.NULL_UUID);

    // Act
    DeviceProfileId actualExternalIdByInternal =
        jpaDeviceProfileDao.getExternalIdByInternal(internalId);

    // Assert
    verify(deviceProfileRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaDeviceProfileDao#getExternalIdByInternal(DeviceProfileId)} with {@code
   * DeviceProfileId}.
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#getExternalIdByInternal(DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfileId JpaDeviceProfileDao.getExternalIdByInternal(DeviceProfileId)"
  })
  public void testGetExternalIdByInternalWithDeviceProfileId2() {
    // Arrange
    when(deviceProfileRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);

    DeviceProfileId internalId = mock(DeviceProfileId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DeviceProfileId actualExternalIdByInternal =
        jpaDeviceProfileDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(deviceProfileRepository).getExternalIdById(isA(UUID.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaDeviceProfileDao#getExternalIdByInternal(DeviceProfileId)} with {@code
   * DeviceProfileId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#getExternalIdByInternal(DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceProfileId JpaDeviceProfileDao.getExternalIdByInternal(DeviceProfileId)"
  })
  public void testGetExternalIdByInternalWithDeviceProfileId_thenReturnNull() {
    // Arrange
    when(deviceProfileRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    DeviceProfileId actualExternalIdByInternal =
        jpaDeviceProfileDao.getExternalIdByInternal(new DeviceProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(deviceProfileRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDefaultEntityByTenantId(UUID)}.
   *
   * <ul>
   *   <li>Then return {@code Default Queue Name}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findDefaultEntityByTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile JpaDeviceProfileDao.findDefaultEntityByTenantId(UUID)"})
  public void testFindDefaultEntityByTenantId_thenReturnDefaultQueueName() {
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
    when(deviceProfileRepository.findByDefaultTrueAndTenantId(Mockito.<UUID>any()))
        .thenReturn(deviceProfileEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    DeviceProfile actualFindDefaultEntityByTenantIdResult =
        jpaDeviceProfileDao.findDefaultEntityByTenantId(tenantId);

    // Assert
    verify(deviceProfileRepository).findByDefaultTrueAndTenantId(isA(UUID.class));
    assertEquals(
        "Default Queue Name", actualFindDefaultEntityByTenantIdResult.getDefaultQueueName());
    assertEquals("Image", actualFindDefaultEntityByTenantIdResult.getImage());
    assertEquals("Name", actualFindDefaultEntityByTenantIdResult.getName());
    assertEquals(
        "Provision Device Key", actualFindDefaultEntityByTenantIdResult.getProvisionDeviceKey());
    assertEquals(
        "The characteristics of someone or something",
        actualFindDefaultEntityByTenantIdResult.getDescription());
    assertNull(actualFindDefaultEntityByTenantIdResult.getProfileDataBytes());
    assertNull(actualFindDefaultEntityByTenantIdResult.getProfileData());
    assertEquals(1L, actualFindDefaultEntityByTenantIdResult.getVersion().longValue());
    assertEquals(1L, actualFindDefaultEntityByTenantIdResult.getCreatedTime());
    assertEquals(
        DeviceProfileProvisionType.DISABLED,
        actualFindDefaultEntityByTenantIdResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualFindDefaultEntityByTenantIdResult.getType());
    assertEquals(
        DeviceTransportType.DEFAULT, actualFindDefaultEntityByTenantIdResult.getTransportType());
    assertTrue(actualFindDefaultEntityByTenantIdResult.isDefault());
    assertSame(tenantId, actualFindDefaultEntityByTenantIdResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findDefaultEntityByTenantId(UUID)}.
   *
   * <ul>
   *   <li>Then return {@code Default Queue Name}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findDefaultEntityByTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile JpaDeviceProfileDao.findDefaultEntityByTenantId(UUID)"})
  public void testFindDefaultEntityByTenantId_thenReturnDefaultQueueName2() {
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
    deviceProfileEntity.setTenantId(UUID.randomUUID());
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(1L);
    when(deviceProfileRepository.findByDefaultTrueAndTenantId(Mockito.<UUID>any()))
        .thenReturn(deviceProfileEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    DeviceProfile actualFindDefaultEntityByTenantIdResult =
        jpaDeviceProfileDao.findDefaultEntityByTenantId(tenantId);

    // Assert
    verify(deviceProfileRepository).findByDefaultTrueAndTenantId(isA(UUID.class));
    assertEquals(
        "Default Queue Name", actualFindDefaultEntityByTenantIdResult.getDefaultQueueName());
    assertEquals("Image", actualFindDefaultEntityByTenantIdResult.getImage());
    assertEquals("Name", actualFindDefaultEntityByTenantIdResult.getName());
    assertEquals(
        "Provision Device Key", actualFindDefaultEntityByTenantIdResult.getProvisionDeviceKey());
    assertEquals(
        "The characteristics of someone or something",
        actualFindDefaultEntityByTenantIdResult.getDescription());
    assertNull(actualFindDefaultEntityByTenantIdResult.getProfileDataBytes());
    assertNull(actualFindDefaultEntityByTenantIdResult.getProfileData());
    assertEquals(1L, actualFindDefaultEntityByTenantIdResult.getVersion().longValue());
    assertEquals(1L, actualFindDefaultEntityByTenantIdResult.getCreatedTime());
    assertEquals(
        DeviceProfileProvisionType.DISABLED,
        actualFindDefaultEntityByTenantIdResult.getProvisionType());
    assertEquals(DeviceProfileType.DEFAULT, actualFindDefaultEntityByTenantIdResult.getType());
    assertEquals(
        DeviceTransportType.DEFAULT, actualFindDefaultEntityByTenantIdResult.getTransportType());
    assertTrue(actualFindDefaultEntityByTenantIdResult.isDefault());
    assertSame(tenantId, actualFindDefaultEntityByTenantIdResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByTenantAndImageLink(TenantId, String,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDeviceProfileDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(deviceProfileRepository.findByTenantAndImageLink(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<DeviceProfileInfo> actualFindByTenantAndImageLinkResult =
        jpaDeviceProfileDao.findByTenantAndImageLink(tenantId, "Image Link", 1);

    // Assert
    verify(tenantId).getId();
    verify(deviceProfileRepository)
        .findByTenantAndImageLink(isA(UUID.class), eq("Image Link"), isA(Pageable.class));
    assertTrue(actualFindByTenantAndImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByTenantAndImageLink(TenantId, String,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDeviceProfileDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(deviceProfileRepository.findByTenantAndImageLink(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<DeviceProfileInfo> actualFindByTenantAndImageLinkResult =
        jpaDeviceProfileDao.findByTenantAndImageLink(ModelConstants.SYSTEM_TENANT, "Image Link", 1);

    // Assert
    verify(deviceProfileRepository)
        .findByTenantAndImageLink(isA(UUID.class), eq("Image Link"), isA(Pageable.class));
    assertTrue(actualFindByTenantAndImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaDeviceProfileDao#findByImageLink(String, int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceProfileDao#findByImageLink(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDeviceProfileDao.findByImageLink(String, int)"})
  public void testFindByImageLink_thenReturnEmpty() {
    // Arrange
    when(deviceProfileRepository.findByImageLink(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<DeviceProfileInfo> actualFindByImageLinkResult =
        jpaDeviceProfileDao.findByImageLink("Image Link", 1);

    // Assert
    verify(deviceProfileRepository).findByImageLink(eq("Image Link"), isA(Pageable.class));
    assertTrue(actualFindByImageLinkResult.isEmpty());
  }
}
