package org.thingsboard.server.service.entitiy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.RpcId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.service.entitiy.customer.DefaultTbCustomerService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.sync.vc.EntitiesVersionControlService;
import org.thingsboard.server.service.telemetry.AlarmSubscriptionService;

@ContextConfiguration(classes = {DefaultTbCustomerService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class AbstractTbEntityServiceDiffblueTest {
  @Autowired
  private AbstractTbEntityService abstractTbEntityService;

  @MockBean
  private AlarmService alarmService;

  @MockBean
  private AlarmSubscriptionService alarmSubscriptionService;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private DbCallbackExecutorService dbCallbackExecutorService;

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
   * Test {@link AbstractTbEntityService#isTestProfile()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#isTestProfile()}
   */
  @Test
  @DisplayName("Test isTestProfile(); then return 'false'")
  void testIsTestProfile_thenReturnFalse() {
    // Arrange
    when(environment.getActiveProfiles()).thenReturn(new String[]{"Active Profiles"});

    // Act
    boolean actualIsTestProfileResult = abstractTbEntityService.isTestProfile();

    // Assert
    verify(environment).getActiveProfiles();
    assertFalse(actualIsTestProfileResult);
  }

  /**
   * Test {@link AbstractTbEntityService#isTestProfile()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#isTestProfile()}
   */
  @Test
  @DisplayName("Test isTestProfile(); then return 'true'")
  void testIsTestProfile_thenReturnTrue() {
    // Arrange
    when(environment.getActiveProfiles()).thenReturn(new String[]{"test"});

    // Act
    boolean actualIsTestProfileResult = abstractTbEntityService.isTestProfile();

    // Assert
    verify(environment).getActiveProfiles();
    assertTrue(actualIsTestProfileResult);
  }

  /**
   * Test {@link AbstractTbEntityService#isTestProfile()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#isTestProfile()}
   */
  @Test
  @DisplayName("Test isTestProfile(); then throw RuntimeException")
  void testIsTestProfile_thenThrowRuntimeException() {
    // Arrange
    when(environment.getActiveProfiles()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> abstractTbEntityService.isTestProfile());
    verify(environment).getActiveProfiles();
  }

  /**
   * Test {@link AbstractTbEntityService#checkNotNull(Object, String)} with
   * {@code Object}, {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractTbEntityService#checkNotNull(Object, String)}
   */
  @Test
  @DisplayName("Test checkNotNull(Object, String) with 'Object', 'String'; when 'null'; then throw ThingsboardException")
  void testCheckNotNullWithObjectString_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class,
        () -> abstractTbEntityService.checkNotNull((Object) null, "Not Found Message"));
  }

  /**
   * Test {@link AbstractTbEntityService#checkNotNull(Object, String)} with
   * {@code Object}, {@code String}.
   * <ul>
   *   <li>When {@code Reference}.</li>
   *   <li>Then return {@code Reference}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractTbEntityService#checkNotNull(Object, String)}
   */
  @Test
  @DisplayName("Test checkNotNull(Object, String) with 'Object', 'String'; when 'Reference'; then return 'Reference'")
  void testCheckNotNullWithObjectString_whenReference_thenReturnReference() throws ThingsboardException {
    // Arrange, Act and Assert
    assertEquals("Reference", abstractTbEntityService.checkNotNull("Reference", "Not Found Message"));
  }

  /**
   * Test {@link AbstractTbEntityService#checkNotNull(Object)} with
   * {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#checkNotNull(Object)}
   */
  @Test
  @DisplayName("Test checkNotNull(Object) with 'Object'; when 'null'; then throw ThingsboardException")
  void testCheckNotNullWithObject_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> abstractTbEntityService.checkNotNull((Object) null));
  }

  /**
   * Test {@link AbstractTbEntityService#checkNotNull(Object)} with
   * {@code Object}.
   * <ul>
   *   <li>When {@code Reference}.</li>
   *   <li>Then return {@code Reference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#checkNotNull(Object)}
   */
  @Test
  @DisplayName("Test checkNotNull(Object) with 'Object'; when 'Reference'; then return 'Reference'")
  void testCheckNotNullWithObject_whenReference_thenReturnReference() throws ThingsboardException {
    // Arrange, Act and Assert
    assertEquals("Reference", abstractTbEntityService.checkNotNull("Reference"));
  }

  /**
   * Test {@link AbstractTbEntityService#checkNotNull(Optional, String)} with
   * {@code Optional}, {@code String}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractTbEntityService#checkNotNull(Optional, String)}
   */
  @Test
  @DisplayName("Test checkNotNull(Optional, String) with 'Optional', 'String'; when empty; then throw ThingsboardException")
  void testCheckNotNullWithOptionalString_whenEmpty_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange
    Optional<Object> reference = Optional.empty();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> abstractTbEntityService.checkNotNull(reference, "Not Found Message"));
  }

  /**
   * Test {@link AbstractTbEntityService#checkNotNull(Optional, String)} with
   * {@code Optional}, {@code String}.
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractTbEntityService#checkNotNull(Optional, String)}
   */
  @Test
  @DisplayName("Test checkNotNull(Optional, String) with 'Optional', 'String'; when Optional with '42'; then return '42'")
  void testCheckNotNullWithOptionalString_whenOptionalWith42_thenReturn42() throws ThingsboardException {
    // Arrange
    Optional<Object> reference = Optional.of("42");

    // Act and Assert
    assertEquals("42", abstractTbEntityService.checkNotNull(reference, "Not Found Message"));
  }

  /**
   * Test {@link AbstractTbEntityService#checkNotNull(Optional)} with
   * {@code Optional}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#checkNotNull(Optional)}
   */
  @Test
  @DisplayName("Test checkNotNull(Optional) with 'Optional'; when empty; then throw ThingsboardException")
  void testCheckNotNullWithOptional_whenEmpty_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange
    Optional<Object> reference = Optional.empty();

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> abstractTbEntityService.checkNotNull(reference));
  }

  /**
   * Test {@link AbstractTbEntityService#checkNotNull(Optional)} with
   * {@code Optional}.
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#checkNotNull(Optional)}
   */
  @Test
  @DisplayName("Test checkNotNull(Optional) with 'Optional'; when Optional with '42'; then return '42'")
  void testCheckNotNullWithOptional_whenOptionalWith42_thenReturn42() throws ThingsboardException {
    // Arrange
    Optional<Object> reference = Optional.of("42");

    // Act and Assert
    assertEquals("42", abstractTbEntityService.checkNotNull(reference));
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code ALARM}.</li>
   *   <li>Then return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'ALARM'; then return AlarmId")
  void testEmptyId_whenAlarm_thenReturnAlarmId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.ALARM);

    // Assert
    assertTrue(actualEmptyIdResult instanceof AlarmId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.ALARM, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code API_USAGE_STATE}.</li>
   *   <li>Then return {@link ApiUsageStateId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'API_USAGE_STATE'; then return ApiUsageStateId")
  void testEmptyId_whenApiUsageState_thenReturnApiUsageStateId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.API_USAGE_STATE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof ApiUsageStateId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.API_USAGE_STATE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code ASSET_PROFILE}.</li>
   *   <li>Then return {@link AssetProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'ASSET_PROFILE'; then return AssetProfileId")
  void testEmptyId_whenAssetProfile_thenReturnAssetProfileId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.ASSET_PROFILE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof AssetProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.ASSET_PROFILE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code ASSET}.</li>
   *   <li>Then return {@link AssetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'ASSET'; then return AssetId")
  void testEmptyId_whenAsset_thenReturnAssetId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.ASSET);

    // Assert
    assertTrue(actualEmptyIdResult instanceof AssetId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.ASSET, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code CUSTOMER}.</li>
   *   <li>Then return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'CUSTOMER'; then return CustomerId")
  void testEmptyId_whenCustomer_thenReturnCustomerId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.CUSTOMER);

    // Assert
    assertTrue(actualEmptyIdResult instanceof CustomerId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.CUSTOMER, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code DASHBOARD}.</li>
   *   <li>Then return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'DASHBOARD'; then return DashboardId")
  void testEmptyId_whenDashboard_thenReturnDashboardId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.DASHBOARD);

    // Assert
    assertTrue(actualEmptyIdResult instanceof DashboardId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.DASHBOARD, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code DEVICE_PROFILE}.</li>
   *   <li>Then return {@link DeviceProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'DEVICE_PROFILE'; then return DeviceProfileId")
  void testEmptyId_whenDeviceProfile_thenReturnDeviceProfileId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.DEVICE_PROFILE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof DeviceProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code DEVICE}.</li>
   *   <li>Then return {@link DeviceId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'DEVICE'; then return DeviceId")
  void testEmptyId_whenDevice_thenReturnDeviceId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.DEVICE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof DeviceId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.DEVICE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code EDGE}.</li>
   *   <li>Then return {@link EdgeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'EDGE'; then return EdgeId")
  void testEmptyId_whenEdge_thenReturnEdgeId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.EDGE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof EdgeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.EDGE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code ENTITY_VIEW}.</li>
   *   <li>Then return {@link EntityViewId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'ENTITY_VIEW'; then return EntityViewId")
  void testEmptyId_whenEntityView_thenReturnEntityViewId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.ENTITY_VIEW);

    // Assert
    assertTrue(actualEmptyIdResult instanceof EntityViewId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code OTA_PACKAGE}.</li>
   *   <li>Then return {@link OtaPackageId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'OTA_PACKAGE'; then return OtaPackageId")
  void testEmptyId_whenOtaPackage_thenReturnOtaPackageId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.OTA_PACKAGE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof OtaPackageId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.OTA_PACKAGE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code RPC}.</li>
   *   <li>Then return {@link RpcId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'RPC'; then return RpcId")
  void testEmptyId_whenRpc_thenReturnRpcId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.RPC);

    // Assert
    assertTrue(actualEmptyIdResult instanceof RpcId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.RPC, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code RULE_CHAIN}.</li>
   *   <li>Then return {@link RuleChainId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'RULE_CHAIN'; then return RuleChainId")
  void testEmptyId_whenRuleChain_thenReturnRuleChainId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.RULE_CHAIN);

    // Assert
    assertTrue(actualEmptyIdResult instanceof RuleChainId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code RULE_NODE}.</li>
   *   <li>Then return {@link RuleNodeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'RULE_NODE'; then return RuleNodeId")
  void testEmptyId_whenRuleNode_thenReturnRuleNodeId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.RULE_NODE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof RuleNodeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.RULE_NODE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code TB_RESOURCE}.</li>
   *   <li>Then return {@link TbResourceId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'TB_RESOURCE'; then return TbResourceId")
  void testEmptyId_whenTbResource_thenReturnTbResourceId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.TB_RESOURCE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof TbResourceId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.TB_RESOURCE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code TENANT_PROFILE}.</li>
   *   <li>Then return {@link TenantProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'TENANT_PROFILE'; then return TenantProfileId")
  void testEmptyId_whenTenantProfile_thenReturnTenantProfileId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.TENANT_PROFILE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof TenantProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.TENANT_PROFILE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code USER}.</li>
   *   <li>Then return {@link UserId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'USER'; then return UserId")
  void testEmptyId_whenUser_thenReturnUserId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.USER);

    // Assert
    assertTrue(actualEmptyIdResult instanceof UserId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.USER, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code WIDGET_TYPE}.</li>
   *   <li>Then return {@link WidgetTypeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'WIDGET_TYPE'; then return WidgetTypeId")
  void testEmptyId_whenWidgetType_thenReturnWidgetTypeId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.WIDGET_TYPE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof WidgetTypeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.WIDGET_TYPE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code WIDGETS_BUNDLE}.</li>
   *   <li>Then return {@link WidgetsBundleId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'WIDGETS_BUNDLE'; then return WidgetsBundleId")
  void testEmptyId_whenWidgetsBundle_thenReturnWidgetsBundleId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = abstractTbEntityService.emptyId(EntityType.WIDGETS_BUNDLE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof WidgetsBundleId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link AbstractTbEntityService#autoCommit(User, EntityId)} with
   * {@code user}, {@code entityId}.
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbEntityService#autoCommit(User, EntityId)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityId) with 'user', 'entityId'; then return ApiFutureToListenableFuture")
  void testAutoCommitWithUserEntityId_thenReturnApiFutureToListenableFuture() throws Exception {
    // Arrange
    SettableFuture<UUID> delegate = SettableFuture.create();
    ApiFutureToListenableFuture<UUID> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(entitiesVersionControlService.autoCommit(Mockito.<User>any(), Mockito.<EntityId>any()))
        .thenReturn(apiFutureToListenableFuture);

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = abstractTbEntityService.autoCommit(mock(User.class), null);

    // Assert
    verify(entitiesVersionControlService).autoCommit(isA(User.class), isNull());
    assertTrue(actualAutoCommitResult instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualAutoCommitResult);
  }

  /**
   * Test {@link AbstractTbEntityService#autoCommit(User, EntityType, List)} with
   * {@code user}, {@code entityType}, {@code entityIds}.
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractTbEntityService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'; then return ApiFutureToListenableFuture")
  void testAutoCommitWithUserEntityTypeEntityIds_thenReturnApiFutureToListenableFuture() throws Exception {
    // Arrange
    SettableFuture<UUID> delegate = SettableFuture.create();
    ApiFutureToListenableFuture<UUID> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(entitiesVersionControlService.autoCommit(Mockito.<User>any(), Mockito.<EntityType>any(),
        Mockito.<List<UUID>>any())).thenReturn(apiFutureToListenableFuture);
    User user = new User();

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = abstractTbEntityService.autoCommit(user, EntityType.TENANT,
        new ArrayList<>());

    // Assert
    verify(entitiesVersionControlService).autoCommit(isA(User.class), eq(EntityType.TENANT), isA(List.class));
    assertTrue(actualAutoCommitResult instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualAutoCommitResult);
  }

  /**
   * Test {@link AbstractTbEntityService#isLogControllerErrorStackTrace()}.
   * <p>
   * Method under test:
   * {@link AbstractTbEntityService#isLogControllerErrorStackTrace()}
   */
  @Test
  @DisplayName("Test isLogControllerErrorStackTrace()")
  void testIsLogControllerErrorStackTrace() {
    // Arrange, Act and Assert
    assertFalse(abstractTbEntityService.isLogControllerErrorStackTrace());
  }
}
