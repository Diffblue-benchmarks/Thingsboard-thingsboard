package org.thingsboard.server.service.security.permission;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.HasTenantId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.security.permission.PermissionChecker.GenericPermissionChecker;

class PermissionCheckerDiffblueTest {
  /**
   * Test GenericPermissionChecker
   * {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation)} with
   * {@code user}, {@code operation}.
   * <p>
   * Method under test:
   * {@link PermissionChecker.GenericPermissionChecker#hasPermission(SecurityUser, Operation)}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker hasPermission(SecurityUser, Operation) with 'user', 'operation'")
  void testGenericPermissionCheckerHasPermissionWithUserOperation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PermissionChecker.GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new PermissionChecker.GenericPermissionChecker<>(
        Operation.ALL);

    // Act and Assert
    assertTrue(genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL));
  }

  /**
   * Test GenericPermissionChecker
   * {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   * with {@code user}, {@code operation}, {@code entityId}, {@code entity}.
   * <p>
   * Method under test:
   * {@link PermissionChecker.GenericPermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker hasPermission(SecurityUser, Operation, EntityId, HasTenantId) with 'user', 'operation', 'entityId', 'entity'")
  void testGenericPermissionCheckerHasPermissionWithUserOperationEntityIdEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PermissionChecker.GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new PermissionChecker.GenericPermissionChecker<>(
        Operation.ALL);

    // Act and Assert
    assertTrue(
        genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL, null, mock(HasTenantId.class)));
  }

  /**
   * Test GenericPermissionChecker
   * {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   * with {@code user}, {@code operation}, {@code entityId}, {@code entity}.
   * <p>
   * Method under test:
   * {@link PermissionChecker.GenericPermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker hasPermission(SecurityUser, Operation, EntityId, HasTenantId) with 'user', 'operation', 'entityId', 'entity'")
  void testGenericPermissionCheckerHasPermissionWithUserOperationEntityIdEntity2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PermissionChecker.GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new PermissionChecker.GenericPermissionChecker<>(
        Operation.CREATE);

    // Act and Assert
    assertFalse(
        genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL, null, mock(HasTenantId.class)));
  }

  /**
   * Test GenericPermissionChecker
   * {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   * with {@code user}, {@code operation}, {@code entityId}, {@code entity}.
   * <p>
   * Method under test:
   * {@link PermissionChecker.GenericPermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker hasPermission(SecurityUser, Operation, EntityId, HasTenantId) with 'user', 'operation', 'entityId', 'entity'")
  void testGenericPermissionCheckerHasPermissionWithUserOperationEntityIdEntity3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PermissionChecker.GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new PermissionChecker.GenericPermissionChecker<>(
        Operation.CREATE);

    // Act and Assert
    assertTrue(
        genericPermissionChecker.hasPermission(new SecurityUser(), Operation.CREATE, null, mock(HasTenantId.class)));
  }

  /**
   * Test GenericPermissionChecker
   * {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation)} with
   * {@code user}, {@code operation}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PermissionChecker.GenericPermissionChecker#hasPermission(SecurityUser, Operation)}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker hasPermission(SecurityUser, Operation) with 'user', 'operation'; then return 'false'")
  void testGenericPermissionCheckerHasPermissionWithUserOperation_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PermissionChecker.GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new PermissionChecker.GenericPermissionChecker<>(
        Operation.CREATE);

    // Act and Assert
    assertFalse(genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL));
  }

  /**
   * Test GenericPermissionChecker
   * {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation)} with
   * {@code user}, {@code operation}.
   * <ul>
   *   <li>When {@code CREATE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PermissionChecker.GenericPermissionChecker#hasPermission(SecurityUser, Operation)}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker hasPermission(SecurityUser, Operation) with 'user', 'operation'; when 'CREATE'")
  void testGenericPermissionCheckerHasPermissionWithUserOperation_whenCreate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PermissionChecker.GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new PermissionChecker.GenericPermissionChecker<>(
        Operation.CREATE);

    // Act and Assert
    assertTrue(genericPermissionChecker.hasPermission(new SecurityUser(), Operation.CREATE));
  }

  /**
   * Test GenericPermissionChecker
   * {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation)} with
   * {@code user}, {@code operation}.
   * <ul>
   *   <li>When {@link SecurityUser}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PermissionChecker.GenericPermissionChecker#hasPermission(SecurityUser, Operation)}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker hasPermission(SecurityUser, Operation) with 'user', 'operation'; when SecurityUser")
  void testGenericPermissionCheckerHasPermissionWithUserOperation_whenSecurityUser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PermissionChecker.GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new PermissionChecker.GenericPermissionChecker<>(
        Operation.ALL);

    // Act and Assert
    assertTrue(genericPermissionChecker.hasPermission(mock(SecurityUser.class), Operation.ALL));
  }

  /**
   * Test GenericPermissionChecker
   * {@link GenericPermissionChecker#GenericPermissionChecker(Operation[])}.
   * <p>
   * Method under test:
   * {@link PermissionChecker.GenericPermissionChecker#GenericPermissionChecker(Operation[])}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker new GenericPermissionChecker(Operation[])")
  void testGenericPermissionCheckerNewGenericPermissionChecker() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    PermissionChecker.GenericPermissionChecker<EntityId, HasTenantId> actualGenericPermissionChecker = new PermissionChecker.GenericPermissionChecker<>(
        Operation.ALL);

    // Assert
    assertTrue(actualGenericPermissionChecker.hasPermission(null, Operation.ALL));
  }

  /**
   * Test
   * {@link PermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   * with {@code user}, {@code operation}, {@code entityId}, {@code entity}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test hasPermission(SecurityUser, Operation, EntityId, HasTenantId) with 'user', 'operation', 'entityId', 'entity'; then return 'false'")
  void testHasPermissionWithUserOperationEntityIdEntity_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PermissionChecker.GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new PermissionChecker.GenericPermissionChecker<>(
        Operation.CREATE);

    // Act and Assert
    assertFalse(
        genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL, null, mock(HasTenantId.class)));
  }

  /**
   * Test
   * {@link PermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   * with {@code user}, {@code operation}, {@code entityId}, {@code entity}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test hasPermission(SecurityUser, Operation, EntityId, HasTenantId) with 'user', 'operation', 'entityId', 'entity'; then return 'true'")
  void testHasPermissionWithUserOperationEntityIdEntity_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PermissionChecker.GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new PermissionChecker.GenericPermissionChecker<>(
        Operation.ALL);

    // Act and Assert
    assertTrue(
        genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL, null, mock(HasTenantId.class)));
  }

  /**
   * Test {@link PermissionChecker#hasPermission(SecurityUser, Operation)} with
   * {@code user}, {@code operation}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PermissionChecker#hasPermission(SecurityUser, Operation)}
   */
  @Test
  @DisplayName("Test hasPermission(SecurityUser, Operation) with 'user', 'operation'; then return 'false'")
  void testHasPermissionWithUserOperation_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PermissionChecker.GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new PermissionChecker.GenericPermissionChecker<>(
        Operation.CREATE);

