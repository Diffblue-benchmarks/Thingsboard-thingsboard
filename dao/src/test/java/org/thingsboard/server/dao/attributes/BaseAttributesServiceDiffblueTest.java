package org.thingsboard.server.dao.attributes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;

public class BaseAttributesServiceDiffblueTest {
  /**
   * Test
   * {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope, String)}
   * with {@code tenantId}, {@code entityId}, {@code scope}, {@code attributeKey}.
   * <ul>
   *   <li>Then return Done.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope, String)}
   */
  @Test
  public void testFindWithTenantIdEntityIdScopeAttributeKey_thenReturnDone()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    Optional<AttributeKvEntry> ofResult = Optional.of(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    when(attributesDao.find(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<String>any())).thenReturn(ofResult);

    // Act
    ListenableFuture<Optional<AttributeKvEntry>> actualFindResult = (new BaseAttributesService(attributesDao)).find(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, "Attribute Key");

    // Assert
    verify(attributesDao).find(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        eq("Attribute Key"));
    assertTrue(actualFindResult.isDone());
    assertSame(ofResult, actualFindResult.get());
  }

  /**
   * Test
   * {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope, Collection)}
   * with {@code tenantId}, {@code entityId}, {@code scope},
   * {@code attributeKeys}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope, Collection)}
   */
  @Test
  public void testFindWithTenantIdEntityIdScopeAttributeKeys_given42_thenCallsGetId()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.find(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("42");
    attributeKeys.add("foo");

    // Act
    ListenableFuture<List<AttributeKvEntry>> actualFindResult = baseAttributesService.find(ModelConstants.SYSTEM_TENANT,
        entityId, AttributeScope.CLIENT_SCOPE, attributeKeys);

    // Assert
    verify(entityId).getId();
    verify(attributesDao).find(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(Collection.class));
    assertTrue(actualFindResult.get().isEmpty());
    assertTrue(actualFindResult.isDone());
  }

  /**
   * Test
   * {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope, Collection)}
   * with {@code tenantId}, {@code entityId}, {@code scope},
   * {@code attributeKeys}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope, Collection)}
   */
  @Test
  public void testFindWithTenantIdEntityIdScopeAttributeKeys_givenNull_uuid_thenCallsGetId()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.find(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("foo");

    // Act
    ListenableFuture<List<AttributeKvEntry>> actualFindResult = baseAttributesService.find(ModelConstants.SYSTEM_TENANT,
        entityId, AttributeScope.CLIENT_SCOPE, attributeKeys);

    // Assert
    verify(entityId).getId();
    verify(attributesDao).find(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(Collection.class));
    assertTrue(actualFindResult.get().isEmpty());
    assertTrue(actualFindResult.isDone());
  }

  /**
   * Test
   * {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope, Collection)}
   * with {@code tenantId}, {@code entityId}, {@code scope},
   * {@code attributeKeys}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#find(TenantId, EntityId, AttributeScope, Collection)}
   */
  @Test
  public void testFindWithTenantIdEntityIdScopeAttributeKeys_whenNull_customer_id()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.find(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    // Act
    ListenableFuture<List<AttributeKvEntry>> actualFindResult = baseAttributesService.find(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, new ArrayList<>());

    // Assert
    verify(attributesDao).find(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(Collection.class));
    assertTrue(actualFindResult.get().isEmpty());
    assertTrue(actualFindResult.isDone());
  }

