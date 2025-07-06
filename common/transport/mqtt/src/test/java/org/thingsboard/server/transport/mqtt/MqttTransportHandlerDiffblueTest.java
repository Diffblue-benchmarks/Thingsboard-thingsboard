package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonParseException;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.mqtt.MqttConnectMessage;
import io.netty.handler.codec.mqtt.MqttConnectPayload;
import io.netty.handler.codec.mqtt.MqttConnectVariableHeader;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPubReplyMessageVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttReasonCodeAndPropertiesVariableHeader;
import io.netty.handler.codec.mqtt.MqttVersion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.thingsboard.server.transport.mqtt.session.DeviceSessionCtx;
import org.thingsboard.server.transport.mqtt.session.MqttTopicMatcher;

class MqttTransportHandlerDiffblueTest {
  /**
   * Test {@link MqttTransportHandler#channelRegistered(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   *   <li>Then calls {@link ChannelHandlerContext#fireChannelRegistered()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelRegistered(ChannelHandlerContext)}
   */
  @Test
  @DisplayName(
      "Test channelRegistered(ChannelHandlerContext); given ChannelHandlerContext; then calls fireChannelRegistered()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportHandler.channelRegistered(ChannelHandlerContext)"})
  void testChannelRegistered_givenChannelHandlerContext_thenCallsFireChannelRegistered()
      throws Exception {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRegistered()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttTransportHandler.channelRegistered(ctx);

    // Assert
    verify(ctx).fireChannelRegistered();
  }

  /**
   * Test {@link MqttTransportHandler#channelUnregistered(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#fireChannelUnregistered()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelUnregistered(ChannelHandlerContext)}
   */
  @Test
  @DisplayName(
      "Test channelUnregistered(ChannelHandlerContext); then calls fireChannelUnregistered()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportHandler.channelUnregistered(ChannelHandlerContext)"})
  void testChannelUnregistered_thenCallsFireChannelUnregistered() throws Exception {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelUnregistered()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttTransportHandler.channelUnregistered(ctx);

    // Assert
    verify(ctx).fireChannelUnregistered();
  }

  /**
   * Test {@link MqttTransportHandler#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); then throw JsonParseException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportHandler.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_thenThrowJsonParseException() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenThrow(new JsonParseException("[{}] Processing msg: {}"));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.channelRead(ctx, "Msg"));
    verify(ctx).channel();
  }

  /**
   * Test {@link MqttTransportHandler#getAddress(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link JsonParseException#JsonParseException(String)} with {@code Msg}.
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#getAddress(ChannelHandlerContext)}
   */
  @Test
  @DisplayName(
      "Test getAddress(ChannelHandlerContext); given JsonParseException(String) with 'Msg'; then throw JsonParseException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.net.InetSocketAddress MqttTransportHandler.getAddress(ChannelHandlerContext)"
  })
  void testGetAddress_givenJsonParseExceptionWithMsg_thenThrowJsonParseException() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenThrow(new JsonParseException("Msg"));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.getAddress(ctx));
    verify(ctx).channel();
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName("Test processMqttMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(null);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.processMqttMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(ctx).channel();
    verify(ctx).close();
    assertSame(ctx, mqttTransportHandler.deviceSessionCtx.getChannel());
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName("Test processMqttMsg(ChannelHandlerContext, MqttMessage); given EmbeddedChannel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg_givenEmbeddedChannel() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.processMqttMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
    assertSame(ctx, mqttTransportHandler.deviceSessionCtx.getChannel());
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test processMqttMsg(ChannelHandlerContext, MqttMessage); then throw JsonParseException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg_thenThrowJsonParseException() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel())
        .thenThrow(
            new JsonParseException(
                "Closing current session because msq queue size for device {} exceed limit {} with msgQueueSize counter"
                    + " {} and actual queue size {}"));

    // Act and Assert
    assertThrows(
        JsonParseException.class,
        () ->
            mqttTransportHandler.processMqttMsg(
                ctx,
                new MqttMessage(
                    new MqttFixedHeader(
                        MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3))));
    verify(ctx).channel();
  }

  /**
   * Test {@link MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage); given EmbeddedChannel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttTransportHandler.enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testEnqueueRegularSessionMsg_givenEmbeddedChannel() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.enqueueRegularSessionMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName("Test enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttTransportHandler.enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testEnqueueRegularSessionMsg_givenNull() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(null);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.enqueueRegularSessionMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(ctx).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage); then throw JsonParseException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttTransportHandler.enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testEnqueueRegularSessionMsg_thenThrowJsonParseException() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel())
        .thenThrow(
            new JsonParseException(
                "Closing current session because msq queue size for device {} exceed limit {} with msgQueueSize counter"
                    + " {} and actual queue size {}"));

    // Act and Assert
    assertThrows(
        JsonParseException.class,
        () ->
            mqttTransportHandler.enqueueRegularSessionMsg(
                ctx,
                new MqttMessage(
                    new MqttFixedHeader(
                        MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3))));
    verify(ctx).channel();
  }

  /**
   * Test {@link MqttTransportHandler#registerSubQoS(String, List, MqttQoS)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#registerSubQoS(String, List, MqttQoS)}
   */
  @Test
  @DisplayName(
      "Test registerSubQoS(String, List, MqttQoS); given two; when ArrayList() add two; then ArrayList() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportHandler.registerSubQoS(String, List, MqttQoS)"})
  void testRegisterSubQoS_givenTwo_whenArrayListAddTwo_thenArrayListSizeIsTwo() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ArrayList<Integer> grantedQoSList = new ArrayList<>();
    grantedQoSList.add(2);

    // Act
    mqttTransportHandler.registerSubQoS("Topic", grantedQoSList, MqttQoS.AT_MOST_ONCE);

    // Assert
    assertEquals(2, grantedQoSList.size());
    assertEquals(0, grantedQoSList.get(1).intValue());
    assertEquals(1, mqttTransportHandler.deviceSessionCtx.getMqttQoSMap().size());
    assertEquals(2, grantedQoSList.get(0).intValue());
  }

  /**
   * Test {@link MqttTransportHandler#registerSubQoS(String, List, MqttQoS)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#registerSubQoS(String, List, MqttQoS)}
   */
  @Test
  @DisplayName(
      "Test registerSubQoS(String, List, MqttQoS); when ArrayList(); then ArrayList() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportHandler.registerSubQoS(String, List, MqttQoS)"})
  void testRegisterSubQoS_whenArrayList_thenArrayListSizeIsOne() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ArrayList<Integer> grantedQoSList = new ArrayList<>();

    // Act
    mqttTransportHandler.registerSubQoS("Topic", grantedQoSList, MqttQoS.AT_MOST_ONCE);

    // Assert
    assertEquals(1, grantedQoSList.size());
    assertEquals(0, grantedQoSList.get(0).intValue());
    assertEquals(1, mqttTransportHandler.deviceSessionCtx.getMqttQoSMap().size());
  }

  /**
   * Test {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processConnect(ChannelHandlerContext,
   * MqttConnectMessage)}
   */
  @Test
  @DisplayName("Test processConnect(ChannelHandlerContext, MqttConnectMessage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttTransportHandler.processConnect(ChannelHandlerContext, MqttConnectMessage)"
  })
  void testProcessConnect() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttConnectVariableHeader variableHeader =
        new MqttConnectVariableHeader("Name", 3, true, true, true, 1, true, false, 1);

    // Act
    mqttTransportHandler.processConnect(
        ctx,
        new MqttConnectMessage(
            mqttFixedHeader,
            variableHeader,
            new MqttConnectPayload(
                "provision", "Will Topic", "Will Message", "provision", "iloveyou")));

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(MqttVersion.MQTT_3_1, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processConnect(ChannelHandlerContext,
   * MqttConnectMessage)}
   */
  @Test
  @DisplayName("Test processConnect(ChannelHandlerContext, MqttConnectMessage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttTransportHandler.processConnect(ChannelHandlerContext, MqttConnectMessage)"
  })
  void testProcessConnect2() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttConnectVariableHeader variableHeader =
        new MqttConnectVariableHeader("Name", 1, true, true, true, 1, true, false, 1);

    // Act
    mqttTransportHandler.processConnect(
        ctx,
        new MqttConnectMessage(
            mqttFixedHeader,
            variableHeader,
            new MqttConnectPayload(
                "provision", "Will Topic", "Will Message", "provision", "iloveyou")));

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(MqttVersion.MQTT_3_1_1, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processConnect(ChannelHandlerContext,
   * MqttConnectMessage)}
   */
  @Test
  @DisplayName("Test processConnect(ChannelHandlerContext, MqttConnectMessage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttTransportHandler.processConnect(ChannelHandlerContext, MqttConnectMessage)"
  })
  void testProcessConnect3() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttConnectVariableHeader variableHeader =
        new MqttConnectVariableHeader("Name", 5, true, true, true, 1, true, false, 1);

    // Act
    mqttTransportHandler.processConnect(
        ctx,
        new MqttConnectMessage(
            mqttFixedHeader,
            variableHeader,
            new MqttConnectPayload(
                "provision", "Will Topic", "Will Message", "provision", "iloveyou")));

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(MqttVersion.MQTT_5, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processConnect(ChannelHandlerContext,
   * MqttConnectMessage)}
   */
  @Test
  @DisplayName("Test processConnect(ChannelHandlerContext, MqttConnectMessage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttTransportHandler.processConnect(ChannelHandlerContext, MqttConnectMessage)"
  })
  void testProcessConnect4() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttConnectVariableHeader variableHeader =
        new MqttConnectVariableHeader("Name", 3, true, true, true, 1, true, true, 1);

    // Act
    mqttTransportHandler.processConnect(
        ctx,
        new MqttConnectMessage(
            mqttFixedHeader,
            variableHeader,
            new MqttConnectPayload(
                "provision", "Will Topic", "Will Message", "provision", "iloveyou")));

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(MqttVersion.MQTT_3_1, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processConnect(ChannelHandlerContext,
   * MqttConnectMessage)}
   */
  @Test
  @DisplayName("Test processConnect(ChannelHandlerContext, MqttConnectMessage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttTransportHandler.processConnect(ChannelHandlerContext, MqttConnectMessage)"
  })
  void testProcessConnect5() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttConnectVariableHeader variableHeader =
        new MqttConnectVariableHeader("Name", 3, true, true, true, 1, true, false, 1);

    // Act
    mqttTransportHandler.processConnect(
        ctx,
        new MqttConnectMessage(
            mqttFixedHeader,
            variableHeader,
            new MqttConnectPayload(
                "provision", "Will Topic", "Will Message", "janedoe", "iloveyou")));

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(MqttVersion.MQTT_3_1, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#processConnect(ChannelHandlerContext,
   * MqttConnectMessage)}
   */
  @Test
  @DisplayName(
      "Test processConnect(ChannelHandlerContext, MqttConnectMessage); then throw JsonParseException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttTransportHandler.processConnect(ChannelHandlerContext, MqttConnectMessage)"
  })
  void testProcessConnect_thenThrowJsonParseException() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenThrow(new JsonParseException("[{}][{}] Processing connect msg for client: {}!"));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttConnectVariableHeader variableHeader =
        new MqttConnectVariableHeader("Name", 3, true, true, true, 1, true, false, 1);

    // Act and Assert
    assertThrows(
        JsonParseException.class,
        () ->
            mqttTransportHandler.processConnect(
                ctx,
                new MqttConnectMessage(
                    mqttFixedHeader,
                    variableHeader,
                    new MqttConnectPayload(
                        "provision", "Will Topic", "Will Message", "provision", "iloveyou"))));
    verify(ctx).writeAndFlush(isA(Object.class));
  }

  /**
   * Test {@link MqttTransportHandler#channelReadComplete(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelReadComplete(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelReadComplete(ChannelHandlerContext); given ChannelHandlerContext")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportHandler.channelReadComplete(ChannelHandlerContext)"})
  void testChannelReadComplete_givenChannelHandlerContext() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.flush()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttTransportHandler.channelReadComplete(ctx);

    // Assert
    verify(ctx).flush();
  }

  /**
   * Test {@link MqttTransportHandler#channelReadComplete(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelReadComplete(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelReadComplete(ChannelHandlerContext); then throw JsonParseException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportHandler.channelReadComplete(ChannelHandlerContext)"})
  void testChannelReadComplete_thenThrowJsonParseException() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.flush()).thenThrow(new JsonParseException("Msg"));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.channelReadComplete(ctx));
    verify(ctx).flush();
  }

  /**
   * Test {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName("Test exceptionCaught(ChannelHandlerContext, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught() {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {

      // Arrange
      mockRuntime
          .when(Runtime::getRuntime)
          .thenThrow(new JsonParseException("[{}] Unexpected Exception"));
      MqttTransportHandler mqttTransportHandler =
          new MqttTransportHandler(new MqttTransportContext(), null);
      ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
      when(ctx.channel()).thenReturn(null);
      when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

      // Act and Assert
      assertThrows(
          JsonParseException.class,
          () ->
              mqttTransportHandler.exceptionCaught(
                  ctx, new OutOfMemoryError("[{}] Unexpected Exception")));
      verify(ctx).channel();
      verify(ctx).close();
      mockRuntime.verify(Runtime::getRuntime);
    }
  }

  /**
   * Test {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName("Test exceptionCaught(ChannelHandlerContext, Throwable); given EmbeddedChannel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenEmbeddedChannel() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link JsonParseException#JsonParseException(String)} with msg is {@code [{}]
   *       Unexpected Exception}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given JsonParseException(String) with msg is '[{}] Unexpected Exception'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenJsonParseExceptionWithMsgIsUnexpectedException() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenThrow(new JsonParseException("[{}] Unexpected Exception"));

    // Act and Assert
    assertThrows(
        JsonParseException.class, () -> mqttTransportHandler.exceptionCaught(ctx, new Throwable()));
    verify(ctx).channel();
  }

  /**
   * Test {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ChannelHandlerContext} {@link ChannelHandlerContext#channel()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given 'null'; when ChannelHandlerContext channel() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenNull_whenChannelHandlerContextChannelReturnNull() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(null);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(ctx).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link IOException#IOException(String)} with {@code [{}] Unexpected Exception}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given 'null'; when IOException(String) with '[{}] Unexpected Exception'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenNull_whenIOExceptionWithUnexpectedException() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(null);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.exceptionCaught(ctx, new IOException("[{}] Unexpected Exception"));

    // Assert
    verify(ctx).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link Runtime} {@link Runtime#exit(int)} does nothing.
   *   <li>Then calls {@link Runtime#exit(int)}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given Runtime exit(int) does nothing; then calls exit(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenRuntimeExitDoesNothing_thenCallsExit() {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {

      // Arrange
      Runtime runtime = mock(Runtime.class);
      doNothing().when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
      MqttTransportHandler mqttTransportHandler =
          new MqttTransportHandler(new MqttTransportContext(), null);
      ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
      when(ctx.channel()).thenReturn(null);
      when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

      // Act
      mqttTransportHandler.exceptionCaught(ctx, new OutOfMemoryError("[{}] Unexpected Exception"));

      // Assert
      verify(ctx).channel();
      verify(ctx).close();
      verify(runtime).exit(eq(1));
      mockRuntime.verify(Runtime::getRuntime);
    }
  }

  /**
   * Test {@link MqttTransportHandler#createMqttPubAckMsg(DeviceSessionCtx, int, byte)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#createMqttPubAckMsg(DeviceSessionCtx, int,
   * byte)}
   */
  @Test
  @DisplayName("Test createMqttPubAckMsg(DeviceSessionCtx, int, byte)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "MqttMessage MqttTransportHandler.createMqttPubAckMsg(DeviceSessionCtx, int, byte)"
  })
  void testCreateMqttPubAckMsg() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    MqttMessage actualCreateMqttPubAckMsgResult =
        MqttTransportHandler.createMqttPubAckMsg(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), 1, (byte) 'A');

    // Assert
    Object variableHeaderResult = actualCreateMqttPubAckMsgResult.variableHeader();
    assertTrue(variableHeaderResult instanceof MqttPubReplyMessageVariableHeader);
    assertNull(actualCreateMqttPubAckMsgResult.payload());
    DecoderResult decoderResultResult = actualCreateMqttPubAckMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals((byte) 0, ((MqttPubReplyMessageVariableHeader) variableHeaderResult).reasonCode());
    assertEquals(1, ((MqttPubReplyMessageVariableHeader) variableHeaderResult).messageId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPubReplyMessageVariableHeader) variableHeaderResult).properties().isEmpty());
  }

  /**
   * Test {@link MqttTransportHandler#createMqttDisconnectMsg(DeviceSessionCtx, byte)}.
   *
   * <ul>
   *   <li>Given {@code MQTT_5}.
   *   <li>Then return variableHeader reasonCode is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#createMqttDisconnectMsg(DeviceSessionCtx,
   * byte)}
   */
  @Test
  @DisplayName(
      "Test createMqttDisconnectMsg(DeviceSessionCtx, byte); given 'MQTT_5'; then return variableHeader reasonCode is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "MqttMessage MqttTransportHandler.createMqttDisconnectMsg(DeviceSessionCtx, byte)"
  })
  void testCreateMqttDisconnectMsg_givenMqtt5_thenReturnVariableHeaderReasonCodeIsA() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setMqttVersion(MqttVersion.MQTT_5);

    // Act
    MqttMessage actualCreateMqttDisconnectMsgResult =
        MqttTransportHandler.createMqttDisconnectMsg(deviceSessionCtx, (byte) 'A');

    // Assert
    Object variableHeaderResult = actualCreateMqttDisconnectMsgResult.variableHeader();
    assertTrue(variableHeaderResult instanceof MqttReasonCodeAndPropertiesVariableHeader);
    assertNull(actualCreateMqttDisconnectMsgResult.payload());
    DecoderResult decoderResultResult = actualCreateMqttDisconnectMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(
        ((MqttReasonCodeAndPropertiesVariableHeader) variableHeaderResult).properties().isEmpty());
    assertEquals(
        'A', ((MqttReasonCodeAndPropertiesVariableHeader) variableHeaderResult).reasonCode());
  }

  /**
   * Test {@link MqttTransportHandler#createMqttDisconnectMsg(DeviceSessionCtx, byte)}.
   *
   * <ul>
   *   <li>Then return variableHeader reasonCode is zero.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#createMqttDisconnectMsg(DeviceSessionCtx,
   * byte)}
   */
  @Test
  @DisplayName(
      "Test createMqttDisconnectMsg(DeviceSessionCtx, byte); then return variableHeader reasonCode is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "MqttMessage MqttTransportHandler.createMqttDisconnectMsg(DeviceSessionCtx, byte)"
  })
  void testCreateMqttDisconnectMsg_thenReturnVariableHeaderReasonCodeIsZero() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    MqttMessage actualCreateMqttDisconnectMsgResult =
        MqttTransportHandler.createMqttDisconnectMsg(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), (byte) 'A');

    // Assert
    Object variableHeaderResult = actualCreateMqttDisconnectMsgResult.variableHeader();
    assertTrue(variableHeaderResult instanceof MqttReasonCodeAndPropertiesVariableHeader);
    assertNull(actualCreateMqttDisconnectMsgResult.payload());
    DecoderResult decoderResultResult = actualCreateMqttDisconnectMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(
        (byte) 0, ((MqttReasonCodeAndPropertiesVariableHeader) variableHeaderResult).reasonCode());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(
        ((MqttReasonCodeAndPropertiesVariableHeader) variableHeaderResult).properties().isEmpty());
  }
}
