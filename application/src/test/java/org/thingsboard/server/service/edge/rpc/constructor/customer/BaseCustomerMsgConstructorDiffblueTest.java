package org.thingsboard.server.service.edge.rpc.constructor.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.gen.edge.v1.CustomerUpdateMsg;

class BaseCustomerMsgConstructorDiffblueTest {
  /**
   * Test {@link BaseCustomerMsgConstructor#constructCustomerDeleteMsg(CustomerId)}.
   * <ul>
   *   <li>Then return IdLSB is {@code -7476899250389416711}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseCustomerMsgConstructor#constructCustomerDeleteMsg(CustomerId)}
   */
  @Test
  @DisplayName("Test constructCustomerDeleteMsg(CustomerId); then return IdLSB is '-7476899250389416711'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CustomerUpdateMsg BaseCustomerMsgConstructor.constructCustomerDeleteMsg(CustomerId)"})
  void testConstructCustomerDeleteMsg_thenReturnIdLSBIs7476899250389416711() {
    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();

    // Act
    CustomerUpdateMsg actualConstructCustomerDeleteMsgResult = customerMsgConstructorV1
        .constructCustomerDeleteMsg(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(-7476899250389416711L, actualConstructCustomerDeleteMsgResult.getIdLSB());
    assertEquals(23, actualConstructCustomerDeleteMsgResult.getSerializedSize());
    assertEquals(8669210807411032922L, actualConstructCustomerDeleteMsgResult.getIdMSB());
  }
}
