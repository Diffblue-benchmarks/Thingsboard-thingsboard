package org.thingsboard.server.dao.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
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
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.cache.customer.CustomerCacheEvictEvent;
import org.thingsboard.server.cache.customer.CustomerCacheKey;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.TenantEntityDao;
import org.thingsboard.server.dao.alarm.AlarmService;
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
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.usagerecord.ApiUsageStateService;
import org.thingsboard.server.dao.user.UserService;

@ContextConfiguration(classes = {CustomerServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class CustomerServiceImplDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApiUsageStateService apiUsageStateService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private AssetService assetService;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private CustomerDao customerDao;

  @Autowired
  private CustomerServiceImpl customerServiceImpl;

  @MockBean
  private DashboardService dashboardService;

  @MockBean
  private DataValidator<Customer> dataValidator;

  @MockBean
  private DeviceService deviceService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityCountService entityCountService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private RelationService relationService;

  @MockBean
  private TbTransactionalCache<CustomerCacheKey, Customer> tbTransactionalCache;

  @MockBean
  private UserService userService;

  /**
   * Test {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)}
   * with {@code CustomerCacheEvictEvent}.
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithCustomerCacheEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    // Act
    customerServiceImpl.handleEvictEvent(new CustomerCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "Dr", "Dr"));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)}
   * with {@code CustomerCacheEvictEvent}.
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithCustomerCacheEvictEvent2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    // Act
    customerServiceImpl.handleEvictEvent(new CustomerCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "Mr", "Dr"));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)}
   * with {@code CustomerCacheEvictEvent}.
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithCustomerCacheEvictEvent3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    // Act
    customerServiceImpl.handleEvictEvent(new CustomerCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "Dr", ""));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)}
   * with {@code CustomerCacheEvictEvent}.
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#handleEvictEvent(CustomerCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithCustomerCacheEvictEvent4() {
    // Arrange
    doThrow(new IncorrectParameterException("An error occurred")).when(tbTransactionalCache)
        .evict(Mockito.<Collection<CustomerCacheKey>>any());

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> customerServiceImpl
        .handleEvictEvent(new CustomerCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "Dr", "Dr")));
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerById(TenantId, CustomerId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@link Customer#Customer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findCustomerById(TenantId, CustomerId)}
   */
  @Test
  public void testFindCustomerById_whenNull_customer_id_thenReturnCustomer() {
    // Arrange
    Customer customer = new Customer();
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    // Act
    Customer actualFindCustomerByIdResult = customerServiceImpl.findCustomerById(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(customer, actualFindCustomerByIdResult);
  }

  /**
   * Test
   * {@link CustomerServiceImpl#findCustomerByTenantIdAndTitle(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findCustomerByTenantIdAndTitle(TenantId, String)}
   */
  @Test
  public void testFindCustomerByTenantIdAndTitle_thenThrowIncorrectParameterException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<CustomerCacheKey>any(), Mockito.<Supplier<Customer>>any(),
        anyBoolean())).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> customerServiceImpl.findCustomerByTenantIdAndTitle(ModelConstants.SYSTEM_TENANT, "Dr"));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(CustomerCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test
   * {@link CustomerServiceImpl#findCustomerByTenantIdAndTitle(TenantId, String)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findCustomerByTenantIdAndTitle(TenantId, String)}
   */
  @Test
  public void testFindCustomerByTenantIdAndTitle_whenSystem_tenant_thenReturnPresent() {
    // Arrange
    Customer customer = new Customer();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<CustomerCacheKey>any(), Mockito.<Supplier<Customer>>any(),
        anyBoolean())).thenReturn(customer);

    // Act
    Optional<Customer> actualFindCustomerByTenantIdAndTitleResult = customerServiceImpl
        .findCustomerByTenantIdAndTitle(ModelConstants.SYSTEM_TENANT, "Dr");

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(CustomerCacheKey.class), isA(Supplier.class), eq(true));
    assertTrue(actualFindCustomerByTenantIdAndTitleResult.isPresent());
    assertSame(customer, actualFindCustomerByTenantIdAndTitleResult.get());
  }

  /**
   * Test
   * {@link CustomerServiceImpl#findCustomerByTenantIdAndTitleAsync(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findCustomerByTenantIdAndTitleAsync(TenantId, String)}
   */
  @Test
  public void testFindCustomerByTenantIdAndTitleAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Optional<Customer>> actualFindCustomerByTenantIdAndTitleAsyncResult = customerServiceImpl
        .findCustomerByTenantIdAndTitleAsync(ModelConstants.SYSTEM_TENANT, "Dr");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindCustomerByTenantIdAndTitleAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindCustomerByTenantIdAndTitleAsyncResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomerByIdAsync(TenantId, CustomerId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findCustomerByIdAsync(TenantId, CustomerId)}
   */
  @Test
  public void testFindCustomerByIdAsync_whenNull_customer_id_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Customer> createResult = SettableFuture.create();
    when(customerDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Customer> actualFindCustomerByIdAsyncResult = customerServiceImpl
        .findCustomerByIdAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customerDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindCustomerByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindCustomerByIdAsyncResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with
   * {@code customer}.
   * <ul>
   *   <li>Given {@link Customer} {@link Customer#getTitle()} return empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  public void testSaveCustomerWithCustomer_givenCustomerGetTitleReturnEmptyString() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(true);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any())).thenReturn(customer);
    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn("");
    when(dataValidator.validate(Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    Customer customer3 = mock(Customer.class);
    when(customer3.getTitle()).thenReturn("Dr");
    when(customer3.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
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
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with
   * {@code customer}.
   * <ul>
   *   <li>Given {@link Customer} {@link Customer#getTitle()} return
   * {@code Executing saveCustomer [{}]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  public void testSaveCustomerWithCustomer_givenCustomerGetTitleReturnExecutingSaveCustomer() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(true);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any())).thenReturn(customer);
    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn("Executing saveCustomer [{}]");
    when(dataValidator.validate(Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    Customer customer3 = mock(Customer.class);
    when(customer3.getTitle()).thenReturn("Dr");
    when(customer3.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
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
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with
   * {@code customer}.
   * <ul>
   *   <li>Given {@link Customer} {@link Customer#getTitle()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  public void testSaveCustomerWithCustomer_givenCustomerGetTitleReturnNull() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(true);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any())).thenReturn(customer);
    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn(null);
    when(dataValidator.validate(Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    Customer customer3 = mock(Customer.class);
    when(customer3.getTitle()).thenReturn("Dr");
    when(customer3.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
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
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with
   * {@code customer}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls
   * {@link EntityCountService#publishCountEntityEvictEvent(TenantId, EntityType)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  public void testSaveCustomerWithCustomer_givenNull_thenCallsPublishCountEntityEvictEvent() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(true);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any())).thenReturn(customer);
    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn("Dr");
    when(dataValidator.validate(Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    Customer customer3 = mock(Customer.class);
    when(customer3.getTitle()).thenReturn("Dr");
    when(customer3.getId()).thenReturn(null);
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
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(dataValidator).validate(isA(Customer.class), isA(Function.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with
   * {@code customer}.
   * <ul>
   *   <li>Given {@link TbTransactionalCache}
   * {@link TbTransactionalCache#evict(Collection)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  public void testSaveCustomerWithCustomer_givenTbTransactionalCacheEvictDoesNothing() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(true);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any())).thenReturn(customer);
    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn("Dr");
    when(dataValidator.validate(Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    Customer customer3 = mock(Customer.class);
    when(customer3.getTitle()).thenReturn("Dr");
    when(customer3.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
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
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with
   * {@code customer}.
   * <ul>
   *   <li>Then calls
   * {@link DashboardService#updateCustomerDashboards(TenantId, CustomerId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  public void testSaveCustomerWithCustomer_thenCallsUpdateCustomerDashboards() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(false);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any())).thenReturn(customer);
    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn("Dr");
    when(dataValidator.validate(Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer2);
    doNothing().when(dashboardService).updateCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    Customer customer3 = mock(Customer.class);
    when(customer3.getTitle()).thenReturn("Dr");
    when(customer3.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
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
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with
   * {@code customer}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  public void testSaveCustomerWithCustomer_thenThrowIncorrectParameterException() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(true);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any())).thenReturn(customer);
    Customer customer2 = mock(Customer.class);
    when(customer2.getTitle()).thenReturn("Dr");
    when(dataValidator.validate(Mockito.<Customer>any(), Mockito.<Function<Customer, TenantId>>any()))
        .thenReturn(customer2);
    doThrow(new IncorrectParameterException("An error occurred")).when(tbTransactionalCache)
        .evict(Mockito.<Collection<CustomerCacheKey>>any());
    Customer customer3 = mock(Customer.class);
    when(customer3.getTitle()).thenReturn("Dr");
    when(customer3.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer3.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> customerServiceImpl.saveCustomer(customer3));
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
   * Test {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}.
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}
   */
  @Test
  public void testDeleteCustomer() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing().when(assetService).unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    doNothing().when(dashboardService).unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(deviceService).unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(userService).deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    doThrow(new IncorrectParameterException("An error occurred")).when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(edgeService).unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(entityViewService).unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> customerServiceImpl.deleteCustomer(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).getTitle();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(entityViewService).unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}.
   * <ul>
   *   <li>Given {@link CustomerDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}
   */
  @Test
  public void testDeleteCustomer_givenCustomerDaoFindByIdReturnNull() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> customerServiceImpl.deleteCustomer(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}.
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#deleteCustomer(TenantId, CustomerId)}
   */
  @Test
  public void testDeleteCustomer_thenCallsEvict() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing().when(assetService).unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    doNothing().when(dashboardService).unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(deviceService).unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(userService).deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(edgeService).unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(entityViewService).unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act
    customerServiceImpl.deleteCustomer(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

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
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(entityViewService).unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link CustomerDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   *   <li>Then calls {@link Dao#findById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_givenCustomerDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    customerServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert that nothing has changed
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_thenCallsEvict() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing().when(assetService).unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    doNothing().when(dashboardService).unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(deviceService).unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(userService).deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(edgeService).unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(entityViewService).unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act
    customerServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

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
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(entityViewService).unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_thenThrowIncorrectParameterException() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing().when(assetService).unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customerDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    doNothing().when(dashboardService).unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(deviceService).unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(userService).deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    doThrow(new IncorrectParameterException("An error occurred")).when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(edgeService).unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(entityViewService).unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> customerServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).getTitle();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(entityViewService).unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   * <ul>
   *   <li>Given {@link Customer} {@link Customer#isPublic()} return
   * {@code false}.</li>
   *   <li>Then calls {@link Customer#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  public void testFindOrCreatePublicCustomer_givenCustomerIsPublicReturnFalse_thenCallsGetId() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(false);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any())).thenReturn(customer);
    Optional<Customer> emptyResult = Optional.empty();
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(emptyResult);
    doNothing().when(dashboardService).updateCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    // Act
    customerServiceImpl.findOrCreatePublicCustomer(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getId();
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).isPublic();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    verify(dashboardService).updateCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   * <ul>
   *   <li>Given {@link Customer} {@link Customer#isPublic()} return
   * {@code true}.</li>
   *   <li>Then calls {@link Customer#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  public void testFindOrCreatePublicCustomer_givenCustomerIsPublicReturnTrue_thenCallsGetId() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Customer customer = mock(Customer.class);
    when(customer.isPublic()).thenReturn(true);
    when(customer.getId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any())).thenReturn(customer);
    Optional<Customer> emptyResult = Optional.empty();
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(emptyResult);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    // Act
    customerServiceImpl.findOrCreatePublicCustomer(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer).getId();
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).isPublic();
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   * <ul>
   *   <li>Given {@link EntityCountService}.</li>
   *   <li>Then return {@link Customer#Customer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  public void testFindOrCreatePublicCustomer_givenEntityCountService_thenReturnCustomer() {
    // Arrange
    Customer customer = new Customer();
    Optional<Customer> ofResult = Optional.of(customer);
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(ofResult);

    // Act
    Customer actualFindOrCreatePublicCustomerResult = customerServiceImpl
        .findOrCreatePublicCustomer(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    assertSame(customer, actualFindOrCreatePublicCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   * <ul>
   *   <li>Then return {@link Customer#Customer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  public void testFindOrCreatePublicCustomer_thenReturnCustomer() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Customer customer = new Customer();
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any())).thenReturn(customer);
    Optional<Customer> emptyResult = Optional.empty();
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(emptyResult);
    doNothing().when(dashboardService).updateCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    // Act
    Customer actualFindOrCreatePublicCustomerResult = customerServiceImpl
        .findOrCreatePublicCustomer(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    verify(dashboardService).updateCustomerDashboards(isNull(), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.CUSTOMER));
    assertSame(customer, actualFindOrCreatePublicCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   * <ul>
   *   <li>Then return {@link Customer#Customer(Customer)} with customer is
   * {@link Customer#Customer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  public void testFindOrCreatePublicCustomer_thenReturnCustomerWithCustomerIsCustomer() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Customer customer = new Customer(new Customer());
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any())).thenReturn(customer);
    Optional<Customer> emptyResult = Optional.empty();
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(emptyResult);
    doNothing().when(dashboardService).updateCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());

    // Act
    Customer actualFindOrCreatePublicCustomerResult = customerServiceImpl
        .findOrCreatePublicCustomer(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    verify(dashboardService).updateCustomerDashboards(isNull(), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.CUSTOMER));
    assertSame(customer, actualFindOrCreatePublicCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  public void testFindOrCreatePublicCustomer_thenThrowIncorrectParameterException() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any())).thenReturn(new Customer());
    Optional<Customer> emptyResult = Optional.empty();
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(emptyResult);
    doNothing().when(dashboardService).updateCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doThrow(new IncorrectParameterException("An error occurred")).when(tbTransactionalCache)
        .evict(Mockito.<Collection<CustomerCacheKey>>any());

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> customerServiceImpl.findOrCreatePublicCustomer(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(Collection.class));
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    verify(dashboardService).updateCustomerDashboards(isNull(), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.CUSTOMER));
  }

  /**
   * Test {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findOrCreatePublicCustomer(TenantId)}
   */
  @Test
  public void testFindOrCreatePublicCustomer_thenThrowRuntimeException() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    when(customerDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Customer>any())).thenReturn(new Customer());
    Optional<Customer> emptyResult = Optional.empty();
    when(customerDao.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(emptyResult);
    doNothing().when(dashboardService).updateCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doThrow(new DataValidationException("An error occurred")).when(tbTransactionalCache)
        .evict(Mockito.<Collection<CustomerCacheKey>>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> customerServiceImpl.findOrCreatePublicCustomer(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(Collection.class));
    verify(customerDao).saveAndFlush(isA(TenantId.class), isA(Customer.class));
    verify(customerDao).findPublicCustomerByTenantId(isA(UUID.class));
    verify(dashboardService).updateCustomerDashboards(isNull(), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.CUSTOMER));
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindCustomersByTenantId() {
    // Arrange
    PageData<Customer> emptyPageDataResult = PageData.emptyPageData();
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Customer> actualFindCustomersByTenantIdResult = customerServiceImpl
        .findCustomersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindCustomersByTenantIdResult.EMPTY_PAGE_DATA, actualFindCustomersByTenantIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindCustomersByTenantId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<Customer> emptyPageDataResult = PageData.emptyPageData();
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Customer> actualFindCustomersByTenantIdResult = customerServiceImpl
        .findCustomersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindCustomersByTenantIdResult.EMPTY_PAGE_DATA, actualFindCustomersByTenantIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindCustomersByTenantId_thenThrowIncorrectParameterException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> customerServiceImpl.findCustomersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindCustomersByTenantId_thenThrowRuntimeException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException("foo"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> customerServiceImpl.findCustomersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#findCustomersByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindCustomersByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Customer> emptyPageDataResult = PageData.emptyPageData();
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Customer> actualFindCustomersByTenantIdResult = customerServiceImpl
        .findCustomersByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindCustomersByTenantIdResult.EMPTY_PAGE_DATA, actualFindCustomersByTenantIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}.
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}
   */
  @Test
  public void testDeleteCustomersByTenantId() {
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
   * <ul>
   *   <li>Given {@link CustomerDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}
   */
  @Test
  public void testDeleteCustomersByTenantId_givenCustomerDaoFindByIdReturnNull() {
    // Arrange
    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new Customer(BaseEntityService.NULL_CUSTOMER_ID));
    PageData<Customer> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(customerList);
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> customerServiceImpl.deleteCustomersByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(pageData).getData();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#deleteCustomersByTenantId(TenantId)}
   */
  @Test
  public void testDeleteCustomersByTenantId_thenCallsEvict() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing().when(assetService).unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(entityCountService)
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
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);
    doNothing().when(dashboardService).unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(deviceService).unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(userService).deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    doThrow(new IncorrectParameterException("An error occurred")).when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(edgeService).unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(entityViewService).unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> customerServiceImpl.deleteCustomersByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).getTitle();
    verify(pageData).getData();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(entityViewService).unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link CustomerDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_givenCustomerDaoFindByIdReturnNull() {
    // Arrange
    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new Customer(BaseEntityService.NULL_CUSTOMER_ID));
    PageData<Customer> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(customerList);
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> customerServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(pageData).getData();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link CustomerServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link CustomerDao}
   * {@link CustomerDao#findCustomersByTenantId(UUID, PageLink)} return
   * emptyPageData.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_givenCustomerDaoFindCustomersByTenantIdReturnEmptyPageData() {
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
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenCallsEvict() {
    // Arrange
    doNothing().when(apiUsageStateService).deleteApiUsageStateByEntityId(Mockito.<EntityId>any());
    doNothing().when(assetService).unassignCustomerAssets(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(entityCountService)
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
    when(customerDao.findCustomersByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);
    doNothing().when(dashboardService).unassignCustomerDashboards(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(deviceService).unassignCustomerDevices(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(userService).deleteCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<CustomerCacheKey>>any());
    doThrow(new IncorrectParameterException("An error occurred")).when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(edgeService).unassignCustomerEdges(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(entityViewService).unassignCustomerEntityViews(Mockito.<TenantId>any(), Mockito.<CustomerId>any());

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> customerServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(customer, atLeast(1)).getTenantId();
    verify(customer).getTitle();
    verify(pageData).getData();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(customerDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetService).unassignCustomerAssets(isA(TenantId.class), isA(CustomerId.class));
    verify(customerDao).findCustomersByTenantId(isA(UUID.class), isA(PageLink.class));
    verify(dashboardService).unassignCustomerDashboards(isA(TenantId.class), isA(CustomerId.class));
    verify(deviceService).unassignCustomerDevices(isA(TenantId.class), isA(CustomerId.class));
    verify(edgeService).unassignCustomerEdges(isA(TenantId.class), isA(CustomerId.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.CUSTOMER));
    verify(entityViewService).unassignCustomerEntityViews(isA(TenantId.class), isA(CustomerId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateService).deleteApiUsageStateByEntityId(isA(EntityId.class));
    verify(userService).deleteCustomerUsers(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    Customer customer = new Customer();
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult = customerServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(customer, actualFindEntityResult.get());
  }

  /**
   * Test {@link CustomerServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    Customer customer = new Customer();
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    // Act
    Optional<HasId<?>> actualFindEntityResult = customerServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(customer, actualFindEntityResult.get());
  }

  /**
   * Test {@link CustomerServiceImpl#countByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link CustomerDao}
   * {@link TenantEntityDao#countByTenantId(TenantId)} return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_givenCustomerDaoCountByTenantIdReturnOne_thenReturnOne() {
    // Arrange
    when(customerDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualCountByTenantIdResult = customerServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(customerDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountByTenantIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#countByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_thenThrowIncorrectParameterException() {
    // Arrange
    when(customerDao.countByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> customerServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(customerDao).countByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link CustomerServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.CUSTOMER, (new CustomerServiceImpl()).getEntityType());
  }
}
