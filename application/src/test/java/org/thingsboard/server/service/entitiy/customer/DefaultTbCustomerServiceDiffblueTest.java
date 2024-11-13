package org.thingsboard.server.service.entitiy.customer;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.service.entitiy.TbLogEntityActionService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.sync.vc.EntitiesVersionControlService;
import org.thingsboard.server.service.telemetry.AlarmSubscriptionService;

@ContextConfiguration(classes = {DefaultTbCustomerService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class DefaultTbCustomerServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private AlarmSubscriptionService alarmSubscriptionService;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private DbCallbackExecutorService dbCallbackExecutorService;

  @Autowired
  private DefaultTbCustomerService defaultTbCustomerService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntitiesVersionControlService entitiesVersionControlService;

  @MockBean
  private Environment environment;

  @MockBean
  private TbClusterService tbClusterService;

  @MockBean
  private TbLogEntityActionService tbLogEntityActionService;

  /**
   * Test {@link DefaultTbCustomerService#delete(Customer, User)} with
   * {@code Customer}, {@code User}.
   * <ul>
   *   <li>Then calls
   * {@link CustomerService#deleteCustomer(TenantId, CustomerId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbCustomerService#delete(Customer, User)}
   */
  @Test
  @DisplayName("Test delete(Customer, User) with 'Customer', 'User'; then calls deleteCustomer(TenantId, CustomerId)")
  void testDeleteWithCustomerUser_thenCallsDeleteCustomer() {
    // Arrange
    doNothing().when(customerService).deleteCustomer(Mockito.<TenantId>any(), Mockito.<CustomerId>any());
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<Customer>any(),
            Mockito.<CustomerId>any(), Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));

    Customer customer = new Customer();
    customer.setId(new CustomerId(UUID.randomUUID()));

    // Act
    defaultTbCustomerService.delete(customer, new User());

    // Assert
    verify(customerService).deleteCustomer(isNull(), isA(CustomerId.class));
    verify(tbLogEntityActionService).logEntityAction((TenantId) isNull(), isA(CustomerId.class), isA(Customer.class),
        isA(CustomerId.class), eq(ActionType.DELETED), isA(User.class), isA(Object[].class));
  }
}
