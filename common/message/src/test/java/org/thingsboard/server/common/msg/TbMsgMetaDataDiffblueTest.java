package org.thingsboard.server.common.msg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbMsgMetaDataDiffblueTest {
  /**
   * Test {@link TbMsgMetaData#equals(Object)}, and
   * {@link TbMsgMetaData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgMetaData#equals(Object)}
   *   <li>{@link TbMsgMetaData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = TbMsgMetaData.EMPTY;
    TbMsgMetaData tbMsgMetaData2 = TbMsgMetaData.EMPTY;

    // Act and Assert
    assertEquals(tbMsgMetaData, tbMsgMetaData2);
    int expectedHashCodeResult = tbMsgMetaData.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgMetaData2.hashCode());
  }

  /**
   * Test {@link TbMsgMetaData#equals(Object)}, and
   * {@link TbMsgMetaData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgMetaData#equals(Object)}
   *   <li>{@link TbMsgMetaData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    TbMsgMetaData tbMsgMetaData2 = TbMsgMetaData.EMPTY;

    // Act and Assert
    assertEquals(tbMsgMetaData, tbMsgMetaData2);
    int expectedHashCodeResult = tbMsgMetaData.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgMetaData2.hashCode());
  }

  /**
   * Test {@link TbMsgMetaData#equals(Object)}, and
   * {@link TbMsgMetaData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgMetaData#equals(Object)}
   *   <li>{@link TbMsgMetaData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = TbMsgMetaData.EMPTY;

    // Act and Assert
    assertEquals(tbMsgMetaData, tbMsgMetaData);
    int expectedHashCodeResult = tbMsgMetaData.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgMetaData.hashCode());
  }

  /**
   * Test {@link TbMsgMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgMetaData.EMPTY, 1);
  }

  /**
   * Test {@link TbMsgMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Key", "42");

    // Act and Assert
    assertNotEquals(tbMsgMetaData, TbMsgMetaData.EMPTY);
  }

  /**
   * Test {@link TbMsgMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgMetaData.EMPTY, null);
  }

  /**
   * Test {@link TbMsgMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgMetaData.EMPTY, "Different type to TbMsgMetaData");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgMetaData#TbMsgMetaData()}
   *   <li>{@link TbMsgMetaData#toString()}
   *   <li>{@link TbMsgMetaData#getData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgMetaData actualTbMsgMetaData = new TbMsgMetaData();
    String actualToStringResult = actualTbMsgMetaData.toString();

    // Assert
    assertEquals("TbMsgMetaData(data={})", actualToStringResult);
    assertTrue(actualTbMsgMetaData.getData().isEmpty());
  }

  /**
   * Test {@link TbMsgMetaData#TbMsgMetaData(Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.</li>
   *   <li>Then return Data is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#TbMsgMetaData(Map)}
   */
  @Test
  @DisplayName("Test new TbMsgMetaData(Map); given '42'; when HashMap() '42' is '42'; then return Data is HashMap()")
  void testNewTbMsgMetaData_given42_whenHashMap42Is42_thenReturnDataIsHashMap() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.put("42", "42");
    data.put("foo", "foo");

    // Act and Assert
    assertEquals(data, (new TbMsgMetaData(data)).getData());
  }

  /**
   * Test {@link TbMsgMetaData#TbMsgMetaData(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#TbMsgMetaData(Map)}
   */
  @Test
  @DisplayName("Test new TbMsgMetaData(Map); given BiFunction; when HashMap() computeIfPresent 'foo' and BiFunction")
  void testNewTbMsgMetaData_givenBiFunction_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.computeIfPresent("foo", mock(BiFunction.class));
    data.put("foo", "foo");

    // Act and Assert
    Map<String, String> data2 = (new TbMsgMetaData(data)).getData();
    assertEquals(1, data2.size());
    assertEquals("foo", data2.get("foo"));
  }

  /**
   * Test {@link TbMsgMetaData#TbMsgMetaData(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#TbMsgMetaData(Map)}
   */
  @Test
  @DisplayName("Test new TbMsgMetaData(Map); given 'foo'; when HashMap() 'foo' is 'foo'; then return Data size is one")
  void testNewTbMsgMetaData_givenFoo_whenHashMapFooIsFoo_thenReturnDataSizeIsOne() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.put("foo", "foo");

    // Act and Assert
    Map<String, String> data2 = (new TbMsgMetaData(data)).getData();
    assertEquals(1, data2.size());
    assertEquals("foo", data2.get("foo"));
  }

  /**
   * Test {@link TbMsgMetaData#TbMsgMetaData(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code null}.</li>
   *   <li>Then return Data Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#TbMsgMetaData(Map)}
   */
  @Test
  @DisplayName("Test new TbMsgMetaData(Map); given 'null'; when HashMap() 'foo' is 'null'; then return Data Empty")
  void testNewTbMsgMetaData_givenNull_whenHashMapFooIsNull_thenReturnDataEmpty() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.put("foo", null);

    // Act and Assert
    assertTrue((new TbMsgMetaData(data)).getData().isEmpty());
  }

  /**
   * Test {@link TbMsgMetaData#TbMsgMetaData(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code null} is {@code foo}.</li>
   *   <li>Then return Data Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#TbMsgMetaData(Map)}
   */
  @Test
  @DisplayName("Test new TbMsgMetaData(Map); given 'null'; when HashMap() 'null' is 'foo'; then return Data Empty")
  void testNewTbMsgMetaData_givenNull_whenHashMapNullIsFoo_thenReturnDataEmpty() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.put(null, "foo");

    // Act and Assert
    assertTrue((new TbMsgMetaData(data)).getData().isEmpty());
  }

  /**
   * Test {@link TbMsgMetaData#TbMsgMetaData(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Data Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#TbMsgMetaData(Map)}
   */
  @Test
  @DisplayName("Test new TbMsgMetaData(Map); when HashMap(); then return Data Empty")
  void testNewTbMsgMetaData_whenHashMap_thenReturnDataEmpty() {
    // Arrange, Act and Assert
    assertTrue((new TbMsgMetaData(new HashMap<>())).getData().isEmpty());
  }

  /**
   * Test {@link TbMsgMetaData#getValue(String)}.
   * <ul>
   *   <li>Given {@link TbMsgMetaData#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#getValue(String)}
   */
  @Test
  @DisplayName("Test getValue(String); given EMPTY")
  void testGetValue_givenEmpty() {
    // Arrange, Act and Assert
    assertNull(TbMsgMetaData.EMPTY.getValue("Key"));
  }

  /**
   * Test {@link TbMsgMetaData#getValue(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#getValue(String)}
   */
  @Test
  @DisplayName("Test getValue(String); given HashMap() computeIfPresent 'foo' and BiFunction")
  void testGetValue_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull((new TbMsgMetaData(data)).getValue("Key"));
  }

  /**
   * Test {@link TbMsgMetaData#putValue(String, String)}.
   * <ul>
   *   <li>Given {@link TbMsgMetaData#EMPTY}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link TbMsgMetaData#EMPTY} Data Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#putValue(String, String)}
   */
  @Test
  @DisplayName("Test putValue(String, String); given EMPTY; when 'null'; then EMPTY Data Empty")
  void testPutValue_givenEmpty_whenNull_thenEmptyDataEmpty() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = TbMsgMetaData.EMPTY;

    // Act
    tbMsgMetaData.putValue(null, null);

    // Assert that nothing has changed
    assertTrue(tbMsgMetaData.getData().isEmpty());
  }

  /**
   * Test {@link TbMsgMetaData#putValue(String, String)}.
   * <ul>
   *   <li>Given {@link TbMsgMetaData#EMPTY}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link TbMsgMetaData#EMPTY} Data Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#putValue(String, String)}
   */
  @Test
  @DisplayName("Test putValue(String, String); given EMPTY; when 'null'; then EMPTY Data Empty")
  void testPutValue_givenEmpty_whenNull_thenEmptyDataEmpty2() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = TbMsgMetaData.EMPTY;

    // Act
    tbMsgMetaData.putValue("Key", null);

    // Assert that nothing has changed
    assertTrue(tbMsgMetaData.getData().isEmpty());
  }

  /**
   * Test {@link TbMsgMetaData#putValue(String, String)}.
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link TbMsgMetaData#TbMsgMetaData()} Data size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#putValue(String, String)}
   */
  @Test
  @DisplayName("Test putValue(String, String); given TbMsgMetaData(); when '42'; then TbMsgMetaData() Data size is one")
  void testPutValue_givenTbMsgMetaData_when42_thenTbMsgMetaDataDataSizeIsOne() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();

    // Act
    tbMsgMetaData.putValue("Key", "42");

    // Assert
    Map<String, String> data = tbMsgMetaData.getData();
    assertEquals(1, data.size());
    assertEquals("42", data.get("Key"));
  }

  /**
   * Test {@link TbMsgMetaData#putValue(String, String)}.
   * <ul>
   *   <li>Then {@link TbMsgMetaData#TbMsgMetaData(Map)} with data is
   * {@link HashMap#HashMap()} Data size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#putValue(String, String)}
   */
  @Test
  @DisplayName("Test putValue(String, String); then TbMsgMetaData(Map) with data is HashMap() Data size is one")
  void testPutValue_thenTbMsgMetaDataWithDataIsHashMapDataSizeIsOne() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.computeIfPresent("foo", mock(BiFunction.class));
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData(data);

    // Act
    tbMsgMetaData.putValue("Key", "42");

    // Assert
    Map<String, String> data2 = tbMsgMetaData.getData();
    assertEquals(1, data2.size());
    assertEquals("42", data2.get("Key"));
  }

  /**
   * Test {@link TbMsgMetaData#values()}.
   * <ul>
   *   <li>Given {@link TbMsgMetaData#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#values()}
   */
  @Test
  @DisplayName("Test values(); given EMPTY")
  void testValues_givenEmpty() {
    // Arrange, Act and Assert
    assertTrue(TbMsgMetaData.EMPTY.values().isEmpty());
  }

  /**
   * Test {@link TbMsgMetaData#values()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#values()}
   */
  @Test
  @DisplayName("Test values(); given HashMap() computeIfPresent 'foo' and BiFunction")
  void testValues_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertTrue((new TbMsgMetaData(data)).values().isEmpty());
  }

  /**
   * Test {@link TbMsgMetaData#copy()}.
   * <ul>
   *   <li>Given {@link TbMsgMetaData#EMPTY}.</li>
   *   <li>Then return {@link TbMsgMetaData#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#copy()}
   */
  @Test
  @DisplayName("Test copy(); given EMPTY; then return EMPTY")
  void testCopy_givenEmpty_thenReturnEmpty() {
    // Arrange and Act
    TbMsgMetaData actualCopyResult = TbMsgMetaData.EMPTY.copy();

    // Assert
    assertEquals(actualCopyResult.EMPTY, actualCopyResult);
  }

  /**
   * Test {@link TbMsgMetaData#copy()}.
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value {@code 42} is
   * {@code Value}.</li>
   *   <li>Then return {@link TbMsgMetaData#TbMsgMetaData()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#copy()}
   */
  @Test
  @DisplayName("Test copy(); given TbMsgMetaData() Value '42' is 'Value'; then return TbMsgMetaData()")
  void testCopy_givenTbMsgMetaDataValue42IsValue_thenReturnTbMsgMetaData() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("42", "Value");
    tbMsgMetaData.putValue("Key", "42");

    // Act and Assert
    assertEquals(tbMsgMetaData, tbMsgMetaData.copy());
  }

  /**
   * Test {@link TbMsgMetaData#copy()}.
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value {@code Key} is
   * {@code 42}.</li>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#copy()}
   */
  @Test
  @DisplayName("Test copy(); given TbMsgMetaData() Value 'Key' is '42'; then return Data size is one")
  void testCopy_givenTbMsgMetaDataValueKeyIs42_thenReturnDataSizeIsOne() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Key", "42");

    // Act and Assert
    Map<String, String> data = tbMsgMetaData.copy().getData();
    assertEquals(1, data.size());
    assertEquals("42", data.get("Key"));
  }

  /**
   * Test {@link TbMsgMetaData#copy()}.
   * <ul>
   *   <li>Then return {@link TbMsgMetaData#TbMsgMetaData(Map)} with data is
   * {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaData#copy()}
   */
  @Test
  @DisplayName("Test copy(); then return TbMsgMetaData(Map) with data is HashMap()")
  void testCopy_thenReturnTbMsgMetaDataWithDataIsHashMap() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.computeIfPresent("foo", mock(BiFunction.class));
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData(data);

    // Act and Assert
    assertEquals(tbMsgMetaData, tbMsgMetaData.copy());
  }
}
