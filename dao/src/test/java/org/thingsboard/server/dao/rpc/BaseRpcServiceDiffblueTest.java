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
package org.thingsboard.server.dao.rpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Optional;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.RpcId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.rpc.Rpc;
import org.thingsboard.server.common.data.rpc.RpcStatus;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.rpc.JpaRpcDao;
import org.thingsboard.server.dao.sql.rpc.RpcRepository;

@ContextConfiguration(classes = {BaseRpcService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseRpcServiceDiffblueTest {
  @Autowired private BaseRpcService baseRpcService;

  @MockBean private RpcDao rpcDao;

  /**
   * Test {@link BaseRpcService#save(Rpc)}.
   *
   * <ul>
   *   <li>When {@link Rpc#Rpc()}.
   *   <li>Then return {@link Rpc#Rpc()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#save(Rpc)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Rpc BaseRpcService.save(Rpc)"})
  public void testSave_whenRpc_thenReturnRpc() {
    // Arrange
    Rpc rpc = new Rpc();
    when(rpcDao.save(Mockito.<TenantId>any(), Mockito.<Rpc>any())).thenReturn(rpc);

    // Act
    Rpc actualSaveResult = baseRpcService.save(new Rpc());

    // Assert
    verify(rpcDao).save(isNull(), isA(Rpc.class));
    assertSame(rpc, actualSaveResult);
  }

  /**
   * Test {@link BaseRpcService#deleteRpc(TenantId, RpcId)}.
   *
   * <ul>
   *   <li>Given {@link RpcDao} {@link RpcDao#removeById(TenantId, UUID)} does nothing.
   *   <li>Then calls {@link RpcDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#deleteRpc(TenantId, RpcId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRpcService.deleteRpc(TenantId, RpcId)"})
  public void testDeleteRpc_givenRpcDaoRemoveByIdDoesNothing_thenCallsRemoveById() {
    // Arrange
    doNothing().when(rpcDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    baseRpcService.deleteRpc(ModelConstants.SYSTEM_TENANT, new RpcId(ModelConstants.NULL_UUID));

    // Assert
    verify(rpcDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRpcService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link RpcDao} {@link RpcDao#removeById(TenantId, UUID)} does nothing.
   *   <li>Then calls {@link RpcDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRpcService.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_givenRpcDaoRemoveByIdDoesNothing_thenCallsRemoveById() {
    // Arrange
    doNothing().when(rpcDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    baseRpcService.deleteEntity(
        ModelConstants.SYSTEM_TENANT, new RpcId(ModelConstants.NULL_UUID), true);

    // Assert
    verify(rpcDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRpcService#deleteAllRpcByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link RpcDao#findAllRpcByTenantId(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#deleteAllRpcByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRpcService.deleteAllRpcByTenantId(TenantId)"})
  public void testDeleteAllRpcByTenantId_thenCallsFindAllRpcByTenantId() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllRpcByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseRpcService.deleteAllRpcByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(rpcDao).findAllRpcByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRpcService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link RpcDao#findAllRpcByTenantId(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRpcService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsFindAllRpcByTenantId() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllRpcByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseRpcService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(rpcDao).findAllRpcByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRpcService#findById(TenantId, RpcId)}.
   *
   * <ul>
   *   <li>Given {@link RpcDao} {@link RpcDao#findById(TenantId, UUID)} return {@link Rpc#Rpc()}.
   *   <li>Then return {@link Rpc#Rpc()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findById(TenantId, RpcId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Rpc BaseRpcService.findById(TenantId, RpcId)"})
  public void testFindById_givenRpcDaoFindByIdReturnRpc_thenReturnRpc() {
    // Arrange
    Rpc rpc = new Rpc();
    when(rpcDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(rpc);

    // Act
    Rpc actualFindByIdResult =
        baseRpcService.findById(ModelConstants.SYSTEM_TENANT, new RpcId(ModelConstants.NULL_UUID));

    // Assert
    verify(rpcDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(rpc, actualFindByIdResult);
  }

  /**
   * Test {@link BaseRpcService#findRpcByIdAsync(TenantId, RpcId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findRpcByIdAsync(TenantId, RpcId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseRpcService.findRpcByIdAsync(TenantId, RpcId)"})
  public void testFindRpcByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Rpc> createResult = SettableFuture.create();
    when(rpcDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Rpc> actualFindRpcByIdAsyncResult =
        baseRpcService.findRpcByIdAsync(
            ModelConstants.SYSTEM_TENANT, new RpcId(ModelConstants.NULL_UUID));

    // Assert
    verify(rpcDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindRpcByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindRpcByIdAsyncResult);
  }

  /**
   * Test {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId,
   * RpcStatus, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRpcService.findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)"
  })
  public void testFindAllByDeviceIdAndStatus_givenBy_created_time_desc_thenCallsGetPage() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceIdAndStatus(
            Mockito.<TenantId>any(),
            Mockito.<DeviceId>any(),
            Mockito.<RpcStatus>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult =
        baseRpcService.findAllByDeviceIdAndStatus(
            ModelConstants.SYSTEM_TENANT, null, RpcStatus.QUEUED, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(rpcDao)
        .findAllByDeviceIdAndStatus(
            isA(TenantId.class), isNull(), eq(RpcStatus.QUEUED), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllByDeviceIdAndStatusResult);
  }

  /**
   * Test {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId,
   * RpcStatus, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRpcService.findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)"
  })
  public void testFindAllByDeviceIdAndStatus_thenCallsGetProperty() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceIdAndStatus(
            Mockito.<TenantId>any(),
            Mockito.<DeviceId>any(),
            Mockito.<RpcStatus>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult =
        baseRpcService.findAllByDeviceIdAndStatus(
            ModelConstants.SYSTEM_TENANT, null, RpcStatus.QUEUED, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(rpcDao)
        .findAllByDeviceIdAndStatus(
            isA(TenantId.class), isNull(), eq(RpcStatus.QUEUED), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllByDeviceIdAndStatusResult);
  }

  /**
   * Test {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId,
   * RpcStatus, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRpcService.findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)"
  })
  public void testFindAllByDeviceIdAndStatus_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceIdAndStatus(
            Mockito.<TenantId>any(),
            Mockito.<DeviceId>any(),
            Mockito.<RpcStatus>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult =
        baseRpcService.findAllByDeviceIdAndStatus(
            ModelConstants.SYSTEM_TENANT,
            null,
            RpcStatus.QUEUED,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(rpcDao)
        .findAllByDeviceIdAndStatus(
            isA(TenantId.class), isNull(), eq(RpcStatus.QUEUED), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllByDeviceIdAndStatusResult);
  }

  /**
   * Test {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseRpcService.findAllByDeviceId(TenantId, DeviceId, PageLink)"})
  public void testFindAllByDeviceId_givenBy_created_time_desc_thenCallsGetPage() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult =
        baseRpcService.findAllByDeviceId(ModelConstants.SYSTEM_TENANT, null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(rpcDao).findAllByDeviceId(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllByDeviceIdResult);
  }

  /**
   * Test {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseRpcService.findAllByDeviceId(TenantId, DeviceId, PageLink)"})
  public void testFindAllByDeviceId_thenCallsGetProperty() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult =
        baseRpcService.findAllByDeviceId(ModelConstants.SYSTEM_TENANT, null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(rpcDao).findAllByDeviceId(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllByDeviceIdResult);
  }

  /**
   * Test {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseRpcService.findAllByDeviceId(TenantId, DeviceId, PageLink)"})
  public void testFindAllByDeviceId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult =
        baseRpcService.findAllByDeviceId(
            ModelConstants.SYSTEM_TENANT, null, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(rpcDao).findAllByDeviceId(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllByDeviceIdResult);
  }

  /**
   * Test {@link BaseRpcService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RpcDao} {@link RpcDao#findById(TenantId, UUID)} return {@link Rpc#Rpc()}.
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseRpcService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenRpcDaoFindByIdReturnRpc_whenSystem_tenant_thenReturnPresent() {
    // Arrange
    Rpc rpc = new Rpc();
    when(rpcDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(rpc);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        baseRpcService.findEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(rpcDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(rpc, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseRpcService#getEntityType()}.
   *
   * <p>Method under test: {@link BaseRpcService#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType BaseRpcService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    JpaRpcDao rpcDao = new JpaRpcDao(mock(RpcRepository.class));

    // Act and Assert
    assertEquals(EntityType.RPC, new BaseRpcService(rpcDao).getEntityType());
  }
}
