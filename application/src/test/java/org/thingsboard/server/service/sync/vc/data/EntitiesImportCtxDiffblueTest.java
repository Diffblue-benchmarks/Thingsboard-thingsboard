package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.common.data.sync.ie.EntityImportSettings;
import org.thingsboard.server.common.data.sync.vc.EntityTypeLoadResult;
import org.thingsboard.server.common.data.util.ThrowingRunnable;
import org.thingsboard.server.service.security.model.SecurityUser;

class EntitiesImportCtxDiffblueTest {
  /**
   * Test {@link EntitiesImportCtx#equals(Object)}, and
   * {@link EntitiesImportCtx#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesImportCtx#equals(Object)}
   *   <li>{@link EntitiesImportCtx#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(null, new User(), "42");
    EntitiesImportCtx entitiesImportCtx2 = new EntitiesImportCtx(null, new User(), "42");

    // Act and Assert
    assertEquals(entitiesImportCtx, entitiesImportCtx2);
    int expectedHashCodeResult = entitiesImportCtx.hashCode();
    assertEquals(expectedHashCodeResult, entitiesImportCtx2.hashCode());
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}, and
   * {@link EntitiesImportCtx#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesImportCtx#equals(Object)}
   *   <li>{@link EntitiesImportCtx#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(null, null, "42");
    EntitiesImportCtx entitiesImportCtx2 = new EntitiesImportCtx(null, null, "42");

    // Act and Assert
    assertEquals(entitiesImportCtx, entitiesImportCtx2);
    int expectedHashCodeResult = entitiesImportCtx.hashCode();
    assertEquals(expectedHashCodeResult, entitiesImportCtx2.hashCode());
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}, and
   * {@link EntitiesImportCtx#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesImportCtx#equals(Object)}
   *   <li>{@link EntitiesImportCtx#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act and Assert
    assertEquals(entitiesImportCtx, entitiesImportCtx);
    int expectedHashCodeResult = entitiesImportCtx.hashCode();
    assertEquals(expectedHashCodeResult, entitiesImportCtx.hashCode());
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    UUID requestId2 = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(entitiesImportCtx, new EntitiesImportCtx(requestId2, new User(), "42"));
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(null, new User(), "42");
    UUID requestId = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(entitiesImportCtx, new EntitiesImportCtx(requestId, new User(), "42"));
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(UUID.randomUUID(), mock(User.class), "42");
    UUID requestId = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(entitiesImportCtx, new EntitiesImportCtx(requestId, new User(), "42"));
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UUID requestId = UUID.randomUUID();

    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    entitiesImportCtx.setFinalImportAttempt(true);
    UUID requestId2 = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(entitiesImportCtx, new EntitiesImportCtx(requestId2, new User(), "42"));
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UUID requestId = UUID.randomUUID();

    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    entitiesImportCtx.setRollbackOnError(true);
    UUID requestId2 = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(entitiesImportCtx, new EntitiesImportCtx(requestId2, new User(), "42"));
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(null, null, "42");

    // Act and Assert
    assertNotEquals(entitiesImportCtx, new EntitiesImportCtx(null, new User(), "42"));
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(null, new SecurityUser(), "42");

    // Act and Assert
    assertNotEquals(entitiesImportCtx, new EntitiesImportCtx(null, new User(), "42"));
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(null, new User(), "1.0.2");

    // Act and Assert
    assertNotEquals(entitiesImportCtx, new EntitiesImportCtx(null, new User(), "42"));
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(null, new User(), null);

    // Act and Assert
    assertNotEquals(entitiesImportCtx, new EntitiesImportCtx(null, new User(), "42"));
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(null, new User(), "42");
    entitiesImportCtx.addEventCallback(mock(ThrowingRunnable.class));

    // Act and Assert
    assertNotEquals(entitiesImportCtx, new EntitiesImportCtx(null, new User(), "42"));
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UUID requestId = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(new EntitiesImportCtx(requestId, new User(), "42"), null);
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UUID requestId = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(new EntitiesImportCtx(requestId, new User(), "42"), "Different type to EntitiesImportCtx");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntitiesImportCtx#EntitiesImportCtx(UUID, User, String, EntityImportSettings)}
   *   <li>{@link EntitiesImportCtx#setCurrentImportResult(EntityImportResult)}
   *   <li>{@link EntitiesImportCtx#setFinalImportAttempt(boolean)}
   *   <li>{@link EntitiesImportCtx#setRollbackOnError(boolean)}
   *   <li>{@link EntitiesImportCtx#setSettings(EntityImportSettings)}
   *   <li>{@link EntitiesImportCtx#toString()}
   *   <li>{@link EntitiesImportCtx#getCurrentImportResult()}
   *   <li>{@link EntitiesImportCtx#getEventCallbacks()}
   *   <li>{@link EntitiesImportCtx#getExternalToInternalIdMap()}
   *   <li>{@link EntitiesImportCtx#getImportedEntities()}
   *   <li>{@link EntitiesImportCtx#getNotFoundIds()}
   *   <li>{@link EntitiesImportCtx#getReferenceCallbacks()}
   *   <li>{@link EntitiesImportCtx#getRelations()}
   *   <li>{@link EntitiesImportCtx#getRequestId()}
   *   <li>{@link EntitiesImportCtx#getResults()}
   *   <li>{@link EntitiesImportCtx#getSettings()}
   *   <li>{@link EntitiesImportCtx#getToReimport()}
   *   <li>{@link EntitiesImportCtx#getUser()}
   *   <li>{@link EntitiesImportCtx#getVersionId()}
   *   <li>{@link EntitiesImportCtx#isFinalImportAttempt()}
   *   <li>{@link EntitiesImportCtx#isRollbackOnError()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UUID requestId = UUID.randomUUID();
    User user = new User();
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act
    EntitiesImportCtx actualEntitiesImportCtx = new EntitiesImportCtx(requestId, user, "42", settings);
    EntityImportResult<ExportableEntity<? extends EntityId>> currentImportResult = new EntityImportResult<>();
    actualEntitiesImportCtx.setCurrentImportResult(currentImportResult);
    actualEntitiesImportCtx.setFinalImportAttempt(true);
    actualEntitiesImportCtx.setRollbackOnError(true);
    EntityImportSettings settings2 = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    actualEntitiesImportCtx.setSettings(settings2);
    actualEntitiesImportCtx.toString();
    EntityImportResult<?> actualCurrentImportResult = actualEntitiesImportCtx.getCurrentImportResult();
    List<ThrowingRunnable> actualEventCallbacks = actualEntitiesImportCtx.getEventCallbacks();
    Map<EntityId, EntityId> actualExternalToInternalIdMap = actualEntitiesImportCtx.getExternalToInternalIdMap();
    Map<EntityType, Set<EntityId>> actualImportedEntities = actualEntitiesImportCtx.getImportedEntities();
    Set<EntityId> actualNotFoundIds = actualEntitiesImportCtx.getNotFoundIds();
    Map<EntityId, ThrowingRunnable> actualReferenceCallbacks = actualEntitiesImportCtx.getReferenceCallbacks();
    Set<EntityRelation> actualRelations = actualEntitiesImportCtx.getRelations();
    UUID actualRequestId = actualEntitiesImportCtx.getRequestId();
    Map<EntityType, EntityTypeLoadResult> actualResults = actualEntitiesImportCtx.getResults();
    EntityImportSettings actualSettings = actualEntitiesImportCtx.getSettings();
    Map<EntityId, ReimportTask> actualToReimport = actualEntitiesImportCtx.getToReimport();
    User actualUser = actualEntitiesImportCtx.getUser();
    String actualVersionId = actualEntitiesImportCtx.getVersionId();
    boolean actualIsFinalImportAttemptResult = actualEntitiesImportCtx.isFinalImportAttempt();
    boolean actualIsRollbackOnErrorResult = actualEntitiesImportCtx.isRollbackOnError();

    // Assert that nothing has changed
    assertEquals("42", actualVersionId);
    assertTrue(actualEventCallbacks.isEmpty());
    assertTrue(actualExternalToInternalIdMap.isEmpty());
    assertTrue(actualImportedEntities.isEmpty());
    assertTrue(actualReferenceCallbacks.isEmpty());
    assertTrue(actualResults.isEmpty());
    assertTrue(actualToReimport.isEmpty());
    assertTrue(actualNotFoundIds.isEmpty());
    assertTrue(actualRelations.isEmpty());
    assertTrue(actualIsFinalImportAttemptResult);
    assertTrue(actualIsRollbackOnErrorResult);
    assertSame(user, actualUser);
    assertSame(currentImportResult, actualCurrentImportResult);
    assertSame(settings2, actualSettings);
    assertSame(requestId, actualRequestId);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link User#User()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesImportCtx#EntitiesImportCtx(UUID, User, String)}
   *   <li>{@link EntitiesImportCtx#setCurrentImportResult(EntityImportResult)}
   *   <li>{@link EntitiesImportCtx#setFinalImportAttempt(boolean)}
   *   <li>{@link EntitiesImportCtx#setRollbackOnError(boolean)}
   *   <li>{@link EntitiesImportCtx#setSettings(EntityImportSettings)}
   *   <li>{@link EntitiesImportCtx#toString()}
   *   <li>{@link EntitiesImportCtx#getCurrentImportResult()}
   *   <li>{@link EntitiesImportCtx#getEventCallbacks()}
   *   <li>{@link EntitiesImportCtx#getExternalToInternalIdMap()}
   *   <li>{@link EntitiesImportCtx#getImportedEntities()}
   *   <li>{@link EntitiesImportCtx#getNotFoundIds()}
   *   <li>{@link EntitiesImportCtx#getReferenceCallbacks()}
   *   <li>{@link EntitiesImportCtx#getRelations()}
   *   <li>{@link EntitiesImportCtx#getRequestId()}
   *   <li>{@link EntitiesImportCtx#getResults()}
   *   <li>{@link EntitiesImportCtx#getSettings()}
   *   <li>{@link EntitiesImportCtx#getToReimport()}
   *   <li>{@link EntitiesImportCtx#getUser()}
   *   <li>{@link EntitiesImportCtx#getVersionId()}
   *   <li>{@link EntitiesImportCtx#isFinalImportAttempt()}
   *   <li>{@link EntitiesImportCtx#isRollbackOnError()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when User()")
  void testGettersAndSetters_whenUser() {
    // Arrange
    UUID requestId = UUID.randomUUID();
    User user = new User();

    // Act
    EntitiesImportCtx actualEntitiesImportCtx = new EntitiesImportCtx(requestId, user, "42");
    EntityImportResult<ExportableEntity<? extends EntityId>> currentImportResult = new EntityImportResult<>();
    actualEntitiesImportCtx.setCurrentImportResult(currentImportResult);
    actualEntitiesImportCtx.setFinalImportAttempt(true);
    actualEntitiesImportCtx.setRollbackOnError(true);
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    actualEntitiesImportCtx.setSettings(settings);
    actualEntitiesImportCtx.toString();
    EntityImportResult<?> actualCurrentImportResult = actualEntitiesImportCtx.getCurrentImportResult();
    List<ThrowingRunnable> actualEventCallbacks = actualEntitiesImportCtx.getEventCallbacks();
    Map<EntityId, EntityId> actualExternalToInternalIdMap = actualEntitiesImportCtx.getExternalToInternalIdMap();
    Map<EntityType, Set<EntityId>> actualImportedEntities = actualEntitiesImportCtx.getImportedEntities();
    Set<EntityId> actualNotFoundIds = actualEntitiesImportCtx.getNotFoundIds();
    Map<EntityId, ThrowingRunnable> actualReferenceCallbacks = actualEntitiesImportCtx.getReferenceCallbacks();
    Set<EntityRelation> actualRelations = actualEntitiesImportCtx.getRelations();
    UUID actualRequestId = actualEntitiesImportCtx.getRequestId();
    Map<EntityType, EntityTypeLoadResult> actualResults = actualEntitiesImportCtx.getResults();
    EntityImportSettings actualSettings = actualEntitiesImportCtx.getSettings();
    Map<EntityId, ReimportTask> actualToReimport = actualEntitiesImportCtx.getToReimport();
    User actualUser = actualEntitiesImportCtx.getUser();
    String actualVersionId = actualEntitiesImportCtx.getVersionId();
    boolean actualIsFinalImportAttemptResult = actualEntitiesImportCtx.isFinalImportAttempt();
    boolean actualIsRollbackOnErrorResult = actualEntitiesImportCtx.isRollbackOnError();

    // Assert that nothing has changed
    assertEquals("42", actualVersionId);
    assertTrue(actualEventCallbacks.isEmpty());
    assertTrue(actualExternalToInternalIdMap.isEmpty());
    assertTrue(actualImportedEntities.isEmpty());
    assertTrue(actualReferenceCallbacks.isEmpty());
    assertTrue(actualResults.isEmpty());
    assertTrue(actualToReimport.isEmpty());
    assertTrue(actualNotFoundIds.isEmpty());
    assertTrue(actualRelations.isEmpty());
    assertTrue(actualIsFinalImportAttemptResult);
    assertTrue(actualIsRollbackOnErrorResult);
    assertSame(user, actualUser);
    assertSame(currentImportResult, actualCurrentImportResult);
    assertSame(settings, actualSettings);
    assertSame(requestId, actualRequestId);
  }

  /**
   * Test {@link EntitiesImportCtx#getTenantId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId(); then return 'null'")
  void testGetTenantId_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();

    // Act and Assert
    assertNull((new EntitiesImportCtx(requestId, new User(), "42")).getTenantId());
  }

  /**
   * Test {@link EntitiesImportCtx#getTenantId()}.
   * <ul>
   *   <li>Then return {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId(); then return TenantId(UUID) with id is randomUUID")
  void testGetTenantId_thenReturnTenantIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    User user = mock(User.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    when(user.getTenantId()).thenReturn(tenantId);

    // Act
    TenantId actualTenantId = (new EntitiesImportCtx(UUID.randomUUID(), user, "42")).getTenantId();

    // Assert
    verify(user).getTenantId();
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link EntitiesImportCtx#isFindExistingByName()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#isFindExistingByName()}
   */
  @Test
  @DisplayName("Test isFindExistingByName(); then return 'false'")
  void testIsFindExistingByName_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();

    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    entitiesImportCtx.setSettings(settings);

