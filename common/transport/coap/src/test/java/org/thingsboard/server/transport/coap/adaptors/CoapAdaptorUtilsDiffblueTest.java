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
package org.thingsboard.server.transport.coap.adaptors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import org.eclipse.californium.core.coap.Request;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeRequestMsg;

class CoapAdaptorUtilsDiffblueTest {
  /**
   * Test {@link CoapAdaptorUtils#toGetAttributeRequestMsg(Request)}.
   *
   * <ul>
   *   <li>When newDelete.
   * </ul>
   *
   * <p>Method under test: {@link CoapAdaptorUtils#toGetAttributeRequestMsg(Request)}
   */
  @Test
  @DisplayName("Test toGetAttributeRequestMsg(Request); when newDelete")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAttributeRequestMsg CoapAdaptorUtils.toGetAttributeRequestMsg(Request)"})
  void testToGetAttributeRequestMsg_whenNewDelete() throws AdaptorException {
    // Arrange and Act
    GetAttributeRequestMsg actualToGetAttributeRequestMsgResult =
        CoapAdaptorUtils.toGetAttributeRequestMsg(Request.newDelete());

    // Assert
    GetAttributeRequestMsg actualDefaultInstanceForType =
        actualToGetAttributeRequestMsgResult.getDefaultInstanceForType();
    assertEquals(actualToGetAttributeRequestMsgResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualToGetAttributeRequestMsgResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
    ProtocolStringList expectedSharedAttributeNamesList =
        actualToGetAttributeRequestMsgResult.getClientAttributeNamesList();
    assertSame(
        expectedSharedAttributeNamesList,
        actualToGetAttributeRequestMsgResult.getSharedAttributeNamesList());
  }

  /**
   * Test {@link CoapAdaptorUtils#toGetAttributeRequestMsg(Request)}.
   *
   * <ul>
   *   <li>When newFetch.
   * </ul>
   *
   * <p>Method under test: {@link CoapAdaptorUtils#toGetAttributeRequestMsg(Request)}
   */
  @Test
  @DisplayName("Test toGetAttributeRequestMsg(Request); when newFetch")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAttributeRequestMsg CoapAdaptorUtils.toGetAttributeRequestMsg(Request)"})
  void testToGetAttributeRequestMsg_whenNewFetch() throws AdaptorException {
    // Arrange and Act
    GetAttributeRequestMsg actualToGetAttributeRequestMsgResult =
        CoapAdaptorUtils.toGetAttributeRequestMsg(Request.newFetch());

    // Assert
    GetAttributeRequestMsg actualDefaultInstanceForType =
        actualToGetAttributeRequestMsgResult.getDefaultInstanceForType();
    assertEquals(actualToGetAttributeRequestMsgResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualToGetAttributeRequestMsgResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
    ProtocolStringList expectedSharedAttributeNamesList =
        actualToGetAttributeRequestMsgResult.getClientAttributeNamesList();
    assertSame(
        expectedSharedAttributeNamesList,
        actualToGetAttributeRequestMsgResult.getSharedAttributeNamesList());
  }
}
