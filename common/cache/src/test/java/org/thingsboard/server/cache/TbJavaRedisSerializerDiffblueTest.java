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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

class TbJavaRedisSerializerDiffblueTest {
  /**
   * Method under test: {@link TbJavaRedisSerializer#serialize(Object)}
   */
  @Test
  void testSerialize() throws SerializationException {
    // Arrange
    TbJavaRedisSerializer<Object, Object> tbJavaRedisSerializer = new TbJavaRedisSerializer<>();

    // Act and Assert
    assertArrayEquals(new byte[]{-84, -19, 0, 5, 't', 0, 5, 'V', 'a', 'l', 'u', 'e'},
        tbJavaRedisSerializer.serialize("Value"));
  }

  /**
   * Method under test: {@link TbJavaRedisSerializer#deserialize(Object, byte[])}
   */
  @Test
  void testDeserialize() throws SerializationException {
    // Arrange
    TbJavaRedisSerializer<Object, Object> tbJavaRedisSerializer = new TbJavaRedisSerializer<>();

    // Act and Assert
    assertNull(tbJavaRedisSerializer.deserialize("Key", new byte[]{}));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TbJavaRedisSerializer}
   */
  @Test
  void testNewTbJavaRedisSerializer() {
    // Arrange and Act
    TbJavaRedisSerializer<Object, Object> actualTbJavaRedisSerializer = new TbJavaRedisSerializer<>();

    // Assert
    RedisSerializer<Object> redisSerializer = actualTbJavaRedisSerializer.serializer;
    assertTrue(redisSerializer instanceof JdkSerializationRedisSerializer);
    Class<Object> expectedTargetType = Object.class;
    assertEquals(expectedTargetType, redisSerializer.getTargetType());
  }
}