    // Act and Assert
    assertFalse(genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL));
  }

  /**
   * Test {@link PermissionChecker#hasPermission(SecurityUser, Operation)} with
   * {@code user}, {@code operation}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PermissionChecker#hasPermission(SecurityUser, Operation)}
   */
  @Test
  @DisplayName("Test hasPermission(SecurityUser, Operation) with 'user', 'operation'; then return 'true'")
  void testHasPermissionWithUserOperation_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PermissionChecker.GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new PermissionChecker.GenericPermissionChecker<>(
        Operation.ALL);

    // Act and Assert
    assertTrue(genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL));
  }

  /**
   * Test {@link PermissionChecker#hasPermission(SecurityUser, Operation)} with
   * {@code user}, {@code operation}.
   * <ul>
   *   <li>When {@link SecurityUser}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PermissionChecker#hasPermission(SecurityUser, Operation)}
   */
  @Test
  @DisplayName("Test hasPermission(SecurityUser, Operation) with 'user', 'operation'; when SecurityUser; then return 'true'")
  void testHasPermissionWithUserOperation_whenSecurityUser_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PermissionChecker.GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new PermissionChecker.GenericPermissionChecker<>(
        Operation.ALL);

    // Act and Assert
    assertTrue(genericPermissionChecker.hasPermission(mock(SecurityUser.class), Operation.ALL));
  }
}
