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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MObserveAllRequest.TbLwM2MObserveAllRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MObserveAllRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MObserveAllRequestDiffblueTest {
  @Autowired private TbLwM2MObserveAllRequestBuilder tbLwM2MObserveAllRequestBuilder;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MObserveAllRequest#getTimeout()}
   *   <li>{@link TbLwM2MObserveAllRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long TbLwM2MObserveAllRequest.getTimeout()",
    "LwM2MOperationType TbLwM2MObserveAllRequest.getType()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MObserveAllRequest tbLwM2MObserveAllRequest =
        TbLwM2MObserveAllRequest.builder().timeout(10L).build();

    // Act
    long actualTimeout = tbLwM2MObserveAllRequest.getTimeout();

    // Assert
    assertEquals(10L, actualTimeout);
    assertEquals(LwM2MOperationType.OBSERVE_READ_ALL, tbLwM2MObserveAllRequest.getType());
  }

  /**
   * Test TbLwM2MObserveAllRequestBuilder {@link TbLwM2MObserveAllRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MObserveAllRequestBuilder#build()}
   *   <li>{@link TbLwM2MObserveAllRequestBuilder#timeout(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MObserveAllRequestBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MObserveAllRequestBuilder.<init>()",
    "TbLwM2MObserveAllRequest TbLwM2MObserveAllRequestBuilder.build()",
    "TbLwM2MObserveAllRequestBuilder TbLwM2MObserveAllRequestBuilder.timeout(long)",
    "java.lang.String TbLwM2MObserveAllRequestBuilder.toString()"
  })
  void testTbLwM2MObserveAllRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MObserveAllRequest actualTbLwM2MObserveAllRequest =
        TbLwM2MObserveAllRequest.builder().timeout(10L).build();

    // Assert
    assertEquals(10L, actualTbLwM2MObserveAllRequest.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE_READ_ALL, actualTbLwM2MObserveAllRequest.getType());
  }
}
