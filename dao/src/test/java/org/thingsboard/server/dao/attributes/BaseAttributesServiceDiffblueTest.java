package org.thingsboard.server.dao.attributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;

@ExtendWith(MockitoExtension.class)
class BaseAttributesServiceDiffblueTest {
  @Mock private AttributesDao attributesDao;

  @InjectMocks private BaseAttributesService baseAttributesService;

  /**
   * Test {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope, String)} with {@code
   * tenantId}, {@code entityId}, {@code scope}, {@code attributeKey}.
   *
   * <ul>
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope,
   * String)}
   */
  @Test
  @DisplayName(
      "Test find(TenantId, EntityId, AttributeScope, String) with 'tenantId', 'entityId', 'scope', 'attributeKey'; then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.find(TenantId, EntityId, AttributeScope, String)"
  })
  void testFindWithTenantIdEntityIdScopeAttributeKey_thenReturnDone()
      throws InterruptedException, ExecutionException {
    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    Optional<AttributeKvEntry> ofResult = Optional.of(baseAttributeKvEntry);
    when(attributesDao.find(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<String>any()))
        .thenReturn(ofResult);

    // Act
    ListenableFuture<Optional<AttributeKvEntry>> actualFindResult =
        new BaseAttributesService(attributesDao)
            .find(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                AttributeScope.CLIENT_SCOPE,
                "Attribute Key");

    // Assert
    verify(attributesDao)
        .find(
            isA(TenantId.class),
            isA(EntityId.class),
            eq(AttributeScope.CLIENT_SCOPE),
            eq("Attribute Key"));
    assertTrue(actualFindResult.isDone());
    assertSame(ofResult, actualFindResult.get());
  }

  /**
   * Test {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope, Collection)} with
   * {@code tenantId}, {@code entityId}, {@code scope}, {@code attributeKeys}.
   *
   * <p>Method under test: {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test find(TenantId, EntityId, AttributeScope, Collection) with 'tenantId', 'entityId', 'scope', 'attributeKeys'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.find(TenantId, EntityId, AttributeScope, Collection)"
  })
  void testFindWithTenantIdEntityIdScopeAttributeKeys()
      throws InterruptedException, ExecutionException {
    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.find(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<Collection<String>>any()))
        .thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    // Act
    ListenableFuture<List<AttributeKvEntry>> actualFindResult =
        baseAttributesService.find(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            new ArrayList<>());

    // Assert
    verify(attributesDao)
        .find(
            isA(TenantId.class),
            isA(EntityId.class),
            eq(AttributeScope.CLIENT_SCOPE),
            isA(Collection.class));
    assertTrue(actualFindResult.get().isEmpty());
    assertTrue(actualFindResult.isDone());
  }

  /**
   * Test {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope, Collection)} with
   * {@code tenantId}, {@code entityId}, {@code scope}, {@code attributeKeys}.
   *
   * <p>Method under test: {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test find(TenantId, EntityId, AttributeScope, Collection) with 'tenantId', 'entityId', 'scope', 'attributeKeys'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.find(TenantId, EntityId, AttributeScope, Collection)"
  })
  void testFindWithTenantIdEntityIdScopeAttributeKeys2()
      throws InterruptedException, ExecutionException {
    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.find(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<Collection<String>>any()))
        .thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("42");

    // Act
    ListenableFuture<List<AttributeKvEntry>> actualFindResult =
        baseAttributesService.find(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            attributeKeys);

    // Assert
    verify(attributesDao)
        .find(
            isA(TenantId.class),
            isA(EntityId.class),
            eq(AttributeScope.CLIENT_SCOPE),
            isA(Collection.class));
    assertTrue(actualFindResult.get().isEmpty());
    assertTrue(actualFindResult.isDone());
  }

  /**
   * Test {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope, Collection)} with
   * {@code tenantId}, {@code entityId}, {@code scope}, {@code attributeKeys}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test find(TenantId, EntityId, AttributeScope, Collection) with 'tenantId', 'entityId', 'scope', 'attributeKeys'; given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.find(TenantId, EntityId, AttributeScope, Collection)"
  })
  void testFindWithTenantIdEntityIdScopeAttributeKeys_givenFoo_whenArrayListAddFoo()
      throws InterruptedException, ExecutionException {
    // Arrange
    when(attributesDao.find(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<Collection<String>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("42");
    attributeKeys.add("foo");

    // Act
    ListenableFuture<List<AttributeKvEntry>> actualFindResult =
        baseAttributesService.find(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            attributeKeys);

    // Assert
    verify(attributesDao)
        .find(
            isA(TenantId.class),
            isA(EntityId.class),
            eq(AttributeScope.CLIENT_SCOPE),
            isA(Collection.class));
    assertTrue(actualFindResult.get().isEmpty());
    assertTrue(actualFindResult.isDone());
  }

  /**
   * Test {@link BaseAttributesService#findAll(TenantId, EntityId, AttributeScope)}.
   *
   * <ul>
   *   <li>Given {@link JpaAttributeDao} {@link JpaAttributeDao#findAll(TenantId, EntityId,
   *       AttributeScope)} return {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  @DisplayName(
      "Test findAll(TenantId, EntityId, AttributeScope); given JpaAttributeDao findAll(TenantId, EntityId, AttributeScope) return ArrayList(); then return get() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.findAll(TenantId, EntityId, AttributeScope)"
  })
  void testFindAll_givenJpaAttributeDaoFindAllReturnArrayList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.findAll(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any()))
        .thenReturn(new ArrayList<>());

    // Act
    ListenableFuture<List<AttributeKvEntry>> actualFindAllResult =
        new BaseAttributesService(attributesDao)
            .findAll(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                AttributeScope.CLIENT_SCOPE);

    // Assert
    verify(attributesDao)
        .findAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE));
    assertTrue(actualFindAllResult.get().isEmpty());
    assertTrue(actualFindAllResult.isDone());
  }

  /**
   * Test {@link BaseAttributesService#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @DisplayName("Test findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseAttributesService.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  void testFindAllKeysByDeviceProfileId() {
    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.findAllKeysByDeviceProfileId(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        new BaseAttributesService(attributesDao)
            .findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(attributesDao).findAllKeysByDeviceProfileId(isA(TenantId.class), isNull());
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)} with {@code
   * tenantId}, {@code entityIds}.
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @DisplayName("Test findAllKeysByEntityIds(TenantId, List) with 'tenantId', 'entityIds'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List)"})
  void testFindAllKeysByEntityIdsWithTenantIdEntityIds() {
    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        baseAttributesService.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List, String)} with {@code
   * tenantId}, {@code entityIds}, {@code scope}.
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findAllKeysByEntityIds(TenantId, List, String) with 'tenantId', 'entityIds', 'scope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope() {
    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.findAllKeysByEntityIdsAndAttributeType(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        baseAttributesService.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>(), "Scope");

    // Assert
    verify(attributesDao)
        .findAllKeysByEntityIdsAndAttributeType(isA(TenantId.class), isA(List.class), eq("Scope"));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List, String)} with {@code
   * tenantId}, {@code entityIds}, {@code scope}.
   *
   * <ul>
   *   <li>Given {@link BaseAttributesService}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findAllKeysByEntityIds(TenantId, List, String) with 'tenantId', 'entityIds', 'scope'; given BaseAttributesService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_givenBaseAttributesService() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIdsAndAttributeType(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        baseAttributesService.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, entityIds, "Scope");

    // Assert
    verify(attributesDao)
        .findAllKeysByEntityIdsAndAttributeType(isA(TenantId.class), isA(List.class), eq("Scope"));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List, String)} with {@code
   * tenantId}, {@code entityIds}, {@code scope}.
   *
   * <ul>
   *   <li>Given {@link BaseAttributesService}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findAllKeysByEntityIds(TenantId, List, String) with 'tenantId', 'entityIds', 'scope'; given BaseAttributesService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_givenBaseAttributesService2() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIdsAndAttributeType(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        baseAttributesService.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, entityIds, "Scope");

    // Assert
    verify(attributesDao)
        .findAllKeysByEntityIdsAndAttributeType(isA(TenantId.class), isA(List.class), eq("Scope"));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List, String)} with {@code
   * tenantId}, {@code entityIds}, {@code scope}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findAllKeysByEntityIds(TenantId, List, String) with 'tenantId', 'entityIds', 'scope'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_whenEmptyString() {
    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        baseAttributesService.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>(), "");

    // Assert
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List, String)} with {@code
   * tenantId}, {@code entityIds}, {@code scope}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findAllKeysByEntityIds(TenantId, List, String) with 'tenantId', 'entityIds', 'scope'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_whenNull() {
    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        baseAttributesService.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>(), null);

    // Assert
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)} with {@code
   * tenantId}, {@code entityIds}.
   *
   * <ul>
   *   <li>Given {@link BaseAttributesService}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @DisplayName(
      "Test findAllKeysByEntityIds(TenantId, List) with 'tenantId', 'entityIds'; given BaseAttributesService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List)"})
  void testFindAllKeysByEntityIdsWithTenantIdEntityIds_givenBaseAttributesService() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        baseAttributesService.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)} with {@code
   * tenantId}, {@code entityIds}.
   *
   * <ul>
   *   <li>Given {@link BaseAttributesService}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @DisplayName(
      "Test findAllKeysByEntityIds(TenantId, List) with 'tenantId', 'entityIds'; given BaseAttributesService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List)"})
  void testFindAllKeysByEntityIdsWithTenantIdEntityIds_givenBaseAttributesService2() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        baseAttributesService.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope, AttributeKvEntry)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope}, {@code AttributeKvEntry}.
   *
   * <p>Method under test: {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope,
   * AttributeKvEntry)}
   */
  @Test
  @DisplayName(
      "Test save(TenantId, EntityId, AttributeScope, AttributeKvEntry) with 'TenantId', 'EntityId', 'AttributeScope', 'AttributeKvEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.save(TenantId, EntityId, AttributeScope, AttributeKvEntry)"
  })
  void testSaveWithTenantIdEntityIdAttributeScopeAttributeKvEntry() {
    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    SettableFuture<Long> createResult = SettableFuture.create();
    when(attributesDao.save(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<AttributeKvEntry>any()))
        .thenReturn(createResult);
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);
    BaseAttributeKvEntry attribute = new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act
    ListenableFuture<Long> actualSaveResult =
        baseAttributesService.save(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            attribute);

    // Assert
    verify(attributesDao)
        .save(
            isA(TenantId.class),
            isA(EntityId.class),
            eq(AttributeScope.CLIENT_SCOPE),
            isA(AttributeKvEntry.class));
    assertTrue(actualSaveResult instanceof SettableFuture);
    assertSame(createResult, actualSaveResult);
  }

  /**
   * Test {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope, List)} with {@code
   * TenantId}, {@code EntityId}, {@code AttributeScope}, {@code List}.
   *
   * <p>Method under test: {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope,
   * List)}
   */
  @Test
  @DisplayName(
      "Test save(TenantId, EntityId, AttributeScope, List) with 'TenantId', 'EntityId', 'AttributeScope', 'List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.save(TenantId, EntityId, AttributeScope, List)"
  })
  void testSaveWithTenantIdEntityIdAttributeScopeList() {
    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    SettableFuture<Long> createResult = SettableFuture.create();
    when(attributesDao.save(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<AttributeKvEntry>any()))
        .thenReturn(createResult);
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(255L, new JsonDataEntry("Key", "42"));
    attributes.add(baseAttributeKvEntry);
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    attributes.add(baseAttributeKvEntry2);

    // Act
    baseAttributesService.save(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        AttributeScope.CLIENT_SCOPE,
        attributes);

    // Assert
    verify(attributesDao, atLeast(1))
        .save(
            isA(TenantId.class),
            isA(EntityId.class),
            eq(AttributeScope.CLIENT_SCOPE),
            Mockito.<AttributeKvEntry>any());
  }

  /**
   * Test {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope, List)} with {@code
   * TenantId}, {@code EntityId}, {@code AttributeScope}, {@code List}.
   *
   * <ul>
   *   <li>Then calls {@link JpaAttributeDao#save(TenantId, EntityId, AttributeScope,
   *       AttributeKvEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope,
   * List)}
   */
  @Test
  @DisplayName(
      "Test save(TenantId, EntityId, AttributeScope, List) with 'TenantId', 'EntityId', 'AttributeScope', 'List'; then calls save(TenantId, EntityId, AttributeScope, AttributeKvEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.save(TenantId, EntityId, AttributeScope, List)"
  })
  void testSaveWithTenantIdEntityIdAttributeScopeList_thenCallsSave() {
    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    SettableFuture<Long> createResult = SettableFuture.create();
    when(attributesDao.save(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<AttributeKvEntry>any()))
        .thenReturn(createResult);
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    attributes.add(baseAttributeKvEntry);

    // Act
    baseAttributesService.save(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        AttributeScope.CLIENT_SCOPE,
        attributes);

    // Assert
    verify(attributesDao)
        .save(
            isA(TenantId.class),
            isA(EntityId.class),
            eq(AttributeScope.CLIENT_SCOPE),
            isA(AttributeKvEntry.class));
  }

  /**
   * Test {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope, List)} with {@code
   * TenantId}, {@code EntityId}, {@code AttributeScope}, {@code List}.
   *
   * <ul>
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope,
   * List)}
   */
  @Test
  @DisplayName(
      "Test save(TenantId, EntityId, AttributeScope, List) with 'TenantId', 'EntityId', 'AttributeScope', 'List'; then return get() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.save(TenantId, EntityId, AttributeScope, List)"
  })
  void testSaveWithTenantIdEntityIdAttributeScopeList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    BaseAttributesService baseAttributesService = new BaseAttributesService(new JpaAttributeDao());

    // Act
    ListenableFuture<List<Long>> actualSaveResult =
        baseAttributesService.save(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            new ArrayList<>());

    // Assert
    assertTrue(actualSaveResult.get().isEmpty());
    assertTrue(actualSaveResult.isDone());
  }

  /**
   * Test {@link BaseAttributesService#save(TenantId, EntityId, String, List)} with {@code
   * TenantId}, {@code EntityId}, {@code String}, {@code List}.
   *
   * <ul>
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#save(TenantId, EntityId, String, List)}
   */
  @Test
  @DisplayName(
      "Test save(TenantId, EntityId, String, List) with 'TenantId', 'EntityId', 'String', 'List'; then return get() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.save(TenantId, EntityId, String, List)"
  })
  void testSaveWithTenantIdEntityIdStringList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    BaseAttributesService baseAttributesService = new BaseAttributesService(new JpaAttributeDao());

    // Act
    ListenableFuture<List<Long>> actualSaveResult =
        baseAttributesService.save(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Scope",
            new ArrayList<>());

    // Assert
    assertTrue(actualSaveResult.get().isEmpty());
    assertTrue(actualSaveResult.isDone());
  }

  /**
   * Test {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)} with
   * {@code TenantId}, {@code EntityId}, {@code AttributeScope}, {@code List}.
   *
   * <p>Method under test: {@link BaseAttributesService#removeAll(TenantId, EntityId,
   * AttributeScope, List)}
   */
  @Test
  @DisplayName(
      "Test removeAll(TenantId, EntityId, AttributeScope, List) with 'TenantId', 'EntityId', 'AttributeScope', 'List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.removeAll(TenantId, EntityId, AttributeScope, List)"
  })
  void testRemoveAllWithTenantIdEntityIdAttributeScopeList()
      throws InterruptedException, ExecutionException {
    // Arrange
    BaseAttributesService baseAttributesService = new BaseAttributesService(new JpaAttributeDao());

    // Act
    ListenableFuture<List<String>> actualRemoveAllResult =
        baseAttributesService.removeAll(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            new ArrayList<>());

    // Assert
    assertTrue(actualRemoveAllResult.get().isEmpty());
    assertTrue(actualRemoveAllResult.isDone());
  }

  /**
   * Test {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)} with
   * {@code TenantId}, {@code EntityId}, {@code AttributeScope}, {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#removeAll(TenantId, EntityId,
   * AttributeScope, List)}
   */
  @Test
  @DisplayName(
      "Test removeAll(TenantId, EntityId, AttributeScope, List) with 'TenantId', 'EntityId', 'AttributeScope', 'List'; given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.removeAll(TenantId, EntityId, AttributeScope, List)"
  })
  void testRemoveAllWithTenantIdEntityIdAttributeScopeList_given42_whenArrayListAdd42()
      throws InterruptedException, ExecutionException {
    // Arrange
    when(attributesDao.removeAll(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("42");
    attributeKeys.add("foo");

    // Act
    ListenableFuture<List<String>> actualRemoveAllResult =
        baseAttributesService.removeAll(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            attributeKeys);

    // Assert
    verify(attributesDao)
        .removeAll(
            isA(TenantId.class),
            isA(EntityId.class),
            eq(AttributeScope.CLIENT_SCOPE),
            isA(List.class));
    assertTrue(actualRemoveAllResult.get().isEmpty());
    assertTrue(actualRemoveAllResult.isDone());
  }

  /**
   * Test {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)} with
   * {@code TenantId}, {@code EntityId}, {@code AttributeScope}, {@code List}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add create.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#removeAll(TenantId, EntityId,
   * AttributeScope, List)}
   */
  @Test
  @DisplayName(
      "Test removeAll(TenantId, EntityId, AttributeScope, List) with 'TenantId', 'EntityId', 'AttributeScope', 'List'; given ArrayList() add create")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.removeAll(TenantId, EntityId, AttributeScope, List)"
  })
  void testRemoveAllWithTenantIdEntityIdAttributeScopeList_givenArrayListAddCreate() {
    // Arrange
    ArrayList<ListenableFuture<String>> listenableFutureList = new ArrayList<>();
    SettableFuture<String> createResult = SettableFuture.create();
    listenableFutureList.add(createResult);
    when(attributesDao.removeAll(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<List<String>>any()))
        .thenReturn(listenableFutureList);

    // Act
    baseAttributesService.removeAll(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        AttributeScope.CLIENT_SCOPE,
        new ArrayList<>());

    // Assert
    verify(attributesDao)
        .removeAll(
            isA(TenantId.class),
            isA(EntityId.class),
            eq(AttributeScope.CLIENT_SCOPE),
            isA(List.class));
  }

  /**
   * Test {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)} with
   * {@code TenantId}, {@code EntityId}, {@code AttributeScope}, {@code List}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add create.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#removeAll(TenantId, EntityId,
   * AttributeScope, List)}
   */
  @Test
  @DisplayName(
      "Test removeAll(TenantId, EntityId, AttributeScope, List) with 'TenantId', 'EntityId', 'AttributeScope', 'List'; given ArrayList() add create")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.removeAll(TenantId, EntityId, AttributeScope, List)"
  })
  void testRemoveAllWithTenantIdEntityIdAttributeScopeList_givenArrayListAddCreate2() {
    // Arrange
    ArrayList<ListenableFuture<String>> listenableFutureList = new ArrayList<>();
    SettableFuture<String> createResult = SettableFuture.create();
    listenableFutureList.add(createResult);
    SettableFuture<String> createResult2 = SettableFuture.create();
    listenableFutureList.add(createResult2);
    when(attributesDao.removeAll(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<List<String>>any()))
        .thenReturn(listenableFutureList);

    // Act
    baseAttributesService.removeAll(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        AttributeScope.CLIENT_SCOPE,
        new ArrayList<>());

    // Assert
    verify(attributesDao)
        .removeAll(
            isA(TenantId.class),
            isA(EntityId.class),
            eq(AttributeScope.CLIENT_SCOPE),
            isA(List.class));
  }

  /**
   * Test {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)} with
   * {@code TenantId}, {@code EntityId}, {@code AttributeScope}, {@code List}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#removeAll(TenantId, EntityId,
   * AttributeScope, List)}
   */
  @Test
  @DisplayName(
      "Test removeAll(TenantId, EntityId, AttributeScope, List) with 'TenantId', 'EntityId', 'AttributeScope', 'List'; given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.removeAll(TenantId, EntityId, AttributeScope, List)"
  })
  void testRemoveAllWithTenantIdEntityIdAttributeScopeList_givenFoo_whenArrayListAddFoo()
      throws InterruptedException, ExecutionException {
    // Arrange
    when(attributesDao.removeAll(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("foo");

    // Act
    ListenableFuture<List<String>> actualRemoveAllResult =
        baseAttributesService.removeAll(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            attributeKeys);

    // Assert
    verify(attributesDao)
        .removeAll(
            isA(TenantId.class),
            isA(EntityId.class),
            eq(AttributeScope.CLIENT_SCOPE),
            isA(List.class));
    assertTrue(actualRemoveAllResult.get().isEmpty());
    assertTrue(actualRemoveAllResult.isDone());
  }

  /**
   * Test {@link BaseAttributesService#removeAllByEntityId(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link BaseAttributesService#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test removeAllByEntityId(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseAttributesService.removeAllByEntityId(TenantId, EntityId)"})
  void testRemoveAllByEntityId() {
    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAllByEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    int actualRemoveAllByEntityIdResult =
        new BaseAttributesService(attributesDao)
            .removeAllByEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(attributesDao).removeAllByEntityId(isA(TenantId.class), isA(EntityId.class));
    assertEquals(0, actualRemoveAllByEntityIdResult);
  }
}
