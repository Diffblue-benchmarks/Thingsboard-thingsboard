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
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteReplaceRequest.TbLwM2MWriteReplaceRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MWriteReplaceRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MWriteReplaceRequestDiffblueTest {
  @Autowired private TbLwM2MWriteReplaceRequestBuilder tbLwM2MWriteReplaceRequestBuilder;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MWriteReplaceRequest#getContentFormat()}
   *   <li>{@link TbLwM2MWriteReplaceRequest#getType()}
   *   <li>{@link TbLwM2MWriteReplaceRequest#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ContentFormat TbLwM2MWriteReplaceRequest.getContentFormat()",
    "LwM2MOperationType TbLwM2MWriteReplaceRequest.getType()",
    "Object TbLwM2MWriteReplaceRequest.getValue()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MWriteReplaceRequestBuilder builderResult = TbLwM2MWriteReplaceRequest.builder();
    ContentFormat contentFormat = ContentFormat.fromCode(1);
    TbLwM2MWriteReplaceRequest tbLwM2MWriteReplaceRequest =
        builderResult
            .contentFormat(contentFormat)
            .timeout(10L)
            .value("Value")
            .versionedId("42")
            .build();

    // Act
    ContentFormat actualContentFormat = tbLwM2MWriteReplaceRequest.getContentFormat();
    LwM2MOperationType actualType = tbLwM2MWriteReplaceRequest.getType();

    // Assert
    assertEquals("Value", tbLwM2MWriteReplaceRequest.getValue());
    assertEquals(LwM2MOperationType.WRITE_REPLACE, actualType);
    assertSame(contentFormat, actualContentFormat);
  }

  /**
   * Test TbLwM2MWriteReplaceRequestBuilder {@link TbLwM2MWriteReplaceRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MWriteReplaceRequestBuilder#build()}
   *   <li>{@link TbLwM2MWriteReplaceRequestBuilder#contentFormat(ContentFormat)}
   *   <li>{@link TbLwM2MWriteReplaceRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MWriteReplaceRequestBuilder#value(Object)}
   *   <li>{@link TbLwM2MWriteReplaceRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MWriteReplaceRequestBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MWriteReplaceRequestBuilder.<init>()",
    "TbLwM2MWriteReplaceRequest TbLwM2MWriteReplaceRequestBuilder.build()",
    "TbLwM2MWriteReplaceRequestBuilder TbLwM2MWriteReplaceRequestBuilder.contentFormat(ContentFormat)",
    "TbLwM2MWriteReplaceRequestBuilder TbLwM2MWriteReplaceRequestBuilder.timeout(long)",
    "String TbLwM2MWriteReplaceRequestBuilder.toString()",
    "TbLwM2MWriteReplaceRequestBuilder TbLwM2MWriteReplaceRequestBuilder.value(Object)",
    "TbLwM2MWriteReplaceRequestBuilder TbLwM2MWriteReplaceRequestBuilder.versionedId(String)"
  })
  void testTbLwM2MWriteReplaceRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MWriteReplaceRequestBuilder actualBuilderResult = TbLwM2MWriteReplaceRequest.builder();
    ContentFormat contentFormat = ContentFormat.fromCode(1);
    TbLwM2MWriteReplaceRequest actualTbLwM2MWriteReplaceRequest =
        actualBuilderResult
            .contentFormat(contentFormat)
            .timeout(10L)
            .value("Value")
            .versionedId("42")
            .build();

    // Assert
    assertEquals("42", actualTbLwM2MWriteReplaceRequest.getVersionedId());
    assertEquals("42", actualTbLwM2MWriteReplaceRequest.getObjectId());
    assertEquals("Value", actualTbLwM2MWriteReplaceRequest.getValue());
    assertEquals(10L, actualTbLwM2MWriteReplaceRequest.getTimeout());
    assertEquals(LwM2MOperationType.WRITE_REPLACE, actualTbLwM2MWriteReplaceRequest.getType());
    assertSame(contentFormat, actualTbLwM2MWriteReplaceRequest.getContentFormat());
  }
}
