package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbJavaRedisSerializer.serialize(Object)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbJavaRedisSerializer.deserialize(Object, byte[])"})
  void testDeserialize_whenEmptyArrayOfByte_thenReturnNull() throws SerializationException {
    // Arrange
    TbJavaRedisSerializer<Object, Object> tbJavaRedisSerializer = new TbJavaRedisSerializer<>();

    // Act and Assert
    assertNull(tbJavaRedisSerializer.deserialize("Key", new byte[]{}));
  }

  /**
   * Test new {@link TbJavaRedisSerializer} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbJavaRedisSerializer}
   */
  @Test
  @DisplayName("Test new TbJavaRedisSerializer (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbJavaRedisSerializer.<init>()"})
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
