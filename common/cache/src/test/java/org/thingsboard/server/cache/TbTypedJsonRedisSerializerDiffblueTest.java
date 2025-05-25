package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.MissingNode;
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
import org.thingsboard.server.common.data.id.DeviceId;

class TbTypedJsonRedisSerializerDiffblueTest {
  /**
   * Test {@link TbTypedJsonRedisSerializer#serialize(Object)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return array length is two hundred twenty-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTypedJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); given HashSet(); then return array length is two hundred twenty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbTypedJsonRedisSerializer.serialize(Object)"})
  void testSerialize_givenHashSet_thenReturnArrayLengthIsTwoHundredTwentyFour() throws SerializationException {
    // Arrange
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer = new TbTypedJsonRedisSerializer<>(
        mock(TypeReference.class));

    Dashboard dashboard = new Dashboard();
    dashboard.setAssignedCustomers(new HashSet<>());
    dashboard.setConfiguration(MissingNode.getInstance());

    // Act
    byte[] actualSerializeResult = tbTypedJsonRedisSerializer.serialize(new HomeDashboard(dashboard, true));

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
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then return array length is two hundred twenty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTypedJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); given Instance; then return array length is two hundred twenty-six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbTypedJsonRedisSerializer.serialize(Object)"})
  void testSerialize_givenInstance_thenReturnArrayLengthIsTwoHundredTwentySix() throws SerializationException {
    // Arrange
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer = new TbTypedJsonRedisSerializer<>(
        mock(TypeReference.class));

    Dashboard dashboard = new Dashboard();
    dashboard.setConfiguration(MissingNode.getInstance());

    // Act
    byte[] actualSerializeResult = tbTypedJsonRedisSerializer.serialize(new HomeDashboard(dashboard, true));

    // Assert
    assertEquals(226, actualSerializeResult.length);
    assertEquals(',', actualSerializeResult[213]);
    assertEquals(':', actualSerializeResult[208]);
    assertEquals(':', actualSerializeResult[220]);
    assertEquals('"', actualSerializeResult[207]);
    assertEquals('"', actualSerializeResult[214]);
    assertEquals('"', actualSerializeResult[219]);
    assertEquals('a', actualSerializeResult[202]);
    assertEquals('a', actualSerializeResult[216]);
    assertEquals('e', actualSerializeResult[218]);
    assertEquals('i', actualSerializeResult[204]);
    assertEquals('l', actualSerializeResult[211]);
    assertEquals('l', actualSerializeResult[212]);
    assertEquals('l', actualSerializeResult[223]);
    assertEquals('l', actualSerializeResult[224]);
    assertEquals('m', actualSerializeResult[217]);
    assertEquals('n', actualSerializeResult[206]);
    assertEquals('n', actualSerializeResult[209]);
    assertEquals('n', actualSerializeResult[215]);
    assertEquals('n', actualSerializeResult[221]);
    assertEquals('o', actualSerializeResult[205]);
    assertEquals('r', actualSerializeResult[201]);
    assertEquals('t', actualSerializeResult[203]);
    assertEquals('u', actualSerializeResult[210]);
    assertEquals('u', actualSerializeResult[222]);
    assertEquals('}', actualSerializeResult[225]);
  }

  /**
   * Test {@link TbTypedJsonRedisSerializer#serialize(Object)}.
   * <ul>
   *   <li>Then return array length is eighty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTypedJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); then return array length is eighty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbTypedJsonRedisSerializer.serialize(Object)"})
  void testSerialize_thenReturnArrayLengthIsEightyEight() throws SerializationException {
    // Arrange
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer = new TbTypedJsonRedisSerializer<>(
        mock(TypeReference.class));

    // Act
    byte[] actualSerializeResult = tbTypedJsonRedisSerializer
        .serialize(new EntityInfo(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Name"));

    // Assert
    assertEquals(88, actualSerializeResult.length);
    assertEquals(',', actualSerializeResult[73]);
    assertEquals('2', actualSerializeResult[65]);
    assertEquals('4', actualSerializeResult[68]);
    assertEquals('7', actualSerializeResult[66]);
    assertEquals('8', actualSerializeResult[67]);
    assertEquals('9', actualSerializeResult[70]);
    assertEquals(':', actualSerializeResult[19]);
    assertEquals(':', actualSerializeResult[80]);
    assertEquals('D', actualSerializeResult[21]);
    assertEquals('E', actualSerializeResult[22]);
    assertEquals('I', actualSerializeResult[24]);
    assertEquals('N', actualSerializeResult[82]);
    assertEquals('T', actualSerializeResult[14]);
    assertEquals('V', actualSerializeResult[23]);
    assertEquals('"', actualSerializeResult[18]);
    assertEquals('"', actualSerializeResult[20]);
    assertEquals('"', actualSerializeResult[7]);
    assertEquals('"', actualSerializeResult[71]);
    assertEquals('"', actualSerializeResult[74]);
    assertEquals('"', actualSerializeResult[79]);
    assertEquals('"', actualSerializeResult[81]);
    assertEquals('"', actualSerializeResult[86]);
    assertEquals('a', actualSerializeResult[76]);
    assertEquals('a', actualSerializeResult[83]);
    assertEquals('e', actualSerializeResult[78]);
    assertEquals('e', actualSerializeResult[8]);
    assertEquals('e', actualSerializeResult[85]);
    assertEquals('f', actualSerializeResult[63]);
    assertEquals('f', actualSerializeResult[69]);
    assertEquals('f', actualSerializeResult[Double.SIZE]);
    assertEquals('i', actualSerializeResult[11]);
    assertEquals('m', actualSerializeResult[77]);
    assertEquals('m', actualSerializeResult[84]);
    assertEquals('n', actualSerializeResult[75]);
    assertEquals('n', actualSerializeResult[9]);
    assertEquals('p', actualSerializeResult[Short.SIZE]);
    assertEquals('t', actualSerializeResult[10]);
    assertEquals('t', actualSerializeResult[12]);
    assertEquals('y', actualSerializeResult[13]);
    assertEquals('y', actualSerializeResult[15]);
    assertEquals('{', actualSerializeResult[6]);
    assertEquals('}', actualSerializeResult[72]);
    assertEquals('}', actualSerializeResult[87]);
  }

  /**
   * Test {@link TbTypedJsonRedisSerializer#serialize(Object)}.
   * <ul>
   *   <li>Then return array length is three hundred thirty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTypedJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); then return array length is three hundred thirty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbTypedJsonRedisSerializer.serialize(Object)"})
  void testSerialize_thenReturnArrayLengthIsThreeHundredThirtyFive() throws SerializationException {
    // Arrange
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer = new TbTypedJsonRedisSerializer<>(
        mock(TypeReference.class));

    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(
        new ShortCustomerInfo(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true));

    Dashboard dashboard = new Dashboard();
    dashboard.setAssignedCustomers(assignedCustomers);
    dashboard.setConfiguration(MissingNode.getInstance());

    // Act
    byte[] actualSerializeResult = tbTypedJsonRedisSerializer.serialize(new HomeDashboard(dashboard, true));

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
   * <ul>
   *   <li>Then return {@code {"id":null,"name":"Name"}} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTypedJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); then return '{\"id\":null,\"name\":\"Name\"}' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbTypedJsonRedisSerializer.serialize(Object)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbTypedJsonRedisSerializer.serialize(Object)"})
  void testSerialize_when42_thenReturn42BytesIsUtf8() throws UnsupportedEncodingException, SerializationException {
    // Arrange
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer = new TbTypedJsonRedisSerializer<>(
        mock(TypeReference.class));

    // Act
    byte[] actualSerializeResult = tbTypedJsonRedisSerializer.serialize("42");

    // Assert
    assertArrayEquals("\"42\"".getBytes("UTF-8"), actualSerializeResult);
  }

  /**
   * Test {@link TbTypedJsonRedisSerializer#deserialize(Object, byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTypedJsonRedisSerializer#deserialize(Object, byte[])}
   */
  @Test
  @DisplayName("Test deserialize(Object, byte[]); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbTypedJsonRedisSerializer.deserialize(Object, byte[])"})
  void testDeserialize_whenNull_thenReturnNull() throws SerializationException {
    // Arrange
    TbTypedJsonRedisSerializer<Object, Object> tbTypedJsonRedisSerializer = new TbTypedJsonRedisSerializer<>(
        mock(TypeReference.class));

    // Act and Assert
    assertNull(tbTypedJsonRedisSerializer.deserialize("Key", null));
  }
}
