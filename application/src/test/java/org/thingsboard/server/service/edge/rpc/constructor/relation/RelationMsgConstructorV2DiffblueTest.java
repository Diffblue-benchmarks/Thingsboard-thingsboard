package org.thingsboard.server.service.edge.rpc.constructor.relation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.gen.edge.v1.RelationUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class RelationMsgConstructorV2DiffblueTest {
  /**
   * Test {@link RelationMsgConstructorV2#constructRelationUpdatedMsg(UpdateMsgType,
   * EntityRelation)}.
   *
   * <p>Method under test: {@link
   * RelationMsgConstructorV2#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}
   */
  @Test
  @DisplayName("Test constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RelationUpdateMsg RelationMsgConstructorV2.constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)"
  })
  void testConstructRelationUpdatedMsg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RelationMsgConstructorV2 relationMsgConstructorV2 = new RelationMsgConstructorV2();

    // Act
    RelationUpdateMsg actualConstructRelationUpdatedMsgResult =
        relationMsgConstructorV2.constructRelationUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, new EntityRelation());

    // Assert
    assertEquals("", actualConstructRelationUpdatedMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructRelationUpdatedMsgResult.getAdditionalInfo());
    assertEquals("", actualConstructRelationUpdatedMsgResult.getFromEntityType());
    assertEquals("", actualConstructRelationUpdatedMsgResult.getToEntityType());
    assertEquals("", actualConstructRelationUpdatedMsgResult.getType());
    assertEquals("", actualConstructRelationUpdatedMsgResult.getTypeGroup());
    assertEquals(
        "{\"from\":null,\"to\":null,\"type\":null,\"typeGroup\":null,\"version\":null,\"additionalInfo\":null}",
        actualConstructRelationUpdatedMsgResult.getEntity());
    assertEquals(0, actualConstructRelationUpdatedMsgResult.getMsgTypeValue());
    assertEquals(0L, actualConstructRelationUpdatedMsgResult.getFromIdLSB());
    assertEquals(0L, actualConstructRelationUpdatedMsgResult.getFromIdMSB());
    assertEquals(0L, actualConstructRelationUpdatedMsgResult.getToIdLSB());
    assertEquals(0L, actualConstructRelationUpdatedMsgResult.getToIdMSB());
    assertEquals(1, actualConstructRelationUpdatedMsgResult.getAllFields().size());
    assertEquals(91, actualConstructRelationUpdatedMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructRelationUpdatedMsgResult.getMsgType());
    assertFalse(actualConstructRelationUpdatedMsgResult.hasTypeGroup());
    assertTrue(actualConstructRelationUpdatedMsgResult.findInitializationErrors().isEmpty());
  }

  /**
   * Test {@link RelationMsgConstructorV2#constructRelationUpdatedMsg(UpdateMsgType,
   * EntityRelation)}.
   *
   * <ul>
   *   <li>Then return Entity is a string.
   * </ul>
   *
   * <p>Method under test: {@link
   * RelationMsgConstructorV2#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}
   */
  @Test
  @DisplayName(
      "Test constructRelationUpdatedMsg(UpdateMsgType, EntityRelation); then return Entity is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RelationUpdateMsg RelationMsgConstructorV2.constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)"
  })
  void testConstructRelationUpdatedMsg_thenReturnEntityIsAString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RelationMsgConstructorV2 relationMsgConstructorV2 = new RelationMsgConstructorV2();

    EntityRelation entityRelation = new EntityRelation();
    entityRelation.setFrom(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RelationUpdateMsg actualConstructRelationUpdatedMsgResult =
        relationMsgConstructorV2.constructRelationUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, entityRelation);

    // Assert
    assertEquals("", actualConstructRelationUpdatedMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructRelationUpdatedMsgResult.getAdditionalInfo());
    assertEquals("", actualConstructRelationUpdatedMsgResult.getFromEntityType());
    assertEquals("", actualConstructRelationUpdatedMsgResult.getToEntityType());
    assertEquals("", actualConstructRelationUpdatedMsgResult.getType());
    assertEquals("", actualConstructRelationUpdatedMsgResult.getTypeGroup());
    assertEquals(
        "{\"from\":{\"entityType\":\"ALARM\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"to\":null,\"type\":null,"
            + "\"typeGroup\":null,\"version\":null,\"additionalInfo\":null}",
        actualConstructRelationUpdatedMsgResult.getEntity());
    assertEquals(0, actualConstructRelationUpdatedMsgResult.getMsgTypeValue());
    assertEquals(0L, actualConstructRelationUpdatedMsgResult.getFromIdLSB());
    assertEquals(0L, actualConstructRelationUpdatedMsgResult.getFromIdMSB());
    assertEquals(0L, actualConstructRelationUpdatedMsgResult.getToIdLSB());
    assertEquals(0L, actualConstructRelationUpdatedMsgResult.getToIdMSB());
    assertEquals(1, actualConstructRelationUpdatedMsgResult.getAllFields().size());
    assertEquals(154, actualConstructRelationUpdatedMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructRelationUpdatedMsgResult.getMsgType());
    assertFalse(actualConstructRelationUpdatedMsgResult.hasTypeGroup());
    assertTrue(actualConstructRelationUpdatedMsgResult.findInitializationErrors().isEmpty());
  }
}
