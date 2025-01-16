package org.thingsboard.server.service.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.script.api.ScriptStatCallback;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.HasTenantId;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.asset.AssetProfileService;
import org.thingsboard.server.dao.asset.AssetService;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.device.DeviceService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.ota.OtaPackageService;
import org.thingsboard.server.dao.resource.ResourceService;
import org.thingsboard.server.dao.rpc.RpcService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiUsageStateService;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.security.permission.AccessControlService;
import org.thingsboard.server.service.security.permission.Operation;
import org.thingsboard.server.service.security.permission.Resource;

@ContextConfiguration(classes = {AccessValidator.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AccessValidatorDiffblueTest {
  @Autowired
  private AccessValidator accessValidator;

  @MockBean
  private AccessControlService accessControlService;

  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApiUsageStateService apiUsageStateService;

  @MockBean
  private AssetProfileService assetProfileService;

  @MockBean
  private AssetService assetService;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private DeviceProfileService deviceProfileService;

  @MockBean
  private DeviceService deviceService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private OtaPackageService otaPackageService;

  @MockBean
  private ResourceService resourceService;

  @MockBean
  private RpcService rpcService;

  @MockBean
  private RuleChainService ruleChainService;

  @MockBean
  private TenantService tenantService;

  @MockBean
  private UserService userService;

  /**
   * Test
   * {@link AccessValidator#validateEntityAndCallback(SecurityUser, Operation, EntityId, ThreeConsumer)}
   * with {@code currentUser}, {@code operation}, {@code entityId},
   * {@code onSuccess}.
   * <p>
   * Method under test:
   * {@link AccessValidator#validateEntityAndCallback(SecurityUser, Operation, EntityId, AccessValidator.ThreeConsumer)}
   */
  @Test
  @DisplayName("Test validateEntityAndCallback(SecurityUser, Operation, EntityId, ThreeConsumer) with 'currentUser', 'operation', 'entityId', 'onSuccess'")
  void testValidateEntityAndCallbackWithCurrentUserOperationEntityIdOnSuccess() throws ThingsboardException {
    // Arrange
    SecurityUser currentUser = new SecurityUser();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> accessValidator.validateEntityAndCallback(currentUser,
        Operation.ALL, new AlarmId(UUID.randomUUID()), mock(AccessValidator.ThreeConsumer.class)));
  }

  /**
   * Test
   * {@link AccessValidator#validateEntityAndCallback(SecurityUser, Operation, EntityId, ThreeConsumer)}
   * with {@code currentUser}, {@code operation}, {@code entityId},
   * {@code onSuccess}.
   * <p>
   * Method under test:
   * {@link AccessValidator#validateEntityAndCallback(SecurityUser, Operation, EntityId, AccessValidator.ThreeConsumer)}
   */
  @Test
  @DisplayName("Test validateEntityAndCallback(SecurityUser, Operation, EntityId, ThreeConsumer) with 'currentUser', 'operation', 'entityId', 'onSuccess'")
  void testValidateEntityAndCallbackWithCurrentUserOperationEntityIdOnSuccess2() throws ThingsboardException {
    // Arrange
    SecurityUser currentUser = new SecurityUser();

    // Act and Assert
    Object result = accessValidator
        .validateEntityAndCallback(currentUser, Operation.ALL, new ApiUsageStateId(UUID.randomUUID()),
            mock(AccessValidator.ThreeConsumer.class))
        .getResult();
    HttpStatusCode statusCode = ((ResponseEntity<Object>) result).getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertTrue(result instanceof ResponseEntity);
    assertEquals(403, ((ResponseEntity<Object>) result).getStatusCodeValue());
    assertEquals(HttpStatus.FORBIDDEN, statusCode);
    assertEquals(AccessValidator.SYSTEM_ADMINISTRATOR_IS_NOT_ALLOWED_TO_PERFORM_THIS_OPERATION,
        ((ResponseEntity<Object>) result).getBody());
  }

  /**
   * Test
   * {@link AccessValidator#validateEntityAndCallback(SecurityUser, Operation, EntityId, ThreeConsumer)}
   * with {@code currentUser}, {@code operation}, {@code entityId},
   * {@code onSuccess}.
   * <p>
   * Method under test:
   * {@link AccessValidator#validateEntityAndCallback(SecurityUser, Operation, EntityId, AccessValidator.ThreeConsumer)}
   */
  @Test
  @DisplayName("Test validateEntityAndCallback(SecurityUser, Operation, EntityId, ThreeConsumer) with 'currentUser', 'operation', 'entityId', 'onSuccess'")
  void testValidateEntityAndCallbackWithCurrentUserOperationEntityIdOnSuccess3() throws ThingsboardException {
    // Arrange
    SecurityUser currentUser = mock(SecurityUser.class);
    when(currentUser.isCustomerUser()).thenReturn(true);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    DeferredResult<ResponseEntity> actualValidateEntityAndCallbackResult = accessValidator
        .validateEntityAndCallback(currentUser, Operation.ALL, entityId, mock(AccessValidator.ThreeConsumer.class));

    // Assert
    verify(currentUser).isCustomerUser();
    verify(entityId).getEntityType();
    Object result = actualValidateEntityAndCallbackResult.getResult();
    HttpStatusCode statusCode = ((ResponseEntity<Object>) result).getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertTrue(result instanceof ResponseEntity);
    assertEquals(403, ((ResponseEntity<Object>) result).getStatusCodeValue());
    assertEquals(HttpStatus.FORBIDDEN, statusCode);
    assertTrue(((ResponseEntity<Object>) result).hasBody());
    assertEquals(AccessValidator.CUSTOMER_USER_IS_NOT_ALLOWED_TO_PERFORM_THIS_OPERATION,
        ((ResponseEntity<Object>) result).getBody());
  }

  /**
   * Test
   * {@link AccessValidator#validateEntityAndCallback(SecurityUser, Operation, EntityId, ThreeConsumer)}
   * with {@code currentUser}, {@code operation}, {@code entityId},
   * {@code onSuccess}.
   * <p>
   * Method under test:
   * {@link AccessValidator#validateEntityAndCallback(SecurityUser, Operation, EntityId, AccessValidator.ThreeConsumer)}
   */
  @Test
  @DisplayName("Test validateEntityAndCallback(SecurityUser, Operation, EntityId, ThreeConsumer) with 'currentUser', 'operation', 'entityId', 'onSuccess'")
  void testValidateEntityAndCallbackWithCurrentUserOperationEntityIdOnSuccess4() throws ThingsboardException {
    // Arrange
    SecurityUser currentUser = mock(SecurityUser.class);
    when(currentUser.isSystemAdmin()).thenReturn(true);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.CUSTOMER);

    // Act
    DeferredResult<ResponseEntity> actualValidateEntityAndCallbackResult = accessValidator
        .validateEntityAndCallback(currentUser, Operation.ALL, entityId, mock(AccessValidator.ThreeConsumer.class));

    // Assert
    verify(currentUser).isSystemAdmin();
    verify(entityId).getEntityType();
    Object result = actualValidateEntityAndCallbackResult.getResult();
    HttpStatusCode statusCode = ((ResponseEntity<Object>) result).getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertTrue(result instanceof ResponseEntity);
    assertEquals(403, ((ResponseEntity<Object>) result).getStatusCodeValue());
    assertEquals(HttpStatus.FORBIDDEN, statusCode);
    assertTrue(((ResponseEntity<Object>) result).hasBody());
    assertEquals(AccessValidator.SYSTEM_ADMINISTRATOR_IS_NOT_ALLOWED_TO_PERFORM_THIS_OPERATION,
        ((ResponseEntity<Object>) result).getBody());
  }

  /**
   * Test
   * {@link AccessValidator#validateEntityAndCallback(SecurityUser, Operation, EntityId, ThreeConsumer, BiConsumer)}
   * with {@code currentUser}, {@code operation}, {@code entityId},
   * {@code onSuccess}, {@code onFailure}.
   * <p>
   * Method under test:
   * {@link AccessValidator#validateEntityAndCallback(SecurityUser, Operation, EntityId, AccessValidator.ThreeConsumer, BiConsumer)}
   */
  @Test
  @DisplayName("Test validateEntityAndCallback(SecurityUser, Operation, EntityId, ThreeConsumer, BiConsumer) with 'currentUser', 'operation', 'entityId', 'onSuccess', 'onFailure'")
  void testValidateEntityAndCallbackWithCurrentUserOperationEntityIdOnSuccessOnFailure() throws ThingsboardException {
    // Arrange
    SecurityUser currentUser = new SecurityUser();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> accessValidator.validateEntityAndCallback(currentUser, Operation.ALL, new AlarmId(UUID.randomUUID()),
            mock(AccessValidator.ThreeConsumer.class), mock(BiConsumer.class)));
  }

  /**
   * Test
   * {@link AccessValidator#validateEntityAndCallback(SecurityUser, Operation, EntityId, ThreeConsumer, BiConsumer)}
   * with {@code currentUser}, {@code operation}, {@code entityId},
   * {@code onSuccess}, {@code onFailure}.
   * <p>
   * Method under test:
   * {@link AccessValidator#validateEntityAndCallback(SecurityUser, Operation, EntityId, AccessValidator.ThreeConsumer, BiConsumer)}
   */
  @Test
  @DisplayName("Test validateEntityAndCallback(SecurityUser, Operation, EntityId, ThreeConsumer, BiConsumer) with 'currentUser', 'operation', 'entityId', 'onSuccess', 'onFailure'")
  void testValidateEntityAndCallbackWithCurrentUserOperationEntityIdOnSuccessOnFailure2() throws ThingsboardException {
    // Arrange
    SettableFuture<User> delegate = SettableFuture.create();
    when(userService.findUserByIdAsync(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    SecurityUser currentUser = mock(SecurityUser.class);
    when(currentUser.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    when(entityId.getEntityType()).thenReturn(EntityType.USER);

    // Act
    DeferredResult<ResponseEntity> actualValidateEntityAndCallbackResult = accessValidator.validateEntityAndCallback(
        currentUser, Operation.ALL, entityId, mock(AccessValidator.ThreeConsumer.class), mock(BiConsumer.class));

    // Assert
    verify(currentUser).getTenantId();
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(userService).findUserByIdAsync(isA(TenantId.class), isA(UserId.class));
    assertNull(actualValidateEntityAndCallbackResult.getResult());
    assertFalse(actualValidateEntityAndCallbackResult.hasResult());
    assertFalse(actualValidateEntityAndCallbackResult.isSetOrExpired());
  }

  /**
   * Test
   * {@link AccessValidator#validateEntityAndCallback(SecurityUser, Operation, EntityId, ThreeConsumer, BiConsumer)}
   * with {@code currentUser}, {@code operation}, {@code entityId},
   * {@code onSuccess}, {@code onFailure}.
   * <p>
   * Method under test:
   * {@link AccessValidator#validateEntityAndCallback(SecurityUser, Operation, EntityId, AccessValidator.ThreeConsumer, BiConsumer)}
   */
  @Test
  @DisplayName("Test validateEntityAndCallback(SecurityUser, Operation, EntityId, ThreeConsumer, BiConsumer) with 'currentUser', 'operation', 'entityId', 'onSuccess', 'onFailure'")
  void testValidateEntityAndCallbackWithCurrentUserOperationEntityIdOnSuccessOnFailure3() throws ThingsboardException {
    // Arrange
    ListenableFutureTask<User> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ApiFutureToListenableFuture<User> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(userService.findUserByIdAsync(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(apiFutureToListenableFuture);
    SecurityUser currentUser = mock(SecurityUser.class);
    when(currentUser.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    when(entityId.getEntityType()).thenReturn(EntityType.USER);

    // Act
    DeferredResult<ResponseEntity> actualValidateEntityAndCallbackResult = accessValidator.validateEntityAndCallback(
        currentUser, Operation.ALL, entityId, mock(AccessValidator.ThreeConsumer.class), mock(BiConsumer.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(currentUser).getTenantId();
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(userService).findUserByIdAsync(isA(TenantId.class), isA(UserId.class));
    assertNull(actualValidateEntityAndCallbackResult.getResult());
    assertFalse(actualValidateEntityAndCallbackResult.hasResult());
    assertFalse(actualValidateEntityAndCallbackResult.isSetOrExpired());
  }

  /**
   * Test
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}.
   * <ul>
   *   <li>Given {@code CUSTOMER}.</li>
   *   <li>When {@link AlarmId} {@link AlarmId#getEntityType()} return
   * {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}
   */
  @Test
  @DisplayName("Test validate(SecurityUser, Operation, EntityId, FutureCallback); given 'CUSTOMER'; when AlarmId getEntityType() return 'CUSTOMER'")
  void testValidate_givenCustomer_whenAlarmIdGetEntityTypeReturnCustomer() {
    // Arrange
    SecurityUser currentUser = mock(SecurityUser.class);
    when(currentUser.isSystemAdmin()).thenReturn(true);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.CUSTOMER);
    AtomicInteger successMsgs = new AtomicInteger(1);
    AtomicInteger timeoutMsgs = new AtomicInteger(1);

    // Act
    accessValidator.validate(currentUser, Operation.ALL, entityId,
        new ScriptStatCallback<>(successMsgs, timeoutMsgs, new AtomicInteger(1)));

    // Assert
    verify(currentUser).isSystemAdmin();
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}.
   * <ul>
   *   <li>Given
   * {@link ListenableFutureToApiFuture#ListenableFutureToApiFuture(ListenableFuture)}
   * with delegate is create.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}
   */
  @Test
  @DisplayName("Test validate(SecurityUser, Operation, EntityId, FutureCallback); given ListenableFutureToApiFuture(ListenableFuture) with delegate is create; then calls getId()")
  void testValidate_givenListenableFutureToApiFutureWithDelegateIsCreate_thenCallsGetId() {
    // Arrange
    SettableFuture<User> delegate = SettableFuture.create();
    when(userService.findUserByIdAsync(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    SecurityUser currentUser = mock(SecurityUser.class);
    when(currentUser.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    when(entityId.getEntityType()).thenReturn(EntityType.USER);
    AtomicInteger successMsgs = new AtomicInteger(1);
    AtomicInteger timeoutMsgs = new AtomicInteger(1);

    // Act
    accessValidator.validate(currentUser, Operation.ALL, entityId,
        new ScriptStatCallback<>(successMsgs, timeoutMsgs, new AtomicInteger(1)));

    // Assert
    verify(currentUser).getTenantId();
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(userService).findUserByIdAsync(isA(TenantId.class), isA(UserId.class));
  }

  /**
   * Test
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}.
   * <ul>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}
   */
  @Test
  @DisplayName("Test validate(SecurityUser, Operation, EntityId, FutureCallback); then calls addListener(Runnable, Executor)")
  void testValidate_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<User> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ApiFutureToListenableFuture<User> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(userService.findUserByIdAsync(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(apiFutureToListenableFuture);
    SecurityUser currentUser = mock(SecurityUser.class);
    when(currentUser.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    when(entityId.getEntityType()).thenReturn(EntityType.USER);
    AtomicInteger successMsgs = new AtomicInteger(1);
    AtomicInteger timeoutMsgs = new AtomicInteger(1);

    // Act
    accessValidator.validate(currentUser, Operation.ALL, entityId,
        new ScriptStatCallback<>(successMsgs, timeoutMsgs, new AtomicInteger(1)));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(currentUser).getTenantId();
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(userService).findUserByIdAsync(isA(TenantId.class), isA(UserId.class));
  }

  /**
   * Test
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}.
   * <ul>
   *   <li>Then calls
   * {@link ApiUsageStateService#findApiUsageStateById(TenantId, ApiUsageStateId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}
   */
  @Test
  @DisplayName("Test validate(SecurityUser, Operation, EntityId, FutureCallback); then calls findApiUsageStateById(TenantId, ApiUsageStateId)")
  void testValidate_thenCallsFindApiUsageStateById() throws ThingsboardException {
    // Arrange
    doNothing().when(accessControlService)
        .checkPermission(Mockito.<SecurityUser>any(), Mockito.<Resource>any(), Mockito.<Operation>any(),
            Mockito.<EntityId>any(), Mockito.<HasTenantId>any());
    when(apiUsageStateService.findApiUsageStateById(Mockito.<TenantId>any(), Mockito.<ApiUsageStateId>any()))
        .thenReturn(new ApiUsageState());
    SecurityUser currentUser = mock(SecurityUser.class);
    when(currentUser.isSystemAdmin()).thenReturn(false);
    when(currentUser.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    ApiUsageStateId entityId = new ApiUsageStateId(UUID.randomUUID());
    AtomicInteger successMsgs = new AtomicInteger(1);
    AtomicInteger timeoutMsgs = new AtomicInteger(1);

    // Act
    accessValidator.validate(currentUser, Operation.ALL, entityId,
        new ScriptStatCallback<>(successMsgs, timeoutMsgs, new AtomicInteger(1)));

    // Assert
    verify(currentUser).getTenantId();
    verify(currentUser).isSystemAdmin();
    verify(apiUsageStateService).findApiUsageStateById(isA(TenantId.class), isA(ApiUsageStateId.class));
    verify(accessControlService).checkPermission(isA(SecurityUser.class), eq(Resource.API_USAGE_STATE),
        eq(Operation.ALL), isA(EntityId.class), isA(HasTenantId.class));
  }

  /**
   * Test
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}
   */
  @Test
  @DisplayName("Test validate(SecurityUser, Operation, EntityId, FutureCallback); when AlarmId(UUID) with id is randomUUID; then throw IllegalStateException")
  void testValidate_whenAlarmIdWithIdIsRandomUUID_thenThrowIllegalStateException() {
    // Arrange
    SecurityUser currentUser = mock(SecurityUser.class);
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    AtomicInteger successMsgs = new AtomicInteger(1);
    AtomicInteger timeoutMsgs = new AtomicInteger(1);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> accessValidator.validate(currentUser, Operation.ALL, entityId,
        new ScriptStatCallback<>(successMsgs, timeoutMsgs, new AtomicInteger(1))));
  }

  /**
   * Test
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}.
   * <ul>
   *   <li>When {@link ApiUsageStateId#ApiUsageStateId(UUID)} with id is
   * randomUUID.</li>
   *   <li>Then calls {@link User#isSystemAdmin()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}
   */
  @Test
  @DisplayName("Test validate(SecurityUser, Operation, EntityId, FutureCallback); when ApiUsageStateId(UUID) with id is randomUUID; then calls isSystemAdmin()")
  void testValidate_whenApiUsageStateIdWithIdIsRandomUUID_thenCallsIsSystemAdmin() {
    // Arrange
    SecurityUser currentUser = mock(SecurityUser.class);
    when(currentUser.isSystemAdmin()).thenReturn(true);
    ApiUsageStateId entityId = new ApiUsageStateId(UUID.randomUUID());
    AtomicInteger successMsgs = new AtomicInteger(1);
    AtomicInteger timeoutMsgs = new AtomicInteger(1);

    // Act
    accessValidator.validate(currentUser, Operation.ALL, entityId,
        new ScriptStatCallback<>(successMsgs, timeoutMsgs, new AtomicInteger(1)));

    // Assert
    verify(currentUser).isSystemAdmin();
  }

  /**
   * Test
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}.
   * <ul>
   *   <li>When {@link SecurityUser} {@link User#isCustomerUser()} return
   * {@code false}.</li>
   *   <li>Then calls {@link User#isCustomerUser()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}
   */
  @Test
  @DisplayName("Test validate(SecurityUser, Operation, EntityId, FutureCallback); when SecurityUser isCustomerUser() return 'false'; then calls isCustomerUser()")
  void testValidate_whenSecurityUserIsCustomerUserReturnFalse_thenCallsIsCustomerUser() {
    // Arrange
    SecurityUser currentUser = mock(SecurityUser.class);
    when(currentUser.isCustomerUser()).thenReturn(false);
    when(currentUser.isSystemAdmin()).thenReturn(true);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    AtomicInteger successMsgs = new AtomicInteger(1);
    AtomicInteger timeoutMsgs = new AtomicInteger(1);

    // Act
    accessValidator.validate(currentUser, Operation.ALL, entityId,
        new ScriptStatCallback<>(successMsgs, timeoutMsgs, new AtomicInteger(1)));

    // Assert
    verify(currentUser).isCustomerUser();
    verify(currentUser).isSystemAdmin();
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}.
   * <ul>
   *   <li>When {@link SecurityUser} {@link User#isCustomerUser()} return
   * {@code true}.</li>
   *   <li>Then calls {@link User#isCustomerUser()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AccessValidator#validate(SecurityUser, Operation, EntityId, FutureCallback)}
   */
  @Test
  @DisplayName("Test validate(SecurityUser, Operation, EntityId, FutureCallback); when SecurityUser isCustomerUser() return 'true'; then calls isCustomerUser()")
  void testValidate_whenSecurityUserIsCustomerUserReturnTrue_thenCallsIsCustomerUser() {
    // Arrange
    SecurityUser currentUser = mock(SecurityUser.class);
    when(currentUser.isCustomerUser()).thenReturn(true);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    AtomicInteger successMsgs = new AtomicInteger(1);
    AtomicInteger timeoutMsgs = new AtomicInteger(1);

    // Act
    accessValidator.validate(currentUser, Operation.ALL, entityId,
        new ScriptStatCallback<>(successMsgs, timeoutMsgs, new AtomicInteger(1)));

    // Assert
    verify(currentUser).isCustomerUser();
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link AccessValidator#handleError(Throwable, DeferredResult, HttpStatus)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link DeferredResult#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AccessValidator#handleError(Throwable, DeferredResult, HttpStatus)}
   */
  @Test
  @DisplayName("Test handleError(Throwable, DeferredResult, HttpStatus); given 'true'; then calls setResult(Object)")
  void testHandleError_givenTrue_thenCallsSetResult() {
    // Arrange
    Throwable e = new Throwable();
    DeferredResult<ResponseEntity> response = mock(DeferredResult.class);
    when(response.setResult(Mockito.<ResponseEntity<Object>>any())).thenReturn(true);

    // Act
    AccessValidator.handleError(e, response, HttpStatus.CONTINUE);

    // Assert
    verify(response).setResult(isA(ResponseEntity.class));
  }

  /**
   * Test
   * {@link AccessValidator#handleError(Throwable, DeferredResult, HttpStatus)}.
   * <ul>
   *   <li>When {@link DeferredResult#DeferredResult()}.</li>
   *   <li>Then {@link DeferredResult#DeferredResult()} Result StatusCode
   * {@link HttpStatus}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AccessValidator#handleError(Throwable, DeferredResult, HttpStatus)}
   */
  @Test
  @DisplayName("Test handleError(Throwable, DeferredResult, HttpStatus); when DeferredResult(); then DeferredResult() Result StatusCode HttpStatus")
  void testHandleError_whenDeferredResult_thenDeferredResultResultStatusCodeHttpStatus() {
    // Arrange
    Throwable e = new Throwable();
    DeferredResult<ResponseEntity> response = new DeferredResult<>();

    // Act
    AccessValidator.handleError(e, response, HttpStatus.CONTINUE);

    // Assert
    Object result = response.getResult();
    HttpStatusCode statusCode = ((ResponseEntity<Object>) result).getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertTrue(result instanceof ResponseEntity);
    assertNull(((ResponseEntity<Object>) result).getBody());
    assertEquals(100, ((ResponseEntity<Object>) result).getStatusCodeValue());
    assertEquals(HttpStatus.CONTINUE, statusCode);
    assertFalse(((ResponseEntity<Object>) result).hasBody());
    assertTrue(((ResponseEntity<Object>) result).getHeaders().isEmpty());
    assertTrue(response.hasResult());
    assertTrue(response.isSetOrExpired());
  }
}
