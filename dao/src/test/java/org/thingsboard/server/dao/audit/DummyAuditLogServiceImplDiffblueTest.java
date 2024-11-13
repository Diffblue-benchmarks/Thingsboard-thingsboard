package org.thingsboard.server.dao.audit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.audit.AuditLog;
import org.thingsboard.server.common.data.id.AlarmId;
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
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndCustomerId_givenAdded_whenArrayListAddAdded() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes, new TimePageLink(3));

    // Assert
    PageData pageData = actualFindAuditLogsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA;
    assertEquals(pageData, dummyAuditLogServiceImpl.findAuditLogsByTenantId(null, null, null));
    assertEquals(pageData, actualFindAuditLogsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code DELETED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndCustomerId_givenDeleted_whenArrayListAddDeleted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes, new TimePageLink(3));

    // Assert
    PageData pageData = actualFindAuditLogsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA;
    assertEquals(pageData, dummyAuditLogServiceImpl.findAuditLogsByTenantId(null, null, null));
    assertEquals(pageData, actualFindAuditLogsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndCustomerId_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes, new TimePageLink(3));

    // Assert
    PageData pageData = actualFindAuditLogsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA;
    assertEquals(pageData, dummyAuditLogServiceImpl.findAuditLogsByTenantId(null, null, null));
    assertEquals(pageData, actualFindAuditLogsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)}.
   * <ul>
   *   <li>When {@link TimePageLink}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndCustomerId_whenTimePageLink() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            new ArrayList<>(), mock(TimePageLink.class));

    // Assert
    PageData pageData = actualFindAuditLogsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA;
    assertEquals(pageData, dummyAuditLogServiceImpl.findAuditLogsByTenantId(null, null, null));
    assertEquals(pageData, actualFindAuditLogsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndUserId_givenAdded_whenArrayListAddAdded() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantIdAndUserId(ModelConstants.SYSTEM_TENANT, null, actionTypes, new TimePageLink(3));

    // Assert
    PageData pageData = actualFindAuditLogsByTenantIdAndUserIdResult.EMPTY_PAGE_DATA;
    assertEquals(pageData, dummyAuditLogServiceImpl.findAuditLogsByTenantId(null, null, null));
    assertEquals(pageData, actualFindAuditLogsByTenantIdAndUserIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code DELETED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndUserId_givenDeleted_whenArrayListAddDeleted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantIdAndUserId(ModelConstants.SYSTEM_TENANT, null, actionTypes, new TimePageLink(3));

    // Assert
    PageData pageData = actualFindAuditLogsByTenantIdAndUserIdResult.EMPTY_PAGE_DATA;
    assertEquals(pageData, dummyAuditLogServiceImpl.findAuditLogsByTenantId(null, null, null));
    assertEquals(pageData, actualFindAuditLogsByTenantIdAndUserIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndUserId_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantIdAndUserId(ModelConstants.SYSTEM_TENANT, null, actionTypes, new TimePageLink(3));

    // Assert
    PageData pageData = actualFindAuditLogsByTenantIdAndUserIdResult.EMPTY_PAGE_DATA;
    assertEquals(pageData, dummyAuditLogServiceImpl.findAuditLogsByTenantId(null, null, null));
    assertEquals(pageData, actualFindAuditLogsByTenantIdAndUserIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)}.
   * <ul>
   *   <li>When {@link TimePageLink}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndUserId_whenTimePageLink() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantIdAndUserId(ModelConstants.SYSTEM_TENANT, null, new ArrayList<>(),
            mock(TimePageLink.class));

    // Assert
    PageData pageData = actualFindAuditLogsByTenantIdAndUserIdResult.EMPTY_PAGE_DATA;
    assertEquals(pageData, dummyAuditLogServiceImpl.findAuditLogsByTenantId(null, null, null));
    assertEquals(pageData, actualFindAuditLogsByTenantIdAndUserIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndEntityId_givenAdded_whenArrayListAddAdded() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantIdAndEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes, new TimePageLink(3));

    // Assert
    PageData pageData = actualFindAuditLogsByTenantIdAndEntityIdResult.EMPTY_PAGE_DATA;
    assertEquals(pageData, dummyAuditLogServiceImpl.findAuditLogsByTenantId(null, null, null));
    assertEquals(pageData, actualFindAuditLogsByTenantIdAndEntityIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code DELETED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndEntityId_givenDeleted_whenArrayListAddDeleted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantIdAndEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes, new TimePageLink(3));

    // Assert
    PageData pageData = actualFindAuditLogsByTenantIdAndEntityIdResult.EMPTY_PAGE_DATA;
    assertEquals(pageData, dummyAuditLogServiceImpl.findAuditLogsByTenantId(null, null, null));
    assertEquals(pageData, actualFindAuditLogsByTenantIdAndEntityIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)}.
   * <ul>
   *   <li>When {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndEntityId_whenAlarmId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();
    AlarmId entityId = mock(AlarmId.class);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantIdAndEntityId(ModelConstants.SYSTEM_TENANT, entityId, actionTypes, new TimePageLink(3));

    // Assert
    PageData pageData = actualFindAuditLogsByTenantIdAndEntityIdResult.EMPTY_PAGE_DATA;
    assertEquals(pageData, dummyAuditLogServiceImpl.findAuditLogsByTenantId(null, null, null));
    assertEquals(pageData, actualFindAuditLogsByTenantIdAndEntityIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndEntityId_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantIdAndEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes, new TimePageLink(3));

    // Assert
    PageData pageData = actualFindAuditLogsByTenantIdAndEntityIdResult.EMPTY_PAGE_DATA;
    assertEquals(pageData, dummyAuditLogServiceImpl.findAuditLogsByTenantId(null, null, null));
    assertEquals(pageData, actualFindAuditLogsByTenantIdAndEntityIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantId_givenAdded_whenArrayListAddAdded() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantId(ModelConstants.SYSTEM_TENANT, actionTypes, new TimePageLink(3));

    // Assert
    assertEquals(actualFindAuditLogsByTenantIdResult.EMPTY_PAGE_DATA, actualFindAuditLogsByTenantIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code DELETED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantId_givenDeleted_whenArrayListAddDeleted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantId(ModelConstants.SYSTEM_TENANT, actionTypes, new TimePageLink(3));

    // Assert
    assertEquals(actualFindAuditLogsByTenantIdResult.EMPTY_PAGE_DATA, actualFindAuditLogsByTenantIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantId_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantId(ModelConstants.SYSTEM_TENANT, actionTypes, new TimePageLink(3));

    // Assert
    assertEquals(actualFindAuditLogsByTenantIdResult.EMPTY_PAGE_DATA, actualFindAuditLogsByTenantIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}.
   * <ul>
   *   <li>When {@link TimePageLink}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantId_whenTimePageLink() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult = dummyAuditLogServiceImpl
        .findAuditLogsByTenantId(ModelConstants.SYSTEM_TENANT, new ArrayList<>(), mock(TimePageLink.class));

    // Assert
    assertEquals(actualFindAuditLogsByTenantIdResult.EMPTY_PAGE_DATA, actualFindAuditLogsByTenantIdResult);
  }

  /**
   * Test
   * {@link DummyAuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyAuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  public void testLogEntityAction_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DummyAuditLogServiceImpl dummyAuditLogServiceImpl = new DummyAuditLogServiceImpl();
    HasName hasName = mock(HasName.class);

    // Act and Assert
    assertNull(dummyAuditLogServiceImpl.logEntityAction(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, null, "janedoe", BaseEntityService.NULL_CUSTOMER_ID, hasName,
        ActionType.ADDED, new Exception("foo"), "Additional Info"));
  }
}
