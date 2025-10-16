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
package org.thingsboard.server.dao.sql.ota;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
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
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.OtaPackageInfo;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.OtaPackageInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaOtaPackageInfoDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaOtaPackageInfoDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaOtaPackageInfoDao jpaOtaPackageInfoDao;

  @MockBean private OtaPackageInfoRepository otaPackageInfoRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaOtaPackageInfoDao#getEntityClass()}
   *   <li>{@link JpaOtaPackageInfoDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaOtaPackageInfoDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaOtaPackageInfoDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaOtaPackageInfoDao jpaOtaPackageInfoDao = new JpaOtaPackageInfoDao();

    // Act
    Class<OtaPackageInfoEntity> actualEntityClass = jpaOtaPackageInfoDao.getEntityClass();

    // Assert
    assertNull(jpaOtaPackageInfoDao.getRepository());
    Class<OtaPackageInfoEntity> expectedEntityClass = OtaPackageInfoEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaOtaPackageInfoDao#findById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return AdditionalInfo is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link JpaOtaPackageInfoDao#findById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackageInfo JpaOtaPackageInfoDao.findById(TenantId, UUID)"})
  public void testFindById_thenReturnAdditionalInfoIsValueOfTen() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    DoubleNode additionalInfo = DoubleNode.valueOf(10.0d);
    otaPackageInfoEntity.setAdditionalInfo(additionalInfo);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");
    when(otaPackageInfoRepository.findOtaPackageInfoById(Mockito.<UUID>any()))
        .thenReturn(otaPackageInfoEntity);

    // Act
    OtaPackageInfo actualFindByIdResult =
        jpaOtaPackageInfoDao.findById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(otaPackageInfoRepository).findOtaPackageInfoById(isA(UUID.class));
    assertSame(additionalInfo, actualFindByIdResult.getAdditionalInfo());
  }

  /**
   * Test {@link JpaOtaPackageInfoDao#findById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaOtaPackageInfoDao#findById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackageInfo JpaOtaPackageInfoDao.findById(TenantId, UUID)"})
  public void testFindById_thenReturnTenantIdIsSys_tenant_id() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");
    when(otaPackageInfoRepository.findOtaPackageInfoById(Mockito.<UUID>any()))
        .thenReturn(otaPackageInfoEntity);

    // Act
    OtaPackageInfo actualFindByIdResult =
        jpaOtaPackageInfoDao.findById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(otaPackageInfoRepository).findOtaPackageInfoById(isA(UUID.class));
    assertSame(TenantId.SYS_TENANT_ID, actualFindByIdResult.getTenantId());
  }

  /**
   * Test {@link JpaOtaPackageInfoDao#save(TenantId, OtaPackageInfo)} with {@code TenantId}, {@code
   * OtaPackageInfo}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaOtaPackageInfoDao#save(TenantId, OtaPackageInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackageInfo JpaOtaPackageInfoDao.save(TenantId, OtaPackageInfo)"})
  public void testSaveWithTenantIdOtaPackageInfo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaOtaPackageInfoDao.save(ModelConstants.SYSTEM_TENANT, new OtaPackage()));
  }

  /**
   * Test {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaOtaPackageInfoDao.findOtaPackageInfoByTenantId(TenantId, PageLink)"
  })
  public void testFindOtaPackageInfoByTenantId_givenNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(otaPackageInfoRepository.findAllByTenantId(
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
    PageData<OtaPackageInfo> actualFindOtaPackageInfoByTenantIdResult =
        jpaOtaPackageInfoDao.findOtaPackageInfoByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(otaPackageInfoRepository)
        .findAllByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindOtaPackageInfoByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindOtaPackageInfoByTenantIdResult.getTotalPages());
    assertFalse(actualFindOtaPackageInfoByTenantIdResult.hasNext());
    assertTrue(actualFindOtaPackageInfoByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaOtaPackageInfoDao.findOtaPackageInfoByTenantId(TenantId, PageLink)"
  })
  public void testFindOtaPackageInfoByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(otaPackageInfoRepository.findAllByTenantId(
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
    PageData<OtaPackageInfo> actualFindOtaPackageInfoByTenantIdResult =
        jpaOtaPackageInfoDao.findOtaPackageInfoByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(otaPackageInfoRepository)
        .findAllByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindOtaPackageInfoByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindOtaPackageInfoByTenantIdResult.getTotalPages());
    assertFalse(actualFindOtaPackageInfoByTenantIdResult.hasNext());
    assertTrue(actualFindOtaPackageInfoByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then Data first AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaOtaPackageInfoDao.findOtaPackageInfoByTenantId(TenantId, PageLink)"
  })
  public void testFindOtaPackageInfoByTenantId_thenDataFirstAdditionalInfoReturnObjectNode() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.randomUUID());
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    ArrayList<OtaPackageInfoEntity> content = new ArrayList<>();
    content.add(otaPackageInfoEntity);
    when(otaPackageInfoRepository.findAllByTenantId(
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
    PageData<OtaPackageInfo> actualFindOtaPackageInfoByTenantIdResult =
        jpaOtaPackageInfoDao.findOtaPackageInfoByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(otaPackageInfoRepository)
        .findAllByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<OtaPackageInfo> data = actualFindOtaPackageInfoByTenantIdResult.getData();
    assertEquals(1, data.size());
    OtaPackageInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("1.0.2", getResult.getVersion());
    assertEquals("Checksum", getResult.getChecksum());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Tag", getResult.getTag());
    assertEquals("foo.txt", getResult.getFileName());
    assertEquals("https://example.org/example", getResult.getUrl());
    assertEquals("text/plain", getResult.getContentType());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindOtaPackageInfoByTenantIdResult.getTotalElements());
    assertEquals(3L, getResult.getDataSize().longValue());
    assertEquals(ChecksumAlgorithm.MD5, getResult.getChecksumAlgorithm());
    assertEquals(OtaPackageType.FIRMWARE, getResult.getType());
    assertTrue(getResult.hasUrl());
    assertTrue(getResult.isHasData());
  }

  /**
   * Test {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaOtaPackageInfoDao.findOtaPackageInfoByTenantId(TenantId, PageLink)"
  })
  public void testFindOtaPackageInfoByTenantId_thenReturnDataFirstTenantIdIsSys_tenant_id() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    ArrayList<OtaPackageInfoEntity> content = new ArrayList<>();
    content.add(otaPackageInfoEntity);
    when(otaPackageInfoRepository.findAllByTenantId(
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
    PageData<OtaPackageInfo> actualFindOtaPackageInfoByTenantIdResult =
        jpaOtaPackageInfoDao.findOtaPackageInfoByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(otaPackageInfoRepository)
        .findAllByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<OtaPackageInfo> data = actualFindOtaPackageInfoByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(TenantId.SYS_TENANT_ID, data.get(0).getTenantId());
  }

  /**
   * Test {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaOtaPackageInfoDao.findOtaPackageInfoByTenantId(TenantId, PageLink)"
  })
  public void testFindOtaPackageInfoByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(otaPackageInfoRepository.findAllByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<OtaPackageInfo> actualFindOtaPackageInfoByTenantIdResult =
        jpaOtaPackageInfoDao.findOtaPackageInfoByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(otaPackageInfoRepository)
        .findAllByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindOtaPackageInfoByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindOtaPackageInfoByTenantIdResult.getTotalPages());
    assertFalse(actualFindOtaPackageInfoByTenantIdResult.hasNext());
    assertTrue(actualFindOtaPackageInfoByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link
   * JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaOtaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData() {
    // Arrange
    when(otaPackageInfoRepository.findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<OtaPackageInfo>
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult =
            jpaOtaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                ModelConstants.SYSTEM_TENANT,
                new DeviceProfileId(ModelConstants.NULL_UUID),
                OtaPackageType.FIRMWARE,
                BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(otaPackageInfoRepository)
        .findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(
            isA(UUID.class),
            isA(UUID.class),
            eq(OtaPackageType.FIRMWARE),
            isNull(),
            isA(Pageable.class));
    assertEquals(
        0L,
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult
            .getTotalElements());
    assertEquals(
        1,
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult
            .getTotalPages());
    assertFalse(
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.hasNext());
    assertTrue(
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult
            .getData()
            .isEmpty());
  }

  /**
   * Test {@link
   * JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaOtaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData2() {
    // Arrange
    when(otaPackageInfoRepository.findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<OtaPackageInfo>
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult =
            jpaOtaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                ModelConstants.SYSTEM_TENANT,
                deviceProfileId,
                OtaPackageType.FIRMWARE,
                BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceProfileId).getId();
    verify(otaPackageInfoRepository)
        .findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(
            isA(UUID.class),
            isA(UUID.class),
            eq(OtaPackageType.FIRMWARE),
            isNull(),
            isA(Pageable.class));
    assertEquals(
        0L,
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult
            .getTotalElements());
    assertEquals(
        1,
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult
            .getTotalPages());
    assertFalse(
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.hasNext());
    assertTrue(
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult
            .getData()
            .isEmpty());
  }

  /**
   * Test {@link
   * JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaOtaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData3() {
    // Arrange
    when(otaPackageInfoRepository.findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<OtaPackageInfo>
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult =
            jpaOtaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                ModelConstants.SYSTEM_TENANT, deviceProfileId, OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(deviceProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(otaPackageInfoRepository)
        .findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(
            isA(UUID.class),
            isA(UUID.class),
            eq(OtaPackageType.FIRMWARE),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(
        0L,
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult
            .getTotalElements());
    assertEquals(
        1,
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult
            .getTotalPages());
    assertFalse(
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.hasNext());
    assertTrue(
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult
            .getData()
            .isEmpty());
  }

  /**
   * Test {@link
   * JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaOtaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData4() {
    // Arrange
    when(otaPackageInfoRepository.findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<OtaPackageInfo>
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult =
            jpaOtaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                tenantId, deviceProfileId, OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(deviceProfileId).getId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(otaPackageInfoRepository)
        .findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(
            isA(UUID.class),
            isA(UUID.class),
            eq(OtaPackageType.FIRMWARE),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(
        0L,
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult
            .getTotalElements());
    assertEquals(
        1,
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult
            .getTotalPages());
    assertFalse(
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.hasNext());
    assertTrue(
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult
            .getData()
            .isEmpty());
  }

  /**
   * Test {@link
   * JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaOtaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData5() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    ArrayList<OtaPackageInfoEntity> content = new ArrayList<>();
    content.add(otaPackageInfoEntity);
    when(otaPackageInfoRepository.findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<OtaPackageInfo>
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult =
            jpaOtaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                tenantId, deviceProfileId, OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(deviceProfileId).getId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(otaPackageInfoRepository)
        .findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(
            isA(UUID.class),
            isA(UUID.class),
            eq(OtaPackageType.FIRMWARE),
            eq("Text Search"),
            isA(Pageable.class));
    List<OtaPackageInfo> data =
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.getData();
    assertEquals(1, data.size());
    assertSame(TenantId.SYS_TENANT_ID, data.get(0).getTenantId());
  }

  /**
   * Test {@link
   * JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaOtaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData6() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.randomUUID());
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    ArrayList<OtaPackageInfoEntity> content = new ArrayList<>();
    content.add(otaPackageInfoEntity);
    when(otaPackageInfoRepository.findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<OtaPackageInfo>
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult =
            jpaOtaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                tenantId, deviceProfileId, OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(deviceProfileId).getId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(otaPackageInfoRepository)
        .findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(
            isA(UUID.class),
            isA(UUID.class),
            eq(OtaPackageType.FIRMWARE),
            eq("Text Search"),
            isA(Pageable.class));
    List<OtaPackageInfo> data =
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.getData();
    assertEquals(1, data.size());
    OtaPackageInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("1.0.2", getResult.getVersion());
    assertEquals("Checksum", getResult.getChecksum());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Tag", getResult.getTag());
    assertEquals("foo.txt", getResult.getFileName());
    assertEquals("https://example.org/example", getResult.getUrl());
    assertEquals("text/plain", getResult.getContentType());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(
        1L,
        actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult
            .getTotalElements());
    assertEquals(3L, getResult.getDataSize().longValue());
    assertEquals(ChecksumAlgorithm.MD5, getResult.getChecksumAlgorithm());
    assertEquals(OtaPackageType.FIRMWARE, getResult.getType());
    assertTrue(getResult.hasUrl());
    assertTrue(getResult.isHasData());
  }

  /**
   * Test {@link JpaOtaPackageInfoDao#isOtaPackageUsed(OtaPackageId, OtaPackageType,
   * DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JpaOtaPackageInfoDao#isOtaPackageUsed(OtaPackageId,
   * OtaPackageType, DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaOtaPackageInfoDao.isOtaPackageUsed(OtaPackageId, OtaPackageType, DeviceProfileId)"
  })
  public void testIsOtaPackageUsed_thenReturnFalse() {
    // Arrange
    when(otaPackageInfoRepository.isOtaPackageUsed(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(false);

    OtaPackageId otaPackageId = mock(OtaPackageId.class);
    when(otaPackageId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualIsOtaPackageUsedResult =
        jpaOtaPackageInfoDao.isOtaPackageUsed(
            otaPackageId, OtaPackageType.FIRMWARE, deviceProfileId);

    // Assert
    verify(deviceProfileId).getId();
    verify(otaPackageId).getId();
    verify(otaPackageInfoRepository)
        .isOtaPackageUsed(isA(UUID.class), isA(UUID.class), eq("FIRMWARE"));
    assertFalse(actualIsOtaPackageUsedResult);
  }

  /**
   * Test {@link JpaOtaPackageInfoDao#isOtaPackageUsed(OtaPackageId, OtaPackageType,
   * DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaOtaPackageInfoDao#isOtaPackageUsed(OtaPackageId,
   * OtaPackageType, DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaOtaPackageInfoDao.isOtaPackageUsed(OtaPackageId, OtaPackageType, DeviceProfileId)"
  })
  public void testIsOtaPackageUsed_thenReturnTrue() {
    // Arrange
    when(otaPackageInfoRepository.isOtaPackageUsed(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(true);

    OtaPackageId otaPackageId = mock(OtaPackageId.class);
    when(otaPackageId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualIsOtaPackageUsedResult =
        jpaOtaPackageInfoDao.isOtaPackageUsed(
            otaPackageId, OtaPackageType.FIRMWARE, deviceProfileId);

    // Assert
    verify(deviceProfileId).getId();
    verify(otaPackageId).getId();
    verify(otaPackageInfoRepository)
        .isOtaPackageUsed(isA(UUID.class), isA(UUID.class), eq("FIRMWARE"));
    assertTrue(actualIsOtaPackageUsedResult);
  }

  /**
   * Test {@link JpaOtaPackageInfoDao#isOtaPackageUsed(OtaPackageId, OtaPackageType,
   * DeviceProfileId)}.
   *
   * <ul>
   *   <li>When {@link DeviceProfileId#DeviceProfileId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaOtaPackageInfoDao#isOtaPackageUsed(OtaPackageId,
   * OtaPackageType, DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaOtaPackageInfoDao.isOtaPackageUsed(OtaPackageId, OtaPackageType, DeviceProfileId)"
  })
  public void testIsOtaPackageUsed_whenDeviceProfileIdWithIdIsNull_uuid_thenReturnTrue() {
    // Arrange
    when(otaPackageInfoRepository.isOtaPackageUsed(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(true);

    OtaPackageId otaPackageId = mock(OtaPackageId.class);
    when(otaPackageId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualIsOtaPackageUsedResult =
        jpaOtaPackageInfoDao.isOtaPackageUsed(
            otaPackageId, OtaPackageType.FIRMWARE, new DeviceProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(otaPackageId).getId();
    verify(otaPackageInfoRepository)
        .isOtaPackageUsed(isA(UUID.class), isA(UUID.class), eq("FIRMWARE"));
    assertTrue(actualIsOtaPackageUsedResult);
  }
}
