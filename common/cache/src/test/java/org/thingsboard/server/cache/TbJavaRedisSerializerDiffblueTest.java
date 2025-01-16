package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

class TbJavaRedisSerializerDiffblueTest {
  /**
   * Test {@link TbJavaRedisSerializer#serialize(Object)}.
   * <p>
   * Method under test: {@link TbJavaRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object)")
  void testSerialize() throws SerializationException {
    // Arrange
    TbJavaRedisSerializer<Object, Object> tbJavaRedisSerializer = new TbJavaRedisSerializer<>();

    // Act and Assert
    assertArrayEquals(new byte[]{-84, -19, 0, 5, 't', 0, 5, 'V', 'a', 'l', 'u', 'e'},
        tbJavaRedisSerializer.serialize("Value"));
  }

  /**
   * Test {@link TbJavaRedisSerializer#deserialize(Object, byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJavaRedisSerializer#deserialize(Object, byte[])}
   */
  @Test
  @DisplayName("Test deserialize(Object, byte[]); when empty array of byte; then return 'null'")
  void testDeserialize_whenEmptyArrayOfByte_thenReturnNull() throws SerializationException {
    // Arrange
    TbJavaRedisSerializer<Object, Object> tbJavaRedisSerializer = new TbJavaRedisSerializer<>();

    // Act and Assert
    assertNull(tbJavaRedisSerializer.deserialize("Key", new byte[]{}));
  }

  /**
   * Test new {@link TbJavaRedisSerializer} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbJavaRedisSerializer}
   */
  @Test
  @DisplayName("Test new TbJavaRedisSerializer (default constructor)")
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
