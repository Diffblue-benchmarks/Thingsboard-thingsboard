package org.thingsboard.server.dao.sql.rpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaRpcDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaRpcDao jpaRpcDao;

  @MockBean
  private RpcRepository rpcRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaRpcDao#getEntityClass()}
   *   <li>{@link JpaRpcDao#getEntityType()}
   *   <li>{@link JpaRpcDao#getRepository()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  public void testFindAllByDeviceId_givenNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(rpcRepository.findAllByTenantIdAndDeviceId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult = jpaRpcDao.findAllByDeviceId(ModelConstants.SYSTEM_TENANT, deviceId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceId).getId();
    verify(rpcRepository).findAllByTenantIdAndDeviceId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdResult.hasNext());
    assertTrue(actualFindAllByDeviceIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  public void testFindAllByDeviceId_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(rpcRepository.findAllByTenantIdAndDeviceId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult = jpaRpcDao.findAllByDeviceId(ModelConstants.SYSTEM_TENANT, deviceId,
        pageLink);

    // Assert
    verify(deviceId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(rpcRepository).findAllByTenantIdAndDeviceId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdResult.hasNext());
    assertTrue(actualFindAllByDeviceIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   * <ul>
   *   <li>Given {@link RpcEntity} {@link RpcEntity#toData()} return
   * {@link Rpc#Rpc()}.</li>
   *   <li>Then return Data first is {@link Rpc#Rpc()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  public void testFindAllByDeviceId_givenRpcEntityToDataReturnRpc_thenReturnDataFirstIsRpc() {
    // Arrange
    RpcEntity rpcEntity = mock(RpcEntity.class);
    Rpc rpc = new Rpc();
    when(rpcEntity.toData()).thenReturn(rpc);
    doNothing().when(rpcEntity).setCreatedTime(anyLong());
    doNothing().when(rpcEntity).setId(Mockito.<UUID>any());
    doNothing().when(rpcEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(rpcEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(rpcEntity).setDeviceId(Mockito.<UUID>any());
    doNothing().when(rpcEntity).setExpirationTime(anyLong());
    doNothing().when(rpcEntity).setRequest(Mockito.<JsonNode>any());
    doNothing().when(rpcEntity).setResponse(Mockito.<JsonNode>any());
    doNothing().when(rpcEntity).setStatus(Mockito.<RpcStatus>any());
    doNothing().when(rpcEntity).setTenantId(Mockito.<UUID>any());
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
    PageImpl<RpcEntity> pageImpl = new PageImpl<>(content);
    when(rpcRepository.findAllByTenantIdAndDeviceId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult = jpaRpcDao.findAllByDeviceId(ModelConstants.SYSTEM_TENANT, deviceId,
        pageLink);

    // Assert
    verify(deviceId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(rpcEntity).setCreatedTime(eq(1L));
    verify(rpcEntity).setId(isA(UUID.class));
    verify(rpcEntity).setUuid(isA(UUID.class));
    verify(rpcEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(rpcEntity).setDeviceId(isA(UUID.class));
    verify(rpcEntity).setExpirationTime(eq(1L));
    verify(rpcEntity).setRequest(isA(JsonNode.class));
    verify(rpcEntity).setResponse(isA(JsonNode.class));
    verify(rpcEntity).setStatus(eq(RpcStatus.QUEUED));
    verify(rpcEntity).setTenantId(isA(UUID.class));
    verify(rpcEntity).toData();
    verify(rpcRepository).findAllByTenantIdAndDeviceId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    List<Rpc> data = actualFindAllByDeviceIdResult.getData();
    assertEquals(1, data.size());
    assertSame(rpc, data.get(0));
  }

  /**
   * Test {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRpcDao#findAllByDeviceId(TenantId, DeviceId, PageLink)}
   */
  @Test
  public void testFindAllByDeviceId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(rpcRepository.findAllByTenantIdAndDeviceId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Rpc> actualFindAllByDeviceIdResult = jpaRpcDao.findAllByDeviceId(ModelConstants.SYSTEM_TENANT,
        new DeviceId(ModelConstants.NULL_UUID), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(rpcRepository).findAllByTenantIdAndDeviceId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdResult.hasNext());
    assertTrue(actualFindAllByDeviceIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}
   */
  @Test
  public void testFindAllByDeviceIdAndStatus_givenNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(rpcRepository.findAllByTenantIdAndDeviceIdAndStatus(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<RpcStatus>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult = jpaRpcDao.findAllByDeviceIdAndStatus(
        ModelConstants.SYSTEM_TENANT, deviceId, RpcStatus.QUEUED, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceId).getId();
    verify(rpcRepository).findAllByTenantIdAndDeviceIdAndStatus(isA(UUID.class), isA(UUID.class), eq(RpcStatus.QUEUED),
        isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdAndStatusResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdAndStatusResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdAndStatusResult.hasNext());
    assertTrue(actualFindAllByDeviceIdAndStatusResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}
   */
  @Test
  public void testFindAllByDeviceIdAndStatus_givenOne_thenCallsGetPage() {
    // Arrange
    when(rpcRepository.findAllByTenantIdAndDeviceIdAndStatus(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<RpcStatus>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult = jpaRpcDao
        .findAllByDeviceIdAndStatus(ModelConstants.SYSTEM_TENANT, deviceId, RpcStatus.QUEUED, pageLink);

    // Assert
    verify(deviceId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(rpcRepository).findAllByTenantIdAndDeviceIdAndStatus(isA(UUID.class), isA(UUID.class), eq(RpcStatus.QUEUED),
        isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdAndStatusResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdAndStatusResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdAndStatusResult.hasNext());
    assertTrue(actualFindAllByDeviceIdAndStatusResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link Rpc#Rpc()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}
   */
  @Test
  public void testFindAllByDeviceIdAndStatus_thenReturnDataFirstIsRpc() {
    // Arrange
    RpcEntity rpcEntity = mock(RpcEntity.class);
    Rpc rpc = new Rpc();
    when(rpcEntity.toData()).thenReturn(rpc);
    doNothing().when(rpcEntity).setCreatedTime(anyLong());
    doNothing().when(rpcEntity).setId(Mockito.<UUID>any());
    doNothing().when(rpcEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(rpcEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(rpcEntity).setDeviceId(Mockito.<UUID>any());
    doNothing().when(rpcEntity).setExpirationTime(anyLong());
    doNothing().when(rpcEntity).setRequest(Mockito.<JsonNode>any());
    doNothing().when(rpcEntity).setResponse(Mockito.<JsonNode>any());
    doNothing().when(rpcEntity).setStatus(Mockito.<RpcStatus>any());
    doNothing().when(rpcEntity).setTenantId(Mockito.<UUID>any());
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
    PageImpl<RpcEntity> pageImpl = new PageImpl<>(content);
    when(rpcRepository.findAllByTenantIdAndDeviceIdAndStatus(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<RpcStatus>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult = jpaRpcDao
        .findAllByDeviceIdAndStatus(ModelConstants.SYSTEM_TENANT, deviceId, RpcStatus.QUEUED, pageLink);

    // Assert
    verify(deviceId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(rpcEntity).setCreatedTime(eq(1L));
    verify(rpcEntity).setId(isA(UUID.class));
    verify(rpcEntity).setUuid(isA(UUID.class));
    verify(rpcEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(rpcEntity).setDeviceId(isA(UUID.class));
    verify(rpcEntity).setExpirationTime(eq(1L));
    verify(rpcEntity).setRequest(isA(JsonNode.class));
    verify(rpcEntity).setResponse(isA(JsonNode.class));
    verify(rpcEntity).setStatus(eq(RpcStatus.QUEUED));
    verify(rpcEntity).setTenantId(isA(UUID.class));
    verify(rpcEntity).toData();
    verify(rpcRepository).findAllByTenantIdAndDeviceIdAndStatus(isA(UUID.class), isA(UUID.class), eq(RpcStatus.QUEUED),
        isA(Pageable.class));
    List<Rpc> data = actualFindAllByDeviceIdAndStatusResult.getData();
    assertEquals(1, data.size());
    assertSame(rpc, data.get(0));
  }

  /**
   * Test
   * {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRpcDao#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}
   */
  @Test
  public void testFindAllByDeviceIdAndStatus_thenReturnTotalElementsIsZero() {
    // Arrange
    when(rpcRepository.findAllByTenantIdAndDeviceIdAndStatus(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<RpcStatus>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult = jpaRpcDao.findAllByDeviceIdAndStatus(
        ModelConstants.SYSTEM_TENANT, new DeviceId(ModelConstants.NULL_UUID), RpcStatus.QUEUED,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(rpcRepository).findAllByTenantIdAndDeviceIdAndStatus(isA(UUID.class), isA(UUID.class), eq(RpcStatus.QUEUED),
        isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdAndStatusResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdAndStatusResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdAndStatusResult.hasNext());
    assertTrue(actualFindAllByDeviceIdAndStatusResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAllRpcByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(rpcRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Rpc> actualFindAllRpcByTenantIdResult = jpaRpcDao.findAllRpcByTenantId(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(rpcRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllRpcByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllRpcByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllRpcByTenantIdResult.hasNext());
    assertTrue(actualFindAllRpcByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link RpcEntity} {@link RpcEntity#toData()} return
   * {@link Rpc#Rpc()}.</li>
   *   <li>Then return Data first is {@link Rpc#Rpc()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAllRpcByTenantId_givenRpcEntityToDataReturnRpc_thenReturnDataFirstIsRpc() {
    // Arrange
    RpcEntity rpcEntity = mock(RpcEntity.class);
    Rpc rpc = new Rpc();
    when(rpcEntity.toData()).thenReturn(rpc);
    doNothing().when(rpcEntity).setCreatedTime(anyLong());
    doNothing().when(rpcEntity).setId(Mockito.<UUID>any());
    doNothing().when(rpcEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(rpcEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(rpcEntity).setDeviceId(Mockito.<UUID>any());
    doNothing().when(rpcEntity).setExpirationTime(anyLong());
    doNothing().when(rpcEntity).setRequest(Mockito.<JsonNode>any());
    doNothing().when(rpcEntity).setResponse(Mockito.<JsonNode>any());
    doNothing().when(rpcEntity).setStatus(Mockito.<RpcStatus>any());
    doNothing().when(rpcEntity).setTenantId(Mockito.<UUID>any());
    rpcEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setCreatedTime(-1L);
    rpcEntity.setDeviceId(ModelConstants.NULL_UUID);
    rpcEntity.setExpirationTime(-1L);
    rpcEntity.setId(ModelConstants.NULL_UUID);
    rpcEntity.setRequest(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setResponse(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    rpcEntity.setStatus(RpcStatus.DELIVERED);
    rpcEntity.setTenantId(ModelConstants.NULL_UUID);
    rpcEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RpcEntity> content = new ArrayList<>();
    content.add(rpcEntity);
    PageImpl<RpcEntity> pageImpl = new PageImpl<>(content);
    when(rpcRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Rpc> actualFindAllRpcByTenantIdResult = jpaRpcDao.findAllRpcByTenantId(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(rpcEntity).setCreatedTime(eq(-1L));
    verify(rpcEntity).setId(isA(UUID.class));
    verify(rpcEntity).setUuid(isA(UUID.class));
    verify(rpcEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(rpcEntity).setDeviceId(isA(UUID.class));
    verify(rpcEntity).setExpirationTime(eq(-1L));
    verify(rpcEntity).setRequest(isA(JsonNode.class));
    verify(rpcEntity).setResponse(isA(JsonNode.class));
    verify(rpcEntity).setStatus(eq(RpcStatus.DELIVERED));
    verify(rpcEntity).setTenantId(isA(UUID.class));
    verify(rpcEntity).toData();
    verify(rpcRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    List<Rpc> data = actualFindAllRpcByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(rpc, data.get(0));
  }

  /**
   * Test {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRpcDao#findAllRpcByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAllRpcByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(rpcRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Rpc> actualFindAllRpcByTenantIdResult = jpaRpcDao.findAllRpcByTenantId(ModelConstants.SYSTEM_TENANT,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(rpcRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllRpcByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllRpcByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllRpcByTenantIdResult.hasNext());
    assertTrue(actualFindAllRpcByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRpcDao#deleteOutdatedRpcByTenantId(TenantId, Long)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRpcDao#deleteOutdatedRpcByTenantId(TenantId, Long)}
   */
  @Test
  public void testDeleteOutdatedRpcByTenantId_whenSystem_tenant_thenReturnOne() {
    // Arrange
    when(rpcRepository.deleteOutdatedRpcByTenantId(Mockito.<UUID>any(), Mockito.<Long>any())).thenReturn(1);

    // Act
    int actualDeleteOutdatedRpcByTenantIdResult = jpaRpcDao.deleteOutdatedRpcByTenantId(ModelConstants.SYSTEM_TENANT,
        1L);

    // Assert
    verify(rpcRepository).deleteOutdatedRpcByTenantId(isA(UUID.class), eq(1L));
    assertEquals(1, actualDeleteOutdatedRpcByTenantIdResult);
  }
}
