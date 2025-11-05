package org.thingsboard.server.dao.audit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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

class DummyAuditLogServiceImplDiffblueTest {
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
  @DisplayName(
      "Test findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink); given 'ADDED'; when ArrayList() add 'ADDED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)"
  })
  void testFindAuditLogsByTenantIdAndCustomerId_givenAdded_whenArrayListAddAdded() {
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
  @DisplayName(
      "Test findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink); given 'DELETED'; when ArrayList() add 'DELETED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)"
  })
  void testFindAuditLogsByTenantIdAndCustomerId_givenDeleted_whenArrayListAddDeleted() {
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
  @DisplayName(
      "Test findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)"
  })
  void testFindAuditLogsByTenantIdAndCustomerId_whenArrayList() {
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
  @DisplayName(
      "Test findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink); given 'ADDED'; when ArrayList() add 'ADDED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)"
  })
  void testFindAuditLogsByTenantIdAndUserId_givenAdded_whenArrayListAddAdded() {
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
  @DisplayName(
      "Test findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink); given 'DELETED'; when ArrayList() add 'DELETED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)"
  })
  void testFindAuditLogsByTenantIdAndUserId_givenDeleted_whenArrayListAddDeleted() {
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
  @DisplayName(
      "Test findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)"
  })
  void testFindAuditLogsByTenantIdAndUserId_whenArrayList() {
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
  @DisplayName(
      "Test findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink); given 'ADDED'; when ArrayList() add 'ADDED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)"
  })
  void testFindAuditLogsByTenantIdAndEntityId_givenAdded_whenArrayListAddAdded() {
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
  @DisplayName(
      "Test findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink); given 'DELETED'; when ArrayList() add 'DELETED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)"
  })
  void testFindAuditLogsByTenantIdAndEntityId_givenDeleted_whenArrayListAddDeleted() {
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
  @DisplayName(
      "Test findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)"
  })
  void testFindAuditLogsByTenantIdAndEntityId_whenArrayList() {
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
  @DisplayName(
      "Test findAuditLogsByTenantId(TenantId, List, TimePageLink); given 'ADDED'; when ArrayList() add 'ADDED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantId(TenantId, List, TimePageLink)"
  })
  void testFindAuditLogsByTenantId_givenAdded_whenArrayListAddAdded() {
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
  @DisplayName(
      "Test findAuditLogsByTenantId(TenantId, List, TimePageLink); given 'DELETED'; when ArrayList() add 'DELETED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantId(TenantId, List, TimePageLink)"
  })
  void testFindAuditLogsByTenantId_givenDeleted_whenArrayListAddDeleted() {
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
  @DisplayName("Test findAuditLogsByTenantId(TenantId, List, TimePageLink); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DummyAuditLogServiceImpl.findAuditLogsByTenantId(TenantId, List, TimePageLink)"
  })
  void testFindAuditLogsByTenantId_whenArrayList() {
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
  @DisplayName(
      "Test logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[]); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture DummyAuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  void testLogEntityAction_whenNull_thenReturnNull() {
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
