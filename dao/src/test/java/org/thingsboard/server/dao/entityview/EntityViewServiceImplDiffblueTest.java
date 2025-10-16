/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.entityview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
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

@RunWith(MockitoJUnitRunner.class)
public class EntityViewServiceImplDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.handleEvictEvent(EntityViewEvictEvent)"})
  public void testHandleEvictEventWithEntityViewEvictEvent_thenThrowDataValidationException() {
    // Arrange
    EntityView savedEntityView = mock(EntityView.class);
    when(savedEntityView.getId()).thenThrow(new DataValidationException("An error occurred"));

    EntityViewEvictEvent event =
        new EntityViewEvictEvent(
            ModelConstants.SYSTEM_TENANT,
            null,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewServiceImpl.saveEntityView(EntityView)"})
  public void testSaveEntityViewWithEntityView() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewServiceImpl.saveEntityView(EntityView)"})
  public void testSaveEntityViewWithEntityView2() {
    // Arrange
    when(entityViewDao.save(Mockito.<TenantId>any(), Mockito.<EntityView>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(entityViewDataValidator.validate(
            Mockito.<EntityView>any(), Mockito.<Function<EntityView, TenantId>>any()))
        .thenReturn(new EntityView());

    EntityView entityView = new EntityView(new EntityView());
    entityView.setId(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> entityViewServiceImpl.saveEntityView(entityView));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewServiceImpl.saveEntityView(EntityView, boolean)"})
  public void testSaveEntityViewWithEntityViewDoValidate() {
    // Arrange
    when(entityViewDao.save(Mockito.<TenantId>any(), Mockito.<EntityView>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    EntityView entityView = new EntityView(new EntityView());
    entityView.setId(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewServiceImpl.saveEntityView(entityView, false));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewServiceImpl.saveEntityView(EntityView, boolean)"})
  public void testSaveEntityViewWithEntityViewDoValidate_thenCallsGetEntityId() {
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
   * Test {@link EntityViewServiceImpl#saveEntityView(EntityView)} with {@code entityView}.
   *
   * <ul>
   *   <li>Then calls {@link EntityView#getEntityId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#saveEntityView(EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewServiceImpl.saveEntityView(EntityView)"})
  public void testSaveEntityViewWithEntityView_thenCallsGetEntityId() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityViewServiceImpl.unassignCustomerEntityViews(TenantId, CustomerId)"
  })
  public void testUnassignCustomerEntityViews_thenCallsFindEntityViewsByTenantIdAndCustomerId() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityViewInfo EntityViewServiceImpl.findEntityViewInfoById(TenantId, EntityViewId)"
  })
  public void testFindEntityViewInfoById_thenReturnEntityViewInfo() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    when(entityViewDao.findEntityViewInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(entityViewInfo);

    // Act
    EntityViewInfo actualFindEntityViewInfoByIdResult =
        entityViewServiceImpl.findEntityViewInfoById(
            ModelConstants.SYSTEM_TENANT, new EntityViewId(ModelConstants.NULL_UUID));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityViewInfo EntityViewServiceImpl.findEntityViewInfoById(TenantId, EntityViewId)"
  })
  public void testFindEntityViewInfoById_thenThrowDataValidationException() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityView EntityViewServiceImpl.findEntityViewById(TenantId, EntityViewId, boolean)"
  })
  public void testFindEntityViewByIdWithTenantIdEntityViewIdPutInCache() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewServiceImpl.findEntityViewById(TenantId, EntityViewId)"})
  public void testFindEntityViewByIdWithTenantIdEntityViewId_thenThrowDataValidationException() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityView EntityViewServiceImpl.findEntityViewByTenantIdAndName(TenantId, String)"
  })
  public void testFindEntityViewByTenantIdAndName_thenThrowDataValidationException() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewByTenantIdAndNameAsync(TenantId, String)"
  })
  public void testFindEntityViewByTenantIdAndNameAsync_thenReturnSettableFuture() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewByTenantIdAndNameAsync(TenantId, String)"
  })
  public void testFindEntityViewByTenantIdAndNameAsync_thenThrowDataValidationException() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  public void testFindEntityViewByTenantId() {
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
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  public void testFindEntityViewByTenantId2() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  public void testFindEntityViewByTenantId3() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  public void testFindEntityViewByTenantId4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  public void testFindEntityViewByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  public void testFindEntityViewByTenantId_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  public void testFindEntityViewByTenantId_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  public void testFindEntityViewByTenantId_thenCallsGetId() {
    // Arrange
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
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EntityViewServiceImpl.findEntityViewByTenantId(TenantId, PageLink)"})
  public void testFindEntityViewByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantId() {
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
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantId2() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantId3() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantId4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantId_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantId_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantId_thenCallsGetId() {
    // Arrange
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
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  public void testFindEntityViewByTenantIdAndType() {
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
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  public void testFindEntityViewByTenantIdAndType2() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  public void testFindEntityViewByTenantIdAndType3() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  public void testFindEntityViewByTenantIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  public void testFindEntityViewByTenantIdAndType_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  public void testFindEntityViewByTenantIdAndType_thenCallsGetId() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  public void testFindEntityViewByTenantIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewByTenantIdAndType(TenantId, PageLink, String)"
  })
  public void testFindEntityViewByTenantIdAndType_whenFirst_page_thenReturnEmpty_page_data() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType() {
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
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType2() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType3() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType_thenCallsGetId() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType_whenFirst_page() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerId() {
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
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerId2() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerId3() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerId4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerId_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerId_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
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
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerId_whenFirst_page() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId() {
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
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId2() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId3() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId4() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId5() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
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
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId_whenFirst_page() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType() {
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
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * PageLink, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType2() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType3() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType4() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * PageLink, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType5() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * PageLink, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType_thenCallsGetId() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType_thenCallsGetProperty() {
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
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * PageLink, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType_whenFirst_page() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType() {
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
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType2() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType3() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType4() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType5() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityViewInfo> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType_thenCallsGetId() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType_thenCallsGetProperty() {
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
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType_whenFirst_page() {
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
   * <ul>
   *   <li>Given {@code Relation Type}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId,
   * EntityViewSearchQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewsByQuery(TenantId, EntityViewSearchQuery)"
  })
  public void testFindEntityViewsByQuery_givenRelationType() {
    // Arrange
    SettableFuture<List<EntityRelation>> createResult = SettableFuture.create();
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenReturn(createResult);

    EntityViewSearchQuery query = new EntityViewSearchQuery();
    query.setRelationType("Relation Type");

    // Act
    entityViewServiceImpl.findEntityViewsByQuery(ModelConstants.SYSTEM_TENANT, query);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewsByQuery(TenantId, EntityViewSearchQuery)"
  })
  public void testFindEntityViewsByQuery_thenCallsToEntitySearchQuery() {
    // Arrange
    SettableFuture<List<EntityRelation>> createResult = SettableFuture.create();
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenReturn(createResult);

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
    verify(query).toEntitySearchQuery();
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId, EntityViewSearchQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId,
   * EntityViewSearchQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewsByQuery(TenantId, EntityViewSearchQuery)"
  })
  public void testFindEntityViewsByQuery_thenThrowDataValidationException() {
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
   * <ul>
   *   <li>When {@link EntityViewSearchQuery} (default constructor).
   *   <li>Then calls {@link RelationService#findByQuery(TenantId, EntityRelationsQuery)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByQuery(TenantId,
   * EntityViewSearchQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewsByQuery(TenantId, EntityViewSearchQuery)"
  })
  public void testFindEntityViewsByQuery_whenEntityViewSearchQuery_thenCallsFindByQuery() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewByIdAsync(TenantId, EntityViewId)"
  })
  public void testFindEntityViewByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<EntityView> createResult = SettableFuture.create();
    when(entityViewDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<EntityView> actualFindEntityViewByIdAsyncResult =
        entityViewServiceImpl.findEntityViewByIdAsync(
            ModelConstants.SYSTEM_TENANT, new EntityViewId(ModelConstants.NULL_UUID));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewByIdAsync(TenantId, EntityViewId)"
  })
  public void testFindEntityViewByIdAsync_thenThrowDataValidationException() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewsByTenantIdAndEntityIdAsync(TenantId, EntityId)"
  })
  public void testFindEntityViewsByTenantIdAndEntityIdAsync_thenReturnSettableFuture() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewsByTenantIdAndEntityIdAsync(TenantId, EntityId)"
  })
  public void testFindEntityViewsByTenantIdAndEntityIdAsync_thenThrowDataValidationException() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityViewServiceImpl.findEntityViewsByTenantIdAndEntityId(TenantId, EntityId)"
  })
  public void testFindEntityViewsByTenantIdAndEntityId_thenThrowDataValidationException() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewServiceImpl.existsByTenantIdAndEntityId(TenantId, EntityId)"
  })
  public void testExistsByTenantIdAndEntityId_thenReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewServiceImpl.existsByTenantIdAndEntityId(TenantId, EntityId)"
  })
  public void testExistsByTenantIdAndEntityId_thenReturnTrue() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewServiceImpl.existsByTenantIdAndEntityId(TenantId, EntityId)"
  })
  public void testExistsByTenantIdAndEntityId_thenThrowDataValidationException() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityView(TenantId, EntityViewId)"})
  public void testDeleteEntityView() {
    // Arrange
    when(entityViewDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.deleteEntityView(
                ModelConstants.SYSTEM_TENANT, new EntityViewId(ModelConstants.NULL_UUID)));
    verify(entityViewDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteEntityView(TenantId, EntityViewId)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteEntityView(TenantId, EntityViewId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityView(TenantId, EntityViewId)"})
  public void testDeleteEntityView2() {
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
                ModelConstants.SYSTEM_TENANT, new EntityViewId(ModelConstants.NULL_UUID)));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityView(TenantId, EntityViewId)"})
  public void testDeleteEntityView_givenEntityViewDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    when(entityViewDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    entityViewServiceImpl.deleteEntityView(
        ModelConstants.SYSTEM_TENANT, new EntityViewId(ModelConstants.NULL_UUID));

    // Assert
    verify(entityViewDao).findById(isA(TenantId.class), isA(UUID.class));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityView(TenantId, EntityViewId)"})
  public void testDeleteEntityView_thenCallsGetTenantId() {
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
                ModelConstants.SYSTEM_TENANT, new EntityViewId(ModelConstants.NULL_UUID)));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityViewsByTenantId(TenantId)"})
  public void testDeleteEntityViewsByTenantId() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityViewsByTenantId(TenantId)"})
  public void testDeleteEntityViewsByTenantId2() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId()).thenReturn(ModelConstants.NULL_UUID);

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
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link PageData#hasNext()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteEntityViewsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityViewsByTenantId(TenantId)"})
  public void testDeleteEntityViewsByTenantId_givenPageDataHasNextReturnFalse_thenCallsHasNext() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<EntityView> entityViewList = new ArrayList<>();
    entityViewList.add(entityView);

    PageData<EntityView> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(entityViewList);
    when(entityViewDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    entityViewServiceImpl.deleteEntityViewsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(entityView).getUuidId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(entityViewDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewDao).findEntityViewsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteEntityViewsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteEntityViewsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityViewsByTenantId(TenantId)"})
  public void testDeleteEntityViewsByTenantId_thenCallsGetId() {
    // Arrange
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
   *   <li>Then calls {@link EntityViewDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteEntityViewsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteEntityViewsByTenantId(TenantId)"})
  public void testDeleteEntityViewsByTenantId_thenCallsRemoveById() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId2() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId()).thenReturn(ModelConstants.NULL_UUID);

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
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link PageData#hasNext()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenPageDataHasNextReturnFalse_thenCallsHasNext() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<EntityView> entityViewList = new ArrayList<>();
    entityViewList.add(entityView);

    PageData<EntityView> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(entityViewList);
    when(entityViewDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(entityViewDao.findEntityViewsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    entityViewServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(entityView).getUuidId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(entityViewDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewDao).findEntityViewsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EntityViewServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsGetId() {
    // Arrange
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
   *   <li>Then calls {@link EntityViewDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsRemoveById() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId()).thenReturn(ModelConstants.NULL_UUID);

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
   * <ul>
   *   <li>Then calls {@link EntityViewDao#findTenantEntityViewTypesAsync(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewTypesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewTypesByTenantId(TenantId)"
  })
  public void testFindEntityViewTypesByTenantId_thenCallsFindTenantEntityViewTypesAsync() {
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
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewTypesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EntityViewServiceImpl.findEntityViewTypesByTenantId(TenantId)"
  })
  public void testFindEntityViewTypesByTenantId_thenThrowDataValidationException() {
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
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeId() {
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
                new EdgeId(ModelConstants.NULL_UUID),
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeId2() {
    // Arrange
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeId3() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeId4() {
    // Arrange
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeId_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeId_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeId_thenCallsGetId() {
    // Arrange
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
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(ModelConstants.NULL_UUID),
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType() {
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
                new EdgeId(ModelConstants.NULL_UUID),
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
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType2() {
    // Arrange
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT,
                edgeId,
                "Executing findEntityViewsByTenantIdAndEdgeIdAndType, tenantId [{}], edgeId [{}], type [{}],"
                    + " pageLink [{}]",
                pageLink));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType3() {
    // Arrange
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT,
                edgeId,
                "Executing findEntityViewsByTenantIdAndEdgeIdAndType, tenantId [{}], edgeId [{}], type [{}],"
                    + " pageLink [{}]",
                pageLink));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType4() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(
            ModelConstants.SYSTEM_TENANT,
            edgeId,
            "Executing findEntityViewsByTenantIdAndEdgeIdAndType, tenantId [{}], edgeId [{}], type [{}],"
                + " pageLink [{}]",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndEdgeIdAndType(
            isA(UUID.class),
            isA(UUID.class),
            eq(
                "Executing findEntityViewsByTenantIdAndEdgeIdAndType, tenantId [{}], edgeId [{}], type [{}], pageLink [{}]"),
            isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType5() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(
            ModelConstants.SYSTEM_TENANT,
            edgeId,
            "Executing findEntityViewsByTenantIdAndEdgeIdAndType, tenantId [{}], edgeId [{}], type [{}],"
                + " pageLink [{}]",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndEdgeIdAndType(
            isA(UUID.class),
            isA(UUID.class),
            eq(
                "Executing findEntityViewsByTenantIdAndEdgeIdAndType, tenantId [{}], edgeId [{}], type [{}], pageLink [{}]"),
            isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType6() {
    // Arrange
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT,
                edgeId,
                "Executing findEntityViewsByTenantIdAndEdgeIdAndType, tenantId [{}], edgeId [{}], type [{}],"
                    + " pageLink [{}]",
                pageLink));
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
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityView> emptyPageDataResult = PageData.emptyPageData();
    when(entityViewDao.findEntityViewsByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult =
        entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(
            ModelConstants.SYSTEM_TENANT,
            edgeId,
            "Executing findEntityViewsByTenantIdAndEdgeIdAndType, tenantId [{}], edgeId [{}], type [{}],"
                + " pageLink [{}]",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(entityViewDao)
        .findEntityViewsByTenantIdAndEdgeIdAndType(
            isA(UUID.class),
            isA(UUID.class),
            eq(
                "Executing findEntityViewsByTenantIdAndEdgeIdAndType, tenantId [{}], edgeId [{}], type [{}], pageLink [{}]"),
            isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType_thenCallsGetId() {
    // Arrange
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
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityViewServiceImpl.findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType_thenReturnEmpty_page_data() {
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
            new EdgeId(ModelConstants.NULL_UUID),
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType EntityViewServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ENTITY_VIEW, new EntityViewServiceImpl().getEntityType());
  }
}
