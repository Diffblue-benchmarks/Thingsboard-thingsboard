package org.thingsboard.server.service.security.permission;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.HasTenantId;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.Authority;
import org.thingsboard.server.service.security.model.SecurityUser;

@ContextConfiguration(classes = {DefaultAccessControlService.class})
@ExtendWith(SpringExtension.class)
class DefaultAccessControlServiceDiffblueTest {
  @Autowired
  private DefaultAccessControlService defaultAccessControlService;

  @MockBean(name = "sysAdminPermissions")
  private Permissions permissions;

  @MockBean(name = "tenantAdminPermissions")
  private Permissions permissions2;

  @MockBean(name = "customerUserPermissions")
  private Permissions permissions3;

  /**
   * Test
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation)}
   * with {@code user}, {@code resource}, {@code operation}.
   * <p>
   * Method under test:
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation)}
   */
  @Test
  @DisplayName("Test checkPermission(SecurityUser, Resource, Operation) with 'user', 'resource', 'operation'")
  void testCheckPermissionWithUserResourceOperation() throws ThingsboardException {
    // Arrange
    Optional<PermissionChecker> ofResult = Optional.of(PermissionChecker.allowAllPermissionChecker);
    when(permissions.getPermissionChecker(Mockito.<Resource>any())).thenReturn(ofResult);
    SecurityUser user = mock(SecurityUser.class);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);

    // Act
    defaultAccessControlService.checkPermission(user, Resource.ADMIN_SETTINGS, Operation.ALL);

