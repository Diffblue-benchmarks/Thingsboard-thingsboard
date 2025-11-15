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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ImageDescriptorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImageDescriptor#equals(Object)}
   *   <li>{@link ImageDescriptor#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor5 = new ImageDescriptor();
    previewDescriptor5.setEtag("Etag");
    previewDescriptor5.setHeight(1);
    previewDescriptor5.setMediaType("Media Type");
    previewDescriptor5.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor5.setSize(3L);
    previewDescriptor5.setWidth(1);

    ImageDescriptor previewDescriptor6 = new ImageDescriptor();
    previewDescriptor6.setEtag("Etag");
    previewDescriptor6.setHeight(1);
    previewDescriptor6.setMediaType("Media Type");
    previewDescriptor6.setPreviewDescriptor(previewDescriptor5);
    previewDescriptor6.setSize(3L);
    previewDescriptor6.setWidth(1);

    ImageDescriptor previewDescriptor7 = new ImageDescriptor();
    previewDescriptor7.setEtag("Etag");
    previewDescriptor7.setHeight(1);
    previewDescriptor7.setMediaType("Media Type");
    previewDescriptor7.setPreviewDescriptor(previewDescriptor6);
    previewDescriptor7.setSize(3L);
    previewDescriptor7.setWidth(1);

    ImageDescriptor previewDescriptor8 = new ImageDescriptor();
    previewDescriptor8.setEtag("Etag");
    previewDescriptor8.setHeight(1);
    previewDescriptor8.setMediaType("Media Type");
    previewDescriptor8.setPreviewDescriptor(previewDescriptor7);
    previewDescriptor8.setSize(3L);
    previewDescriptor8.setWidth(1);

    ImageDescriptor imageDescriptor2 = new ImageDescriptor();
    imageDescriptor2.setEtag("Etag");
    imageDescriptor2.setHeight(1);
    imageDescriptor2.setMediaType("Media Type");
    imageDescriptor2.setPreviewDescriptor(previewDescriptor8);
    imageDescriptor2.setSize(3L);
    imageDescriptor2.setWidth(1);

    // Act and Assert
    assertEquals(imageDescriptor, imageDescriptor2);
    int expectedHashCodeResult = imageDescriptor.hashCode();
    assertEquals(expectedHashCodeResult, imageDescriptor2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImageDescriptor#equals(Object)}
   *   <li>{@link ImageDescriptor#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    // Act and Assert
    assertEquals(imageDescriptor, imageDescriptor);
    int expectedHashCodeResult = imageDescriptor.hashCode();
    assertEquals(expectedHashCodeResult, imageDescriptor.hashCode());
  }

  /**
   * Method under test: {@link ImageDescriptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Media Type");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor5 = new ImageDescriptor();
    previewDescriptor5.setEtag("Etag");
    previewDescriptor5.setHeight(1);
    previewDescriptor5.setMediaType("Media Type");
    previewDescriptor5.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor5.setSize(3L);
    previewDescriptor5.setWidth(1);

    ImageDescriptor previewDescriptor6 = new ImageDescriptor();
    previewDescriptor6.setEtag("Etag");
    previewDescriptor6.setHeight(1);
    previewDescriptor6.setMediaType("Media Type");
    previewDescriptor6.setPreviewDescriptor(previewDescriptor5);
    previewDescriptor6.setSize(3L);
    previewDescriptor6.setWidth(1);

    ImageDescriptor previewDescriptor7 = new ImageDescriptor();
    previewDescriptor7.setEtag("Etag");
    previewDescriptor7.setHeight(1);
    previewDescriptor7.setMediaType("Media Type");
    previewDescriptor7.setPreviewDescriptor(previewDescriptor6);
    previewDescriptor7.setSize(3L);
    previewDescriptor7.setWidth(1);

    ImageDescriptor previewDescriptor8 = new ImageDescriptor();
    previewDescriptor8.setEtag("Etag");
    previewDescriptor8.setHeight(1);
    previewDescriptor8.setMediaType("Media Type");
    previewDescriptor8.setPreviewDescriptor(previewDescriptor7);
    previewDescriptor8.setSize(3L);
    previewDescriptor8.setWidth(1);

    ImageDescriptor imageDescriptor2 = new ImageDescriptor();
    imageDescriptor2.setEtag("Etag");
    imageDescriptor2.setHeight(1);
    imageDescriptor2.setMediaType("Media Type");
    imageDescriptor2.setPreviewDescriptor(previewDescriptor8);
    imageDescriptor2.setSize(3L);
    imageDescriptor2.setWidth(1);

    // Act and Assert
    assertNotEquals(imageDescriptor, imageDescriptor2);
  }

  /**
   * Method under test: {@link ImageDescriptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag(null);
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor5 = new ImageDescriptor();
    previewDescriptor5.setEtag("Etag");
    previewDescriptor5.setHeight(1);
    previewDescriptor5.setMediaType("Media Type");
    previewDescriptor5.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor5.setSize(3L);
    previewDescriptor5.setWidth(1);

    ImageDescriptor previewDescriptor6 = new ImageDescriptor();
    previewDescriptor6.setEtag("Etag");
    previewDescriptor6.setHeight(1);
    previewDescriptor6.setMediaType("Media Type");
    previewDescriptor6.setPreviewDescriptor(previewDescriptor5);
    previewDescriptor6.setSize(3L);
    previewDescriptor6.setWidth(1);

    ImageDescriptor previewDescriptor7 = new ImageDescriptor();
    previewDescriptor7.setEtag("Etag");
    previewDescriptor7.setHeight(1);
    previewDescriptor7.setMediaType("Media Type");
    previewDescriptor7.setPreviewDescriptor(previewDescriptor6);
    previewDescriptor7.setSize(3L);
    previewDescriptor7.setWidth(1);

    ImageDescriptor previewDescriptor8 = new ImageDescriptor();
    previewDescriptor8.setEtag("Etag");
    previewDescriptor8.setHeight(1);
    previewDescriptor8.setMediaType("Media Type");
    previewDescriptor8.setPreviewDescriptor(previewDescriptor7);
    previewDescriptor8.setSize(3L);
    previewDescriptor8.setWidth(1);

    ImageDescriptor imageDescriptor2 = new ImageDescriptor();
    imageDescriptor2.setEtag("Etag");
    imageDescriptor2.setHeight(1);
    imageDescriptor2.setMediaType("Media Type");
    imageDescriptor2.setPreviewDescriptor(previewDescriptor8);
    imageDescriptor2.setSize(3L);
    imageDescriptor2.setWidth(1);

    // Act and Assert
    assertNotEquals(imageDescriptor, imageDescriptor2);
  }

  /**
   * Method under test: {@link ImageDescriptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(3);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor5 = new ImageDescriptor();
    previewDescriptor5.setEtag("Etag");
    previewDescriptor5.setHeight(1);
    previewDescriptor5.setMediaType("Media Type");
    previewDescriptor5.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor5.setSize(3L);
    previewDescriptor5.setWidth(1);

    ImageDescriptor previewDescriptor6 = new ImageDescriptor();
    previewDescriptor6.setEtag("Etag");
    previewDescriptor6.setHeight(1);
    previewDescriptor6.setMediaType("Media Type");
    previewDescriptor6.setPreviewDescriptor(previewDescriptor5);
    previewDescriptor6.setSize(3L);
    previewDescriptor6.setWidth(1);

    ImageDescriptor previewDescriptor7 = new ImageDescriptor();
    previewDescriptor7.setEtag("Etag");
    previewDescriptor7.setHeight(1);
    previewDescriptor7.setMediaType("Media Type");
    previewDescriptor7.setPreviewDescriptor(previewDescriptor6);
    previewDescriptor7.setSize(3L);
    previewDescriptor7.setWidth(1);

    ImageDescriptor previewDescriptor8 = new ImageDescriptor();
    previewDescriptor8.setEtag("Etag");
    previewDescriptor8.setHeight(1);
    previewDescriptor8.setMediaType("Media Type");
    previewDescriptor8.setPreviewDescriptor(previewDescriptor7);
    previewDescriptor8.setSize(3L);
    previewDescriptor8.setWidth(1);

    ImageDescriptor imageDescriptor2 = new ImageDescriptor();
    imageDescriptor2.setEtag("Etag");
    imageDescriptor2.setHeight(1);
    imageDescriptor2.setMediaType("Media Type");
    imageDescriptor2.setPreviewDescriptor(previewDescriptor8);
    imageDescriptor2.setSize(3L);
    imageDescriptor2.setWidth(1);

    // Act and Assert
    assertNotEquals(imageDescriptor, imageDescriptor2);
  }

  /**
   * Method under test: {@link ImageDescriptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Etag");
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor5 = new ImageDescriptor();
    previewDescriptor5.setEtag("Etag");
    previewDescriptor5.setHeight(1);
    previewDescriptor5.setMediaType("Media Type");
    previewDescriptor5.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor5.setSize(3L);
    previewDescriptor5.setWidth(1);

    ImageDescriptor previewDescriptor6 = new ImageDescriptor();
    previewDescriptor6.setEtag("Etag");
    previewDescriptor6.setHeight(1);
    previewDescriptor6.setMediaType("Media Type");
    previewDescriptor6.setPreviewDescriptor(previewDescriptor5);
    previewDescriptor6.setSize(3L);
    previewDescriptor6.setWidth(1);

    ImageDescriptor previewDescriptor7 = new ImageDescriptor();
    previewDescriptor7.setEtag("Etag");
    previewDescriptor7.setHeight(1);
    previewDescriptor7.setMediaType("Media Type");
    previewDescriptor7.setPreviewDescriptor(previewDescriptor6);
    previewDescriptor7.setSize(3L);
    previewDescriptor7.setWidth(1);

    ImageDescriptor previewDescriptor8 = new ImageDescriptor();
    previewDescriptor8.setEtag("Etag");
    previewDescriptor8.setHeight(1);
    previewDescriptor8.setMediaType("Media Type");
    previewDescriptor8.setPreviewDescriptor(previewDescriptor7);
    previewDescriptor8.setSize(3L);
    previewDescriptor8.setWidth(1);

    ImageDescriptor imageDescriptor2 = new ImageDescriptor();
    imageDescriptor2.setEtag("Etag");
    imageDescriptor2.setHeight(1);
    imageDescriptor2.setMediaType("Media Type");
    imageDescriptor2.setPreviewDescriptor(previewDescriptor8);
    imageDescriptor2.setSize(3L);
    imageDescriptor2.setWidth(1);

    // Act and Assert
    assertNotEquals(imageDescriptor, imageDescriptor2);
  }

  /**
   * Method under test: {@link ImageDescriptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType(null);
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor5 = new ImageDescriptor();
    previewDescriptor5.setEtag("Etag");
    previewDescriptor5.setHeight(1);
    previewDescriptor5.setMediaType("Media Type");
    previewDescriptor5.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor5.setSize(3L);
    previewDescriptor5.setWidth(1);

    ImageDescriptor previewDescriptor6 = new ImageDescriptor();
    previewDescriptor6.setEtag("Etag");
    previewDescriptor6.setHeight(1);
    previewDescriptor6.setMediaType("Media Type");
    previewDescriptor6.setPreviewDescriptor(previewDescriptor5);
    previewDescriptor6.setSize(3L);
    previewDescriptor6.setWidth(1);

    ImageDescriptor previewDescriptor7 = new ImageDescriptor();
    previewDescriptor7.setEtag("Etag");
    previewDescriptor7.setHeight(1);
    previewDescriptor7.setMediaType("Media Type");
    previewDescriptor7.setPreviewDescriptor(previewDescriptor6);
    previewDescriptor7.setSize(3L);
    previewDescriptor7.setWidth(1);

    ImageDescriptor previewDescriptor8 = new ImageDescriptor();
    previewDescriptor8.setEtag("Etag");
    previewDescriptor8.setHeight(1);
    previewDescriptor8.setMediaType("Media Type");
    previewDescriptor8.setPreviewDescriptor(previewDescriptor7);
    previewDescriptor8.setSize(3L);
    previewDescriptor8.setWidth(1);

    ImageDescriptor imageDescriptor2 = new ImageDescriptor();
    imageDescriptor2.setEtag("Etag");
    imageDescriptor2.setHeight(1);
    imageDescriptor2.setMediaType("Media Type");
    imageDescriptor2.setPreviewDescriptor(previewDescriptor8);
    imageDescriptor2.setSize(3L);
    imageDescriptor2.setWidth(1);

    // Act and Assert
    assertNotEquals(imageDescriptor, imageDescriptor2);
  }

  /**
   * Method under test: {@link ImageDescriptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Media Type");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor5 = new ImageDescriptor();
    previewDescriptor5.setEtag("Etag");
    previewDescriptor5.setHeight(1);
    previewDescriptor5.setMediaType("Media Type");
    previewDescriptor5.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor5.setSize(3L);
    previewDescriptor5.setWidth(1);

    ImageDescriptor previewDescriptor6 = new ImageDescriptor();
    previewDescriptor6.setEtag("Etag");
    previewDescriptor6.setHeight(1);
    previewDescriptor6.setMediaType("Media Type");
    previewDescriptor6.setPreviewDescriptor(previewDescriptor5);
    previewDescriptor6.setSize(3L);
    previewDescriptor6.setWidth(1);

    ImageDescriptor previewDescriptor7 = new ImageDescriptor();
    previewDescriptor7.setEtag("Etag");
    previewDescriptor7.setHeight(1);
    previewDescriptor7.setMediaType("Media Type");
    previewDescriptor7.setPreviewDescriptor(previewDescriptor6);
    previewDescriptor7.setSize(3L);
    previewDescriptor7.setWidth(1);

    ImageDescriptor previewDescriptor8 = new ImageDescriptor();
    previewDescriptor8.setEtag("Etag");
    previewDescriptor8.setHeight(1);
    previewDescriptor8.setMediaType("Media Type");
    previewDescriptor8.setPreviewDescriptor(previewDescriptor7);
    previewDescriptor8.setSize(3L);
    previewDescriptor8.setWidth(1);

    ImageDescriptor imageDescriptor2 = new ImageDescriptor();
    imageDescriptor2.setEtag("Etag");
    imageDescriptor2.setHeight(1);
    imageDescriptor2.setMediaType("Media Type");
    imageDescriptor2.setPreviewDescriptor(previewDescriptor8);
    imageDescriptor2.setSize(3L);
    imageDescriptor2.setWidth(1);

    // Act and Assert
    assertNotEquals(imageDescriptor, imageDescriptor2);
  }

  /**
   * Method under test: {@link ImageDescriptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(null);
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor5 = new ImageDescriptor();
    previewDescriptor5.setEtag("Etag");
    previewDescriptor5.setHeight(1);
    previewDescriptor5.setMediaType("Media Type");
    previewDescriptor5.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor5.setSize(3L);
    previewDescriptor5.setWidth(1);

    ImageDescriptor previewDescriptor6 = new ImageDescriptor();
    previewDescriptor6.setEtag("Etag");
    previewDescriptor6.setHeight(1);
    previewDescriptor6.setMediaType("Media Type");
    previewDescriptor6.setPreviewDescriptor(previewDescriptor5);
    previewDescriptor6.setSize(3L);
    previewDescriptor6.setWidth(1);

    ImageDescriptor previewDescriptor7 = new ImageDescriptor();
    previewDescriptor7.setEtag("Etag");
    previewDescriptor7.setHeight(1);
    previewDescriptor7.setMediaType("Media Type");
    previewDescriptor7.setPreviewDescriptor(previewDescriptor6);
    previewDescriptor7.setSize(3L);
    previewDescriptor7.setWidth(1);

    ImageDescriptor previewDescriptor8 = new ImageDescriptor();
    previewDescriptor8.setEtag("Etag");
    previewDescriptor8.setHeight(1);
    previewDescriptor8.setMediaType("Media Type");
    previewDescriptor8.setPreviewDescriptor(previewDescriptor7);
    previewDescriptor8.setSize(3L);
    previewDescriptor8.setWidth(1);

    ImageDescriptor imageDescriptor2 = new ImageDescriptor();
    imageDescriptor2.setEtag("Etag");
    imageDescriptor2.setHeight(1);
    imageDescriptor2.setMediaType("Media Type");
    imageDescriptor2.setPreviewDescriptor(previewDescriptor8);
    imageDescriptor2.setSize(3L);
    imageDescriptor2.setWidth(1);

    // Act and Assert
    assertNotEquals(imageDescriptor, imageDescriptor2);
  }

  /**
   * Method under test: {@link ImageDescriptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(1L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor5 = new ImageDescriptor();
    previewDescriptor5.setEtag("Etag");
    previewDescriptor5.setHeight(1);
    previewDescriptor5.setMediaType("Media Type");
    previewDescriptor5.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor5.setSize(3L);
    previewDescriptor5.setWidth(1);

    ImageDescriptor previewDescriptor6 = new ImageDescriptor();
    previewDescriptor6.setEtag("Etag");
    previewDescriptor6.setHeight(1);
    previewDescriptor6.setMediaType("Media Type");
    previewDescriptor6.setPreviewDescriptor(previewDescriptor5);
    previewDescriptor6.setSize(3L);
    previewDescriptor6.setWidth(1);

    ImageDescriptor previewDescriptor7 = new ImageDescriptor();
    previewDescriptor7.setEtag("Etag");
    previewDescriptor7.setHeight(1);
    previewDescriptor7.setMediaType("Media Type");
    previewDescriptor7.setPreviewDescriptor(previewDescriptor6);
    previewDescriptor7.setSize(3L);
    previewDescriptor7.setWidth(1);

    ImageDescriptor previewDescriptor8 = new ImageDescriptor();
    previewDescriptor8.setEtag("Etag");
    previewDescriptor8.setHeight(1);
    previewDescriptor8.setMediaType("Media Type");
    previewDescriptor8.setPreviewDescriptor(previewDescriptor7);
    previewDescriptor8.setSize(3L);
    previewDescriptor8.setWidth(1);

    ImageDescriptor imageDescriptor2 = new ImageDescriptor();
    imageDescriptor2.setEtag("Etag");
    imageDescriptor2.setHeight(1);
    imageDescriptor2.setMediaType("Media Type");
    imageDescriptor2.setPreviewDescriptor(previewDescriptor8);
    imageDescriptor2.setSize(3L);
    imageDescriptor2.setWidth(1);

    // Act and Assert
    assertNotEquals(imageDescriptor, imageDescriptor2);
  }

  /**
   * Method under test: {@link ImageDescriptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(2);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor5 = new ImageDescriptor();
    previewDescriptor5.setEtag("Etag");
    previewDescriptor5.setHeight(1);
    previewDescriptor5.setMediaType("Media Type");
    previewDescriptor5.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor5.setSize(3L);
    previewDescriptor5.setWidth(1);

    ImageDescriptor previewDescriptor6 = new ImageDescriptor();
    previewDescriptor6.setEtag("Etag");
    previewDescriptor6.setHeight(1);
    previewDescriptor6.setMediaType("Media Type");
    previewDescriptor6.setPreviewDescriptor(previewDescriptor5);
    previewDescriptor6.setSize(3L);
    previewDescriptor6.setWidth(1);

    ImageDescriptor previewDescriptor7 = new ImageDescriptor();
    previewDescriptor7.setEtag("Etag");
    previewDescriptor7.setHeight(1);
    previewDescriptor7.setMediaType("Media Type");
    previewDescriptor7.setPreviewDescriptor(previewDescriptor6);
    previewDescriptor7.setSize(3L);
    previewDescriptor7.setWidth(1);

    ImageDescriptor previewDescriptor8 = new ImageDescriptor();
    previewDescriptor8.setEtag("Etag");
    previewDescriptor8.setHeight(1);
    previewDescriptor8.setMediaType("Media Type");
    previewDescriptor8.setPreviewDescriptor(previewDescriptor7);
    previewDescriptor8.setSize(3L);
    previewDescriptor8.setWidth(1);

    ImageDescriptor imageDescriptor2 = new ImageDescriptor();
    imageDescriptor2.setEtag("Etag");
    imageDescriptor2.setHeight(1);
    imageDescriptor2.setMediaType("Media Type");
    imageDescriptor2.setPreviewDescriptor(previewDescriptor8);
    imageDescriptor2.setSize(3L);
    imageDescriptor2.setWidth(1);

    // Act and Assert
    assertNotEquals(imageDescriptor, imageDescriptor2);
  }

  /**
   * Method under test: {@link ImageDescriptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    // Act and Assert
    assertNotEquals(imageDescriptor, null);
  }

  /**
   * Method under test: {@link ImageDescriptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    // Act and Assert
    assertNotEquals(imageDescriptor, "Different type to ImageDescriptor");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImageDescriptor}
   *   <li>{@link ImageDescriptor#setEtag(String)}
   *   <li>{@link ImageDescriptor#setHeight(int)}
   *   <li>{@link ImageDescriptor#setMediaType(String)}
   *   <li>{@link ImageDescriptor#setPreviewDescriptor(ImageDescriptor)}
   *   <li>{@link ImageDescriptor#setSize(long)}
   *   <li>{@link ImageDescriptor#setWidth(int)}
   *   <li>{@link ImageDescriptor#toString()}
   *   <li>{@link ImageDescriptor#getEtag()}
   *   <li>{@link ImageDescriptor#getHeight()}
   *   <li>{@link ImageDescriptor#getMediaType()}
   *   <li>{@link ImageDescriptor#getPreviewDescriptor()}
   *   <li>{@link ImageDescriptor#getSize()}
   *   <li>{@link ImageDescriptor#getWidth()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ImageDescriptor actualImageDescriptor = new ImageDescriptor();
    actualImageDescriptor.setEtag("Etag");
    actualImageDescriptor.setHeight(1);
    actualImageDescriptor.setMediaType("Media Type");
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);
    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);
    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);
    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);
    actualImageDescriptor.setPreviewDescriptor(previewDescriptor4);
    actualImageDescriptor.setSize(3L);
    actualImageDescriptor.setWidth(1);
    String actualToStringResult = actualImageDescriptor.toString();
    String actualEtag = actualImageDescriptor.getEtag();
    int actualHeight = actualImageDescriptor.getHeight();
    String actualMediaType = actualImageDescriptor.getMediaType();
    ImageDescriptor actualPreviewDescriptor = actualImageDescriptor.getPreviewDescriptor();
    long actualSize = actualImageDescriptor.getSize();

    // Assert that nothing has changed
    assertEquals("Etag", actualEtag);
    assertEquals(
        "ImageDescriptor(mediaType=Media Type, width=1, height=1, size=3, etag=Etag, previewDescriptor"
            + "=ImageDescriptor(mediaType=Media Type, width=1, height=1, size=3, etag=Etag, previewDescriptor"
            + "=ImageDescriptor(mediaType=Media Type, width=1, height=1, size=3, etag=Etag, previewDescriptor"
            + "=ImageDescriptor(mediaType=Media Type, width=1, height=1, size=3, etag=Etag, previewDescriptor"
            + "=ImageDescriptor(mediaType=Media Type, width=1, height=1, size=3, etag=Etag, previewDescriptor"
            + "=ImageDescriptor(mediaType=null, width=0, height=0, size=0, etag=null, previewDescriptor=null))))))",
        actualToStringResult);
    assertEquals("Media Type", actualMediaType);
    assertEquals(1, actualHeight);
    assertEquals(1, actualImageDescriptor.getWidth());
    assertEquals(3L, actualSize);
    assertSame(previewDescriptor4, actualPreviewDescriptor);
  }
}
