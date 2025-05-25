package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class DashboardEntityDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DashboardEntity.<init>()", "String DashboardEntity.getAssignedCustomers()",
      "JsonNode DashboardEntity.getConfiguration()", "UUID DashboardEntity.getExternalId()",
      "String DashboardEntity.getImage()", "Integer DashboardEntity.getMobileOrder()",
      "UUID DashboardEntity.getTenantId()", "String DashboardEntity.getTitle()",
      "boolean DashboardEntity.isMobileHide()", "void DashboardEntity.setAssignedCustomers(String)",
      "void DashboardEntity.setConfiguration(JsonNode)", "void DashboardEntity.setExternalId(UUID)",
      "void DashboardEntity.setImage(String)", "void DashboardEntity.setMobileHide(boolean)",
      "void DashboardEntity.setMobileOrder(Integer)", "void DashboardEntity.setTenantId(UUID)",
      "void DashboardEntity.setTitle(String)", "String DashboardEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    DashboardEntity actualDashboardEntity = new DashboardEntity();
    actualDashboardEntity.setAssignedCustomers("Assigned Customers");
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualDashboardEntity.setConfiguration(configuration);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDashboardEntity.setExternalId(externalId);
    actualDashboardEntity.setImage("Image");
    actualDashboardEntity.setMobileHide(true);
    actualDashboardEntity.setMobileOrder(1);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Assigned Customers", actualAssignedCustomers);
    assertEquals(
        "DashboardEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, title=Dr, image=Image, assignedCustomers"
            + "=Assigned Customers, mobileHide=true, mobileOrder=1, configuration={\"isPublic\":true}, externalId"
            + "=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertEquals("Dr", actualTitle);
    assertEquals("Image", actualImage);
    assertNull(actualDashboardEntity.getVersion());
    assertNull(actualDashboardEntity.getId());
    assertNull(actualDashboardEntity.getUuid());
    assertEquals(0L, actualDashboardEntity.getCreatedTime());
    assertEquals(1, actualMobileOrder.intValue());
    assertTrue(actualIsMobileHideResult);
    assertSame(externalId, actualExternalId);
    assertSame(tenantId, actualTenantId);
    assertSame(configuration, actualConfiguration);
  }
}
