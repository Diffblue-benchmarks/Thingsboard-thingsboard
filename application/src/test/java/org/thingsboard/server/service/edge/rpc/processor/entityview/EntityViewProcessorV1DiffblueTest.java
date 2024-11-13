package org.thingsboard.server.service.edge.rpc.processor.entityview;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.EntityViewUpdateMsg;

class EntityViewProcessorV1DiffblueTest {
  /**
   * Test
   * {@link EntityViewProcessorV1#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}.
   * <ul>
   *   <li>Then {@link EntityView#EntityView()} CustomerId is
   * {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewProcessorV1#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg); then EntityView() CustomerId is CustomerId(UUID) with id is randomUUID")
  void testSetCustomerId_thenEntityViewCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewProcessorV1 entityViewProcessorV1 = new EntityViewProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    EntityView entityView = new EntityView();

    // Act
    entityViewProcessorV1.setCustomerId(tenantId, customerId, entityView, EntityViewUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(customerId, entityView.getCustomerId());
  }

  /**
   * Test
   * {@link EntityViewProcessorV1#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}.
   * <ul>
   *   <li>When {@link EntityView} {@link EntityView#setCustomerId(CustomerId)} does
   * nothing.</li>
   *   <li>Then calls {@link EntityView#setCustomerId(CustomerId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewProcessorV1#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg); when EntityView setCustomerId(CustomerId) does nothing; then calls setCustomerId(CustomerId)")
  void testSetCustomerId_whenEntityViewSetCustomerIdDoesNothing_thenCallsSetCustomerId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewProcessorV1 entityViewProcessorV1 = new EntityViewProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    EntityView entityView = mock(EntityView.class);
    doNothing().when(entityView).setCustomerId(Mockito.<CustomerId>any());

    // Act
    entityViewProcessorV1.setCustomerId(tenantId, customerId, entityView, EntityViewUpdateMsg.getDefaultInstance());

    // Assert that nothing has changed
    verify(entityView).setCustomerId(isA(CustomerId.class));
  }
}
