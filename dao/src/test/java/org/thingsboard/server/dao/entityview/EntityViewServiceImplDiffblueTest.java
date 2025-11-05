package org.thingsboard.server.dao.entityview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.EntityViewInfo;
import org.thingsboard.server.common.data.entityview.EntityViewSearchQuery;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.EntityRelationsQuery;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationsSearchParameters;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.validator.EntityViewDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ExtendWith(MockitoExtension.class)
class EntityViewServiceImplDiffblueTest {
  @Mock private EntityViewDao entityViewDao;

  @Mock private EntityViewDataValidator entityViewDataValidator;

  @InjectMocks private EntityViewServiceImpl entityViewServiceImpl;

  @Mock private JpaExecutorService jpaExecutorService;

  @Mock private RelationService relationService;

  /**
   * Test {@link EntityViewServiceImpl#handleEvictEvent(EntityViewEvictEvent)} with {@code
   * EntityViewEvictEvent}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#handleEvictEvent(EntityViewEvictEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvictEvent(EntityViewEvictEvent) with 'EntityViewEvictEvent'; then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.handleEvictEvent(EntityViewEvictEvent)"})
  void testHandleEvictEventWithEntityViewEvictEvent_thenThrowDataValidationException() {
    // Arrange
    EntityView savedEntityView = mock(EntityView.class);
    when(savedEntityView.getId()).thenThrow(new DataValidationException("An error occurred"));

    EntityViewEvictEvent event =
        new EntityViewEvictEvent(
            ModelConstants.SYSTEM_TENANT,
            null,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "New Name",
            "not empty");
    event.setSavedEntityView(savedEntityView);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> entityViewServiceImpl.handleEvictEvent(event));
    verify(savedEntityView).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#saveEntityView(EntityView)} with {@code entityView}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#saveEntityView(EntityView)}
   */
  @Test
  @DisplayName("Test saveEntityView(EntityView) with 'entityView'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewServiceImpl.saveEntityView(EntityView)"})
  void testSaveEntityViewWithEntityView() {
    // Arrange
    when(entityViewDataValidator.validate(
            Mockito.<EntityView>any(), Mockito.<Function<EntityView, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.saveEntityView(new EntityView()));
    verify(entityViewDataValidator).validate(isA(EntityView.class), isA(Function.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#saveEntityView(EntityView)} with {@code entityView}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#saveEntityView(EntityView)}
   */
  @Test
  @DisplayName("Test saveEntityView(EntityView) with 'entityView'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewServiceImpl.saveEntityView(EntityView)"})
  void testSaveEntityViewWithEntityView2() {
    // Arrange
    when(entityViewDao.save(Mockito.<TenantId>any(), Mockito.<EntityView>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(entityViewDataValidator.validate(
            Mockito.<EntityView>any(), Mockito.<Function<EntityView, TenantId>>any()))
        .thenReturn(new EntityView());
    EntityViewId id = new EntityViewId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.saveEntityView(new EntityView(id)));
    verify(entityViewDao).save(isNull(), isA(EntityView.class));
    verify(entityViewDataValidator).validate(isA(EntityView.class), isA(Function.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#saveEntityView(EntityView, boolean)} with {@code entityView},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#saveEntityView(EntityView, boolean)}
   */
  @Test
  @DisplayName("Test saveEntityView(EntityView, boolean) with 'entityView', 'doValidate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewServiceImpl.saveEntityView(EntityView, boolean)"})
  void testSaveEntityViewWithEntityViewDoValidate() {
    // Arrange
    when(entityViewDao.save(Mockito.<TenantId>any(), Mockito.<EntityView>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.saveEntityView(new EntityView((EntityViewId) null), false));
    verify(entityViewDao).save(isNull(), isA(EntityView.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#saveEntityView(EntityView, boolean)} with {@code entityView},
   * {@code doValidate}.
   *
   * <ul>
   *   <li>Then calls {@link EntityView#getEntityId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#saveEntityView(EntityView, boolean)}
   */
  @Test
  @DisplayName(
      "Test saveEntityView(EntityView, boolean) with 'entityView', 'doValidate'; then calls getEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewServiceImpl.saveEntityView(EntityView, boolean)"})
  void testSaveEntityViewWithEntityViewDoValidate_thenCallsGetEntityId() {
    // Arrange
    when(entityViewDao.save(Mockito.<TenantId>any(), Mockito.<EntityView>any()))
        .thenReturn(new EntityView());

    EntityView entityView = mock(EntityView.class);
    when(entityView.getEntityId()).thenThrow(new DataValidationException("An error occurred"));
    when(entityViewDataValidator.validate(
            Mockito.<EntityView>any(), Mockito.<Function<EntityView, TenantId>>any()))
        .thenReturn(entityView);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.saveEntityView(new EntityView(), true));
    verify(entityView).getEntityId();
    verify(entityViewDao).save(isNull(), isA(EntityView.class));
    verify(entityViewDataValidator).validate(isA(EntityView.class), isA(Function.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#saveEntityView(EntityView, boolean)} with {@code entityView},
   * {@code doValidate}.
   *
   * <ul>
   *   <li>Then calls {@link EntityViewId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#saveEntityView(EntityView, boolean)}
   */
  @Test
  @DisplayName(
      "Test saveEntityView(EntityView, boolean) with 'entityView', 'doValidate'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewServiceImpl.saveEntityView(EntityView, boolean)"})
  void testSaveEntityViewWithEntityViewDoValidate_thenCallsGetId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    EntityViewId id = mock(EntityViewId.class);
    when(id.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.saveEntityView(new EntityView(id), false));
    verify(id).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#saveEntityView(EntityView)} with {@code entityView}.
   *
   * <ul>
   *   <li>Then calls {@link EntityView#getEntityId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#saveEntityView(EntityView)}
   */
  @Test
  @DisplayName("Test saveEntityView(EntityView) with 'entityView'; then calls getEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewServiceImpl.saveEntityView(EntityView)"})
  void testSaveEntityViewWithEntityView_thenCallsGetEntityId() {
    // Arrange
    when(entityViewDao.save(Mockito.<TenantId>any(), Mockito.<EntityView>any()))
        .thenReturn(new EntityView());

    EntityView entityView = mock(EntityView.class);
    when(entityView.getEntityId()).thenThrow(new DataValidationException("An error occurred"));
    when(entityViewDataValidator.validate(
            Mockito.<EntityView>any(), Mockito.<Function<EntityView, TenantId>>any()))
        .thenReturn(entityView);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.saveEntityView(new EntityView()));
    verify(entityView).getEntityId();
    verify(entityViewDao).save(isNull(), isA(EntityView.class));
    verify(entityViewDataValidator).validate(isA(EntityView.class), isA(Function.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#unassignCustomerEntityViews(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID, UUID,
   *       PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#unassignCustomerEntityViews(TenantId,
   * CustomerId)}
   */
  @Test
  @DisplayName(
      "Test unassignCustomerEntityViews(TenantId, CustomerId); then calls findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityViewServiceImpl.unassignCustomerEntityViews(TenantId, CustomerId)"
  })
  void testUnassignCustomerEntityViews_thenCallsFindEntityViewsByTenantIdAndCustomerId() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    entityViewServiceImpl.unassignCustomerEntityViews(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#unassignCustomerEntityViews(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#unassignCustomerEntityViews(TenantId,
   * CustomerId)}
   */
  @Test
  @DisplayName(
      "Test unassignCustomerEntityViews(TenantId, CustomerId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityViewServiceImpl.unassignCustomerEntityViews(TenantId, CustomerId)"
  })
  void testUnassignCustomerEntityViews_thenThrowDataValidationException() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.unassignCustomerEntityViews(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfoById(TenantId, EntityViewId)}.
   *
   * <ul>
   *   <li>Then return {@link EntityViewInfo#EntityViewInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfoById(TenantId,
   * EntityViewId)}
   */
  @Test
  @DisplayName("Test findEntityViewInfoById(TenantId, EntityViewId); then return EntityViewInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityViewInfo EntityViewServiceImpl.findEntityViewInfoById(TenantId, EntityViewId)"
  })
  void testFindEntityViewInfoById_thenReturnEntityViewInfo() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    when(entityViewDao.findEntityViewInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(entityViewInfo);

    // Act
    EntityViewInfo actualFindEntityViewInfoByIdResult =
        entityViewServiceImpl.findEntityViewInfoById(
            ModelConstants.SYSTEM_TENANT,
            new EntityViewId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(entityViewDao).findEntityViewInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(entityViewInfo, actualFindEntityViewInfoByIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfoById(TenantId, EntityViewId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfoById(TenantId,
   * EntityViewId)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfoById(TenantId, EntityViewId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityViewInfo EntityViewServiceImpl.findEntityViewInfoById(TenantId, EntityViewId)"
  })
  void testFindEntityViewInfoById_thenThrowDataValidationException() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    EntityViewId entityViewId = mock(EntityViewId.class);
    when(entityViewId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfoById(
                ModelConstants.SYSTEM_TENANT, entityViewId));
    verify(entityViewId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewById(TenantId, EntityViewId, boolean)} with
   * {@code tenantId}, {@code entityViewId}, {@code putInCache}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewById(TenantId, EntityViewId,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewById(TenantId, EntityViewId, boolean) with 'tenantId', 'entityViewId', 'putInCache'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityView EntityViewServiceImpl.findEntityViewById(TenantId, EntityViewId, boolean)"
  })
  void testFindEntityViewByIdWithTenantIdEntityViewIdPutInCache() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    EntityViewId entityViewId = mock(EntityViewId.class);
    when(entityViewId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewById(
                ModelConstants.SYSTEM_TENANT, entityViewId, true));
    verify(entityViewId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewById(TenantId, EntityViewId)} with {@code
   * tenantId}, {@code entityViewId}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewById(TenantId, EntityViewId)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewById(TenantId, EntityViewId) with 'tenantId', 'entityViewId'; then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewServiceImpl.findEntityViewById(TenantId, EntityViewId)"})
  void testFindEntityViewByIdWithTenantIdEntityViewId_thenThrowDataValidationException() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    EntityViewId entityViewId = mock(EntityViewId.class);
    when(entityViewId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewById(ModelConstants.SYSTEM_TENANT, entityViewId));
    verify(entityViewId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantIdAndName(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantIdAndName(TenantId,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewByTenantIdAndName(TenantId, String); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityView EntityViewServiceImpl.findEntityViewByTenantIdAndName(TenantId, String)"
  })
  void testFindEntityViewByTenantIdAndName_thenThrowDataValidationException() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewByTenantIdAndName(tenantId, "Name"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantIdAndNameAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewByTenantIdAndNameAsync(TenantId, String); then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewByTenantIdAndNameAsync(TenantId, String)"
  })
  void testFindEntityViewByTenantIdAndNameAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<EntityView> actualFindEntityViewByTenantIdAndNameAsyncResult =
        entityViewServiceImpl.findEntityViewByTenantIdAndNameAsync(
            ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEntityViewByTenantIdAndNameAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEntityViewByTenantIdAndNameAsyncResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantIdAndNameAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewByTenantIdAndNameAsync(TenantId, String); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewByTenantIdAndNameAsync(TenantId, String)"
  })
  void testFindEntityViewByTenantIdAndNameAsync_thenThrowDataValidationException() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewByTenantIdAndNameAsync(tenantId, "Name"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  void testFindEntityViewByTenantId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  void testFindEntityViewByTenantId2() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  void testFindEntityViewByTenantId3() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  void testFindEntityViewByTenantId4() {
    // Arrange
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(entityViewDao).findEntityViewsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewByTenantId(TenantId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  void testFindEntityViewByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityView> actualFindEntityViewByTenantIdResult =
        entityViewServiceImpl.findEntityViewByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(entityViewDao).findEntityViewsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewByTenantIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewByTenantId(TenantId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  void testFindEntityViewByTenantId_thenCallsGetId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewByTenantId(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewByTenantId(TenantId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  void testFindEntityViewByTenantId_thenCallsGetProperty() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityView> actualFindEntityViewByTenantIdResult =
        entityViewServiceImpl.findEntityViewByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(entityViewDao).findEntityViewsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewByTenantIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewByTenantId(TenantId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  void testFindEntityViewByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityView> actualFindEntityViewByTenantIdResult =
        entityViewServiceImpl.findEntityViewByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewDao).findEntityViewsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewByTenantIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  void testFindEntityViewInfosByTenantId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantId(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  void testFindEntityViewInfosByTenantId2() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantId(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  void testFindEntityViewInfosByTenantId3() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantId(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  void testFindEntityViewInfosByTenantId4() {
    // Arrange
    when(entityViewDao.findEntityViewInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(entityViewDao).findEntityViewInfosByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewInfosByTenantId(TenantId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  void testFindEntityViewInfosByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult =
        entityViewServiceImpl.findEntityViewInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(entityViewDao).findEntityViewInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewInfosByTenantIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewInfosByTenantId(TenantId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  void testFindEntityViewInfosByTenantId_thenCallsGetId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewInfosByTenantId(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewInfosByTenantId(TenantId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  void testFindEntityViewInfosByTenantId_thenCallsGetProperty() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult =
        entityViewServiceImpl.findEntityViewInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(entityViewDao).findEntityViewInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewInfosByTenantIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantId(TenantId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  void testFindEntityViewInfosByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult =
        entityViewServiceImpl.findEntityViewInfosByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewDao).findEntityViewInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewInfosByTenantIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId, PageLink, String)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName("Test findEntityViewByTenantIdAndType(TenantId, PageLink, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  void testFindEntityViewByTenantIdAndType() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, pageLink, "Type"));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId, PageLink, String)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName("Test findEntityViewByTenantIdAndType(TenantId, PageLink, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  void testFindEntityViewByTenantIdAndType2() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, pageLink, "Type"));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId, PageLink, String)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName("Test findEntityViewByTenantIdAndType(TenantId, PageLink, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  void testFindEntityViewByTenantIdAndType3() {
    // Arrange
    when(entityViewDao.findEntityViewsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE, "Type"));
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId, PageLink, String)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewByTenantIdAndType(TenantId, PageLink, String); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  void testFindEntityViewByTenantIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityView> actualFindEntityViewByTenantIdAndTypeResult =
        entityViewServiceImpl.findEntityViewByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, pageLink, "Type");

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId, PageLink, String)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewByTenantIdAndType(TenantId, PageLink, String); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  void testFindEntityViewByTenantIdAndType_thenCallsGetId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewByTenantIdAndType(
                tenantId, mock(PageLink.class), "Type"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId, PageLink, String)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewByTenantIdAndType(TenantId, PageLink, String); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  void testFindEntityViewByTenantIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityView> actualFindEntityViewByTenantIdAndTypeResult =
        entityViewServiceImpl.findEntityViewByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, pageLink, "Type");

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId, PageLink, String)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId,
   * PageLink, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewByTenantIdAndType(TenantId, PageLink, String); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  void testFindEntityViewByTenantIdAndType_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityView> actualFindEntityViewByTenantIdAndTypeResult =
        entityViewServiceImpl.findEntityViewByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE, "Type");

    // Assert
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndType() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndType2() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndType3() {
    // Arrange
    when(entityViewDao.findEntityViewInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE));
    verify(entityViewDao)
        .findEntityViewInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult =
        entityViewServiceImpl.findEntityViewInfosByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(entityViewDao)
        .findEntityViewInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewInfosByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndType_thenCallsGetId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantIdAndType(
                tenantId, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult =
        entityViewServiceImpl.findEntityViewInfosByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(entityViewDao)
        .findEntityViewInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewInfosByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndType_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult =
        entityViewServiceImpl.findEntityViewInfosByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewDao)
        .findEntityViewInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewInfosByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndCustomerId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndCustomerId2() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndCustomerId3() {
    // Arrange
    when(entityViewDao.findEntityViewsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndCustomerId_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndCustomerId_thenCallsGetProperty() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndCustomerId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerId2() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerId3() {
    // Arrange
    when(entityViewDao.findEntityViewInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(entityViewDao)
        .findEntityViewInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerId_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult =
        entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(entityViewDao)
        .findEntityViewInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerId_thenCallsGetProperty() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult =
        entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(entityViewDao)
        .findEntityViewInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult =
        entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewDao)
        .findEntityViewInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, PageLink, String)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * PageLink, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  void testFindEntityViewsByTenantIdAndCustomerIdAndType() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                pageLink,
                "Type"));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, PageLink, String)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * PageLink, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  void testFindEntityViewsByTenantIdAndCustomerIdAndType2() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                pageLink,
                "Type"));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, PageLink, String)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * PageLink, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  void testFindEntityViewsByTenantIdAndCustomerIdAndType3() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                pageLink,
                "Type"));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, PageLink, String)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * PageLink, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  void testFindEntityViewsByTenantIdAndCustomerIdAndType4() {
    // Arrange
    when(entityViewDao.findEntityViewsByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE,
                "Type"));
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, PageLink, String)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * PageLink, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  void testFindEntityViewsByTenantIdAndCustomerIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink, "Type");

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, PageLink, String)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * PageLink, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  void testFindEntityViewsByTenantIdAndCustomerIdAndType_thenCallsGetId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, mock(PageLink.class), "Type"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, PageLink, String)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * PageLink, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  void testFindEntityViewsByTenantIdAndCustomerIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink, "Type");

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, PageLink, String)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * PageLink, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  void testFindEntityViewsByTenantIdAndCustomerIdAndType_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE,
            "Type");

    // Assert
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerIdAndType() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerIdAndType2() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerIdAndType3() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerIdAndType4() {
    // Arrange
    when(entityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(entityViewDao)
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult =
        entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(entityViewDao)
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerIdAndType_thenCallsGetId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult =
        entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(entityViewDao)
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEntityViewInfosByTenantIdAndCustomerIdAndType_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult =
        entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewDao)
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId, EntityViewSearchQuery)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId,
   * EntityViewSearchQuery)}
   */
  @Test
  @DisplayName("Test findEntityViewsByQuery(TenantId, EntityViewSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewsByQuery(TenantId, EntityViewSearchQuery)"
  })
  void testFindEntityViewsByQuery() {
    // Arrange
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByQuery(
                ModelConstants.SYSTEM_TENANT, new EntityViewSearchQuery()));
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId, EntityViewSearchQuery)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId,
   * EntityViewSearchQuery)}
   */
  @Test
  @DisplayName("Test findEntityViewsByQuery(TenantId, EntityViewSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewsByQuery(TenantId, EntityViewSearchQuery)"
  })
  void testFindEntityViewsByQuery2() {
    // Arrange
    ListenableFutureTask<List<EntityRelation>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doThrow(new DataValidationException("An error occurred"))
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenReturn(listenableFutureTask);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByQuery(
                ModelConstants.SYSTEM_TENANT, new EntityViewSearchQuery()));
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId, EntityViewSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId,
   * EntityViewSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByQuery(TenantId, EntityViewSearchQuery); given ListenableFutureTask addListener(Runnable, Executor) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewsByQuery(TenantId, EntityViewSearchQuery)"
  })
  void testFindEntityViewsByQuery_givenListenableFutureTaskAddListenerDoesNothing() {
    // Arrange
    ListenableFutureTask<List<EntityRelation>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenReturn(listenableFutureTask);

    // Act
    entityViewServiceImpl.findEntityViewsByQuery(
        ModelConstants.SYSTEM_TENANT, new EntityViewSearchQuery());

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId, EntityViewSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@code Query}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId,
   * EntityViewSearchQuery)}
   */
  @Test
  @DisplayName("Test findEntityViewsByQuery(TenantId, EntityViewSearchQuery); given 'Query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewsByQuery(TenantId, EntityViewSearchQuery)"
  })
  void testFindEntityViewsByQuery_givenQuery() {
    // Arrange
    SettableFuture<List<EntityRelation>> createResult = SettableFuture.create();
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenReturn(createResult);

    EntityViewSearchQuery query = new EntityViewSearchQuery();
    query.setRelationType("Query");

    // Act
    entityViewServiceImpl.findEntityViewsByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId, EntityViewSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link RelationService} {@link RelationService#findByQuery(TenantId,
   *       EntityRelationsQuery)} return create.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId,
   * EntityViewSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByQuery(TenantId, EntityViewSearchQuery); given RelationService findByQuery(TenantId, EntityRelationsQuery) return create")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewsByQuery(TenantId, EntityViewSearchQuery)"
  })
  void testFindEntityViewsByQuery_givenRelationServiceFindByQueryReturnCreate() {
    // Arrange
    SettableFuture<List<EntityRelation>> createResult = SettableFuture.create();
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenReturn(createResult);

    // Act
    entityViewServiceImpl.findEntityViewsByQuery(
        ModelConstants.SYSTEM_TENANT, new EntityViewSearchQuery());

    // Assert
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId, EntityViewSearchQuery)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityViewSearchQuery#toEntitySearchQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId,
   * EntityViewSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByQuery(TenantId, EntityViewSearchQuery); then calls toEntitySearchQuery()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewsByQuery(TenantId, EntityViewSearchQuery)"
  })
  void testFindEntityViewsByQuery_thenCallsToEntitySearchQuery() {
    // Arrange
    ListenableFutureTask<List<EntityRelation>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenReturn(listenableFutureTask);

    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery.setParameters(
        new RelationsSearchParameters(
            BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));

    EntityViewSearchQuery query = mock(EntityViewSearchQuery.class);
    when(query.toEntitySearchQuery()).thenReturn(entityRelationsQuery);

    // Act
    entityViewServiceImpl.findEntityViewsByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(query).toEntitySearchQuery();
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByIdAsync(TenantId, EntityViewId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByIdAsync(TenantId,
   * EntityViewId)}
   */
  @Test
  @DisplayName("Test findEntityViewByIdAsync(TenantId, EntityViewId); then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewByIdAsync(TenantId, EntityViewId)"
  })
  void testFindEntityViewByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<EntityView> createResult = SettableFuture.create();
    when(entityViewDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<EntityView> actualFindEntityViewByIdAsyncResult =
        entityViewServiceImpl.findEntityViewByIdAsync(
            ModelConstants.SYSTEM_TENANT,
            new EntityViewId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(entityViewDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityViewByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEntityViewByIdAsyncResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewByIdAsync(TenantId, EntityViewId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByIdAsync(TenantId,
   * EntityViewId)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewByIdAsync(TenantId, EntityViewId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewByIdAsync(TenantId, EntityViewId)"
  })
  void testFindEntityViewByIdAsync_thenThrowDataValidationException() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    EntityViewId entityViewId = mock(EntityViewId.class);
    when(entityViewId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewByIdAsync(
                ModelConstants.SYSTEM_TENANT, entityViewId));
    verify(entityViewId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEntityIdAsync(TenantId,
   * EntityId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndEntityIdAsync(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndEntityIdAsync(TenantId, EntityId); then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewsByTenantIdAndEntityIdAsync(TenantId, EntityId)"
  })
  void testFindEntityViewsByTenantIdAndEntityIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntityView>> actualFindEntityViewsByTenantIdAndEntityIdAsyncResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndEntityIdAsync(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEntityViewsByTenantIdAndEntityIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEntityViewsByTenantIdAndEntityIdAsyncResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEntityIdAsync(TenantId,
   * EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndEntityIdAsync(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndEntityIdAsync(TenantId, EntityId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewsByTenantIdAndEntityIdAsync(TenantId, EntityId)"
  })
  void testFindEntityViewsByTenantIdAndEntityIdAsync_thenThrowDataValidationException() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEntityIdAsync(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEntityId(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndEntityId(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndEntityId(TenantId, EntityId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityViewServiceImpl.findEntityViewsByTenantIdAndEntityId(TenantId, EntityId)"
  })
  void testFindEntityViewsByTenantIdAndEntityId_thenThrowDataValidationException() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEntityId(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#existsByTenantIdAndEntityId(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#existsByTenantIdAndEntityId(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName("Test existsByTenantIdAndEntityId(TenantId, EntityId); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewServiceImpl.existsByTenantIdAndEntityId(TenantId, EntityId)"
  })
  void testExistsByTenantIdAndEntityId_thenReturnFalse() {
    // Arrange
    when(entityViewDao.existsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(false);

    // Act
    boolean actualExistsByTenantIdAndEntityIdResult =
        entityViewServiceImpl.existsByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityViewDao).existsByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertFalse(actualExistsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#existsByTenantIdAndEntityId(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#existsByTenantIdAndEntityId(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName("Test existsByTenantIdAndEntityId(TenantId, EntityId); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewServiceImpl.existsByTenantIdAndEntityId(TenantId, EntityId)"
  })
  void testExistsByTenantIdAndEntityId_thenReturnTrue() {
    // Arrange
    when(entityViewDao.existsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndEntityIdResult =
        entityViewServiceImpl.existsByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityViewDao).existsByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#existsByTenantIdAndEntityId(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#existsByTenantIdAndEntityId(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test existsByTenantIdAndEntityId(TenantId, EntityId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewServiceImpl.existsByTenantIdAndEntityId(TenantId, EntityId)"
  })
  void testExistsByTenantIdAndEntityId_thenThrowDataValidationException() {
    // Arrange
    when(entityViewDao.existsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.existsByTenantIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(entityViewDao).existsByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteEntityView(TenantId, EntityViewId)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteEntityView(TenantId, EntityViewId)}
   */
  @Test
  @DisplayName("Test deleteEntityView(TenantId, EntityViewId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityView(TenantId, EntityViewId)"})
  void testDeleteEntityView() {
    // Arrange
    when(entityViewDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.deleteEntityView(
                ModelConstants.SYSTEM_TENANT,
                new EntityViewId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(entityViewDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteEntityView(TenantId, EntityViewId)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteEntityView(TenantId, EntityViewId)}
   */
  @Test
  @DisplayName("Test deleteEntityView(TenantId, EntityViewId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityView(TenantId, EntityViewId)"})
  void testDeleteEntityView2() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(entityViewDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(entityViewDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new EntityView());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.deleteEntityView(
                ModelConstants.SYSTEM_TENANT,
                new EntityViewId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(entityViewDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteEntityView(TenantId, EntityViewId)}.
   *
   * <ul>
   *   <li>Given {@link EntityViewDao} {@link EntityViewDao#findById(TenantId, UUID)} return {@code
   *       null}.
   *   <li>Then calls {@link EntityViewDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteEntityView(TenantId, EntityViewId)}
   */
  @Test
  @DisplayName(
      "Test deleteEntityView(TenantId, EntityViewId); given EntityViewDao findById(TenantId, UUID) return 'null'; then calls findById(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityView(TenantId, EntityViewId)"})
  void testDeleteEntityView_givenEntityViewDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    when(entityViewDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    entityViewServiceImpl.deleteEntityView(
        ModelConstants.SYSTEM_TENANT,
        new EntityViewId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(entityViewDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteEntityView(TenantId, EntityViewId)}.
   *
   * <ul>
   *   <li>Given {@link EntityViewServiceImpl} (default constructor).
   *   <li>Then calls {@link EntityViewId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteEntityView(TenantId, EntityViewId)}
   */
  @Test
  @DisplayName(
      "Test deleteEntityView(TenantId, EntityViewId); given EntityViewServiceImpl (default constructor); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityView(TenantId, EntityViewId)"})
  void testDeleteEntityView_givenEntityViewServiceImpl_thenCallsGetId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    EntityViewId entityViewId = mock(EntityViewId.class);
    when(entityViewId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.deleteEntityView(ModelConstants.SYSTEM_TENANT, entityViewId));
    verify(entityViewId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteEntityView(TenantId, EntityViewId)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityView#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteEntityView(TenantId, EntityViewId)}
   */
  @Test
  @DisplayName("Test deleteEntityView(TenantId, EntityViewId); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityView(TenantId, EntityViewId)"})
  void testDeleteEntityView_thenCallsGetTenantId() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    doNothing().when(entityViewDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(entityViewDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(entityView);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.deleteEntityView(
                ModelConstants.SYSTEM_TENANT,
                new EntityViewId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(entityView).getTenantId();
    verify(entityViewDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteEntityViewsByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteEntityViewsByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteEntityViewsByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityViewsByTenantId(TenantId)"})
  void testDeleteEntityViewsByTenantId() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    entityViewServiceImpl.deleteEntityViewsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(entityViewDao).findEntityViewsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteEntityViewsByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteEntityViewsByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteEntityViewsByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityViewsByTenantId(TenantId)"})
  void testDeleteEntityViewsByTenantId2() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<EntityView> entityViewList = new ArrayList<>();
    entityViewList.add(entityView);

    PageData<EntityView> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(entityViewList);
    when(entityViewDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.deleteEntityViewsByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(entityView).getUuidId();
    verify(pageData).getData();
    verify(entityViewDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewDao).findEntityViewsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteEntityViewsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link EntityViewServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteEntityViewsByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteEntityViewsByTenantId(TenantId); given EntityViewServiceImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityViewsByTenantId(TenantId)"})
  void testDeleteEntityViewsByTenantId_givenEntityViewServiceImpl() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.deleteEntityViewsByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteEntityViewsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link PageData#hasNext()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteEntityViewsByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteEntityViewsByTenantId(TenantId); given PageData hasNext() return 'false'; then calls hasNext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityViewsByTenantId(TenantId)"})
  void testDeleteEntityViewsByTenantId_givenPageDataHasNextReturnFalse_thenCallsHasNext() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<EntityView> entityViewList = new ArrayList<>();
    entityViewList.add(entityView);

    PageData<EntityView> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(entityViewList);
    when(entityViewDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityViewServiceImpl.deleteEntityViewsByTenantId(tenantId);

    // Assert
    verify(entityView).getUuidId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(entityViewDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewDao).findEntityViewsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteEntityViewsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityViewDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteEntityViewsByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteEntityViewsByTenantId(TenantId); then calls removeById(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityViewsByTenantId(TenantId)"})
  void testDeleteEntityViewsByTenantId_thenCallsRemoveById() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<EntityView> entityViewList = new ArrayList<>();
    entityViewList.add(entityView);

    PageData<EntityView> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(entityViewList);
    doThrow(new DataValidationException("An error occurred"))
        .when(entityViewDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(entityViewDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new EntityView());
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.deleteEntityViewsByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(entityView).getUuidId();
    verify(pageData).getData();
    verify(entityViewDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewDao).findEntityViewsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    entityViewServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(entityViewDao).findEntityViewsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId2() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<EntityView> entityViewList = new ArrayList<>();
    entityViewList.add(entityView);

    PageData<EntityView> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(entityViewList);
    when(entityViewDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(entityView).getUuidId();
    verify(pageData).getData();
    verify(entityViewDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewDao).findEntityViewsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link EntityViewServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId); given EntityViewServiceImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_givenEntityViewServiceImpl() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> entityViewServiceImpl.deleteByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link PageData#hasNext()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteByTenantId(TenantId); given PageData hasNext() return 'false'; then calls hasNext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_givenPageDataHasNextReturnFalse_thenCallsHasNext() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<EntityView> entityViewList = new ArrayList<>();
    entityViewList.add(entityView);

    PageData<EntityView> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(entityViewList);
    when(entityViewDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityViewServiceImpl.deleteByTenantId(tenantId);

    // Assert
    verify(entityView).getUuidId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(entityViewDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewDao).findEntityViewsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityViewDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId); then calls removeById(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_thenCallsRemoveById() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<EntityView> entityViewList = new ArrayList<>();
    entityViewList.add(entityView);

    PageData<EntityView> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(entityViewList);
    doThrow(new DataValidationException("An error occurred"))
        .when(entityViewDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(entityViewDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new EntityView());
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(entityView).getUuidId();
    verify(pageData).getData();
    verify(entityViewDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewDao).findEntityViewsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewTypesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test findEntityViewTypesByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewTypesByTenantId(TenantId)"
  })
  void testFindEntityViewTypesByTenantId() {
    // Arrange
    SettableFuture<List<EntitySubtype>> createResult = SettableFuture.create();
    when(entityViewDao.findTenantEntityViewTypesAsync(Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    entityViewServiceImpl.findEntityViewTypesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(entityViewDao).findTenantEntityViewTypesAsync(isA(UUID.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewTypesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test findEntityViewTypesByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewTypesByTenantId(TenantId)"
  })
  void testFindEntityViewTypesByTenantId2() {
    // Arrange
    when(entityViewDao.findTenantEntityViewTypesAsync(Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewTypesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(entityViewDao).findTenantEntityViewTypesAsync(isA(UUID.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewTypesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test findEntityViewTypesByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewTypesByTenantId(TenantId)"
  })
  void testFindEntityViewTypesByTenantId3() {
    // Arrange
    ListenableFutureTask<List<EntitySubtype>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doThrow(new DataValidationException("An error occurred"))
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(entityViewDao.findTenantEntityViewTypesAsync(Mockito.<UUID>any()))
        .thenReturn(listenableFutureTask);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewTypesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(entityViewDao).findTenantEntityViewTypesAsync(isA(UUID.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link EntityViewServiceImpl} (default constructor).
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewTypesByTenantId(TenantId); given EntityViewServiceImpl (default constructor); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewTypesByTenantId(TenantId)"
  })
  void testFindEntityViewTypesByTenantId_givenEntityViewServiceImpl_thenCallsGetId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewTypesByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewTypesByTenantId(TenantId); then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewTypesByTenantId(TenantId)"
  })
  void testFindEntityViewTypesByTenantId_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<List<EntitySubtype>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(entityViewDao.findTenantEntityViewTypesAsync(Mockito.<UUID>any()))
        .thenReturn(listenableFutureTask);

    // Act
    entityViewServiceImpl.findEntityViewTypesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(entityViewDao).findTenantEntityViewTypesAsync(isA(UUID.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#assignEntityViewToEdge(TenantId, EntityViewId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#assignEntityViewToEdge(TenantId,
   * EntityViewId, EdgeId)}
   */
  @Test
  @DisplayName(
      "Test assignEntityViewToEdge(TenantId, EntityViewId, EdgeId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityView EntityViewServiceImpl.assignEntityViewToEdge(TenantId, EntityViewId, EdgeId)"
  })
  void testAssignEntityViewToEdge_thenThrowDataValidationException() {
    // Arrange
    EntityViewId entityViewId = mock(EntityViewId.class);
    when(entityViewId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.assignEntityViewToEdge(
                ModelConstants.SYSTEM_TENANT, entityViewId, null));
    verify(entityViewId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#unassignEntityViewFromEdge(TenantId, EntityViewId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#unassignEntityViewFromEdge(TenantId,
   * EntityViewId, EdgeId)}
   */
  @Test
  @DisplayName(
      "Test unassignEntityViewFromEdge(TenantId, EntityViewId, EdgeId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityView EntityViewServiceImpl.unassignEntityViewFromEdge(TenantId, EntityViewId, EdgeId)"
  })
  void testUnassignEntityViewFromEdge_thenThrowDataValidationException() {
    // Arrange
    EntityViewId entityViewId = mock(EntityViewId.class);
    when(entityViewId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.unassignEntityViewFromEdge(
                ModelConstants.SYSTEM_TENANT, entityViewId, null));
    verify(entityViewId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndEdgeId() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndEdgeId2() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndEdgeId3() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndEdgeId4() {
    // Arrange
    when(entityViewDao.findEntityViewsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndEdgeId5() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndEdgeId_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndEdgeId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndEdgeIdAndType() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT, edgeId, "Type", BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeId).getId();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndEdgeIdAndType2() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndEdgeIdAndType3() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndEdgeIdAndType4() {
    // Arrange
    when(entityViewDao.findEntityViewsByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "Type",
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getSortOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink); then calls getSortOrder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndEdgeIdAndType_thenCallsGetSortOrder() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindEntityViewsByTenantIdAndEdgeIdAndType_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType EntityViewServiceImpl.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ENTITY_VIEW, new EntityViewServiceImpl().getEntityType());
  }
}
