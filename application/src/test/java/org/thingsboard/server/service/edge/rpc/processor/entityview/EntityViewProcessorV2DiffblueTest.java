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
class EntityViewProcessorV2DiffblueTest {
  @InjectMocks
  private EntityViewProcessorV2 entityViewProcessorV2;

  /**
   * Test {@link EntityViewProcessorV2#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}.
   * <p>
   * Method under test: {@link EntityViewProcessorV2#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityViewProcessorV2.setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)"})
  void testSetCustomerId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityView entityView = new EntityView();
    CustomerId customerId2 = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityView.setCustomerId(customerId2);

    // Act
    entityViewProcessorV2.setCustomerId(tenantId, customerId, entityView, EntityViewUpdateMsg.getDefaultInstance());

    // Assert that nothing has changed
    assertSame(customerId2, entityView.getCustomerId());
  }

  /**
   * Test {@link EntityViewProcessorV2#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}.
   * <ul>
   *   <li>When {@link EntityView#EntityView()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewProcessorV2#setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg); when EntityView()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityViewProcessorV2.setCustomerId(TenantId, CustomerId, EntityView, EntityViewUpdateMsg)"})
  void testSetCustomerId_whenEntityView() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EntityView entityView = new EntityView();

    // Act
    entityViewProcessorV2.setCustomerId(tenantId, customerId, entityView, EntityViewUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(customerId, entityView.getCustomerId());
  }
}
