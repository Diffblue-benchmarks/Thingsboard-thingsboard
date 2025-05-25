package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.sql.customer.JpaCustomerDao;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

@ExtendWith(MockitoExtension.class)
class CustomerImportServiceDiffblueTest {
  @InjectMocks
  private CustomerImportService customerImportService;

  /**
   * Test {@link CustomerImportService#setOwner(TenantId, Customer, IdProvider)}.
   * <p>
   * Method under test: {@link CustomerImportService#setOwner(TenantId, Customer, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, Customer, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerImportService.setOwner(TenantId, Customer, IdProvider)"})
  void testSetOwner() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Customer customer = new Customer();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    customerImportService.setOwner(tenantId, customer,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, customer.getTenantId());
  }

  /**
   * Test {@link CustomerImportService#setOwner(TenantId, Customer, IdProvider)}.
   * <ul>
   *   <li>When {@link Customer} {@link Customer#setTenantId(TenantId)} does nothing.</li>
   *   <li>Then calls {@link Customer#setTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImportService#setOwner(TenantId, Customer, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, Customer, IdProvider); when Customer setTenantId(TenantId) does nothing; then calls setTenantId(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerImportService.setOwner(TenantId, Customer, IdProvider)"})
  void testSetOwner_whenCustomerSetTenantIdDoesNothing_thenCallsSetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Customer customer = mock(Customer.class);
    doNothing().when(customer).setTenantId(Mockito.<TenantId>any());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    customerImportService.setOwner(tenantId, customer,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    verify(customer).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link CustomerImportService#prepare(EntitiesImportCtx, Customer, Customer, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Then return {@link Customer#Customer()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImportService#prepare(EntitiesImportCtx, Customer, Customer, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Customer, Customer, EntityExportData, IdProvider); then return Customer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Customer CustomerImportService.prepare(EntitiesImportCtx, Customer, Customer, EntityExportData, IdProvider)"})
  void testPrepare_thenReturnCustomer() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    Customer customer = new Customer();
    Customer old = new Customer();
    EntityExportData<Customer> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertSame(customer, customerImportService.prepare(ctx, customer, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test {@link CustomerImportService#prepare(EntitiesImportCtx, Customer, Customer, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Then return {@link Customer#Customer(Customer)} with customer is {@link Customer#Customer()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImportService#prepare(EntitiesImportCtx, Customer, Customer, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Customer, Customer, EntityExportData, IdProvider); then return Customer(Customer) with customer is Customer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Customer CustomerImportService.prepare(EntitiesImportCtx, Customer, Customer, EntityExportData, IdProvider)"})
  void testPrepare_thenReturnCustomerWithCustomerIsCustomer() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    Customer customer = new Customer(new Customer());
    Customer old = new Customer();
    EntityExportData<Customer> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertSame(customer, customerImportService.prepare(ctx, customer, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test {@link CustomerImportService#deepCopy(Customer)} with {@code Customer}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then AdditionalInfo return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImportService#deepCopy(Customer)}
   */
  @Test
  @DisplayName("Test deepCopy(Customer) with 'Customer'; given Instance; then AdditionalInfo return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Customer CustomerImportService.deepCopy(Customer)"})
  void testDeepCopyWithCustomer_givenInstance_thenAdditionalInfoReturnMissingNode() {
    // Arrange
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
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(customer.getExternalId()).thenReturn(customerId);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    CustomerId customerId2 = new CustomerId(id);
    when(customer.getId()).thenReturn(customerId2);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    JsonNode additionalInfo = actualDeepCopyResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof MissingNode);
    assertEquals("21654", actualDeepCopyResult.getZip());
    assertEquals("42 Main St", actualDeepCopyResult.getAddress());
    assertEquals("42 Main St", actualDeepCopyResult.getAddress2());
    assertEquals("6625550144", actualDeepCopyResult.getPhone());
    assertEquals("Dr", actualDeepCopyResult.getName());
    assertEquals("Dr", actualDeepCopyResult.getTitle());
    assertEquals("GB", actualDeepCopyResult.getCountry());
    assertEquals("MD", actualDeepCopyResult.getState());
    assertEquals("Oxford", actualDeepCopyResult.getCity());
    assertEquals("jane.doe@example.org", actualDeepCopyResult.getEmail());
    assertEquals(1L, actualDeepCopyResult.getVersion().longValue());
    assertEquals(1L, actualDeepCopyResult.getCreatedTime());
    assertSame(customerId, actualDeepCopyResult.getExternalId());
    assertSame(customerId2, actualDeepCopyResult.getId());
    assertSame(tenantId, actualDeepCopyResult.getTenantId());
    assertSame(instance, additionalInfo);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Customer CustomerImportService.deepCopy(Customer)"})
  void testDeepCopyWithCustomer_whenCustomer_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Customer actualDeepCopyResult = customerImportService.deepCopy(new Customer());

    // Assert
    assertTrue(actualDeepCopyResult.getAdditionalInfo() instanceof NullNode);
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
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
  }

  /**
   * Test {@link CustomerImportService#getEntityType()}.
   * <p>
   * Method under test: {@link CustomerImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType CustomerImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange
    CustomerServiceImpl customerService = new CustomerServiceImpl();

    // Act and Assert
    assertEquals(EntityType.CUSTOMER,
        (new CustomerImportService(customerService, new JpaCustomerDao())).getEntityType());
  }
}
