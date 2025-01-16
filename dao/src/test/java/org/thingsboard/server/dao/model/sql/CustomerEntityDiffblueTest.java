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
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ShortCustomerInfo;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class CustomerEntityDiffblueTest {
  /**
   * Test {@link CustomerEntity#equals(Object)}, and
   * {@link CustomerEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerEntity#equals(Object)}
   *   <li>{@link CustomerEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertEquals(customerEntity, customerEntity2);
    int expectedHashCodeResult = customerEntity.hashCode();
    assertEquals(expectedHashCodeResult, customerEntity2.hashCode());
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}, and
   * {@link CustomerEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerEntity#equals(Object)}
   *   <li>{@link CustomerEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    // Act and Assert
    assertEquals(customerEntity, customerEntity);
    int expectedHashCodeResult = customerEntity.hashCode();
    assertEquals(expectedHashCodeResult, customerEntity.hashCode());
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(MissingNode.getInstance());
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(null);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(mock(JsonNode.class));
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("17 High St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress(null);
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("17 High St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2(null);
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("London");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity(null);
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GBR");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry(null);
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(3L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("john.smith@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail(null);
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.randomUUID());
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(null);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("8605550118");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone(null);
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(false);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("Dr");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState(null);
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.randomUUID());
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(null);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Mr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle(null);
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("OX1 1PT");

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip(null);

    CustomerEntity customerEntity2 = new CustomerEntity();
    customerEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity2.setAddress("42 Main St");
    customerEntity2.setAddress2("42 Main St");
    customerEntity2.setCity("Oxford");
    customerEntity2.setCountry("GB");
    customerEntity2.setCreatedTime(1L);
    customerEntity2.setEmail("jane.doe@example.org");
    customerEntity2.setExternalId(ModelConstants.NULL_UUID);
    customerEntity2.setId(ModelConstants.NULL_UUID);
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(ModelConstants.NULL_UUID);
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(ModelConstants.NULL_UUID);
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, null);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, "Different type to CustomerEntity");
  }

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
    actualCustomerEntity.setExternalId(ModelConstants.NULL_UUID);
    actualCustomerEntity.setPhone("6625550144");
    actualCustomerEntity.setPublic(true);
    actualCustomerEntity.setState("MD");
    UUID tenantId = ModelConstants.NULL_UUID;
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

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("21654", actualZip);
    assertEquals("42 Main St", actualAddress);
    assertEquals("42 Main St", actualAddress2);
    assertEquals("6625550144", actualPhone);
    assertEquals("CustomerEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, country=GB, state=MD,"
        + " city=Oxford, address=42 Main St, address2=42 Main St, zip=21654, phone=6625550144, email=jane.doe"
        + "@example.org, isPublic=true, additionalInfo={\"isPublic\":true}, externalId=13814000-1dd2-11b2-8080"
        + "-808080808080)", actualToStringResult);
    assertEquals("Dr", actualTitle);
    assertEquals("GB", actualCountry);
    assertEquals("MD", actualState);
    assertEquals("Oxford", actualCity);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals(0L, actualCustomerEntity.getCreatedTime());
    assertTrue(actualIsPublicResult);
    assertSame(additionalInfo, actualAdditionalInfo);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link CustomerEntity#CustomerEntity(Customer)}.
   * <p>
   * Method under test: {@link CustomerEntity#CustomerEntity(Customer)}
   */
  @Test
  public void testNewCustomerEntity() throws IOException {
    // Arrange
    Customer customer = new Customer();
    customer.setExternalId(BaseEntityService.NULL_CUSTOMER_ID);

    Customer customer2 = new Customer(customer);
    customer2.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    CustomerEntity actualCustomerEntity = new CustomerEntity(customer2);

    // Assert
    JsonNode additionalInfo = actualCustomerEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    UUID externalId = actualCustomerEntity.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(externalId, actualCustomerEntity.getTenantId());
  }

  /**
   * Test {@link CustomerEntity#CustomerEntity(Customer)}.
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#CustomerEntity(Customer)}
   */
  @Test
  public void testNewCustomerEntity_thenAdditionalInfoReturnNullNode() throws IOException {
    // Arrange
    Customer customer = new Customer(new Customer());
    customer.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    CustomerEntity actualCustomerEntity = new CustomerEntity(customer);

    // Assert
    JsonNode additionalInfo = actualCustomerEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualCustomerEntity.getTenantId().toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualCustomerEntity.getExternalId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link CustomerEntity#CustomerEntity(Customer)}.
   * <ul>
   *   <li>Then return AdditionalInfo is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#CustomerEntity(Customer)}
   */
  @Test
  public void testNewCustomerEntity_thenReturnAdditionalInfoIsNull() {
    // Arrange
    Customer customer = new Customer();
    customer.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    CustomerEntity actualCustomerEntity = new CustomerEntity(customer);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualCustomerEntity.getTenantId().toString());
    assertNull(actualCustomerEntity.getAdditionalInfo());
    assertNull(actualCustomerEntity.getVersion());
    assertNull(actualCustomerEntity.getAddress());
    assertNull(actualCustomerEntity.getAddress2());
    assertNull(actualCustomerEntity.getCity());
    assertNull(actualCustomerEntity.getCountry());
    assertNull(actualCustomerEntity.getEmail());
    assertNull(actualCustomerEntity.getPhone());
    assertNull(actualCustomerEntity.getState());
    assertNull(actualCustomerEntity.getTitle());
    assertNull(actualCustomerEntity.getZip());
    assertNull(actualCustomerEntity.getId());
    assertNull(actualCustomerEntity.getUuid());
    assertNull(actualCustomerEntity.getExternalId());
    assertEquals(0L, actualCustomerEntity.getCreatedTime());
    assertFalse(actualCustomerEntity.isPublic());
  }

  /**
   * Test {@link CustomerEntity#toData()}.
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is
   * randomUUID.</li>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#toData()}
   */
  @Test
  public void testToData_givenCustomerEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() throws IOException {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    UUID tenantId = UUID.randomUUID();
    customerEntity.setTenantId(tenantId);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    Customer actualToDataResult = customerEntity.toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("21654", actualToDataResult.getZip());
    assertEquals("42 Main St", actualToDataResult.getAddress());
    assertEquals("42 Main St", actualToDataResult.getAddress2());
    assertEquals("6625550144", actualToDataResult.getPhone());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    ShortCustomerInfo toShortCustomerInfoResult = actualToDataResult.toShortCustomerInfo();
    assertEquals("Dr", toShortCustomerInfoResult.getTitle());
    assertEquals("GB", actualToDataResult.getCountry());
    assertEquals("MD", actualToDataResult.getState());
    assertEquals("Oxford", actualToDataResult.getCity());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("jane.doe@example.org", actualToDataResult.getEmail());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.CUSTOMER, externalId.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(toShortCustomerInfoResult.isPublic());
    assertTrue(externalId.isNullUid());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, actualToDataResult.getId());
    assertSame(uuidId, externalId.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link CustomerEntity#toData()}.
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#toData()}
   */
  @Test
  public void testToData_givenCustomerEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Customer actualToDataResult = (new CustomerEntity()).toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getAddress());
    assertNull(actualToDataResult.getAddress2());
    assertNull(actualToDataResult.getCity());
    assertNull(actualToDataResult.getCountry());
    assertNull(actualToDataResult.getEmail());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getPhone());
    assertNull(actualToDataResult.getState());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getZip());
    ShortCustomerInfo toShortCustomerInfoResult = actualToDataResult.toShortCustomerInfo();
    assertNull(toShortCustomerInfoResult.getTitle());
    assertNull(actualToDataResult.getUuidId());
    CustomerId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getTenantId().getId());
    assertNull(actualToDataResult.getExternalId());
    assertEquals(0, additionalInfo.size());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertEquals(EntityType.CUSTOMER, id.getEntityType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(toShortCustomerInfoResult.isPublic());
    assertFalse(id.isNullUid());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link CustomerEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() throws IOException {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    Customer actualToDataResult = customerEntity.toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("21654", actualToDataResult.getZip());
    assertEquals("42 Main St", actualToDataResult.getAddress());
    assertEquals("42 Main St", actualToDataResult.getAddress2());
    assertEquals("6625550144", actualToDataResult.getPhone());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    ShortCustomerInfo toShortCustomerInfoResult = actualToDataResult.toShortCustomerInfo();
    assertEquals("Dr", toShortCustomerInfoResult.getTitle());
    assertEquals("GB", actualToDataResult.getCountry());
    assertEquals("MD", actualToDataResult.getState());
    assertEquals("Oxford", actualToDataResult.getCity());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("jane.doe@example.org", actualToDataResult.getEmail());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.CUSTOMER, externalId.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(toShortCustomerInfoResult.isPublic());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, actualToDataResult.getId());
    assertSame(uuidId, externalId.getId());
  }
}
