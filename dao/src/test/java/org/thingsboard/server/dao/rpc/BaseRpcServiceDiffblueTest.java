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
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Optional;
import java.util.UUID;
import org.junit.Test;
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
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.rpc.JpaRpcDao;
import org.thingsboard.server.dao.sql.rpc.RpcRepository;

@ContextConfiguration(classes = {BaseRpcService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class BaseRpcServiceDiffblueTest {
  @Autowired
  private BaseRpcService baseRpcService;

  @MockBean
  private RpcDao rpcDao;

  /**
   * Test {@link BaseRpcService#save(Rpc)}.
   * <ul>
   *   <li>When {@link Rpc#Rpc()}.</li>
   *   <li>Then return {@link Rpc#Rpc()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRpcService#save(Rpc)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRpcService#deleteRpc(TenantId, RpcId)}
   */
  @Test
  public void testDeleteRpc_whenSystem_tenant_thenCallsRemoveById() {
    // Arrange
    doNothing().when(rpcDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    baseRpcService.deleteRpc(ModelConstants.SYSTEM_TENANT, new RpcId(ModelConstants.NULL_UUID));

    // Assert that nothing has changed
    verify(rpcDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRpcService#deleteAllRpcByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls {@link RpcDao#findAllRpcByTenantId(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRpcService#deleteAllRpcByTenantId(TenantId)}
   */
  @Test
  public void testDeleteAllRpcByTenantId_thenCallsFindAllRpcByTenantId() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllRpcByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    baseRpcService.deleteAllRpcByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(rpcDao).findAllRpcByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRpcService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls {@link RpcDao#findAllRpcByTenantId(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRpcService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenCallsFindAllRpcByTenantId() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllRpcByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    baseRpcService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(rpcDao).findAllRpcByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRpcService#findById(TenantId, RpcId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link Rpc#Rpc()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRpcService#findById(TenantId, RpcId)}
   */
  @Test
  public void testFindById_whenSystem_tenant_thenReturnRpc() {
    // Arrange
    Rpc rpc = new Rpc();
    when(rpcDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(rpc);

    // Act
    Rpc actualFindByIdResult = baseRpcService.findById(ModelConstants.SYSTEM_TENANT,
        new RpcId(ModelConstants.NULL_UUID));

    // Assert
    verify(rpcDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(rpc, actualFindByIdResult);
  }

  /**
   * Test {@link BaseRpcService#findRpcByIdAsync(TenantId, RpcId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRpcService#findRpcByIdAsync(TenantId, RpcId)}
   */
  @Test
  public void testFindRpcByIdAsync_whenSystem_tenant_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Rpc> createResult = SettableFuture.create();
    when(rpcDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Rpc> actualFindRpcByIdAsyncResult = baseRpcService.findRpcByIdAsync(ModelConstants.SYSTEM_TENANT,
        new RpcId(ModelConstants.NULL_UUID));

    // Assert
    verify(rpcDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindRpcByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindRpcByIdAsyncResult);
  }

  /**
   * Test
   * {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}
   */
  @Test
  public void testFindAllByDeviceIdAndStatus() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceIdAndStatus(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<RpcStatus>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult = baseRpcService
        .findAllByDeviceIdAndStatus(ModelConstants.SYSTEM_TENANT, null, RpcStatus.QUEUED, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(rpcDao).findAllByDeviceIdAndStatus(isA(TenantId.class), isNull(), eq(RpcStatus.QUEUED), isA(PageLink.class));
    assertSame(actualFindAllByDeviceIdAndStatusResult.EMPTY_PAGE_DATA, actualFindAllByDeviceIdAndStatusResult);
  }

  /**
   * Test
   * {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}.
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}
   */
  @Test
  public void testFindAllByDeviceIdAndStatus_thenCallsGetPage() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceIdAndStatus(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<RpcStatus>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult = baseRpcService
        .findAllByDeviceIdAndStatus(ModelConstants.SYSTEM_TENANT, null, RpcStatus.QUEUED, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(rpcDao).findAllByDeviceIdAndStatus(isA(TenantId.class), isNull(), eq(RpcStatus.QUEUED), isA(PageLink.class));
    assertSame(actualFindAllByDeviceIdAndStatusResult.EMPTY_PAGE_DATA, actualFindAllByDeviceIdAndStatusResult);
  }

  /**
   * Test
   * {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}
   */
  @Test
  public void testFindAllByDeviceIdAndStatus_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceIdAndStatus(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<RpcStatus>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult = baseRpcService.findAllByDeviceIdAndStatus(
        ModelConstants.SYSTEM_TENANT, null, RpcStatus.QUEUED, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(rpcDao).findAllByDeviceIdAndStatus(isA(TenantId.class), isNull(), eq(RpcStatus.QUEUED), isA(PageLink.class));
    assertSame(actualFindAllByDeviceIdAndStatusResult.EMPTY_PAGE_DATA, actualFindAllByDeviceIdAndStatusResult);
  }

  /**
   * Test {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with property is empty string and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  public void testFindAllByDeviceId_givenSortOrderWithPropertyIsEmptyStringAndDirectionIsAsc() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult = baseRpcService.findAllByDeviceId(ModelConstants.SYSTEM_TENANT, null,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(rpcDao).findAllByDeviceId(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(actualFindAllByDeviceIdResult.EMPTY_PAGE_DATA, actualFindAllByDeviceIdResult);
  }

  /**
   * Test {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  public void testFindAllByDeviceId_thenCallsGetPage() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult = baseRpcService.findAllByDeviceId(ModelConstants.SYSTEM_TENANT, null,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(rpcDao).findAllByDeviceId(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(actualFindAllByDeviceIdResult.EMPTY_PAGE_DATA, actualFindAllByDeviceIdResult);
  }

  /**
   * Test {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  public void testFindAllByDeviceId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult = baseRpcService.findAllByDeviceId(ModelConstants.SYSTEM_TENANT, null,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(rpcDao).findAllByDeviceId(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(actualFindAllByDeviceIdResult.EMPTY_PAGE_DATA, actualFindAllByDeviceIdResult);
  }

  /**
   * Test {@link BaseRpcService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRpcService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    Rpc rpc = new Rpc();
    when(rpcDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(rpc);

    // Act
    Optional<HasId<?>> actualFindEntityResult = baseRpcService.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(rpcDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(rpc, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseRpcService#getEntityType()}.
   * <p>
   * Method under test: {@link BaseRpcService#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.RPC, (new BaseRpcService(new JpaRpcDao(mock(RpcRepository.class)))).getEntityType());
  }
}
