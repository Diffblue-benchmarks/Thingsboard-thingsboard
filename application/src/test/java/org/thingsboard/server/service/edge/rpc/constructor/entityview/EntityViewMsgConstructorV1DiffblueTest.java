package org.thingsboard.server.service.edge.rpc.constructor.entityview;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class EntityViewMsgConstructorV1DiffblueTest {
  /**
   * Test {@link EntityViewMsgConstructorV1#constructEntityViewUpdatedMsg(UpdateMsgType, EntityView)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewMsgConstructorV1#constructEntityViewUpdatedMsg(UpdateMsgType, EntityView)}
   */
  @Test
  @DisplayName("Test constructEntityViewUpdatedMsg(UpdateMsgType, EntityView); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.EntityViewUpdateMsg EntityViewMsgConstructorV1.constructEntityViewUpdatedMsg(UpdateMsgType, EntityView)"})
  void testConstructEntityViewUpdatedMsg_thenThrowRuntimeException() {
    // Arrange
    EntityViewMsgConstructorV1 entityViewMsgConstructorV1 = new EntityViewMsgConstructorV1();

    EntityView entityView = new EntityView();
    entityView.setEntityId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> entityViewMsgConstructorV1
        .constructEntityViewUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, entityView));
  }
}
