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
package org.thingsboard.server.dao.edge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class EdgeServiceImplDiffblueTest {
  /**
   * Test {@link EdgeServiceImpl#findEdgeById(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeById(TenantId, EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.edge.Edge EdgeServiceImpl.findEdgeById(TenantId, EdgeId)"
  })
  public void testFindEdgeById_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findEdgeById [{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeById(ModelConstants.SYSTEM_TENANT, edgeId));
    verify(edgeId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfoById(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfoById(TenantId, EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.edge.EdgeInfo EdgeServiceImpl.findEdgeInfoById(TenantId, EdgeId)"
  })
  public void testFindEdgeInfoById_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findEdgeInfoById [{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeInfoById(ModelConstants.SYSTEM_TENANT, edgeId));
    verify(edgeId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeByIdAsync(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByIdAsync(TenantId, EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EdgeServiceImpl.findEdgeByIdAsync(TenantId, EdgeId)"
  })
  public void testFindEdgeByIdAsync_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findEdgeByIdAsync [{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeByIdAsync(ModelConstants.SYSTEM_TENANT, edgeId));
    verify(edgeId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeByTenantIdAndName(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByTenantIdAndName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.edge.Edge EdgeServiceImpl.findEdgeByTenantIdAndName(TenantId, String)"
  })
  public void testFindEdgeByTenantIdAndName_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeByTenantIdAndName [{}][{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeByTenantIdAndName(tenantId, "Name"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeByTenantIdAndNameAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EdgeServiceImpl.findEdgeByTenantIdAndNameAsync(TenantId, String)"
  })
  public void testFindEdgeByTenantIdAndNameAsync_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeByTenantIdAndNameAsync [{}][{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeByTenantIdAndNameAsync(tenantId, "Name"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId, CustomerId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId,
   * CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.edge.Edge EdgeServiceImpl.assignEdgeToCustomer(TenantId, EdgeId, CustomerId)"
  })
  public void testAssignEdgeToCustomer_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "[{}] Executing assignEdgeToCustomer [{}][{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.assignEdgeToCustomer(
                ModelConstants.SYSTEM_TENANT, edgeId, BaseEntityService.NULL_CUSTOMER_ID));
    verify(edgeId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#unassignEdgeFromCustomer(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#unassignEdgeFromCustomer(TenantId, EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.edge.Edge EdgeServiceImpl.unassignEdgeFromCustomer(TenantId, EdgeId)"
  })
  public void testUnassignEdgeFromCustomer_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "[{}] Executing unassignEdgeFromCustomer [{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.unassignEdgeFromCustomer(ModelConstants.SYSTEM_TENANT, edgeId));
    verify(edgeId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdge(TenantId, EdgeId)"})
  public void testDeleteEdge_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteEdge [{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.deleteEdge(ModelConstants.SYSTEM_TENANT, edgeId));
    verify(edgeId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    EdgeId id = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteEdge [{}]");
    when(id.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true));
    verify(id).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  public void testFindEdgesByTenantId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantId, tenantId [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  public void testFindEdgesByTenantId2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantId, tenantId [{}], pageLink [{}]");
    when(pageLink.getPage()).thenThrow(constraintViolationException);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  public void testFindEdgesByTenantId_thenCallsGetId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantId, tenantId [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantId(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getSortOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  public void testFindEdgesByTenantId_thenCallsGetSortOrder() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantId, tenantId [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndType() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndType_thenCallsGetId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantIdAndType(tenantId, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndType_thenCallsGetPage() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndType() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndType_thenCallsGetId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndType(tenantId, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndType_thenCallsGetPage() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  public void testFindEdgeInfosByTenantId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantId, tenantId [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  public void testFindEdgeInfosByTenantId2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantId, tenantId [{}], pageLink [{}]");
    when(pageLink.getPage()).thenThrow(constraintViolationException);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  public void testFindEdgeInfosByTenantId_thenCallsGetId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantId, tenantId [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeInfosByTenantId(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getSortOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  public void testFindEdgeInfosByTenantId_thenCallsGetSortOrder() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantId, tenantId [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EdgeServiceImpl.findEdgesByTenantIdAndIdsAsync(TenantId, List)"
  })
  public void testFindEdgesByTenantIdAndIdsAsync() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndIdsAsync, tenantId [{}], edgeIds [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantIdAndIdsAsync(tenantId, new ArrayList<>()));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EdgeServiceImpl.findEdgesByTenantIdAndIdsAsync(TenantId, List)"
  })
  public void testFindEdgesByTenantIdAndIdsAsync_thenCallsGetId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndIdsAsync, tenantId [{}], edgeIds [{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(edgeId);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantIdAndIdsAsync(tenantId, edgeIds));
    verify(edgeId).getId();
    verify(tenantId, atLeast(1)).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEdgesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEdgesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdgesByTenantId(TenantId)"})
  public void testDeleteEdgesByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing deleteEdgesByTenantId, tenantId [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> edgeServiceImpl.deleteEdgesByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing deleteEdgesByTenantId, tenantId [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> edgeServiceImpl.deleteByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerId(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerId_thenCallsGetPage() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(pageLink.getPage()).thenThrow(constraintViolationException);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType_thenCallsGetId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getSortOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType_thenCallsGetSortOrder() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
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
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId_thenCallsGetPage() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(pageLink.getPage()).thenThrow(constraintViolationException);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenCallsGetId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getSortOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenCallsGetSortOrder() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(
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
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId,
   * CustomerId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EdgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  public void testFindEdgesByTenantIdCustomerIdAndIdsAsync() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdCustomerIdAndIdsAsync, tenantId [{}], customerId [{}], edgeIds [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>()));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId,
   * CustomerId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EdgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  public void testFindEdgesByTenantIdCustomerIdAndIdsAsync_thenCallsGetId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdCustomerIdAndIdsAsync, tenantId [{}], customerId [{}], edgeIds [{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(edgeId);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(
                tenantId, customerId, edgeIds));
    verify(edgeId).getId();
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#unassignCustomerEdges(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#unassignCustomerEdges(TenantId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.unassignCustomerEdges(TenantId, CustomerId)"})
  public void testUnassignCustomerEdges_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing unassignCustomerEdges, tenantId [{}], customerId [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.unassignCustomerEdges(tenantId, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EdgeServiceImpl.findEdgeTypesByTenantId(TenantId)"
  })
  public void testFindEdgeTypesByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeTypesByTenantId, tenantId [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeTypesByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndEntityId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    AlarmId entityId = mock(AlarmId.class);

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, entityId, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndEntityId_thenCallsGetId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndEntityId(
                tenantId, mock(AlarmId.class), mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndEntityId_thenCallsGetPage() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    AlarmId entityId = mock(AlarmId.class);

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, entityId, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgeIdsByTenantIdAndEntityId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    AlarmId entityId = mock(AlarmId.class);

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeIdsByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, entityId, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgeIdsByTenantIdAndEntityId_thenCallsGetId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeIdsByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(
                tenantId, mock(AlarmId.class), mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgeIdsByTenantIdAndEntityId_thenCallsGetPage() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    AlarmId entityId = mock(AlarmId.class);

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeIdsByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, entityId, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  public void testFindEdgesByTenantProfileId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantProfileId, tenantProfileId [{}], pageLink [{}]");
    when(tenantProfileId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantProfileId(
                tenantProfileId, BaseRelatedEdgesService.FIRST_PAGE));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  public void testFindEdgesByTenantProfileId2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantProfileId, tenantProfileId [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantProfileId(tenantProfileId, pageLink));
    verify(tenantProfileId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  public void testFindEdgesByTenantProfileId3() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantProfileId, tenantProfileId [{}], pageLink [{}]");
    when(pageLink.getPage()).thenThrow(constraintViolationException);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantProfileId(tenantProfileId, pageLink));
    verify(tenantProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getSortOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  public void testFindEdgesByTenantProfileId_thenCallsGetSortOrder() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantProfileId, tenantProfileId [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantProfileId(tenantProfileId, pageLink));
    verify(tenantProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findAllRelatedEdgeIds(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findAllRelatedEdgeIds(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EdgeServiceImpl.findAllRelatedEdgeIds(TenantId, EntityId)"})
  public void testFindAllRelatedEdgeIds() {
    // Arrange, Act and Assert
    assertNull(
        new EdgeServiceImpl()
            .findAllRelatedEdgeIds(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findRelatedEdgeIdsByEntityId(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, BaseRelatedEdgesService.FIRST_PAGE));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findRelatedEdgeIdsByEntityId(tenantId, entityId, pageLink));
    verify(entityId).getEntityType();
    verify(tenantId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId3() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    TenantId tenantId = mock(TenantId.class);

    AlarmId entityId = mock(AlarmId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]");
    when(entityId.getId()).thenThrow(constraintViolationException);
    when(entityId.getEntityType()).thenReturn(EntityType.CUSTOMER);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findRelatedEdgeIdsByEntityId(tenantId, entityId, mock(PageLink.class)));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code CUSTOMER}.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId_givenCustomer_thenCallsGetPage() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.CUSTOMER);

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findRelatedEdgeIdsByEntityId(tenantId, entityId, pageLink));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code TENANT_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId_givenTenantProfile() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    TenantId tenantId = mock(TenantId.class);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT_PROFILE);

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findRelatedEdgeIdsByEntityId(tenantId, entityId, pageLink));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code USER}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId_givenUser() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    TenantId tenantId = mock(TenantId.class);

    AlarmId entityId = mock(AlarmId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]");
    when(entityId.getId()).thenThrow(constraintViolationException);
    when(entityId.getEntityType()).thenReturn(EntityType.USER);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findRelatedEdgeIdsByEntityId(tenantId, entityId, mock(PageLink.class)));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId_thenCallsGetPage() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findRelatedEdgeIdsByEntityId(tenantId, entityId, pageLink));
    verify(entityId).getEntityType();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId_thenReturnEmpty_page_data() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    // Act and Assert
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        edgeServiceImpl.findRelatedEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT,
            new AlarmId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeServiceImpl#getEntityType()}
   *   <li>{@link EdgeServiceImpl#isEdgesEnabled()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityType EdgeServiceImpl.getEntityType()",
    "boolean EdgeServiceImpl.isEdgesEnabled()"
  })
  public void testGettersAndSetters() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    // Act
    EntityType actualEntityType = edgeServiceImpl.getEntityType();

    // Assert
    assertEquals(EntityType.EDGE, actualEntityType);
    assertFalse(edgeServiceImpl.isEdgesEnabled());
  }
}
