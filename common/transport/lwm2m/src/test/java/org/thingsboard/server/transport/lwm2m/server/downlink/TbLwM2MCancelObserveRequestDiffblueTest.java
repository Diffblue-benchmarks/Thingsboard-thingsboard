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
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MCancelObserveRequest.TbLwM2MCancelObserveRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MCancelObserveRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MCancelObserveRequestDiffblueTest {
  @Autowired private TbLwM2MCancelObserveRequestBuilder tbLwM2MCancelObserveRequestBuilder;

  /**
   * Test {@link TbLwM2MCancelObserveRequest#getType()}.
   *
   * <p>Method under test: {@link TbLwM2MCancelObserveRequest#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2MOperationType TbLwM2MCancelObserveRequest.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals(
        LwM2MOperationType.OBSERVE_CANCEL,
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build().getType());
  }

  /**
   * Test TbLwM2MCancelObserveRequestBuilder {@link TbLwM2MCancelObserveRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MCancelObserveRequestBuilder#build()}
   *   <li>{@link TbLwM2MCancelObserveRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MCancelObserveRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MCancelObserveRequestBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MCancelObserveRequestBuilder.<init>()",
    "TbLwM2MCancelObserveRequest TbLwM2MCancelObserveRequestBuilder.build()",
    "TbLwM2MCancelObserveRequestBuilder TbLwM2MCancelObserveRequestBuilder.timeout(long)",
    "String TbLwM2MCancelObserveRequestBuilder.toString()",
    "TbLwM2MCancelObserveRequestBuilder TbLwM2MCancelObserveRequestBuilder.versionedId(String)"
  })
  void testTbLwM2MCancelObserveRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MCancelObserveRequest actualTbLwM2MCancelObserveRequest =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();

    // Assert
    assertEquals("42", actualTbLwM2MCancelObserveRequest.getVersionedId());
    assertEquals("42", actualTbLwM2MCancelObserveRequest.getObjectId());
    assertEquals(10L, actualTbLwM2MCancelObserveRequest.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE_CANCEL, actualTbLwM2MCancelObserveRequest.getType());
  }
}
