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
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MCancelAllRequest.TbLwM2MCancelAllRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MCancelAllRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MCancelAllRequestDiffblueTest {
  @Autowired private TbLwM2MCancelAllRequestBuilder tbLwM2MCancelAllRequestBuilder;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MCancelAllRequest#getTimeout()}
   *   <li>{@link TbLwM2MCancelAllRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long TbLwM2MCancelAllRequest.getTimeout()",
    "LwM2MOperationType TbLwM2MCancelAllRequest.getType()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MCancelAllRequest tbLwM2MCancelAllRequest =
        TbLwM2MCancelAllRequest.builder().timeout(10L).build();

    // Act
    long actualTimeout = tbLwM2MCancelAllRequest.getTimeout();

    // Assert
    assertEquals(10L, actualTimeout);
    assertEquals(LwM2MOperationType.OBSERVE_CANCEL_ALL, tbLwM2MCancelAllRequest.getType());
  }

  /**
   * Test TbLwM2MCancelAllRequestBuilder {@link TbLwM2MCancelAllRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MCancelAllRequestBuilder#build()}
   *   <li>{@link TbLwM2MCancelAllRequestBuilder#timeout(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MCancelAllRequestBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MCancelAllRequestBuilder.<init>()",
    "TbLwM2MCancelAllRequest TbLwM2MCancelAllRequestBuilder.build()",
    "TbLwM2MCancelAllRequestBuilder TbLwM2MCancelAllRequestBuilder.timeout(long)",
    "java.lang.String TbLwM2MCancelAllRequestBuilder.toString()"
  })
  void testTbLwM2MCancelAllRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MCancelAllRequest actualTbLwM2MCancelAllRequest =
        TbLwM2MCancelAllRequest.builder().timeout(10L).build();

    // Assert
    assertEquals(10L, actualTbLwM2MCancelAllRequest.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE_CANCEL_ALL, actualTbLwM2MCancelAllRequest.getType());
  }
}
