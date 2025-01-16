package org.thingsboard.server.service.entitiy.asset;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.asset.AssetService;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.service.entitiy.TbLogEntityActionService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.sync.vc.EntitiesVersionControlService;
import org.thingsboard.server.service.telemetry.AlarmSubscriptionService;

@ContextConfiguration(classes = {DefaultTbAssetService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class DefaultTbAssetServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private AlarmSubscriptionService alarmSubscriptionService;

  @MockBean
  private AssetService assetService;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private DbCallbackExecutorService dbCallbackExecutorService;

  @Autowired
  private DefaultTbAssetService defaultTbAssetService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntitiesVersionControlService entitiesVersionControlService;

  @MockBean
  private Environment environment;

  @MockBean
  private TbClusterService tbClusterService;

  @MockBean
  private TbLogEntityActionService tbLogEntityActionService;

  /**
   * Test {@link DefaultTbAssetService#save(Asset, User)}.
   * <ul>
   *   <li>Given
   * {@link ListenableFutureToApiFuture#ListenableFutureToApiFuture(ListenableFuture)}
   * with delegate is create.</li>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbAssetService#save(Asset, User)}
   */
  @Test
  @DisplayName("Test save(Asset, User); given ListenableFutureToApiFuture(ListenableFuture) with delegate is create; then return Asset()")
  void testSave_givenListenableFutureToApiFutureWithDelegateIsCreate_thenReturnAsset() throws Exception {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    SettableFuture<UUID> delegate = SettableFuture.create();
    when(entitiesVersionControlService.autoCommit(Mockito.<User>any(), Mockito.<EntityId>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    Asset asset = new Asset();
    when(assetService.saveAsset(Mockito.<Asset>any())).thenReturn(asset);
    Asset asset2 = new Asset();

    // Act
    Asset actualSaveResult = defaultTbAssetService.save(asset2, new User());

    // Assert
    verify(assetService).saveAsset(isA(Asset.class));
    verify(tbLogEntityActionService).logEntityAction((TenantId) isNull(), (EntityId) isNull(), isA(HasName.class),
        (CustomerId) isNull(), eq(ActionType.ADDED), isA(User.class), isA(Object[].class));
    verify(entitiesVersionControlService).autoCommit(isA(User.class), isNull());
    assertSame(asset, actualSaveResult);
  }

  /**
   * Test {@link DefaultTbAssetService#delete(Asset, User)}.
   * <ul>
   *   <li>Then calls {@link AssetService#deleteAsset(TenantId, AssetId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbAssetService#delete(Asset, User)}
   */
  @Test
  @DisplayName("Test delete(Asset, User); then calls deleteAsset(TenantId, AssetId)")
  void testDelete_thenCallsDeleteAsset() {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<AssetId>any(), Mockito.<Asset>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    doNothing().when(assetService).deleteAsset(Mockito.<TenantId>any(), Mockito.<AssetId>any());

    Asset asset = new Asset();
    asset.setId(new AssetId(UUID.randomUUID()));

    // Act
    defaultTbAssetService.delete(asset, new User());

    // Assert
    verify(assetService).deleteAsset(isNull(), isA(AssetId.class));
    verify(tbLogEntityActionService).logEntityAction((TenantId) isNull(), isA(AssetId.class), isA(Asset.class),
        (CustomerId) isNull(), eq(ActionType.DELETED), isA(User.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbAssetService#assignAssetToCustomer(TenantId, AssetId, Customer, User)}.
   * <ul>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbAssetService#assignAssetToCustomer(TenantId, AssetId, Customer, User)}
   */
  @Test
  @DisplayName("Test assignAssetToCustomer(TenantId, AssetId, Customer, User); then return Asset()")
  void testAssignAssetToCustomer_thenReturnAsset() throws ThingsboardException {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<AssetId>any(), Mockito.<Asset>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    Asset asset = new Asset();
    when(assetService.assignAssetToCustomer(Mockito.<TenantId>any(), Mockito.<AssetId>any(), Mockito.<CustomerId>any()))
        .thenReturn(asset);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AssetId assetId = new AssetId(UUID.randomUUID());

    Customer customer = new Customer();
    customer.setId(new CustomerId(UUID.randomUUID()));

    // Act
    Asset actualAssignAssetToCustomerResult = defaultTbAssetService.assignAssetToCustomer(tenantId, assetId, customer,
        new User());

    // Assert
    verify(assetService).assignAssetToCustomer(isA(TenantId.class), isA(AssetId.class), isA(CustomerId.class));
    verify(tbLogEntityActionService).logEntityAction(isA(TenantId.class), isA(AssetId.class), isA(Asset.class),
        isA(CustomerId.class), eq(ActionType.ASSIGNED_TO_CUSTOMER), isA(User.class), isA(Object[].class));
    assertSame(asset, actualAssignAssetToCustomerResult);
  }

  /**
   * Test
   * {@link DefaultTbAssetService#unassignAssetToCustomer(TenantId, AssetId, Customer, User)}.
   * <ul>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbAssetService#unassignAssetToCustomer(TenantId, AssetId, Customer, User)}
   */
  @Test
  @DisplayName("Test unassignAssetToCustomer(TenantId, AssetId, Customer, User); then return Asset()")
  void testUnassignAssetToCustomer_thenReturnAsset() throws ThingsboardException {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<AssetId>any(), Mockito.<Asset>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    Asset asset = new Asset();
    when(assetService.unassignAssetFromCustomer(Mockito.<TenantId>any(), Mockito.<AssetId>any())).thenReturn(asset);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AssetId assetId = new AssetId(UUID.randomUUID());

    Customer customer = new Customer();
    customer.setId(new CustomerId(UUID.randomUUID()));

    // Act
    Asset actualUnassignAssetToCustomerResult = defaultTbAssetService.unassignAssetToCustomer(tenantId, assetId,
        customer, new User());

    // Assert
    verify(assetService).unassignAssetFromCustomer(isA(TenantId.class), isA(AssetId.class));
    verify(tbLogEntityActionService).logEntityAction(isA(TenantId.class), isA(AssetId.class), isA(Asset.class),
        isA(CustomerId.class), eq(ActionType.UNASSIGNED_FROM_CUSTOMER), isA(User.class), isA(Object[].class));
    assertSame(asset, actualUnassignAssetToCustomerResult);
  }

  /**
   * Test
   * {@link DefaultTbAssetService#assignAssetToPublicCustomer(TenantId, AssetId, User)}.
   * <ul>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbAssetService#assignAssetToPublicCustomer(TenantId, AssetId, User)}
   */
  @Test
  @DisplayName("Test assignAssetToPublicCustomer(TenantId, AssetId, User); then return Asset()")
  void testAssignAssetToPublicCustomer_thenReturnAsset() throws ThingsboardException {
    // Arrange
    Customer customer = new Customer();
    customer.setId(new CustomerId(UUID.randomUUID()));
    when(customerService.findOrCreatePublicCustomer(Mockito.<TenantId>any())).thenReturn(customer);
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<AssetId>any(), Mockito.<Asset>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    Asset asset = new Asset();
    when(assetService.assignAssetToCustomer(Mockito.<TenantId>any(), Mockito.<AssetId>any(), Mockito.<CustomerId>any()))
        .thenReturn(asset);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AssetId assetId = new AssetId(UUID.randomUUID());

    // Act
    Asset actualAssignAssetToPublicCustomerResult = defaultTbAssetService.assignAssetToPublicCustomer(tenantId, assetId,
        new User());

    // Assert
    verify(assetService).assignAssetToCustomer(isA(TenantId.class), isA(AssetId.class), isA(CustomerId.class));
    verify(customerService).findOrCreatePublicCustomer(isA(TenantId.class));
    verify(tbLogEntityActionService).logEntityAction(isA(TenantId.class), isA(AssetId.class), isA(Asset.class),
        isA(CustomerId.class), eq(ActionType.ASSIGNED_TO_CUSTOMER), isA(User.class), isA(Object[].class));
    assertSame(asset, actualAssignAssetToPublicCustomerResult);
  }
}