  /**
   * Test
   * {@link BaseAttributesService#findAll(TenantId, EntityId, AttributeScope)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  public void testFindAll_whenNull_customer_id_thenReturnGetEmpty() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.findAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any()))
        .thenReturn(new ArrayList<>());

    // Act
    ListenableFuture<List<AttributeKvEntry>> actualFindAllResult = (new BaseAttributesService(attributesDao))
        .findAll(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE);

    // Assert
    verify(attributesDao).findAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE));
    assertTrue(actualFindAllResult.get().isEmpty());
    assertTrue(actualFindAllResult.isDone());
  }

  /**
   * Test
   * {@link BaseAttributesService#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}
   */
  @Test
  public void testFindAllKeysByDeviceProfileId_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.findAllKeysByDeviceProfileId(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult = (new BaseAttributesService(attributesDao))
        .findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(attributesDao).findAllKeysByDeviceProfileId(isA(TenantId.class), isNull());
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test
   * {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   * with {@code tenantId}, {@code entityIds}, {@code scope}.
   * <p>
   * Method under test:
   * {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   */
  @Test
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.findAllKeysByEntityIdsAndAttributeType(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = baseAttributesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>(), "Scope");

    // Assert
    verify(attributesDao).findAllKeysByEntityIdsAndAttributeType(isA(TenantId.class), isA(List.class), eq("Scope"));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   * with {@code tenantId}, {@code entityIds}, {@code scope}.
   * <p>
   * Method under test:
   * {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   */
  @Test
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = baseAttributesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>(), "");

    // Assert
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   * with {@code tenantId}, {@code entityIds}, {@code scope}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   */
  @Test
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_givenNull_customer_id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.findAllKeysByEntityIdsAndAttributeType(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = baseAttributesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds, "Scope");

    // Assert
    verify(attributesDao).findAllKeysByEntityIdsAndAttributeType(isA(TenantId.class), isA(List.class), eq("Scope"));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   * with {@code tenantId}, {@code entityIds}, {@code scope}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   */
  @Test
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_givenNull_customer_id2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.findAllKeysByEntityIdsAndAttributeType(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = baseAttributesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds, "Scope");

    // Assert
    verify(attributesDao).findAllKeysByEntityIdsAndAttributeType(isA(TenantId.class), isA(List.class), eq("Scope"));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)}
   * with {@code tenantId}, {@code entityIds}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIds_givenNull_customer_id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = baseAttributesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)}
   * with {@code tenantId}, {@code entityIds}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIds_givenNull_customer_id2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = baseAttributesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)}
   * with {@code tenantId}, {@code entityIds}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIds_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    when(attributesDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = baseAttributesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope, AttributeKvEntry)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code AttributeKvEntry}.
   * <p>
   * Method under test:
   * {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope, AttributeKvEntry)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdAttributeScopeAttributeKvEntry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    SettableFuture<Long> createResult = SettableFuture.create();
    when(attributesDao.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<AttributeKvEntry>any())).thenReturn(createResult);
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    // Act
    ListenableFuture<Long> actualSaveResult = baseAttributesService.save(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE,
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Assert
    verify(attributesDao).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(AttributeKvEntry.class));
    assertTrue(actualSaveResult instanceof SettableFuture);
    assertSame(createResult, actualSaveResult);
  }

  /**
   * Test
   * {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope, List)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}.
   * <ul>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdAttributeScopeList_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    SettableFuture<Long> createResult = SettableFuture.create();
    when(attributesDao.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<AttributeKvEntry>any())).thenReturn(createResult);
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    baseAttributesService.save(ModelConstants.SYSTEM_TENANT, entityId, AttributeScope.CLIENT_SCOPE, attributes);

    // Assert
    verify(entityId).getId();
    verify(attributesDao).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(AttributeKvEntry.class));
  }

  /**
   * Test
   * {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope, List)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}.
   * <ul>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdAttributeScopeList_thenCallsGetId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AttributesDao attributesDao = mock(AttributesDao.class);
    SettableFuture<Long> createResult = SettableFuture.create();
    when(attributesDao.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<AttributeKvEntry>any())).thenReturn(createResult);
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(255L, new JsonDataEntry("Key", "42")));
    attributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    baseAttributesService.save(ModelConstants.SYSTEM_TENANT, entityId, AttributeScope.CLIENT_SCOPE, attributes);

    // Assert
    verify(entityId).getId();
    verify(attributesDao, atLeast(1)).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        Mockito.<AttributeKvEntry>any());
  }

  /**
   * Test
   * {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope, List)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}.
   * <ul>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdAttributeScopeList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAttributesService baseAttributesService = new BaseAttributesService(new JpaAttributeDao());

    // Act
    ListenableFuture<List<Long>> actualSaveResult = baseAttributesService.save(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, new ArrayList<>());

    // Assert
    assertTrue(actualSaveResult.get().isEmpty());
    assertTrue(actualSaveResult.isDone());
  }

  /**
   * Test
   * {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope, List)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}.
   * <ul>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#save(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdAttributeScopeList_thenReturnGetEmpty2()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAttributesService baseAttributesService = new BaseAttributesService(mock(AttributesDao.class));

    // Act
    ListenableFuture<List<Long>> actualSaveResult = baseAttributesService.save(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, new ArrayList<>());

    // Assert
    assertTrue(actualSaveResult.get().isEmpty());
    assertTrue(actualSaveResult.isDone());
  }

  /**
   * Test {@link BaseAttributesService#save(TenantId, EntityId, String, List)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List}.
   * <p>
   * Method under test:
   * {@link BaseAttributesService#save(TenantId, EntityId, String, List)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdStringList() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAttributesService baseAttributesService = new BaseAttributesService(mock(AttributesDao.class));

    // Act
    ListenableFuture<List<Long>> actualSaveResult = baseAttributesService.save(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, "Scope", new ArrayList<>());

    // Assert
    assertTrue(actualSaveResult.get().isEmpty());
    assertTrue(actualSaveResult.isDone());
  }

  /**
   * Test {@link BaseAttributesService#save(TenantId, EntityId, String, List)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#save(TenantId, EntityId, String, List)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdStringList_whenNull_customer_id_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAttributesService baseAttributesService = new BaseAttributesService(new JpaAttributeDao());

    // Act
    ListenableFuture<List<Long>> actualSaveResult = baseAttributesService.save(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, "Scope", new ArrayList<>());

    // Assert
    assertTrue(actualSaveResult.get().isEmpty());
    assertTrue(actualSaveResult.isDone());
  }

  /**
   * Test
   * {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}.
   * <p>
   * Method under test:
   * {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAttributesService baseAttributesService = new BaseAttributesService(new JpaAttributeDao());

    // Act
    ListenableFuture<List<String>> actualRemoveAllResult = baseAttributesService.removeAll(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, new ArrayList<>());

    // Assert
    assertTrue(actualRemoveAllResult.get().isEmpty());
    assertTrue(actualRemoveAllResult.isDone());
  }

  /**
   * Test
   * {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_given42_whenArrayListAdd42()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<String>>any())).thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("42");
    attributeKeys.add("foo");

    // Act
    ListenableFuture<List<String>> actualRemoveAllResult = baseAttributesService.removeAll(ModelConstants.SYSTEM_TENANT,
        entityId, AttributeScope.CLIENT_SCOPE, attributeKeys);

    // Assert
    verify(entityId).getId();
    verify(attributesDao).removeAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
    assertTrue(actualRemoveAllResult.get().isEmpty());
    assertTrue(actualRemoveAllResult.isDone());
  }

  /**
   * Test
   * {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add create.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_givenArrayListAddCreate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<ListenableFuture<String>> listenableFutureList = new ArrayList<>();
    SettableFuture<String> createResult = SettableFuture.create();
    listenableFutureList.add(createResult);
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<String>>any())).thenReturn(listenableFutureList);
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    // Act
    baseAttributesService.removeAll(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        AttributeScope.CLIENT_SCOPE, new ArrayList<>());

    // Assert
    verify(attributesDao).removeAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add create.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_givenArrayListAddCreate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<ListenableFuture<String>> listenableFutureList = new ArrayList<>();
    SettableFuture<String> createResult = SettableFuture.create();
    listenableFutureList.add(createResult);
    SettableFuture<String> createResult2 = SettableFuture.create();
    listenableFutureList.add(createResult2);
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<String>>any())).thenReturn(listenableFutureList);
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    // Act
    baseAttributesService.removeAll(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        AttributeScope.CLIENT_SCOPE, new ArrayList<>());

    // Assert
    verify(attributesDao).removeAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_thenCallsGetId()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<String>>any())).thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("foo");

    // Act
    ListenableFuture<List<String>> actualRemoveAllResult = baseAttributesService.removeAll(ModelConstants.SYSTEM_TENANT,
        entityId, AttributeScope.CLIENT_SCOPE, attributeKeys);

    // Assert
    verify(entityId).getId();
    verify(attributesDao).removeAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
    assertTrue(actualRemoveAllResult.get().isEmpty());
    assertTrue(actualRemoveAllResult.isDone());
  }

  /**
   * Test
   * {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}.
   * <ul>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<String>>any())).thenReturn(new ArrayList<>());
    BaseAttributesService baseAttributesService = new BaseAttributesService(attributesDao);

    // Act
    ListenableFuture<List<String>> actualRemoveAllResult = baseAttributesService.removeAll(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, new ArrayList<>());

    // Assert
    verify(attributesDao).removeAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
    assertTrue(actualRemoveAllResult.get().isEmpty());
    assertTrue(actualRemoveAllResult.isDone());
  }

  /**
   * Test {@link BaseAttributesService#removeAllByEntityId(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAttributesService#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  public void testRemoveAllByEntityId_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAllByEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    int actualRemoveAllByEntityIdResult = (new BaseAttributesService(attributesDao))
        .removeAllByEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(attributesDao).removeAllByEntityId(isA(TenantId.class), isA(EntityId.class));
    assertEquals(0, actualRemoveAllByEntityIdResult);
  }
}
