package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.DashboardInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ShortCustomerInfo;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class DashboardInfoEntityDiffblueTest {
  /**
   * Test {@link DashboardInfoEntity#equals(Object)}, and {@link DashboardInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DashboardInfoEntity#equals(Object)}
   *   <li>{@link DashboardInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(dashboardInfoEntity, dashboardInfoEntity2);
    int expectedHashCodeResult = dashboardInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, dashboardInfoEntity2.hashCode());
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}, and {@link DashboardInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DashboardInfoEntity#equals(Object)}
   *   <li>{@link DashboardInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers(null);
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers(null);
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(dashboardInfoEntity, dashboardInfoEntity2);
    int expectedHashCodeResult = dashboardInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, dashboardInfoEntity2.hashCode());
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}, and {@link DashboardInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DashboardInfoEntity#equals(Object)}
   *   <li>{@link DashboardInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    // Act and Assert
    assertEquals(dashboardInfoEntity, dashboardInfoEntity);
    int expectedHashCodeResult = dashboardInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, dashboardInfoEntity.hashCode());
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Dr");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers(null);
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(3L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Dr");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage(null);
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(false);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(3);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(null);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(null);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Mr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle(null);
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity2.setCreatedTime(1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("Image");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(1);
    dashboardInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setTitle("Dr");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, dashboardInfoEntity2);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, null);
  }

  /**
   * Test {@link DashboardInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardInfoEntity.equals(Object)",
    "int DashboardInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(dashboardInfoEntity, "Different type to DashboardInfoEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DashboardInfoEntity.<init>()",
    "String DashboardInfoEntity.getAssignedCustomers()",
    "String DashboardInfoEntity.getImage()",
    "Integer DashboardInfoEntity.getMobileOrder()",
    "UUID DashboardInfoEntity.getTenantId()",
    "String DashboardInfoEntity.getTitle()",
    "boolean DashboardInfoEntity.isMobileHide()",
    "void DashboardInfoEntity.setAssignedCustomers(String)",
    "void DashboardInfoEntity.setImage(String)",
    "void DashboardInfoEntity.setMobileHide(boolean)",
    "void DashboardInfoEntity.setMobileOrder(Integer)",
    "void DashboardInfoEntity.setTenantId(UUID)",
    "void DashboardInfoEntity.setTitle(String)",
    "String DashboardInfoEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DashboardInfoEntity actualDashboardInfoEntity = new DashboardInfoEntity();
    actualDashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    actualDashboardInfoEntity.setImage("Image");
    actualDashboardInfoEntity.setMobileHide(true);
    actualDashboardInfoEntity.setMobileOrder(1);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDashboardInfoEntity.setTenantId(tenantId);
    actualDashboardInfoEntity.setTitle("Dr");
    String actualToStringResult = actualDashboardInfoEntity.toString();
    String actualAssignedCustomers = actualDashboardInfoEntity.getAssignedCustomers();
    String actualImage = actualDashboardInfoEntity.getImage();
    Integer actualMobileOrder = actualDashboardInfoEntity.getMobileOrder();
    UUID actualTenantId = actualDashboardInfoEntity.getTenantId();
    String actualTitle = actualDashboardInfoEntity.getTitle();
    boolean actualIsMobileHideResult = actualDashboardInfoEntity.isMobileHide();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Assigned Customers", actualAssignedCustomers);
    assertEquals(
        "DashboardInfoEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, title=Dr, image=Image, assignedCustomers"
            + "=Assigned Customers, mobileHide=true, mobileOrder=1)",
        actualToStringResult);
    assertEquals("Dr", actualTitle);
    assertEquals("Image", actualImage);
    assertNull(actualDashboardInfoEntity.getVersion());
    assertNull(actualDashboardInfoEntity.getId());
    assertNull(actualDashboardInfoEntity.getUuid());
    assertEquals(0L, actualDashboardInfoEntity.getCreatedTime());
    assertEquals(1, actualMobileOrder.intValue());
    assertTrue(actualIsMobileHideResult);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link DashboardInfoEntity#DashboardInfoEntity(DashboardInfo)}.
   *
   * <p>Method under test: {@link DashboardInfoEntity#DashboardInfoEntity(DashboardInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DashboardInfoEntity.<init>(DashboardInfo)"})
  public void testNewDashboardInfoEntity() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo(new DashboardInfo());
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
   *
   * <p>Method under test: {@link DashboardInfoEntity#DashboardInfoEntity(DashboardInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DashboardInfoEntity.<init>(DashboardInfo)"})
  public void testNewDashboardInfoEntity2() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo(new DashboardInfo());
    dashboardInfo.setTenantId(ModelConstants.SYSTEM_TENANT);
    dashboardInfo.setAssignedCustomers(null);

    // Act
    DashboardInfoEntity actualDashboardInfoEntity = new DashboardInfoEntity(dashboardInfo);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualDashboardInfoEntity.getTenantId().toString());
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
   *
   * <ul>
   *   <li>When {@link DashboardInfo#DashboardInfo()}.
   *   <li>Then return AssignedCustomers is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#DashboardInfoEntity(DashboardInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DashboardInfoEntity.<init>(DashboardInfo)"})
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
   *
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()} AssignedCustomers is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DashboardInfo DashboardInfoEntity.toData()"})
  public void testToData_givenDashboardInfoEntityAssignedCustomersIs42() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("42");

    // Act
    DashboardInfo actualToDataResult = dashboardInfoEntity.toData();

    // Assert
    assertNull(actualToDataResult.getMobileOrder());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getAssignedCustomers());
    assertNull(actualToDataResult.getUuidId());
    DashboardId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertFalse(actualToDataResult.isMobileHide());
    assertFalse(id.isNullUid());
  }

  /**
   * Test {@link DashboardInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()} AssignedCustomers is {@code
   *       Assigned Customers}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DashboardInfo DashboardInfoEntity.toData()"})
  public void testToData_givenDashboardInfoEntityAssignedCustomersIsAssignedCustomers() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");

    // Act
    DashboardInfo actualToDataResult = dashboardInfoEntity.toData();

    // Assert
    assertNull(actualToDataResult.getMobileOrder());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getAssignedCustomers());
    assertNull(actualToDataResult.getUuidId());
    DashboardId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertFalse(actualToDataResult.isMobileHide());
    assertFalse(id.isNullUid());
  }

  /**
   * Test {@link DashboardInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()} AssignedCustomers is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DashboardInfo DashboardInfoEntity.toData()"})
  public void testToData_givenDashboardInfoEntityAssignedCustomersIsEmptyString() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("");

    // Act
    DashboardInfo actualToDataResult = dashboardInfoEntity.toData();

    // Assert
    assertNull(actualToDataResult.getMobileOrder());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getAssignedCustomers());
    assertNull(actualToDataResult.getUuidId());
    DashboardId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertFalse(actualToDataResult.isMobileHide());
    assertFalse(id.isNullUid());
  }

  /**
   * Test {@link DashboardInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()}.
   *   <li>Then return AssignedCustomers is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DashboardInfo DashboardInfoEntity.toData()"})
  public void testToData_givenDashboardInfoEntity_thenReturnAssignedCustomersIsNull() {
    // Arrange and Act
    DashboardInfo actualToDataResult = new DashboardInfoEntity().toData();

    // Assert
    assertNull(actualToDataResult.getMobileOrder());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getAssignedCustomers());
    assertNull(actualToDataResult.getUuidId());
    DashboardId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertFalse(actualToDataResult.isMobileHide());
    assertFalse(id.isNullUid());
  }

  /**
   * Test {@link DashboardInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return AssignedCustomers Empty.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DashboardInfo DashboardInfoEntity.toData()"})
  public void testToData_thenReturnAssignedCustomersEmpty() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo(new DashboardInfo());
    dashboardInfo.setTenantId(null);
    dashboardInfo.setAssignedCustomers(new HashSet<>());

    // Act
    DashboardInfo actualToDataResult = new DashboardInfoEntity(dashboardInfo).toData();

    // Assert
    assertNull(actualToDataResult.getMobileOrder());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getUuidId());
    DashboardId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertFalse(actualToDataResult.isMobileHide());
    assertFalse(id.isNullUid());
    assertTrue(actualToDataResult.getAssignedCustomers().isEmpty());
  }

  /**
   * Test {@link DashboardInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return AssignedCustomers size is one.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DashboardInfo DashboardInfoEntity.toData()"})
  public void testToData_thenReturnAssignedCustomersSizeIsOne() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(new ShortCustomerInfo(BaseEntityService.NULL_CUSTOMER_ID, "Dr", true));

    DashboardInfo dashboardInfo = new DashboardInfo(new DashboardInfo());
    dashboardInfo.setTenantId(null);
    dashboardInfo.setAssignedCustomers(assignedCustomers);

    // Act
    DashboardInfo actualToDataResult = new DashboardInfoEntity(dashboardInfo).toData();

    // Assert
    assertNull(actualToDataResult.getMobileOrder());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getUuidId());
    DashboardId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(1, actualToDataResult.getAssignedCustomers().size());
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertFalse(actualToDataResult.isMobileHide());
    assertFalse(id.isNullUid());
  }

  /**
   * Test {@link DashboardInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DashboardInfo DashboardInfoEntity.toData()"})
  public void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    UUID tenantId = UUID.randomUUID();
    dashboardInfoEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = dashboardInfoEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DashboardInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DashboardInfo DashboardInfoEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    TenantId tenantId = dashboardInfoEntity.toData().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
