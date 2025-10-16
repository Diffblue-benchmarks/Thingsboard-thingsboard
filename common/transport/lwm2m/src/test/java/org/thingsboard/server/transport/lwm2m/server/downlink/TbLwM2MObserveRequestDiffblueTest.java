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
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MObserveRequest.TbLwM2MObserveRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MObserveRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MObserveRequestDiffblueTest {
  @Autowired private TbLwM2MObserveRequestBuilder tbLwM2MObserveRequestBuilder;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MObserveRequest#getRequestContentFormat()}
   *   <li>{@link TbLwM2MObserveRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional TbLwM2MObserveRequest.getRequestContentFormat()",
    "LwM2MOperationType TbLwM2MObserveRequest.getType()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MObserveRequestBuilder builderResult = TbLwM2MObserveRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MObserveRequest tbLwM2MObserveRequest =
        builderResult
            .requestContentFormat(requestContentFormat)
            .timeout(10L)
            .versionedId("42")
            .build();

    // Act
    Optional<ContentFormat> actualRequestContentFormat =
        tbLwM2MObserveRequest.getRequestContentFormat();

    // Assert
    assertEquals(LwM2MOperationType.OBSERVE, tbLwM2MObserveRequest.getType());
    assertTrue(actualRequestContentFormat.isPresent());
    assertSame(requestContentFormat, actualRequestContentFormat.get());
  }

  /**
   * Test TbLwM2MObserveRequestBuilder {@link TbLwM2MObserveRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MObserveRequestBuilder#build()}
   *   <li>{@link TbLwM2MObserveRequestBuilder#requestContentFormat(ContentFormat)}
   *   <li>{@link TbLwM2MObserveRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MObserveRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MObserveRequestBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MObserveRequestBuilder.<init>()",
    "TbLwM2MObserveRequest TbLwM2MObserveRequestBuilder.build()",
    "TbLwM2MObserveRequestBuilder TbLwM2MObserveRequestBuilder.requestContentFormat(ContentFormat)",
    "TbLwM2MObserveRequestBuilder TbLwM2MObserveRequestBuilder.timeout(long)",
    "String TbLwM2MObserveRequestBuilder.toString()",
    "TbLwM2MObserveRequestBuilder TbLwM2MObserveRequestBuilder.versionedId(String)"
  })
  void testTbLwM2MObserveRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MObserveRequestBuilder actualBuilderResult = TbLwM2MObserveRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MObserveRequest actualTbLwM2MObserveRequest =
        actualBuilderResult
            .requestContentFormat(requestContentFormat)
            .timeout(10L)
            .versionedId("42")
            .build();

    // Assert
    assertEquals("42", actualTbLwM2MObserveRequest.getVersionedId());
    assertEquals("42", actualTbLwM2MObserveRequest.getObjectId());
    assertNull(actualTbLwM2MObserveRequest.getResponseContentFormat());
    assertEquals(10L, actualTbLwM2MObserveRequest.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE, actualTbLwM2MObserveRequest.getType());
    Optional<ContentFormat> requestContentFormat2 =
        actualTbLwM2MObserveRequest.getRequestContentFormat();
    assertTrue(requestContentFormat2.isPresent());
    assertSame(requestContentFormat, requestContentFormat2.get());
  }
}
