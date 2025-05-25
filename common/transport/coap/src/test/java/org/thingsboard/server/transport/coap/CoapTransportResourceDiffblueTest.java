package org.thingsboard.server.transport.coap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.eclipse.californium.core.coap.Request;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CoapTransportResourceDiffblueTest {
  /**
   * Test {@link CoapTransportResource#getRequestId(Request)}.
   * <ul>
   *   <li>Given {@code Failed to decode feature type: {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapTransportResource#getRequestId(Request)}
   */
  @Test
  @DisplayName("Test getRequestId(Request); given 'Failed to decode feature type: {}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CoapTransportResource.getRequestId(Request)"})
  void testGetRequestId_givenFailedToDecodeFeatureType() {
    // Arrange
    Request request = Request.newDelete();
    request.setProxyUri("Failed to decode feature type: {}");

    // Act
    Optional<Integer> actualRequestId = CoapTransportResource.getRequestId(request);

    // Assert
    assertFalse(actualRequestId.isPresent());
  }

  /**
   * Test {@link CoapTransportResource#getRequestId(Request)}.
   * <ul>
   *   <li>When newDelete.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapTransportResource#getRequestId(Request)}
   */
  @Test
  @DisplayName("Test getRequestId(Request); when newDelete; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CoapTransportResource.getRequestId(Request)"})
  void testGetRequestId_whenNewDelete_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Integer> actualRequestId = CoapTransportResource.getRequestId(Request.newDelete());

    // Assert
    assertFalse(actualRequestId.isPresent());
  }
}
