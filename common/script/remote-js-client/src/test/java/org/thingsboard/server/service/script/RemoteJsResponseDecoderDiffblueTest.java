package org.thingsboard.server.service.script;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.Advice;
import com.google.api.BackendRule;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FeatureSetDefaults;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.js.JsInvokeProtos;
import org.thingsboard.server.gen.js.JsInvokeProtos.JsCompileResponse;
import org.thingsboard.server.gen.js.JsInvokeProtos.JsInvokeResponse;
import org.thingsboard.server.gen.js.JsInvokeProtos.JsReleaseResponse;
import org.thingsboard.server.gen.js.JsInvokeProtos.RemoteJsResponse;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.common.DefaultTbQueueMsg;
import org.thingsboard.server.queue.common.DefaultTbQueueMsgHeaders;
import org.thingsboard.server.queue.common.TbProtoJsQueueMsg;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;

class RemoteJsResponseDecoderDiffblueTest {
  /**
   * Test {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}.
   * <p>
   * Method under test: {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbProtoQueueMsg RemoteJsResponseDecoder.decode(TbQueueMsg)"})
  void testDecode() throws IOException {
    // Arrange
    RemoteJsResponseDecoder remoteJsResponseDecoder = new RemoteJsResponseDecoder();
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act
    TbProtoQueueMsg<RemoteJsResponse> actualDecodeResult = remoteJsResponseDecoder
        .decode(new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, defaultInstance, new DefaultTbQueueMsgHeaders())));

    // Assert
    RemoteJsResponse value = actualDecodeResult.getValue();
    assertEquals(value, value.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = value.getUnknownFields();
    JsCompileResponse compileResponse = value.getCompileResponse();
    assertSame(unknownFields, compileResponse.getUnknownFields());
    JsInvokeResponse invokeResponse = value.getInvokeResponse();
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    JsReleaseResponse releaseResponse = value.getReleaseResponse();
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, value.getCompileResponseOrBuilder());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, value.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, value.getReleaseResponseOrBuilder());
    assertArrayEquals(new byte[]{}, actualDecodeResult.getData());
  }

  /**
   * Test {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}.
   * <ul>
   *   <li>Then return Value DefaultInstanceForType is Value.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg); then return Value DefaultInstanceForType is Value")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbProtoQueueMsg RemoteJsResponseDecoder.decode(TbQueueMsg)"})
  void testDecode_thenReturnValueDefaultInstanceForTypeIsValue() throws IOException {
    // Arrange
    RemoteJsResponseDecoder remoteJsResponseDecoder = new RemoteJsResponseDecoder();
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    TbProtoQueueMsg<RemoteJsResponse> actualDecodeResult = remoteJsResponseDecoder
        .decode(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance()));

    // Assert
    RemoteJsResponse value = actualDecodeResult.getValue();
    assertEquals(value, value.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = value.getUnknownFields();
    JsCompileResponse compileResponse = value.getCompileResponse();
    assertSame(unknownFields, compileResponse.getUnknownFields());
    JsInvokeResponse invokeResponse = value.getInvokeResponse();
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    JsReleaseResponse releaseResponse = value.getReleaseResponse();
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, value.getCompileResponseOrBuilder());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, value.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, value.getReleaseResponseOrBuilder());
    assertArrayEquals(new byte[]{}, actualDecodeResult.getData());
  }

  /**
   * Test {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}.
   * <ul>
   *   <li>Then return Value DefaultInstanceForType is Value.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg); then return Value DefaultInstanceForType is Value")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbProtoQueueMsg RemoteJsResponseDecoder.decode(TbQueueMsg)"})
  void testDecode_thenReturnValueDefaultInstanceForTypeIsValue2() throws IOException {
    // Arrange
    RemoteJsResponseDecoder remoteJsResponseDecoder = new RemoteJsResponseDecoder();
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    TbProtoQueueMsg<RemoteJsResponse> actualDecodeResult = remoteJsResponseDecoder
        .decode(new TbProtoJsQueueMsg<>(key, FeatureSetDefaults.getDefaultInstance()));

    // Assert
    RemoteJsResponse value = actualDecodeResult.getValue();
    assertEquals(value, value.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = value.getUnknownFields();
    JsCompileResponse compileResponse = value.getCompileResponse();
    assertSame(unknownFields, compileResponse.getUnknownFields());
    JsInvokeResponse invokeResponse = value.getInvokeResponse();
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    JsReleaseResponse releaseResponse = value.getReleaseResponse();
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, value.getCompileResponseOrBuilder());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, value.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, value.getReleaseResponseOrBuilder());
    assertArrayEquals(new byte[]{}, actualDecodeResult.getData());
  }

  /**
   * Test {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}.
   * <ul>
   *   <li>Then return Value DefaultInstanceForType is Value.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg); then return Value DefaultInstanceForType is Value")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbProtoQueueMsg RemoteJsResponseDecoder.decode(TbQueueMsg)"})
  void testDecode_thenReturnValueDefaultInstanceForTypeIsValue3() throws IOException {
    // Arrange
    RemoteJsResponseDecoder remoteJsResponseDecoder = new RemoteJsResponseDecoder();
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    TbProtoQueueMsg<RemoteJsResponse> actualDecodeResult = remoteJsResponseDecoder
        .decode(new TbProtoJsQueueMsg<>(key, BackendRule.getDefaultInstance()));

    // Assert
    RemoteJsResponse value = actualDecodeResult.getValue();
    assertEquals(value, value.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = value.getUnknownFields();
    JsCompileResponse compileResponse = value.getCompileResponse();
    assertSame(unknownFields, compileResponse.getUnknownFields());
    JsInvokeResponse invokeResponse = value.getInvokeResponse();
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    JsReleaseResponse releaseResponse = value.getReleaseResponse();
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, value.getCompileResponseOrBuilder());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, value.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, value.getReleaseResponseOrBuilder());
    assertArrayEquals(new byte[]{}, actualDecodeResult.getData());
  }

  /**
   * Test {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}.
   * <ul>
   *   <li>When {@link DefaultTbQueueMsg#DefaultTbQueueMsg(TbQueueMsg)} with msg is {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg); when DefaultTbQueueMsg(TbQueueMsg) with msg is TbProtoJsQueueMsg(UUID, GeneratedMessageV3)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbProtoQueueMsg RemoteJsResponseDecoder.decode(TbQueueMsg)"})
  void testDecode_whenDefaultTbQueueMsgWithMsgIsTbProtoJsQueueMsg() throws IOException {
    // Arrange
    RemoteJsResponseDecoder remoteJsResponseDecoder = new RemoteJsResponseDecoder();
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    TbProtoQueueMsg<RemoteJsResponse> actualDecodeResult = remoteJsResponseDecoder
        .decode(new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance())));

    // Assert
    RemoteJsResponse value = actualDecodeResult.getValue();
    assertEquals(value, value.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = value.getUnknownFields();
    JsCompileResponse compileResponse = value.getCompileResponse();
    assertSame(unknownFields, compileResponse.getUnknownFields());
    JsInvokeResponse invokeResponse = value.getInvokeResponse();
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    JsReleaseResponse releaseResponse = value.getReleaseResponse();
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, value.getCompileResponseOrBuilder());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, value.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, value.getReleaseResponseOrBuilder());
    assertArrayEquals(new byte[]{}, actualDecodeResult.getData());
  }
}
