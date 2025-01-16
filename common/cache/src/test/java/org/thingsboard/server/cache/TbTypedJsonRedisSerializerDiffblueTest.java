package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.serializer.SerializationException;
import org.thingsboard.server.common.data.EntityInfo;

class TbTypedJsonRedisSerializerDiffblueTest {
  /**
   * Test {@link TbTypedJsonRedisSerializer#serialize(Object)}.
   * <ul>
   *   <li>Then return {@code {"id":null,"name":"Name"}} Bytes is
   * {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTypedJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); then return '{\"id\":null,\"name\":\"Name\"}' Bytes is 'UTF-8'")
  void testSerialize_thenReturnIdNullNameNameBytesIsUtf8() throws UnsupportedEncodingException, SerializationException {
    // Arrange
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer = new TbTypedJsonRedisSerializer<>(
        mock(TypeReference.class));

    // Act
    byte[] actualSerializeResult = tbTypedJsonRedisSerializer.serialize(new EntityInfo(null, "Name"));

    // Assert
    assertArrayEquals("{\"id\":null,\"name\":\"Name\"}".getBytes("UTF-8"), actualSerializeResult);
  }

  /**
   * Test {@link TbTypedJsonRedisSerializer#serialize(Object)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code "42"} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTypedJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when '42'; then return '\"42\"' Bytes is 'UTF-8'")
  void testSerialize_when42_thenReturn42BytesIsUtf8() throws UnsupportedEncodingException, SerializationException {
    // Arrange
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer = new TbTypedJsonRedisSerializer<>(
        mock(TypeReference.class));

    // Act
    byte[] actualSerializeResult = tbTypedJsonRedisSerializer.serialize("42");

    // Assert
    assertArrayEquals("\"42\"".getBytes("UTF-8"), actualSerializeResult);
  }
}
