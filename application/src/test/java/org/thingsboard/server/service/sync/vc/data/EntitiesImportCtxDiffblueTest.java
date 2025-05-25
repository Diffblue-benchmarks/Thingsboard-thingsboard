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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.common.data.sync.ie.EntityImportSettings;
import org.thingsboard.server.common.data.sync.ie.EntityImportSettings.EntityImportSettingsBuilder;
import org.thingsboard.server.common.data.sync.vc.EntityTypeLoadResult;
import org.thingsboard.server.common.data.util.ThrowingRunnable;
import org.thingsboard.server.service.security.model.SecurityUser;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class EntitiesImportCtxDiffblueTest {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.TenantId EntitiesImportCtx.getTenantId()"})
  void testGetTenantId_thenReturnNull() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNull((new EntitiesImportCtx(requestId, new User(), "42")).getTenantId());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.isFindExistingByName()"})
  void testIsFindExistingByName_thenReturnFalse() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.isUpdateRelations()"})
  void testIsUpdateRelations_thenReturnFalse() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.isUpdateRelations()"})
  void testIsUpdateRelations_thenReturnTrue() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.isSaveAttributes()"})
  void testIsSaveAttributes_thenReturnFalse() {
    // Arrange
    EntityImportSettingsBuilder entityImportSettingsBuilder = mock(EntityImportSettingsBuilder.class);
    when(entityImportSettingsBuilder.saveAttributes(anyBoolean())).thenReturn(EntityImportSettings.builder());
    EntityImportSettings settings = entityImportSettingsBuilder.saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.isSaveAttributes()"})
  void testIsSaveAttributes_thenReturnTrue() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.isSaveCredentials()"})
  void testIsSaveCredentials_thenReturnFalse() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.isSaveCredentials()"})
  void testIsSaveCredentials_thenReturnTrue() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
   * Test {@link EntitiesImportCtx#getInternalId(EntityId)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#getInternalId(EntityId)}
   */
  @Test
  @DisplayName("Test getInternalId(EntityId); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId EntitiesImportCtx.getInternalId(EntityId)"})
  void testGetInternalId_thenReturnNull() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act and Assert
    assertNull(entitiesImportCtx.getInternalId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link EntitiesImportCtx#registerResult(EntityType, boolean)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#registerResult(EntityType, boolean)}
   */
  @Test
  @DisplayName("Test registerResult(EntityType, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesImportCtx.registerResult(EntityType, boolean)"})
  void testRegisterResult() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
   * Method under test: {@link EntitiesImportCtx#registerResult(EntityType, boolean)}
   */
  @Test
  @DisplayName("Test registerResult(EntityType, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesImportCtx.registerResult(EntityType, boolean)"})
  void testRegisterResult2() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
   * Test {@link EntitiesImportCtx#registerDeleted(EntityType)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#registerDeleted(EntityType)}
   */
  @Test
  @DisplayName("Test registerDeleted(EntityType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesImportCtx.registerDeleted(EntityType)"})
  void testRegisterDeleted() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
   * Test {@link EntitiesImportCtx#addRelations(Collection)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#addRelations(Collection)}
   */
  @Test
  @DisplayName("Test addRelations(Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesImportCtx.addRelations(Collection)"})
  void testAddRelations() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    entitiesImportCtx.addRelations(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(entitiesImportCtx.getRelations().isEmpty());
  }

  /**
   * Test {@link EntitiesImportCtx#addRelations(Collection)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#addRelations(Collection)}
   */
  @Test
  @DisplayName("Test addRelations(Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesImportCtx.addRelations(Collection)"})
  void testAddRelations2() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesImportCtx.addRelations(Collection)"})
  void testAddRelations3() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
   * Test {@link EntitiesImportCtx#addReferenceCallback(EntityId, ThrowingRunnable)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#addReferenceCallback(EntityId, ThrowingRunnable)}
   */
  @Test
  @DisplayName("Test addReferenceCallback(EntityId, ThrowingRunnable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesImportCtx.addReferenceCallback(EntityId, ThrowingRunnable)"})
  void testAddReferenceCallback() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
   * Test {@link EntitiesImportCtx#addReferenceCallback(EntityId, ThrowingRunnable)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#addReferenceCallback(EntityId, ThrowingRunnable)}
   */
  @Test
  @DisplayName("Test addReferenceCallback(EntityId, ThrowingRunnable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesImportCtx.addReferenceCallback(EntityId, ThrowingRunnable)"})
  void testAddReferenceCallback2() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    entitiesImportCtx.addReferenceCallback(null, null);

    // Assert that nothing has changed
    assertTrue(entitiesImportCtx.getReferenceCallbacks().isEmpty());
  }

  /**
   * Test {@link EntitiesImportCtx#addEventCallback(ThrowingRunnable)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#addEventCallback(ThrowingRunnable)}
   */
  @Test
  @DisplayName("Test addEventCallback(ThrowingRunnable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesImportCtx.addEventCallback(ThrowingRunnable)"})
  void testAddEventCallback() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    ThrowingRunnable tr = mock(ThrowingRunnable.class);

    // Act
    entitiesImportCtx.addEventCallback(tr);

    // Assert
    List<ThrowingRunnable> eventCallbacks = entitiesImportCtx.getEventCallbacks();
    assertEquals(1, eventCallbacks.size());
    assertSame(tr, eventCallbacks.get(0));
  }

  /**
   * Test {@link EntitiesImportCtx#addEventCallback(ThrowingRunnable)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#addEventCallback(ThrowingRunnable)}
   */
  @Test
  @DisplayName("Test addEventCallback(ThrowingRunnable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesImportCtx.addEventCallback(ThrowingRunnable)"})
  void testAddEventCallback2() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    entitiesImportCtx.addEventCallback(null);

    // Assert that nothing has changed
    assertTrue(entitiesImportCtx.getEventCallbacks().isEmpty());
  }

  /**
   * Test {@link EntitiesImportCtx#registerNotFound(EntityId)}.
   * <p>
   * Method under test: {@link EntitiesImportCtx#registerNotFound(EntityId)}
   */
  @Test
  @DisplayName("Test registerNotFound(EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesImportCtx.registerNotFound(EntityId)"})
  void testRegisterNotFound() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    entitiesImportCtx.registerNotFound(null);

    // Assert
    assertEquals(1, entitiesImportCtx.getNotFoundIds().size());
  }

  /**
   * Test {@link EntitiesImportCtx#isNotFound(EntityId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesImportCtx#isNotFound(EntityId)}
   */
  @Test
  @DisplayName("Test isNotFound(EntityId); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.isNotFound(EntityId)"})
  void testIsNotFound_whenNull_thenReturnFalse() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertFalse((new EntitiesImportCtx(requestId, new User(), "42")).isNotFound(null));
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}, and {@link EntitiesImportCtx#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx entitiesImportCtx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertEquals(entitiesImportCtx, entitiesImportCtx2);
    int expectedHashCodeResult = entitiesImportCtx.hashCode();
    assertEquals(expectedHashCodeResult, entitiesImportCtx2.hashCode());
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}, and {@link EntitiesImportCtx#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(null, new User(), "42");
    EntitiesImportCtx entitiesImportCtx2 = new EntitiesImportCtx(null, new User(), "42");

    // Act and Assert
    assertEquals(entitiesImportCtx, entitiesImportCtx2);
    int expectedHashCodeResult = entitiesImportCtx.hashCode();
    assertEquals(expectedHashCodeResult, entitiesImportCtx2.hashCode());
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}, and {@link EntitiesImportCtx#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
        null, "42");
    EntitiesImportCtx entitiesImportCtx2 = new EntitiesImportCtx(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), null, "42");

    // Act and Assert
    assertEquals(entitiesImportCtx, entitiesImportCtx2);
    int expectedHashCodeResult = entitiesImportCtx.hashCode();
    assertEquals(expectedHashCodeResult, entitiesImportCtx2.hashCode());
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}, and {@link EntitiesImportCtx#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), null);
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx entitiesImportCtx2 = new EntitiesImportCtx(requestId2, new User(), null);

    // Act and Assert
    assertEquals(entitiesImportCtx, entitiesImportCtx2);
    int expectedHashCodeResult = entitiesImportCtx.hashCode();
    assertEquals(expectedHashCodeResult, entitiesImportCtx2.hashCode());
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}, and {@link EntitiesImportCtx#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    User user = new User();
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, user, "42", settings);
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    User user2 = new User();
    EntityImportSettings settings2 = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    EntitiesImportCtx entitiesImportCtx2 = new EntitiesImportCtx(requestId2, user2, "42", settings2);

    // Act and Assert
    assertEquals(entitiesImportCtx, entitiesImportCtx2);
    int expectedHashCodeResult = entitiesImportCtx.hashCode();
    assertEquals(expectedHashCodeResult, entitiesImportCtx2.hashCode());
  }

  /**
   * Test {@link EntitiesImportCtx#equals(Object)}, and {@link EntitiesImportCtx#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(null, new User(), "42");
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
        null, "42");
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new SecurityUser(), "42");
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "1.0.2");
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), null);
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    User user = new User();
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, user, "42", settings);
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    entitiesImportCtx.addEventCallback(mock(ThrowingRunnable.class));
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    entitiesImportCtx.setFinalImportAttempt(true);
    entitiesImportCtx.addEventCallback(mock(ThrowingRunnable.class));
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    entitiesImportCtx.setRollbackOnError(true);
    entitiesImportCtx.addEventCallback(mock(ThrowingRunnable.class));
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    User user = new User();
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(entitiesImportCtx, new EntitiesImportCtx(requestId2, user, "42", settings));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    EntitiesImportCtx entitiesImportCtx = new EntitiesImportCtx(requestId, new User(), "42");
    entitiesImportCtx.setCurrentImportResult(new EntityImportResult<>());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(entitiesImportCtx, new EntitiesImportCtx(requestId2, new User(), "42"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesImportCtx.equals(Object)", "int EntitiesImportCtx.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(new EntitiesImportCtx(requestId, new User(), "42"), "Different type to EntitiesImportCtx");
  }
}
