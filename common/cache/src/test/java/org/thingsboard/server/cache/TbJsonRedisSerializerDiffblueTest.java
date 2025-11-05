package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.serializer.SerializationException;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.device.data.CoapDeviceTransportConfiguration;

class TbJsonRedisSerializerDiffblueTest {
  /**
   * Test {@link TbJsonRedisSerializer#serialize(Object)}.
   *
   * <ul>
   *   <li>Then return array length is one hundred five.
   * </ul>
   *
   * <p>Method under test: {@link TbJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); then return array length is one hundred five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbJsonRedisSerializer.serialize(Object)"})
  void testSerialize_thenReturnArrayLengthIsOneHundredFive() throws SerializationException {
    // Arrange
    Class<Object> clazz = Object.class;
    TbJsonRedisSerializer<Object, Object> tbJsonRedisSerializer =
        new TbJsonRedisSerializer<>(clazz);

    // Act
    byte[] actualSerializeResult =
        tbJsonRedisSerializer.serialize(new CoapDeviceTransportConfiguration());

    // Assert
    assertEquals(105, actualSerializeResult.length);
    assertEquals(',', actualSerializeResult[14]);
    assertEquals(':', actualSerializeResult[7]);
    assertEquals(':', actualSerializeResult[99]);
    assertEquals('A', actualSerializeResult[11]);
    assertEquals('C', actualSerializeResult[9]);
    assertEquals('M', actualSerializeResult[21]);
    assertEquals('O', actualSerializeResult[10]);
    assertEquals('P', actualSerializeResult[12]);
    assertEquals('T', actualSerializeResult[80]);
    assertEquals('W', actualSerializeResult[92]);
    assertEquals('"', actualSerializeResult[13]);
    assertEquals('"', actualSerializeResult[15]);
    assertEquals('"', actualSerializeResult[6]);
    assertEquals('"', actualSerializeResult[8]);
    assertEquals('"', actualSerializeResult[98]);
    assertEquals('a', actualSerializeResult[82]);
    assertEquals('d', actualSerializeResult[23]);
    assertEquals('d', actualSerializeResult[95]);
    assertEquals('e', actualSerializeResult[19]);
    assertEquals('e', actualSerializeResult[24]);
    assertEquals('e', actualSerializeResult[5]);
    assertEquals('i', actualSerializeResult[86]);
    assertEquals('i', actualSerializeResult[89]);
    assertEquals('i', actualSerializeResult[93]);
    assertEquals('l', actualSerializeResult[102]);
    assertEquals('l', actualSerializeResult[103]);
    assertEquals('m', actualSerializeResult[85]);
    assertEquals('n', actualSerializeResult[100]);
    assertEquals('n', actualSerializeResult[83]);
    assertEquals('n', actualSerializeResult[91]);
    assertEquals('n', actualSerializeResult[94]);
    assertEquals('o', actualSerializeResult[17]);
    assertEquals('o', actualSerializeResult[22]);
    assertEquals('o', actualSerializeResult[90]);
    assertEquals('o', actualSerializeResult[96]);
    assertEquals('p', actualSerializeResult[4]);
    assertEquals('p', actualSerializeResult[Short.SIZE]);
    assertEquals('r', actualSerializeResult[20]);
    assertEquals('r', actualSerializeResult[81]);
    assertEquals('s', actualSerializeResult[84]);
    assertEquals('s', actualSerializeResult[87]);
    assertEquals('s', actualSerializeResult[88]);
    assertEquals('t', actualSerializeResult[2]);
    assertEquals('u', actualSerializeResult[101]);
    assertEquals('w', actualSerializeResult[18]);
    assertEquals('w', actualSerializeResult[97]);
    assertEquals('y', actualSerializeResult[3]);
    assertEquals('}', actualSerializeResult[104]);
  }

  /**
   * Test {@link TbJsonRedisSerializer#serialize(Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code "42"} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TbJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when '42'; then return '\"42\"' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbJsonRedisSerializer.serialize(Object)"})
  void testSerialize_when42_thenReturn42BytesIsUtf8()
      throws UnsupportedEncodingException, SerializationException {
    // Arrange
    Class<Object> clazz = Object.class;
    TbJsonRedisSerializer<Object, Object> tbJsonRedisSerializer =
        new TbJsonRedisSerializer<>(clazz);

    // Act and Assert
    assertArrayEquals("\"42\"".getBytes("UTF-8"), tbJsonRedisSerializer.serialize("42"));
  }

  /**
   * Test {@link TbJsonRedisSerializer#serialize(Object)}.
   *
   * <ul>
   *   <li>When {@link AdminSettings#AdminSettings()}.
   *   <li>Then return array length is seventy-one.
   * </ul>
   *
   * <p>Method under test: {@link TbJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName(
      "Test serialize(Object); when AdminSettings(); then return array length is seventy-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbJsonRedisSerializer.serialize(Object)"})
  void testSerialize_whenAdminSettings_thenReturnArrayLengthIsSeventyOne()
      throws SerializationException {
    // Arrange
    Class<Object> clazz = Object.class;
    TbJsonRedisSerializer<Object, Object> tbJsonRedisSerializer =
        new TbJsonRedisSerializer<>(clazz);

    // Act
    byte[] actualSerializeResult = tbJsonRedisSerializer.serialize(new AdminSettings());

    // Assert
    assertEquals(71, actualSerializeResult.length);
    assertEquals(',', actualSerializeResult[53]);
    assertEquals(':', actualSerializeResult[48]);
    assertEquals(':', actualSerializeResult[65]);
    assertEquals('V', actualSerializeResult[59]);
    assertEquals('"', actualSerializeResult[47]);
    assertEquals('"', actualSerializeResult[54]);
    assertEquals('"', actualSerializeResult[Double.SIZE]);
    assertEquals('a', actualSerializeResult[60]);
    assertEquals('e', actualSerializeResult[63]);
    assertEquals('j', actualSerializeResult[55]);
    assertEquals('l', actualSerializeResult[51]);
    assertEquals('l', actualSerializeResult[52]);
    assertEquals('l', actualSerializeResult[61]);
    assertEquals('l', actualSerializeResult[68]);
    assertEquals('l', actualSerializeResult[69]);
    assertEquals('n', actualSerializeResult[49]);
    assertEquals('n', actualSerializeResult[58]);
    assertEquals('n', actualSerializeResult[66]);
    assertEquals('o', actualSerializeResult[57]);
    assertEquals('s', actualSerializeResult[56]);
    assertEquals('u', actualSerializeResult[50]);
    assertEquals('u', actualSerializeResult[62]);
    assertEquals('u', actualSerializeResult[67]);
    assertEquals('y', actualSerializeResult[46]);
    assertEquals('}', actualSerializeResult[70]);
  }

  /**
   * Test {@link TbJsonRedisSerializer#serialize(Object)}.
   *
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.
   *   <li>Then return array length is one hundred ninety-eight.
   * </ul>
   *
   * <p>Method under test: {@link TbJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName(
      "Test serialize(Object); when Dashboard(); then return array length is one hundred ninety-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbJsonRedisSerializer.serialize(Object)"})
  void testSerialize_whenDashboard_thenReturnArrayLengthIsOneHundredNinetyEight()
      throws SerializationException {
    // Arrange
    Class<Object> clazz = Object.class;
    TbJsonRedisSerializer<Object, Object> tbJsonRedisSerializer =
        new TbJsonRedisSerializer<>(clazz);

    // Act
    byte[] actualSerializeResult = tbJsonRedisSerializer.serialize(new Dashboard());

    // Assert
    assertEquals(198, actualSerializeResult.length);
    assertEquals(',', actualSerializeResult[185]);
    assertEquals(':', actualSerializeResult[180]);
    assertEquals(':', actualSerializeResult[192]);
    assertEquals('"', actualSerializeResult[179]);
    assertEquals('"', actualSerializeResult[186]);
    assertEquals('"', actualSerializeResult[191]);
    assertEquals('a', actualSerializeResult[174]);
    assertEquals('a', actualSerializeResult[188]);
    assertEquals('e', actualSerializeResult[190]);
    assertEquals('i', actualSerializeResult[176]);
    assertEquals('l', actualSerializeResult[183]);
    assertEquals('l', actualSerializeResult[184]);
    assertEquals('l', actualSerializeResult[195]);
    assertEquals('l', actualSerializeResult[196]);
    assertEquals('m', actualSerializeResult[189]);
    assertEquals('n', actualSerializeResult[178]);
    assertEquals('n', actualSerializeResult[181]);
    assertEquals('n', actualSerializeResult[187]);
    assertEquals('n', actualSerializeResult[193]);
    assertEquals('o', actualSerializeResult[177]);
    assertEquals('r', actualSerializeResult[173]);
    assertEquals('t', actualSerializeResult[175]);
    assertEquals('u', actualSerializeResult[182]);
    assertEquals('u', actualSerializeResult[194]);
    assertEquals('}', actualSerializeResult[197]);
  }

  /**
   * Test {@link TbJsonRedisSerializer#serialize(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TbJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when 'null'; then return 'null' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbJsonRedisSerializer.serialize(Object)"})
  void testSerialize_whenNull_thenReturnNullBytesIsUtf8()
      throws UnsupportedEncodingException, SerializationException {
    // Arrange
    Class<Object> clazz = Object.class;
    TbJsonRedisSerializer<Object, Object> tbJsonRedisSerializer =
        new TbJsonRedisSerializer<>(clazz);

    // Act and Assert
    assertArrayEquals("null".getBytes("UTF-8"), tbJsonRedisSerializer.serialize(null));
  }

  /**
   * Test {@link TbJsonRedisSerializer#serialize(Object)}.
   *
   * <ul>
   *   <li>When {@link TenantProfile#TenantProfile()}.
   *   <li>Then return array length is {@code 2023}.
   * </ul>
   *
   * <p>Method under test: {@link TbJsonRedisSerializer#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when TenantProfile(); then return array length is '2023'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbJsonRedisSerializer.serialize(Object)"})
  void testSerialize_whenTenantProfile_thenReturnArrayLengthIs2023() throws SerializationException {
    // Arrange
    Class<Object> clazz = Object.class;
    TbJsonRedisSerializer<Object, Object> tbJsonRedisSerializer =
        new TbJsonRedisSerializer<>(clazz);

    // Act
    byte[] actualSerializeResult = tbJsonRedisSerializer.serialize(new TenantProfile());

    // Assert
    assertEquals(2023, actualSerializeResult.length);
    assertEquals(',', actualSerializeResult[2006]);
    assertEquals(':', actualSerializeResult[2000]);
    assertEquals(':', actualSerializeResult[2016]);
    assertEquals('"', actualSerializeResult[1999]);
    assertEquals('"', actualSerializeResult[2007]);
    assertEquals('"', actualSerializeResult[2015]);
    assertEquals('a', actualSerializeResult[2011]);
    assertEquals('a', actualSerializeResult[2018]);
    assertEquals('d', actualSerializeResult[2008]);
    assertEquals('e', actualSerializeResult[2009]);
    assertEquals('e', actualSerializeResult[2021]);
    assertEquals('f', actualSerializeResult[2010]);
    assertEquals('f', actualSerializeResult[2017]);
    assertEquals('l', actualSerializeResult[2003]);
    assertEquals('l', actualSerializeResult[2004]);
    assertEquals('l', actualSerializeResult[2013]);
    assertEquals('l', actualSerializeResult[2019]);
    assertEquals('n', actualSerializeResult[1998]);
    assertEquals('n', actualSerializeResult[2001]);
    assertEquals('s', actualSerializeResult[2020]);
    assertEquals('t', actualSerializeResult[2014]);
    assertEquals('u', actualSerializeResult[2002]);
    assertEquals('u', actualSerializeResult[2012]);
    assertEquals('}', actualSerializeResult[2005]);
    assertEquals('}', actualSerializeResult[2022]);
  }
}