    // Act and Assert
    assertFalse(entitiesImportCtx.isFindExistingByName());
  }

  /**
   * Test {@link EntitiesImportCtx#isUpdateRelations()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#isUpdateRelations()}
   */
  @Test
  @DisplayName("Test isUpdateRelations(); then return 'false'")
  void testIsUpdateRelations_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();

    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(false)
        .build();
    entitiesImportCtx.setSettings(settings);

    // Act and Assert
    assertFalse(entitiesImportCtx.isUpdateRelations());
  }

  /**
   * Test {@link EntitiesImportCtx#isUpdateRelations()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#isUpdateRelations()}
   */
  @Test
  @DisplayName("Test isUpdateRelations(); then return 'true'")
  void testIsUpdateRelations_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();

    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    entitiesImportCtx.setSettings(settings);

    // Act and Assert
    assertTrue(entitiesImportCtx.isUpdateRelations());
  }

  /**
   * Test {@link EntitiesImportCtx#isSaveAttributes()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#isSaveAttributes()}
   */
  @Test
  @DisplayName("Test isSaveAttributes(); then return 'false'")
  void testIsSaveAttributes_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityImportSettings.EntityImportSettingsBuilder entityImportSettingsBuilder = mock(
        EntityImportSettings.EntityImportSettingsBuilder.class);
    when(entityImportSettingsBuilder.saveAttributes(anyBoolean())).thenReturn(EntityImportSettings.builder());
    EntityImportSettings settings = entityImportSettingsBuilder.saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    UUID requestId = UUID.randomUUID();

    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    entitiesImportCtx.setSettings(settings);

    // Act
    boolean actualIsSaveAttributesResult = entitiesImportCtx.isSaveAttributes();

    // Assert
    verify(entityImportSettingsBuilder).saveAttributes(eq(true));
    assertFalse(actualIsSaveAttributesResult);
  }

  /**
   * Test {@link EntitiesImportCtx#isSaveAttributes()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#isSaveAttributes()}
   */
  @Test
  @DisplayName("Test isSaveAttributes(); then return 'true'")
  void testIsSaveAttributes_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();

    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    entitiesImportCtx.setSettings(settings);

    // Act and Assert
    assertTrue(entitiesImportCtx.isSaveAttributes());
  }

  /**
   * Test {@link EntitiesImportCtx#isSaveCredentials()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#isSaveCredentials()}
   */
  @Test
  @DisplayName("Test isSaveCredentials(); then return 'false'")
  void testIsSaveCredentials_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();

    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(false)
        .updateRelations(true)
        .build();
    entitiesImportCtx.setSettings(settings);

    // Act and Assert
    assertFalse(entitiesImportCtx.isSaveCredentials());
  }

  /**
   * Test {@link EntitiesImportCtx#isSaveCredentials()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#isSaveCredentials()}
   */
  @Test
  @DisplayName("Test isSaveCredentials(); then return 'true'")
  void testIsSaveCredentials_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();

    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    entitiesImportCtx.setSettings(settings);

    // Act and Assert
    assertTrue(entitiesImportCtx.isSaveCredentials());
  }

  /**
   * Test {@link EntitiesImportCtx#registerResult(EntityType, boolean)}.
   * <p>
   * Method under test:
   * {@link EntitiesImportCtx#registerResult(EntityType, boolean)}
   */
  @Test
  @DisplayName("Test registerResult(EntityType, boolean)")
  void testRegisterResult() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    entitiesImportCtx.registerResult(EntityType.TENANT, true);

    // Assert
    Map<EntityType, EntityTypeLoadResult> results = entitiesImportCtx.getResults();
    assertEquals(1, results.size());
    EntityTypeLoadResult getResult = results.get(EntityType.TENANT);
    assertEquals(0, getResult.getDeleted());
    assertEquals(0, getResult.getUpdated());
    assertEquals(1, getResult.getCreated());
    assertEquals(EntityType.TENANT, getResult.getEntityType());
  }

  /**
   * Test {@link EntitiesImportCtx#registerResult(EntityType, boolean)}.
   * <p>
   * Method under test:
   * {@link EntitiesImportCtx#registerResult(EntityType, boolean)}
   */
  @Test
  @DisplayName("Test registerResult(EntityType, boolean)")
  void testRegisterResult2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    entitiesImportCtx.registerResult(EntityType.TENANT, false);

    // Assert
    Map<EntityType, EntityTypeLoadResult> results = entitiesImportCtx.getResults();
    assertEquals(1, results.size());
    EntityTypeLoadResult getResult = results.get(EntityType.TENANT);
    assertEquals(0, getResult.getCreated());
    assertEquals(0, getResult.getDeleted());
    assertEquals(1, getResult.getUpdated());
    assertEquals(EntityType.TENANT, getResult.getEntityType());
  }

  /**
   * Test {@link EntitiesImportCtx#registerResult(EntityType, boolean)}.
   * <p>
   * Method under test:
   * {@link EntitiesImportCtx#registerResult(EntityType, boolean)}
   */
  @Test
  @DisplayName("Test registerResult(EntityType, boolean)")
  void testRegisterResult3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(UUID.randomUUID(), mock(User.class), "42");

    // Act
    entitiesImportCtx.registerResult(EntityType.TENANT, true);

    // Assert
    Map<EntityType, EntityTypeLoadResult> results = entitiesImportCtx.getResults();
    assertEquals(1, results.size());
    EntityTypeLoadResult getResult = results.get(EntityType.TENANT);
    assertEquals(0, getResult.getDeleted());
    assertEquals(0, getResult.getUpdated());
    assertEquals(1, getResult.getCreated());
    assertEquals(EntityType.TENANT, getResult.getEntityType());
  }

  /**
   * Test {@link EntitiesImportCtx#registerDeleted(EntityType)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#registerDeleted(EntityType)}
   */
  @Test
  @DisplayName("Test registerDeleted(EntityType)")
  void testRegisterDeleted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    entitiesImportCtx.registerDeleted(EntityType.TENANT);

    // Assert
    Map<EntityType, EntityTypeLoadResult> results = entitiesImportCtx.getResults();
    assertEquals(1, results.size());
    EntityTypeLoadResult getResult = results.get(EntityType.TENANT);
    assertEquals(0, getResult.getCreated());
    assertEquals(0, getResult.getUpdated());
    assertEquals(1, getResult.getDeleted());
    assertEquals(EntityType.TENANT, getResult.getEntityType());
  }

  /**
   * Test {@link EntitiesImportCtx#registerDeleted(EntityType)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#registerDeleted(EntityType)}
   */
  @Test
  @DisplayName("Test registerDeleted(EntityType)")
  void testRegisterDeleted2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(UUID.randomUUID(), mock(User.class), "42");

    // Act
    entitiesImportCtx.registerDeleted(EntityType.TENANT);

    // Assert
    Map<EntityType, EntityTypeLoadResult> results = entitiesImportCtx.getResults();
    assertEquals(1, results.size());
    EntityTypeLoadResult getResult = results.get(EntityType.TENANT);
    assertEquals(0, getResult.getCreated());
    assertEquals(0, getResult.getUpdated());
    assertEquals(1, getResult.getDeleted());
    assertEquals(EntityType.TENANT, getResult.getEntityType());
  }

  /**
   * Test {@link EntitiesImportCtx#addRelations(Collection)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#addRelations(Collection)}
   */
  @Test
  @DisplayName("Test addRelations(Collection)")
  void testAddRelations() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    entitiesImportCtx.addRelations(new ArrayList<>());

    // Assert
    assertTrue(entitiesImportCtx.getRelations().isEmpty());
  }

  /**
   * Test {@link EntitiesImportCtx#addRelations(Collection)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#addRelations(Collection)}
   */
  @Test
  @DisplayName("Test addRelations(Collection)")
  void testAddRelations2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(UUID.randomUUID(), mock(User.class), "42");

    // Act
    entitiesImportCtx.addRelations(new ArrayList<>());

    // Assert
    assertTrue(entitiesImportCtx.getRelations().isEmpty());
  }

  /**
   * Test {@link EntitiesImportCtx#addRelations(Collection)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#addRelations(Collection)}
   */
  @Test
  @DisplayName("Test addRelations(Collection)")
  void testAddRelations3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");

    ArrayList<EntityRelation> values = new ArrayList<>();
    values.add(new EntityRelation());

    // Act
    entitiesImportCtx.addRelations(values);

    // Assert
    assertEquals(1, entitiesImportCtx.getRelations().size());
  }

  /**
   * Test {@link EntitiesImportCtx#addRelations(Collection)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#addRelations(Collection)}
   */
  @Test
  @DisplayName("Test addRelations(Collection)")
  void testAddRelations4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");

    ArrayList<EntityRelation> values = new ArrayList<>();
    values.add(new EntityRelation());
    values.add(new EntityRelation());

    // Act
    entitiesImportCtx.addRelations(values);

    // Assert
    assertEquals(1, entitiesImportCtx.getRelations().size());
  }

  /**
   * Test
   * {@link EntitiesImportCtx#addReferenceCallback(EntityId, ThrowingRunnable)}.
   * <p>
   * Method under test:
   * {@link EntitiesImportCtx#addReferenceCallback(EntityId, ThrowingRunnable)}
   */
  @Test
  @DisplayName("Test addReferenceCallback(EntityId, ThrowingRunnable)")
  void testAddReferenceCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    ThrowingRunnable tr = mock(ThrowingRunnable.class);

    // Act
    entitiesImportCtx.addReferenceCallback(null, tr);

    // Assert
    Map<EntityId, ThrowingRunnable> referenceCallbacks = entitiesImportCtx.getReferenceCallbacks();
    assertEquals(1, referenceCallbacks.size());
    assertSame(tr, referenceCallbacks.get(null));
  }

  /**
   * Test
   * {@link EntitiesImportCtx#addReferenceCallback(EntityId, ThrowingRunnable)}.
   * <p>
   * Method under test:
   * {@link EntitiesImportCtx#addReferenceCallback(EntityId, ThrowingRunnable)}
   */
  @Test
  @DisplayName("Test addReferenceCallback(EntityId, ThrowingRunnable)")
  void testAddReferenceCallback2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    entitiesImportCtx.addReferenceCallback(null, null);

    // Assert that nothing has changed
    assertTrue(entitiesImportCtx.getReferenceCallbacks().isEmpty());
  }
}
