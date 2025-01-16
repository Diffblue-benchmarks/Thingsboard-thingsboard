package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ShortCustomerInfo;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.sql.customer.JpaCustomerDao;

class CustomerImportServiceDiffblueTest {
  /**
   * Test {@link CustomerImportService#deepCopy(Customer)} with {@code Customer}.
   * <p>
   * Method under test: {@link CustomerImportService#deepCopy(Customer)}
   */
  @Test
  @DisplayName("Test deepCopy(Customer) with 'Customer'")
  void testDeepCopyWithCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerService customerService = mock(CustomerService.class);
    CustomerImportService customerImportService = new CustomerImportService(customerService, new JpaCustomerDao());

    // Act
    Customer actualDeepCopyResult = customerImportService.deepCopy(new Customer());

    // Assert
    JsonNode additionalInfo = actualDeepCopyResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualDeepCopyResult.getVersion());
    assertNull(actualDeepCopyResult.getAddress());
    assertNull(actualDeepCopyResult.getAddress2());
    assertNull(actualDeepCopyResult.getCity());
    assertNull(actualDeepCopyResult.getCountry());
    assertNull(actualDeepCopyResult.getEmail());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getPhone());
    assertNull(actualDeepCopyResult.getState());
    assertNull(actualDeepCopyResult.getTitle());
    assertNull(actualDeepCopyResult.getZip());
    ShortCustomerInfo toShortCustomerInfoResult = actualDeepCopyResult.toShortCustomerInfo();
    assertNull(toShortCustomerInfoResult.getTitle());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(toShortCustomerInfoResult.getCustomerId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isMissingNode());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link CustomerImportService#deepCopy(Customer)} with {@code Customer}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then return Zip is {@code 21654}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImportService#deepCopy(Customer)}
   */
  @Test
  @DisplayName("Test deepCopy(Customer) with 'Customer'; given Instance; then return Zip is '21654'")
  void testDeepCopyWithCustomer_givenInstance_thenReturnZipIs21654() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    CustomerImportService customerImportService = new CustomerImportService(customerService, new JpaCustomerDao());
    Customer customer = mock(Customer.class);
    MissingNode instance = MissingNode.getInstance();
    when(customer.getAdditionalInfo()).thenReturn(instance);
    when(customer.getVersion()).thenReturn(1L);
    when(customer.getAddress()).thenReturn("42 Main St");
    when(customer.getAddress2()).thenReturn("42 Main St");
    when(customer.getCity()).thenReturn("Oxford");
    when(customer.getCountry()).thenReturn("GB");
    when(customer.getEmail()).thenReturn("jane.doe@example.org");
    when(customer.getPhone()).thenReturn("6625550144");
    when(customer.getState()).thenReturn("MD");
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getZip()).thenReturn("21654");
    when(customer.getCreatedTime()).thenReturn(1L);
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    when(customer.getExternalId()).thenReturn(customerId);
    UUID id = UUID.randomUUID();
    CustomerId customerId2 = new CustomerId(id);
    when(customer.getId()).thenReturn(customerId2);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    when(customer.getTenantId()).thenReturn(tenantId);

    // Act
    Customer actualDeepCopyResult = customerImportService.deepCopy(customer);

    // Assert
    verify(customer).getAdditionalInfo();
    verify(customer).getAddress();
    verify(customer).getAddress2();
    verify(customer).getCity();
    verify(customer).getCountry();
    verify(customer).getCreatedTime();
    verify(customer).getEmail();
    verify(customer).getExternalId();
    verify(customer).getId();
    verify(customer).getPhone();
    verify(customer).getState();
    verify(customer).getTenantId();
    verify(customer).getTitle();
    verify(customer).getVersion();
    verify(customer).getZip();
    assertEquals("21654", actualDeepCopyResult.getZip());
    assertEquals("42 Main St", actualDeepCopyResult.getAddress());
    assertEquals("42 Main St", actualDeepCopyResult.getAddress2());
    assertEquals("6625550144", actualDeepCopyResult.getPhone());
    assertEquals("Dr", actualDeepCopyResult.getName());
    assertEquals("Dr", actualDeepCopyResult.getTitle());
    ShortCustomerInfo toShortCustomerInfoResult = actualDeepCopyResult.toShortCustomerInfo();
    assertEquals("Dr", toShortCustomerInfoResult.getTitle());
    assertEquals("GB", actualDeepCopyResult.getCountry());
    assertEquals("MD", actualDeepCopyResult.getState());
    assertEquals("Oxford", actualDeepCopyResult.getCity());
    assertEquals("jane.doe@example.org", actualDeepCopyResult.getEmail());
    assertEquals(1L, actualDeepCopyResult.getVersion().longValue());
    assertEquals(1L, actualDeepCopyResult.getCreatedTime());
    assertSame(customerId, actualDeepCopyResult.getExternalId());
    assertSame(customerId2, actualDeepCopyResult.getId());
    assertSame(customerId2, toShortCustomerInfoResult.getCustomerId());
    assertSame(tenantId, actualDeepCopyResult.getTenantId());
    assertSame(instance, actualDeepCopyResult.getAdditionalInfo());
    assertSame(id, actualDeepCopyResult.getUuidId());
  }

  /**
   * Test {@link CustomerImportService#deepCopy(Customer)} with {@code Customer}.
   * <ul>
   *   <li>When {@link Customer#Customer()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImportService#deepCopy(Customer)}
   */
  @Test
  @DisplayName("Test deepCopy(Customer) with 'Customer'; when Customer(); then AdditionalInfo return NullNode")
  void testDeepCopyWithCustomer_whenCustomer_thenAdditionalInfoReturnNullNode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    CustomerImportService customerImportService = new CustomerImportService(customerService, new JpaCustomerDao());

    // Act
    Customer actualDeepCopyResult = customerImportService.deepCopy(new Customer());

    // Assert
    JsonNode additionalInfo = actualDeepCopyResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualDeepCopyResult.getVersion());
    assertNull(actualDeepCopyResult.getAddress());
    assertNull(actualDeepCopyResult.getAddress2());
    assertNull(actualDeepCopyResult.getCity());
    assertNull(actualDeepCopyResult.getCountry());
    assertNull(actualDeepCopyResult.getEmail());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getPhone());
    assertNull(actualDeepCopyResult.getState());
    assertNull(actualDeepCopyResult.getTitle());
    assertNull(actualDeepCopyResult.getZip());
    ShortCustomerInfo toShortCustomerInfoResult = actualDeepCopyResult.toShortCustomerInfo();
    assertNull(toShortCustomerInfoResult.getTitle());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(toShortCustomerInfoResult.getCustomerId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isMissingNode());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link CustomerImportService#getEntityType()}.
   * <p>
   * Method under test: {@link CustomerImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  void testGetEntityType() {
    // Arrange
    CustomerServiceImpl customerService = new CustomerServiceImpl();

    // Act and Assert
    assertEquals(EntityType.CUSTOMER,
        (new CustomerImportService(customerService, new JpaCustomerDao())).getEntityType());
  }
}
