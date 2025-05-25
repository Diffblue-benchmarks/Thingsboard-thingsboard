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

public class CustomerEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerEntity#CustomerEntity()}
   *   <li>{@link CustomerEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link CustomerEntity#setAddress2(String)}
   *   <li>{@link CustomerEntity#setAddress(String)}
   *   <li>{@link CustomerEntity#setCity(String)}
   *   <li>{@link CustomerEntity#setCountry(String)}
   *   <li>{@link CustomerEntity#setEmail(String)}
   *   <li>{@link CustomerEntity#setExternalId(UUID)}
   *   <li>{@link CustomerEntity#setPhone(String)}
   *   <li>{@link CustomerEntity#setPublic(boolean)}
   *   <li>{@link CustomerEntity#setState(String)}
   *   <li>{@link CustomerEntity#setTenantId(UUID)}
   *   <li>{@link CustomerEntity#setTitle(String)}
   *   <li>{@link CustomerEntity#setZip(String)}
   *   <li>{@link CustomerEntity#toString()}
   *   <li>{@link CustomerEntity#getAdditionalInfo()}
   *   <li>{@link CustomerEntity#getAddress()}
   *   <li>{@link CustomerEntity#getAddress2()}
   *   <li>{@link CustomerEntity#getCity()}
   *   <li>{@link CustomerEntity#getCountry()}
   *   <li>{@link CustomerEntity#getEmail()}
   *   <li>{@link CustomerEntity#getExternalId()}
   *   <li>{@link CustomerEntity#getPhone()}
   *   <li>{@link CustomerEntity#getState()}
   *   <li>{@link CustomerEntity#getTenantId()}
   *   <li>{@link CustomerEntity#getTitle()}
   *   <li>{@link CustomerEntity#getZip()}
   *   <li>{@link CustomerEntity#isPublic()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerEntity.<init>()", "JsonNode CustomerEntity.getAdditionalInfo()",
      "String CustomerEntity.getAddress()", "String CustomerEntity.getAddress2()", "String CustomerEntity.getCity()",
      "String CustomerEntity.getCountry()", "String CustomerEntity.getEmail()", "UUID CustomerEntity.getExternalId()",
      "String CustomerEntity.getPhone()", "String CustomerEntity.getState()", "UUID CustomerEntity.getTenantId()",
      "String CustomerEntity.getTitle()", "String CustomerEntity.getZip()", "boolean CustomerEntity.isPublic()",
      "void CustomerEntity.setAdditionalInfo(JsonNode)", "void CustomerEntity.setAddress(String)",
      "void CustomerEntity.setAddress2(String)", "void CustomerEntity.setCity(String)",
      "void CustomerEntity.setCountry(String)", "void CustomerEntity.setEmail(String)",
      "void CustomerEntity.setExternalId(UUID)", "void CustomerEntity.setPhone(String)",
      "void CustomerEntity.setPublic(boolean)", "void CustomerEntity.setState(String)",
      "void CustomerEntity.setTenantId(UUID)", "void CustomerEntity.setTitle(String)",
      "void CustomerEntity.setZip(String)", "String CustomerEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerEntity actualCustomerEntity = new CustomerEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualCustomerEntity.setAdditionalInfo(additionalInfo);
    actualCustomerEntity.setAddress2("42 Main St");
    actualCustomerEntity.setAddress("42 Main St");
    actualCustomerEntity.setCity("Oxford");
    actualCustomerEntity.setCountry("GB");
    actualCustomerEntity.setEmail("jane.doe@example.org");
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualCustomerEntity.setExternalId(externalId);
    actualCustomerEntity.setPhone("6625550144");
    actualCustomerEntity.setPublic(true);
    actualCustomerEntity.setState("MD");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualCustomerEntity.setTenantId(tenantId);
    actualCustomerEntity.setTitle("Dr");
    actualCustomerEntity.setZip("21654");
    String actualToStringResult = actualCustomerEntity.toString();
    JsonNode actualAdditionalInfo = actualCustomerEntity.getAdditionalInfo();
    String actualAddress = actualCustomerEntity.getAddress();
    String actualAddress2 = actualCustomerEntity.getAddress2();
    String actualCity = actualCustomerEntity.getCity();
    String actualCountry = actualCustomerEntity.getCountry();
    String actualEmail = actualCustomerEntity.getEmail();
    UUID actualExternalId = actualCustomerEntity.getExternalId();
    String actualPhone = actualCustomerEntity.getPhone();
    String actualState = actualCustomerEntity.getState();
    UUID actualTenantId = actualCustomerEntity.getTenantId();
    String actualTitle = actualCustomerEntity.getTitle();
    String actualZip = actualCustomerEntity.getZip();
    boolean actualIsPublicResult = actualCustomerEntity.isPublic();

    // Assert
    assertEquals("21654", actualZip);
    assertEquals("42 Main St", actualAddress);
    assertEquals("42 Main St", actualAddress2);
    assertEquals("6625550144", actualPhone);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("CustomerEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, title=Dr, country=GB, state=MD,"
        + " city=Oxford, address=42 Main St, address2=42 Main St, zip=21654, phone=6625550144, email=jane.doe"
        + "@example.org, isPublic=true, additionalInfo={\"isPublic\":true}, externalId=784f394c-42b6-435a-983c"
        + "-b7beff2784f9)", actualToStringResult);
    assertEquals("Dr", actualTitle);
    assertEquals("GB", actualCountry);
    assertEquals("MD", actualState);
    assertEquals("Oxford", actualCity);
    assertEquals("jane.doe@example.org", actualEmail);
    assertNull(actualCustomerEntity.getVersion());
    assertNull(actualCustomerEntity.getId());
    assertNull(actualCustomerEntity.getUuid());
    assertEquals(0L, actualCustomerEntity.getCreatedTime());
    assertTrue(actualIsPublicResult);
    assertSame(externalId, actualExternalId);
    assertSame(tenantId, actualTenantId);
    assertSame(additionalInfo, actualAdditionalInfo);
  }
}
