package org.thingsboard.server.dao.entityview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityViewServiceImplDiffblueTest {
  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindEntityViewByTenantId_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindEntityViewByTenantId_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new RuntimeException("Executing findEntityViewsByTenantId, tenantId [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> entityViewServiceImpl.findEntityViewByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantId_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantId_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new RuntimeException("Executing findEntityViewInfosByTenantId, tenantId [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> entityViewServiceImpl.findEntityViewInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId, PageLink, String)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewByTenantIdAndType(TenantId, PageLink, String)}
   */
  @Test
  public void testFindEntityViewByTenantIdAndType_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewByTenantIdAndType(ModelConstants.SYSTEM_TENANT, pageLink, "Type"));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndType_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> entityViewServiceImpl
        .findEntityViewInfosByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndCustomerId_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndCustomerId_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)}.
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, pageLink, "Type"));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, PageLink, String)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException(
        "Executing findEntityViewsByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], pageLink [{}],"
            + " type [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> entityViewServiceImpl.findEntityViewsByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, pageLink, "Type"));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException(
        "Executing findEntityViewInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], pageLink"
            + " [{}], type [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> entityViewServiceImpl.findEntityViewInfosByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEdgeId_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewServiceImpl.findEntityViewsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> entityViewServiceImpl
        .findEntityViewsByTenantIdAndEdgeIdAndType(ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewServiceImpl#findEntityViewsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException("foo"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> entityViewServiceImpl
        .findEntityViewsByTenantIdAndEdgeIdAndType(ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EntityViewServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link EntityViewServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ENTITY_VIEW, (new EntityViewServiceImpl()).getEntityType());
  }
}
