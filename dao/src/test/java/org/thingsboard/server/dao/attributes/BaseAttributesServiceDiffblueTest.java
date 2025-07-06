package org.thingsboard.server.dao.attributes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

@RunWith(MockitoJUnitRunner.class)
public class BaseAttributesServiceDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.find(TenantId, EntityId, AttributeScope, String)"
  })
  public void testFindWithTenantIdEntityIdScopeAttributeKey_thenReturnDone()
      throws InterruptedException, ExecutionException {
    // Arrange
    Optional<AttributeKvEntry> ofResult =
        Optional.of(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    when(attributesDao.find(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<String>any()))
        .thenReturn(ofResult);

    // Act
    ListenableFuture<Optional<AttributeKvEntry>> actualFindResult =
        baseAttributesService.find(
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
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.find(TenantId, EntityId, AttributeScope, Collection)"
  })
  public void testFindWithTenantIdEntityIdScopeAttributeKeys_given42_whenArrayListAdd42()
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
   * Test {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope, Collection)} with
   * {@code tenantId}, {@code entityId}, {@code scope}, {@code attributeKeys}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.find(TenantId, EntityId, AttributeScope, Collection)"
  })
  public void testFindWithTenantIdEntityIdScopeAttributeKeys_givenFoo_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    when(attributesDao.find(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<Collection<String>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> attributeKeys = new ArrayList<>();
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
   * Test {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope, Collection)} with
   * {@code tenantId}, {@code entityId}, {@code scope}, {@code attributeKeys}.
   *
   * <ul>
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.find(TenantId, EntityId, AttributeScope, Collection)"
  })
  public void testFindWithTenantIdEntityIdScopeAttributeKeys_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    when(attributesDao.find(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<Collection<String>>any()))
        .thenReturn(new ArrayList<>());

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
   * Test {@link BaseAttributesService#findAll(TenantId, EntityId, AttributeScope)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.findAll(TenantId, EntityId, AttributeScope)"
  })
  public void testFindAll_whenNull_customer_id_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    when(attributesDao.findAll(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any()))
        .thenReturn(new ArrayList<>());

    // Act
    ListenableFuture<List<AttributeKvEntry>> actualFindAllResult =
        baseAttributesService.findAll(
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
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "List BaseAttributesService.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_thenReturnEmpty() {
    // Arrange
    when(attributesDao.findAllKeysByDeviceProfileId(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        baseAttributesService.findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(attributesDao).findAllKeysByDeviceProfileId(isA(TenantId.class), isNull());
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List, String)} with {@code
   * tenantId}, {@code entityIds}, {@code scope}.
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIdsAndAttributeType(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

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
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_givenNull_customer_id() {
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
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_givenNull_customer_id2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_whenEmptyString() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_whenNull() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

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
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIds_givenNull_customer_id() {
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
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIds_givenNull_customer_id2() {
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
   * Test {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)} with {@code
   * tenantId}, {@code entityIds}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BaseAttributesService.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIds_whenArrayList() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        baseAttributesService.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>());

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.save(TenantId, EntityId, AttributeScope, AttributeKvEntry)"
  })
  public void testSaveWithTenantIdEntityIdAttributeScopeAttributeKvEntry() {
    // Arrange
    SettableFuture<Long> createResult = SettableFuture.create();
    when(attributesDao.save(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<AttributeKvEntry>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Long> actualSaveResult =
        baseAttributesService.save(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.save(TenantId, EntityId, AttributeScope, List)"
  })
  public void testSaveWithTenantIdEntityIdAttributeScopeList() {
    // Arrange
    SettableFuture<Long> createResult = SettableFuture.create();
    when(attributesDao.save(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<AttributeKvEntry>any()))
        .thenReturn(createResult);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(255L, new JsonDataEntry("Key", "42")));
    attributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

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
   *   <li>Then calls {@link AttributesDao#save(TenantId, EntityId, AttributeScope,
   *       AttributeKvEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope,
   * List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.save(TenantId, EntityId, AttributeScope, List)"
  })
  public void testSaveWithTenantIdEntityIdAttributeScopeList_thenCallsSave() {
    // Arrange
    SettableFuture<Long> createResult = SettableFuture.create();
    when(attributesDao.save(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<AttributeKvEntry>any()))
        .thenReturn(createResult);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

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
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope,
   * List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.save(TenantId, EntityId, AttributeScope, List)"
  })
  public void testSaveWithTenantIdEntityIdAttributeScopeList_whenArrayList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
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
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#save(TenantId, EntityId, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.save(TenantId, EntityId, String, List)"
  })
  public void testSaveWithTenantIdEntityIdStringList_whenArrayList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
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
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#removeAll(TenantId, EntityId,
   * AttributeScope, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.removeAll(TenantId, EntityId, AttributeScope, List)"
  })
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_given42_whenArrayListAdd42()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.removeAll(TenantId, EntityId, AttributeScope, List)"
  })
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_givenArrayListAddCreate() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.removeAll(TenantId, EntityId, AttributeScope, List)"
  })
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_givenArrayListAddCreate2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.removeAll(TenantId, EntityId, AttributeScope, List)"
  })
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_givenFoo_whenArrayListAddFoo()
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
   * Test {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)} with
   * {@code TenantId}, {@code EntityId}, {@code AttributeScope}, {@code List}.
   *
   * <ul>
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributesService#removeAll(TenantId, EntityId,
   * AttributeScope, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAttributesService.removeAll(TenantId, EntityId, AttributeScope, List)"
  })
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    when(attributesDao.removeAll(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    ListenableFuture<List<String>> actualRemoveAllResult =
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
    assertTrue(actualRemoveAllResult.get().isEmpty());
    assertTrue(actualRemoveAllResult.isDone());
  }

  /**
   * Test {@link BaseAttributesService#removeAllByEntityId(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link BaseAttributesService#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BaseAttributesService.removeAllByEntityId(TenantId, EntityId)"})
  public void testRemoveAllByEntityId() {
    // Arrange
    when(attributesDao.removeAllByEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    int actualRemoveAllByEntityIdResult =
        baseAttributesService.removeAllByEntityId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(attributesDao).removeAllByEntityId(isA(TenantId.class), isA(EntityId.class));
    assertEquals(0, actualRemoveAllByEntityIdResult);
  }
}
