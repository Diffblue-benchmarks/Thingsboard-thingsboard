package org.thingsboard.server.service.edge.rpc.constructor.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.NotificationRuleInfo;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.gen.edge.v1.NotificationRuleUpdateMsg;
import org.thingsboard.server.gen.edge.v1.NotificationTargetUpdateMsg;
import org.thingsboard.server.gen.edge.v1.NotificationTemplateUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class NotificationMsgConstructorImplDiffblueTest {
  /**
   * Test {@link NotificationMsgConstructorImpl#constructNotificationRuleUpdateMsg(UpdateMsgType,
   * NotificationRule)}.
   *
   * <p>Method under test: {@link
   * NotificationMsgConstructorImpl#constructNotificationRuleUpdateMsg(UpdateMsgType,
   * NotificationRule)}
   */
  @Test
  @DisplayName("Test constructNotificationRuleUpdateMsg(UpdateMsgType, NotificationRule)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationRuleUpdateMsg NotificationMsgConstructorImpl.constructNotificationRuleUpdateMsg(UpdateMsgType, NotificationRule)"
  })
  void testConstructNotificationRuleUpdateMsg() {
    // Arrange
    NotificationMsgConstructorImpl notificationMsgConstructorImpl =
        new NotificationMsgConstructorImpl();

    // Act
    NotificationRuleUpdateMsg actualConstructNotificationRuleUpdateMsgResult =
        notificationMsgConstructorImpl.constructNotificationRuleUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, new NotificationRule());

    // Assert
    assertEquals(198, actualConstructNotificationRuleUpdateMsgResult.getSerializedSize());
    UnknownFieldSet unknownFields =
        actualConstructNotificationRuleUpdateMsgResult.getUnknownFields();
    NotificationRuleUpdateMsg defaultInstanceForType =
        actualConstructNotificationRuleUpdateMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link NotificationMsgConstructorImpl#constructNotificationRuleUpdateMsg(UpdateMsgType,
   * NotificationRule)}.
   *
   * <p>Method under test: {@link
   * NotificationMsgConstructorImpl#constructNotificationRuleUpdateMsg(UpdateMsgType,
   * NotificationRule)}
   */
  @Test
  @DisplayName("Test constructNotificationRuleUpdateMsg(UpdateMsgType, NotificationRule)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationRuleUpdateMsg NotificationMsgConstructorImpl.constructNotificationRuleUpdateMsg(UpdateMsgType, NotificationRule)"
  })
  void testConstructNotificationRuleUpdateMsg2() {
    // Arrange
    NotificationMsgConstructorImpl notificationMsgConstructorImpl =
        new NotificationMsgConstructorImpl();

    // Act
    NotificationRuleUpdateMsg actualConstructNotificationRuleUpdateMsgResult =
        notificationMsgConstructorImpl.constructNotificationRuleUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, new NotificationRuleInfo());

    // Assert
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"name\":null,\"enabled\":false,\"templateId\":null,\"triggerType"
            + "\":null,\"triggerConfig\":null,\"recipientsConfig\":null,\"additionalConfig\":null,\"externalId\":null,"
            + "\"templateName\":null,\"deliveryMethods\":null}",
        actualConstructNotificationRuleUpdateMsgResult.getEntityBytes().toStringUtf8());
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"name\":null,\"enabled\":false,\"templateId\":null,\"triggerType"
            + "\":null,\"triggerConfig\":null,\"recipientsConfig\":null,\"additionalConfig\":null,\"externalId\":null,"
            + "\"templateName\":null,\"deliveryMethods\":null}",
        actualConstructNotificationRuleUpdateMsgResult.getEntity());
    assertEquals(241, actualConstructNotificationRuleUpdateMsgResult.getSerializedSize());
    UnknownFieldSet unknownFields =
        actualConstructNotificationRuleUpdateMsgResult.getUnknownFields();
    NotificationRuleUpdateMsg defaultInstanceForType =
        actualConstructNotificationRuleUpdateMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link NotificationMsgConstructorImpl#constructNotificationRuleUpdateMsg(UpdateMsgType,
   * NotificationRule)}.
   *
   * <ul>
   *   <li>Then return MsgTypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationMsgConstructorImpl#constructNotificationRuleUpdateMsg(UpdateMsgType,
   * NotificationRule)}
   */
  @Test
  @DisplayName(
      "Test constructNotificationRuleUpdateMsg(UpdateMsgType, NotificationRule); then return MsgTypeValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationRuleUpdateMsg NotificationMsgConstructorImpl.constructNotificationRuleUpdateMsg(UpdateMsgType, NotificationRule)"
  })
  void testConstructNotificationRuleUpdateMsg_thenReturnMsgTypeValueIsOne() {
    // Arrange
    NotificationMsgConstructorImpl notificationMsgConstructorImpl =
        new NotificationMsgConstructorImpl();

    // Act
    NotificationRuleUpdateMsg actualConstructNotificationRuleUpdateMsgResult =
        notificationMsgConstructorImpl.constructNotificationRuleUpdateMsg(
            UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, new NotificationRule());

    // Assert
    assertEquals(1, actualConstructNotificationRuleUpdateMsgResult.getMsgTypeValue());
    assertEquals(2, actualConstructNotificationRuleUpdateMsgResult.getAllFields().size());
    assertEquals(200, actualConstructNotificationRuleUpdateMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE,
        actualConstructNotificationRuleUpdateMsgResult.getMsgType());
    UnknownFieldSet unknownFields =
        actualConstructNotificationRuleUpdateMsgResult.getUnknownFields();
    NotificationRuleUpdateMsg defaultInstanceForType =
        actualConstructNotificationRuleUpdateMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link NotificationMsgConstructorImpl#constructNotificationRuleUpdateMsg(UpdateMsgType,
   * NotificationRule)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is two hundred fifty.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationMsgConstructorImpl#constructNotificationRuleUpdateMsg(UpdateMsgType,
   * NotificationRule)}
   */
  @Test
  @DisplayName(
      "Test constructNotificationRuleUpdateMsg(UpdateMsgType, NotificationRule); then return SerializedSize is two hundred fifty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationRuleUpdateMsg NotificationMsgConstructorImpl.constructNotificationRuleUpdateMsg(UpdateMsgType, NotificationRule)"
  })
  void testConstructNotificationRuleUpdateMsg_thenReturnSerializedSizeIsTwoHundredFifty() {
    // Arrange
    NotificationMsgConstructorImpl notificationMsgConstructorImpl =
        new NotificationMsgConstructorImpl();
    NotificationRule rule = new NotificationRule();

    // Act
    NotificationRuleUpdateMsg actualConstructNotificationRuleUpdateMsgResult =
        notificationMsgConstructorImpl.constructNotificationRuleUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
            new NotificationRuleInfo(rule, "Template Name", new ArrayList<>()));

    // Assert
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"name\":null,\"enabled\":false,\"templateId\":null,\"triggerType"
            + "\":null,\"triggerConfig\":null,\"recipientsConfig\":null,\"additionalConfig\":null,\"externalId\":null,"
            + "\"templateName\":\"Template Name\",\"deliveryMethods\":[]}",
        actualConstructNotificationRuleUpdateMsgResult.getEntityBytes().toStringUtf8());
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"name\":null,\"enabled\":false,\"templateId\":null,\"triggerType"
            + "\":null,\"triggerConfig\":null,\"recipientsConfig\":null,\"additionalConfig\":null,\"externalId\":null,"
            + "\"templateName\":\"Template Name\",\"deliveryMethods\":[]}",
        actualConstructNotificationRuleUpdateMsgResult.getEntity());
    assertEquals(250, actualConstructNotificationRuleUpdateMsgResult.getSerializedSize());
    UnknownFieldSet unknownFields =
        actualConstructNotificationRuleUpdateMsgResult.getUnknownFields();
    NotificationRuleUpdateMsg defaultInstanceForType =
        actualConstructNotificationRuleUpdateMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

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
  @Tag("MaintainedByDiffblue")
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
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
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
  @Tag("MaintainedByDiffblue")
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
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link NotificationMsgConstructorImpl#constructNotificationTargetUpdateMsg(UpdateMsgType,
   * NotificationTarget)}.
   *
   * <ul>
   *   <li>Then return MsgTypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationMsgConstructorImpl#constructNotificationTargetUpdateMsg(UpdateMsgType,
   * NotificationTarget)}
   */
  @Test
  @DisplayName(
      "Test constructNotificationTargetUpdateMsg(UpdateMsgType, NotificationTarget); then return MsgTypeValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationTargetUpdateMsg NotificationMsgConstructorImpl.constructNotificationTargetUpdateMsg(UpdateMsgType, NotificationTarget)"
  })
  void testConstructNotificationTargetUpdateMsg_thenReturnMsgTypeValueIsOne() {
    // Arrange
    NotificationMsgConstructorImpl notificationMsgConstructorImpl =
        new NotificationMsgConstructorImpl();

    // Act
    NotificationTargetUpdateMsg actualConstructNotificationTargetUpdateMsgResult =
        notificationMsgConstructorImpl.constructNotificationTargetUpdateMsg(
            UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, new NotificationTarget());

    // Assert
    assertEquals(1, actualConstructNotificationTargetUpdateMsgResult.getMsgTypeValue());
    assertEquals(2, actualConstructNotificationTargetUpdateMsgResult.getAllFields().size());
    assertEquals(98, actualConstructNotificationTargetUpdateMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE,
        actualConstructNotificationTargetUpdateMsgResult.getMsgType());
    UnknownFieldSet unknownFields =
        actualConstructNotificationTargetUpdateMsgResult.getUnknownFields();
    NotificationTargetUpdateMsg defaultInstanceForType =
        actualConstructNotificationTargetUpdateMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link NotificationMsgConstructorImpl#constructNotificationTargetUpdateMsg(UpdateMsgType,
   * NotificationTarget)}.
   *
   * <ul>
   *   <li>Then return MsgTypeValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationMsgConstructorImpl#constructNotificationTargetUpdateMsg(UpdateMsgType,
   * NotificationTarget)}
   */
  @Test
  @DisplayName(
      "Test constructNotificationTargetUpdateMsg(UpdateMsgType, NotificationTarget); then return MsgTypeValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationTargetUpdateMsg NotificationMsgConstructorImpl.constructNotificationTargetUpdateMsg(UpdateMsgType, NotificationTarget)"
  })
  void testConstructNotificationTargetUpdateMsg_thenReturnMsgTypeValueIsZero() {
    // Arrange
    NotificationMsgConstructorImpl notificationMsgConstructorImpl =
        new NotificationMsgConstructorImpl();

    // Act
    NotificationTargetUpdateMsg actualConstructNotificationTargetUpdateMsgResult =
        notificationMsgConstructorImpl.constructNotificationTargetUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, new NotificationTarget());

    // Assert
    assertEquals(0, actualConstructNotificationTargetUpdateMsgResult.getMsgTypeValue());
    assertEquals(1, actualConstructNotificationTargetUpdateMsgResult.getAllFields().size());
    assertEquals(96, actualConstructNotificationTargetUpdateMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructNotificationTargetUpdateMsgResult.getMsgType());
    UnknownFieldSet unknownFields =
        actualConstructNotificationTargetUpdateMsgResult.getUnknownFields();
    NotificationTargetUpdateMsg defaultInstanceForType =
        actualConstructNotificationTargetUpdateMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link
   * NotificationMsgConstructorImpl#constructNotificationTargetDeleteMsg(NotificationTargetId)}.
   *
   * <p>Method under test: {@link
   * NotificationMsgConstructorImpl#constructNotificationTargetDeleteMsg(NotificationTargetId)}
   */
  @Test
  @DisplayName("Test constructNotificationTargetDeleteMsg(NotificationTargetId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationTargetUpdateMsg NotificationMsgConstructorImpl.constructNotificationTargetDeleteMsg(NotificationTargetId)"
  })
  void testConstructNotificationTargetDeleteMsg() {
    // Arrange
    NotificationMsgConstructorImpl notificationMsgConstructorImpl =
        new NotificationMsgConstructorImpl();

    // Act
    NotificationTargetUpdateMsg actualConstructNotificationTargetDeleteMsgResult =
        notificationMsgConstructorImpl.constructNotificationTargetDeleteMsg(
            new NotificationTargetId(UUID.randomUUID()));

    // Assert
    UnknownFieldSet unknownFields =
        actualConstructNotificationTargetDeleteMsgResult.getUnknownFields();
    NotificationTargetUpdateMsg defaultInstanceForType =
        actualConstructNotificationTargetDeleteMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link
   * NotificationMsgConstructorImpl#constructNotificationTargetDeleteMsg(NotificationTargetId)}.
   *
   * <ul>
   *   <li>Then return IdLSB is {@code -7476899250389416711}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationMsgConstructorImpl#constructNotificationTargetDeleteMsg(NotificationTargetId)}
   */
  @Test
  @DisplayName(
      "Test constructNotificationTargetDeleteMsg(NotificationTargetId); then return IdLSB is '-7476899250389416711'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationTargetUpdateMsg NotificationMsgConstructorImpl.constructNotificationTargetDeleteMsg(NotificationTargetId)"
  })
  void testConstructNotificationTargetDeleteMsg_thenReturnIdLSBIs7476899250389416711() {
    // Arrange
    NotificationMsgConstructorImpl notificationMsgConstructorImpl =
        new NotificationMsgConstructorImpl();

    // Act
    NotificationTargetUpdateMsg actualConstructNotificationTargetDeleteMsgResult =
        notificationMsgConstructorImpl.constructNotificationTargetDeleteMsg(
            new NotificationTargetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(
        -7476899250389416711L, actualConstructNotificationTargetDeleteMsgResult.getIdLSB());
    assertEquals(23, actualConstructNotificationTargetDeleteMsgResult.getSerializedSize());
    assertEquals(8669210807411032922L, actualConstructNotificationTargetDeleteMsgResult.getIdMSB());
    UnknownFieldSet unknownFields =
        actualConstructNotificationTargetDeleteMsgResult.getUnknownFields();
    NotificationTargetUpdateMsg defaultInstanceForType =
        actualConstructNotificationTargetDeleteMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link
   * NotificationMsgConstructorImpl#constructNotificationTemplateUpdateMsg(UpdateMsgType,
   * NotificationTemplate)}.
   *
   * <ul>
   *   <li>Then return MsgTypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationMsgConstructorImpl#constructNotificationTemplateUpdateMsg(UpdateMsgType,
   * NotificationTemplate)}
   */
  @Test
  @DisplayName(
      "Test constructNotificationTemplateUpdateMsg(UpdateMsgType, NotificationTemplate); then return MsgTypeValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationTemplateUpdateMsg NotificationMsgConstructorImpl.constructNotificationTemplateUpdateMsg(UpdateMsgType, NotificationTemplate)"
  })
  void testConstructNotificationTemplateUpdateMsg_thenReturnMsgTypeValueIsOne() {
    // Arrange
    NotificationMsgConstructorImpl notificationMsgConstructorImpl =
        new NotificationMsgConstructorImpl();

    // Act
    NotificationTemplateUpdateMsg actualConstructNotificationTemplateUpdateMsgResult =
        notificationMsgConstructorImpl.constructNotificationTemplateUpdateMsg(
            UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, new NotificationTemplate());

    // Assert
    assertEquals(1, actualConstructNotificationTemplateUpdateMsgResult.getMsgTypeValue());
    assertEquals(122, actualConstructNotificationTemplateUpdateMsgResult.getSerializedSize());
    assertEquals(2, actualConstructNotificationTemplateUpdateMsgResult.getAllFields().size());
    assertEquals(
        UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE,
        actualConstructNotificationTemplateUpdateMsgResult.getMsgType());
    UnknownFieldSet unknownFields =
        actualConstructNotificationTemplateUpdateMsgResult.getUnknownFields();
    NotificationTemplateUpdateMsg defaultInstanceForType =
        actualConstructNotificationTemplateUpdateMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link
   * NotificationMsgConstructorImpl#constructNotificationTemplateUpdateMsg(UpdateMsgType,
   * NotificationTemplate)}.
   *
   * <ul>
   *   <li>Then return MsgTypeValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationMsgConstructorImpl#constructNotificationTemplateUpdateMsg(UpdateMsgType,
   * NotificationTemplate)}
   */
  @Test
  @DisplayName(
      "Test constructNotificationTemplateUpdateMsg(UpdateMsgType, NotificationTemplate); then return MsgTypeValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationTemplateUpdateMsg NotificationMsgConstructorImpl.constructNotificationTemplateUpdateMsg(UpdateMsgType, NotificationTemplate)"
  })
  void testConstructNotificationTemplateUpdateMsg_thenReturnMsgTypeValueIsZero() {
    // Arrange
    NotificationMsgConstructorImpl notificationMsgConstructorImpl =
        new NotificationMsgConstructorImpl();

    // Act
    NotificationTemplateUpdateMsg actualConstructNotificationTemplateUpdateMsgResult =
        notificationMsgConstructorImpl.constructNotificationTemplateUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, new NotificationTemplate());

    // Assert
    assertEquals(0, actualConstructNotificationTemplateUpdateMsgResult.getMsgTypeValue());
    assertEquals(1, actualConstructNotificationTemplateUpdateMsgResult.getAllFields().size());
    assertEquals(120, actualConstructNotificationTemplateUpdateMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructNotificationTemplateUpdateMsgResult.getMsgType());
    UnknownFieldSet unknownFields =
        actualConstructNotificationTemplateUpdateMsgResult.getUnknownFields();
    NotificationTemplateUpdateMsg defaultInstanceForType =
        actualConstructNotificationTemplateUpdateMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link
   * NotificationMsgConstructorImpl#constructNotificationTemplateDeleteMsg(NotificationTemplateId)}.
   *
   * <p>Method under test: {@link
   * NotificationMsgConstructorImpl#constructNotificationTemplateDeleteMsg(NotificationTemplateId)}
   */
  @Test
  @DisplayName("Test constructNotificationTemplateDeleteMsg(NotificationTemplateId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationTemplateUpdateMsg NotificationMsgConstructorImpl.constructNotificationTemplateDeleteMsg(NotificationTemplateId)"
  })
  void testConstructNotificationTemplateDeleteMsg() {
    // Arrange
    NotificationMsgConstructorImpl notificationMsgConstructorImpl =
        new NotificationMsgConstructorImpl();

    // Act
    NotificationTemplateUpdateMsg actualConstructNotificationTemplateDeleteMsgResult =
        notificationMsgConstructorImpl.constructNotificationTemplateDeleteMsg(
            new NotificationTemplateId(UUID.randomUUID()));

    // Assert
    UnknownFieldSet unknownFields =
        actualConstructNotificationTemplateDeleteMsgResult.getUnknownFields();
    NotificationTemplateUpdateMsg defaultInstanceForType =
        actualConstructNotificationTemplateDeleteMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link
   * NotificationMsgConstructorImpl#constructNotificationTemplateDeleteMsg(NotificationTemplateId)}.
   *
   * <ul>
   *   <li>Then return IdLSB is {@code -7476899250389416711}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationMsgConstructorImpl#constructNotificationTemplateDeleteMsg(NotificationTemplateId)}
   */
  @Test
  @DisplayName(
      "Test constructNotificationTemplateDeleteMsg(NotificationTemplateId); then return IdLSB is '-7476899250389416711'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationTemplateUpdateMsg NotificationMsgConstructorImpl.constructNotificationTemplateDeleteMsg(NotificationTemplateId)"
  })
  void testConstructNotificationTemplateDeleteMsg_thenReturnIdLSBIs7476899250389416711() {
    // Arrange
    NotificationMsgConstructorImpl notificationMsgConstructorImpl =
        new NotificationMsgConstructorImpl();

    // Act
    NotificationTemplateUpdateMsg actualConstructNotificationTemplateDeleteMsgResult =
        notificationMsgConstructorImpl.constructNotificationTemplateDeleteMsg(
            new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(
        -7476899250389416711L, actualConstructNotificationTemplateDeleteMsgResult.getIdLSB());
    assertEquals(
        8669210807411032922L, actualConstructNotificationTemplateDeleteMsgResult.getIdMSB());
    UnknownFieldSet unknownFields =
        actualConstructNotificationTemplateDeleteMsgResult.getUnknownFields();
    NotificationTemplateUpdateMsg defaultInstanceForType =
        actualConstructNotificationTemplateDeleteMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }
}
