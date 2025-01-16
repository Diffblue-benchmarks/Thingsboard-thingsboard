package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.function.Function;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.HasTenantId;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.exception.EntityVersionMismatchException;
import org.thingsboard.server.common.data.exception.ThingsboardErrorCode;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AlarmCommentId;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.NotificationId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.QueueStatsId;
import org.thingsboard.server.common.data.id.RpcId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.common.data.query.EntityDataSortOrder;
import org.thingsboard.server.common.data.query.EntityKey;
import org.thingsboard.server.common.data.query.EntityKeyType;
import org.thingsboard.server.dao.alarm.AlarmCommentService;
import org.thingsboard.server.dao.asset.AssetProfileService;
import org.thingsboard.server.dao.asset.AssetService;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.audit.AuditLogService;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.dashboard.DashboardService;
import org.thingsboard.server.dao.device.ClaimDevicesService;
import org.thingsboard.server.dao.device.DeviceCredentialsService;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.device.DeviceService;
import org.thingsboard.server.dao.domain.DomainService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.mobile.MobileAppService;
import org.thingsboard.server.dao.oauth2.OAuth2ClientService;
import org.thingsboard.server.dao.oauth2.OAuth2ConfigTemplateService;
import org.thingsboard.server.dao.ota.OtaPackageService;
import org.thingsboard.server.dao.queue.QueueService;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.resource.ResourceService;
import org.thingsboard.server.dao.rpc.RpcService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileService;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.dao.widget.WidgetTypeService;
import org.thingsboard.server.dao.widget.WidgetsBundleService;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.provider.TbQueueProducerProvider;
import org.thingsboard.server.service.action.EntityActionService;
import org.thingsboard.server.service.component.ComponentDiscoveryService;
import org.thingsboard.server.service.entitiy.TbLogEntityActionService;
import org.thingsboard.server.service.entitiy.user.TbUserSettingsService;
import org.thingsboard.server.service.ota.OtaPackageStateService;
import org.thingsboard.server.service.profile.TbAssetProfileCache;
import org.thingsboard.server.service.profile.TbDeviceProfileCache;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.security.permission.AccessControlService;
import org.thingsboard.server.service.security.permission.Operation;
import org.thingsboard.server.service.security.permission.Resource;
import org.thingsboard.server.service.state.DeviceStateService;
import org.thingsboard.server.service.sync.ie.exporting.ExportableEntitiesService;
import org.thingsboard.server.service.sync.vc.EntitiesVersionControlService;
import org.thingsboard.server.service.telemetry.AlarmSubscriptionService;
import org.thingsboard.server.service.telemetry.TelemetrySubscriptionService;

