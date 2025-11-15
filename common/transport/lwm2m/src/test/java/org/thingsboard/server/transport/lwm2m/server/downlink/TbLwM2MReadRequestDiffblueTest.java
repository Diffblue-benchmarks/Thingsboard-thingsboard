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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MReadRequest.TbLwM2MReadRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MReadRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MReadRequestDiffblueTest {
  @Autowired
  private TbLwM2MReadRequestBuilder tbLwM2MReadRequestBuilder;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MReadRequest#getRequestContentFormat()}
   *   <li>{@link TbLwM2MReadRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional TbLwM2MReadRequest.getRequestContentFormat()",
      "LwM2MOperationType TbLwM2MReadRequest.getType()"})
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MReadRequestBuilder builderResult = TbLwM2MReadRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MReadRequest buildResult = builderResult.requestContentFormat(requestContentFormat)
        .timeout(10L)
        .versionedId("42")
        .build();

    // Act
    Optional<ContentFormat> actualRequestContentFormat = buildResult.getRequestContentFormat();

    // Assert
    assertEquals(LwM2MOperationType.READ, buildResult.getType());
    assertTrue(actualRequestContentFormat.isPresent());
    assertSame(requestContentFormat, actualRequestContentFormat.get());
  }

  /**
   * Test TbLwM2MReadRequestBuilder {@link TbLwM2MReadRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MReadRequestBuilder#build()}
   *   <li>{@link TbLwM2MReadRequestBuilder#requestContentFormat(ContentFormat)}
   *   <li>{@link TbLwM2MReadRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MReadRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MReadRequestBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbLwM2MReadRequestBuilder.<init>()", "TbLwM2MReadRequest TbLwM2MReadRequestBuilder.build()",
      "TbLwM2MReadRequestBuilder TbLwM2MReadRequestBuilder.requestContentFormat(ContentFormat)",
      "TbLwM2MReadRequestBuilder TbLwM2MReadRequestBuilder.timeout(long)",
      "String TbLwM2MReadRequestBuilder.toString()",
      "TbLwM2MReadRequestBuilder TbLwM2MReadRequestBuilder.versionedId(String)"})
  void testTbLwM2MReadRequestBuilderBuild() {
    // Arrange
    TbLwM2MReadRequestBuilder builderResult = TbLwM2MReadRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);

    // Act
    TbLwM2MReadRequest actualBuildResult = builderResult.requestContentFormat(requestContentFormat)
        .timeout(10L)
        .versionedId("42")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertNull(actualBuildResult.getResponseContentFormat());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.READ, actualBuildResult.getType());
    Optional<ContentFormat> requestContentFormat2 = actualBuildResult.getRequestContentFormat();
    assertTrue(requestContentFormat2.isPresent());
    assertSame(requestContentFormat, requestContentFormat2.get());
  }
}
