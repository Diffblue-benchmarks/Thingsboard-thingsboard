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
