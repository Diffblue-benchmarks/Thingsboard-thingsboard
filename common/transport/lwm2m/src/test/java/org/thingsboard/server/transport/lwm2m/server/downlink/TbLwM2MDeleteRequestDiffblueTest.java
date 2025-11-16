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
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MDeleteRequest.TbLwM2MDeleteRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MDeleteRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MDeleteRequestDiffblueTest {
  @Autowired private TbLwM2MDeleteRequestBuilder tbLwM2MDeleteRequestBuilder;

  /**
   * Test {@link TbLwM2MDeleteRequest#getType()}.
   *
   * <p>Method under test: {@link TbLwM2MDeleteRequest#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2MOperationType TbLwM2MDeleteRequest.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals(
        LwM2MOperationType.DELETE,
        TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42").build().getType());
  }

  /**
   * Test TbLwM2MDeleteRequestBuilder {@link TbLwM2MDeleteRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MDeleteRequestBuilder#build()}
   *   <li>{@link TbLwM2MDeleteRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MDeleteRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MDeleteRequestBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MDeleteRequestBuilder.<init>()",
    "TbLwM2MDeleteRequest TbLwM2MDeleteRequestBuilder.build()",
    "TbLwM2MDeleteRequestBuilder TbLwM2MDeleteRequestBuilder.timeout(long)",
    "String TbLwM2MDeleteRequestBuilder.toString()",
    "TbLwM2MDeleteRequestBuilder TbLwM2MDeleteRequestBuilder.versionedId(String)"
  })
  void testTbLwM2MDeleteRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MDeleteRequest actualTbLwM2MDeleteRequest =
        TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42").build();

    // Assert
    assertEquals("42", actualTbLwM2MDeleteRequest.getVersionedId());
    assertEquals("42", actualTbLwM2MDeleteRequest.getObjectId());
    assertEquals(10L, actualTbLwM2MDeleteRequest.getTimeout());
    assertEquals(LwM2MOperationType.DELETE, actualTbLwM2MDeleteRequest.getType());
  }
}
