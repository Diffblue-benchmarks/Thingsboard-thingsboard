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
package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.profile.lwm2m.ObjectAttributes;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;

class TbLwM2MWriteAttributesRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MWriteAttributesRequest#getAttributes()}
   *   <li>{@link TbLwM2MWriteAttributesRequest#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ObjectAttributes attributes = new ObjectAttributes();
    attributes.setDim(1L);
    attributes.setEpmax(1L);
    attributes.setEpmin(1L);
    attributes.setGt(10.0d);
    attributes.setLt(10.0d);
    attributes.setLwm2m("Lwm2m");
    attributes.setPmax(1L);
    attributes.setPmin(1L);
    attributes.setSsid(1L);
    attributes.setSt(10.0d);
    attributes.setUri("Uri");
    attributes.setVer("Ver");
    TbLwM2MWriteAttributesRequest buildResult = TbLwM2MWriteAttributesRequest.builder()
        .attributes(attributes)
        .timeout(10L)
        .versionedId("42")
        .build();

    // Act
    ObjectAttributes actualAttributes = buildResult.getAttributes();

    // Assert
    assertEquals(LwM2MOperationType.WRITE_ATTRIBUTES, buildResult.getType());
    assertSame(attributes, actualAttributes);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbLwM2MWriteAttributesRequest.TbLwM2MWriteAttributesRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MWriteAttributesRequest.TbLwM2MWriteAttributesRequestBuilder#attributes(ObjectAttributes)}
   *   <li>
   * {@link TbLwM2MWriteAttributesRequest.TbLwM2MWriteAttributesRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MWriteAttributesRequest.TbLwM2MWriteAttributesRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  void testTbLwM2MWriteAttributesRequestBuilderBuild() {
    // Arrange
    ObjectAttributes attributes = new ObjectAttributes();
    attributes.setDim(1L);
    attributes.setEpmax(1L);
    attributes.setEpmin(1L);
    attributes.setGt(10.0d);
    attributes.setLt(10.0d);
    attributes.setLwm2m("Lwm2m");
    attributes.setPmax(1L);
    attributes.setPmin(1L);
    attributes.setSsid(1L);
    attributes.setSt(10.0d);
    attributes.setUri("Uri");
    attributes.setVer("Ver");

    // Act
    TbLwM2MWriteAttributesRequest actualBuildResult = TbLwM2MWriteAttributesRequest.builder()
        .attributes(attributes)
        .timeout(10L)
        .versionedId("42")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.WRITE_ATTRIBUTES, actualBuildResult.getType());
    assertSame(attributes, actualBuildResult.getAttributes());
  }
}
