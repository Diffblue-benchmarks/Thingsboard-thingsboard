package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.rpc.RpcStatus;

class RpcV2ControllerDiffblueTest {
  /**
   * Test
   * {@link RpcV2Controller#getPersistedRpcByDevice(String, int, int, RpcStatus, String, String, String)}.
   * <ul>
   *   <li>When {@code DELETED}.</li>
   *   <li>Then throw {@link ResponseStatusException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RpcV2Controller#getPersistedRpcByDevice(String, int, int, RpcStatus, String, String, String)}
   */
  @Test
  @DisplayName("Test getPersistedRpcByDevice(String, int, int, RpcStatus, String, String, String); when 'DELETED'; then throw ResponseStatusException")
  void testGetPersistedRpcByDevice_whenDeleted_thenThrowResponseStatusException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ResponseStatusException.class, () -> (new RpcV2Controller()).getPersistedRpcByDevice("42", 3, 1,
        RpcStatus.DELETED, "Text Search", "Sort Property", "asc"));
  }
}
