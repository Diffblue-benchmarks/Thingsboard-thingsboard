package org.thingsboard.server.dao.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.cache.customer.CustomerCacheEvictEvent;
import org.thingsboard.server.cache.customer.CustomerCacheKey;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.asset.AssetService;
import org.thingsboard.server.dao.dashboard.DashboardService;
import org.thingsboard.server.dao.device.DeviceService;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityCountService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.usagerecord.ApiUsageStateService;
import org.thingsboard.server.dao.user.UserService;

@ContextConfiguration(classes = {CustomerServiceImpl.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class CustomerServiceImplDiffblueTest {
  @MockBean private ApiUsageStateService apiUsageStateService;

  @MockBean private AssetService assetService;

  @MockBean private CleanUpService cleanUpService;

  @MockBean private CustomerDao customerDao;

  @Autowired private CustomerServiceImpl customerServiceImpl;

  @MockBean private DashboardService dashboardService;

  @MockBean private DataValidator<Customer> dataValidator;

  @MockBean private DeviceService deviceService;

  @MockBean private EdgeService edgeService;

  @MockBean private EntityCountService entityCountService;

  @MockBean private EntityViewService entityViewService;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TbTransactionalCache<CustomerCacheKey, Customer> tbTransactionalCache;

  @MockBean private UserService userService;

  /**
   * Test {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)} with {@code
   * CustomerCacheEvictEvent}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)}
   */
  @Test
  @DisplayName("Test handleEvictEvent(CustomerCacheEvictEvent) with 'CustomerCacheEvictEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.handleEvictEvent(CustomerCacheEvictEvent)"})
  void testHandleEvictEventWithCustomerCacheEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    CustomerCacheEvictEvent event =
        new CustomerCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "Dr", "Dr");

    // Act
    customerServiceImpl.handleEvictEvent(event);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)} with {@code
   * CustomerCacheEvictEvent}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)}
   */
  @Test
  @DisplayName("Test handleEvictEvent(CustomerCacheEvictEvent) with 'CustomerCacheEvictEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.handleEvictEvent(CustomerCacheEvictEvent)"})
  void testHandleEvictEventWithCustomerCacheEvictEvent2() {
    // Arrange
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<CustomerCacheKey>>any());
    CustomerCacheEvictEvent event =
        new CustomerCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "Dr", "Dr");

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class, () -> customerServiceImpl.handleEvictEvent(event));
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)} with {@code
   * CustomerCacheEvictEvent}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)}
   */
  @Test
  @DisplayName("Test handleEvictEvent(CustomerCacheEvictEvent) with 'CustomerCacheEvictEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.handleEvictEvent(CustomerCacheEvictEvent)"})
  void testHandleEvictEventWithCustomerCacheEvictEvent3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    CustomerCacheEvictEvent event =
        new CustomerCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "Mr", "Dr");

    // Act
    customerServiceImpl.handleEvictEvent(event);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)} with {@code
   * CustomerCacheEvictEvent}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)}
   */
  @Test
  @DisplayName("Test handleEvictEvent(CustomerCacheEvictEvent) with 'CustomerCacheEvictEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.handleEvictEvent(CustomerCacheEvictEvent)"})
  void testHandleEvictEventWithCustomerCacheEvictEvent4() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    CustomerCacheEvictEvent event =
        new CustomerCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "Dr", "");

    // Act
    customerServiceImpl.handleEvictEvent(event);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)} with {@code
   * CustomerCacheEvictEvent}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)}
   */
  @Test
  @DisplayName("Test handleEvictEvent(CustomerCacheEvictEvent) with 'CustomerCacheEvictEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.handleEvictEvent(CustomerCacheEvictEvent)"})
  void testHandleEvictEventWithCustomerCacheEvictEvent5() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    CustomerCacheEvictEvent event =
        new CustomerCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "Dr", null);

    // Act
    customerServiceImpl.handleEvictEvent(event);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerById(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomerById(TenantId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test findCustomerById(TenantId, CustomerId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.findCustomerById(TenantId, CustomerId)"})
  void testFindCustomerById_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    Customer customer = new Customer();
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Customer actualFindCustomerByIdResult =
        customerServiceImpl.findCustomerById(ModelConstants.SYSTEM_TENANT, customerId);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(customer, actualFindCustomerByIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerById(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomerById(TenantId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test findCustomerById(TenantId, CustomerId); then throw IncorrectParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.findCustomerById(TenantId, CustomerId)"})
  void testFindCustomerById_thenThrowIncorrectParameterException() {
    // Arrange
    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.findCustomerById(ModelConstants.SYSTEM_TENANT, customerId));
    verify(customerId).getId();
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerById(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomerById(TenantId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test findCustomerById(TenantId, CustomerId); when NULL_CUSTOMER_ID; then return Customer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.findCustomerById(TenantId, CustomerId)"})
  void testFindCustomerById_whenNull_customer_id_thenReturnCustomer() {
    // Arrange
    Customer customer = new Customer();
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    // Act
    Customer actualFindCustomerByIdResult =
        customerServiceImpl.findCustomerById(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(customer, actualFindCustomerByIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerByTenantIdAndTitle(TenantId, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomerByTenantIdAndTitle(TenantId,
   * String)}
   */
  @Test
  @DisplayName("Test findCustomerByTenantIdAndTitle(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional CustomerServiceImpl.findCustomerByTenantIdAndTitle(TenantId, String)"
  })
  void testFindCustomerByTenantIdAndTitle() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<CustomerCacheKey>any(), Mockito.<Supplier<Customer>>any(), anyBoolean()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            customerServiceImpl.findCustomerByTenantIdAndTitle(ModelConstants.SYSTEM_TENANT, "Dr"));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(CustomerCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerByTenantIdAndTitle(TenantId, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomerByTenantIdAndTitle(TenantId,
   * String)}
   */
  @Test
  @DisplayName("Test findCustomerByTenantIdAndTitle(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional CustomerServiceImpl.findCustomerByTenantIdAndTitle(TenantId, String)"
  })
  void testFindCustomerByTenantIdAndTitle2() {
    // Arrange
    Customer customer = new Customer();
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<CustomerCacheKey>any(), Mockito.<Supplier<Customer>>any(), anyBoolean()))
        .thenReturn(customer);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Optional<Customer> actualFindCustomerByTenantIdAndTitleResult =
        customerServiceImpl.findCustomerByTenantIdAndTitle(tenantId, "Dr");

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(CustomerCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantId).getId();
    assertTrue(actualFindCustomerByTenantIdAndTitleResult.isPresent());
    assertSame(customer, actualFindCustomerByTenantIdAndTitleResult.get());
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerByTenantIdAndTitle(TenantId, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomerByTenantIdAndTitle(TenantId,
   * String)}
   */
  @Test
  @DisplayName("Test findCustomerByTenantIdAndTitle(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional CustomerServiceImpl.findCustomerByTenantIdAndTitle(TenantId, String)"
  })
  void testFindCustomerByTenantIdAndTitle3() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.findCustomerByTenantIdAndTitle(tenantId, "Dr"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerByTenantIdAndTitle(TenantId, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomerByTenantIdAndTitle(TenantId,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findCustomerByTenantIdAndTitle(TenantId, String); when SYSTEM_TENANT; then return Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional CustomerServiceImpl.findCustomerByTenantIdAndTitle(TenantId, String)"
  })
  void testFindCustomerByTenantIdAndTitle_whenSystem_tenant_thenReturnPresent() {
    // Arrange
    Customer customer = new Customer();
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<CustomerCacheKey>any(), Mockito.<Supplier<Customer>>any(), anyBoolean()))
        .thenReturn(customer);

    // Act
    Optional<Customer> actualFindCustomerByTenantIdAndTitleResult =
        customerServiceImpl.findCustomerByTenantIdAndTitle(ModelConstants.SYSTEM_TENANT, "Dr");

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(CustomerCacheKey.class), isA(Supplier.class), eq(true));
    assertTrue(actualFindCustomerByTenantIdAndTitleResult.isPresent());
    assertSame(customer, actualFindCustomerByTenantIdAndTitleResult.get());
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerByTenantIdAndTitleAsync(TenantId, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomerByTenantIdAndTitleAsync(TenantId,
   * String)}
   */
  @Test
  @DisplayName("Test findCustomerByTenantIdAndTitleAsync(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CustomerServiceImpl.findCustomerByTenantIdAndTitleAsync(TenantId, String)"
  })
  void testFindCustomerByTenantIdAndTitleAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Optional<Customer>> actualFindCustomerByTenantIdAndTitleAsyncResult =
        customerServiceImpl.findCustomerByTenantIdAndTitleAsync(tenantId, "Dr");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(tenantId).getId();
    assertTrue(actualFindCustomerByTenantIdAndTitleAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindCustomerByTenantIdAndTitleAsyncResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerByTenantIdAndTitleAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomerByTenantIdAndTitleAsync(TenantId,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findCustomerByTenantIdAndTitleAsync(TenantId, String); then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CustomerServiceImpl.findCustomerByTenantIdAndTitleAsync(TenantId, String)"
  })
  void testFindCustomerByTenantIdAndTitleAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Optional<Customer>> actualFindCustomerByTenantIdAndTitleAsyncResult =
        customerServiceImpl.findCustomerByTenantIdAndTitleAsync(ModelConstants.SYSTEM_TENANT, "Dr");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindCustomerByTenantIdAndTitleAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindCustomerByTenantIdAndTitleAsyncResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerByTenantIdAndTitleAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomerByTenantIdAndTitleAsync(TenantId,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findCustomerByTenantIdAndTitleAsync(TenantId, String); then throw IncorrectParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CustomerServiceImpl.findCustomerByTenantIdAndTitleAsync(TenantId, String)"
  })
  void testFindCustomerByTenantIdAndTitleAsync_thenThrowIncorrectParameterException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.findCustomerByTenantIdAndTitleAsync(tenantId, "Dr"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerByIdAsync(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomerByIdAsync(TenantId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test findCustomerByIdAsync(TenantId, CustomerId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CustomerServiceImpl.findCustomerByIdAsync(TenantId, CustomerId)"
  })
  void testFindCustomerByIdAsync_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    SettableFuture<Customer> createResult = SettableFuture.create();
    when(customerDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Customer> actualFindCustomerByIdAsyncResult =
        customerServiceImpl.findCustomerByIdAsync(ModelConstants.SYSTEM_TENANT, customerId);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(customerDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindCustomerByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindCustomerByIdAsyncResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerByIdAsync(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomerByIdAsync(TenantId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test findCustomerByIdAsync(TenantId, CustomerId); then throw IncorrectParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CustomerServiceImpl.findCustomerByIdAsync(TenantId, CustomerId)"
  })
  void testFindCustomerByIdAsync_thenThrowIncorrectParameterException() {
    // Arrange
    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.findCustomerByIdAsync(ModelConstants.SYSTEM_TENANT, customerId));
    verify(customerId).getId();
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerByIdAsync(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomerByIdAsync(TenantId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test findCustomerByIdAsync(TenantId, CustomerId); when NULL_CUSTOMER_ID; then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CustomerServiceImpl.findCustomerByIdAsync(TenantId, CustomerId)"
  })
  void testFindCustomerByIdAsync_whenNull_customer_id_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Customer> createResult = SettableFuture.create();
    when(customerDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Customer> actualFindCustomerByIdAsyncResult =
        customerServiceImpl.findCustomerByIdAsync(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customerDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindCustomerByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindCustomerByIdAsyncResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @DisplayName("Test saveCustomer(Customer) with 'customer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  void testSaveCustomerWithCustomer() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class, () -> customerServiceImpl.saveCustomer(new Customer()));
    verify(dataValidator).validate(isA(Customer.class), isA(Function.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @DisplayName("Test saveCustomer(Customer) with 'customer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  void testSaveCustomerWithCustomer2() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(dataValidator.validate(
            Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class, () -> customerServiceImpl.saveCustomer(new Customer()));
    verify(customer).getTitle();
    verify(dataValidator).validate(isA(Customer.class), isA(Function.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @DisplayName("Test saveCustomer(Customer) with 'customer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  void testSaveCustomerWithCustomer3() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(true);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any()))
        .thenReturn(customer);

    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn("Dr");
    when(dataValidator.validate(
            Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer2);
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<CustomerCacheKey>>any());

    Customer customer3 = mock(Customer.class);
    when(customer3.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer3.getTitle()).thenReturn("Dr");
    when(customer3.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class, () -> customerServiceImpl.saveCustomer(customer3));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(Collection.class));
    verify(customer3).getId();
    verify(customer3, atLeast(1)).getTenantId();
    verify(customer2).getTitle();
    verify(customer3).getTitle();
    verify(customer).isPublic();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(dataValidator).validate(isA(Customer.class), isA(Function.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Given {@link Customer} {@link Customer#getTitle()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @DisplayName(
      "Test saveCustomer(Customer) with 'customer'; given Customer getTitle() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  void testSaveCustomerWithCustomer_givenCustomerGetTitleReturnEmptyString() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(true);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any()))
        .thenReturn(customer);

    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn("");
    when(dataValidator.validate(
            Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    Customer customer3 = mock(Customer.class);
    when(customer3.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer3.getTitle()).thenReturn("Dr");
    when(customer3.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    customerServiceImpl.saveCustomer(customer3);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer).getId();
    verify(customer3, atLeast(1)).getId();
    verify(customer).getTenantId();
    verify(customer3, atLeast(1)).getTenantId();
    verify(customer2).getTitle();
    verify(customer3).getTitle();
    verify(customer).isPublic();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(dataValidator).validate(isA(Customer.class), isA(Function.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Given {@link Customer} {@link Customer#getTitle()} return {@code Executing saveCustomer
   *       [{}]}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @DisplayName(
      "Test saveCustomer(Customer) with 'customer'; given Customer getTitle() return 'Executing saveCustomer [{}]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  void testSaveCustomerWithCustomer_givenCustomerGetTitleReturnExecutingSaveCustomer() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(true);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any()))
        .thenReturn(customer);

    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn("Executing saveCustomer [{}]");
    when(dataValidator.validate(
            Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    Customer customer3 = mock(Customer.class);
    when(customer3.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer3.getTitle()).thenReturn("Dr");
    when(customer3.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    customerServiceImpl.saveCustomer(customer3);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer).getId();
    verify(customer3, atLeast(1)).getId();
    verify(customer).getTenantId();
    verify(customer3, atLeast(1)).getTenantId();
    verify(customer2).getTitle();
    verify(customer3).getTitle();
    verify(customer).isPublic();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(dataValidator).validate(isA(Customer.class), isA(Function.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Given {@link Customer} {@link Customer#getTitle()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @DisplayName(
      "Test saveCustomer(Customer) with 'customer'; given Customer getTitle() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  void testSaveCustomerWithCustomer_givenCustomerGetTitleReturnNull() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(true);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any()))
        .thenReturn(customer);

    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn(null);
    when(dataValidator.validate(
            Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    Customer customer3 = mock(Customer.class);
    when(customer3.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer3.getTitle()).thenReturn("Dr");
    when(customer3.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    customerServiceImpl.saveCustomer(customer3);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer).getId();
    verify(customer3, atLeast(1)).getId();
    verify(customer).getTenantId();
    verify(customer3, atLeast(1)).getTenantId();
    verify(customer2).getTitle();
    verify(customer3).getTitle();
    verify(customer).isPublic();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(dataValidator).validate(isA(Customer.class), isA(Function.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then calls {@link EntityCountService#publishCountEntityEvictEvent(TenantId, EntityType)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @DisplayName(
      "Test saveCustomer(Customer) with 'customer'; given 'null'; then calls publishCountEntityEvictEvent(TenantId, EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  void testSaveCustomerWithCustomer_givenNull_thenCallsPublishCountEntityEvictEvent() {
    // Arrange
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(true);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any()))
        .thenReturn(customer);

    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn("Dr");
    when(dataValidator.validate(
            Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    Customer customer3 = mock(Customer.class);
    when(customer3.getId()).thenReturn(null);
    when(customer3.getTitle()).thenReturn("Dr");
    when(customer3.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    customerServiceImpl.saveCustomer(customer3);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer).getId();
    verify(customer3, atLeast(1)).getId();
    verify(customer, atLeast(1)).getTenantId();
    verify(customer3, atLeast(1)).getTenantId();
    verify(customer2).getTitle();
    verify(customer3).getTitle();
    verify(customer).isPublic();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(dataValidator).validate(isA(Customer.class), isA(Function.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache} {@link TbTransactionalCache#evict(Collection)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @DisplayName(
      "Test saveCustomer(Customer) with 'customer'; given TbTransactionalCache evict(Collection) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  void testSaveCustomerWithCustomer_givenTbTransactionalCacheEvictDoesNothing() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(true);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any()))
        .thenReturn(customer);

    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn("Dr");
    when(dataValidator.validate(
            Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    Customer customer3 = mock(Customer.class);
    when(customer3.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer3.getTitle()).thenReturn("Dr");
    when(customer3.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    customerServiceImpl.saveCustomer(customer3);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer).getId();
    verify(customer3, atLeast(1)).getId();
    verify(customer).getTenantId();
    verify(customer3, atLeast(1)).getTenantId();
    verify(customer2).getTitle();
    verify(customer3).getTitle();
    verify(customer).isPublic();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(dataValidator).validate(isA(Customer.class), isA(Function.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Then calls {@link DashboardService#updateCustomerDashboards(TenantId, CustomerId)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @DisplayName(
      "Test saveCustomer(Customer) with 'customer'; then calls updateCustomerDashboards(TenantId, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  void testSaveCustomerWithCustomer_thenCallsUpdateCustomerDashboards() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(false);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any()))
        .thenReturn(customer);

    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn("Dr");
    when(dataValidator.validate(
            Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer2);
    doNothing()
        .when(dashboardService)
        .updateCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    Customer customer3 = mock(Customer.class);
    when(customer3.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer3.getTitle()).thenReturn("Dr");
    when(customer3.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    customerServiceImpl.saveCustomer(customer3);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getId();
    verify(customer3, atLeast(1)).getId();
    verify(customer, atLeast(1)).getTenantId();
    verify(customer3, atLeast(1)).getTenantId();
    verify(customer2).getTitle();
    verify(customer3).getTitle();
    verify(customer).isPublic();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(dashboardService).updateCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(dataValidator).validate(isA(Customer.class), isA(Function.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}
   */
  @Test
  @DisplayName("Test deleteCustomer(TenantId, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomer(TenantId, CustomerId)"})
  void testDeleteCustomer() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            customerServiceImpl.deleteCustomer(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}
   */
  @Test
  @DisplayName("Test deleteCustomer(TenantId, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomer(TenantId, CustomerId)"})
  void testDeleteCustomer2() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Customer());
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            customerServiceImpl.deleteCustomer(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}
   */
  @Test
  @DisplayName("Test deleteCustomer(TenantId, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomer(TenantId, CustomerId)"})
  void testDeleteCustomer3() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getTenantId()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    doNothing()
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            customerServiceImpl.deleteCustomer(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(customer).getTenantId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}
   */
  @Test
  @DisplayName("Test deleteCustomer(TenantId, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomer(TenantId, CustomerId)"})
  void testDeleteCustomer4() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing()
        .when(assetService)
        .unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    doNothing()
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(deviceService)
        .unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(userService)
        .deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<CustomerCacheKey>>any());
    doNothing()
        .when(edgeService)
        .unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityViewService)
        .unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            customerServiceImpl.deleteCustomer(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).getTitle();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityViewService)
        .unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}
   */
  @Test
  @DisplayName("Test deleteCustomer(TenantId, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomer(TenantId, CustomerId)"})
  void testDeleteCustomer5() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing()
        .when(assetService)
        .unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    doNothing()
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(deviceService)
        .unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(userService)
        .deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(edgeService)
        .unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityViewService)
        .unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            customerServiceImpl.deleteCustomer(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).getTitle();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(entityViewService)
        .unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#findById(TenantId, UUID)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test deleteCustomer(TenantId, CustomerId); given CustomerDao findById(TenantId, UUID) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomer(TenantId, CustomerId)"})
  void testDeleteCustomer_givenCustomerDaoFindByIdReturnNull() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            customerServiceImpl.deleteCustomer(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}
   */
  @Test
  @DisplayName("Test deleteCustomer(TenantId, CustomerId); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomer(TenantId, CustomerId)"})
  void testDeleteCustomer_thenCallsGetId() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing()
        .when(assetService)
        .unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    doNothing()
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(deviceService)
        .unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(userService)
        .deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(edgeService)
        .unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityViewService)
        .unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    customerServiceImpl.deleteCustomer(ModelConstants.SYSTEM_TENANT, customerId);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).getTitle();
    verify(customerId, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(entityViewService)
        .unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityCountService#publishCountEntityEvictEvent(TenantId, EntityType)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test deleteCustomer(TenantId, CustomerId); then calls publishCountEntityEvictEvent(TenantId, EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomer(TenantId, CustomerId)"})
  void testDeleteCustomer_thenCallsPublishCountEntityEvictEvent() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing()
        .when(assetService)
        .unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    doNothing()
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(deviceService)
        .unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(userService)
        .deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(edgeService)
        .unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityViewService)
        .unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act
    customerServiceImpl.deleteCustomer(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).getTitle();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(entityViewService)
        .unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            customerServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity2() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Customer());
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            customerServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity3() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getTenantId()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    doNothing()
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            customerServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(customer).getTenantId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity4() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing()
        .when(assetService)
        .unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    doNothing()
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(deviceService)
        .unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(userService)
        .deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<CustomerCacheKey>>any());
    doNothing()
        .when(edgeService)
        .unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityViewService)
        .unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            customerServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).getTitle();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityViewService)
        .unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity5() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing()
        .when(assetService)
        .unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    doNothing()
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(deviceService)
        .unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(userService)
        .deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(edgeService)
        .unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityViewService)
        .unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            customerServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).getTitle();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(entityViewService)
        .unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#findById(TenantId, UUID)} return {@code
   *       null}.
   *   <li>Then calls {@link CustomerDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given CustomerDao findById(TenantId, UUID) return 'null'; then calls findById(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenCustomerDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    customerServiceImpl.deleteEntity(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenFromString784f394c42b6435a983cB7beff2784f9_thenCallsGetId() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing()
        .when(assetService)
        .unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    doNothing()
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(deviceService)
        .unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(userService)
        .deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(edgeService)
        .unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityViewService)
        .unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    CustomerId id = mock(CustomerId.class);
    when(id.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    customerServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).getTitle();
    verify(id, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(entityViewService)
        .unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityCountService#publishCountEntityEvictEvent(TenantId, EntityType)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); then calls publishCountEntityEvictEvent(TenantId, EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_thenCallsPublishCountEntityEvictEvent() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing()
        .when(assetService)
        .unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    doNothing()
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(deviceService)
        .unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(userService)
        .deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(edgeService)
        .unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityViewService)
        .unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act
    customerServiceImpl.deleteEntity(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).getTitle();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(entityViewService)
        .unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  @DisplayName("Test findOrCreatePublicCustomer(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.findOrCreatePublicCustomer(TenantId)"})
  void testFindOrCreatePublicCustomer() {
    // Arrange
    Customer customer = new Customer();
    Optional<Customer> ofResult = Optional.of(customer);
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(ofResult);

    // Act
    Customer actualFindOrCreatePublicCustomerResult =
        customerServiceImpl.findOrCreatePublicCustomer(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    assertSame(customer, actualFindOrCreatePublicCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  @DisplayName("Test findOrCreatePublicCustomer(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.findOrCreatePublicCustomer(TenantId)"})
  void testFindOrCreatePublicCustomer2() {
    // Arrange
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.findOrCreatePublicCustomer(ModelConstants.SYSTEM_TENANT));
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  @DisplayName("Test findOrCreatePublicCustomer(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.findOrCreatePublicCustomer(TenantId)"})
  void testFindOrCreatePublicCustomer3() {
    // Arrange
    Customer customer = new Customer();
    Optional<Customer> ofResult = Optional.of(customer);
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(ofResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Customer actualFindOrCreatePublicCustomerResult =
        customerServiceImpl.findOrCreatePublicCustomer(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    assertSame(customer, actualFindOrCreatePublicCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  @DisplayName("Test findOrCreatePublicCustomer(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.findOrCreatePublicCustomer(TenantId)"})
  void testFindOrCreatePublicCustomer4() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.findOrCreatePublicCustomer(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  @DisplayName("Test findOrCreatePublicCustomer(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.findOrCreatePublicCustomer(TenantId)"})
  void testFindOrCreatePublicCustomer5() {
    // Arrange
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any()))
        .thenReturn(new Customer());
    Optional<Customer> emptyResult = Optional.empty();
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(emptyResult);
    doNothing()
        .when(dashboardService)
        .updateCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<CustomerCacheKey>>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.findOrCreatePublicCustomer(tenantId));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(Collection.class));
    verify(tenantId, atLeast(1)).getId();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    verify(dashboardService).updateCustomerDashboards(isNull(), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.CUSTOMER));
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link Customer} {@link Customer#isPublic()} return {@code false}.
   *   <li>Then calls {@link Customer#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  @DisplayName(
      "Test findOrCreatePublicCustomer(TenantId); given Customer isPublic() return 'false'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.findOrCreatePublicCustomer(TenantId)"})
  void testFindOrCreatePublicCustomer_givenCustomerIsPublicReturnFalse_thenCallsGetId() {
    // Arrange
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(false);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any()))
        .thenReturn(customer);
    Optional<Customer> emptyResult = Optional.empty();
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(emptyResult);
    doNothing()
        .when(dashboardService)
        .updateCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    customerServiceImpl.findOrCreatePublicCustomer(tenantId);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getId();
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).isPublic();
    verify(tenantId, atLeast(1)).getId();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    verify(dashboardService).updateCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link Customer} {@link Customer#isPublic()} return {@code true}.
   *   <li>Then calls {@link Customer#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  @DisplayName(
      "Test findOrCreatePublicCustomer(TenantId); given Customer isPublic() return 'true'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.findOrCreatePublicCustomer(TenantId)"})
  void testFindOrCreatePublicCustomer_givenCustomerIsPublicReturnTrue_thenCallsGetId() {
    // Arrange
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(true);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any()))
        .thenReturn(customer);
    Optional<Customer> emptyResult = Optional.empty();
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(emptyResult);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    customerServiceImpl.findOrCreatePublicCustomer(tenantId);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer).getId();
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).isPublic();
    verify(tenantId, atLeast(1)).getId();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  @DisplayName("Test findOrCreatePublicCustomer(TenantId); then AdditionalInfo return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.findOrCreatePublicCustomer(TenantId)"})
  void testFindOrCreatePublicCustomer_thenAdditionalInfoReturnNullNode() {
    // Arrange
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Customer customer = new Customer(new Customer());
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any()))
        .thenReturn(customer);
    Optional<Customer> emptyResult = Optional.empty();
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(emptyResult);
    doNothing()
        .when(dashboardService)
        .updateCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Customer actualFindOrCreatePublicCustomerResult =
        customerServiceImpl.findOrCreatePublicCustomer(tenantId);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantId, atLeast(1)).getId();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    verify(dashboardService).updateCustomerDashboards(isNull(), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.CUSTOMER));
    assertTrue(actualFindOrCreatePublicCustomerResult.getAdditionalInfo() instanceof NullNode);
    assertSame(customer, actualFindOrCreatePublicCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   *
   * <ul>
   *   <li>Then return {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  @DisplayName("Test findOrCreatePublicCustomer(TenantId); then return Customer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.findOrCreatePublicCustomer(TenantId)"})
  void testFindOrCreatePublicCustomer_thenReturnCustomer() {
    // Arrange
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Customer customer = new Customer();
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any()))
        .thenReturn(customer);
    Optional<Customer> emptyResult = Optional.empty();
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(emptyResult);
    doNothing()
        .when(dashboardService)
        .updateCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Customer actualFindOrCreatePublicCustomerResult =
        customerServiceImpl.findOrCreatePublicCustomer(tenantId);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantId, atLeast(1)).getId();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    verify(dashboardService).updateCustomerDashboards(isNull(), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.CUSTOMER));
    assertSame(customer, actualFindOrCreatePublicCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  @DisplayName("Test findOrCreatePublicCustomer(TenantId); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.findOrCreatePublicCustomer(TenantId)"})
  void testFindOrCreatePublicCustomer_thenThrowRuntimeException() {
    // Arrange
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any()))
        .thenReturn(new Customer());
    Optional<Customer> emptyResult = Optional.empty();
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(emptyResult);
    doNothing()
        .when(dashboardService)
        .updateCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<CustomerCacheKey>>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> customerServiceImpl.findOrCreatePublicCustomer(tenantId));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(Collection.class));
    verify(tenantId, atLeast(1)).getId();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    verify(dashboardService).updateCustomerDashboards(isNull(), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.CUSTOMER));
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findCustomersByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData CustomerServiceImpl.findCustomersByTenantId(TenantId, PageLink)"})
  void testFindCustomersByTenantId() {
    // Arrange
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            customerServiceImpl.findCustomersByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findCustomersByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData CustomerServiceImpl.findCustomersByTenantId(TenantId, PageLink)"})
  void testFindCustomersByTenantId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.findCustomersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findCustomersByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData CustomerServiceImpl.findCustomersByTenantId(TenantId, PageLink)"})
  void testFindCustomersByTenantId3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.findCustomersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findCustomersByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData CustomerServiceImpl.findCustomersByTenantId(TenantId, PageLink)"})
  void testFindCustomersByTenantId4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.findCustomersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findCustomersByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData CustomerServiceImpl.findCustomersByTenantId(TenantId, PageLink)"})
  void testFindCustomersByTenantId5() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.findCustomersByTenantId(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findCustomersByTenantId(TenantId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData CustomerServiceImpl.findCustomersByTenantId(TenantId, PageLink)"})
  void testFindCustomersByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<Customer> emptyPageDataResult = PageData.emptyPageData();
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Customer> actualFindCustomersByTenantIdResult =
        customerServiceImpl.findCustomersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindCustomersByTenantIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findCustomersByTenantId(TenantId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData CustomerServiceImpl.findCustomersByTenantId(TenantId, PageLink)"})
  void testFindCustomersByTenantId_thenCallsGetId() {
    // Arrange
    PageData<Customer> emptyPageDataResult = PageData.emptyPageData();
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Customer> actualFindCustomersByTenantIdResult =
        customerServiceImpl.findCustomersByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindCustomersByTenantIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findCustomersByTenantId(TenantId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData CustomerServiceImpl.findCustomersByTenantId(TenantId, PageLink)"})
  void testFindCustomersByTenantId_thenCallsGetProperty() {
    // Arrange
    PageData<Customer> emptyPageDataResult = PageData.emptyPageData();
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Customer> actualFindCustomersByTenantIdResult =
        customerServiceImpl.findCustomersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindCustomersByTenantIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findCustomersByTenantId(TenantId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData CustomerServiceImpl.findCustomersByTenantId(TenantId, PageLink)"})
  void testFindCustomersByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Customer> emptyPageDataResult = PageData.emptyPageData();
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Customer> actualFindCustomersByTenantIdResult =
        customerServiceImpl.findCustomersByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindCustomersByTenantIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteCustomersByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomersByTenantId(TenantId)"})
  void testDeleteCustomersByTenantId() {
    // Arrange
    PageData<Customer> emptyPageDataResult = PageData.emptyPageData();
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    customerServiceImpl.deleteCustomersByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteCustomersByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomersByTenantId(TenantId)"})
  void testDeleteCustomersByTenantId2() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.deleteCustomersByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteCustomersByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomersByTenantId(TenantId)"})
  void testDeleteCustomersByTenantId3() {
    // Arrange
    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new Customer(BaseEntityService.NULL_CUSTOMER_ID));

    PageData<Customer> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(customerList);
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.deleteCustomersByTenantId(tenantId));
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteCustomersByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomersByTenantId(TenantId)"})
  void testDeleteCustomersByTenantId4() {
    // Arrange
    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new Customer(BaseEntityService.NULL_CUSTOMER_ID));

    PageData<Customer> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(customerList);
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Customer());
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.deleteCustomersByTenantId(tenantId));
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteCustomersByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomersByTenantId(TenantId)"})
  void testDeleteCustomersByTenantId5() {
    // Arrange
    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new Customer(BaseEntityService.NULL_CUSTOMER_ID));

    PageData<Customer> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(customerList);

    Customer customer = mock(Customer.class);
    when(customer.getTenantId()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
    doNothing()
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.deleteCustomersByTenantId(tenantId));
    verify(customer).getTenantId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteCustomersByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomersByTenantId(TenantId)"})
  void testDeleteCustomersByTenantId6() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing()
        .when(assetService)
        .unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new Customer(BaseEntityService.NULL_CUSTOMER_ID));

    PageData<Customer> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(customerList);

    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
    doNothing()
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(deviceService)
        .unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(userService)
        .deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<CustomerCacheKey>>any());
    doNothing()
        .when(edgeService)
        .unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityViewService)
        .unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.deleteCustomersByTenantId(tenantId));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).getTitle();
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityViewService)
        .unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteCustomersByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomersByTenantId(TenantId)"})
  void testDeleteCustomersByTenantId7() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing()
        .when(assetService)
        .unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new Customer(BaseEntityService.NULL_CUSTOMER_ID));

    PageData<Customer> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(customerList);

    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
    doNothing()
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(deviceService)
        .unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(userService)
        .deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(edgeService)
        .unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityViewService)
        .unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.deleteCustomersByTenantId(tenantId));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).getTitle();
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(entityViewService)
        .unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#findById(TenantId, UUID)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteCustomersByTenantId(TenantId); given CustomerDao findById(TenantId, UUID) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomersByTenantId(TenantId)"})
  void testDeleteCustomersByTenantId_givenCustomerDaoFindByIdReturnNull() {
    // Arrange
    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new Customer(BaseEntityService.NULL_CUSTOMER_ID));

    PageData<Customer> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(customerList);
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.deleteCustomersByTenantId(tenantId));
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link Customer#getUuidId()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteCustomersByTenantId(TenantId); given PageData hasNext() return 'false'; then calls getUuidId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomersByTenantId(TenantId)"})
  void testDeleteCustomersByTenantId_givenPageDataHasNextReturnFalse_thenCallsGetUuidId() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing()
        .when(assetService)
        .unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    Customer customer = mock(Customer.class);
    when(customer.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(customer);

    PageData<Customer> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(customerList);

    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn("Dr");
    when(customer2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer2);
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
    doNothing()
        .when(dashboardService)
        .unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(deviceService)
        .unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(userService)
        .deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(edgeService)
        .unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing()
        .when(entityViewService)
        .unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    customerServiceImpl.deleteCustomersByTenantId(tenantId);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer2, atLeast(1)).getTenantId();
    verify(customer2).getTitle();
    verify(customer).getUuidId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(entityViewService)
        .unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link PageData#hasNext()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteCustomersByTenantId(TenantId); given PageData hasNext() return 'false'; then calls hasNext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomersByTenantId(TenantId)"})
  void testDeleteCustomersByTenantId_givenPageDataHasNextReturnFalse_thenCallsHasNext() {
    // Arrange
    PageData<Customer> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    customerServiceImpl.deleteCustomersByTenantId(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerDao#findCustomersByTenantId(UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteByTenantId(TenantId); then calls findCustomersByTenantId(UUID, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_thenCallsFindCustomersByTenantId() {
    // Arrange
    PageData<Customer> emptyPageDataResult = PageData.emptyPageData();
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    customerServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId); then throw IncorrectParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_thenThrowIncorrectParameterException() {
    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class, () -> customerServiceImpl.deleteByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link CustomerServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#findById(TenantId, UUID)} return {@link
   *       Customer#Customer()}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntity(TenantId, EntityId); given CustomerDao findById(TenantId, UUID) return Customer(); then return Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional CustomerServiceImpl.findEntity(TenantId, EntityId)"})
  void testFindEntity_givenCustomerDaoFindByIdReturnCustomer_thenReturnPresent() {
    // Arrange
    Customer customer = new Customer();
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        customerServiceImpl.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(customer, actualFindEntityResult.get());
  }

  /**
   * Test {@link CustomerServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntity(TenantId, EntityId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional CustomerServiceImpl.findEntity(TenantId, EntityId)"})
  void testFindEntity_givenFromString784f394c42b6435a983cB7beff2784f9_thenCallsGetId() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT, entityId));
    verify(entityId).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link CustomerServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntity(TenantId, EntityId); when NULL_CUSTOMER_ID; then throw IncorrectParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional CustomerServiceImpl.findEntity(TenantId, EntityId)"})
  void testFindEntity_whenNull_customer_id_thenThrowIncorrectParameterException() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            customerServiceImpl.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link CustomerServiceImpl#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#countByTenantId(TenantId)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test countByTenantId(TenantId); given CustomerDao countByTenantId(TenantId) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CustomerServiceImpl.countByTenantId(TenantId)"})
  void testCountByTenantId_givenCustomerDaoCountByTenantIdReturnOne_thenReturnOne() {
    // Arrange
    when(customerDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualCountByTenantIdResult =
        customerServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(customerDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountByTenantIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test countByTenantId(TenantId); then throw IncorrectParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CustomerServiceImpl.countByTenantId(TenantId)"})
  void testCountByTenantId_thenThrowIncorrectParameterException() {
    // Arrange
    when(customerDao.countByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> customerServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(customerDao).countByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType CustomerServiceImpl.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.CUSTOMER, new CustomerServiceImpl().getEntityType());
  }
}
