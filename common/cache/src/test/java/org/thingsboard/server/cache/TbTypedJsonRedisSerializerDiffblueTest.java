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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.type.ArrayType;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.serializer.SerializationException;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.HomeDashboard;
import org.thingsboard.server.common.data.ShortCustomerInfo;
import org.thingsboard.server.common.data.id.CustomerId;

class TbTypedJsonRedisSerializerDiffblueTest {
  /**
   * Test {@link TbTypedJsonRedisSerializer#serialize(Object)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then return array length is two hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link TbTypedJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName(
      "Test serialize(Object); given HashSet(); then return array length is two hundred twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbTypedJsonRedisSerializer.serialize(Object)"})
  void testSerialize_givenHashSet_thenReturnArrayLengthIsTwoHundredTwentyFour()
      throws SerializationException {
    // Arrange
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer =
        new TbTypedJsonRedisSerializer<>(mock(TypeReference.class));

    Dashboard dashboard = new Dashboard();
    dashboard.setAssignedCustomers(new HashSet<>());

    // Act
    byte[] actualSerializeResult =
        tbTypedJsonRedisSerializer.serialize(new HomeDashboard(dashboard, true));

    // Assert
    assertEquals(224, actualSerializeResult.length);
    assertEquals(',', actualSerializeResult[211]);
    assertEquals(':', actualSerializeResult[206]);
    assertEquals(':', actualSerializeResult[218]);
    assertEquals('"', actualSerializeResult[205]);
    assertEquals('"', actualSerializeResult[212]);
    assertEquals('"', actualSerializeResult[217]);
    assertEquals('a', actualSerializeResult[200]);
    assertEquals('a', actualSerializeResult[214]);
    assertEquals('e', actualSerializeResult[216]);
    assertEquals('i', actualSerializeResult[202]);
    assertEquals('l', actualSerializeResult[209]);
    assertEquals('l', actualSerializeResult[210]);
    assertEquals('l', actualSerializeResult[221]);
    assertEquals('l', actualSerializeResult[222]);
    assertEquals('m', actualSerializeResult[215]);
    assertEquals('n', actualSerializeResult[204]);
    assertEquals('n', actualSerializeResult[207]);
    assertEquals('n', actualSerializeResult[213]);
    assertEquals('n', actualSerializeResult[219]);
    assertEquals('o', actualSerializeResult[203]);
    assertEquals('r', actualSerializeResult[199]);
    assertEquals('t', actualSerializeResult[201]);
    assertEquals('u', actualSerializeResult[208]);
    assertEquals('u', actualSerializeResult[220]);
    assertEquals('}', actualSerializeResult[223]);
  }

  /**
   * Test {@link TbTypedJsonRedisSerializer#serialize(Object)}.
   *
   * <ul>
   *   <li>Then return array length is three hundred thirty-five.
   * </ul>
   *
   * <p>Method under test: {@link TbTypedJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); then return array length is three hundred thirty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbTypedJsonRedisSerializer.serialize(Object)"})
  void testSerialize_thenReturnArrayLengthIsThreeHundredThirtyFive() throws SerializationException {
    // Arrange
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer =
        new TbTypedJsonRedisSerializer<>(mock(TypeReference.class));

    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    ShortCustomerInfo shortCustomerInfo =
        new ShortCustomerInfo(new CustomerId(UUID.randomUUID()), "Dr", true);
    assignedCustomers.add(shortCustomerInfo);

    Dashboard dashboard = new Dashboard();
    dashboard.setAssignedCustomers(assignedCustomers);

    // Act
    byte[] actualSerializeResult =
        tbTypedJsonRedisSerializer.serialize(new HomeDashboard(dashboard, true));

    // Assert
    assertEquals(335, actualSerializeResult.length);
    assertEquals(',', actualSerializeResult[322]);
    assertEquals(':', actualSerializeResult[317]);
    assertEquals(':', actualSerializeResult[329]);
    assertEquals('"', actualSerializeResult[316]);
    assertEquals('"', actualSerializeResult[323]);
    assertEquals('"', actualSerializeResult[328]);
    assertEquals('a', actualSerializeResult[311]);
    assertEquals('a', actualSerializeResult[325]);
    assertEquals('e', actualSerializeResult[327]);
    assertEquals('i', actualSerializeResult[313]);
    assertEquals('l', actualSerializeResult[320]);
    assertEquals('l', actualSerializeResult[321]);
    assertEquals('l', actualSerializeResult[332]);
    assertEquals('l', actualSerializeResult[333]);
    assertEquals('m', actualSerializeResult[326]);
    assertEquals('n', actualSerializeResult[315]);
    assertEquals('n', actualSerializeResult[318]);
    assertEquals('n', actualSerializeResult[324]);
    assertEquals('n', actualSerializeResult[330]);
    assertEquals('o', actualSerializeResult[314]);
    assertEquals('r', actualSerializeResult[310]);
    assertEquals('t', actualSerializeResult[312]);
    assertEquals('u', actualSerializeResult[319]);
    assertEquals('u', actualSerializeResult[331]);
    assertEquals('}', actualSerializeResult[334]);
  }

  /**
   * Test {@link TbTypedJsonRedisSerializer#serialize(Object)}.
   *
   * <ul>
   *   <li>Then return {@code {"id":null,"name":"Name"}} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TbTypedJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName(
      "Test serialize(Object); then return '{\"id\":null,\"name\":\"Name\"}' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbTypedJsonRedisSerializer.serialize(Object)"})
  void testSerialize_thenReturnIdNullNameNameBytesIsUtf8()
      throws UnsupportedEncodingException, SerializationException {
    // Arrange
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer =
        new TbTypedJsonRedisSerializer<>(mock(TypeReference.class));

    // Act
    byte[] actualSerializeResult =
        tbTypedJsonRedisSerializer.serialize(new EntityInfo(null, "Name"));

    // Assert
    assertArrayEquals("{\"id\":null,\"name\":\"Name\"}".getBytes("UTF-8"), actualSerializeResult);
  }

  /**
   * Test {@link TbTypedJsonRedisSerializer#serialize(Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code "42"} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TbTypedJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when '42'; then return '\"42\"' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbTypedJsonRedisSerializer.serialize(Object)"})
  void testSerialize_when42_thenReturn42BytesIsUtf8()
      throws UnsupportedEncodingException, SerializationException {
    // Arrange
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer =
        new TbTypedJsonRedisSerializer<>(mock(TypeReference.class));

    // Act and Assert
    assertArrayEquals("\"42\"".getBytes("UTF-8"), tbTypedJsonRedisSerializer.serialize("42"));
  }

  /**
   * Test {@link TbTypedJsonRedisSerializer#deserialize(Object, byte[])}.
   *
   * <ul>
   *   <li>Given {@link TypeReference} {@link TypeReference#getType()} throw {@link
   *       SerializationException#SerializationException(String)} with {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link TbTypedJsonRedisSerializer#deserialize(Object, byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialize(Object, byte[]); given TypeReference getType() throw SerializationException(String) with 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbTypedJsonRedisSerializer.deserialize(Object, byte[])"})
  void testDeserialize_givenTypeReferenceGetTypeThrowSerializationExceptionWithMsg()
      throws UnsupportedEncodingException, SerializationException {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenThrow(new SerializationException("Msg"));
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer =
        new TbTypedJsonRedisSerializer<>(valueTypeRef);

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () -> tbTypedJsonRedisSerializer.deserialize("Key", "AXAXAXAX".getBytes("UTF-8")));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link TbTypedJsonRedisSerializer#deserialize(Object, byte[])}.
   *
   * <ul>
   *   <li>Then calls {@link ArrayType#getRawClass()}.
   * </ul>
   *
   * <p>Method under test: {@link TbTypedJsonRedisSerializer#deserialize(Object, byte[])}
   */
  @Test
  @DisplayName("Test deserialize(Object, byte[]); then calls getRawClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbTypedJsonRedisSerializer.deserialize(Object, byte[])"})
  void testDeserialize_thenCallsGetRawClass() throws SerializationException {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    org.mockito.Mockito.<Class<?>>when(arrayType.getRawClass())
        .thenThrow(new SerializationException("Msg"));

    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(arrayType);
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer =
        new TbTypedJsonRedisSerializer<>(valueTypeRef);

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () -> tbTypedJsonRedisSerializer.deserialize("Key", new byte[] {}));
    verify(valueTypeRef).getType();
    verify(arrayType).getRawClass();
  }
}
