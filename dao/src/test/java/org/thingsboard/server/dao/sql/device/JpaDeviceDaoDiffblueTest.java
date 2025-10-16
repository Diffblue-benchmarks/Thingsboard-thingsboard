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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
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
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceIdInfo;
import org.thingsboard.server.common.data.DeviceInfo;
import org.thingsboard.server.common.data.DeviceInfoFilter;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DeviceEntity;
import org.thingsboard.server.dao.model.sql.DeviceInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaDeviceDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaDeviceDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private DeviceProfileRepository deviceProfileRepository;

  @MockBean private DeviceRepository deviceRepository;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaDeviceDao jpaDeviceDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private NativeDeviceRepository nativeDeviceRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaDeviceDao#getEntityClass()}
   *   <li>{@link JpaDeviceDao#getEntityType()}
   *   <li>{@link JpaDeviceDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaDeviceDao.getEntityClass()",
    "EntityType JpaDeviceDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaDeviceDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaDeviceDao jpaDeviceDao = new JpaDeviceDao();

    // Act
    Class<DeviceEntity> actualEntityClass = jpaDeviceDao.getEntityClass();
    EntityType actualEntityType = jpaDeviceDao.getEntityType();

    // Assert
    assertNull(jpaDeviceDao.getRepository());
    assertEquals(EntityType.DEVICE, actualEntityType);
    Class<DeviceEntity> expectedEntityClass = DeviceEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo JpaDeviceDao.findDeviceInfoById(TenantId, UUID)"})
  public void testFindDeviceInfoById_thenAdditionalInfoReturnObjectNode() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(MissingNode.getInstance());
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(UUID.randomUUID());
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);
    when(deviceRepository.findDeviceInfoById(Mockito.<UUID>any())).thenReturn(deviceInfoEntity);
    UUID deviceId = ModelConstants.NULL_UUID;

    // Act
    DeviceInfo actualFindDeviceInfoByIdResult =
        jpaDeviceDao.findDeviceInfoById(ModelConstants.SYSTEM_TENANT, deviceId);

    // Assert
    verify(deviceRepository).findDeviceInfoById(isA(UUID.class));
    assertTrue(actualFindDeviceInfoByIdResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Dr", actualFindDeviceInfoByIdResult.getCustomerTitle());
    assertEquals("Label", actualFindDeviceInfoByIdResult.getLabel());
    assertEquals("Name", actualFindDeviceInfoByIdResult.getName());
    assertEquals("Type", actualFindDeviceInfoByIdResult.getType());
    assertEquals("foo.txt", actualFindDeviceInfoByIdResult.getDeviceProfileName());
    assertNull(actualFindDeviceInfoByIdResult.getDeviceDataBytes());
    assertNull(actualFindDeviceInfoByIdResult.getDeviceData());
    assertEquals(1L, actualFindDeviceInfoByIdResult.getVersion().longValue());
    assertEquals(1L, actualFindDeviceInfoByIdResult.getCreatedTime());
    assertTrue(actualFindDeviceInfoByIdResult.isActive());
    assertTrue(actualFindDeviceInfoByIdResult.isCustomerIsPublic());
    assertSame(deviceId, actualFindDeviceInfoByIdResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo JpaDeviceDao.findDeviceInfoById(TenantId, UUID)"})
  public void testFindDeviceInfoById_thenReturnTenantIdIsSys_tenant_id() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(MissingNode.getInstance());
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);
    when(deviceRepository.findDeviceInfoById(Mockito.<UUID>any())).thenReturn(deviceInfoEntity);

    // Act
    DeviceInfo actualFindDeviceInfoByIdResult =
        jpaDeviceDao.findDeviceInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(deviceRepository).findDeviceInfoById(isA(UUID.class));
    assertSame(TenantId.SYS_TENANT_ID, actualFindDeviceInfoByIdResult.getTenantId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDevicesByTenantId(UUID, PageLink)"})
  public void testFindDevicesByTenantId() {
    // Arrange
    when(deviceRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        jpaDeviceDao.findDevicesByTenantId(
            ModelConstants.NULL_UUID, new PageLink(3, 1, "Text Search"));

    // Assert
    verify(deviceRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDevicesByTenantId(UUID, PageLink)"})
  public void testFindDevicesByTenantId2() {
    // Arrange
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        jpaDeviceDao.findDevicesByTenantId(ModelConstants.NULL_UUID, new PageLink(3, 1, ""));

    // Assert
    verify(deviceRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDevicesByTenantId(UUID, PageLink)"})
  public void testFindDevicesByTenantId_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(deviceRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        jpaDeviceDao.findDevicesByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink, atLeast(1)).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDevicesByTenantId(UUID, PageLink)"})
  public void testFindDevicesByTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        jpaDeviceDao.findDevicesByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink, atLeast(1)).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDevicesByTenantIdResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDevicesByTenantId(UUID, PageLink)"})
  public void testFindDevicesByTenantId_thenReturnDataSizeIsOne2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(UUID.randomUUID());
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        jpaDeviceDao.findDevicesByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink, atLeast(1)).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDevicesByTenantIdResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then calls {@link DeviceRepository#findByTenantId(UUID, Pageable)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDevicesByTenantId(UUID, PageLink)"})
  public void testFindDevicesByTenantId_whenFirst_page_thenCallsFindByTenantId() {
    // Arrange
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        jpaDeviceDao.findDevicesByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"})
  public void testFindDeviceInfosByFilter_givenNull_customer_id() {
    // Arrange
    when(deviceRepository.findDeviceInfosByFilter(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getActive()).thenReturn(null);
    when(filter.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(filter.getDeviceProfileId()).thenReturn(null);
    when(filter.getEdgeId()).thenReturn(null);
    when(filter.getType()).thenReturn("Type");
    when(filter.getTenantId()).thenReturn(tenantId);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        jpaDeviceDao.findDeviceInfosByFilter(filter, pageLink);

    // Assert
    verify(filter, atLeast(1)).getActive();
    verify(filter).getCustomerId();
    verify(filter).getDeviceProfileId();
    verify(filter).getEdgeId();
    verify(filter).getTenantId();
    verify(filter).getType();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findDeviceInfosByFilter(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            eq("Type"),
            isNull(),
            eq(false),
            eq(false),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindDeviceInfosByFilterResult.getTotalElements());
    assertEquals(1, actualFindDeviceInfosByFilterResult.getTotalPages());
    assertFalse(actualFindDeviceInfosByFilterResult.hasNext());
    assertTrue(actualFindDeviceInfosByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"})
  public void testFindDeviceInfosByFilter_givenSystem_tenant() {
    // Arrange
    when(deviceRepository.findDeviceInfosByFilter(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getActive()).thenReturn(null);
    when(filter.getCustomerId()).thenReturn(null);
    when(filter.getDeviceProfileId()).thenReturn(null);
    when(filter.getEdgeId()).thenReturn(null);
    when(filter.getType()).thenReturn("Type");
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        jpaDeviceDao.findDeviceInfosByFilter(filter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(filter, atLeast(1)).getActive();
    verify(filter).getCustomerId();
    verify(filter).getDeviceProfileId();
    verify(filter).getEdgeId();
    verify(filter).getTenantId();
    verify(filter).getType();
    verify(deviceRepository)
        .findDeviceInfosByFilter(
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Type"),
            isNull(),
            eq(false),
            eq(false),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindDeviceInfosByFilterResult.getTotalElements());
    assertEquals(1, actualFindDeviceInfosByFilterResult.getTotalPages());
    assertFalse(actualFindDeviceInfosByFilterResult.hasNext());
    assertTrue(actualFindDeviceInfosByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"})
  public void testFindDeviceInfosByFilter_givenSystem_tenant2() {
    // Arrange
    when(deviceRepository.findDeviceInfosByFilter(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getActive()).thenReturn(null);
    when(filter.getCustomerId()).thenReturn(null);
    when(filter.getDeviceProfileId()).thenReturn(null);
    when(filter.getEdgeId()).thenReturn(null);
    when(filter.getType()).thenReturn("Type");
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        jpaDeviceDao.findDeviceInfosByFilter(filter, pageLink);

    // Assert
    verify(filter, atLeast(1)).getActive();
    verify(filter).getCustomerId();
    verify(filter).getDeviceProfileId();
    verify(filter).getEdgeId();
    verify(filter).getTenantId();
    verify(filter).getType();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findDeviceInfosByFilter(
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Type"),
            isNull(),
            eq(false),
            eq(false),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindDeviceInfosByFilterResult.getTotalElements());
    assertEquals(1, actualFindDeviceInfosByFilterResult.getTotalPages());
    assertFalse(actualFindDeviceInfosByFilterResult.hasNext());
    assertTrue(actualFindDeviceInfosByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"})
  public void testFindDeviceInfosByFilter_givenTenantIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(deviceRepository.findDeviceInfosByFilter(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getActive()).thenReturn(null);
    when(filter.getCustomerId()).thenReturn(null);
    when(filter.getDeviceProfileId()).thenReturn(null);
    when(filter.getEdgeId()).thenReturn(null);
    when(filter.getType()).thenReturn("Type");
    when(filter.getTenantId()).thenReturn(tenantId);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        jpaDeviceDao.findDeviceInfosByFilter(filter, pageLink);

    // Assert
    verify(filter, atLeast(1)).getActive();
    verify(filter).getCustomerId();
    verify(filter).getDeviceProfileId();
    verify(filter).getEdgeId();
    verify(filter).getTenantId();
    verify(filter).getType();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findDeviceInfosByFilter(
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Type"),
            isNull(),
            eq(false),
            eq(false),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindDeviceInfosByFilterResult.getTotalElements());
    assertEquals(1, actualFindDeviceInfosByFilterResult.getTotalPages());
    assertFalse(actualFindDeviceInfosByFilterResult.hasNext());
    assertTrue(actualFindDeviceInfosByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link DeviceInfoFilter} {@link DeviceInfoFilter#getActive()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"})
  public void testFindDeviceInfosByFilter_givenTrue_whenDeviceInfoFilterGetActiveReturnTrue() {
    // Arrange
    when(deviceRepository.findDeviceInfosByFilter(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getActive()).thenReturn(true);
    when(filter.getCustomerId()).thenReturn(null);
    when(filter.getDeviceProfileId()).thenReturn(null);
    when(filter.getEdgeId()).thenReturn(null);
    when(filter.getType()).thenReturn("Type");
    when(filter.getTenantId()).thenReturn(tenantId);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        jpaDeviceDao.findDeviceInfosByFilter(filter, pageLink);

    // Assert
    verify(filter, atLeast(1)).getActive();
    verify(filter).getCustomerId();
    verify(filter).getDeviceProfileId();
    verify(filter).getEdgeId();
    verify(filter).getTenantId();
    verify(filter).getType();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findDeviceInfosByFilter(
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Type"),
            isNull(),
            eq(true),
            eq(true),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindDeviceInfosByFilterResult.getTotalElements());
    assertEquals(1, actualFindDeviceInfosByFilterResult.getTotalPages());
    assertFalse(actualFindDeviceInfosByFilterResult.hasNext());
    assertTrue(actualFindDeviceInfosByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfileId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"})
  public void testFindDeviceInfosByFilter_thenCallsGetId() {
    // Arrange
    when(deviceRepository.findDeviceInfosByFilter(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getActive()).thenReturn(null);
    when(filter.getCustomerId()).thenReturn(null);
    when(filter.getDeviceProfileId()).thenReturn(deviceProfileId);
    when(filter.getEdgeId()).thenReturn(null);
    when(filter.getType()).thenReturn("Type");
    when(filter.getTenantId()).thenReturn(tenantId);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        jpaDeviceDao.findDeviceInfosByFilter(filter, pageLink);

    // Assert
    verify(filter, atLeast(1)).getActive();
    verify(filter).getCustomerId();
    verify(filter).getDeviceProfileId();
    verify(filter).getEdgeId();
    verify(filter).getTenantId();
    verify(filter).getType();
    verify(deviceProfileId).getId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findDeviceInfosByFilter(
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Type"),
            isA(UUID.class),
            eq(false),
            eq(false),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindDeviceInfosByFilterResult.getTotalElements());
    assertEquals(1, actualFindDeviceInfosByFilterResult.getTotalPages());
    assertFalse(actualFindDeviceInfosByFilterResult.hasNext());
    assertTrue(actualFindDeviceInfosByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"})
  public void testFindDeviceInfosByFilter_thenReturnDataSizeIsOne() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(-1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Prof");
    deviceInfoEntity.setDeviceData(null);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("org.thingsboard.server.dao.model.sql.DeviceInfoEntity");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("42");
    deviceInfoEntity.setName("42");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("42");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(-1L);

    ArrayList<DeviceInfoEntity> content = new ArrayList<>();
    content.add(deviceInfoEntity);
    when(deviceRepository.findDeviceInfosByFilter(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getActive()).thenReturn(null);
    when(filter.getCustomerId()).thenReturn(null);
    when(filter.getDeviceProfileId()).thenReturn(deviceProfileId);
    when(filter.getEdgeId()).thenReturn(null);
    when(filter.getType()).thenReturn("Type");
    when(filter.getTenantId()).thenReturn(tenantId);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        jpaDeviceDao.findDeviceInfosByFilter(filter, pageLink);

    // Assert
    verify(filter, atLeast(1)).getActive();
    verify(filter).getCustomerId();
    verify(filter).getDeviceProfileId();
    verify(filter).getEdgeId();
    verify(filter).getTenantId();
    verify(filter).getType();
    verify(deviceProfileId).getId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findDeviceInfosByFilter(
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Type"),
            isA(UUID.class),
            eq(false),
            eq(false),
            eq("Text Search"),
            isA(Pageable.class));
    List<DeviceInfo> data = actualFindDeviceInfosByFilterResult.getData();
    assertEquals(1, data.size());
    DeviceInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("42", getResult.getLabel());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getType());
    assertEquals("Prof", getResult.getCustomerTitle());
    assertEquals(
        "org.thingsboard.server.dao.model.sql.DeviceInfoEntity", getResult.getDeviceProfileName());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDeviceInfosByFilterResult.getTotalElements());
    assertTrue(getResult.isActive());
    assertTrue(getResult.isCustomerIsPublic());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndIdsAsync(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaDeviceDao.findDevicesByTenantIdAndIdsAsync(UUID, List)"})
  public void testFindDevicesByTenantIdAndIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdAndIdsAsyncResult =
        jpaDeviceDao.findDevicesByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, deviceIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndIdsAsync(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaDeviceDao.findDevicesByTenantIdAndIdsAsync(UUID, List)"})
  public void testFindDevicesByTenantIdAndIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdAndIdsAsyncResult =
        jpaDeviceDao.findDevicesByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, deviceIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndIdsAsync(UUID, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaDeviceDao.findDevicesByTenantIdAndIdsAsync(UUID, List)"})
  public void testFindDevicesByTenantIdAndIdsAsync_whenArrayList() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdAndIdsAsyncResult =
        jpaDeviceDao.findDevicesByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, new ArrayList<>());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIds(List)}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} DeviceData is Instance.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDeviceDao.findDevicesByIds(List)"})
  public void testFindDevicesByIds_givenDeviceEntityDeviceDataIsInstance_thenReturnSizeIsOne() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> deviceEntityList = new ArrayList<>();
    deviceEntityList.add(deviceEntity);
    when(deviceRepository.findDevicesByIdIn(Mockito.<List<UUID>>any()))
        .thenReturn(deviceEntityList);

    // Act
    List<Device> actualFindDevicesByIdsResult = jpaDeviceDao.findDevicesByIds(new ArrayList<>());

    // Assert
    verify(deviceRepository).findDevicesByIdIn(isA(List.class));
    assertEquals(1, actualFindDevicesByIdsResult.size());
    Device getResult = actualFindDevicesByIdsResult.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIds(List)}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} DeviceData is Instance.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDeviceDao.findDevicesByIds(List)"})
  public void testFindDevicesByIds_givenDeviceEntityDeviceDataIsInstance_thenReturnSizeIsOne2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(UUID.randomUUID());
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> deviceEntityList = new ArrayList<>();
    deviceEntityList.add(deviceEntity);
    when(deviceRepository.findDevicesByIdIn(Mockito.<List<UUID>>any()))
        .thenReturn(deviceEntityList);

    // Act
    List<Device> actualFindDevicesByIdsResult = jpaDeviceDao.findDevicesByIds(new ArrayList<>());

    // Assert
    verify(deviceRepository).findDevicesByIdIn(isA(List.class));
    assertEquals(1, actualFindDevicesByIdsResult.size());
    Device getResult = actualFindDevicesByIdsResult.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIds(List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDeviceDao.findDevicesByIds(List)"})
  public void testFindDevicesByIds_givenNull_uuid_whenArrayListAddNull_uuid_thenReturnEmpty() {
    // Arrange
    when(deviceRepository.findDevicesByIdIn(Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    List<Device> actualFindDevicesByIdsResult = jpaDeviceDao.findDevicesByIds(deviceIds);

    // Assert
    verify(deviceRepository).findDevicesByIdIn(isA(List.class));
    assertTrue(actualFindDevicesByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIds(List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDeviceDao.findDevicesByIds(List)"})
  public void testFindDevicesByIds_givenNull_uuid_whenArrayListAddNull_uuid_thenReturnEmpty2() {
    // Arrange
    when(deviceRepository.findDevicesByIdIn(Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    List<Device> actualFindDevicesByIdsResult = jpaDeviceDao.findDevicesByIds(deviceIds);

    // Assert
    verify(deviceRepository).findDevicesByIdIn(isA(List.class));
    assertTrue(actualFindDevicesByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIds(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDeviceDao.findDevicesByIds(List)"})
  public void testFindDevicesByIds_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(deviceRepository.findDevicesByIdIn(Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Device> actualFindDevicesByIdsResult = jpaDeviceDao.findDevicesByIds(new ArrayList<>());

    // Assert
    verify(deviceRepository).findDevicesByIdIn(isA(List.class));
    assertTrue(actualFindDevicesByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIdsAsync(List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByIdsAsync(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaDeviceDao.findDevicesByIdsAsync(List)"})
  public void testFindDevicesByIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByIdsAsyncResult =
        jpaDeviceDao.findDevicesByIdsAsync(deviceIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIdsAsync(List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByIdsAsync(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaDeviceDao.findDevicesByIdsAsync(List)"})
  public void testFindDevicesByIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByIdsAsyncResult =
        jpaDeviceDao.findDevicesByIdsAsync(deviceIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIdsAsync(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByIdsAsync(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaDeviceDao.findDevicesByIdsAsync(List)"})
  public void testFindDevicesByIdsAsync_whenArrayList() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByIdsAsyncResult =
        jpaDeviceDao.findDevicesByIdsAsync(new ArrayList<>());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult =
        jpaDeviceDao.findDevicesByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId_thenReturnDataSizeIsOne() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult =
        jpaDeviceDao.findDevicesByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDevicesByTenantIdAndCustomerIdResult.getTotalElements());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId_thenReturnDataSizeIsOne2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(UUID.randomUUID());
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult =
        jpaDeviceDao.findDevicesByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDevicesByTenantIdAndCustomerIdResult.getTotalElements());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult =
        jpaDeviceDao.findDevicesByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)"
  })
  public void testFindDevicesByTenantIdAndProfileId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndProfileId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    PageData<Device> actualFindDevicesByTenantIdAndProfileIdResult =
        jpaDeviceDao.findDevicesByTenantIdAndProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndProfileId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndProfileIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndProfileIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndProfileIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndProfileIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)"
  })
  public void testFindDevicesByTenantIdAndProfileId_thenReturnDataSizeIsOne() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantIdAndProfileId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID profileId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndProfileIdResult =
        jpaDeviceDao.findDevicesByTenantIdAndProfileId(
            ModelConstants.NULL_UUID, profileId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndProfileId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndProfileIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDevicesByTenantIdAndProfileIdResult.getTotalElements());
    assertSame(profileId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)"
  })
  public void testFindDevicesByTenantIdAndProfileId_thenReturnDataSizeIsOne2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(UUID.randomUUID());
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantIdAndProfileId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID profileId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndProfileIdResult =
        jpaDeviceDao.findDevicesByTenantIdAndProfileId(
            ModelConstants.NULL_UUID, profileId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndProfileId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndProfileIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDevicesByTenantIdAndProfileIdResult.getTotalElements());
    assertSame(profileId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)"
  })
  public void testFindDevicesByTenantIdAndProfileId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndProfileId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndProfileIdResult =
        jpaDeviceDao.findDevicesByTenantIdAndProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository)
        .findByTenantIdAndProfileId(
            isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndProfileIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndProfileIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndProfileIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndProfileIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesIdsByDeviceProfileTransportType(DeviceTransportType,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaDeviceDao#findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)"
  })
  public void testFindDevicesIdsByDeviceProfileTransportType_givenOne_thenCallsGetPage() {
    // Arrange
    when(deviceRepository.findIdsByDeviceProfileTransportType(
            Mockito.<DeviceTransportType>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<UUID> actualFindDevicesIdsByDeviceProfileTransportTypeResult =
        jpaDeviceDao.findDevicesIdsByDeviceProfileTransportType(
            DeviceTransportType.DEFAULT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findIdsByDeviceProfileTransportType(eq(DeviceTransportType.DEFAULT), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesIdsByDeviceProfileTransportTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesIdsByDeviceProfileTransportTypeResult.getTotalPages());
    assertFalse(actualFindDevicesIdsByDeviceProfileTransportTypeResult.hasNext());
    assertTrue(actualFindDevicesIdsByDeviceProfileTransportTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesIdsByDeviceProfileTransportType(DeviceTransportType,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaDeviceDao#findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)"
  })
  public void testFindDevicesIdsByDeviceProfileTransportType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findIdsByDeviceProfileTransportType(
            Mockito.<DeviceTransportType>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<UUID> actualFindDevicesIdsByDeviceProfileTransportTypeResult =
        jpaDeviceDao.findDevicesIdsByDeviceProfileTransportType(
            DeviceTransportType.DEFAULT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository)
        .findIdsByDeviceProfileTransportType(eq(DeviceTransportType.DEFAULT), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesIdsByDeviceProfileTransportTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesIdsByDeviceProfileTransportTypeResult.getTotalPages());
    assertFalse(actualFindDevicesIdsByDeviceProfileTransportTypeResult.hasNext());
    assertTrue(actualFindDevicesIdsByDeviceProfileTransportTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdCustomerIdAndIdsAsync(UUID,
   * UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaDeviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)"
  })
  public void testFindDevicesByTenantIdCustomerIdAndIdsAsync_givenNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult =
        jpaDeviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, deviceIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdCustomerIdAndIdsAsync(UUID,
   * UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaDeviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)"
  })
  public void testFindDevicesByTenantIdCustomerIdAndIdsAsync_givenNull_uuid2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult =
        jpaDeviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, deviceIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdCustomerIdAndIdsAsync(UUID,
   * UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaDeviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)"
  })
  public void testFindDevicesByTenantIdCustomerIdAndIdsAsync_whenArrayList() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult =
        jpaDeviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, new ArrayList<>());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Then {@link Optional#get()} AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaDeviceDao.findDeviceByTenantIdAndName(UUID, String)"})
  public void testFindDeviceByTenantIdAndName_thenGetAdditionalInfoReturnObjectNode() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    when(deviceRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(deviceEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Device> actualFindDeviceByTenantIdAndNameResult =
        jpaDeviceDao.findDeviceByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(deviceRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    Device getResult = actualFindDeviceByTenantIdAndNameResult.get();
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(actualFindDeviceByTenantIdAndNameResult.isPresent());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Then {@link Optional#get()} AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaDeviceDao.findDeviceByTenantIdAndName(UUID, String)"})
  public void testFindDeviceByTenantIdAndName_thenGetAdditionalInfoReturnObjectNode2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(UUID.randomUUID());
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    when(deviceRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(deviceEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Device> actualFindDeviceByTenantIdAndNameResult =
        jpaDeviceDao.findDeviceByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(deviceRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    Device getResult = actualFindDeviceByTenantIdAndNameResult.get();
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(actualFindDeviceByTenantIdAndNameResult.isPresent());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDevicesByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindDevicesByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult =
        jpaDeviceDao.findDevicesByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDevicesByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindDevicesByTenantIdAndType_thenReturnDataSizeIsOne() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult =
        jpaDeviceDao.findDevicesByTenantIdAndType(tenantId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDevicesByTenantIdAndTypeResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDevicesByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindDevicesByTenantIdAndType_thenReturnDataSizeIsOne2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(UUID.randomUUID());
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult =
        jpaDeviceDao.findDevicesByTenantIdAndType(tenantId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDevicesByTenantIdAndTypeResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDevicesByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindDevicesByTenantIdAndType_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult =
        jpaDeviceDao.findDevicesByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID,
   * OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID,
   * UUID, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage() {
    // Arrange
    when(deviceRepository.findByTenantIdAndTypeAndFirmwareIdIsNull(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult =
        jpaDeviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            OtaPackageType.FIRMWARE,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository)
        .findByTenantIdAndTypeAndFirmwareIdIsNull(
            isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID,
   * OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID,
   * UUID, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage2() {
    // Arrange
    when(deviceRepository.findByTenantIdAndTypeAndFirmwareIdIsNull(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult =
        jpaDeviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndTypeAndFirmwareIdIsNull(
            isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID,
   * OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID,
   * UUID, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage3() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(UUID.randomUUID());
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantIdAndTypeAndSoftwareIdIsNull(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID deviceProfileId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult =
        jpaDeviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            ModelConstants.NULL_UUID, deviceProfileId, OtaPackageType.SOFTWARE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndTypeAndSoftwareIdIsNull(
            isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalElements());
    assertSame(deviceProfileId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID,
   * OtaPackageType, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID,
   * UUID, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage_thenReturnDataSizeIsOne() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantIdAndTypeAndSoftwareIdIsNull(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID deviceProfileId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult =
        jpaDeviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            ModelConstants.NULL_UUID, deviceProfileId, OtaPackageType.SOFTWARE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndTypeAndSoftwareIdIsNull(
            isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalElements());
    assertSame(deviceProfileId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID,
   * OtaPackageType, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID,
   * UUID, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndTypeAndSoftwareIdIsNull(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult =
        jpaDeviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, OtaPackageType.SOFTWARE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndTypeAndSoftwareIdIsNull(
            isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID,
   * OtaPackageType)}.
   *
   * <p>Method under test: {@link
   * JpaDeviceDao#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID,
   * OtaPackageType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long JpaDeviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID, OtaPackageType)"
  })
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage() {
    // Arrange
    when(deviceRepository.countByTenantIdAndDeviceProfileIdAndFirmwareIdIsNull(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(1L);

    // Act
    Long actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult =
        jpaDeviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, OtaPackageType.FIRMWARE);

    // Assert
    verify(deviceRepository)
        .countByTenantIdAndDeviceProfileIdAndFirmwareIdIsNull(isA(UUID.class), isA(UUID.class));
    assertEquals(
        1L, actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult.longValue());
  }

  /**
   * Test {@link JpaDeviceDao#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID,
   * OtaPackageType)}.
   *
   * <p>Method under test: {@link
   * JpaDeviceDao#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID,
   * OtaPackageType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long JpaDeviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID, OtaPackageType)"
  })
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage2() {
    // Arrange
    when(deviceRepository.countByTenantIdAndDeviceProfileIdAndSoftwareIdIsNull(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(1L);

    // Act
    Long actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult =
        jpaDeviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, OtaPackageType.SOFTWARE);

    // Assert
    verify(deviceRepository)
        .countByTenantIdAndDeviceProfileIdAndSoftwareIdIsNull(isA(UUID.class), isA(UUID.class));
    assertEquals(
        1L, actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult.longValue());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType_thenReturnDataSizeIsOne() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult =
        jpaDeviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, customerId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType_thenReturnDataSizeIsOne2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(UUID.randomUUID());
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult =
        jpaDeviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, customerId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult =
        jpaDeviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(deviceRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult =
        jpaDeviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findTenantDeviceTypesAsync(UUID)}.
   *
   * <p>Method under test: {@link JpaDeviceDao#findTenantDeviceTypesAsync(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaDeviceDao.findTenantDeviceTypesAsync(UUID)"})
  public void testFindTenantDeviceTypesAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindTenantDeviceTypesAsyncResult =
        jpaDeviceDao.findTenantDeviceTypesAsync(ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindTenantDeviceTypesAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindTenantDeviceTypesAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceByTenantIdAndId(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceByTenantIdAndId(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device JpaDeviceDao.findDeviceByTenantIdAndId(TenantId, UUID)"})
  public void testFindDeviceByTenantIdAndId_thenAdditionalInfoIteratorNextReturnBooleanNode() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    when(deviceRepository.findByTenantIdAndId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(deviceEntity);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    Device actualFindDeviceByTenantIdAndIdResult =
        jpaDeviceDao.findDeviceByTenantIdAndId(tenantId, ModelConstants.NULL_UUID);

    // Assert
    verify(deviceRepository).findByTenantIdAndId(isA(UUID.class), isA(UUID.class));
    JsonNode additionalInfo = actualFindDeviceByTenantIdAndIdResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    assertTrue(iteratorResult.next() instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    DeviceId expectedId = actualFindDeviceByTenantIdAndIdResult.getExternalId();
    assertEquals(expectedId, actualFindDeviceByTenantIdAndIdResult.getId());
    OtaPackageId expectedSoftwareId = actualFindDeviceByTenantIdAndIdResult.getFirmwareId();
    assertEquals(expectedSoftwareId, actualFindDeviceByTenantIdAndIdResult.getSoftwareId());
    assertSame(tenantId, actualFindDeviceByTenantIdAndIdResult.getTenantId());
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceByTenantIdAndId(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceByTenantIdAndId(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device JpaDeviceDao.findDeviceByTenantIdAndId(TenantId, UUID)"})
  public void testFindDeviceByTenantIdAndId_thenReturnNotTenantIdNullUid() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    deviceEntity.setTenantId(tenantId);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    when(deviceRepository.findByTenantIdAndId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(deviceEntity);

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Device actualFindDeviceByTenantIdAndIdResult =
        jpaDeviceDao.findDeviceByTenantIdAndId(tenantId2, ModelConstants.NULL_UUID);

    // Assert
    verify(tenantId2).getId();
    verify(deviceRepository).findByTenantIdAndId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId3 = actualFindDeviceByTenantIdAndIdResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    DeviceId expectedId = actualFindDeviceByTenantIdAndIdResult.getExternalId();
    assertEquals(expectedId, actualFindDeviceByTenantIdAndIdResult.getId());
    OtaPackageId expectedSoftwareId = actualFindDeviceByTenantIdAndIdResult.getFirmwareId();
    assertEquals(expectedSoftwareId, actualFindDeviceByTenantIdAndIdResult.getSoftwareId());
    assertSame(tenantId, tenantId3.getId());
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceByTenantIdAndId(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceByTenantIdAndId(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device JpaDeviceDao.findDeviceByTenantIdAndId(TenantId, UUID)"})
  public void testFindDeviceByTenantIdAndId_thenReturnTenantIdIsSys_tenant_id() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    when(deviceRepository.findByTenantIdAndId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(deviceEntity);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Device actualFindDeviceByTenantIdAndIdResult =
        jpaDeviceDao.findDeviceByTenantIdAndId(tenantId, ModelConstants.NULL_UUID);

    // Assert
    verify(tenantId).getId();
    verify(deviceRepository).findByTenantIdAndId(isA(UUID.class), isA(UUID.class));
    DeviceId expectedId = actualFindDeviceByTenantIdAndIdResult.getExternalId();
    assertEquals(expectedId, actualFindDeviceByTenantIdAndIdResult.getId());
    OtaPackageId expectedSoftwareId = actualFindDeviceByTenantIdAndIdResult.getFirmwareId();
    assertEquals(expectedSoftwareId, actualFindDeviceByTenantIdAndIdResult.getSoftwareId());
    assertSame(TenantId.SYS_TENANT_ID, actualFindDeviceByTenantIdAndIdResult.getTenantId());
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceByTenantIdAndIdAsync(TenantId, UUID)}.
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceByTenantIdAndIdAsync(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaDeviceDao.findDeviceByTenantIdAndIdAsync(TenantId, UUID)"
  })
  public void testFindDeviceByTenantIdAndIdAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Device> actualFindDeviceByTenantIdAndIdAsyncResult =
        jpaDeviceDao.findDeviceByTenantIdAndIdAsync(
            ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDeviceByTenantIdAndIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByTenantIdAndIdAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#countDevicesByDeviceProfileId(TenantId, UUID)}.
   *
   * <p>Method under test: {@link JpaDeviceDao#countDevicesByDeviceProfileId(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaDeviceDao.countDevicesByDeviceProfileId(TenantId, UUID)"})
  public void testCountDevicesByDeviceProfileId() {
    // Arrange
    when(deviceRepository.countByDeviceProfileId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountDevicesByDeviceProfileIdResult =
        jpaDeviceDao.countDevicesByDeviceProfileId(
            ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(deviceRepository).countByDeviceProfileId(isA(UUID.class));
    assertEquals(1L, actualCountDevicesByDeviceProfileIdResult.longValue());
  }

  /**
   * Test {@link JpaDeviceDao#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaDeviceDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(deviceRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Long actualCountByTenantIdResult = jpaDeviceDao.countByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(deviceRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaDeviceDao#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaDeviceDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(deviceRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaDeviceDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)"})
  public void testFindDevicesByTenantIdAndEdgeId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult =
        jpaDeviceDao.findDevicesByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)"})
  public void testFindDevicesByTenantIdAndEdgeId_thenReturnDataSizeIsOne() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(3L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Try to find devices by tenantId [{}], edgeId [{}] and pageLink [{}]");
    deviceEntity.setName("Try to find devices by tenantId [{}], edgeId [{}] and pageLink [{}]");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Try to find devices by tenantId [{}], edgeId [{}] and pageLink [{}]");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(3L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID edgeId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult =
        jpaDeviceDao.findDevicesByTenantIdAndEdgeId(ModelConstants.NULL_UUID, edgeId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals(
        "Try to find devices by tenantId [{}], edgeId [{}] and pageLink [{}]",
        getResult.getLabel());
    assertEquals(
        "Try to find devices by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getName());
    assertEquals(
        "Try to find devices by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, actualFindDevicesByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(3L, getResult.getVersion().longValue());
    assertEquals(3L, getResult.getCreatedTime());
    assertSame(edgeId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)"})
  public void testFindDevicesByTenantIdAndEdgeId_thenReturnDataSizeIsOne2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(3L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Try to find devices by tenantId [{}], edgeId [{}] and pageLink [{}]");
    deviceEntity.setName("Try to find devices by tenantId [{}], edgeId [{}] and pageLink [{}]");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(UUID.randomUUID());
    deviceEntity.setType("Try to find devices by tenantId [{}], edgeId [{}] and pageLink [{}]");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(3L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID edgeId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult =
        jpaDeviceDao.findDevicesByTenantIdAndEdgeId(ModelConstants.NULL_UUID, edgeId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals(
        "Try to find devices by tenantId [{}], edgeId [{}] and pageLink [{}]",
        getResult.getLabel());
    assertEquals(
        "Try to find devices by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getName());
    assertEquals(
        "Try to find devices by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, actualFindDevicesByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(3L, getResult.getVersion().longValue());
    assertEquals(3L, getResult.getCreatedTime());
    assertSame(edgeId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)"})
  public void testFindDevicesByTenantIdAndEdgeId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult =
        jpaDeviceDao.findDevicesByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository)
        .findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult =
        jpaDeviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType_thenReturnDataSizeIsOne() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(4L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel(
        "Try to find devices by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    deviceEntity.setName(
        "Try to find devices by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType(
        "Try to find devices by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(4L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID edgeId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult =
        jpaDeviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            ModelConstants.NULL_UUID, edgeId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals(
        "Try to find devices by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]",
        getResult.getLabel());
    assertEquals(
        "Try to find devices by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]",
        getResult.getName());
    assertEquals(
        "Try to find devices by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]",
        getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(4L, getResult.getVersion().longValue());
    assertEquals(4L, getResult.getCreatedTime());
    assertSame(edgeId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType_thenReturnDataSizeIsOne2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(4L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel(
        "Try to find devices by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    deviceEntity.setName(
        "Try to find devices by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(UUID.randomUUID());
    deviceEntity.setType(
        "Try to find devices by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(4L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID edgeId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult =
        jpaDeviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            ModelConstants.NULL_UUID, edgeId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals(
        "Try to find devices by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]",
        getResult.getLabel());
    assertEquals(
        "Try to find devices by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]",
        getResult.getName());
    assertEquals(
        "Try to find devices by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]",
        getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(4L, getResult.getVersion().longValue());
    assertEquals(4L, getResult.getCreatedTime());
    assertSame(edgeId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDeviceDao.findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult =
        jpaDeviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository)
        .findByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceIdInfos(PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceIdInfos(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(nativeDeviceRepository.findDeviceIdInfos(Mockito.<Pageable>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult = jpaDeviceDao.findDeviceIdInfos(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(nativeDeviceRepository).findDeviceIdInfos(isA(Pageable.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceIdInfos(PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findDeviceIdInfos(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(nativeDeviceRepository.findDeviceIdInfos(Mockito.<Pageable>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult =
        jpaDeviceDao.findDeviceIdInfos(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(nativeDeviceRepository).findDeviceIdInfos(isA(Pageable.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device JpaDeviceDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_thenAdditionalInfoReturnObjectNode() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    when(deviceRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(deviceEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    Device actualFindByTenantIdAndExternalIdResult =
        jpaDeviceDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(deviceRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindByTenantIdAndExternalIdResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", actualFindByTenantIdAndExternalIdResult.getLabel());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals("Type", actualFindByTenantIdAndExternalIdResult.getType());
    assertNull(actualFindByTenantIdAndExternalIdResult.getDeviceDataBytes());
    assertNull(actualFindByTenantIdAndExternalIdResult.getDeviceData());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device JpaDeviceDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_thenAdditionalInfoReturnObjectNode2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(UUID.randomUUID());
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    when(deviceRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(deviceEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    Device actualFindByTenantIdAndExternalIdResult =
        jpaDeviceDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(deviceRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindByTenantIdAndExternalIdResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", actualFindByTenantIdAndExternalIdResult.getLabel());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals("Type", actualFindByTenantIdAndExternalIdResult.getType());
    assertNull(actualFindByTenantIdAndExternalIdResult.getDeviceDataBytes());
    assertNull(actualFindByTenantIdAndExternalIdResult.getDeviceData());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device JpaDeviceDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName_thenAdditionalInfoReturnObjectNode() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    when(deviceRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(deviceEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Device actualFindByTenantIdAndNameResult = jpaDeviceDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(deviceRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertTrue(actualFindByTenantIdAndNameResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", actualFindByTenantIdAndNameResult.getLabel());
    assertEquals("Name", actualFindByTenantIdAndNameResult.getName());
    assertEquals("Type", actualFindByTenantIdAndNameResult.getType());
    assertNull(actualFindByTenantIdAndNameResult.getDeviceDataBytes());
    assertNull(actualFindByTenantIdAndNameResult.getDeviceData());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device JpaDeviceDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName_thenAdditionalInfoReturnObjectNode2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(UUID.randomUUID());
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    when(deviceRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(deviceEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Device actualFindByTenantIdAndNameResult = jpaDeviceDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(deviceRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertTrue(actualFindByTenantIdAndNameResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", actualFindByTenantIdAndNameResult.getLabel());
    assertEquals("Name", actualFindByTenantIdAndNameResult.getName());
    assertEquals("Type", actualFindByTenantIdAndNameResult.getType());
    assertNull(actualFindByTenantIdAndNameResult.getDeviceDataBytes());
    assertNull(actualFindByTenantIdAndNameResult.getDeviceData());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId() {
    // Arrange
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindByTenantIdResult =
        jpaDeviceDao.findByTenantId(ModelConstants.NULL_UUID, new PageLink(3, 1, ""));

    // Assert
    verify(deviceRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} DeviceData is Instance.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenDeviceEntityDeviceDataIsInstance_thenReturnDataSizeIsOne() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Device> actualFindByTenantIdResult = jpaDeviceDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink, atLeast(1)).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} DeviceData is Instance.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenDeviceEntityDeviceDataIsInstance_thenReturnDataSizeIsOne2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(UUID.randomUUID());
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    when(deviceRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Device> actualFindByTenantIdResult = jpaDeviceDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink, atLeast(1)).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(getResult.getDeviceData());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(deviceRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Device> actualFindByTenantIdResult =
        jpaDeviceDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink, atLeast(1)).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then calls {@link DeviceRepository#findByTenantId(UUID, Pageable)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenCallsFindByTenantId() {
    // Arrange
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindByTenantIdResult =
        jpaDeviceDao.findByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link PageLink#PageLink(int, int, String)} with pageSize is three and page is one
   *       and {@code Text Search}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDeviceDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenPageLinkWithPageSizeIsThreeAndPageIsOneAndTextSearch() {
    // Arrange
    when(deviceRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindByTenantIdResult =
        jpaDeviceDao.findByTenantId(ModelConstants.NULL_UUID, new PageLink(3, 1, "Text Search"));

    // Assert
    verify(deviceRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#getExternalIdByInternal(DeviceId)} with {@code DeviceId}.
   *
   * <p>Method under test: {@link JpaDeviceDao#getExternalIdByInternal(DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceId JpaDeviceDao.getExternalIdByInternal(DeviceId)"})
  public void testGetExternalIdByInternalWithDeviceId() {
    // Arrange
    when(deviceRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);

    DeviceId internalId = mock(DeviceId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DeviceId actualExternalIdByInternal = jpaDeviceDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(deviceRepository).getExternalIdById(isA(UUID.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.DEVICE, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaDeviceDao#getExternalIdByInternal(DeviceId)} with {@code DeviceId}.
   *
   * <ul>
   *   <li>Then return {@link DeviceId#DeviceId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#getExternalIdByInternal(DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceId JpaDeviceDao.getExternalIdByInternal(DeviceId)"})
  public void testGetExternalIdByInternalWithDeviceId_thenReturnDeviceIdWithIdIsNull_uuid() {
    // Arrange
    when(deviceRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    DeviceId internalId = new DeviceId(ModelConstants.NULL_UUID);

    // Act
    DeviceId actualExternalIdByInternal = jpaDeviceDao.getExternalIdByInternal(internalId);

    // Assert
    verify(deviceRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaDeviceDao#getExternalIdByInternal(DeviceId)} with {@code DeviceId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDeviceDao#getExternalIdByInternal(DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceId JpaDeviceDao.getExternalIdByInternal(DeviceId)"})
  public void testGetExternalIdByInternalWithDeviceId_thenReturnNull() {
    // Arrange
    when(deviceRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    DeviceId actualExternalIdByInternal =
        jpaDeviceDao.getExternalIdByInternal(new DeviceId(ModelConstants.NULL_UUID));

    // Assert
    verify(deviceRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }
}
