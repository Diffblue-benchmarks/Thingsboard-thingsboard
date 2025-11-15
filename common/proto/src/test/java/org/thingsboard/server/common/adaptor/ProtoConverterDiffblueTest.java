/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.adaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Any;
import com.google.protobuf.Api;
import com.google.protobuf.BytesValue;
import com.google.protobuf.Descriptors;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;

class ProtoConverterDiffblueTest {
  /**
   * Method under test: {@link ProtoConverter#convertToTelemetryProto(byte[])}
   */
  @Test
  void testConvertToTelemetryProto() throws InvalidProtocolBufferException, IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ProtoConverter.convertToTelemetryProto(new byte[]{}));
    assertThrows(IllegalArgumentException.class, () -> ProtoConverter.convertToTelemetryProto(
        new byte[]{'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', Byte.MIN_VALUE, 'A', '\b'}));
  }

  /**
   * Method under test:
   * {@link ProtoConverter#dynamicMsgToJson(byte[], Descriptors.Descriptor)}
   */
  @Test
  void testDynamicMsgToJson() throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals("{}", ProtoConverter.dynamicMsgToJson(new byte[]{}, Any.getDescriptor()));
    assertEquals("{}", ProtoConverter.dynamicMsgToJson(new byte[]{}, Any.Builder.getDescriptor()));
    assertEquals(
        "{\n" + "  \"name\": \"\",\n" + "  \"methods\": [],\n" + "  \"options\": [],\n" + "  \"version\": \"\",\n"
            + "  \"mixins\": [],\n" + "  \"syntax\": \"SYNTAX_PROTO2\"\n" + "}",
        ProtoConverter.dynamicMsgToJson(new byte[]{}, Api.getDescriptor()));
    assertEquals("\"\"", ProtoConverter.dynamicMsgToJson(new byte[]{}, BytesValue.getDescriptor()));
  }

  /**
   * Method under test:
   * {@link ProtoConverter#validateDescriptor(Descriptors.Descriptor)}
   */
  @Test
  void testValidateDescriptor() throws AdaptorException {
    // Arrange, Act and Assert
    assertThrows(AdaptorException.class, () -> ProtoConverter.validateDescriptor(null));
  }

  /**
   * Method under test:
   * {@link ProtoConverter#validatePostAttributeMsg(TransportProtos.PostAttributeMsg)}
   */
  @Test
  void testValidatePostAttributeMsg() throws InvalidProtocolBufferException, IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ProtoConverter.validatePostAttributeMsg(TransportProtos.PostAttributeMsg.getDefaultInstance()));
  }

  /**
   * Method under test: {@link ProtoConverter#validatePostTelemetryMsg(byte[])}
   */
  @Test
  void testValidatePostTelemetryMsg() throws InvalidProtocolBufferException, IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ProtoConverter.validatePostTelemetryMsg(new byte[]{}));
  }
}
