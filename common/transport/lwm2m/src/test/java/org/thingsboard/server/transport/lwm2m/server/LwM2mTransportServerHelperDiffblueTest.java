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
package org.thingsboard.server.transport.lwm2m.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.model.ResourceModel.Type;
import org.eclipse.leshan.core.node.codec.CodecException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LwM2mTransportServerHelperDiffblueTest {
  @InjectMocks
  private LwM2mTransportServerHelper lwM2mTransportServerHelper;

  /**
   * Test {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code Key} is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  @DisplayName("Test getTsByKey(String, Map, long); when 'Key'; then HashMap() 'Key' is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long LwM2mTransportServerHelper.getTsByKey(String, Map, long)"})
  void testGetTsByKey_whenKey_thenHashMapKeyIsOne() {
    // Arrange
    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();

    // Act
    lwM2mTransportServerHelper.getTsByKey("Key", keyTsLatestMap, 1L);

    // Assert
    assertEquals(1, keyTsLatestMap.size());
    assertEquals(1L, keyTsLatestMap.get("Key").get());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[], String)}.
   * <ul>
   *   <li>When {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[], String)}
   */
  @Test
  @DisplayName("Test parseFromXmlToObjectModel(byte[], String); when 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.eclipse.leshan.core.model.ObjectModel LwM2mTransportServerHelper.parseFromXmlToObjectModel(byte[], String)"})
  void testParseFromXmlToObjectModel_whenA() {
    // Arrange, Act and Assert
    assertNull(lwM2mTransportServerHelper.parseFromXmlToObjectModel(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        "Stream Name"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[], String)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[], String)}
   */
  @Test
  @DisplayName("Test parseFromXmlToObjectModel(byte[], String); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.eclipse.leshan.core.model.ObjectModel LwM2mTransportServerHelper.parseFromXmlToObjectModel(byte[], String)"})
  void testParseFromXmlToObjectModel_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(lwM2mTransportServerHelper.parseFromXmlToObjectModel("AXAXAXAX".getBytes("UTF-8"), "Stream Name"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}.
   * <ul>
   *   <li>When {@code BOOLEAN}.</li>
   *   <li>Then return {@code BOOLEAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName("Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'BOOLEAN'; then return 'BOOLEAN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"})
  void testGetResourceModelTypeEqualsKvProtoValueType_whenBoolean_thenReturnBoolean() {
    // Arrange, Act and Assert
    assertEquals(Type.BOOLEAN,
        LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type.BOOLEAN, "Resource Path"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}.
   * <ul>
   *   <li>When {@code FLOAT}.</li>
   *   <li>Then return {@code FLOAT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName("Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'FLOAT'; then return 'FLOAT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"})
  void testGetResourceModelTypeEqualsKvProtoValueType_whenFloat_thenReturnFloat() {
    // Arrange, Act and Assert
    assertEquals(Type.FLOAT,
        LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type.FLOAT, "Resource Path"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}.
   * <ul>
   *   <li>When {@code INTEGER}.</li>
   *   <li>Then return {@code INTEGER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName("Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'INTEGER'; then return 'INTEGER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"})
  void testGetResourceModelTypeEqualsKvProtoValueType_whenInteger_thenReturnInteger() {
    // Arrange, Act and Assert
    assertEquals(Type.INTEGER,
        LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type.INTEGER, "Resource Path"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}.
   * <ul>
   *   <li>When {@code NONE}.</li>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName("Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'NONE'; then throw CodecException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"})
  void testGetResourceModelTypeEqualsKvProtoValueType_whenNone_thenThrowCodecException() {
    // Arrange, Act and Assert
    assertThrows(CodecException.class,
        () -> LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type.NONE, "Resource Path"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}.
   * <ul>
   *   <li>When {@code STRING}.</li>
   *   <li>Then return {@code STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName("Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'STRING'; then return 'STRING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"})
  void testGetResourceModelTypeEqualsKvProtoValueType_whenString_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(Type.STRING,
        LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type.STRING, "Resource Path"));
  }
}
