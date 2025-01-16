package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.TenantId;

class TbMsgPushToCloudNodeDiffblueTest {
  /**
   * Test
   * {@link TbMsgPushToCloudNode#buildEvent(TenantId, EdgeEventActionType, UUID, Object, JsonNode)}
   * with {@code tenantId}, {@code eventAction}, {@code entityId},
   * {@code eventType}, {@code entityBody}.
   * <p>
   * Method under test:
   * {@link TbMsgPushToCloudNode#buildEvent(TenantId, EdgeEventActionType, UUID, Object, JsonNode)}
   */
  @Test
  @DisplayName("Test buildEvent(TenantId, EdgeEventActionType, UUID, Object, JsonNode) with 'tenantId', 'eventAction', 'entityId', 'eventType', 'entityBody'")
  void testBuildEventWithTenantIdEventActionEntityIdEventTypeEntityBody() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UUID entityId = UUID.randomUUID();

    // Act and Assert
    assertNull(tbMsgPushToCloudNode.buildEvent(tenantId, EdgeEventActionType.ADDED, entityId, "Event Type",
        MissingNode.getInstance()));
  }

  /**
   * Test
   * {@link TbMsgPushToCloudNode#buildEvent(TenantId, EdgeEventActionType, UUID, Object, JsonNode)}
   * with {@code tenantId}, {@code eventAction}, {@code entityId},
   * {@code eventType}, {@code entityBody}.
   * <p>
   * Method under test:
   * {@link TbMsgPushToCloudNode#buildEvent(TenantId, EdgeEventActionType, UUID, Object, JsonNode)}
   */
  @Test
  @DisplayName("Test buildEvent(TenantId, EdgeEventActionType, UUID, Object, JsonNode) with 'tenantId', 'eventAction', 'entityId', 'eventType', 'entityBody'")
  void testBuildEventWithTenantIdEventActionEntityIdEventTypeEntityBody2() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(null));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UUID entityId = UUID.randomUUID();

    // Act and Assert
    assertNull(tbMsgPushToCloudNode.buildEvent(tenantId, EdgeEventActionType.ADDED, entityId, "Event Type",
        MissingNode.getInstance()));
  }

  /**
   * Test {@link TbMsgPushToCloudNode#getEventTypeByEntityType(EntityType)}.
   * <p>
   * Method under test:
   * {@link TbMsgPushToCloudNode#getEventTypeByEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test getEventTypeByEntityType(EntityType)")
  void testGetEventTypeByEntityType() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(null));

    // Act and Assert
    assertNull(tbMsgPushToCloudNode.getEventTypeByEntityType(EntityType.TENANT));
  }

  /**
   * Test {@link TbMsgPushToCloudNode#getEventTypeByEntityType(EntityType)}.
   * <ul>
   *   <li>Given {@link TbMsgPushToCloudNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgPushToCloudNode#getEventTypeByEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test getEventTypeByEntityType(EntityType); given TbMsgPushToCloudNode (default constructor)")
  void testGetEventTypeByEntityType_givenTbMsgPushToCloudNode() {
    // Arrange, Act and Assert
    assertNull((new TbMsgPushToCloudNode()).getEventTypeByEntityType(EntityType.TENANT));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgPushToCloudNode}
   *   <li>{@link TbMsgPushToCloudNode#getAlarmEventType()}
   *   <li>{@link TbMsgPushToCloudNode#getConfigClazz()}
   *   <li>{@link TbMsgPushToCloudNode#getIgnoredMessageSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgPushToCloudNode actualTbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    Object actualAlarmEventType = actualTbMsgPushToCloudNode.getAlarmEventType();
    Class<TbMsgPushToCloudNodeConfiguration> actualConfigClazz = actualTbMsgPushToCloudNode.getConfigClazz();

    // Assert
    assertNull(actualAlarmEventType);
    assertNull(actualTbMsgPushToCloudNode.getIgnoredMessageSource());
    Class<TbMsgPushToCloudNodeConfiguration> expectedConfigClazz = TbMsgPushToCloudNodeConfiguration.class;
    assertEquals(expectedConfigClazz, actualConfigClazz);
  }
}