@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class BaseControllerDiffblueTest {
  @MockBean
  private AccessControlService accessControlService;

  @MockBean
  private AlarmCommentService alarmCommentService;

  @MockBean
  private AlarmSubscriptionService alarmSubscriptionService;

  @MockBean
  private AssetProfileService assetProfileService;

  @MockBean
  private AssetService assetService;

  @MockBean
  private AttributesService attributesService;

  @MockBean
  private AuditLogService auditLogService;

  @MockBean
  private ClaimDevicesService claimDevicesService;

  @MockBean
  private ComponentDiscoveryService componentDiscoveryService;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private DashboardService dashboardService;

  @MockBean
  private DeviceCredentialsService deviceCredentialsService;

  @MockBean
  private DeviceProfileService deviceProfileService;

  @MockBean
  private DeviceService deviceService;

  @MockBean
  private DeviceStateService deviceStateService;

  @MockBean
  private DomainService domainService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntitiesVersionControlService entitiesVersionControlService;

  @MockBean
  private EntityActionService entityActionService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private ExportableEntitiesService exportableEntitiesService;

  @MockBean
  private MobileAppService mobileAppService;

  @MockBean
  private OAuth2ClientService oAuth2ClientService;

  @MockBean
  private OAuth2ConfigTemplateService oAuth2ConfigTemplateService;

  @MockBean
  private OtaPackageService otaPackageService;

  @MockBean
  private OtaPackageStateService otaPackageStateService;

  @MockBean
  private PartitionService partitionService;

  @MockBean
  private QueueService queueService;

  @MockBean
  private RelationService relationService;

  @MockBean
  private ResourceService resourceService;

  @MockBean
  private RpcService rpcService;

  @MockBean
  private RuleChainService ruleChainService;

  @MockBean
  private TbAssetProfileCache tbAssetProfileCache;

  @MockBean
  private TbClusterService tbClusterService;

  @MockBean
  private TbDeviceProfileCache tbDeviceProfileCache;

  @MockBean
  private TbLogEntityActionService tbLogEntityActionService;

  @MockBean
  private TbQueueProducerProvider tbQueueProducerProvider;

  @MockBean
  private TbServiceInfoProvider tbServiceInfoProvider;

  @MockBean
  private TbTenantProfileCache tbTenantProfileCache;

  @MockBean
  private TbUserSettingsService tbUserSettingsService;

  @MockBean
  private TelemetrySubscriptionService telemetrySubscriptionService;

  @MockBean
  private TenantProfileService tenantProfileService;

  @MockBean
  private TenantService tenantService;

  @MockBean
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  @MockBean
  private UserService userService;

  @MockBean
  private WidgetTypeService widgetTypeService;

  @MockBean
  private WidgetsBundleService widgetsBundleService;

  /**
   * Test {@link BaseController#handleException(Exception)} with
   * {@code exception}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#handleException(Exception)}
   */
  @Test
  @DisplayName("Test handleException(Exception) with 'exception'; then return LocalizedMessage is 'foo'")
  void testHandleExceptionWithException_thenReturnLocalizedMessageIsFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    Exception exception = new Exception("foo");

    // Act
    ThingsboardException actualHandleExceptionResult = auditLogController.handleException(exception);

    // Assert
    assertEquals("foo", actualHandleExceptionResult.getLocalizedMessage());
    assertEquals("foo", actualHandleExceptionResult.getMessage());
    assertEquals(0, actualHandleExceptionResult.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualHandleExceptionResult.getErrorCode());
    assertSame(exception, actualHandleExceptionResult.getCause());
  }

  /**
   * Test {@link BaseController#checkNotNull(Object, String)} with {@code Object},
   * {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkNotNull(Object, String)}
   */
  @Test
  @DisplayName("Test checkNotNull(Object, String) with 'Object', 'String'; when 'null'; then throw ThingsboardException")
  void testCheckNotNullWithObjectString_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new AuditLogController()).checkNotNull((Object) null, "Not Found Message"));
  }

  /**
   * Test {@link BaseController#checkNotNull(Object, String)} with {@code Object},
   * {@code String}.
   * <ul>
   *   <li>When {@code Reference}.</li>
   *   <li>Then return {@code Reference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkNotNull(Object, String)}
   */
  @Test
  @DisplayName("Test checkNotNull(Object, String) with 'Object', 'String'; when 'Reference'; then return 'Reference'")
  void testCheckNotNullWithObjectString_whenReference_thenReturnReference() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Reference", (new AuditLogController()).checkNotNull("Reference", "Not Found Message"));
  }

  /**
   * Test {@link BaseController#checkNotNull(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkNotNull(Object)}
   */
  @Test
  @DisplayName("Test checkNotNull(Object) with 'Object'; when 'null'; then throw ThingsboardException")
  void testCheckNotNullWithObject_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> (new AuditLogController()).checkNotNull((Object) null));
  }

  /**
   * Test {@link BaseController#checkNotNull(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@code Reference}.</li>
   *   <li>Then return {@code Reference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkNotNull(Object)}
   */
  @Test
  @DisplayName("Test checkNotNull(Object) with 'Object'; when 'Reference'; then return 'Reference'")
  void testCheckNotNullWithObject_whenReference_thenReturnReference() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Reference", (new AuditLogController()).checkNotNull("Reference"));
  }

  /**
   * Test {@link BaseController#checkNotNull(Optional, String)} with
   * {@code Optional}, {@code String}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkNotNull(Optional, String)}
   */
  @Test
  @DisplayName("Test checkNotNull(Optional, String) with 'Optional', 'String'; when empty; then throw ThingsboardException")
  void testCheckNotNullWithOptionalString_whenEmpty_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    Optional<Object> reference = Optional.empty();

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkNotNull(reference, "Not Found Message"));
  }

  /**
   * Test {@link BaseController#checkNotNull(Optional, String)} with
   * {@code Optional}, {@code String}.
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkNotNull(Optional, String)}
   */
  @Test
  @DisplayName("Test checkNotNull(Optional, String) with 'Optional', 'String'; when Optional with '42'; then return '42'")
  void testCheckNotNullWithOptionalString_whenOptionalWith42_thenReturn42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    Optional<Object> reference = Optional.of("42");

    // Act and Assert
    assertEquals("42", auditLogController.checkNotNull(reference, "Not Found Message"));
  }

  /**
   * Test {@link BaseController#checkNotNull(Optional)} with {@code Optional}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkNotNull(Optional)}
   */
  @Test
  @DisplayName("Test checkNotNull(Optional) with 'Optional'; when empty; then throw ThingsboardException")
  void testCheckNotNullWithOptional_whenEmpty_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    Optional<Object> reference = Optional.empty();

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkNotNull(reference));
  }

  /**
   * Test {@link BaseController#checkNotNull(Optional)} with {@code Optional}.
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkNotNull(Optional)}
   */
  @Test
  @DisplayName("Test checkNotNull(Optional) with 'Optional'; when Optional with '42'; then return '42'")
  void testCheckNotNullWithOptional_whenOptionalWith42_thenReturn42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    Optional<Object> reference = Optional.of("42");

    // Act and Assert
    assertEquals("42", auditLogController.checkNotNull(reference));
  }

  /**
   * Test {@link BaseController#checkParameter(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkParameter(String, String)}
   */
  @Test
  @DisplayName("Test checkParameter(String, String); when empty string; then throw ThingsboardException")
  void testCheckParameter_whenEmptyString_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> (new AuditLogController()).checkParameter("Name", ""));
  }

  /**
   * Test {@link BaseController#checkParameter(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkParameter(String, String)}
   */
  @Test
  @DisplayName("Test checkParameter(String, String); when 'null'; then throw ThingsboardException")
  void testCheckParameter_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> (new AuditLogController()).checkParameter("Name", null));
  }

  /**
   * Test {@link BaseController#checkArrayParameter(String, String[])}.
   * <ul>
   *   <li>When array of {@link String} with empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkArrayParameter(String, String[])}
   */
  @Test
  @DisplayName("Test checkArrayParameter(String, String[]); when array of String with empty string")
  void testCheckArrayParameter_whenArrayOfStringWithEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new AuditLogController()).checkArrayParameter("Name", new String[]{""}));
  }

  /**
   * Test {@link BaseController#checkArrayParameter(String, String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code null}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkArrayParameter(String, String[])}
   */
  @Test
  @DisplayName("Test checkArrayParameter(String, String[]); when array of String with 'null'; then throw ThingsboardException")
  void testCheckArrayParameter_whenArrayOfStringWithNull_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new AuditLogController()).checkArrayParameter("Name", new String[]{null}));
  }

  /**
   * Test {@link BaseController#checkArrayParameter(String, String[])}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkArrayParameter(String, String[])}
   */
  @Test
  @DisplayName("Test checkArrayParameter(String, String[]); when empty array of String; then throw ThingsboardException")
  void testCheckArrayParameter_whenEmptyArrayOfString_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new AuditLogController()).checkArrayParameter("Name", new String[]{}));
  }

  /**
   * Test {@link BaseController#checkArrayParameter(String, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkArrayParameter(String, String[])}
   */
  @Test
  @DisplayName("Test checkArrayParameter(String, String[]); when 'null'; then throw ThingsboardException")
  void testCheckArrayParameter_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> (new AuditLogController()).checkArrayParameter("Name", null));
  }

  /**
   * Test {@link BaseController#checkEnumParameter(String, String, Function)}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@link Function} {@link Function#apply(Object)} return
   * {@code Apply}.</li>
   *   <li>Then return {@code Apply}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkEnumParameter(String, String, Function)}
   */
  @Test
  @DisplayName("Test checkEnumParameter(String, String, Function); given 'Apply'; when Function apply(Object) return 'Apply'; then return 'Apply'")
  void testCheckEnumParameter_givenApply_whenFunctionApplyReturnApply_thenReturnApply() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    Function<String, Object> valueOf = mock(Function.class);
    when(valueOf.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    Object actualCheckEnumParameterResult = auditLogController.checkEnumParameter("Name", "Param", valueOf);

    // Assert
    verify(valueOf).apply(eq("PARAM"));
    assertEquals("Apply", actualCheckEnumParameterResult);
  }

  /**
   * Test {@link BaseController#checkEnumParameter(String, String, Function)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkEnumParameter(String, String, Function)}
   */
  @Test
  @DisplayName("Test checkEnumParameter(String, String, Function); then throw IncorrectParameterException")
  void testCheckEnumParameter_thenThrowIncorrectParameterException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    Function<String, Object> valueOf = mock(Function.class);
    when(valueOf.apply(Mockito.<String>any())).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> auditLogController.checkEnumParameter("Name", "Param", valueOf));
    verify(valueOf).apply(eq("PARAM"));
  }

  /**
   * Test {@link BaseController#checkEnumParameter(String, String, Function)}.
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkEnumParameter(String, String, Function)}
   */
  @Test
  @DisplayName("Test checkEnumParameter(String, String, Function); then throw ThingsboardException")
  void testCheckEnumParameter_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    Function<String, Object> valueOf = mock(Function.class);
    when(valueOf.apply(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkEnumParameter("Name", "Param", valueOf));
    verify(valueOf).apply(eq("PARAM"));
  }

  /**
   * Test {@link BaseController#toUUID(String)}.
   * <p>
   * Method under test: {@link BaseController#toUUID(String)}
   */
  @Test
  @DisplayName("Test toUUID(String)")
  void testToUUID() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> (new AuditLogController()).toUUID("42"));
  }

  /**
   * Test {@link BaseController#createPageLink(int, int, String, String, String)}.
   * <ul>
   *   <li>When {@code asc}.</li>
   *   <li>Then return SortOrder Property is {@code U}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createPageLink(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test createPageLink(int, int, String, String, String); when 'asc'; then return SortOrder Property is 'U'")
  void testCreatePageLink_whenAsc_thenReturnSortOrderPropertyIsU() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    PageLink actualCreatePageLinkResult = (new AuditLogController()).createPageLink(3, 1, "Text Search", "U", "asc");

    // Assert
    assertEquals("Text Search", actualCreatePageLinkResult.getTextSearch());
    SortOrder sortOrder = actualCreatePageLinkResult.getSortOrder();
    assertEquals("U", sortOrder.getProperty());
    assertEquals(1, actualCreatePageLinkResult.getPage());
    assertEquals(3, actualCreatePageLinkResult.getPageSize());
    assertEquals(SortOrder.Direction.ASC, sortOrder.getDirection());
  }

  /**
   * Test {@link BaseController#createPageLink(int, int, String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return SortOrder is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createPageLink(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test createPageLink(int, int, String, String, String); when empty string; then return SortOrder is 'null'")
  void testCreatePageLink_whenEmptyString_thenReturnSortOrderIsNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    PageLink actualCreatePageLinkResult = (new AuditLogController()).createPageLink(3, 1, "Text Search", "", null);

    // Assert
    assertEquals("Text Search", actualCreatePageLinkResult.getTextSearch());
    assertNull(actualCreatePageLinkResult.getSortOrder());
    assertEquals(1, actualCreatePageLinkResult.getPage());
    assertEquals(3, actualCreatePageLinkResult.getPageSize());
  }

  /**
   * Test {@link BaseController#createPageLink(int, int, String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return SortOrder Property is {@code U}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createPageLink(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test createPageLink(int, int, String, String, String); when empty string; then return SortOrder Property is 'U'")
  void testCreatePageLink_whenEmptyString_thenReturnSortOrderPropertyIsU() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    PageLink actualCreatePageLinkResult = (new AuditLogController()).createPageLink(3, 1, "Text Search", "U", "");

    // Assert
    assertEquals("Text Search", actualCreatePageLinkResult.getTextSearch());
    SortOrder sortOrder = actualCreatePageLinkResult.getSortOrder();
    assertEquals("U", sortOrder.getProperty());
    assertEquals(1, actualCreatePageLinkResult.getPage());
    assertEquals(3, actualCreatePageLinkResult.getPageSize());
    assertEquals(SortOrder.Direction.ASC, sortOrder.getDirection());
  }

  /**
   * Test {@link BaseController#createPageLink(int, int, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return SortOrder is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createPageLink(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test createPageLink(int, int, String, String, String); when 'null'; then return SortOrder is 'null'")
  void testCreatePageLink_whenNull_thenReturnSortOrderIsNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    PageLink actualCreatePageLinkResult = (new AuditLogController()).createPageLink(3, 1, "Text Search", null, null);

    // Assert
    assertEquals("Text Search", actualCreatePageLinkResult.getTextSearch());
    assertNull(actualCreatePageLinkResult.getSortOrder());
    assertEquals(1, actualCreatePageLinkResult.getPage());
    assertEquals(3, actualCreatePageLinkResult.getPageSize());
  }

  /**
   * Test {@link BaseController#createPageLink(int, int, String, String, String)}.
   * <ul>
   *   <li>When {@code Sort Property}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createPageLink(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test createPageLink(int, int, String, String, String); when 'Sort Property'; then throw IllegalArgumentException")
  void testCreatePageLink_whenSortProperty_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AuditLogController()).createPageLink(3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link BaseController#createPageLink(int, int, String, String, String)}.
   * <ul>
   *   <li>When {@code U}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createPageLink(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test createPageLink(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  void testCreatePageLink_whenU_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new AuditLogController()).createPageLink(3, 1, "Text Search", "U", "U"));
  }

  /**
   * Test
   * {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}.
   * <ul>
   *   <li>When {@code asc}.</li>
   *   <li>Then return SortOrder Property is {@code U}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName("Test createTimePageLink(int, int, String, String, String, Long, Long); when 'asc'; then return SortOrder Property is 'U'")
  void testCreateTimePageLink_whenAsc_thenReturnSortOrderPropertyIsU() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TimePageLink actualCreateTimePageLinkResult = (new AuditLogController()).createTimePageLink(3, 1, "Text Search",
        "U", "asc", 1L, 1L);

    // Assert
    assertEquals("Text Search", actualCreateTimePageLinkResult.getTextSearch());
    SortOrder sortOrder = actualCreateTimePageLinkResult.getSortOrder();
    assertEquals("U", sortOrder.getProperty());
    assertEquals(1, actualCreateTimePageLinkResult.getPage());
    assertEquals(1L, actualCreateTimePageLinkResult.getEndTime().longValue());
    assertEquals(1L, actualCreateTimePageLinkResult.getStartTime().longValue());
    assertEquals(3, actualCreateTimePageLinkResult.getPageSize());
    assertEquals(SortOrder.Direction.ASC, sortOrder.getDirection());
  }

  /**
   * Test
   * {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return SortOrder is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName("Test createTimePageLink(int, int, String, String, String, Long, Long); when empty string; then return SortOrder is 'null'")
  void testCreateTimePageLink_whenEmptyString_thenReturnSortOrderIsNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TimePageLink actualCreateTimePageLinkResult = (new AuditLogController()).createTimePageLink(3, 1, "Text Search", "",
        null, 1L, 1L);

    // Assert
    assertEquals("Text Search", actualCreateTimePageLinkResult.getTextSearch());
    assertNull(actualCreateTimePageLinkResult.getSortOrder());
    assertEquals(1, actualCreateTimePageLinkResult.getPage());
    assertEquals(1L, actualCreateTimePageLinkResult.getEndTime().longValue());
    assertEquals(1L, actualCreateTimePageLinkResult.getStartTime().longValue());
    assertEquals(3, actualCreateTimePageLinkResult.getPageSize());
  }

  /**
   * Test
   * {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return SortOrder Property is {@code U}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName("Test createTimePageLink(int, int, String, String, String, Long, Long); when empty string; then return SortOrder Property is 'U'")
  void testCreateTimePageLink_whenEmptyString_thenReturnSortOrderPropertyIsU() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TimePageLink actualCreateTimePageLinkResult = (new AuditLogController()).createTimePageLink(3, 1, "Text Search",
        "U", "", 1L, 1L);

    // Assert
    assertEquals("Text Search", actualCreateTimePageLinkResult.getTextSearch());
    SortOrder sortOrder = actualCreateTimePageLinkResult.getSortOrder();
    assertEquals("U", sortOrder.getProperty());
    assertEquals(1, actualCreateTimePageLinkResult.getPage());
    assertEquals(1L, actualCreateTimePageLinkResult.getEndTime().longValue());
    assertEquals(1L, actualCreateTimePageLinkResult.getStartTime().longValue());
    assertEquals(3, actualCreateTimePageLinkResult.getPageSize());
    assertEquals(SortOrder.Direction.ASC, sortOrder.getDirection());
  }

  /**
   * Test
   * {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return SortOrder is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName("Test createTimePageLink(int, int, String, String, String, Long, Long); when 'null'; then return SortOrder is 'null'")
  void testCreateTimePageLink_whenNull_thenReturnSortOrderIsNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TimePageLink actualCreateTimePageLinkResult = (new AuditLogController()).createTimePageLink(3, 1, "Text Search",
        null, null, 1L, 1L);

    // Assert
    assertEquals("Text Search", actualCreateTimePageLinkResult.getTextSearch());
    assertNull(actualCreateTimePageLinkResult.getSortOrder());
    assertEquals(1, actualCreateTimePageLinkResult.getPage());
    assertEquals(1L, actualCreateTimePageLinkResult.getEndTime().longValue());
    assertEquals(1L, actualCreateTimePageLinkResult.getStartTime().longValue());
    assertEquals(3, actualCreateTimePageLinkResult.getPageSize());
  }

  /**
   * Test
   * {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}.
   * <ul>
   *   <li>When {@code Sort Property}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName("Test createTimePageLink(int, int, String, String, String, Long, Long); when 'Sort Property'; then throw IllegalArgumentException")
  void testCreateTimePageLink_whenSortProperty_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AuditLogController()).createTimePageLink(3, 1, "Text Search", "Sort Property", "asc", 1L, 1L));
  }

  /**
   * Test
   * {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}.
   * <ul>
   *   <li>When {@code U}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName("Test createTimePageLink(int, int, String, String, String, Long, Long); when 'U'; then throw ThingsboardException")
  void testCreateTimePageLink_whenU_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new AuditLogController()).createTimePageLink(3, 1, "Text Search", "U", "U", 1L, 1L));
  }

  /**
   * Test {@link BaseController#getCurrentUser()}.
   * <p>
   * Method under test: {@link BaseController#getCurrentUser()}
   */
  @Test
  @DisplayName("Test getCurrentUser()")
  void testGetCurrentUser() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> (new AuditLogController()).getCurrentUser());
  }

  /**
   * Test {@link BaseController#checkTenantId(TenantId, Operation)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkTenantId(TenantId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantId(TenantId, Operation); when 'null'")
  void testCheckTenantId_whenNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> (new AuditLogController()).checkTenantId(null, Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantId(TenantId, Operation)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkTenantId(TenantId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantId(TenantId, Operation); when TenantId(UUID) with id is 'null'")
  void testCheckTenantId_whenTenantIdWithIdIsNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkTenantId(new TenantId(null), Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantId(TenantId, Operation)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkTenantId(TenantId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantId(TenantId, Operation); when TenantId(UUID) with id is randomUUID")
  void testCheckTenantId_whenTenantIdWithIdIsRandomUUID() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkTenantId(new TenantId(UUID.randomUUID()), Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantInfoId(TenantId, Operation)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkTenantInfoId(TenantId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantInfoId(TenantId, Operation); when 'null'")
  void testCheckTenantInfoId_whenNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> (new AuditLogController()).checkTenantInfoId(null, Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantInfoId(TenantId, Operation)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkTenantInfoId(TenantId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantInfoId(TenantId, Operation); when TenantId(UUID) with id is 'null'")
  void testCheckTenantInfoId_whenTenantIdWithIdIsNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkTenantInfoId(new TenantId(null), Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantInfoId(TenantId, Operation)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkTenantInfoId(TenantId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantInfoId(TenantId, Operation); when TenantId(UUID) with id is randomUUID")
  void testCheckTenantInfoId_whenTenantIdWithIdIsRandomUUID() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkTenantInfoId(new TenantId(UUID.randomUUID()), Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   * <p>
   * Method under test:
   * {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantProfileId(TenantProfileId, Operation)")
  void testCheckTenantProfileId() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(tenantProfileId, Operation.ALL));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   * <p>
   * Method under test:
   * {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantProfileId(TenantProfileId, Operation)")
  void testCheckTenantProfileId2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(tenantProfileId, Operation.ALL));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   * <p>
   * Method under test:
   * {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantProfileId(TenantProfileId, Operation)")
  void testCheckTenantProfileId3() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(tenantProfileId, Operation.ALL));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   * <p>
   * Method under test:
   * {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantProfileId(TenantProfileId, Operation)")
  void testCheckTenantProfileId4() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(tenantProfileId, Operation.ALL));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   * <ul>
   *   <li>Given {@link AsyncRequestTimeoutException} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantProfileId(TenantProfileId, Operation); given AsyncRequestTimeoutException (default constructor)")
  void testCheckTenantProfileId_givenAsyncRequestTimeoutException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenThrow(new AsyncRequestTimeoutException());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(tenantProfileId, Operation.ALL));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantProfileId(TenantProfileId, Operation); given IllegalArgumentException(String) with 'foo'")
  void testCheckTenantProfileId_givenIllegalArgumentExceptionWithFoo() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(tenantProfileId, Operation.ALL));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link TenantProfileId} {@link UUIDBased#getId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantProfileId(TenantProfileId, Operation); given 'null'; when TenantProfileId getId() return 'null'")
  void testCheckTenantProfileId_givenNull_whenTenantProfileIdGetIdReturnNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(tenantProfileId, Operation.ALL));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantProfileId(TenantProfileId, Operation); when 'null'; then throw ThingsboardException")
  void testCheckTenantProfileId_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new AuditLogController()).checkTenantProfileId(null, Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   * <ul>
   *   <li>When {@link TenantProfileId#TenantProfileId(UUID)} with id is
   * randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantProfileId(TenantProfileId, Operation); when TenantProfileId(UUID) with id is randomUUID")
  void testCheckTenantProfileId_whenTenantProfileIdWithIdIsRandomUUID() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(new TenantProfileId(UUID.randomUUID()), Operation.ALL));
  }

  /**
   * Test {@link BaseController#getTenantId()}.
   * <p>
   * Method under test: {@link BaseController#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  void testGetTenantId() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> (new AuditLogController()).getTenantId());
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with
   * {@code entityId}, {@code entity}, {@code resource}.
   * <p>
   * Method under test:
   * {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName("Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'")
  void testCheckEntityWithEntityIdEntityResource() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(alarmId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkEntity(alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with
   * {@code entityId}, {@code entity}, {@code resource}.
   * <p>
   * Method under test:
   * {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName("Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'")
  void testCheckEntityWithEntityIdEntityResource2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new DataValidationException("An error occurred"));
    when(alarmId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkEntity(alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with
   * {@code entityId}, {@code entity}, {@code resource}.
   * <p>
   * Method under test:
   * {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName("Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'")
  void testCheckEntityWithEntityIdEntityResource3() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new EmptyResultDataAccessException(3));
    when(alarmId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkEntity(alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with
   * {@code entityId}, {@code entity}, {@code resource}.
   * <p>
   * Method under test:
   * {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName("Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'")
  void testCheckEntityWithEntityIdEntityResource4() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(alarmId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkEntity(alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with
   * {@code entityId}, {@code entity}, {@code resource}.
   * <ul>
   *   <li>Given {@link AsyncRequestTimeoutException} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName("Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given AsyncRequestTimeoutException (default constructor)")
  void testCheckEntityWithEntityIdEntityResource_givenAsyncRequestTimeoutException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new AsyncRequestTimeoutException());
    when(alarmId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkEntity(alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with
   * {@code entityId}, {@code entity}, {@code resource}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName("Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given IllegalArgumentException(String) with 'foo'")
  void testCheckEntityWithEntityIdEntityResource_givenIllegalArgumentExceptionWithFoo() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));
    when(alarmId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkEntity(alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with
   * {@code entityId}, {@code entity}, {@code resource}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link AlarmId} {@link UUIDBased#getId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName("Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'null'; when AlarmId getId() return 'null'")
  void testCheckEntityWithEntityIdEntityResource_givenNull_whenAlarmIdGetIdReturnNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkEntity(alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with
   * {@code entityId}, {@code entity}, {@code resource}.
   * <ul>
   *   <li>Given {@code RULE_NODE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName("Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'RULE_NODE'")
  void testCheckEntityWithEntityIdEntityResource_givenRuleNode() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkEntity(alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with
   * {@code entityId}, {@code entity}, {@code resource}.
   * <ul>
   *   <li>Given {@code TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName("Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'TENANT'")
  void testCheckEntityWithEntityIdEntityResource_givenTenant() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkEntity(alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with
   * {@code entityId}, {@code entity}, {@code resource}.
   * <ul>
   *   <li>Given {@code TENANT_PROFILE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName("Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'TENANT_PROFILE'")
  void testCheckEntityWithEntityIdEntityResource_givenTenantProfile() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT_PROFILE);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkEntity(alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with
   * {@code entityId}, {@code entity}, {@code resource}.
   * <ul>
   *   <li>Given {@link UUID#UUID(long, long)} with one and one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName("Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given UUID(long, long) with one and one")
  void testCheckEntityWithEntityIdEntityResource_givenUuidWithOneAndOne() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    when(alarmId.getId()).thenReturn(new UUID(1L, 1L));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkEntity(alarmId, mock(HasTenantId.class), Resource.ALARM));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with
   * {@code entityId}, {@code entity}, {@code resource}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName("Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; when 'null'; then throw ThingsboardException")
  void testCheckEntityWithEntityIdEntityResource_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new AuditLogController()).checkEntity(null, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with
   * {@code entityId}, {@code operation}.
   * <p>
   * Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'")
  void testCheckEntityIdWithEntityIdOperation() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with
   * {@code entityId}, {@code operation}.
   * <p>
   * Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'")
  void testCheckEntityIdWithEntityIdOperation2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new DataValidationException("An error occurred"));
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with
   * {@code entityId}, {@code operation}.
   * <p>
   * Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'")
  void testCheckEntityIdWithEntityIdOperation3() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new EmptyResultDataAccessException(3));
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with
   * {@code entityId}, {@code operation}.
   * <p>
   * Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'")
  void testCheckEntityIdWithEntityIdOperation4() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with
   * {@code entityId}, {@code operation}.
   * <ul>
   *   <li>Given {@link AsyncRequestTimeoutException} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given AsyncRequestTimeoutException (default constructor)")
  void testCheckEntityIdWithEntityIdOperation_givenAsyncRequestTimeoutException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new AsyncRequestTimeoutException());
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with
   * {@code entityId}, {@code operation}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given IllegalArgumentException(String) with 'foo'")
  void testCheckEntityIdWithEntityIdOperation_givenIllegalArgumentExceptionWithFoo() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with
   * {@code entityId}, {@code operation}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link AlarmId} {@link UUIDBased#getId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'null'; when AlarmId getId() return 'null'")
  void testCheckEntityIdWithEntityIdOperation_givenNull_whenAlarmIdGetIdReturnNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with
   * {@code entityId}, {@code operation}.
   * <ul>
   *   <li>Given {@code RULE_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'RULE_NODE'")
  void testCheckEntityIdWithEntityIdOperation_givenRuleNode() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with
   * {@code entityId}, {@code operation}.
   * <ul>
   *   <li>Given {@code TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'TENANT'")
  void testCheckEntityIdWithEntityIdOperation_givenTenant() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with
   * {@code entityId}, {@code operation}.
   * <ul>
   *   <li>Given {@code TENANT_PROFILE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'TENANT_PROFILE'")
  void testCheckEntityIdWithEntityIdOperation_givenTenantProfile() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT_PROFILE);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with
   * {@code entityId}, {@code operation}.
   * <ul>
   *   <li>Given {@link UUID#UUID(long, long)} with one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given UUID(long, long) with one and one")
  void testCheckEntityIdWithEntityIdOperation_givenUuidWithOneAndOne() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(new UUID(1L, 1L));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with
   * {@code entityId}, {@code operation}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; when 'null'; then throw ThingsboardException")
  void testCheckEntityIdWithEntityIdOperation_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> (new AuditLogController()).checkEntityId(null, Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   * <p>
   * Method under test:
   * {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName("Test checkAlarmCommentId(AlarmCommentId, AlarmId)")
  void testCheckAlarmCommentId() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   * <p>
   * Method under test:
   * {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName("Test checkAlarmCommentId(AlarmCommentId, AlarmId)")
  void testCheckAlarmCommentId2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   * <p>
   * Method under test:
   * {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName("Test checkAlarmCommentId(AlarmCommentId, AlarmId)")
  void testCheckAlarmCommentId3() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   * <ul>
   *   <li>Given {@link AsyncRequestTimeoutException} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName("Test checkAlarmCommentId(AlarmCommentId, AlarmId); given AsyncRequestTimeoutException (default constructor)")
  void testCheckAlarmCommentId_givenAsyncRequestTimeoutException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenThrow(new AsyncRequestTimeoutException());

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   * <ul>
   *   <li>Given {@link DataValidationException#DataValidationException(String)}
   * with message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName("Test checkAlarmCommentId(AlarmCommentId, AlarmId); given DataValidationException(String) with message is 'An error occurred'")
  void testCheckAlarmCommentId_givenDataValidationExceptionWithMessageIsAnErrorOccurred() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName("Test checkAlarmCommentId(AlarmCommentId, AlarmId); given IllegalArgumentException(String) with 'foo'")
  void testCheckAlarmCommentId_givenIllegalArgumentExceptionWithFoo() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link AlarmCommentId} {@link UUIDBased#getId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName("Test checkAlarmCommentId(AlarmCommentId, AlarmId); given 'null'; when AlarmCommentId getId() return 'null'")
  void testCheckAlarmCommentId_givenNull_whenAlarmCommentIdGetIdReturnNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   * <ul>
   *   <li>Given randomUUID.</li>
   *   <li>When {@link AlarmCommentId} {@link UUIDBased#getId()} return
   * randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName("Test checkAlarmCommentId(AlarmCommentId, AlarmId); given randomUUID; when AlarmCommentId getId() return randomUUID")
  void testCheckAlarmCommentId_givenRandomUUID_whenAlarmCommentIdGetIdReturnRandomUUID() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkRuleNode(RuleNodeId, Operation)}.
   * <ul>
   *   <li>When {@link RuleNodeId#RuleNodeId(UUID)} with id is randomUUID.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#checkRuleNode(RuleNodeId, Operation)}
   */
  @Test
  @DisplayName("Test checkRuleNode(RuleNodeId, Operation); when RuleNodeId(UUID) with id is randomUUID; then throw ThingsboardException")
  void testCheckRuleNode_whenRuleNodeIdWithIdIsRandomUUID_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> auditLogController.checkRuleNode(new RuleNodeId(UUID.randomUUID()), Operation.ALL));
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code ALARM}.</li>
   *   <li>Then return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'ALARM'; then return AlarmId")
  void testEmptyId_whenAlarm_thenReturnAlarmId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.ALARM);

    // Assert
    assertTrue(actualEmptyIdResult instanceof AlarmId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.ALARM, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code API_USAGE_STATE}.</li>
   *   <li>Then return {@link ApiUsageStateId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'API_USAGE_STATE'; then return ApiUsageStateId")
  void testEmptyId_whenApiUsageState_thenReturnApiUsageStateId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.API_USAGE_STATE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof ApiUsageStateId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.API_USAGE_STATE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code ASSET_PROFILE}.</li>
   *   <li>Then return {@link AssetProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'ASSET_PROFILE'; then return AssetProfileId")
  void testEmptyId_whenAssetProfile_thenReturnAssetProfileId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.ASSET_PROFILE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof AssetProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.ASSET_PROFILE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code ASSET}.</li>
   *   <li>Then return {@link AssetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'ASSET'; then return AssetId")
  void testEmptyId_whenAsset_thenReturnAssetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.ASSET);

    // Assert
    assertTrue(actualEmptyIdResult instanceof AssetId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.ASSET, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code CUSTOMER}.</li>
   *   <li>Then return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'CUSTOMER'; then return CustomerId")
  void testEmptyId_whenCustomer_thenReturnCustomerId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.CUSTOMER);

    // Assert
    assertTrue(actualEmptyIdResult instanceof CustomerId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.CUSTOMER, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code DASHBOARD}.</li>
   *   <li>Then return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'DASHBOARD'; then return DashboardId")
  void testEmptyId_whenDashboard_thenReturnDashboardId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.DASHBOARD);

    // Assert
    assertTrue(actualEmptyIdResult instanceof DashboardId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.DASHBOARD, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code DEVICE_PROFILE}.</li>
   *   <li>Then return {@link DeviceProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'DEVICE_PROFILE'; then return DeviceProfileId")
  void testEmptyId_whenDeviceProfile_thenReturnDeviceProfileId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.DEVICE_PROFILE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof DeviceProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code DEVICE}.</li>
   *   <li>Then return {@link DeviceId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'DEVICE'; then return DeviceId")
  void testEmptyId_whenDevice_thenReturnDeviceId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.DEVICE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof DeviceId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.DEVICE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code DOMAIN}.</li>
   *   <li>Then return {@link DomainId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'DOMAIN'; then return DomainId")
  void testEmptyId_whenDomain_thenReturnDomainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.DOMAIN);

    // Assert
    assertTrue(actualEmptyIdResult instanceof DomainId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.DOMAIN, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code EDGE}.</li>
   *   <li>Then return {@link EdgeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'EDGE'; then return EdgeId")
  void testEmptyId_whenEdge_thenReturnEdgeId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.EDGE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof EdgeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.EDGE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code ENTITY_VIEW}.</li>
   *   <li>Then return {@link EntityViewId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'ENTITY_VIEW'; then return EntityViewId")
  void testEmptyId_whenEntityView_thenReturnEntityViewId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.ENTITY_VIEW);

    // Assert
    assertTrue(actualEmptyIdResult instanceof EntityViewId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code MOBILE_APP}.</li>
   *   <li>Then return {@link MobileAppId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'MOBILE_APP'; then return MobileAppId")
  void testEmptyId_whenMobileApp_thenReturnMobileAppId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.MOBILE_APP);

    // Assert
    assertTrue(actualEmptyIdResult instanceof MobileAppId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.MOBILE_APP, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION_REQUEST}.</li>
   *   <li>Then return {@link NotificationRequestId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'NOTIFICATION_REQUEST'; then return NotificationRequestId")
  void testEmptyId_whenNotificationRequest_thenReturnNotificationRequestId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.NOTIFICATION_REQUEST);

    // Assert
    assertTrue(actualEmptyIdResult instanceof NotificationRequestId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.NOTIFICATION_REQUEST, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION_RULE}.</li>
   *   <li>Then return {@link NotificationRuleId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'NOTIFICATION_RULE'; then return NotificationRuleId")
  void testEmptyId_whenNotificationRule_thenReturnNotificationRuleId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.NOTIFICATION_RULE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof NotificationRuleId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.NOTIFICATION_RULE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION_TARGET}.</li>
   *   <li>Then return {@link NotificationTargetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'NOTIFICATION_TARGET'; then return NotificationTargetId")
  void testEmptyId_whenNotificationTarget_thenReturnNotificationTargetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.NOTIFICATION_TARGET);

    // Assert
    assertTrue(actualEmptyIdResult instanceof NotificationTargetId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION_TEMPLATE}.</li>
   *   <li>Then return {@link NotificationTemplateId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'NOTIFICATION_TEMPLATE'; then return NotificationTemplateId")
  void testEmptyId_whenNotificationTemplate_thenReturnNotificationTemplateId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.NOTIFICATION_TEMPLATE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof NotificationTemplateId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION}.</li>
   *   <li>Then return {@link NotificationId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'NOTIFICATION'; then return NotificationId")
  void testEmptyId_whenNotification_thenReturnNotificationId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.NOTIFICATION);

    // Assert
    assertTrue(actualEmptyIdResult instanceof NotificationId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.NOTIFICATION, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code OAUTH2_CLIENT}.</li>
   *   <li>Then return {@link OAuth2ClientId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'OAUTH2_CLIENT'; then return OAuth2ClientId")
  void testEmptyId_whenOauth2Client_thenReturnOAuth2ClientId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.OAUTH2_CLIENT);

    // Assert
    assertTrue(actualEmptyIdResult instanceof OAuth2ClientId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.OAUTH2_CLIENT, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code OTA_PACKAGE}.</li>
   *   <li>Then return {@link OtaPackageId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'OTA_PACKAGE'; then return OtaPackageId")
  void testEmptyId_whenOtaPackage_thenReturnOtaPackageId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.OTA_PACKAGE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof OtaPackageId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.OTA_PACKAGE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code QUEUE_STATS}.</li>
   *   <li>Then return {@link QueueStatsId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'QUEUE_STATS'; then return QueueStatsId")
  void testEmptyId_whenQueueStats_thenReturnQueueStatsId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.QUEUE_STATS);

    // Assert
    assertTrue(actualEmptyIdResult instanceof QueueStatsId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.QUEUE_STATS, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code QUEUE}.</li>
   *   <li>Then return {@link QueueId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'QUEUE'; then return QueueId")
  void testEmptyId_whenQueue_thenReturnQueueId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.QUEUE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof QueueId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.QUEUE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code RPC}.</li>
   *   <li>Then return {@link RpcId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'RPC'; then return RpcId")
  void testEmptyId_whenRpc_thenReturnRpcId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.RPC);

    // Assert
    assertTrue(actualEmptyIdResult instanceof RpcId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.RPC, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code RULE_CHAIN}.</li>
   *   <li>Then return {@link RuleChainId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'RULE_CHAIN'; then return RuleChainId")
  void testEmptyId_whenRuleChain_thenReturnRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.RULE_CHAIN);

    // Assert
    assertTrue(actualEmptyIdResult instanceof RuleChainId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code RULE_NODE}.</li>
   *   <li>Then return {@link RuleNodeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'RULE_NODE'; then return RuleNodeId")
  void testEmptyId_whenRuleNode_thenReturnRuleNodeId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.RULE_NODE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof RuleNodeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.RULE_NODE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code TB_RESOURCE}.</li>
   *   <li>Then return {@link TbResourceId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'TB_RESOURCE'; then return TbResourceId")
  void testEmptyId_whenTbResource_thenReturnTbResourceId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.TB_RESOURCE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof TbResourceId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.TB_RESOURCE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code TENANT_PROFILE}.</li>
   *   <li>Then return {@link TenantProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'TENANT_PROFILE'; then return TenantProfileId")
  void testEmptyId_whenTenantProfile_thenReturnTenantProfileId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.TENANT_PROFILE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof TenantProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.TENANT_PROFILE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code USER}.</li>
   *   <li>Then return {@link UserId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'USER'; then return UserId")
  void testEmptyId_whenUser_thenReturnUserId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.USER);

    // Assert
    assertTrue(actualEmptyIdResult instanceof UserId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.USER, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code WIDGET_TYPE}.</li>
   *   <li>Then return {@link WidgetTypeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'WIDGET_TYPE'; then return WidgetTypeId")
  void testEmptyId_whenWidgetType_thenReturnWidgetTypeId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.WIDGET_TYPE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof WidgetTypeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.WIDGET_TYPE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   * <ul>
   *   <li>When {@code WIDGETS_BUNDLE}.</li>
   *   <li>Then return {@link WidgetsBundleId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'WIDGETS_BUNDLE'; then return WidgetsBundleId")
  void testEmptyId_whenWidgetsBundle_thenReturnWidgetsBundleId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityId actualEmptyIdResult = (new AuditLogController()).emptyId(EntityType.WIDGETS_BUNDLE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof WidgetsBundleId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#toException(Throwable)}.
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then return LocalizedMessage is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#toException(Throwable)}
   */
  @Test
  @DisplayName("Test toException(Throwable); when IOException(String) with 'foo'; then return LocalizedMessage is 'foo'")
  void testToException_whenIOExceptionWithFoo_thenReturnLocalizedMessageIsFoo() {
    // Arrange and Act
    Exception actualToExceptionResult = BaseController.toException(new IOException("foo"));

    // Assert
    assertEquals("foo", actualToExceptionResult.getLocalizedMessage());
    assertEquals("foo", actualToExceptionResult.getMessage());
    assertNull(actualToExceptionResult.getCause());
    assertEquals(0, actualToExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link BaseController#toException(Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#toException(Throwable)}
   */
  @Test
  @DisplayName("Test toException(Throwable); when 'null'; then return 'null'")
  void testToException_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BaseController.toException(null));
  }

  /**
   * Test {@link BaseController#toException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return LocalizedMessage is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#toException(Throwable)}
   */
  @Test
  @DisplayName("Test toException(Throwable); when Throwable(); then return LocalizedMessage is 'java.lang.Throwable'")
  void testToException_whenThrowable_thenReturnLocalizedMessageIsJavaLangThrowable() {
    // Arrange
    Throwable error = new Throwable();

    // Act
    Exception actualToExceptionResult = BaseController.toException(error);

    // Assert
    assertEquals("java.lang.Throwable", actualToExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualToExceptionResult.getMessage());
    assertSame(error, actualToExceptionResult.getCause());
  }

  /**
   * Test
   * {@link BaseController#logEntityAction(SecurityUser, EntityType, HasName, ActionType)}
   * with {@code user}, {@code entityType}, {@code savedEntity},
   * {@code actionType}.
   * <p>
   * Method under test:
   * {@link BaseController#logEntityAction(SecurityUser, EntityType, HasName, ActionType)}
   */
  @Test
  @DisplayName("Test logEntityAction(SecurityUser, EntityType, HasName, ActionType) with 'user', 'entityType', 'savedEntity', 'actionType'")
  void testLogEntityActionWithUserEntityTypeSavedEntityActionType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    SecurityUser user = new SecurityUser();
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> auditLogController.logEntityAction(user, EntityType.TENANT, customer, ActionType.ADDED));
    verify(customer).getId();
  }

  /**
   * Test {@link BaseController#parseMediaType(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link MediaType#APPLICATION_OCTET_STREAM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#parseMediaType(String)}
   */
  @Test
  @DisplayName("Test parseMediaType(String); when 'null'; then return APPLICATION_OCTET_STREAM")
  void testParseMediaType_whenNull_thenReturnApplication_octet_stream() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    MediaType actualParseMediaTypeResult = (new AuditLogController()).parseMediaType(null);

    // Assert
    assertSame(actualParseMediaTypeResult.APPLICATION_OCTET_STREAM, actualParseMediaTypeResult);
  }

  /**
   * Test {@link BaseController#parseMediaType(String)}.
   * <ul>
   *   <li>When {@code text/plain}.</li>
   *   <li>Then return {@link MediaType#TEXT_PLAIN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#parseMediaType(String)}
   */
  @Test
  @DisplayName("Test parseMediaType(String); when 'text/plain'; then return TEXT_PLAIN")
  void testParseMediaType_whenTextPlain_thenReturnText_plain() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    MediaType actualParseMediaTypeResult = (new AuditLogController()).parseMediaType("text/plain");

    // Assert
    assertEquals(actualParseMediaTypeResult.TEXT_PLAIN, actualParseMediaTypeResult);
  }

  /**
   * Test {@link BaseController#wrapFuture(ListenableFuture, long)} with
   * {@code future}, {@code timeoutMs}.
   * <p>
   * Method under test: {@link BaseController#wrapFuture(ListenableFuture, long)}
   */
  @Test
  @DisplayName("Test wrapFuture(ListenableFuture, long) with 'future', 'timeoutMs'")
  void testWrapFutureWithFutureTimeoutMs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    SettableFuture<Object> delegate = SettableFuture.create();

    // Act
    DeferredResult<Object> actualWrapFutureResult = auditLogController.wrapFuture(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))), 10L);

    // Assert
    assertNull(actualWrapFutureResult.getResult());
    assertFalse(actualWrapFutureResult.hasResult());
    assertFalse(actualWrapFutureResult.isSetOrExpired());
  }

  /**
   * Test {@link BaseController#wrapFuture(ListenableFuture, long)} with
   * {@code future}, {@code timeoutMs}.
   * <ul>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#wrapFuture(ListenableFuture, long)}
   */
  @Test
  @DisplayName("Test wrapFuture(ListenableFuture, long) with 'future', 'timeoutMs'; then calls addListener(Runnable, Executor)")
  void testWrapFutureWithFutureTimeoutMs_thenCallsAddListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    // Act
    DeferredResult<Object> actualWrapFutureResult = auditLogController.wrapFuture(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))), 10L);

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    assertNull(actualWrapFutureResult.getResult());
    assertFalse(actualWrapFutureResult.hasResult());
    assertFalse(actualWrapFutureResult.isSetOrExpired());
  }

  /**
   * Test {@link BaseController#wrapFuture(ListenableFuture)} with {@code future}.
   * <ul>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#wrapFuture(ListenableFuture)}
   */
  @Test
  @DisplayName("Test wrapFuture(ListenableFuture) with 'future'; then calls addListener(Runnable, Executor)")
  void testWrapFutureWithFuture_thenCallsAddListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    // Act
    DeferredResult<Object> actualWrapFutureResult = auditLogController.wrapFuture(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    assertNull(actualWrapFutureResult.getResult());
    assertFalse(actualWrapFutureResult.hasResult());
    assertFalse(actualWrapFutureResult.isSetOrExpired());
  }

  /**
   * Test {@link BaseController#wrapFuture(ListenableFuture)} with {@code future}.
   * <ul>
   *   <li>When
   * {@link ListenableFutureToApiFuture#ListenableFutureToApiFuture(ListenableFuture)}
   * with delegate is create.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#wrapFuture(ListenableFuture)}
   */
  @Test
  @DisplayName("Test wrapFuture(ListenableFuture) with 'future'; when ListenableFutureToApiFuture(ListenableFuture) with delegate is create")
  void testWrapFutureWithFuture_whenListenableFutureToApiFutureWithDelegateIsCreate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    SettableFuture<Object> delegate = SettableFuture.create();

    // Act
    DeferredResult<Object> actualWrapFutureResult = auditLogController.wrapFuture(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));

    // Assert
    assertNull(actualWrapFutureResult.getResult());
    assertFalse(actualWrapFutureResult.hasResult());
    assertFalse(actualWrapFutureResult.isSetOrExpired());
  }

  /**
   * Test {@link BaseController#createEntityDataSortOrder(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createEntityDataSortOrder(String, String)}
   */
  @Test
  @DisplayName("Test createEntityDataSortOrder(String, String); when empty string; then return 'null'")
  void testCreateEntityDataSortOrder_whenEmptyString_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AuditLogController()).createEntityDataSortOrder("", null));
  }

  /**
   * Test {@link BaseController#createEntityDataSortOrder(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createEntityDataSortOrder(String, String)}
   */
  @Test
  @DisplayName("Test createEntityDataSortOrder(String, String); when 'null'; then return 'null'")
  void testCreateEntityDataSortOrder_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AuditLogController()).createEntityDataSortOrder(null, null));
  }

  /**
   * Test {@link BaseController#createEntityDataSortOrder(String, String)}.
   * <ul>
   *   <li>When {@code Sort Property}.</li>
   *   <li>Then return Key Key is {@code Sort Property}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseController#createEntityDataSortOrder(String, String)}
   */
  @Test
  @DisplayName("Test createEntityDataSortOrder(String, String); when 'Sort Property'; then return Key Key is 'Sort Property'")
  void testCreateEntityDataSortOrder_whenSortProperty_thenReturnKeyKeyIsSortProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityDataSortOrder actualCreateEntityDataSortOrderResult = (new AuditLogController())
        .createEntityDataSortOrder("Sort Property", null);

    // Assert
    EntityKey key = actualCreateEntityDataSortOrderResult.getKey();
    assertEquals("Sort Property", key.getKey());
    assertNull(actualCreateEntityDataSortOrderResult.getDirection());
    assertEquals(EntityKeyType.ENTITY_FIELD, key.getType());
  }

  /**
   * Test {@link BaseController#redirectTo(String)}.
   * <p>
   * Method under test: {@link BaseController#redirectTo(String)}
   */
  @Test
  @DisplayName("Test redirectTo(String)")
  void testRedirectTo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ResponseEntity<Object> actualRedirectToResult = (new AuditLogController()).redirectTo("Location");

    // Assert
    HttpStatusCode statusCode = actualRedirectToResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    HttpHeaders headers = actualRedirectToResult.getHeaders();
    assertEquals(1, headers.size());
    List<String> getResult = headers.get(HttpHeaders.LOCATION);
    assertEquals(1, getResult.size());
    assertEquals("Location", getResult.get(0));
    assertNull(actualRedirectToResult.getBody());
    assertEquals(303, actualRedirectToResult.getStatusCodeValue());
    assertEquals(HttpStatus.SEE_OTHER, statusCode);
    assertFalse(actualRedirectToResult.hasBody());
  }

  /**
   * Test {@link BaseController#getOAuth2ClientIds(UUID[])}.
   * <ul>
   *   <li>When empty array of {@link UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#getOAuth2ClientIds(UUID[])}
   */
  @Test
  @DisplayName("Test getOAuth2ClientIds(UUID[]); when empty array of UUID; then return Empty")
  void testGetOAuth2ClientIds_whenEmptyArrayOfUuid_thenReturnEmpty() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new AuditLogController()).getOAuth2ClientIds(new UUID[]{}).isEmpty());
  }

  /**
   * Test {@link BaseController#getOAuth2ClientIds(UUID[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseController#getOAuth2ClientIds(UUID[])}
   */
  @Test
  @DisplayName("Test getOAuth2ClientIds(UUID[]); when 'null'; then return Empty")
  void testGetOAuth2ClientIds_whenNull_thenReturnEmpty() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new AuditLogController()).getOAuth2ClientIds(null).isEmpty());
  }

  /**
   * Test {@link BaseController#isEdgesEnabled()}.
   * <p>
   * Method under test: {@link BaseController#isEdgesEnabled()}
   */
  @Test
  @DisplayName("Test isEdgesEnabled()")
  void testIsEdgesEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new AuditLogController()).isEdgesEnabled());
  }

  /**
   * Test {@link BaseController#isLogControllerErrorStackTrace()}.
   * <p>
   * Method under test: {@link BaseController#isLogControllerErrorStackTrace()}
   */
  @Test
  @DisplayName("Test isLogControllerErrorStackTrace()")
  void testIsLogControllerErrorStackTrace() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new AuditLogController()).isLogControllerErrorStackTrace());
  }
}
