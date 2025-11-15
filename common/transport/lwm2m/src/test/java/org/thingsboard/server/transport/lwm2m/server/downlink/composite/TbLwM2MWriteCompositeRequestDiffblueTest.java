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
package org.thingsboard.server.transport.lwm2m.server.downlink.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MWriteCompositeRequest.TbLwM2MWriteCompositeRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MWriteCompositeRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MWriteCompositeRequestDiffblueTest {
  @Autowired
  private TbLwM2MWriteCompositeRequestBuilder tbLwM2MWriteCompositeRequestBuilder;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MWriteCompositeRequest#getContentFormat()}
   *   <li>{@link TbLwM2MWriteCompositeRequest#getType()}
   *   <li>{@link TbLwM2MWriteCompositeRequest#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ContentFormat TbLwM2MWriteCompositeRequest.getContentFormat()",
      "LwM2MOperationType TbLwM2MWriteCompositeRequest.getType()", "Object TbLwM2MWriteCompositeRequest.getValue()"})
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MWriteCompositeRequestBuilder builderResult = TbLwM2MWriteCompositeRequest.builder();
    ContentFormat contentFormat = ContentFormat.fromCode(1);
    TbLwM2MWriteCompositeRequest buildResult = builderResult.contentFormat(contentFormat)
        .timeout(10L)
        .value("Value")
        .versionedId("42")
        .build();

    // Act
    ContentFormat actualContentFormat = buildResult.getContentFormat();
    LwM2MOperationType actualType = buildResult.getType();

    // Assert
    assertEquals("Value", buildResult.getValue());
    assertEquals(LwM2MOperationType.WRITE_REPLACE, actualType);
    assertSame(contentFormat, actualContentFormat);
  }

  /**
   * Test TbLwM2MWriteCompositeRequestBuilder {@link TbLwM2MWriteCompositeRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MWriteCompositeRequestBuilder#build()}
   *   <li>{@link TbLwM2MWriteCompositeRequestBuilder#contentFormat(ContentFormat)}
   *   <li>{@link TbLwM2MWriteCompositeRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MWriteCompositeRequestBuilder#value(Object)}
   *   <li>{@link TbLwM2MWriteCompositeRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MWriteCompositeRequestBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbLwM2MWriteCompositeRequestBuilder.<init>()",
      "TbLwM2MWriteCompositeRequest TbLwM2MWriteCompositeRequestBuilder.build()",
      "TbLwM2MWriteCompositeRequestBuilder TbLwM2MWriteCompositeRequestBuilder.contentFormat(ContentFormat)",
      "TbLwM2MWriteCompositeRequestBuilder TbLwM2MWriteCompositeRequestBuilder.timeout(long)",
      "String TbLwM2MWriteCompositeRequestBuilder.toString()",
      "TbLwM2MWriteCompositeRequestBuilder TbLwM2MWriteCompositeRequestBuilder.value(Object)",
      "TbLwM2MWriteCompositeRequestBuilder TbLwM2MWriteCompositeRequestBuilder.versionedId(String)"})
  void testTbLwM2MWriteCompositeRequestBuilderBuild() {
    // Arrange
    TbLwM2MWriteCompositeRequestBuilder builderResult = TbLwM2MWriteCompositeRequest.builder();
    ContentFormat contentFormat = ContentFormat.fromCode(1);

    // Act
    TbLwM2MWriteCompositeRequest actualBuildResult = builderResult.contentFormat(contentFormat)
        .timeout(10L)
        .value("Value")
        .versionedId("42")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertEquals("Value", actualBuildResult.getValue());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.WRITE_REPLACE, actualBuildResult.getType());
    assertSame(contentFormat, actualBuildResult.getContentFormat());
  }
}
