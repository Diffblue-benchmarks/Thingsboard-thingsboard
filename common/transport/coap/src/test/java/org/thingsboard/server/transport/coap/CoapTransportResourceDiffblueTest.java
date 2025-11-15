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
