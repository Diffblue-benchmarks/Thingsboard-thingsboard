package org.thingsboard.server.service.apiusage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.EntityType;

@ContextConfiguration(classes = {CustomerApiUsageState.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class CustomerApiUsageStateDiffblueTest {
  @MockBean
  private ApiUsageState apiUsageState;

  @Autowired
  private CustomerApiUsageState customerApiUsageState;

  /**
   * Test {@link CustomerApiUsageState#CustomerApiUsageState(ApiUsageState)}.
   * <p>
   * Method under test:
   * {@link CustomerApiUsageState#CustomerApiUsageState(ApiUsageState)}
   */
  @Test
  @DisplayName("Test new CustomerApiUsageState(ApiUsageState)")
  void testNewCustomerApiUsageState() {
    // Arrange and Act
    CustomerApiUsageState actualCustomerApiUsageState = new CustomerApiUsageState(apiUsageState);

    // Assert
    assertNull(actualCustomerApiUsageState.getEntityId());
    assertNull(actualCustomerApiUsageState.getTenantId());
    assertEquals(EntityType.CUSTOMER, actualCustomerApiUsageState.getEntityType());
    assertSame(apiUsageState, actualCustomerApiUsageState.getApiUsageState());
  }

  /**
   * Test {@link CustomerApiUsageState#getEntityType()}.
   * <p>
   * Method under test: {@link CustomerApiUsageState#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.CUSTOMER, (new CustomerApiUsageState(new ApiUsageState())).getEntityType());
  }
}
