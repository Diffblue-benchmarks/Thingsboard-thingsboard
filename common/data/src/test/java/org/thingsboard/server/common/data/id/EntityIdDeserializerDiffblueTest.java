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
package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.util.AccessPattern;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.BaseData;
import org.thingsboard.server.common.data.TenantProfile;

class EntityIdDeserializerDiffblueTest {
  /**
   * Method under test:
   * {@link EntityIdDeserializer#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  void testDeserialize() throws IOException {
    // Arrange
    EntityIdDeserializer entityIdDeserializer = new EntityIdDeserializer();
    JsonParserSequence d = mock(JsonParserSequence.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(BaseData.mapper);
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(IOException.class, () -> entityIdDeserializer.deserialize(jsonParser,
        new DefaultDeserializationContext.Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d).nextToken();
  }

  /**
   * Method under test:
   * {@link EntityIdDeserializer#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  void testDeserialize2() throws IOException {
    // Arrange
    EntityIdDeserializer entityIdDeserializer = new EntityIdDeserializer();
    JsonParserSequence d = mock(JsonParserSequence.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(TenantProfile.mapper);
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(IOException.class, () -> entityIdDeserializer.deserialize(jsonParser,
        new DefaultDeserializationContext.Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d).nextToken();
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link EntityIdDeserializer}
   */
  @Test
  void testNewEntityIdDeserializer() {
    // Arrange and Act
    EntityIdDeserializer actualEntityIdDeserializer = new EntityIdDeserializer();

    // Assert
    assertNull(actualEntityIdDeserializer.getDelegatee());
    assertNull(actualEntityIdDeserializer.getObjectIdReader());
    assertNull(actualEntityIdDeserializer.getEmptyValue());
    assertNull(actualEntityIdDeserializer.getKnownPropertyNames());
    assertNull(actualEntityIdDeserializer.getNullValue());
    assertEquals(AccessPattern.CONSTANT, actualEntityIdDeserializer.getNullAccessPattern());
    assertEquals(AccessPattern.DYNAMIC, actualEntityIdDeserializer.getEmptyAccessPattern());
    assertFalse(actualEntityIdDeserializer.isCachable());
  }
}
