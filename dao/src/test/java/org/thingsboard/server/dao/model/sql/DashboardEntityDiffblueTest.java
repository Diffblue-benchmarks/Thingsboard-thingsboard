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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.HashSet;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link DashboardEntity#equals(Object)}, and {@link DashboardEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DashboardEntity#equals(Object)}
   *   <li>{@link DashboardEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
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
    assertEquals(dashboardEntity.hashCode(), dashboardEntity2.hashCode());
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}, and {@link DashboardEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DashboardEntity#equals(Object)}
   *   <li>{@link DashboardEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
    dashboardEntity2.setAssignedCustomers(null);
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
    assertEquals(dashboardEntity.hashCode(), dashboardEntity2.hashCode());
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}, and {@link DashboardEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DashboardEntity#equals(Object)}
   *   <li>{@link DashboardEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
    dashboardEntity2.setConfiguration(null);
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
    assertEquals(dashboardEntity.hashCode(), dashboardEntity2.hashCode());
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}, and {@link DashboardEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DashboardEntity#equals(Object)}
   *   <li>{@link DashboardEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
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
    dashboardEntity2.setExternalId(null);
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
    assertEquals(dashboardEntity.hashCode(), dashboardEntity2.hashCode());
  }

  /**
   * Test {@link DashboardEntity#equals(Object)}, and {@link DashboardEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DashboardEntity#equals(Object)}
   *   <li>{@link DashboardEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(DoubleNode.valueOf(10.0d));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardEntity.equals(Object)", "int DashboardEntity.hashCode()"})
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
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DashboardEntity.<init>()",
    "String DashboardEntity.getAssignedCustomers()",
    "JsonNode DashboardEntity.getConfiguration()",
    "UUID DashboardEntity.getExternalId()",
    "String DashboardEntity.getImage()",
    "Integer DashboardEntity.getMobileOrder()",
    "UUID DashboardEntity.getTenantId()",
    "String DashboardEntity.getTitle()",
    "boolean DashboardEntity.isMobileHide()",
    "void DashboardEntity.setAssignedCustomers(String)",
    "void DashboardEntity.setConfiguration(JsonNode)",
    "void DashboardEntity.setExternalId(UUID)",
    "void DashboardEntity.setImage(String)",
    "void DashboardEntity.setMobileHide(boolean)",
    "void DashboardEntity.setMobileOrder(Integer)",
    "void DashboardEntity.setTenantId(UUID)",
    "void DashboardEntity.setTitle(String)",
    "String DashboardEntity.toString()"
  })
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

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Assigned Customers", actualAssignedCustomers);
    assertEquals(
        "DashboardEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, image=Image, assignedCustomers"
            + "=Assigned Customers, mobileHide=true, mobileOrder=1, configuration={\"isPublic\":true}, externalId"
            + "=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertEquals("Dr", actualTitle);
    assertEquals("Image", actualImage);
    assertNull(actualDashboardEntity.getVersion());
    assertNull(actualDashboardEntity.getId());
    assertNull(actualDashboardEntity.getUuid());
    assertEquals(0L, actualDashboardEntity.getCreatedTime());
    assertEquals(1, actualMobileOrder.intValue());
    assertTrue(actualIsMobileHideResult);
    assertSame(configuration, actualConfiguration);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link DashboardEntity#DashboardEntity(Dashboard)}.
   *
   * <p>Method under test: {@link DashboardEntity#DashboardEntity(Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardEntity.<init>(Dashboard)"})
  public void testNewDashboardEntity() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    DashboardEntity actualDashboardEntity = new DashboardEntity(dashboard);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualDashboardEntity.getTenantId().toString());
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
   *
   * <p>Method under test: {@link DashboardEntity#DashboardEntity(Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardEntity.<init>(Dashboard)"})
  public void testNewDashboardEntity2() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setAssignedCustomers(new HashSet<>());

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
   *
   * <ul>
   *   <li>Then return AssignedCustomers is a string.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#DashboardEntity(Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardEntity.<init>(Dashboard)"})
  public void testNewDashboardEntity_thenReturnAssignedCustomersIsAString() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    ShortCustomerInfo shortCustomerInfo =
        new ShortCustomerInfo(BaseEntityService.NULL_CUSTOMER_ID, "Dr", true);
    assignedCustomers.add(shortCustomerInfo);

    Dashboard dashboard = new Dashboard();
    dashboard.setAssignedCustomers(assignedCustomers);

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
   *
   * <ul>
   *   <li>Then return AssignedCustomers is a string.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#DashboardEntity(Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardEntity.<init>(Dashboard)"})
  public void testNewDashboardEntity_thenReturnAssignedCustomersIsAString2() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    ShortCustomerInfo shortCustomerInfo =
        new ShortCustomerInfo(BaseEntityService.NULL_CUSTOMER_ID, "Dr", true);
    assignedCustomers.add(shortCustomerInfo);
    ShortCustomerInfo shortCustomerInfo2 =
        new ShortCustomerInfo(BaseEntityService.NULL_CUSTOMER_ID, "Dr", true);
    assignedCustomers.add(shortCustomerInfo2);

    Dashboard dashboard = new Dashboard();
    dashboard.setAssignedCustomers(assignedCustomers);

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
   *
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.
   *   <li>Then return AssignedCustomers is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#DashboardEntity(Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardEntity.<init>(Dashboard)"})
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
   *
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} AssignedCustomers is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardEntity.toData()"})
  public void testToData_givenDashboardEntityAssignedCustomersIs42() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("42");

    // Act
    Dashboard actualToDataResult = dashboardEntity.toData();

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
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isMobileHide());
    assertFalse(id.isNullUid());
  }

  /**
   * Test {@link DashboardEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} AssignedCustomers is {@code Assigned
   *       Customers}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardEntity.toData()"})
  public void testToData_givenDashboardEntityAssignedCustomersIsAssignedCustomers() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");

    // Act
    Dashboard actualToDataResult = dashboardEntity.toData();

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
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isMobileHide());
    assertFalse(id.isNullUid());
  }

  /**
   * Test {@link DashboardEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} AssignedCustomers is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardEntity.toData()"})
  public void testToData_givenDashboardEntityAssignedCustomersIsEmptyString() {
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
    dashboardEntity.setAssignedCustomers("");
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    Dashboard actualToDataResult = dashboardEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    DashboardId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.DASHBOARD, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertEquals(externalId, actualToDataResult.getId());
  }

  /**
   * Test {@link DashboardEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} ExternalId is {@code null}.
   *   <li>Then return Id NullUid.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardEntity.toData()"})
  public void testToData_givenDashboardEntityExternalIdIsNull_thenReturnIdNullUid()
      throws JsonProcessingException {
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

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    dashboardEntity.setAssignedCustomers(jsonMapper.writeValueAsString(new HashSet<>()));
    dashboardEntity.setExternalId(null);

    // Act
    Dashboard actualToDataResult = dashboardEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(actualToDataResult.getAssignedCustomers().isEmpty());
    assertTrue(actualToDataResult.getId().isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link DashboardEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} TenantId is randomUUID.
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardEntity.toData()"})
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
    dashboardEntity.setAssignedCustomers("");
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    Dashboard actualToDataResult = dashboardEntity.toData();

    // Assert
    DashboardId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.DASHBOARD, externalId.getEntityType());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DashboardEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()}.
   *   <li>Then return Configuration is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardEntity.toData()"})
  public void testToData_givenDashboardEntity_thenReturnConfigurationIsNull() {
    // Arrange and Act
    Dashboard actualToDataResult = new DashboardEntity().toData();

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
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isMobileHide());
    assertFalse(id.isNullUid());
  }

  /**
   * Test {@link DashboardEntity#toData()}.
   *
   * <ul>
   *   <li>Then return AssignedCustomers Empty.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardEntity.toData()"})
  public void testToData_thenReturnAssignedCustomersEmpty() throws JsonProcessingException {
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

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    dashboardEntity.setAssignedCustomers(jsonMapper.writeValueAsString(new HashSet<>()));
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    Dashboard actualToDataResult = dashboardEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    DashboardId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.DASHBOARD, externalId.getEntityType());
    assertTrue(actualToDataResult.getAssignedCustomers().isEmpty());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertEquals(externalId, actualToDataResult.getId());
  }
}
