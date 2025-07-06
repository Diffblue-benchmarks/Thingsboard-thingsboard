package org.thingsboard.server.service.edge.rpc.constructor.widget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;
import org.thingsboard.server.gen.edge.v1.WidgetTypeUpdateMsg;
import org.thingsboard.server.gen.edge.v1.WidgetsBundleUpdateMsg;

class WidgetMsgConstructorV2DiffblueTest {
  /**
   * Test {@link WidgetMsgConstructorV2#constructWidgetsBundleUpdateMsg(UpdateMsgType,
   * WidgetsBundle, List)}.
   *
   * <p>Method under test: {@link
   * WidgetMsgConstructorV2#constructWidgetsBundleUpdateMsg(UpdateMsgType, WidgetsBundle, List)}
   */
  @Test
  @DisplayName("Test constructWidgetsBundleUpdateMsg(UpdateMsgType, WidgetsBundle, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "WidgetsBundleUpdateMsg WidgetMsgConstructorV2.constructWidgetsBundleUpdateMsg(UpdateMsgType, WidgetsBundle, List)"
  })
  void testConstructWidgetsBundleUpdateMsg() {
    // Arrange
    WidgetMsgConstructorV2 widgetMsgConstructorV2 = new WidgetMsgConstructorV2();

    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setId(
        new WidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    WidgetsBundleUpdateMsg actualConstructWidgetsBundleUpdateMsgResult =
        widgetMsgConstructorV2.constructWidgetsBundleUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, widgetsBundle, new ArrayList<>());

    // Assert
    assertEquals("", actualConstructWidgetsBundleUpdateMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructWidgetsBundleUpdateMsgResult.getAlias());
    assertEquals("", actualConstructWidgetsBundleUpdateMsgResult.getDescription());
    assertEquals("", actualConstructWidgetsBundleUpdateMsgResult.getTitle());
    assertEquals("[]", actualConstructWidgetsBundleUpdateMsgResult.getWidgets());
    assertEquals(
        "{\"id\":{\"entityType\":\"WIDGETS_BUNDLE\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,"
            + "\"tenantId\":null,\"alias\":null,\"title\":null,\"image\":null,\"scada\":false,\"description\":null,\"order\":null"
            + ",\"externalId\":null,\"version\":null,\"name\":null}",
        actualConstructWidgetsBundleUpdateMsgResult.getEntity());
    assertEquals(-7476899250389416711L, actualConstructWidgetsBundleUpdateMsgResult.getIdLSB());
    assertEquals(0, actualConstructWidgetsBundleUpdateMsgResult.getMsgTypeValue());
    assertEquals(0, actualConstructWidgetsBundleUpdateMsgResult.getOrder());
    assertEquals(272, actualConstructWidgetsBundleUpdateMsgResult.getSerializedSize());
    assertEquals(4, actualConstructWidgetsBundleUpdateMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructWidgetsBundleUpdateMsgResult.getIdMSB());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructWidgetsBundleUpdateMsgResult.getMsgType());
    assertFalse(actualConstructWidgetsBundleUpdateMsgResult.getIsSystem());
    assertFalse(actualConstructWidgetsBundleUpdateMsgResult.hasDescription());
    assertFalse(actualConstructWidgetsBundleUpdateMsgResult.hasImage());
    assertFalse(actualConstructWidgetsBundleUpdateMsgResult.hasOrder());
    assertTrue(actualConstructWidgetsBundleUpdateMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructWidgetsBundleUpdateMsgResult.hasWidgets());
    assertTrue(actualConstructWidgetsBundleUpdateMsgResult.isInitialized());
  }

  /**
   * Test {@link WidgetMsgConstructorV2#constructWidgetTypeUpdateMsg(UpdateMsgType,
   * WidgetTypeDetails, EdgeVersion)}.
   *
   * <p>Method under test: {@link WidgetMsgConstructorV2#constructWidgetTypeUpdateMsg(UpdateMsgType,
   * WidgetTypeDetails, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructWidgetTypeUpdateMsg(UpdateMsgType, WidgetTypeDetails, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "WidgetTypeUpdateMsg WidgetMsgConstructorV2.constructWidgetTypeUpdateMsg(UpdateMsgType, WidgetTypeDetails, EdgeVersion)"
  })
  void testConstructWidgetTypeUpdateMsg() {
    // Arrange
    WidgetMsgConstructorV2 widgetMsgConstructorV2 = new WidgetMsgConstructorV2();

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setId(
        new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    WidgetTypeUpdateMsg actualConstructWidgetTypeUpdateMsgResult =
        widgetMsgConstructorV2.constructWidgetTypeUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, widgetTypeDetails, EdgeVersion.V_3_3_0);

    // Assert
    assertEquals("", actualConstructWidgetTypeUpdateMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructWidgetTypeUpdateMsgResult.getAlias());
    assertEquals("", actualConstructWidgetTypeUpdateMsgResult.getBundleAlias());
    assertEquals("", actualConstructWidgetTypeUpdateMsgResult.getDescription());
    assertEquals("", actualConstructWidgetTypeUpdateMsgResult.getDescriptorJson());
    assertEquals("", actualConstructWidgetTypeUpdateMsgResult.getFqn());
    assertEquals("", actualConstructWidgetTypeUpdateMsgResult.getImage());
    assertEquals("", actualConstructWidgetTypeUpdateMsgResult.getName());
    assertEquals(
        "{\"fqn\":null,\"name\":null,\"deprecated\":false,\"image\":null,\"description\":null,\"descriptor\":null,\"externalId"
            + "\":null,\"id\":{\"entityType\":\"WIDGET_TYPE\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0"
            + ",\"tenantId\":null,\"scada\":false,\"version\":null,\"tags\":null}",
        actualConstructWidgetTypeUpdateMsgResult.getEntity());
    assertEquals(-7476899250389416711L, actualConstructWidgetTypeUpdateMsgResult.getIdLSB());
    assertEquals(0, actualConstructWidgetTypeUpdateMsgResult.getMsgTypeValue());
    assertEquals(0, actualConstructWidgetTypeUpdateMsgResult.getTagsCount());
    assertEquals(286, actualConstructWidgetTypeUpdateMsgResult.getSerializedSize());
    assertEquals(3, actualConstructWidgetTypeUpdateMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructWidgetTypeUpdateMsgResult.getIdMSB());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructWidgetTypeUpdateMsgResult.getMsgType());
    assertFalse(actualConstructWidgetTypeUpdateMsgResult.getDeprecated());
    assertFalse(actualConstructWidgetTypeUpdateMsgResult.getIsSystem());
    assertFalse(actualConstructWidgetTypeUpdateMsgResult.hasAlias());
    assertFalse(actualConstructWidgetTypeUpdateMsgResult.hasBundleAlias());
    assertFalse(actualConstructWidgetTypeUpdateMsgResult.hasDescription());
    assertFalse(actualConstructWidgetTypeUpdateMsgResult.hasDescriptorJson());
    assertFalse(actualConstructWidgetTypeUpdateMsgResult.hasFqn());
    assertFalse(actualConstructWidgetTypeUpdateMsgResult.hasImage());
    assertFalse(actualConstructWidgetTypeUpdateMsgResult.hasName());
    assertTrue(actualConstructWidgetTypeUpdateMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructWidgetTypeUpdateMsgResult.getTagsList().isEmpty());
    assertTrue(actualConstructWidgetTypeUpdateMsgResult.isInitialized());
  }
}
