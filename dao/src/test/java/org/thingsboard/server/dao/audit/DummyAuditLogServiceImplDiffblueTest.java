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
package org.thingsboard.server.dao.audit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class DummyAuditLogServiceImplDiffblueTest {
  /**
   * Test {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId,
   * List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ADDED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndCustomerId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act and Assert
    assertEquals(
        PageData.EMPTY_PAGE_DATA,
        dummyAuditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes,
            new TimePageLink(3)));
  }

  /**
   * Test {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId,
   * List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DELETED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndCustomerId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act and Assert
    assertEquals(
        PageData.EMPTY_PAGE_DATA,
        dummyAuditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes,
            new TimePageLink(3)));
  }

  /**
   * Test {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId,
   * List, TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndCustomerId_whenArrayList() {
    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act and Assert
    assertEquals(
        PageData.EMPTY_PAGE_DATA,
        dummyAuditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes,
            new TimePageLink(3)));
  }

  /**
   * Test {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ADDED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndUserId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act and Assert
    assertEquals(
        PageData.EMPTY_PAGE_DATA,
        dummyAuditLogServiceImpl.findAuditLogsByTenantIdAndUserId(
            ModelConstants.SYSTEM_TENANT, null, actionTypes, new TimePageLink(3)));
  }

  /**
   * Test {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DELETED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndUserId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act and Assert
    assertEquals(
        PageData.EMPTY_PAGE_DATA,
        dummyAuditLogServiceImpl.findAuditLogsByTenantIdAndUserId(
            ModelConstants.SYSTEM_TENANT, null, actionTypes, new TimePageLink(3)));
  }

  /**
   * Test {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndUserId_whenArrayList() {
    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act and Assert
    assertEquals(
        PageData.EMPTY_PAGE_DATA,
        dummyAuditLogServiceImpl.findAuditLogsByTenantIdAndUserId(
            ModelConstants.SYSTEM_TENANT, null, actionTypes, new TimePageLink(3)));
  }

  /**
   * Test {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId,
   * List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ADDED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act and Assert
    assertEquals(
        PageData.EMPTY_PAGE_DATA,
        dummyAuditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes,
            new TimePageLink(3)));
  }

  /**
   * Test {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId,
   * List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DELETED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act and Assert
    assertEquals(
        PageData.EMPTY_PAGE_DATA,
        dummyAuditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes,
            new TimePageLink(3)));
  }

  /**
   * Test {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId,
   * List, TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId_whenArrayList() {
    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act and Assert
    assertEquals(
        PageData.EMPTY_PAGE_DATA,
        dummyAuditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes,
            new TimePageLink(3)));
  }

  /**
   * Test {@link DummyAuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ADDED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.
   * </ul>
   *
   * <p>Method under test: {@link DummyAuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantId(TenantId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act and Assert
    assertEquals(
        PageData.EMPTY_PAGE_DATA,
        dummyAuditLogServiceImpl.findAuditLogsByTenantId(
            ModelConstants.SYSTEM_TENANT, actionTypes, new TimePageLink(3)));
  }

  /**
   * Test {@link DummyAuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DELETED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.
   * </ul>
   *
   * <p>Method under test: {@link DummyAuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantId(TenantId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act and Assert
    assertEquals(
        PageData.EMPTY_PAGE_DATA,
        dummyAuditLogServiceImpl.findAuditLogsByTenantId(
            ModelConstants.SYSTEM_TENANT, actionTypes, new TimePageLink(3)));
  }

  /**
   * Test {@link DummyAuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DummyAuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantId(TenantId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantId_whenArrayList() {
    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act and Assert
    assertEquals(
        PageData.EMPTY_PAGE_DATA,
        dummyAuditLogServiceImpl.findAuditLogsByTenantId(
            ModelConstants.SYSTEM_TENANT, actionTypes, new TimePageLink(3)));
  }

  /**
   * Test {@link DummyAuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String,
   * EntityId, HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DummyAuditLogServiceImpl#logEntityAction(TenantId, CustomerId,
   * UserId, String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture DummyAuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_whenNull_thenReturnNull() {
    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();
    HasName hasName = mock(HasName.class);

    // Act and Assert
    assertNull(
        dummyAuditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            BaseEntityService.NULL_CUSTOMER_ID,
            hasName,
            ActionType.ADDED,
            new Exception(),
            "Additional Info"));
  }
}
