package org.thingsboard.server.service.security.permission;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.HasTenantId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.security.permission.PermissionChecker.GenericPermissionChecker;

class PermissionCheckerDiffblueTest {
  /**
   * Test GenericPermissionChecker {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation)} with {@code user}, {@code operation}.
   * <p>
   * Method under test: {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation)}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker hasPermission(SecurityUser, Operation) with 'user', 'operation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GenericPermissionChecker.hasPermission(SecurityUser, Operation)"})
  void testGenericPermissionCheckerHasPermissionWithUserOperation() {
    // Arrange
    GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new GenericPermissionChecker<>(
        Operation.ALL);

    // Act and Assert
    assertTrue(genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL));
  }

  /**
   * Test GenericPermissionChecker {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)} with {@code user}, {@code operation}, {@code entityId}, {@code entity}.
   * <p>
   * Method under test: {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker hasPermission(SecurityUser, Operation, EntityId, HasTenantId) with 'user', 'operation', 'entityId', 'entity'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GenericPermissionChecker.hasPermission(SecurityUser, Operation, EntityId, HasTenantId)"})
  void testGenericPermissionCheckerHasPermissionWithUserOperationEntityIdEntity() {
    // Arrange
    GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new GenericPermissionChecker<>(
        Operation.ALL);

    // Act and Assert
    assertTrue(
        genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL, null, mock(HasTenantId.class)));
  }

  /**
   * Test GenericPermissionChecker {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)} with {@code user}, {@code operation}, {@code entityId}, {@code entity}.
   * <p>
   * Method under test: {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker hasPermission(SecurityUser, Operation, EntityId, HasTenantId) with 'user', 'operation', 'entityId', 'entity'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GenericPermissionChecker.hasPermission(SecurityUser, Operation, EntityId, HasTenantId)"})
  void testGenericPermissionCheckerHasPermissionWithUserOperationEntityIdEntity2() {
    // Arrange
    GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new GenericPermissionChecker<>(
        Operation.CREATE);

    // Act and Assert
    assertFalse(
        genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL, null, mock(HasTenantId.class)));
  }

  /**
   * Test GenericPermissionChecker {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)} with {@code user}, {@code operation}, {@code entityId}, {@code entity}.
   * <p>
   * Method under test: {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker hasPermission(SecurityUser, Operation, EntityId, HasTenantId) with 'user', 'operation', 'entityId', 'entity'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GenericPermissionChecker.hasPermission(SecurityUser, Operation, EntityId, HasTenantId)"})
  void testGenericPermissionCheckerHasPermissionWithUserOperationEntityIdEntity3() {
    // Arrange
    GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new GenericPermissionChecker<>(
        Operation.CREATE);

    // Act and Assert
    assertTrue(
        genericPermissionChecker.hasPermission(new SecurityUser(), Operation.CREATE, null, mock(HasTenantId.class)));
  }

  /**
   * Test GenericPermissionChecker {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation)} with {@code user}, {@code operation}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation)}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker hasPermission(SecurityUser, Operation) with 'user', 'operation'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GenericPermissionChecker.hasPermission(SecurityUser, Operation)"})
  void testGenericPermissionCheckerHasPermissionWithUserOperation_thenReturnFalse() {
    // Arrange
    GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new GenericPermissionChecker<>(
        Operation.CREATE);

    // Act and Assert
    assertFalse(genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL));
  }

  /**
   * Test GenericPermissionChecker {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation)} with {@code user}, {@code operation}.
   * <ul>
   *   <li>When {@code CREATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericPermissionChecker#hasPermission(SecurityUser, Operation)}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker hasPermission(SecurityUser, Operation) with 'user', 'operation'; when 'CREATE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GenericPermissionChecker.hasPermission(SecurityUser, Operation)"})
  void testGenericPermissionCheckerHasPermissionWithUserOperation_whenCreate() {
    // Arrange
    GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new GenericPermissionChecker<>(
        Operation.CREATE);

    // Act and Assert
    assertTrue(genericPermissionChecker.hasPermission(new SecurityUser(), Operation.CREATE));
  }

  /**
   * Test GenericPermissionChecker {@link GenericPermissionChecker#GenericPermissionChecker(Operation[])}.
   * <p>
   * Method under test: {@link GenericPermissionChecker#GenericPermissionChecker(Operation[])}
   */
  @Test
  @DisplayName("Test GenericPermissionChecker new GenericPermissionChecker(Operation[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GenericPermissionChecker.<init>(Operation[])"})
  void testGenericPermissionCheckerNewGenericPermissionChecker() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    GenericPermissionChecker<EntityId, HasTenantId> actualGenericPermissionChecker = new GenericPermissionChecker<>(
        Operation.ALL);

    // Assert
    assertTrue(actualGenericPermissionChecker.hasPermission(null, Operation.ALL));
  }

  /**
   * Test {@link PermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)} with {@code user}, {@code operation}, {@code entityId}, {@code entity}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test hasPermission(SecurityUser, Operation, EntityId, HasTenantId) with 'user', 'operation', 'entityId', 'entity'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PermissionChecker.hasPermission(SecurityUser, Operation, EntityId, HasTenantId)"})
  void testHasPermissionWithUserOperationEntityIdEntity_thenReturnFalse() {
    // Arrange
    GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new GenericPermissionChecker<>(
        Operation.CREATE);

    // Act and Assert
    assertFalse(
        genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL, null, mock(HasTenantId.class)));
  }

  /**
   * Test {@link PermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)} with {@code user}, {@code operation}, {@code entityId}, {@code entity}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PermissionChecker#hasPermission(SecurityUser, Operation, EntityId, HasTenantId)}
   */
  @Test
  @DisplayName("Test hasPermission(SecurityUser, Operation, EntityId, HasTenantId) with 'user', 'operation', 'entityId', 'entity'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PermissionChecker.hasPermission(SecurityUser, Operation, EntityId, HasTenantId)"})
  void testHasPermissionWithUserOperationEntityIdEntity_thenReturnTrue() {
    // Arrange
    GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new GenericPermissionChecker<>(
        Operation.ALL);

    // Act and Assert
    assertTrue(
        genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL, null, mock(HasTenantId.class)));
  }

  /**
   * Test {@link PermissionChecker#hasPermission(SecurityUser, Operation)} with {@code user}, {@code operation}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PermissionChecker#hasPermission(SecurityUser, Operation)}
   */
  @Test
  @DisplayName("Test hasPermission(SecurityUser, Operation) with 'user', 'operation'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PermissionChecker.hasPermission(SecurityUser, Operation)"})
  void testHasPermissionWithUserOperation_thenReturnFalse() {
    // Arrange
    GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new GenericPermissionChecker<>(
        Operation.CREATE);

    // Act and Assert
    assertFalse(genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL));
  }

  /**
   * Test {@link PermissionChecker#hasPermission(SecurityUser, Operation)} with {@code user}, {@code operation}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PermissionChecker#hasPermission(SecurityUser, Operation)}
   */
  @Test
  @DisplayName("Test hasPermission(SecurityUser, Operation) with 'user', 'operation'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PermissionChecker.hasPermission(SecurityUser, Operation)"})
  void testHasPermissionWithUserOperation_thenReturnTrue() {
    // Arrange
    GenericPermissionChecker<EntityId, HasTenantId> genericPermissionChecker = new GenericPermissionChecker<>(
        Operation.ALL);

    // Act and Assert
    assertTrue(genericPermissionChecker.hasPermission(new SecurityUser(), Operation.ALL));
  }
}