    // Assert that nothing has changed
    verify(user).getAuthority();
    verify(permissions).getPermissionChecker(eq(Resource.ADMIN_SETTINGS));
  }

  /**
   * Test
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation)}
   * with {@code user}, {@code resource}, {@code operation}.
   * <p>
   * Method under test:
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation)}
   */
  @Test
  @DisplayName("Test checkPermission(SecurityUser, Resource, Operation) with 'user', 'resource', 'operation'")
  void testCheckPermissionWithUserResourceOperation2() throws ThingsboardException {
    // Arrange
    Optional<PermissionChecker> ofResult = Optional.of(PermissionChecker.denyAllPermissionChecker);
    when(permissions.getPermissionChecker(Mockito.<Resource>any())).thenReturn(ofResult);
    SecurityUser user = mock(SecurityUser.class);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultAccessControlService.checkPermission(user, Resource.ADMIN_SETTINGS, Operation.ALL));
    verify(user).getAuthority();
    verify(permissions).getPermissionChecker(eq(Resource.ADMIN_SETTINGS));
  }

  /**
   * Test
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation)}
   * with {@code user}, {@code resource}, {@code operation}.
   * <p>
   * Method under test:
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation)}
   */
  @Test
  @DisplayName("Test checkPermission(SecurityUser, Resource, Operation) with 'user', 'resource', 'operation'")
  void testCheckPermissionWithUserResourceOperation3() throws ThingsboardException {
    // Arrange
    Optional<PermissionChecker> emptyResult = Optional.empty();
    when(permissions.getPermissionChecker(Mockito.<Resource>any())).thenReturn(emptyResult);
    SecurityUser user = mock(SecurityUser.class);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultAccessControlService.checkPermission(user, Resource.ADMIN_SETTINGS, Operation.ALL));
    verify(user).getAuthority();
    verify(permissions).getPermissionChecker(eq(Resource.ADMIN_SETTINGS));
  }

  /**
   * Test
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId)}
   * with {@code user}, {@code resource}, {@code operation}, {@code entityId},
   * {@code entity}.
   * <p>
   * Method under test:
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId) with 'user', 'resource', 'operation', 'entityId', 'entity'")
  void testCheckPermissionWithUserResourceOperationEntityIdEntity() throws ThingsboardException {
    // Arrange
    Optional<PermissionChecker> ofResult = Optional.of(PermissionChecker.allowAllPermissionChecker);
    when(permissions.getPermissionChecker(Mockito.<Resource>any())).thenReturn(ofResult);
    SecurityUser user = mock(SecurityUser.class);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);

    // Act
    defaultAccessControlService.checkPermission(user, Resource.ADMIN_SETTINGS, Operation.ALL, null,
        mock(HasTenantId.class));

    // Assert that nothing has changed
    verify(user).getAuthority();
    verify(permissions).getPermissionChecker(eq(Resource.ADMIN_SETTINGS));
  }

  /**
   * Test
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId)}
   * with {@code user}, {@code resource}, {@code operation}, {@code entityId},
   * {@code entity}.
   * <p>
   * Method under test:
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId) with 'user', 'resource', 'operation', 'entityId', 'entity'")
  void testCheckPermissionWithUserResourceOperationEntityIdEntity2() throws ThingsboardException {
    // Arrange
    Optional<PermissionChecker> ofResult = Optional.of(PermissionChecker.denyAllPermissionChecker);
    when(permissions.getPermissionChecker(Mockito.<Resource>any())).thenReturn(ofResult);
    SecurityUser user = mock(SecurityUser.class);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultAccessControlService.checkPermission(user,
        Resource.ADMIN_SETTINGS, Operation.ALL, null, mock(HasTenantId.class)));
    verify(user).getAuthority();
    verify(permissions).getPermissionChecker(eq(Resource.ADMIN_SETTINGS));
  }

  /**
   * Test
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId)}
   * with {@code user}, {@code resource}, {@code operation}, {@code entityId},
   * {@code entity}.
   * <p>
   * Method under test:
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId) with 'user', 'resource', 'operation', 'entityId', 'entity'")
  void testCheckPermissionWithUserResourceOperationEntityIdEntity3() throws ThingsboardException {
    // Arrange
    Optional<PermissionChecker> emptyResult = Optional.empty();
    when(permissions.getPermissionChecker(Mockito.<Resource>any())).thenReturn(emptyResult);
    SecurityUser user = mock(SecurityUser.class);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultAccessControlService.checkPermission(user,
        Resource.ADMIN_SETTINGS, Operation.ALL, null, mock(HasTenantId.class)));
    verify(user).getAuthority();
    verify(permissions).getPermissionChecker(eq(Resource.ADMIN_SETTINGS));
  }

  /**
   * Test
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId)}
   * with {@code user}, {@code resource}, {@code operation}, {@code entityId},
   * {@code entity}.
   * <ul>
   *   <li>Then calls {@link HasTenantId#getTenantId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId) with 'user', 'resource', 'operation', 'entityId', 'entity'; then calls getTenantId()")
  void testCheckPermissionWithUserResourceOperationEntityIdEntity_thenCallsGetTenantId() throws ThingsboardException {
    // Arrange
    Optional<PermissionChecker> ofResult = Optional.of(TenantAdminPermissions.tenantEntityPermissionChecker);
    when(permissions.getPermissionChecker(Mockito.<Resource>any())).thenReturn(ofResult);
    SecurityUser user = mock(SecurityUser.class);
    when(user.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    HasTenantId hasTenantId = mock(HasTenantId.class);
    when(hasTenantId.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultAccessControlService.checkPermission(user,
        Resource.ADMIN_SETTINGS, Operation.ALL, null, hasTenantId));
    verify(hasTenantId).getTenantId();
    verify(user).getAuthority();
    verify(user).getTenantId();
    verify(permissions).getPermissionChecker(eq(Resource.ADMIN_SETTINGS));
  }

  /**
   * Test
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId)}
   * with {@code user}, {@code resource}, {@code operation}, {@code entityId},
   * {@code entity}.
   * <ul>
   *   <li>When {@link SecurityUser#SecurityUser()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test checkPermission(SecurityUser, Resource, Operation, EntityId, HasTenantId) with 'user', 'resource', 'operation', 'entityId', 'entity'; when SecurityUser()")
  void testCheckPermissionWithUserResourceOperationEntityIdEntity_whenSecurityUser() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultAccessControlService.checkPermission(new SecurityUser(),
        Resource.ADMIN_SETTINGS, Operation.ALL, null, mock(HasTenantId.class)));
  }

  /**
   * Test
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation)}
   * with {@code user}, {@code resource}, {@code operation}.
   * <ul>
   *   <li>Then calls
   * {@link PermissionChecker#hasPermission(SecurityUser, Operation)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation)}
   */
  @Test
  @DisplayName("Test checkPermission(SecurityUser, Resource, Operation) with 'user', 'resource', 'operation'; then calls hasPermission(SecurityUser, Operation)")
  void testCheckPermissionWithUserResourceOperation_thenCallsHasPermission() throws ThingsboardException {
    // Arrange
    PermissionChecker permissionChecker = mock(PermissionChecker.class);
    when(permissionChecker.hasPermission(Mockito.<SecurityUser>any(), Mockito.<Operation>any())).thenReturn(true);
    Optional<PermissionChecker> ofResult = Optional.of(permissionChecker);
    when(permissions.getPermissionChecker(Mockito.<Resource>any())).thenReturn(ofResult);
    SecurityUser user = mock(SecurityUser.class);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);

    // Act
    defaultAccessControlService.checkPermission(user, Resource.ADMIN_SETTINGS, Operation.ALL);

    // Assert that nothing has changed
    verify(user).getAuthority();
    verify(permissionChecker).hasPermission(isA(SecurityUser.class), eq(Operation.ALL));
    verify(permissions).getPermissionChecker(eq(Resource.ADMIN_SETTINGS));
  }

  /**
   * Test
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation)}
   * with {@code user}, {@code resource}, {@code operation}.
   * <ul>
   *   <li>When {@link SecurityUser#SecurityUser()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAccessControlService#checkPermission(SecurityUser, Resource, Operation)}
   */
  @Test
  @DisplayName("Test checkPermission(SecurityUser, Resource, Operation) with 'user', 'resource', 'operation'; when SecurityUser()")
  void testCheckPermissionWithUserResourceOperation_whenSecurityUser() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultAccessControlService.checkPermission(new SecurityUser(), Resource.ADMIN_SETTINGS, Operation.ALL));
  }
}
