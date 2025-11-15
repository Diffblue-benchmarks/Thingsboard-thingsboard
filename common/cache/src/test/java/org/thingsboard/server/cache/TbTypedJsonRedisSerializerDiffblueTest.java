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
package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.serializer.SerializationException;
import org.thingsboard.server.common.data.EntityInfo;

class TbTypedJsonRedisSerializerDiffblueTest {
  /**
   * Method under test: {@link TbTypedJsonRedisSerializer#serialize(Object)}
   */
  @Test
  void testSerialize() throws UnsupportedEncodingException, SerializationException {
    // Arrange
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer = new TbTypedJsonRedisSerializer<>(
        mock(TypeReference.class));

    // Act
    byte[] actualSerializeResult = tbTypedJsonRedisSerializer.serialize("42");

    // Assert
    assertArrayEquals("\"42\"".getBytes("UTF-8"), actualSerializeResult);
  }

  /**
   * Method under test: {@link TbTypedJsonRedisSerializer#serialize(Object)}
   */
  @Test
  void testSerialize2() throws UnsupportedEncodingException, SerializationException {
    // Arrange
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer = new TbTypedJsonRedisSerializer<>(
        mock(TypeReference.class));

    // Act
    byte[] actualSerializeResult = tbTypedJsonRedisSerializer.serialize(new EntityInfo(null, "Name"));

    // Assert
    assertArrayEquals("{\"id\":null,\"name\":\"Name\"}".getBytes("UTF-8"), actualSerializeResult);
  }
}
