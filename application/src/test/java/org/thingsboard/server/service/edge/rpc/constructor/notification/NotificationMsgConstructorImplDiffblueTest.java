package org.thingsboard.server.service.edge.rpc.constructor.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.gen.edge.v1.NotificationRuleUpdateMsg;

class NotificationMsgConstructorImplDiffblueTest {
  /**
   * Test {@link
   * NotificationMsgConstructorImpl#constructNotificationRuleDeleteMsg(NotificationRuleId)}.
   *
   * <ul>
   *   <li>Then return IdLSB is {@code -7476899250389416711}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationMsgConstructorImpl#constructNotificationRuleDeleteMsg(NotificationRuleId)}
   */
  @Test
  @DisplayName(
      "Test constructNotificationRuleDeleteMsg(NotificationRuleId); then return IdLSB is '-7476899250389416711'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRuleUpdateMsg NotificationMsgConstructorImpl.constructNotificationRuleDeleteMsg(NotificationRuleId)"
  })
  void testConstructNotificationRuleDeleteMsg_thenReturnIdLSBIs7476899250389416711() {
    // Arrange
    NotificationMsgConstructorImpl notificationMsgConstructorImpl =
        new NotificationMsgConstructorImpl();

    // Act
    NotificationRuleUpdateMsg actualConstructNotificationRuleDeleteMsgResult =
        notificationMsgConstructorImpl.constructNotificationRuleDeleteMsg(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(-7476899250389416711L, actualConstructNotificationRuleDeleteMsgResult.getIdLSB());
    assertEquals(23, actualConstructNotificationRuleDeleteMsgResult.getSerializedSize());
    assertEquals(8669210807411032922L, actualConstructNotificationRuleDeleteMsgResult.getIdMSB());
    UnknownFieldSet unknownFields =
        actualConstructNotificationRuleDeleteMsgResult.getUnknownFields();
    NotificationRuleUpdateMsg defaultInstanceForType =
        actualConstructNotificationRuleDeleteMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link
   * NotificationMsgConstructorImpl#constructNotificationRuleDeleteMsg(NotificationRuleId)}.
   *
   * <ul>
   *   <li>When {@link NotificationRuleId#NotificationRuleId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationMsgConstructorImpl#constructNotificationRuleDeleteMsg(NotificationRuleId)}
   */
  @Test
  @DisplayName(
      "Test constructNotificationRuleDeleteMsg(NotificationRuleId); when NotificationRuleId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRuleUpdateMsg NotificationMsgConstructorImpl.constructNotificationRuleDeleteMsg(NotificationRuleId)"
  })
  void testConstructNotificationRuleDeleteMsg_whenNotificationRuleIdWithIdIsRandomUUID() {
    // Arrange
    NotificationMsgConstructorImpl notificationMsgConstructorImpl =
        new NotificationMsgConstructorImpl();

    // Act
    NotificationRuleUpdateMsg actualConstructNotificationRuleDeleteMsgResult =
        notificationMsgConstructorImpl.constructNotificationRuleDeleteMsg(
            new NotificationRuleId(UUID.randomUUID()));

    // Assert
    UnknownFieldSet unknownFields =
        actualConstructNotificationRuleDeleteMsgResult.getUnknownFields();
    NotificationRuleUpdateMsg defaultInstanceForType =
        actualConstructNotificationRuleDeleteMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }
}
