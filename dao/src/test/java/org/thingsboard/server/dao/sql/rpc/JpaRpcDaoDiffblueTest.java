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
package org.thingsboard.server.dao.sql.rpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import com.fasterxml.jackson.databind.JsonNode;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.rpc.Rpc;
import org.thingsboard.server.common.data.rpc.RpcStatus;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.RpcEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaRpcDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaRpcDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaRpcDao jpaRpcDao;

  @MockBean private RpcRepository rpcRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaRpcDao#getEntityClass()}
   *   <li>{@link JpaRpcDao#getEntityType()}
   *   <li>{@link JpaRpcDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaRpcDao.getEntityClass()",
    "EntityType JpaRpcDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaRpcDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaRpcDao jpaRpcDao = new JpaRpcDao(mock(RpcRepository.class));

    // Act
    Class<RpcEntity> actualEntityClass = jpaRpcDao.getEntityClass();
    EntityType actualEntityType = jpaRpcDao.getEntityType();
    jpaRpcDao.getRepository();

    // Assert
    assertEquals(EntityType.RPC, actualEntityType);
    Class<RpcEntity> expectedEntityClass = RpcEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRpcDao.findAllByDeviceId(TenantId, DeviceId, PageLink)"})
  public void testFindAllByDeviceId_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(rpcRepository.findAllByTenantIdAndDeviceId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult =
        jpaRpcDao.findAllByDeviceId(tenantId, deviceId, pageLink);

    // Assert
    verify(deviceId).getId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(rpcRepository)
        .findAllByTenantIdAndDeviceId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdResult.hasNext());
    assertTrue(actualFindAllByDeviceIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   *
   * <ul>
   *   <li>Then Data first AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRpcDao.findAllByDeviceId(TenantId, DeviceId, PageLink)"})
  public void testFindAllByDeviceId_thenDataFirstAdditionalInfoReturnObjectNode() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.randomUUID());
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RpcEntity> content = new ArrayList<>();
    content.add(rpcEntity);
    when(rpcRepository.findAllByTenantIdAndDeviceId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult =
        jpaRpcDao.findAllByDeviceId(tenantId, deviceId, pageLink);

    // Assert
    verify(deviceId).getId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(rpcRepository)
        .findAllByTenantIdAndDeviceId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    List<Rpc> data = actualFindAllByDeviceIdResult.getData();
    assertEquals(1, data.size());
    Rpc getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals(1L, actualFindAllByDeviceIdResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, getResult.getExpirationTime());
    assertEquals(RpcStatus.QUEUED, getResult.getStatus());
    assertSame(additionalInfo, getResult.getRequest());
    assertSame(additionalInfo, getResult.getResponse());
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRpcDao.findAllByDeviceId(TenantId, DeviceId, PageLink)"})
  public void testFindAllByDeviceId_thenReturnDataFirstTenantIdIsSys_tenant_id() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RpcEntity> content = new ArrayList<>();
    content.add(rpcEntity);
    when(rpcRepository.findAllByTenantIdAndDeviceId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult =
        jpaRpcDao.findAllByDeviceId(tenantId, deviceId, pageLink);

    // Assert
    verify(deviceId).getId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(rpcRepository)
        .findAllByTenantIdAndDeviceId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    List<Rpc> data = actualFindAllByDeviceIdResult.getData();
    assertEquals(1, data.size());
    assertSame(TenantId.SYS_TENANT_ID, data.get(0).getTenantId());
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRpcDao.findAllByDeviceId(TenantId, DeviceId, PageLink)"})
  public void testFindAllByDeviceId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(rpcRepository.findAllByTenantIdAndDeviceId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult =
        jpaRpcDao.findAllByDeviceId(
            tenantId, new DeviceId(ModelConstants.NULL_UUID), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(rpcRepository)
        .findAllByTenantIdAndDeviceId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdResult.hasNext());
    assertTrue(actualFindAllByDeviceIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRpcDao.findAllByDeviceId(TenantId, DeviceId, PageLink)"})
  public void testFindAllByDeviceId_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(rpcRepository.findAllByTenantIdAndDeviceId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult =
        jpaRpcDao.findAllByDeviceId(tenantId, deviceId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceId).getId();
    verify(tenantId).getId();
    verify(rpcRepository)
        .findAllByTenantIdAndDeviceId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdResult.hasNext());
    assertTrue(actualFindAllByDeviceIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRpcDao.findAllByDeviceId(TenantId, DeviceId, PageLink)"})
  public void testFindAllByDeviceId_whenSystem_tenant_thenReturnTotalElementsIsZero() {
    // Arrange
    when(rpcRepository.findAllByTenantIdAndDeviceId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult =
        jpaRpcDao.findAllByDeviceId(
            ModelConstants.SYSTEM_TENANT,
            new DeviceId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(rpcRepository)
        .findAllByTenantIdAndDeviceId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdResult.hasNext());
    assertTrue(actualFindAllByDeviceIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId,
   * RpcStatus, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRpcDao.findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)"
  })
  public void testFindAllByDeviceIdAndStatus_givenNull_thenCallsGetPage() {
    // Arrange
    when(rpcRepository.findAllByTenantIdAndDeviceIdAndStatus(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<RpcStatus>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult =
        jpaRpcDao.findAllByDeviceIdAndStatus(tenantId, deviceId, RpcStatus.QUEUED, pageLink);

    // Assert
    verify(deviceId).getId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(rpcRepository)
        .findAllByTenantIdAndDeviceIdAndStatus(
            isA(UUID.class), isA(UUID.class), eq(RpcStatus.QUEUED), isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdAndStatusResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdAndStatusResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdAndStatusResult.hasNext());
    assertTrue(actualFindAllByDeviceIdAndStatusResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId,
   * RpcStatus, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRpcDao.findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)"
  })
  public void testFindAllByDeviceIdAndStatus_givenNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(rpcRepository.findAllByTenantIdAndDeviceIdAndStatus(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<RpcStatus>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult =
        jpaRpcDao.findAllByDeviceIdAndStatus(
            tenantId,
            new DeviceId(ModelConstants.NULL_UUID),
            RpcStatus.QUEUED,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(rpcRepository)
        .findAllByTenantIdAndDeviceIdAndStatus(
            isA(UUID.class), isA(UUID.class), eq(RpcStatus.QUEUED), isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdAndStatusResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdAndStatusResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdAndStatusResult.hasNext());
    assertTrue(actualFindAllByDeviceIdAndStatusResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}.
   *
   * <ul>
   *   <li>Then Data first AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId,
   * RpcStatus, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRpcDao.findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)"
  })
  public void testFindAllByDeviceIdAndStatus_thenDataFirstAdditionalInfoReturnObjectNode() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.randomUUID());
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RpcEntity> content = new ArrayList<>();
    content.add(rpcEntity);
    when(rpcRepository.findAllByTenantIdAndDeviceIdAndStatus(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<RpcStatus>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult =
        jpaRpcDao.findAllByDeviceIdAndStatus(tenantId, deviceId, RpcStatus.QUEUED, pageLink);

    // Assert
    verify(deviceId).getId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(rpcRepository)
        .findAllByTenantIdAndDeviceIdAndStatus(
            isA(UUID.class), isA(UUID.class), eq(RpcStatus.QUEUED), isA(Pageable.class));
    List<Rpc> data = actualFindAllByDeviceIdAndStatusResult.getData();
    assertEquals(1, data.size());
    Rpc getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals(1L, actualFindAllByDeviceIdAndStatusResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, getResult.getExpirationTime());
    assertEquals(RpcStatus.QUEUED, getResult.getStatus());
    assertSame(additionalInfo, getResult.getRequest());
    assertSame(additionalInfo, getResult.getResponse());
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId,
   * RpcStatus, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRpcDao.findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)"
  })
  public void testFindAllByDeviceIdAndStatus_thenReturnDataFirstTenantIdIsSys_tenant_id() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RpcEntity> content = new ArrayList<>();
    content.add(rpcEntity);
    when(rpcRepository.findAllByTenantIdAndDeviceIdAndStatus(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<RpcStatus>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult =
        jpaRpcDao.findAllByDeviceIdAndStatus(tenantId, deviceId, RpcStatus.QUEUED, pageLink);

    // Assert
    verify(deviceId).getId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(rpcRepository)
        .findAllByTenantIdAndDeviceIdAndStatus(
            isA(UUID.class), isA(UUID.class), eq(RpcStatus.QUEUED), isA(Pageable.class));
    List<Rpc> data = actualFindAllByDeviceIdAndStatusResult.getData();
    assertEquals(1, data.size());
    assertSame(TenantId.SYS_TENANT_ID, data.get(0).getTenantId());
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId,
   * RpcStatus, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRpcDao.findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)"
  })
  public void testFindAllByDeviceIdAndStatus_thenReturnTotalElementsIsZero() {
    // Arrange
    when(rpcRepository.findAllByTenantIdAndDeviceIdAndStatus(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<RpcStatus>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult =
        jpaRpcDao.findAllByDeviceIdAndStatus(
            tenantId, deviceId, RpcStatus.QUEUED, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceId).getId();
    verify(tenantId).getId();
    verify(rpcRepository)
        .findAllByTenantIdAndDeviceIdAndStatus(
            isA(UUID.class), isA(UUID.class), eq(RpcStatus.QUEUED), isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdAndStatusResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdAndStatusResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdAndStatusResult.hasNext());
    assertTrue(actualFindAllByDeviceIdAndStatusResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId,
   * RpcStatus, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRpcDao.findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)"
  })
  public void testFindAllByDeviceIdAndStatus_whenSystem_tenant_thenReturnTotalElementsIsZero() {
    // Arrange
    when(rpcRepository.findAllByTenantIdAndDeviceIdAndStatus(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<RpcStatus>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult =
        jpaRpcDao.findAllByDeviceIdAndStatus(
            ModelConstants.SYSTEM_TENANT,
            new DeviceId(ModelConstants.NULL_UUID),
            RpcStatus.QUEUED,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(rpcRepository)
        .findAllByTenantIdAndDeviceIdAndStatus(
            isA(UUID.class), isA(UUID.class), eq(RpcStatus.QUEUED), isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdAndStatusResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdAndStatusResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdAndStatusResult.hasNext());
    assertTrue(actualFindAllByDeviceIdAndStatusResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRpcDao.findAllRpcByTenantId(TenantId, PageLink)"})
  public void testFindAllRpcByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(rpcRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
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

    // Act
    PageData<Rpc> actualFindAllRpcByTenantIdResult =
        jpaRpcDao.findAllRpcByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(rpcRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllRpcByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllRpcByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllRpcByTenantIdResult.hasNext());
    assertTrue(actualFindAllRpcByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then Data first AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRpcDao.findAllRpcByTenantId(TenantId, PageLink)"})
  public void testFindAllRpcByTenantId_thenDataFirstAdditionalInfoReturnObjectNode() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.randomUUID());
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RpcEntity> content = new ArrayList<>();
    content.add(rpcEntity);
    when(rpcRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Rpc> actualFindAllRpcByTenantIdResult =
        jpaRpcDao.findAllRpcByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(rpcRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    List<Rpc> data = actualFindAllRpcByTenantIdResult.getData();
    assertEquals(1, data.size());
    Rpc getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals(1L, actualFindAllRpcByTenantIdResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, getResult.getExpirationTime());
    assertEquals(RpcStatus.QUEUED, getResult.getStatus());
    assertSame(additionalInfo, getResult.getRequest());
    assertSame(additionalInfo, getResult.getResponse());
  }

  /**
   * Test {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRpcDao.findAllRpcByTenantId(TenantId, PageLink)"})
  public void testFindAllRpcByTenantId_thenReturnDataFirstTenantIdIsSys_tenant_id() {
    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RpcEntity> content = new ArrayList<>();
    content.add(rpcEntity);
    when(rpcRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Rpc> actualFindAllRpcByTenantIdResult =
        jpaRpcDao.findAllRpcByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(rpcRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    List<Rpc> data = actualFindAllRpcByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(TenantId.SYS_TENANT_ID, data.get(0).getTenantId());
  }

  /**
   * Test {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRpcDao.findAllRpcByTenantId(TenantId, PageLink)"})
  public void testFindAllRpcByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(rpcRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Rpc> actualFindAllRpcByTenantIdResult =
        jpaRpcDao.findAllRpcByTenantId(tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(rpcRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllRpcByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllRpcByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllRpcByTenantIdResult.hasNext());
    assertTrue(actualFindAllRpcByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRpcDao.findAllRpcByTenantId(TenantId, PageLink)"})
  public void testFindAllRpcByTenantId_whenSystem_tenant_thenReturnTotalElementsIsZero() {
    // Arrange
    when(rpcRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Rpc> actualFindAllRpcByTenantIdResult =
        jpaRpcDao.findAllRpcByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(rpcRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllRpcByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllRpcByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllRpcByTenantIdResult.hasNext());
    assertTrue(actualFindAllRpcByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#deleteOutdatedRpcByTenantId(TenantId, Long)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#deleteOutdatedRpcByTenantId(TenantId, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JpaRpcDao.deleteOutdatedRpcByTenantId(TenantId, Long)"})
  public void testDeleteOutdatedRpcByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(rpcRepository.deleteOutdatedRpcByTenantId(Mockito.<UUID>any(), Mockito.<Long>any()))
        .thenReturn(1);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    int actualDeleteOutdatedRpcByTenantIdResult =
        jpaRpcDao.deleteOutdatedRpcByTenantId(tenantId, 1L);

    // Assert
    verify(tenantId).getId();
    verify(rpcRepository).deleteOutdatedRpcByTenantId(isA(UUID.class), eq(1L));
    assertEquals(1, actualDeleteOutdatedRpcByTenantIdResult);
  }

  /**
   * Test {@link JpaRpcDao#deleteOutdatedRpcByTenantId(TenantId, Long)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JpaRpcDao#deleteOutdatedRpcByTenantId(TenantId, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JpaRpcDao.deleteOutdatedRpcByTenantId(TenantId, Long)"})
  public void testDeleteOutdatedRpcByTenantId_whenSystem_tenant_thenReturnOne() {
    // Arrange
    when(rpcRepository.deleteOutdatedRpcByTenantId(Mockito.<UUID>any(), Mockito.<Long>any()))
        .thenReturn(1);

    // Act
    int actualDeleteOutdatedRpcByTenantIdResult =
        jpaRpcDao.deleteOutdatedRpcByTenantId(ModelConstants.SYSTEM_TENANT, 1L);

    // Assert
    verify(rpcRepository).deleteOutdatedRpcByTenantId(isA(UUID.class), eq(1L));
    assertEquals(1, actualDeleteOutdatedRpcByTenantIdResult);
  }
}
