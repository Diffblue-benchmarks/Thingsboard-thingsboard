package org.thingsboard.server.service.edge.rpc.constructor.entityview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.gen.edge.v1.EdgeEntityType;
import org.thingsboard.server.gen.edge.v1.EntityViewUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class BaseEntityViewMsgConstructorDiffblueTest {
  /**
   * Test {@link BaseEntityViewMsgConstructor#constructEntityViewDeleteMsg(EntityViewId)}.
   *
   * <p>Method under test: {@link
   * BaseEntityViewMsgConstructor#constructEntityViewDeleteMsg(EntityViewId)}
   */
  @Test
  @DisplayName("Test constructEntityViewDeleteMsg(EntityViewId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityViewUpdateMsg BaseEntityViewMsgConstructor.constructEntityViewDeleteMsg(EntityViewId)"
  })
  void testConstructEntityViewDeleteMsg() {
    // Arrange
    EntityViewMsgConstructorV1 entityViewMsgConstructorV1 = new EntityViewMsgConstructorV1();

    // Act
    EntityViewUpdateMsg actualConstructEntityViewDeleteMsgResult =
        entityViewMsgConstructorV1.constructEntityViewDeleteMsg(
            new EntityViewId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructEntityViewDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructEntityViewDeleteMsgResult.getAdditionalInfo());
    assertEquals("", actualConstructEntityViewDeleteMsgResult.getEntity());
    assertEquals("", actualConstructEntityViewDeleteMsgResult.getName());
    assertEquals("", actualConstructEntityViewDeleteMsgResult.getType());
    assertEquals(-7476899250389416711L, actualConstructEntityViewDeleteMsgResult.getIdLSB());
    assertEquals(0, actualConstructEntityViewDeleteMsgResult.getEntityTypeValue());
    assertEquals(0L, actualConstructEntityViewDeleteMsgResult.getCustomerIdLSB());
    assertEquals(0L, actualConstructEntityViewDeleteMsgResult.getCustomerIdMSB());
    assertEquals(0L, actualConstructEntityViewDeleteMsgResult.getEntityIdLSB());
    assertEquals(0L, actualConstructEntityViewDeleteMsgResult.getEntityIdMSB());
    assertEquals(2, actualConstructEntityViewDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructEntityViewDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructEntityViewDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructEntityViewDeleteMsgResult.getIdMSB());
    assertEquals(EdgeEntityType.DEVICE, actualConstructEntityViewDeleteMsgResult.getEntityType());
    assertEquals(
        UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE,
        actualConstructEntityViewDeleteMsgResult.getMsgType());
    assertFalse(actualConstructEntityViewDeleteMsgResult.hasAdditionalInfo());
    assertFalse(actualConstructEntityViewDeleteMsgResult.hasCustomerIdLSB());
    assertFalse(actualConstructEntityViewDeleteMsgResult.hasCustomerIdMSB());
    assertTrue(actualConstructEntityViewDeleteMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructEntityViewDeleteMsgResult.isInitialized());
  }
}
