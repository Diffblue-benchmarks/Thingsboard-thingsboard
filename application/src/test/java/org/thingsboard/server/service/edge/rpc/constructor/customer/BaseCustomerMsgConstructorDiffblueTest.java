package org.thingsboard.server.service.edge.rpc.constructor.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.gen.edge.v1.CustomerUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class BaseCustomerMsgConstructorDiffblueTest {
  /**
   * Test {@link BaseCustomerMsgConstructor#constructCustomerDeleteMsg(CustomerId)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseCustomerMsgConstructor#constructCustomerDeleteMsg(CustomerId)}
   */
  @Test
  @DisplayName(
      "Test constructCustomerDeleteMsg(CustomerId); then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerUpdateMsg BaseCustomerMsgConstructor.constructCustomerDeleteMsg(CustomerId)"
  })
  void testConstructCustomerDeleteMsg_thenReturnInitializationErrorStringIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();

    // Act
    CustomerUpdateMsg actualConstructCustomerDeleteMsgResult =
        customerMsgConstructorV1.constructCustomerDeleteMsg(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructCustomerDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructCustomerDeleteMsgResult.getAdditionalInfo());
    assertEquals("", actualConstructCustomerDeleteMsgResult.getAddress());
    assertEquals("", actualConstructCustomerDeleteMsgResult.getAddress2());
    assertEquals("", actualConstructCustomerDeleteMsgResult.getCity());
    assertEquals("", actualConstructCustomerDeleteMsgResult.getCountry());
    assertEquals("", actualConstructCustomerDeleteMsgResult.getEmail());
    assertEquals("", actualConstructCustomerDeleteMsgResult.getEntity());
    assertEquals("", actualConstructCustomerDeleteMsgResult.getPhone());
    assertEquals("", actualConstructCustomerDeleteMsgResult.getState());
    assertEquals("", actualConstructCustomerDeleteMsgResult.getTitle());
    assertEquals("", actualConstructCustomerDeleteMsgResult.getZip());
    assertEquals(-7476899250389416711L, actualConstructCustomerDeleteMsgResult.getIdLSB());
    assertEquals(2, actualConstructCustomerDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructCustomerDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructCustomerDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructCustomerDeleteMsgResult.getIdMSB());
    assertEquals(
        UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE,
        actualConstructCustomerDeleteMsgResult.getMsgType());
    assertFalse(actualConstructCustomerDeleteMsgResult.hasAdditionalInfo());
    assertFalse(actualConstructCustomerDeleteMsgResult.hasAddress());
    assertFalse(actualConstructCustomerDeleteMsgResult.hasAddress2());
    assertFalse(actualConstructCustomerDeleteMsgResult.hasCity());
    assertFalse(actualConstructCustomerDeleteMsgResult.hasCountry());
    assertFalse(actualConstructCustomerDeleteMsgResult.hasEmail());
    assertFalse(actualConstructCustomerDeleteMsgResult.hasPhone());
    assertFalse(actualConstructCustomerDeleteMsgResult.hasState());
    assertFalse(actualConstructCustomerDeleteMsgResult.hasZip());
    assertTrue(actualConstructCustomerDeleteMsgResult.findInitializationErrors().isEmpty());
  }
}
