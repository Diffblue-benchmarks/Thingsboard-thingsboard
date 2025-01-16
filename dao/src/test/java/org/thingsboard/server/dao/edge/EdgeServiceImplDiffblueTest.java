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
import java.sql.SQLException;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
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
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

public class EdgeServiceImplDiffblueTest {
  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantId_thenThrowConstraintViolationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findEdgesByTenantId, tenantId [{}], pageLink [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantId_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeServiceImpl.findEdgesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndType_thenThrowConstraintViolationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findEdgesByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndType_thenThrowConstraintViolationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findEdgeInfosByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeInfosByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantId_thenThrowConstraintViolationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findEdgeInfosByTenantId, tenantId [{}], pageLink [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantId_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeServiceImpl.findEdgeInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndCustomerId_thenThrowConstraintViolationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findEdgesByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> edgeServiceImpl
        .findEdgesByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndCustomerIdAndType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findEdgesByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
            + " pageLink [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndCustomerIdAndType_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndCustomerId_thenThrowConstraintViolationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findEdgeInfosByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findEdgeInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
            + " pageLink [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndEntityId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findEdgesByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> edgeServiceImpl
        .findEdgesByTenantIdAndEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   * <ul>
   *   <li>When {@link AlarmId}.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndEntityId_whenAlarmId_thenCallsGetPage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    AlarmId entityId = mock(AlarmId.class);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findEdgesByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantIdAndEntityId(ModelConstants.SYSTEM_TENANT, entityId, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}
   */
  @Test
  public void testFindEdgeIdsByTenantIdAndEntityId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findEdgeIdsByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> edgeServiceImpl
        .findEdgeIdsByTenantIdAndEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   * <ul>
   *   <li>When {@link AlarmId}.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}
   */
  @Test
  public void testFindEdgeIdsByTenantIdAndEntityId_whenAlarmId_thenCallsGetPage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    AlarmId entityId = mock(AlarmId.class);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findEdgeIdsByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(ModelConstants.SYSTEM_TENANT, entityId, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantProfileId_thenThrowConstraintViolationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findEdgesByTenantProfileId, tenantProfileId [{}], pageLink [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantProfileId(tenantProfileId, pageLink));
    verify(tenantProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantProfileId_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeServiceImpl.findEdgesByTenantProfileId(tenantProfileId, pageLink));
    verify(tenantProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findAllRelatedEdgeIds(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findAllRelatedEdgeIds(TenantId, EntityId)}
   */
  @Test
  public void testFindAllRelatedEdgeIds_whenAlarmId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EdgeServiceImpl()).findAllRelatedEdgeIds(ModelConstants.SYSTEM_TENANT, mock(AlarmId.class)));
  }

  /**
   * Test {@link EdgeServiceImpl#findAllRelatedEdgeIds(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findAllRelatedEdgeIds(TenantId, EntityId)}
   */
  @Test
  public void testFindAllRelatedEdgeIds_whenNull_customer_id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EdgeServiceImpl()).findAllRelatedEdgeIds(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID));
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}
   */
  @Test
  public void testFindRelatedEdgeIdsByEntityId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]"));
    when(entityId.getEntityType()).thenReturn(EntityType.CUSTOMER);

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> edgeServiceImpl
        .findRelatedEdgeIdsByEntityId(ModelConstants.SYSTEM_TENANT, entityId, mock(PageLink.class)));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}
   */
  @Test
  public void testFindRelatedEdgeIdsByEntityId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]"));
    when(entityId.getEntityType()).thenReturn(EntityType.USER);

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> edgeServiceImpl
        .findRelatedEdgeIdsByEntityId(ModelConstants.SYSTEM_TENANT, entityId, mock(PageLink.class)));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}
   */
  @Test
  public void testFindRelatedEdgeIdsByEntityId_givenNull_uuid_thenCallsGetPage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.CUSTOMER);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> edgeServiceImpl.findRelatedEdgeIdsByEntityId(ModelConstants.SYSTEM_TENANT, entityId, pageLink));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   * <ul>
   *   <li>Given {@code TENANT}.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}
   */
  @Test
  public void testFindRelatedEdgeIdsByEntityId_givenTenant_thenCallsGetPage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> edgeServiceImpl.findRelatedEdgeIdsByEntityId(ModelConstants.SYSTEM_TENANT, entityId, pageLink));
    verify(entityId).getEntityType();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}
   */
  @Test
  public void testFindRelatedEdgeIdsByEntityId_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    // Act
    PageData<EdgeId> actualFindRelatedEdgeIdsByEntityIdResult = edgeServiceImpl.findRelatedEdgeIdsByEntityId(
        ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    assertSame(actualFindRelatedEdgeIdsByEntityIdResult.EMPTY_PAGE_DATA, actualFindRelatedEdgeIdsByEntityIdResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeServiceImpl#getEntityType()}
   *   <li>{@link EdgeServiceImpl#isEdgesEnabled()}
   * </ul>
   */
  @Test
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
