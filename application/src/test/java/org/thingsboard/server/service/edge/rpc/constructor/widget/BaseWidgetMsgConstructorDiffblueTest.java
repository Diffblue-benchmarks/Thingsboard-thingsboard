package org.thingsboard.server.service.edge.rpc.constructor.widget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.UnknownFieldSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;
import org.thingsboard.server.gen.edge.v1.WidgetTypeUpdateMsg;
import org.thingsboard.server.gen.edge.v1.WidgetsBundleUpdateMsg;

@ExtendWith(MockitoExtension.class)
class BaseWidgetMsgConstructorDiffblueTest {
  @InjectMocks
  private WidgetMsgConstructorV1 widgetMsgConstructorV1;

  /**
   * Test {@link BaseWidgetMsgConstructor#constructWidgetsBundleDeleteMsg(WidgetsBundleId)}.
   * <p>
   * Method under test: {@link BaseWidgetMsgConstructor#constructWidgetsBundleDeleteMsg(WidgetsBundleId)}
   */
  @Test
  @DisplayName("Test constructWidgetsBundleDeleteMsg(WidgetsBundleId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "WidgetsBundleUpdateMsg BaseWidgetMsgConstructor.constructWidgetsBundleDeleteMsg(WidgetsBundleId)"})
  void testConstructWidgetsBundleDeleteMsg() {
    // Arrange
    WidgetMsgConstructorV1 widgetMsgConstructorV1 = new WidgetMsgConstructorV1();

    // Act
    WidgetsBundleUpdateMsg actualConstructWidgetsBundleDeleteMsgResult = widgetMsgConstructorV1
        .constructWidgetsBundleDeleteMsg(new WidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    UnknownFieldSet unknownFields = actualConstructWidgetsBundleDeleteMsgResult.getUnknownFields();
    WidgetsBundleUpdateMsg defaultInstanceForType = actualConstructWidgetsBundleDeleteMsgResult
        .getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    ByteString expectedImage = actualConstructWidgetsBundleDeleteMsgResult.getImage();
    assertSame(expectedImage, defaultInstanceForType.getImage());
  }

  /**
   * Test {@link BaseWidgetMsgConstructor#constructWidgetsBundleDeleteMsg(WidgetsBundleId)}.
   * <ul>
   *   <li>Given {@link WidgetMsgConstructorV1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseWidgetMsgConstructor#constructWidgetsBundleDeleteMsg(WidgetsBundleId)}
   */
  @Test
  @DisplayName("Test constructWidgetsBundleDeleteMsg(WidgetsBundleId); given WidgetMsgConstructorV1")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "WidgetsBundleUpdateMsg BaseWidgetMsgConstructor.constructWidgetsBundleDeleteMsg(WidgetsBundleId)"})
  void testConstructWidgetsBundleDeleteMsg_givenWidgetMsgConstructorV1() {
    // Arrange and Act
    WidgetsBundleUpdateMsg actualConstructWidgetsBundleDeleteMsgResult = widgetMsgConstructorV1
        .constructWidgetsBundleDeleteMsg(new WidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    UnknownFieldSet unknownFields = actualConstructWidgetsBundleDeleteMsgResult.getUnknownFields();
    WidgetsBundleUpdateMsg defaultInstanceForType = actualConstructWidgetsBundleDeleteMsgResult
        .getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    ByteString expectedImage = actualConstructWidgetsBundleDeleteMsgResult.getImage();
    assertSame(expectedImage, defaultInstanceForType.getImage());
  }

  /**
   * Test {@link BaseWidgetMsgConstructor#constructWidgetTypeDeleteMsg(WidgetTypeId)}.
   * <p>
   * Method under test: {@link BaseWidgetMsgConstructor#constructWidgetTypeDeleteMsg(WidgetTypeId)}
   */
  @Test
  @DisplayName("Test constructWidgetTypeDeleteMsg(WidgetTypeId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetTypeUpdateMsg BaseWidgetMsgConstructor.constructWidgetTypeDeleteMsg(WidgetTypeId)"})
  void testConstructWidgetTypeDeleteMsg() {
    // Arrange
    WidgetMsgConstructorV1 widgetMsgConstructorV1 = new WidgetMsgConstructorV1();

    // Act
    WidgetTypeUpdateMsg actualConstructWidgetTypeDeleteMsgResult = widgetMsgConstructorV1
        .constructWidgetTypeDeleteMsg(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructWidgetTypeDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructWidgetTypeDeleteMsgResult.getAlias());
    assertEquals("", actualConstructWidgetTypeDeleteMsgResult.getBundleAlias());
    assertEquals("", actualConstructWidgetTypeDeleteMsgResult.getDescription());
    assertEquals("", actualConstructWidgetTypeDeleteMsgResult.getDescriptorJson());
    assertEquals("", actualConstructWidgetTypeDeleteMsgResult.getEntity());
    assertEquals("", actualConstructWidgetTypeDeleteMsgResult.getFqn());
    assertEquals("", actualConstructWidgetTypeDeleteMsgResult.getImage());
    assertEquals("", actualConstructWidgetTypeDeleteMsgResult.getName());
    assertEquals(-7476899250389416711L, actualConstructWidgetTypeDeleteMsgResult.getIdLSB());
    assertEquals(0, actualConstructWidgetTypeDeleteMsgResult.getTagsCount());
    assertEquals(2, actualConstructWidgetTypeDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructWidgetTypeDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructWidgetTypeDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructWidgetTypeDeleteMsgResult.getIdMSB());
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, actualConstructWidgetTypeDeleteMsgResult.getMsgType());
    assertFalse(actualConstructWidgetTypeDeleteMsgResult.getDeprecated());
    assertFalse(actualConstructWidgetTypeDeleteMsgResult.getIsSystem());
    assertFalse(actualConstructWidgetTypeDeleteMsgResult.hasAlias());
    assertFalse(actualConstructWidgetTypeDeleteMsgResult.hasBundleAlias());
    assertFalse(actualConstructWidgetTypeDeleteMsgResult.hasDescription());
    assertFalse(actualConstructWidgetTypeDeleteMsgResult.hasDescriptorJson());
    assertFalse(actualConstructWidgetTypeDeleteMsgResult.hasFqn());
    assertFalse(actualConstructWidgetTypeDeleteMsgResult.hasImage());
    assertFalse(actualConstructWidgetTypeDeleteMsgResult.hasName());
    assertTrue(actualConstructWidgetTypeDeleteMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructWidgetTypeDeleteMsgResult.getTagsList().isEmpty());
    assertTrue(actualConstructWidgetTypeDeleteMsgResult.isInitialized());
  }
}
