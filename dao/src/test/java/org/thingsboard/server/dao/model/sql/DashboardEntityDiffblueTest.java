package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ShortCustomerInfo;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class DashboardEntityDiffblueTest {
  /**
   * Test {@link DashboardEntity#equals(Object)}, and
   * {@link DashboardEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DashboardEntity#equals(Object)}
   *   <li>{@link DashboardEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(dashboardEntity, dashboardEntity2);
    int expectedHashCodeResult = dashboardEntity.hashCode();
    assertEquals(expectedHashCodeResult, dashboardEntity2.hashCode());
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}, and
   * {@link DashboardEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DashboardEntity#equals(Object)}
   *   <li>{@link DashboardEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    // Act and Assert
    assertEquals(dashboardEntity, dashboardEntity);
    int expectedHashCodeResult = dashboardEntity.hashCode();
    assertEquals(expectedHashCodeResult, dashboardEntity.hashCode());
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Dr");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers(null);
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(MissingNode.getInstance());
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(null);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(mock(JsonNode.class));
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(3L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(UUID.randomUUID());
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(null);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Dr");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage(null);
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(false);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(3);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(null);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(UUID.randomUUID());
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(null);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Mr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle(null);
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    DashboardEntity dashboardEntity2 = new DashboardEntity();
    dashboardEntity2.setAssignedCustomers("Assigned Customers");
    dashboardEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity2.setCreatedTime(1L);
    dashboardEntity2.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity2.setId(ModelConstants.NULL_UUID);
    dashboardEntity2.setImage("Image");
    dashboardEntity2.setMobileHide(true);
    dashboardEntity2.setMobileOrder(1);
    dashboardEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity2.setTitle("Dr");
    dashboardEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, dashboardEntity2);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, null);
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardEntity, "Different type to DashboardEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DashboardEntity#DashboardEntity()}
   *   <li>{@link DashboardEntity#setAssignedCustomers(String)}
   *   <li>{@link DashboardEntity#setConfiguration(JsonNode)}
   *   <li>{@link DashboardEntity#setExternalId(UUID)}
   *   <li>{@link DashboardEntity#setImage(String)}
   *   <li>{@link DashboardEntity#setMobileHide(boolean)}
   *   <li>{@link DashboardEntity#setMobileOrder(Integer)}
   *   <li>{@link DashboardEntity#setTenantId(UUID)}
   *   <li>{@link DashboardEntity#setTitle(String)}
   *   <li>{@link DashboardEntity#toString()}
   *   <li>{@link DashboardEntity#getAssignedCustomers()}
   *   <li>{@link DashboardEntity#getConfiguration()}
   *   <li>{@link DashboardEntity#getExternalId()}
   *   <li>{@link DashboardEntity#getImage()}
   *   <li>{@link DashboardEntity#getMobileOrder()}
   *   <li>{@link DashboardEntity#getTenantId()}
   *   <li>{@link DashboardEntity#getTitle()}
   *   <li>{@link DashboardEntity#isMobileHide()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DashboardEntity actualDashboardEntity = new DashboardEntity();
    actualDashboardEntity.setAssignedCustomers("Assigned Customers");
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualDashboardEntity.setConfiguration(configuration);
    actualDashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    actualDashboardEntity.setImage("Image");
    actualDashboardEntity.setMobileHide(true);
    actualDashboardEntity.setMobileOrder(1);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualDashboardEntity.setTenantId(tenantId);
    actualDashboardEntity.setTitle("Dr");
    String actualToStringResult = actualDashboardEntity.toString();
    String actualAssignedCustomers = actualDashboardEntity.getAssignedCustomers();
    JsonNode actualConfiguration = actualDashboardEntity.getConfiguration();
    UUID actualExternalId = actualDashboardEntity.getExternalId();
    String actualImage = actualDashboardEntity.getImage();
    Integer actualMobileOrder = actualDashboardEntity.getMobileOrder();
    UUID actualTenantId = actualDashboardEntity.getTenantId();
    String actualTitle = actualDashboardEntity.getTitle();
    boolean actualIsMobileHideResult = actualDashboardEntity.isMobileHide();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Assigned Customers", actualAssignedCustomers);
    assertEquals(
        "DashboardEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, image=Image, assignedCustomers"
            + "=Assigned Customers, mobileHide=true, mobileOrder=1, configuration={\"isPublic\":true}, externalId"
            + "=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertEquals("Dr", actualTitle);
    assertEquals("Image", actualImage);
    assertEquals(0L, actualDashboardEntity.getCreatedTime());
    assertEquals(1, actualMobileOrder.intValue());
    assertTrue(actualIsMobileHideResult);
    assertSame(configuration, actualConfiguration);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link DashboardEntity#DashboardEntity(Dashboard)}.
   * <p>
   * Method under test: {@link DashboardEntity#DashboardEntity(Dashboard)}
   */
  @Test
  public void testNewDashboardEntity() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(null);
    dashboard.setAssignedCustomers(new HashSet<>());
    dashboard.setExternalId(null);

    // Act
    DashboardEntity actualDashboardEntity = new DashboardEntity(dashboard);

    // Assert
    assertEquals("[]", actualDashboardEntity.getAssignedCustomers());
    assertNull(actualDashboardEntity.getConfiguration());
    assertNull(actualDashboardEntity.getMobileOrder());
    assertNull(actualDashboardEntity.getVersion());
    assertNull(actualDashboardEntity.getImage());
    assertNull(actualDashboardEntity.getTitle());
    assertNull(actualDashboardEntity.getId());
    assertNull(actualDashboardEntity.getUuid());
    assertNull(actualDashboardEntity.getExternalId());
    assertNull(actualDashboardEntity.getTenantId());
    assertEquals(0L, actualDashboardEntity.getCreatedTime());
    assertFalse(actualDashboardEntity.isMobileHide());
  }

  /**
   * Test {@link DashboardEntity#DashboardEntity(Dashboard)}.
   * <p>
   * Method under test: {@link DashboardEntity#DashboardEntity(Dashboard)}
   */
  @Test
  public void testNewDashboardEntity2() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);
    dashboard.setAssignedCustomers(new HashSet<>());
    dashboard.setExternalId(null);

    // Act
    DashboardEntity actualDashboardEntity = new DashboardEntity(dashboard);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDashboardEntity.getTenantId().toString());
    assertEquals("[]", actualDashboardEntity.getAssignedCustomers());
    assertNull(actualDashboardEntity.getConfiguration());
    assertNull(actualDashboardEntity.getMobileOrder());
    assertNull(actualDashboardEntity.getVersion());
    assertNull(actualDashboardEntity.getImage());
    assertNull(actualDashboardEntity.getTitle());
    assertNull(actualDashboardEntity.getId());
    assertNull(actualDashboardEntity.getUuid());
    assertNull(actualDashboardEntity.getExternalId());
    assertEquals(0L, actualDashboardEntity.getCreatedTime());
    assertFalse(actualDashboardEntity.isMobileHide());
  }

  /**
   * Test {@link DashboardEntity#DashboardEntity(Dashboard)}.
   * <p>
   * Method under test: {@link DashboardEntity#DashboardEntity(Dashboard)}
   */
  @Test
  public void testNewDashboardEntity3() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(null);
    dashboard.setAssignedCustomers(new HashSet<>());
    dashboard.setExternalId(new DashboardId(ModelConstants.NULL_UUID));

    // Act
    DashboardEntity actualDashboardEntity = new DashboardEntity(dashboard);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDashboardEntity.getExternalId().toString());
    assertEquals("[]", actualDashboardEntity.getAssignedCustomers());
    assertNull(actualDashboardEntity.getConfiguration());
    assertNull(actualDashboardEntity.getMobileOrder());
    assertNull(actualDashboardEntity.getVersion());
    assertNull(actualDashboardEntity.getImage());
    assertNull(actualDashboardEntity.getTitle());
    assertNull(actualDashboardEntity.getId());
    assertNull(actualDashboardEntity.getUuid());
    assertNull(actualDashboardEntity.getTenantId());
    assertEquals(0L, actualDashboardEntity.getCreatedTime());
    assertFalse(actualDashboardEntity.isMobileHide());
  }

  /**
   * Test {@link DashboardEntity#DashboardEntity(Dashboard)}.
   * <ul>
   *   <li>Then return AssignedCustomers is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#DashboardEntity(Dashboard)}
   */
  @Test
  public void testNewDashboardEntity_thenReturnAssignedCustomersIsAString() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(new ShortCustomerInfo(BaseEntityService.NULL_CUSTOMER_ID, "Dr", true));

    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(null);
    dashboard.setAssignedCustomers(assignedCustomers);
    dashboard.setExternalId(null);

    // Act
    DashboardEntity actualDashboardEntity = new DashboardEntity(dashboard);

    // Assert
    assertEquals(
        "[{\"customerId\":{\"entityType\":\"CUSTOMER\",\"id\":\"13814000-1dd2-11b2-8080-808080808080\"},\"title\":\"Dr\","
            + "\"public\":true}]",
        actualDashboardEntity.getAssignedCustomers());
    assertNull(actualDashboardEntity.getConfiguration());
    assertNull(actualDashboardEntity.getMobileOrder());
    assertNull(actualDashboardEntity.getVersion());
    assertNull(actualDashboardEntity.getImage());
    assertNull(actualDashboardEntity.getTitle());
    assertNull(actualDashboardEntity.getId());
    assertNull(actualDashboardEntity.getUuid());
    assertNull(actualDashboardEntity.getExternalId());
    assertNull(actualDashboardEntity.getTenantId());
    assertEquals(0L, actualDashboardEntity.getCreatedTime());
    assertFalse(actualDashboardEntity.isMobileHide());
  }

  /**
   * Test {@link DashboardEntity#DashboardEntity(Dashboard)}.
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()} AssignedCustomers is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#DashboardEntity(Dashboard)}
   */
  @Test
  public void testNewDashboardEntity_whenDashboardAssignedCustomersIsNull() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);
    dashboard.setAssignedCustomers(null);
    dashboard.setExternalId(null);

    // Act
    DashboardEntity actualDashboardEntity = new DashboardEntity(dashboard);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDashboardEntity.getTenantId().toString());
    assertNull(actualDashboardEntity.getConfiguration());
    assertNull(actualDashboardEntity.getMobileOrder());
    assertNull(actualDashboardEntity.getVersion());
    assertNull(actualDashboardEntity.getAssignedCustomers());
    assertNull(actualDashboardEntity.getImage());
    assertNull(actualDashboardEntity.getTitle());
    assertNull(actualDashboardEntity.getId());
    assertNull(actualDashboardEntity.getUuid());
    assertNull(actualDashboardEntity.getExternalId());
    assertEquals(0L, actualDashboardEntity.getCreatedTime());
    assertFalse(actualDashboardEntity.isMobileHide());
  }

  /**
   * Test {@link DashboardEntity#DashboardEntity(Dashboard)}.
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.</li>
   *   <li>Then return AssignedCustomers is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#DashboardEntity(Dashboard)}
   */
  @Test
  public void testNewDashboardEntity_whenDashboard_thenReturnAssignedCustomersIsNull() {
    // Arrange and Act
    DashboardEntity actualDashboardEntity = new DashboardEntity(new Dashboard());

    // Assert
    assertNull(actualDashboardEntity.getConfiguration());
    assertNull(actualDashboardEntity.getMobileOrder());
    assertNull(actualDashboardEntity.getVersion());
    assertNull(actualDashboardEntity.getAssignedCustomers());
    assertNull(actualDashboardEntity.getImage());
    assertNull(actualDashboardEntity.getTitle());
    assertNull(actualDashboardEntity.getId());
    assertNull(actualDashboardEntity.getUuid());
    assertNull(actualDashboardEntity.getExternalId());
    assertNull(actualDashboardEntity.getTenantId());
    assertEquals(0L, actualDashboardEntity.getCreatedTime());
    assertFalse(actualDashboardEntity.isMobileHide());
  }

  /**
   * Test {@link DashboardEntity#toData()}.
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} AssignedCustomers is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  public void testToData_givenDashboardEntityAssignedCustomersIs42() throws IOException {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);
    dashboardEntity.setTenantId(null);
    dashboardEntity.setExternalId(null);
    dashboardEntity.setAssignedCustomers("42");

    // Act
    Dashboard actualToDataResult = dashboardEntity.toData();

    // Assert
    JsonNode configuration = actualToDataResult.getConfiguration();
    Iterator<JsonNode> iteratorResult = configuration.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(configuration instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = configuration.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("Image", actualToDataResult.getImage());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", configuration.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, configuration.size());
    assertEquals(1, actualToDataResult.getMobileOrder().intValue());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, configuration.getNodeType());
    DashboardId id = actualToDataResult.getId();
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(configuration.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(configuration.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(configuration.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(configuration.isBinary());
    assertFalse(configuration.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(configuration.isDouble());
    assertFalse(configuration.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(configuration.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(configuration.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(configuration.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(configuration.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(configuration.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(configuration.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(configuration.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(configuration.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(configuration.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(configuration.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(configuration.isTextual());
    assertFalse(configuration.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(configuration.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(configuration.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(actualToDataResult.isMobileHide());
    assertTrue(id.isNullUid());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link DashboardEntity#toData()}.
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} AssignedCustomers is
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  public void testToData_givenDashboardEntityAssignedCustomersIsEmptyString() throws IOException {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);
    dashboardEntity.setTenantId(null);
    dashboardEntity.setExternalId(null);
    dashboardEntity.setAssignedCustomers("");

    // Act
    Dashboard actualToDataResult = dashboardEntity.toData();

    // Assert
    JsonNode configuration = actualToDataResult.getConfiguration();
    Iterator<JsonNode> iteratorResult = configuration.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(configuration instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = configuration.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("Image", actualToDataResult.getImage());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", configuration.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, configuration.size());
    assertEquals(1, actualToDataResult.getMobileOrder().intValue());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, configuration.getNodeType());
    DashboardId id = actualToDataResult.getId();
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(configuration.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(configuration.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(configuration.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(configuration.isBinary());
    assertFalse(configuration.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(configuration.isDouble());
    assertFalse(configuration.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(configuration.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(configuration.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(configuration.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(configuration.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(configuration.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(configuration.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(configuration.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(configuration.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(configuration.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(configuration.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(configuration.isTextual());
    assertFalse(configuration.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(configuration.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(configuration.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(actualToDataResult.isMobileHide());
    assertTrue(id.isNullUid());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link DashboardEntity#toData()}.
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} AssignedCustomers is
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  public void testToData_givenDashboardEntityAssignedCustomersIsFoo() throws IOException {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);
    dashboardEntity.setTenantId(null);
    dashboardEntity.setExternalId(null);
    dashboardEntity.setAssignedCustomers("foo");

    // Act
    Dashboard actualToDataResult = dashboardEntity.toData();

    // Assert
    JsonNode configuration = actualToDataResult.getConfiguration();
    Iterator<JsonNode> iteratorResult = configuration.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(configuration instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = configuration.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("Image", actualToDataResult.getImage());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", configuration.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, configuration.size());
    assertEquals(1, actualToDataResult.getMobileOrder().intValue());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, configuration.getNodeType());
    DashboardId id = actualToDataResult.getId();
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(configuration.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(configuration.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(configuration.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(configuration.isBinary());
    assertFalse(configuration.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(configuration.isDouble());
    assertFalse(configuration.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(configuration.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(configuration.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(configuration.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(configuration.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(configuration.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(configuration.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(configuration.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(configuration.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(configuration.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(configuration.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(configuration.isTextual());
    assertFalse(configuration.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(configuration.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(configuration.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(actualToDataResult.isMobileHide());
    assertTrue(id.isNullUid());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link DashboardEntity#toData()}.
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} TenantId is
   * randomUUID.</li>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  public void testToData_givenDashboardEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);
    UUID tenantId = UUID.randomUUID();
    dashboardEntity.setTenantId(tenantId);
    dashboardEntity.setExternalId(null);
    dashboardEntity.setAssignedCustomers("");

    // Act and Assert
    TenantId tenantId2 = dashboardEntity.toData().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DashboardEntity#toData()}.
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} TenantId is
   * randomUUID.</li>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  public void testToData_givenDashboardEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid2() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);
    UUID tenantId = UUID.randomUUID();
    dashboardEntity.setTenantId(tenantId);
    dashboardEntity.setExternalId(null);
    dashboardEntity.setAssignedCustomers("42");

    // Act and Assert
    TenantId tenantId2 = dashboardEntity.toData().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DashboardEntity#toData()}.
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()}.</li>
   *   <li>Then return Configuration is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  public void testToData_givenDashboardEntity_thenReturnConfigurationIsNull() {
    // Arrange and Act
    Dashboard actualToDataResult = (new DashboardEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getConfiguration());
    assertNull(actualToDataResult.getMobileOrder());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getUuidId());
    DashboardId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isMobileHide());
    assertFalse(id.isNullUid());
  }

  /**
   * Test {@link DashboardEntity#toData()}.
   * <ul>
   *   <li>Then return ExternalId EntityType is {@code DASHBOARD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  public void testToData_thenReturnExternalIdEntityTypeIsDashboard() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);
    dashboardEntity.setTenantId(null);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setAssignedCustomers(null);

    // Act
    Dashboard actualToDataResult = dashboardEntity.toData();

    // Assert
    DashboardId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.DASHBOARD, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
  }

  /**
   * Test {@link DashboardEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setExternalId(null);
    dashboardEntity.setAssignedCustomers(null);

    // Act and Assert
    TenantId tenantId = dashboardEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
