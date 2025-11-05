package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

class CustomerEntityDiffblueTest {
  /**
   * Test {@link CustomerEntity#equals(Object)}, and {@link CustomerEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerEntity#equals(Object)}
   *   <li>{@link CustomerEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertEquals(customerEntity, customerEntity2);
    assertEquals(customerEntity.hashCode(), customerEntity2.hashCode());
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}, and {@link CustomerEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerEntity#equals(Object)}
   *   <li>{@link CustomerEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    // Act and Assert
    assertEquals(customerEntity, customerEntity);
    int expectedHashCodeResult = customerEntity.hashCode();
    assertEquals(expectedHashCodeResult, customerEntity.hashCode());
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(null);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("17 High St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress(null);
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("17 High St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2(null);
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("London");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity(null);
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GBR");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry(null);
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(3L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("john.smith@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail(null);
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
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
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
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
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("8605550118");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone(null);
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(false);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("Dr");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState(null);
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(null);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Mr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle(null);
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    customerEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setPhone("6625550144");
    customerEntity2.setPublic(true);
    customerEntity2.setState("MD");
    customerEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setTitle("Dr");
    customerEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity2.setVersion(1L);
    customerEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, customerEntity2);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, null);
  }

  /**
   * Test {@link CustomerEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerEntity.equals(Object)", "int CustomerEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    // Act and Assert
    assertNotEquals(customerEntity, "Different type to CustomerEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerEntity.<init>()",
    "JsonNode CustomerEntity.getAdditionalInfo()",
    "String CustomerEntity.getAddress()",
    "String CustomerEntity.getAddress2()",
    "String CustomerEntity.getCity()",
    "String CustomerEntity.getCountry()",
    "String CustomerEntity.getEmail()",
    "UUID CustomerEntity.getExternalId()",
    "String CustomerEntity.getPhone()",
    "String CustomerEntity.getState()",
    "UUID CustomerEntity.getTenantId()",
    "String CustomerEntity.getTitle()",
    "String CustomerEntity.getZip()",
    "boolean CustomerEntity.isPublic()",
    "void CustomerEntity.setAdditionalInfo(JsonNode)",
    "void CustomerEntity.setAddress(String)",
    "void CustomerEntity.setAddress2(String)",
    "void CustomerEntity.setCity(String)",
    "void CustomerEntity.setCountry(String)",
    "void CustomerEntity.setEmail(String)",
    "void CustomerEntity.setExternalId(UUID)",
    "void CustomerEntity.setPhone(String)",
    "void CustomerEntity.setPublic(boolean)",
    "void CustomerEntity.setState(String)",
    "void CustomerEntity.setTenantId(UUID)",
    "void CustomerEntity.setTitle(String)",
    "void CustomerEntity.setZip(String)",
    "String CustomerEntity.toString()"
  })
  void testGettersAndSetters() {
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
    assertEquals(
        "CustomerEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, title=Dr, country=GB, state=MD,"
            + " city=Oxford, address=42 Main St, address2=42 Main St, zip=21654, phone=6625550144, email=jane.doe"
            + "@example.org, isPublic=true, additionalInfo={\"isPublic\":true}, externalId=784f394c-42b6-435a-983c"
            + "-b7beff2784f9)",
        actualToStringResult);
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

  /**
   * Test {@link CustomerEntity#CustomerEntity(Customer)}.
   *
   * <p>Method under test: {@link CustomerEntity#CustomerEntity(Customer)}
   */
  @Test
  @DisplayName("Test new CustomerEntity(Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerEntity.<init>(Customer)"})
  void testNewCustomerEntity() {
    // Arrange
    Customer customer = new Customer();
    customer.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    CustomerEntity actualCustomerEntity = new CustomerEntity(customer);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualCustomerEntity.getTenantId().toString());
    assertNull(actualCustomerEntity.getAdditionalInfo());
    assertNull(actualCustomerEntity.getId());
    assertNull(actualCustomerEntity.getUuid());
    assertNull(actualCustomerEntity.getExternalId());
  }

  /**
   * Test {@link CustomerEntity#CustomerEntity(Customer)}.
   *
   * <p>Method under test: {@link CustomerEntity#CustomerEntity(Customer)}
   */
  @Test
  @DisplayName("Test new CustomerEntity(Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerEntity.<init>(Customer)"})
  void testNewCustomerEntity2() {
    // Arrange
    Customer customer = new Customer(BaseEntityService.NULL_CUSTOMER_ID);
    customer.setExternalId(BaseEntityService.NULL_CUSTOMER_ID);
    customer.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    CustomerEntity actualCustomerEntity = new CustomerEntity(customer);

    // Assert
    UUID externalId = actualCustomerEntity.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.toString());
    assertSame(externalId, actualCustomerEntity.getId());
    assertSame(externalId, actualCustomerEntity.getUuid());
    assertSame(externalId, actualCustomerEntity.getTenantId());
  }

  /**
   * Test {@link CustomerEntity#CustomerEntity(Customer)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#CustomerEntity(Customer)}
   */
  @Test
  @DisplayName("Test new CustomerEntity(Customer); then AdditionalInfo return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerEntity.<init>(Customer)"})
  void testNewCustomerEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange
    Customer customer = new Customer(new Customer());
    customer.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertTrue(new CustomerEntity(customer).getAdditionalInfo() instanceof NullNode);
  }

  /**
   * Test {@link CustomerEntity#toData()}.
   *
   * <p>Method under test: {@link CustomerEntity#toData()}
   */
  @Test
  @DisplayName("Test toData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerEntity.toData()"})
  void testToData() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setTitle("Dr");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    customerEntity.setUuid(id);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Customer actualToDataResult = customerEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("21654", actualToDataResult.getZip());
    assertEquals("42 Main St", actualToDataResult.getAddress());
    assertEquals("42 Main St", actualToDataResult.getAddress2());
    assertEquals("6625550144", actualToDataResult.getPhone());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("GB", actualToDataResult.getCountry());
    assertEquals("MD", actualToDataResult.getState());
    assertEquals("Oxford", actualToDataResult.getCity());
    assertEquals("jane.doe@example.org", actualToDataResult.getEmail());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link CustomerEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given CustomerEntity() TenantId is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerEntity.toData()"})
  void testToData_givenCustomerEntityTenantIdIsRandomUUID() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.randomUUID());
    customerEntity.setTitle("Dr");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    customerEntity.setUuid(id);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    customerEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Customer actualToDataResult = customerEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("21654", actualToDataResult.getZip());
    assertEquals("42 Main St", actualToDataResult.getAddress());
    assertEquals("42 Main St", actualToDataResult.getAddress2());
    assertEquals("6625550144", actualToDataResult.getPhone());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("GB", actualToDataResult.getCountry());
    assertEquals("MD", actualToDataResult.getState());
    assertEquals("Oxford", actualToDataResult.getCity());
    assertEquals("jane.doe@example.org", actualToDataResult.getEmail());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link CustomerEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given CustomerEntity(); then AdditionalInfo return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerEntity.toData()"})
  void testToData_givenCustomerEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Customer actualToDataResult = new CustomerEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
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
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getExternalId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }
}
