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
package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.Advice;
import com.google.api.AuthProvider;
import com.google.protobuf.GeneratedMessageV3;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.queue.TbQueueMsgHeaders;

class TbProtoQueueMsgDiffblueTest {
  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}, and {@link TbProtoQueueMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbProtoQueueMsg#equals(Object)}
   *   <li>{@link TbProtoQueueMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UUID key = UUID.randomUUID();
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());

    // Act and Assert
    assertEquals(tbProtoQueueMsg, tbProtoQueueMsg);
    int expectedHashCodeResult = tbProtoQueueMsg.hashCode();
    assertEquals(expectedHashCodeResult, tbProtoQueueMsg.hashCode());
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID key = UUID.randomUUID();
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());
    UUID key2 = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, new TbProtoQueueMsg<>(key2, Advice.getDefaultInstance()));
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(null, Advice.getDefaultInstance());
    UUID key = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, new TbProtoQueueMsg<>(key, Advice.getDefaultInstance()));
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UUID key = UUID.randomUUID();
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg = mock(TbProtoJsQueueMsg.class);
    when(tbProtoJsQueueMsg.getKey()).thenReturn(UUID.randomUUID());
    when(tbProtoJsQueueMsg.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, tbProtoJsQueueMsg);
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UUID key = UUID.randomUUID();
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg = mock(TbProtoJsQueueMsg.class);
    when(tbProtoJsQueueMsg.getKey()).thenReturn(UUID.randomUUID());
    when(tbProtoJsQueueMsg.canEqual(Mockito.<Object>any())).thenReturn(false);

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, tbProtoJsQueueMsg);
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(null, Advice.getDefaultInstance());
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg = mock(TbProtoJsQueueMsg.class);
    when(tbProtoJsQueueMsg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());
    when(tbProtoJsQueueMsg.getValue()).thenReturn(Advice.getDefaultInstance());
    when(tbProtoJsQueueMsg.getKey()).thenReturn(null);
    when(tbProtoJsQueueMsg.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, tbProtoJsQueueMsg);
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(null, null);
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg = mock(TbProtoJsQueueMsg.class);
    when(tbProtoJsQueueMsg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());
    when(tbProtoJsQueueMsg.getValue()).thenReturn(Advice.getDefaultInstance());
    when(tbProtoJsQueueMsg.getKey()).thenReturn(null);
    when(tbProtoJsQueueMsg.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, tbProtoJsQueueMsg);
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(null,
        AuthProvider.getDefaultInstance());
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg = mock(TbProtoJsQueueMsg.class);
    when(tbProtoJsQueueMsg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());
    when(tbProtoJsQueueMsg.getValue()).thenReturn(Advice.getDefaultInstance());
    when(tbProtoJsQueueMsg.getKey()).thenReturn(null);
    when(tbProtoJsQueueMsg.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, tbProtoJsQueueMsg);
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(null, null);
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg = mock(TbProtoJsQueueMsg.class);
    when(tbProtoJsQueueMsg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());
    when(tbProtoJsQueueMsg.getValue()).thenReturn(null);
    when(tbProtoJsQueueMsg.getKey()).thenReturn(null);
    when(tbProtoJsQueueMsg.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, tbProtoJsQueueMsg);
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UUID key = new UUID(1L, 1L);

    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg = mock(TbProtoJsQueueMsg.class);
    when(tbProtoJsQueueMsg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());
    when(tbProtoJsQueueMsg.getValue()).thenReturn(Advice.getDefaultInstance());
    when(tbProtoJsQueueMsg.getKey()).thenReturn(new UUID(1L, 1L));
    when(tbProtoJsQueueMsg.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, tbProtoJsQueueMsg);
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UUID key = UUID.randomUUID();
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, null);
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UUID key = UUID.randomUUID();
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, "Different type to TbProtoQueueMsg");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbProtoQueueMsg#TbProtoQueueMsg(UUID, GeneratedMessageV3, TbQueueMsgHeaders)}
   *   <li>{@link TbProtoQueueMsg#toString()}
   *   <li>{@link TbProtoQueueMsg#getHeaders()}
   *   <li>{@link TbProtoQueueMsg#getKey()}
   *   <li>{@link TbProtoQueueMsg#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbProtoQueueMsg.<init>(UUID, GeneratedMessageV3, TbQueueMsgHeaders)",
      "TbQueueMsgHeaders TbProtoQueueMsg.getHeaders()", "UUID TbProtoQueueMsg.getKey()",
      "GeneratedMessageV3 TbProtoQueueMsg.getValue()", "java.lang.String TbProtoQueueMsg.toString()"})
  void testGettersAndSetters() {
    // Arrange
    UUID key = UUID.randomUUID();
    Advice defaultInstance = Advice.getDefaultInstance();
    DefaultTbQueueMsgHeaders headers = new DefaultTbQueueMsgHeaders();

    // Act
    TbProtoQueueMsg<GeneratedMessageV3> actualTbProtoQueueMsg = new TbProtoQueueMsg<>(key, defaultInstance, headers);
    actualTbProtoQueueMsg.toString();
    TbQueueMsgHeaders actualHeaders = actualTbProtoQueueMsg.getHeaders();
    UUID actualKey = actualTbProtoQueueMsg.getKey();

    // Assert
    assertTrue(actualHeaders instanceof DefaultTbQueueMsgHeaders);
    assertSame(headers, actualHeaders);
    assertSame(defaultInstance, actualTbProtoQueueMsg.getValue());
    assertSame(key, actualKey);
  }

  /**
   * Test {@link TbProtoQueueMsg#TbProtoQueueMsg(UUID, GeneratedMessageV3)}.
   * <p>
   * Method under test: {@link TbProtoQueueMsg#TbProtoQueueMsg(UUID, GeneratedMessageV3)}
   */
  @Test
  @DisplayName("Test new TbProtoQueueMsg(UUID, GeneratedMessageV3)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbProtoQueueMsg.<init>(UUID, GeneratedMessageV3)"})
  void testNewTbProtoQueueMsg() {
    // Arrange
    UUID key = UUID.randomUUID();
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act
    TbProtoQueueMsg<GeneratedMessageV3> actualTbProtoQueueMsg = new TbProtoQueueMsg<>(key, defaultInstance);

    // Assert
    TbQueueMsgHeaders headers = actualTbProtoQueueMsg.getHeaders();
    assertTrue(headers instanceof DefaultTbQueueMsgHeaders);
    assertTrue(headers.getData().isEmpty());
    assertSame(defaultInstance, actualTbProtoQueueMsg.getValue());
    assertSame(key, actualTbProtoQueueMsg.getKey());
    assertArrayEquals(new byte[]{}, actualTbProtoQueueMsg.getData());
  }

  /**
   * Test {@link TbProtoQueueMsg#getData()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#getData()}
   */
  @Test
  @DisplayName("Test getData(); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbProtoQueueMsg.getData()"})
  void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    UUID key = UUID.randomUUID();
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{}, tbProtoQueueMsg.getData());
  }
}
