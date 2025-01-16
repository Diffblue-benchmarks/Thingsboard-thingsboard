package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TbSubscriptionsInfo.class})
@ExtendWith(SpringExtension.class)
class TbSubscriptionsInfoDiffblueTest {
  @Autowired
  private TbSubscriptionsInfo tbSubscriptionsInfo;

  /**
   * Test {@link TbSubscriptionsInfo#isEmpty()}.
   * <p>
   * Method under test: {@link TbSubscriptionsInfo#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue(tbSubscriptionsInfo.isEmpty());
  }

  /**
   * Test {@link TbSubscriptionsInfo#copy()}.
   * <p>
   * Method under test: {@link TbSubscriptionsInfo#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  void testCopy() {
    // Arrange, Act and Assert
    assertEquals(tbSubscriptionsInfo, tbSubscriptionsInfo.copy());
  }

  /**
   * Test {@link TbSubscriptionsInfo#copy(int)} with {@code int}.
   * <p>
   * Method under test: {@link TbSubscriptionsInfo#copy(int)}
   */
  @Test
  @DisplayName("Test copy(int) with 'int'")
  void testCopyWithInt() {
    // Arrange, Act and Assert
    assertEquals(tbSubscriptionsInfo, tbSubscriptionsInfo.copy(10));
  }

