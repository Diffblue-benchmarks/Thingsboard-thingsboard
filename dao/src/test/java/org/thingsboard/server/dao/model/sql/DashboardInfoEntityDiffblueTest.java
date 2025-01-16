package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.DashboardInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class DashboardInfoEntityDiffblueTest {
  /**
   * Test {@link DashboardInfoEntity#equals(Object)}, and
   * {@link DashboardInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DashboardInfoEntity#equals(Object)}
   *   <li>{@link DashboardInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(dashboardInfoEntity, dashboardInfoEntity2);
    int expectedHashCodeResult = dashboardInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, dashboardInfoEntity2.hashCode());
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}, and
   * {@link DashboardInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DashboardInfoEntity#equals(Object)}
   *   <li>{@link DashboardInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    // Act and Assert
    assertEquals(dashboardInfoEntity, dashboardInfoEntity);
    int expectedHashCodeResult = dashboardInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, dashboardInfoEntity.hashCode());
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Dr");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers(null);
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(3L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Dr");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage(null);
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(false);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(3);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(null);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.randomUUID());
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(null);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Mr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle(null);
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, null);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, "Different type to DashboardInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DashboardInfoEntity#DashboardInfoEntity()}
   *   <li>{@link DashboardInfoEntity#setAssignedCustomers(String)}
   *   <li>{@link DashboardInfoEntity#setImage(String)}
   *   <li>{@link DashboardInfoEntity#setMobileHide(boolean)}
   *   <li>{@link DashboardInfoEntity#setMobileOrder(Integer)}
   *   <li>{@link DashboardInfoEntity#setTenantId(UUID)}
   *   <li>{@link DashboardInfoEntity#setTitle(String)}
   *   <li>{@link DashboardInfoEntity#toString()}
   *   <li>{@link DashboardInfoEntity#getAssignedCustomers()}
   *   <li>{@link DashboardInfoEntity#getImage()}
   *   <li>{@link DashboardInfoEntity#getMobileOrder()}
   *   <li>{@link DashboardInfoEntity#getTenantId()}
   *   <li>{@link DashboardInfoEntity#getTitle()}
   *   <li>{@link DashboardInfoEntity#isMobileHide()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DashboardInfoEntity actualDashboardInfoEntity = new DashboardInfoEntity();
    actualDashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    actualDashboardInfoEntity.setImage("Image");
    actualDashboardInfoEntity.setMobileHide(true);
    actualDashboardInfoEntity.setMobileOrder(1);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualDashboardInfoEntity.setTenantId(tenantId);
    actualDashboardInfoEntity.setTitle("Dr");
    String actualToStringResult = actualDashboardInfoEntity.toString();
    String actualAssignedCustomers = actualDashboardInfoEntity.getAssignedCustomers();
    String actualImage = actualDashboardInfoEntity.getImage();
    Integer actualMobileOrder = actualDashboardInfoEntity.getMobileOrder();
    UUID actualTenantId = actualDashboardInfoEntity.getTenantId();
    String actualTitle = actualDashboardInfoEntity.getTitle();
    boolean actualIsMobileHideResult = actualDashboardInfoEntity.isMobileHide();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.toString());
    assertEquals("Assigned Customers", actualAssignedCustomers);
    assertEquals(
        "DashboardInfoEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, image=Image, assignedCustomers"
            + "=Assigned Customers, mobileHide=true, mobileOrder=1)",
        actualToStringResult);
    assertEquals("Dr", actualTitle);
    assertEquals("Image", actualImage);
    assertEquals(0L, actualDashboardInfoEntity.getCreatedTime());
    assertEquals(1, actualMobileOrder.intValue());
    assertTrue(actualIsMobileHideResult);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link DashboardInfoEntity#DashboardInfoEntity(DashboardInfo)}.
   * <p>
   * Method under test:
   * {@link DashboardInfoEntity#DashboardInfoEntity(DashboardInfo)}
   */
  @Test
  public void testNewDashboardInfoEntity() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setTenantId(ModelConstants.SYSTEM_TENANT);
    dashboardInfo.setAssignedCustomers(null);

    // Act
    DashboardInfoEntity actualDashboardInfoEntity = new DashboardInfoEntity(dashboardInfo);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDashboardInfoEntity.getTenantId().toString());
    assertNull(actualDashboardInfoEntity.getMobileOrder());
    assertNull(actualDashboardInfoEntity.getVersion());
    assertNull(actualDashboardInfoEntity.getAssignedCustomers());
    assertNull(actualDashboardInfoEntity.getImage());
    assertNull(actualDashboardInfoEntity.getTitle());
    assertNull(actualDashboardInfoEntity.getId());
    assertNull(actualDashboardInfoEntity.getUuid());
    assertEquals(0L, actualDashboardInfoEntity.getCreatedTime());
    assertFalse(actualDashboardInfoEntity.isMobileHide());
  }

  /**
   * Test {@link DashboardInfoEntity#DashboardInfoEntity(DashboardInfo)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardInfoEntity#DashboardInfoEntity(DashboardInfo)}
   */
  @Test
  public void testNewDashboardInfoEntity_givenHashSet() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setTenantId(null);
    dashboardInfo.setAssignedCustomers(new HashSet<>());

    // Act
    DashboardInfoEntity actualDashboardInfoEntity = new DashboardInfoEntity(dashboardInfo);

    // Assert
    assertEquals("[]", actualDashboardInfoEntity.getAssignedCustomers());
    assertNull(actualDashboardInfoEntity.getMobileOrder());
    assertNull(actualDashboardInfoEntity.getVersion());
    assertNull(actualDashboardInfoEntity.getImage());
    assertNull(actualDashboardInfoEntity.getTitle());
    assertNull(actualDashboardInfoEntity.getId());
    assertNull(actualDashboardInfoEntity.getUuid());
    assertNull(actualDashboardInfoEntity.getTenantId());
    assertEquals(0L, actualDashboardInfoEntity.getCreatedTime());
    assertFalse(actualDashboardInfoEntity.isMobileHide());
  }

  /**
   * Test {@link DashboardInfoEntity#DashboardInfoEntity(DashboardInfo)}.
   * <ul>
   *   <li>When {@link DashboardInfo#DashboardInfo()}.</li>
   *   <li>Then return AssignedCustomers is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardInfoEntity#DashboardInfoEntity(DashboardInfo)}
   */
  @Test
  public void testNewDashboardInfoEntity_whenDashboardInfo_thenReturnAssignedCustomersIsNull() {
    // Arrange and Act
    DashboardInfoEntity actualDashboardInfoEntity = new DashboardInfoEntity(new DashboardInfo());

    // Assert
    assertNull(actualDashboardInfoEntity.getMobileOrder());
    assertNull(actualDashboardInfoEntity.getVersion());
    assertNull(actualDashboardInfoEntity.getAssignedCustomers());
    assertNull(actualDashboardInfoEntity.getImage());
    assertNull(actualDashboardInfoEntity.getTitle());
    assertNull(actualDashboardInfoEntity.getId());
    assertNull(actualDashboardInfoEntity.getUuid());
    assertNull(actualDashboardInfoEntity.getTenantId());
    assertEquals(0L, actualDashboardInfoEntity.getCreatedTime());
    assertFalse(actualDashboardInfoEntity.isMobileHide());
  }

  /**
   * Test {@link DashboardInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()} AssignedCustomers
   * is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#toData()}
   */
  @Test
  public void testToData_givenDashboardInfoEntityAssignedCustomersIs42() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);
    dashboardInfoEntity.setTenantId(null);
    dashboardInfoEntity.setAssignedCustomers("42");

    // Act
    DashboardInfo actualToDataResult = dashboardInfoEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("Image", actualToDataResult.getImage());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(1, actualToDataResult.getMobileOrder().intValue());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isMobileHide());
    DashboardId id = actualToDataResult.getId();
    assertTrue(id.isNullUid());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link DashboardInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()} AssignedCustomers
   * is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#toData()}
   */
  @Test
  public void testToData_givenDashboardInfoEntityAssignedCustomersIsEmptyString() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);
    dashboardInfoEntity.setTenantId(null);
    dashboardInfoEntity.setAssignedCustomers("");

    // Act
    DashboardInfo actualToDataResult = dashboardInfoEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("Image", actualToDataResult.getImage());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(1, actualToDataResult.getMobileOrder().intValue());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isMobileHide());
    DashboardId id = actualToDataResult.getId();
    assertTrue(id.isNullUid());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link DashboardInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()} AssignedCustomers
   * is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#toData()}
   */
  @Test
  public void testToData_givenDashboardInfoEntityAssignedCustomersIsFoo() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);
    dashboardInfoEntity.setTenantId(null);
    dashboardInfoEntity.setAssignedCustomers("foo");

    // Act
    DashboardInfo actualToDataResult = dashboardInfoEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("Image", actualToDataResult.getImage());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(1, actualToDataResult.getMobileOrder().intValue());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isMobileHide());
    DashboardId id = actualToDataResult.getId();
    assertTrue(id.isNullUid());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link DashboardInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()}.</li>
   *   <li>Then return MobileOrder is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#toData()}
   */
  @Test
  public void testToData_givenDashboardInfoEntity_thenReturnMobileOrderIsNull() {
    // Arrange and Act
    DashboardInfo actualToDataResult = (new DashboardInfoEntity()).toData();

    // Assert
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
   * Test {@link DashboardInfoEntity#toData()}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnNotTenantIdNullUid() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);
    UUID tenantId = UUID.randomUUID();
    dashboardInfoEntity.setTenantId(tenantId);
    dashboardInfoEntity.setAssignedCustomers("");

    // Act and Assert
    TenantId tenantId2 = dashboardInfoEntity.toData().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DashboardInfoEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setAssignedCustomers(null);

    // Act and Assert
    TenantId tenantId = dashboardInfoEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
