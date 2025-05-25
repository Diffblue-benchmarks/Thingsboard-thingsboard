package org.thingsboard.server.service.edge.rpc.processor.entityview;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.EntityViewUpdateMsg;

@ExtendWith(MockitoExtension.class)
class EntityViewProcessorV1DiffblueTest {
  @InjectMocks
  private EntityViewProcessorV1 entityViewProcessorV1;

  /**
   * Test {@link EntityViewProcessorV1#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}.
   * <p>
   * Method under test: {@link EntityViewProcessorV1#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityViewProcessorV1.setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)"})
  void testSetCustomerId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EntityView entityView = new EntityView();

    // Act
    entityViewProcessorV1.setCustomerId(tenantId, customerId, entityView, EntityViewUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(customerId, entityView.getCustomerId());
  }
}