  /**
   * Test {@link TbSubscriptionsInfo#equals(Object)}, and
   * {@link TbSubscriptionsInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSubscriptionsInfo#equals(Object)}
   *   <li>{@link TbSubscriptionsInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSubscriptionsInfo tbSubscriptionsInfo = new TbSubscriptionsInfo();
    TbSubscriptionsInfo tbSubscriptionsInfo2 = new TbSubscriptionsInfo();

    // Act and Assert
    assertEquals(tbSubscriptionsInfo, tbSubscriptionsInfo2);
    int expectedHashCodeResult = tbSubscriptionsInfo.hashCode();
    assertEquals(expectedHashCodeResult, tbSubscriptionsInfo2.hashCode());
  }

  /**
   * Test {@link TbSubscriptionsInfo#equals(Object)}, and
   * {@link TbSubscriptionsInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSubscriptionsInfo#equals(Object)}
   *   <li>{@link TbSubscriptionsInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    HashSet<String> tsKeys = new HashSet<>();
    TbSubscriptionsInfo tbSubscriptionsInfo = new TbSubscriptionsInfo(true, true, true, tsKeys, true, new HashSet<>(),
        10);
    HashSet<String> tsKeys2 = new HashSet<>();
    TbSubscriptionsInfo tbSubscriptionsInfo2 = new TbSubscriptionsInfo(true, true, true, tsKeys2, true, new HashSet<>(),
        10);

    // Act and Assert
    assertEquals(tbSubscriptionsInfo, tbSubscriptionsInfo2);
    int expectedHashCodeResult = tbSubscriptionsInfo.hashCode();
    assertEquals(expectedHashCodeResult, tbSubscriptionsInfo2.hashCode());
  }

  /**
   * Test {@link TbSubscriptionsInfo#equals(Object)}, and
   * {@link TbSubscriptionsInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSubscriptionsInfo#equals(Object)}
   *   <li>{@link TbSubscriptionsInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSubscriptionsInfo tbSubscriptionsInfo = new TbSubscriptionsInfo();

    // Act and Assert
    assertEquals(tbSubscriptionsInfo, tbSubscriptionsInfo);
    int expectedHashCodeResult = tbSubscriptionsInfo.hashCode();
    assertEquals(expectedHashCodeResult, tbSubscriptionsInfo.hashCode());
  }

  /**
   * Test {@link TbSubscriptionsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscriptionsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<String> tsKeys = new HashSet<>();
    TbSubscriptionsInfo tbSubscriptionsInfo = new TbSubscriptionsInfo(true, true, true, tsKeys, true, new HashSet<>(),
        10);

    // Act and Assert
    assertNotEquals(tbSubscriptionsInfo, new TbSubscriptionsInfo());
  }

  /**
   * Test {@link TbSubscriptionsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscriptionsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<String> tsKeys = new HashSet<>();
    TbSubscriptionsInfo tbSubscriptionsInfo = new TbSubscriptionsInfo(false, true, true, tsKeys, true, new HashSet<>(),
        10);

    // Act and Assert
    assertNotEquals(tbSubscriptionsInfo, new TbSubscriptionsInfo());
  }

  /**
   * Test {@link TbSubscriptionsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscriptionsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<String> tsKeys = new HashSet<>();
    TbSubscriptionsInfo tbSubscriptionsInfo = new TbSubscriptionsInfo(false, false, true, tsKeys, true, new HashSet<>(),
        10);

    // Act and Assert
    assertNotEquals(tbSubscriptionsInfo, new TbSubscriptionsInfo());
  }

  /**
   * Test {@link TbSubscriptionsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscriptionsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashSet<String> tsKeys = new HashSet<>();
    tsKeys.add("");
    TbSubscriptionsInfo tbSubscriptionsInfo = new TbSubscriptionsInfo(true, true, true, tsKeys, true, new HashSet<>(),
        10);
    HashSet<String> tsKeys2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(tbSubscriptionsInfo, new TbSubscriptionsInfo(true, true, true, tsKeys2, true, new HashSet<>(), 10));
  }

  /**
   * Test {@link TbSubscriptionsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscriptionsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashSet<String> tsKeys = new HashSet<>();
    TbSubscriptionsInfo tbSubscriptionsInfo = new TbSubscriptionsInfo(true, true, true, tsKeys, false, new HashSet<>(),
        10);
    HashSet<String> tsKeys2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(tbSubscriptionsInfo, new TbSubscriptionsInfo(true, true, true, tsKeys2, true, new HashSet<>(), 10));
  }

  /**
   * Test {@link TbSubscriptionsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscriptionsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    HashSet<String> attrKeys = new HashSet<>();
    attrKeys.add("");
    TbSubscriptionsInfo tbSubscriptionsInfo = new TbSubscriptionsInfo(true, true, true, new HashSet<>(), true, attrKeys,
        10);
    HashSet<String> tsKeys = new HashSet<>();

    // Act and Assert
    assertNotEquals(tbSubscriptionsInfo, new TbSubscriptionsInfo(true, true, true, tsKeys, true, new HashSet<>(), 10));
  }

  /**
   * Test {@link TbSubscriptionsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscriptionsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSubscriptionsInfo(), null);
  }

  /**
   * Test {@link TbSubscriptionsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscriptionsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSubscriptionsInfo(), "Different type to TbSubscriptionsInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSubscriptionsInfo#TbSubscriptionsInfo()}
   *   <li>{@link TbSubscriptionsInfo#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "TbSubscriptionsInfo(notifications=false, alarms=false, tsAllKeys=false, tsKeys=null, attrAllKeys=false,"
            + " attrKeys=null, seqNumber=0)",
        (new TbSubscriptionsInfo()).toString());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@link TbSubscriptionsInfo#attrKeys} Empty.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbSubscriptionsInfo#TbSubscriptionsInfo(boolean, boolean, boolean, Set, boolean, Set, int)}
   *   <li>{@link TbSubscriptionsInfo#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'; then return attrKeys Empty")
  void testGettersAndSetters_whenTrue_thenReturnAttrKeysEmpty() {
    // Arrange
    HashSet<String> tsKeys = new HashSet<>();

    // Act
    TbSubscriptionsInfo actualTbSubscriptionsInfo = new TbSubscriptionsInfo(true, true, true, tsKeys, true,
        new HashSet<>(), 10);

    // Assert
    assertEquals("TbSubscriptionsInfo(notifications=true, alarms=true, tsAllKeys=true, tsKeys=[], attrAllKeys=true,"
        + " attrKeys=[], seqNumber=10)", actualTbSubscriptionsInfo.toString());
    assertTrue(actualTbSubscriptionsInfo.attrKeys.isEmpty());
    assertTrue(actualTbSubscriptionsInfo.tsKeys.isEmpty());
  }
}
