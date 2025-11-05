package org.thingsboard.rule.engine.mail;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;

@ExtendWith(MockitoExtension.class)
class TbMsgToEmailNodeDiffblueTest {
  @InjectMocks private TbMsgToEmailNode tbMsgToEmailNode;

  @Mock private TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration;

  /**
   * Test {@link TbMsgToEmailNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code START_OBJECT}.
   *   <li>Then calls {@link ArrayNode#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; when ArrayNode asToken() return 'START_OBJECT'; then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgToEmailNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_whenArrayNodeAsTokenReturnStartObject_thenCallsFields()
      throws TbNodeException {
    // Arrange
    TbMsgToEmailNode tbMsgToEmailNode = new TbMsgToEmailNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbMsgToEmailNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgToEmailNodeConfiguration} {@link
   *       TbMsgToEmailNodeConfiguration#getBccTemplate()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgToEmailNodeConfiguration getBccTemplate() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgToEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgToEmailNodeConfigurationGetBccTemplateReturnEmptyString() {
    // Arrange
    when(tbMsgToEmailNodeConfiguration.getBccTemplate()).thenReturn("");
    when(tbMsgToEmailNodeConfiguration.getBodyTemplate()).thenReturn("Not all who wander are lost");
    when(tbMsgToEmailNodeConfiguration.getCcTemplate()).thenReturn("Cc Template");
    when(tbMsgToEmailNodeConfiguration.getFromTemplate()).thenReturn("jane.doe@example.org");
    when(tbMsgToEmailNodeConfiguration.getMailBodyType()).thenReturn("Not all who wander are lost");
    when(tbMsgToEmailNodeConfiguration.getSubjectTemplate())
        .thenReturn("Hello from the Dreaming Spires");
    when(tbMsgToEmailNodeConfiguration.getToTemplate()).thenReturn("To Template");

    TbContext ctx = mock(TbContext.class);
    TbMsg telemetryMsgResult =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    when(ctx.transformMsg(
            Mockito.<TbMsg>any(),
            Mockito.<TbMsgType>any(),
            Mockito.<EntityId>any(),
            Mockito.<TbMsgMetaData>any(),
            Mockito.<String>any()))
        .thenReturn(telemetryMsgResult);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgToEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Success"));
    verify(ctx)
        .transformMsg(
            isA(TbMsg.class),
            eq(TbMsgType.SEND_EMAIL),
            (EntityId) isNull(),
            isA(TbMsgMetaData.class),
            eq(
                "{\"from\":\"jane.doe@example.org\",\"to\":\"To Template\",\"cc\":\"Cc Template\",\"bcc\":null,\"subject\":\"Hello from the Dreaming Spires\",\"body\":\"Not all who wander are lost\",\"images\":null,\"html\":false}"));
    verify(tbMsgToEmailNodeConfiguration).getBccTemplate();
    verify(tbMsgToEmailNodeConfiguration).getBodyTemplate();
    verify(tbMsgToEmailNodeConfiguration).getCcTemplate();
    verify(tbMsgToEmailNodeConfiguration).getFromTemplate();
    verify(tbMsgToEmailNodeConfiguration).getMailBodyType();
    verify(tbMsgToEmailNodeConfiguration).getSubjectTemplate();
    verify(tbMsgToEmailNodeConfiguration).getToTemplate();
  }

  /**
   * Test {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgToEmailNode} (default constructor).
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgToEmailNode (default constructor); then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgToEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgToEmailNode_thenCallsTellFailure() {
    // Arrange
    TbMsgToEmailNode tbMsgToEmailNode = new TbMsgToEmailNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgToEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#tellNext(TbMsg, String)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls tellNext(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgToEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsTellNext() {
    // Arrange
    when(tbMsgToEmailNodeConfiguration.getBccTemplate()).thenReturn("mary.somerville@example.org");
    when(tbMsgToEmailNodeConfiguration.getBodyTemplate()).thenReturn("Not all who wander are lost");
    when(tbMsgToEmailNodeConfiguration.getCcTemplate()).thenReturn("Cc Template");
    when(tbMsgToEmailNodeConfiguration.getFromTemplate()).thenReturn("jane.doe@example.org");
    when(tbMsgToEmailNodeConfiguration.getMailBodyType()).thenReturn("Not all who wander are lost");
    when(tbMsgToEmailNodeConfiguration.getSubjectTemplate())
        .thenReturn("Hello from the Dreaming Spires");
    when(tbMsgToEmailNodeConfiguration.getToTemplate()).thenReturn("To Template");

    TbContext ctx = mock(TbContext.class);
    TbMsg telemetryMsgResult =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    when(ctx.transformMsg(
            Mockito.<TbMsg>any(),
            Mockito.<TbMsgType>any(),
            Mockito.<EntityId>any(),
            Mockito.<TbMsgMetaData>any(),
            Mockito.<String>any()))
        .thenReturn(telemetryMsgResult);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgToEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Success"));
    verify(ctx)
        .transformMsg(
            isA(TbMsg.class),
            eq(TbMsgType.SEND_EMAIL),
            (EntityId) isNull(),
            isA(TbMsgMetaData.class),
            eq(
                "{\"from\":\"jane.doe@example.org\",\"to\":\"To Template\",\"cc\":\"Cc Template\",\"bcc\":\"mary.somerville@example.org\",\"subject\":\"Hello from the Dreaming Spires\",\"body\":\"Not all who wander are lost\",\"images\":null,\"html\":false}"));
    verify(tbMsgToEmailNodeConfiguration).getBccTemplate();
    verify(tbMsgToEmailNodeConfiguration).getBodyTemplate();
    verify(tbMsgToEmailNodeConfiguration).getCcTemplate();
    verify(tbMsgToEmailNodeConfiguration).getFromTemplate();
    verify(tbMsgToEmailNodeConfiguration).getMailBodyType();
    verify(tbMsgToEmailNodeConfiguration).getSubjectTemplate();
    verify(tbMsgToEmailNodeConfiguration).getToTemplate();
  }
}
