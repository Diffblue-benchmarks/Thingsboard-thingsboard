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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
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
import org.thingsboard.server.common.data.page.SortOrder.Direction;
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseRpcService.deleteRpc(TenantId, RpcId)"})
  public void testDeleteRpc_givenRpcDaoRemoveByIdDoesNothing_thenCallsRemoveById() {
    // Arrange
    doNothing().when(rpcDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    baseRpcService.deleteRpc(
        ModelConstants.SYSTEM_TENANT,
        new RpcId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(rpcDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRpcService#deleteAllRpcByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link RpcDao} {@link RpcDao#findAllRpcByTenantId(TenantId, PageLink)} return
   *       emptyPageData.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#deleteAllRpcByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseRpcService.deleteAllRpcByTenantId(TenantId)"})
  public void testDeleteAllRpcByTenantId_givenRpcDaoFindAllRpcByTenantIdReturnEmptyPageData() {
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
   * Test {@link BaseRpcService#deleteAllRpcByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link RpcDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#deleteAllRpcByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseRpcService.deleteAllRpcByTenantId(TenantId)"})
  public void testDeleteAllRpcByTenantId_thenCallsRemoveById() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setId(new RpcId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<Rpc> data = new ArrayList<>();
    data.add(rpc);
    PageData<Rpc> pageData = new PageData<>(data, 100, 100L, false);

    doNothing().when(rpcDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(rpcDao.findAllRpcByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    baseRpcService.deleteAllRpcByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(rpcDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(rpcDao).findAllRpcByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRpcService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link RpcDao} {@link RpcDao#findAllRpcByTenantId(TenantId, PageLink)} return
   *       emptyPageData.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseRpcService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenRpcDaoFindAllRpcByTenantIdReturnEmptyPageData() {
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
   * Test {@link BaseRpcService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link RpcDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseRpcService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsRemoveById() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setId(new RpcId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<Rpc> data = new ArrayList<>();
    data.add(rpc);
    PageData<Rpc> pageData = new PageData<>(data, 100, 100L, false);

    doNothing().when(rpcDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(rpcDao.findAllRpcByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    baseRpcService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(rpcDao).removeById(isA(TenantId.class), isA(UUID.class));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Rpc BaseRpcService.findById(TenantId, RpcId)"})
  public void testFindById_givenRpcDaoFindByIdReturnRpc_thenReturnRpc() {
    // Arrange
    Rpc rpc = new Rpc();
    when(rpcDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(rpc);

    // Act
    Rpc actualFindByIdResult =
        baseRpcService.findById(
            ModelConstants.SYSTEM_TENANT,
            new RpcId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture BaseRpcService.findRpcByIdAsync(TenantId, RpcId)"})
  public void testFindRpcByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Rpc> createResult = SettableFuture.create();
    when(rpcDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Rpc> actualFindRpcByIdAsyncResult =
        baseRpcService.findRpcByIdAsync(
            ModelConstants.SYSTEM_TENANT,
            new RpcId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId,
   * RpcStatus, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseRpcService.findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)"
  })
  public void testFindAllByDeviceIdAndStatus_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceIdAndStatus(
            Mockito.<TenantId>any(),
            Mockito.<DeviceId>any(),
            Mockito.<RpcStatus>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
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
    assertSame(
        actualFindAllByDeviceIdAndStatusResult.EMPTY_PAGE_DATA,
        actualFindAllByDeviceIdAndStatusResult);
  }

  /**
   * Test {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId,
   * RpcStatus, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseRpcService.findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)"
  })
  public void testFindAllByDeviceIdAndStatus_givenSortOrderWithPropertyIsEmptyString() {
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
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
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
    assertSame(
        actualFindAllByDeviceIdAndStatusResult.EMPTY_PAGE_DATA,
        actualFindAllByDeviceIdAndStatusResult);
  }

  /**
   * Test {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId,
   * RpcStatus, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseRpcService.findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)"
  })
  public void testFindAllByDeviceIdAndStatus_givenSortOrderWithPropertyIsNull() {
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
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
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
    assertSame(
        actualFindAllByDeviceIdAndStatusResult.EMPTY_PAGE_DATA,
        actualFindAllByDeviceIdAndStatusResult);
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
  @Category(MaintainedByDiffblue.class)
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
    assertSame(
        actualFindAllByDeviceIdAndStatusResult.EMPTY_PAGE_DATA,
        actualFindAllByDeviceIdAndStatusResult);
  }

  /**
   * Test {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData BaseRpcService.findAllByDeviceId(TenantId, DeviceId, PageLink)"})
  public void testFindAllByDeviceId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult =
        baseRpcService.findAllByDeviceId(ModelConstants.SYSTEM_TENANT, null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(rpcDao).findAllByDeviceId(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(actualFindAllByDeviceIdResult.EMPTY_PAGE_DATA, actualFindAllByDeviceIdResult);
  }

  /**
   * Test {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData BaseRpcService.findAllByDeviceId(TenantId, DeviceId, PageLink)"})
  public void testFindAllByDeviceId_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult =
        baseRpcService.findAllByDeviceId(ModelConstants.SYSTEM_TENANT, null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(rpcDao).findAllByDeviceId(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(actualFindAllByDeviceIdResult.EMPTY_PAGE_DATA, actualFindAllByDeviceIdResult);
  }

  /**
   * Test {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData BaseRpcService.findAllByDeviceId(TenantId, DeviceId, PageLink)"})
  public void testFindAllByDeviceId_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<Rpc> emptyPageDataResult = PageData.emptyPageData();
    when(rpcDao.findAllByDeviceId(
            Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult =
        baseRpcService.findAllByDeviceId(ModelConstants.SYSTEM_TENANT, null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(rpcDao).findAllByDeviceId(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(actualFindAllByDeviceIdResult.EMPTY_PAGE_DATA, actualFindAllByDeviceIdResult);
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
  @Category(MaintainedByDiffblue.class)
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
    assertSame(actualFindAllByDeviceIdResult.EMPTY_PAGE_DATA, actualFindAllByDeviceIdResult);
  }

  /**
   * Test {@link BaseRpcService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseRpcService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional BaseRpcService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType BaseRpcService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(
        EntityType.RPC,
        new BaseRpcService(new JpaRpcDao(mock(RpcRepository.class))).getEntityType());
  }
}
