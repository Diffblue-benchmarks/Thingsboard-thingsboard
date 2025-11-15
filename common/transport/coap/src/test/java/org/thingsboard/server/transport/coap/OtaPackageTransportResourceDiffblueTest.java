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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ota.OtaPackageType;

class OtaPackageTransportResourceDiffblueTest {
  /**
   * Test {@link OtaPackageTransportResource#OtaPackageTransportResource(CoapTransportContext, OtaPackageType)}.
   * <ul>
   *   <li>Then return Path is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageTransportResource#OtaPackageTransportResource(CoapTransportContext, OtaPackageType)}
   */
  @Test
  @DisplayName("Test new OtaPackageTransportResource(CoapTransportContext, OtaPackageType); then return Path is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageTransportResource.<init>(CoapTransportContext, OtaPackageType)"})
  void testNewOtaPackageTransportResource_thenReturnPathIsEmptyString() {
    // Arrange and Act
    OtaPackageTransportResource actualOtaPackageTransportResource = new OtaPackageTransportResource(
        new CoapTransportContext(), OtaPackageType.FIRMWARE);

    // Assert
    assertEquals("", actualOtaPackageTransportResource.getPath());
    assertEquals("fw", actualOtaPackageTransportResource.getName());
    assertEquals("fw", actualOtaPackageTransportResource.getURI());
    assertNull(actualOtaPackageTransportResource.getExecutor());
    assertNull(actualOtaPackageTransportResource.getObserveType());
    assertNull(actualOtaPackageTransportResource.getParent());
    assertNull(actualOtaPackageTransportResource.transportService);
    assertEquals(0, actualOtaPackageTransportResource.getNotificationSequenceNumber());
    assertEquals(0, actualOtaPackageTransportResource.getObserverCount());
    assertTrue(actualOtaPackageTransportResource.getChildren().isEmpty());
    assertTrue(actualOtaPackageTransportResource.isCachable());
    assertTrue(actualOtaPackageTransportResource.isObservable());
    assertTrue(actualOtaPackageTransportResource.isVisible());
  }

  /**
   * Test {@link OtaPackageTransportResource#getChild(String)}.
   * <p>
   * Method under test: {@link OtaPackageTransportResource#getChild(String)}
   */
  @Test
  @DisplayName("Test getChild(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.eclipse.californium.core.server.resources.Resource OtaPackageTransportResource.getChild(String)"})
  void testGetChild() {
    // Arrange
    OtaPackageTransportResource otaPackageTransportResource = new OtaPackageTransportResource(
        new CoapTransportContext(), OtaPackageType.FIRMWARE);

    // Act and Assert
    assertSame(otaPackageTransportResource, otaPackageTransportResource.getChild("Name"));
  }
}
