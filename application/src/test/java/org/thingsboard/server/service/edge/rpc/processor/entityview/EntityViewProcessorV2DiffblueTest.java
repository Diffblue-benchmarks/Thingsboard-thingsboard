package org.thingsboard.server.service.edge.rpc.processor.entityview;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.EntityViewUpdateMsg;

class EntityViewProcessorV2DiffblueTest {
  /**
   * Test
   * {@link EntityViewProcessorV2#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}.
   * <ul>
   *   <li>Then calls {@link EntityView#getCustomerId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewProcessorV2#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg); then calls getCustomerId()")
  void testSetCustomerId_thenCallsGetCustomerId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewProcessorV2 entityViewProcessorV2 = new EntityViewProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    EntityView entityView = mock(EntityView.class);
    when(entityView.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(entityView).setCustomerId(Mockito.<CustomerId>any());

    // Act
    entityViewProcessorV2.setCustomerId(tenantId, customerId, entityView, EntityViewUpdateMsg.getDefaultInstance());

    // Assert that nothing has changed
    verify(entityView, atLeast(1)).getCustomerId();
    verify(entityView).setCustomerId(isA(CustomerId.class));
  }

  /**
   * Test
   * {@link EntityViewProcessorV2#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}.
   * <ul>
   *   <li>When {@link EntityView#EntityView()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewProcessorV2#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg); when EntityView()")
  void testSetCustomerId_whenEntityView() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewProcessorV2 entityViewProcessorV2 = new EntityViewProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    EntityView entityView = new EntityView();

    // Act
    entityViewProcessorV2.setCustomerId(tenantId, customerId, entityView, EntityViewUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(customerId, entityView.getCustomerId());
  }

  /**
   * Test
   * {@link EntityViewProcessorV2#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}.
   * <ul>
   *   <li>When {@link EntityView#EntityView()} CustomerId is
   * {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewProcessorV2#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg); when EntityView() CustomerId is CustomerId(UUID) with id is randomUUID")
  void testSetCustomerId_whenEntityViewCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewProcessorV2 entityViewProcessorV2 = new EntityViewProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    EntityView entityView = new EntityView();
    CustomerId customerId2 = new CustomerId(UUID.randomUUID());
    entityView.setCustomerId(customerId2);

    // Act
    entityViewProcessorV2.setCustomerId(tenantId, customerId, entityView, EntityViewUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(customerId2, entityView.getCustomerId());
  }
}
